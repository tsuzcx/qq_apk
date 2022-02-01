package com.tencent.mm.plugin.textstatus;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.a.cx;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.mmdata.rpt.pq;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.sns.c.q;
import com.tencent.mm.plugin.textstatus.a.a.b;
import com.tencent.mm.plugin.textstatus.a.a.c;
import com.tencent.mm.plugin.textstatus.a.ac;
import com.tencent.mm.plugin.textstatus.a.u;
import com.tencent.mm.plugin.textstatus.a.x;
import com.tencent.mm.plugin.textstatus.h.l;
import com.tencent.mm.plugin.textstatus.h.o.b;
import com.tencent.mm.plugin.textstatus.h.o.c;
import com.tencent.mm.plugin.textstatus.h.o.d;
import com.tencent.mm.plugin.textstatus.h.o.e;
import com.tencent.mm.plugin.textstatus.proto.TextStatusTopicInfo;
import com.tencent.mm.plugin.textstatus.third.m;
import com.tencent.mm.plugin.textstatus.ui.StatusAlbumUI;
import com.tencent.mm.plugin.textstatus.ui.TextStatusLikeListActivity;
import com.tencent.mm.plugin.textstatus.ui.TextStatusLikeListActivity.a;
import com.tencent.mm.protocal.protobuf.dzc;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.vfs.af;
import com.tencent.mm.vfs.y;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.a.ak;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/PluginTextStatus;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/textstatus/api/IPluginTextStatus;", "Lcom/tencent/mm/kernel/api/bucket/ICoreAccountCallbackBucket;", "Lcom/tencent/mm/kernel/boot/parallels/IParallelsDependency;", "Lcom/tencent/mm/kernel/api/ICollectDBFactory;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/pluginsdk/oplog/IDeleteContactService$IDeleteContactResult;", "()V", "cardDialog", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mm/plugin/textstatus/ui/TextStatusCardDialog;", "getCardDialog", "()Ljava/lang/ref/WeakReference;", "setCardDialog", "(Ljava/lang/ref/WeakReference;)V", "configUpdateListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/ConfigUpdatedEvent;", "getConfigUpdateListener", "()Lcom/tencent/mm/sdk/event/IListener;", "hasGetUserPermission", "", "messageStorage", "Lcom/tencent/mm/plugin/textstatus/conversation/storage/TextStatusMessageStorage;", "getMessageStorage", "()Lcom/tencent/mm/plugin/textstatus/conversation/storage/TextStatusMessageStorage;", "messageStorage$delegate", "Lkotlin/Lazy;", "privateMsgConfig", "Lcom/tencent/mm/plugin/textstatus/conversation/config/TextStatusPrivateMsgConfig;", "getPrivateMsgConfig", "()Lcom/tencent/mm/plugin/textstatus/conversation/config/TextStatusPrivateMsgConfig;", "privateMsgConfig$delegate", "attachTextStatusSpanSync", "", "textView", "Landroid/widget/TextView;", "userName", "", "displayName", "iconScene", "Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconScene;", "size", "", "clearTextStatus", "", "collectDatabaseFactory", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/storagebase/SqliteDB$IFactory;", "configure", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "doGetBrandResult", "Lcom/tencent/mm/plugin/textstatus/api/IGetBrandTask;", "context", "Landroid/app/Activity;", "url", "scanSource", "notifyFinishCallback", "Ljava/lang/Runnable;", "execSQL", "sql", "execute", "getBackPreview", "Lcom/tencent/mm/plugin/textstatus/api/IBackPreview;", "Landroid/content/Context;", "pullDownViewCloseRunnable", "isPreviewVideo", "getHistoryFragment", "Lcom/tencent/mm/ui/MMFragment;", "bundle", "Landroid/os/Bundle;", "getMoreTabCardView", "Lcom/tencent/mm/plugin/textstatus/api/IProfileCardView;", "rootLayout", "Landroid/widget/RelativeLayout;", "headerRoot", "Landroid/widget/LinearLayout;", "getProfileCardView", "headRoot", "extraPadding", "getResVersion", "", "getStatusCardView", "Lcom/tencent/mm/plugin/textstatus/api/IStatusCardView;", "showParam", "Lcom/tencent/mm/plugin/textstatus/api/StatusShowParam;", "username", "getStrangerInfos", "Lorg/json/JSONObject;", "data", "getTextStatusIconId", "getTextStatusId", "getTextStatusSpanSync", "Landroid/text/style/ImageSpan;", "getVerifyInfoForWeRun", "iconId", "source", "callback", "Lcom/tencent/mm/plugin/textstatus/api/IPluginTextStatus$ReqVerifyInfoCallback;", "goLikeListFromSelfHistory", "goUnReadMsgPage", "contex", "hasStatus", "hideCardDialog", "isHasStatusThumb", "isInTagList", "isSpanSwitchOpen", "scene", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "onDeleteContact", "ret", "oplogErrMsg", "Lcom/tencent/mm/protocal/protobuf/OplogErrMsg;", "onSceneEnd", "errType", "errCode", "errMsg", "Lcom/tencent/mm/modelbase/NetSceneBase;", "openTextStateChatting", "reqJo", "parallelsDependency", "report22208", "action", "actionResult", "report22210", "setIcon", "iv", "Landroid/widget/ImageView;", "iconType", "Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconType;", "iconColor", "Lcom/tencent/mm/plugin/textstatus/api/ConstantsTextStatus$IconColor;", "setTextStatusDrawable", "imageView", "setTextStatusWithDesc", "setTextWithStatus", "Lcom/tencent/mm/ui/base/NoMeasuredTextView;", "showCardDialog", "activity", "showStatusDetail", "showStatusPlanet", "tryAttachStatusIconSpan", "v", "Landroid/view/View;", "content", "Companion", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PluginTextStatus
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.am.h, com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.a, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.textstatus.a.f, com.tencent.mm.pluginsdk.i.a.a
{
  public static final PluginTextStatus.a Tbs;
  private static String Tbw;
  private final kotlin.j Asq;
  private final IListener<cx> JFS;
  private final kotlin.j Tbu;
  private boolean Tbv;
  private WeakReference<com.tencent.mm.plugin.textstatus.ui.i> akjl;
  
  static
  {
    AppMethodBeat.i(289744);
    Tbs = new PluginTextStatus.a((byte)0);
    Tbw = "";
    AppMethodBeat.o(289744);
  }
  
  public PluginTextStatus()
  {
    AppMethodBeat.i(289690);
    this.Asq = kotlin.k.cm((kotlin.g.a.a)PluginTextStatus.i.TbC);
    this.Tbu = kotlin.k.cm((kotlin.g.a.a)PluginTextStatus.d.Tbz);
    this.JFS = ((IListener)new PluginTextStatus.configUpdateListener.1(com.tencent.mm.app.f.hfK));
    AppMethodBeat.o(289690);
  }
  
  private static final String[] collectDatabaseFactory$lambda-0()
  {
    AppMethodBeat.i(289717);
    Object localObject = com.tencent.mm.plugin.textstatus.conversation.h.c.TjG;
    kotlin.g.b.s.u("textstatusmessage", "table");
    localObject = com.tencent.mm.plugin.byp.b.wag;
    localObject = MAutoStorage.getCreateSQLs(com.tencent.mm.plugin.byp.b.access$getInfo$cp(), "textstatusmessage");
    kotlin.g.b.s.s(localObject, "getCreateSQLs(BypMsgInfo.info, table)");
    String str1 = "CREATE INDEX IF NOT EXISTS  " + "textstatusmessage" + "SvrIdIndex ON " + "textstatusmessage" + " ( msgSvrId )";
    String str2 = "CREATE INDEX IF NOT EXISTS  " + "textstatusmessage" + "TalkerIndex ON " + "textstatusmessage" + " ( talker )";
    String str3 = "CREATE INDEX IF NOT EXISTS  " + "textstatusmessage" + "TalkerStatusIndex ON " + "textstatusmessage" + " ( talker,status )";
    String str4 = "CREATE INDEX IF NOT EXISTS  " + "textstatusmessage" + "CreateTimeIndex ON " + "textstatusmessage" + " ( createTime )";
    String str5 = "CREATE INDEX IF NOT EXISTS  " + "textstatusmessage" + "CreateTalkerTimeIndex ON " + "textstatusmessage" + " ( talker,createTime )";
    String str6 = "CREATE INDEX IF NOT EXISTS  " + "textstatusmessage" + "SendCreateTimeIndex ON " + "textstatusmessage" + " ( status,isSend,createTime )";
    String str7 = "CREATE INDEX IF NOT EXISTS  " + "textstatusmessage" + "TalkerTypeIndex ON " + "textstatusmessage" + " ( talker,type )";
    AppMethodBeat.o(289717);
    return new String[] { localObject, str1, str2, str3, str4, str5, str6, str7 };
  }
  
  private final com.tencent.mm.plugin.textstatus.conversation.c.a getPrivateMsgConfig()
  {
    AppMethodBeat.i(289701);
    com.tencent.mm.plugin.textstatus.conversation.c.a locala = (com.tencent.mm.plugin.textstatus.conversation.c.a)this.Asq.getValue();
    AppMethodBeat.o(289701);
    return locala;
  }
  
  private static final void getVerifyInfoForWeRun$lambda-5$lambda-4(com.tencent.mm.plugin.textstatus.h.c paramc, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(289725);
    kotlin.g.b.s.u(paramc, "$scene");
    com.tencent.mm.kernel.h.aZW().a((p)paramc);
    AppMethodBeat.o(289725);
  }
  
  private final boolean isInTagList(String paramString)
  {
    AppMethodBeat.i(289708);
    if (q.Qkl != null)
    {
      boolean bool = q.Qkl.aRZ(paramString);
      AppMethodBeat.o(289708);
      return bool;
    }
    AppMethodBeat.o(289708);
    return false;
  }
  
  private final boolean isSpanSwitchOpen(a.b paramb, String paramString)
  {
    AppMethodBeat.i(289696);
    boolean bool;
    switch (b.$EnumSwitchMapping$0[paramb.ordinal()])
    {
    default: 
      AppMethodBeat.o(289696);
      return false;
    case 1: 
      bool = ac.hFS();
      AppMethodBeat.o(289696);
      return bool;
    case 2: 
      bool = ac.hGb();
      AppMethodBeat.o(289696);
      return bool;
    case 3: 
      bool = ac.hGc();
      AppMethodBeat.o(289696);
      return bool;
    case 4: 
      if (ac.hGe())
      {
        paramb = com.tencent.mm.plugin.textstatus.b.f.TjQ;
        paramb = com.tencent.mm.plugin.textstatus.b.f.bdN(paramString);
        if (paramb == null) {}
        for (paramb = null;; paramb = paramb.field_IconID)
        {
          bool = kotlin.g.b.s.p(paramb, "2021");
          AppMethodBeat.o(289696);
          return bool;
        }
      }
      bool = ac.hGd();
      AppMethodBeat.o(289696);
      return bool;
    case 5: 
      bool = ac.hGf();
      AppMethodBeat.o(289696);
      return bool;
    case 6: 
      bool = ac.hGg();
      AppMethodBeat.o(289696);
      return bool;
    case 7: 
      bool = ac.hFU();
      AppMethodBeat.o(289696);
      return bool;
    case 8: 
    case 9: 
      AppMethodBeat.o(289696);
      return true;
    }
    AppMethodBeat.o(289696);
    return true;
  }
  
  public final CharSequence attachTextStatusSpanSync(TextView paramTextView, String paramString, CharSequence paramCharSequence, a.b paramb, float paramFloat)
  {
    AppMethodBeat.i(290043);
    kotlin.g.b.s.u(paramb, "iconScene");
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
      AppMethodBeat.o(290043);
      return paramCharSequence;
      i = 0;
      break;
    }
    label84:
    if (!isSpanSwitchOpen(paramb, paramString))
    {
      AppMethodBeat.o(290043);
      return paramCharSequence;
    }
    paramTextView = getTextStatusSpanSync(paramTextView, paramString, paramb, paramFloat);
    if (paramTextView != null)
    {
      paramString = new SpannableStringBuilder(paramCharSequence);
      paramString.append((CharSequence)" ");
      paramString.setSpan(paramTextView, paramString.length() - 1, paramString.length(), 34);
      paramTextView = (CharSequence)paramString;
      AppMethodBeat.o(290043);
      return paramTextView;
    }
    AppMethodBeat.o(290043);
    return paramCharSequence;
  }
  
  public final void clearTextStatus(TextView paramTextView, String paramString)
  {
    AppMethodBeat.i(289987);
    if (paramTextView != null)
    {
      localObject = (CharSequence)paramString;
      if ((localObject != null) && (!kotlin.n.n.bp((CharSequence)localObject))) {
        break label42;
      }
    }
    label42:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(289987);
      return;
    }
    Object localObject = com.tencent.mm.plugin.textstatus.h.o.Tna;
    com.tencent.mm.plugin.textstatus.h.o.N(paramString, paramTextView);
    AppMethodBeat.o(289987);
  }
  
  public final HashMap<Integer, h.b> collectDatabaseFactory()
  {
    AppMethodBeat.i(290056);
    HashMap localHashMap = ak.g(new kotlin.r[] { kotlin.v.Y(Integer.valueOf("textstatusmessage".hashCode()), PluginTextStatus..ExternalSyntheticLambda1.INSTANCE) });
    AppMethodBeat.o(290056);
    return localHashMap;
  }
  
  public final void configure(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(290061);
    if ((paramg != null) && (paramg.bbA()))
    {
      af.b("textstatusCache", "textstatus", 536870912L, 7776000000L, 1);
      af.aR("textstatusPersist", "textstatus", 6);
    }
    AppMethodBeat.o(290061);
  }
  
  public final com.tencent.mm.plugin.textstatus.a.c doGetBrandResult(Activity paramActivity, String paramString, int paramInt, Runnable paramRunnable)
  {
    AppMethodBeat.i(290120);
    kotlin.g.b.s.u(paramActivity, "context");
    paramActivity = new com.tencent.mm.plugin.textstatus.third.c(paramActivity, paramString, paramInt, paramRunnable);
    paramString = new com.tencent.mm.plugin.textstatus.h.d(paramActivity.url);
    paramRunnable = new com.tencent.mm.plugin.textstatus.f.g((com.tencent.mm.am.h)paramActivity);
    com.tencent.mm.kernel.h.aZW().a(paramString.getType(), (com.tencent.mm.am.h)paramRunnable);
    paramActivity.TuJ = paramRunnable;
    com.tencent.mm.kernel.h.aZW().a((p)paramString, 0);
    paramActivity.TuI = new WeakReference(paramString);
    paramActivity = (com.tencent.mm.plugin.textstatus.a.c)paramActivity;
    AppMethodBeat.o(290120);
    return paramActivity;
  }
  
  /* Error */
  public final void execSQL(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 10
    //   6: ldc_w 600
    //   9: invokestatic 200	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   12: getstatic 424	com/tencent/mm/plugin/textstatus/b/f:TjQ	Lcom/tencent/mm/plugin/textstatus/b/f;
    //   15: astore 7
    //   17: invokestatic 604	com/tencent/mm/plugin/textstatus/b/f:getDataDB	()Lcom/tencent/mm/storagebase/h;
    //   20: invokevirtual 610	com/tencent/mm/storagebase/h:jef	()Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   23: astore 9
    //   25: aload 8
    //   27: astore 7
    //   29: invokestatic 616	java/lang/System:currentTimeMillis	()J
    //   32: lstore 5
    //   34: aload 8
    //   36: astore 7
    //   38: aload 9
    //   40: getstatic 622	com/tencent/wcdb/database/SQLiteDirectCursor:FACTORY	Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;
    //   43: aload_1
    //   44: aconst_null
    //   45: aconst_null
    //   46: invokevirtual 628	com/tencent/wcdb/database/SQLiteDatabase:rawQueryWithFactory	(Lcom/tencent/wcdb/database/SQLiteDatabase$CursorFactory;Ljava/lang/String;[Ljava/lang/Object;Ljava/lang/String;)Lcom/tencent/wcdb/Cursor;
    //   49: checkcast 630	android/database/Cursor
    //   52: astore 8
    //   54: aload 8
    //   56: checkcast 632	com/tencent/wcdb/Cursor
    //   59: invokeinterface 635 1 0
    //   64: astore 7
    //   66: aload 7
    //   68: ifnonnull +240 -> 308
    //   71: iconst_0
    //   72: istore_2
    //   73: ldc_w 637
    //   76: ldc_w 639
    //   79: aload_1
    //   80: invokestatic 643	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   83: invokestatic 648	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   86: iload_2
    //   87: ifle +35 -> 122
    //   90: ldc_w 650
    //   93: checkcast 456	java/lang/CharSequence
    //   96: astore 9
    //   98: aload 7
    //   100: invokestatic 653	kotlin/g/b/s:checkNotNull	(Ljava/lang/Object;)V
    //   103: ldc_w 637
    //   106: ldc_w 655
    //   109: aload 9
    //   111: aload 7
    //   113: invokestatic 661	android/text/TextUtils:join	(Ljava/lang/CharSequence;[Ljava/lang/Object;)Ljava/lang/String;
    //   116: invokestatic 643	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   119: invokestatic 648	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   122: new 310	java/lang/StringBuilder
    //   125: dup
    //   126: sipush 1024
    //   129: invokespecial 663	java/lang/StringBuilder:<init>	(I)V
    //   132: astore 7
    //   134: aload 8
    //   136: checkcast 632	com/tencent/wcdb/Cursor
    //   139: invokeinterface 666 1 0
    //   144: ifeq +220 -> 364
    //   147: aload 7
    //   149: iconst_0
    //   150: invokevirtual 669	java/lang/StringBuilder:setLength	(I)V
    //   153: aload 7
    //   155: ldc_w 655
    //   158: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: iload_2
    //   163: ifle +81 -> 244
    //   166: iconst_0
    //   167: istore_3
    //   168: iload_3
    //   169: iconst_1
    //   170: iadd
    //   171: istore 4
    //   173: aload 8
    //   175: checkcast 632	com/tencent/wcdb/Cursor
    //   178: iload_3
    //   179: invokeinterface 672 2 0
    //   184: lookupswitch	default:+247->431, 0:+131->315, 4:+168->352
    //   213: iconst_4
    //   214: aload 8
    //   216: checkcast 632	com/tencent/wcdb/Cursor
    //   219: iload_3
    //   220: invokeinterface 676 2 0
    //   225: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   228: pop
    //   229: aload 7
    //   231: ldc_w 650
    //   234: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: pop
    //   238: iload 4
    //   240: iload_2
    //   241: if_icmplt +184 -> 425
    //   244: ldc_w 637
    //   247: aload 7
    //   249: invokevirtual 325	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: invokestatic 648	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   255: goto -121 -> 134
    //   258: astore 9
    //   260: aload 8
    //   262: astore 7
    //   264: ldc_w 637
    //   267: ldc_w 678
    //   270: iconst_2
    //   271: anewarray 680	java/lang/Object
    //   274: dup
    //   275: iconst_0
    //   276: aload_1
    //   277: aastore
    //   278: dup
    //   279: iconst_1
    //   280: aload 9
    //   282: invokevirtual 683	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   285: aastore
    //   286: invokestatic 687	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   289: aload 8
    //   291: ifnull +10 -> 301
    //   294: aload 8
    //   296: invokeinterface 690 1 0
    //   301: ldc_w 600
    //   304: invokestatic 206	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   307: return
    //   308: aload 7
    //   310: arraylength
    //   311: istore_2
    //   312: goto -239 -> 73
    //   315: aload 7
    //   317: ldc_w 692
    //   320: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   323: pop
    //   324: goto -95 -> 229
    //   327: astore_1
    //   328: aload 8
    //   330: astore 7
    //   332: aload 7
    //   334: ifnull +10 -> 344
    //   337: aload 7
    //   339: invokeinterface 690 1 0
    //   344: ldc_w 600
    //   347: invokestatic 206	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   350: aload_1
    //   351: athrow
    //   352: aload 7
    //   354: ldc_w 694
    //   357: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: pop
    //   361: goto -132 -> 229
    //   364: ldc_w 637
    //   367: ldc_w 696
    //   370: iconst_2
    //   371: anewarray 680	java/lang/Object
    //   374: dup
    //   375: iconst_0
    //   376: invokestatic 616	java/lang/System:currentTimeMillis	()J
    //   379: lload 5
    //   381: lsub
    //   382: invokestatic 701	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   385: aastore
    //   386: dup
    //   387: iconst_1
    //   388: aload_1
    //   389: aastore
    //   390: invokestatic 703	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   393: aload 8
    //   395: ifnull +10 -> 405
    //   398: aload 8
    //   400: invokeinterface 690 1 0
    //   405: ldc_w 600
    //   408: invokestatic 206	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   411: return
    //   412: astore_1
    //   413: goto -81 -> 332
    //   416: astore 9
    //   418: aload 10
    //   420: astore 8
    //   422: goto -162 -> 260
    //   425: iload 4
    //   427: istore_3
    //   428: goto -260 -> 168
    //   431: goto -219 -> 212
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	434	0	this	PluginTextStatus
    //   0	434	1	paramString	String
    //   72	240	2	i	int
    //   167	261	3	j	int
    //   171	255	4	k	int
    //   32	348	5	l	long
    //   15	338	7	localObject1	Object
    //   1	420	8	localObject2	Object
    //   23	87	9	localObject3	Object
    //   258	23	9	localRuntimeException1	java.lang.RuntimeException
    //   416	1	9	localRuntimeException2	java.lang.RuntimeException
    //   4	415	10	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   54	66	258	java/lang/RuntimeException
    //   73	86	258	java/lang/RuntimeException
    //   90	122	258	java/lang/RuntimeException
    //   122	134	258	java/lang/RuntimeException
    //   134	162	258	java/lang/RuntimeException
    //   173	212	258	java/lang/RuntimeException
    //   212	229	258	java/lang/RuntimeException
    //   229	238	258	java/lang/RuntimeException
    //   244	255	258	java/lang/RuntimeException
    //   308	312	258	java/lang/RuntimeException
    //   315	324	258	java/lang/RuntimeException
    //   352	361	258	java/lang/RuntimeException
    //   364	393	258	java/lang/RuntimeException
    //   54	66	327	finally
    //   73	86	327	finally
    //   90	122	327	finally
    //   122	134	327	finally
    //   134	162	327	finally
    //   173	212	327	finally
    //   212	229	327	finally
    //   229	238	327	finally
    //   244	255	327	finally
    //   308	312	327	finally
    //   315	324	327	finally
    //   352	361	327	finally
    //   364	393	327	finally
    //   29	34	412	finally
    //   38	54	412	finally
    //   264	289	412	finally
    //   29	34	416	java/lang/RuntimeException
    //   38	54	416	java/lang/RuntimeException
  }
  
  public final void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(290051);
    kotlin.g.b.s.u(paramg, "profile");
    if (paramg.bbA())
    {
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.textstatus.a.n.class, (com.tencent.mm.kernel.c.a)new com.tencent.mm.plugin.textstatus.h.n());
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.textstatus.a.t.class, (com.tencent.mm.kernel.c.a)new com.tencent.mm.plugin.textstatus.conversation.g.f());
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.textstatus.a.r.class, (com.tencent.mm.kernel.c.a)com.tencent.mm.plugin.textstatus.conversation.g.a.Tjq);
      com.tencent.mm.kernel.h.b(com.tencent.mm.plugin.textstatus.a.s.class, (com.tencent.mm.kernel.c.a)com.tencent.mm.plugin.textstatus.conversation.g.b.Tjv);
      com.tencent.mm.kernel.h.b(u.class, (com.tencent.mm.kernel.c.a)com.tencent.mm.plugin.textstatus.i.e.Tru);
    }
    AppMethodBeat.o(290051);
  }
  
  public final com.tencent.mm.plugin.textstatus.a.b getBackPreview(Context paramContext, Runnable paramRunnable, boolean paramBoolean)
  {
    AppMethodBeat.i(289890);
    kotlin.g.b.s.u(paramContext, "context");
    paramContext = (com.tencent.mm.plugin.textstatus.a.b)new com.tencent.mm.plugin.textstatus.ui.a(paramContext, paramRunnable, paramBoolean);
    AppMethodBeat.o(289890);
    return paramContext;
  }
  
  public final WeakReference<com.tencent.mm.plugin.textstatus.ui.i> getCardDialog()
  {
    return this.akjl;
  }
  
  public final IListener<cx> getConfigUpdateListener()
  {
    return this.JFS;
  }
  
  public final MMFragment getHistoryFragment(Context paramContext, Bundle paramBundle)
  {
    AppMethodBeat.i(289999);
    kotlin.g.b.s.u(paramContext, "context");
    paramContext = (MMFragment)Fragment.instantiate(paramContext, StatusAlbumUI.class.getName(), paramBundle);
    AppMethodBeat.o(289999);
    return paramContext;
  }
  
  public final com.tencent.mm.plugin.textstatus.conversation.h.c getMessageStorage()
  {
    AppMethodBeat.i(290080);
    com.tencent.mm.plugin.textstatus.conversation.h.c localc = (com.tencent.mm.plugin.textstatus.conversation.h.c)this.Tbu.getValue();
    AppMethodBeat.o(290080);
    return localc;
  }
  
  public final com.tencent.mm.plugin.textstatus.a.g getMoreTabCardView(Context paramContext, RelativeLayout paramRelativeLayout, LinearLayout paramLinearLayout)
  {
    AppMethodBeat.i(289910);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramLinearLayout, "headerRoot");
    paramContext = (com.tencent.mm.plugin.textstatus.a.g)new com.tencent.mm.plugin.textstatus.ui.e(paramContext, paramRelativeLayout, paramLinearLayout);
    AppMethodBeat.o(289910);
    return paramContext;
  }
  
  public final com.tencent.mm.plugin.textstatus.a.g getProfileCardView(Context paramContext, RelativeLayout paramRelativeLayout, LinearLayout paramLinearLayout, int paramInt)
  {
    AppMethodBeat.i(289902);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramRelativeLayout, "rootLayout");
    kotlin.g.b.s.u(paramLinearLayout, "headRoot");
    paramContext = (com.tencent.mm.plugin.textstatus.a.g)new com.tencent.mm.plugin.textstatus.ui.g(paramContext, paramRelativeLayout, paramLinearLayout, paramInt);
    AppMethodBeat.o(289902);
    return paramContext;
  }
  
  public final long getResVersion()
  {
    AppMethodBeat.i(290175);
    long l = com.tencent.mm.plugin.textstatus.util.b.hKh().getResVersion();
    AppMethodBeat.o(290175);
    return l;
  }
  
  public final com.tencent.mm.plugin.textstatus.a.j getStatusCardView(Context paramContext)
  {
    AppMethodBeat.i(289854);
    kotlin.g.b.s.u(paramContext, "context");
    x localx = x.hFI();
    kotlin.g.b.s.s(localx, "def()");
    paramContext = getStatusCardView(paramContext, localx);
    AppMethodBeat.o(289854);
    return paramContext;
  }
  
  public final com.tencent.mm.plugin.textstatus.a.j getStatusCardView(Context paramContext, x paramx)
  {
    AppMethodBeat.i(289865);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramx, "showParam");
    paramContext = (com.tencent.mm.plugin.textstatus.a.j)new com.tencent.mm.plugin.textstatus.ui.h(paramContext, paramx);
    AppMethodBeat.o(289865);
    return paramContext;
  }
  
  public final com.tencent.mm.plugin.textstatus.a.j getStatusCardView(Context paramContext, String paramString)
  {
    AppMethodBeat.i(289877);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramString, "username");
    paramContext = new com.tencent.mm.plugin.textstatus.ui.h(paramContext);
    paramContext.Ds(paramString);
    paramContext = (com.tencent.mm.plugin.textstatus.a.j)paramContext;
    AppMethodBeat.o(289877);
    return paramContext;
  }
  
  public final JSONObject getStrangerInfos(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(290202);
    JSONObject localJSONObject1 = new JSONObject();
    if (paramJSONObject == null) {}
    for (paramJSONObject = null;; paramJSONObject = paramJSONObject.optJSONArray("arrStrangerContact"))
    {
      if (paramJSONObject != null) {}
      try
      {
        localJSONArray = new JSONArray();
        str2 = com.tencent.mm.plugin.auth.a.a.cUx();
        i = 0;
        k = paramJSONObject.length();
        if (k <= 0) {
          break label287;
        }
      }
      finally
      {
        int i;
        int j;
        for (;;)
        {
          JSONArray localJSONArray;
          String str2;
          int k;
          Object localObject1;
          String str3;
          JSONObject localJSONObject2;
        }
      }
      j = i + 1;
      localObject1 = paramJSONObject.optString(i);
      str3 = ((com.tencent.mm.plugin.hashinfo.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.hashinfo.a.a.class)).getUserNameByHash((String)localObject1, 1);
      localJSONObject2 = new JSONObject();
      try
      {
        localJSONObject2.put("hashName", localObject1);
        JSONObject localJSONObject3 = new JSONObject();
        if (str3 != null)
        {
          String str1 = aa.getDisplayName(str3);
          localObject1 = str1;
          if (kotlin.g.b.s.p(str1, str3)) {
            localObject1 = "";
          }
          localJSONObject3.put("name", localObject1);
          localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(str3);
          if ((com.tencent.mm.contact.d.rs(((az)localObject1).field_type)) && (!((au)localObject1).aSF()) && (!((au)localObject1).aSN()) && (!isInTagList(str3)))
          {
            localObject1 = com.tencent.mm.plugin.textstatus.b.f.TjQ;
            localObject1 = com.tencent.mm.plugin.textstatus.b.f.bdN(str3);
            if (localObject1 != null)
            {
              localJSONObject3.put("statusId", ((com.tencent.mm.plugin.textstatus.h.f.b)localObject1).field_StatusID);
              if (kotlin.g.b.s.p(str2, str3)) {
                localJSONObject3.put("isSelf", true);
              }
            }
          }
        }
        localJSONObject2.put("info", localJSONObject3);
      }
      finally
      {
        label273:
        break label273;
        i = j;
      }
      localJSONArray.put(localJSONObject2);
      if (j < k) {
        break;
      }
      label287:
      localJSONObject1.put("arrFriendContact", localJSONArray);
      AppMethodBeat.o(290202);
      return localJSONObject1;
    }
  }
  
  public final String getTextStatusIconId(String paramString)
  {
    AppMethodBeat.i(289801);
    com.tencent.mm.plugin.textstatus.b.f localf = com.tencent.mm.plugin.textstatus.b.f.TjQ;
    paramString = com.tencent.mm.plugin.textstatus.b.f.bdN(paramString);
    if (paramString == null)
    {
      AppMethodBeat.o(289801);
      return "";
    }
    paramString = paramString.field_IconID;
    if (paramString == null)
    {
      AppMethodBeat.o(289801);
      return "";
    }
    AppMethodBeat.o(289801);
    return paramString;
  }
  
  public final String getTextStatusId(String paramString)
  {
    AppMethodBeat.i(289792);
    Object localObject = (CharSequence)paramString;
    int i;
    if ((localObject == null) || (kotlin.n.n.bp((CharSequence)localObject)))
    {
      i = 1;
      if (i == 0) {
        break label48;
      }
    }
    for (paramString = null;; paramString = com.tencent.mm.plugin.textstatus.b.f.bdN(paramString))
    {
      if (paramString != null) {
        break label60;
      }
      AppMethodBeat.o(289792);
      return "";
      i = 0;
      break;
      label48:
      localObject = com.tencent.mm.plugin.textstatus.b.f.TjQ;
    }
    label60:
    paramString = paramString.field_StatusID;
    if (paramString == null)
    {
      AppMethodBeat.o(289792);
      return "";
    }
    AppMethodBeat.o(289792);
    return paramString;
  }
  
  public final ImageSpan getTextStatusSpanSync(TextView paramTextView, String paramString, a.b paramb, float paramFloat)
  {
    AppMethodBeat.i(290033);
    kotlin.g.b.s.u(paramb, "iconScene");
    Object localObject1 = (CharSequence)paramString;
    if ((localObject1 == null) || (kotlin.n.n.bp((CharSequence)localObject1))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(290033);
      return null;
    }
    if (!isSpanSwitchOpen(paramb, paramString))
    {
      AppMethodBeat.o(290033);
      return null;
    }
    localObject1 = com.tencent.mm.plugin.textstatus.util.b.hKh();
    int j = (int)paramFloat;
    Object localObject2 = com.tencent.mm.plugin.textstatus.b.f.TjQ;
    localObject2 = com.tencent.mm.plugin.textstatus.b.f.bdN(paramString);
    if (localObject2 != null)
    {
      if (paramb == null)
      {
        i = -1;
        switch (i)
        {
        default: 
          if (((com.tencent.mm.plugin.textstatus.h.f.b)localObject2).hHF()) {
            paramString = com.tencent.mm.plugin.textstatus.a.a.a.Thw;
          }
          break;
        }
      }
      for (;;)
      {
        paramTextView = ((com.tencent.mm.plugin.textstatus.util.a)localObject1).a((View)paramTextView, ((com.tencent.mm.plugin.textstatus.h.f.b)localObject2).field_IconID, a.c.ThP, paramString, paramb, j, (com.tencent.mm.plugin.textstatus.h.f.b)localObject2);
        AppMethodBeat.o(290033);
        return paramTextView;
        i = com.tencent.mm.plugin.textstatus.util.a.b.avM[paramb.ordinal()];
        break;
        paramString = com.tencent.mm.plugin.textstatus.a.a.a.Thy;
        continue;
        paramString = com.tencent.mm.plugin.textstatus.a.a.a.Thz;
        continue;
        paramString = com.tencent.mm.plugin.textstatus.a.a.a.Thr;
      }
    }
    AppMethodBeat.o(290033);
    return null;
  }
  
  public final void getVerifyInfoForWeRun(String paramString, int paramInt, Context paramContext, com.tencent.mm.plugin.textstatus.a.f.a parama)
  {
    AppMethodBeat.i(290224);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(parama, "callback");
    if (paramString != null)
    {
      paramString = new com.tencent.mm.plugin.textstatus.h.c(paramString, paramInt);
      paramContext.getString(a.h.app_loading);
      paramContext = com.tencent.mm.ui.base.k.a(paramContext, 3, paramContext.getString(a.h.app_loading), true, new PluginTextStatus..ExternalSyntheticLambda0(paramString));
      kotlin.g.b.s.s(paramContext, "showProgressDlg(context,…ncel(scene)\n            }");
      com.tencent.mm.am.s locals = com.tencent.mm.kernel.h.aZW();
      kotlin.g.b.s.s(locals, "getNetSceneQueue()");
      com.tencent.mm.plugin.textstatus.conversation.e.a.a(locals, (p)paramString, null, (com.tencent.mm.am.h)new PluginTextStatus.c(paramString, parama, paramContext));
    }
    AppMethodBeat.o(290224);
  }
  
  public final void goLikeListFromSelfHistory(Context paramContext)
  {
    AppMethodBeat.i(290007);
    kotlin.g.b.s.u(paramContext, "context");
    Object localObject = TextStatusLikeListActivity.Tzn;
    kotlin.g.b.s.u(paramContext, "context");
    localObject = new Intent(paramContext, TextStatusLikeListActivity.class);
    ((Intent)localObject).putExtra("scene", 2);
    ((Intent)localObject).putExtra("reportEnterScene", 8);
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(paramContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$Companion", "startForSelfAllHistory", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/textstatus/ui/TextStatusLikeListActivity$Companion", "startForSelfAllHistory", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(290007);
  }
  
  public final void goUnReadMsgPage(Context paramContext)
  {
    AppMethodBeat.i(289915);
    if (paramContext == null)
    {
      AppMethodBeat.o(289915);
      return;
    }
    TextStatusLikeListActivity.a locala = TextStatusLikeListActivity.Tzn;
    TextStatusLikeListActivity.a.ba(paramContext, -1);
    AppMethodBeat.o(289915);
  }
  
  public final boolean hasStatus(String paramString)
  {
    AppMethodBeat.i(289778);
    if (!ac.hFS())
    {
      AppMethodBeat.o(289778);
      return false;
    }
    Object localObject = (CharSequence)paramString;
    int i;
    if ((localObject == null) || (kotlin.n.n.bp((CharSequence)localObject)))
    {
      i = 1;
      if (i == 0) {
        break label61;
      }
    }
    for (paramString = null;; paramString = com.tencent.mm.plugin.textstatus.b.f.bdN(paramString))
    {
      if (paramString == null) {
        break label73;
      }
      AppMethodBeat.o(289778);
      return true;
      i = 0;
      break;
      label61:
      localObject = com.tencent.mm.plugin.textstatus.b.f.TjQ;
    }
    label73:
    AppMethodBeat.o(289778);
    return false;
  }
  
  public final void hideCardDialog()
  {
    AppMethodBeat.i(289831);
    Object localObject = this.akjl;
    if (localObject != null)
    {
      localObject = (com.tencent.mm.plugin.textstatus.ui.i)((WeakReference)localObject).get();
      if (localObject != null) {
        ((com.tencent.mm.plugin.textstatus.ui.i)localObject).dismiss();
      }
    }
    AppMethodBeat.o(289831);
  }
  
  public final boolean isHasStatusThumb(String paramString)
  {
    AppMethodBeat.i(289992);
    Object localObject1 = com.tencent.mm.plugin.textstatus.util.e.TAU;
    kotlin.g.b.s.checkNotNull(paramString);
    if (y.ZC(com.tencent.mm.plugin.textstatus.util.e.nl("thumb", paramString)))
    {
      AppMethodBeat.o(289992);
      return true;
    }
    localObject1 = com.tencent.mm.plugin.textstatus.b.f.TjQ;
    localObject1 = com.tencent.mm.plugin.textstatus.b.f.bdN(paramString);
    Object localObject2;
    if (localObject1 == null)
    {
      paramString = null;
      if (paramString == null) {
        break label118;
      }
      localObject2 = (CharSequence)paramString.sourceId;
      if ((localObject2 != null) && (!kotlin.n.n.bp((CharSequence)localObject2))) {
        break label113;
      }
    }
    label113:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        break label118;
      }
      localObject2 = com.tencent.mm.plugin.textstatus.third.i.TuX;
      if (com.tencent.mm.plugin.textstatus.third.i.bec(com.tencent.mm.plugin.textstatus.b.b.c.b(paramString)) == null) {
        break label118;
      }
      AppMethodBeat.o(289992);
      return true;
      paramString = com.tencent.mm.plugin.textstatus.h.f.b.b((com.tencent.mm.plugin.textstatus.h.f.b)localObject1);
      break;
    }
    label118:
    if ((localObject1 != null) && (!TextUtils.isEmpty((CharSequence)((com.tencent.mm.plugin.textstatus.h.f.b)localObject1).field_MediaThumbUrl)))
    {
      AppMethodBeat.o(289992);
      return true;
    }
    AppMethodBeat.o(289992);
    return false;
  }
  
  public final void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(290073);
    kotlin.g.b.s.u(paramc, "upgrade");
    Log.i("MicroMsg.TextStatus.PluginTextStatus", "onAccountInitialized");
    ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().a("modtextstatus", (com.tencent.mm.plugin.messenger.foundation.a.t)com.tencent.mm.plugin.textstatus.b.f.TjQ);
    ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().a("textstatuslike", (com.tencent.mm.plugin.messenger.foundation.a.t)com.tencent.mm.plugin.textstatus.b.f.TjQ);
    ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().a("textstatusreference", (com.tencent.mm.plugin.messenger.foundation.a.t)com.tencent.mm.plugin.textstatus.b.f.TjQ);
    ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().a("textstatusiconconfigrefresh", (com.tencent.mm.plugin.messenger.foundation.a.t)com.tencent.mm.plugin.textstatus.b.f.TjQ);
    com.tencent.mm.kernel.h.aZW().a(302, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.aZW().a(4255, (com.tencent.mm.am.h)this);
    ((com.tencent.mm.plugin.messenger.foundation.a.g)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.g.class)).addContactAssembler((com.tencent.mm.plugin.messenger.foundation.a.f)new PluginTextStatus.e());
    com.tencent.mm.plugin.textstatus.h.h.c localc = com.tencent.mm.plugin.textstatus.h.h.c.Tob;
    com.tencent.mm.plugin.textstatus.h.h.c.cZW();
    if ((paramc.mDg) && (ac.hGh() == 1))
    {
      com.tencent.mm.kernel.h.aZW().a((p)new l(), 0);
      this.Tbv = true;
    }
    com.tencent.mm.ae.d.e("TextStatusThread", (kotlin.g.a.a)PluginTextStatus.f.TbA);
    ((com.tencent.mm.plugin.textstatus.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.textstatus.a.n.class)).a("7", (com.tencent.mm.plugin.textstatus.a.o)new com.tencent.mm.plugin.textstatus.third.n());
    ((com.tencent.mm.plugin.textstatus.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.textstatus.a.n.class)).a("8", (com.tencent.mm.plugin.textstatus.a.o)new com.tencent.mm.plugin.textstatus.third.b());
    ((com.tencent.mm.plugin.textstatus.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.textstatus.a.n.class)).a("9", (com.tencent.mm.plugin.textstatus.a.o)new com.tencent.mm.plugin.textstatus.third.o());
    ((com.tencent.mm.plugin.textstatus.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.textstatus.a.n.class)).a("12", (com.tencent.mm.plugin.textstatus.a.o)new m());
    ((com.tencent.mm.plugin.textstatus.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.textstatus.a.n.class)).a("11", (com.tencent.mm.plugin.textstatus.a.o)new com.tencent.mm.plugin.textstatus.third.h());
    paramc = new com.tencent.mm.plugin.textstatus.third.d();
    ((com.tencent.mm.plugin.textstatus.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.textstatus.a.n.class)).a("3", (com.tencent.mm.plugin.textstatus.a.o)paramc);
    ((com.tencent.mm.plugin.textstatus.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.textstatus.a.n.class)).a("10", (com.tencent.mm.plugin.textstatus.a.o)paramc);
    com.tencent.mm.plugin.byp.c.f.waY.a((com.tencent.mm.plugin.byp.c.e)getPrivateMsgConfig());
    ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).gaZ().a((com.tencent.mm.storage.e)getMessageStorage());
    this.JFS.alive();
    ((com.tencent.mm.pluginsdk.i.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.pluginsdk.i.a.class)).a((com.tencent.mm.pluginsdk.i.a.a)this);
    AppMethodBeat.o(290073);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(290097);
    Log.i("MicroMsg.TextStatus.PluginTextStatus", "onAccountRelease");
    com.tencent.mm.plugin.textstatus.util.b.hKh().onDestroy();
    ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().b("modtextstatus", (com.tencent.mm.plugin.messenger.foundation.a.t)com.tencent.mm.plugin.textstatus.b.f.TjQ);
    ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().b("textstatuslike", (com.tencent.mm.plugin.messenger.foundation.a.t)com.tencent.mm.plugin.textstatus.b.f.TjQ);
    ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().b("textstatusreference", (com.tencent.mm.plugin.messenger.foundation.a.t)com.tencent.mm.plugin.textstatus.b.f.TjQ);
    ((com.tencent.mm.plugin.messenger.foundation.a.v)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.messenger.foundation.a.v.class)).getSysCmdMsgExtension().b("textstatusiconconfigrefresh", (com.tencent.mm.plugin.messenger.foundation.a.t)com.tencent.mm.plugin.textstatus.b.f.TjQ);
    com.tencent.mm.kernel.h.aZW().b(302, (com.tencent.mm.am.h)this);
    com.tencent.mm.kernel.h.aZW().b(4255, (com.tencent.mm.am.h)this);
    com.tencent.mm.plugin.textstatus.b.f localf = com.tencent.mm.plugin.textstatus.b.f.TjQ;
    com.tencent.mm.plugin.textstatus.b.f.getDataDB().closeDB();
    ((com.tencent.mm.plugin.textstatus.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.textstatus.a.n.class)).bdp("7");
    ((com.tencent.mm.plugin.textstatus.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.textstatus.a.n.class)).bdp("8");
    ((com.tencent.mm.plugin.textstatus.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.textstatus.a.n.class)).bdp("3");
    ((com.tencent.mm.plugin.textstatus.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.textstatus.a.n.class)).bdp("10");
    ((com.tencent.mm.plugin.textstatus.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.textstatus.a.n.class)).bdp("9");
    ((com.tencent.mm.plugin.textstatus.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.textstatus.a.n.class)).bdp("11");
    ((com.tencent.mm.plugin.textstatus.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.textstatus.a.n.class)).bdp("12");
    ((com.tencent.mm.plugin.byp.a.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.byp.a.c.class)).removeBypSyncHandler(4);
    this.JFS.dead();
    ((com.tencent.mm.pluginsdk.i.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.pluginsdk.i.a.class)).b((com.tencent.mm.pluginsdk.i.a.a)this);
    AppMethodBeat.o(290097);
  }
  
  public final void onDeleteContact(String paramString, int paramInt, dzc paramdzc)
  {
    AppMethodBeat.i(290230);
    Log.d("MicroMsg.TextStatus.PluginTextStatus", "onDeleteContact() called with: username = " + paramString + ", ret = " + paramInt + ", oplogErrMsg = " + paramdzc);
    if (paramInt == 0)
    {
      paramdzc = (CharSequence)paramString;
      if ((paramdzc != null) && (!kotlin.n.n.bp(paramdzc))) {
        break label96;
      }
    }
    label96:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt == 0) {
        com.tencent.mm.ae.d.B((kotlin.g.a.a)new PluginTextStatus.g(paramString));
      }
      AppMethodBeat.o(290230);
      return;
    }
  }
  
  /* Error */
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    // Byte code:
    //   0: ldc_w 1329
    //   3: invokestatic 200	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload 4
    //   8: ldc_w 1029
    //   11: invokestatic 287	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   14: ldc_w 637
    //   17: new 310	java/lang/StringBuilder
    //   20: dup
    //   21: ldc_w 1331
    //   24: invokespecial 314	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   27: iload_1
    //   28: invokevirtual 1315	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   31: ldc_w 1333
    //   34: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: iload_2
    //   38: invokevirtual 1315	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   41: ldc_w 1335
    //   44: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: aload_3
    //   48: invokevirtual 1310	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   51: ldc_w 1337
    //   54: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: aload 4
    //   59: invokevirtual 1310	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 325	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokestatic 648	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   68: aload 4
    //   70: instanceof 1339
    //   73: ifeq +48 -> 121
    //   76: iload_1
    //   77: ifne +37 -> 114
    //   80: iload_2
    //   81: ifne +33 -> 114
    //   84: aload 4
    //   86: checkcast 1339	com/tencent/mm/plugin/textstatus/h/g
    //   89: getfield 1343	com/tencent/mm/plugin/textstatus/h/g:TmN	Lcom/tencent/mm/plugin/textstatus/proto/ae;
    //   92: astore_3
    //   93: aload_3
    //   94: ifnull +20 -> 114
    //   97: ldc_w 1196
    //   100: new 1345	com/tencent/mm/plugin/textstatus/PluginTextStatus$h
    //   103: dup
    //   104: aload_3
    //   105: invokespecial 1348	com/tencent/mm/plugin/textstatus/PluginTextStatus$h:<init>	(Lcom/tencent/mm/plugin/textstatus/proto/ae;)V
    //   108: checkcast 235	kotlin/g/a/a
    //   111: invokestatic 1207	com/tencent/mm/ae/d:e	(Ljava/lang/String;Lkotlin/g/a/a;)V
    //   114: ldc_w 1329
    //   117: invokestatic 206	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   120: return
    //   121: iload_1
    //   122: ifne +247 -> 369
    //   125: iload_2
    //   126: ifne +243 -> 369
    //   129: aload 4
    //   131: checkcast 1350	com/tencent/mm/modelsimple/q
    //   134: invokevirtual 1354	com/tencent/mm/modelsimple/q:getReqResp	()Lcom/tencent/mm/network/s;
    //   137: astore_3
    //   138: aload_3
    //   139: ifnonnull +22 -> 161
    //   142: new 1356	java/lang/NullPointerException
    //   145: dup
    //   146: ldc_w 1358
    //   149: invokespecial 1359	java/lang/NullPointerException:<init>	(Ljava/lang/String;)V
    //   152: astore_3
    //   153: ldc_w 1329
    //   156: invokestatic 206	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   159: aload_3
    //   160: athrow
    //   161: aload_3
    //   162: checkcast 1361	com/tencent/mm/am/c
    //   165: getfield 1365	com/tencent/mm/am/c:otC	Lcom/tencent/mm/am/c$c;
    //   168: invokestatic 1370	com/tencent/mm/am/c$c:b	(Lcom/tencent/mm/am/c$c;)Lcom/tencent/mm/bx/a;
    //   171: checkcast 1372	com/tencent/mm/protocal/protobuf/cqe
    //   174: astore_3
    //   175: aload_3
    //   176: ifnull +193 -> 369
    //   179: aload_3
    //   180: getfield 1376	com/tencent/mm/protocal/protobuf/cqe:aawK	Lcom/tencent/mm/protocal/protobuf/fvb;
    //   183: astore 4
    //   185: aload 4
    //   187: ifnull +182 -> 369
    //   190: aload 4
    //   192: getfield 1381	com/tencent/mm/protocal/protobuf/fvb:Zia	Ljava/lang/String;
    //   195: astore_3
    //   196: aload 4
    //   198: getfield 1384	com/tencent/mm/protocal/protobuf/fvb:Zic	Ljava/lang/String;
    //   201: astore 4
    //   203: ldc_w 637
    //   206: new 310	java/lang/StringBuilder
    //   209: dup
    //   210: ldc_w 1386
    //   213: invokespecial 314	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   216: aload_3
    //   217: invokevirtual 1310	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   220: ldc_w 1388
    //   223: invokevirtual 318	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: aload 4
    //   228: invokevirtual 1310	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   231: invokevirtual 325	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   234: invokestatic 648	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   237: aload_3
    //   238: checkcast 456	java/lang/CharSequence
    //   241: astore 5
    //   243: aload 5
    //   245: ifnull +13 -> 258
    //   248: aload 5
    //   250: invokeinterface 459 1 0
    //   255: ifne +153 -> 408
    //   258: iconst_1
    //   259: istore_1
    //   260: iload_1
    //   261: ifne +181 -> 442
    //   264: aload 4
    //   266: checkcast 456	java/lang/CharSequence
    //   269: astore 5
    //   271: aload 5
    //   273: ifnull +13 -> 286
    //   276: aload 5
    //   278: invokeinterface 459 1 0
    //   283: ifne +130 -> 413
    //   286: iconst_1
    //   287: istore_1
    //   288: iload_1
    //   289: ifne +153 -> 442
    //   292: new 1390	com/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo
    //   295: dup
    //   296: invokespecial 1391	com/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo:<init>	()V
    //   299: astore 5
    //   301: aload 5
    //   303: aload 4
    //   305: iconst_0
    //   306: invokestatic 1397	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   309: invokevirtual 1401	com/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo:parseFrom	([B)Lcom/tencent/mm/bx/a;
    //   312: pop
    //   313: getstatic 424	com/tencent/mm/plugin/textstatus/b/f:TjQ	Lcom/tencent/mm/plugin/textstatus/b/f;
    //   316: astore 4
    //   318: invokestatic 850	com/tencent/mm/plugin/auth/a/a:cUx	()Ljava/lang/String;
    //   321: astore 4
    //   323: aload 4
    //   325: ldc_w 1403
    //   328: invokestatic 308	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   331: aload_3
    //   332: ldc_w 1405
    //   335: invokestatic 308	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   338: aload 4
    //   340: aload_3
    //   341: aload 5
    //   343: iconst_0
    //   344: aconst_null
    //   345: bipush 24
    //   347: invokestatic 1408	com/tencent/mm/plugin/textstatus/b/f:a	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo;ILjava/lang/String;I)J
    //   350: pop2
    //   351: invokestatic 370	com/tencent/mm/kernel/h:aZW	()Lcom/tencent/mm/am/s;
    //   354: new 1410	com/tencent/mm/plugin/textstatus/h/j
    //   357: dup
    //   358: invokespecial 1411	com/tencent/mm/plugin/textstatus/h/j:<init>	()V
    //   361: checkcast 372	com/tencent/mm/am/p
    //   364: iconst_0
    //   365: invokevirtual 587	com/tencent/mm/am/s:a	(Lcom/tencent/mm/am/p;I)Z
    //   368: pop
    //   369: aload_0
    //   370: getfield 1194	com/tencent/mm/plugin/textstatus/PluginTextStatus:Tbv	Z
    //   373: ifne +28 -> 401
    //   376: invokestatic 1189	com/tencent/mm/plugin/textstatus/a/ac:hGh	()I
    //   379: iconst_1
    //   380: if_icmpne +21 -> 401
    //   383: invokestatic 370	com/tencent/mm/kernel/h:aZW	()Lcom/tencent/mm/am/s;
    //   386: new 1191	com/tencent/mm/plugin/textstatus/h/l
    //   389: dup
    //   390: invokespecial 1192	com/tencent/mm/plugin/textstatus/h/l:<init>	()V
    //   393: checkcast 372	com/tencent/mm/am/p
    //   396: iconst_0
    //   397: invokevirtual 587	com/tencent/mm/am/s:a	(Lcom/tencent/mm/am/p;I)Z
    //   400: pop
    //   401: ldc_w 1329
    //   404: invokestatic 206	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   407: return
    //   408: iconst_0
    //   409: istore_1
    //   410: goto -150 -> 260
    //   413: iconst_0
    //   414: istore_1
    //   415: goto -127 -> 288
    //   418: astore 4
    //   420: ldc_w 637
    //   423: aload 4
    //   425: ldc_w 1413
    //   428: aload_3
    //   429: invokestatic 643	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   432: iconst_0
    //   433: anewarray 680	java/lang/Object
    //   436: invokestatic 1417	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   439: goto -70 -> 369
    //   442: ldc_w 637
    //   445: ldc_w 1419
    //   448: invokestatic 648	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   451: getstatic 424	com/tencent/mm/plugin/textstatus/b/f:TjQ	Lcom/tencent/mm/plugin/textstatus/b/f;
    //   454: astore_3
    //   455: invokestatic 1423	com/tencent/mm/plugin/textstatus/b/f:hGH	()Lcom/tencent/mm/plugin/textstatus/h/f/g;
    //   458: astore_3
    //   459: invokestatic 850	com/tencent/mm/plugin/auth/a/a:cUx	()Ljava/lang/String;
    //   462: astore 4
    //   464: aload 4
    //   466: ldc_w 1403
    //   469: invokestatic 308	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   472: aload_3
    //   473: aload 4
    //   475: invokevirtual 1428	com/tencent/mm/plugin/textstatus/h/f/g:bdX	(Ljava/lang/String;)Z
    //   478: pop
    //   479: goto -110 -> 369
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	482	0	this	PluginTextStatus
    //   0	482	1	paramInt1	int
    //   0	482	2	paramInt2	int
    //   0	482	3	paramString	String
    //   0	482	4	paramp	p
    //   241	101	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   292	369	418	finally
  }
  
  public final boolean openTextStateChatting(Context paramContext, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(290217);
    kotlin.g.b.s.u(paramContext, "context");
    if (paramJSONObject == null)
    {
      AppMethodBeat.o(290217);
      return true;
    }
    Object localObject2 = paramJSONObject.optString("hashUserName");
    Object localObject1 = paramJSONObject.optString("encodeUserName");
    paramJSONObject.optString("nickName");
    paramJSONObject.optString("headImageURL");
    String str = paramJSONObject.optString("sessionId");
    paramJSONObject = ((com.tencent.mm.plugin.hashinfo.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.hashinfo.a.a.class)).getUserNameByHash((String)localObject2, 1);
    Log.i("MicroMsg.TextStatus.PluginTextStatus", "openTextStateChatting hashUserName:%s changeUserName:%s", new Object[] { localObject2, paramJSONObject });
    localObject2 = (CharSequence)paramJSONObject;
    if ((localObject2 == null) || (kotlin.n.n.bp((CharSequence)localObject2))) {}
    for (int i = 1; i == 0; i = 0)
    {
      localObject1 = com.tencent.mm.plugin.textstatus.conversation.g.a.Tjq;
      kotlin.g.b.s.s(paramJSONObject, "changeUserName");
      com.tencent.mm.plugin.textstatus.conversation.g.a.bY(paramContext, paramJSONObject);
      paramContext = com.tencent.mm.plugin.textstatus.i.b.Trt;
      paramContext = com.tencent.mm.plugin.fts.a.d.We(2);
      kotlin.g.b.s.s(paramContext, "getUnsignedMd5UInt(Const…atus.SessionScene.NOTIFY)");
      com.tencent.mm.plugin.textstatus.i.b.a(6L, null, paramContext, 10, null, 0, 0, 0, 0, paramJSONObject, null, null, null, null, 15858);
      AppMethodBeat.o(290217);
      return true;
    }
    paramJSONObject = com.tencent.mm.plugin.textstatus.conversation.d.f.Tjd;
    paramJSONObject = com.tencent.mm.plugin.fts.a.d.We(2);
    kotlin.g.b.s.s(paramJSONObject, "getUnsignedMd5UInt(Const…atus.SessionScene.NOTIFY)");
    com.tencent.mm.plugin.textstatus.conversation.d.f.a.bdH(paramJSONObject);
    com.tencent.mm.plugin.textstatus.conversation.g.a.Tjq.a(str, (String)localObject1, paramContext);
    paramContext = com.tencent.mm.plugin.textstatus.i.b.Trt;
    paramContext = com.tencent.mm.plugin.textstatus.conversation.g.d.Tjx;
    if (com.tencent.mm.plugin.textstatus.conversation.g.d.hGA()) {}
    for (paramContext = "1";; paramContext = "0")
    {
      paramJSONObject = com.tencent.mm.plugin.textstatus.conversation.d.f.Tjd;
      localObject1 = com.tencent.mm.plugin.textstatus.conversation.d.f.hGy();
      paramJSONObject = (JSONObject)localObject1;
      if (localObject1 == null) {
        paramJSONObject = "";
      }
      com.tencent.mm.plugin.textstatus.i.b.a(1L, paramContext, paramJSONObject, 7, null, 2, 0, 0, 0, null, null, null, null, null, 16336);
      break;
    }
  }
  
  public final void parallelsDependency() {}
  
  public final void report22208(long paramLong, String paramString)
  {
    AppMethodBeat.i(290011);
    com.tencent.mm.plugin.textstatus.i.b localb = com.tencent.mm.plugin.textstatus.i.b.Trt;
    if (paramString == null) {
      paramString = "";
    }
    for (;;)
    {
      com.tencent.mm.plugin.textstatus.i.b.a(paramLong, paramString, null, 0L, null, 28);
      AppMethodBeat.o(290011);
      return;
    }
  }
  
  public final void report22210(String paramString, long paramLong)
  {
    int i = 0;
    long l2 = 2L;
    AppMethodBeat.i(290021);
    kotlin.g.b.s.u(paramString, "userName");
    Object localObject = com.tencent.mm.plugin.textstatus.i.b.Trt;
    kotlin.g.b.s.u(paramString, "userName");
    localObject = com.tencent.mm.plugin.textstatus.b.f.TjQ;
    com.tencent.mm.plugin.textstatus.h.f.b localb = com.tencent.mm.plugin.textstatus.b.f.hGH().bdY(paramString);
    long l1;
    pq localpq;
    if (paramLong == 2L) {
      if (localb != null)
      {
        l1 = 2L;
        localpq = new pq();
        localpq.iWh = localpq.F("ToUsername", paramString, true);
        localpq.iqr = paramLong;
        if (localb == null) {
          break label377;
        }
        paramLong = l2;
        label103:
        localpq.jnt = paramLong;
        localpq.jnu = l1;
        localpq.iOI = System.currentTimeMillis();
        localpq.jnv = localpq.F("SceneExtInfo", "", true);
        if (localb != null) {
          break label382;
        }
        paramString = "";
        label148:
        localpq.jcv = localpq.F("ToStatusID", paramString, true);
        if (localb != null) {
          break label403;
        }
        paramString = "";
      }
    }
    for (;;)
    {
      localpq.jnw = localpq.F("ToStatusIconID", paramString, true);
      localpq.bMH();
      com.tencent.mm.plugin.textstatus.i.b.a((com.tencent.mm.plugin.report.a)localpq);
      AppMethodBeat.o(290021);
      return;
      l1 = 0L;
      break;
      if (paramLong == 3L)
      {
        if (((CharSequence)paramString).length() == 0) {
          i = 1;
        }
        if (i != 0) {
          break label371;
        }
        l1 = 1L;
        break;
      }
      if (paramLong == 4L)
      {
        if (((CharSequence)paramString).length() == 0) {}
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label371;
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
      label371:
      l1 = 0L;
      break;
      label377:
      paramLong = 1L;
      break label103;
      label382:
      localObject = localb.field_StatusID;
      paramString = (String)localObject;
      if (localObject != null) {
        break label148;
      }
      paramString = "";
      break label148;
      label403:
      localObject = localb.field_IconID;
      paramString = (String)localObject;
      if (localObject == null) {
        paramString = "";
      }
    }
  }
  
  public final void setCardDialog(WeakReference<com.tencent.mm.plugin.textstatus.ui.i> paramWeakReference)
  {
    this.akjl = paramWeakReference;
  }
  
  public final void setIcon(ImageView paramImageView, String paramString, a.c paramc, com.tencent.mm.plugin.textstatus.a.a.a parama)
  {
    AppMethodBeat.i(290183);
    if ((paramc != null) && (parama != null)) {
      com.tencent.mm.plugin.textstatus.util.a.a(com.tencent.mm.plugin.textstatus.util.b.hKh(), paramImageView, paramString, paramc, parama, null, 16);
    }
    AppMethodBeat.o(290183);
  }
  
  public final void setTextStatusDrawable(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(289929);
    kotlin.g.b.s.u(paramImageView, "imageView");
    kotlin.g.b.s.u(paramString, "username");
    new o.b(paramString, paramImageView);
    AppMethodBeat.o(289929);
  }
  
  public final void setTextStatusWithDesc(TextView paramTextView, String paramString, a.b paramb, a.c paramc)
  {
    AppMethodBeat.i(289979);
    kotlin.g.b.s.u(paramb, "iconScene");
    kotlin.g.b.s.u(paramc, "iconType");
    if (paramTextView != null)
    {
      CharSequence localCharSequence = (CharSequence)paramString;
      if ((localCharSequence != null) && (!kotlin.n.n.bp(localCharSequence))) {
        break label59;
      }
    }
    label59:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(289979);
      return;
    }
    if (isSpanSwitchOpen(paramb, paramString)) {
      new o.e(paramString, paramTextView, paramc, paramb);
    }
    AppMethodBeat.o(289979);
  }
  
  public final void setTextWithStatus(TextView paramTextView, String paramString, a.b paramb, a.c paramc)
  {
    AppMethodBeat.i(289959);
    kotlin.g.b.s.u(paramb, "iconScene");
    kotlin.g.b.s.u(paramc, "iconType");
    if (paramTextView != null)
    {
      CharSequence localCharSequence = (CharSequence)paramString;
      if ((localCharSequence != null) && (!kotlin.n.n.bp(localCharSequence))) {
        break label59;
      }
    }
    label59:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(289959);
      return;
    }
    if (isSpanSwitchOpen(paramb, paramString)) {
      new o.c(paramString, paramTextView, paramc, paramb);
    }
    AppMethodBeat.o(289959);
  }
  
  public final void setTextWithStatus(NoMeasuredTextView paramNoMeasuredTextView, String paramString, a.b paramb)
  {
    AppMethodBeat.i(289967);
    kotlin.g.b.s.u(paramb, "iconScene");
    if (paramNoMeasuredTextView != null)
    {
      CharSequence localCharSequence = (CharSequence)paramString;
      if ((localCharSequence != null) && (!kotlin.n.n.bp(localCharSequence))) {
        break label51;
      }
    }
    label51:
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(289967);
      return;
    }
    if (isSpanSwitchOpen(paramb, paramString)) {
      new o.d(paramString, paramNoMeasuredTextView, paramb);
    }
    AppMethodBeat.o(289967);
  }
  
  public final void showCardDialog(Activity paramActivity, String paramString)
  {
    AppMethodBeat.i(289823);
    if (paramActivity != null)
    {
      localObject = (CharSequence)paramString;
      if ((localObject != null) && (!kotlin.n.n.bp((CharSequence)localObject))) {
        break label54;
      }
    }
    label54:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        localObject = com.tencent.mm.plugin.textstatus.b.f.TjQ;
        if (com.tencent.mm.plugin.textstatus.b.f.bdN(paramString) != null) {
          break;
        }
      }
      AppMethodBeat.o(289823);
      return;
    }
    Object localObject = paramActivity.getResources().getConfiguration();
    kotlin.g.b.s.s(localObject, "activity.resources.configuration");
    if (((Configuration)localObject).orientation == 2) {}
    for (i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(289823);
      return;
    }
    paramActivity = new com.tencent.mm.plugin.textstatus.ui.i((Context)paramActivity, paramString);
    paramActivity.show();
    this.akjl = new WeakReference(paramActivity);
    AppMethodBeat.o(289823);
  }
  
  public final void showStatusDetail(Context paramContext, String paramString)
  {
    AppMethodBeat.i(289841);
    paramString = (CharSequence)paramString;
    if ((paramString == null) || (kotlin.n.n.bp(paramString))) {}
    for (int i = 1; (i != 0) || (paramContext == null); i = 0)
    {
      AppMethodBeat.o(289841);
      return;
    }
    AppMethodBeat.o(289841);
  }
  
  public final void showStatusPlanet(Activity paramActivity) {}
  
  public final void tryAttachStatusIconSpan(View paramView, CharSequence paramCharSequence)
  {
    int j = 0;
    AppMethodBeat.i(290134);
    if ((paramCharSequence == null) || (kotlin.n.n.bp(paramCharSequence))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(290134);
      return;
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramCharSequence);
    if (paramCharSequence == null) {}
    for (i = 0;; i = paramCharSequence.length())
    {
      paramCharSequence = (com.tencent.mm.plugin.textstatus.util.j[])localSpannableStringBuilder.getSpans(0, i, com.tencent.mm.plugin.textstatus.util.j.class);
      if (paramView != null) {
        paramView.setTag(a.e.TdV, null);
      }
      kotlin.g.b.s.s(paramCharSequence, "imgSpans");
      int k = paramCharSequence.length;
      i = j;
      while (i < k)
      {
        localSpannableStringBuilder = paramCharSequence[i];
        i += 1;
        localSpannableStringBuilder.fj(paramView);
      }
    }
    AppMethodBeat.o(290134);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.PluginTextStatus
 * JD-Core Version:    0.7.0.1
 */