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
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AppGrid
  extends GridView
{
  private b BZN;
  private int BZO;
  private int BZP;
  private int BZQ;
  private int BZR;
  private int BZS;
  private a BZT;
  private Context context;
  private AdapterView.OnItemClickListener mUR;
  private AdapterView.OnItemLongClickListener qdN;
  private SharedPreferences sp;
  
  public AppGrid(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(31442);
    this.BZP = 0;
    this.BZQ = 0;
    this.mUR = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(31433);
        AppGrid.c(AppGrid.this).a(AppGrid.c(AppGrid.this).UW(AppGrid.a(AppGrid.this) * AppGrid.b(AppGrid.this) + paramAnonymousInt), AppGrid.d(AppGrid.this).OU(paramAnonymousInt));
        AppMethodBeat.o(31433);
      }
    };
    this.qdN = new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(31434);
        paramAnonymousAdapterView = AppGrid.c(AppGrid.this);
        int i = AppGrid.c(AppGrid.this).UW(AppGrid.a(AppGrid.this) * AppGrid.b(AppGrid.this) + paramAnonymousInt);
        AppGrid.d(AppGrid.this).OU(paramAnonymousInt);
        paramAnonymousAdapterView.UX(i);
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
    this.BZP = 0;
    this.BZQ = 0;
    this.mUR = new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(31433);
        AppGrid.c(AppGrid.this).a(AppGrid.c(AppGrid.this).UW(AppGrid.a(AppGrid.this) * AppGrid.b(AppGrid.this) + paramAnonymousInt), AppGrid.d(AppGrid.this).OU(paramAnonymousInt));
        AppMethodBeat.o(31433);
      }
    };
    this.qdN = new AdapterView.OnItemLongClickListener()
    {
      public final boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(31434);
        paramAnonymousAdapterView = AppGrid.c(AppGrid.this);
        int i = AppGrid.c(AppGrid.this).UW(AppGrid.a(AppGrid.this) * AppGrid.b(AppGrid.this) + paramAnonymousInt);
        AppGrid.d(AppGrid.this).OU(paramAnonymousInt);
        paramAnonymousAdapterView.UX(i);
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
    String str = ac.eFu();
    if ("zh_CN".equals(str))
    {
      parama = parama.Cbo;
      AppMethodBeat.o(163203);
      return parama;
    }
    if ("zh_TW".equals(str))
    {
      parama = parama.Cbq;
      AppMethodBeat.o(163203);
      return parama;
    }
    if ("zh_HK".equals(str))
    {
      parama = parama.Cbp;
      AppMethodBeat.o(163203);
      return parama;
    }
    parama = parama.Cbr;
    AppMethodBeat.o(163203);
    return parama;
  }
  
  public final void UV(int paramInt)
  {
    AppMethodBeat.i(31444);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(31444);
      return;
    }
    setPadding(BackwardSupportUtil.b.g(this.context, 16.0F), paramInt, BackwardSupportUtil.b.g(this.context, 16.0F), 0);
    setVerticalSpacing(paramInt / 2);
    AppMethodBeat.o(31444);
  }
  
  public final void a(List<g> paramList, Map<String, g> paramMap, ArrayList<a.a> paramArrayList)
  {
    AppMethodBeat.i(163202);
    this.BZT = new a(this.context, paramList, paramMap, paramArrayList);
    setBackgroundResource(0);
    setAdapter(this.BZT);
    setOnItemClickListener(this.mUR);
    setOnItemLongClickListener(this.qdN);
    int i = BackwardSupportUtil.b.g(this.context, 16.0F);
    int j = BackwardSupportUtil.b.g(this.context, 16.0F);
    setPadding(i, BackwardSupportUtil.b.g(this.context, 6.0F), j, 0);
    AppMethodBeat.o(163202);
  }
  
  public final void b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(31445);
    this.BZR = paramInt1;
    this.BZO = paramInt2;
    this.BZP = paramInt3;
    this.BZQ = paramInt4;
    this.BZS = paramInt6;
    setNumColumns(paramInt5);
    AppMethodBeat.o(31445);
  }
  
  public int getCount()
  {
    AppMethodBeat.i(31446);
    int i = this.BZT.getCount();
    AppMethodBeat.o(31446);
    return i;
  }
  
  public void setOnAppSelectedListener(b paramb)
  {
    this.BZN = paramb;
  }
  
  final class a
    extends BaseAdapter
  {
    private int BZV;
    private int BZW;
    private Map<String, g> BZX;
    List<g> hND;
    private boolean uHs;
    
    public a(List<g> paramList, Map<String, g> paramMap, ArrayList<a.a> paramArrayList)
    {
      AppMethodBeat.i(163201);
      this.hND = new ArrayList();
      this.BZX = null;
      this.uHs = false;
      if (paramMap == null) {}
      for (int i = -1;; i = paramMap.size())
      {
        ad.i("MicroMsg.AppGrid", "AppGridAdapter infoList size:%s ", new Object[] { Integer.valueOf(i) });
        this.hND.clear();
        this.hND.addAll(paramMap);
        Collection localCollection;
        this.hND.addAll(localCollection);
        this.BZX = paramArrayList;
        this.BZV = BackwardSupportUtil.b.g(paramList, 56.0F);
        this.BZW = BackwardSupportUtil.b.g(paramList, 53.299999F);
        this$1 = localCollection.iterator();
        do
        {
          if (!AppGrid.this.hasNext()) {
            break;
          }
          paramList = AppGrid.a((a.a)AppGrid.this.next());
        } while ((paramList == null) || (bt.isNullOrNil(paramList.desc)));
        this.uHs = true;
        AppMethodBeat.o(163201);
        return;
      }
      AppMethodBeat.o(163201);
    }
    
    private void a(a parama, String paramString1, String paramString2)
    {
      AppMethodBeat.i(31439);
      if (this.BZX == null)
      {
        ad.w("MicroMsg.AppGrid", "func[attachHarcodeServiceApp] harcodeServiceAppInfoMap null");
        AppMethodBeat.o(31439);
        return;
      }
      paramString1 = (g)this.BZX.get(paramString1);
      if (paramString1 == null)
      {
        ad.w("MicroMsg.AppGrid", "func[attachHarcodeServiceApp] info null");
        AppMethodBeat.o(31439);
        return;
      }
      if (g.BPE.equals(paramString1.field_appId))
      {
        parama.hg.setImageResource(2131691015);
        if (bt.isNullOrNil(paramString2)) {
          break label338;
        }
        parama.sgt.setText(h.b(AppGrid.h(AppGrid.this), paramString1, paramString2));
      }
      int i;
      for (;;)
      {
        if ((paramString1.evD()) && (paramString1.evE()))
        {
          if (AppGrid.i(AppGrid.this) == null) {
            AppGrid.a(AppGrid.this, AppGrid.h(AppGrid.this).getSharedPreferences(aj.eFD(), 0));
          }
          if (AppGrid.i(AppGrid.this).getBoolean("SP_KEY_SERVICE_APP_PREFIX_" + paramString1.field_appId, true)) {
            parama.BZZ.setVisibility(0);
          }
        }
        if (!g.BPE.equals(paramString1.field_appId)) {
          break label416;
        }
        az.arV();
        i = ((Integer)c.afk().get(ae.a.Fla, Integer.valueOf(0))).intValue();
        if (i > 1) {
          break label360;
        }
        AppMethodBeat.o(31439);
        return;
        if (g.BPG.equals(paramString1.field_appId))
        {
          parama.hg.setImageResource(2131691010);
          break;
        }
        if (g.BPF.equals(paramString1.field_appId))
        {
          parama.hg.setImageResource(2131691004);
          break;
        }
        if (g.BPH.equals(paramString1.field_appId))
        {
          parama.hg.setImageResource(2131691002);
          break;
        }
        parama.hg.setImageResource(2131231048);
        break;
        label338:
        parama.sgt.setText(h.a(AppGrid.h(AppGrid.this), paramString1, null));
      }
      label360:
      az.arV();
      if (!bt.S(((String)c.afk().get(ae.a.Fnr, "")).split(";")).contains(String.valueOf(i))) {
        parama.BZZ.setVisibility(0);
      }
      AppMethodBeat.o(31439);
      return;
      label416:
      if (g.BPG.equals(paramString1.field_appId))
      {
        az.arV();
        i = ((Integer)c.afk().get(ae.a.Fla, Integer.valueOf(0))).intValue();
        if (i <= 1)
        {
          parama.BZZ.setVisibility(8);
          AppMethodBeat.o(31439);
          return;
        }
        az.arV();
        if (!bt.S(((String)c.afk().get(ae.a.Fns, "")).split(";")).contains(String.valueOf(i))) {
          parama.BZZ.setVisibility(0);
        }
      }
      AppMethodBeat.o(31439);
    }
    
    public final g OU(int paramInt)
    {
      AppMethodBeat.i(31437);
      if (((paramInt < AppGrid.g(AppGrid.this)) && (AppGrid.a(AppGrid.this) == 0)) || (AppGrid.a(AppGrid.this) * AppGrid.b(AppGrid.this) + paramInt < AppGrid.g(AppGrid.this)) || (paramInt - AppGrid.g(AppGrid.this) + AppGrid.a(AppGrid.this) * AppGrid.b(AppGrid.this) >= this.hND.size()))
      {
        AppMethodBeat.o(31437);
        return null;
      }
      paramInt = paramInt - AppGrid.g(AppGrid.this) + AppGrid.a(AppGrid.this) * AppGrid.b(AppGrid.this);
      ad.v("MicroMsg.AppGrid", "get item db pos: %d", new Object[] { Integer.valueOf(paramInt) });
      g localg = (g)this.hND.get(paramInt);
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
      //   7: ifnonnull +445 -> 452
      //   10: new 9	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a
      //   13: dup
      //   14: aload_0
      //   15: invokespecial 334	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:<init>	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid$a;)V
      //   18: astore_3
      //   19: aload_0
      //   20: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:BZU	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   23: invokestatic 171	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
      //   26: ldc_w 335
      //   29: aconst_null
      //   30: invokestatic 341	android/view/View:inflate	(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;
      //   33: astore_2
      //   34: aload_3
      //   35: aload_2
      //   36: ldc_w 342
      //   39: invokevirtual 346	android/view/View:findViewById	(I)Landroid/view/View;
      //   42: checkcast 160	android/widget/ImageView
      //   45: putfield 157	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:hg	Landroid/widget/ImageView;
      //   48: aload_3
      //   49: aload_2
      //   50: ldc_w 347
      //   53: invokevirtual 346	android/view/View:findViewById	(I)Landroid/view/View;
      //   56: checkcast 349	com/tencent/mm/pluginsdk/ui/applet/CdnImageView
      //   59: putfield 353	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:BZY	Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;
      //   62: aload_3
      //   63: aload_2
      //   64: ldc_w 354
      //   67: invokevirtual 346	android/view/View:findViewById	(I)Landroid/view/View;
      //   70: putfield 358	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:Caa	Landroid/view/View;
      //   73: aload_3
      //   74: aload_2
      //   75: ldc_w 359
      //   78: invokevirtual 346	android/view/View:findViewById	(I)Landroid/view/View;
      //   81: checkcast 179	android/widget/TextView
      //   84: putfield 167	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:sgt	Landroid/widget/TextView;
      //   87: aload_3
      //   88: aload_2
      //   89: ldc_w 360
      //   92: invokevirtual 346	android/view/View:findViewById	(I)Landroid/view/View;
      //   95: checkcast 179	android/widget/TextView
      //   98: putfield 363	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:hJR	Landroid/widget/TextView;
      //   101: aload_3
      //   102: aload_2
      //   103: ldc_w 364
      //   106: invokevirtual 346	android/view/View:findViewById	(I)Landroid/view/View;
      //   109: checkcast 179	android/widget/TextView
      //   112: putfield 230	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:BZZ	Landroid/widget/TextView;
      //   115: aload_3
      //   116: aload_2
      //   117: ldc_w 365
      //   120: invokevirtual 346	android/view/View:findViewById	(I)Landroid/view/View;
      //   123: putfield 368	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:Cab	Landroid/view/View;
      //   126: aload_2
      //   127: aload_3
      //   128: invokevirtual 372	android/view/View:setTag	(Ljava/lang/Object;)V
      //   131: ldc 47
      //   133: new 209	java/lang/StringBuilder
      //   136: dup
      //   137: ldc_w 374
      //   140: invokespecial 214	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   143: iload_1
      //   144: invokevirtual 377	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   147: ldc_w 379
      //   150: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   153: aload_0
      //   154: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:BZU	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   157: invokestatic 305	com/tencent/mm/pluginsdk/ui/chat/AppGrid:a	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)I
      //   160: invokevirtual 377	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   163: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   166: invokestatic 381	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   169: aload_3
      //   170: getfield 167	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:sgt	Landroid/widget/TextView;
      //   173: iconst_0
      //   174: invokevirtual 233	android/widget/TextView:setVisibility	(I)V
      //   177: aload_0
      //   178: getfield 45	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:uHs	Z
      //   181: ifeq +282 -> 463
      //   184: aload_3
      //   185: getfield 363	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:hJR	Landroid/widget/TextView;
      //   188: iconst_0
      //   189: invokevirtual 233	android/widget/TextView:setVisibility	(I)V
      //   192: aload_3
      //   193: getfield 368	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:Cab	Landroid/view/View;
      //   196: bipush 8
      //   198: invokevirtual 382	android/view/View:setVisibility	(I)V
      //   201: aload_3
      //   202: getfield 230	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:BZZ	Landroid/widget/TextView;
      //   205: bipush 8
      //   207: invokevirtual 233	android/widget/TextView:setVisibility	(I)V
      //   210: aload_3
      //   211: getfield 358	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:Caa	Landroid/view/View;
      //   214: iconst_0
      //   215: invokevirtual 382	android/view/View:setVisibility	(I)V
      //   218: aload_3
      //   219: getfield 157	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:hg	Landroid/widget/ImageView;
      //   222: iconst_0
      //   223: invokevirtual 383	android/widget/ImageView:setVisibility	(I)V
      //   226: aload_3
      //   227: getfield 353	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:BZY	Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;
      //   230: bipush 8
      //   232: invokevirtual 384	com/tencent/mm/pluginsdk/ui/applet/CdnImageView:setVisibility	(I)V
      //   235: aload_3
      //   236: getfield 157	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:hg	Landroid/widget/ImageView;
      //   239: invokevirtual 388	android/widget/ImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
      //   242: astore 8
      //   244: aload 8
      //   246: aload_0
      //   247: getfield 80	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:BZV	I
      //   250: putfield 393	android/view/ViewGroup$LayoutParams:width	I
      //   253: aload 8
      //   255: aload_0
      //   256: getfield 80	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:BZV	I
      //   259: putfield 396	android/view/ViewGroup$LayoutParams:height	I
      //   262: aload_3
      //   263: getfield 157	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:hg	Landroid/widget/ImageView;
      //   266: aload 8
      //   268: invokevirtual 400	android/widget/ImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
      //   271: aload_0
      //   272: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:BZU	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   275: invokestatic 305	com/tencent/mm/pluginsdk/ui/chat/AppGrid:a	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)I
      //   278: aload_0
      //   279: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:BZU	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   282: invokestatic 307	com/tencent/mm/pluginsdk/ui/chat/AppGrid:b	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)I
      //   285: imul
      //   286: iload_1
      //   287: iadd
      //   288: istore 4
      //   290: aload_0
      //   291: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:BZU	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   294: invokestatic 404	com/tencent/mm/pluginsdk/ui/chat/AppGrid:c	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid$b;
      //   297: iload 4
      //   299: invokeinterface 410 2 0
      //   304: istore 5
      //   306: iload 4
      //   308: aload_0
      //   309: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:BZU	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   312: invokestatic 303	com/tencent/mm/pluginsdk/ui/chat/AppGrid:g	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)I
      //   315: if_icmpge +1283 -> 1598
      //   318: iload 5
      //   320: tableswitch	default:+96 -> 416, 0:+420->740, 1:+348->668, 2:+648->968, 3:+1007->1327, 4:+728->1048, 5:+188->508, 6:+453->773, 7:+975->1295, 8:+943->1263, 9:+1134->1454, 10:+268->588, 11:+155->475, 12:+1179->1499, 13:+1212->1532, 14:+615->935, 15:+808->1128, 16:+534->854, 17:+1087->1407, 18:+1146->1466, 19:+1245->1565
      //   417: iload_1
      //   418: invokevirtual 325	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:OU	(I)Lcom/tencent/mm/pluginsdk/model/app/g;
      //   421: astore 8
      //   423: aload 8
      //   425: ifnull +19 -> 444
      //   428: aload 8
      //   430: invokestatic 413	com/tencent/mm/pluginsdk/model/app/h:o	(Lcom/tencent/mm/pluginsdk/model/app/g;)Z
      //   433: ifeq +11 -> 444
      //   436: aload_3
      //   437: getfield 230	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:BZZ	Landroid/widget/TextView;
      //   440: iconst_0
      //   441: invokevirtual 233	android/widget/TextView:setVisibility	(I)V
      //   444: sipush 31438
      //   447: invokestatic 117	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   450: aload_2
      //   451: areturn
      //   452: aload_2
      //   453: invokevirtual 416	android/view/View:getTag	()Ljava/lang/Object;
      //   456: checkcast 9	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a
      //   459: astore_3
      //   460: goto -329 -> 131
      //   463: aload_3
      //   464: getfield 363	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:hJR	Landroid/widget/TextView;
      //   467: bipush 8
      //   469: invokevirtual 233	android/widget/TextView:setVisibility	(I)V
      //   472: goto -280 -> 192
      //   475: aload_3
      //   476: getfield 157	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:hg	Landroid/widget/ImageView;
      //   479: ldc_w 417
      //   482: invokevirtual 163	android/widget/ImageView:setImageResource	(I)V
      //   485: aload_3
      //   486: getfield 167	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:sgt	Landroid/widget/TextView;
      //   489: aload_0
      //   490: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:BZU	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   493: invokestatic 171	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
      //   496: ldc_w 418
      //   499: invokevirtual 421	android/content/Context:getString	(I)Ljava/lang/String;
      //   502: invokevirtual 183	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   505: goto -89 -> 416
      //   508: aload_3
      //   509: getfield 157	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:hg	Landroid/widget/ImageView;
      //   512: ldc_w 422
      //   515: invokevirtual 163	android/widget/ImageView:setImageResource	(I)V
      //   518: aload_3
      //   519: getfield 167	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:sgt	Landroid/widget/TextView;
      //   522: aload_0
      //   523: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:BZU	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   526: invokestatic 171	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
      //   529: ldc_w 423
      //   532: invokevirtual 421	android/content/Context:getString	(I)Ljava/lang/String;
      //   535: invokevirtual 183	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   538: invokestatic 239	com/tencent/mm/model/az:arV	()Lcom/tencent/mm/model/c;
      //   541: pop
      //   542: invokestatic 245	com/tencent/mm/model/c:afk	()Lcom/tencent/mm/storage/ab;
      //   545: bipush 67
      //   547: getstatic 429	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   550: invokevirtual 432	com/tencent/mm/storage/ab:get	(ILjava/lang/Object;)Ljava/lang/Object;
      //   553: checkcast 425	java/lang/Boolean
      //   556: checkcast 425	java/lang/Boolean
      //   559: invokevirtual 435	java/lang/Boolean:booleanValue	()Z
      //   562: ifeq +14 -> 576
      //   565: aload_3
      //   566: getfield 230	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:BZZ	Landroid/widget/TextView;
      //   569: iconst_0
      //   570: invokevirtual 233	android/widget/TextView:setVisibility	(I)V
      //   573: goto -157 -> 416
      //   576: aload_3
      //   577: getfield 230	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:BZZ	Landroid/widget/TextView;
      //   580: bipush 8
      //   582: invokevirtual 233	android/widget/TextView:setVisibility	(I)V
      //   585: goto -169 -> 416
      //   588: aload_3
      //   589: getfield 157	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:hg	Landroid/widget/ImageView;
      //   592: ldc_w 436
      //   595: invokevirtual 163	android/widget/ImageView:setImageResource	(I)V
      //   598: aload_3
      //   599: getfield 167	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:sgt	Landroid/widget/TextView;
      //   602: aload_0
      //   603: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:BZU	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   606: invokestatic 171	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
      //   609: ldc_w 437
      //   612: invokevirtual 421	android/content/Context:getString	(I)Ljava/lang/String;
      //   615: invokevirtual 183	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   618: invokestatic 239	com/tencent/mm/model/az:arV	()Lcom/tencent/mm/model/c;
      //   621: pop
      //   622: invokestatic 245	com/tencent/mm/model/c:afk	()Lcom/tencent/mm/storage/ab;
      //   625: bipush 73
      //   627: getstatic 429	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   630: invokevirtual 432	com/tencent/mm/storage/ab:get	(ILjava/lang/Object;)Ljava/lang/Object;
      //   633: checkcast 425	java/lang/Boolean
      //   636: checkcast 425	java/lang/Boolean
      //   639: invokevirtual 435	java/lang/Boolean:booleanValue	()Z
      //   642: ifeq +14 -> 656
      //   645: aload_3
      //   646: getfield 230	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:BZZ	Landroid/widget/TextView;
      //   649: iconst_0
      //   650: invokevirtual 233	android/widget/TextView:setVisibility	(I)V
      //   653: goto -237 -> 416
      //   656: aload_3
      //   657: getfield 230	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:BZZ	Landroid/widget/TextView;
      //   660: bipush 8
      //   662: invokevirtual 233	android/widget/TextView:setVisibility	(I)V
      //   665: goto -249 -> 416
      //   668: getstatic 442	com/tencent/mm/platformtools/ab:hWB	Z
      //   671: ifeq +36 -> 707
      //   674: aload_3
      //   675: getfield 157	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:hg	Landroid/widget/ImageView;
      //   678: ldc_w 443
      //   681: invokevirtual 163	android/widget/ImageView:setImageResource	(I)V
      //   684: aload_3
      //   685: getfield 167	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:sgt	Landroid/widget/TextView;
      //   688: aload_0
      //   689: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:BZU	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   692: invokestatic 171	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
      //   695: ldc_w 444
      //   698: invokevirtual 421	android/content/Context:getString	(I)Ljava/lang/String;
      //   701: invokevirtual 183	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   704: goto -288 -> 416
      //   707: aload_3
      //   708: getfield 157	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:hg	Landroid/widget/ImageView;
      //   711: ldc_w 445
      //   714: invokevirtual 163	android/widget/ImageView:setImageResource	(I)V
      //   717: aload_3
      //   718: getfield 167	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:sgt	Landroid/widget/TextView;
      //   721: aload_0
      //   722: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:BZU	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   725: invokestatic 171	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
      //   728: ldc_w 446
      //   731: invokevirtual 421	android/content/Context:getString	(I)Ljava/lang/String;
      //   734: invokevirtual 183	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   737: goto -321 -> 416
      //   740: aload_3
      //   741: getfield 157	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:hg	Landroid/widget/ImageView;
      //   744: ldc_w 447
      //   747: invokevirtual 163	android/widget/ImageView:setImageResource	(I)V
      //   750: aload_3
      //   751: getfield 167	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:sgt	Landroid/widget/TextView;
      //   754: aload_0
      //   755: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:BZU	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   758: invokestatic 171	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
      //   761: ldc_w 448
      //   764: invokevirtual 421	android/content/Context:getString	(I)Ljava/lang/String;
      //   767: invokevirtual 183	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   770: goto -354 -> 416
      //   773: aload_3
      //   774: getfield 157	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:hg	Landroid/widget/ImageView;
      //   777: ldc_w 449
      //   780: invokevirtual 163	android/widget/ImageView:setImageResource	(I)V
      //   783: aload_3
      //   784: getfield 167	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:sgt	Landroid/widget/TextView;
      //   787: aload_0
      //   788: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:BZU	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   791: invokestatic 171	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
      //   794: ldc_w 450
      //   797: invokevirtual 421	android/content/Context:getString	(I)Ljava/lang/String;
      //   800: invokevirtual 183	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   803: invokestatic 239	com/tencent/mm/model/az:arV	()Lcom/tencent/mm/model/c;
      //   806: pop
      //   807: invokestatic 245	com/tencent/mm/model/c:afk	()Lcom/tencent/mm/storage/ab;
      //   810: ldc_w 451
      //   813: getstatic 429	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   816: invokevirtual 432	com/tencent/mm/storage/ab:get	(ILjava/lang/Object;)Ljava/lang/Object;
      //   819: checkcast 425	java/lang/Boolean
      //   822: checkcast 425	java/lang/Boolean
      //   825: invokevirtual 435	java/lang/Boolean:booleanValue	()Z
      //   828: ifeq +14 -> 842
      //   831: aload_3
      //   832: getfield 368	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:Cab	Landroid/view/View;
      //   835: iconst_0
      //   836: invokevirtual 382	android/view/View:setVisibility	(I)V
      //   839: goto -423 -> 416
      //   842: aload_3
      //   843: getfield 368	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:Cab	Landroid/view/View;
      //   846: bipush 8
      //   848: invokevirtual 382	android/view/View:setVisibility	(I)V
      //   851: goto -435 -> 416
      //   854: aload_3
      //   855: getfield 157	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:hg	Landroid/widget/ImageView;
      //   858: ldc_w 452
      //   861: invokevirtual 163	android/widget/ImageView:setImageResource	(I)V
      //   864: aload_3
      //   865: getfield 167	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:sgt	Landroid/widget/TextView;
      //   868: aload_0
      //   869: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:BZU	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   872: invokestatic 171	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
      //   875: ldc_w 453
      //   878: invokevirtual 421	android/content/Context:getString	(I)Ljava/lang/String;
      //   881: invokevirtual 183	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   884: invokestatic 239	com/tencent/mm/model/az:arV	()Lcom/tencent/mm/model/c;
      //   887: pop
      //   888: invokestatic 245	com/tencent/mm/model/c:afk	()Lcom/tencent/mm/storage/ab;
      //   891: ldc_w 454
      //   894: getstatic 457	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
      //   897: invokevirtual 432	com/tencent/mm/storage/ab:get	(ILjava/lang/Object;)Ljava/lang/Object;
      //   900: checkcast 425	java/lang/Boolean
      //   903: checkcast 425	java/lang/Boolean
      //   906: invokevirtual 435	java/lang/Boolean:booleanValue	()Z
      //   909: ifeq +14 -> 923
      //   912: aload_3
      //   913: getfield 368	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:Cab	Landroid/view/View;
      //   916: iconst_0
      //   917: invokevirtual 382	android/view/View:setVisibility	(I)V
      //   920: goto -504 -> 416
      //   923: aload_3
      //   924: getfield 368	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:Cab	Landroid/view/View;
      //   927: bipush 8
      //   929: invokevirtual 382	android/view/View:setVisibility	(I)V
      //   932: goto -516 -> 416
      //   935: aload_3
      //   936: getfield 157	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:hg	Landroid/widget/ImageView;
      //   939: ldc_w 458
      //   942: invokevirtual 163	android/widget/ImageView:setImageResource	(I)V
      //   945: aload_3
      //   946: getfield 167	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:sgt	Landroid/widget/TextView;
      //   949: aload_0
      //   950: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:BZU	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   953: invokestatic 171	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
      //   956: ldc_w 459
      //   959: invokevirtual 421	android/content/Context:getString	(I)Ljava/lang/String;
      //   962: invokevirtual 183	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   965: goto -549 -> 416
      //   968: aload_3
      //   969: getfield 157	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:hg	Landroid/widget/ImageView;
      //   972: ldc_w 460
      //   975: invokevirtual 163	android/widget/ImageView:setImageResource	(I)V
      //   978: aload_3
      //   979: getfield 167	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:sgt	Landroid/widget/TextView;
      //   982: aload_0
      //   983: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:BZU	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   986: invokestatic 171	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
      //   989: ldc_w 461
      //   992: invokevirtual 421	android/content/Context:getString	(I)Ljava/lang/String;
      //   995: invokevirtual 183	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   998: invokestatic 239	com/tencent/mm/model/az:arV	()Lcom/tencent/mm/model/c;
      //   1001: pop
      //   1002: invokestatic 245	com/tencent/mm/model/c:afk	()Lcom/tencent/mm/storage/ab;
      //   1005: bipush 54
      //   1007: getstatic 429	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   1010: invokevirtual 432	com/tencent/mm/storage/ab:get	(ILjava/lang/Object;)Ljava/lang/Object;
      //   1013: checkcast 425	java/lang/Boolean
      //   1016: checkcast 425	java/lang/Boolean
      //   1019: invokevirtual 435	java/lang/Boolean:booleanValue	()Z
      //   1022: ifeq +14 -> 1036
      //   1025: aload_3
      //   1026: getfield 230	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:BZZ	Landroid/widget/TextView;
      //   1029: iconst_0
      //   1030: invokevirtual 233	android/widget/TextView:setVisibility	(I)V
      //   1033: goto -617 -> 416
      //   1036: aload_3
      //   1037: getfield 230	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:BZZ	Landroid/widget/TextView;
      //   1040: bipush 8
      //   1042: invokevirtual 233	android/widget/TextView:setVisibility	(I)V
      //   1045: goto -629 -> 416
      //   1048: aload_3
      //   1049: getfield 157	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:hg	Landroid/widget/ImageView;
      //   1052: ldc_w 462
      //   1055: invokevirtual 163	android/widget/ImageView:setImageResource	(I)V
      //   1058: aload_3
      //   1059: getfield 167	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:sgt	Landroid/widget/TextView;
      //   1062: aload_0
      //   1063: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:BZU	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   1066: invokestatic 171	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
      //   1069: ldc_w 463
      //   1072: invokevirtual 421	android/content/Context:getString	(I)Ljava/lang/String;
      //   1075: invokevirtual 183	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   1078: invokestatic 239	com/tencent/mm/model/az:arV	()Lcom/tencent/mm/model/c;
      //   1081: pop
      //   1082: invokestatic 245	com/tencent/mm/model/c:afk	()Lcom/tencent/mm/storage/ab;
      //   1085: bipush 62
      //   1087: getstatic 429	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   1090: invokevirtual 432	com/tencent/mm/storage/ab:get	(ILjava/lang/Object;)Ljava/lang/Object;
      //   1093: checkcast 425	java/lang/Boolean
      //   1096: checkcast 425	java/lang/Boolean
      //   1099: invokevirtual 435	java/lang/Boolean:booleanValue	()Z
      //   1102: ifeq +14 -> 1116
      //   1105: aload_3
      //   1106: getfield 230	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:BZZ	Landroid/widget/TextView;
      //   1109: iconst_0
      //   1110: invokevirtual 233	android/widget/TextView:setVisibility	(I)V
      //   1113: goto -697 -> 416
      //   1116: aload_3
      //   1117: getfield 230	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:BZZ	Landroid/widget/TextView;
      //   1120: bipush 8
      //   1122: invokevirtual 233	android/widget/TextView:setVisibility	(I)V
      //   1125: goto -709 -> 416
      //   1128: aload_3
      //   1129: getfield 167	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:sgt	Landroid/widget/TextView;
      //   1132: aload_0
      //   1133: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:BZU	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   1136: invokestatic 171	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
      //   1139: ldc_w 464
      //   1142: invokevirtual 421	android/content/Context:getString	(I)Ljava/lang/String;
      //   1145: invokevirtual 183	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   1148: invokestatic 239	com/tencent/mm/model/az:arV	()Lcom/tencent/mm/model/c;
      //   1151: pop
      //   1152: invokestatic 245	com/tencent/mm/model/c:afk	()Lcom/tencent/mm/storage/ab;
      //   1155: ldc_w 465
      //   1158: getstatic 429	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   1161: invokevirtual 432	com/tencent/mm/storage/ab:get	(ILjava/lang/Object;)Ljava/lang/Object;
      //   1164: checkcast 425	java/lang/Boolean
      //   1167: checkcast 425	java/lang/Boolean
      //   1170: invokevirtual 435	java/lang/Boolean:booleanValue	()Z
      //   1173: istore 6
      //   1175: invokestatic 239	com/tencent/mm/model/az:arV	()Lcom/tencent/mm/model/c;
      //   1178: pop
      //   1179: invokestatic 245	com/tencent/mm/model/c:afk	()Lcom/tencent/mm/storage/ab;
      //   1182: ldc_w 466
      //   1185: getstatic 429	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   1188: invokevirtual 432	com/tencent/mm/storage/ab:get	(ILjava/lang/Object;)Ljava/lang/Object;
      //   1191: checkcast 425	java/lang/Boolean
      //   1194: checkcast 425	java/lang/Boolean
      //   1197: invokevirtual 435	java/lang/Boolean:booleanValue	()Z
      //   1200: istore 7
      //   1202: iload 6
      //   1204: ifne +8 -> 1212
      //   1207: iload 7
      //   1209: ifeq +42 -> 1251
      //   1212: aload_3
      //   1213: getfield 230	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:BZZ	Landroid/widget/TextView;
      //   1216: iconst_0
      //   1217: invokevirtual 233	android/widget/TextView:setVisibility	(I)V
      //   1220: iload 7
      //   1222: ifeq +16 -> 1238
      //   1225: aload_3
      //   1226: getfield 230	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:BZZ	Landroid/widget/TextView;
      //   1229: ldc_w 467
      //   1232: invokevirtual 469	android/widget/TextView:setText	(I)V
      //   1235: goto -819 -> 416
      //   1238: aload_3
      //   1239: getfield 230	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:BZZ	Landroid/widget/TextView;
      //   1242: ldc_w 470
      //   1245: invokevirtual 469	android/widget/TextView:setText	(I)V
      //   1248: goto -832 -> 416
      //   1251: aload_3
      //   1252: getfield 230	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:BZZ	Landroid/widget/TextView;
      //   1255: bipush 8
      //   1257: invokevirtual 233	android/widget/TextView:setVisibility	(I)V
      //   1260: goto -844 -> 416
      //   1263: ldc 47
      //   1265: ldc_w 472
      //   1268: invokestatic 381	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   1271: aload_0
      //   1272: aload_3
      //   1273: getstatic 144	com/tencent/mm/pluginsdk/model/app/g:BPE	Ljava/lang/String;
      //   1276: aload_0
      //   1277: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:BZU	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   1280: invokestatic 171	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
      //   1283: ldc_w 473
      //   1286: invokevirtual 421	android/content/Context:getString	(I)Ljava/lang/String;
      //   1289: invokespecial 475	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:a	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a;Ljava/lang/String;Ljava/lang/String;)V
      //   1292: goto -876 -> 416
      //   1295: ldc 47
      //   1297: ldc_w 477
      //   1300: invokestatic 381	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   1303: aload_0
      //   1304: aload_3
      //   1305: getstatic 262	com/tencent/mm/pluginsdk/model/app/g:BPG	Ljava/lang/String;
      //   1308: aload_0
      //   1309: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:BZU	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   1312: invokestatic 171	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
      //   1315: ldc_w 478
      //   1318: invokevirtual 421	android/content/Context:getString	(I)Ljava/lang/String;
      //   1321: invokespecial 475	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:a	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a;Ljava/lang/String;Ljava/lang/String;)V
      //   1324: goto -908 -> 416
      //   1327: aload_3
      //   1328: getfield 157	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:hg	Landroid/widget/ImageView;
      //   1331: ldc_w 479
      //   1334: invokevirtual 163	android/widget/ImageView:setImageResource	(I)V
      //   1337: aload_3
      //   1338: getfield 167	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:sgt	Landroid/widget/TextView;
      //   1341: aload_0
      //   1342: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:BZU	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   1345: invokestatic 171	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
      //   1348: ldc_w 463
      //   1351: invokevirtual 421	android/content/Context:getString	(I)Ljava/lang/String;
      //   1354: invokevirtual 183	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   1357: invokestatic 239	com/tencent/mm/model/az:arV	()Lcom/tencent/mm/model/c;
      //   1360: pop
      //   1361: invokestatic 245	com/tencent/mm/model/c:afk	()Lcom/tencent/mm/storage/ab;
      //   1364: bipush 81
      //   1366: getstatic 429	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
      //   1369: invokevirtual 432	com/tencent/mm/storage/ab:get	(ILjava/lang/Object;)Ljava/lang/Object;
      //   1372: checkcast 425	java/lang/Boolean
      //   1375: checkcast 425	java/lang/Boolean
      //   1378: invokevirtual 435	java/lang/Boolean:booleanValue	()Z
      //   1381: ifeq +14 -> 1395
      //   1384: aload_3
      //   1385: getfield 230	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:BZZ	Landroid/widget/TextView;
      //   1388: iconst_0
      //   1389: invokevirtual 233	android/widget/TextView:setVisibility	(I)V
      //   1392: goto -976 -> 416
      //   1395: aload_3
      //   1396: getfield 230	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:BZZ	Landroid/widget/TextView;
      //   1399: bipush 8
      //   1401: invokevirtual 233	android/widget/TextView:setVisibility	(I)V
      //   1404: goto -988 -> 416
      //   1407: aload_3
      //   1408: getfield 157	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:hg	Landroid/widget/ImageView;
      //   1411: ldc_w 480
      //   1414: invokevirtual 163	android/widget/ImageView:setImageResource	(I)V
      //   1417: aload_3
      //   1418: getfield 167	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:sgt	Landroid/widget/TextView;
      //   1421: aload_0
      //   1422: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:BZU	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   1425: invokestatic 171	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
      //   1428: ldc_w 481
      //   1431: invokevirtual 421	android/content/Context:getString	(I)Ljava/lang/String;
      //   1434: invokevirtual 183	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   1437: aload_3
      //   1438: getfield 368	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:Cab	Landroid/view/View;
      //   1441: bipush 8
      //   1443: invokevirtual 382	android/view/View:setVisibility	(I)V
      //   1446: goto -1030 -> 416
      //   1449: astore 8
      //   1451: goto -1035 -> 416
      //   1454: aload_0
      //   1455: aload_3
      //   1456: getstatic 270	com/tencent/mm/pluginsdk/model/app/g:BPH	Ljava/lang/String;
      //   1459: aconst_null
      //   1460: invokespecial 475	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:a	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a;Ljava/lang/String;Ljava/lang/String;)V
      //   1463: goto -1047 -> 416
      //   1466: aload_3
      //   1467: getfield 157	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:hg	Landroid/widget/ImageView;
      //   1470: ldc_w 482
      //   1473: invokevirtual 163	android/widget/ImageView:setImageResource	(I)V
      //   1476: aload_3
      //   1477: getfield 167	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:sgt	Landroid/widget/TextView;
      //   1480: aload_0
      //   1481: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:BZU	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   1484: invokestatic 171	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
      //   1487: ldc_w 483
      //   1490: invokevirtual 421	android/content/Context:getString	(I)Ljava/lang/String;
      //   1493: invokevirtual 183	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   1496: goto -1080 -> 416
      //   1499: aload_3
      //   1500: getfield 157	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:hg	Landroid/widget/ImageView;
      //   1503: ldc_w 484
      //   1506: invokevirtual 163	android/widget/ImageView:setImageResource	(I)V
      //   1509: aload_3
      //   1510: getfield 167	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:sgt	Landroid/widget/TextView;
      //   1513: aload_0
      //   1514: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:BZU	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   1517: invokestatic 171	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
      //   1520: ldc_w 485
      //   1523: invokevirtual 421	android/content/Context:getString	(I)Ljava/lang/String;
      //   1526: invokevirtual 183	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   1529: goto -1113 -> 416
      //   1532: aload_3
      //   1533: getfield 157	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:hg	Landroid/widget/ImageView;
      //   1536: ldc_w 486
      //   1539: invokevirtual 163	android/widget/ImageView:setImageResource	(I)V
      //   1542: aload_3
      //   1543: getfield 167	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:sgt	Landroid/widget/TextView;
      //   1546: aload_0
      //   1547: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:BZU	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   1550: invokestatic 171	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
      //   1553: ldc_w 487
      //   1556: invokevirtual 421	android/content/Context:getString	(I)Ljava/lang/String;
      //   1559: invokevirtual 183	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   1562: goto -1146 -> 416
      //   1565: aload_3
      //   1566: getfield 157	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:hg	Landroid/widget/ImageView;
      //   1569: ldc_w 488
      //   1572: invokevirtual 163	android/widget/ImageView:setImageResource	(I)V
      //   1575: aload_3
      //   1576: getfield 167	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:sgt	Landroid/widget/TextView;
      //   1579: aload_0
      //   1580: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:BZU	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   1583: invokestatic 171	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
      //   1586: ldc_w 489
      //   1589: invokevirtual 421	android/content/Context:getString	(I)Ljava/lang/String;
      //   1592: invokevirtual 183	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   1595: goto -1179 -> 416
      //   1598: aload 8
      //   1600: aload_0
      //   1601: getfield 83	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:BZW	I
      //   1604: putfield 393	android/view/ViewGroup$LayoutParams:width	I
      //   1607: aload 8
      //   1609: aload_0
      //   1610: getfield 83	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:BZW	I
      //   1613: putfield 396	android/view/ViewGroup$LayoutParams:height	I
      //   1616: aload_3
      //   1617: getfield 157	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:hg	Landroid/widget/ImageView;
      //   1620: aload 8
      //   1622: invokevirtual 400	android/widget/ImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
      //   1625: aload_0
      //   1626: iload_1
      //   1627: invokevirtual 325	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:OU	(I)Lcom/tencent/mm/pluginsdk/model/app/g;
      //   1630: astore 8
      //   1632: aload 8
      //   1634: ifnull -1218 -> 416
      //   1637: aload 8
      //   1639: instanceof 99
      //   1642: ifeq +241 -> 1883
      //   1645: aload 8
      //   1647: checkcast 99	com/tencent/mm/pluginsdk/ui/chat/a$a
      //   1650: astore 8
      //   1652: aload 8
      //   1654: invokestatic 102	com/tencent/mm/pluginsdk/ui/chat/AppGrid:a	(Lcom/tencent/mm/pluginsdk/ui/chat/a$a;)Lcom/tencent/mm/pluginsdk/ui/chat/a$b;
      //   1657: astore 9
      //   1659: aload 8
      //   1661: getfield 492	com/tencent/mm/pluginsdk/ui/chat/a$a:iconUrl	Ljava/lang/String;
      //   1664: astore 10
      //   1666: iconst_m1
      //   1667: istore 4
      //   1669: aload 10
      //   1671: invokevirtual 495	java/lang/String:hashCode	()I
      //   1674: lookupswitch	default:+26->1700, -793313752:+151->1825, 1442800093:+134->1808
      //   1701: iconst_1
      //   1702: tableswitch	default:+22 -> 1724, 0:+140->1842, 1:+153->1855
      //   1725: getfield 157	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:hg	Landroid/widget/ImageView;
      //   1728: bipush 8
      //   1730: invokevirtual 383	android/widget/ImageView:setVisibility	(I)V
      //   1733: aload_3
      //   1734: getfield 353	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:BZY	Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;
      //   1737: iconst_0
      //   1738: invokevirtual 384	com/tencent/mm/pluginsdk/ui/applet/CdnImageView:setVisibility	(I)V
      //   1741: invokestatic 500	com/tencent/mm/ui/ai:Eq	()Z
      //   1744: ifeq +124 -> 1868
      //   1747: aload 8
      //   1749: getfield 503	com/tencent/mm/pluginsdk/ui/chat/a$a:Cbs	Ljava/lang/String;
      //   1752: invokestatic 114	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
      //   1755: ifne +113 -> 1868
      //   1758: aload_3
      //   1759: getfield 353	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:BZY	Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;
      //   1762: aload 8
      //   1764: getfield 503	com/tencent/mm/pluginsdk/ui/chat/a$a:Cbs	Ljava/lang/String;
      //   1767: invokevirtual 506	com/tencent/mm/pluginsdk/ui/applet/CdnImageView:setUrl	(Ljava/lang/String;)V
      //   1770: aload_3
      //   1771: getfield 167	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:sgt	Landroid/widget/TextView;
      //   1774: aload 9
      //   1776: getfield 509	com/tencent/mm/pluginsdk/ui/chat/a$b:title	Ljava/lang/String;
      //   1779: invokevirtual 183	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   1782: aload 9
      //   1784: getfield 108	com/tencent/mm/pluginsdk/ui/chat/a$b:desc	Ljava/lang/String;
      //   1787: invokestatic 114	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
      //   1790: ifne -1374 -> 416
      //   1793: aload_3
      //   1794: getfield 363	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:hJR	Landroid/widget/TextView;
      //   1797: aload 9
      //   1799: getfield 108	com/tencent/mm/pluginsdk/ui/chat/a$b:desc	Ljava/lang/String;
      //   1802: invokevirtual 183	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   1805: goto -1389 -> 416
      //   1808: aload 10
      //   1810: ldc_w 511
      //   1813: invokevirtual 153	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   1816: ifeq -116 -> 1700
      //   1819: iconst_0
      //   1820: istore 4
      //   1822: goto -122 -> 1700
      //   1825: aload 10
      //   1827: ldc_w 513
      //   1830: invokevirtual 153	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   1833: ifeq -133 -> 1700
      //   1836: iconst_1
      //   1837: istore 4
      //   1839: goto -139 -> 1700
      //   1842: aload_3
      //   1843: getfield 157	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:hg	Landroid/widget/ImageView;
      //   1846: ldc_w 514
      //   1849: invokevirtual 163	android/widget/ImageView:setImageResource	(I)V
      //   1852: goto -82 -> 1770
      //   1855: aload_3
      //   1856: getfield 157	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:hg	Landroid/widget/ImageView;
      //   1859: ldc_w 515
      //   1862: invokevirtual 163	android/widget/ImageView:setImageResource	(I)V
      //   1865: goto -95 -> 1770
      //   1868: aload_3
      //   1869: getfield 353	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:BZY	Lcom/tencent/mm/pluginsdk/ui/applet/CdnImageView;
      //   1872: aload 8
      //   1874: getfield 492	com/tencent/mm/pluginsdk/ui/chat/a$a:iconUrl	Ljava/lang/String;
      //   1877: invokevirtual 506	com/tencent/mm/pluginsdk/ui/applet/CdnImageView:setUrl	(Ljava/lang/String;)V
      //   1880: goto -110 -> 1770
      //   1883: invokestatic 239	com/tencent/mm/model/az:arV	()Lcom/tencent/mm/model/c;
      //   1886: pop
      //   1887: invokestatic 518	com/tencent/mm/model/c:isSDCardAvailable	()Z
      //   1890: ifeq +318 -> 2208
      //   1893: aload 8
      //   1895: getfield 521	com/tencent/mm/pluginsdk/model/app/g:field_status	I
      //   1898: iconst_5
      //   1899: if_icmpne +161 -> 2060
      //   1902: aload 8
      //   1904: getfield 147	com/tencent/mm/pluginsdk/model/app/g:field_appId	Ljava/lang/String;
      //   1907: iconst_3
      //   1908: aload_0
      //   1909: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:BZU	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   1912: invokestatic 171	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
      //   1915: invokestatic 527	com/tencent/mm/cd/a:getDensity	(Landroid/content/Context;)F
      //   1918: invokestatic 530	com/tencent/mm/pluginsdk/model/app/h:c	(Ljava/lang/String;IF)Landroid/graphics/Bitmap;
      //   1921: pop
      //   1922: getstatic 144	com/tencent/mm/pluginsdk/model/app/g:BPE	Ljava/lang/String;
      //   1925: aload 8
      //   1927: getfield 147	com/tencent/mm/pluginsdk/model/app/g:field_appId	Ljava/lang/String;
      //   1930: invokevirtual 153	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   1933: ifeq +181 -> 2114
      //   1936: aload_3
      //   1937: getfield 157	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:hg	Landroid/widget/ImageView;
      //   1940: ldc 158
      //   1942: invokevirtual 163	android/widget/ImageView:setImageResource	(I)V
      //   1945: aload_3
      //   1946: getfield 167	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:sgt	Landroid/widget/TextView;
      //   1949: aload_0
      //   1950: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:BZU	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   1953: invokestatic 171	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
      //   1956: aload 8
      //   1958: aconst_null
      //   1959: invokestatic 274	com/tencent/mm/pluginsdk/model/app/h:a	(Landroid/content/Context;Lcom/tencent/mm/pluginsdk/model/app/g;Ljava/lang/String;)Ljava/lang/String;
      //   1962: invokevirtual 183	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   1965: aload 8
      //   1967: invokevirtual 186	com/tencent/mm/pluginsdk/model/app/g:evD	()Z
      //   1970: ifeq -1554 -> 416
      //   1973: aload 8
      //   1975: invokevirtual 189	com/tencent/mm/pluginsdk/model/app/g:evE	()Z
      //   1978: ifeq -1562 -> 416
      //   1981: aload_0
      //   1982: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:BZU	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   1985: invokestatic 192	com/tencent/mm/pluginsdk/ui/chat/AppGrid:i	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/SharedPreferences;
      //   1988: ifnonnull +25 -> 2013
      //   1991: aload_0
      //   1992: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:BZU	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   1995: aload_0
      //   1996: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:BZU	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   1999: invokestatic 171	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
      //   2002: invokestatic 198	com/tencent/mm/sdk/platformtools/aj:eFD	()Ljava/lang/String;
      //   2005: iconst_0
      //   2006: invokevirtual 204	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
      //   2009: invokestatic 207	com/tencent/mm/pluginsdk/ui/chat/AppGrid:a	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;Landroid/content/SharedPreferences;)Landroid/content/SharedPreferences;
      //   2012: pop
      //   2013: aload_0
      //   2014: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:BZU	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   2017: invokestatic 192	com/tencent/mm/pluginsdk/ui/chat/AppGrid:i	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/SharedPreferences;
      //   2020: new 209	java/lang/StringBuilder
      //   2023: dup
      //   2024: ldc 211
      //   2026: invokespecial 214	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   2029: aload 8
      //   2031: getfield 147	com/tencent/mm/pluginsdk/model/app/g:field_appId	Ljava/lang/String;
      //   2034: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2037: invokevirtual 221	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2040: iconst_1
      //   2041: invokeinterface 227 3 0
      //   2046: ifeq -1630 -> 416
      //   2049: aload_3
      //   2050: getfield 230	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:BZZ	Landroid/widget/TextView;
      //   2053: iconst_0
      //   2054: invokevirtual 233	android/widget/TextView:setVisibility	(I)V
      //   2057: goto -1641 -> 416
      //   2060: aload 8
      //   2062: invokevirtual 186	com/tencent/mm/pluginsdk/model/app/g:evD	()Z
      //   2065: ifeq +26 -> 2091
      //   2068: aload 8
      //   2070: getfield 147	com/tencent/mm/pluginsdk/model/app/g:field_appId	Ljava/lang/String;
      //   2073: iconst_4
      //   2074: aload_0
      //   2075: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:BZU	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   2078: invokestatic 171	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
      //   2081: invokestatic 527	com/tencent/mm/cd/a:getDensity	(Landroid/content/Context;)F
      //   2084: invokestatic 530	com/tencent/mm/pluginsdk/model/app/h:c	(Ljava/lang/String;IF)Landroid/graphics/Bitmap;
      //   2087: pop
      //   2088: goto -166 -> 1922
      //   2091: aload 8
      //   2093: getfield 147	com/tencent/mm/pluginsdk/model/app/g:field_appId	Ljava/lang/String;
      //   2096: iconst_1
      //   2097: aload_0
      //   2098: getfield 26	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a:BZU	Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;
      //   2101: invokestatic 171	com/tencent/mm/pluginsdk/ui/chat/AppGrid:h	(Lcom/tencent/mm/pluginsdk/ui/chat/AppGrid;)Landroid/content/Context;
      //   2104: invokestatic 527	com/tencent/mm/cd/a:getDensity	(Landroid/content/Context;)F
      //   2107: invokestatic 530	com/tencent/mm/pluginsdk/model/app/h:c	(Ljava/lang/String;IF)Landroid/graphics/Bitmap;
      //   2110: pop
      //   2111: goto -189 -> 1922
      //   2114: getstatic 262	com/tencent/mm/pluginsdk/model/app/g:BPG	Ljava/lang/String;
      //   2117: aload 8
      //   2119: getfield 147	com/tencent/mm/pluginsdk/model/app/g:field_appId	Ljava/lang/String;
      //   2122: invokevirtual 153	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   2125: ifeq +16 -> 2141
      //   2128: aload_3
      //   2129: getfield 157	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:hg	Landroid/widget/ImageView;
      //   2132: ldc_w 263
      //   2135: invokevirtual 163	android/widget/ImageView:setImageResource	(I)V
      //   2138: goto -193 -> 1945
      //   2141: getstatic 266	com/tencent/mm/pluginsdk/model/app/g:BPF	Ljava/lang/String;
      //   2144: aload 8
      //   2146: getfield 147	com/tencent/mm/pluginsdk/model/app/g:field_appId	Ljava/lang/String;
      //   2149: invokevirtual 153	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   2152: ifeq +16 -> 2168
      //   2155: aload_3
      //   2156: getfield 157	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:hg	Landroid/widget/ImageView;
      //   2159: ldc_w 267
      //   2162: invokevirtual 163	android/widget/ImageView:setImageResource	(I)V
      //   2165: goto -220 -> 1945
      //   2168: getstatic 270	com/tencent/mm/pluginsdk/model/app/g:BPH	Ljava/lang/String;
      //   2171: aload 8
      //   2173: getfield 147	com/tencent/mm/pluginsdk/model/app/g:field_appId	Ljava/lang/String;
      //   2176: invokevirtual 153	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   2179: ifeq +16 -> 2195
      //   2182: aload_3
      //   2183: getfield 157	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:hg	Landroid/widget/ImageView;
      //   2186: ldc_w 271
      //   2189: invokevirtual 163	android/widget/ImageView:setImageResource	(I)V
      //   2192: goto -247 -> 1945
      //   2195: aload_3
      //   2196: getfield 157	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:hg	Landroid/widget/ImageView;
      //   2199: ldc_w 272
      //   2202: invokevirtual 533	android/widget/ImageView:setBackgroundResource	(I)V
      //   2205: goto -260 -> 1945
      //   2208: aload_3
      //   2209: getfield 157	com/tencent/mm/pluginsdk/ui/chat/AppGrid$a$a:hg	Landroid/widget/ImageView;
      //   2212: ldc_w 534
      //   2215: invokevirtual 533	android/widget/ImageView:setBackgroundResource	(I)V
      //   2218: goto -273 -> 1945
      //   2221: astore 8
      //   2223: goto -1807 -> 416
      //   2226: astore 8
      //   2228: goto -1812 -> 416
      //   2231: astore 8
      //   2233: goto -1817 -> 416
      //   2236: astore 8
      //   2238: goto -1822 -> 416
      //   2241: astore 8
      //   2243: goto -1827 -> 416
      //   2246: astore 8
      //   2248: goto -1832 -> 416
      //   2251: astore 8
      //   2253: goto -1837 -> 416
      //   2256: astore 8
      //   2258: goto -1842 -> 416
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	2261	0	this	a
      //   0	2261	1	paramInt	int
      //   0	2261	2	paramView	View
      //   0	2261	3	paramViewGroup	android.view.ViewGroup
      //   288	1550	4	i	int
      //   304	15	5	j	int
      //   1173	30	6	bool1	boolean
      //   1200	21	7	bool2	boolean
      //   242	187	8	localObject1	Object
      //   1449	172	8	localException1	java.lang.Exception
      //   1630	542	8	localObject2	Object
      //   2221	1	8	localException2	java.lang.Exception
      //   2226	1	8	localException3	java.lang.Exception
      //   2231	1	8	localException4	java.lang.Exception
      //   2236	1	8	localException5	java.lang.Exception
      //   2241	1	8	localException6	java.lang.Exception
      //   2246	1	8	localException7	java.lang.Exception
      //   2251	1	8	localException8	java.lang.Exception
      //   2256	1	8	localException9	java.lang.Exception
      //   1657	141	9	localb	a.b
      //   1664	162	10	str	String
      // Exception table:
      //   from	to	target	type
      //   1437	1446	1449	java/lang/Exception
      //   538	573	2221	java/lang/Exception
      //   576	585	2221	java/lang/Exception
      //   618	653	2226	java/lang/Exception
      //   656	665	2226	java/lang/Exception
      //   803	839	2231	java/lang/Exception
      //   842	851	2231	java/lang/Exception
      //   884	920	2236	java/lang/Exception
      //   923	932	2236	java/lang/Exception
      //   998	1033	2241	java/lang/Exception
      //   1036	1045	2241	java/lang/Exception
      //   1078	1113	2246	java/lang/Exception
      //   1116	1125	2246	java/lang/Exception
      //   1148	1202	2251	java/lang/Exception
      //   1212	1220	2251	java/lang/Exception
      //   1225	1235	2251	java/lang/Exception
      //   1238	1248	2251	java/lang/Exception
      //   1251	1260	2251	java/lang/Exception
      //   1357	1392	2256	java/lang/Exception
      //   1395	1404	2256	java/lang/Exception
    }
    
    final class a
    {
      CdnImageView BZY;
      TextView BZZ;
      View Caa;
      View Cab;
      TextView hJR;
      ImageView hg;
      TextView sgt;
      
      a() {}
    }
  }
  
  public static abstract interface b
  {
    public abstract int UW(int paramInt);
    
    public abstract void UX(int paramInt);
    
    public abstract void a(int paramInt, g paramg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.AppGrid
 * JD-Core Version:    0.7.0.1
 */