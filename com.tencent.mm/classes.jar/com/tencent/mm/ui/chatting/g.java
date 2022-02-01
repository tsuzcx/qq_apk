package com.tencent.mm.ui.chatting;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
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
import com.tencent.mm.al.j;
import com.tencent.mm.plugin.newtips.a.i;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.MMListPopupWindow;
import com.tencent.mm.ui.base.o;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class g
  implements View.OnKeyListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener
{
  j HLA;
  private boolean HLB;
  private Boolean HLe;
  Map<String, an> HLf;
  List<an> HLg;
  AdapterView.OnItemClickListener HLt;
  String HLu;
  private ViewGroup HLv;
  private b HLw;
  private MMListPopupWindow HLx;
  private int HLy;
  private int HLz;
  boolean dvX;
  private int height;
  private Context mContext;
  private int mCount;
  private LayoutInflater mInflater;
  
  public g(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(34351);
    this.HLt = null;
    this.HLe = Boolean.FALSE;
    this.HLu = "";
    this.dvX = false;
    this.HLf = new ConcurrentHashMap();
    this.HLg = new ArrayList();
    this.mContext = null;
    this.HLv = null;
    this.HLw = null;
    this.HLy = 2131821491;
    this.HLA = null;
    this.HLB = true;
    this.mContext = paramContext;
    this.HLv = paramViewGroup;
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    fkR();
    this.HLw = new b((byte)0);
    AppMethodBeat.o(34351);
  }
  
  private int b(ListAdapter paramListAdapter)
  {
    AppMethodBeat.i(34355);
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
        break label137;
      }
      localView = null;
      i = m;
    }
    label137:
    for (;;)
    {
      if (this.HLv == null) {
        this.HLv = new FrameLayout(this.mContext);
      }
      localView = paramListAdapter.getView(j, localView, this.HLv);
      localView.measure(n, i1);
      k = Math.max(k, localView.getMeasuredWidth());
      j += 1;
      break;
      AppMethodBeat.o(34355);
      return k;
    }
  }
  
  @SuppressLint({"WrongCall"})
  public final boolean a(j paramj, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(34352);
    if ((!isShowing()) && (paramj != null) && (paramj.hxQ != null) && (paramj.hxQ.size() > 0))
    {
      this.HLB = false;
      this.HLA = paramj;
      this.mCount = paramj.hxQ.size();
      this.HLw.notifyDataSetChanged();
      this.height = ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay().getHeight();
      TextView localTextView = (TextView)((LayoutInflater)this.mContext.getSystemService("layout_inflater")).inflate(2131495102, null);
      paramj = g.a.a(this.mContext, localTextView.getPaint(), paramj.hxQ, paramInt1);
      this.HLz = (paramInt2 - this.HLw.getCount() * this.mContext.getResources().getDimensionPixelSize(2131165567) - this.mContext.getResources().getDimensionPixelSize(2131165371));
      ac.d("MicroMsg.ChatFooterCustomSubmenu", "showPointY=" + paramInt2 + "verticalOffset=" + this.HLz);
      this.HLx = new MMListPopupWindow(this.mContext, null, 0);
      this.HLx.setOnDismissListener(this);
      this.HLx.apn = this.HLt;
      this.HLx.setAdapter(this.HLw);
      this.HLx.setModal(true);
      this.HLx.setBackgroundDrawable(this.mContext.getResources().getDrawable(2131234275));
      this.HLx.setAnimationStyle(this.HLy);
      this.HLx.apa = paramj.mIg;
      this.HLx.setVerticalOffset(this.HLz);
      this.HLx.apl = this.HLv;
      this.HLx.setContentWidth(b(this.HLw));
      this.HLx.kg();
      this.HLx.show();
      this.HLx.Hyb.setOnKeyListener(this);
      this.HLx.Hyb.setDivider(new ColorDrawable(this.mContext.getResources().getColor(2131100886)));
      this.HLx.Hyb.setSelector(this.mContext.getResources().getDrawable(2131233634));
      this.HLx.Hyb.setDividerHeight(1);
      this.HLx.Hyb.setVerticalScrollBarEnabled(false);
      this.HLx.Hyb.setHorizontalScrollBarEnabled(false);
      this.HLx.Hyb.setBackgroundColor(ao.aJ(this.mContext, 2130968582));
      AppMethodBeat.o(34352);
      return true;
    }
    AppMethodBeat.o(34352);
    return false;
  }
  
  public final void d(j paramj)
  {
    AppMethodBeat.i(196419);
    ac.d("MicroMsg.ChatFooterCustomSubmenu", "registerRedDotComponentForSubMenu subMeubConut：%s", new Object[] { Integer.valueOf(paramj.hxQ.size()) });
    this.HLe = Boolean.TRUE;
    int i = 0;
    for (;;)
    {
      j localj;
      if (i < paramj.hxQ.size())
      {
        localj = (j)paramj.hxQ.get(i);
        ac.d("MicroMsg.ChatFooterCustomSubmenu", "registerRedDotComponentForMenu key：%s，name：%s", new Object[] { localj.key, localj.name });
        if (this.HLf.containsKey(localj.key)) {
          ac.d("MicroMsg.ChatFooterCustomSubmenu", "this key has register");
        }
      }
      else
      {
        ac.d("MicroMsg.ChatFooterCustomSubmenu", "mRedDotCompoentList：%s,mRedDotCompoents:%s", new Object[] { Integer.valueOf(this.HLf.size()), Integer.valueOf(this.HLg.size()) });
        AppMethodBeat.o(196419);
        return;
      }
      an localan = new an(this.mContext, localj.key, new an.a()
      {
        public final void G(boolean paramAnonymousBoolean, String paramAnonymousString)
        {
          AppMethodBeat.i(196418);
          ac.d("MicroMsg.ChatFooterCustomSubmenu", "OnShowRedDot showTextView：%s，key ：%s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), paramAnonymousString });
          g.b(g.this, paramAnonymousString);
          g.a(g.this, paramAnonymousBoolean);
          AppMethodBeat.o(196418);
        }
      });
      com.tencent.mm.plugin.newtips.a.dkb().h(localan);
      this.HLf.put(localj.key, localan);
      this.HLg.add(localan);
      ac.d("MicroMsg.ChatFooterCustomSubmenu", " Register key ：%s", new Object[] { localj.key });
      i += 1;
    }
  }
  
  public final boolean fkR()
  {
    AppMethodBeat.i(34354);
    if (isShowing())
    {
      this.HLx.dismiss();
      AppMethodBeat.o(34354);
      return true;
    }
    AppMethodBeat.o(34354);
    return false;
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(34353);
    if ((this.HLx != null) && (this.HLx.jat.isShowing()))
    {
      AppMethodBeat.o(34353);
      return true;
    }
    AppMethodBeat.o(34353);
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
    
    private j aaC(int paramInt)
    {
      AppMethodBeat.i(34348);
      j localj = (j)g.b(g.this).hxQ.get(paramInt);
      AppMethodBeat.o(34348);
      return localj;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(34347);
      int i = g.a(g.this);
      AppMethodBeat.o(34347);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(34349);
      if (paramView == null)
      {
        paramView = (TextView)g.c(g.this).inflate(2131495102, paramViewGroup, false);
        paramViewGroup = aaC(paramInt);
        paramView.setTag(paramViewGroup);
        if (!g.a(g.this, paramViewGroup.key)) {
          break label222;
        }
        ac.i("MicroMsg.ChatFooterCustomSubmenu", "showRedDotTextView：%s", new Object[] { paramViewGroup.key });
        paramView.setEllipsize(null);
        Object localObject = g.d(g.this).getResources().getDrawable(2131234447);
        ((Drawable)localObject).setBounds(0, 0, ao.fromDPToPix(g.d(g.this), 8), ao.fromDPToPix(g.d(g.this), 8));
        localObject = new com.tencent.mm.ui.widget.a((Drawable)localObject);
        SpannableString localSpannableString = new SpannableString("@");
        localSpannableString.setSpan(localObject, 0, 1, 33);
        paramView.setText(TextUtils.concat(new CharSequence[] { k.c(g.d(g.this), paramViewGroup.name) + " ", localSpannableString }));
      }
      for (;;)
      {
        AppMethodBeat.o(34349);
        return paramView;
        paramView = (TextView)paramView;
        break;
        label222:
        paramView.setText(k.c(g.d(g.this), paramViewGroup.name));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.g
 * JD-Core Version:    0.7.0.1
 */