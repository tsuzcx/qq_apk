package com.tencent.mm.ui.widget.c;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.MMListPopupWindow;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.o;
import java.util.Iterator;
import java.util.List;

public class a
  implements View.OnKeyListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener
{
  private static boolean AIA = false;
  private static int pBc;
  private static int pBd;
  private a.a AIB;
  private o AIC;
  private int AID;
  private boolean AIE;
  public View AIF;
  public View.OnCreateContextMenuListener AIG;
  public boolean AIH;
  public boolean AII;
  public boolean AIJ;
  public PopupWindow.OnDismissListener AxS;
  private DisplayMetrics bUu;
  private Context mContext;
  private LayoutInflater mInflater;
  private View omC;
  public n.d sap;
  private l saq;
  private View zRH;
  private MMListPopupWindow zxr;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(112765);
    this.mContext = null;
    this.zRH = null;
    this.AIB = null;
    this.AIE = false;
    this.AIH = false;
    this.AII = true;
    this.AIJ = false;
    this.mContext = paramContext;
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    initView();
    AppMethodBeat.o(112765);
  }
  
  public a(Context paramContext, View paramView)
  {
    AppMethodBeat.i(112764);
    this.mContext = null;
    this.zRH = null;
    this.AIB = null;
    this.AIE = false;
    this.AIH = false;
    this.AII = true;
    this.AIJ = false;
    this.mContext = paramContext;
    this.zRH = paramView;
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    initView();
    dPl();
    AppMethodBeat.o(112764);
  }
  
  private int b(ListAdapter paramListAdapter)
  {
    AppMethodBeat.i(112777);
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
      AppMethodBeat.o(112777);
      return k;
    }
  }
  
  private boolean dPk()
  {
    AppMethodBeat.i(112772);
    if ((this.AIC != null) && (this.AIC.isShowing()))
    {
      AppMethodBeat.o(112772);
      return true;
    }
    AppMethodBeat.o(112772);
    return false;
  }
  
  private void dPl()
  {
    AppMethodBeat.i(112776);
    this.zRH.setOnTouchListener(new a.5(this));
    AppMethodBeat.o(112776);
  }
  
  private boolean hU(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(112769);
    if ((isShowing()) || (dPk()))
    {
      AppMethodBeat.o(112769);
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
      ak.w("MicroMsg.MMPopupMenu", "is swiping, PASS tryShow", new Object[0]);
      AppMethodBeat.o(112769);
      return false;
    }
    if (this.AIG != null) {
      this.AIG.onCreateContextMenu(this.saq, this.zRH, null);
    }
    int k = this.AIB.getCount();
    int m = this.mContext.getResources().getDimensionPixelSize(2131427853);
    int n = this.mContext.getResources().getDimensionPixelSize(2131428315);
    i = b(this.AIB);
    int j = al.ap(this.mContext, 2131428573);
    if (i < j)
    {
      i = j;
      if (this.saq.size() < 3) {
        break label652;
      }
    }
    label645:
    label652:
    for (boolean bool = false;; bool = true)
    {
      if (!this.AIE)
      {
        if (this.AIF != null) {
          this.AIF.setSelected(true);
        }
      }
      else
      {
        label247:
        if (!this.AIH) {
          break label281;
        }
        hV(paramInt1, paramInt2);
      }
      for (;;)
      {
        AppMethodBeat.o(112769);
        return true;
        break;
        this.zRH.setSelected(true);
        break label247;
        label281:
        localObject = b.a(this.mContext, i, paramInt1, paramInt2, k * m, n, bool);
        this.AID = (paramInt2 - this.mContext.getResources().getDimensionPixelSize(2131428315));
        ak.d("MicroMsg.MMPopupMenu", "showPointY=" + paramInt2 + "verticalOffset=" + this.AID, new Object[0]);
        this.zxr = new MMListPopupWindow(this.mContext, null, 0);
        this.zxr.setOnDismissListener(this);
        this.zxr.ahl = new a.3(this);
        this.zxr.setAdapter(this.AIB);
        this.zxr.setModal(this.AII);
        this.zxr.ahf = this.AIJ;
        this.zxr.setBackgroundDrawable(this.mContext.getResources().getDrawable(2130840491));
        this.zxr.setAnimationStyle(((b.a)localObject).AIM);
        this.zxr.agY = ((b.a)localObject).jqo;
        this.zxr.setVerticalOffset(((b.a)localObject).scS);
        this.zxr.ahj = this.zRH;
        this.zxr.setContentWidth(i);
        this.zxr.iD();
        if ((!(this.mContext instanceof Activity)) || (((Activity)this.mContext).isFinishing())) {
          break label645;
        }
        this.zxr.show();
        this.zxr.zkP.setOnKeyListener(this);
        this.zxr.zkP.setDivider(new ColorDrawable(this.mContext.getResources().getColor(2131690471)));
        this.zxr.zkP.setSelector(this.mContext.getResources().getDrawable(2130839962));
        this.zxr.zkP.setDividerHeight(0);
        this.zxr.zkP.setVerticalScrollBarEnabled(false);
        this.zxr.zkP.setHorizontalScrollBarEnabled(false);
      }
      AppMethodBeat.o(112769);
      return false;
    }
  }
  
  private void hV(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(112770);
    int j = this.mContext.getResources().getDimensionPixelOffset(2131427808);
    int k = this.mContext.getResources().getDimensionPixelOffset(2131427772);
    this.AIC = new o(this.mContext);
    this.AIC.setWidth(-2);
    this.AIC.setHeight(-2);
    this.AIC.setBackgroundDrawable(this.mContext.getResources().getDrawable(2130840491));
    LinearLayout localLinearLayout = new LinearLayout(this.mContext);
    localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    localLinearLayout.setOrientation(0);
    localLinearLayout.setBackgroundColor(this.mContext.getResources().getColor(2131690709));
    int i = 0;
    if (i < this.saq.size())
    {
      TextView localTextView = (TextView)this.mInflater.inflate(2130969879, null, false);
      localTextView.setBackground(this.mContext.getResources().getDrawable(2130839962));
      if (i == 0) {
        localTextView.setPadding(k, 0, j, 0);
      }
      for (;;)
      {
        localTextView.setText(((MenuItem)this.saq.zkW.get(i)).getTitle());
        localTextView.setOnClickListener(new a.4(this, i));
        localLinearLayout.addView(localTextView);
        i += 1;
        break;
        if (i == this.saq.size() - 1) {
          localTextView.setPadding(j, 0, k, 0);
        }
      }
    }
    localLinearLayout.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    i = localLinearLayout.getMeasuredHeight();
    this.AIC.setContentView(localLinearLayout);
    if (((this.mContext instanceof Activity)) && (!((Activity)this.mContext).isFinishing())) {
      this.AIC.showAtLocation(this.zRH, 0, paramInt1, paramInt2 - i);
    }
    AppMethodBeat.o(112770);
  }
  
  private void initView()
  {
    AppMethodBeat.i(112775);
    dGj();
    this.saq = new l(this.mContext);
    this.AIB = new a.a(this, (byte)0);
    this.bUu = this.mContext.getResources().getDisplayMetrics();
    AppMethodBeat.o(112775);
  }
  
  private boolean isShowing()
  {
    AppMethodBeat.i(112771);
    if ((this.zxr != null) && (this.zxr.gMK.isShowing()))
    {
      AppMethodBeat.o(112771);
      return true;
    }
    AppMethodBeat.o(112771);
    return false;
  }
  
  public final void a(View paramView, int paramInt1, long paramLong, View.OnCreateContextMenuListener paramOnCreateContextMenuListener, n.d paramd, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(112767);
    this.sap = paramd;
    this.zRH = paramView;
    dPl();
    this.saq.clear();
    paramd = new AdapterView.AdapterContextMenuInfo(paramView, paramInt1, paramLong);
    paramOnCreateContextMenuListener.onCreateContextMenu(this.saq, paramView, paramd);
    paramView = this.saq.zkW.iterator();
    while (paramView.hasNext()) {
      ((m)paramView.next()).zkZ = paramd;
    }
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      dq(0, 0);
      AppMethodBeat.o(112767);
      return;
    }
    dq(paramInt2, paramInt3);
    AppMethodBeat.o(112767);
  }
  
  public final void a(View paramView, View.OnCreateContextMenuListener paramOnCreateContextMenuListener, n.d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(112768);
    this.sap = paramd;
    this.zRH = paramView;
    if ((!(paramView instanceof TextView)) && ((paramInt1 == 0) || (paramInt2 == 0))) {
      dPl();
    }
    this.saq.clear();
    paramOnCreateContextMenuListener.onCreateContextMenu(this.saq, paramView, null);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      dq(0, 0);
      AppMethodBeat.o(112768);
      return;
    }
    dq(paramInt1, paramInt2);
    AppMethodBeat.o(112768);
  }
  
  public final void c(View paramView, final View.OnCreateContextMenuListener paramOnCreateContextMenuListener, n.d paramd)
  {
    AppMethodBeat.i(112766);
    this.zRH = paramView;
    dPl();
    this.sap = paramd;
    if ((paramView instanceof AbsListView))
    {
      ak.v("MicroMsg.MMPopupMenu", "registerForPopupMenu AbsListView", new Object[0]);
      ((AbsListView)paramView).setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(112755);
          a.a(a.this).clear();
          ak.v("MicroMsg.MMPopupMenu", "registerForPopupMenu AbsListView long click", new Object[0]);
          paramAnonymousAdapterView = new AdapterView.AdapterContextMenuInfo(paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
          paramOnCreateContextMenuListener.onCreateContextMenu(a.a(a.this), paramAnonymousView, paramAnonymousAdapterView);
          paramAnonymousView = a.a(a.this).zkW.iterator();
          while (paramAnonymousView.hasNext()) {
            ((m)paramAnonymousView.next()).zkZ = paramAnonymousAdapterView;
          }
          a.this.dq(0, 0);
          AppMethodBeat.o(112755);
          return true;
        }
      });
      AppMethodBeat.o(112766);
      return;
    }
    ak.v("MicroMsg.MMPopupMenu", "registerForPopupMenu normal view", new Object[0]);
    paramView.setOnLongClickListener(new a.2(this, paramOnCreateContextMenuListener));
    AppMethodBeat.o(112766);
  }
  
  public final boolean dGj()
  {
    AppMethodBeat.i(112773);
    if (isShowing())
    {
      if (this.zxr != null) {
        this.zxr.dismiss();
      }
      AppMethodBeat.o(112773);
      return true;
    }
    if (dPk())
    {
      if (this.AIC != null) {
        this.AIC.dismiss();
      }
      AppMethodBeat.o(112773);
      return true;
    }
    AppMethodBeat.o(112773);
    return false;
  }
  
  public boolean dq(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(112774);
    if (((this.zRH != null) && (!this.zRH.equals(this.omC))) || ((!AIA) && ((paramInt1 != 0) || (paramInt2 != 0))))
    {
      pBc = paramInt1;
      pBd = paramInt2;
    }
    this.omC = null;
    int k = pBc;
    int n = pBd;
    AIA = false;
    if (this.bUu == null) {
      this.bUu = this.mContext.getResources().getDisplayMetrics();
    }
    int j = k;
    int i;
    int m;
    if (this.zRH != null)
    {
      int[] arrayOfInt = new int[2];
      this.zRH.getLocationOnScreen(arrayOfInt);
      i = k;
      if (k == 0) {
        i = arrayOfInt[0] + this.zRH.getWidth() / 2;
      }
      m = arrayOfInt[1];
      j = arrayOfInt[1] + this.zRH.getHeight();
      k = m;
      if (m < 0) {
        k = 0;
      }
      m = j;
      if (j > this.bUu.heightPixels) {
        m = this.bUu.heightPixels;
      }
      j = i;
      if (n != 0) {}
    }
    for (j = (k + m) / 2;; j = k)
    {
      ak.i("MicroMsg.MMPopupMenu", "show popMenu , xDown:%s, yDown:%s, showPointX:%s, showPointY:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i), Integer.valueOf(j) });
      if ((!isShowing()) || (!dPk()))
      {
        bool1 = hU(i, j);
        AppMethodBeat.o(112774);
        return bool1;
      }
      boolean bool1 = dGj();
      boolean bool2 = hU(i, j);
      AppMethodBeat.o(112774);
      return bool2 & bool1;
      k = n;
      i = j;
    }
  }
  
  public void onDismiss()
  {
    AppMethodBeat.i(112778);
    if (!this.AIE)
    {
      if (this.AIF == null) {
        break label51;
      }
      this.AIF.setSelected(false);
    }
    for (;;)
    {
      if (this.AxS != null) {
        this.AxS.onDismiss();
      }
      AppMethodBeat.o(112778);
      return;
      label51:
      this.zRH.setSelected(false);
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.widget.c.a
 * JD-Core Version:    0.7.0.1
 */