package com.tencent.mm.plugin.test;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.v;
import android.text.ClipboardManager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;
import d.g.b.k;
import d.v;
import d.y;
import java.util.ArrayList;

@com.tencent.mm.ui.base.a(3)
@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/test/ExMainSettings;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/test/ExMainSettings$Info;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "setRecyclerView", "(Landroid/support/v7/widget/RecyclerView;)V", "getLayoutId", "", "initList", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "printCrash", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "d", "Companion", "Info", "SimpleAdapter", "ViewHolder", "app_release"})
public final class ExMainSettings
  extends MMActivity
{
  private static final String TAG = "ExMainSettings";
  public static final a yKN;
  private final ArrayList<b> dataList;
  private RecyclerView fPw;
  
  static
  {
    AppMethodBeat.i(163411);
    yKN = new a((byte)0);
    TAG = "ExMainSettings";
    AppMethodBeat.o(163411);
  }
  
  public ExMainSettings()
  {
    AppMethodBeat.i(163410);
    this.dataList = new ArrayList();
    AppMethodBeat.o(163410);
  }
  
  /* Error */
  private static StringBuilder dNq()
  {
    // Byte code:
    //   0: ldc 217
    //   2: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 219	java/util/Date
    //   8: dup
    //   9: invokestatic 225	com/tencent/mm/sdk/platformtools/bt:eGO	()J
    //   12: lconst_0
    //   13: lsub
    //   14: invokespecial 228	java/util/Date:<init>	(J)V
    //   17: astore_1
    //   18: new 230	java/text/SimpleDateFormat
    //   21: dup
    //   22: ldc 232
    //   24: invokestatic 238	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   27: invokespecial 241	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   30: astore_2
    //   31: new 243	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 244	java/lang/StringBuilder:<init>	()V
    //   38: invokestatic 249	com/tencent/mm/loader/j/b:aii	()Ljava/lang/String;
    //   41: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: ldc 255
    //   46: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload_2
    //   50: aload_1
    //   51: invokevirtual 259	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   54: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: ldc_w 261
    //   60: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: astore_2
    //   67: new 243	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 244	java/lang/StringBuilder:<init>	()V
    //   74: astore 4
    //   76: aload_2
    //   77: invokestatic 270	com/tencent/mm/vfs/i:eK	(Ljava/lang/String;)Z
    //   80: ifne +31 -> 111
    //   83: new 243	java/lang/StringBuilder
    //   86: dup
    //   87: new 243	java/lang/StringBuilder
    //   90: dup
    //   91: ldc_w 272
    //   94: invokespecial 275	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   97: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: invokespecial 275	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   103: astore_1
    //   104: ldc 217
    //   106: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   109: aload_1
    //   110: areturn
    //   111: aconst_null
    //   112: astore_1
    //   113: new 277	java/io/BufferedReader
    //   116: dup
    //   117: new 279	com/tencent/mm/vfs/k
    //   120: dup
    //   121: aload_2
    //   122: invokespecial 280	com/tencent/mm/vfs/k:<init>	(Ljava/lang/String;)V
    //   125: checkcast 282	java/io/Reader
    //   128: invokespecial 285	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   131: astore_2
    //   132: aload_2
    //   133: invokevirtual 288	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   136: invokestatic 291	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   139: ifeq +60 -> 199
    //   142: aload_2
    //   143: invokevirtual 294	java/io/BufferedReader:close	()V
    //   146: new 243	java/lang/StringBuilder
    //   149: dup
    //   150: new 243	java/lang/StringBuilder
    //   153: dup
    //   154: ldc_w 296
    //   157: invokespecial 275	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   160: invokevirtual 264	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokespecial 275	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   166: astore_1
    //   167: aload_2
    //   168: invokevirtual 294	java/io/BufferedReader:close	()V
    //   171: ldc 217
    //   173: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   176: aload_1
    //   177: areturn
    //   178: aload 4
    //   180: aload_1
    //   181: checkcast 298	[Ljava/lang/String;
    //   184: iconst_0
    //   185: aaload
    //   186: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: aload 4
    //   192: ldc_w 300
    //   195: invokevirtual 253	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: pop
    //   199: aload_2
    //   200: invokevirtual 288	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   203: astore_1
    //   204: aload_1
    //   205: ifnull +375 -> 580
    //   208: aload_1
    //   209: checkcast 123	java/lang/CharSequence
    //   212: astore_1
    //   213: new 302	d/n/k
    //   216: dup
    //   217: ldc_w 304
    //   220: invokespecial 305	d/n/k:<init>	(Ljava/lang/String;)V
    //   223: aload_1
    //   224: iconst_0
    //   225: invokevirtual 309	d/n/k:r	(Ljava/lang/CharSequence;I)Ljava/util/List;
    //   228: astore_1
    //   229: aload_1
    //   230: invokeinterface 315 1 0
    //   235: ifne +146 -> 381
    //   238: aload_1
    //   239: aload_1
    //   240: invokeinterface 319 1 0
    //   245: invokeinterface 323 2 0
    //   250: astore_3
    //   251: aload_3
    //   252: invokeinterface 328 1 0
    //   257: ifeq +124 -> 381
    //   260: aload_3
    //   261: invokeinterface 332 1 0
    //   266: checkcast 334	java/lang/String
    //   269: checkcast 123	java/lang/CharSequence
    //   272: invokeinterface 337 1 0
    //   277: ifne +99 -> 376
    //   280: iconst_1
    //   281: istore_0
    //   282: iload_0
    //   283: ifne -32 -> 251
    //   286: aload_1
    //   287: checkcast 339	java/lang/Iterable
    //   290: aload_3
    //   291: invokeinterface 342 1 0
    //   296: iconst_1
    //   297: iadd
    //   298: invokestatic 347	d/a/j:b	(Ljava/lang/Iterable;I)Ljava/util/List;
    //   301: astore_1
    //   302: aload_1
    //   303: checkcast 349	java/util/Collection
    //   306: iconst_0
    //   307: anewarray 334	java/lang/String
    //   310: invokeinterface 353 2 0
    //   315: astore_1
    //   316: aload_1
    //   317: ifnonnull +74 -> 391
    //   320: new 355	d/v
    //   323: dup
    //   324: ldc_w 357
    //   327: invokespecial 358	d/v:<init>	(Ljava/lang/String;)V
    //   330: astore_1
    //   331: ldc 217
    //   333: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   336: aload_1
    //   337: athrow
    //   338: astore_3
    //   339: aload_2
    //   340: astore_1
    //   341: aload_3
    //   342: astore_2
    //   343: getstatic 92	com/tencent/mm/plugin/test/ExMainSettings:TAG	Ljava/lang/String;
    //   346: aload_2
    //   347: checkcast 360	java/lang/Throwable
    //   350: ldc_w 361
    //   353: iconst_0
    //   354: anewarray 363	java/lang/Object
    //   357: invokestatic 369	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   360: aload_1
    //   361: ifnull +7 -> 368
    //   364: aload_1
    //   365: invokevirtual 294	java/io/BufferedReader:close	()V
    //   368: ldc 217
    //   370: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   373: aload 4
    //   375: areturn
    //   376: iconst_0
    //   377: istore_0
    //   378: goto -96 -> 282
    //   381: getstatic 375	d/a/v:Jgl	Ld/a/v;
    //   384: checkcast 311	java/util/List
    //   387: astore_1
    //   388: goto -86 -> 302
    //   391: aload_1
    //   392: checkcast 298	[Ljava/lang/String;
    //   395: iconst_1
    //   396: aaload
    //   397: iconst_0
    //   398: invokestatic 381	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   401: astore_1
    //   402: aload_1
    //   403: ldc_w 383
    //   406: invokestatic 166	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   409: new 334	java/lang/String
    //   412: dup
    //   413: aload_1
    //   414: getstatic 389	d/n/d:UTF_8	Ljava/nio/charset/Charset;
    //   417: invokespecial 392	java/lang/String:<init>	([BLjava/nio/charset/Charset;)V
    //   420: checkcast 123	java/lang/CharSequence
    //   423: astore_1
    //   424: new 302	d/n/k
    //   427: dup
    //   428: ldc_w 394
    //   431: invokespecial 305	d/n/k:<init>	(Ljava/lang/String;)V
    //   434: aload_1
    //   435: iconst_0
    //   436: invokevirtual 309	d/n/k:r	(Ljava/lang/CharSequence;I)Ljava/util/List;
    //   439: astore_1
    //   440: aload_1
    //   441: invokeinterface 315 1 0
    //   446: ifne +124 -> 570
    //   449: aload_1
    //   450: aload_1
    //   451: invokeinterface 319 1 0
    //   456: invokeinterface 323 2 0
    //   461: astore_3
    //   462: aload_3
    //   463: invokeinterface 328 1 0
    //   468: ifeq +102 -> 570
    //   471: aload_3
    //   472: invokeinterface 332 1 0
    //   477: checkcast 334	java/lang/String
    //   480: checkcast 123	java/lang/CharSequence
    //   483: invokeinterface 337 1 0
    //   488: ifne +77 -> 565
    //   491: iconst_1
    //   492: istore_0
    //   493: iload_0
    //   494: ifne -32 -> 462
    //   497: aload_1
    //   498: checkcast 339	java/lang/Iterable
    //   501: aload_3
    //   502: invokeinterface 342 1 0
    //   507: iconst_1
    //   508: iadd
    //   509: invokestatic 347	d/a/j:b	(Ljava/lang/Iterable;I)Ljava/util/List;
    //   512: astore_1
    //   513: aload_1
    //   514: checkcast 349	java/util/Collection
    //   517: iconst_0
    //   518: anewarray 334	java/lang/String
    //   521: invokeinterface 353 2 0
    //   526: astore_1
    //   527: aload_1
    //   528: ifnonnull -350 -> 178
    //   531: new 355	d/v
    //   534: dup
    //   535: ldc_w 357
    //   538: invokespecial 358	d/v:<init>	(Ljava/lang/String;)V
    //   541: astore_1
    //   542: ldc 217
    //   544: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   547: aload_1
    //   548: athrow
    //   549: astore_1
    //   550: aload_2
    //   551: ifnull +7 -> 558
    //   554: aload_2
    //   555: invokevirtual 294	java/io/BufferedReader:close	()V
    //   558: ldc 217
    //   560: invokestatic 95	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   563: aload_1
    //   564: athrow
    //   565: iconst_0
    //   566: istore_0
    //   567: goto -74 -> 493
    //   570: getstatic 375	d/a/v:Jgl	Ld/a/v;
    //   573: checkcast 311	java/util/List
    //   576: astore_1
    //   577: goto -64 -> 513
    //   580: aload_2
    //   581: invokevirtual 294	java/io/BufferedReader:close	()V
    //   584: goto -216 -> 368
    //   587: astore_1
    //   588: goto -220 -> 368
    //   591: astore_2
    //   592: goto -421 -> 171
    //   595: astore_1
    //   596: goto -228 -> 368
    //   599: astore_2
    //   600: goto -42 -> 558
    //   603: astore_1
    //   604: aconst_null
    //   605: astore_2
    //   606: goto -56 -> 550
    //   609: astore_3
    //   610: aload_1
    //   611: astore_2
    //   612: aload_3
    //   613: astore_1
    //   614: goto -64 -> 550
    //   617: astore_2
    //   618: goto -275 -> 343
    // Local variable table:
    //   start	length	slot	name	signature
    //   281	286	0	i	int
    //   17	531	1	localObject1	Object
    //   549	15	1	localObject2	Object
    //   576	1	1	localList	java.util.List
    //   587	1	1	localException1	java.lang.Exception
    //   595	1	1	localException2	java.lang.Exception
    //   603	8	1	localObject3	Object
    //   613	1	1	localObject4	Object
    //   30	551	2	localObject5	Object
    //   591	1	2	localException3	java.lang.Exception
    //   599	1	2	localException4	java.lang.Exception
    //   605	7	2	localObject6	Object
    //   617	1	2	localException5	java.lang.Exception
    //   250	41	3	localListIterator1	java.util.ListIterator
    //   338	4	3	localException6	java.lang.Exception
    //   461	41	3	localListIterator2	java.util.ListIterator
    //   609	4	3	localObject7	Object
    //   74	300	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   132	167	338	java/lang/Exception
    //   178	199	338	java/lang/Exception
    //   199	204	338	java/lang/Exception
    //   208	251	338	java/lang/Exception
    //   251	280	338	java/lang/Exception
    //   286	302	338	java/lang/Exception
    //   302	316	338	java/lang/Exception
    //   320	338	338	java/lang/Exception
    //   381	388	338	java/lang/Exception
    //   391	462	338	java/lang/Exception
    //   462	491	338	java/lang/Exception
    //   497	513	338	java/lang/Exception
    //   513	527	338	java/lang/Exception
    //   531	549	338	java/lang/Exception
    //   570	577	338	java/lang/Exception
    //   132	167	549	finally
    //   178	199	549	finally
    //   199	204	549	finally
    //   208	251	549	finally
    //   251	280	549	finally
    //   286	302	549	finally
    //   302	316	549	finally
    //   320	338	549	finally
    //   381	388	549	finally
    //   391	462	549	finally
    //   462	491	549	finally
    //   497	513	549	finally
    //   513	527	549	finally
    //   531	549	549	finally
    //   570	577	549	finally
    //   580	584	587	java/lang/Exception
    //   167	171	591	java/lang/Exception
    //   364	368	595	java/lang/Exception
    //   554	558	599	java/lang/Exception
    //   113	132	603	finally
    //   343	360	609	finally
    //   113	132	617	java/lang/Exception
  }
  
  public final int getLayoutId()
  {
    return 2131495018;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(163409);
    super.onCreate(paramBundle);
    setMMTitle("");
    setBackBtn((MenuItem.OnMenuItemClickListener)new i(this));
    this.dataList.add(new b("PrintCrash", null, (View.OnClickListener)new e(this)));
    this.dataList.add(new b("朋友圈", 2131690250, (View.OnClickListener)new f()));
    this.dataList.add(new b("视频动态", 2131689897, (View.OnClickListener)new g(this)));
    this.dataList.add(new b("Live", 2131691535, (View.OnClickListener)new h(this)));
    paramBundle = com.tencent.mm.cd.a.l((Context)getContext(), 2131690572);
    Object localObject = getContext();
    k.g(localObject, "context");
    paramBundle.setColorFilter((ColorFilter)new PorterDuffColorFilter(((AppCompatActivity)localObject).getResources().getColor(2131099778), PorterDuff.Mode.SRC_ATOP));
    this.dataList.add(new b("Finder", paramBundle, (View.OnClickListener)new ExMainSettings.m(this)));
    this.fPw = ((RecyclerView)findViewById(2131303744));
    paramBundle = new LinearLayoutManager();
    localObject = this.fPw;
    if (localObject != null) {
      ((RecyclerView)localObject).setLayoutManager((RecyclerView.i)paramBundle);
    }
    paramBundle = new c(this.dataList);
    localObject = this.fPw;
    if (localObject != null) {
      ((RecyclerView)localObject).setAdapter((RecyclerView.a)paramBundle);
    }
    localObject = this.fPw;
    if (localObject != null) {
      ((RecyclerView)localObject).setItemViewCacheSize(0);
    }
    c.a(0L, (d.g.a.a)new j(paramBundle));
    AppMethodBeat.o(163409);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/test/ExMainSettings$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "app_release"})
  public static final class a {}
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/test/ExMainSettings$Info;", "", "name", "", "resId", "", "onClickListener", "Landroid/view/View$OnClickListener;", "(Ljava/lang/String;ILandroid/view/View$OnClickListener;)V", "Landroid/graphics/drawable/Drawable;", "(Ljava/lang/String;Landroid/graphics/drawable/Drawable;Landroid/view/View$OnClickListener;)V", "drawable", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "setDrawable", "(Landroid/graphics/drawable/Drawable;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getOnClickListener", "()Landroid/view/View$OnClickListener;", "setOnClickListener", "(Landroid/view/View$OnClickListener;)V", "getResId", "()Ljava/lang/Integer;", "setResId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "app_release"})
  public static final class b
  {
    Drawable drawable;
    View.OnClickListener hs;
    String name;
    Integer yKO;
    
    public b(String paramString, int paramInt, View.OnClickListener paramOnClickListener)
    {
      AppMethodBeat.i(163394);
      this.name = paramString;
      this.yKO = Integer.valueOf(paramInt);
      this.hs = paramOnClickListener;
      AppMethodBeat.o(163394);
    }
    
    public b(String paramString, Drawable paramDrawable, View.OnClickListener paramOnClickListener)
    {
      AppMethodBeat.i(163395);
      this.name = paramString;
      this.drawable = paramDrawable;
      this.hs = paramOnClickListener;
      AppMethodBeat.o(163395);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/test/ExMainSettings$SimpleAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "list", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/test/ExMainSettings$Info;", "(Ljava/util/ArrayList;)V", "getList", "()Ljava/util/ArrayList;", "getItemCount", "", "onBindViewHolder", "", "_holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "app_release"})
  public static final class c
    extends RecyclerView.a<RecyclerView.v>
  {
    private final ArrayList<ExMainSettings.b> cTm;
    
    public c(ArrayList<ExMainSettings.b> paramArrayList)
    {
      AppMethodBeat.i(163399);
      this.cTm = paramArrayList;
      AppMethodBeat.o(163399);
    }
    
    public final RecyclerView.v a(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(163396);
      k.h(paramViewGroup, "parent");
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131495394, paramViewGroup, false);
      k.g(paramViewGroup, "LayoutInflater.from(pare…yout_item, parent, false)");
      paramViewGroup = (RecyclerView.v)new ExMainSettings.d(paramViewGroup);
      AppMethodBeat.o(163396);
      return paramViewGroup;
    }
    
    public final void a(RecyclerView.v paramv, int paramInt)
    {
      Object localObject1 = null;
      AppMethodBeat.i(163398);
      k.h(paramv, "_holder");
      Object localObject2 = (ExMainSettings.d)paramv;
      paramv = this.cTm.get(paramInt);
      k.g(paramv, "list[position]");
      ExMainSettings.b localb = (ExMainSettings.b)paramv;
      TextView localTextView = ((ExMainSettings.d)localObject2).ftj;
      if (localb != null) {}
      for (paramv = localb.name;; paramv = null)
      {
        localTextView.setText((CharSequence)paramv);
        if (localb != null)
        {
          paramv = localb.yKO;
          if (paramv != null)
          {
            paramInt = ((Number)paramv).intValue();
            ((ExMainSettings.d)localObject2).fxT.setImageResource(paramInt);
          }
        }
        if (localb != null)
        {
          paramv = localb.drawable;
          if (paramv != null) {
            ((ExMainSettings.d)localObject2).fxT.setImageDrawable(paramv);
          }
        }
        localObject2 = ((ExMainSettings.d)localObject2).pf;
        paramv = localObject1;
        if (localb != null) {
          paramv = localb.hs;
        }
        ((View)localObject2).setOnClickListener(paramv);
        AppMethodBeat.o(163398);
        return;
      }
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(163397);
      int i = this.cTm.size();
      AppMethodBeat.o(163397);
      return i;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/test/ExMainSettings$ViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "iconIv", "Landroid/widget/ImageView;", "getIconIv", "()Landroid/widget/ImageView;", "setIconIv", "(Landroid/widget/ImageView;)V", "layout", "getLayout", "()Landroid/view/View;", "setLayout", "nameTv", "Landroid/widget/TextView;", "getNameTv", "()Landroid/widget/TextView;", "setNameTv", "(Landroid/widget/TextView;)V", "app_release"})
  public static final class d
    extends RecyclerView.v
  {
    TextView ftj;
    ImageView fxT;
    View pf;
    
    public d(View paramView)
    {
      super();
      AppMethodBeat.i(163400);
      View localView = paramView.findViewById(2131306428);
      k.g(localView, "itemView.findViewById(R.id.view_layout)");
      this.pf = localView;
      localView = paramView.findViewById(2131297628);
      k.g(localView, "itemView.findViewById(R.id.busi_icon)");
      this.fxT = ((ImageView)localView);
      paramView = paramView.findViewById(2131302666);
      k.g(paramView, "itemView.findViewById(R.id.name_tv)");
      this.ftj = ((TextView)paramView);
      AppMethodBeat.o(163400);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/test/ExMainSettings$initList$1", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "app_release"})
  public static final class e
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(163401);
      ExMainSettings.a(this.yKP);
      AppMethodBeat.o(163401);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/test/ExMainSettings$initList$2", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "app_release"})
  public static final class f
    implements View.OnClickListener
  {
    public final void onClick(View paramView) {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/test/ExMainSettings$initList$3", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "app_release"})
  public static final class g
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(163402);
      Object localObject = new Intent((Context)this.yKP, Class.forName("com.tencent.mm.plugin.story.ui.StorySettingsUI"));
      paramView = this.yKP;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/test/ExMainSettings$initList$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/test/ExMainSettings$initList$3", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(163402);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/test/ExMainSettings$initList$4", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "app_release"})
  public static final class h
    implements View.OnClickListener
  {
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(163403);
      Object localObject = new Intent((Context)this.yKP, Class.forName("com.tencent.mm.live.ui.LiveUIG"));
      paramView = this.yKP;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/test/ExMainSettings$initList$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/plugin/test/ExMainSettings$initList$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(163403);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class i
    implements MenuItem.OnMenuItemClickListener
  {
    i(ExMainSettings paramExMainSettings) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(163404);
      this.yKP.finish();
      AppMethodBeat.o(163404);
      return false;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class j
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    j(ExMainSettings.c paramc)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/test/ExMainSettings$printCrash$onClickCancel$1", "Landroid/content/DialogInterface$OnClickListener;", "onClick", "", "dialog", "Landroid/content/DialogInterface;", "which", "", "app_release"})
  public static final class k
    implements DialogInterface.OnClickListener
  {
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(163406);
      k.h(paramDialogInterface, "dialog");
      paramDialogInterface = ExMainSettings.yKN;
      ad.i(ExMainSettings.access$getTAG$cp(), "onClickCancel");
      AppMethodBeat.o(163406);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/test/ExMainSettings$printCrash$onClickOk$1", "Landroid/content/DialogInterface$OnClickListener;", "onClick", "", "dialog", "Landroid/content/DialogInterface;", "which", "", "app_release"})
  public static final class l
    implements DialogInterface.OnClickListener
  {
    l(StringBuilder paramStringBuilder) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(163407);
      k.h(paramDialogInterface, "dialog");
      paramDialogInterface = ExMainSettings.yKN;
      ad.i(ExMainSettings.access$getTAG$cp(), "onClick1");
      paramDialogInterface = this.yKP.getContext().getSystemService("clipboard");
      if (paramDialogInterface == null)
      {
        paramDialogInterface = new v("null cannot be cast to non-null type android.text.ClipboardManager");
        AppMethodBeat.o(163407);
        throw paramDialogInterface;
      }
      ((ClipboardManager)paramDialogInterface).setText((CharSequence)this.yKR);
      Toast.makeText((Context)this.yKP.getContext(), (CharSequence)"copy done", 0).show();
      AppMethodBeat.o(163407);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.test.ExMainSettings
 * JD-Core Version:    0.7.0.1
 */