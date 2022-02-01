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
import com.tencent.mm.am.j;
import com.tencent.mm.plugin.newtips.a.i;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.aq;
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
  AdapterView.OnItemClickListener GlE;
  String GlF;
  private ViewGroup GlG;
  private b GlH;
  private MMListPopupWindow GlI;
  private int GlJ;
  private int GlK;
  j GlL;
  private boolean GlM;
  private Boolean Glp;
  Map<String, an> Glq;
  List<an> Glr;
  boolean dyl;
  private int height;
  private Context mContext;
  private int mCount;
  private LayoutInflater mInflater;
  
  public g(Context paramContext, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(34351);
    this.GlE = null;
    this.Glp = Boolean.FALSE;
    this.GlF = "";
    this.dyl = false;
    this.Glq = new ConcurrentHashMap();
    this.Glr = new ArrayList();
    this.mContext = null;
    this.GlG = null;
    this.GlH = null;
    this.GlJ = 2131821491;
    this.GlL = null;
    this.GlM = true;
    this.mContext = paramContext;
    this.GlG = paramViewGroup;
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    eVf();
    this.GlH = new b((byte)0);
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
      if (this.GlG == null) {
        this.GlG = new FrameLayout(this.mContext);
      }
      localView = paramListAdapter.getView(j, localView, this.GlG);
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
    if ((!isShowing()) && (paramj != null) && (paramj.gXr != null) && (paramj.gXr.size() > 0))
    {
      this.GlM = false;
      this.GlL = paramj;
      this.mCount = paramj.gXr.size();
      this.GlH.notifyDataSetChanged();
      this.height = ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay().getHeight();
      TextView localTextView = (TextView)((LayoutInflater)this.mContext.getSystemService("layout_inflater")).inflate(2131495102, null);
      paramj = a.a(this.mContext, localTextView.getPaint(), paramj.gXr, paramInt1);
      this.GlK = (paramInt2 - this.GlH.getCount() * this.mContext.getResources().getDimensionPixelSize(2131165567) - this.mContext.getResources().getDimensionPixelSize(2131165371));
      ad.d("MicroMsg.ChatFooterCustomSubmenu", "showPointY=" + paramInt2 + "verticalOffset=" + this.GlK);
      this.GlI = new MMListPopupWindow(this.mContext, null, 0);
      this.GlI.setOnDismissListener(this);
      this.GlI.aos = this.GlE;
      this.GlI.setAdapter(this.GlH);
      this.GlI.setModal(true);
      this.GlI.setBackgroundDrawable(this.mContext.getResources().getDrawable(2131234275));
      this.GlI.setAnimationStyle(this.GlJ);
      this.GlI.aof = paramj.mgg;
      this.GlI.setVerticalOffset(this.GlK);
      this.GlI.aoq = this.GlG;
      this.GlI.setContentWidth(b(this.GlH));
      this.GlI.jY();
      this.GlI.show();
      this.GlI.FYm.setOnKeyListener(this);
      this.GlI.FYm.setDivider(new ColorDrawable(this.mContext.getResources().getColor(2131100886)));
      this.GlI.FYm.setSelector(this.mContext.getResources().getDrawable(2131233634));
      this.GlI.FYm.setDividerHeight(1);
      this.GlI.FYm.setVerticalScrollBarEnabled(false);
      this.GlI.FYm.setHorizontalScrollBarEnabled(false);
      this.GlI.FYm.setBackgroundColor(ao.aD(this.mContext, 2130968582));
      AppMethodBeat.o(34352);
      return true;
    }
    AppMethodBeat.o(34352);
    return false;
  }
  
  public final void d(j paramj)
  {
    AppMethodBeat.i(191477);
    ad.d("MicroMsg.ChatFooterCustomSubmenu", "registerRedDotComponentForSubMenu subMeubConut：%s", new Object[] { Integer.valueOf(paramj.gXr.size()) });
    this.Glp = Boolean.TRUE;
    int i = 0;
    for (;;)
    {
      j localj;
      if (i < paramj.gXr.size())
      {
        localj = (j)paramj.gXr.get(i);
        ad.d("MicroMsg.ChatFooterCustomSubmenu", "registerRedDotComponentForMenu key：%s，name：%s", new Object[] { localj.key, localj.name });
        if (this.Glq.containsKey(localj.key)) {
          ad.d("MicroMsg.ChatFooterCustomSubmenu", "this key has register");
        }
      }
      else
      {
        ad.d("MicroMsg.ChatFooterCustomSubmenu", "mRedDotCompoentList：%s,mRedDotCompoents:%s", new Object[] { Integer.valueOf(this.Glq.size()), Integer.valueOf(this.Glr.size()) });
        AppMethodBeat.o(191477);
        return;
      }
      an localan = new an(this.mContext, localj.key, new an.a()
      {
        public final void F(boolean paramAnonymousBoolean, String paramAnonymousString)
        {
          AppMethodBeat.i(191476);
          ad.d("MicroMsg.ChatFooterCustomSubmenu", "OnShowRedDot showTextView：%s，key ：%s", new Object[] { Boolean.valueOf(paramAnonymousBoolean), paramAnonymousString });
          g.b(g.this, paramAnonymousString);
          g.a(g.this, paramAnonymousBoolean);
          AppMethodBeat.o(191476);
        }
      });
      com.tencent.mm.plugin.newtips.a.cWs().h(localan);
      this.Glq.put(localj.key, localan);
      this.Glr.add(localan);
      ad.d("MicroMsg.ChatFooterCustomSubmenu", " Register key ：%s", new Object[] { localj.key });
      i += 1;
    }
  }
  
  public final boolean eVf()
  {
    AppMethodBeat.i(34354);
    if (isShowing())
    {
      this.GlI.dismiss();
      AppMethodBeat.o(34354);
      return true;
    }
    AppMethodBeat.o(34354);
    return false;
  }
  
  public final boolean isShowing()
  {
    AppMethodBeat.i(34353);
    if ((this.GlI != null) && (this.GlI.iAs.isShowing()))
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
  
  public static final class a
  {
    private static DisplayMetrics GlO = null;
    
    private static int a(Context paramContext, TextPaint paramTextPaint, List<j> paramList)
    {
      AppMethodBeat.i(34345);
      paramList = paramList.iterator();
      float f1 = 0.0F;
      if (paramList.hasNext())
      {
        float f2 = paramTextPaint.measureText(((j)paramList.next()).name);
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
        int j = com.tencent.mm.cd.a.fromDPToPix(paramContext, 30);
        AppMethodBeat.o(34345);
        return i + j * 2;
      }
    }
    
    public static a a(Context paramContext, TextPaint paramTextPaint, List<j> paramList, int paramInt)
    {
      AppMethodBeat.i(34346);
      a locala = new a();
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      int k;
      int i;
      if ((paramContext instanceof Activity))
      {
        ((Activity)paramContext).getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
        Point localPoint = aq.cf(paramContext);
        k = localDisplayMetrics.widthPixels;
        if ((k != localDisplayMetrics.widthPixels) || (localPoint.y != localDisplayMetrics.heightPixels)) {
          ad.e("MicroMsg.ChatFooterCustomSubmenu", "get screen param error!! width:%s, systermWidth:%s, height:%s, systermHeight:%s", new Object[] { Integer.valueOf(k), Integer.valueOf(localDisplayMetrics.widthPixels), Integer.valueOf(localPoint.y), Integer.valueOf(localDisplayMetrics.heightPixels) });
        }
        i = a(paramContext, paramTextPaint, paramList);
        int j = com.tencent.mm.cd.a.fromDPToPix(paramContext, 95);
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
          locala.mgf = 0;
          locala.mgg = (k - (i + 0));
        }
        for (;;)
        {
          AppMethodBeat.o(34346);
          return locala;
          if (GlO == null) {
            GlO = paramContext.getResources().getDisplayMetrics();
          }
          localDisplayMetrics = GlO;
          break;
          if (k - (i / 2 + paramInt) < 0)
          {
            locala.mgf = (k - (i + 0));
            locala.mgg = 0;
          }
          else
          {
            locala.mgf = (paramInt - i / 2);
            locala.mgg = (k - (i / 2 + paramInt));
          }
        }
      }
    }
    
    public static final class a
    {
      public int mgf;
      public int mgg;
      
      public final String toString()
      {
        AppMethodBeat.i(34344);
        String str = " marginLeft:" + this.mgf + " marginRight:" + this.mgg;
        AppMethodBeat.o(34344);
        return str;
      }
    }
  }
  
  final class b
    extends BaseAdapter
  {
    private b() {}
    
    private j Yr(int paramInt)
    {
      AppMethodBeat.i(34348);
      j localj = (j)g.b(g.this).gXr.get(paramInt);
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
        paramViewGroup = Yr(paramInt);
        paramView.setTag(paramViewGroup);
        if (!g.a(g.this, paramViewGroup.key)) {
          break label222;
        }
        ad.i("MicroMsg.ChatFooterCustomSubmenu", "showRedDotTextView：%s", new Object[] { paramViewGroup.key });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.g
 * JD-Core Version:    0.7.0.1
 */