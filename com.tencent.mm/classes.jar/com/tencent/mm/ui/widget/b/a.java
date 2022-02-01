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
import com.tencent.mm.ui.ap;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.base.MMListPopupWindow;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Iterator;
import java.util.List;

public class a
  implements View.OnKeyListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener
{
  private static int jwh;
  private static int jwi;
  private static boolean sVK = false;
  private l ECx;
  private MMListPopupWindow JUe;
  private View KuS;
  public n.e LfT;
  public PopupWindow.OnDismissListener LhV;
  private b LwA;
  private o LwB;
  private o LwC;
  private int LwD;
  private boolean LwE;
  public View LwF;
  public View.OnCreateContextMenuListener LwG;
  public n.c LwH;
  public boolean LwI;
  public boolean LwJ;
  public boolean LwK;
  public boolean LwL;
  public boolean LwM;
  private boolean LwN;
  public a LwO;
  public boolean LwP;
  public boolean LwQ;
  private DisplayMetrics cPa;
  private Context mContext;
  private LayoutInflater mInflater;
  public long startTime;
  private View vzt;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(159475);
    this.mContext = null;
    this.KuS = null;
    this.LwA = null;
    this.LwE = false;
    this.LwI = false;
    this.LwJ = false;
    this.LwK = false;
    this.LwL = false;
    this.LwM = true;
    this.LwN = true;
    this.startTime = 0L;
    this.LwP = true;
    this.LwQ = false;
    this.mContext = paramContext;
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    initView();
    AppMethodBeat.o(159475);
  }
  
  public a(Context paramContext, View paramView)
  {
    AppMethodBeat.i(159474);
    this.mContext = null;
    this.KuS = null;
    this.LwA = null;
    this.LwE = false;
    this.LwI = false;
    this.LwJ = false;
    this.LwK = false;
    this.LwL = false;
    this.LwM = true;
    this.LwN = true;
    this.startTime = 0L;
    this.LwP = true;
    this.LwQ = false;
    this.mContext = paramContext;
    this.KuS = paramView;
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    initView();
    fRc();
    AppMethodBeat.o(159474);
  }
  
  private int b(ListAdapter paramListAdapter)
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
  
  private boolean fRa()
  {
    AppMethodBeat.i(159482);
    if ((this.LwB != null) && (this.LwB.isShowing()))
    {
      AppMethodBeat.o(159482);
      return true;
    }
    AppMethodBeat.o(159482);
    return false;
  }
  
  private boolean fRb()
  {
    AppMethodBeat.i(200423);
    if ((this.LwC != null) && (this.LwC.isShowing()))
    {
      AppMethodBeat.o(200423);
      return true;
    }
    AppMethodBeat.o(200423);
    return false;
  }
  
  private void fRc()
  {
    AppMethodBeat.i(159486);
    this.KuS.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(200419);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/menu/MMPopupMenu$8", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
        switch (paramAnonymousMotionEvent.getAction() & 0xFF)
        {
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/widget/menu/MMPopupMenu$8", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(200419);
          return false;
          a.agk((int)paramAnonymousMotionEvent.getRawX());
          a.zC((int)paramAnonymousMotionEvent.getRawY());
          a.b(a.this, a.f(a.this));
          a.Qb();
          ap.i("MicroMsg.MMPopupMenu", "popmenu view set , x_down=" + a.dGm() + "y_down=" + a.bJS(), new Object[0]);
        }
      }
    });
    AppMethodBeat.o(159486);
  }
  
  private void initView()
  {
    AppMethodBeat.i(159485);
    fFi();
    this.ECx = new l(this.mContext);
    this.LwA = new b((byte)0);
    this.cPa = this.mContext.getResources().getDisplayMetrics();
    AppMethodBeat.o(159485);
  }
  
  private boolean isShowing()
  {
    AppMethodBeat.i(159481);
    if ((this.JUe != null) && (this.JUe.jwx.isShowing()))
    {
      AppMethodBeat.o(159481);
      return true;
    }
    AppMethodBeat.o(159481);
    return false;
  }
  
  private boolean ko(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159479);
    if ((isShowing()) || (fRa()) || (fRb()))
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
      ap.w("MicroMsg.MMPopupMenu", "is swiping, PASS tryShow", new Object[0]);
      AppMethodBeat.o(159479);
      return false;
    }
    if ((this.LwJ) && (this.LwH != null)) {
      this.LwH.a(this.ECx, this.KuS);
    }
    int k;
    for (;;)
    {
      k = this.LwA.getCount() * this.mContext.getResources().getDimensionPixelSize(2131165567);
      if ((k != 0) || (this.LwI) || (this.LwJ)) {
        break;
      }
      AppMethodBeat.o(159479);
      return false;
      if (this.LwG != null) {
        this.LwG.onCreateContextMenu(this.ECx, this.KuS, null);
      }
    }
    int m = this.mContext.getResources().getDimensionPixelSize(2131166166);
    i = b(this.LwA);
    int j = aq.ay(this.mContext, 2131166572);
    if (i < j)
    {
      i = j;
      if (this.ECx.size() < 3) {
        break label742;
      }
    }
    label321:
    label356:
    label742:
    for (boolean bool = false;; bool = true)
    {
      if (!this.LwE)
      {
        if (this.LwF != null) {
          this.LwF.setSelected(true);
        }
      }
      else
      {
        if (!this.LwI) {
          break label356;
        }
        kp(paramInt1, paramInt2);
      }
      for (;;)
      {
        AppMethodBeat.o(159479);
        return true;
        break;
        this.KuS.setSelected(true);
        break label321;
        if (this.LwJ)
        {
          kq(paramInt1, paramInt2);
        }
        else
        {
          localObject = b.a(this.mContext, i, paramInt1, paramInt2, k, m, bool);
          this.LwD = (paramInt2 - this.mContext.getResources().getDimensionPixelSize(2131166166));
          ap.d("MicroMsg.MMPopupMenu", "showPointY=" + paramInt2 + "verticalOffset=" + this.LwD, new Object[0]);
          this.JUe = new MMListPopupWindow(this.mContext, null, 0);
          this.JUe.setOnDismissListener(this);
          this.JUe.arf = new AdapterView.OnItemClickListener()
          {
            public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
            {
              AppMethodBeat.i(200416);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousAdapterView);
              localb.bd(paramAnonymousView);
              localb.mu(paramAnonymousInt);
              localb.rl(paramAnonymousLong);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/menu/MMPopupMenu$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
              if (a.b(a.this) != null) {
                a.b(a.this).onMMMenuItemSelected(a.a(a.this).getItem(paramAnonymousInt), paramAnonymousInt);
              }
              if ((a.c(a.this) != null) && (a.c(a.this).jwx.isShowing())) {
                a.c(a.this).dismiss();
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/menu/MMPopupMenu$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(200416);
            }
          };
          this.JUe.setAdapter(this.LwA);
          this.JUe.setModal(this.LwP);
          this.JUe.aqZ = this.LwQ;
          this.JUe.setBackgroundDrawable(this.mContext.getResources().getDrawable(2131234275));
          this.JUe.setAnimationStyle(((b.a)localObject).LwU);
          this.JUe.aqS = ((b.a)localObject).nnL;
          this.JUe.setVerticalOffset(((b.a)localObject).AHL);
          this.JUe.ard = this.KuS;
          this.JUe.setContentWidth(i);
          this.JUe.kw();
          if ((!(this.mContext instanceof Activity)) || (((Activity)this.mContext).isFinishing())) {
            break label734;
          }
          this.JUe.show();
          this.JUe.JGF.setOnKeyListener(this);
          this.JUe.JGF.setDivider(new ColorDrawable(this.mContext.getResources().getColor(2131100886)));
          this.JUe.JGF.setSelector(this.mContext.getResources().getDrawable(2131233634));
          this.JUe.JGF.setDividerHeight(0);
          this.JUe.JGF.setVerticalScrollBarEnabled(false);
          this.JUe.JGF.setHorizontalScrollBarEnabled(false);
        }
      }
      AppMethodBeat.o(159479);
      return false;
    }
  }
  
  private void kp(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159480);
    int j = this.mContext.getResources().getDimensionPixelOffset(2131165516);
    int k = this.mContext.getResources().getDimensionPixelOffset(2131165480);
    this.LwB = new o(this.mContext);
    this.LwB.setOnDismissListener(this);
    this.LwB.setWidth(-2);
    this.LwB.setHeight(-2);
    this.LwB.setBackgroundDrawable(this.mContext.getResources().getDrawable(2131234275));
    this.LwB.setFocusable(this.LwK);
    this.LwB.setOutsideTouchable(this.LwL);
    LinearLayout localLinearLayout = new LinearLayout(this.mContext);
    localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    localLinearLayout.setOrientation(0);
    localLinearLayout.setBackgroundColor(this.mContext.getResources().getColor(2131099653));
    final int i = 0;
    if (i < this.ECx.size())
    {
      TextView localTextView = (TextView)this.mInflater.inflate(2131494456, null, false);
      localTextView.setBackgroundResource(2131233634);
      if (i == 0) {
        localTextView.setPadding(k, 0, j, 0);
      }
      for (;;)
      {
        localTextView.setText(((MenuItem)this.ECx.JGM.get(i)).getTitle());
        localTextView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(200417);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/menu/MMPopupMenu$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            if (a.b(a.this) != null) {
              a.b(a.this).onMMMenuItemSelected(a.a(a.this).getItem(i), i);
            }
            a.d(a.this).dismiss();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/menu/MMPopupMenu$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(200417);
          }
        });
        localLinearLayout.addView(localTextView);
        i += 1;
        break;
        if (i == this.ECx.size() - 1) {
          localTextView.setPadding(j, 0, k, 0);
        }
      }
    }
    localLinearLayout.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    i = localLinearLayout.getMeasuredHeight();
    this.LwB.setWidth(localLinearLayout.getMeasuredWidth() + aq.fromDPToPix(this.mContext, 24));
    this.LwB.setContentView(localLinearLayout);
    if (((this.mContext instanceof Activity)) && (!((Activity)this.mContext).isFinishing())) {
      this.LwB.showAtLocation(this.KuS, 0, paramInt1, paramInt2 - i);
    }
    AppMethodBeat.o(159480);
  }
  
  private void kq(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(200422);
    this.LwC = new o(this.mContext);
    this.LwC.setOnDismissListener(this);
    this.LwC.setWidth(-2);
    this.LwC.setHeight(-2);
    this.LwC.setFocusable(this.LwM);
    this.LwC.setOutsideTouchable(true);
    this.LwC.setAnimationStyle(2131821786);
    this.LwC.setInputMethodMode(2);
    View localView = View.inflate(this.mContext, 2131496410, null);
    localView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    LinearLayout localLinearLayout1 = (LinearLayout)localView.findViewById(2131308152);
    LinearLayout localLinearLayout2 = (LinearLayout)localView.findViewById(2131308153);
    Object localObject1 = localView.findViewById(2131308151);
    ImageView localImageView1 = (ImageView)localView.findViewById(2131308079);
    ImageView localImageView2 = (ImageView)localView.findViewById(2131308080);
    localLinearLayout1.setVisibility(0);
    localLinearLayout1.removeAllViews();
    if (this.ECx.size() > 5)
    {
      localLinearLayout2.setVisibility(0);
      localLinearLayout2.removeAllViews();
      ((View)localObject1).setVisibility(0);
    }
    final int i = 0;
    if (i < this.ECx.size())
    {
      localObject1 = null;
      if (this.LwO != null) {
        localObject1 = this.LwO.a(this.mContext, (MenuItem)this.ECx.JGM.get(i));
      }
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = View.inflate(this.mContext, 2131496418, null);
        localObject1 = (WeImageView)((View)localObject2).findViewById(2131300874);
        TextView localTextView = (TextView)((View)localObject2).findViewById(2131305902);
        ((WeImageView)localObject1).setImageDrawable(((MenuItem)this.ECx.JGM.get(i)).getIcon());
        localTextView.setText(((MenuItem)this.ECx.JGM.get(i)).getTitle());
      }
      ((View)localObject2).setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(200418);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/menu/MMPopupMenu$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (a.b(a.this) != null) {
            a.b(a.this).onMMMenuItemSelected(a.a(a.this).getItem(i), i);
          }
          a.e(a.this).dismiss();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/menu/MMPopupMenu$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(200418);
        }
      });
      if (i < 5) {
        localLinearLayout1.addView((View)localObject2);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((i >= 5) && (i < 10)) {
          localLinearLayout2.addView((View)localObject2);
        }
      }
    }
    this.LwC.setContentView(localView);
    localView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    int m = localView.getMeasuredHeight();
    i = localView.getMeasuredWidth();
    int j = aq.fromDPToPix(this.mContext, 12);
    int k = paramInt1 - (int)(i / 2.0F);
    if (k + i > this.cPa.widthPixels - j)
    {
      i = this.cPa.widthPixels - j - i;
      j = paramInt2 - m - aq.ay(this.mContext, 2131165274);
      if (j >= 0) {
        break label697;
      }
      j = this.KuS.getHeight();
      paramInt2 = aq.ay(this.mContext, 2131165274) + (j + paramInt2);
      localImageView2.setVisibility(0);
      localImageView1.setVisibility(8);
      localObject1 = (LinearLayout.LayoutParams)localImageView2.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject1).leftMargin = (paramInt1 - i - aq.fromDPToPix(this.mContext, 7));
      localImageView2.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
    for (paramInt1 = paramInt2;; paramInt1 = j)
    {
      if (this.ECx.size() == 0)
      {
        localImageView1.setVisibility(8);
        localImageView2.setVisibility(8);
      }
      if (((this.mContext instanceof Activity)) && (!((Activity)this.mContext).isFinishing()))
      {
        this.LwC.showAtLocation(this.KuS, 0, i, paramInt1);
        this.startTime = System.currentTimeMillis();
      }
      AppMethodBeat.o(200422);
      return;
      i = k;
      if (k >= j) {
        break;
      }
      i = j;
      break;
      label697:
      localImageView2.setVisibility(8);
      localImageView1.setVisibility(0);
      localObject1 = (LinearLayout.LayoutParams)localImageView1.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject1).leftMargin = (paramInt1 - i - aq.fromDPToPix(this.mContext, 7));
      localImageView1.setLayoutParams((ViewGroup.LayoutParams)localObject1);
    }
  }
  
  public final void a(View.OnCreateContextMenuListener paramOnCreateContextMenuListener)
  {
    this.LwG = paramOnCreateContextMenuListener;
  }
  
  public final void a(View paramView, int paramInt1, long paramLong, View.OnCreateContextMenuListener paramOnCreateContextMenuListener, n.e parame, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(159477);
    this.LfT = parame;
    this.KuS = paramView;
    fRc();
    this.ECx.clear();
    parame = new AdapterView.AdapterContextMenuInfo(paramView, paramInt1, paramLong);
    paramOnCreateContextMenuListener.onCreateContextMenu(this.ECx, paramView, parame);
    paramView = this.ECx.JGM.iterator();
    while (paramView.hasNext()) {
      ((m)paramView.next()).JGS = parame;
    }
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      el(0, 0);
      AppMethodBeat.o(159477);
      return;
    }
    el(paramInt2, paramInt3);
    AppMethodBeat.o(159477);
  }
  
  public final void a(View paramView, View.OnCreateContextMenuListener paramOnCreateContextMenuListener, n.e parame, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159478);
    this.LfT = parame;
    this.KuS = paramView;
    if ((!(paramView instanceof TextView)) && ((paramInt1 == 0) || (paramInt2 == 0))) {
      fRc();
    }
    this.ECx.clear();
    paramOnCreateContextMenuListener.onCreateContextMenu(this.ECx, paramView, null);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      el(0, 0);
      AppMethodBeat.o(159478);
      return;
    }
    el(paramInt1, paramInt2);
    AppMethodBeat.o(159478);
  }
  
  public final void a(final View paramView, final n.c paramc, n.e parame)
  {
    AppMethodBeat.i(200420);
    this.KuS = paramView;
    fRc();
    this.LfT = parame;
    if ((paramView instanceof AbsListView))
    {
      ap.v("MicroMsg.MMPopupMenu", "registerForPopupMenu AbsListView", new Object[0]);
      ((AbsListView)paramView).setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(200414);
          a.a(a.this).clear();
          ap.v("MicroMsg.MMPopupMenu", "registerForPopupMenu AbsListView long click", new Object[0]);
          paramAnonymousAdapterView = new AdapterView.AdapterContextMenuInfo(paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
          paramc.a(a.a(a.this), paramAnonymousView);
          paramAnonymousView = a.a(a.this).JGM.iterator();
          while (paramAnonymousView.hasNext()) {
            ((m)paramAnonymousView.next()).JGS = paramAnonymousAdapterView;
          }
          a.this.el(0, 0);
          AppMethodBeat.o(200414);
          return true;
        }
      });
      AppMethodBeat.o(200420);
      return;
    }
    ap.v("MicroMsg.MMPopupMenu", "registerForPopupMenu normal view", new Object[0]);
    paramView.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(200415);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/menu/MMPopupMenu$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahF());
        ap.v("MicroMsg.MMPopupMenu", "registerForPopupMenu normal view long click", new Object[0]);
        a.a(a.this).clear();
        a.a(a.this, paramAnonymousView);
        paramc.a(a.a(a.this), paramAnonymousView);
        paramAnonymousView = new int[2];
        paramView.getLocationInWindow(paramAnonymousView);
        int i = paramAnonymousView[0] + (int)(paramView.getWidth() / 2.0F);
        int j = paramAnonymousView[1];
        if ((i == 0) && (j == 0)) {
          a.this.el(0, 0);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/widget/menu/MMPopupMenu$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(200415);
          return true;
          a.this.el(i, j);
        }
      }
    });
    AppMethodBeat.o(200420);
  }
  
  public final void a(View paramView, n.c paramc, n.e parame, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(200421);
    this.LfT = parame;
    this.KuS = paramView;
    if ((!(paramView instanceof TextView)) && ((paramInt1 == 0) || (paramInt2 == 0))) {
      fRc();
    }
    this.ECx.clear();
    paramc.a(this.ECx, paramView);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      el(0, 0);
      AppMethodBeat.o(200421);
      return;
    }
    el(paramInt1, paramInt2);
    AppMethodBeat.o(200421);
  }
  
  public final void a(n.e parame)
  {
    this.LfT = parame;
  }
  
  public final void c(View paramView, final View.OnCreateContextMenuListener paramOnCreateContextMenuListener, n.e parame)
  {
    AppMethodBeat.i(159476);
    this.KuS = paramView;
    fRc();
    this.LfT = parame;
    if ((paramView instanceof AbsListView))
    {
      ap.v("MicroMsg.MMPopupMenu", "registerForPopupMenu AbsListView", new Object[0]);
      ((AbsListView)paramView).setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(159465);
          a.a(a.this).clear();
          ap.v("MicroMsg.MMPopupMenu", "registerForPopupMenu AbsListView long click", new Object[0]);
          paramAnonymousAdapterView = new AdapterView.AdapterContextMenuInfo(paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
          paramOnCreateContextMenuListener.onCreateContextMenu(a.a(a.this), paramAnonymousView, paramAnonymousAdapterView);
          paramAnonymousView = a.a(a.this).JGM.iterator();
          while (paramAnonymousView.hasNext()) {
            ((m)paramAnonymousView.next()).JGS = paramAnonymousAdapterView;
          }
          a.this.el(0, 0);
          AppMethodBeat.o(159465);
          return true;
        }
      });
      AppMethodBeat.o(159476);
      return;
    }
    ap.v("MicroMsg.MMPopupMenu", "registerForPopupMenu normal view", new Object[0]);
    paramView.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(159466);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/menu/MMPopupMenu$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahF());
        ap.v("MicroMsg.MMPopupMenu", "registerForPopupMenu normal view long click", new Object[0]);
        a.a(a.this).clear();
        a.a(a.this, paramAnonymousView);
        paramOnCreateContextMenuListener.onCreateContextMenu(a.a(a.this), paramAnonymousView, null);
        if ((paramAnonymousView.getTag(2131306044) instanceof int[]))
        {
          paramAnonymousView = (int[])paramAnonymousView.getTag(2131306044);
          if (paramAnonymousView == null) {
            a.this.el(0, 0);
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/widget/menu/MMPopupMenu$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(159466);
          return true;
          a.this.el(paramAnonymousView[0], paramAnonymousView[1]);
          continue;
          a.this.el(0, 0);
        }
      }
    });
    AppMethodBeat.o(159476);
  }
  
  public boolean el(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159484);
    if (((this.KuS != null) && (!this.KuS.equals(this.vzt))) || ((!sVK) && ((paramInt1 != 0) || (paramInt2 != 0))))
    {
      jwh = paramInt1;
      jwi = paramInt2;
    }
    this.vzt = null;
    int k = jwh;
    int n = jwi;
    sVK = false;
    if (this.cPa == null) {
      this.cPa = this.mContext.getResources().getDisplayMetrics();
    }
    int j = k;
    int i;
    int m;
    if (this.KuS != null)
    {
      int[] arrayOfInt = new int[2];
      this.KuS.getLocationOnScreen(arrayOfInt);
      i = k;
      if (k == 0) {
        i = arrayOfInt[0] + this.KuS.getWidth() / 2;
      }
      m = arrayOfInt[1];
      j = arrayOfInt[1] + this.KuS.getHeight();
      k = m;
      if (m < 0) {
        k = 0;
      }
      m = j;
      if (j > this.cPa.heightPixels) {
        m = this.cPa.heightPixels;
      }
      j = i;
      if (n != 0) {}
    }
    for (j = (k + m) / 2;; j = k)
    {
      ap.i("MicroMsg.MMPopupMenu", "show popMenu , xDown:%s, yDown:%s, showPointX:%s, showPointY:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i), Integer.valueOf(j) });
      if ((!isShowing()) || (!fRa()) || (!fRb()))
      {
        bool1 = ko(i, j);
        AppMethodBeat.o(159484);
        return bool1;
      }
      boolean bool1 = fFi();
      boolean bool2 = ko(i, j);
      AppMethodBeat.o(159484);
      return bool2 & bool1;
      k = n;
      i = j;
    }
  }
  
  public final boolean fFi()
  {
    AppMethodBeat.i(159483);
    if (isShowing())
    {
      if (this.JUe != null) {
        this.JUe.dismiss();
      }
      AppMethodBeat.o(159483);
      return true;
    }
    if (fRa())
    {
      if (this.LwB != null) {
        this.LwB.dismiss();
      }
      AppMethodBeat.o(159483);
      return true;
    }
    if (fRb())
    {
      if (this.LwC != null) {
        this.LwC.dismiss();
      }
      AppMethodBeat.o(159483);
      return true;
    }
    AppMethodBeat.o(159483);
    return false;
  }
  
  public final boolean fLf()
  {
    AppMethodBeat.i(224517);
    boolean bool = el(0, 0);
    AppMethodBeat.o(224517);
    return bool;
  }
  
  public void onDismiss()
  {
    AppMethodBeat.i(159488);
    if (!this.LwE)
    {
      if (this.LwF == null) {
        break label51;
      }
      this.LwF.setSelected(false);
    }
    for (;;)
    {
      if (this.LhV != null) {
        this.LhV.onDismiss();
      }
      AppMethodBeat.o(159488);
      return;
      label51:
      this.KuS.setSelected(false);
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(200426);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramAdapterView);
    localb.bd(paramView);
    localb.mu(paramInt);
    localb.rl(paramLong);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/menu/MMPopupMenu", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/menu/MMPopupMenu", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(200426);
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(200425);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bd(paramView);
    localb.mu(paramInt);
    localb.bd(paramKeyEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/menu/MMPopupMenu", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.ahF());
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/widget/menu/MMPopupMenu", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
    AppMethodBeat.o(200425);
    return false;
  }
  
  public final void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.LhV = paramOnDismissListener;
  }
  
  public static abstract interface a
  {
    public abstract View a(Context paramContext, MenuItem paramMenuItem);
  }
  
  final class b
    extends BaseAdapter
  {
    private b() {}
    
    private String getItem(int paramInt)
    {
      AppMethodBeat.i(159471);
      String str = (String)((MenuItem)a.a(a.this).JGM.get(paramInt)).getTitle();
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
        paramViewGroup = (TextView)a.g(a.this).inflate(2131495102, paramViewGroup, false);
      }
      for (;;)
      {
        paramView = getItem(paramInt);
        if (paramViewGroup != null)
        {
          paramViewGroup.setTag(paramView);
          paramViewGroup.setText(paramView);
          paramViewGroup.setBackgroundResource(2131233634);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.widget.b.a
 * JD-Core Version:    0.7.0.1
 */