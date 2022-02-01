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
import com.tencent.mm.al.k;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.newtips.a.i;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.av;
import com.tencent.mm.ui.base.MMListPopupWindow;
import com.tencent.mm.ui.base.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class g
  implements View.OnKeyListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener
{
  private Boolean PeQ;
  Map<String, ap> PeR;
  List<ap> PeS;
  AdapterView.OnItemClickListener Pff;
  String Pfg;
  private ViewGroup Pfh;
  private b Pfi;
  private MMListPopupWindow Pfj;
  private int Pfk;
  private int Pfl;
  k Pfm;
  private boolean Pfn;
  boolean eaY;
  private int height;
  private Context mContext;
  private int mCount;
  private LayoutInflater mInflater;
  
  public g(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(34351);
    this.Pff = null;
    this.PeQ = Boolean.FALSE;
    this.Pfg = "";
    this.eaY = false;
    this.PeR = new ConcurrentHashMap();
    this.PeS = new ArrayList();
    this.mContext = null;
    this.Pfh = null;
    this.Pfi = null;
    this.Pfk = 2131821537;
    this.Pfm = null;
    this.Pfn = true;
    this.mContext = paramContext;
    this.Pfh = paramViewGroup;
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    gNq();
    this.Pfi = new b((byte)0);
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
      if (this.Pfh == null) {
        this.Pfh = new FrameLayout(this.mContext);
      }
      localView = paramListAdapter.getView(j, localView, this.Pfh);
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
    if ((!isShowing()) && (paramk != null) && (paramk.iOs != null) && (paramk.iOs.size() > 0))
    {
      this.Pfn = false;
      this.Pfm = paramk;
      this.mCount = paramk.iOs.size();
      this.Pfi.notifyDataSetChanged();
      this.height = ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay().getHeight();
      TextView localTextView = (TextView)((LayoutInflater)this.mContext.getSystemService("layout_inflater")).inflate(2131495944, null);
      paramk = a.a(this.mContext, localTextView.getPaint(), paramk.iOs, paramInt1);
      this.Pfl = (paramInt2 - this.Pfi.getCount() * this.mContext.getResources().getDimensionPixelSize(2131165585) - this.mContext.getResources().getDimensionPixelSize(2131165382));
      Log.d("MicroMsg.ChatFooterCustomSubmenu", "showPointY=" + paramInt2 + "verticalOffset=" + this.Pfl);
      this.Pfj = new MMListPopupWindow(this.mContext, null, 0);
      this.Pfj.setOnDismissListener(this);
      this.Pfj.ars = this.Pff;
      this.Pfj.setAdapter(this.Pfi);
      this.Pfj.setModal(true);
      this.Pfj.setBackgroundDrawable(this.mContext.getResources().getDrawable(2131235152));
      this.Pfj.setAnimationStyle(this.Pfk);
      this.Pfj.are = paramk.oxr;
      this.Pfj.setVerticalOffset(this.Pfl);
      this.Pfj.arp = this.Pfh;
      this.Pfj.setContentWidth(b(this.Pfi));
      this.Pfj.kC();
      this.Pfj.show();
      this.Pfj.ORx.setOnKeyListener(this);
      this.Pfj.ORx.setDivider(new ColorDrawable(this.mContext.getResources().getColor(2131101085)));
      this.Pfj.ORx.setSelector(this.mContext.getResources().getDrawable(2131234447));
      this.Pfj.ORx.setDividerHeight(1);
      this.Pfj.ORx.setVerticalScrollBarEnabled(false);
      this.Pfj.ORx.setHorizontalScrollBarEnabled(false);
      this.Pfj.ORx.setBackgroundColor(this.mContext.getResources().getColor(2131099653));
      AppMethodBeat.o(34352);
      return true;
    }
    AppMethodBeat.o(34352);
    return false;
  }
  
  public final void d(k paramk)
  {
    AppMethodBeat.i(232847);
    Log.d("MicroMsg.ChatFooterCustomSubmenu", "registerRedDotComponentForSubMenu subMeubConut：%s", new Object[] { Integer.valueOf(paramk.iOs.size()) });
    this.PeQ = Boolean.TRUE;
    int i = 0;
    for (;;)
    {
      k localk;
      if (i < paramk.iOs.size())
      {
        localk = (k)paramk.iOs.get(i);
        Log.d("MicroMsg.ChatFooterCustomSubmenu", "registerRedDotComponentForMenu key：%s，name：%s", new Object[] { localk.key, localk.name });
        if (this.PeR.containsKey(localk.key)) {
          Log.d("MicroMsg.ChatFooterCustomSubmenu", "this key has register");
        }
      }
      else
      {
        Log.d("MicroMsg.ChatFooterCustomSubmenu", "mRedDotCompoentList：%s,mRedDotCompoents:%s", new Object[] { Integer.valueOf(this.PeR.size()), Integer.valueOf(this.PeS.size()) });
        AppMethodBeat.o(232847);
        return;
      }
      ap localap = new ap(this.mContext, localk.key, new ap.a()
      {
        public final void O(boolean paramAnonymousBoolean, String paramAnonymousString)
        {
          AppMethodBeat.i(232844);
          Log.d("MicroMsg.ChatFooterCustomSubmenu", "OnShowRedDot showTextView：%s，key ：%s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), paramAnonymousString });
          g.b(g.this, paramAnonymousString);
          g.a(g.this, paramAnonymousBoolean);
          AppMethodBeat.o(232844);
        }
      });
      com.tencent.mm.plugin.newtips.a.exl().h(localap);
      this.PeR.put(localk.key, localap);
      this.PeS.add(localap);
      Log.d("MicroMsg.ChatFooterCustomSubmenu", " Register key ：%s", new Object[] { localk.key });
      i += 1;
    }
  }
  
  public final boolean gNq()
  {
    AppMethodBeat.i(34354);
    if (isShowing())
    {
      this.Pfj.dismiss();
      AppMethodBeat.o(34354);
      return true;
    }
    AppMethodBeat.o(34354);
    return false;
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(34353);
    if ((this.Pfj != null) && (this.Pfj.kuK.isShowing()))
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
    AppMethodBeat.i(232846);
    b localb = new b();
    localb.bm(paramAdapterView);
    localb.bm(paramView);
    localb.pH(paramInt);
    localb.zo(paramLong);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChatFooterCustomSubmenu", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.axR());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/ui/chatting/ChatFooterCustomSubmenu", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
    AppMethodBeat.o(232846);
  }
  
  public final boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(232845);
    b localb = new b();
    localb.bm(paramView);
    localb.pH(paramInt);
    localb.bm(paramKeyEvent);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/ui/chatting/ChatFooterCustomSubmenu", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z", this, localb.axR());
    com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/ui/chatting/ChatFooterCustomSubmenu", "android/view/View$OnKeyListener", "onKey", "(Landroid/view/View;ILandroid/view/KeyEvent;)Z");
    AppMethodBeat.o(232845);
    return false;
  }
  
  public static final class a
  {
    private static DisplayMetrics Pfp = null;
    
    private static int a(Context paramContext, TextPaint paramTextPaint, List<k> paramList)
    {
      AppMethodBeat.i(34345);
      paramList = paramList.iterator();
      float f1 = 0.0F;
      if (paramList.hasNext())
      {
        float f2 = paramTextPaint.measureText(((k)paramList.next()).name);
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
    
    public static a a(Context paramContext, TextPaint paramTextPaint, List<k> paramList, int paramInt)
    {
      AppMethodBeat.i(34346);
      a locala = new a();
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      int k;
      int i;
      if ((paramContext instanceof Activity))
      {
        ((Activity)paramContext).getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
        Point localPoint = av.az(paramContext);
        k = localDisplayMetrics.widthPixels;
        if ((k != localDisplayMetrics.widthPixels) || (localPoint.y != localDisplayMetrics.heightPixels)) {
          Log.e("MicroMsg.ChatFooterCustomSubmenu", "get screen param error!! width:%s, systermWidth:%s, height:%s, systermHeight:%s", new Object[] { Integer.valueOf(k), Integer.valueOf(localDisplayMetrics.widthPixels), Integer.valueOf(localPoint.y), Integer.valueOf(localDisplayMetrics.heightPixels) });
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
          locala.oxq = 0;
          locala.oxr = (k - (i + 0));
        }
        for (;;)
        {
          AppMethodBeat.o(34346);
          return locala;
          if (Pfp == null) {
            Pfp = paramContext.getResources().getDisplayMetrics();
          }
          localDisplayMetrics = Pfp;
          break;
          if (k - (i / 2 + paramInt) < 0)
          {
            locala.oxq = (k - (i + 0));
            locala.oxr = 0;
          }
          else
          {
            locala.oxq = (paramInt - i / 2);
            locala.oxr = (k - (i / 2 + paramInt));
          }
        }
      }
    }
    
    public static final class a
    {
      public int oxq;
      public int oxr;
      
      public final String toString()
      {
        AppMethodBeat.i(34344);
        String str = " marginLeft:" + this.oxq + " marginRight:" + this.oxr;
        AppMethodBeat.o(34344);
        return str;
      }
    }
  }
  
  final class b
    extends BaseAdapter
  {
    private b() {}
    
    private k ame(int paramInt)
    {
      AppMethodBeat.i(34348);
      k localk = (k)g.b(g.this).iOs.get(paramInt);
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
        paramView = (TextView)g.c(g.this).inflate(2131495944, paramViewGroup, false);
        paramViewGroup = ame(paramInt);
        paramView.setTag(paramViewGroup);
        if (!g.a(g.this, paramViewGroup.key)) {
          break label222;
        }
        Log.i("MicroMsg.ChatFooterCustomSubmenu", "showRedDotTextView：%s", new Object[] { paramViewGroup.key });
        paramView.setEllipsize(null);
        Object localObject = g.d(g.this).getResources().getDrawable(2131235385);
        ((Drawable)localObject).setBounds(0, 0, at.fromDPToPix(g.d(g.this), 8), at.fromDPToPix(g.d(g.this), 8));
        localObject = new com.tencent.mm.ui.widget.a((Drawable)localObject);
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
        label222:
        paramView.setText(l.c(g.d(g.this), paramViewGroup.name));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.g
 * JD-Core Version:    0.7.0.1
 */