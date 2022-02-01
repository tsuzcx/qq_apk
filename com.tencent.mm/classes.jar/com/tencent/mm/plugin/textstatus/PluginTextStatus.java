package com.tencent.mm.plugin.textstatus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.co;
import com.tencent.mm.f.b.a.mn;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.ck;
import com.tencent.mm.plugin.messenger.foundation.a.v;
import com.tencent.mm.plugin.textstatus.a.a.a;
import com.tencent.mm.plugin.textstatus.a.a.b;
import com.tencent.mm.plugin.textstatus.a.a.c;
import com.tencent.mm.plugin.textstatus.a.o;
import com.tencent.mm.plugin.textstatus.a.q.a;
import com.tencent.mm.plugin.textstatus.a.r;
import com.tencent.mm.plugin.textstatus.g.e.h.d;
import com.tencent.mm.plugin.textstatus.g.k;
import com.tencent.mm.plugin.textstatus.g.n.b;
import com.tencent.mm.plugin.textstatus.g.n.c;
import com.tencent.mm.plugin.textstatus.g.n.d;
import com.tencent.mm.plugin.textstatus.proto.TextStatusExtInfo;
import com.tencent.mm.plugin.textstatus.proto.TextStatusTopicInfo;
import com.tencent.mm.plugin.textstatus.ui.StatusAlbumUI;
import com.tencent.mm.plugin.textstatus.ui.TextStatusLikeListActivity;
import com.tencent.mm.plugin.textstatus.ui.TextStatusLikeListActivity.b;
import com.tencent.mm.protocal.protobuf.cav;
import com.tencent.mm.protocal.protobuf.cyb;
import com.tencent.mm.protocal.protobuf.eza;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.vfs.ab;
import com.tencent.mm.vfs.u;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.x;
import org.json.JSONArray;
import org.json.JSONObject;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/textstatus/PluginTextStatus;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/textstatus/api/IPluginTextStatus;", "Lcom/tencent/mm/kernel/api/bucket/ICoreAccountCallbackBucket;", "Lcom/tencent/mm/kernel/boot/parallels/IParallelsDependency;", "Lcom/tencent/mm/kernel/api/ICollectDBFactory;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "configUpdateListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ConfigUpdatedEvent;", "getConfigUpdateListener", "()Lcom/tencent/mm/sdk/event/IListener;", "hasGetUserPermission", "", "attachTextStatusSpanSync", "", "textView", "Landroid/widget/TextView;", "userName", "", "displayName", "iconScene", "Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconScene;", "size", "", "clearTextStatus", "", "collectDatabaseFactory", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "configure", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "createGetBrandInfoScene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "url", "execSQL", "sql", "execute", "getBackPreview", "Lcom/tencent/mm/plugin/textstatus/api/IBackPreview;", "context", "Landroid/content/Context;", "pullDownViewCloseRunnable", "Ljava/lang/Runnable;", "isPreviewVideo", "getDataManager", "Lcom/tencent/mm/plugin/textstatus/api/ITextStatusDataManager;", "getHistoryFragment", "Lcom/tencent/mm/ui/MMFragment;", "bundle", "Landroid/os/Bundle;", "getMoreTabCardView", "Lcom/tencent/mm/plugin/textstatus/api/IProfileCardView;", "rootLayout", "Landroid/widget/RelativeLayout;", "headerRoot", "Landroid/widget/LinearLayout;", "getProfileCardView", "headRoot", "extraPadding", "getResVersion", "", "getStatusCardView", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCardView;", "showParam", "Lcom/tencent/mm/plugin/textstatus/api/StatusShowParam;", "username", "getStrangerInfos", "Lorg/json/JSONObject;", "data", "getTextStatusId", "getTextStatusSpanSync", "Landroid/text/style/ImageSpan;", "getUserNameByCommHashName", "hashName", "goLikeListFromSelfHistory", "goUnReadMsgPage", "contex", "handleGetBrandResult", "Landroid/app/Activity;", "scene", "scanSource", "hasStatus", "isHasStatusThumb", "isInTagList", "isSpanSwitchOpen", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "onSceneEnd", "errType", "errCode", "errMsg", "parallelsDependency", "report22208", "action", "actionResult", "report22210", "setTextStatusDrawable", "imageView", "Landroid/widget/ImageView;", "setTextWithStatus", "iconType", "Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconType;", "Lcom/tencent/mm/ui/base/NoMeasuredTextView;", "showCardDialog", "activity", "showStatusDetail", "showStatusPlanet", "tryAttachStatusIconSpan", "v", "Landroid/view/View;", "content", "Companion", "plugin-textstatus_release"})
public final class PluginTextStatus
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.an.i, com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.a, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.textstatus.a.d
{
  private static String Muq;
  public static final PluginTextStatus.a Mur;
  private final IListener<co> DOD;
  private boolean Mup;
  
  static
  {
    AppMethodBeat.i(236906);
    Mur = new PluginTextStatus.a((byte)0);
    Muq = "";
    AppMethodBeat.o(236906);
  }
  
  public PluginTextStatus()
  {
    AppMethodBeat.i(236903);
    this.DOD = ((IListener)new b());
    AppMethodBeat.o(236903);
  }
  
  private final boolean isInTagList(String paramString)
  {
    AppMethodBeat.i(236898);
    if (com.tencent.mm.plugin.sns.b.p.fNe() != null)
    {
      boolean bool = com.tencent.mm.plugin.sns.b.p.fNe().aUR(paramString);
      AppMethodBeat.o(236898);
      return bool;
    }
    AppMethodBeat.o(236898);
    return false;
  }
  
  private final boolean isSpanSwitchOpen(a.b paramb, String paramString)
  {
    AppMethodBeat.i(236868);
    switch (a.$EnumSwitchMapping$0[paramb.ordinal()])
    {
    default: 
      AppMethodBeat.o(236868);
      return false;
    case 1: 
      bool = com.tencent.mm.plugin.textstatus.a.t.gkZ();
      AppMethodBeat.o(236868);
      return bool;
    case 2: 
      bool = com.tencent.mm.plugin.textstatus.a.t.glh();
      AppMethodBeat.o(236868);
      return bool;
    case 3: 
      bool = com.tencent.mm.plugin.textstatus.a.t.gli();
      AppMethodBeat.o(236868);
      return bool;
    case 4: 
      if (com.tencent.mm.plugin.textstatus.a.t.glk())
      {
        paramb = com.tencent.mm.plugin.textstatus.b.f.MAm;
        paramb = com.tencent.mm.plugin.textstatus.b.f.bep(paramString);
        if (paramb != null) {}
        for (paramb = paramb.field_IconID;; paramb = null)
        {
          bool = kotlin.g.b.p.h(paramb, "2021");
          AppMethodBeat.o(236868);
          return bool;
        }
      }
      bool = com.tencent.mm.plugin.textstatus.a.t.glj();
      AppMethodBeat.o(236868);
      return bool;
    case 5: 
      bool = com.tencent.mm.plugin.textstatus.a.t.gll();
      AppMethodBeat.o(236868);
      return bool;
    case 6: 
      bool = com.tencent.mm.plugin.textstatus.a.t.glm();
      AppMethodBeat.o(236868);
      return bool;
    }
    boolean bool = com.tencent.mm.plugin.textstatus.a.t.gla();
    AppMethodBeat.o(236868);
    return bool;
  }
  
  public final CharSequence attachTextStatusSpanSync(TextView paramTextView, String paramString, CharSequence paramCharSequence, a.b paramb, float paramFloat)
  {
    AppMethodBeat.i(236866);
    kotlin.g.b.p.k(paramb, "iconScene");
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0))
    {
      i = 1;
      if (i == 0) {
        if ((paramCharSequence != null) && (paramCharSequence.length() != 0)) {
          break label78;
        }
      }
    }
    label78:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label84;
      }
      AppMethodBeat.o(236866);
      return paramCharSequence;
      i = 0;
      break;
    }
    label84:
    if (!isSpanSwitchOpen(paramb, paramString))
    {
      AppMethodBeat.o(236866);
      return paramCharSequence;
    }
    paramTextView = getTextStatusSpanSync(paramTextView, paramString, paramb, paramFloat);
    if (paramTextView != null)
    {
      paramString = new SpannableStringBuilder(paramCharSequence);
      paramString.append((CharSequence)" ");
      paramString.setSpan(paramTextView, paramString.length() - 1, paramString.length(), 34);
      paramTextView = (CharSequence)paramString;
      AppMethodBeat.o(236866);
      return paramTextView;
    }
    AppMethodBeat.o(236866);
    return paramCharSequence;
  }
  
  public final void clearTextStatus(TextView paramTextView, String paramString)
  {
    AppMethodBeat.i(236855);
    if (paramTextView != null)
    {
      localObject = (CharSequence)paramString;
      if ((localObject != null) && (!kotlin.n.n.ba((CharSequence)localObject))) {
        break label42;
      }
    }
    label42:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(236855);
      return;
    }
    Object localObject = com.tencent.mm.plugin.textstatus.g.n.MDy;
    com.tencent.mm.plugin.textstatus.g.n.B(paramString, paramTextView);
    AppMethodBeat.o(236855);
  }
  
  public final HashMap<Integer, h.b> collectDatabaseFactory()
  {
    return null;
  }
  
  public final void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(236877);
    if ((paramg != null) && (paramg.aIE()))
    {
      ab.a("textstatusCache", "textstatus", 536870912L, 7776000000L, 1);
      ab.aE("textstatusPersist", "textstatus", 6);
    }
    AppMethodBeat.o(236877);
  }
  
  public final com.tencent.mm.an.q createGetBrandInfoScene(String paramString)
  {
    AppMethodBeat.i(236894);
    paramString = (com.tencent.mm.an.q)new com.tencent.mm.plugin.textstatus.g.c(paramString);
    AppMethodBeat.o(236894);
    return paramString;
  }
  
  /* Error */
  public final void execSQL(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 9
    //   6: ldc_w 354
    //   9: invokestatic 160	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   12: getstatic 233	com/tencent/mm/plugin/textstatus/b/f:MAm	Lcom/tencent/mm/plugin/textstatus/b/f;
    //   15: astore 6
    //   17: invokestatic 358	com/tencent/mm/plugin/textstatus/b/f:getDataDB	()Lcom/tencent/mm/storagebase/h;
    //   20: invokevirtual 364	com/tencent/mm/storagebase/h:hBZ	()Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   23: astore 8
    //   25: aload 7
    //   27: astore 6
    //   29: invokestatic 370	java/lang/System:currentTimeMillis	()J
    //   32: lstore 4
    //   34: aload 7
    //   36: astore 6
    //   38: aload 8
    //   40: getstatic 376	com/tencent/wcdb/database/SQLiteDirectCursor:FACTORY	Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;
    //   43: aload_1
    //   44: aconst_null
    //   45: aconst_null
    //   46: invokevirtual 382	com/tencent/wcdb/database/SQLiteDatabase:rawQueryWithFactory	(Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/String;)Lcom/tencent/wcdb/Cursor;
    //   49: checkcast 384	android/database/Cursor
    //   52: astore 7
    //   54: aload 7
    //   56: invokeinterface 388 1 0
    //   61: astore 6
    //   63: aload 6
    //   65: ifnull +376 -> 441
    //   68: aload 6
    //   70: arraylength
    //   71: istore_2
    //   72: ldc_w 390
    //   75: ldc_w 392
    //   78: aload_1
    //   79: invokestatic 398	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   82: invokevirtual 402	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   85: invokestatic 407	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: iload_2
    //   89: ifle +52 -> 141
    //   92: new 409	java/lang/StringBuilder
    //   95: dup
    //   96: ldc_w 411
    //   99: invokespecial 412	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   102: astore 8
    //   104: ldc_w 414
    //   107: checkcast 271	java/lang/CharSequence
    //   110: astore 9
    //   112: aload 6
    //   114: ifnonnull +6 -> 120
    //   117: invokestatic 417	kotlin/g/b/p:iCn	()V
    //   120: ldc_w 390
    //   123: aload 8
    //   125: aload 9
    //   127: aload 6
    //   129: invokestatic 423	android/text/TextUtils:join	(Ljava/lang/CharSequence;[Ljava/lang/Object;)Ljava/lang/String;
    //   132: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: invokevirtual 429	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   138: invokestatic 407	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   141: new 409	java/lang/StringBuilder
    //   144: dup
    //   145: sipush 1024
    //   148: invokespecial 431	java/lang/StringBuilder:<init>	(I)V
    //   151: astore 6
    //   153: aload 7
    //   155: invokeinterface 434 1 0
    //   160: ifeq +203 -> 363
    //   163: aload 6
    //   165: iconst_0
    //   166: invokevirtual 437	java/lang/StringBuilder:setLength	(I)V
    //   169: aload 6
    //   171: ldc_w 411
    //   174: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: iconst_0
    //   179: istore_3
    //   180: iload_3
    //   181: iload_2
    //   182: if_icmpge +167 -> 349
    //   185: aload 7
    //   187: iload_3
    //   188: invokeinterface 441 2 0
    //   193: lookupswitch	default:+245->438, 0:+57->250, 4:+119->312
    //   221: iconst_3
    //   222: aload 7
    //   224: iload_3
    //   225: invokeinterface 445 2 0
    //   230: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: pop
    //   234: aload 6
    //   236: ldc_w 414
    //   239: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: pop
    //   243: iload_3
    //   244: iconst_1
    //   245: iadd
    //   246: istore_3
    //   247: goto -67 -> 180
    //   250: aload 6
    //   252: ldc_w 447
    //   255: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   258: pop
    //   259: goto -25 -> 234
    //   262: astore 8
    //   264: aload 7
    //   266: astore 6
    //   268: ldc_w 390
    //   271: ldc_w 449
    //   274: iconst_2
    //   275: anewarray 451	java/lang/Object
    //   278: dup
    //   279: iconst_0
    //   280: aload_1
    //   281: aastore
    //   282: dup
    //   283: iconst_1
    //   284: aload 8
    //   286: invokevirtual 454	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   289: aastore
    //   290: invokestatic 458	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   293: aload 7
    //   295: ifnull +123 -> 418
    //   298: aload 7
    //   300: invokeinterface 461 1 0
    //   305: ldc_w 354
    //   308: invokestatic 172	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   311: return
    //   312: aload 6
    //   314: ldc_w 463
    //   317: invokevirtual 426	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: pop
    //   321: goto -87 -> 234
    //   324: astore_1
    //   325: aload 7
    //   327: astore 6
    //   329: aload 6
    //   331: ifnull +10 -> 341
    //   334: aload 6
    //   336: invokeinterface 461 1 0
    //   341: ldc_w 354
    //   344: invokestatic 172	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   347: aload_1
    //   348: athrow
    //   349: ldc_w 390
    //   352: aload 6
    //   354: invokevirtual 429	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   357: invokestatic 407	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   360: goto -207 -> 153
    //   363: ldc_w 390
    //   366: ldc_w 465
    //   369: iconst_2
    //   370: anewarray 451	java/lang/Object
    //   373: dup
    //   374: iconst_0
    //   375: invokestatic 370	java/lang/System:currentTimeMillis	()J
    //   378: lload 4
    //   380: lsub
    //   381: invokestatic 470	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   384: aastore
    //   385: dup
    //   386: iconst_1
    //   387: aload_1
    //   388: aastore
    //   389: invokestatic 472	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   392: aload 7
    //   394: ifnull +17 -> 411
    //   397: aload 7
    //   399: invokeinterface 461 1 0
    //   404: ldc_w 354
    //   407: invokestatic 172	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   410: return
    //   411: ldc_w 354
    //   414: invokestatic 172	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   417: return
    //   418: ldc_w 354
    //   421: invokestatic 172	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    AppMethodBeat.i(236871);
    kotlin.g.b.p.k(paramg, "profile");
    if (paramg.aIE()) {
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.textstatus.a.l.class, (com.tencent.mm.kernel.c.a)new com.tencent.mm.plugin.textstatus.g.m());
    }
    AppMethodBeat.o(236871);
  }
  
  public final com.tencent.mm.plugin.textstatus.a.b getBackPreview(Context paramContext, Runnable paramRunnable, boolean paramBoolean)
  {
    AppMethodBeat.i(236843);
    kotlin.g.b.p.k(paramContext, "context");
    paramContext = (com.tencent.mm.plugin.textstatus.a.b)new com.tencent.mm.plugin.textstatus.ui.a(paramContext, paramRunnable, paramBoolean);
    AppMethodBeat.o(236843);
    return paramContext;
  }
  
  public final IListener<co> getConfigUpdateListener()
  {
    return this.DOD;
  }
  
  public final o getDataManager()
  {
    return (o)com.tencent.mm.plugin.textstatus.b.f.MAm;
  }
  
  public final MMFragment getHistoryFragment(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(236859);
    paramContext = Fragment.instantiate(paramContext, StatusAlbumUI.class.getName(), paramBundle);
    if (paramContext == null)
    {
      paramContext = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragment");
      AppMethodBeat.o(236859);
      throw paramContext;
    }
    paramContext = (MMFragment)paramContext;
    AppMethodBeat.o(236859);
    return paramContext;
  }
  
  public final com.tencent.mm.plugin.textstatus.a.e getMoreTabCardView(Context paramContext, RelativeLayout paramRelativeLayout, LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(236845);
    kotlin.g.b.p.k(paramContext, "context");
    kotlin.g.b.p.k(paramLinearLayout, "headerRoot");
    paramContext = (com.tencent.mm.plugin.textstatus.a.e)new com.tencent.mm.plugin.textstatus.ui.f(paramContext, paramRelativeLayout, paramLinearLayout);
    AppMethodBeat.o(236845);
    return paramContext;
  }
  
  public final com.tencent.mm.plugin.textstatus.a.e getProfileCardView(Context paramContext, RelativeLayout paramRelativeLayout, LinearLayout paramLinearLayout, int paramInt)
  {
    AppMethodBeat.i(236844);
    kotlin.g.b.p.k(paramContext, "context");
    kotlin.g.b.p.k(paramRelativeLayout, "rootLayout");
    kotlin.g.b.p.k(paramLinearLayout, "headRoot");
    paramContext = (com.tencent.mm.plugin.textstatus.a.e)new com.tencent.mm.plugin.textstatus.ui.g(paramContext, paramRelativeLayout, paramLinearLayout, paramInt);
    AppMethodBeat.o(236844);
    return paramContext;
  }
  
  public final long getResVersion()
  {
    AppMethodBeat.i(236897);
    long l = com.tencent.mm.plugin.textstatus.k.c.gnz().getResVersion();
    AppMethodBeat.o(236897);
    return l;
  }
  
  public final com.tencent.mm.plugin.textstatus.a.h getStatusCardView(Context paramContext)
  {
    AppMethodBeat.i(236840);
    kotlin.g.b.p.k(paramContext, "context");
    r localr = r.gkP();
    kotlin.g.b.p.j(localr, "StatusShowParam.def()");
    paramContext = getStatusCardView(paramContext, localr);
    AppMethodBeat.o(236840);
    return paramContext;
  }
  
  public final com.tencent.mm.plugin.textstatus.a.h getStatusCardView(Context paramContext, r paramr)
  {
    AppMethodBeat.i(236841);
    kotlin.g.b.p.k(paramContext, "context");
    kotlin.g.b.p.k(paramr, "showParam");
    paramContext = (com.tencent.mm.plugin.textstatus.a.h)new com.tencent.mm.plugin.textstatus.ui.h(paramContext, paramr);
    AppMethodBeat.o(236841);
    return paramContext;
  }
  
  public final com.tencent.mm.plugin.textstatus.a.h getStatusCardView(Context paramContext, String paramString)
  {
    AppMethodBeat.i(236842);
    kotlin.g.b.p.k(paramContext, "context");
    kotlin.g.b.p.k(paramString, "username");
    paramContext = new com.tencent.mm.plugin.textstatus.ui.h(paramContext);
    paramContext.KN(paramString);
    paramContext = (com.tencent.mm.plugin.textstatus.a.h)paramContext;
    AppMethodBeat.o(236842);
    return paramContext;
  }
  
  public final JSONObject getStrangerInfos(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(236901);
    JSONObject localJSONObject = new JSONObject();
    if (paramJSONObject != null) {}
    for (;;)
    {
      try
      {
        paramJSONObject = paramJSONObject.optJSONArray("arrStrangerContact");
        if (paramJSONObject != null)
        {
          localJSONArray = new JSONArray();
          int j = paramJSONObject.length();
          i = 0;
          if (i < j)
          {
            localObject3 = paramJSONObject.optString(i);
            localObject1 = com.tencent.mm.plugin.textstatus.b.f.MAm;
            localObject2 = com.tencent.mm.plugin.textstatus.b.f.glA().Vd((String)localObject3);
            localObject1 = new JSONObject();
          }
        }
      }
      catch (Throwable paramJSONObject)
      {
        JSONArray localJSONArray;
        int i;
        Object localObject3;
        Object localObject1;
        Object localObject2;
        continue;
      }
      try
      {
        ((JSONObject)localObject1).put("hashName", localObject3);
        localObject3 = new JSONObject();
        if (localObject2 != null)
        {
          ((JSONObject)localObject3).put("name", aa.PJ((String)localObject2));
          Object localObject4 = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class);
          kotlin.g.b.p.j(localObject4, "MMKernel.service(IMessengerStorage::class.java)");
          localObject4 = ((com.tencent.mm.plugin.messenger.foundation.a.n)localObject4).bbL().RG((String)localObject2);
          kotlin.g.b.p.j(localObject4, "ct");
          if ((((as)localObject4).axZ()) && (!((as)localObject4).ayc()) && (!((as)localObject4).ayk()) && (!isInTagList((String)localObject2)))
          {
            localObject4 = com.tencent.mm.plugin.textstatus.b.f.MAm;
            localObject2 = com.tencent.mm.plugin.textstatus.b.f.bep((String)localObject2);
            if (localObject2 != null) {
              ((JSONObject)localObject3).put("statusId", ((com.tencent.mm.plugin.textstatus.g.e.a)localObject2).field_StatusID);
            }
          }
        }
        ((JSONObject)localObject1).put("info", localObject3);
      }
      catch (Throwable localThrowable)
      {
        continue;
      }
      localJSONArray.put(localObject1);
      i += 1;
      continue;
      localJSONObject.put("arrFriendContact", localJSONArray);
      AppMethodBeat.o(236901);
      return localJSONObject;
      paramJSONObject = null;
    }
  }
  
  public final String getTextStatusId(String paramString)
  {
    AppMethodBeat.i(236835);
    Object localObject = (CharSequence)paramString;
    int i;
    if ((localObject == null) || (kotlin.n.n.ba((CharSequence)localObject)))
    {
      i = 1;
      if (i == 0) {
        break label61;
      }
    }
    for (paramString = null;; paramString = com.tencent.mm.plugin.textstatus.b.f.bep(paramString))
    {
      if (paramString != null)
      {
        localObject = paramString.field_StatusID;
        paramString = (String)localObject;
        if (localObject != null) {}
      }
      else
      {
        paramString = "";
      }
      AppMethodBeat.o(236835);
      return paramString;
      i = 0;
      break;
      label61:
      localObject = com.tencent.mm.plugin.textstatus.b.f.MAm;
    }
  }
  
  public final ImageSpan getTextStatusSpanSync(TextView paramTextView, String paramString, a.b paramb, float paramFloat)
  {
    AppMethodBeat.i(236864);
    kotlin.g.b.p.k(paramb, "iconScene");
    Object localObject1 = (CharSequence)paramString;
    if ((localObject1 == null) || (kotlin.n.n.ba((CharSequence)localObject1))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(236864);
      return null;
    }
    if (!isSpanSwitchOpen(paramb, paramString))
    {
      AppMethodBeat.o(236864);
      return null;
    }
    localObject1 = com.tencent.mm.plugin.textstatus.k.c.gnz();
    i = (int)paramFloat;
    Object localObject2 = com.tencent.mm.plugin.textstatus.b.f.MAm;
    localObject2 = com.tencent.mm.plugin.textstatus.b.f.bep(paramString);
    if (localObject2 != null)
    {
      if (((com.tencent.mm.plugin.textstatus.g.e.a)localObject2).glZ()) {}
      for (paramString = a.a.Mzw;; paramString = a.a.Mzt)
      {
        paramTextView = ((com.tencent.mm.plugin.textstatus.k.a)localObject1).a((View)paramTextView, ((com.tencent.mm.plugin.textstatus.g.e.a)localObject2).field_IconID, a.c.MzI, paramString, paramb, i, (com.tencent.mm.plugin.textstatus.g.e.a)localObject2);
        AppMethodBeat.o(236864);
        return paramTextView;
      }
    }
    AppMethodBeat.o(236864);
    return null;
  }
  
  public final String getUserNameByCommHashName(String paramString)
  {
    AppMethodBeat.i(236900);
    Object localObject1 = com.tencent.mm.plugin.textstatus.b.f.MAm;
    com.tencent.mm.plugin.textstatus.g.e.h localh = com.tencent.mm.plugin.textstatus.b.f.glA();
    localObject1 = (CharSequence)paramString;
    int i;
    if ((localObject1 == null) || (kotlin.n.n.ba((CharSequence)localObject1)))
    {
      i = 1;
      if (i == 0) {
        break label61;
      }
      paramString = null;
    }
    for (;;)
    {
      localObject1 = paramString;
      if (paramString == null) {
        localObject1 = "";
      }
      AppMethodBeat.o(236900);
      return localObject1;
      i = 0;
      break;
      label61:
      localObject1 = (com.tencent.mm.plugin.textstatus.g.e.g)localh.MEi.aX(paramString);
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        localObject2 = "select * from " + com.tencent.mm.plugin.textstatus.g.e.h.Alf + " where CommHashUserName = ? ";
        Cursor localCursor = localh.db.rawQuery((String)localObject2, new String[] { Util.escapeSqlValue(paramString) });
        kotlin.g.b.p.j(localCursor, "db.rawQuery(sql, arrayOf…eSqlValue(hashUserName)))");
        localObject2 = localObject1;
        if (localCursor != null)
        {
          if (localCursor.moveToFirst())
          {
            localObject1 = new com.tencent.mm.plugin.textstatus.g.e.g();
            ((com.tencent.mm.plugin.textstatus.g.e.g)localObject1).convertFrom(localCursor);
            localh.MEi.put(paramString, localObject1);
          }
          localCursor.close();
          localObject2 = localObject1;
        }
      }
      if (localObject2 != null) {
        paramString = ((com.tencent.mm.plugin.textstatus.g.e.g)localObject2).field_UserName;
      } else {
        paramString = null;
      }
    }
  }
  
  public final void goLikeListFromSelfHistory(Context paramContext)
  {
    AppMethodBeat.i(236860);
    kotlin.g.b.p.k(paramContext, "context");
    Object localObject = TextStatusLikeListActivity.MNs;
    kotlin.g.b.p.k(paramContext, "context");
    localObject = new Intent(paramContext, TextStatusLikeListActivity.class);
    ((Intent)localObject).putExtra("scene", 2);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$Companion", "startForSelfAllHistory", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$Companion", "startForSelfAllHistory", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(236860);
  }
  
  public final void goUnReadMsgPage(Context paramContext)
  {
    AppMethodBeat.i(236846);
    if (paramContext == null)
    {
      AppMethodBeat.o(236846);
      return;
    }
    TextStatusLikeListActivity.b localb = TextStatusLikeListActivity.MNs;
    TextStatusLikeListActivity.b.ix(paramContext);
    AppMethodBeat.o(236846);
  }
  
  public final void handleGetBrandResult(Activity paramActivity, com.tencent.mm.an.q paramq, int paramInt)
  {
    AppMethodBeat.i(236891);
    if (paramActivity == null)
    {
      AppMethodBeat.o(236891);
      return;
    }
    if ((paramq instanceof com.tencent.mm.plugin.textstatus.g.c))
    {
      Object localObject1 = new StringBuilder("GetBrandInfo templates:");
      Object localObject2 = ((com.tencent.mm.plugin.textstatus.g.c)paramq).MDd;
      if (localObject2 != null)
      {
        localObject2 = ((com.tencent.mm.plugin.textstatus.proto.m)localObject2).MFl;
        if (localObject2 != null)
        {
          localObject2 = ((com.tencent.mm.plugin.textstatus.proto.g)localObject2).MFi;
          if (localObject2 == null) {}
        }
      }
      for (int i = ((LinkedList)localObject2).size();; i = -1)
      {
        Log.i("MicroMsg.TextStatus.PluginTextStatus", i);
        paramq = ((com.tencent.mm.plugin.textstatus.g.c)paramq).MDd;
        if (paramq == null) {
          break label409;
        }
        paramq = paramq.MFl;
        if (paramq == null) {
          break label409;
        }
        paramq = paramq.MFi;
        if (paramq == null) {
          break label409;
        }
        localObject1 = paramq.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          paramq = (com.tencent.mm.plugin.textstatus.proto.h)((Iterator)localObject1).next();
          switch (paramq.tpK)
          {
          }
        }
        Log.i("MicroMsg.TextStatus.PluginTextStatus", "GetBrandInfo templates url:" + paramq.url);
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("rawUrl", paramq.url);
        com.tencent.mm.by.c.b((Context)paramActivity, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
        AppMethodBeat.o(236891);
        return;
      }
      localObject1 = new TextStatusExtInfo();
      ((TextStatusExtInfo)localObject1).parseFrom(Base64.decode(paramq.MFj, 0));
      Log.i("MicroMsg.TextStatus.PluginTextStatus", "GetBrandInfo templates extInfo:" + com.tencent.mm.plugin.textstatus.k.e.c((TextStatusExtInfo)localObject1));
      paramq = new q.a().gkO();
      paramq.MEA = ((TextStatusExtInfo)localObject1);
      long l;
      switch (paramInt)
      {
      default: 
        l = 8L;
      }
      for (;;)
      {
        paramq.MEC = l;
        ((com.tencent.mm.plugin.textstatus.a.l)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.textstatus.a.l.class)).a((Context)paramActivity, paramq);
        AppMethodBeat.o(236891);
        return;
        l = 9L;
        continue;
        l = 10L;
      }
      AppMethodBeat.o(236891);
      return;
      label409:
      AppMethodBeat.o(236891);
      return;
    }
    AppMethodBeat.o(236891);
  }
  
  public final boolean hasStatus(String paramString)
  {
    AppMethodBeat.i(236834);
    Object localObject = (CharSequence)paramString;
    int i;
    if ((localObject == null) || (kotlin.n.n.ba((CharSequence)localObject)))
    {
      i = 1;
      if (i == 0) {
        break label47;
      }
    }
    for (paramString = null;; paramString = com.tencent.mm.plugin.textstatus.b.f.bep(paramString))
    {
      if (paramString == null) {
        break label59;
      }
      AppMethodBeat.o(236834);
      return true;
      i = 0;
      break;
      label47:
      localObject = com.tencent.mm.plugin.textstatus.b.f.MAm;
    }
    label59:
    AppMethodBeat.o(236834);
    return false;
  }
  
  public final boolean isHasStatusThumb(String paramString)
  {
    AppMethodBeat.i(236858);
    Object localObject1 = com.tencent.mm.plugin.textstatus.k.f.MOw;
    if (paramString == null) {
      kotlin.g.b.p.iCn();
    }
    if (u.agG(com.tencent.mm.plugin.textstatus.k.f.lD("thumb", paramString)))
    {
      AppMethodBeat.o(236858);
      return true;
    }
    localObject1 = com.tencent.mm.plugin.textstatus.b.f.MAm;
    localObject1 = com.tencent.mm.plugin.textstatus.b.f.bep(paramString);
    Object localObject2;
    if (localObject1 != null)
    {
      paramString = ((com.tencent.mm.plugin.textstatus.g.e.a)localObject1).glY();
      if (paramString == null) {
        break label121;
      }
      localObject2 = (CharSequence)paramString.sourceId;
      if ((localObject2 != null) && (!kotlin.n.n.ba((CharSequence)localObject2))) {
        break label116;
      }
    }
    label116:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label121;
      }
      localObject2 = com.tencent.mm.plugin.textstatus.j.d.MIW;
      if (com.tencent.mm.plugin.textstatus.j.d.beD(com.tencent.mm.plugin.textstatus.b.b.c.a(paramString)) == null) {
        break label121;
      }
      AppMethodBeat.o(236858);
      return true;
      paramString = null;
      break;
    }
    label121:
    if ((localObject1 != null) && (!TextUtils.isEmpty((CharSequence)((com.tencent.mm.plugin.textstatus.g.e.a)localObject1).field_MediaThumbUrl)))
    {
      AppMethodBeat.o(236858);
      return true;
    }
    AppMethodBeat.o(236858);
    return false;
  }
  
  public final void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(236882);
    kotlin.g.b.p.k(paramc, "upgrade");
    Log.i("MicroMsg.TextStatus.PluginTextStatus", "onAccountInitialized");
    Object localObject = com.tencent.mm.kernel.h.ag(v.class);
    kotlin.g.b.p.j(localObject, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((v)localObject).getSysCmdMsgExtension().a("modtextstatus", (com.tencent.mm.plugin.messenger.foundation.a.t)com.tencent.mm.plugin.textstatus.b.f.MAm);
    localObject = com.tencent.mm.kernel.h.ag(v.class);
    kotlin.g.b.p.j(localObject, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((v)localObject).getSysCmdMsgExtension().a("textstatuslike", (com.tencent.mm.plugin.messenger.foundation.a.t)com.tencent.mm.plugin.textstatus.b.f.MAm);
    localObject = com.tencent.mm.kernel.h.ag(v.class);
    kotlin.g.b.p.j(localObject, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((v)localObject).getSysCmdMsgExtension().a("textstatusreference", (com.tencent.mm.plugin.messenger.foundation.a.t)com.tencent.mm.plugin.textstatus.b.f.MAm);
    localObject = com.tencent.mm.kernel.h.ag(v.class);
    kotlin.g.b.p.j(localObject, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((v)localObject).getSysCmdMsgExtension().a("textstatusiconconfigrefresh", (com.tencent.mm.plugin.messenger.foundation.a.t)com.tencent.mm.plugin.textstatus.b.f.MAm);
    com.tencent.mm.kernel.h.aGY().a(302, (com.tencent.mm.an.i)this);
    com.tencent.mm.kernel.h.aGY().a(4255, (com.tencent.mm.an.i)this);
    ((com.tencent.mm.plugin.messenger.foundation.a.g)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.g.class)).addContactAssembler((com.tencent.mm.plugin.messenger.foundation.a.f)new c());
    localObject = com.tencent.mm.plugin.textstatus.g.g.c.MEt;
    com.tencent.mm.plugin.textstatus.g.g.c.cxi();
    if ((paramc.kcX) && (com.tencent.mm.plugin.textstatus.a.t.glo() == 1))
    {
      com.tencent.mm.kernel.h.aGY().b((com.tencent.mm.an.q)new k());
      this.Mup = true;
    }
    com.tencent.mm.ae.d.c("TextStatusThread", (kotlin.g.a.a)d.Mus);
    ((com.tencent.mm.plugin.textstatus.a.l)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.textstatus.a.l.class)).a("7", (com.tencent.mm.plugin.textstatus.a.m)new com.tencent.mm.plugin.textstatus.j.f());
    ((com.tencent.mm.plugin.textstatus.a.l)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.textstatus.a.l.class)).a("8", (com.tencent.mm.plugin.textstatus.a.m)new com.tencent.mm.plugin.textstatus.j.a());
    ((com.tencent.mm.plugin.textstatus.a.l)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.textstatus.a.l.class)).a("3", (com.tencent.mm.plugin.textstatus.a.m)new com.tencent.mm.plugin.textstatus.j.b());
    this.DOD.alive();
    AppMethodBeat.o(236882);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(236885);
    Log.i("MicroMsg.TextStatus.PluginTextStatus", "onAccountRelease");
    com.tencent.mm.plugin.textstatus.k.c.gnz().onDestroy();
    Object localObject = com.tencent.mm.kernel.h.ag(v.class);
    kotlin.g.b.p.j(localObject, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((v)localObject).getSysCmdMsgExtension().b("modtextstatus", (com.tencent.mm.plugin.messenger.foundation.a.t)com.tencent.mm.plugin.textstatus.b.f.MAm);
    localObject = com.tencent.mm.kernel.h.ag(v.class);
    kotlin.g.b.p.j(localObject, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((v)localObject).getSysCmdMsgExtension().b("textstatuslike", (com.tencent.mm.plugin.messenger.foundation.a.t)com.tencent.mm.plugin.textstatus.b.f.MAm);
    localObject = com.tencent.mm.kernel.h.ag(v.class);
    kotlin.g.b.p.j(localObject, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((v)localObject).getSysCmdMsgExtension().b("textstatusreference", (com.tencent.mm.plugin.messenger.foundation.a.t)com.tencent.mm.plugin.textstatus.b.f.MAm);
    localObject = com.tencent.mm.kernel.h.ag(v.class);
    kotlin.g.b.p.j(localObject, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
    ((v)localObject).getSysCmdMsgExtension().b("textstatusiconconfigrefresh", (com.tencent.mm.plugin.messenger.foundation.a.t)com.tencent.mm.plugin.textstatus.b.f.MAm);
    com.tencent.mm.kernel.h.aGY().b(302, (com.tencent.mm.an.i)this);
    com.tencent.mm.kernel.h.aGY().b(4255, (com.tencent.mm.an.i)this);
    localObject = com.tencent.mm.plugin.textstatus.b.f.MAm;
    com.tencent.mm.plugin.textstatus.b.f.getDataDB().closeDB();
    ((com.tencent.mm.plugin.textstatus.a.l)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.textstatus.a.l.class)).beb("7");
    ((com.tencent.mm.plugin.textstatus.a.l)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.textstatus.a.l.class)).beb("8");
    ((com.tencent.mm.plugin.textstatus.a.l)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.textstatus.a.l.class)).beb("3");
    this.DOD.dead();
    AppMethodBeat.o(236885);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(236896);
    kotlin.g.b.p.k(paramq, "scene");
    if ((paramq instanceof com.tencent.mm.plugin.textstatus.g.f))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = ((com.tencent.mm.plugin.textstatus.g.f)paramq).MDi;
        if (paramString != null)
        {
          com.tencent.mm.ae.d.c("TextStatusThread", (kotlin.g.a.a)new e(paramString));
          AppMethodBeat.o(236896);
          return;
        }
      }
      AppMethodBeat.o(236896);
      return;
    }
    Object localObject;
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      paramString = ((com.tencent.mm.modelsimple.p)paramq).getReqResp();
      if (paramString == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.modelbase.CommReqResp");
        AppMethodBeat.o(236896);
        throw paramString;
      }
      paramString = (com.tencent.mm.an.d)paramString;
      if (paramString == null) {
        break label359;
      }
      paramString = paramString.bhY();
      paramString = (cav)paramString;
      if (paramString != null)
      {
        paramq = paramString.Tjh;
        if (paramq != null)
        {
          paramString = paramq.SjU;
          paramq = paramq.SjW;
          Log.i("MicroMsg.TextStatus.PluginTextStatus", "statusID: " + paramString + ", extInfo: " + paramq);
          localObject = (CharSequence)paramString;
          if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
            break label364;
          }
          paramInt1 = 1;
          label218:
          if (paramInt1 != 0) {
            break label401;
          }
          localObject = (CharSequence)paramq;
          if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
            break label369;
          }
          paramInt1 = 1;
          if (paramInt1 != 0) {
            break label401;
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject = new TextStatusExtInfo();
        ((TextStatusExtInfo)localObject).parseFrom(Base64.decode(paramq, 0));
        paramq = com.tencent.mm.plugin.textstatus.b.f.MAm;
        String str = com.tencent.mm.plugin.auth.a.a.crN();
        kotlin.g.b.p.j(str, "Account.username()");
        com.tencent.mm.plugin.textstatus.b.f.a(paramq, str, paramString, (TextStatusExtInfo)localObject, 0, null, 24);
        com.tencent.mm.kernel.h.aGY().b((com.tencent.mm.an.q)new com.tencent.mm.plugin.textstatus.g.i());
        if ((!this.Mup) && (com.tencent.mm.plugin.textstatus.a.t.glo() == 1)) {
          com.tencent.mm.kernel.h.aGY().b((com.tencent.mm.an.q)new k());
        }
        AppMethodBeat.o(236896);
        return;
        label359:
        paramString = null;
        break;
        label364:
        paramInt1 = 0;
        break label218;
        label369:
        paramInt1 = 0;
      }
      catch (Throwable paramq)
      {
        Log.printErrStackTrace("MicroMsg.TextStatus.PluginTextStatus", paramq, "NetSceneGetProfile parse extfail id:".concat(String.valueOf(paramString)), new Object[0]);
        continue;
      }
      label401:
      Log.i("MicroMsg.TextStatus.PluginTextStatus", "del self");
      paramString = com.tencent.mm.plugin.textstatus.b.f.MAm;
      paramString = com.tencent.mm.plugin.textstatus.b.f.gly();
      paramq = com.tencent.mm.plugin.auth.a.a.crN();
      kotlin.g.b.p.j(paramq, "Account.username()");
      paramString.bex(paramq);
    }
  }
  
  public final void parallelsDependency() {}
  
  public final void report22208(long paramLong, String paramString)
  {
    AppMethodBeat.i(236862);
    com.tencent.mm.plugin.textstatus.h.a locala = com.tencent.mm.plugin.textstatus.h.a.MGJ;
    if (paramString == null) {
      paramString = "";
    }
    for (;;)
    {
      com.tencent.mm.plugin.textstatus.h.a.a(paramLong, paramString, null, 0L, 12);
      AppMethodBeat.o(236862);
      return;
    }
  }
  
  public final void report22210(String paramString, long paramLong)
  {
    int i = 1;
    long l2 = 2L;
    AppMethodBeat.i(236863);
    kotlin.g.b.p.k(paramString, "userName");
    Object localObject = com.tencent.mm.plugin.textstatus.h.a.MGJ;
    kotlin.g.b.p.k(paramString, "userName");
    localObject = com.tencent.mm.plugin.textstatus.b.f.MAm;
    localObject = com.tencent.mm.plugin.textstatus.b.f.gly().bey(paramString);
    long l1;
    mn localmn;
    if (paramLong == 2L) {
      if (localObject != null)
      {
        l1 = 2L;
        localmn = new mn();
        paramString = localmn.De(paramString).yc(paramLong);
        if (localObject == null) {
          break label306;
        }
      }
    }
    label300:
    label306:
    for (paramLong = l2;; paramLong = 1L)
    {
      paramString.yd(paramLong).ye(l1).yf(System.currentTimeMillis()).Df("").bpa();
      com.tencent.mm.plugin.textstatus.h.a.a((com.tencent.mm.plugin.report.a)localmn);
      AppMethodBeat.o(236863);
      return;
      l1 = 0L;
      break;
      if (paramLong == 3L)
      {
        if (((CharSequence)paramString).length() == 0) {}
        for (;;)
        {
          if (i != 0) {
            break label300;
          }
          l1 = 1L;
          break;
          i = 0;
        }
      }
      if (paramLong == 4L)
      {
        if (((CharSequence)paramString).length() == 0) {}
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label300;
          }
          l1 = 1L;
          break;
        }
      }
      if (paramLong == 5L)
      {
        l1 = 1L;
        break;
      }
      if (paramLong == 6L)
      {
        l1 = 1L;
        break;
      }
      if (paramLong == 7L)
      {
        l1 = 1L;
        break;
      }
      if (paramLong == 8L)
      {
        l1 = 1L;
        break;
      }
      if (paramLong == 9L)
      {
        l1 = 1L;
        break;
      }
      if (paramLong == 10L)
      {
        l1 = 1L;
        break;
      }
      l1 = 0L;
      break;
    }
  }
  
  public final void setTextStatusDrawable(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(236847);
    kotlin.g.b.p.k(paramImageView, "imageView");
    kotlin.g.b.p.k(paramString, "username");
    new n.b(paramString, paramImageView);
    AppMethodBeat.o(236847);
  }
  
  public final void setTextWithStatus(TextView paramTextView, String paramString, a.b paramb, a.c paramc)
  {
    AppMethodBeat.i(236849);
    kotlin.g.b.p.k(paramb, "iconScene");
    kotlin.g.b.p.k(paramc, "iconType");
    if (paramTextView != null)
    {
      CharSequence localCharSequence = (CharSequence)paramString;
      if ((localCharSequence != null) && (!kotlin.n.n.ba(localCharSequence))) {
        break label59;
      }
    }
    label59:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(236849);
      return;
    }
    if (isSpanSwitchOpen(paramb, paramString)) {
      new n.c(paramString, paramTextView, paramc, paramb);
    }
    AppMethodBeat.o(236849);
  }
  
  public final void setTextWithStatus(NoMeasuredTextView paramNoMeasuredTextView, String paramString, a.b paramb)
  {
    AppMethodBeat.i(236853);
    kotlin.g.b.p.k(paramb, "iconScene");
    if (paramNoMeasuredTextView != null)
    {
      CharSequence localCharSequence = (CharSequence)paramString;
      if ((localCharSequence != null) && (!kotlin.n.n.ba(localCharSequence))) {
        break label51;
      }
    }
    label51:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(236853);
      return;
    }
    if (isSpanSwitchOpen(paramb, paramString)) {
      new n.d(paramString, paramNoMeasuredTextView, paramb);
    }
    AppMethodBeat.o(236853);
  }
  
  public final void showCardDialog(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(236837);
    if (paramActivity != null)
    {
      localObject = (CharSequence)paramString;
      if ((localObject != null) && (!kotlin.n.n.ba((CharSequence)localObject))) {
        break label54;
      }
    }
    label54:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = com.tencent.mm.plugin.textstatus.b.f.MAm;
        if (com.tencent.mm.plugin.textstatus.b.f.bep(paramString) != null) {
          break;
        }
      }
      AppMethodBeat.o(236837);
      return;
    }
    Object localObject = paramActivity.getResources();
    kotlin.g.b.p.j(localObject, "activity.resources");
    localObject = ((Resources)localObject).getConfiguration();
    kotlin.g.b.p.j(localObject, "activity.resources.configuration");
    if (((Configuration)localObject).orientation == 2) {}
    for (i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(236837);
      return;
    }
    new com.tencent.mm.plugin.textstatus.ui.i((Context)paramActivity, paramString).show();
    AppMethodBeat.o(236837);
  }
  
  public final void showStatusDetail(Context paramContext, String paramString)
  {
    AppMethodBeat.i(236838);
    paramString = (CharSequence)paramString;
    if ((paramString == null) || (kotlin.n.n.ba(paramString))) {}
    for (int i = 1; (i != 0) || (paramContext == null); i = 0)
    {
      AppMethodBeat.o(236838);
      return;
    }
    AppMethodBeat.o(236838);
  }
  
  public final void showStatusPlanet(Activity paramActivity)
  {
    AppMethodBeat.i(236836);
    if (paramActivity == null)
    {
      AppMethodBeat.o(236836);
      return;
    }
    new com.tencent.mm.plugin.textstatus.ui.n((Context)paramActivity).show();
    AppMethodBeat.o(236836);
  }
  
  public final void tryAttachStatusIconSpan(View paramView, CharSequence paramCharSequence)
  {
    AppMethodBeat.i(236895);
    if ((paramCharSequence == null) || (kotlin.n.n.ba(paramCharSequence))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(236895);
      return;
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramCharSequence);
    if (paramCharSequence != null) {}
    for (paramCharSequence = Integer.valueOf(paramCharSequence.length());; paramCharSequence = null)
    {
      paramCharSequence = (com.tencent.mm.plugin.textstatus.k.l[])localSpannableStringBuilder.getSpans(0, paramCharSequence.intValue(), com.tencent.mm.plugin.textstatus.k.l.class);
      if (paramView != null) {
        paramView.setTag(b.e.MwF, null);
      }
      int j = paramCharSequence.length;
      i = 0;
      while (i < j)
      {
        paramCharSequence[i].eo(paramView);
        i += 1;
      }
    }
    AppMethodBeat.o(236895);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/textstatus/PluginTextStatus$configUpdateListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ConfigUpdatedEvent;", "callback", "", "event", "plugin-textstatus_release"})
  public static final class b
    extends IListener<co>
  {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/textstatus/PluginTextStatus$onAccountInitialized$1", "Lcom/tencent/mm/plugin/messenger/foundation/api/IContactSyncCallback;", "afterContactUpdate", "", "newContact", "Lcom/tencent/mm/storage/Contact;", "oldContact", "cmdMC", "Lcom/tencent/mm/protocal/protobuf/ModContact;", "cmdBuf", "", "isInit", "", "assemble", "plugin-textstatus_release"})
  public static final class c
    implements com.tencent.mm.plugin.messenger.foundation.a.f
  {
    public final void a(as paramas1, as paramas2, cyb paramcyb, byte[] paramArrayOfByte, boolean paramBoolean) {}
    
    public final void b(as paramas1, as paramas2, cyb paramcyb, byte[] paramArrayOfByte, boolean paramBoolean)
    {
      AppMethodBeat.i(233266);
      if (paramcyb != null)
      {
        if ((paramas1 != null) && (paramas1.axZ()))
        {
          paramas2 = com.tencent.mm.plugin.textstatus.b.f.MAm;
          paramas2 = com.tencent.mm.plugin.textstatus.b.f.glA();
          paramArrayOfByte = paramas1.getUsername();
          kotlin.g.b.p.j(paramArrayOfByte, "newContact.username");
          kotlin.g.b.p.k(paramArrayOfByte, "userName");
          CharSequence localCharSequence = (CharSequence)paramas2.gmh();
          if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
            break label142;
          }
          i = 1;
          if (i == 0) {
            if (!kotlin.n.n.ba((CharSequence)paramArrayOfByte)) {
              break label148;
            }
          }
        }
        label142:
        label148:
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            com.tencent.mm.ae.d.b("MicroMsg.TextStatus.TextStatusUserNameMapStorage", (kotlin.g.a.a)new h.d(paramas2, paramArrayOfByte));
          }
          if ((paramcyb.TGz == 2) && (paramas1 != null) && (paramas1.axZ())) {
            break label154;
          }
          AppMethodBeat.o(233266);
          return;
          i = 0;
          break;
        }
        label154:
        paramas2 = paramcyb.SjU;
        paramcyb = paramcyb.SjW;
        Log.i("MicroMsg.TextStatus.PluginTextStatus", "afterContactUpdate, statusID: " + paramas2 + ", extInfo: " + paramcyb);
        paramArrayOfByte = (CharSequence)paramas2;
        if ((paramArrayOfByte == null) || (paramArrayOfByte.length() == 0))
        {
          i = 1;
          if (i != 0) {
            break label344;
          }
          paramArrayOfByte = (CharSequence)paramcyb;
          if ((paramArrayOfByte != null) && (paramArrayOfByte.length() != 0)) {
            break label312;
          }
        }
        label312:
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label344;
          }
          paramArrayOfByte = new TextStatusExtInfo();
          try
          {
            paramArrayOfByte.parseFrom(Base64.decode(paramcyb, 0));
            paramcyb = com.tencent.mm.plugin.textstatus.b.f.MAm;
            paramas1 = paramas1.getUsername();
            kotlin.g.b.p.j(paramas1, "newContact.username");
            com.tencent.mm.plugin.textstatus.b.f.a(paramcyb, paramas1, paramas2, paramArrayOfByte, 0, null, 24);
            AppMethodBeat.o(233266);
            return;
          }
          catch (Throwable paramas1)
          {
            Log.printErrStackTrace("MicroMsg.TextStatus.PluginTextStatus", paramas1, "afterContactUpdate err id:".concat(String.valueOf(paramas2)), new Object[0]);
            AppMethodBeat.o(233266);
            return;
          }
          i = 0;
          break;
        }
        label344:
        paramas2 = com.tencent.mm.plugin.textstatus.b.f.MAm;
        paramas2 = com.tencent.mm.plugin.textstatus.b.f.gly();
        paramas1 = paramas1.getUsername();
        kotlin.g.b.p.j(paramas1, "newContact.username");
        paramas2.bex(paramas1);
        AppMethodBeat.o(233266);
        return;
      }
      AppMethodBeat.o(233266);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    public static final d Mus;
    
    static
    {
      AppMethodBeat.i(234893);
      Mus = new d();
      AppMethodBeat.o(234893);
    }
    
    d()
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class e
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    e(com.tencent.mm.plugin.textstatus.proto.p paramp)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.PluginTextStatus
 * JD-Core Version:    0.7.0.1
 */