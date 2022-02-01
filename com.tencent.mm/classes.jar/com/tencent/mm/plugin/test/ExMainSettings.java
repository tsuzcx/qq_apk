package com.tencent.mm.plugin.test;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
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
import android.support.v7.widget.RecyclerView.w;
import android.text.ClipboardManager;
import android.view.LayoutInflater;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.MMActivity;
import d.g.b.k;
import d.l;
import d.v;
import java.util.ArrayList;

@com.tencent.mm.ui.base.a(3)
@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/test/ExMainSettings;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/test/ExMainSettings$Info;", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRecyclerView", "()Landroid/support/v7/widget/RecyclerView;", "setRecyclerView", "(Landroid/support/v7/widget/RecyclerView;)V", "getLayoutId", "", "initList", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "printCrash", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "d", "Companion", "Info", "SimpleAdapter", "ViewHolder", "app_release"})
public final class ExMainSettings
  extends MMActivity
{
  private static final String TAG = "ExMainSettings";
  public static final a zYa;
  private final ArrayList<b> dataList;
  private RecyclerView fTr;
  
  static
  {
    AppMethodBeat.i(163411);
    zYa = new a((byte)0);
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
  private static StringBuilder ebQ()
  {
    // Byte code:
    //   0: ldc 207
    //   2: invokestatic 74	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 209	java/util/Date
    //   8: dup
    //   9: invokestatic 215	com/tencent/mm/sdk/platformtools/bs:eWj	()J
    //   12: lconst_0
    //   13: lsub
    //   14: invokespecial 218	java/util/Date:<init>	(J)V
    //   17: astore_1
    //   18: new 220	java/text/SimpleDateFormat
    //   21: dup
    //   22: ldc 222
    //   24: invokestatic 228	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   27: invokespecial 231	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   30: astore_2
    //   31: new 233	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 234	java/lang/StringBuilder:<init>	()V
    //   38: invokestatic 239	com/tencent/mm/loader/j/b:api	()Ljava/lang/String;
    //   41: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: ldc 245
    //   46: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload_2
    //   50: aload_1
    //   51: invokevirtual 249	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   54: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: ldc 251
    //   59: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 254	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: astore_2
    //   66: new 233	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 234	java/lang/StringBuilder:<init>	()V
    //   73: astore 4
    //   75: aload_2
    //   76: invokestatic 260	com/tencent/mm/vfs/i:eA	(Ljava/lang/String;)Z
    //   79: ifne +31 -> 110
    //   82: new 233	java/lang/StringBuilder
    //   85: dup
    //   86: new 233	java/lang/StringBuilder
    //   89: dup
    //   90: ldc_w 262
    //   93: invokespecial 265	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   96: invokevirtual 254	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: invokespecial 265	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   102: astore_1
    //   103: ldc 207
    //   105: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   108: aload_1
    //   109: areturn
    //   110: aconst_null
    //   111: astore_1
    //   112: new 267	java/io/BufferedReader
    //   115: dup
    //   116: new 269	com/tencent/mm/vfs/k
    //   119: dup
    //   120: aload_2
    //   121: invokespecial 270	com/tencent/mm/vfs/k:<init>	(Ljava/lang/String;)V
    //   124: checkcast 272	java/io/Reader
    //   127: invokespecial 275	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   130: astore_2
    //   131: aload_2
    //   132: invokevirtual 278	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   135: invokestatic 281	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   138: ifeq +60 -> 198
    //   141: aload_2
    //   142: invokevirtual 284	java/io/BufferedReader:close	()V
    //   145: new 233	java/lang/StringBuilder
    //   148: dup
    //   149: new 233	java/lang/StringBuilder
    //   152: dup
    //   153: ldc_w 286
    //   156: invokespecial 265	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   159: invokevirtual 254	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokespecial 265	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   165: astore_1
    //   166: aload_2
    //   167: invokevirtual 284	java/io/BufferedReader:close	()V
    //   170: ldc 207
    //   172: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   175: aload_1
    //   176: areturn
    //   177: aload 4
    //   179: aload_1
    //   180: checkcast 288	[Ljava/lang/String;
    //   183: iconst_0
    //   184: aaload
    //   185: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: aload 4
    //   191: ldc_w 290
    //   194: invokevirtual 243	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: aload_2
    //   199: invokevirtual 278	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   202: astore_1
    //   203: aload_1
    //   204: ifnull +375 -> 579
    //   207: aload_1
    //   208: checkcast 113	java/lang/CharSequence
    //   211: astore_1
    //   212: new 292	d/n/k
    //   215: dup
    //   216: ldc_w 294
    //   219: invokespecial 295	d/n/k:<init>	(Ljava/lang/String;)V
    //   222: aload_1
    //   223: iconst_0
    //   224: invokevirtual 299	d/n/k:q	(Ljava/lang/CharSequence;I)Ljava/util/List;
    //   227: astore_1
    //   228: aload_1
    //   229: invokeinterface 305 1 0
    //   234: ifne +146 -> 380
    //   237: aload_1
    //   238: aload_1
    //   239: invokeinterface 309 1 0
    //   244: invokeinterface 313 2 0
    //   249: astore_3
    //   250: aload_3
    //   251: invokeinterface 318 1 0
    //   256: ifeq +124 -> 380
    //   259: aload_3
    //   260: invokeinterface 322 1 0
    //   265: checkcast 324	java/lang/String
    //   268: checkcast 113	java/lang/CharSequence
    //   271: invokeinterface 327 1 0
    //   276: ifne +99 -> 375
    //   279: iconst_1
    //   280: istore_0
    //   281: iload_0
    //   282: ifne -32 -> 250
    //   285: aload_1
    //   286: checkcast 329	java/lang/Iterable
    //   289: aload_3
    //   290: invokeinterface 332 1 0
    //   295: iconst_1
    //   296: iadd
    //   297: invokestatic 337	d/a/j:b	(Ljava/lang/Iterable;I)Ljava/util/List;
    //   300: astore_1
    //   301: aload_1
    //   302: checkcast 339	java/util/Collection
    //   305: iconst_0
    //   306: anewarray 324	java/lang/String
    //   309: invokeinterface 343 2 0
    //   314: astore_1
    //   315: aload_1
    //   316: ifnonnull +74 -> 390
    //   319: new 345	d/v
    //   322: dup
    //   323: ldc_w 347
    //   326: invokespecial 348	d/v:<init>	(Ljava/lang/String;)V
    //   329: astore_1
    //   330: ldc 207
    //   332: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   335: aload_1
    //   336: athrow
    //   337: astore_3
    //   338: aload_2
    //   339: astore_1
    //   340: aload_3
    //   341: astore_2
    //   342: getstatic 82	com/tencent/mm/plugin/test/ExMainSettings:TAG	Ljava/lang/String;
    //   345: aload_2
    //   346: checkcast 350	java/lang/Throwable
    //   349: ldc_w 351
    //   352: iconst_0
    //   353: anewarray 353	java/lang/Object
    //   356: invokestatic 359	com/tencent/mm/sdk/platformtools/ac:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   359: aload_1
    //   360: ifnull +7 -> 367
    //   363: aload_1
    //   364: invokevirtual 284	java/io/BufferedReader:close	()V
    //   367: ldc 207
    //   369: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   372: aload 4
    //   374: areturn
    //   375: iconst_0
    //   376: istore_0
    //   377: goto -96 -> 281
    //   380: getstatic 365	d/a/v:KTF	Ld/a/v;
    //   383: checkcast 301	java/util/List
    //   386: astore_1
    //   387: goto -86 -> 301
    //   390: aload_1
    //   391: checkcast 288	[Ljava/lang/String;
    //   394: iconst_1
    //   395: aaload
    //   396: iconst_0
    //   397: invokestatic 371	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   400: astore_1
    //   401: aload_1
    //   402: ldc_w 373
    //   405: invokestatic 156	d/g/b/k:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   408: new 324	java/lang/String
    //   411: dup
    //   412: aload_1
    //   413: getstatic 379	d/n/d:UTF_8	Ljava/nio/charset/Charset;
    //   416: invokespecial 382	java/lang/String:<init>	([BLjava/nio/charset/Charset;)V
    //   419: checkcast 113	java/lang/CharSequence
    //   422: astore_1
    //   423: new 292	d/n/k
    //   426: dup
    //   427: ldc_w 384
    //   430: invokespecial 295	d/n/k:<init>	(Ljava/lang/String;)V
    //   433: aload_1
    //   434: iconst_0
    //   435: invokevirtual 299	d/n/k:q	(Ljava/lang/CharSequence;I)Ljava/util/List;
    //   438: astore_1
    //   439: aload_1
    //   440: invokeinterface 305 1 0
    //   445: ifne +124 -> 569
    //   448: aload_1
    //   449: aload_1
    //   450: invokeinterface 309 1 0
    //   455: invokeinterface 313 2 0
    //   460: astore_3
    //   461: aload_3
    //   462: invokeinterface 318 1 0
    //   467: ifeq +102 -> 569
    //   470: aload_3
    //   471: invokeinterface 322 1 0
    //   476: checkcast 324	java/lang/String
    //   479: checkcast 113	java/lang/CharSequence
    //   482: invokeinterface 327 1 0
    //   487: ifne +77 -> 564
    //   490: iconst_1
    //   491: istore_0
    //   492: iload_0
    //   493: ifne -32 -> 461
    //   496: aload_1
    //   497: checkcast 329	java/lang/Iterable
    //   500: aload_3
    //   501: invokeinterface 332 1 0
    //   506: iconst_1
    //   507: iadd
    //   508: invokestatic 337	d/a/j:b	(Ljava/lang/Iterable;I)Ljava/util/List;
    //   511: astore_1
    //   512: aload_1
    //   513: checkcast 339	java/util/Collection
    //   516: iconst_0
    //   517: anewarray 324	java/lang/String
    //   520: invokeinterface 343 2 0
    //   525: astore_1
    //   526: aload_1
    //   527: ifnonnull -350 -> 177
    //   530: new 345	d/v
    //   533: dup
    //   534: ldc_w 347
    //   537: invokespecial 348	d/v:<init>	(Ljava/lang/String;)V
    //   540: astore_1
    //   541: ldc 207
    //   543: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   546: aload_1
    //   547: athrow
    //   548: astore_1
    //   549: aload_2
    //   550: ifnull +7 -> 557
    //   553: aload_2
    //   554: invokevirtual 284	java/io/BufferedReader:close	()V
    //   557: ldc 207
    //   559: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   562: aload_1
    //   563: athrow
    //   564: iconst_0
    //   565: istore_0
    //   566: goto -74 -> 492
    //   569: getstatic 365	d/a/v:KTF	Ld/a/v;
    //   572: checkcast 301	java/util/List
    //   575: astore_1
    //   576: goto -64 -> 512
    //   579: aload_2
    //   580: invokevirtual 284	java/io/BufferedReader:close	()V
    //   583: goto -216 -> 367
    //   586: astore_1
    //   587: goto -220 -> 367
    //   590: astore_2
    //   591: goto -421 -> 170
    //   594: astore_1
    //   595: goto -228 -> 367
    //   598: astore_2
    //   599: goto -42 -> 557
    //   602: astore_1
    //   603: aconst_null
    //   604: astore_2
    //   605: goto -56 -> 549
    //   608: astore_3
    //   609: aload_1
    //   610: astore_2
    //   611: aload_3
    //   612: astore_1
    //   613: goto -64 -> 549
    //   616: astore_2
    //   617: goto -275 -> 342
    // Local variable table:
    //   start	length	slot	name	signature
    //   280	286	0	i	int
    //   17	530	1	localObject1	Object
    //   548	15	1	localObject2	Object
    //   575	1	1	localList	java.util.List
    //   586	1	1	localException1	java.lang.Exception
    //   594	1	1	localException2	java.lang.Exception
    //   602	8	1	localObject3	Object
    //   612	1	1	localObject4	Object
    //   30	550	2	localObject5	Object
    //   590	1	2	localException3	java.lang.Exception
    //   598	1	2	localException4	java.lang.Exception
    //   604	7	2	localObject6	Object
    //   616	1	2	localException5	java.lang.Exception
    //   249	41	3	localListIterator1	java.util.ListIterator
    //   337	4	3	localException6	java.lang.Exception
    //   460	41	3	localListIterator2	java.util.ListIterator
    //   608	4	3	localObject7	Object
    //   73	300	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   131	166	337	java/lang/Exception
    //   177	198	337	java/lang/Exception
    //   198	203	337	java/lang/Exception
    //   207	250	337	java/lang/Exception
    //   250	279	337	java/lang/Exception
    //   285	301	337	java/lang/Exception
    //   301	315	337	java/lang/Exception
    //   319	337	337	java/lang/Exception
    //   380	387	337	java/lang/Exception
    //   390	461	337	java/lang/Exception
    //   461	490	337	java/lang/Exception
    //   496	512	337	java/lang/Exception
    //   512	526	337	java/lang/Exception
    //   530	548	337	java/lang/Exception
    //   569	576	337	java/lang/Exception
    //   131	166	548	finally
    //   177	198	548	finally
    //   198	203	548	finally
    //   207	250	548	finally
    //   250	279	548	finally
    //   285	301	548	finally
    //   301	315	548	finally
    //   319	337	548	finally
    //   380	387	548	finally
    //   390	461	548	finally
    //   461	490	548	finally
    //   496	512	548	finally
    //   512	526	548	finally
    //   530	548	548	finally
    //   569	576	548	finally
    //   579	583	586	java/lang/Exception
    //   166	170	590	java/lang/Exception
    //   363	367	594	java/lang/Exception
    //   553	557	598	java/lang/Exception
    //   112	131	602	finally
    //   342	359	608	finally
    //   112	131	616	java/lang/Exception
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
    setBackBtn((MenuItem.OnMenuItemClickListener)new ExMainSettings.j(this));
    this.dataList.add(new b("PrintCrash", null, (View.OnClickListener)new ExMainSettings.e(this)));
    this.dataList.add(new b("朋友圈", 2131690250, (View.OnClickListener)new f()));
    this.dataList.add(new b("视频动态", 2131689897, (View.OnClickListener)new ExMainSettings.g(this)));
    this.dataList.add(new b("Live", 2131691550, (View.OnClickListener)new ExMainSettings.h(this)));
    paramBundle = com.tencent.mm.cc.a.l((Context)getContext(), 2131690572);
    Object localObject = getContext();
    k.g(localObject, "context");
    paramBundle.setColorFilter((ColorFilter)new PorterDuffColorFilter(((AppCompatActivity)localObject).getResources().getColor(2131099778), PorterDuff.Mode.SRC_ATOP));
    this.dataList.add(new b("Finder", paramBundle, (View.OnClickListener)new ExMainSettings.i(this)));
    this.fTr = ((RecyclerView)findViewById(2131303744));
    paramBundle = new LinearLayoutManager();
    localObject = this.fTr;
    if (localObject != null) {
      ((RecyclerView)localObject).setLayoutManager((RecyclerView.i)paramBundle);
    }
    paramBundle = new c(this.dataList);
    localObject = this.fTr;
    if (localObject != null) {
      ((RecyclerView)localObject).setAdapter((RecyclerView.a)paramBundle);
    }
    localObject = this.fTr;
    if (localObject != null) {
      ((RecyclerView)localObject).setItemViewCacheSize(0);
    }
    c.a(0L, (d.g.a.a)new ExMainSettings.k(paramBundle));
    AppMethodBeat.o(163409);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/test/ExMainSettings$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "app_release"})
  public static final class a {}
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/test/ExMainSettings$Info;", "", "name", "", "resId", "", "onClickListener", "Landroid/view/View$OnClickListener;", "(Ljava/lang/String;ILandroid/view/View$OnClickListener;)V", "Landroid/graphics/drawable/Drawable;", "(Ljava/lang/String;Landroid/graphics/drawable/Drawable;Landroid/view/View$OnClickListener;)V", "drawable", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "setDrawable", "(Landroid/graphics/drawable/Drawable;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getOnClickListener", "()Landroid/view/View$OnClickListener;", "setOnClickListener", "(Landroid/view/View$OnClickListener;)V", "getResId", "()Ljava/lang/Integer;", "setResId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "app_release"})
  public static final class b
  {
    Drawable drawable;
    View.OnClickListener iu;
    String name;
    Integer zYb;
    
    public b(String paramString, int paramInt, View.OnClickListener paramOnClickListener)
    {
      AppMethodBeat.i(163394);
      this.name = paramString;
      this.zYb = Integer.valueOf(paramInt);
      this.iu = paramOnClickListener;
      AppMethodBeat.o(163394);
    }
    
    public b(String paramString, Drawable paramDrawable, View.OnClickListener paramOnClickListener)
    {
      AppMethodBeat.i(163395);
      this.name = paramString;
      this.drawable = paramDrawable;
      this.iu = paramOnClickListener;
      AppMethodBeat.o(163395);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/test/ExMainSettings$SimpleAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "list", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/test/ExMainSettings$Info;", "(Ljava/util/ArrayList;)V", "getList", "()Ljava/util/ArrayList;", "getItemCount", "", "onBindViewHolder", "", "_holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "app_release"})
  public static final class c
    extends RecyclerView.a<RecyclerView.w>
  {
    private final ArrayList<ExMainSettings.b> cQJ;
    
    public c(ArrayList<ExMainSettings.b> paramArrayList)
    {
      AppMethodBeat.i(163399);
      this.cQJ = paramArrayList;
      AppMethodBeat.o(163399);
    }
    
    public final RecyclerView.w a(ViewGroup paramViewGroup, int paramInt)
    {
      AppMethodBeat.i(163396);
      k.h(paramViewGroup, "parent");
      paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131495394, paramViewGroup, false);
      k.g(paramViewGroup, "LayoutInflater.from(pare…yout_item, parent, false)");
      paramViewGroup = (RecyclerView.w)new ExMainSettings.d(paramViewGroup);
      AppMethodBeat.o(163396);
      return paramViewGroup;
    }
    
    public final void a(RecyclerView.w paramw, int paramInt)
    {
      Object localObject1 = null;
      AppMethodBeat.i(163398);
      k.h(paramw, "_holder");
      Object localObject2 = (ExMainSettings.d)paramw;
      paramw = this.cQJ.get(paramInt);
      k.g(paramw, "list[position]");
      ExMainSettings.b localb = (ExMainSettings.b)paramw;
      TextView localTextView = ((ExMainSettings.d)localObject2).fwQ;
      if (localb != null) {}
      for (paramw = localb.name;; paramw = null)
      {
        localTextView.setText((CharSequence)paramw);
        if (localb != null)
        {
          paramw = localb.zYb;
          if (paramw != null)
          {
            paramInt = ((Number)paramw).intValue();
            ((ExMainSettings.d)localObject2).fBA.setImageResource(paramInt);
          }
        }
        if (localb != null)
        {
          paramw = localb.drawable;
          if (paramw != null) {
            ((ExMainSettings.d)localObject2).fBA.setImageDrawable(paramw);
          }
        }
        localObject2 = ((ExMainSettings.d)localObject2).qe;
        paramw = localObject1;
        if (localb != null) {
          paramw = localb.iu;
        }
        ((View)localObject2).setOnClickListener(paramw);
        AppMethodBeat.o(163398);
        return;
      }
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(163397);
      int i = this.cQJ.size();
      AppMethodBeat.o(163397);
      return i;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/test/ExMainSettings$ViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "iconIv", "Landroid/widget/ImageView;", "getIconIv", "()Landroid/widget/ImageView;", "setIconIv", "(Landroid/widget/ImageView;)V", "layout", "getLayout", "()Landroid/view/View;", "setLayout", "nameTv", "Landroid/widget/TextView;", "getNameTv", "()Landroid/widget/TextView;", "setNameTv", "(Landroid/widget/TextView;)V", "app_release"})
  public static final class d
    extends RecyclerView.w
  {
    ImageView fBA;
    TextView fwQ;
    View qe;
    
    public d(View paramView)
    {
      super();
      AppMethodBeat.i(163400);
      View localView = paramView.findViewById(2131306428);
      k.g(localView, "itemView.findViewById(R.id.view_layout)");
      this.qe = localView;
      localView = paramView.findViewById(2131297628);
      k.g(localView, "itemView.findViewById(R.id.busi_icon)");
      this.fBA = ((ImageView)localView);
      paramView = paramView.findViewById(2131302666);
      k.g(paramView, "itemView.findViewById(R.id.name_tv)");
      this.fwQ = ((TextView)paramView);
      AppMethodBeat.o(163400);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/test/ExMainSettings$initList$2", "Landroid/view/View$OnClickListener;", "onClick", "", "v", "Landroid/view/View;", "app_release"})
  public static final class f
    implements View.OnClickListener
  {
    public final void onClick(View paramView) {}
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/test/ExMainSettings$printCrash$onClickCancel$1", "Landroid/content/DialogInterface$OnClickListener;", "onClick", "", "dialog", "Landroid/content/DialogInterface;", "which", "", "app_release"})
  public static final class l
    implements DialogInterface.OnClickListener
  {
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(163406);
      k.h(paramDialogInterface, "dialog");
      paramDialogInterface = ExMainSettings.zYa;
      ac.i(ExMainSettings.access$getTAG$cp(), "onClickCancel");
      AppMethodBeat.o(163406);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/test/ExMainSettings$printCrash$onClickOk$1", "Landroid/content/DialogInterface$OnClickListener;", "onClick", "", "dialog", "Landroid/content/DialogInterface;", "which", "", "app_release"})
  public static final class m
    implements DialogInterface.OnClickListener
  {
    m(StringBuilder paramStringBuilder) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(163407);
      k.h(paramDialogInterface, "dialog");
      paramDialogInterface = ExMainSettings.zYa;
      ac.i(ExMainSettings.access$getTAG$cp(), "onClick1");
      paramDialogInterface = this.zYc.getContext().getSystemService("clipboard");
      if (paramDialogInterface == null)
      {
        paramDialogInterface = new v("null cannot be cast to non-null type android.text.ClipboardManager");
        AppMethodBeat.o(163407);
        throw paramDialogInterface;
      }
      ((ClipboardManager)paramDialogInterface).setText((CharSequence)this.zYe);
      Toast.makeText((Context)this.zYc.getContext(), (CharSequence)"copy done", 0).show();
      AppMethodBeat.o(163407);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.test.ExMainSettings
 * JD-Core Version:    0.7.0.1
 */