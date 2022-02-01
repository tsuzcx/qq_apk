package com.tencent.mm.pluginsdk.ui.chat;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.g;
import com.tencent.mm.R.k;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AppGrid
  extends GridView
{
  AdapterView.OnItemLongClickListener AgR;
  private b Ydj;
  int Ydk;
  int Ydl;
  int Ydm;
  int Ydn;
  int Ydo;
  a Ydp;
  Context context;
  private SharedPreferences sp;
  AdapterView.OnItemClickListener vEc;
  
  public AppGrid(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(31442);
    this.Ydl = 0;
    this.Ydm = 0;
    this.vEc = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(31433);
        b localb = new b();
        localb.cH(paramAnonymousAdapterView);
        localb.cH(paramAnonymousView);
        localb.sc(paramAnonymousInt);
        localb.hB(paramAnonymousLong);
        a.c("com/tencent/mm/pluginsdk/ui/chat/AppGrid$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
        AppGrid.c(AppGrid.this).a(AppGrid.c(AppGrid.this).awx(AppGrid.a(AppGrid.this) * AppGrid.b(AppGrid.this) + paramAnonymousInt), AppGrid.d(AppGrid.this).anJ(paramAnonymousInt));
        a.a(this, "com/tencent/mm/pluginsdk/ui/chat/AppGrid$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(31433);
      }
    };
    this.AgR = new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(31434);
        paramAnonymousAdapterView = AppGrid.c(AppGrid.this);
        int i = AppGrid.c(AppGrid.this).awx(AppGrid.a(AppGrid.this) * AppGrid.b(AppGrid.this) + paramAnonymousInt);
        AppGrid.d(AppGrid.this).anJ(paramAnonymousInt);
        paramAnonymousAdapterView.awy(i);
        AppMethodBeat.o(31434);
        return true;
      }
    };
    this.context = paramContext;
    AppMethodBeat.o(31442);
  }
  
  public AppGrid(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(31441);
    this.Ydl = 0;
    this.Ydm = 0;
    this.vEc = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(31433);
        b localb = new b();
        localb.cH(paramAnonymousAdapterView);
        localb.cH(paramAnonymousView);
        localb.sc(paramAnonymousInt);
        localb.hB(paramAnonymousLong);
        a.c("com/tencent/mm/pluginsdk/ui/chat/AppGrid$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, localb.aYj());
        AppGrid.c(AppGrid.this).a(AppGrid.c(AppGrid.this).awx(AppGrid.a(AppGrid.this) * AppGrid.b(AppGrid.this) + paramAnonymousInt), AppGrid.d(AppGrid.this).anJ(paramAnonymousInt));
        a.a(this, "com/tencent/mm/pluginsdk/ui/chat/AppGrid$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
        AppMethodBeat.o(31433);
      }
    };
    this.AgR = new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(31434);
        paramAnonymousAdapterView = AppGrid.c(AppGrid.this);
        int i = AppGrid.c(AppGrid.this).awx(AppGrid.a(AppGrid.this) * AppGrid.b(AppGrid.this) + paramAnonymousInt);
        AppGrid.d(AppGrid.this).anJ(paramAnonymousInt);
        paramAnonymousAdapterView.awy(i);
        AppMethodBeat.o(31434);
        return true;
      }
    };
    this.context = paramContext;
    AppMethodBeat.o(31441);
  }
  
  public static a.b a(a.a parama)
  {
    AppMethodBeat.i(163203);
    if (parama == null)
    {
      AppMethodBeat.o(163203);
      return null;
    }
    String str = LocaleUtil.getApplicationLanguage();
    if ("zh_CN".equals(str))
    {
      parama = parama.YeP;
      AppMethodBeat.o(163203);
      return parama;
    }
    if ("zh_TW".equals(str))
    {
      parama = parama.YeR;
      AppMethodBeat.o(163203);
      return parama;
    }
    if ("zh_HK".equals(str))
    {
      parama = parama.YeQ;
      AppMethodBeat.o(163203);
      return parama;
    }
    parama = parama.YeS;
    AppMethodBeat.o(163203);
    return parama;
  }
  
  public int getCount()
  {
    AppMethodBeat.i(31446);
    int i = this.Ydp.getCount();
    AppMethodBeat.o(31446);
    return i;
  }
  
  public void setOnAppSelectedListener(b paramb)
  {
    this.Ydj = paramb;
  }
  
  final class a
    extends BaseAdapter
  {
    private boolean Nfg;
    private int Ydr;
    private int Yds;
    private Map<String, g> Ydt;
    List<g> aYV;
    
    public a(List<g> paramList, Map<String, g> paramMap, ArrayList<a.a> paramArrayList)
    {
      AppMethodBeat.i(163201);
      this.aYV = new ArrayList();
      this.Ydt = null;
      this.Nfg = false;
      if (paramMap == null) {}
      for (int i = -1;; i = paramMap.size())
      {
        Log.i("MicroMsg.AppGrid", "AppGridAdapter infoList size:%s ", new Object[] { Integer.valueOf(i) });
        this.aYV.clear();
        this.aYV.addAll(paramMap);
        Collection localCollection;
        this.aYV.addAll(localCollection);
        this.Ydt = paramArrayList;
        this.Ydr = BackwardSupportUtil.BitmapFactory.fromDPToPix(paramList, 56.0F);
        this.Yds = BackwardSupportUtil.BitmapFactory.fromDPToPix(paramList, 53.299999F);
        this$1 = localCollection.iterator();
        do
        {
          if (!AppGrid.this.hasNext()) {
            break;
          }
          paramList = AppGrid.a((a.a)AppGrid.this.next());
        } while ((paramList == null) || (Util.isNullOrNil(paramList.desc)));
        this.Nfg = true;
        AppMethodBeat.o(163201);
        return;
      }
      AppMethodBeat.o(163201);
    }
    
    private void a(a parama, String paramString1, String paramString2)
    {
      AppMethodBeat.i(31439);
      if (this.Ydt == null)
      {
        Log.w("MicroMsg.AppGrid", "func[attachHarcodeServiceApp] harcodeServiceAppInfoMap null");
        AppMethodBeat.o(31439);
        return;
      }
      paramString1 = (g)this.Ydt.get(paramString1);
      if (paramString1 == null)
      {
        Log.w("MicroMsg.AppGrid", "func[attachHarcodeServiceApp] info null");
        AppMethodBeat.o(31439);
        return;
      }
      if (g.XSb.equals(paramString1.field_appId))
      {
        parama.dpM.setImageResource(R.k.panel_icon_transfer);
        if (Util.isNullOrNil(paramString2)) {
          break label339;
        }
        parama.Eoo.setText(h.b(AppGrid.h(AppGrid.this), paramString1, paramString2));
      }
      int i;
      for (;;)
      {
        if ((paramString1.iIs()) && (paramString1.iIt()))
        {
          if (AppGrid.i(AppGrid.this) == null) {
            AppGrid.a(AppGrid.this, AppGrid.h(AppGrid.this).getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0));
          }
          if (AppGrid.i(AppGrid.this).getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + paramString1.field_appId, true)) {
            parama.Ydv.setVisibility(0);
          }
        }
        if (!g.XSb.equals(paramString1.field_appId)) {
          break label417;
        }
        bh.bCz();
        i = ((Integer)c.ban().get(at.a.acNa, Integer.valueOf(0))).intValue();
        if (i > 1) {
          break label361;
        }
        AppMethodBeat.o(31439);
        return;
        if (g.XSd.equals(paramString1.field_appId))
        {
          parama.dpM.setImageResource(R.k.panel_icon_luckymoney);
          break;
        }
        if (g.XSc.equals(paramString1.field_appId))
        {
          parama.dpM.setImageResource(R.k.panel_icon_card);
          break;
        }
        if (g.XSe.equals(paramString1.field_appId))
        {
          parama.dpM.setImageResource(R.k.panel_icon_aa);
          break;
        }
        parama.dpM.setImageResource(R.g.app_panel_icon_unknowed);
        break;
        label339:
        parama.Eoo.setText(h.a(AppGrid.h(AppGrid.this), paramString1, null));
      }
      label361:
      bh.bCz();
      if (!Util.stringsToList(((String)c.ban().get(at.a.acPu, "")).split(";")).contains(String.valueOf(i))) {
        parama.Ydv.setVisibility(0);
      }
      AppMethodBeat.o(31439);
      return;
      label417:
      if (g.XSd.equals(paramString1.field_appId))
      {
        bh.bCz();
        i = ((Integer)c.ban().get(at.a.acNa, Integer.valueOf(0))).intValue();
        if (i <= 1)
        {
          parama.Ydv.setVisibility(8);
          AppMethodBeat.o(31439);
          return;
        }
        bh.bCz();
        if (!Util.stringsToList(((String)c.ban().get(at.a.acPv, "")).split(";")).contains(String.valueOf(i))) {
          parama.Ydv.setVisibility(0);
        }
      }
      AppMethodBeat.o(31439);
    }
    
    public final g anJ(int paramInt)
    {
      AppMethodBeat.i(31437);
      if (((paramInt < AppGrid.g(AppGrid.this)) && (AppGrid.a(AppGrid.this) == 0)) || (AppGrid.a(AppGrid.this) * AppGrid.b(AppGrid.this) + paramInt < AppGrid.g(AppGrid.this)) || (paramInt - AppGrid.g(AppGrid.this) + AppGrid.a(AppGrid.this) * AppGrid.b(AppGrid.this) >= this.aYV.size()))
      {
        AppMethodBeat.o(31437);
        return null;
      }
      paramInt = paramInt - AppGrid.g(AppGrid.this) + AppGrid.a(AppGrid.this) * AppGrid.b(AppGrid.this);
      Log.v("MicroMsg.AppGrid", "get item db pos: %d", new Object[] { Integer.valueOf(paramInt) });
      g localg = (g)this.aYV.get(paramInt);
      AppMethodBeat.o(31437);
      return localg;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(31436);
      if (AppGrid.a(AppGrid.this) == AppGrid.e(AppGrid.this) - 1)
      {
        i = AppGrid.f(AppGrid.this);
        int j = AppGrid.a(AppGrid.this);
        int k = AppGrid.b(AppGrid.this);
        AppMethodBeat.o(31436);
        return i - j * k;
      }
      int i = AppGrid.b(AppGrid.this);
      AppMethodBeat.o(31436);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return 0L;
    }
    
    /* Error */
    public final View getView(int paramInt, View paramView, android.view.ViewGroup paramViewGroup)
    {
      // Byte code:
      //   0: sipush 31438
      //   3: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   6: aload_2
      //   7: ifnonnull +461 -> 468
      //   10: new 9	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a
      //   13: dup
      //   14: aload_0
      //   15: invokespecial 349	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:<init>	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid$a;)V
      //   18: astore_3
      //   19: aload_0
      //   20: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:Ydq	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   23: invokestatic 175	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
      //   26: getstatic 354	com/tencent/mm/R$i:geh	I
      //   29: aconst_null
      //   30: invokestatic 360	android/view/View:inflate	(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;
      //   33: astore_2
      //   34: aload_3
      //   35: aload_2
      //   36: getstatic 365	com/tencent/mm/R$h:frl	I
      //   39: invokevirtual 369	android/view/View:findViewById	(I)Landroid/view/View;
      //   42: checkcast 164	android/widget/ImageView
      //   45: putfield 157	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:dpM	Landroid/widget/ImageView;
      //   48: aload_3
      //   49: aload_2
      //   50: getstatic 372	com/tencent/mm/R$h:frk	I
      //   53: invokevirtual 369	android/view/View:findViewById	(I)Landroid/view/View;
      //   56: checkcast 374	com/tencent/mm/pluginsdk/ui/applet/CdnImageView
      //   59: putfield 378	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:Ydu	Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;
      //   62: aload_3
      //   63: aload_2
      //   64: getstatic 381	com/tencent/mm/R$h:frm	I
      //   67: invokevirtual 369	android/view/View:findViewById	(I)Landroid/view/View;
      //   70: putfield 385	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:Ydw	Landroid/view/View;
      //   73: aload_3
      //   74: aload_2
      //   75: getstatic 388	com/tencent/mm/R$h:frn	I
      //   78: invokevirtual 369	android/view/View:findViewById	(I)Landroid/view/View;
      //   81: checkcast 183	android/widget/TextView
      //   84: putfield 171	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:Eoo	Landroid/widget/TextView;
      //   87: aload_3
      //   88: aload_2
      //   89: getstatic 391	com/tencent/mm/R$h:frj	I
      //   92: invokevirtual 369	android/view/View:findViewById	(I)Landroid/view/View;
      //   95: checkcast 183	android/widget/TextView
      //   98: putfield 394	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:pmf	Landroid/widget/TextView;
      //   101: aload_3
      //   102: aload_2
      //   103: getstatic 397	com/tencent/mm/R$h:fro	I
      //   106: invokevirtual 369	android/view/View:findViewById	(I)Landroid/view/View;
      //   109: checkcast 183	android/widget/TextView
      //   112: putfield 234	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:Ydv	Landroid/widget/TextView;
      //   115: aload_3
      //   116: aload_2
      //   117: getstatic 400	com/tencent/mm/R$h:frp	I
      //   120: invokevirtual 369	android/view/View:findViewById	(I)Landroid/view/View;
      //   123: putfield 403	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:Ydx	Landroid/view/View;
      //   126: aload_2
      //   127: aload_3
      //   128: invokevirtual 407	android/view/View:setTag	(Ljava/lang/Object;)V
      //   131: ldc 47
      //   133: new 213	java/lang/StringBuilder
      //   136: dup
      //   137: ldc_w 409
      //   140: invokespecial 218	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   143: iload_1
      //   144: invokevirtual 412	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   147: ldc_w 414
      //   150: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   153: aload_0
      //   154: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:Ydq	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   157: invokestatic 320	com/tencent/mm/pluginsdk/ui/chat/AppGrid:a	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)I
      //   160: invokevirtual 412	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   163: invokevirtual 225	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   166: invokestatic 416	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   169: aload_3
      //   170: getfield 171	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:Eoo	Landroid/widget/TextView;
      //   173: iconst_0
      //   174: invokevirtual 237	android/widget/TextView:setVisibility	(I)V
      //   177: aload_0
      //   178: getfield 45	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:Nfg	Z
      //   181: ifeq +298 -> 479
      //   184: aload_3
      //   185: getfield 394	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:pmf	Landroid/widget/TextView;
      //   188: iconst_0
      //   189: invokevirtual 237	android/widget/TextView:setVisibility	(I)V
      //   192: aload_3
      //   193: getfield 403	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:Ydx	Landroid/view/View;
      //   196: bipush 8
      //   198: invokevirtual 417	android/view/View:setVisibility	(I)V
      //   201: aload_3
      //   202: getfield 234	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:Ydv	Landroid/widget/TextView;
      //   205: bipush 8
      //   207: invokevirtual 237	android/widget/TextView:setVisibility	(I)V
      //   210: aload_3
      //   211: getfield 385	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:Ydw	Landroid/view/View;
      //   214: iconst_0
      //   215: invokevirtual 417	android/view/View:setVisibility	(I)V
      //   218: aload_3
      //   219: getfield 157	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:dpM	Landroid/widget/ImageView;
      //   222: iconst_0
      //   223: invokevirtual 418	android/widget/ImageView:setVisibility	(I)V
      //   226: aload_3
      //   227: getfield 378	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:Ydu	Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;
      //   230: bipush 8
      //   232: invokevirtual 419	com/tencent/mm/pluginsdk/ui/applet/CdnImageView:setVisibility	(I)V
      //   235: aload_3
      //   236: getfield 157	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:dpM	Landroid/widget/ImageView;
      //   239: invokevirtual 423	android/widget/ImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
      //   242: astore 8
      //   244: aload 8
      //   246: aload_0
      //   247: getfield 80	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:Ydr	I
      //   250: putfield 428	android/view/ViewGroup$LayoutParams:width	I
      //   253: aload 8
      //   255: aload_0
      //   256: getfield 80	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:Ydr	I
      //   259: putfield 431	android/view/ViewGroup$LayoutParams:height	I
      //   262: aload_3
      //   263: getfield 157	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:dpM	Landroid/widget/ImageView;
      //   266: aload 8
      //   268: invokevirtual 435	android/widget/ImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
      //   271: aload_3
      //   272: getfield 171	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:Eoo	Landroid/widget/TextView;
      //   275: aconst_null
      //   276: invokevirtual 436	android/widget/TextView:setTag	(Ljava/lang/Object;)V
      //   279: aload_0
      //   280: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:Ydq	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   283: invokestatic 320	com/tencent/mm/pluginsdk/ui/chat/AppGrid:a	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)I
      //   286: aload_0
      //   287: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:Ydq	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   290: invokestatic 322	com/tencent/mm/pluginsdk/ui/chat/AppGrid:b	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)I
      //   293: imul
      //   294: iload_1
      //   295: iadd
      //   296: istore 4
      //   298: aload_0
      //   299: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:Ydq	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   302: invokestatic 440	com/tencent/mm/pluginsdk/ui/chat/AppGrid:c	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid$b;
      //   305: iload 4
      //   307: invokeinterface 446 2 0
      //   312: istore 5
      //   314: iload 4
      //   316: aload_0
      //   317: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:Ydq	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   320: invokestatic 318	com/tencent/mm/pluginsdk/ui/chat/AppGrid:g	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)I
      //   323: if_icmpge +1413 -> 1736
      //   326: iload 5
      //   328: tableswitch	default:+104 -> 432, 0:+422->750, 1:+350->678, 2:+644->972, 3:+1023->1351, 4:+721->1049, 5:+196->524, 6:+455->783, 7:+975->1303, 8:+927->1255, 9:+1180->1508, 10:+273->601, 11:+163->491, 12:+1225->1553, 13:+1258->1586, 14:+1291->1619, 15:+611->939, 16:+798->1126, 17:+533->861, 18:+1100->1428, 19:+1192->1520, 20:+1147->1475, 21:+1324->1652
      //   433: iload_1
      //   434: invokevirtual 340	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:anJ	(I)Lcom/tencent/mm/pluginsdk/model/app/g;
      //   437: astore 8
      //   439: aload 8
      //   441: ifnull +19 -> 460
      //   444: aload 8
      //   446: invokestatic 450	com/tencent/mm/pluginsdk/model/app/h:p	(Lcom/tencent/mm/pluginsdk/model/app/g;)Z
      //   449: ifeq +11 -> 460
      //   452: aload_3
      //   453: getfield 234	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:Ydv	Landroid/widget/TextView;
      //   456: iconst_0
      //   457: invokevirtual 237	android/widget/TextView:setVisibility	(I)V
      //   460: sipush 31438
      //   463: invokestatic 117	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   466: aload_2
      //   467: areturn
      //   468: aload_2
      //   469: invokevirtual 453	android/view/View:getTag	()Ljava/lang/Object;
      //   472: checkcast 9	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a
      //   475: astore_3
      //   476: goto -345 -> 131
      //   479: aload_3
      //   480: getfield 394	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:pmf	Landroid/widget/TextView;
      //   483: bipush 8
      //   485: invokevirtual 237	android/widget/TextView:setVisibility	(I)V
      //   488: goto -296 -> 192
      //   491: aload_3
      //   492: getfield 157	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:dpM	Landroid/widget/ImageView;
      //   495: getstatic 456	com/tencent/mm/R$k:panel_icon_fav	I
      //   498: invokevirtual 167	android/widget/ImageView:setImageResource	(I)V
      //   501: aload_3
      //   502: getfield 171	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:Eoo	Landroid/widget/TextView;
      //   505: aload_0
      //   506: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:Ydq	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   509: invokestatic 175	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
      //   512: getstatic 461	com/tencent/mm/R$l:app_field_favorite	I
      //   515: invokevirtual 464	android/content/Context:getString	(I)Ljava/lang/String;
      //   518: invokevirtual 187	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   521: goto -89 -> 432
      //   524: aload_3
      //   525: getfield 157	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:dpM	Landroid/widget/ImageView;
      //   528: getstatic 467	com/tencent/mm/R$k:panel_icon_wxtalk	I
      //   531: invokevirtual 167	android/widget/ImageView:setImageResource	(I)V
      //   534: aload_3
      //   535: getfield 171	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:Eoo	Landroid/widget/TextView;
      //   538: aload_0
      //   539: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:Ydq	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   542: invokestatic 175	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
      //   545: getstatic 470	com/tencent/mm/R$l:app_field_talkroom	I
      //   548: invokevirtual 464	android/content/Context:getString	(I)Ljava/lang/String;
      //   551: invokevirtual 187	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   554: invokestatic 243	com/tencent/mm/model/bh:bCz	()Lcom/tencent/mm/model/c;
      //   557: pop
      //   558: invokestatic 249	com/tencent/mm/model/c:ban	()Lcom/tencent/mm/storage/aq;
      //   561: bipush 67
      //   563: getstatic 476	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   566: invokevirtual 480	com/tencent/mm/storage/aq:d	(ILjava/lang/Object;)Ljava/lang/Object;
      //   569: checkcast 472	java/lang/Boolean
      //   572: invokevirtual 483	java/lang/Boolean:booleanValue	()Z
      //   575: ifeq +14 -> 589
      //   578: aload_3
      //   579: getfield 234	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:Ydv	Landroid/widget/TextView;
      //   582: iconst_0
      //   583: invokevirtual 237	android/widget/TextView:setVisibility	(I)V
      //   586: goto -154 -> 432
      //   589: aload_3
      //   590: getfield 234	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:Ydv	Landroid/widget/TextView;
      //   593: bipush 8
      //   595: invokevirtual 237	android/widget/TextView:setVisibility	(I)V
      //   598: goto -166 -> 432
      //   601: aload_3
      //   602: getfield 157	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:dpM	Landroid/widget/ImageView;
      //   605: getstatic 486	com/tencent/mm/R$k:panel_icon_voiceinput	I
      //   608: invokevirtual 167	android/widget/ImageView:setImageResource	(I)V
      //   611: aload_3
      //   612: getfield 171	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:Eoo	Landroid/widget/TextView;
      //   615: aload_0
      //   616: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:Ydq	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   619: invokestatic 175	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
      //   622: getstatic 489	com/tencent/mm/R$l:hardcode_plugin_voiceinput_nick	I
      //   625: invokevirtual 464	android/content/Context:getString	(I)Ljava/lang/String;
      //   628: invokevirtual 187	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   631: invokestatic 243	com/tencent/mm/model/bh:bCz	()Lcom/tencent/mm/model/c;
      //   634: pop
      //   635: invokestatic 249	com/tencent/mm/model/c:ban	()Lcom/tencent/mm/storage/aq;
      //   638: bipush 73
      //   640: getstatic 476	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   643: invokevirtual 480	com/tencent/mm/storage/aq:d	(ILjava/lang/Object;)Ljava/lang/Object;
      //   646: checkcast 472	java/lang/Boolean
      //   649: invokevirtual 483	java/lang/Boolean:booleanValue	()Z
      //   652: ifeq +14 -> 666
      //   655: aload_3
      //   656: getfield 234	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:Ydv	Landroid/widget/TextView;
      //   659: iconst_0
      //   660: invokevirtual 237	android/widget/TextView:setVisibility	(I)V
      //   663: goto -231 -> 432
      //   666: aload_3
      //   667: getfield 234	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:Ydv	Landroid/widget/TextView;
      //   670: bipush 8
      //   672: invokevirtual 237	android/widget/TextView:setVisibility	(I)V
      //   675: goto -243 -> 432
      //   678: getstatic 494	com/tencent/mm/platformtools/z:pDl	Z
      //   681: ifeq +36 -> 717
      //   684: aload_3
      //   685: getfield 157	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:dpM	Landroid/widget/ImageView;
      //   688: getstatic 497	com/tencent/mm/R$k:panel_icon_sights	I
      //   691: invokevirtual 167	android/widget/ImageView:setImageResource	(I)V
      //   694: aload_3
      //   695: getfield 171	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:Eoo	Landroid/widget/TextView;
      //   698: aload_0
      //   699: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:Ydq	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   702: invokestatic 175	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
      //   705: getstatic 500	com/tencent/mm/R$l:app_field_sight	I
      //   708: invokevirtual 464	android/content/Context:getString	(I)Ljava/lang/String;
      //   711: invokevirtual 187	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   714: goto -282 -> 432
      //   717: aload_3
      //   718: getfield 157	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:dpM	Landroid/widget/ImageView;
      //   721: getstatic 503	com/tencent/mm/R$k:panel_icon_camera	I
      //   724: invokevirtual 167	android/widget/ImageView:setImageResource	(I)V
      //   727: aload_3
      //   728: getfield 171	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:Eoo	Landroid/widget/TextView;
      //   731: aload_0
      //   732: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:Ydq	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   735: invokestatic 175	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
      //   738: getstatic 506	com/tencent/mm/R$l:app_field_mmsight	I
      //   741: invokevirtual 464	android/content/Context:getString	(I)Ljava/lang/String;
      //   744: invokevirtual 187	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   747: goto -315 -> 432
      //   750: aload_3
      //   751: getfield 157	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:dpM	Landroid/widget/ImageView;
      //   754: getstatic 509	com/tencent/mm/R$k:panel_icon_pic	I
      //   757: invokevirtual 167	android/widget/ImageView:setImageResource	(I)V
      //   760: aload_3
      //   761: getfield 171	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:Eoo	Landroid/widget/TextView;
      //   764: aload_0
      //   765: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:Ydq	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   768: invokestatic 175	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
      //   771: getstatic 512	com/tencent/mm/R$l:app_field_new_pic	I
      //   774: invokevirtual 464	android/content/Context:getString	(I)Ljava/lang/String;
      //   777: invokevirtual 187	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   780: goto -348 -> 432
      //   783: aload_3
      //   784: getfield 157	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:dpM	Landroid/widget/ImageView;
      //   787: getstatic 515	com/tencent/mm/R$k:panel_icon_location	I
      //   790: invokevirtual 167	android/widget/ImageView:setImageResource	(I)V
      //   793: aload_3
      //   794: getfield 171	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:Eoo	Landroid/widget/TextView;
      //   797: aload_0
      //   798: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:Ydq	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   801: invokestatic 175	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
      //   804: getstatic 518	com/tencent/mm/R$l:app_field_location	I
      //   807: invokevirtual 464	android/content/Context:getString	(I)Ljava/lang/String;
      //   810: invokevirtual 187	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   813: invokestatic 243	com/tencent/mm/model/bh:bCz	()Lcom/tencent/mm/model/c;
      //   816: pop
      //   817: invokestatic 249	com/tencent/mm/model/c:ban	()Lcom/tencent/mm/storage/aq;
      //   820: ldc_w 519
      //   823: getstatic 476	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   826: invokevirtual 480	com/tencent/mm/storage/aq:d	(ILjava/lang/Object;)Ljava/lang/Object;
      //   829: checkcast 472	java/lang/Boolean
      //   832: invokevirtual 483	java/lang/Boolean:booleanValue	()Z
      //   835: ifeq +14 -> 849
      //   838: aload_3
      //   839: getfield 403	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:Ydx	Landroid/view/View;
      //   842: iconst_0
      //   843: invokevirtual 417	android/view/View:setVisibility	(I)V
      //   846: goto -414 -> 432
      //   849: aload_3
      //   850: getfield 403	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:Ydx	Landroid/view/View;
      //   853: bipush 8
      //   855: invokevirtual 417	android/view/View:setVisibility	(I)V
      //   858: goto -426 -> 432
      //   861: aload_3
      //   862: getfield 157	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:dpM	Landroid/widget/ImageView;
      //   865: getstatic 522	com/tencent/mm/R$k:panel_icon_service	I
      //   868: invokevirtual 167	android/widget/ImageView:setImageResource	(I)V
      //   871: aload_3
      //   872: getfield 171	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:Eoo	Landroid/widget/TextView;
      //   875: aload_0
      //   876: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:Ydq	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   879: invokestatic 175	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
      //   882: getstatic 525	com/tencent/mm/R$l:app_field_service	I
      //   885: invokevirtual 464	android/content/Context:getString	(I)Ljava/lang/String;
      //   888: invokevirtual 187	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   891: invokestatic 243	com/tencent/mm/model/bh:bCz	()Lcom/tencent/mm/model/c;
      //   894: pop
      //   895: invokestatic 249	com/tencent/mm/model/c:ban	()Lcom/tencent/mm/storage/aq;
      //   898: ldc_w 526
      //   901: getstatic 529	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
      //   904: invokevirtual 480	com/tencent/mm/storage/aq:d	(ILjava/lang/Object;)Ljava/lang/Object;
      //   907: checkcast 472	java/lang/Boolean
      //   910: invokevirtual 483	java/lang/Boolean:booleanValue	()Z
      //   913: ifeq +14 -> 927
      //   916: aload_3
      //   917: getfield 403	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:Ydx	Landroid/view/View;
      //   920: iconst_0
      //   921: invokevirtual 417	android/view/View:setVisibility	(I)V
      //   924: goto -492 -> 432
      //   927: aload_3
      //   928: getfield 403	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:Ydx	Landroid/view/View;
      //   931: bipush 8
      //   933: invokevirtual 417	android/view/View:setVisibility	(I)V
      //   936: goto -504 -> 432
      //   939: aload_3
      //   940: getfield 157	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:dpM	Landroid/widget/ImageView;
      //   943: getstatic 532	com/tencent/mm/R$k:panel_icon_friendcard	I
      //   946: invokevirtual 167	android/widget/ImageView:setImageResource	(I)V
      //   949: aload_3
      //   950: getfield 171	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:Eoo	Landroid/widget/TextView;
      //   953: aload_0
      //   954: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:Ydq	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   957: invokestatic 175	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
      //   960: getstatic 535	com/tencent/mm/R$l:app_field_card	I
      //   963: invokevirtual 464	android/content/Context:getString	(I)Ljava/lang/String;
      //   966: invokevirtual 187	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   969: goto -537 -> 432
      //   972: aload_3
      //   973: getfield 157	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:dpM	Landroid/widget/ImageView;
      //   976: getstatic 538	com/tencent/mm/R$k:panel_icon_voip	I
      //   979: invokevirtual 167	android/widget/ImageView:setImageResource	(I)V
      //   982: aload_3
      //   983: getfield 171	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:Eoo	Landroid/widget/TextView;
      //   986: aload_0
      //   987: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:Ydq	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   990: invokestatic 175	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
      //   993: getstatic 541	com/tencent/mm/R$l:app_field_voip	I
      //   996: invokevirtual 464	android/content/Context:getString	(I)Ljava/lang/String;
      //   999: invokevirtual 187	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   1002: invokestatic 243	com/tencent/mm/model/bh:bCz	()Lcom/tencent/mm/model/c;
      //   1005: pop
      //   1006: invokestatic 249	com/tencent/mm/model/c:ban	()Lcom/tencent/mm/storage/aq;
      //   1009: bipush 54
      //   1011: getstatic 476	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   1014: invokevirtual 480	com/tencent/mm/storage/aq:d	(ILjava/lang/Object;)Ljava/lang/Object;
      //   1017: checkcast 472	java/lang/Boolean
      //   1020: invokevirtual 483	java/lang/Boolean:booleanValue	()Z
      //   1023: ifeq +14 -> 1037
      //   1026: aload_3
      //   1027: getfield 234	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:Ydv	Landroid/widget/TextView;
      //   1030: iconst_0
      //   1031: invokevirtual 237	android/widget/TextView:setVisibility	(I)V
      //   1034: goto -602 -> 432
      //   1037: aload_3
      //   1038: getfield 234	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:Ydv	Landroid/widget/TextView;
      //   1041: bipush 8
      //   1043: invokevirtual 237	android/widget/TextView:setVisibility	(I)V
      //   1046: goto -614 -> 432
      //   1049: aload_3
      //   1050: getfield 157	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:dpM	Landroid/widget/ImageView;
      //   1053: getstatic 544	com/tencent/mm/R$k:panel_icon_voipvoice	I
      //   1056: invokevirtual 167	android/widget/ImageView:setImageResource	(I)V
      //   1059: aload_3
      //   1060: getfield 171	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:Eoo	Landroid/widget/TextView;
      //   1063: aload_0
      //   1064: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:Ydq	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   1067: invokestatic 175	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
      //   1070: getstatic 547	com/tencent/mm/R$l:app_field_voipaudio	I
      //   1073: invokevirtual 464	android/content/Context:getString	(I)Ljava/lang/String;
      //   1076: invokevirtual 187	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   1079: invokestatic 243	com/tencent/mm/model/bh:bCz	()Lcom/tencent/mm/model/c;
      //   1082: pop
      //   1083: invokestatic 249	com/tencent/mm/model/c:ban	()Lcom/tencent/mm/storage/aq;
      //   1086: bipush 62
      //   1088: getstatic 476	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   1091: invokevirtual 480	com/tencent/mm/storage/aq:d	(ILjava/lang/Object;)Ljava/lang/Object;
      //   1094: checkcast 472	java/lang/Boolean
      //   1097: invokevirtual 483	java/lang/Boolean:booleanValue	()Z
      //   1100: ifeq +14 -> 1114
      //   1103: aload_3
      //   1104: getfield 234	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:Ydv	Landroid/widget/TextView;
      //   1107: iconst_0
      //   1108: invokevirtual 237	android/widget/TextView:setVisibility	(I)V
      //   1111: goto -679 -> 432
      //   1114: aload_3
      //   1115: getfield 234	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:Ydv	Landroid/widget/TextView;
      //   1118: bipush 8
      //   1120: invokevirtual 237	android/widget/TextView:setVisibility	(I)V
      //   1123: goto -691 -> 432
      //   1126: aload_3
      //   1127: getfield 171	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:Eoo	Landroid/widget/TextView;
      //   1130: aload_0
      //   1131: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:Ydq	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   1134: invokestatic 175	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
      //   1137: getstatic 550	com/tencent/mm/R$l:emoji_store_title	I
      //   1140: invokevirtual 464	android/content/Context:getString	(I)Ljava/lang/String;
      //   1143: invokevirtual 187	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   1146: invokestatic 243	com/tencent/mm/model/bh:bCz	()Lcom/tencent/mm/model/c;
      //   1149: pop
      //   1150: invokestatic 249	com/tencent/mm/model/c:ban	()Lcom/tencent/mm/storage/aq;
      //   1153: ldc_w 551
      //   1156: getstatic 476	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   1159: invokevirtual 480	com/tencent/mm/storage/aq:d	(ILjava/lang/Object;)Ljava/lang/Object;
      //   1162: checkcast 472	java/lang/Boolean
      //   1165: invokevirtual 483	java/lang/Boolean:booleanValue	()Z
      //   1168: istore 6
      //   1170: invokestatic 243	com/tencent/mm/model/bh:bCz	()Lcom/tencent/mm/model/c;
      //   1173: pop
      //   1174: invokestatic 249	com/tencent/mm/model/c:ban	()Lcom/tencent/mm/storage/aq;
      //   1177: ldc_w 552
      //   1180: getstatic 476	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   1183: invokevirtual 480	com/tencent/mm/storage/aq:d	(ILjava/lang/Object;)Ljava/lang/Object;
      //   1186: checkcast 472	java/lang/Boolean
      //   1189: invokevirtual 483	java/lang/Boolean:booleanValue	()Z
      //   1192: istore 7
      //   1194: iload 6
      //   1196: ifne +8 -> 1204
      //   1199: iload 7
      //   1201: ifeq +42 -> 1243
      //   1204: aload_3
      //   1205: getfield 234	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:Ydv	Landroid/widget/TextView;
      //   1208: iconst_0
      //   1209: invokevirtual 237	android/widget/TextView:setVisibility	(I)V
      //   1212: iload 7
      //   1214: ifeq +16 -> 1230
      //   1217: aload_3
      //   1218: getfield 234	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:Ydv	Landroid/widget/TextView;
      //   1221: getstatic 555	com/tencent/mm/R$l:app_free	I
      //   1224: invokevirtual 557	android/widget/TextView:setText	(I)V
      //   1227: goto -795 -> 432
      //   1230: aload_3
      //   1231: getfield 234	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:Ydv	Landroid/widget/TextView;
      //   1234: getstatic 560	com/tencent/mm/R$l:app_new	I
      //   1237: invokevirtual 557	android/widget/TextView:setText	(I)V
      //   1240: goto -808 -> 432
      //   1243: aload_3
      //   1244: getfield 234	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:Ydv	Landroid/widget/TextView;
      //   1247: bipush 8
      //   1249: invokevirtual 237	android/widget/TextView:setVisibility	(I)V
      //   1252: goto -820 -> 432
      //   1255: ldc 47
      //   1257: ldc_w 562
      //   1260: invokestatic 416	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   1263: aload_3
      //   1264: getfield 171	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:Eoo	Landroid/widget/TextView;
      //   1267: getstatic 565	com/tencent/mm/R$h:wcpay_report_view_id	I
      //   1270: getstatic 571	com/tencent/mm/plugin/wxpayreport/a/c$a:XJE	Lcom/tencent/mm/plugin/wxpayreport/a/c$a;
      //   1273: invokevirtual 574	com/tencent/mm/plugin/wxpayreport/a/c$a:name	()Ljava/lang/String;
      //   1276: invokevirtual 577	android/widget/TextView:setTag	(ILjava/lang/Object;)V
      //   1279: aload_0
      //   1280: aload_3
      //   1281: getstatic 144	com/tencent/mm/pluginsdk/model/app/g:XSb	Ljava/lang/String;
      //   1284: aload_0
      //   1285: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:Ydq	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   1288: invokestatic 175	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
      //   1291: getstatic 580	com/tencent/mm/R$l:app_field_transfer	I
      //   1294: invokevirtual 464	android/content/Context:getString	(I)Ljava/lang/String;
      //   1297: invokespecial 582	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:a	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a;Ljava/lang/String;Ljava/lang/String;)V
      //   1300: goto -868 -> 432
      //   1303: ldc 47
      //   1305: ldc_w 584
      //   1308: invokestatic 416	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   1311: aload_3
      //   1312: getfield 171	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:Eoo	Landroid/widget/TextView;
      //   1315: getstatic 565	com/tencent/mm/R$h:wcpay_report_view_id	I
      //   1318: getstatic 587	com/tencent/mm/plugin/wxpayreport/a/c$a:XJF	Lcom/tencent/mm/plugin/wxpayreport/a/c$a;
      //   1321: invokevirtual 574	com/tencent/mm/plugin/wxpayreport/a/c$a:name	()Ljava/lang/String;
      //   1324: invokevirtual 577	android/widget/TextView:setTag	(ILjava/lang/Object;)V
      //   1327: aload_0
      //   1328: aload_3
      //   1329: getstatic 266	com/tencent/mm/pluginsdk/model/app/g:XSd	Ljava/lang/String;
      //   1332: aload_0
      //   1333: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:Ydq	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   1336: invokestatic 175	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
      //   1339: getstatic 590	com/tencent/mm/R$l:app_field_lucky_money	I
      //   1342: invokevirtual 464	android/content/Context:getString	(I)Ljava/lang/String;
      //   1345: invokespecial 582	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:a	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a;Ljava/lang/String;Ljava/lang/String;)V
      //   1348: goto -916 -> 432
      //   1351: aload_3
      //   1352: getfield 157	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:dpM	Landroid/widget/ImageView;
      //   1355: getstatic 593	com/tencent/mm/R$k:panel_icon_multitalk	I
      //   1358: invokevirtual 167	android/widget/ImageView:setImageResource	(I)V
      //   1361: aload_3
      //   1362: getfield 171	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:Eoo	Landroid/widget/TextView;
      //   1365: aload_0
      //   1366: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:Ydq	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   1369: invokestatic 175	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
      //   1372: getstatic 547	com/tencent/mm/R$l:app_field_voipaudio	I
      //   1375: invokevirtual 464	android/content/Context:getString	(I)Ljava/lang/String;
      //   1378: invokevirtual 187	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   1381: invokestatic 243	com/tencent/mm/model/bh:bCz	()Lcom/tencent/mm/model/c;
      //   1384: pop
      //   1385: invokestatic 249	com/tencent/mm/model/c:ban	()Lcom/tencent/mm/storage/aq;
      //   1388: bipush 81
      //   1390: getstatic 476	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   1393: invokevirtual 480	com/tencent/mm/storage/aq:d	(ILjava/lang/Object;)Ljava/lang/Object;
      //   1396: checkcast 472	java/lang/Boolean
      //   1399: invokevirtual 483	java/lang/Boolean:booleanValue	()Z
      //   1402: ifeq +14 -> 1416
      //   1405: aload_3
      //   1406: getfield 234	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:Ydv	Landroid/widget/TextView;
      //   1409: iconst_0
      //   1410: invokevirtual 237	android/widget/TextView:setVisibility	(I)V
      //   1413: goto -981 -> 432
      //   1416: aload_3
      //   1417: getfield 234	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:Ydv	Landroid/widget/TextView;
      //   1420: bipush 8
      //   1422: invokevirtual 237	android/widget/TextView:setVisibility	(I)V
      //   1425: goto -993 -> 432
      //   1428: aload_3
      //   1429: getfield 157	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:dpM	Landroid/widget/ImageView;
      //   1432: getstatic 596	com/tencent/mm/R$k:panel_icon_enterprise	I
      //   1435: invokevirtual 167	android/widget/ImageView:setImageResource	(I)V
      //   1438: aload_3
      //   1439: getfield 171	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:Eoo	Landroid/widget/TextView;
      //   1442: aload_0
      //   1443: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:Ydq	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   1446: invokestatic 175	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
      //   1449: getstatic 599	com/tencent/mm/R$l:app_field_enterprise_brand	I
      //   1452: invokevirtual 464	android/content/Context:getString	(I)Ljava/lang/String;
      //   1455: invokevirtual 187	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   1458: aload_3
      //   1459: getfield 403	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:Ydx	Landroid/view/View;
      //   1462: bipush 8
      //   1464: invokevirtual 417	android/view/View:setVisibility	(I)V
      //   1467: goto -1035 -> 432
      //   1470: astore 8
      //   1472: goto -1040 -> 432
      //   1475: aload_3
      //   1476: getfield 157	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:dpM	Landroid/widget/ImageView;
      //   1479: getstatic 602	com/tencent/mm/R$k:icons_filled_gift	I
      //   1482: invokevirtual 167	android/widget/ImageView:setImageResource	(I)V
      //   1485: aload_3
      //   1486: getfield 171	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:Eoo	Landroid/widget/TextView;
      //   1489: aload_0
      //   1490: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:Ydq	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   1493: invokestatic 175	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
      //   1496: getstatic 605	com/tencent/mm/R$l:app_field_gift	I
      //   1499: invokevirtual 464	android/content/Context:getString	(I)Ljava/lang/String;
      //   1502: invokevirtual 187	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   1505: goto -1073 -> 432
      //   1508: aload_0
      //   1509: aload_3
      //   1510: getstatic 278	com/tencent/mm/pluginsdk/model/app/g:XSe	Ljava/lang/String;
      //   1513: aconst_null
      //   1514: invokespecial 582	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:a	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a;Ljava/lang/String;Ljava/lang/String;)V
      //   1517: goto -1085 -> 432
      //   1520: aload_3
      //   1521: getfield 157	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:dpM	Landroid/widget/ImageView;
      //   1524: getstatic 608	com/tencent/mm/R$k:panel_icon_file_explorer	I
      //   1527: invokevirtual 167	android/widget/ImageView:setImageResource	(I)V
      //   1530: aload_3
      //   1531: getfield 171	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:Eoo	Landroid/widget/TextView;
      //   1534: aload_0
      //   1535: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:Ydq	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   1538: invokestatic 175	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
      //   1541: getstatic 611	com/tencent/mm/R$l:app_field_file	I
      //   1544: invokevirtual 464	android/content/Context:getString	(I)Ljava/lang/String;
      //   1547: invokevirtual 187	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   1550: goto -1118 -> 432
      //   1553: aload_3
      //   1554: getfield 157	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:dpM	Landroid/widget/ImageView;
      //   1557: getstatic 614	com/tencent/mm/R$k:icons_filled_grouptool	I
      //   1560: invokevirtual 167	android/widget/ImageView:setImageResource	(I)V
      //   1563: aload_3
      //   1564: getfield 171	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:Eoo	Landroid/widget/TextView;
      //   1567: aload_0
      //   1568: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:Ydq	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   1571: invokestatic 175	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
      //   1574: getstatic 617	com/tencent/mm/R$l:app_field_group_tools	I
      //   1577: invokevirtual 464	android/content/Context:getString	(I)Ljava/lang/String;
      //   1580: invokevirtual 187	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   1583: goto -1151 -> 432
      //   1586: aload_3
      //   1587: getfield 157	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:dpM	Landroid/widget/ImageView;
      //   1590: getstatic 620	com/tencent/mm/R$k:icons_outlined_continued_form	I
      //   1593: invokevirtual 167	android/widget/ImageView:setImageResource	(I)V
      //   1596: aload_3
      //   1597: getfield 171	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:Eoo	Landroid/widget/TextView;
      //   1600: aload_0
      //   1601: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:Ydq	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   1604: invokestatic 175	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
      //   1607: getstatic 623	com/tencent/mm/R$l:app_field_group_solitaire	I
      //   1610: invokevirtual 464	android/content/Context:getString	(I)Ljava/lang/String;
      //   1613: invokevirtual 187	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   1616: goto -1184 -> 432
      //   1619: aload_3
      //   1620: getfield 157	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:dpM	Landroid/widget/ImageView;
      //   1623: getstatic 626	com/tencent/mm/R$k:panel_icon_live	I
      //   1626: invokevirtual 167	android/widget/ImageView:setImageResource	(I)V
      //   1629: aload_3
      //   1630: getfield 171	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:Eoo	Landroid/widget/TextView;
      //   1633: aload_0
      //   1634: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:Ydq	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   1637: invokestatic 175	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
      //   1640: getstatic 629	com/tencent/mm/R$l:app_field_live	I
      //   1643: invokevirtual 464	android/content/Context:getString	(I)Ljava/lang/String;
      //   1646: invokevirtual 187	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   1649: goto -1217 -> 432
      //   1652: aload_0
      //   1653: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:Ydq	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   1656: invokestatic 175	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
      //   1659: invokevirtual 633	android/content/Context:getResources	()Landroid/content/res/Resources;
      //   1662: getstatic 638	com/tencent/mm/R$f:Edge_4A	I
      //   1665: invokevirtual 643	android/content/res/Resources:getDimensionPixelSize	(I)I
      //   1668: istore 4
      //   1670: aload 8
      //   1672: iload 4
      //   1674: putfield 428	android/view/ViewGroup$LayoutParams:width	I
      //   1677: aload 8
      //   1679: iload 4
      //   1681: putfield 431	android/view/ViewGroup$LayoutParams:height	I
      //   1684: aload_3
      //   1685: getfield 157	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:dpM	Landroid/widget/ImageView;
      //   1688: aload 8
      //   1690: invokevirtual 435	android/widget/ImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
      //   1693: aload_3
      //   1694: getfield 157	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:dpM	Landroid/widget/ImageView;
      //   1697: getstatic 649	android/widget/ImageView$ScaleType:FIT_CENTER	Landroid/widget/ImageView$ScaleType;
      //   1700: invokevirtual 653	android/widget/ImageView:setScaleType	(Landroid/widget/ImageView$ScaleType;)V
      //   1703: aload_3
      //   1704: getfield 157	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:dpM	Landroid/widget/ImageView;
      //   1707: getstatic 656	com/tencent/mm/R$k:icon_music_filled	I
      //   1710: invokevirtual 167	android/widget/ImageView:setImageResource	(I)V
      //   1713: aload_3
      //   1714: getfield 171	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:Eoo	Landroid/widget/TextView;
      //   1717: aload_0
      //   1718: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:Ydq	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   1721: invokestatic 175	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
      //   1724: getstatic 659	com/tencent/mm/R$l:app_field_music	I
      //   1727: invokevirtual 464	android/content/Context:getString	(I)Ljava/lang/String;
      //   1730: invokevirtual 187	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   1733: goto -1301 -> 432
      //   1736: aload 8
      //   1738: aload_0
      //   1739: getfield 83	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:Yds	I
      //   1742: putfield 428	android/view/ViewGroup$LayoutParams:width	I
      //   1745: aload 8
      //   1747: aload_0
      //   1748: getfield 83	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:Yds	I
      //   1751: putfield 431	android/view/ViewGroup$LayoutParams:height	I
      //   1754: aload_3
      //   1755: getfield 157	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:dpM	Landroid/widget/ImageView;
      //   1758: aload 8
      //   1760: invokevirtual 435	android/widget/ImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
      //   1763: aload_0
      //   1764: iload_1
      //   1765: invokevirtual 340	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:anJ	(I)Lcom/tencent/mm/pluginsdk/model/app/g;
      //   1768: astore 8
      //   1770: aload 8
      //   1772: ifnull -1340 -> 432
      //   1775: aload 8
      //   1777: instanceof 99
      //   1780: ifeq +303 -> 2083
      //   1783: aload 8
      //   1785: checkcast 99	com/tencent/mm/pluginsdk/ui/chat/a$a
      //   1788: astore 8
      //   1790: aload 8
      //   1792: invokestatic 102	com/tencent/mm/pluginsdk/ui/chat/AppGrid:a	(Lcom/tencent/mm/pluginsdk/ui/chat/a$a;)Lcom/tencent/mm/pluginsdk/ui/chat/a$b;
      //   1795: astore 9
      //   1797: aload 8
      //   1799: getfield 662	com/tencent/mm/pluginsdk/ui/chat/a$a:iconUrl	Ljava/lang/String;
      //   1802: astore 10
      //   1804: iconst_m1
      //   1805: istore 4
      //   1807: aload 10
      //   1809: invokevirtual 665	java/lang/String:hashCode	()I
      //   1812: lookupswitch	default:+28->1840, -793313752:+183->1995, 1442800093:+166->1978
      //   1841: iconst_1
      //   1842: tableswitch	default:+22 -> 1864, 0:+170->2012, 1:+183->2025
      //   1865: getfield 157	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:dpM	Landroid/widget/ImageView;
      //   1868: bipush 8
      //   1870: invokevirtual 418	android/widget/ImageView:setVisibility	(I)V
      //   1873: aload_3
      //   1874: getfield 378	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:Ydu	Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;
      //   1877: iconst_0
      //   1878: invokevirtual 419	com/tencent/mm/pluginsdk/ui/applet/CdnImageView:setVisibility	(I)V
      //   1881: invokestatic 670	com/tencent/mm/ui/aw:isDarkMode	()Z
      //   1884: ifeq +154 -> 2038
      //   1887: aload 8
      //   1889: getfield 673	com/tencent/mm/pluginsdk/ui/chat/a$a:PNd	Ljava/lang/String;
      //   1892: invokestatic 114	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
      //   1895: ifne +143 -> 2038
      //   1898: aload_3
      //   1899: getfield 378	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:Ydu	Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;
      //   1902: aload 8
      //   1904: getfield 673	com/tencent/mm/pluginsdk/ui/chat/a$a:PNd	Ljava/lang/String;
      //   1907: aload_0
      //   1908: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:Ydq	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   1911: invokestatic 175	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
      //   1914: aload 8
      //   1916: getfield 676	com/tencent/mm/pluginsdk/ui/chat/a$a:YeT	I
      //   1919: invokestatic 681	com/tencent/mm/cd/a:fromDPToPix	(Landroid/content/Context;I)I
      //   1922: aload_0
      //   1923: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:Ydq	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   1926: invokestatic 175	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
      //   1929: aload 8
      //   1931: getfield 684	com/tencent/mm/pluginsdk/ui/chat/a$a:YeU	I
      //   1934: invokestatic 681	com/tencent/mm/cd/a:fromDPToPix	(Landroid/content/Context;I)I
      //   1937: invokevirtual 688	com/tencent/mm/pluginsdk/ui/applet/CdnImageView:aW	(Ljava/lang/String;II)V
      //   1940: aload_3
      //   1941: getfield 171	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:Eoo	Landroid/widget/TextView;
      //   1944: aload 9
      //   1946: getfield 691	com/tencent/mm/pluginsdk/ui/chat/a$b:title	Ljava/lang/String;
      //   1949: invokevirtual 187	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   1952: aload 9
      //   1954: getfield 108	com/tencent/mm/pluginsdk/ui/chat/a$b:desc	Ljava/lang/String;
      //   1957: invokestatic 114	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
      //   1960: ifne -1528 -> 432
      //   1963: aload_3
      //   1964: getfield 394	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:pmf	Landroid/widget/TextView;
      //   1967: aload 9
      //   1969: getfield 108	com/tencent/mm/pluginsdk/ui/chat/a$b:desc	Ljava/lang/String;
      //   1972: invokevirtual 187	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   1975: goto -1543 -> 432
      //   1978: aload 10
      //   1980: ldc_w 693
      //   1983: invokevirtual 153	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   1986: ifeq -146 -> 1840
      //   1989: iconst_0
      //   1990: istore 4
      //   1992: goto -152 -> 1840
      //   1995: aload 10
      //   1997: ldc_w 695
      //   2000: invokevirtual 153	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   2003: ifeq -163 -> 1840
      //   2006: iconst_1
      //   2007: istore 4
      //   2009: goto -169 -> 1840
      //   2012: aload_3
      //   2013: getfield 157	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:dpM	Landroid/widget/ImageView;
      //   2016: getstatic 697	com/tencent/mm/R$k:icons_filled_health_note	I
      //   2019: invokevirtual 167	android/widget/ImageView:setImageResource	(I)V
      //   2022: goto -82 -> 1940
      //   2025: aload_3
      //   2026: getfield 157	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:dpM	Landroid/widget/ImageView;
      //   2029: getstatic 699	com/tencent/mm/R$k:icons_filled_live_mark	I
      //   2032: invokevirtual 167	android/widget/ImageView:setImageResource	(I)V
      //   2035: goto -95 -> 1940
      //   2038: aload_3
      //   2039: getfield 378	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:Ydu	Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;
      //   2042: aload 8
      //   2044: getfield 662	com/tencent/mm/pluginsdk/ui/chat/a$a:iconUrl	Ljava/lang/String;
      //   2047: aload_0
      //   2048: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:Ydq	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   2051: invokestatic 175	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
      //   2054: aload 8
      //   2056: getfield 676	com/tencent/mm/pluginsdk/ui/chat/a$a:YeT	I
      //   2059: invokestatic 681	com/tencent/mm/cd/a:fromDPToPix	(Landroid/content/Context;I)I
      //   2062: aload_0
      //   2063: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:Ydq	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   2066: invokestatic 175	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
      //   2069: aload 8
      //   2071: getfield 684	com/tencent/mm/pluginsdk/ui/chat/a$a:YeU	I
      //   2074: invokestatic 681	com/tencent/mm/cd/a:fromDPToPix	(Landroid/content/Context;I)I
      //   2077: invokevirtual 688	com/tencent/mm/pluginsdk/ui/applet/CdnImageView:aW	(Ljava/lang/String;II)V
      //   2080: goto -140 -> 1940
      //   2083: invokestatic 243	com/tencent/mm/model/bh:bCz	()Lcom/tencent/mm/model/c;
      //   2086: pop
      //   2087: invokestatic 702	com/tencent/mm/model/c:isSDCardAvailable	()Z
      //   2090: ifeq +319 -> 2409
      //   2093: aload 8
      //   2095: getfield 705	com/tencent/mm/pluginsdk/model/app/g:field_status	I
      //   2098: iconst_5
      //   2099: if_icmpne +162 -> 2261
      //   2102: aload 8
      //   2104: getfield 147	com/tencent/mm/pluginsdk/model/app/g:field_appId	Ljava/lang/String;
      //   2107: iconst_3
      //   2108: aload_0
      //   2109: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:Ydq	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   2112: invokestatic 175	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
      //   2115: invokestatic 709	com/tencent/mm/cd/a:getDensity	(Landroid/content/Context;)F
      //   2118: invokestatic 712	com/tencent/mm/pluginsdk/model/app/h:c	(Ljava/lang/String;IF)Landroid/graphics/Bitmap;
      //   2121: pop
      //   2122: getstatic 144	com/tencent/mm/pluginsdk/model/app/g:XSb	Ljava/lang/String;
      //   2125: aload 8
      //   2127: getfield 147	com/tencent/mm/pluginsdk/model/app/g:field_appId	Ljava/lang/String;
      //   2130: invokevirtual 153	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   2133: ifeq +182 -> 2315
      //   2136: aload_3
      //   2137: getfield 157	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:dpM	Landroid/widget/ImageView;
      //   2140: getstatic 162	com/tencent/mm/R$k:panel_icon_transfer	I
      //   2143: invokevirtual 167	android/widget/ImageView:setImageResource	(I)V
      //   2146: aload_3
      //   2147: getfield 171	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:Eoo	Landroid/widget/TextView;
      //   2150: aload_0
      //   2151: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:Ydq	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   2154: invokestatic 175	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
      //   2157: aload 8
      //   2159: aconst_null
      //   2160: invokestatic 288	com/tencent/mm/pluginsdk/model/app/h:a	(Landroid/content/Context;Lcom/tencent/mm/pluginsdk/model/app/g;Ljava/lang/String;)Ljava/lang/String;
      //   2163: invokevirtual 187	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   2166: aload 8
      //   2168: invokevirtual 190	com/tencent/mm/pluginsdk/model/app/g:iIs	()Z
      //   2171: ifeq -1739 -> 432
      //   2174: aload 8
      //   2176: invokevirtual 193	com/tencent/mm/pluginsdk/model/app/g:iIt	()Z
      //   2179: ifeq -1747 -> 432
      //   2182: aload_0
      //   2183: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:Ydq	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   2186: invokestatic 196	com/tencent/mm/pluginsdk/ui/chat/AppGrid:i	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/SharedPreferences;
      //   2189: ifnonnull +25 -> 2214
      //   2192: aload_0
      //   2193: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:Ydq	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   2196: aload_0
      //   2197: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:Ydq	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   2200: invokestatic 175	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
      //   2203: invokestatic 202	com/tencent/mm/sdk/platformtools/MMApplicationContext:getDefaultPreferencePath	()Ljava/lang/String;
      //   2206: iconst_0
      //   2207: invokevirtual 208	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
      //   2210: invokestatic 211	com/tencent/mm/pluginsdk/ui/chat/AppGrid:a	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;Landroid/content/SharedPreferences;)Landroid/content/SharedPreferences;
      //   2213: pop
      //   2214: aload_0
      //   2215: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:Ydq	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   2218: invokestatic 196	com/tencent/mm/pluginsdk/ui/chat/AppGrid:i	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/SharedPreferences;
      //   2221: new 213	java/lang/StringBuilder
      //   2224: dup
      //   2225: ldc 215
      //   2227: invokespecial 218	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   2230: aload 8
      //   2232: getfield 147	com/tencent/mm/pluginsdk/model/app/g:field_appId	Ljava/lang/String;
      //   2235: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2238: invokevirtual 225	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2241: iconst_1
      //   2242: invokeinterface 231 3 0
      //   2247: ifeq -1815 -> 432
      //   2250: aload_3
      //   2251: getfield 234	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:Ydv	Landroid/widget/TextView;
      //   2254: iconst_0
      //   2255: invokevirtual 237	android/widget/TextView:setVisibility	(I)V
      //   2258: goto -1826 -> 432
      //   2261: aload 8
      //   2263: invokevirtual 190	com/tencent/mm/pluginsdk/model/app/g:iIs	()Z
      //   2266: ifeq +26 -> 2292
      //   2269: aload 8
      //   2271: getfield 147	com/tencent/mm/pluginsdk/model/app/g:field_appId	Ljava/lang/String;
      //   2274: iconst_4
      //   2275: aload_0
      //   2276: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:Ydq	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   2279: invokestatic 175	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
      //   2282: invokestatic 709	com/tencent/mm/cd/a:getDensity	(Landroid/content/Context;)F
      //   2285: invokestatic 712	com/tencent/mm/pluginsdk/model/app/h:c	(Ljava/lang/String;IF)Landroid/graphics/Bitmap;
      //   2288: pop
      //   2289: goto -167 -> 2122
      //   2292: aload 8
      //   2294: getfield 147	com/tencent/mm/pluginsdk/model/app/g:field_appId	Ljava/lang/String;
      //   2297: iconst_1
      //   2298: aload_0
      //   2299: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:Ydq	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   2302: invokestatic 175	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
      //   2305: invokestatic 709	com/tencent/mm/cd/a:getDensity	(Landroid/content/Context;)F
      //   2308: invokestatic 712	com/tencent/mm/pluginsdk/model/app/h:c	(Ljava/lang/String;IF)Landroid/graphics/Bitmap;
      //   2311: pop
      //   2312: goto -190 -> 2122
      //   2315: getstatic 266	com/tencent/mm/pluginsdk/model/app/g:XSd	Ljava/lang/String;
      //   2318: aload 8
      //   2320: getfield 147	com/tencent/mm/pluginsdk/model/app/g:field_appId	Ljava/lang/String;
      //   2323: invokevirtual 153	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   2326: ifeq +16 -> 2342
      //   2329: aload_3
      //   2330: getfield 157	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:dpM	Landroid/widget/ImageView;
      //   2333: getstatic 269	com/tencent/mm/R$k:panel_icon_luckymoney	I
      //   2336: invokevirtual 167	android/widget/ImageView:setImageResource	(I)V
      //   2339: goto -193 -> 2146
      //   2342: getstatic 272	com/tencent/mm/pluginsdk/model/app/g:XSc	Ljava/lang/String;
      //   2345: aload 8
      //   2347: getfield 147	com/tencent/mm/pluginsdk/model/app/g:field_appId	Ljava/lang/String;
      //   2350: invokevirtual 153	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   2353: ifeq +16 -> 2369
      //   2356: aload_3
      //   2357: getfield 157	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:dpM	Landroid/widget/ImageView;
      //   2360: getstatic 275	com/tencent/mm/R$k:panel_icon_card	I
      //   2363: invokevirtual 167	android/widget/ImageView:setImageResource	(I)V
      //   2366: goto -220 -> 2146
      //   2369: getstatic 278	com/tencent/mm/pluginsdk/model/app/g:XSe	Ljava/lang/String;
      //   2372: aload 8
      //   2374: getfield 147	com/tencent/mm/pluginsdk/model/app/g:field_appId	Ljava/lang/String;
      //   2377: invokevirtual 153	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   2380: ifeq +16 -> 2396
      //   2383: aload_3
      //   2384: getfield 157	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:dpM	Landroid/widget/ImageView;
      //   2387: getstatic 281	com/tencent/mm/R$k:panel_icon_aa	I
      //   2390: invokevirtual 167	android/widget/ImageView:setImageResource	(I)V
      //   2393: goto -247 -> 2146
      //   2396: aload_3
      //   2397: getfield 157	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:dpM	Landroid/widget/ImageView;
      //   2400: getstatic 286	com/tencent/mm/R$g:app_panel_icon_unknowed	I
      //   2403: invokevirtual 715	android/widget/ImageView:setBackgroundResource	(I)V
      //   2406: goto -260 -> 2146
      //   2409: aload_3
      //   2410: getfield 157	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:dpM	Landroid/widget/ImageView;
      //   2413: getstatic 718	com/tencent/mm/R$g:sharemore_nosdcard_icon	I
      //   2416: invokevirtual 715	android/widget/ImageView:setBackgroundResource	(I)V
      //   2419: goto -273 -> 2146
      //   2422: astore 8
      //   2424: goto -1992 -> 432
      //   2427: astore 8
      //   2429: goto -1997 -> 432
      //   2432: astore 8
      //   2434: goto -2002 -> 432
      //   2437: astore 8
      //   2439: goto -2007 -> 432
      //   2442: astore 8
      //   2444: goto -2012 -> 432
      //   2447: astore 8
      //   2449: goto -2017 -> 432
      //   2452: astore 8
      //   2454: goto -2022 -> 432
      //   2457: astore 8
      //   2459: goto -2027 -> 432
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	2462	0	this	a
      //   0	2462	1	paramInt	int
      //   0	2462	2	paramView	View
      //   0	2462	3	paramViewGroup	android.view.ViewGroup
      //   296	1712	4	i	int
      //   312	15	5	j	int
      //   1168	27	6	bool1	boolean
      //   1192	21	7	bool2	boolean
      //   242	203	8	localObject1	Object
      //   1470	289	8	localException1	java.lang.Exception
      //   1768	605	8	localObject2	Object
      //   2422	1	8	localException2	java.lang.Exception
      //   2427	1	8	localException3	java.lang.Exception
      //   2432	1	8	localException4	java.lang.Exception
      //   2437	1	8	localException5	java.lang.Exception
      //   2442	1	8	localException6	java.lang.Exception
      //   2447	1	8	localException7	java.lang.Exception
      //   2452	1	8	localException8	java.lang.Exception
      //   2457	1	8	localException9	java.lang.Exception
      //   1795	173	9	localb	a.b
      //   1802	194	10	str	String
      // Exception table:
      //   from	to	target	type
      //   1458	1467	1470	java/lang/Exception
      //   554	586	2422	java/lang/Exception
      //   589	598	2422	java/lang/Exception
      //   631	663	2427	java/lang/Exception
      //   666	675	2427	java/lang/Exception
      //   813	846	2432	java/lang/Exception
      //   849	858	2432	java/lang/Exception
      //   891	924	2437	java/lang/Exception
      //   927	936	2437	java/lang/Exception
      //   1002	1034	2442	java/lang/Exception
      //   1037	1046	2442	java/lang/Exception
      //   1079	1111	2447	java/lang/Exception
      //   1114	1123	2447	java/lang/Exception
      //   1146	1194	2452	java/lang/Exception
      //   1204	1212	2452	java/lang/Exception
      //   1217	1227	2452	java/lang/Exception
      //   1230	1240	2452	java/lang/Exception
      //   1243	1252	2452	java/lang/Exception
      //   1381	1413	2457	java/lang/Exception
      //   1416	1425	2457	java/lang/Exception
    }
    
    final class a
    {
      TextView Eoo;
      CdnImageView Ydu;
      TextView Ydv;
      View Ydw;
      View Ydx;
      ImageView dpM;
      TextView pmf;
      
      a() {}
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(int paramInt, g paramg);
    
    public abstract int awx(int paramInt);
    
    public abstract void awy(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.AppGrid
 * JD-Core Version:    0.7.0.1
 */