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
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.g;
import com.tencent.mm.R.i;
import com.tencent.mm.R.m;
import com.tencent.mm.ao.k;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.newtips.a.i;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.MMListPopupWindow;
import com.tencent.mm.ui.base.r;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class g
  implements View.OnKeyListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener
{
  private b WyA;
  private MMListPopupWindow WyB;
  private int WyC;
  private int WyD;
  k WyE;
  private boolean WyF;
  private Boolean Wyi;
  Map<String, ap> Wyj;
  List<ap> Wyk;
  AdapterView.OnItemClickListener Wyx;
  String Wyy;
  private ViewGroup Wyz;
  boolean fUV;
  private int height;
  private Context mContext;
  private int mCount;
  private LayoutInflater mInflater;
  
  public g(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(34351);
    this.Wyx = null;
    this.Wyi = Boolean.FALSE;
    this.Wyy = "";
    this.fUV = false;
    this.Wyj = new ConcurrentHashMap();
    this.Wyk = new ArrayList();
    this.mContext = null;
    this.Wyz = null;
    this.WyA = null;
    this.WyC = R.m.UpMenuAnimation;
    this.WyE = null;
    this.WyF = true;
    this.mContext = paramContext;
    this.Wyz = paramViewGroup;
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    cFD();
    this.WyA = new b((byte)0);
    AppMethodBeat.o(34351);
  }
  
  private int c(ListAdapter paramListAdapter)
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
      if (this.Wyz == null) {
        this.Wyz = new FrameLayout(this.mContext);
      }
      localView = paramListAdapter.getView(j, localView, this.Wyz);
      localView.measure(n, i1);
      k = Math.max(k, localView.getMeasuredWidth());
      j += 1;
      break;
      AppMethodBeat.o(34355);
      return k;
    }
  }
  
  @SuppressLint({"WrongCall"})
  public final boolean a(k paramk, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(34352);
    if ((!isShowing()) && (paramk != null) && (paramk.lEI != null) && (paramk.lEI.size() > 0))
    {
      this.WyF = false;
      this.WyE = paramk;
      this.mCount = paramk.lEI.size();
      this.WyA.notifyDataSetChanged();
      this.height = ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay().getHeight();
      TextView localTextView = (TextView)((LayoutInflater)this.mContext.getSystemService("layout_inflater")).inflate(R.i.popup_submenu_item, null);
      paramk = g.a.a(this.mContext, localTextView.getPaint(), paramk.lEI, paramInt1);
      this.WyD = (paramInt2 - this.WyA.getCount() * this.mContext.getResources().getDimensionPixelSize(R.f.SmallListHeight) - this.mContext.getResources().getDimensionPixelSize(R.f.FooterPadding));
      Log.d("MicroMsg.ChatFooterCustomSubmenu", "showPointY=" + paramInt2 + "verticalOffset=" + this.WyD);
      this.WyB = new MMListPopupWindow(this.mContext, null, 0);
      this.WyB.setOnDismissListener(this);
      this.WyB.tp = this.Wyx;
      this.WyB.setAdapter(this.WyA);
      this.WyB.P(true);
      this.WyB.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.g.sub_menu_bg));
      this.WyB.ax(this.WyC);
      this.WyB.ta = paramk.rzP;
      this.WyB.ah(this.WyD);
      this.WyB.tl = this.Wyz;
      this.WyB.setContentWidth(c(this.WyA));
      this.WyB.dN();
      this.WyB.show();
      this.WyB.WkJ.setOnKeyListener(this);
      this.WyB.WkJ.setDivider(new ColorDrawable(this.mContext.getResources().getColor(R.e.small_line_color)));
      this.WyB.WkJ.setSelector(this.mContext.getResources().getDrawable(R.g.popup_menu_selector));
      this.WyB.WkJ.setDividerHeight(1);
      this.WyB.WkJ.setVerticalScrollBarEnabled(false);
      this.WyB.WkJ.setHorizontalScrollBarEnabled(false);
      this.WyB.WkJ.setBackgroundColor(this.mContext.getResources().getColor(R.e.BG_5));
      AppMethodBeat.o(34352);
      return true;
    }
    AppMethodBeat.o(34352);
    return false;
  }
  
  public final boolean cFD()
  {
    AppMethodBeat.i(34354);
    if (isShowing())
    {
      this.WyB.dismiss();
      AppMethodBeat.o(34354);
      return true;
    }
    AppMethodBeat.o(34354);
    return false;
  }
  
  public final void d(k paramk)
  {
    AppMethodBeat.i(281192);
    Log.d("MicroMsg.ChatFooterCustomSubmenu", "registerRedDotComponentForSubMenu subMeubConut：%s", new Object[] { Integer.valueOf(paramk.lEI.size()) });
    this.Wyi = Boolean.TRUE;
    int i = 0;
    for (;;)
    {
      k localk;
      if (i < paramk.lEI.size())
      {
        localk = (k)paramk.lEI.get(i);
        Log.d("MicroMsg.ChatFooterCustomSubmenu", "registerRedDotComponentForMenu key：%s，name：%s", new Object[] { localk.key, localk.name });
        if (this.Wyj.containsKey(localk.key)) {
          Log.d("MicroMsg.ChatFooterCustomSubmenu", "this key has register");
        }
      }
      else
      {
        Log.d("MicroMsg.ChatFooterCustomSubmenu", "mRedDotCompoentList：%s,mRedDotCompoents:%s", new Object[] { Integer.valueOf(this.Wyj.size()), Integer.valueOf(this.Wyk.size()) });
        AppMethodBeat.o(281192);
        return;
      }
      ap localap = new ap(this.mContext, localk.key, new ap.a()
      {
        public final void U(boolean paramAnonymousBoolean, String paramAnonymousString)
        {
          AppMethodBeat.i(274412);
          Log.d("MicroMsg.ChatFooterCustomSubmenu", "OnShowRedDot showTextView：%s，key ：%s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), paramAnonymousString });
          g.b(g.this, paramAnonymousString);
          g.a(g.this, paramAnonymousBoolean);
          AppMethodBeat.o(274412);
        }
      });
      com.tencent.mm.plugin.newtips.a.fiO().h(localap);
      this.Wyj.put(localk.key, localap);
      this.Wyk.add(localap);
      Log.d("MicroMsg.ChatFooterCustomSubmenu", " Register key ：%s", new Object[] { localk.key });
      i += 1;
    }
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(34353);
    if ((this.WyB != null) && (this.WyB.nmy.isShowing()))
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
    AppMethodBeat.i(281191);
    b localb = new b();
    localb.bn(paramAdapterView);
    localb.bn(paramView);
    localb.sg(paramInt);
    localb.Fs(paramLong);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/ChatFooterCustomSubmenu", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aFi());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChatFooterCustomSubmenu", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(281191);
  }
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(281190);
    b localb = new b();
    localb.bn(paramView);
    localb.sg(paramInt);
    localb.bn(paramKeyEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/ChatFooterCustomSubmenu", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.aFi());
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/chatting/ChatFooterCustomSubmenu", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
    AppMethodBeat.o(281190);
    return false;
  }
  
  final class b
    extends BaseAdapter
  {
    private b() {}
    
    private k avf(int paramInt)
    {
      AppMethodBeat.i(34348);
      k localk = (k)g.b(g.this).lEI.get(paramInt);
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
        paramView = (TextView)g.c(g.this).inflate(R.i.popup_submenu_item, paramViewGroup, false);
        paramViewGroup = avf(paramInt);
        paramView.setTag(paramViewGroup);
        if (!g.a(g.this, paramViewGroup.key)) {
          break label225;
        }
        Log.i("MicroMsg.ChatFooterCustomSubmenu", "showRedDotTextView：%s", new Object[] { paramViewGroup.key });
        paramView.setEllipsize(null);
        Object localObject = g.d(g.this).getResources().getDrawable(R.g.unread_dot_shape);
        ((Drawable)localObject).setBounds(0, 0, aw.fromDPToPix(g.d(g.this), 8), aw.fromDPToPix(g.d(g.this), 8));
        localObject = new com.tencent.mm.ui.widget.a((Drawable)localObject, 1);
        SpannableString localSpannableString = new SpannableString("@");
        localSpannableString.setSpan(localObject, 0, 1, 33);
        paramView.setText(TextUtils.concat(new CharSequence[] { l.c(g.d(g.this), paramViewGroup.name) + " ", localSpannableString }));
      }
      for (;;)
      {
        AppMethodBeat.o(34349);
        return paramView;
        paramView = (TextView)paramView;
        break;
        label225:
        paramView.setText(l.c(g.d(g.this), paramViewGroup.name));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.g
 * JD-Core Version:    0.7.0.1
 */