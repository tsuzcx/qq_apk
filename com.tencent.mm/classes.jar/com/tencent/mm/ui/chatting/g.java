package com.tencent.mm.ui.chatting;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.MMListPopupWindow;
import com.tencent.mm.ui.base.o;
import java.util.List;

public final class g
  implements View.OnKeyListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener
{
  private int height;
  private Context mContext;
  private int mCount;
  private LayoutInflater mInflater;
  AdapterView.OnItemClickListener zxo;
  private ViewGroup zxp;
  private b zxq;
  private MMListPopupWindow zxr;
  private int zxs;
  private int zxt;
  com.tencent.mm.aj.j zxu;
  private boolean zxv;
  
  public g(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(30501);
    this.zxo = null;
    this.mContext = null;
    this.zxp = null;
    this.zxq = null;
    this.zxs = 2131493701;
    this.zxu = null;
    this.zxv = true;
    this.mContext = paramContext;
    this.zxp = paramViewGroup;
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    dGj();
    this.zxq = new b((byte)0);
    AppMethodBeat.o(30501);
  }
  
  private int b(ListAdapter paramListAdapter)
  {
    AppMethodBeat.i(30505);
    int n = View.MeasureSpec.makeMeasureSpec(0, 0);
    int i1 = View.MeasureSpec.makeMeasureSpec(0, 0);
    int i2 = paramListAdapter.getCount();
    int j = 0;
    int i = 0;
    View localView = null;
    int k = 0;
    if (j < i2)
    {
      int m = paramListAdapter.getItemViewType(j);
      if (m == i) {
        break label139;
      }
      localView = null;
      i = m;
    }
    label139:
    for (;;)
    {
      if (this.zxp == null) {
        this.zxp = new FrameLayout(this.mContext);
      }
      localView = paramListAdapter.getView(j, localView, this.zxp);
      localView.measure(n, i1);
      k = Math.max(k, localView.getMeasuredWidth());
      j += 1;
      break;
      AppMethodBeat.o(30505);
      return k;
    }
  }
  
  @SuppressLint({"WrongCall"})
  public final boolean a(com.tencent.mm.aj.j paramj, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(30502);
    if ((!isShowing()) && (paramj != null) && (paramj.fwr != null) && (paramj.fwr.size() > 0))
    {
      this.zxv = false;
      this.zxu = paramj;
      this.mCount = paramj.fwr.size();
      this.zxq.notifyDataSetChanged();
      this.height = ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay().getHeight();
      TextView localTextView = (TextView)((LayoutInflater)this.mContext.getSystemService("layout_inflater")).inflate(2130970429, null);
      paramj = g.a.a(this.mContext, localTextView.getPaint(), paramj.fwr, paramInt1);
      this.zxt = (paramInt2 - this.zxq.getCount() * this.mContext.getResources().getDimensionPixelSize(2131427853) - this.mContext.getResources().getDimensionPixelSize(2131427665));
      ab.d("MicroMsg.ChatFooterCustomSubmenu", "showPointY=" + paramInt2 + "verticalOffset=" + this.zxt);
      this.zxr = new MMListPopupWindow(this.mContext, null, 0);
      this.zxr.setOnDismissListener(this);
      this.zxr.ahl = this.zxo;
      this.zxr.setAdapter(this.zxq);
      this.zxr.setModal(true);
      this.zxr.setBackgroundDrawable(this.mContext.getResources().getDrawable(2130840491));
      this.zxr.setAnimationStyle(this.zxs);
      this.zxr.agY = paramj.jqo;
      this.zxr.setVerticalOffset(this.zxt);
      this.zxr.ahj = this.zxp;
      this.zxr.setContentWidth(b(this.zxq));
      this.zxr.iD();
      this.zxr.show();
      this.zxr.zkP.setOnKeyListener(this);
      this.zxr.zkP.setDivider(new ColorDrawable(this.mContext.getResources().getColor(2131690471)));
      this.zxr.zkP.setSelector(this.mContext.getResources().getDrawable(2130839962));
      this.zxr.zkP.setDividerHeight(1);
      this.zxr.zkP.setVerticalScrollBarEnabled(false);
      this.zxr.zkP.setHorizontalScrollBarEnabled(false);
      AppMethodBeat.o(30502);
      return true;
    }
    AppMethodBeat.o(30502);
    return false;
  }
  
  public final boolean dGj()
  {
    AppMethodBeat.i(30504);
    if (isShowing())
    {
      this.zxr.dismiss();
      AppMethodBeat.o(30504);
      return true;
    }
    AppMethodBeat.o(30504);
    return false;
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(30503);
    if ((this.zxr != null) && (this.zxr.gMK.isShowing()))
    {
      AppMethodBeat.o(30503);
      return true;
    }
    AppMethodBeat.o(30503);
    return false;
  }
  
  public final void onDismiss() {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong) {}
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  final class b
    extends BaseAdapter
  {
    private b() {}
    
    private com.tencent.mm.aj.j Pm(int paramInt)
    {
      AppMethodBeat.i(30498);
      com.tencent.mm.aj.j localj = (com.tencent.mm.aj.j)g.b(g.this).fwr.get(paramInt);
      AppMethodBeat.o(30498);
      return localj;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(30497);
      int i = g.a(g.this);
      AppMethodBeat.o(30497);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(30499);
      if (paramView == null) {}
      for (paramView = (TextView)g.c(g.this).inflate(2130970429, paramViewGroup, false);; paramView = (TextView)paramView)
      {
        paramViewGroup = Pm(paramInt);
        paramView.setTag(paramViewGroup);
        paramView.setText(com.tencent.mm.pluginsdk.ui.d.j.b(g.d(g.this), paramViewGroup.name));
        AppMethodBeat.o(30499);
        return paramView;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.g
 * JD-Core Version:    0.7.0.1
 */