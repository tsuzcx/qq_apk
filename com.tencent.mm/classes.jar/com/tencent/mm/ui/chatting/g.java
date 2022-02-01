package com.tencent.mm.ui.chatting;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.aq;
import com.tencent.mm.ui.as;
import com.tencent.mm.ui.base.MMListPopupWindow;
import com.tencent.mm.ui.base.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class g
  implements View.OnKeyListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener
{
  private Boolean JTL;
  Map<String, ao> JTM;
  List<ao> JTN;
  AdapterView.OnItemClickListener JUa;
  String JUb;
  private ViewGroup JUc;
  private b JUd;
  private MMListPopupWindow JUe;
  private int JUf;
  private int JUg;
  com.tencent.mm.al.k JUh;
  private boolean JUi;
  boolean dJl;
  private int height;
  private Context mContext;
  private int mCount;
  private LayoutInflater mInflater;
  
  public g(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(34351);
    this.JUa = null;
    this.JTL = Boolean.FALSE;
    this.JUb = "";
    this.dJl = false;
    this.JTM = new ConcurrentHashMap();
    this.JTN = new ArrayList();
    this.mContext = null;
    this.JUc = null;
    this.JUd = null;
    this.JUf = 2131821491;
    this.JUh = null;
    this.JUi = true;
    this.mContext = paramContext;
    this.JUc = paramViewGroup;
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    fFi();
    this.JUd = new b((byte)0);
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
      if (this.JUc == null) {
        this.JUc = new FrameLayout(this.mContext);
      }
      localView = paramListAdapter.getView(j, localView, this.JUc);
      localView.measure(n, i1);
      k = Math.max(k, localView.getMeasuredWidth());
      j += 1;
      break;
      AppMethodBeat.o(34355);
      return k;
    }
  }
  
  @SuppressLint({"WrongCall"})
  public final boolean a(com.tencent.mm.al.k paramk, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(34352);
    if ((!isShowing()) && (paramk != null) && (paramk.hTd != null) && (paramk.hTd.size() > 0))
    {
      this.JUi = false;
      this.JUh = paramk;
      this.mCount = paramk.hTd.size();
      this.JUd.notifyDataSetChanged();
      this.height = ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay().getHeight();
      TextView localTextView = (TextView)((LayoutInflater)this.mContext.getSystemService("layout_inflater")).inflate(2131495102, null);
      paramk = a.a(this.mContext, localTextView.getPaint(), paramk.hTd, paramInt1);
      this.JUg = (paramInt2 - this.JUd.getCount() * this.mContext.getResources().getDimensionPixelSize(2131165567) - this.mContext.getResources().getDimensionPixelSize(2131165371));
      ae.d("MicroMsg.ChatFooterCustomSubmenu", "showPointY=" + paramInt2 + "verticalOffset=" + this.JUg);
      this.JUe = new MMListPopupWindow(this.mContext, null, 0);
      this.JUe.setOnDismissListener(this);
      this.JUe.arf = this.JUa;
      this.JUe.setAdapter(this.JUd);
      this.JUe.setModal(true);
      this.JUe.setBackgroundDrawable(this.mContext.getResources().getDrawable(2131234275));
      this.JUe.setAnimationStyle(this.JUf);
      this.JUe.aqS = paramk.nnL;
      this.JUe.setVerticalOffset(this.JUg);
      this.JUe.ard = this.JUc;
      this.JUe.setContentWidth(b(this.JUd));
      this.JUe.kw();
      this.JUe.show();
      this.JUe.JGF.setOnKeyListener(this);
      this.JUe.JGF.setDivider(new ColorDrawable(this.mContext.getResources().getColor(2131100886)));
      this.JUe.JGF.setSelector(this.mContext.getResources().getDrawable(2131233634));
      this.JUe.JGF.setDividerHeight(1);
      this.JUe.JGF.setVerticalScrollBarEnabled(false);
      this.JUe.JGF.setHorizontalScrollBarEnabled(false);
      this.JUe.JGF.setBackgroundColor(this.mContext.getResources().getColor(2131099653));
      AppMethodBeat.o(34352);
      return true;
    }
    AppMethodBeat.o(34352);
    return false;
  }
  
  public final void d(com.tencent.mm.al.k paramk)
  {
    AppMethodBeat.i(187136);
    ae.d("MicroMsg.ChatFooterCustomSubmenu", "registerRedDotComponentForSubMenu subMeubConut：%s", new Object[] { Integer.valueOf(paramk.hTd.size()) });
    this.JTL = Boolean.TRUE;
    int i = 0;
    for (;;)
    {
      com.tencent.mm.al.k localk;
      if (i < paramk.hTd.size())
      {
        localk = (com.tencent.mm.al.k)paramk.hTd.get(i);
        ae.d("MicroMsg.ChatFooterCustomSubmenu", "registerRedDotComponentForMenu key：%s，name：%s", new Object[] { localk.key, localk.name });
        if (this.JTM.containsKey(localk.key)) {
          ae.d("MicroMsg.ChatFooterCustomSubmenu", "this key has register");
        }
      }
      else
      {
        ae.d("MicroMsg.ChatFooterCustomSubmenu", "mRedDotCompoentList：%s,mRedDotCompoents:%s", new Object[] { Integer.valueOf(this.JTM.size()), Integer.valueOf(this.JTN.size()) });
        AppMethodBeat.o(187136);
        return;
      }
      ao localao = new ao(this.mContext, localk.key, new ao.a()
      {
        public final void N(boolean paramAnonymousBoolean, String paramAnonymousString)
        {
          AppMethodBeat.i(187133);
          ae.d("MicroMsg.ChatFooterCustomSubmenu", "OnShowRedDot showTextView：%s，key ：%s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), paramAnonymousString });
          g.b(g.this, paramAnonymousString);
          g.a(g.this, paramAnonymousBoolean);
          AppMethodBeat.o(187133);
        }
      });
      com.tencent.mm.plugin.newtips.a.dxD().h(localao);
      this.JTM.put(localk.key, localao);
      this.JTN.add(localao);
      ae.d("MicroMsg.ChatFooterCustomSubmenu", " Register key ：%s", new Object[] { localk.key });
      i += 1;
    }
  }
  
  public final boolean fFi()
  {
    AppMethodBeat.i(34354);
    if (isShowing())
    {
      this.JUe.dismiss();
      AppMethodBeat.o(34354);
      return true;
    }
    AppMethodBeat.o(34354);
    return false;
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(34353);
    if ((this.JUe != null) && (this.JUe.jwx.isShowing()))
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
    AppMethodBeat.i(187135);
    b localb = new b();
    localb.bd(paramAdapterView);
    localb.bd(paramView);
    localb.mu(paramInt);
    localb.rl(paramLong);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChatFooterCustomSubmenu", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.ahF());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChatFooterCustomSubmenu", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(187135);
  }
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(187134);
    b localb = new b();
    localb.bd(paramView);
    localb.mu(paramInt);
    localb.bd(paramKeyEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChatFooterCustomSubmenu", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.ahF());
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/chatting/ChatFooterCustomSubmenu", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
    AppMethodBeat.o(187134);
    return false;
  }
  
  public static final class a
  {
    private static DisplayMetrics JUk = null;
    
    private static int a(Context paramContext, TextPaint paramTextPaint, List<com.tencent.mm.al.k> paramList)
    {
      AppMethodBeat.i(34345);
      paramList = paramList.iterator();
      float f1 = 0.0F;
      if (paramList.hasNext())
      {
        float f2 = paramTextPaint.measureText(((com.tencent.mm.al.k)paramList.next()).name);
        if (f1 >= f2) {
          break label79;
        }
        f1 = f2;
      }
      label79:
      for (;;)
      {
        break;
        int i = (int)f1;
        int j = com.tencent.mm.cb.a.fromDPToPix(paramContext, 30);
        AppMethodBeat.o(34345);
        return i + j * 2;
      }
    }
    
    public static g.a.a a(Context paramContext, TextPaint paramTextPaint, List<com.tencent.mm.al.k> paramList, int paramInt)
    {
      AppMethodBeat.i(34346);
      g.a.a locala = new g.a.a();
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      int k;
      int i;
      if ((paramContext instanceof Activity))
      {
        ((Activity)paramContext).getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
        Point localPoint = as.ck(paramContext);
        k = localDisplayMetrics.widthPixels;
        if ((k != localDisplayMetrics.widthPixels) || (localPoint.y != localDisplayMetrics.heightPixels)) {
          ae.e("MicroMsg.ChatFooterCustomSubmenu", "get screen param error!! width:%s, systermWidth:%s, height:%s, systermHeight:%s", new Object[] { Integer.valueOf(k), Integer.valueOf(localDisplayMetrics.widthPixels), Integer.valueOf(localPoint.y), Integer.valueOf(localDisplayMetrics.heightPixels) });
        }
        i = a(paramContext, paramTextPaint, paramList);
        int j = com.tencent.mm.cb.a.fromDPToPix(paramContext, 95);
        if (i >= j) {
          break label282;
        }
        i = j;
      }
      label282:
      for (;;)
      {
        if (paramInt - i / 2 < 0)
        {
          locala.nnK = 0;
          locala.nnL = (k - (i + 0));
        }
        for (;;)
        {
          AppMethodBeat.o(34346);
          return locala;
          if (JUk == null) {
            JUk = paramContext.getResources().getDisplayMetrics();
          }
          localDisplayMetrics = JUk;
          break;
          if (k - (i / 2 + paramInt) < 0)
          {
            locala.nnK = (k - (i + 0));
            locala.nnL = 0;
          }
          else
          {
            locala.nnK = (paramInt - i / 2);
            locala.nnL = (k - (i / 2 + paramInt));
          }
        }
      }
    }
  }
  
  final class b
    extends BaseAdapter
  {
    private b() {}
    
    private com.tencent.mm.al.k adu(int paramInt)
    {
      AppMethodBeat.i(34348);
      com.tencent.mm.al.k localk = (com.tencent.mm.al.k)g.b(g.this).hTd.get(paramInt);
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
        paramViewGroup = adu(paramInt);
        paramView.setTag(paramViewGroup);
        if (!g.a(g.this, paramViewGroup.key)) {
          break label222;
        }
        ae.i("MicroMsg.ChatFooterCustomSubmenu", "showRedDotTextView：%s", new Object[] { paramViewGroup.key });
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