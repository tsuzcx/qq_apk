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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.newtips.a.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.base.MMListPopupWindow;
import com.tencent.mm.ui.base.o;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class g
  implements View.OnKeyListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener
{
  private Boolean JyV;
  Map<String, an> JyW;
  List<an> JyX;
  AdapterView.OnItemClickListener Jzk;
  String Jzl;
  private ViewGroup Jzm;
  private b Jzn;
  private MMListPopupWindow Jzo;
  private int Jzp;
  private int Jzq;
  com.tencent.mm.am.k Jzr;
  private boolean Jzs;
  boolean dIh;
  private int height;
  private Context mContext;
  private int mCount;
  private LayoutInflater mInflater;
  
  public g(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(34351);
    this.Jzk = null;
    this.JyV = Boolean.FALSE;
    this.Jzl = "";
    this.dIh = false;
    this.JyW = new ConcurrentHashMap();
    this.JyX = new ArrayList();
    this.mContext = null;
    this.Jzm = null;
    this.Jzn = null;
    this.Jzp = 2131821491;
    this.Jzr = null;
    this.Jzs = true;
    this.mContext = paramContext;
    this.Jzm = paramViewGroup;
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    fBg();
    this.Jzn = new b((byte)0);
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
      if (this.Jzm == null) {
        this.Jzm = new FrameLayout(this.mContext);
      }
      localView = paramListAdapter.getView(j, localView, this.Jzm);
      localView.measure(n, i1);
      k = Math.max(k, localView.getMeasuredWidth());
      j += 1;
      break;
      AppMethodBeat.o(34355);
      return k;
    }
  }
  
  @SuppressLint({"WrongCall"})
  public final boolean a(com.tencent.mm.am.k paramk, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(34352);
    if ((!isShowing()) && (paramk != null) && (paramk.hQl != null) && (paramk.hQl.size() > 0))
    {
      this.Jzs = false;
      this.Jzr = paramk;
      this.mCount = paramk.hQl.size();
      this.Jzn.notifyDataSetChanged();
      this.height = ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay().getHeight();
      TextView localTextView = (TextView)((LayoutInflater)this.mContext.getSystemService("layout_inflater")).inflate(2131495102, null);
      paramk = g.a.a(this.mContext, localTextView.getPaint(), paramk.hQl, paramInt1);
      this.Jzq = (paramInt2 - this.Jzn.getCount() * this.mContext.getResources().getDimensionPixelSize(2131165567) - this.mContext.getResources().getDimensionPixelSize(2131165371));
      ad.d("MicroMsg.ChatFooterCustomSubmenu", "showPointY=" + paramInt2 + "verticalOffset=" + this.Jzq);
      this.Jzo = new MMListPopupWindow(this.mContext, null, 0);
      this.Jzo.setOnDismissListener(this);
      this.Jzo.arf = this.Jzk;
      this.Jzo.setAdapter(this.Jzn);
      this.Jzo.setModal(true);
      this.Jzo.setBackgroundDrawable(this.mContext.getResources().getDrawable(2131234275));
      this.Jzo.setAnimationStyle(this.Jzp);
      this.Jzo.aqS = paramk.niD;
      this.Jzo.setVerticalOffset(this.Jzq);
      this.Jzo.ard = this.Jzm;
      this.Jzo.setContentWidth(b(this.Jzn));
      this.Jzo.kw();
      this.Jzo.show();
      this.Jzo.JlR.setOnKeyListener(this);
      this.Jzo.JlR.setDivider(new ColorDrawable(this.mContext.getResources().getColor(2131100886)));
      this.Jzo.JlR.setSelector(this.mContext.getResources().getDrawable(2131233634));
      this.Jzo.JlR.setDividerHeight(1);
      this.Jzo.JlR.setVerticalScrollBarEnabled(false);
      this.Jzo.JlR.setHorizontalScrollBarEnabled(false);
      this.Jzo.JlR.setBackgroundColor(this.mContext.getResources().getColor(2131099653));
      AppMethodBeat.o(34352);
      return true;
    }
    AppMethodBeat.o(34352);
    return false;
  }
  
  public final void d(com.tencent.mm.am.k paramk)
  {
    AppMethodBeat.i(193840);
    ad.d("MicroMsg.ChatFooterCustomSubmenu", "registerRedDotComponentForSubMenu subMeubConut：%s", new Object[] { Integer.valueOf(paramk.hQl.size()) });
    this.JyV = Boolean.TRUE;
    int i = 0;
    for (;;)
    {
      com.tencent.mm.am.k localk;
      if (i < paramk.hQl.size())
      {
        localk = (com.tencent.mm.am.k)paramk.hQl.get(i);
        ad.d("MicroMsg.ChatFooterCustomSubmenu", "registerRedDotComponentForMenu key：%s，name：%s", new Object[] { localk.key, localk.name });
        if (this.JyW.containsKey(localk.key)) {
          ad.d("MicroMsg.ChatFooterCustomSubmenu", "this key has register");
        }
      }
      else
      {
        ad.d("MicroMsg.ChatFooterCustomSubmenu", "mRedDotCompoentList：%s,mRedDotCompoents:%s", new Object[] { Integer.valueOf(this.JyW.size()), Integer.valueOf(this.JyX.size()) });
        AppMethodBeat.o(193840);
        return;
      }
      an localan = new an(this.mContext, localk.key, new an.a()
      {
        public final void L(boolean paramAnonymousBoolean, String paramAnonymousString)
        {
          AppMethodBeat.i(193837);
          ad.d("MicroMsg.ChatFooterCustomSubmenu", "OnShowRedDot showTextView：%s，key ：%s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), paramAnonymousString });
          g.b(g.this, paramAnonymousString);
          g.a(g.this, paramAnonymousBoolean);
          AppMethodBeat.o(193837);
        }
      });
      com.tencent.mm.plugin.newtips.a.dun().h(localan);
      this.JyW.put(localk.key, localan);
      this.JyX.add(localan);
      ad.d("MicroMsg.ChatFooterCustomSubmenu", " Register key ：%s", new Object[] { localk.key });
      i += 1;
    }
  }
  
  public final boolean fBg()
  {
    AppMethodBeat.i(34354);
    if (isShowing())
    {
      this.Jzo.dismiss();
      AppMethodBeat.o(34354);
      return true;
    }
    AppMethodBeat.o(34354);
    return false;
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(34353);
    if ((this.Jzo != null) && (this.Jzo.jtC.isShowing()))
    {
      AppMethodBeat.o(34353);
      return true;
    }
    AppMethodBeat.o(34353);
    return false;
  }
  
  public final void onDismiss() {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(193839);
    b localb = new b();
    localb.bd(paramAdapterView);
    localb.bd(paramView);
    localb.mr(paramInt);
    localb.qY(paramLong);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChatFooterCustomSubmenu", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahq());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChatFooterCustomSubmenu", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(193839);
  }
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(193838);
    b localb = new b();
    localb.bd(paramView);
    localb.mr(paramInt);
    localb.bd(paramKeyEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChatFooterCustomSubmenu", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.ahq());
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/chatting/ChatFooterCustomSubmenu", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
    AppMethodBeat.o(193838);
    return false;
  }
  
  final class b
    extends BaseAdapter
  {
    private b() {}
    
    private com.tencent.mm.am.k acM(int paramInt)
    {
      AppMethodBeat.i(34348);
      com.tencent.mm.am.k localk = (com.tencent.mm.am.k)g.b(g.this).hQl.get(paramInt);
      AppMethodBeat.o(34348);
      return localk;
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
        paramViewGroup = acM(paramInt);
        paramView.setTag(paramViewGroup);
        if (!g.a(g.this, paramViewGroup.key)) {
          break label222;
        }
        ad.i("MicroMsg.ChatFooterCustomSubmenu", "showRedDotTextView：%s", new Object[] { paramViewGroup.key });
        paramView.setEllipsize(null);
        Object localObject = g.d(g.this).getResources().getDrawable(2131234447);
        ((Drawable)localObject).setBounds(0, 0, aq.fromDPToPix(g.d(g.this), 8), aq.fromDPToPix(g.d(g.this), 8));
        localObject = new com.tencent.mm.ui.widget.a((Drawable)localObject);
        SpannableString localSpannableString = new SpannableString("@");
        localSpannableString.setSpan(localObject, 0, 1, 33);
        paramView.setText(TextUtils.concat(new CharSequence[] { com.tencent.mm.pluginsdk.ui.span.k.c(g.d(g.this), paramViewGroup.name) + " ", localSpannableString }));
      }
      for (;;)
      {
        AppMethodBeat.o(34349);
        return paramView;
        paramView = (TextView)paramView;
        break;
        label222:
        paramView.setText(com.tencent.mm.pluginsdk.ui.span.k.c(g.d(g.this), paramViewGroup.name));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.g
 * JD-Core Version:    0.7.0.1
 */