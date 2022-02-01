package com.tencent.mm.plugin.textstatus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.Base64;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.model.cj;
import com.tencent.mm.plugin.textstatus.a.a.b;
import com.tencent.mm.plugin.textstatus.a.a.c;
import com.tencent.mm.plugin.textstatus.a.m;
import com.tencent.mm.plugin.textstatus.a.o;
import com.tencent.mm.plugin.textstatus.f.k.b;
import com.tencent.mm.plugin.textstatus.f.k.c;
import com.tencent.mm.plugin.textstatus.f.k.d;
import com.tencent.mm.plugin.textstatus.ui.StatusAlbumUI;
import com.tencent.mm.plugin.textstatus.ui.TextStatusEditActivity;
import com.tencent.mm.plugin.textstatus.ui.TextStatusEditActivity.a;
import com.tencent.mm.plugin.textstatus.ui.TextStatusLikeListActivity;
import com.tencent.mm.plugin.textstatus.ui.TextStatusLikeListActivity.b;
import com.tencent.mm.protocal.protobuf.btd;
import com.tencent.mm.protocal.protobuf.cpl;
import com.tencent.mm.protocal.protobuf.eos;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.as;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.vfs.y;
import java.util.HashMap;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/textstatus/PluginTextStatus;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/textstatus/api/IPluginTextStatus;", "Lcom/tencent/mm/kernel/api/bucket/ICoreAccountCallbackBucket;", "Lcom/tencent/mm/kernel/boot/parallels/IParallelsDependency;", "Lcom/tencent/mm/kernel/api/ICollectDBFactory;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "attachTextStatusSpanSync", "", "userName", "", "displayName", "iconScene", "Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconScene;", "size", "", "clearTextStatus", "", "textView", "Landroid/widget/TextView;", "collectDatabaseFactory", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "configure", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "execSQL", "sql", "execute", "getBackPreview", "Lcom/tencent/mm/plugin/textstatus/api/IBackPreview;", "context", "Landroid/content/Context;", "getDataManager", "Lcom/tencent/mm/plugin/textstatus/api/ITextStatusDataManager;", "getHistoryFragment", "Lcom/tencent/mm/ui/MMFragment;", "bundle", "Landroid/os/Bundle;", "getInfo", "Lcom/tencent/mm/plugin/textstatus/api/TextStatusInfo;", "username", "getMoreTabCardView", "Lcom/tencent/mm/plugin/textstatus/api/IProfileCardView;", "rootLayout", "Landroid/widget/RelativeLayout;", "headerRoot", "Landroid/widget/LinearLayout;", "getProfileCardView", "headRoot", "extraPadding", "getSelfInfo", "getStatusCardView", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCardView;", "showParam", "Lcom/tencent/mm/plugin/textstatus/api/StatusShowParam;", "getTextStatusSpanSync", "Landroid/text/style/ImageSpan;", "goLikeListFromSelfHistory", "goUnReadMsgPage", "contex", "hasStatus", "", "isHasStatusThumb", "isSpanSwitchOpen", "scene", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "onSceneEnd", "errType", "errCode", "errMsg", "Lcom/tencent/mm/modelbase/NetSceneBase;", "parallelsDependency", "report22208", "action", "", "actionResult", "report22210", "setSelfStatus", "activity", "Landroid/app/Activity;", "param", "Lcom/tencent/mm/plugin/textstatus/api/SetStatusParam;", "setTextStatusDrawable", "imageView", "Landroid/widget/ImageView;", "setTextWithStatus", "iconType", "Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconType;", "Lcom/tencent/mm/ui/base/NoMeasuredTextView;", "showCardDialog", "showStatusDetail", "showStatusPlanet", "updateStatus", "Companion", "plugin-textstatus_release"})
public final class PluginTextStatus
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.ak.i, com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.a, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.textstatus.a.c
{
  private static String FWZ;
  private static boolean FXa;
  public static final PluginTextStatus.a FXb;
  
  static
  {
    AppMethodBeat.i(216053);
    FXb = new PluginTextStatus.a((byte)0);
    FWZ = "";
    AppMethodBeat.o(216053);
  }
  
  private final boolean isSpanSwitchOpen(a.b paramb)
  {
    AppMethodBeat.i(216047);
    switch (a.$EnumSwitchMapping$0[paramb.ordinal()])
    {
    default: 
      AppMethodBeat.o(216047);
      return false;
    case 1: 
      bool = com.tencent.mm.plugin.textstatus.a.p.fvC();
      AppMethodBeat.o(216047);
      return bool;
    case 2: 
      bool = com.tencent.mm.plugin.textstatus.a.p.fvH();
      AppMethodBeat.o(216047);
      return bool;
    case 3: 
      bool = com.tencent.mm.plugin.textstatus.a.p.fvI();
      AppMethodBeat.o(216047);
      return bool;
    case 4: 
      bool = com.tencent.mm.plugin.textstatus.a.p.fvJ();
      AppMethodBeat.o(216047);
      return bool;
    case 5: 
      bool = com.tencent.mm.plugin.textstatus.a.p.fvK();
      AppMethodBeat.o(216047);
      return bool;
    case 6: 
      bool = com.tencent.mm.plugin.textstatus.a.p.fvL();
      AppMethodBeat.o(216047);
      return bool;
    }
    boolean bool = com.tencent.mm.plugin.textstatus.a.p.fvD();
    AppMethodBeat.o(216047);
    return bool;
  }
  
  public final CharSequence attachTextStatusSpanSync(String paramString, CharSequence paramCharSequence, a.b paramb, float paramFloat)
  {
    AppMethodBeat.i(216046);
    kotlin.g.b.p.h(paramb, "iconScene");
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i == 0) {
        if ((paramCharSequence != null) && (paramCharSequence.length() != 0)) {
          break label74;
        }
      }
    }
    label74:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label80;
      }
      AppMethodBeat.o(216046);
      return paramCharSequence;
      i = 0;
      break;
    }
    label80:
    if (!isSpanSwitchOpen(paramb))
    {
      AppMethodBeat.o(216046);
      return paramCharSequence;
    }
    paramString = getTextStatusSpanSync(paramString, paramb, paramFloat);
    if (paramString != null)
    {
      paramCharSequence = new SpannableStringBuilder(paramCharSequence);
      paramCharSequence.append((CharSequence)" ");
      paramCharSequence.setSpan(paramString, paramCharSequence.length() - 1, paramCharSequence.length(), 34);
      paramString = (CharSequence)paramCharSequence;
      AppMethodBeat.o(216046);
      return paramString;
    }
    AppMethodBeat.o(216046);
    return paramCharSequence;
  }
  
  public final void clearTextStatus(TextView paramTextView, String paramString)
  {
    AppMethodBeat.i(216041);
    if (paramTextView != null)
    {
      localObject = (CharSequence)paramString;
      if ((localObject != null) && (!kotlin.n.n.aL((CharSequence)localObject))) {
        break label40;
      }
    }
    label40:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(216041);
      return;
    }
    Object localObject = com.tencent.mm.plugin.textstatus.f.k.FZi;
    com.tencent.mm.plugin.textstatus.f.k.C(paramString, paramTextView);
    AppMethodBeat.o(216041);
  }
  
  public final HashMap<Integer, h.b> collectDatabaseFactory()
  {
    return null;
  }
  
  public final void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(216049);
    if ((paramg != null) && (paramg.aBb())) {
      y.a("textstatus", "textstatus", 536870912L, 3);
    }
    AppMethodBeat.o(216049);
  }
  
  /* Error */
  public final void execSQL(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 9
    //   6: ldc_w 272
    //   9: invokestatic 134	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   12: getstatic 278	com/tencent/mm/plugin/textstatus/b/f:FXJ	Lcom/tencent/mm/plugin/textstatus/b/f;
    //   15: astore 6
    //   17: invokestatic 282	com/tencent/mm/plugin/textstatus/b/f:getDataDB	()Lcom/tencent/mm/storagebase/h;
    //   20: invokevirtual 288	com/tencent/mm/storagebase/h:gFH	()Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   23: astore 8
    //   25: aload 7
    //   27: astore 6
    //   29: invokestatic 294	java/lang/System:currentTimeMillis	()J
    //   32: lstore 4
    //   34: aload 7
    //   36: astore 6
    //   38: aload 8
    //   40: getstatic 300	com/tencent/wcdb/database/SQLiteDirectCursor:FACTORY	Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;
    //   43: aload_1
    //   44: aconst_null
    //   45: aconst_null
    //   46: invokevirtual 306	com/tencent/wcdb/database/SQLiteDatabase:rawQueryWithFactory	(Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/String;)Lcom/tencent/wcdb/Cursor;
    //   49: checkcast 308	android/database/Cursor
    //   52: astore 7
    //   54: aload 7
    //   56: invokeinterface 312 1 0
    //   61: astore 6
    //   63: aload 6
    //   65: ifnull +376 -> 441
    //   68: aload 6
    //   70: arraylength
    //   71: istore_2
    //   72: ldc_w 314
    //   75: ldc_w 316
    //   78: aload_1
    //   79: invokestatic 322	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   82: invokevirtual 326	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   85: invokestatic 331	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: iload_2
    //   89: ifle +52 -> 141
    //   92: new 333	java/lang/StringBuilder
    //   95: dup
    //   96: ldc_w 335
    //   99: invokespecial 337	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   102: astore 8
    //   104: ldc_w 339
    //   107: checkcast 207	java/lang/CharSequence
    //   110: astore 9
    //   112: aload 6
    //   114: ifnonnull +6 -> 120
    //   117: invokestatic 342	kotlin/g/b/p:hyc	()V
    //   120: ldc_w 314
    //   123: aload 8
    //   125: aload 9
    //   127: aload 6
    //   129: invokestatic 348	android/text/TextUtils:join	(Ljava/lang/CharSequence;[Ljava/lang/Object;)Ljava/lang/String;
    //   132: invokevirtual 351	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: invokevirtual 354	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokestatic 331	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   141: new 333	java/lang/StringBuilder
    //   144: dup
    //   145: sipush 1024
    //   148: invokespecial 356	java/lang/StringBuilder:<init>	(I)V
    //   151: astore 6
    //   153: aload 7
    //   155: invokeinterface 359 1 0
    //   160: ifeq +203 -> 363
    //   163: aload 6
    //   165: iconst_0
    //   166: invokevirtual 362	java/lang/StringBuilder:setLength	(I)V
    //   169: aload 6
    //   171: ldc_w 335
    //   174: invokevirtual 351	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: iconst_0
    //   179: istore_3
    //   180: iload_3
    //   181: iload_2
    //   182: if_icmpge +167 -> 349
    //   185: aload 7
    //   187: iload_3
    //   188: invokeinterface 366 2 0
    //   193: lookupswitch	default:+245->438, 0:+57->250, 4:+119->312
    //   221: iconst_3
    //   222: aload 7
    //   224: iload_3
    //   225: invokeinterface 370 2 0
    //   230: invokevirtual 351	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: pop
    //   234: aload 6
    //   236: ldc_w 339
    //   239: invokevirtual 351	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: pop
    //   243: iload_3
    //   244: iconst_1
    //   245: iadd
    //   246: istore_3
    //   247: goto -67 -> 180
    //   250: aload 6
    //   252: ldc_w 372
    //   255: invokevirtual 351	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: pop
    //   259: goto -25 -> 234
    //   262: astore 8
    //   264: aload 7
    //   266: astore 6
    //   268: ldc_w 314
    //   271: ldc_w 374
    //   274: iconst_2
    //   275: anewarray 376	java/lang/Object
    //   278: dup
    //   279: iconst_0
    //   280: aload_1
    //   281: aastore
    //   282: dup
    //   283: iconst_1
    //   284: aload 8
    //   286: invokevirtual 379	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   289: aastore
    //   290: invokestatic 383	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   293: aload 7
    //   295: ifnull +123 -> 418
    //   298: aload 7
    //   300: invokeinterface 386 1 0
    //   305: ldc_w 272
    //   308: invokestatic 146	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   311: return
    //   312: aload 6
    //   314: ldc_w 388
    //   317: invokevirtual 351	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: pop
    //   321: goto -87 -> 234
    //   324: astore_1
    //   325: aload 7
    //   327: astore 6
    //   329: aload 6
    //   331: ifnull +10 -> 341
    //   334: aload 6
    //   336: invokeinterface 386 1 0
    //   341: ldc_w 272
    //   344: invokestatic 146	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   347: aload_1
    //   348: athrow
    //   349: ldc_w 314
    //   352: aload 6
    //   354: invokevirtual 354	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   357: invokestatic 331	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   360: goto -207 -> 153
    //   363: ldc_w 314
    //   366: ldc_w 390
    //   369: iconst_2
    //   370: anewarray 376	java/lang/Object
    //   373: dup
    //   374: iconst_0
    //   375: invokestatic 294	java/lang/System:currentTimeMillis	()J
    //   378: lload 4
    //   380: lsub
    //   381: invokestatic 395	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   384: aastore
    //   385: dup
    //   386: iconst_1
    //   387: aload_1
    //   388: aastore
    //   389: invokestatic 397	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   392: aload 7
    //   394: ifnull +17 -> 411
    //   397: aload 7
    //   399: invokeinterface 386 1 0
    //   404: ldc_w 272
    //   407: invokestatic 146	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   410: return
    //   411: ldc_w 272
    //   414: invokestatic 146	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   417: return
    //   418: ldc_w 272
    //   421: invokestatic 146	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   424: return
    //   425: astore_1
    //   426: goto -97 -> 329
    //   429: astore 8
    //   431: aload 9
    //   433: astore 7
    //   435: goto -171 -> 264
    //   438: goto -218 -> 220
    //   441: iconst_0
    //   442: istore_2
    //   443: goto -371 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	446	0	this	PluginTextStatus
    //   0	446	1	paramString	String
    //   71	372	2	i	int
    //   179	68	3	j	int
    //   32	347	4	l	long
    //   15	338	6	localObject1	Object
    //   1	433	7	localObject2	Object
    //   23	101	8	localObject3	Object
    //   262	23	8	localRuntimeException1	java.lang.RuntimeException
    //   429	1	8	localRuntimeException2	java.lang.RuntimeException
    //   4	428	9	localCharSequence	CharSequence
    // Exception table:
    //   from	to	target	type
    //   54	63	262	java/lang/RuntimeException
    //   68	72	262	java/lang/RuntimeException
    //   72	88	262	java/lang/RuntimeException
    //   92	112	262	java/lang/RuntimeException
    //   117	120	262	java/lang/RuntimeException
    //   120	141	262	java/lang/RuntimeException
    //   141	153	262	java/lang/RuntimeException
    //   153	178	262	java/lang/RuntimeException
    //   185	220	262	java/lang/RuntimeException
    //   220	234	262	java/lang/RuntimeException
    //   234	243	262	java/lang/RuntimeException
    //   250	259	262	java/lang/RuntimeException
    //   312	321	262	java/lang/RuntimeException
    //   349	360	262	java/lang/RuntimeException
    //   363	392	262	java/lang/RuntimeException
    //   54	63	324	finally
    //   68	72	324	finally
    //   72	88	324	finally
    //   92	112	324	finally
    //   117	120	324	finally
    //   120	141	324	finally
    //   141	153	324	finally
    //   153	178	324	finally
    //   185	220	324	finally
    //   220	234	324	finally
    //   234	243	324	finally
    //   250	259	324	finally
    //   312	321	324	finally
    //   349	360	324	finally
    //   363	392	324	finally
    //   29	34	425	finally
    //   38	54	425	finally
    //   268	293	425	finally
    //   29	34	429	java/lang/RuntimeException
    //   38	54	429	java/lang/RuntimeException
  }
  
  public final void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(216048);
    kotlin.g.b.p.h(paramg, "profile");
    if (paramg.aBb()) {
      com.tencent.mm.kernel.g.b(com.tencent.mm.plugin.textstatus.a.i.class, (com.tencent.mm.kernel.c.a)new com.tencent.mm.plugin.textstatus.f.j());
    }
    AppMethodBeat.o(216048);
  }
  
  public final com.tencent.mm.plugin.textstatus.a.b getBackPreview(Context paramContext)
  {
    AppMethodBeat.i(216033);
    kotlin.g.b.p.h(paramContext, "context");
    paramContext = (com.tencent.mm.plugin.textstatus.a.b)new com.tencent.mm.plugin.textstatus.ui.a(paramContext);
    AppMethodBeat.o(216033);
    return paramContext;
  }
  
  public final com.tencent.mm.plugin.textstatus.a.k getDataManager()
  {
    return (com.tencent.mm.plugin.textstatus.a.k)com.tencent.mm.plugin.textstatus.b.f.FXJ;
  }
  
  public final MMFragment getHistoryFragment(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(216043);
    paramContext = Fragment.instantiate(paramContext, StatusAlbumUI.class.getName(), paramBundle);
    if (paramContext == null)
    {
      paramContext = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragment");
      AppMethodBeat.o(216043);
      throw paramContext;
    }
    paramContext = (MMFragment)paramContext;
    AppMethodBeat.o(216043);
    return paramContext;
  }
  
  public final o getInfo(String paramString)
  {
    AppMethodBeat.i(216023);
    paramString = (Throwable)new kotlin.n("An operation is not implemented: ".concat(String.valueOf("Not yet implemented")));
    AppMethodBeat.o(216023);
    throw paramString;
  }
  
  public final com.tencent.mm.plugin.textstatus.a.d getMoreTabCardView(Context paramContext, RelativeLayout paramRelativeLayout, LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(216035);
    kotlin.g.b.p.h(paramContext, "context");
    kotlin.g.b.p.h(paramLinearLayout, "headerRoot");
    paramContext = (com.tencent.mm.plugin.textstatus.a.d)new com.tencent.mm.plugin.textstatus.ui.d(paramContext, paramRelativeLayout, paramLinearLayout);
    AppMethodBeat.o(216035);
    return paramContext;
  }
  
  public final com.tencent.mm.plugin.textstatus.a.d getProfileCardView(Context paramContext, RelativeLayout paramRelativeLayout, LinearLayout paramLinearLayout, int paramInt)
  {
    AppMethodBeat.i(216034);
    kotlin.g.b.p.h(paramContext, "context");
    kotlin.g.b.p.h(paramRelativeLayout, "rootLayout");
    kotlin.g.b.p.h(paramLinearLayout, "headRoot");
    paramContext = (com.tencent.mm.plugin.textstatus.a.d)new com.tencent.mm.plugin.textstatus.ui.e(paramContext, paramRelativeLayout, paramLinearLayout, paramInt);
    AppMethodBeat.o(216034);
    return paramContext;
  }
  
  public final o getSelfInfo()
  {
    AppMethodBeat.i(216022);
    Throwable localThrowable = (Throwable)new kotlin.n("An operation is not implemented: ".concat(String.valueOf("Not yet implemented")));
    AppMethodBeat.o(216022);
    throw localThrowable;
  }
  
  public final com.tencent.mm.plugin.textstatus.a.f getStatusCardView(Context paramContext)
  {
    AppMethodBeat.i(216030);
    kotlin.g.b.p.h(paramContext, "context");
    com.tencent.mm.plugin.textstatus.a.n localn = com.tencent.mm.plugin.textstatus.a.n.FXs;
    kotlin.g.b.p.g(localn, "StatusShowParam.sDefaultShowParam");
    paramContext = getStatusCardView(paramContext, localn);
    AppMethodBeat.o(216030);
    return paramContext;
  }
  
  public final com.tencent.mm.plugin.textstatus.a.f getStatusCardView(Context paramContext, com.tencent.mm.plugin.textstatus.a.n paramn)
  {
    AppMethodBeat.i(216031);
    kotlin.g.b.p.h(paramContext, "context");
    kotlin.g.b.p.h(paramn, "showParam");
    paramContext = (com.tencent.mm.plugin.textstatus.a.f)new com.tencent.mm.plugin.textstatus.ui.f(paramContext, paramn);
    AppMethodBeat.o(216031);
    return paramContext;
  }
  
  public final com.tencent.mm.plugin.textstatus.a.f getStatusCardView(Context paramContext, String paramString)
  {
    AppMethodBeat.i(216032);
    kotlin.g.b.p.h(paramContext, "context");
    kotlin.g.b.p.h(paramString, "username");
    paramContext = new com.tencent.mm.plugin.textstatus.ui.f(paramContext);
    paramContext.DV(paramString);
    paramContext = (com.tencent.mm.plugin.textstatus.a.f)paramContext;
    AppMethodBeat.o(216032);
    return paramContext;
  }
  
  public final ImageSpan getTextStatusSpanSync(String paramString, a.b paramb, float paramFloat)
  {
    AppMethodBeat.i(216045);
    kotlin.g.b.p.h(paramb, "iconScene");
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (kotlin.n.n.aL(localCharSequence))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(216045);
      return null;
    }
    if (!isSpanSwitchOpen(paramb))
    {
      AppMethodBeat.o(216045);
      return null;
    }
    paramb = com.tencent.mm.plugin.textstatus.b.f.FXJ;
    paramString = com.tencent.mm.plugin.textstatus.b.f.aTf(paramString);
    if (paramString != null)
    {
      paramb = com.tencent.mm.plugin.textstatus.j.b.GfZ;
      paramString = com.tencent.mm.plugin.textstatus.j.b.a(paramString.field_IconID, a.c.FXp, null, 4);
      if (paramString != null)
      {
        paramString.setBounds(0, 0, (int)paramFloat, (int)paramFloat);
        paramString = (ImageSpan)new com.tencent.mm.plugin.textstatus.j.d(paramString);
        AppMethodBeat.o(216045);
        return paramString;
      }
    }
    AppMethodBeat.o(216045);
    return null;
  }
  
  public final void goLikeListFromSelfHistory(Context paramContext)
  {
    AppMethodBeat.i(216044);
    kotlin.g.b.p.h(paramContext, "context");
    Object localObject = TextStatusLikeListActivity.Gfx;
    kotlin.g.b.p.h(paramContext, "context");
    localObject = new Intent(paramContext, TextStatusLikeListActivity.class);
    ((Intent)localObject).putExtra("scene", 2);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$Companion", "startForSelfAllHistory", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$Companion", "startForSelfAllHistory", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(216044);
  }
  
  public final void goUnReadMsgPage(Context paramContext)
  {
    AppMethodBeat.i(216036);
    if (paramContext == null)
    {
      AppMethodBeat.o(216036);
      return;
    }
    TextStatusLikeListActivity.b localb = TextStatusLikeListActivity.Gfx;
    TextStatusLikeListActivity.b.hs(paramContext);
    AppMethodBeat.o(216036);
  }
  
  public final boolean hasStatus(String paramString)
  {
    AppMethodBeat.i(216021);
    Object localObject = (CharSequence)paramString;
    int i;
    if ((localObject == null) || (kotlin.n.n.aL((CharSequence)localObject)))
    {
      i = 1;
      if (i == 0) {
        break label47;
      }
    }
    for (paramString = null;; paramString = com.tencent.mm.plugin.textstatus.b.f.aTf(paramString))
    {
      if (paramString == null) {
        break label59;
      }
      AppMethodBeat.o(216021);
      return true;
      i = 0;
      break;
      label47:
      localObject = com.tencent.mm.plugin.textstatus.b.f.FXJ;
    }
    label59:
    AppMethodBeat.o(216021);
    return false;
  }
  
  public final boolean isHasStatusThumb(String paramString)
  {
    AppMethodBeat.i(216042);
    Object localObject = com.tencent.mm.plugin.textstatus.j.a.GfU;
    if (paramString == null) {
      kotlin.g.b.p.hyc();
    }
    if (com.tencent.mm.vfs.s.YS(com.tencent.mm.plugin.textstatus.j.a.lf("thumb", paramString)))
    {
      AppMethodBeat.o(216042);
      return true;
    }
    localObject = com.tencent.mm.plugin.textstatus.b.f.FXJ;
    paramString = com.tencent.mm.plugin.textstatus.b.f.aTf(paramString);
    if ((paramString != null) && (!TextUtils.isEmpty((CharSequence)paramString.field_MediaThumbUrl)))
    {
      AppMethodBeat.o(216042);
      return true;
    }
    AppMethodBeat.o(216042);
    return false;
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(216050);
    kotlin.g.b.p.h(paramc, "upgrade");
    Log.i("MicroMsg.TxtStatus.PluginTextStatus", "onAccountInitialized");
    paramc = com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class);
    kotlin.g.b.p.g(paramc, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.s)paramc).getSysCmdMsgExtension().a("modtextstatus", (com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.plugin.textstatus.b.f.FXJ);
    paramc = com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class);
    kotlin.g.b.p.g(paramc, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.s)paramc).getSysCmdMsgExtension().a("textstatuslike", (com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.plugin.textstatus.b.f.FXJ);
    com.tencent.mm.kernel.g.azz().a(302, (com.tencent.mm.ak.i)this);
    ((com.tencent.mm.plugin.messenger.foundation.a.e)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.e.class)).addContactAssembler((com.tencent.mm.plugin.messenger.foundation.a.d)new b());
    paramc = com.tencent.mm.plugin.textstatus.f.h.c.FZX;
    com.tencent.mm.plugin.textstatus.f.h.c.cjR();
    AppMethodBeat.o(216050);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(216051);
    Log.i("MicroMsg.TxtStatus.PluginTextStatus", "onAccountRelease");
    Object localObject = com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class);
    kotlin.g.b.p.g(localObject, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.s)localObject).getSysCmdMsgExtension().b("modtextstatus", (com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.plugin.textstatus.b.f.FXJ);
    localObject = com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class);
    kotlin.g.b.p.g(localObject, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((com.tencent.mm.plugin.messenger.foundation.a.s)localObject).getSysCmdMsgExtension().b("textstatuslike", (com.tencent.mm.plugin.messenger.foundation.a.q)com.tencent.mm.plugin.textstatus.b.f.FXJ);
    com.tencent.mm.kernel.g.azz().b(302, (com.tencent.mm.ak.i)this);
    localObject = com.tencent.mm.plugin.textstatus.b.f.FXJ;
    com.tencent.mm.plugin.textstatus.b.f.getDataDB().closeDB();
    AppMethodBeat.o(216051);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(216052);
    kotlin.g.b.p.h(paramq, "scene");
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((com.tencent.mm.modelsimple.p)paramq).getReqResp();
      if (paramString == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
        AppMethodBeat.o(216052);
        throw paramString;
      }
      paramString = (com.tencent.mm.ak.d)paramString;
      Object localObject;
      if (paramString != null)
      {
        paramString = paramString.aYK();
        paramString = (btd)paramString;
        if (paramString == null) {
          break label323;
        }
        paramq = paramString.LZO;
        if (paramq == null) {
          break label323;
        }
        paramString = paramq.LiD;
        paramq = paramq.LiF;
        Log.i("MicroMsg.TxtStatus.PluginTextStatus", "statusID: " + paramString + ", extInfo: " + paramq);
        localObject = (CharSequence)paramString;
        if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
          break label269;
        }
        paramInt1 = 1;
        label158:
        if (paramInt1 != 0) {
          break label279;
        }
        localObject = (CharSequence)paramq;
        if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
          break label274;
        }
      }
      label269:
      label274:
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        if (paramInt1 != 0) {
          break label279;
        }
        localObject = new com.tencent.mm.plugin.textstatus.g.g();
        ((com.tencent.mm.plugin.textstatus.g.g)localObject).parseFrom(Base64.decode(paramq, 0));
        paramq = com.tencent.mm.plugin.textstatus.b.f.FXJ;
        String str = com.tencent.mm.plugin.auth.a.a.ceA();
        kotlin.g.b.p.g(str, "Account.username()");
        com.tencent.mm.plugin.textstatus.b.f.a(paramq, str, paramString, (com.tencent.mm.plugin.textstatus.g.g)localObject);
        com.tencent.mm.kernel.g.azz().b((com.tencent.mm.ak.q)new com.tencent.mm.plugin.textstatus.f.g());
        AppMethodBeat.o(216052);
        return;
        paramString = null;
        break;
        paramInt1 = 0;
        break label158;
      }
      label279:
      Log.i("MicroMsg.TxtStatus.PluginTextStatus", "del self");
      paramString = com.tencent.mm.plugin.textstatus.b.f.FXJ;
      paramString = com.tencent.mm.plugin.textstatus.b.f.fvM();
      paramq = com.tencent.mm.plugin.auth.a.a.ceA();
      kotlin.g.b.p.g(paramq, "Account.username()");
      paramString.aTk(paramq);
      AppMethodBeat.o(216052);
      return;
    }
    label323:
    AppMethodBeat.o(216052);
  }
  
  public final void parallelsDependency() {}
  
  public final void report22208(long paramLong, String paramString)
  {
    AppMethodBeat.i(258406);
    Object localObject = com.tencent.mm.plugin.textstatus.k.a.UsD;
    localObject = paramString;
    if (paramString == null) {
      localObject = "";
    }
    com.tencent.mm.plugin.textstatus.k.a.report22208(paramLong, (String)localObject);
    AppMethodBeat.o(258406);
  }
  
  public final void report22210(String paramString, long paramLong)
  {
    AppMethodBeat.i(258407);
    kotlin.g.b.p.h(paramString, "userName");
    com.tencent.mm.plugin.textstatus.k.a locala = com.tencent.mm.plugin.textstatus.k.a.UsD;
    com.tencent.mm.plugin.textstatus.k.a.report22210(paramString, paramLong);
    AppMethodBeat.o(258407);
  }
  
  public final void setSelfStatus(Activity paramActivity)
  {
    AppMethodBeat.i(216025);
    setSelfStatus(paramActivity, null);
    AppMethodBeat.o(216025);
  }
  
  public final void setSelfStatus(Activity paramActivity, m paramm)
  {
    AppMethodBeat.i(216026);
    if (paramActivity == null)
    {
      AppMethodBeat.o(216026);
      return;
    }
    TextStatusEditActivity.a locala = TextStatusEditActivity.GeM;
    TextStatusEditActivity.a.b((Context)paramActivity, paramm);
    AppMethodBeat.o(216026);
  }
  
  public final void setTextStatusDrawable(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(216037);
    kotlin.g.b.p.h(paramImageView, "imageView");
    kotlin.g.b.p.h(paramString, "username");
    new k.b(paramString, paramImageView);
    AppMethodBeat.o(216037);
  }
  
  public final void setTextWithStatus(TextView paramTextView, String paramString, a.b paramb, a.c paramc)
  {
    AppMethodBeat.i(216039);
    kotlin.g.b.p.h(paramb, "iconScene");
    kotlin.g.b.p.h(paramc, "iconType");
    if (paramTextView != null)
    {
      CharSequence localCharSequence = (CharSequence)paramString;
      if ((localCharSequence != null) && (!kotlin.n.n.aL(localCharSequence))) {
        break label58;
      }
    }
    label58:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(216039);
      return;
    }
    if (isSpanSwitchOpen(paramb)) {
      new k.c(paramString, paramTextView, paramc);
    }
    AppMethodBeat.o(216039);
  }
  
  public final void setTextWithStatus(NoMeasuredTextView paramNoMeasuredTextView, String paramString, a.b paramb)
  {
    AppMethodBeat.i(216040);
    kotlin.g.b.p.h(paramb, "iconScene");
    if (paramNoMeasuredTextView != null)
    {
      CharSequence localCharSequence = (CharSequence)paramString;
      if ((localCharSequence != null) && (!kotlin.n.n.aL(localCharSequence))) {
        break label50;
      }
    }
    label50:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(216040);
      return;
    }
    if (isSpanSwitchOpen(paramb)) {
      new k.d(paramString, paramNoMeasuredTextView);
    }
    AppMethodBeat.o(216040);
  }
  
  public final void showCardDialog(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(216028);
    Object localObject;
    if (paramActivity != null)
    {
      localObject = (CharSequence)paramString;
      if ((localObject != null) && (!kotlin.n.n.aL((CharSequence)localObject))) {
        break label54;
      }
    }
    label54:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = com.tencent.mm.plugin.textstatus.b.f.FXJ;
        if (com.tencent.mm.plugin.textstatus.b.f.aTf(paramString) != null) {
          break;
        }
      }
      AppMethodBeat.o(216028);
      return;
    }
    new com.tencent.mm.plugin.textstatus.ui.g((Context)paramActivity, paramString).show();
    AppMethodBeat.o(216028);
  }
  
  public final void showStatusDetail(Context paramContext, String paramString)
  {
    AppMethodBeat.i(216029);
    paramString = (CharSequence)paramString;
    if ((paramString == null) || (kotlin.n.n.aL(paramString))) {}
    for (int i = 1; (i != 0) || (paramContext == null); i = 0)
    {
      AppMethodBeat.o(216029);
      return;
    }
    AppMethodBeat.o(216029);
  }
  
  public final void showStatusPlanet(Activity paramActivity)
  {
    AppMethodBeat.i(216027);
    if (paramActivity == null)
    {
      AppMethodBeat.o(216027);
      return;
    }
    new com.tencent.mm.plugin.textstatus.ui.j((Context)paramActivity).show();
    AppMethodBeat.o(216027);
  }
  
  public final void updateStatus(String paramString)
  {
    AppMethodBeat.i(216024);
    paramString = (Throwable)new kotlin.n("An operation is not implemented: ".concat(String.valueOf("Not yet implemented")));
    AppMethodBeat.o(216024);
    throw paramString;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/textstatus/PluginTextStatus$onAccountInitialized$1", "Lcom/tencent/mm/plugin/messenger/foundation/api/IContactSyncCallback;", "afterContactUpdate", "", "newContact", "Lcom/tencent/mm/storage/Contact;", "oldContact", "cmdMC", "Lcom/tencent/mm/protocal/protobuf/ModContact;", "cmdBuf", "", "isInit", "", "assemble", "plugin-textstatus_release"})
  public static final class b
    implements com.tencent.mm.plugin.messenger.foundation.a.d
  {
    public final void a(as paramas1, as paramas2, cpl paramcpl, byte[] paramArrayOfByte, boolean paramBoolean) {}
    
    public final void b(as paramas1, as paramas2, cpl paramcpl, byte[] paramArrayOfByte, boolean paramBoolean)
    {
      AppMethodBeat.i(216020);
      if (paramcpl != null)
      {
        Object localObject;
        if (((paramas2 == null) || (!paramas2.arv())) && (paramas1 != null) && (paramas1.arv()))
        {
          paramas2 = com.tencent.mm.plugin.textstatus.b.f.FXJ;
          paramas2 = com.tencent.mm.plugin.textstatus.b.f.fvO();
          paramArrayOfByte = paramas1.getUsername();
          kotlin.g.b.p.g(paramArrayOfByte, "newContact.username");
          kotlin.g.b.p.h(paramArrayOfByte, "userName");
          localObject = (CharSequence)paramas2.gWM();
          if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
            break label156;
          }
        }
        label156:
        for (int i = 1;; i = 0)
        {
          if (i == 0)
          {
            localObject = new com.tencent.mm.plugin.textstatus.f.f.e();
            ((com.tencent.mm.plugin.textstatus.f.f.e)localObject).field_UserName = paramArrayOfByte;
            ((com.tencent.mm.plugin.textstatus.f.f.e)localObject).field_HashUserName = com.tencent.mm.plugin.textstatus.f.f.f.fA(paramArrayOfByte, paramas2.gWM());
            paramas2.replace((IAutoDBItem)localObject);
          }
          if ((paramcpl.MvB == 2) && (paramas1 != null) && (paramas1.arv())) {
            break;
          }
          AppMethodBeat.o(216020);
          return;
        }
        paramas2 = paramcpl.LiD;
        paramcpl = paramcpl.LiF;
        Log.i("MicroMsg.TxtStatus.PluginTextStatus", "afterContactUpdate, statusID: " + paramas2 + ", extInfo: " + paramcpl);
        paramArrayOfByte = (CharSequence)paramas2;
        if ((paramArrayOfByte == null) || (paramArrayOfByte.length() == 0))
        {
          i = 1;
          if (i != 0) {
            break label322;
          }
          paramArrayOfByte = (CharSequence)paramcpl;
          if ((paramArrayOfByte != null) && (paramArrayOfByte.length() != 0)) {
            break label316;
          }
        }
        label316:
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label322;
          }
          paramArrayOfByte = new com.tencent.mm.plugin.textstatus.g.g();
          paramArrayOfByte.parseFrom(Base64.decode(paramcpl, 0));
          paramcpl = com.tencent.mm.plugin.textstatus.b.f.FXJ;
          paramas1 = paramas1.getUsername();
          kotlin.g.b.p.g(paramas1, "newContact.username");
          com.tencent.mm.plugin.textstatus.b.f.a(paramcpl, paramas1, paramas2, paramArrayOfByte);
          AppMethodBeat.o(216020);
          return;
          i = 0;
          break;
        }
        label322:
        paramas2 = com.tencent.mm.plugin.textstatus.b.f.FXJ;
        paramas2 = com.tencent.mm.plugin.textstatus.b.f.fvM();
        paramas1 = paramas1.getUsername();
        kotlin.g.b.p.g(paramas1, "newContact.username");
        paramas2.aTk(paramas1);
        AppMethodBeat.o(216020);
        return;
      }
      AppMethodBeat.o(216020);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.PluginTextStatus
 * JD-Core Version:    0.7.0.1
 */