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
import com.tencent.mm.ui.as;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.base.MMListPopupWindow;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.o.e;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Iterator;
import java.util.List;

public class a
  implements View.OnKeyListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener
{
  private static int kuv;
  private static int kuw;
  private static boolean vUN = false;
  public o.g HLY;
  private m HMc;
  private View PHi;
  private MMListPopupWindow Pfj;
  public a QSA;
  public boolean QSB;
  public boolean QSC;
  private b QSm;
  private p QSn;
  private p QSo;
  private int QSp;
  private boolean QSq;
  public View QSr;
  public View.OnCreateContextMenuListener QSs;
  public o.e QSt;
  public boolean QSu;
  public boolean QSv;
  public boolean QSw;
  public boolean QSx;
  public boolean QSy;
  private boolean QSz;
  public PopupWindow.OnDismissListener QwU;
  private DisplayMetrics dfz;
  private Context mContext;
  private LayoutInflater mInflater;
  public long startTime;
  private View yTH;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(159475);
    this.mContext = null;
    this.PHi = null;
    this.QSm = null;
    this.QSq = false;
    this.QSu = false;
    this.QSv = false;
    this.QSw = false;
    this.QSx = false;
    this.QSy = true;
    this.QSz = true;
    this.startTime = 0L;
    this.QSB = true;
    this.QSC = false;
    this.mContext = paramContext;
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    initView();
    AppMethodBeat.o(159475);
  }
  
  public a(Context paramContext, View paramView)
  {
    AppMethodBeat.i(159474);
    this.mContext = null;
    this.PHi = null;
    this.QSm = null;
    this.QSq = false;
    this.QSu = false;
    this.QSv = false;
    this.QSw = false;
    this.QSx = false;
    this.QSy = true;
    this.QSz = true;
    this.startTime = 0L;
    this.QSB = true;
    this.QSC = false;
    this.mContext = paramContext;
    this.PHi = paramView;
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    initView();
    hcc();
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
  
  private boolean hbZ()
  {
    AppMethodBeat.i(159482);
    if ((this.QSn != null) && (this.QSn.isShowing()))
    {
      AppMethodBeat.o(159482);
      return true;
    }
    AppMethodBeat.o(159482);
    return false;
  }
  
  private void hcc()
  {
    AppMethodBeat.i(159486);
    this.PHi.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(198365);
        switch (paramAnonymousMotionEvent.getAction() & 0xFF)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(198365);
          return false;
          a.apn((int)paramAnonymousMotionEvent.getRawX());
          a.adu((int)paramAnonymousMotionEvent.getRawY());
          a.b(a.this, a.f(a.this));
          a.aav();
          as.i("MicroMsg.MMPopupMenu", "popmenu view set , x_down=" + a.eHa() + "y_down=" + a.cgL(), new Object[0]);
        }
      }
    });
    AppMethodBeat.o(159486);
  }
  
  private void initView()
  {
    AppMethodBeat.i(159485);
    gNq();
    this.HMc = new m(this.mContext);
    this.QSm = new b((byte)0);
    this.dfz = this.mContext.getResources().getDisplayMetrics();
    AppMethodBeat.o(159485);
  }
  
  private boolean lJ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159479);
    if ((isShowing()) || (hbZ()) || (hca()))
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
      as.w("MicroMsg.MMPopupMenu", "is swiping, PASS tryShow", new Object[0]);
      AppMethodBeat.o(159479);
      return false;
    }
    if ((this.QSv) && (this.QSt != null)) {
      this.QSt.a(this.HMc, this.PHi);
    }
    int k;
    for (;;)
    {
      k = this.QSm.getCount() * this.mContext.getResources().getDimensionPixelSize(2131165585);
      if ((k != 0) || (this.QSu) || (this.QSv)) {
        break;
      }
      AppMethodBeat.o(159479);
      return false;
      if (this.QSs != null) {
        this.QSs.onCreateContextMenu(this.HMc, this.PHi, null);
      }
    }
    int m = this.mContext.getResources().getDimensionPixelSize(2131166207);
    i = b(this.QSm);
    int j = at.aH(this.mContext, 2131166687);
    if (i < j)
    {
      i = j;
      if (this.HMc.size() < 3) {
        break label742;
      }
    }
    label321:
    label356:
    label742:
    for (boolean bool = false;; bool = true)
    {
      if (!this.QSq)
      {
        if (this.QSr != null) {
          this.QSr.setSelected(true);
        }
      }
      else
      {
        if (!this.QSu) {
          break label356;
        }
        lK(paramInt1, paramInt2);
      }
      for (;;)
      {
        AppMethodBeat.o(159479);
        return true;
        break;
        this.PHi.setSelected(true);
        break label321;
        if (this.QSv)
        {
          lL(paramInt1, paramInt2);
        }
        else
        {
          localObject = b.a(this.mContext, i, paramInt1, paramInt2, k, m, bool);
          this.QSp = (paramInt2 - this.mContext.getResources().getDimensionPixelSize(2131166207));
          as.d("MicroMsg.MMPopupMenu", "showPointY=" + paramInt2 + "verticalOffset=" + this.QSp, new Object[0]);
          this.Pfj = new MMListPopupWindow(this.mContext, null, 0);
          this.Pfj.setOnDismissListener(this);
          this.Pfj.ars = new AdapterView.OnItemClickListener()
          {
            public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
            {
              AppMethodBeat.i(198362);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bm(paramAnonymousAdapterView);
              localb.bm(paramAnonymousView);
              localb.pH(paramAnonymousInt);
              localb.zo(paramAnonymousLong);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/menu/MMPopupMenu$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
              if (a.b(a.this) != null) {
                a.b(a.this).onMMMenuItemSelected(a.a(a.this).getItem(paramAnonymousInt), paramAnonymousInt);
              }
              if ((a.c(a.this) != null) && (a.c(a.this).kuK.isShowing())) {
                a.c(a.this).dismiss();
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/menu/MMPopupMenu$5", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
              AppMethodBeat.o(198362);
            }
          };
          this.Pfj.setAdapter(this.QSm);
          this.Pfj.setModal(this.QSB);
          this.Pfj.arl = this.QSC;
          this.Pfj.setBackgroundDrawable(this.mContext.getResources().getDrawable(2131235152));
          this.Pfj.setAnimationStyle(((b.a)localObject).QSG);
          this.Pfj.are = ((b.a)localObject).oxr;
          this.Pfj.setVerticalOffset(((b.a)localObject).ERI);
          this.Pfj.arp = this.PHi;
          this.Pfj.setContentWidth(i);
          this.Pfj.kC();
          if ((!(this.mContext instanceof Activity)) || (((Activity)this.mContext).isFinishing())) {
            break label734;
          }
          this.Pfj.show();
          this.Pfj.ORx.setOnKeyListener(this);
          this.Pfj.ORx.setDivider(new ColorDrawable(this.mContext.getResources().getColor(2131101085)));
          this.Pfj.ORx.setSelector(this.mContext.getResources().getDrawable(2131234447));
          this.Pfj.ORx.setDividerHeight(0);
          this.Pfj.ORx.setVerticalScrollBarEnabled(false);
          this.Pfj.ORx.setHorizontalScrollBarEnabled(false);
        }
      }
      AppMethodBeat.o(159479);
      return false;
    }
  }
  
  private void lK(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159480);
    int j = this.mContext.getResources().getDimensionPixelOffset(2131165534);
    int k = this.mContext.getResources().getDimensionPixelOffset(2131165498);
    this.QSn = new p(this.mContext);
    this.QSn.setOnDismissListener(this);
    this.QSn.setWidth(-2);
    this.QSn.setHeight(-2);
    this.QSn.setBackgroundDrawable(this.mContext.getResources().getDrawable(2131235152));
    this.QSn.setFocusable(this.QSw);
    this.QSn.setOutsideTouchable(this.QSx);
    LinearLayout localLinearLayout = new LinearLayout(this.mContext);
    localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    localLinearLayout.setOrientation(0);
    localLinearLayout.setBackgroundColor(this.mContext.getResources().getColor(2131099653));
    final int i = 0;
    if (i < this.HMc.size())
    {
      TextView localTextView = (TextView)this.mInflater.inflate(2131495034, null, false);
      localTextView.setBackgroundResource(2131234447);
      if (i == 0) {
        localTextView.setPadding(k, 0, j, 0);
      }
      for (;;)
      {
        localTextView.setText(((MenuItem)this.HMc.ORD.get(i)).getTitle());
        localTextView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(198363);
            com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/menu/MMPopupMenu$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            if (a.b(a.this) != null) {
              a.b(a.this).onMMMenuItemSelected(a.a(a.this).getItem(i), i);
            }
            a.d(a.this).dismiss();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/menu/MMPopupMenu$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(198363);
          }
        });
        localLinearLayout.addView(localTextView);
        i += 1;
        break;
        if (i == this.HMc.size() - 1) {
          localTextView.setPadding(j, 0, k, 0);
        }
      }
    }
    localLinearLayout.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    i = localLinearLayout.getMeasuredHeight();
    this.QSn.setWidth(localLinearLayout.getMeasuredWidth() + at.fromDPToPix(this.mContext, 24));
    this.QSn.setContentView(localLinearLayout);
    if (((this.mContext instanceof Activity)) && (!((Activity)this.mContext).isFinishing())) {
      this.QSn.showAtLocation(this.PHi, 0, paramInt1, paramInt2 - i);
    }
    AppMethodBeat.o(159480);
  }
  
  private void lL(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(198368);
    this.QSo = new p(this.mContext);
    this.QSo.setOnDismissListener(this);
    this.QSo.setWidth(-2);
    this.QSo.setHeight(-2);
    this.QSo.setFocusable(this.QSy);
    this.QSo.setOutsideTouchable(true);
    this.QSo.setAnimationStyle(2131821254);
    this.QSo.setInputMethodMode(2);
    View localView = View.inflate(this.mContext, 2131494992, null);
    localView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    LinearLayout localLinearLayout1 = (LinearLayout)localView.findViewById(2131304621);
    LinearLayout localLinearLayout2 = (LinearLayout)localView.findViewById(2131304622);
    Object localObject = localView.findViewById(2131304612);
    ImageView localImageView1 = (ImageView)localView.findViewById(2131299376);
    ImageView localImageView2 = (ImageView)localView.findViewById(2131299377);
    localLinearLayout1.setVisibility(0);
    localLinearLayout1.removeAllViews();
    if (this.HMc.size() > 5)
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
        if (i < this.HMc.size())
        {
          localObject = null;
          if (this.QSA != null) {
            localObject = this.QSA.a(this.mContext, (MenuItem)this.HMc.ORD.get(i));
          }
          if (localObject != null) {
            break label853;
          }
          localObject = View.inflate(this.mContext, 2131495942, null);
          WeImageView localWeImageView = (WeImageView)((View)localObject).findViewById(2131302468);
          TextView localTextView = (TextView)((View)localObject).findViewById(2131309195);
          localWeImageView.setImageDrawable(((MenuItem)this.HMc.ORD.get(i)).getIcon());
          localTextView.setText(((MenuItem)this.HMc.ORD.get(i)).getTitle());
          label364:
          ((View)localObject).setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(198364);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bm(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/menu/MMPopupMenu$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
              if (a.b(a.this) != null) {
                a.b(a.this).onMMMenuItemSelected(a.a(a.this).getItem(i), i);
              }
              a.e(a.this).dismiss();
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/menu/MMPopupMenu$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(198364);
            }
          });
          if (((n)this.HMc.ORD.get(i)).ORJ)
          {
            if (localLinearLayout2.getChildCount() < 5) {
              localLinearLayout2.addView((View)localObject);
            }
            i += 1;
            continue;
            i = 0;
            if (i >= this.HMc.size()) {
              break label856;
            }
            if (!((n)this.HMc.getItem(i)).ORJ) {
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
        this.QSo.setContentView(localView);
        localView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int m = localView.getMeasuredHeight();
        i = localView.getMeasuredWidth();
        int j = at.fromDPToPix(this.mContext, 12);
        int k = paramInt1 - (int)(i / 2.0F);
        if (k + i > this.dfz.widthPixels - j)
        {
          i = this.dfz.widthPixels - j - i;
          j = paramInt2 - m - at.aH(this.mContext, 2131165277);
          if (j >= 0) {
            break label799;
          }
          j = this.PHi.getHeight();
          paramInt2 = at.aH(this.mContext, 2131165277) + (j + paramInt2);
          localImageView2.setVisibility(0);
          localImageView1.setVisibility(8);
          localObject = (LinearLayout.LayoutParams)localImageView2.getLayoutParams();
          ((LinearLayout.LayoutParams)localObject).leftMargin = (paramInt1 - i - at.fromDPToPix(this.mContext, 7));
          localImageView2.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        for (paramInt1 = paramInt2;; paramInt1 = j)
        {
          if (this.HMc.size() == 0)
          {
            localImageView1.setVisibility(8);
            localImageView2.setVisibility(8);
          }
          if (((this.mContext instanceof Activity)) && (!((Activity)this.mContext).isFinishing()))
          {
            this.QSo.showAtLocation(this.PHi, 0, i, paramInt1);
            this.startTime = System.currentTimeMillis();
          }
          AppMethodBeat.o(198368);
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
          ((LinearLayout.LayoutParams)localObject).leftMargin = (paramInt1 - i - at.fromDPToPix(this.mContext, 7));
          localImageView1.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        break label364;
      }
    }
  }
  
  public final void a(View.OnCreateContextMenuListener paramOnCreateContextMenuListener)
  {
    this.QSs = paramOnCreateContextMenuListener;
  }
  
  public final void a(View paramView, int paramInt1, long paramLong, View.OnCreateContextMenuListener paramOnCreateContextMenuListener, o.g paramg, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(159477);
    this.HLY = paramg;
    this.PHi = paramView;
    hcc();
    this.HMc.clear();
    paramg = new AdapterView.AdapterContextMenuInfo(paramView, paramInt1, paramLong);
    paramOnCreateContextMenuListener.onCreateContextMenu(this.HMc, paramView, paramg);
    paramView = this.HMc.ORD.iterator();
    while (paramView.hasNext()) {
      ((n)paramView.next()).ORH = paramg;
    }
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      ez(0, 0);
      AppMethodBeat.o(159477);
      return;
    }
    ez(paramInt2, paramInt3);
    AppMethodBeat.o(159477);
  }
  
  public final void a(View paramView, View.OnCreateContextMenuListener paramOnCreateContextMenuListener, o.g paramg, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159478);
    this.HLY = paramg;
    this.PHi = paramView;
    if ((!(paramView instanceof TextView)) && ((paramInt1 == 0) || (paramInt2 == 0))) {
      hcc();
    }
    this.HMc.clear();
    paramOnCreateContextMenuListener.onCreateContextMenu(this.HMc, paramView, null);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      ez(0, 0);
      AppMethodBeat.o(159478);
      return;
    }
    ez(paramInt1, paramInt2);
    AppMethodBeat.o(159478);
  }
  
  public final void a(final View paramView, final o.e parame, o.g paramg)
  {
    AppMethodBeat.i(198366);
    this.PHi = paramView;
    hcc();
    this.HLY = paramg;
    if ((paramView instanceof AbsListView))
    {
      as.v("MicroMsg.MMPopupMenu", "registerForPopupMenu AbsListView", new Object[0]);
      ((AbsListView)paramView).setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(198360);
          a.a(a.this).clear();
          as.v("MicroMsg.MMPopupMenu", "registerForPopupMenu AbsListView long click", new Object[0]);
          paramAnonymousAdapterView = new AdapterView.AdapterContextMenuInfo(paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
          parame.a(a.a(a.this), paramAnonymousView);
          paramAnonymousView = a.a(a.this).ORD.iterator();
          while (paramAnonymousView.hasNext()) {
            ((n)paramAnonymousView.next()).ORH = paramAnonymousAdapterView;
          }
          a.this.ez(0, 0);
          AppMethodBeat.o(198360);
          return true;
        }
      });
      AppMethodBeat.o(198366);
      return;
    }
    as.v("MicroMsg.MMPopupMenu", "registerForPopupMenu normal view", new Object[0]);
    paramView.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(198361);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/menu/MMPopupMenu$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
        as.v("MicroMsg.MMPopupMenu", "registerForPopupMenu normal view long click", new Object[0]);
        a.a(a.this).clear();
        a.a(a.this, paramAnonymousView);
        parame.a(a.a(a.this), paramAnonymousView);
        paramAnonymousView = new int[2];
        paramView.getLocationInWindow(paramAnonymousView);
        int i = paramAnonymousView[0] + (int)(paramView.getWidth() / 2.0F);
        int j = paramAnonymousView[1];
        if ((i == 0) && (j == 0)) {
          a.this.ez(0, 0);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/widget/menu/MMPopupMenu$4", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(198361);
          return true;
          a.this.ez(i, j);
        }
      }
    });
    AppMethodBeat.o(198366);
  }
  
  public final void a(View paramView, o.e parame, o.g paramg, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(198367);
    this.HLY = paramg;
    this.PHi = paramView;
    if ((!(paramView instanceof TextView)) && ((paramInt1 == 0) || (paramInt2 == 0))) {
      hcc();
    }
    this.HMc.clear();
    parame.a(this.HMc, paramView);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      ez(0, 0);
      AppMethodBeat.o(198367);
      return;
    }
    ez(paramInt1, paramInt2);
    AppMethodBeat.o(198367);
  }
  
  public final void a(o.g paramg)
  {
    this.HLY = paramg;
  }
  
  public final void c(View paramView, final View.OnCreateContextMenuListener paramOnCreateContextMenuListener, o.g paramg)
  {
    AppMethodBeat.i(159476);
    this.PHi = paramView;
    hcc();
    this.HLY = paramg;
    if ((paramView instanceof AbsListView))
    {
      as.v("MicroMsg.MMPopupMenu", "registerForPopupMenu AbsListView", new Object[0]);
      ((AbsListView)paramView).setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(159465);
          a.a(a.this).clear();
          as.v("MicroMsg.MMPopupMenu", "registerForPopupMenu AbsListView long click", new Object[0]);
          paramAnonymousAdapterView = new AdapterView.AdapterContextMenuInfo(paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
          paramOnCreateContextMenuListener.onCreateContextMenu(a.a(a.this), paramAnonymousView, paramAnonymousAdapterView);
          paramAnonymousView = a.a(a.this).ORD.iterator();
          while (paramAnonymousView.hasNext()) {
            ((n)paramAnonymousView.next()).ORH = paramAnonymousAdapterView;
          }
          a.this.ez(0, 0);
          AppMethodBeat.o(159465);
          return true;
        }
      });
      AppMethodBeat.o(159476);
      return;
    }
    as.v("MicroMsg.MMPopupMenu", "registerForPopupMenu normal view", new Object[0]);
    paramView.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(159466);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/menu/MMPopupMenu$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
        as.v("MicroMsg.MMPopupMenu", "registerForPopupMenu normal view long click", new Object[0]);
        a.a(a.this).clear();
        a.a(a.this, paramAnonymousView);
        paramOnCreateContextMenuListener.onCreateContextMenu(a.a(a.this), paramAnonymousView, null);
        if ((paramAnonymousView.getTag(2131309367) instanceof int[]))
        {
          paramAnonymousView = (int[])paramAnonymousView.getTag(2131309367);
          if (paramAnonymousView == null) {
            a.this.ez(0, 0);
          }
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/ui/widget/menu/MMPopupMenu$2", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(159466);
          return true;
          a.this.ez(paramAnonymousView[0], paramAnonymousView[1]);
          continue;
          a.this.ez(0, 0);
        }
      }
    });
    AppMethodBeat.o(159476);
  }
  
  public boolean ez(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159484);
    if (((this.PHi != null) && (!this.PHi.equals(this.yTH))) || ((!vUN) && ((paramInt1 != 0) || (paramInt2 != 0))))
    {
      kuv = paramInt1;
      kuw = paramInt2;
    }
    this.yTH = null;
    int k = kuv;
    int n = kuw;
    vUN = false;
    if (this.dfz == null) {
      this.dfz = this.mContext.getResources().getDisplayMetrics();
    }
    int j = k;
    int i;
    int m;
    if (this.PHi != null)
    {
      int[] arrayOfInt = new int[2];
      this.PHi.getLocationOnScreen(arrayOfInt);
      i = k;
      if (k == 0) {
        i = arrayOfInt[0] + this.PHi.getWidth() / 2;
      }
      m = arrayOfInt[1];
      j = arrayOfInt[1] + this.PHi.getHeight();
      k = m;
      if (m < 0) {
        k = 0;
      }
      m = j;
      if (j > this.dfz.heightPixels) {
        m = this.dfz.heightPixels;
      }
      j = i;
      if (n != 0) {}
    }
    for (j = (k + m) / 2;; j = k)
    {
      as.i("MicroMsg.MMPopupMenu", "show popMenu , xDown:%s, yDown:%s, showPointX:%s, showPointY:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i), Integer.valueOf(j) });
      if ((!isShowing()) || (!hbZ()) || (!hca()))
      {
        bool1 = lJ(i, j);
        AppMethodBeat.o(159484);
        return bool1;
      }
      boolean bool1 = gNq();
      boolean bool2 = lJ(i, j);
      AppMethodBeat.o(159484);
      return bool2 & bool1;
      k = n;
      i = j;
    }
  }
  
  public final boolean gNq()
  {
    AppMethodBeat.i(159483);
    if (isShowing())
    {
      if (this.Pfj != null) {
        this.Pfj.dismiss();
      }
      AppMethodBeat.o(159483);
      return true;
    }
    if (hbZ())
    {
      if (this.QSn != null) {
        this.QSn.dismiss();
      }
      AppMethodBeat.o(159483);
      return true;
    }
    if (hca())
    {
      if (this.QSo != null) {
        this.QSo.dismiss();
      }
      AppMethodBeat.o(159483);
      return true;
    }
    AppMethodBeat.o(159483);
    return false;
  }
  
  public final boolean gTx()
  {
    AppMethodBeat.i(258312);
    boolean bool = ez(0, 0);
    AppMethodBeat.o(258312);
    return bool;
  }
  
  public final boolean hca()
  {
    AppMethodBeat.i(198369);
    if ((this.QSo != null) && (this.QSo.isShowing()))
    {
      AppMethodBeat.o(198369);
      return true;
    }
    AppMethodBeat.o(198369);
    return false;
  }
  
  public final void hcb()
  {
    this.QSv = true;
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(159481);
    if ((this.Pfj != null) && (this.Pfj.kuK.isShowing()))
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
    if (!this.QSq)
    {
      if (this.QSr == null) {
        break label51;
      }
      this.QSr.setSelected(false);
    }
    for (;;)
    {
      if (this.QwU != null) {
        this.QwU.onDismiss();
      }
      AppMethodBeat.o(159488);
      return;
      label51:
      this.PHi.setSelected(false);
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(198372);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramAdapterView);
    localb.bm(paramView);
    localb.pH(paramInt);
    localb.zo(paramLong);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/menu/MMPopupMenu", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/widget/menu/MMPopupMenu", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(198372);
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(198371);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramView);
    localb.pH(paramInt);
    localb.bm(paramKeyEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/widget/menu/MMPopupMenu", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.axR());
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/widget/menu/MMPopupMenu", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
    AppMethodBeat.o(198371);
    return false;
  }
  
  public final void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.QwU = paramOnDismissListener;
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
      String str = (String)((MenuItem)a.a(a.this).ORD.get(paramInt)).getTitle();
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
        paramViewGroup = (TextView)a.g(a.this).inflate(2131495944, paramViewGroup, false);
      }
      for (;;)
      {
        paramView = getItem(paramInt);
        if (paramViewGroup != null)
        {
          paramViewGroup.setTag(paramView);
          paramViewGroup.setText(paramView);
          paramViewGroup.setBackgroundResource(2131234447);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.widget.b.a
 * JD-Core Version:    0.7.0.1
 */