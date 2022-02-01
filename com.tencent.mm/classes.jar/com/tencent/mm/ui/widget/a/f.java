package com.tencent.mm.ui.widget.a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.r;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.o;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ck.a.c;
import com.tencent.mm.ck.a.d;
import com.tencent.mm.ck.a.e;
import com.tencent.mm.ck.a.f;
import com.tencent.mm.ck.a.g;
import com.tencent.mm.ck.a.j;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.ui.base.CustomScrollView;
import com.tencent.mm.ui.base.CustomScrollView.a;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.base.u.a;
import com.tencent.mm.ui.base.u.b;
import com.tencent.mm.ui.base.u.c;
import com.tencent.mm.ui.base.u.d;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.h;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.base.u.k;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Iterator;
import java.util.List;

public class f
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  public u.i GAC;
  public u.g GAx;
  public u.g GAz;
  public boolean GwR;
  public boolean GwS;
  private LinearLayout GwU;
  private View GwV;
  private TextView GwW;
  public boolean Nfh;
  public boolean NyV;
  public LinearLayout VtC;
  private LinearLayout VtD;
  public boolean VtK;
  public u.g Vtg;
  private u.i Vth;
  public u.b Vti;
  public u.d Vtj;
  public s Vtk;
  private s Vtl;
  private boolean Vtn;
  public boolean Vto;
  public f.b aeLi;
  private boolean aeLj;
  private s ageA;
  private s ageB;
  private Boolean ageC;
  private LinearLayout ageD;
  private CustomScrollView ageE;
  private View ageF;
  private TextView ageG;
  public g ageH;
  private g ageI;
  private g ageJ;
  public boolean ageK;
  private boolean ageL;
  private boolean ageM;
  public ViewStub ageN;
  public ViewGroup ageO;
  public TextView ageP;
  public RecyclerView ageQ;
  private RecyclerView ageR;
  public ImageView ageS;
  private ImageView ageT;
  private ImageView ageU;
  private ImageView ageV;
  private int ageW;
  private int ageX;
  private int ageY;
  public boolean ageZ;
  public f.c agei;
  public d agej;
  private u.g agek;
  public u.g agel;
  public u.i agem;
  public u.i agen;
  public u.h ageo;
  private u.i agep;
  public u.i ageq;
  public f ager;
  public a ages;
  public u.b aget;
  public u.b ageu;
  public u.a agev;
  private u.d agew;
  public u.c agex;
  private s agey;
  public s agez;
  private int agfa;
  public boolean agfb;
  public RecyclerView.r agfc;
  private RecyclerView.r agfd;
  private boolean agfe;
  private boolean agff;
  public boolean agfg;
  private String agfh;
  private u.b agfi;
  private u.a agfj;
  private u.k agfk;
  private boolean agfl;
  public int bottomSheetStyle;
  public TextView lzN;
  public Context mContext;
  private View mF;
  private ViewTreeObserver mP;
  public RecyclerView mRecyclerView;
  public int pym;
  public View rootView;
  private boolean sRA;
  public int sRB;
  private Dialog sRs;
  private int sRu;
  private BottomSheetBehavior sRv;
  private boolean sRw;
  private int sRx;
  public boolean sRy;
  public boolean sRz;
  
  public f(Context paramContext, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(159351);
    this.ageC = Boolean.FALSE;
    this.ageK = false;
    this.Vtn = false;
    this.ageL = false;
    this.ageM = false;
    this.sRw = false;
    this.ageW = 4;
    this.ageX = (this.ageW * 3);
    this.ageY = 6;
    this.NyV = false;
    this.GwS = false;
    this.aeLj = false;
    this.sRz = false;
    this.Vto = false;
    this.ageZ = false;
    this.pym = 0;
    this.sRA = false;
    this.agfa = 0;
    this.sRB = 0;
    this.agfb = false;
    this.VtK = false;
    this.agfc = null;
    this.agfd = null;
    this.agfe = false;
    this.agff = false;
    this.agfg = true;
    this.agfh = null;
    this.agfi = null;
    this.agfj = null;
    this.agfk = null;
    this.agfl = false;
    this.bottomSheetStyle = paramInt;
    this.mContext = paramContext;
    this.Nfh = paramBoolean;
    this.ageZ = false;
    if ((this.mContext instanceof Activity)) {
      this.mF = ((ViewGroup)((Activity)this.mContext).getWindow().getDecorView()).findViewById(16908290);
    }
    ci(this.mContext);
    AppMethodBeat.o(159351);
  }
  
  public f(Context paramContext, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(251811);
    this.ageC = Boolean.FALSE;
    this.ageK = false;
    this.Vtn = false;
    this.ageL = false;
    this.ageM = false;
    this.sRw = false;
    this.ageW = 4;
    this.ageX = (this.ageW * 3);
    this.ageY = 6;
    this.NyV = false;
    this.GwS = false;
    this.aeLj = false;
    this.sRz = false;
    this.Vto = false;
    this.ageZ = false;
    this.pym = 0;
    this.sRA = false;
    this.agfa = 0;
    this.sRB = 0;
    this.agfb = false;
    this.VtK = false;
    this.agfc = null;
    this.agfd = null;
    this.agfe = false;
    this.agff = false;
    this.agfg = true;
    this.agfh = null;
    this.agfi = null;
    this.agfj = null;
    this.agfk = null;
    this.agfl = false;
    this.bottomSheetStyle = paramInt;
    this.mContext = paramContext;
    this.sRA = paramBoolean;
    if ((this.mContext instanceof Activity)) {
      this.mF = ((ViewGroup)((Activity)this.mContext).getWindow().getDecorView()).findViewById(16908290);
    }
    ci(this.mContext);
    AppMethodBeat.o(251811);
  }
  
  private o L(final RecyclerView paramRecyclerView)
  {
    AppMethodBeat.i(251836);
    paramRecyclerView = new o(paramRecyclerView.getContext())
    {
      public final int JB()
      {
        return -1;
      }
      
      public final float c(DisplayMetrics paramAnonymousDisplayMetrics)
      {
        return 1.0F / paramAnonymousDisplayMetrics.densityDpi;
      }
      
      public final PointF fM(int paramAnonymousInt)
      {
        AppMethodBeat.i(251787);
        if ((paramRecyclerView != null) && (paramRecyclerView.getLayoutManager() != null) && ((paramRecyclerView.getLayoutManager() instanceof LinearLayoutManager)))
        {
          localPointF = ((LinearLayoutManager)f.z(f.this).getLayoutManager()).fM(paramAnonymousInt);
          AppMethodBeat.o(251787);
          return localPointF;
        }
        PointF localPointF = super.fM(paramAnonymousInt);
        AppMethodBeat.o(251787);
        return localPointF;
      }
    };
    AppMethodBeat.o(251836);
    return paramRecyclerView;
  }
  
  private void a(u.k paramk)
  {
    AppMethodBeat.i(251843);
    if (this.agfl)
    {
      AppMethodBeat.o(251843);
      return;
    }
    if ((this.mRecyclerView == null) || (paramk == null))
    {
      AppMethodBeat.o(251843);
      return;
    }
    this.mRecyclerView.a(new e((byte)0));
    this.agfl = true;
    AppMethodBeat.o(251843);
  }
  
  private void aEV(int paramInt)
  {
    AppMethodBeat.i(251851);
    if ((this.ageQ != null) && (this.ageO != null))
    {
      this.ageQ.setVisibility(paramInt);
      if (this.ageV != null)
      {
        if (paramInt != 0)
        {
          this.ageO.setVisibility(4);
          this.ageV.setVisibility(4);
          AppMethodBeat.o(251851);
          return;
        }
        this.ageV.setVisibility(0);
        this.ageO.setVisibility(0);
      }
    }
    AppMethodBeat.o(251851);
  }
  
  private void ci(Context paramContext)
  {
    AppMethodBeat.i(159355);
    this.Vtk = new s(paramContext);
    this.Vtl = new s(paramContext);
    this.agey = new s(paramContext);
    this.agez = new s(paramContext);
    this.ageA = new s(paramContext);
    this.ageB = new s(paramContext);
    if (this.sRA)
    {
      this.sRs = new b(paramContext);
      this.rootView = View.inflate(paramContext, a.g.mm_bottom_sheet, null);
      this.VtC = ((LinearLayout)this.rootView.findViewById(a.f.bottom_sheet_title));
      this.VtD = ((LinearLayout)this.rootView.findViewById(a.f.bottom_sheet_footer));
      this.GwU = ((LinearLayout)this.rootView.findViewById(a.f.bottom_sheet_cancel));
      this.GwV = this.rootView.findViewById(a.f.cancel_space);
      this.ageD = ((LinearLayout)this.rootView.findViewById(a.f.bottom_sheet_footer_menu));
      this.GwW = ((TextView)this.rootView.findViewById(a.f.cancel_text));
      this.ageG = ((TextView)this.rootView.findViewById(a.f.cancel_text_grid_style));
      this.ageE = ((CustomScrollView)this.rootView.findViewById(a.f.content_scroll));
      this.ageF = this.rootView.findViewById(a.f.gradient_mask);
      this.ageS = ((ImageView)this.rootView.findViewById(a.f.deviderline));
      this.ageT = ((ImageView)this.rootView.findViewById(a.f.menu_line));
      this.ageU = ((ImageView)this.rootView.findViewById(a.f.menu_line_over_cancel_btn));
      this.GwU.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(159340);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          a.c("com/tencent/mm/ui/widget/dialog/MMBottomSheet$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          f.this.cyW();
          if (f.d(f.this) != null) {
            f.d(f.this).onClick();
          }
          a.a(this, "com/tencent/mm/ui/widget/dialog/MMBottomSheet$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(159340);
        }
      });
      this.mRecyclerView = ((RecyclerView)this.rootView.findViewById(a.f.bottom_sheet_menu_reccycleview));
      this.mRecyclerView.setHasFixedSize(true);
      if (this.mRecyclerView.getItemAnimator() != null) {
        this.mRecyclerView.getItemAnimator().bZI = 100L;
      }
      this.ageR = ((RecyclerView)this.rootView.findViewById(a.f.bottom_sheet_second_reccycleview));
      this.ageR.setHasFixedSize(true);
      this.ageN = ((ViewStub)this.rootView.findViewById(a.f.bottom_sheet_zero_menu_stub));
      this.agfc = L(this.mRecyclerView);
      this.sRw = isLandscape();
      if (this.bottomSheetStyle != 0) {
        break label899;
      }
      this.ageM = true;
      if (!this.sRw) {
        break label858;
      }
      this.ageW = 7;
      this.ageX = (this.ageW * 2);
      this.sRu = (bd.bs(this.mContext, a.d.BottomSheetGridMaxHeight_Landscape) + bd.bs(this.mContext, a.d.grid_item_top_bottom_padding));
      label492:
      if (this.Nfh) {
        this.sRu += bd.bs(this.mContext, a.d.grid_item_top_bottom_padding);
      }
      this.GwU.setVisibility(0);
      if (this.rootView != null)
      {
        if ((!this.sRA) || (!isLandscape())) {
          break label886;
        }
        this.rootView.setBackgroundColor(this.mContext.getResources().getColor(a.c.BG_1));
      }
      label567:
      this.ageE.setOnScrollChangeListener(new CustomScrollView.a()
      {
        public final void onScrollChange(ScrollView paramAnonymousScrollView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
        {
          AppMethodBeat.i(251862);
          if (paramAnonymousScrollView.getChildAt(0).getMeasuredHeight() - (paramAnonymousScrollView.getHeight() + paramAnonymousScrollView.getScrollY()) < 50)
          {
            f.e(f.this).setVisibility(8);
            AppMethodBeat.o(251862);
            return;
          }
          f.e(f.this).setVisibility(0);
          AppMethodBeat.o(251862);
        }
      });
      label582:
      if ((this.Nfh) && (this.ageS != null) && (this.ageZ)) {
        this.ageS.setVisibility(0);
      }
      if (this.bottomSheetStyle != 0) {
        break label1140;
      }
      paramContext = new LinearLayoutManager();
      paramContext.setOrientation(0);
      this.mRecyclerView.setLayoutManager(paramContext);
      paramContext = new LinearLayoutManager();
      paramContext.setOrientation(0);
      this.ageR.setLayoutManager(paramContext);
    }
    for (;;)
    {
      this.mRecyclerView.setFocusable(false);
      this.mRecyclerView.setItemViewCacheSize(20);
      this.ageH = new g(false);
      this.ageH.GAB = this.Vtk;
      this.ageH.un = new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(159342);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousAdapterView);
          localb.cH(paramAnonymousView);
          localb.sc(paramAnonymousInt);
          localb.hB(paramAnonymousLong);
          a.c("com/tencent/mm/ui/widget/dialog/MMBottomSheet$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
          if (paramAnonymousInt < f.f(f.this).size())
          {
            paramAnonymousAdapterView = (t)f.f(f.this).adRW.get(paramAnonymousInt);
            if ((paramAnonymousAdapterView == null) || (paramAnonymousAdapterView.disable))
            {
              a.a(this, "com/tencent/mm/ui/widget/dialog/MMBottomSheet$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(159342);
              return;
            }
            if (f.g(f.this) != null) {
              f.g(f.this).onMMMenuItemSelected(paramAnonymousAdapterView, paramAnonymousInt);
            }
          }
          for (;;)
          {
            if (!f.l(f.this)) {
              f.this.cyW();
            }
            f.m(f.this);
            f.a(f.this, paramAnonymousInt);
            f.n(f.this).bZE.notifyChanged();
            a.a(this, "com/tencent/mm/ui/widget/dialog/MMBottomSheet$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(159342);
            return;
            paramAnonymousAdapterView.performClick();
            continue;
            if ((f.h(f.this).size() > 0) && (paramAnonymousInt < f.f(f.this).size() + f.h(f.this).size()))
            {
              paramAnonymousAdapterView = (t)f.h(f.this).getItem(paramAnonymousInt - f.f(f.this).size());
              if ((paramAnonymousAdapterView == null) || (paramAnonymousAdapterView.disable))
              {
                a.a(this, "com/tencent/mm/ui/widget/dialog/MMBottomSheet$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(159342);
                return;
              }
              if (f.i(f.this) != null) {
                f.i(f.this).onMMMenuItemSelected(paramAnonymousAdapterView, paramAnonymousInt);
              } else {
                paramAnonymousAdapterView.performClick();
              }
            }
            else
            {
              if (!f.j(f.this))
              {
                a.a(this, "com/tencent/mm/ui/widget/dialog/MMBottomSheet$3", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(159342);
                return;
              }
              f.k(f.this);
            }
          }
        }
      };
      this.mRecyclerView.setAdapter(this.ageH);
      this.mRecyclerView.setOverScrollMode(1);
      this.ageI = new g(true);
      this.ageI.GAB = this.agey;
      this.ageI.un = new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(251784);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousAdapterView);
          localb.cH(paramAnonymousView);
          localb.sc(paramAnonymousInt);
          localb.hB(paramAnonymousLong);
          a.c("com/tencent/mm/ui/widget/dialog/MMBottomSheet$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
          if (paramAnonymousInt >= f.o(f.this).size())
          {
            a.a(this, "com/tencent/mm/ui/widget/dialog/MMBottomSheet$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(251784);
            return;
          }
          paramAnonymousAdapterView = (t)f.o(f.this).adRW.get(paramAnonymousInt);
          if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.disable))
          {
            a.a(this, "com/tencent/mm/ui/widget/dialog/MMBottomSheet$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(251784);
            return;
          }
          if ((paramAnonymousInt < f.o(f.this).size()) && (f.p(f.this) != null)) {
            f.p(f.this).onMMMenuItemSelected(f.o(f.this).getItem(paramAnonymousInt), paramAnonymousInt);
          }
          if (!f.l(f.this)) {
            f.this.cyW();
          }
          f.m(f.this);
          f.q(f.this).bZE.notifyChanged();
          a.a(this, "com/tencent/mm/ui/widget/dialog/MMBottomSheet$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(251784);
        }
      };
      this.ageR.setAdapter(this.ageI);
      this.ageR.setOverScrollMode(1);
      if (this.sRs != null) {
        this.sRs.setContentView(this.rootView);
      }
      if (this.sRs != null) {
        this.sRs.setOnDismissListener(new DialogInterface.OnDismissListener()
        {
          public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(159344);
            if (f.r(f.this) != null)
            {
              if (!f.r(f.this).isAlive()) {
                f.a(f.this, f.s(f.this).getViewTreeObserver());
              }
              f.r(f.this).removeGlobalOnLayoutListener(f.this);
              f.a(f.this, null);
            }
            if (f.t(f.this) != null) {
              c.f(f.t(f.this));
            }
            if (!f.u(f.this)) {
              f.v(f.this);
            }
            AppMethodBeat.o(159344);
          }
        });
      }
      AppMethodBeat.o(159355);
      return;
      this.sRs = new l(paramContext, a.j.CustomSheetStyle);
      break;
      label858:
      this.sRu = (bd.bs(this.mContext, a.d.BottomSheetGridMaxHeight) + bd.bs(this.mContext, a.d.grid_item_top_bottom_padding));
      break label492;
      label886:
      this.rootView.setBackgroundResource(a.e.up_corner_grey_bg);
      break label567;
      label899:
      if (this.bottomSheetStyle == 2)
      {
        this.Vtn = true;
        i = bd.bs(this.mContext, a.d.bottomsheet_list_checkbox_item_height);
        if (this.sRw) {
          this.ageY = 2;
        }
        for (this.sRu = ((int)(i * 2.5D) + bd.bs(this.mContext, a.d.bottomsheet_dividing_line_height));; this.sRu = ((int)(i * 3.5D) + bd.bs(this.mContext, a.d.bottomsheet_dividing_line_height)))
        {
          if (!this.Nfh) {
            break label1013;
          }
          this.sRu += bd.fromDPToPix(this.mContext, 88);
          break;
          this.ageY = 3;
        }
        label1013:
        break label582;
      }
      this.ageL = true;
      int i = bd.bs(this.mContext, a.d.bottomsheet_list_item_height);
      if (this.sRw) {
        this.ageY = 4;
      }
      for (this.sRu = ((int)(i * 4.5D) + bd.bs(this.mContext, a.d.bottomsheet_dividing_line_height));; this.sRu = ((int)(i * 6.5D) + bd.bs(this.mContext, a.d.bottomsheet_dividing_line_height)))
      {
        if (this.Nfh) {
          this.sRu += bd.bs(this.mContext, a.d.grid_item_top_bottom_padding);
        }
        if (this.GwU == null) {
          break;
        }
        this.GwU.setVisibility(0);
        break;
        this.ageY = 6;
      }
      label1140:
      this.mRecyclerView.setLayoutManager(new LinearLayoutManager());
    }
  }
  
  private int getRotation()
  {
    AppMethodBeat.i(159354);
    int i = 0;
    if ((this.mContext instanceof Activity)) {
      i = ((Activity)this.mContext).getWindow().getWindowManager().getDefaultDisplay().getRotation();
    }
    AppMethodBeat.o(159354);
    return i;
  }
  
  private void iAS()
  {
    AppMethodBeat.i(159361);
    if ((Build.VERSION.SDK_INT >= 23) && (this.sRs != null))
    {
      this.sRs.getWindow().getDecorView().setSystemUiVisibility(9216);
      this.sRs.getWindow().setStatusBarColor(0);
    }
    AppMethodBeat.o(159361);
  }
  
  private boolean isLandscape()
  {
    AppMethodBeat.i(159367);
    if (this.mContext.getResources().getConfiguration().orientation == 2)
    {
      AppMethodBeat.o(159367);
      return true;
    }
    AppMethodBeat.o(159367);
    return false;
  }
  
  private void jHL()
  {
    AppMethodBeat.i(159366);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.rootView.getLayoutParams();
    this.Vtk.size();
    if ((!this.ageK) && (this.Vtl.size() > 0)) {
      this.Vtl.size();
    }
    Rect localRect;
    if ((this.sRw) && (this.mF != null))
    {
      localRect = new Rect();
      this.mF.getWindowVisibleDisplayFrame(localRect);
      if (!this.sRA) {
        break label168;
      }
      localLayoutParams.width = ((int)(localRect.right * 1.0F / 2.0F));
      if (this.sRB != 0) {
        localLayoutParams.width = this.sRB;
      }
      if (!bf.nc(this.mContext)) {
        break label157;
      }
      localLayoutParams.height = (localRect.bottom - bf.be(this.mContext));
    }
    for (;;)
    {
      this.rootView.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(159366);
      return;
      label157:
      localLayoutParams.height = localRect.bottom;
      continue;
      label168:
      localLayoutParams.width = Math.min(localRect.right, localRect.bottom);
      if (this.sRB != 0) {
        localLayoutParams.width = this.sRB;
      }
    }
  }
  
  private void w(s params)
  {
    AppMethodBeat.i(251847);
    if (this.agfl)
    {
      AppMethodBeat.o(251847);
      return;
    }
    if ((this.mRecyclerView == null) || (params == null))
    {
      AppMethodBeat.o(251847);
      return;
    }
    params = params.adRW;
    if ((params == null) || (params.isEmpty()))
    {
      AppMethodBeat.o(251847);
      return;
    }
    params = params.iterator();
    MenuItem localMenuItem;
    do
    {
      if (!params.hasNext()) {
        break;
      }
      localMenuItem = (MenuItem)params.next();
    } while ((!(localMenuItem instanceof t)) || (((t)localMenuItem).adSe == null));
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.mRecyclerView.a(new e((byte)0));
        this.agfl = true;
      }
      AppMethodBeat.o(251847);
      return;
    }
  }
  
  public final f NE(boolean paramBoolean)
  {
    AppMethodBeat.i(252091);
    this.VtK = paramBoolean;
    if (this.rootView != null)
    {
      if (!this.VtK) {
        break label286;
      }
      if (this.bottomSheetStyle != 0) {
        break label242;
      }
      this.rootView.setBackgroundResource(a.e.up_corner_grey_dark_bg);
      if (this.GwW != null) {
        this.GwW.setVisibility(8);
      }
      if (this.ageG != null) {
        this.ageG.setVisibility(0);
      }
      this.GwV.setBackgroundColor(this.mContext.getResources().getColor(a.c.Dark_1));
      this.GwW.setTextColor(this.mContext.getResources().getColor(a.c.BW_100_Alpha_0_8));
      this.GwW.setBackgroundResource(a.e.dark_list_item_selector);
      this.ageG.setTextColor(this.mContext.getResources().getColor(a.c.BW_100_Alpha_0_8));
      this.ageG.setBackgroundResource(a.e.dark_list_item_selector);
      if (this.ageT != null) {
        this.ageT.setBackgroundColor(this.mContext.getResources().getColor(a.c.BW_100_Alpha_0_0_5));
      }
      if (this.ageU != null) {
        this.ageU.setBackgroundColor(this.mContext.getResources().getColor(a.c.BW_100_Alpha_0_0_5));
      }
      if (this.ageP != null) {
        this.ageP.setTextColor(this.mContext.getResources().getColor(a.c.BW_100_Alpha_0_8));
      }
    }
    for (;;)
    {
      AppMethodBeat.o(252091);
      return this;
      label242:
      this.rootView.setBackgroundResource(a.e.up_corner_dark_bg);
      if (this.GwW != null) {
        this.GwW.setVisibility(0);
      }
      if (this.ageG == null) {
        break;
      }
      this.ageG.setVisibility(8);
      break;
      label286:
      this.rootView.setBackgroundResource(a.e.up_corner_white_bg);
      if (this.ageP != null) {
        this.ageP.setTextColor(this.mContext.getResources().getColor(a.c.FG_0));
      }
    }
  }
  
  public final void a(s params, u.i parami, u.d paramd)
  {
    AppMethodBeat.i(252109);
    this.agfe = true;
    this.Vtl = params;
    this.Vth = parami;
    this.agew = paramd;
    w(params);
    AppMethodBeat.o(252109);
  }
  
  public final void a(f paramf, String paramString, u.b paramb, u.a parama, u.k paramk)
  {
    AppMethodBeat.i(252100);
    this.ageK = true;
    this.ager = paramf;
    this.agff = true;
    this.agfh = paramString;
    this.agfi = paramb;
    this.agfj = parama;
    this.agfk = paramk;
    a(paramk);
    AppMethodBeat.o(252100);
  }
  
  public final void af(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(159356);
    if (paramView == null)
    {
      AppMethodBeat.o(159356);
      return;
    }
    this.Nfh = true;
    ImageView localImageView;
    if (this.ageS != null)
    {
      localImageView = this.ageS;
      if (!paramBoolean) {
        break label96;
      }
    }
    label96:
    for (int i = 4;; i = 0)
    {
      localImageView.setVisibility(i);
      if (this.VtC != null)
      {
        this.VtC.setVisibility(0);
        this.VtC.removeAllViews();
        this.VtC.setGravity(17);
        this.VtC.addView(paramView, -1, -2);
      }
      AppMethodBeat.o(159356);
      return;
    }
  }
  
  public final void cyW()
  {
    AppMethodBeat.i(159364);
    if (this.sRs != null)
    {
      if (this.sRv != null) {
        this.sRv.dqC = true;
      }
      if ((!(this.mContext instanceof Activity)) || ((this.mContext != null) && (!((Activity)this.mContext).isFinishing()) && (!((Activity)this.mContext).isDestroyed()))) {
        this.sRs.dismiss();
      }
    }
    AppMethodBeat.o(159364);
  }
  
  public final void dDn()
  {
    int j = 0;
    AppMethodBeat.i(159362);
    this.aeLj = false;
    this.sRw = isLandscape();
    this.sRx = getRotation();
    if (this.Vtg != null) {
      this.Vtg.onCreateMMMenu(this.Vtk);
    }
    if (this.GAz != null) {
      this.GAz.onCreateMMMenu(this.agey);
    }
    if (this.GAx != null)
    {
      this.GAx.onCreateMMMenu(this.agez);
      if ((this.agez.size() > 0) && (this.ageO == null)) {
        jHJ();
      }
    }
    if (this.agek != null) {
      this.agek.onCreateMMMenu(this.ageA);
    }
    if (this.agel != null) {
      this.agel.onCreateMMMenu(this.ageB);
    }
    final int i;
    int k;
    if (this.sRs != null)
    {
      jHL();
      if (!this.ageM) {
        break label1543;
      }
      if (this.agey.size() > 0)
      {
        this.ageT.setVisibility(8);
        this.ageU.setVisibility(0);
        this.ageR.setVisibility(0);
        if (this.GwV != null) {
          this.GwV.setVisibility(8);
        }
        if (this.GwW != null) {
          this.GwW.setVisibility(8);
        }
        if (this.ageG != null) {
          this.ageG.setVisibility(0);
        }
      }
      if (this.agez.size() > 0)
      {
        aEV(0);
        if (this.GwV != null) {
          this.GwV.setVisibility(8);
        }
      }
      t localt;
      Object localObject;
      WeImageView localWeImageView;
      TextView localTextView1;
      TextView localTextView2;
      if (this.ageA.size() > 0)
      {
        if (this.VtC != null)
        {
          this.VtC.setVisibility(0);
          this.VtC.removeAllViews();
          this.VtC.setGravity(17);
        }
        localView = View.inflate(this.mContext, a.g.bottomsheet_header_menu_layout, null);
        localLinearLayout = (LinearLayout)localView.findViewById(a.f.menu_layout);
        i = 0;
        while (i < this.ageA.size())
        {
          localt = (t)this.ageA.adRW.get(i);
          if (localt.NfE)
          {
            localObject = View.inflate(this.mContext, a.g.bottomsheet_header_loading_item, null);
            localLinearLayout.addView((View)localObject);
            i += 1;
          }
          else
          {
            localObject = View.inflate(this.mContext, a.g.bottomsheet_header_menu_item, null);
            localWeImageView = (WeImageView)((View)localObject).findViewById(a.f.meun_icon);
            localTextView1 = (TextView)((View)localObject).findViewById(a.f.menu_title);
            localTextView2 = (TextView)((View)localObject).findViewById(a.f.menu_desc);
            if (this.aget != null) {
              this.aget.onAttach(localWeImageView, null, localt);
            }
            for (;;)
            {
              localWeImageView.setIconColor(localt.iconColor);
              localTextView1.setText(localt.getTitle());
              if (localt.BdX != null)
              {
                localTextView2.setVisibility(0);
                localTextView2.setText(localt.BdX);
              }
              ((View)localObject).setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(251780);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.cH(paramAnonymousView);
                  a.c("com/tencent/mm/ui/widget/dialog/MMBottomSheet$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                  if ((f.A(f.this) != null) && (i < f.B(f.this).size())) {
                    f.A(f.this).onMMMenuItemSelected(f.B(f.this).getItem(i), i);
                  }
                  if (!f.l(f.this)) {
                    f.this.cyW();
                  }
                  a.a(this, "com/tencent/mm/ui/widget/dialog/MMBottomSheet$9", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(251780);
                }
              });
              break;
              localWeImageView.setImageDrawable(localt.getIcon());
            }
          }
        }
        this.VtC.addView(localView);
      }
      if (this.ageB.size() <= 0) {
        break label1454;
      }
      if (this.ageD != null)
      {
        this.ageD.setVisibility(0);
        this.ageD.removeAllViews();
        this.ageD.setGravity(17);
      }
      View localView = View.inflate(this.mContext, a.g.bottomsheet_footer_menu_layout, null);
      LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(a.f.menu_layout);
      i = 0;
      while (i < this.ageB.size())
      {
        localt = (t)this.ageB.adRW.get(i);
        if (localt.NfE)
        {
          localObject = View.inflate(this.mContext, a.g.bottomsheet_footer_loading_item, null);
          localLinearLayout.addView((View)localObject);
          i += 1;
        }
        else
        {
          localObject = View.inflate(this.mContext, a.g.bottomsheet_footer_menu_item, null);
          localWeImageView = (WeImageView)((View)localObject).findViewById(a.f.meun_icon);
          localTextView1 = (TextView)((View)localObject).findViewById(a.f.menu_title);
          localTextView2 = (TextView)((View)localObject).findViewById(a.f.menu_desc);
          if (this.ageu != null) {
            this.ageu.onAttach(localWeImageView, null, localt);
          }
          for (;;)
          {
            localWeImageView.setIconColor(localt.iconColor);
            localTextView1.setText(localt.getTitle());
            if (localt.BdX != null)
            {
              localTextView2.setVisibility(0);
              localTextView2.setText(localt.BdX);
            }
            ((View)localObject).setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(251866);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.cH(paramAnonymousView);
                a.c("com/tencent/mm/ui/widget/dialog/MMBottomSheet$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                if ((f.C(f.this) != null) && (i < f.D(f.this).size())) {
                  f.C(f.this).onMMMenuItemSelected(f.D(f.this).getItem(i), i);
                }
                if (!f.l(f.this)) {
                  f.this.cyW();
                }
                a.a(this, "com/tencent/mm/ui/widget/dialog/MMBottomSheet$10", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(251866);
              }
            });
            break;
            localWeImageView.setImageDrawable(localt.getIcon());
          }
        }
      }
      if (this.ageD != null) {
        this.ageD.addView(localView);
      }
      i = bd.bs(this.mContext, a.d.grid_item_top_bottom_padding);
      k = bd.bs(this.mContext, a.d.Edge_2A);
      if (((this.Nfh) && (this.VtC.getVisibility() == 0)) || (this.agez.size() > 0)) {
        i = bd.fromDPToPix(this.mContext, 0);
      }
      this.mRecyclerView.setPadding(0, i, this.mRecyclerView.getPaddingRight(), this.mRecyclerView.getPaddingBottom());
      if ((this.ageD == null) || (this.ageD.getVisibility() != 0)) {
        break label1473;
      }
      this.ageD.setPadding(0, this.ageD.getPaddingTop(), this.ageD.getPaddingRight(), k);
      this.ageR.setPadding(0, this.ageR.getPaddingTop(), this.ageR.getPaddingRight(), k);
      label1010:
      if (this.ageQ != null)
      {
        k = bd.bs(this.mContext, a.d.grid_item_top_bottom_padding);
        i = k;
        if (this.Nfh)
        {
          i = k;
          if (this.VtC.getVisibility() == 0) {
            i = 0;
          }
        }
        this.ageQ.setPadding(0, i, this.ageQ.getPaddingRight(), this.ageQ.getPaddingBottom());
      }
      this.ageE.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      if (this.ageE.getChildAt(0) != null)
      {
        localObject = new Rect();
        this.mF.getWindowVisibleDisplayFrame((Rect)localObject);
        if (this.ageE.getChildAt(0).getMeasuredHeight() + bd.bs(this.mContext, a.d.Edge_7A) <= ((Rect)localObject).bottom) {
          break label1538;
        }
        i = 1;
        label1152:
        if (i != 0) {
          this.ageF.setVisibility(0);
        }
      }
      label1164:
      if ((this.Vtl != null) && (this.ageH != null)) {
        this.ageH.bZE.notifyChanged();
      }
      if (this.ageI != null) {
        this.ageI.bZE.notifyChanged();
      }
      if (this.ageJ != null) {
        this.ageJ.bZE.notifyChanged();
      }
      if (Build.VERSION.SDK_INT >= 21) {
        this.sRs.getWindow().addFlags(-2147483648);
      }
      if (this.GwR) {
        iAS();
      }
      if (this.sRy) {
        this.sRs.getWindow().addFlags(1024);
      }
      if (!this.sRz) {
        break label1557;
      }
      this.sRs.getWindow().setFlags(8, 8);
      this.sRs.getWindow().addFlags(131200);
      this.sRs.getWindow().getDecorView().setSystemUiVisibility(4102);
    }
    for (;;)
    {
      if (this.sRv != null) {
        this.sRv.dqC = false;
      }
      if (this.aeLi != null) {
        this.sRs.setOnDismissListener(new DialogInterface.OnDismissListener()
        {
          public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(251867);
            if ((f.this.aeLi != null) && (!f.E(f.this))) {
              f.this.aeLi.onDismiss();
            }
            if (f.t(f.this) != null) {
              c.f(f.t(f.this));
            }
            AppMethodBeat.o(251867);
          }
        });
      }
      this.sRs.setOnShowListener(new DialogInterface.OnShowListener()
      {
        public final void onShow(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(251859);
          if ((f.this.agei != null) && (!f.E(f.this))) {
            f.this.agei.onShow();
          }
          if ((f.this.agej != null) && (!f.E(f.this)) && (f.this.ageQ != null) && (f.this.ageQ.getVisibility() == 0)) {
            f.this.agej.onShow();
          }
          AppMethodBeat.o(251859);
        }
      });
      if (this.mF != null)
      {
        i = j;
        if (this.mP == null) {
          i = 1;
        }
        this.mP = this.mF.getViewTreeObserver();
        if (i != 0) {
          this.mP.addOnGlobalLayoutListener(this);
        }
      }
      if (((this.mContext instanceof Activity)) && (!((Activity)this.mContext).isFinishing())) {
        this.sRs.show();
      }
      AppMethodBeat.o(159362);
      return;
      label1454:
      if (this.ageD == null) {
        break;
      }
      this.ageD.setVisibility(8);
      break;
      label1473:
      if (isLandscape())
      {
        this.ageR.setPadding(0, this.ageR.getPaddingTop(), this.ageR.getPaddingRight(), k);
        break label1010;
      }
      this.ageR.setPadding(0, this.ageR.getPaddingTop(), this.ageR.getPaddingRight(), this.ageR.getPaddingBottom());
      break label1010;
      label1538:
      i = 0;
      break label1152;
      label1543:
      this.mRecyclerView.setPadding(0, 0, 0, 0);
      break label1164;
      label1557:
      this.sRs.getWindow().clearFlags(8);
      this.sRs.getWindow().clearFlags(131072);
      this.sRs.getWindow().clearFlags(128);
      this.sRs.getWindow().getDecorView().setSystemUiVisibility(0);
    }
  }
  
  public final Window getWindow()
  {
    AppMethodBeat.i(252180);
    if (this.sRs != null)
    {
      Window localWindow = this.sRs.getWindow();
      AppMethodBeat.o(252180);
      return localWindow;
    }
    AppMethodBeat.o(252180);
    return null;
  }
  
  public final void h(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(252080);
    if ((this.VtC != null) && (this.Nfh))
    {
      this.VtC.setVisibility(0);
      this.VtC.removeAllViews();
      this.VtC.setGravity(paramInt1);
      View localView = LayoutInflater.from(this.mContext).inflate(a.g.mm_bottom_sheet_title_text, null);
      TextView localTextView = (TextView)localView.findViewById(a.f.title_text);
      ImageView localImageView = (ImageView)localView.findViewById(a.f.divider);
      if (this.ageL) {
        localImageView.setVisibility(0);
      }
      this.lzN = localTextView;
      localTextView.setText(paramCharSequence);
      if (paramInt2 != 0) {
        localTextView.setTextSize(0, paramInt2);
      }
      localTextView.setGravity(paramInt1 | 0x50);
      if (this.VtK)
      {
        localTextView.setTextColor(this.mContext.getResources().getColor(a.c.BW_100_Alpha_0_8));
        localImageView.setBackgroundColor(this.mContext.getResources().getColor(a.c.BW_100_Alpha_0_0_5));
      }
      this.VtC.addView(localView, -1, -2);
    }
    AppMethodBeat.o(252080);
  }
  
  public final void ihf()
  {
    AppMethodBeat.i(159363);
    if (this.sRs != null)
    {
      this.aeLj = false;
      if ((this.Vtl != null) && (this.ageH != null)) {
        this.ageH.bZE.notifyChanged();
      }
      if (this.ageI != null) {
        this.ageI.bZE.notifyChanged();
      }
      if (this.ageJ != null)
      {
        if (this.ageJ.getItemCount() == 0) {
          aEV(8);
        }
        this.ageJ.bZE.notifyChanged();
      }
      this.sRs.setOnShowListener(new DialogInterface.OnShowListener()
      {
        public final void onShow(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(251858);
          if ((f.this.agei != null) && (!f.E(f.this))) {
            f.this.agei.onShow();
          }
          if ((f.this.agej != null) && (!f.E(f.this)) && (f.this.ageQ != null) && (f.this.ageQ.getVisibility() == 0)) {
            f.this.agej.onShow();
          }
          AppMethodBeat.o(251858);
        }
      });
      if (this.aeLi == null) {
        break label143;
      }
      this.sRs.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(251856);
          if (!f.E(f.this)) {
            f.this.aeLi.onDismiss();
          }
          AppMethodBeat.o(251856);
        }
      });
    }
    for (;;)
    {
      this.sRs.show();
      AppMethodBeat.o(159363);
      return;
      label143:
      this.sRs.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(251857);
          if (f.r(f.this) != null)
          {
            if (!f.r(f.this).isAlive()) {
              f.a(f.this, f.s(f.this).getViewTreeObserver());
            }
            f.r(f.this).removeGlobalOnLayoutListener(f.this);
            f.a(f.this, null);
          }
          if (!f.u(f.this)) {
            f.v(f.this);
          }
          AppMethodBeat.o(251857);
        }
      });
    }
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(159365);
    if ((this.sRs != null) && (this.sRs.isShowing()))
    {
      AppMethodBeat.o(159365);
      return true;
    }
    AppMethodBeat.o(159365);
    return false;
  }
  
  public final void jHI()
  {
    AppMethodBeat.i(252063);
    if ((this.agez.size() > 0) && (this.ageO == null))
    {
      jHJ();
      aEV(0);
    }
    AppMethodBeat.o(252063);
  }
  
  public final void jHJ()
  {
    AppMethodBeat.i(252070);
    this.ageO = ((ViewGroup)this.ageN.inflate());
    this.ageV = ((ImageView)this.rootView.findViewById(a.f.zero_menu_line));
    if (this.VtK) {
      this.ageV.setBackgroundColor(this.mContext.getResources().getColor(a.c.BW_100_Alpha_0_0_5));
    }
    this.ageQ = ((RecyclerView)this.rootView.findViewById(a.f.bottom_sheet_zero_menu_recycleview));
    this.ageQ.setHasFixedSize(true);
    this.agfd = L(this.ageQ);
    this.ageJ = new g(true);
    this.ageJ.GAB = this.agez;
    this.ageJ.un = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(251802);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousAdapterView);
        localb.cH(paramAnonymousView);
        localb.sc(paramAnonymousInt);
        localb.hB(paramAnonymousLong);
        a.c("com/tencent/mm/ui/widget/dialog/MMBottomSheet$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
        if (paramAnonymousInt >= f.this.agez.size())
        {
          a.a(this, "com/tencent/mm/ui/widget/dialog/MMBottomSheet$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(251802);
          return;
        }
        paramAnonymousAdapterView = (t)f.this.agez.adRW.get(paramAnonymousInt);
        if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.disable))
        {
          a.a(this, "com/tencent/mm/ui/widget/dialog/MMBottomSheet$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(251802);
          return;
        }
        if ((paramAnonymousInt < f.this.agez.size()) && (f.w(f.this) != null)) {
          f.w(f.this).onMMMenuItemSelected(f.this.agez.getItem(paramAnonymousInt), paramAnonymousInt);
        }
        if (!f.l(f.this)) {
          f.this.cyW();
        }
        f.m(f.this);
        f.x(f.this).bZE.notifyChanged();
        a.a(this, "com/tencent/mm/ui/widget/dialog/MMBottomSheet$6", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(251802);
      }
    };
    this.ageJ.agfp = new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(251789);
        if (paramAnonymousInt >= f.this.agez.size())
        {
          AppMethodBeat.o(251789);
          return false;
        }
        paramAnonymousAdapterView = (t)f.this.agez.adRW.get(paramAnonymousInt);
        if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.disable))
        {
          AppMethodBeat.o(251789);
          return false;
        }
        if ((paramAnonymousInt < f.this.agez.size()) && (f.y(f.this) != null)) {
          f.y(f.this).onMMMenuItemLongSelected(f.this.agez.getItem(paramAnonymousInt), paramAnonymousInt);
        }
        f.m(f.this);
        f.x(f.this).bZE.notifyChanged();
        AppMethodBeat.o(251789);
        return false;
      }
    };
    this.ageQ.setAdapter(this.ageJ);
    this.ageQ.setOverScrollMode(1);
    if (this.bottomSheetStyle == 0)
    {
      LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager();
      localLinearLayoutManager.setOrientation(0);
      this.ageQ.setLayoutManager(localLinearLayoutManager);
    }
    AppMethodBeat.o(252070);
  }
  
  public final void jHK()
  {
    AppMethodBeat.i(252171);
    if (this.sRs != null)
    {
      this.sRs.setCancelMessage(null);
      this.sRs.setDismissMessage(null);
      this.sRs.setOnShowListener(null);
      this.agei = null;
      this.ages = null;
      this.aeLi = null;
    }
    this.mContext = null;
    AppMethodBeat.o(252171);
  }
  
  public void onGlobalLayout()
  {
    AppMethodBeat.i(159353);
    if (isShowing())
    {
      View localView = this.mF;
      if ((localView == null) || ((!localView.isShown()) && (localView.getVisibility() != 0)))
      {
        cyW();
        AppMethodBeat.o(159353);
        return;
      }
      if ((isShowing()) && ((this.sRw != isLandscape()) || (this.sRx != getRotation()))) {
        cyW();
      }
    }
    AppMethodBeat.o(159353);
  }
  
  public final void setBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(159360);
    if (this.rootView != null) {
      this.rootView.setBackgroundColor(paramInt);
    }
    this.ageC = Boolean.valueOf(bb.aAF(paramInt));
    if ((this.ageC.booleanValue()) && (this.ageS != null)) {
      this.ageS.setImageDrawable(this.mContext.getResources().getDrawable(a.c.dark_bg_line_color));
    }
    AppMethodBeat.o(159360);
  }
  
  public final void setFooterView(View paramView)
  {
    AppMethodBeat.i(159358);
    if (this.VtD != null)
    {
      if (paramView == null)
      {
        this.VtD.setVisibility(8);
        AppMethodBeat.o(159358);
        return;
      }
      this.VtD.setVisibility(0);
      this.VtD.removeAllViews();
      this.VtD.setGravity(17);
      this.VtD.addView(paramView, -1, -2);
    }
    AppMethodBeat.o(159358);
  }
  
  public final void uR(boolean paramBoolean)
  {
    AppMethodBeat.i(252087);
    if (this.GwU == null)
    {
      AppMethodBeat.o(252087);
      return;
    }
    if (paramBoolean)
    {
      this.GwU.setVisibility(8);
      AppMethodBeat.o(252087);
      return;
    }
    this.GwU.setVisibility(0);
    AppMethodBeat.o(252087);
  }
  
  public static abstract interface a
  {
    public abstract void onClick();
  }
  
  public static abstract interface d
  {
    public abstract void onShow();
  }
  
  final class e
    extends RecyclerView.l
  {
    private e() {}
    
    private void M(RecyclerView paramRecyclerView)
    {
      AppMethodBeat.i(251849);
      paramRecyclerView = paramRecyclerView.getLayoutManager();
      if (!(paramRecyclerView instanceof LinearLayoutManager))
      {
        AppMethodBeat.o(251849);
        return;
      }
      paramRecyclerView = (LinearLayoutManager)paramRecyclerView;
      int i = paramRecyclerView.Ju();
      int j = paramRecyclerView.Jw();
      if (i <= j)
      {
        t localt = aEW(i);
        if (localt == null) {
          if ((i == f.f(f.this).size() + f.h(f.this).size()) && (f.aa(f.this) != null)) {
            f.aa(f.this).onMMMenuItemVisible(null, paramRecyclerView.findViewByPosition(i));
          }
        }
        for (;;)
        {
          i += 1;
          break;
          u.k localk = localt.adSe;
          if (localk != null) {
            localk.onMMMenuItemVisible(localt, paramRecyclerView.findViewByPosition(i));
          }
        }
      }
      AppMethodBeat.o(251849);
    }
    
    private t aEW(int paramInt)
    {
      AppMethodBeat.i(251854);
      if (paramInt < 0)
      {
        AppMethodBeat.o(251854);
        return null;
      }
      t localt;
      if (paramInt < f.f(f.this).size())
      {
        localt = (t)f.f(f.this).adRW.get(paramInt);
        AppMethodBeat.o(251854);
        return localt;
      }
      if ((f.h(f.this).size() > 0) && (paramInt < f.f(f.this).size() + f.h(f.this).size()))
      {
        localt = (t)f.h(f.this).getItem(paramInt - f.f(f.this).size());
        AppMethodBeat.o(251854);
        return localt;
      }
      AppMethodBeat.o(251854);
      return null;
    }
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(251860);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt);
      a.c("com/tencent/mm/ui/widget/dialog/MMBottomSheet$MenuItemVisibleHelper", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      M(paramRecyclerView);
      a.a(this, "com/tencent/mm/ui/widget/dialog/MMBottomSheet$MenuItemVisibleHelper", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(251860);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(251863);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt1);
      localb.sc(paramInt2);
      a.c("com/tencent/mm/ui/widget/dialog/MMBottomSheet$MenuItemVisibleHelper", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      M(paramRecyclerView);
      a.a(this, "com/tencent/mm/ui/widget/dialog/MMBottomSheet$MenuItemVisibleHelper", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(251863);
    }
  }
  
  public static abstract interface f
  {
    public abstract void onClick();
  }
  
  public final class g
    extends RecyclerView.a<a>
  {
    s GAB;
    private final boolean agfo;
    AdapterView.OnItemLongClickListener agfp;
    AdapterView.OnItemClickListener un;
    
    public g(boolean paramBoolean)
    {
      this.agfo = paramBoolean;
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(159348);
      int j = this.GAB.size();
      int i;
      if (this.agfo)
      {
        i = j;
        if (f.R(f.this)) {}
      }
      else
      {
        i = j + f.h(f.this).size();
      }
      j = i;
      if (f.U(f.this)) {
        if (this.agfo)
        {
          j = i;
          if (f.R(f.this)) {}
        }
        else
        {
          j = i + 1;
        }
      }
      AppMethodBeat.o(159348);
      return j;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(251848);
      if ((paramInt >= 0) && (paramInt < this.GAB.size()))
      {
        MenuItem localMenuItem = this.GAB.getItem(paramInt);
        if (((localMenuItem instanceof t)) && (!((t)localMenuItem).adSa))
        {
          AppMethodBeat.o(251848);
          return 1;
        }
      }
      else
      {
        if ((f.h(f.this).size() > 0) && (paramInt < this.GAB.size() + f.h(f.this).size()))
        {
          AppMethodBeat.o(251848);
          return 2;
        }
        if ((f.U(f.this)) && (paramInt == this.GAB.size() + f.h(f.this).size()))
        {
          AppMethodBeat.o(251848);
          return 3;
        }
      }
      AppMethodBeat.o(251848);
      return 0;
    }
    
    public final class a
      extends RecyclerView.v
      implements View.OnClickListener, View.OnLongClickListener
    {
      WeImageView EoD;
      ImageView GAE;
      ImageView Vts;
      LinearLayout Vtt;
      ImageView agfs;
      RadioButton agft;
      View agfu;
      View mlS;
      TextView mll;
      TextView pmf;
      
      public a(View paramView)
      {
        super();
        AppMethodBeat.i(159346);
        this.agfs = null;
        paramView.setOnClickListener(this);
        paramView.setOnLongClickListener(this);
        this.mll = ((TextView)paramView.findViewById(a.f.title));
        this.EoD = ((WeImageView)paramView.findViewById(a.f.icon));
        this.Vtt = ((LinearLayout)paramView.findViewById(a.f.root));
        this.agfu = paramView.findViewById(a.f.new_tip);
        this.mlS = paramView.findViewById(a.f.red_dot);
        if (f.I(f.this))
        {
          this.GAE = ((ImageView)paramView.findViewById(a.f.icon_bg));
          if ((f.x(f.this) != null) && (f.x(f.this).getItemCount() > 0))
          {
            this.GAE.setLongClickable(true);
            this.GAE.setOnLongClickListener(this);
            this.GAE.setOnClickListener(this);
          }
          this.agfs = ((ImageView)paramView.findViewById(a.f.icon_badge));
        }
        if (f.J(f.this)) {
          this.agft = ((RadioButton)paramView.findViewById(a.f.radio));
        }
        if ((f.J(f.this)) || (f.Q(f.this)))
        {
          this.pmf = ((TextView)paramView.findViewById(a.f.desc));
          this.Vts = ((ImageView)paramView.findViewById(a.f.divider));
        }
        AppMethodBeat.o(159346);
      }
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(159347);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramView);
        a.c("com/tencent/mm/ui/widget/dialog/MMBottomSheet$RecycleViewAdapter$ViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (f.g.this.un != null) {
          f.g.this.un.onItemClick(null, paramView, getPosition(), getPosition());
        }
        a.a(this, "com/tencent/mm/ui/widget/dialog/MMBottomSheet$RecycleViewAdapter$ViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(159347);
      }
      
      public final boolean onLongClick(View paramView)
      {
        AppMethodBeat.i(251822);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramView);
        a.c("com/tencent/mm/ui/widget/dialog/MMBottomSheet$RecycleViewAdapter$ViewHolder", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
        if (f.g.this.agfp != null)
        {
          f.g.this.agfp.onItemLongClick(null, paramView, getPosition(), getPosition());
          a.a(true, this, "com/tencent/mm/ui/widget/dialog/MMBottomSheet$RecycleViewAdapter$ViewHolder", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(251822);
          return true;
        }
        a.a(false, this, "com/tencent/mm/ui/widget/dialog/MMBottomSheet$RecycleViewAdapter$ViewHolder", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(251822);
        return false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.a.f
 * JD-Core Version:    0.7.0.1
 */