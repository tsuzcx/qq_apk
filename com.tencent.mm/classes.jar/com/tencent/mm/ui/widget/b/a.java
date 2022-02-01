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
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.an;
import com.tencent.mm.ui.ao;
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
  private static boolean GjZ = false;
  private static int rTn;
  private static int rTo;
  private l CGH;
  private MMListPopupWindow HLx;
  public n.d ISv;
  public PopupWindow.OnDismissListener IUx;
  private View Iic;
  private a JiM;
  private o JiN;
  private int JiO;
  private boolean JiP;
  public View JiQ;
  public View.OnCreateContextMenuListener JiR;
  public boolean JiS;
  public boolean JiT;
  public boolean JiU;
  public boolean JiV;
  public boolean JiW;
  private DisplayMetrics cDl;
  private Context mContext;
  private LayoutInflater mInflater;
  private View ukI;
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(159475);
    this.mContext = null;
    this.Iic = null;
    this.JiM = null;
    this.JiP = false;
    this.JiS = false;
    this.JiT = false;
    this.JiU = false;
    this.JiV = true;
    this.JiW = false;
    this.mContext = paramContext;
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    initView();
    AppMethodBeat.o(159475);
  }
  
  public a(Context paramContext, View paramView)
  {
    AppMethodBeat.i(159474);
    this.mContext = null;
    this.Iic = null;
    this.JiM = null;
    this.JiP = false;
    this.JiS = false;
    this.JiT = false;
    this.JiU = false;
    this.JiV = true;
    this.JiW = false;
    this.mContext = paramContext;
    this.Iic = paramView;
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    initView();
    fvU();
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
  
  private boolean fvS()
  {
    AppMethodBeat.i(159482);
    if ((this.JiN != null) && (this.JiN.isShowing()))
    {
      AppMethodBeat.o(159482);
      return true;
    }
    AppMethodBeat.o(159482);
    return false;
  }
  
  private void fvU()
  {
    AppMethodBeat.i(159486);
    this.Iic.setOnTouchListener(new View.OnTouchListener()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(159469);
        switch (paramAnonymousMotionEvent.getAction() & 0xFF)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(159469);
          return false;
          a.ada((int)paramAnonymousMotionEvent.getRawX());
          a.yJ((int)paramAnonymousMotionEvent.getRawY());
          a.b(a.this, a.e(a.this));
          a.fgd();
          an.i("MicroMsg.MMPopupMenu", "popmenu view set , x_down=" + a.bYi() + "y_down=" + a.eom(), new Object[0]);
        }
      }
    });
    AppMethodBeat.o(159486);
  }
  
  private void initView()
  {
    AppMethodBeat.i(159485);
    fkR();
    this.CGH = new l(this.mContext);
    this.JiM = new a((byte)0);
    this.cDl = this.mContext.getResources().getDisplayMetrics();
    AppMethodBeat.o(159485);
  }
  
  private boolean isShowing()
  {
    AppMethodBeat.i(159481);
    if ((this.HLx != null) && (this.HLx.jat.isShowing()))
    {
      AppMethodBeat.o(159481);
      return true;
    }
    AppMethodBeat.o(159481);
    return false;
  }
  
  private boolean jV(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159479);
    if ((isShowing()) || (fvS()))
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
      an.w("MicroMsg.MMPopupMenu", "is swiping, PASS tryShow", new Object[0]);
      AppMethodBeat.o(159479);
      return false;
    }
    if (this.JiR != null) {
      this.JiR.onCreateContextMenu(this.CGH, this.Iic, null);
    }
    int k = this.JiM.getCount() * this.mContext.getResources().getDimensionPixelSize(2131165567);
    if ((k == 0) && (!this.JiS))
    {
      AppMethodBeat.o(159479);
      return false;
    }
    int m = this.mContext.getResources().getDimensionPixelSize(2131166166);
    i = b(this.JiM);
    int j = ao.av(this.mContext, 2131166572);
    if (i < j)
    {
      i = j;
      if (this.CGH.size() < 3) {
        break label671;
      }
    }
    label268:
    label664:
    label671:
    for (boolean bool = false;; bool = true)
    {
      if (!this.JiP)
      {
        if (this.JiQ != null) {
          this.JiQ.setSelected(true);
        }
      }
      else
      {
        if (!this.JiS) {
          break label302;
        }
        jW(paramInt1, paramInt2);
      }
      for (;;)
      {
        AppMethodBeat.o(159479);
        return true;
        break;
        this.Iic.setSelected(true);
        break label268;
        label302:
        localObject = b.a(this.mContext, i, paramInt1, paramInt2, k, m, bool);
        this.JiO = (paramInt2 - this.mContext.getResources().getDimensionPixelSize(2131166166));
        an.d("MicroMsg.MMPopupMenu", "showPointY=" + paramInt2 + "verticalOffset=" + this.JiO, new Object[0]);
        this.HLx = new MMListPopupWindow(this.mContext, null, 0);
        this.HLx.setOnDismissListener(this);
        this.HLx.apn = new AdapterView.OnItemClickListener()
        {
          public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
          {
            AppMethodBeat.i(159467);
            if (a.b(a.this) != null) {
              a.b(a.this).onMMMenuItemSelected(a.a(a.this).getItem(paramAnonymousInt), paramAnonymousInt);
            }
            if ((a.c(a.this) != null) && (a.c(a.this).jat.isShowing())) {
              a.c(a.this).dismiss();
            }
            AppMethodBeat.o(159467);
          }
        };
        this.HLx.setAdapter(this.JiM);
        this.HLx.setModal(this.JiV);
        this.HLx.aph = this.JiW;
        this.HLx.setBackgroundDrawable(this.mContext.getResources().getDrawable(2131234275));
        this.HLx.setAnimationStyle(((b.a)localObject).JiZ);
        this.HLx.apa = ((b.a)localObject).mIg;
        this.HLx.setVerticalOffset(((b.a)localObject).yYJ);
        this.HLx.apl = this.Iic;
        this.HLx.setContentWidth(i);
        this.HLx.kg();
        if ((!(this.mContext instanceof Activity)) || (((Activity)this.mContext).isFinishing())) {
          break label664;
        }
        this.HLx.show();
        this.HLx.Hyb.setOnKeyListener(this);
        this.HLx.Hyb.setDivider(new ColorDrawable(this.mContext.getResources().getColor(2131100886)));
        this.HLx.Hyb.setSelector(this.mContext.getResources().getDrawable(2131233634));
        this.HLx.Hyb.setDividerHeight(0);
        this.HLx.Hyb.setVerticalScrollBarEnabled(false);
        this.HLx.Hyb.setHorizontalScrollBarEnabled(false);
      }
      AppMethodBeat.o(159479);
      return false;
    }
  }
  
  private void jW(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159480);
    int j = this.mContext.getResources().getDimensionPixelOffset(2131165516);
    int k = this.mContext.getResources().getDimensionPixelOffset(2131165480);
    this.JiN = new o(this.mContext);
    this.JiN.setOnDismissListener(this);
    this.JiN.setWidth(-2);
    this.JiN.setHeight(-2);
    this.JiN.setBackgroundDrawable(this.mContext.getResources().getDrawable(2131234275));
    this.JiN.setFocusable(this.JiT);
    this.JiN.setOutsideTouchable(this.JiU);
    LinearLayout localLinearLayout = new LinearLayout(this.mContext);
    localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    localLinearLayout.setOrientation(0);
    localLinearLayout.setBackgroundColor(ao.aJ(this.mContext, 2130968582));
    final int i = 0;
    if (i < this.CGH.size())
    {
      TextView localTextView = (TextView)this.mInflater.inflate(2131494456, null, false);
      localTextView.setBackgroundResource(2131233634);
      if (i == 0) {
        localTextView.setPadding(k, 0, j, 0);
      }
      for (;;)
      {
        localTextView.setText(((MenuItem)this.CGH.Hyi.get(i)).getTitle());
        localTextView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(159468);
            if (a.b(a.this) != null) {
              a.b(a.this).onMMMenuItemSelected(a.a(a.this).getItem(i), i);
            }
            a.d(a.this).dismiss();
            AppMethodBeat.o(159468);
          }
        });
        localLinearLayout.addView(localTextView);
        i += 1;
        break;
        if (i == this.CGH.size() - 1) {
          localTextView.setPadding(j, 0, k, 0);
        }
      }
    }
    localLinearLayout.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    i = localLinearLayout.getMeasuredHeight();
    this.JiN.setWidth(localLinearLayout.getMeasuredWidth() + ao.fromDPToPix(this.mContext, 24));
    this.JiN.setContentView(localLinearLayout);
    if (((this.mContext instanceof Activity)) && (!((Activity)this.mContext).isFinishing())) {
      this.JiN.showAtLocation(this.Iic, 0, paramInt1, paramInt2 - i);
    }
    AppMethodBeat.o(159480);
  }
  
  public final void a(View.OnCreateContextMenuListener paramOnCreateContextMenuListener)
  {
    this.JiR = paramOnCreateContextMenuListener;
  }
  
  public final void a(View paramView, int paramInt1, long paramLong, View.OnCreateContextMenuListener paramOnCreateContextMenuListener, n.d paramd, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(159477);
    this.ISv = paramd;
    this.Iic = paramView;
    fvU();
    this.CGH.clear();
    paramd = new AdapterView.AdapterContextMenuInfo(paramView, paramInt1, paramLong);
    paramOnCreateContextMenuListener.onCreateContextMenu(this.CGH, paramView, paramd);
    paramView = this.CGH.Hyi.iterator();
    while (paramView.hasNext()) {
      ((m)paramView.next()).Hyn = paramd;
    }
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      ej(0, 0);
      AppMethodBeat.o(159477);
      return;
    }
    ej(paramInt2, paramInt3);
    AppMethodBeat.o(159477);
  }
  
  public final void a(View paramView, View.OnCreateContextMenuListener paramOnCreateContextMenuListener, n.d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159478);
    this.ISv = paramd;
    this.Iic = paramView;
    if ((!(paramView instanceof TextView)) && ((paramInt1 == 0) || (paramInt2 == 0))) {
      fvU();
    }
    this.CGH.clear();
    paramOnCreateContextMenuListener.onCreateContextMenu(this.CGH, paramView, null);
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      ej(0, 0);
      AppMethodBeat.o(159478);
      return;
    }
    ej(paramInt1, paramInt2);
    AppMethodBeat.o(159478);
  }
  
  public final void a(n.d paramd)
  {
    this.ISv = paramd;
  }
  
  public final void c(View paramView, final View.OnCreateContextMenuListener paramOnCreateContextMenuListener, n.d paramd)
  {
    AppMethodBeat.i(159476);
    this.Iic = paramView;
    fvU();
    this.ISv = paramd;
    if ((paramView instanceof AbsListView))
    {
      an.v("MicroMsg.MMPopupMenu", "registerForPopupMenu AbsListView", new Object[0]);
      ((AbsListView)paramView).setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
      {
        public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          AppMethodBeat.i(159465);
          a.a(a.this).clear();
          an.v("MicroMsg.MMPopupMenu", "registerForPopupMenu AbsListView long click", new Object[0]);
          paramAnonymousAdapterView = new AdapterView.AdapterContextMenuInfo(paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
          paramOnCreateContextMenuListener.onCreateContextMenu(a.a(a.this), paramAnonymousView, paramAnonymousAdapterView);
          paramAnonymousView = a.a(a.this).Hyi.iterator();
          while (paramAnonymousView.hasNext()) {
            ((m)paramAnonymousView.next()).Hyn = paramAnonymousAdapterView;
          }
          a.this.ej(0, 0);
          AppMethodBeat.o(159465);
          return true;
        }
      });
      AppMethodBeat.o(159476);
      return;
    }
    an.v("MicroMsg.MMPopupMenu", "registerForPopupMenu normal view", new Object[0]);
    paramView.setOnLongClickListener(new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(159466);
        an.v("MicroMsg.MMPopupMenu", "registerForPopupMenu normal view long click", new Object[0]);
        a.a(a.this).clear();
        a.a(a.this, paramAnonymousView);
        paramOnCreateContextMenuListener.onCreateContextMenu(a.a(a.this), paramAnonymousView, null);
        if ((paramAnonymousView.getTag(2131306044) instanceof int[]))
        {
          paramAnonymousView = (int[])paramAnonymousView.getTag(2131306044);
          if (paramAnonymousView == null) {
            a.this.ej(0, 0);
          }
        }
        for (;;)
        {
          AppMethodBeat.o(159466);
          return true;
          a.this.ej(paramAnonymousView[0], paramAnonymousView[1]);
          continue;
          a.this.ej(0, 0);
        }
      }
    });
    AppMethodBeat.o(159476);
  }
  
  public boolean ej(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(159484);
    if (((this.Iic != null) && (!this.Iic.equals(this.ukI))) || ((!GjZ) && ((paramInt1 != 0) || (paramInt2 != 0))))
    {
      rTn = paramInt1;
      rTo = paramInt2;
    }
    this.ukI = null;
    int k = rTn;
    int n = rTo;
    GjZ = false;
    if (this.cDl == null) {
      this.cDl = this.mContext.getResources().getDisplayMetrics();
    }
    int j = k;
    int i;
    int m;
    if (this.Iic != null)
    {
      int[] arrayOfInt = new int[2];
      this.Iic.getLocationOnScreen(arrayOfInt);
      i = k;
      if (k == 0) {
        i = arrayOfInt[0] + this.Iic.getWidth() / 2;
      }
      m = arrayOfInt[1];
      j = arrayOfInt[1] + this.Iic.getHeight();
      k = m;
      if (m < 0) {
        k = 0;
      }
      m = j;
      if (j > this.cDl.heightPixels) {
        m = this.cDl.heightPixels;
      }
      j = i;
      if (n != 0) {}
    }
    for (j = (k + m) / 2;; j = k)
    {
      an.i("MicroMsg.MMPopupMenu", "show popMenu , xDown:%s, yDown:%s, showPointX:%s, showPointY:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i), Integer.valueOf(j) });
      if ((!isShowing()) || (!fvS()))
      {
        bool1 = jV(i, j);
        AppMethodBeat.o(159484);
        return bool1;
      }
      boolean bool1 = fkR();
      boolean bool2 = jV(i, j);
      AppMethodBeat.o(159484);
      return bool2 & bool1;
      k = n;
      i = j;
    }
  }
  
  public final boolean fkR()
  {
    AppMethodBeat.i(159483);
    if (isShowing())
    {
      if (this.HLx != null) {
        this.HLx.dismiss();
      }
      AppMethodBeat.o(159483);
      return true;
    }
    if (fvS())
    {
      if (this.JiN != null) {
        this.JiN.dismiss();
      }
      AppMethodBeat.o(159483);
      return true;
    }
    AppMethodBeat.o(159483);
    return false;
  }
  
  public final boolean fvT()
  {
    AppMethodBeat.i(210316);
    boolean bool = ej(0, 0);
    AppMethodBeat.o(210316);
    return bool;
  }
  
  public void onDismiss()
  {
    AppMethodBeat.i(159488);
    if (!this.JiP)
    {
      if (this.JiQ == null) {
        break label51;
      }
      this.JiQ.setSelected(false);
    }
    for (;;)
    {
      if (this.IUx != null) {
        this.IUx.onDismiss();
      }
      AppMethodBeat.o(159488);
      return;
      label51:
      this.Iic.setSelected(false);
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public final void setOnDismissListener(PopupWindow.OnDismissListener paramOnDismissListener)
  {
    this.IUx = paramOnDismissListener;
  }
  
  final class a
    extends BaseAdapter
  {
    private a() {}
    
    private String getItem(int paramInt)
    {
      AppMethodBeat.i(159471);
      String str = (String)((MenuItem)a.a(a.this).Hyi.get(paramInt)).getTitle();
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
        paramViewGroup = (TextView)a.f(a.this).inflate(2131495102, paramViewGroup, false);
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