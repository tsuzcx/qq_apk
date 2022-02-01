package com.tencent.mm.ui.chatting;

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
import com.tencent.mm.an.k;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.newtips.a.i;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.MMListPopupWindow;
import com.tencent.mm.ui.base.v;
import com.tencent.mm.ui.bd;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class h
  implements View.OnKeyListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener
{
  private int Hzm;
  private Boolean aefF;
  Map<String, ar> aefG;
  List<ar> aefH;
  AdapterView.OnItemClickListener aefU;
  String aefV;
  private ViewGroup aefW;
  private b aefX;
  private MMListPopupWindow aefY;
  private int aefZ;
  k aega;
  private boolean aegb;
  private int height;
  boolean iaS;
  private Context mContext;
  private int mCount;
  private LayoutInflater mInflater;
  
  public h(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(34351);
    this.aefU = null;
    this.aefF = Boolean.FALSE;
    this.aefV = "";
    this.iaS = false;
    this.aefG = new ConcurrentHashMap();
    this.aefH = new ArrayList();
    this.mContext = null;
    this.aefW = null;
    this.aefX = null;
    this.aefZ = R.m.UpMenuAnimation;
    this.aega = null;
    this.aegb = true;
    this.mContext = paramContext;
    this.aefW = paramViewGroup;
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    diW();
    this.aefX = new b((byte)0);
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
      if (this.aefW == null) {
        this.aefW = new FrameLayout(this.mContext);
      }
      localView = paramListAdapter.getView(j, localView, this.aefW);
      localView.measure(n, i1);
      k = Math.max(k, localView.getMeasuredWidth());
      j += 1;
      break;
      AppMethodBeat.o(34355);
      return k;
    }
  }
  
  public final boolean a(k paramk, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(34352);
    if ((!isShowing()) && (paramk != null) && (paramk.owo != null) && (paramk.owo.size() > 0))
    {
      this.aegb = false;
      this.aega = paramk;
      this.mCount = paramk.owo.size();
      this.aefX.notifyDataSetChanged();
      this.height = ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay().getHeight();
      TextView localTextView = (TextView)((LayoutInflater)this.mContext.getSystemService("layout_inflater")).inflate(R.i.popup_submenu_item, null);
      paramk = h.a.a(this.mContext, localTextView.getPaint(), paramk.owo, paramInt1);
      this.Hzm = (paramInt2 - this.aefX.getCount() * this.mContext.getResources().getDimensionPixelSize(R.f.SmallListHeight) - this.mContext.getResources().getDimensionPixelSize(R.f.FooterPadding));
      Log.d("MicroMsg.ChatFooterCustomSubmenu", "showPointY=" + paramInt2 + "verticalOffset=" + this.Hzm);
      this.aefY = new MMListPopupWindow(this.mContext, null, 0);
      this.aefY.setOnDismissListener(this);
      this.aefY.un = this.aefU;
      this.aefY.setAdapter(this.aefX);
      this.aefY.LA(true);
      this.aefY.setBackgroundDrawable(this.mContext.getResources().getDrawable(R.g.sub_menu_bg));
      this.aefY.aAU(this.aefZ);
      this.aefY.tZ = paramk.uLg;
      this.aefY.ad(this.Hzm);
      this.aefY.ul = this.aefW;
      this.aefY.setContentWidth(c(this.aefX));
      this.aefY.eN();
      this.aefY.show();
      this.aefY.adRQ.setOnKeyListener(this);
      this.aefY.adRQ.setDivider(new ColorDrawable(this.mContext.getResources().getColor(R.e.small_line_color)));
      this.aefY.adRQ.setSelector(this.mContext.getResources().getDrawable(R.g.popup_menu_selector));
      this.aefY.adRQ.setDividerHeight(1);
      this.aefY.adRQ.setVerticalScrollBarEnabled(false);
      this.aefY.adRQ.setHorizontalScrollBarEnabled(false);
      this.aefY.adRQ.setBackgroundColor(this.mContext.getResources().getColor(R.e.BG_5));
      AppMethodBeat.o(34352);
      return true;
    }
    AppMethodBeat.o(34352);
    return false;
  }
  
  public final void d(k paramk)
  {
    AppMethodBeat.i(253946);
    Log.d("MicroMsg.ChatFooterCustomSubmenu", "registerRedDotComponentForSubMenu subMeubConut：%s", new Object[] { Integer.valueOf(paramk.owo.size()) });
    this.aefF = Boolean.TRUE;
    int i = 0;
    for (;;)
    {
      k localk;
      if (i < paramk.owo.size())
      {
        localk = (k)paramk.owo.get(i);
        Log.d("MicroMsg.ChatFooterCustomSubmenu", "registerRedDotComponentForMenu key：%s，name：%s", new Object[] { localk.key, localk.name });
        if (this.aefG.containsKey(localk.key)) {
          Log.d("MicroMsg.ChatFooterCustomSubmenu", "this key has register");
        }
      }
      else
      {
        Log.d("MicroMsg.ChatFooterCustomSubmenu", "mRedDotCompoentList：%s,mRedDotCompoents:%s", new Object[] { Integer.valueOf(this.aefG.size()), Integer.valueOf(this.aefH.size()) });
        AppMethodBeat.o(253946);
        return;
      }
      ar localar = new ar(this.mContext, localk.key, new ar.a()
      {
        public final void aR(boolean paramAnonymousBoolean, String paramAnonymousString)
        {
          AppMethodBeat.i(253727);
          Log.d("MicroMsg.ChatFooterCustomSubmenu", "OnShowRedDot showTextView：%s，key ：%s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), paramAnonymousString });
          h.b(h.this, paramAnonymousString);
          h.a(h.this, paramAnonymousBoolean);
          AppMethodBeat.o(253727);
        }
      });
      com.tencent.mm.plugin.newtips.a.gtf().h(localar);
      this.aefG.put(localk.key, localar);
      this.aefH.add(localar);
      Log.d("MicroMsg.ChatFooterCustomSubmenu", " Register key ：%s", new Object[] { localk.key });
      i += 1;
    }
  }
  
  public final boolean diW()
  {
    AppMethodBeat.i(34354);
    if (isShowing())
    {
      this.aefY.dismiss();
      AppMethodBeat.o(34354);
      return true;
    }
    AppMethodBeat.o(34354);
    return false;
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(34353);
    if ((this.aefY != null) && (this.aefY.qjH.isShowing()))
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
    AppMethodBeat.i(253940);
    b localb = new b();
    localb.cH(paramAdapterView);
    localb.cH(paramView);
    localb.sc(paramInt);
    localb.hB(paramLong);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/ChatFooterCustomSubmenu", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChatFooterCustomSubmenu", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(253940);
  }
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(253936);
    b localb = new b();
    localb.cH(paramView);
    localb.sc(paramInt);
    localb.cH(paramKeyEvent);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/ui/chatting/ChatFooterCustomSubmenu", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/chatting/ChatFooterCustomSubmenu", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
    AppMethodBeat.o(253936);
    return false;
  }
  
  final class b
    extends BaseAdapter
  {
    private b() {}
    
    private k aBH(int paramInt)
    {
      AppMethodBeat.i(34348);
      k localk = (k)h.b(h.this).owo.get(paramInt);
      AppMethodBeat.o(34348);
      return localk;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(34347);
      int i = h.a(h.this);
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
        paramView = (TextView)h.c(h.this).inflate(R.i.popup_submenu_item, paramViewGroup, false);
        paramViewGroup = aBH(paramInt);
        paramView.setTag(paramViewGroup);
        if (!h.a(h.this, paramViewGroup.key)) {
          break label225;
        }
        Log.i("MicroMsg.ChatFooterCustomSubmenu", "showRedDotTextView：%s", new Object[] { paramViewGroup.key });
        paramView.setEllipsize(null);
        Object localObject = h.d(h.this).getResources().getDrawable(R.g.unread_dot_shape);
        ((Drawable)localObject).setBounds(0, 0, bd.fromDPToPix(h.d(h.this), 8), bd.fromDPToPix(h.d(h.this), 8));
        localObject = new com.tencent.mm.ui.widget.a((Drawable)localObject, 1);
        SpannableString localSpannableString = new SpannableString("@");
        localSpannableString.setSpan(localObject, 0, 1, 33);
        paramView.setText(TextUtils.concat(new CharSequence[] { p.b(h.d(h.this), paramViewGroup.name) + " ", localSpannableString }));
      }
      for (;;)
      {
        AppMethodBeat.o(34349);
        return paramView;
        paramView = (TextView)paramView;
        break;
        label225:
        paramView.setText(p.b(h.d(h.this), paramViewGroup.name));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.h
 * JD-Core Version:    0.7.0.1
 */