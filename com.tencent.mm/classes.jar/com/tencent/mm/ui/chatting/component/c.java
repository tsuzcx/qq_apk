package com.tencent.mm.ui.chatting.component;

import android.content.Context;
import android.graphics.Rect;
import android.os.Looper;
import android.util.LongSparseArray;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.widget.AbsListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.autogen.mmdata.rpt.aa;
import com.tencent.mm.compatible.util.r;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.br;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.c;
import com.tencent.mm.plugin.msgquote.model.MsgQuoteItem;
import com.tencent.mm.protocal.protobuf.bth;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.chatting.AppBrandServiceChattingUI.AppBrandServiceChattingFmUI;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.ChattingUIFragment;
import com.tencent.mm.ui.chatting.viewitems.ab.e;
import com.tencent.mm.ui.chatting.viewitems.ap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;
import kotlin.o;

@com.tencent.mm.ui.chatting.component.annotation.a(juB=com.tencent.mm.ui.chatting.component.api.c.class)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/component/AppMsgWxaReportComponent;", "Lcom/tencent/mm/ui/chatting/component/AbstractChattingComponent;", "Lcom/tencent/mm/ui/chatting/component/api/IAppMsgWxaReportComponent;", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IMsgInfoStorage$IOnMsgChange;", "()V", "chattingStatInfo", "Lcom/tencent/mm/ui/chatting/component/AppMsgWxaReportComponent$Companion$ChattingStatInfo;", "exposingMsgIds", "Lcom/tencent/mm/ui/chatting/component/AppMsgWxaReportComponent$Companion$LongList;", "isExposePeriodStatEnabled", "", "()Z", "isExposePeriodStatEnabled$delegate", "Lkotlin/Lazy;", "msgId2CachedContentMap", "Landroid/util/LongSparseArray;", "Lcom/tencent/mm/ui/chatting/component/AppMsgWxaReportComponent$Companion$CachedAppMsgContent;", "msgId2CachedHelpfulInfoMap", "Lcom/tencent/mm/ui/chatting/component/AppMsgWxaReportComponent$Companion$CachedStatHelpfulInfo;", "msgId2StatInfoMap", "Lcom/tencent/mm/ui/chatting/component/AppMsgWxaReportComponent$Companion$StatefulAppMsgWxaStatInfo;", "myTag", "", "tempLongList", "viewId2MsgMap", "Landroid/util/SparseArray;", "Lcom/tencent/mm/storage/MsgInfo;", "buildChattingStatInfo", "cleanAllStatInfo", "", "doClickReport", "appMsgWxaStatInfo", "doExposeReport", "getOrBuildMsgId2CachedContentMap", "getOrBuildMsgId2CachedHelpfulInfoMap", "getOrBuildMsgId2StatInfoMap", "getOrBuildViewId2MsgMap", "maybeAppMsgWxaViewClick", "chattingContext", "Lcom/tencent/mm/ui/chatting/context/ChattingContext;", "view", "Landroid/view/View;", "msg", "maybeAppMsgWxaViewExpose", "onChattingEnterAnimStart", "onChattingExitAnimEnd", "onChattingPause", "onChattingResume", "onNotifyChange", "msgstg", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IMsgInfoStorage;", "notifyInfo", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IMsgInfoStorage$NotifyInfo;", "onScroll", "Landroid/widget/AbsListView;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "buildStatefulAppMsgWxaStatInfo", "Lcom/tencent/mm/ui/chatting/component/AppMsgWxaReportComponent$Companion$AppMsgWxaStatHelpfulInfo;", "containsKey", "E", "key", "", "getOrBuildStatefulAppMsgWxaStatInfo", "getOrPut", "defaultValue", "Lkotlin/Function0;", "(Landroid/util/LongSparseArray;JLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "getOriginMsg", "kotlin.jvm.PlatformType", "Lcom/tencent/mm/ui/chatting/viewitems/ChattingItemContainer;", "getQuoteMsgInfo", "Lcom/tencent/mm/plugin/msgquote/model/MsgQuoteItem;", "getStatefulAppMsgWxaStatInfo", "parseContent", "Lcom/tencent/mm/message/AppMessage$Content;", "parseExposePercent", "", "parseHelpfulInfo", "Lcom/tencent/mm/ui/chatting/component/AppMsgWxaReportComponent$Companion$ParseHelpfulInfoContext;", "msgInfo", "parseHelpfulInfoInternal", "parseSenderUsername", "putNewMsg", "set", "value", "(Landroid/util/LongSparseArray;JLjava/lang/Object;)V", "(Landroid/util/SparseArray;ILjava/lang/Object;)V", "toDebugString", "toParseContext", "com/tencent/mm/ui/chatting/component/AppMsgWxaReportComponent$toParseContext$2", "(Lcom/tencent/mm/plugin/msgquote/model/MsgQuoteItem;Lcom/tencent/mm/storage/MsgInfo;)Lcom/tencent/mm/ui/chatting/component/AppMsgWxaReportComponent$toParseContext$2;", "com/tencent/mm/ui/chatting/component/AppMsgWxaReportComponent$toParseContext$1", "(Lcom/tencent/mm/storage/MsgInfo;)Lcom/tencent/mm/ui/chatting/component/AppMsgWxaReportComponent$toParseContext$1;", "toReportString", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends a
  implements i.a, com.tencent.mm.ui.chatting.component.api.c
{
  private static final boolean DEBUG = false;
  public static final c.a aeok;
  private final j aeol;
  private c.a.h aeom;
  private LongSparseArray<c.a.k> aeon;
  private SparseArray<cc> aeoo;
  private LongSparseArray<a.e> aeop;
  private LongSparseArray<a.g> aeoq;
  private c.a.i aeor;
  private c.a.i aeos;
  private final String djQ;
  
  static
  {
    AppMethodBeat.i(256201);
    aeok = new c.a((byte)0);
    AppMethodBeat.o(256201);
  }
  
  public c()
  {
    AppMethodBeat.i(256074);
    this.djQ = ("MicroMsg.AppMsgWxaReportComponent#{" + hashCode() + '}');
    this.aeol = k.a(o.aiuH, (kotlin.g.a.a)new d(this));
    AppMethodBeat.o(256074);
  }
  
  private static String YG(String paramString)
  {
    AppMethodBeat.i(256174);
    if (paramString.length() > 1024)
    {
      if (paramString == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(256174);
        throw paramString;
      }
      paramString = paramString.substring(0, 1024);
      s.s(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    }
    while (kotlin.n.n.i((CharSequence)paramString, (CharSequence)","))
    {
      paramString = r.as(paramString, "UTF-8");
      if (paramString == null)
      {
        AppMethodBeat.o(256174);
        return "";
      }
      else
      {
        AppMethodBeat.o(256174);
        return paramString;
      }
    }
    AppMethodBeat.o(256174);
    return paramString;
  }
  
  private final a.a a(a.j paramj, cc paramcc)
  {
    AppMethodBeat.i(256143);
    cc localcc = paramj.jqO();
    if (localcc == null)
    {
      Log.w(this.djQ, "parseHelpfulInfo, wxaMsgInfo is null");
      AppMethodBeat.o(256143);
      return null;
    }
    if (587202609 == paramj.msgType)
    {
      paramj = new a.a(paramcc, a.c.aeoG, localcc, (byte)0);
      AppMethodBeat.o(256143);
      return paramj;
    }
    if (553648177 == paramj.msgType)
    {
      paramj = new a.a(paramcc, a.c.aeoH, localcc, (byte)0);
      AppMethodBeat.o(256143);
      return paramj;
    }
    if (974127153 == paramj.msgType)
    {
      paramj = new a.a(paramcc, a.c.aeoI, localcc, (byte)0);
      AppMethodBeat.o(256143);
      return paramj;
    }
    if (49 == paramj.msgType)
    {
      k.b localb = paramj.jqP();
      if (localb == null)
      {
        Log.w(this.djQ, "parseHelpfulInfo, appMsgContent is null");
        AppMethodBeat.o(256143);
        return null;
      }
      int i = localb.type;
      if (36 == i)
      {
        if ((!ab.IS(paramj.talker)) && (!com.tencent.mm.an.h.ac(paramj.jqO())))
        {
          paramj = new a.a(paramcc, a.c.aeoJ, localcc, (byte)0);
          AppMethodBeat.o(256143);
          return paramj;
        }
        AppMethodBeat.o(256143);
        return null;
      }
      if ((33 == i) || (44 == i))
      {
        if (44 == i)
        {
          if (localb.gK(false))
          {
            localObject = this.hlc;
            if (localObject != null) {
              break label328;
            }
            localObject = null;
            if (localObject != null) {
              break label341;
            }
            localObject = MMApplicationContext.getContext();
            label286:
            localObject = (CharSequence)localb.B((Context)localObject, false);
            if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
              break label351;
            }
          }
          label328:
          label341:
          label351:
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label356;
            }
            AppMethodBeat.o(256143);
            return null;
            localObject = ((com.tencent.mm.ui.chatting.d.a)localObject).aezO.getContext();
            break;
            localObject = (Context)localObject;
            break label286;
          }
        }
        label356:
        int j = localb.nTF;
        if ((j != 0) && (2 != j))
        {
          if (3 != j) {
            break label509;
          }
          localObject = (CharSequence)localb.nTJ;
          if ((localObject == null) || (((CharSequence)localObject).length() == 0))
          {
            i = 1;
            if (i == 0) {
              break label509;
            }
          }
        }
        else
        {
          localObject = this.hlc;
          if (localObject != null) {
            break label491;
          }
        }
        label491:
        for (Object localObject = null;; localObject = ((com.tencent.mm.ui.chatting.d.a)localObject).aezO)
        {
          if (((localObject instanceof AppBrandServiceChattingUI.AppBrandServiceChattingFmUI)) || (com.tencent.mm.an.h.ac(paramj.jqO())) || (ab.IS(paramj.talker)) || (au.bwQ(paramj.talker))) {
            break label501;
          }
          paramj = new a.a(paramcc, a.c.aeoL, localcc, (byte)0);
          AppMethodBeat.o(256143);
          return paramj;
          i = 0;
          break;
        }
        label501:
        AppMethodBeat.o(256143);
        return null;
        label509:
        if (1 == j)
        {
          localObject = this.hlc;
          if (localObject == null) {}
          for (localObject = null; (!(localObject instanceof AppBrandServiceChattingUI.AppBrandServiceChattingFmUI)) && (!com.tencent.mm.an.h.ac(paramj.jqO())) && (!ab.IS(paramj.talker)) && (!au.bwQ(paramj.talker)); localObject = ((com.tencent.mm.ui.chatting.d.a)localObject).aezO)
          {
            paramj = new a.a(paramcc, a.c.aeoM, localcc, (byte)0);
            AppMethodBeat.o(256143);
            return paramj;
          }
          AppMethodBeat.o(256143);
          return null;
        }
        if (3 == j)
        {
          if (!au.bwQ(paramj.talker))
          {
            paramj = new a.a(paramcc, a.c.aeoK, localcc, (byte)0);
            AppMethodBeat.o(256143);
            return paramj;
          }
          AppMethodBeat.o(256143);
          return null;
        }
      }
    }
    AppMethodBeat.o(256143);
    return null;
  }
  
  private final c.a.k a(a.a parama)
  {
    AppMethodBeat.i(256084);
    c.a.k localk = cD(parama.hTm);
    if (localk == null)
    {
      parama = b(parama);
      AppMethodBeat.o(256084);
      return parama;
    }
    AppMethodBeat.o(256084);
    return localk;
  }
  
  private final f a(final MsgQuoteItem paramMsgQuoteItem, final cc paramcc)
  {
    AppMethodBeat.i(256135);
    int i = paramMsgQuoteItem.type;
    String str2 = paramMsgQuoteItem.LgW;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    paramMsgQuoteItem = new f(this, paramcc, paramMsgQuoteItem, i, str1);
    AppMethodBeat.o(256135);
    return paramMsgQuoteItem;
  }
  
  private static String a(cc paramcc, com.tencent.mm.ui.chatting.d.a parama)
  {
    AppMethodBeat.i(256116);
    if (1 == paramcc.field_isSend)
    {
      paramcc = parama.getSelfUserName();
      if (paramcc == null)
      {
        AppMethodBeat.o(256116);
        return "";
      }
      AppMethodBeat.o(256116);
      return paramcc;
    }
    if (parama.juG())
    {
      paramcc = br.JJ(paramcc.field_content);
      if (paramcc == null)
      {
        AppMethodBeat.o(256116);
        return "";
      }
      AppMethodBeat.o(256116);
      return paramcc;
    }
    paramcc = parama.getTalkerUserName();
    s.s(paramcc, "chattingContext.talkerUserName");
    AppMethodBeat.o(256116);
    return paramcc;
  }
  
  private static <E> void a(LongSparseArray<E> paramLongSparseArray, long paramLong, E paramE)
  {
    AppMethodBeat.i(256167);
    s.u(paramLongSparseArray, "<this>");
    paramLongSparseArray.put(paramLong, paramE);
    AppMethodBeat.o(256167);
  }
  
  private final c.a.k b(a.a parama)
  {
    AppMethodBeat.i(256090);
    com.tencent.mm.ui.chatting.d.a locala = this.hlc;
    if (locala == null)
    {
      Log.w(this.djQ, "buildStatefulAppMsgWxaStatInfo, chattingContext is null");
      AppMethodBeat.o(256090);
      return null;
    }
    k.b localb = cF(parama.aeou);
    if (localb == null)
    {
      Log.w(this.djQ, "buildStatefulAppMsgWxaStatInfo, appMsgContent is null");
      AppMethodBeat.o(256090);
      return null;
    }
    long l1;
    long l2;
    Object localObject1;
    int i;
    label158:
    String str;
    Object localObject2;
    label177:
    Object localObject4;
    if (a.c.aeoI == parama.aeot)
    {
      localObject3 = ((com.tencent.mm.plugin.findersdk.a.h)localb.aK(com.tencent.mm.plugin.findersdk.a.h.class)).HbZ;
      l1 = parama.hTm.field_msgSvrId;
      l2 = parama.aeou.field_msgSvrId;
      localObject1 = parama.aeot;
      switch (b.$EnumSwitchMapping$0[localObject1.ordinal()])
      {
      default: 
        i = 1;
        str = a(parama.aeou, locala);
        if (localObject3 == null)
        {
          localObject2 = null;
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject2 = localb.nTE;
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = "";
            }
          }
          localObject2 = localb.nTD;
          localObject4 = localObject2;
          if (localObject2 == null) {
            localObject4 = "";
          }
          if (localObject3 != null) {
            break label387;
          }
        }
        break;
      }
    }
    label387:
    for (Object localObject3 = null;; localObject3 = ((bth)localObject3).hzy)
    {
      localObject2 = localObject3;
      if (localObject3 == null)
      {
        localObject3 = localb.nTC;
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = "";
        }
      }
      localObject1 = new c.a.b(l1, l2, i, str, (String)localObject1, (String)localObject4, (String)localObject2, parama.aeot.LV(locala.juG()));
      if (DEBUG) {
        Log.d(this.djQ, s.X("buildStatefulAppMsgWxaStatInfo, appMsgWxaStatInfo: ", localObject1));
      }
      localObject1 = new c.a.k((c.a.b)localObject1);
      a(jqI(), parama.hTm.field_msgSvrId, localObject1);
      AppMethodBeat.o(256090);
      return localObject1;
      localObject3 = null;
      break;
      i = 2;
      break label158;
      i = 3;
      break label158;
      i = 4;
      break label158;
      localObject2 = ((bth)localObject3).appId;
      break label177;
    }
  }
  
  public static final void c(com.tencent.mm.ui.chatting.d.a parama, View paramView, cc paramcc)
  {
    AppMethodBeat.i(256179);
    c.a.c(parama, paramView, paramcc);
    AppMethodBeat.o(256179);
  }
  
  private final c.a.k cD(cc paramcc)
  {
    AppMethodBeat.i(256086);
    paramcc = (c.a.k)jqI().get(paramcc.field_msgSvrId);
    AppMethodBeat.o(256086);
    return paramcc;
  }
  
  private static String cE(cc paramcc)
  {
    AppMethodBeat.i(256099);
    paramcc = "MsgInfo(msgId = " + paramcc.field_msgId + ", msgType = " + paramcc.getType() + ", msgSvrId = " + paramcc.field_msgSvrId + ')';
    AppMethodBeat.o(256099);
    return paramcc;
  }
  
  private final k.b cF(cc paramcc)
  {
    AppMethodBeat.i(256107);
    LongSparseArray localLongSparseArray = jqK();
    long l = paramcc.field_msgSvrId;
    Object localObject2 = localLongSparseArray.get(l);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = paramcc.field_content;
      if (localObject1 != null) {
        break label82;
      }
    }
    label82:
    for (paramcc = null;; paramcc = k.b.aP((String)localObject1, paramcc.field_reserved))
    {
      localObject1 = new a.e(paramcc);
      localLongSparseArray.put(l, localObject1);
      paramcc = ((a.e)localObject1).hWV;
      AppMethodBeat.o(256107);
      return paramcc;
    }
  }
  
  private final a.a cG(cc paramcc)
  {
    AppMethodBeat.i(256109);
    if (paramcc == null)
    {
      AppMethodBeat.o(256109);
      return null;
    }
    LongSparseArray localLongSparseArray = jqL();
    long l = paramcc.field_msgSvrId;
    Object localObject2 = localLongSparseArray.get(l);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new a.g(cH(paramcc));
      localLongSparseArray.put(l, localObject1);
    }
    paramcc = ((a.g)localObject1).aeoP;
    AppMethodBeat.o(256109);
    return paramcc;
  }
  
  private final a.a cH(cc paramcc)
  {
    AppMethodBeat.i(256121);
    if (paramcc == null)
    {
      AppMethodBeat.o(256121);
      return null;
    }
    Object localObject = a((a.j)cI(paramcc), paramcc);
    if (localObject == null)
    {
      localObject = cJ(paramcc);
      if (localObject == null)
      {
        AppMethodBeat.o(256121);
        return null;
      }
      paramcc = a((a.j)a((MsgQuoteItem)localObject, paramcc), paramcc);
      AppMethodBeat.o(256121);
      return paramcc;
    }
    AppMethodBeat.o(256121);
    return localObject;
  }
  
  private final e cI(cc paramcc)
  {
    AppMethodBeat.i(256128);
    int i = paramcc.getType();
    String str2 = paramcc.field_talker;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    paramcc = new e(paramcc, this, i, str1);
    AppMethodBeat.o(256128);
    return paramcc;
  }
  
  private final MsgQuoteItem cJ(cc paramcc)
  {
    AppMethodBeat.i(256132);
    if (822083633 != paramcc.getType())
    {
      AppMethodBeat.o(256132);
      return null;
    }
    paramcc = cF(paramcc);
    if (paramcc == null)
    {
      AppMethodBeat.o(256132);
      return null;
    }
    paramcc = paramcc.nTU;
    AppMethodBeat.o(256132);
    return paramcc;
  }
  
  public static final void d(com.tencent.mm.ui.chatting.d.a parama, View paramView, cc paramcc)
  {
    AppMethodBeat.i(256184);
    c.a.d(parama, paramView, paramcc);
    AppMethodBeat.o(256184);
  }
  
  private final boolean jqH()
  {
    AppMethodBeat.i(256078);
    boolean bool = ((Boolean)this.aeol.getValue()).booleanValue();
    AppMethodBeat.o(256078);
    return bool;
  }
  
  private final LongSparseArray<c.a.k> jqI()
  {
    AppMethodBeat.i(256095);
    LongSparseArray localLongSparseArray2 = this.aeon;
    LongSparseArray localLongSparseArray1 = localLongSparseArray2;
    if (localLongSparseArray2 == null)
    {
      localLongSparseArray1 = new LongSparseArray();
      this.aeon = localLongSparseArray1;
    }
    AppMethodBeat.o(256095);
    return localLongSparseArray1;
  }
  
  private final SparseArray<cc> jqJ()
  {
    AppMethodBeat.i(256148);
    SparseArray localSparseArray2 = this.aeoo;
    SparseArray localSparseArray1 = localSparseArray2;
    if (localSparseArray2 == null)
    {
      localSparseArray1 = new SparseArray();
      this.aeoo = localSparseArray1;
    }
    AppMethodBeat.o(256148);
    return localSparseArray1;
  }
  
  private final LongSparseArray<a.e> jqK()
  {
    AppMethodBeat.i(256156);
    LongSparseArray localLongSparseArray2 = this.aeop;
    LongSparseArray localLongSparseArray1 = localLongSparseArray2;
    if (localLongSparseArray2 == null)
    {
      localLongSparseArray1 = new LongSparseArray();
      this.aeop = localLongSparseArray1;
    }
    AppMethodBeat.o(256156);
    return localLongSparseArray1;
  }
  
  private final LongSparseArray<a.g> jqL()
  {
    AppMethodBeat.i(256162);
    LongSparseArray localLongSparseArray2 = this.aeoq;
    LongSparseArray localLongSparseArray1 = localLongSparseArray2;
    if (localLongSparseArray2 == null)
    {
      localLongSparseArray1 = new LongSparseArray();
      this.aeoq = localLongSparseArray1;
    }
    AppMethodBeat.o(256162);
    return localLongSparseArray1;
  }
  
  public final void a(com.tencent.mm.ui.chatting.d.a parama, View paramView, cc paramcc)
  {
    int i = 1;
    AppMethodBeat.i(256260);
    s.u(parama, "chattingContext");
    s.u(paramView, "view");
    s.u(paramcc, "msg");
    if (DEBUG) {
      Log.d(this.djQ, s.X("maybeAppMsgWxaViewExpose, msg: ", cE(paramcc)));
    }
    if (!(paramView instanceof ap))
    {
      Log.w(this.djQ, "maybeAppMsgWxaViewExpose, view: " + paramView + ", why?");
      AppMethodBeat.o(256260);
      return;
    }
    if (!jqH())
    {
      parama = cG(paramcc);
      if (parama == null) {}
      for (parama = null; parama == null; parama = a(parama))
      {
        parama = (c)this;
        if (DEBUG) {
          Log.d(parama.djQ, "maybeAppMsgWxaViewExpose, msg is not AppMsgWxa");
        }
        AppMethodBeat.o(256260);
        return;
      }
      parama = parama.aeoV;
      Log.i("MicroMsg.AppMsgWxaReportComponent", s.X("markExpose, msgId: ", Long.valueOf(parama.msgId)));
      parama.aeoC = true;
      AppMethodBeat.o(256260);
      return;
    }
    parama = (ap)paramView;
    parama = (cc)jqJ().get(parama.hashCode());
    long l = paramcc.field_msgSvrId;
    if ((parama != null) && (l == parama.field_msgSvrId)) {}
    while (i != 0)
    {
      Log.i(this.djQ, "maybeAppMsgWxaViewExpose, msg is the same as originMsg, why?");
      AppMethodBeat.o(256260);
      return;
      i = 0;
    }
    if (parama != null)
    {
      localObject = cD(parama);
      if (localObject != null) {
        break label386;
      }
      Log.w(((c)this).djQ, "maybeAppMsgWxaViewExpose, originMsg is not AppMsgWxa, originMsg: " + cE(parama) + ", why?");
    }
    for (;;)
    {
      parama = cG(parama);
      if (parama != null)
      {
        localObject = parama.aeov;
        if (localObject != null) {
          paramView.removeOnAttachStateChangeListener((View.OnAttachStateChangeListener)localObject);
        }
        parama.aeov = null;
      }
      parama = cG(paramcc);
      if (parama != null) {
        break;
      }
      parama = (c)this;
      if (DEBUG) {
        Log.d(parama.djQ, "maybeAppMsgWxaViewExpose, msg is not AppMsgWxa");
      }
      AppMethodBeat.o(256260);
      return;
      label386:
      ((c.a.k)localObject).aeoV.w(null);
    }
    Object localObject = a(parama);
    if (localObject != null)
    {
      ap localap = (ap)paramView;
      SparseArray localSparseArray = jqJ();
      i = localap.hashCode();
      s.u(localSparseArray, "<this>");
      localSparseArray.put(i, paramcc);
      paramcc = new c.a.d((c.a.k)localObject);
      parama.aeov = paramcc;
      paramView.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)paramcc);
    }
    AppMethodBeat.o(256260);
  }
  
  public final void b(com.tencent.mm.ui.chatting.d.a parama, View paramView, cc paramcc)
  {
    AppMethodBeat.i(256268);
    s.u(parama, "chattingContext");
    s.u(paramView, "view");
    s.u(paramcc, "msg");
    Log.i(this.djQ, s.X("onAppMsgWxaViewClick, msgInfo: ", cE(paramcc)));
    parama = cD(paramcc);
    if (parama == null)
    {
      Log.i(((c)this).djQ, "onAppMsgWxaViewClick, appMsgWxaStatInfo is null");
      AppMethodBeat.o(256268);
      return;
    }
    boolean bool = parama.ihE;
    parama.ihE = true;
    if (!bool)
    {
      i = 1;
      if (i == 0) {
        break label347;
      }
      Log.i(this.djQ, s.X("doClickReport, msgId: ", Long.valueOf(parama.aeoV.aeow)));
      paramView = this.aeom;
      if (paramView != null) {
        if (((CharSequence)paramView.lxj).length() != 0) {
          break label176;
        }
      }
    }
    label176:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label182;
      }
      Log.i(this.djQ, "doClickReport, filter invalid statInfo");
      AppMethodBeat.o(256268);
      return;
      i = 0;
      break;
    }
    label182:
    if (DEBUG) {
      Log.d(this.djQ, s.X("doClickReport, appMsgWxaStatInfo: ", parama));
    }
    parama = parama.aeoV;
    paramcc = new aa();
    paramcc.ilm = 1;
    paramcc.imM = paramView.chatType;
    paramcc = paramcc.km(YG(paramView.lxj));
    paramcc.imO = paramView.aeoQ;
    paramView = paramcc.kn(YG(paramView.sessionId));
    paramView.imP = parama.msgId;
    paramView.imQ = parama.aeow;
    paramView.imR = parama.aeox;
    paramView = paramView.ko(YG(parama.aeoy)).kp(YG(parama.appId)).kq(YG(parama.username)).kr(YG(parama.qAF));
    paramView.imW = parama.scene;
    paramView.imX = parama.jqN();
    paramView.bMH();
    label347:
    AppMethodBeat.o(256268);
  }
  
  public final void jjg()
  {
    AppMethodBeat.i(256208);
    if (DEBUG) {
      Log.d(this.djQ, "onChattingEnterAnimStart");
    }
    if (jqH())
    {
      localObject1 = (com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class);
      if (localObject1 != null)
      {
        localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)localObject1).gaZ();
        if (localObject1 != null) {
          ((i)localObject1).a((i.a)this, Looper.getMainLooper());
        }
      }
    }
    Object localObject1 = this.hlc;
    Object localObject2;
    label93:
    int i;
    if (localObject1 == null)
    {
      localObject1 = "";
      localObject2 = this.hlc;
      if (localObject2 != null) {
        break label170;
      }
      localObject2 = "";
      i = com.tencent.mm.modelappbrand.a.KG((String)localObject2);
      if (!au.bwE((String)localObject2)) {
        break label191;
      }
    }
    label170:
    label191:
    for (localObject1 = new c.a.h((String)localObject1, (String)localObject2, i, v.getMembersCountByChatRoomName((String)localObject2));; localObject1 = new c.a.h((String)localObject1, (String)localObject2, i))
    {
      if (DEBUG) {
        Log.d(this.djQ, s.X("buildChattingStatInfo, chattingStatInfo: ", localObject1));
      }
      this.aeom = ((c.a.h)localObject1);
      AppMethodBeat.o(256208);
      return;
      localObject2 = ((com.tencent.mm.ui.chatting.d.a)localObject1).aezT;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      localObject1 = "";
      break;
      String str = ((com.tencent.mm.ui.chatting.d.a)localObject2).getTalkerUserName();
      localObject2 = str;
      if (str != null) {
        break label93;
      }
      localObject2 = "";
      break label93;
    }
  }
  
  public final void jji()
  {
    AppMethodBeat.i(256228);
    if (DEBUG) {
      Log.d(this.djQ, "onChattingResume");
    }
    LongSparseArray localLongSparseArray = this.aeon;
    int k;
    if (localLongSparseArray != null)
    {
      k = localLongSparseArray.size();
      if (k <= 0) {}
    }
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      localLongSparseArray.keyAt(i);
      c.a.b localb = ((c.a.k)localLongSparseArray.valueAt(i)).aeoV;
      Log.i("MicroMsg.AppMsgWxaReportComponent", s.X("markForeground, msgId: ", Long.valueOf(localb.msgId)));
      if (localb.aeoD) {
        Log.i("MicroMsg.AppMsgWxaReportComponent", "markForeground, already revoked");
      }
      while (j >= k)
      {
        AppMethodBeat.o(256228);
        return;
        if (localb.aeoB)
        {
          localb.aeoB = false;
          localb.v(null);
        }
      }
    }
  }
  
  public final void jjj()
  {
    AppMethodBeat.i(256235);
    if (DEBUG) {
      Log.d(this.djQ, "onChattingPause");
    }
    LongSparseArray localLongSparseArray = this.aeon;
    int i;
    int k;
    if (localLongSparseArray != null)
    {
      i = 0;
      k = localLongSparseArray.size();
      if (k <= 0) {}
    }
    for (;;)
    {
      int j = i + 1;
      localLongSparseArray.keyAt(i);
      c.a.b localb = ((c.a.k)localLongSparseArray.valueAt(i)).aeoV;
      Log.i("MicroMsg.AppMsgWxaReportComponent", s.X("markBackground, msgId: ", Long.valueOf(localb.msgId)));
      if (localb.aeoD) {
        Log.i("MicroMsg.AppMsgWxaReportComponent", "markBackground, already revoked");
      }
      while (j >= k)
      {
        AppMethodBeat.o(256235);
        return;
        if (localb.jqM())
        {
          localb.w(null);
          localb.aeoB = true;
        }
      }
      i = j;
    }
  }
  
  public final void jjl()
  {
    AppMethodBeat.i(256222);
    if (DEBUG) {
      Log.d(this.djQ, "onChattingExitAnimEnd");
    }
    Object localObject1 = this.aeom;
    if (localObject1 != null)
    {
      Log.i("MicroMsg.AppMsgWxaReportComponent", "markExitChatting");
      ((c.a.h)localObject1).GdW = System.currentTimeMillis();
    }
    Log.i(this.djQ, "doExposeReport");
    Object localObject2 = this.aeom;
    localObject1 = this.aeon;
    if (localObject1 == null)
    {
      localObject1 = null;
      if ((localObject2 != null) && (localObject1 != null))
      {
        if (((CharSequence)((c.a.h)localObject2).lxj).length() != 0) {
          break label355;
        }
        i = 1;
        label108:
        if (i == 0)
        {
          if ((localObject1 != null) && (((LongSparseArray)localObject1).size() != 0)) {
            break label360;
          }
          i = 1;
          label127:
          if (i == 0) {
            break label365;
          }
        }
      }
      Log.i(this.djQ, "doExposeReport, filter invalid statInfo");
    }
    label355:
    label360:
    label365:
    Object localObject3;
    int k;
    do
    {
      Log.i(this.djQ, "cleanAllStatInfo");
      this.aeom = null;
      localObject1 = this.aeon;
      if (localObject1 != null) {
        ((LongSparseArray)localObject1).clear();
      }
      this.aeon = null;
      localObject1 = this.aeoo;
      if (localObject1 != null) {
        ((SparseArray)localObject1).clear();
      }
      this.aeoo = null;
      localObject1 = this.aeop;
      if (localObject1 != null) {
        ((LongSparseArray)localObject1).clear();
      }
      this.aeop = null;
      localObject1 = this.aeoq;
      if (localObject1 != null) {
        ((LongSparseArray)localObject1).clear();
      }
      this.aeoq = null;
      localObject1 = this.aeor;
      if (localObject1 != null) {
        ((c.a.i)localObject1).aeoS = 0;
      }
      this.aeor = null;
      localObject1 = this.aeos;
      if (localObject1 != null) {
        ((c.a.i)localObject1).aeoS = 0;
      }
      this.aeos = null;
      if (jqH())
      {
        localObject1 = (com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class);
        if (localObject1 != null)
        {
          localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)localObject1).gaZ();
          if (localObject1 != null) {
            ((i)localObject1).a((i.a)this);
          }
        }
      }
      AppMethodBeat.o(256222);
      return;
      localObject1 = d.a((LongSparseArray)localObject1, (m)c.c.aeoW);
      break;
      i = 0;
      break label108;
      i = 0;
      break label127;
      if (DEBUG) {
        Log.d(this.djQ, "doExposeReport, chattingStatInfo: " + localObject2 + ", msgId2StatInfoMap: " + localObject1);
      }
      localObject3 = new aa();
      ((aa)localObject3).ilm = 0;
      ((aa)localObject3).imM = ((c.a.h)localObject2).chatType;
      localObject3 = ((aa)localObject3).km(YG(((c.a.h)localObject2).lxj));
      ((aa)localObject3).imO = ((c.a.h)localObject2).aeoQ;
      localObject2 = ((aa)localObject3).kn(YG(((c.a.h)localObject2).sessionId));
      k = ((LongSparseArray)localObject1).size();
    } while (k <= 0);
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      ((LongSparseArray)localObject1).keyAt(i);
      localObject3 = ((c.a.k)((LongSparseArray)localObject1).valueAt(i)).aeoV;
      ((aa)localObject2).imP = ((c.a.b)localObject3).msgId;
      ((aa)localObject2).imQ = ((c.a.b)localObject3).aeow;
      ((aa)localObject2).imR = ((c.a.b)localObject3).aeox;
      aa localaa = ((aa)localObject2).ko(YG(((c.a.b)localObject3).aeoy)).kp(YG(((c.a.b)localObject3).appId)).kq(YG(((c.a.b)localObject3).username)).kr(YG(((c.a.b)localObject3).qAF));
      localaa.imW = ((c.a.b)localObject3).scene;
      localaa.imX = ((c.a.b)localObject3).jqN();
      localaa.bMH();
      if (j >= k) {
        break;
      }
    }
  }
  
  public final void onNotifyChange(i parami, i.c paramc)
  {
    AppMethodBeat.i(256274);
    if (!jqH())
    {
      AppMethodBeat.o(256274);
      return;
    }
    if (DEBUG) {
      Log.d(this.djQ, "onNotifyChange");
    }
    if (paramc == null)
    {
      AppMethodBeat.o(256274);
      return;
    }
    if (!s.p("update", paramc.KRm))
    {
      if (DEBUG) {
        Log.d(this.djQ, "onNotifyChange, not update");
      }
      AppMethodBeat.o(256274);
      return;
    }
    parami = this.aeon;
    if (parami == null)
    {
      if (DEBUG) {
        Log.d(this.djQ, "onNotifyChange, msgId2StatInfoMap is null");
      }
      AppMethodBeat.o(256274);
      return;
    }
    paramc = paramc.mZo;
    s.s(paramc, "notifyInfo.msgList");
    Object localObject1 = (Iterable)paramc;
    paramc = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    Object localObject2;
    label207:
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      if (4 == (((cc)localObject2).jUq & 0x4)) {}
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label207;
        }
        paramc.add(localObject2);
        break;
      }
    }
    paramc = ((Iterable)paramc).iterator();
    while (paramc.hasNext())
    {
      localObject1 = (cc)paramc.next();
      if (DEBUG)
      {
        localObject2 = this.djQ;
        s.s(localObject1, "revokeMsg");
        Log.d((String)localObject2, s.X("onNotifyChange, revokeMsg: ", cE((cc)localObject1)));
      }
      localObject1 = (c.a.k)parami.get(((fi)localObject1).field_msgSvrId);
      if (localObject1 != null)
      {
        localObject1 = ((c.a.k)localObject1).aeoV;
        Log.i("MicroMsg.AppMsgWxaReportComponent", s.X("markRevoked, msgId: ", Long.valueOf(((c.a.b)localObject1).msgId)));
        if (((c.a.b)localObject1).aeoD)
        {
          Log.i("MicroMsg.AppMsgWxaReportComponent", "markRevoked, already revoked");
        }
        else
        {
          ((c.a.b)localObject1).w(null);
          ((c.a.b)localObject1).aeoD = true;
        }
      }
    }
    AppMethodBeat.o(256274);
  }
  
  public final void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(256250);
    if (!jqH())
    {
      AppMethodBeat.o(256250);
      return;
    }
    if (DEBUG) {
      Log.d(this.djQ, "onScroll, firstVisibleItem: " + paramInt1 + ", visibleItemCount: " + paramInt2 + ", totalItemCount: " + paramInt3);
    }
    if (paramInt2 <= 0)
    {
      AppMethodBeat.o(256250);
      return;
    }
    LongSparseArray localLongSparseArray = this.aeon;
    if (localLongSparseArray == null)
    {
      AppMethodBeat.o(256250);
      return;
    }
    com.tencent.mm.ui.chatting.d.a locala = this.hlc;
    if (locala == null)
    {
      Log.w(((c)this).djQ, "onScroll, chattingContext is null");
      AppMethodBeat.o(256250);
      return;
    }
    paramAbsListView = locala.aezO;
    if ((paramAbsListView instanceof ChattingUIFragment))
    {
      paramAbsListView = (ChattingUIFragment)paramAbsListView;
      if (paramAbsListView != null) {
        break label186;
      }
    }
    label186:
    for (Object localObject2 = null;; localObject2 = paramAbsListView.aekk)
    {
      if (localObject2 != null) {
        break label195;
      }
      Log.w(((c)this).djQ, "onScroll, chattingDataAdapter is null");
      AppMethodBeat.o(256250);
      return;
      paramAbsListView = null;
      break;
    }
    label195:
    paramAbsListView = this.aeos;
    paramInt3 = 0;
    int j;
    int i;
    Object localObject1;
    Object localObject3;
    long l1;
    if (paramInt2 > 0)
    {
      j = paramInt3 + 1;
      i = paramInt1 - 1 + paramInt3;
      localObject1 = paramAbsListView;
      if (i >= 0)
      {
        localObject1 = ((com.tencent.mm.ui.chatting.a.a)localObject2).aBV(i);
        if (localObject1 != null) {
          break label501;
        }
        localObject3 = null;
        localObject1 = paramAbsListView;
        if (localObject3 != null)
        {
          l1 = ((Long)localObject3).longValue();
          if (DEBUG) {
            Log.d(this.djQ, "onScroll, viewIndex: " + paramInt3 + ", dataIndex: " + i + ", msgId: " + l1);
          }
          if (localLongSparseArray.indexOfKey(l1) < 0) {
            break label514;
          }
          i = 1;
          label327:
          localObject1 = paramAbsListView;
          if (i != 0)
          {
            if ((paramInt3 != 0) && (paramInt2 - 1 != paramInt3)) {
              break label720;
            }
            localObject3 = locala.getChildAt(paramInt3);
            if (localObject3 != null) {
              break label520;
            }
            Log.w(this.djQ, "onScroll, msgView is null");
            localObject1 = paramAbsListView;
          }
        }
      }
      label375:
      if (j < paramInt2) {}
    }
    for (;;)
    {
      paramAbsListView = this.aeor;
      this.aeor = ((c.a.i)localObject1);
      if (DEBUG) {
        Log.d(this.djQ, "onScroll, newExposingMsgIds: " + localObject1 + ", originExposingMsgIds: " + paramAbsListView);
      }
      if (!c.a.a((c.a.i)localObject1))
      {
        paramInt1 = 1;
        label443:
        if (c.a.a(paramAbsListView)) {
          break label833;
        }
        paramInt2 = 1;
        label452:
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          break label851;
        }
        if (paramAbsListView != null) {
          break label838;
        }
        paramAbsListView = null;
      }
      for (;;)
      {
        this.aeos = paramAbsListView;
        if (DEBUG) {
          Log.d(this.djQ, s.X("onScroll, tempLongList: ", this.aeos));
        }
        AppMethodBeat.o(256250);
        return;
        label501:
        localObject3 = Long.valueOf(((fi)localObject1).field_msgSvrId);
        break;
        label514:
        i = 0;
        break label327;
        label520:
        float f1;
        if (localObject3 == null) {
          f1 = 0.0F;
        }
        for (;;)
        {
          if (1.0F <= f1) {
            break label720;
          }
          Log.i(this.djQ, "onScroll, fix expose");
          localObject1 = paramAbsListView;
          break;
          localObject1 = new Rect();
          ((View)localObject3).getLocalVisibleRect((Rect)localObject1);
          localObject3 = new Rect(0, 0, ((View)localObject3).getWidth(), ((View)localObject3).getHeight());
          if (DEBUG) {
            Log.d(this.djQ, "exposePercent#get, visibleContent: " + localObject1 + ", wholeContent: " + localObject3);
          }
          if ((((Rect)localObject1).isEmpty()) || (((Rect)localObject3).isEmpty()))
          {
            f1 = 0.0F;
          }
          else
          {
            float f2 = 100.0F * ((Rect)localObject1).width() * ((Rect)localObject1).height() / (((Rect)localObject3).width() * ((Rect)localObject3).height());
            f1 = f2;
            if (DEBUG)
            {
              Log.d(this.djQ, s.X("exposePercent#get, exposePercent: ", Float.valueOf(f2)));
              f1 = f2;
            }
          }
        }
        label720:
        localObject1 = paramAbsListView;
        if (paramAbsListView == null)
        {
          if (DEBUG) {
            Log.d(this.djQ, "onScroll, create newExposingMsgIds");
          }
          localObject1 = new c.a.i(paramInt2);
        }
        paramInt3 = ((c.a.i)localObject1).aeoR.length;
        if (((c.a.i)localObject1).aeoS >= paramInt3)
        {
          paramAbsListView = Arrays.copyOf(((c.a.i)localObject1).aeoR, paramInt3 * 2);
          s.s(paramAbsListView, "java.util.Arrays.copyOf(this, newSize)");
          ((c.a.i)localObject1).aeoR = paramAbsListView;
        }
        paramAbsListView = ((c.a.i)localObject1).aeoR;
        paramInt3 = ((c.a.i)localObject1).aeoS;
        ((c.a.i)localObject1).aeoS = (paramInt3 + 1);
        paramAbsListView[paramInt3] = l1;
        break label375;
        paramInt1 = 0;
        break label443;
        label833:
        paramInt2 = 0;
        break label452;
        label838:
        paramAbsListView.aeoS = 0;
        localObject1 = ah.aiuX;
      }
      label851:
      l1 = System.currentTimeMillis();
      if (paramInt2 != 0)
      {
        s.checkNotNull(paramAbsListView);
        paramInt2 = 0;
        i = paramAbsListView.aeoS;
        if (i <= 0) {}
      }
      for (;;)
      {
        paramInt3 = paramInt2 + 1;
        long l2 = paramAbsListView.aeoR[paramInt2];
        if ((localObject1 != null) && (true == ((c.a.i)localObject1).contains(l2)))
        {
          paramInt2 = 1;
          if (paramInt2 == 0)
          {
            localObject2 = (c.a.k)localLongSparseArray.get(l2);
            if (localObject2 != null) {
              ((c.a.k)localObject2).aeoV.w(Long.valueOf(l1));
            }
          }
          if (paramInt3 < i) {
            break label1110;
          }
          if (paramInt1 != 0)
          {
            s.checkNotNull(localObject1);
            paramInt1 = 0;
            paramInt3 = ((c.a.i)localObject1).aeoS;
            if (paramInt3 <= 0) {}
          }
        }
        for (;;)
        {
          paramInt2 = paramInt1 + 1;
          l2 = localObject1.aeoR[paramInt1];
          if ((paramAbsListView != null) && (true == paramAbsListView.contains(l2)))
          {
            paramInt1 = 1;
            label1001:
            if (paramInt1 == 0)
            {
              localObject2 = (c.a.k)localLongSparseArray.get(l2);
              if (localObject2 != null) {
                ((c.a.k)localObject2).aeoV.v(Long.valueOf(l1));
              }
            }
            if (paramInt2 < paramInt3) {
              break label1105;
            }
            if (paramAbsListView != null) {
              break label1092;
            }
            paramAbsListView = null;
          }
          for (;;)
          {
            this.aeos = paramAbsListView;
            if (DEBUG) {
              Log.d(this.djQ, s.X("onScroll, tempLongList: ", this.aeos));
            }
            AppMethodBeat.o(256250);
            return;
            paramInt2 = 0;
            break;
            paramInt1 = 0;
            break label1001;
            label1092:
            paramAbsListView.aeoS = 0;
            localObject1 = ah.aiuX;
          }
          label1105:
          paramInt1 = paramInt2;
        }
        label1110:
        paramInt2 = paramInt3;
      }
      paramInt3 = j;
      paramAbsListView = (AbsListView)localObject1;
      break;
      localObject1 = paramAbsListView;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/component/AppMsgWxaReportComponent$Companion$AppMsgWxaStatHelpfulInfo;", "", "msgInfo", "Lcom/tencent/mm/storage/MsgInfo;", "wxaType", "Lcom/tencent/mm/ui/chatting/component/AppMsgWxaReportComponent$Companion$AppMsgWxaType;", "wxaMsgInfo", "attachStateChangeListener", "Lcom/tencent/mm/ui/chatting/component/AppMsgWxaReportComponent$Companion$AppMsgWxaViewAttachStateChangeListener;", "(Lcom/tencent/mm/storage/MsgInfo;Lcom/tencent/mm/ui/chatting/component/AppMsgWxaReportComponent$Companion$AppMsgWxaType;Lcom/tencent/mm/storage/MsgInfo;Lcom/tencent/mm/ui/chatting/component/AppMsgWxaReportComponent$Companion$AppMsgWxaViewAttachStateChangeListener;)V", "getAttachStateChangeListener", "()Lcom/tencent/mm/ui/chatting/component/AppMsgWxaReportComponent$Companion$AppMsgWxaViewAttachStateChangeListener;", "setAttachStateChangeListener", "(Lcom/tencent/mm/ui/chatting/component/AppMsgWxaReportComponent$Companion$AppMsgWxaViewAttachStateChangeListener;)V", "getMsgInfo", "()Lcom/tencent/mm/storage/MsgInfo;", "getWxaMsgInfo", "getWxaType", "()Lcom/tencent/mm/ui/chatting/component/AppMsgWxaReportComponent$Companion$AppMsgWxaType;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a$a
  {
    final c.a.c aeot;
    final cc aeou;
    c.a.d aeov;
    final cc hTm;
    
    private a$a(cc paramcc1, c.a.c paramc, cc paramcc2)
    {
      AppMethodBeat.i(255894);
      this.hTm = paramcc1;
      this.aeot = paramc;
      this.aeou = paramcc2;
      this.aeov = null;
      AppMethodBeat.o(255894);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/component/AppMsgWxaReportComponent$Companion$AppMsgWxaType;", "", "singleChatScene", "", "groupChatScene", "(Ljava/lang/String;III)V", "toScene", "isGroupChat", "", "Update", "Dynamic", "Finder", "OpenSdk", "WithShareTicket", "Normal", "Profile", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  static enum a$c
  {
    private final int aeoE;
    private final int aeoF;
    
    static
    {
      AppMethodBeat.i(255925);
      aeoG = new c("Update", 0, 1007, 1008);
      aeoH = new c("Dynamic", 1, 1007, 1008);
      aeoI = new c("Finder", 2, 1208, 1208);
      aeoJ = new c("OpenSdk", 3, 1036, 1036);
      aeoK = new c("WithShareTicket", 4, 1044, 1044);
      aeoL = new c("Normal", 5, 1007, 1008);
      aeoM = new c("Profile", 6, 1000, 1000);
      aeoN = new c[] { aeoG, aeoH, aeoI, aeoJ, aeoK, aeoL, aeoM };
      AppMethodBeat.o(255925);
    }
    
    private a$c(int paramInt1, int paramInt2)
    {
      this.aeoE = paramInt1;
      this.aeoF = paramInt2;
    }
    
    public final int LV(boolean paramBoolean)
    {
      if (paramBoolean) {
        return this.aeoF;
      }
      return this.aeoE;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/component/AppMsgWxaReportComponent$Companion$CachedAppMsgContent;", "", "content", "Lcom/tencent/mm/message/AppMessage$Content;", "(Lcom/tencent/mm/message/AppMessage$Content;)V", "getContent", "()Lcom/tencent/mm/message/AppMessage$Content;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a$e
  {
    final k.b hWV;
    
    public a$e(k.b paramb)
    {
      this.hWV = paramb;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/component/AppMsgWxaReportComponent$Companion$CachedMsgInfo;", "", "msgInfo", "Lcom/tencent/mm/storage/MsgInfo;", "(Lcom/tencent/mm/storage/MsgInfo;)V", "getMsgInfo", "()Lcom/tencent/mm/storage/MsgInfo;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a$f
  {
    final cc hTm;
    
    public a$f(cc paramcc)
    {
      this.hTm = paramcc;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/component/AppMsgWxaReportComponent$Companion$CachedStatHelpfulInfo;", "", "helpfulInfo", "Lcom/tencent/mm/ui/chatting/component/AppMsgWxaReportComponent$Companion$AppMsgWxaStatHelpfulInfo;", "(Lcom/tencent/mm/ui/chatting/component/AppMsgWxaReportComponent$Companion$AppMsgWxaStatHelpfulInfo;)V", "getHelpfulInfo", "()Lcom/tencent/mm/ui/chatting/component/AppMsgWxaReportComponent$Companion$AppMsgWxaStatHelpfulInfo;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a$g
  {
    final c.a.a aeoP;
    
    public a$g(c.a.a parama)
    {
      this.aeoP = parama;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ui/chatting/component/AppMsgWxaReportComponent$Companion$ParseHelpfulInfoContext;", "", "msgType", "", "talker", "", "(ILjava/lang/String;)V", "cachedMsgContent", "Lcom/tencent/mm/ui/chatting/component/AppMsgWxaReportComponent$Companion$CachedAppMsgContent;", "cachedMsgInfo", "Lcom/tencent/mm/ui/chatting/component/AppMsgWxaReportComponent$Companion$CachedMsgInfo;", "getMsgType", "()I", "getTalker", "()Ljava/lang/String;", "parseMsgContent", "Lcom/tencent/mm/message/AppMessage$Content;", "parseMsgContentInternal", "parseMsgInfo", "Lcom/tencent/mm/storage/MsgInfo;", "parseMsgInfoInternal", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  static abstract class a$j
  {
    private c.a.f aeoT;
    private c.a.e aeoU;
    final int msgType;
    final String talker;
    
    public a$j(int paramInt, String paramString)
    {
      this.msgType = paramInt;
      this.talker = paramString;
    }
    
    public final cc jqO()
    {
      c.a.f localf = this.aeoT;
      if (localf != null) {
        return localf.hTm;
      }
      localf = new c.a.f(jqQ());
      this.aeoT = localf;
      return localf.hTm;
    }
    
    public final k.b jqP()
    {
      c.a.e locale = this.aeoU;
      if (locale != null) {
        return locale.hWV;
      }
      locale = new c.a.e(jqR());
      this.aeoU = locale;
      return locale.hWV;
    }
    
    protected abstract cc jqQ();
    
    protected abstract k.b jqR();
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<Boolean>
  {
    d(c paramc)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/ui/chatting/component/AppMsgWxaReportComponent$toParseContext$1", "Lcom/tencent/mm/ui/chatting/component/AppMsgWxaReportComponent$Companion$ParseHelpfulInfoContext;", "parseMsgContentInternal", "Lcom/tencent/mm/message/AppMessage$Content;", "parseMsgInfoInternal", "Lcom/tencent/mm/storage/MsgInfo;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    extends c.a.j
  {
    e(cc paramcc, c paramc, int paramInt, String paramString)
    {
      super(paramString);
    }
    
    protected final cc jqQ()
    {
      return this.aeoY;
    }
    
    protected final k.b jqR()
    {
      AppMethodBeat.i(256321);
      k.b localb = c.a(jdField_this, this.aeoY);
      AppMethodBeat.o(256321);
      return localb;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/ui/chatting/component/AppMsgWxaReportComponent$toParseContext$2", "Lcom/tencent/mm/ui/chatting/component/AppMsgWxaReportComponent$Companion$ParseHelpfulInfoContext;", "parseMsgContentInternal", "Lcom/tencent/mm/message/AppMessage$Content;", "parseMsgInfoInternal", "Lcom/tencent/mm/storage/MsgInfo;", "kotlin.jvm.PlatformType", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    extends c.a.j
  {
    f(c paramc, cc paramcc, MsgQuoteItem paramMsgQuoteItem, int paramInt, String paramString)
    {
      super(paramString);
    }
    
    protected final cc jqQ()
    {
      AppMethodBeat.i(256313);
      cc localcc = ab.e.a(this.aeoX.hlc, paramcc.field_msgId, paramMsgQuoteItem, "toParamsPack");
      AppMethodBeat.o(256313);
      return localcc;
    }
    
    protected final k.b jqR()
    {
      AppMethodBeat.i(256314);
      Object localObject = jqO();
      if (localObject == null)
      {
        AppMethodBeat.o(256314);
        return null;
      }
      localObject = c.a(this.aeoX, (cc)localObject);
      AppMethodBeat.o(256314);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.component.c
 * JD-Core Version:    0.7.0.1
 */