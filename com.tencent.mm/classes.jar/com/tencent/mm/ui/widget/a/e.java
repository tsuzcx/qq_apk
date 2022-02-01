package com.tencent.mm.ui.widget.a;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.l;
import androidx.recyclerview.widget.RecyclerView.r;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cr.a.c;
import com.tencent.mm.cr.a.d;
import com.tencent.mm.cr.a.e;
import com.tencent.mm.cr.a.f;
import com.tencent.mm.cr.a.g;
import com.tencent.mm.cr.a.j;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.base.CustomScrollView;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.q.a;
import com.tencent.mm.ui.base.q.b;
import com.tencent.mm.ui.base.q.c;
import com.tencent.mm.ui.base.q.d;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.q.h;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Iterator;
import java.util.List;

public class e
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private boolean AUA;
  public boolean AUB;
  private LinearLayout AUD;
  private View AUE;
  private TextView AUF;
  private boolean HBs;
  private boolean Hfz;
  public q.f ODT;
  public q.g ODU;
  private q.g ODV;
  public q.b ODW;
  public q.c ODX;
  public o ODY;
  private o ODZ;
  private boolean OEb;
  public boolean OEc;
  private LinearLayout OEr;
  private LinearLayout OEs;
  private boolean OEz;
  public e.b XbB;
  private boolean XbC;
  public q.g YmA;
  private q.g YmB;
  public q.g YmC;
  private e.e YmD;
  public e.a YmE;
  public q.b YmF;
  public q.b YmG;
  private q.a YmH;
  private q.c YmI;
  private o YmJ;
  private o YmK;
  private o YmL;
  private Boolean YmM;
  private LinearLayout YmN;
  private CustomScrollView YmO;
  private View YmP;
  public f YmQ;
  private f YmR;
  private boolean YmS;
  private boolean YmT;
  private boolean YmU;
  private RecyclerView YmV;
  private ImageView YmW;
  private ImageView YmX;
  private int YmY;
  private int YmZ;
  public c Ymw;
  public q.f Ymx;
  private q.f Ymy;
  public q.f Ymz;
  private int Yna;
  public boolean Ynb;
  private int Ync;
  public boolean Ynd;
  public RecyclerView.r Yne;
  private boolean Ynf;
  private boolean Yng;
  private boolean Ynh;
  private String Yni;
  private q.b Ynj;
  private q.a Ynk;
  private q.h Ynl;
  private boolean Ynm;
  private int bottomSheetStyle;
  private View lJ;
  private ViewTreeObserver lS;
  public int mBE;
  public Context mContext;
  public RecyclerView mRecyclerView;
  private View oFW;
  private int pMB;
  private BottomSheetBehavior pMC;
  private boolean pMD;
  private int pME;
  public boolean pMF;
  public boolean pMG;
  private boolean pMH;
  public int pMI;
  private Dialog pMz;
  
  public e(Context paramContext, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(159351);
    this.YmM = Boolean.FALSE;
    this.YmS = false;
    this.OEb = false;
    this.YmT = false;
    this.YmU = false;
    this.pMD = false;
    this.YmY = 4;
    this.YmZ = (this.YmY * 3);
    this.Yna = 6;
    this.HBs = false;
    this.AUB = false;
    this.XbC = false;
    this.pMG = false;
    this.OEc = false;
    this.Ynb = false;
    this.mBE = 0;
    this.pMH = false;
    this.Ync = 0;
    this.pMI = 0;
    this.Ynd = false;
    this.OEz = false;
    this.Yne = null;
    this.Ynf = false;
    this.Yng = false;
    this.Ynh = true;
    this.Yni = null;
    this.Ynj = null;
    this.Ynk = null;
    this.Ynl = null;
    this.Ynm = false;
    this.bottomSheetStyle = paramInt;
    this.mContext = paramContext;
    this.Hfz = paramBoolean;
    this.Ynb = false;
    if ((this.mContext instanceof Activity)) {
      this.lJ = ((ViewGroup)((Activity)this.mContext).getWindow().getDecorView()).findViewById(16908290);
    }
    bv(this.mContext);
    AppMethodBeat.o(159351);
  }
  
  public e(Context paramContext, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(250415);
    this.YmM = Boolean.FALSE;
    this.YmS = false;
    this.OEb = false;
    this.YmT = false;
    this.YmU = false;
    this.pMD = false;
    this.YmY = 4;
    this.YmZ = (this.YmY * 3);
    this.Yna = 6;
    this.HBs = false;
    this.AUB = false;
    this.XbC = false;
    this.pMG = false;
    this.OEc = false;
    this.Ynb = false;
    this.mBE = 0;
    this.pMH = false;
    this.Ync = 0;
    this.pMI = 0;
    this.Ynd = false;
    this.OEz = false;
    this.Yne = null;
    this.Ynf = false;
    this.Yng = false;
    this.Ynh = true;
    this.Yni = null;
    this.Ynj = null;
    this.Ynk = null;
    this.Ynl = null;
    this.Ynm = false;
    this.bottomSheetStyle = paramInt;
    this.mContext = paramContext;
    this.pMH = paramBoolean;
    if ((this.mContext instanceof Activity)) {
      this.lJ = ((ViewGroup)((Activity)this.mContext).getWindow().getDecorView()).findViewById(16908290);
    }
    bv(this.mContext);
    AppMethodBeat.o(250415);
  }
  
  private void bv(Context paramContext)
  {
    AppMethodBeat.i(159355);
    this.ODY = new o(paramContext);
    this.ODZ = new o(paramContext);
    this.YmJ = new o(paramContext);
    this.YmK = new o(paramContext);
    this.YmL = new o(paramContext);
    if (this.pMH)
    {
      this.pMz = new b(paramContext);
      this.oFW = View.inflate(paramContext, a.g.mm_bottom_sheet, null);
      this.OEr = ((LinearLayout)this.oFW.findViewById(a.f.bottom_sheet_title));
      this.OEs = ((LinearLayout)this.oFW.findViewById(a.f.bottom_sheet_footer));
      this.AUD = ((LinearLayout)this.oFW.findViewById(a.f.bottom_sheet_cancel));
      this.AUE = this.oFW.findViewById(a.f.cancel_space);
      this.YmN = ((LinearLayout)this.oFW.findViewById(a.f.bottom_sheet_footer_menu));
      this.AUF = ((TextView)this.oFW.findViewById(a.f.cancel_text));
      this.YmO = ((CustomScrollView)this.oFW.findViewById(a.f.content_scroll));
      this.YmP = this.oFW.findViewById(a.f.gradient_mask);
      this.YmW = ((ImageView)this.oFW.findViewById(a.f.deviderline));
      this.YmX = ((ImageView)this.oFW.findViewById(a.f.menu_line));
      this.AUD.setOnClickListener(new e.1(this));
      this.mRecyclerView = ((RecyclerView)this.oFW.findViewById(a.f.bottom_sheet_menu_reccycleview));
      this.mRecyclerView.setHasFixedSize(true);
      if (this.mRecyclerView.getItemAnimator() != null) {
        this.mRecyclerView.getItemAnimator().alg = 100L;
      }
      this.YmV = ((RecyclerView)this.oFW.findViewById(a.f.bottom_sheet_second_reccycleview));
      this.YmV.setHasFixedSize(true);
      this.Yne = new e.4(this, this.mRecyclerView.getContext());
      this.pMD = isLandscape();
      if (this.bottomSheetStyle != 0) {
        break label843;
      }
      this.YmU = true;
      if (!this.pMD) {
        break label802;
      }
      this.YmY = 7;
      this.YmZ = (this.YmY * 2);
      this.pMB = (aw.aZ(this.mContext, a.d.BottomSheetGridMaxHeight_Landscape) + aw.aZ(this.mContext, a.d.grid_item_top_bottom_padding));
      label436:
      if (this.Hfz) {
        this.pMB += aw.aZ(this.mContext, a.d.grid_item_top_bottom_padding);
      }
      this.AUD.setVisibility(0);
      if (this.oFW != null)
      {
        if ((!this.pMH) || (!isLandscape())) {
          break label830;
        }
        this.oFW.setBackgroundColor(this.mContext.getResources().getColor(a.c.BG_1));
      }
      label511:
      this.YmO.setOnScrollChangeListener(new e.5(this));
      label526:
      if ((this.Hfz) && (this.YmW != null) && (this.Ynb)) {
        this.YmW.setVisibility(0);
      }
      if (this.bottomSheetStyle != 0) {
        break label1084;
      }
      paramContext = new LinearLayoutManager();
      paramContext.setOrientation(0);
      this.mRecyclerView.setLayoutManager(paramContext);
      paramContext = new LinearLayoutManager();
      paramContext.setOrientation(0);
      this.YmV.setLayoutManager(paramContext);
    }
    for (;;)
    {
      this.mRecyclerView.setFocusable(false);
      this.mRecyclerView.setItemViewCacheSize(20);
      this.YmQ = new f(false);
      this.YmQ.OEf = this.ODY;
      this.YmQ.tp = new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(251034);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousAdapterView);
          localb.bn(paramAnonymousView);
          localb.sg(paramAnonymousInt);
          localb.Fs(paramAnonymousLong);
          a.c("com/tencent/mm/ui/widget/dialog/MMBottomSheet$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
          if (paramAnonymousInt < e.e(e.this).size())
          {
            paramAnonymousAdapterView = (p)e.e(e.this).WkP.get(paramAnonymousInt);
            if ((paramAnonymousAdapterView == null) || (paramAnonymousAdapterView.qfB))
            {
              a.a(this, "com/tencent/mm/ui/widget/dialog/MMBottomSheet$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(251034);
              return;
            }
            if (e.f(e.this) != null) {
              e.f(e.this).onMMMenuItemSelected(paramAnonymousAdapterView, paramAnonymousInt);
            }
          }
          for (;;)
          {
            if (!e.k(e.this)) {
              e.this.bYF();
            }
            e.l(e.this);
            e.a(e.this, paramAnonymousInt);
            e.m(e.this).alc.notifyChanged();
            a.a(this, "com/tencent/mm/ui/widget/dialog/MMBottomSheet$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(251034);
            return;
            paramAnonymousAdapterView.performClick();
            continue;
            if ((e.g(e.this).size() > 0) && (paramAnonymousInt < e.e(e.this).size() + e.g(e.this).size()))
            {
              paramAnonymousAdapterView = (p)e.g(e.this).getItem(paramAnonymousInt - e.e(e.this).size());
              if ((paramAnonymousAdapterView == null) || (paramAnonymousAdapterView.qfB))
              {
                a.a(this, "com/tencent/mm/ui/widget/dialog/MMBottomSheet$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(251034);
                return;
              }
              if (e.h(e.this) != null) {
                e.h(e.this).onMMMenuItemSelected(paramAnonymousAdapterView, paramAnonymousInt);
              } else {
                paramAnonymousAdapterView.performClick();
              }
            }
            else
            {
              if (!e.i(e.this))
              {
                a.a(this, "com/tencent/mm/ui/widget/dialog/MMBottomSheet$4", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(251034);
                return;
              }
              e.j(e.this);
            }
          }
        }
      };
      this.mRecyclerView.setAdapter(this.YmQ);
      this.mRecyclerView.setOverScrollMode(1);
      this.YmR = new f(true);
      this.YmR.OEf = this.YmJ;
      this.YmR.tp = new AdapterView.OnItemClickListener()
      {
        public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(249425);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousAdapterView);
          localb.bn(paramAnonymousView);
          localb.sg(paramAnonymousInt);
          localb.Fs(paramAnonymousLong);
          a.c("com/tencent/mm/ui/widget/dialog/MMBottomSheet$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
          if (paramAnonymousInt >= e.n(e.this).size())
          {
            a.a(this, "com/tencent/mm/ui/widget/dialog/MMBottomSheet$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(249425);
            return;
          }
          paramAnonymousAdapterView = (p)e.n(e.this).WkP.get(paramAnonymousInt);
          if ((paramAnonymousAdapterView != null) && (paramAnonymousAdapterView.qfB))
          {
            a.a(this, "com/tencent/mm/ui/widget/dialog/MMBottomSheet$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
            AppMethodBeat.o(249425);
            return;
          }
          if ((paramAnonymousInt < e.n(e.this).size()) && (e.o(e.this) != null)) {
            e.o(e.this).onMMMenuItemSelected(e.n(e.this).getItem(paramAnonymousInt), paramAnonymousInt);
          }
          if (!e.k(e.this)) {
            e.this.bYF();
          }
          e.l(e.this);
          e.p(e.this).alc.notifyChanged();
          a.a(this, "com/tencent/mm/ui/widget/dialog/MMBottomSheet$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
          AppMethodBeat.o(249425);
        }
      };
      this.YmV.setAdapter(this.YmR);
      this.YmV.setOverScrollMode(1);
      if (this.pMz != null) {
        this.pMz.setContentView(this.oFW);
      }
      if (this.pMz != null) {
        this.pMz.setOnDismissListener(new DialogInterface.OnDismissListener()
        {
          public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(159345);
            if (e.q(e.this) != null)
            {
              if (!e.q(e.this).isAlive()) {
                e.a(e.this, e.r(e.this).getViewTreeObserver());
              }
              e.q(e.this).removeGlobalOnLayoutListener(e.this);
              e.a(e.this, null);
            }
            if (!e.s(e.this)) {
              e.t(e.this);
            }
            AppMethodBeat.o(159345);
          }
        });
      }
      AppMethodBeat.o(159355);
      return;
      this.pMz = new i(paramContext, a.j.CustomSheetStyle);
      break;
      label802:
      this.pMB = (aw.aZ(this.mContext, a.d.BottomSheetGridMaxHeight) + aw.aZ(this.mContext, a.d.grid_item_top_bottom_padding));
      break label436;
      label830:
      this.oFW.setBackgroundResource(a.e.up_corner_grey_bg);
      break label511;
      label843:
      if (this.bottomSheetStyle == 2)
      {
        this.OEb = true;
        i = aw.aZ(this.mContext, a.d.bottomsheet_list_checkbox_item_height);
        if (this.pMD) {
          this.Yna = 2;
        }
        for (this.pMB = ((int)(i * 2.5D) + aw.aZ(this.mContext, a.d.bottomsheet_dividing_line_height));; this.pMB = ((int)(i * 3.5D) + aw.aZ(this.mContext, a.d.bottomsheet_dividing_line_height)))
        {
          if (!this.Hfz) {
            break label957;
          }
          this.pMB += aw.fromDPToPix(this.mContext, 88);
          break;
          this.Yna = 3;
        }
        break label526;
      }
      label957:
      this.YmT = true;
      int i = aw.aZ(this.mContext, a.d.bottomsheet_list_item_height);
      if (this.pMD) {
        this.Yna = 4;
      }
      for (this.pMB = ((int)(i * 4.5D) + aw.aZ(this.mContext, a.d.bottomsheet_dividing_line_height));; this.pMB = ((int)(i * 6.5D) + aw.aZ(this.mContext, a.d.bottomsheet_dividing_line_height)))
      {
        if (this.Hfz) {
          this.pMB += aw.aZ(this.mContext, a.d.grid_item_top_bottom_padding);
        }
        if (this.AUD == null) {
          break;
        }
        this.AUD.setVisibility(0);
        break;
        this.Yna = 6;
      }
      label1084:
      this.mRecyclerView.setLayoutManager(new LinearLayoutManager());
    }
  }
  
  @SuppressLint({"WrongConstant"})
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
  
  @TargetApi(23)
  private void haF()
  {
    AppMethodBeat.i(159361);
    if ((Build.VERSION.SDK_INT >= 23) && (this.pMz != null))
    {
      this.pMz.getWindow().getDecorView().setSystemUiVisibility(9216);
      this.pMz.getWindow().setStatusBarColor(0);
    }
    AppMethodBeat.o(159361);
  }
  
  private void icB()
  {
    AppMethodBeat.i(159366);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.oFW.getLayoutParams();
    this.ODY.size();
    if ((!this.YmS) && (this.ODZ.size() > 0)) {
      this.ODZ.size();
    }
    Rect localRect;
    if ((this.pMD) && (this.lJ != null))
    {
      localRect = new Rect();
      this.lJ.getWindowVisibleDisplayFrame(localRect);
      if (!this.pMH) {
        break label168;
      }
      localLayoutParams.width = ((int)(localRect.right * 1.0F / 2.0F));
      if (this.pMI != 0) {
        localLayoutParams.width = this.pMI;
      }
      if (!ax.kY(this.mContext)) {
        break label157;
      }
      localLayoutParams.height = (localRect.bottom - ax.at(this.mContext));
    }
    for (;;)
    {
      this.oFW.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(159366);
      return;
      label157:
      localLayoutParams.height = localRect.bottom;
      continue;
      label168:
      localLayoutParams.width = Math.min(localRect.right, localRect.bottom);
      if (this.pMI != 0) {
        localLayoutParams.width = this.pMI;
      }
    }
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
  
  public final void HI(boolean paramBoolean)
  {
    this.Ynh = paramBoolean;
  }
  
  public final void HJ(boolean paramBoolean)
  {
    this.pMG = paramBoolean;
  }
  
  public final e HK(boolean paramBoolean)
  {
    this.Ynd = paramBoolean;
    return this;
  }
  
  public final void Z(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(159356);
    if (paramView == null)
    {
      AppMethodBeat.o(159356);
      return;
    }
    this.Hfz = true;
    ImageView localImageView;
    if (this.YmW != null)
    {
      localImageView = this.YmW;
      if (!paramBoolean) {
        break label96;
      }
    }
    label96:
    for (int i = 4;; i = 0)
    {
      localImageView.setVisibility(i);
      if (this.OEr != null)
      {
        this.OEr.setVisibility(0);
        this.OEr.removeAllViews();
        this.OEr.setGravity(17);
        this.OEr.addView(paramView, -1, -2);
      }
      AppMethodBeat.o(159356);
      return;
    }
  }
  
  public final void a(o paramo, q.g paramg, q.c paramc)
  {
    AppMethodBeat.i(250431);
    this.Ynf = true;
    this.ODZ = paramo;
    this.ODV = paramg;
    this.YmI = paramc;
    if (!this.Ynm)
    {
      if ((this.mRecyclerView == null) || (paramo == null))
      {
        AppMethodBeat.o(250431);
        return;
      }
      paramo = paramo.WkP;
      if ((paramo == null) || (paramo.isEmpty()))
      {
        AppMethodBeat.o(250431);
        return;
      }
      paramo = paramo.iterator();
      do
      {
        if (!paramo.hasNext()) {
          break;
        }
        paramg = (MenuItem)paramo.next();
      } while ((!(paramg instanceof p)) || (((p)paramg).WkY == null));
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.mRecyclerView.a(new d((byte)0));
        this.Ynm = true;
      }
      AppMethodBeat.o(250431);
      return;
    }
  }
  
  public final void a(q.a parama)
  {
    this.YmH = parama;
  }
  
  public final void a(q.f paramf)
  {
    this.ODT = paramf;
  }
  
  public final void a(q.g paramg)
  {
    this.ODU = paramg;
  }
  
  public final void a(e.a parama)
  {
    this.YmE = parama;
  }
  
  public final void a(e.e parame)
  {
    this.YmS = false;
    this.YmD = parame;
  }
  
  public final void a(e.e parame, String paramString, q.b paramb, q.a parama, q.h paramh)
  {
    AppMethodBeat.i(250429);
    this.YmS = true;
    this.YmD = parame;
    this.Yng = true;
    this.Yni = paramString;
    this.Ynj = paramb;
    this.Ynk = parama;
    this.Ynl = paramh;
    if (!this.Ynm)
    {
      if (this.mRecyclerView == null)
      {
        AppMethodBeat.o(250429);
        return;
      }
      this.mRecyclerView.a(new d((byte)0));
      this.Ynm = true;
    }
    AppMethodBeat.o(250429);
  }
  
  public final void ayn(int paramInt)
  {
    this.mBE = paramInt;
  }
  
  public final void b(q.f paramf)
  {
    this.Ymx = paramf;
  }
  
  public final void b(q.g paramg)
  {
    this.YmA = paramg;
  }
  
  public final void b(e.b paramb)
  {
    this.XbB = paramb;
  }
  
  public final void bYF()
  {
    AppMethodBeat.i(159364);
    if (this.pMz != null)
    {
      if (this.pMC != null) {
        this.pMC.bxz = true;
      }
      if ((!(this.mContext instanceof Activity)) || ((this.mContext != null) && (!((Activity)this.mContext).isFinishing()) && (!((Activity)this.mContext).isDestroyed()))) {
        this.pMz.dismiss();
      }
    }
    AppMethodBeat.o(159364);
  }
  
  public final void eik()
  {
    int j = 0;
    AppMethodBeat.i(159362);
    this.XbC = false;
    this.pMD = isLandscape();
    this.pME = getRotation();
    if (this.ODT != null) {
      this.ODT.onCreateMMMenu(this.ODY);
    }
    if (this.Ymx != null) {
      this.Ymx.onCreateMMMenu(this.YmJ);
    }
    if (this.Ymy != null) {
      this.Ymy.onCreateMMMenu(this.YmK);
    }
    if (this.Ymz != null) {
      this.Ymz.onCreateMMMenu(this.YmL);
    }
    final int i;
    int m;
    if (this.pMz != null)
    {
      icB();
      if (!this.YmU) {
        break label1327;
      }
      if (this.YmJ.size() > 0)
      {
        this.YmX.setVisibility(0);
        this.YmV.setVisibility(0);
        if (this.AUE != null) {
          this.AUE.setVisibility(8);
        }
      }
      View localView;
      LinearLayout localLinearLayout;
      p localp;
      Object localObject;
      WeImageView localWeImageView;
      TextView localTextView1;
      TextView localTextView2;
      if (this.YmK.size() > 0)
      {
        if (this.OEr != null)
        {
          this.OEr.setVisibility(0);
          this.OEr.removeAllViews();
          this.OEr.setGravity(17);
        }
        localView = View.inflate(this.mContext, a.g.bottomsheet_header_menu_layout, null);
        localLinearLayout = (LinearLayout)localView.findViewById(a.f.menu_layout);
        i = 0;
        while (i < this.YmK.size())
        {
          localp = (p)this.YmK.WkP.get(i);
          if (localp.HhK)
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
            if (this.YmF != null) {
              this.YmF.a(localWeImageView, localp);
            }
            for (;;)
            {
              localWeImageView.setIconColor(localp.iconColor);
              localTextView1.setText(localp.getTitle());
              if (localp.BOZ != null)
              {
                localTextView2.setVisibility(0);
                localTextView2.setText(localp.BOZ);
              }
              ((View)localObject).setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(249698);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bn(paramAnonymousView);
                  a.c("com/tencent/mm/ui/widget/dialog/MMBottomSheet$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                  if ((e.u(e.this) != null) && (i < e.v(e.this).size())) {
                    e.u(e.this).onMMMenuItemSelected(e.v(e.this).getItem(i), i);
                  }
                  if (!e.k(e.this)) {
                    e.this.bYF();
                  }
                  a.a(this, "com/tencent/mm/ui/widget/dialog/MMBottomSheet$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(249698);
                }
              });
              break;
              localWeImageView.setImageDrawable(localp.getIcon());
            }
          }
        }
        this.OEr.addView(localView);
      }
      if (this.YmL.size() > 0)
      {
        if (this.YmN != null)
        {
          this.YmN.setVisibility(0);
          this.YmN.removeAllViews();
          this.YmN.setGravity(17);
        }
        localView = View.inflate(this.mContext, a.g.bottomsheet_footer_menu_layout, null);
        localLinearLayout = (LinearLayout)localView.findViewById(a.f.menu_layout);
        i = 0;
        while (i < this.YmL.size())
        {
          localp = (p)this.YmL.WkP.get(i);
          if (localp.HhK)
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
            if (this.YmG != null) {
              this.YmG.a(localWeImageView, localp);
            }
            for (;;)
            {
              localWeImageView.setIconColor(localp.iconColor);
              localTextView1.setText(localp.getTitle());
              if (localp.BOZ != null)
              {
                localTextView2.setVisibility(0);
                localTextView2.setText(localp.BOZ);
              }
              ((View)localObject).setOnClickListener(new View.OnClickListener()
              {
                public final void onClick(View paramAnonymousView)
                {
                  AppMethodBeat.i(249762);
                  com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                  localb.bn(paramAnonymousView);
                  a.c("com/tencent/mm/ui/widget/dialog/MMBottomSheet$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                  if ((e.w(e.this) != null) && (i < e.x(e.this).size())) {
                    e.w(e.this).onMMMenuItemSelected(e.x(e.this).getItem(i), i);
                  }
                  if (!e.k(e.this)) {
                    e.this.bYF();
                  }
                  a.a(this, "com/tencent/mm/ui/widget/dialog/MMBottomSheet$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                  AppMethodBeat.o(249762);
                }
              });
              break;
              localWeImageView.setImageDrawable(localp.getIcon());
            }
          }
        }
        if (this.YmN != null) {
          this.YmN.addView(localView);
        }
      }
      int k = aw.aZ(this.mContext, a.d.grid_item_top_bottom_padding);
      m = aw.aZ(this.mContext, a.d.Edge_2A);
      i = k;
      if (this.Hfz)
      {
        i = k;
        if (this.OEr.getVisibility() == 0) {
          i = aw.fromDPToPix(this.mContext, 0);
        }
      }
      this.mRecyclerView.setPadding(0, i, this.mRecyclerView.getPaddingRight(), this.mRecyclerView.getPaddingBottom());
      if ((this.YmN == null) || (this.YmN.getVisibility() != 0)) {
        break label1256;
      }
      this.YmN.setPadding(0, this.YmN.getPaddingTop(), this.YmN.getPaddingRight(), m);
      this.YmV.setPadding(0, this.YmV.getPaddingTop(), this.YmV.getPaddingRight(), m);
      this.YmO.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      if (this.YmO.getChildAt(0) != null)
      {
        localObject = new Rect();
        this.lJ.getWindowVisibleDisplayFrame((Rect)localObject);
        if (this.YmO.getChildAt(0).getMeasuredHeight() + aw.aZ(this.mContext, a.d.Edge_7A) <= ((Rect)localObject).bottom) {
          break label1322;
        }
        i = 1;
        label971:
        if (i != 0) {
          this.YmP.setVisibility(0);
        }
      }
      label983:
      if ((this.ODZ != null) && (this.YmQ != null)) {
        this.YmQ.alc.notifyChanged();
      }
      if (this.YmR != null) {
        this.YmR.alc.notifyChanged();
      }
      if (Build.VERSION.SDK_INT >= 21) {
        this.pMz.getWindow().addFlags(-2147483648);
      }
      if (this.AUA) {
        haF();
      }
      if (this.pMF) {
        this.pMz.getWindow().addFlags(1024);
      }
      if (!this.pMG) {
        break label1341;
      }
      this.pMz.getWindow().setFlags(8, 8);
      this.pMz.getWindow().addFlags(131200);
      this.pMz.getWindow().getDecorView().setSystemUiVisibility(4102);
    }
    for (;;)
    {
      if (this.pMC != null) {
        this.pMC.bxz = false;
      }
      if (this.XbB != null) {
        this.pMz.setOnDismissListener(new DialogInterface.OnDismissListener()
        {
          public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(250043);
            if (!e.y(e.this)) {
              e.this.XbB.onDismiss();
            }
            AppMethodBeat.o(250043);
          }
        });
      }
      this.pMz.setOnShowListener(new DialogInterface.OnShowListener()
      {
        public final void onShow(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(249547);
          if ((e.this.Ymw != null) && (!e.y(e.this))) {
            e.this.Ymw.onShow();
          }
          AppMethodBeat.o(249547);
        }
      });
      if (this.lJ != null)
      {
        i = j;
        if (this.lS == null) {
          i = 1;
        }
        this.lS = this.lJ.getViewTreeObserver();
        if (i != 0) {
          this.lS.addOnGlobalLayoutListener(this);
        }
      }
      if (((this.mContext instanceof Activity)) && (!((Activity)this.mContext).isFinishing())) {
        this.pMz.show();
      }
      AppMethodBeat.o(159362);
      return;
      label1256:
      if (isLandscape())
      {
        this.YmV.setPadding(0, this.YmV.getPaddingTop(), this.YmV.getPaddingRight(), m);
        break;
      }
      this.YmV.setPadding(0, this.YmV.getPaddingTop(), this.YmV.getPaddingRight(), this.YmV.getPaddingBottom());
      break;
      label1322:
      i = 0;
      break label971;
      label1327:
      this.mRecyclerView.setPadding(0, 0, 0, 0);
      break label983;
      label1341:
      this.pMz.getWindow().clearFlags(8);
      this.pMz.getWindow().clearFlags(131072);
      this.pMz.getWindow().clearFlags(128);
      this.pMz.getWindow().getDecorView().setSystemUiVisibility(0);
    }
  }
  
  public final void gIa()
  {
    AppMethodBeat.i(159363);
    if (this.pMz != null)
    {
      if ((this.ODZ != null) && (this.YmQ != null)) {
        this.YmQ.alc.notifyChanged();
      }
      if (this.YmR != null) {
        this.YmR.alc.notifyChanged();
      }
      this.pMz.setOnShowListener(new DialogInterface.OnShowListener()
      {
        public final void onShow(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(250133);
          if ((e.this.Ymw != null) && (!e.y(e.this))) {
            e.this.Ymw.onShow();
          }
          AppMethodBeat.o(250133);
        }
      });
      this.pMz.show();
    }
    AppMethodBeat.o(159363);
  }
  
  public final Window getWindow()
  {
    AppMethodBeat.i(250438);
    if (this.pMz != null)
    {
      Window localWindow = this.pMz.getWindow();
      AppMethodBeat.o(250438);
      return localWindow;
    }
    AppMethodBeat.o(250438);
    return null;
  }
  
  public final void icA()
  {
    this.HBs = true;
  }
  
  public final void icC()
  {
    AppMethodBeat.i(250445);
    if ((this.pMz != null) && (this.pMz.getWindow() != null)) {
      this.pMz.getWindow().setDimAmount(0.0F);
    }
    AppMethodBeat.o(250445);
  }
  
  public final int icv()
  {
    return this.bottomSheetStyle;
  }
  
  public final boolean icw()
  {
    return this.AUA;
  }
  
  public final boolean icx()
  {
    return this.pMG;
  }
  
  public final e icy()
  {
    AppMethodBeat.i(250426);
    this.OEz = true;
    if (this.oFW != null)
    {
      if (!this.OEz) {
        break label113;
      }
      if (this.bottomSheetStyle != 0) {
        break label100;
      }
      this.oFW.setBackgroundResource(a.e.up_corner_grey_dark_bg);
      this.AUE.setBackgroundColor(this.mContext.getResources().getColor(a.c.Dark_1));
      this.AUF.setTextColor(this.mContext.getResources().getColor(a.c.BW_100_Alpha_0_8));
      this.AUF.setBackgroundResource(a.e.dark_list_item_selector);
    }
    for (;;)
    {
      AppMethodBeat.o(250426);
      return this;
      label100:
      this.oFW.setBackgroundResource(a.e.up_corner_dark_bg);
      break;
      label113:
      this.oFW.setBackgroundResource(a.e.up_corner_white_bg);
    }
  }
  
  public final void icz()
  {
    this.Ynb = true;
  }
  
  public final boolean isHideStatusBar()
  {
    return this.pMF;
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(159365);
    if ((this.pMz != null) && (this.pMz.isShowing()))
    {
      AppMethodBeat.o(159365);
      return true;
    }
    AppMethodBeat.o(159365);
    return false;
  }
  
  public final void j(CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(250424);
    if ((this.OEr != null) && (this.Hfz))
    {
      this.OEr.setVisibility(0);
      this.OEr.removeAllViews();
      this.OEr.setGravity(paramInt1);
      View localView = LayoutInflater.from(this.mContext).inflate(a.g.mm_bottom_sheet_title_text, null);
      TextView localTextView = (TextView)localView.findViewById(a.f.title_text);
      ImageView localImageView = (ImageView)localView.findViewById(a.f.divider);
      if (this.YmT) {
        localImageView.setVisibility(0);
      }
      localTextView.setText(paramCharSequence);
      if (paramInt2 != 0) {
        localTextView.setTextSize(0, paramInt2);
      }
      localTextView.setGravity(paramInt1 | 0x50);
      if (this.OEz)
      {
        localTextView.setTextColor(this.mContext.getResources().getColor(a.c.BW_100_Alpha_0_8));
        localImageView.setBackgroundColor(this.mContext.getResources().getColor(a.c.BW_100_Alpha_0_0_5));
      }
      this.OEr.addView(localView, -1, -2);
    }
    AppMethodBeat.o(250424);
  }
  
  public void onGlobalLayout()
  {
    AppMethodBeat.i(159353);
    if (isShowing())
    {
      View localView = this.lJ;
      if ((localView == null) || ((!localView.isShown()) && (localView.getVisibility() != 0)))
      {
        bYF();
        AppMethodBeat.o(159353);
        return;
      }
      if ((isShowing()) && ((this.pMD != isLandscape()) || (this.pME != getRotation()))) {
        bYF();
      }
    }
    AppMethodBeat.o(159353);
  }
  
  public final void q(CharSequence paramCharSequence, int paramInt)
  {
    AppMethodBeat.i(292994);
    j(paramCharSequence, paramInt, 0);
    AppMethodBeat.o(292994);
  }
  
  public final void rn(boolean paramBoolean)
  {
    AppMethodBeat.i(250425);
    if (this.AUD == null)
    {
      AppMethodBeat.o(250425);
      return;
    }
    if (paramBoolean)
    {
      this.AUD.setVisibility(8);
      AppMethodBeat.o(250425);
      return;
    }
    this.AUD.setVisibility(0);
    AppMethodBeat.o(250425);
  }
  
  public final void setBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(159360);
    if (this.oFW != null) {
      this.oFW.setBackgroundColor(paramInt);
    }
    this.YmM = Boolean.valueOf(au.auk(paramInt));
    if ((this.YmM.booleanValue()) && (this.YmW != null)) {
      this.YmW.setImageDrawable(this.mContext.getResources().getDrawable(a.c.dark_bg_line_color));
    }
    AppMethodBeat.o(159360);
  }
  
  public final void setFooterView(View paramView)
  {
    AppMethodBeat.i(159358);
    if (this.OEs != null)
    {
      if (paramView == null)
      {
        this.OEs.setVisibility(8);
        AppMethodBeat.o(159358);
        return;
      }
      this.OEs.setVisibility(0);
      this.OEs.removeAllViews();
      this.OEs.setGravity(17);
      this.OEs.addView(paramView, -1, -2);
    }
    AppMethodBeat.o(159358);
  }
  
  public final void setTitleView(View paramView)
  {
    AppMethodBeat.i(292993);
    Z(paramView, false);
    AppMethodBeat.o(292993);
  }
  
  public static abstract interface c
  {
    public abstract void onShow();
  }
  
  final class d
    extends RecyclerView.l
  {
    private d() {}
    
    private void A(RecyclerView paramRecyclerView)
    {
      AppMethodBeat.i(251467);
      paramRecyclerView = paramRecyclerView.getLayoutManager();
      if (!(paramRecyclerView instanceof LinearLayoutManager))
      {
        AppMethodBeat.o(251467);
        return;
      }
      paramRecyclerView = (LinearLayoutManager)paramRecyclerView;
      int i = paramRecyclerView.kJ();
      int j = paramRecyclerView.kL();
      if (i <= j)
      {
        Object localObject = ayo(i);
        if (localObject == null) {
          if ((i == e.e(e.this).size() + e.g(e.this).size()) && (e.T(e.this) != null)) {
            e.T(e.this).cR(paramRecyclerView.findViewByPosition(i));
          }
        }
        for (;;)
        {
          i += 1;
          break;
          localObject = ((p)localObject).WkY;
          if (localObject != null) {
            ((q.h)localObject).cR(paramRecyclerView.findViewByPosition(i));
          }
        }
      }
      AppMethodBeat.o(251467);
    }
    
    private p ayo(int paramInt)
    {
      AppMethodBeat.i(251468);
      if (paramInt < 0)
      {
        AppMethodBeat.o(251468);
        return null;
      }
      p localp;
      if (paramInt < e.e(e.this).size())
      {
        localp = (p)e.e(e.this).WkP.get(paramInt);
        AppMethodBeat.o(251468);
        return localp;
      }
      if ((e.g(e.this).size() > 0) && (paramInt < e.e(e.this).size() + e.g(e.this).size()))
      {
        localp = (p)e.g(e.this).getItem(paramInt - e.e(e.this).size());
        AppMethodBeat.o(251468);
        return localp;
      }
      AppMethodBeat.o(251468);
      return null;
    }
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(251463);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt);
      a.c("com/tencent/mm/ui/widget/dialog/MMBottomSheet$MenuItemVisibleHelper", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aFi());
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      A(paramRecyclerView);
      a.a(this, "com/tencent/mm/ui/widget/dialog/MMBottomSheet$MenuItemVisibleHelper", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(251463);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(251465);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramRecyclerView);
      localb.sg(paramInt1);
      localb.sg(paramInt2);
      a.c("com/tencent/mm/ui/widget/dialog/MMBottomSheet$MenuItemVisibleHelper", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aFi());
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      A(paramRecyclerView);
      a.a(this, "com/tencent/mm/ui/widget/dialog/MMBottomSheet$MenuItemVisibleHelper", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(251465);
    }
  }
  
  public final class f
    extends RecyclerView.a<e.f.a>
  {
    o OEf;
    private final boolean Yno;
    AdapterView.OnItemClickListener tp;
    
    public f(boolean paramBoolean)
    {
      this.Yno = paramBoolean;
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(159348);
      int j = this.OEf.size();
      int i;
      if (this.Yno)
      {
        i = j;
        if (e.K(e.this)) {}
      }
      else
      {
        i = j + e.g(e.this).size();
      }
      j = i;
      if (e.N(e.this)) {
        if (this.Yno)
        {
          j = i;
          if (e.K(e.this)) {}
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
      AppMethodBeat.i(251278);
      if ((paramInt >= 0) && (paramInt < this.OEf.size()))
      {
        MenuItem localMenuItem = this.OEf.getItem(paramInt);
        if (((localMenuItem instanceof p)) && (!((p)localMenuItem).WkT))
        {
          AppMethodBeat.o(251278);
          return 1;
        }
      }
      else
      {
        if ((e.g(e.this).size() > 0) && (paramInt < this.OEf.size() + e.g(e.this).size()))
        {
          AppMethodBeat.o(251278);
          return 2;
        }
        if ((e.N(e.this)) && (paramInt == this.OEf.size() + e.g(e.this).size()))
        {
          AppMethodBeat.o(251278);
          return 3;
        }
      }
      AppMethodBeat.o(251278);
      return 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.a.e
 * JD-Core Version:    0.7.0.1
 */