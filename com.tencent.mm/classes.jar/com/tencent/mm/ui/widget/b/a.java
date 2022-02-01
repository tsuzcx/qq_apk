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
import com.tencent.mm.cr.a.c;
import com.tencent.mm.cr.a.d;
import com.tencent.mm.cr.a.e;
import com.tencent.mm.cr.a.f;
import com.tencent.mm.cr.a.g;
import com.tencent.mm.cr.a.j;
import com.tencent.mm.ui.av;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.MMListPopupWindow;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.base.q.e;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.r;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Iterator;
import java.util.List;

public class a
  implements View.OnKeyListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener
{
  private static boolean ACA = false;
  private static int nmj;
  private static int nmk;
  private View ExE;
  public q.g ODU;
  private o ODY;
  private MMListPopupWindow WyB;
  public PopupWindow.OnDismissListener XVa;
  private View XcB;
  private b YqY;
  private r YqZ;
  private r Yra;
  private int Yrb;
  private DisplayMetrics Yrc;
  private boolean Yrd;
  public View Yre;
  public View.OnCreateContextMenuListener Yrf;
  public q.e Yrg;
  public boolean Yrh;
  public boolean Yri;
  public boolean Yrj;
  public boolean Yrk;
  public boolean Yrl;
  private boolean Yrm;
  private boolean Yrn;
  private int Yro;
  public a.a Yrp;
  public boolean Yrq;
  public boolean Yrr;
  private Context mContext;
  private LayoutInflater mInflater;
  public long startTime;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(159475);
    this.mContext = null;
    this.XcB = null;
    this.YqY = null;
    this.Yrd = false;
    this.Yrh = false;
    this.Yri = false;
    this.Yrj = false;
    this.Yrk = false;
    this.Yrl = true;
    this.Yrm = true;
    this.Yrn = false;
    this.Yro = 0;
    this.startTime = 0L;
    this.Yrq = true;
    this.Yrr = false;
    this.mContext = paramContext;
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    initView();
    AppMethodBeat.o(159475);
  }
  
  public a(Context paramContext, View paramView)
  {
    AppMethodBeat.i(159474);
    this.mContext = null;
    this.XcB = null;
    this.YqY = null;
    this.Yrd = false;
    this.Yrh = false;
    this.Yri = false;
    this.Yrj = false;
    this.Yrk = false;
    this.Yrl = true;
    this.Yrm = true;
    this.Yrn = false;
    this.Yro = 0;
    this.startTime = 0L;
    this.Yrq = true;
    this.Yrr = false;
    this.mContext = paramContext;
    this.XcB = paramView;
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    initView();
    idl();
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
  
  private boolean idi()
  {
    AppMethodBeat.i(159482);
    if ((this.YqZ != null) && (this.YqZ.isShowing()))
    {
      AppMethodBeat.o(159482);
      return true;
    }
    AppMethodBeat.o(159482);
    return false;
  }
  
  private void idl()
  {
    AppMethodBeat.i(159486);
    this.XcB.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(251423);
        switch (paramAnonymousMotionEvent.getAction() & 0xFF)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(251423);
          return false;
          a.ayH((int)paramAnonymousMotionEvent.getRawX());
          a.GN((int)paramAnonymousMotionEvent.getRawY());
          a.b(a.this, a.f(a.this));
          a.afi();
          av.i("MicroMsg.MMPopupMenu", "popmenu view set , x_down=" + a.abk() + "y_down=" + a.bru(), new Object[0]);
        }
      }
    });
    AppMethodBeat.o(159486);
  }
  
  private void initView()
  {
    AppMethodBeat.i(159485);
    cFD();
    this.ODY = new o(this.mContext);
    this.YqY = new b((byte)0);
    this.Yrc = this.mContext.getResources().getDisplayMetrics();
    AppMethodBeat.o(159485);
  }
  
  private boolean mZ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159479);
    if ((isShowing()) || (idi()) || (idj()))
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
      av.w("MicroMsg.MMPopupMenu", "is swiping, PASS tryShow", new Object[0]);
      AppMethodBeat.o(159479);
      return false;
    }
    if ((this.Yri) && (this.Yrg != null)) {
      this.Yrg.a(this.ODY, this.XcB);
    }
    int k;
    for (;;)
    {
      k = this.YqY.getCount() * this.mContext.getResources().getDimensionPixelSize(a.d.SmallListHeight);
      if ((k != 0) || (this.Yrh) || (this.Yri)) {
        break;
      }
      AppMethodBeat.o(159479);
      return false;
      if (this.Yrf != null) {
        this.Yrf.onCreateContextMenu(this.ODY, this.XcB, null);
      }
    }
    int m = this.mContext.getResources().getDimensionPixelSize(a.d.edgePadding);
    i = c(this.YqY);
    int j = aw.aZ(this.mContext, a.d.minMenuWidth);
    if (i < j)
    {
      i = j;
      if (this.ODY.size() < 3) {
        break label742;
      }
    }
    label321:
    label356:
    label742:
    for (boolean bool = false;; bool = true)
    {
      if (!this.Yrd)
      {
        if (this.Yre != null) {
          this.Yre.setSelected(true);
        }
      }
      else
      {
        if (!this.Yrh) {
          break label356;
        }
        na(paramInt1, paramInt2);
      }
      for (;;)
      {
        AppMethodBeat.o(159479);
        return true;
        break;
        this.XcB.setSelected(true);
        break label321;
        if (this.Yri)
        {
          nb(paramInt1, paramInt2);
        }
        else
        {
          localObject = b.a(this.mContext, i, paramInt1, paramInt2, k, m, bool);
          this.Yrb = (paramInt2 - this.mContext.getResources().getDimensionPixelSize(a.d.edgePadding));
          av.d("MicroMsg.MMPopupMenu", "showPointY=" + paramInt2 + "verticalOffset=" + this.Yrb, new Object[0]);
          this.WyB = new MMListPopupWindow(this.mContext, null, 0);
          this.WyB.setOnDismissListener(this);
          this.WyB.tp = new AdapterView.OnItemClickListener()
          {
            public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
            {
              AppMethodBeat.i(252360);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bn(paramAnonymousAdapterView);
              localb.bn(paramAnonymousView);
              localb.sg(paramAnonymousInt);
              localb.Fs(paramAnonymousLong);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/menu/MMPopupMenu$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
              if (a.b(a.this) != null) {
                a.b(a.this).onMMMenuItemSelected(a.a(a.this).getItem(paramAnonymousInt), paramAnonymousInt);
              }
              if ((a.c(a.this) != null) && (a.c(a.this).nmy.isShowing())) {
                a.c(a.this).dismiss();
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/menu/MMPopupMenu$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(252360);
            }
          };
          this.WyB.setAdapter(this.YqY);
          this.WyB.P(this.Yrq);
          this.WyB.th = this.Yrr;
          this.WyB.setBackgroundDrawable(this.mContext.getResources().getDrawable(a.e.sub_menu_bg));
          this.WyB.ax(((b.a)localObject).Yrv);
          this.WyB.ta = ((b.a)localObject).rzP;
          this.WyB.ah(((b.a)localObject).LfM);
          this.WyB.tl = this.XcB;
          this.WyB.setContentWidth(i);
          this.WyB.dN();
          if ((!(this.mContext instanceof Activity)) || (((Activity)this.mContext).isFinishing())) {
            break label734;
          }
          this.WyB.show();
          this.WyB.WkJ.setOnKeyListener(this);
          this.WyB.WkJ.setDivider(new ColorDrawable(this.mContext.getResources().getColor(a.c.small_line_color)));
          this.WyB.WkJ.setSelector(this.mContext.getResources().getDrawable(a.e.popup_menu_selector));
          this.WyB.WkJ.setDividerHeight(0);
          this.WyB.WkJ.setVerticalScrollBarEnabled(false);
          this.WyB.WkJ.setHorizontalScrollBarEnabled(false);
        }
      }
      AppMethodBeat.o(159479);
      return false;
    }
  }
  
  private void na(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159480);
    int j = this.mContext.getResources().getDimensionPixelOffset(a.d.NormalPadding);
    int k = this.mContext.getResources().getDimensionPixelOffset(a.d.LargePadding);
    this.YqZ = new r(this.mContext);
    this.YqZ.setOnDismissListener(this);
    this.YqZ.setWidth(-2);
    this.YqZ.setHeight(-2);
    this.YqZ.setBackgroundDrawable(this.mContext.getResources().getDrawable(a.e.sub_menu_bg));
    this.YqZ.setFocusable(this.Yrj);
    this.YqZ.setOutsideTouchable(this.Yrk);
    LinearLayout localLinearLayout = new LinearLayout(this.mContext);
    localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    localLinearLayout.setOrientation(0);
    localLinearLayout.setBackgroundColor(this.mContext.getResources().getColor(a.c.BG_5));
    final int i = 0;
    if (i < this.ODY.size())
    {
      TextView localTextView = (TextView)this.mInflater.inflate(a.g.horizontal_popup_item, null, false);
      localTextView.setBackgroundResource(a.e.popup_menu_selector);
      if (i == 0) {
        localTextView.setPadding(k, 0, j, 0);
      }
      for (;;)
      {
        localTextView.setText(((MenuItem)this.ODY.WkP.get(i)).getTitle());
        localTextView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(250610);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bn(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/menu/MMPopupMenu$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
            if (a.b(a.this) != null) {
              a.b(a.this).onMMMenuItemSelected(a.a(a.this).getItem(i), i);
            }
            a.d(a.this).dismiss();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/menu/MMPopupMenu$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(250610);
          }
        });
        localLinearLayout.addView(localTextView);
        i += 1;
        break;
        if (i == this.ODY.size() - 1) {
          localTextView.setPadding(j, 0, k, 0);
        }
      }
    }
    localLinearLayout.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    i = localLinearLayout.getMeasuredHeight();
    this.YqZ.setWidth(localLinearLayout.getMeasuredWidth() + aw.fromDPToPix(this.mContext, 24));
    this.YqZ.setContentView(localLinearLayout);
    if (((this.mContext instanceof Activity)) && (!((Activity)this.mContext).isFinishing())) {
      this.YqZ.showAtLocation(this.XcB, 0, paramInt1, paramInt2 - i);
    }
    AppMethodBeat.o(159480);
  }
  
  private void nb(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(249989);
    this.Yra = new r(this.mContext);
    this.Yra.setOnDismissListener(this);
    this.Yra.setWidth(-2);
    this.Yra.setHeight(-2);
    this.Yra.setFocusable(this.Yrl);
    this.Yra.setOutsideTouchable(true);
    this.Yra.setAnimationStyle(a.j.PopCenterAnimation);
    this.Yra.setInputMethodMode(2);
    View localView = View.inflate(this.mContext, a.g.grid_popup_layout, null);
    localView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    LinearLayout localLinearLayout1 = (LinearLayout)localView.findViewById(a.f.menu_line_one);
    LinearLayout localLinearLayout2 = (LinearLayout)localView.findViewById(a.f.menu_line_two);
    Object localObject = localView.findViewById(a.f.menu_divider);
    ImageView localImageView1 = (ImageView)localView.findViewById(a.f.cursor_iv);
    ImageView localImageView2 = (ImageView)localView.findViewById(a.f.cursor_iv_top);
    localLinearLayout1.setVisibility(0);
    localLinearLayout1.removeAllViews();
    if (this.ODY.size() > 5)
    {
      localLinearLayout2.setVisibility(0);
      localLinearLayout2.removeAllViews();
      ((View)localObject).setVisibility(0);
    }
    label416:
    label425:
    label853:
    label856:
    label859:
    for (;;)
    {
      final int i = 0;
      for (;;)
      {
        if (i < this.ODY.size())
        {
          localObject = null;
          if (this.Yrp != null) {
            localObject = this.Yrp.a(this.mContext, (MenuItem)this.ODY.WkP.get(i));
          }
          if (localObject != null) {
            break label853;
          }
          localObject = View.inflate(this.mContext, a.g.pop_grid_menu_item, null);
          WeImageView localWeImageView = (WeImageView)((View)localObject).findViewById(a.f.icon);
          TextView localTextView = (TextView)((View)localObject).findViewById(a.f.title);
          localWeImageView.setImageDrawable(((MenuItem)this.ODY.WkP.get(i)).getIcon());
          localTextView.setText(((MenuItem)this.ODY.WkP.get(i)).getTitle());
          label364:
          ((View)localObject).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(252019);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/menu/MMPopupMenu$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
              if (a.b(a.this) != null) {
                a.b(a.this).onMMMenuItemSelected(a.a(a.this).getItem(i), i);
              }
              a.e(a.this).dismiss();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/menu/MMPopupMenu$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(252019);
            }
          });
          if (((p)this.ODY.WkP.get(i)).WkW)
          {
            if (localLinearLayout2.getChildCount() < 5) {
              localLinearLayout2.addView((View)localObject);
            }
            i += 1;
            continue;
            i = 0;
            if (i >= this.ODY.size()) {
              break label856;
            }
            if (!((p)this.ODY.getItem(i)).WkW) {
              break;
            }
          }
        }
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label859;
        }
        localLinearLayout2.setVisibility(0);
        localLinearLayout2.removeAllViews();
        ((View)localObject).setVisibility(0);
        break;
        i += 1;
        break label425;
        if (localLinearLayout1.getChildCount() < 5)
        {
          localLinearLayout1.addView((View)localObject);
          break label416;
        }
        if (localLinearLayout2.getChildCount() >= 5) {
          break label416;
        }
        localLinearLayout2.addView((View)localObject);
        break label416;
        this.Yra.setContentView(localView);
        localView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int m = localView.getMeasuredHeight();
        i = localView.getMeasuredWidth();
        int j = aw.fromDPToPix(this.mContext, 12);
        int k = paramInt1 - (int)(i / 2.0F);
        if (k + i > this.Yrc.widthPixels - j)
        {
          i = this.Yrc.widthPixels - j - i;
          j = paramInt2 - m - aw.aZ(this.mContext, a.d.Edge_0_5_A);
          if (j >= 0) {
            break label799;
          }
          j = this.XcB.getHeight();
          paramInt2 = aw.aZ(this.mContext, a.d.Edge_0_5_A) + (j + paramInt2);
          localImageView2.setVisibility(0);
          localImageView1.setVisibility(8);
          localObject = (LinearLayout.LayoutParams)localImageView2.getLayoutParams();
          ((LinearLayout.LayoutParams)localObject).leftMargin = (paramInt1 - i - aw.fromDPToPix(this.mContext, 7));
          localImageView2.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        for (paramInt1 = paramInt2;; paramInt1 = j)
        {
          if (this.ODY.size() == 0)
          {
            localImageView1.setVisibility(8);
            localImageView2.setVisibility(8);
          }
          if (((this.mContext instanceof Activity)) && (!((Activity)this.mContext).isFinishing()))
          {
            this.Yra.showAtLocation(this.XcB, 0, i, paramInt1);
            this.startTime = System.currentTimeMillis();
          }
          AppMethodBeat.o(249989);
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
          ((LinearLayout.LayoutParams)localObject).leftMargin = (paramInt1 - i - aw.fromDPToPix(this.mContext, 7));
          localImageView1.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        break label364;
      }
    }
  }
  
  public final void a(View.OnCreateContextMenuListener paramOnCreateContextMenuListener)
  {
    this.Yrf = paramOnCreateContextMenuListener;
  }
  
  public final void a(View paramView, int paramInt1, long paramLong, View.OnCreateContextMenuListener paramOnCreateContextMenuListener, q.g paramg, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(159477);
    this.ODU = paramg;
    this.XcB = paramView;
    idl();
    this.ODY.clear();
    paramg = new AdapterView.AdapterContextMenuInfo(paramView, paramInt1, paramLong);
    paramOnCreateContextMenuListener.onCreateContextMenu(this.ODY, paramView, paramg);
    paramView = this.ODY.WkP.iterator();
    while (paramView.hasNext()) {
      ((p)paramView.next()).WkU = paramg;
    }
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      eY(0, 0);
      AppMethodBeat.o(159477);
      return;
    }
    eY(paramInt2, paramInt3);
    AppMethodBeat.o(159477);
  }
  
  public final void a(View paramView, View.OnCreateContextMenuListener paramOnCreateContextMenuListener, q.g paramg, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159478);
    this.ODU = paramg;
    this.XcB = paramView;
    if ((!(paramView instanceof TextView)) && ((paramInt1 == 0) || (paramInt2 == 0))) {
      idl();
    }
    this.ODY.clear();
    paramOnCreateContextMenuListener.onCreateContextMenu(this.ODY, paramView, null);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      eY(0, 0);
      AppMethodBeat.o(159478);
      return;
    }
    eY(paramInt1, paramInt2);
    AppMethodBeat.o(159478);
  }
  
  public final void a(final View paramView, final q.e parame, q.g paramg)
  {
    AppMethodBeat.i(249981);
    this.XcB = paramView;
    idl();
    this.ODU = paramg;
    if ((paramView instanceof AbsListView))
    {
      av.v("MicroMsg.MMPopupMenu", "registerForPopupMenu AbsListView", new Object[0]);
      ((AbsListView)paramView).setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(251408);
          a.a(a.this).clear();
          av.v("MicroMsg.MMPopupMenu", "registerForPopupMenu AbsListView long click", new Object[0]);
          paramAnonymousAdapterView = new AdapterView.AdapterContextMenuInfo(paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
          parame.a(a.a(a.this), paramAnonymousView);
          paramAnonymousView = a.a(a.this).WkP.iterator();
          while (paramAnonymousView.hasNext()) {
            ((p)paramAnonymousView.next()).WkU = paramAnonymousAdapterView;
          }
          a.this.eY(0, 0);
          AppMethodBeat.o(251408);
          return true;
        }
      });
      AppMethodBeat.o(249981);
      return;
    }
    av.v("MicroMsg.MMPopupMenu", "registerForPopupMenu normal view", new Object[0]);
    paramView.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(252654);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/menu/MMPopupMenu$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
        av.v("MicroMsg.MMPopupMenu", "registerForPopupMenu normal view long click", new Object[0]);
        a.a(a.this).clear();
        a.a(a.this, paramAnonymousView);
        parame.a(a.a(a.this), paramAnonymousView);
        paramAnonymousView = new int[2];
        paramView.getLocationInWindow(paramAnonymousView);
        int i = paramAnonymousView[0] + (int)(paramView.getWidth() / 2.0F);
        int j = paramAnonymousView[1];
        if ((i == 0) && (j == 0)) {
          a.this.eY(0, 0);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/widget/menu/MMPopupMenu$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(252654);
          return true;
          a.this.eY(i, j);
        }
      }
    });
    AppMethodBeat.o(249981);
  }
  
  public final void a(View paramView, q.e parame, q.g paramg, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(249982);
    this.ODU = paramg;
    this.XcB = paramView;
    if ((!(paramView instanceof TextView)) && ((paramInt1 == 0) || (paramInt2 == 0))) {
      idl();
    }
    this.ODY.clear();
    parame.a(this.ODY, paramView);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      eY(0, 0);
      AppMethodBeat.o(249982);
      return;
    }
    eY(paramInt1, paramInt2);
    AppMethodBeat.o(249982);
  }
  
  public final void a(q.g paramg)
  {
    this.ODU = paramg;
  }
  
  public final void ayF(int paramInt)
  {
    AppMethodBeat.i(249994);
    this.WyB.setBackgroundDrawable(this.mContext.getResources().getDrawable(paramInt));
    AppMethodBeat.o(249994);
  }
  
  public final void ayG(int paramInt)
  {
    this.Yrn = true;
    this.Yro = paramInt;
  }
  
  public final void c(View paramView, final View.OnCreateContextMenuListener paramOnCreateContextMenuListener, q.g paramg)
  {
    AppMethodBeat.i(159476);
    this.XcB = paramView;
    idl();
    this.ODU = paramg;
    if ((paramView instanceof AbsListView))
    {
      av.v("MicroMsg.MMPopupMenu", "registerForPopupMenu AbsListView", new Object[0]);
      ((AbsListView)paramView).setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(159465);
          a.a(a.this).clear();
          av.v("MicroMsg.MMPopupMenu", "registerForPopupMenu AbsListView long click", new Object[0]);
          paramAnonymousAdapterView = new AdapterView.AdapterContextMenuInfo(paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
          paramOnCreateContextMenuListener.onCreateContextMenu(a.a(a.this), paramAnonymousView, paramAnonymousAdapterView);
          paramAnonymousView = a.a(a.this).WkP.iterator();
          while (paramAnonymousView.hasNext()) {
            ((p)paramAnonymousView.next()).WkU = paramAnonymousAdapterView;
          }
          a.this.eY(0, 0);
          AppMethodBeat.o(159465);
          return true;
        }
      });
      AppMethodBeat.o(159476);
      return;
    }
    av.v("MicroMsg.MMPopupMenu", "registerForPopupMenu normal view", new Object[0]);
    paramView.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(159466);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/menu/MMPopupMenu$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
        av.v("MicroMsg.MMPopupMenu", "registerForPopupMenu normal view long click", new Object[0]);
        a.a(a.this).clear();
        a.a(a.this, paramAnonymousView);
        paramOnCreateContextMenuListener.onCreateContextMenu(a.a(a.this), paramAnonymousView, null);
        if ((paramAnonymousView.getTag(a.f.touch_loc) instanceof int[]))
        {
          paramAnonymousView = (int[])paramAnonymousView.getTag(a.f.touch_loc);
          if (paramAnonymousView == null) {
            a.this.eY(0, 0);
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/widget/menu/MMPopupMenu$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(159466);
          return true;
          a.this.eY(paramAnonymousView[0], paramAnonymousView[1]);
          continue;
          a.this.eY(0, 0);
        }
      }
    });
    AppMethodBeat.o(159476);
  }
  
  public boolean cFD()
  {
    AppMethodBeat.i(159483);
    if (isShowing())
    {
      if (this.WyB != null) {
        this.WyB.dismiss();
      }
      AppMethodBeat.o(159483);
      return true;
    }
    if (idi())
    {
      if (this.YqZ != null) {
        this.YqZ.dismiss();
      }
      AppMethodBeat.o(159483);
      return true;
    }
    if (idj())
    {
      if (this.Yra != null) {
        this.Yra.dismiss();
      }
      AppMethodBeat.o(159483);
      return true;
    }
    AppMethodBeat.o(159483);
    return false;
  }
  
  public boolean eY(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159484);
    if (((this.XcB != null) && (!this.XcB.equals(this.ExE))) || ((!ACA) && ((paramInt1 != 0) || (paramInt2 != 0))))
    {
      nmj = paramInt1;
      nmk = paramInt2;
    }
    this.ExE = null;
    int k = nmj;
    int n = nmk;
    ACA = false;
    if (this.Yrc == null) {
      this.Yrc = this.mContext.getResources().getDisplayMetrics();
    }
    int j = k;
    int i;
    int m;
    if (this.XcB != null)
    {
      int[] arrayOfInt = new int[2];
      this.XcB.getLocationOnScreen(arrayOfInt);
      i = k;
      if (k == 0) {
        i = arrayOfInt[0] + this.XcB.getWidth() / 2;
      }
      m = arrayOfInt[1];
      j = arrayOfInt[1] + this.XcB.getHeight();
      k = m;
      if (m < 0) {
        k = 0;
      }
      m = j;
      if (j > this.Yrc.heightPixels) {
        m = this.Yrc.heightPixels;
      }
      j = i;
      if (n != 0) {}
    }
    for (j = (k + m) / 2;; j = k)
    {
      av.i("MicroMsg.MMPopupMenu", "show popMenu , xDown:%s, yDown:%s, showPointX:%s, showPointY:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i), Integer.valueOf(j) });
      if ((!isShowing()) || (!idi()) || (!idj()))
      {
        bool1 = mZ(i, j);
        AppMethodBeat.o(159484);
        return bool1;
      }
      boolean bool1 = cFD();
      boolean bool2 = mZ(i, j);
      AppMethodBeat.o(159484);
      return bool2 & bool1;
      k = n;
      i = j;
    }
  }
  
  public final boolean hTd()
  {
    AppMethodBeat.i(292987);
    boolean bool = eY(0, 0);
    AppMethodBeat.o(292987);
    return bool;
  }
  
  public final boolean idj()
  {
    AppMethodBeat.i(249990);
    if ((this.Yra != null) && (this.Yra.isShowing()))
    {
      AppMethodBeat.o(249990);
      return true;
    }
    AppMethodBeat.o(249990);
    return false;
  }
  
  public final void idk()
  {
    this.Yri = true;
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(159481);
    if ((this.WyB != null) && (this.WyB.nmy.isShowing()))
    {
      AppMethodBeat.o(159481);
      return true;
    }
    AppMethodBeat.o(159481);
    return false;
  }
  
  public void onDismiss()
  {
    AppMethodBeat.i(159488);
    if (!this.Yrd)
    {
      if (this.Yre == null) {
        break label51;
      }
      this.Yre.setSelected(false);
    }
    for (;;)
    {
      if (this.XVa != null) {
        this.XVa.onDismiss();
      }
      AppMethodBeat.o(159488);
      return;
      label51:
      this.XcB.setSelected(false);
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(249993);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramAdapterView);
    localb.bn(paramView);
    localb.sg(paramInt);
    localb.Fs(paramLong);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/menu/MMPopupMenu", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/menu/MMPopupMenu", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(249993);
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(249992);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramView);
    localb.sg(paramInt);
    localb.bn(paramKeyEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/widget/menu/MMPopupMenu", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.aFi());
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/widget/menu/MMPopupMenu", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
    AppMethodBeat.o(249992);
    return false;
  }
  
  public final void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.XVa = paramOnDismissListener;
  }
  
  final class b
    extends BaseAdapter
  {
    private b() {}
    
    private String getItem(int paramInt)
    {
      AppMethodBeat.i(159471);
      String str = (String)((MenuItem)a.a(a.this).WkP.get(paramInt)).getTitle();
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
        paramViewGroup = (TextView)a.g(a.this).inflate(a.g.popup_submenu_item, paramViewGroup, false);
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
        if ((a.h(a.this)) && (a.i(a.this) != 0)) {
          paramViewGroup.setTextColor(a.j(a.this).getResources().getColor(a.i(a.this)));
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