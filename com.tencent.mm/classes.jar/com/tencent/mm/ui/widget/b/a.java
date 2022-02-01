package com.tencent.mm.ui.widget.b;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnKeyListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ck.a.c;
import com.tencent.mm.ck.a.d;
import com.tencent.mm.ck.a.e;
import com.tencent.mm.ck.a.f;
import com.tencent.mm.ck.a.g;
import com.tencent.mm.ck.a.j;
import com.tencent.mm.ui.base.MMListPopupWindow;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.base.u.f;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.base.v;
import com.tencent.mm.ui.bc;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Iterator;
import java.util.List;

public class a
  implements View.OnKeyListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener
{
  private static boolean GfH = false;
  private static int akmm = 5;
  private static int qjs;
  private static int qjt;
  public u.i GAC;
  private View Kqo;
  public s Vtk;
  private View aeMz;
  public MMListPopupWindow aefY;
  public PopupWindow.OnDismissListener afLp;
  public boolean agjA;
  public boolean agjB;
  private boolean agjC;
  public a.a agjF;
  public boolean agjG;
  public boolean agjH;
  private b agjl;
  private v agjm;
  private v agjn;
  private v agjo;
  private int agjp;
  private DisplayMetrics agjq;
  private boolean agjr;
  public View agjs;
  public View.OnCreateContextMenuListener agjt;
  public u.f agju;
  public boolean agjv;
  public boolean agjw;
  public boolean agjx;
  public int agjy;
  public boolean agjz;
  public boolean akil;
  public int akmn;
  public Context mContext;
  private LayoutInflater mInflater;
  public long startTime;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(159475);
    this.mContext = null;
    this.aeMz = null;
    this.agjl = null;
    this.agjr = false;
    this.agjv = false;
    this.agjw = false;
    this.agjx = false;
    this.agjy = 0;
    this.agjz = false;
    this.agjA = false;
    this.agjB = true;
    this.agjC = true;
    this.akmn = 0;
    this.akil = false;
    this.startTime = 0L;
    this.agjG = true;
    this.agjH = false;
    this.mContext = paramContext;
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    initView();
    AppMethodBeat.o(159475);
  }
  
  public a(Context paramContext, View paramView)
  {
    AppMethodBeat.i(159474);
    this.mContext = null;
    this.aeMz = null;
    this.agjl = null;
    this.agjr = false;
    this.agjv = false;
    this.agjw = false;
    this.agjx = false;
    this.agjy = 0;
    this.agjz = false;
    this.agjA = false;
    this.agjB = true;
    this.agjC = true;
    this.akmn = 0;
    this.akil = false;
    this.startTime = 0L;
    this.agjG = true;
    this.agjH = false;
    this.mContext = paramContext;
    this.aeMz = paramView;
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    initView();
    jIw();
    AppMethodBeat.o(159474);
  }
  
  private int c(ListAdapter paramListAdapter)
  {
    AppMethodBeat.i(159487);
    int n = View.MeasureSpec.makeMeasureSpec(0, 0);
    int i1 = View.MeasureSpec.makeMeasureSpec(0, 0);
    int i2 = paramListAdapter.getCount();
    int j = 0;
    int i = 0;
    View localView = null;
    int k = 0;
    int m;
    if (j < i2)
    {
      m = paramListAdapter.getItemViewType(j);
      if (m == i) {
        break label135;
      }
      localView = null;
      i = m;
    }
    label135:
    for (;;)
    {
      localView = paramListAdapter.getView(j, localView, new FrameLayout(this.mContext));
      m = k;
      if (localView != null)
      {
        localView.measure(n, i1);
        m = Math.max(k, localView.getMeasuredWidth());
      }
      j += 1;
      k = m;
      break;
      AppMethodBeat.o(159487);
      return k;
    }
  }
  
  private void initView()
  {
    AppMethodBeat.i(159485);
    diW();
    this.Vtk = new s(this.mContext);
    this.agjl = new b((byte)0);
    this.agjq = this.mContext.getResources().getDisplayMetrics();
    AppMethodBeat.o(159485);
  }
  
  private boolean isShowing()
  {
    AppMethodBeat.i(159481);
    if ((this.aefY != null) && (this.aefY.qjH.isShowing()))
    {
      AppMethodBeat.o(159481);
      return true;
    }
    AppMethodBeat.o(159481);
    return false;
  }
  
  private boolean jIu()
  {
    AppMethodBeat.i(159482);
    if ((this.agjm != null) && (this.agjm.isShowing()))
    {
      AppMethodBeat.o(159482);
      return true;
    }
    AppMethodBeat.o(159482);
    return false;
  }
  
  private void jIw()
  {
    AppMethodBeat.i(159486);
    this.aeMz.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(251898);
        switch (paramAnonymousMotionEvent.getAction() & 0xFF)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(251898);
          return false;
          a.aqz((int)paramAnonymousMotionEvent.getRawX());
          a.Hn((int)paramAnonymousMotionEvent.getRawY());
          a.b(a.this, a.g(a.this));
          a.daN();
          bc.i("MicroMsg.MMPopupMenu", "popmenu view set , x_down=" + a.bPa() + "y_down=" + a.ddn(), new Object[0]);
        }
      }
    });
    AppMethodBeat.o(159486);
  }
  
  public static int kMr()
  {
    return akmm;
  }
  
  private boolean oU(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159479);
    if ((isShowing()) || (jIu()) || (jIv()))
    {
      AppMethodBeat.o(159479);
      return false;
    }
    Object localObject;
    if ((this.mContext instanceof Activity))
    {
      localObject = ((ViewGroup)((Activity)this.mContext).getWindow().getDecorView()).findViewById(16908290);
      if (localObject != null)
      {
        Rect localRect = new Rect();
        ((View)localObject).getGlobalVisibleRect(localRect);
        if (localRect.left <= 0) {}
      }
    }
    for (int i = 1; i != 0; i = 0)
    {
      bc.w("MicroMsg.MMPopupMenu", "is swiping, PASS tryShow", new Object[0]);
      AppMethodBeat.o(159479);
      return false;
    }
    if (((this.agjw) || (this.agjx)) && (this.agju != null)) {
      this.agju.OnCreateContextMMMenu(this.Vtk, this.aeMz, null);
    }
    int k;
    for (;;)
    {
      k = this.agjl.getCount() * this.mContext.getResources().getDimensionPixelSize(a.d.SmallListHeight);
      if ((k != 0) || (this.agjv) || (this.agjw) || (this.agjx)) {
        break;
      }
      AppMethodBeat.o(159479);
      return false;
      if (this.agjt != null) {
        this.agjt.onCreateContextMenu(this.Vtk, this.aeMz, null);
      }
    }
    int m = this.mContext.getResources().getDimensionPixelSize(a.d.edgePadding);
    i = c(this.agjl);
    int j = bd.bs(this.mContext, a.d.minMenuWidth);
    if (i < j)
    {
      i = j;
      if (this.Vtk.size() < 3) {
        break label773;
      }
    }
    label773:
    for (boolean bool = false;; bool = true)
    {
      if (!this.agjr)
      {
        if (this.agjs != null) {
          this.agjs.setSelected(true);
        }
      }
      else
      {
        label336:
        if (!this.agjv) {
          break label371;
        }
        oV(paramInt1, paramInt2);
      }
      for (;;)
      {
        AppMethodBeat.o(159479);
        return true;
        break;
        this.aeMz.setSelected(true);
        break label336;
        label371:
        if (this.agjw)
        {
          oW(paramInt1, paramInt2);
        }
        else if (this.agjx)
        {
          oX(paramInt1, paramInt2);
        }
        else
        {
          localObject = b.a(this.mContext, i, paramInt1, paramInt2, k, m, bool);
          this.agjp = (paramInt2 - this.mContext.getResources().getDimensionPixelSize(a.d.edgePadding));
          bc.d("MicroMsg.MMPopupMenu", "showPointY=" + paramInt2 + "verticalOffset=" + this.agjp, new Object[0]);
          this.aefY = new MMListPopupWindow(this.mContext, null, 0);
          this.aefY.setOnDismissListener(this);
          this.aefY.un = new AdapterView.OnItemClickListener()
          {
            public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
            {
              AppMethodBeat.i(251900);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.cH(paramAnonymousAdapterView);
              localb.cH(paramAnonymousView);
              localb.sc(paramAnonymousInt);
              localb.hB(paramAnonymousLong);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/menu/MMPopupMenu$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
              if (a.b(a.this) != null) {
                a.b(a.this).onMMMenuItemSelected(a.a(a.this).getItem(paramAnonymousInt), paramAnonymousInt);
              }
              if ((a.c(a.this) != null) && (a.c(a.this).qjH.isShowing())) {
                a.c(a.this).dismiss();
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/menu/MMPopupMenu$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(251900);
            }
          };
          this.aefY.setAdapter(this.agjl);
          this.aefY.LA(this.agjG);
          this.aefY.ug = this.agjH;
          this.aefY.setBackgroundDrawable(this.mContext.getResources().getDrawable(a.e.sub_menu_bg));
          this.aefY.aAU(((b.a)localObject).agjL);
          this.aefY.tZ = ((b.a)localObject).uLg;
          this.aefY.ad(((b.a)localObject).CMA);
          this.aefY.ul = this.aeMz;
          this.aefY.setContentWidth(i);
          this.aefY.eN();
          if ((!(this.mContext instanceof Activity)) || (((Activity)this.mContext).isFinishing())) {
            break label765;
          }
          this.aefY.show();
          this.aefY.adRQ.setOnKeyListener(this);
          this.aefY.adRQ.setDivider(new ColorDrawable(this.mContext.getResources().getColor(a.c.small_line_color)));
          this.aefY.adRQ.setSelector(this.mContext.getResources().getDrawable(a.e.popup_menu_selector));
          this.aefY.adRQ.setDividerHeight(0);
          this.aefY.adRQ.setVerticalScrollBarEnabled(false);
          this.aefY.adRQ.setHorizontalScrollBarEnabled(false);
        }
      }
      label765:
      AppMethodBeat.o(159479);
      return false;
    }
  }
  
  private void oV(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159480);
    int j = this.mContext.getResources().getDimensionPixelOffset(a.d.NormalPadding);
    int k = this.mContext.getResources().getDimensionPixelOffset(a.d.LargePadding);
    this.agjm = new v(this.mContext);
    this.agjm.setOnDismissListener(this);
    this.agjm.setWidth(-2);
    this.agjm.setHeight(-2);
    this.agjm.setBackgroundDrawable(this.mContext.getResources().getDrawable(a.e.sub_menu_bg));
    this.agjm.setFocusable(this.agjz);
    this.agjm.setOutsideTouchable(this.agjA);
    LinearLayout localLinearLayout = new LinearLayout(this.mContext);
    localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    localLinearLayout.setOrientation(0);
    localLinearLayout.setBackgroundColor(this.mContext.getResources().getColor(a.c.BG_5));
    final int i = 0;
    if (i < this.Vtk.size())
    {
      TextView localTextView = (TextView)this.mInflater.inflate(a.g.horizontal_popup_item, null, false);
      localTextView.setBackgroundResource(a.e.popup_menu_selector);
      if (i == 0) {
        localTextView.setPadding(k, 0, j, 0);
      }
      for (;;)
      {
        localTextView.setText(((MenuItem)this.Vtk.adRW.get(i)).getTitle());
        localTextView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(251895);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.cH(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/menu/MMPopupMenu$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
            if (a.b(a.this) != null) {
              a.b(a.this).onMMMenuItemSelected(a.a(a.this).getItem(i), i);
            }
            a.d(a.this).dismiss();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/menu/MMPopupMenu$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(251895);
          }
        });
        localLinearLayout.addView(localTextView);
        i += 1;
        break;
        if (i == this.Vtk.size() - 1) {
          localTextView.setPadding(j, 0, k, 0);
        }
      }
    }
    localLinearLayout.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    i = localLinearLayout.getMeasuredHeight();
    this.agjm.setWidth(localLinearLayout.getMeasuredWidth() + bd.fromDPToPix(this.mContext, 24));
    this.agjm.setContentView(localLinearLayout);
    if (((this.mContext instanceof Activity)) && (!((Activity)this.mContext).isFinishing())) {
      this.agjm.showAtLocation(this.aeMz, 0, paramInt1, paramInt2 - i);
    }
    AppMethodBeat.o(159480);
  }
  
  private void oW(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(251972);
    this.agjn = new v(this.mContext);
    this.agjn.setOnDismissListener(this);
    this.agjn.setWidth(-2);
    this.agjn.setHeight(-2);
    this.agjn.setFocusable(this.agjB);
    this.agjn.setOutsideTouchable(true);
    this.agjn.setAnimationStyle(a.j.PopCenterAnimation);
    this.agjn.setInputMethodMode(2);
    View localView = View.inflate(this.mContext, a.g.grid_popup_layout, null);
    localView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    if (this.agjy > 0)
    {
      localObject = (LinearLayout)localView.findViewById(a.f.pop_bubble);
      ((LinearLayout)localObject).setMinimumWidth(this.agjy);
      ((LinearLayout)localObject).setGravity(1);
    }
    LinearLayout localLinearLayout1 = (LinearLayout)localView.findViewById(a.f.menu_line_one);
    LinearLayout localLinearLayout2 = (LinearLayout)localView.findViewById(a.f.menu_line_two);
    Object localObject = localView.findViewById(a.f.menu_divider);
    ImageView localImageView1 = (ImageView)localView.findViewById(a.f.cursor_iv);
    ImageView localImageView2 = (ImageView)localView.findViewById(a.f.cursor_iv_top);
    localLinearLayout1.setVisibility(0);
    localLinearLayout1.removeAllViews();
    if (this.Vtk.size() > akmm)
    {
      localLinearLayout2.setVisibility(0);
      localLinearLayout2.removeAllViews();
      ((View)localObject).setVisibility(0);
    }
    label547:
    label556:
    label988:
    label991:
    label994:
    for (;;)
    {
      final int i = 0;
      int j;
      int k;
      for (;;)
      {
        if (i < this.Vtk.size())
        {
          localObject = null;
          if (this.agjF != null) {
            localObject = this.agjF.a(this.mContext, (MenuItem)this.Vtk.adRW.get(i));
          }
          if (localObject != null) {
            break label988;
          }
          localObject = View.inflate(this.mContext, a.g.pop_grid_menu_item, null);
          WeImageView localWeImageView = (WeImageView)((View)localObject).findViewById(a.f.icon);
          TextView localTextView = (TextView)((View)localObject).findViewById(a.f.title);
          localWeImageView.setImageDrawable(((MenuItem)this.Vtk.adRW.get(i)).getIcon());
          localTextView.setText(((MenuItem)this.Vtk.adRW.get(i)).getTitle());
          if ((this.akil) && ((this.Vtk.adRW.get(i) instanceof t)))
          {
            j = ((t)this.Vtk.adRW.get(i)).iconColor;
            k = ((t)this.Vtk.adRW.get(i)).XXf;
            if (j != 0) {
              localWeImageView.setIconColor(j);
            }
            if (k != 0) {
              localTextView.setTextColor(k);
            }
          }
          label493:
          ((View)localObject).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(251892);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.cH(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/menu/MMPopupMenu$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
              if (a.b(a.this) != null) {
                a.b(a.this).onMMMenuItemSelected(a.a(a.this).getItem(i), i);
              }
              a.e(a.this).dismiss();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/menu/MMPopupMenu$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(251892);
            }
          });
          if (((t)this.Vtk.adRW.get(i)).adSc)
          {
            if (localLinearLayout2.getChildCount() < akmm) {
              localLinearLayout2.addView((View)localObject);
            }
            i += 1;
            continue;
            i = 0;
            if (i >= this.Vtk.size()) {
              break label991;
            }
            if (!((t)this.Vtk.getItem(i)).adSc) {
              break;
            }
          }
        }
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label994;
        }
        localLinearLayout2.setVisibility(0);
        localLinearLayout2.removeAllViews();
        ((View)localObject).setVisibility(0);
        break;
        i += 1;
        break label556;
        if (localLinearLayout1.getChildCount() < akmm)
        {
          localLinearLayout1.addView((View)localObject);
          break label547;
        }
        if (localLinearLayout2.getChildCount() >= akmm) {
          break label547;
        }
        localLinearLayout2.addView((View)localObject);
        break label547;
        this.agjn.setContentView(localView);
        localView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int m = localView.getMeasuredHeight();
        i = localView.getMeasuredWidth();
        j = bd.fromDPToPix(this.mContext, 12);
        k = paramInt1 - (int)(i / 2.0F);
        if (k + i > this.agjq.widthPixels - j)
        {
          i = this.agjq.widthPixels - j - i;
          j = paramInt2 - m - bd.bs(this.mContext, a.d.Edge_0_5_A);
          if (j >= 0) {
            break label934;
          }
          j = this.aeMz.getHeight();
          paramInt2 = bd.bs(this.mContext, a.d.Edge_0_5_A) + (j + paramInt2);
          localImageView2.setVisibility(0);
          localImageView1.setVisibility(8);
          localObject = (LinearLayout.LayoutParams)localImageView2.getLayoutParams();
          ((LinearLayout.LayoutParams)localObject).leftMargin = (paramInt1 - i - bd.fromDPToPix(this.mContext, 7));
          localImageView2.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        for (paramInt1 = paramInt2;; paramInt1 = j)
        {
          if (this.Vtk.size() == 0)
          {
            localImageView1.setVisibility(8);
            localImageView2.setVisibility(8);
          }
          if (((this.mContext instanceof Activity)) && (!((Activity)this.mContext).isFinishing()))
          {
            this.agjn.showAtLocation(this.aeMz, 0, i, paramInt1);
            this.startTime = System.currentTimeMillis();
          }
          AppMethodBeat.o(251972);
          return;
          i = k;
          if (k >= j) {
            break;
          }
          i = j;
          break;
          localImageView2.setVisibility(8);
          localImageView1.setVisibility(0);
          localObject = (LinearLayout.LayoutParams)localImageView1.getLayoutParams();
          ((LinearLayout.LayoutParams)localObject).leftMargin = (paramInt1 - i - bd.fromDPToPix(this.mContext, 7));
          localImageView1.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        break label493;
      }
    }
  }
  
  private void oX(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(251983);
    this.agjo = new v(this.mContext);
    this.agjo.setOnDismissListener(this);
    this.agjo.setWidth(-2);
    this.agjo.setHeight(-2);
    this.agjo.setFocusable(true);
    this.agjo.setOutsideTouchable(true);
    this.agjo.setAnimationStyle(a.j.PopCenterAnimation);
    this.agjo.setInputMethodMode(2);
    View localView = View.inflate(this.mContext, a.g.text_style_popuo_layout, null);
    localView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    LinearLayout localLinearLayout = (LinearLayout)localView.findViewById(a.f.menu_line);
    ImageView localImageView1 = (ImageView)localView.findViewById(a.f.cursor_iv);
    ImageView localImageView2 = (ImageView)localView.findViewById(a.f.cursor_iv_top);
    localLinearLayout.setVisibility(0);
    localLinearLayout.removeAllViews();
    final int i = 0;
    if (i < this.Vtk.size()) {
      if (this.agjF == null) {
        break label634;
      }
    }
    label580:
    label634:
    for (Object localObject1 = this.agjF.a(this.mContext, (MenuItem)this.Vtk.adRW.get(i));; localObject1 = null)
    {
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = View.inflate(this.mContext, a.g.pop_text_menu_item, null);
        ((TextView)((View)localObject2).findViewById(a.f.content_text)).setText(((MenuItem)this.Vtk.adRW.get(i)).getTitle());
      }
      ((View)localObject2).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(251890);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/menu/MMPopupMenu$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (a.b(a.this) != null) {
            a.b(a.this).onMMMenuItemSelected(a.a(a.this).getItem(i), i);
          }
          a.f(a.this).dismiss();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/menu/MMPopupMenu$8", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(251890);
        }
      });
      if (localLinearLayout.getChildCount() < 5) {
        localLinearLayout.addView((View)localObject2);
      }
      i += 1;
      break;
      this.agjo.setContentView(localView);
      localView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
      int m = localView.getMeasuredHeight();
      i = localView.getMeasuredWidth();
      int j = bd.fromDPToPix(this.mContext, 12);
      int k = paramInt1 - (int)(i / 2.0F);
      if (k + i > this.agjq.widthPixels - j)
      {
        i = this.agjq.widthPixels - j - i;
        j = paramInt2 - m - bd.bs(this.mContext, a.d.Edge_0_5_A);
        if (j >= 0) {
          break label580;
        }
        j = this.aeMz.getHeight();
        paramInt2 = bd.bs(this.mContext, a.d.Edge_0_5_A) + (j + paramInt2);
        localImageView2.setVisibility(0);
        localImageView1.setVisibility(8);
        localObject1 = (LinearLayout.LayoutParams)localImageView2.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).leftMargin = (paramInt1 - i - bd.fromDPToPix(this.mContext, 7));
        localImageView2.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
      for (paramInt1 = paramInt2;; paramInt1 = j)
      {
        if (this.Vtk.size() == 0)
        {
          localImageView1.setVisibility(8);
          localImageView2.setVisibility(8);
        }
        if (((this.mContext instanceof Activity)) && (!((Activity)this.mContext).isFinishing()))
        {
          this.agjo.showAtLocation(this.aeMz, 0, i, paramInt1);
          this.startTime = System.currentTimeMillis();
        }
        AppMethodBeat.o(251983);
        return;
        i = k;
        if (k >= j) {
          break;
        }
        i = j;
        break;
        localImageView2.setVisibility(8);
        localImageView1.setVisibility(0);
        localObject1 = (LinearLayout.LayoutParams)localImageView1.getLayoutParams();
        ((LinearLayout.LayoutParams)localObject1).leftMargin = (paramInt1 - i - bd.fromDPToPix(this.mContext, 7));
        localImageView1.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
    }
  }
  
  public final void a(View paramView, int paramInt1, long paramLong, View.OnCreateContextMenuListener paramOnCreateContextMenuListener, u.i parami, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(159477);
    this.GAC = parami;
    this.aeMz = paramView;
    jIw();
    this.Vtk.clear();
    parami = new AdapterView.AdapterContextMenuInfo(paramView, paramInt1, paramLong);
    paramOnCreateContextMenuListener.onCreateContextMenu(this.Vtk, paramView, parami);
    paramView = this.Vtk.adRW.iterator();
    while (paramView.hasNext()) {
      ((t)paramView.next()).adSb = parami;
    }
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      cMz();
      AppMethodBeat.o(159477);
      return;
    }
    fQ(paramInt2, paramInt3);
    AppMethodBeat.o(159477);
  }
  
  public final void a(View paramView, View.OnCreateContextMenuListener paramOnCreateContextMenuListener, u.i parami, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159478);
    this.GAC = parami;
    this.aeMz = paramView;
    if ((!(paramView instanceof TextView)) && ((paramInt1 == 0) || (paramInt2 == 0))) {
      jIw();
    }
    this.Vtk.clear();
    paramOnCreateContextMenuListener.onCreateContextMenu(this.Vtk, paramView, null);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      cMz();
      AppMethodBeat.o(159478);
      return;
    }
    fQ(paramInt1, paramInt2);
    AppMethodBeat.o(159478);
  }
  
  public final void a(final View paramView, final u.f paramf, u.i parami)
  {
    AppMethodBeat.i(252082);
    this.aeMz = paramView;
    jIw();
    this.GAC = parami;
    if ((paramView instanceof AbsListView))
    {
      bc.v("MicroMsg.MMPopupMenu", "registerForPopupMenu AbsListView", new Object[0]);
      ((AbsListView)paramView).setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(251899);
          a.a(a.this).clear();
          bc.v("MicroMsg.MMPopupMenu", "registerForPopupMenu AbsListView long click", new Object[0]);
          paramAnonymousAdapterView = new AdapterView.AdapterContextMenuInfo(paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
          paramf.OnCreateContextMMMenu(a.a(a.this), paramAnonymousView, paramAnonymousAdapterView);
          paramAnonymousView = a.a(a.this).adRW.iterator();
          while (paramAnonymousView.hasNext()) {
            ((t)paramAnonymousView.next()).adSb = paramAnonymousAdapterView;
          }
          a.this.cMz();
          AppMethodBeat.o(251899);
          return true;
        }
      });
      AppMethodBeat.o(252082);
      return;
    }
    bc.v("MicroMsg.MMPopupMenu", "registerForPopupMenu normal view", new Object[0]);
    paramView.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(251902);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/menu/MMPopupMenu$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
        bc.v("MicroMsg.MMPopupMenu", "registerForPopupMenu normal view long click", new Object[0]);
        a.a(a.this).clear();
        a.a(a.this, paramAnonymousView);
        paramf.OnCreateContextMMMenu(a.a(a.this), paramAnonymousView, null);
        paramAnonymousView = new int[2];
        paramView.getLocationInWindow(paramAnonymousView);
        int i = paramAnonymousView[0] + (int)(paramView.getWidth() / 2.0F);
        int j = paramAnonymousView[1];
        if ((i == 0) && (j == 0)) {
          a.this.cMz();
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/widget/menu/MMPopupMenu$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(251902);
          return true;
          a.this.fQ(i, j);
        }
      }
    });
    AppMethodBeat.o(252082);
  }
  
  public final void a(View paramView, u.f paramf, u.i parami, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(252090);
    this.GAC = parami;
    this.aeMz = paramView;
    if ((!(paramView instanceof TextView)) && ((paramInt1 == 0) || (paramInt2 == 0))) {
      jIw();
    }
    this.Vtk.clear();
    paramf.OnCreateContextMMMenu(this.Vtk, paramView, null);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      cMz();
      AppMethodBeat.o(252090);
      return;
    }
    fQ(paramInt1, paramInt2);
    AppMethodBeat.o(252090);
  }
  
  public final void b(View paramView, u.f paramf, u.i parami, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(252095);
    this.GAC = parami;
    this.aeMz = paramView;
    if ((!(paramView instanceof TextView)) && ((paramInt1 == 0) || (paramInt2 == 0))) {
      jIw();
    }
    this.Vtk.clear();
    paramf.OnCreateContextMMMenu(this.Vtk, paramView, null);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      cMz();
      AppMethodBeat.o(252095);
      return;
    }
    fQ(paramInt1, paramInt2);
    AppMethodBeat.o(252095);
  }
  
  public final void c(View paramView, final View.OnCreateContextMenuListener paramOnCreateContextMenuListener, u.i parami)
  {
    AppMethodBeat.i(159476);
    this.aeMz = paramView;
    jIw();
    this.GAC = parami;
    if ((paramView instanceof AbsListView))
    {
      bc.v("MicroMsg.MMPopupMenu", "registerForPopupMenu AbsListView", new Object[0]);
      ((AbsListView)paramView).setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(159465);
          a.a(a.this).clear();
          bc.v("MicroMsg.MMPopupMenu", "registerForPopupMenu AbsListView long click", new Object[0]);
          paramAnonymousAdapterView = new AdapterView.AdapterContextMenuInfo(paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
          paramOnCreateContextMenuListener.onCreateContextMenu(a.a(a.this), paramAnonymousView, paramAnonymousAdapterView);
          paramAnonymousView = a.a(a.this).adRW.iterator();
          while (paramAnonymousView.hasNext()) {
            ((t)paramAnonymousView.next()).adSb = paramAnonymousAdapterView;
          }
          a.this.cMz();
          AppMethodBeat.o(159465);
          return true;
        }
      });
      AppMethodBeat.o(159476);
      return;
    }
    bc.v("MicroMsg.MMPopupMenu", "registerForPopupMenu normal view", new Object[0]);
    paramView.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(159466);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/menu/MMPopupMenu$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
        bc.v("MicroMsg.MMPopupMenu", "registerForPopupMenu normal view long click", new Object[0]);
        a.a(a.this).clear();
        a.a(a.this, paramAnonymousView);
        paramOnCreateContextMenuListener.onCreateContextMenu(a.a(a.this), paramAnonymousView, null);
        if ((paramAnonymousView.getTag(a.f.touch_loc) instanceof int[]))
        {
          paramAnonymousView = (int[])paramAnonymousView.getTag(a.f.touch_loc);
          if (paramAnonymousView == null) {
            a.this.cMz();
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/widget/menu/MMPopupMenu$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(159466);
          return true;
          a.this.fQ(paramAnonymousView[0], paramAnonymousView[1]);
          continue;
          a.this.cMz();
        }
      }
    });
    AppMethodBeat.o(159476);
  }
  
  public boolean cMz()
  {
    AppMethodBeat.i(186016);
    boolean bool = fQ(0, 0);
    AppMethodBeat.o(186016);
    return bool;
  }
  
  public boolean diW()
  {
    AppMethodBeat.i(159483);
    if (isShowing())
    {
      if (this.aefY != null) {
        this.aefY.dismiss();
      }
      AppMethodBeat.o(159483);
      return true;
    }
    if (jIu())
    {
      if (this.agjm != null) {
        this.agjm.dismiss();
      }
      AppMethodBeat.o(159483);
      return true;
    }
    if (jIv())
    {
      if (this.agjn != null) {
        this.agjn.dismiss();
      }
      AppMethodBeat.o(159483);
      return true;
    }
    AppMethodBeat.o(159483);
    return false;
  }
  
  public boolean fQ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159484);
    if (((this.aeMz != null) && (!this.aeMz.equals(this.Kqo))) || ((!GfH) && ((paramInt1 != 0) || (paramInt2 != 0))))
    {
      qjs = paramInt1;
      qjt = paramInt2;
    }
    this.Kqo = null;
    int k = qjs;
    int n = qjt;
    GfH = false;
    if (this.agjq == null) {
      this.agjq = this.mContext.getResources().getDisplayMetrics();
    }
    int j = k;
    int i;
    int m;
    if (this.aeMz != null)
    {
      int[] arrayOfInt = new int[2];
      this.aeMz.getLocationOnScreen(arrayOfInt);
      i = k;
      if (k == 0) {
        i = arrayOfInt[0] + this.aeMz.getWidth() / 2;
      }
      m = arrayOfInt[1];
      j = arrayOfInt[1] + this.aeMz.getHeight();
      k = m;
      if (m < 0) {
        k = 0;
      }
      m = j;
      if (j > this.agjq.heightPixels) {
        m = this.agjq.heightPixels;
      }
      j = i;
      if (n != 0) {}
    }
    for (j = (k + m) / 2;; j = k)
    {
      bc.i("MicroMsg.MMPopupMenu", "show popMenu , xDown:%s, yDown:%s, showPointX:%s, showPointY:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i), Integer.valueOf(j) });
      if ((!isShowing()) || (!jIu()) || (!jIv()))
      {
        bool1 = oU(i, j);
        AppMethodBeat.o(159484);
        return bool1;
      }
      boolean bool1 = diW();
      boolean bool2 = oU(i, j);
      AppMethodBeat.o(159484);
      return bool2 & bool1;
      k = n;
      i = j;
    }
  }
  
  public final boolean jIv()
  {
    AppMethodBeat.i(252102);
    if ((this.agjn != null) && (this.agjn.isShowing()))
    {
      AppMethodBeat.o(252102);
      return true;
    }
    AppMethodBeat.o(252102);
    return false;
  }
  
  public final int kMq()
  {
    AppMethodBeat.i(369640);
    if ((this.agjn != null) && (this.agjn.getContentView() != null))
    {
      View localView = this.agjn.getContentView();
      localView.measure(0, 0);
      int i = localView.getMeasuredHeight();
      AppMethodBeat.o(369640);
      return i;
    }
    AppMethodBeat.o(369640);
    return 0;
  }
  
  public void onDismiss()
  {
    AppMethodBeat.i(159488);
    if (!this.agjr)
    {
      if (this.agjs == null) {
        break label51;
      }
      this.agjs.setSelected(false);
    }
    for (;;)
    {
      if (this.afLp != null) {
        this.afLp.onDismiss();
      }
      AppMethodBeat.o(159488);
      return;
      label51:
      this.aeMz.setSelected(false);
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(252147);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramAdapterView);
    localb.cH(paramView);
    localb.sc(paramInt);
    localb.hB(paramLong);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/menu/MMPopupMenu", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/menu/MMPopupMenu", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(252147);
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(252137);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    localb.sc(paramInt);
    localb.cH(paramKeyEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/menu/MMPopupMenu", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/widget/menu/MMPopupMenu", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
    AppMethodBeat.o(252137);
    return false;
  }
  
  final class b
    extends BaseAdapter
  {
    private b() {}
    
    private String getItem(int paramInt)
    {
      AppMethodBeat.i(159471);
      String str = (String)((MenuItem)a.a(a.this).adRW.get(paramInt)).getTitle();
      AppMethodBeat.o(159471);
      return str;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(159470);
      int i = a.a(a.this).size();
      AppMethodBeat.o(159470);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(159472);
      Object localObject = null;
      if (paramView == null) {
        paramViewGroup = (TextView)a.h(a.this).inflate(a.g.popup_submenu_item, paramViewGroup, false);
      }
      for (;;)
      {
        paramView = getItem(paramInt);
        if (paramViewGroup != null)
        {
          paramViewGroup.setTag(paramView);
          paramViewGroup.setText(paramView);
          paramViewGroup.setBackgroundResource(a.e.popup_menu_selector);
        }
        if ((a.i(a.this)) && (a.j(a.this) != 0)) {
          paramViewGroup.setTextColor(a.k(a.this).getResources().getColor(a.j(a.this)));
        }
        AppMethodBeat.o(159472);
        return paramViewGroup;
        paramViewGroup = localObject;
        if ((paramView instanceof TextView)) {
          paramViewGroup = (TextView)paramView;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.widget.b.a
 * JD-Core Version:    0.7.0.1
 */