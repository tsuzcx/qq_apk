package com.tencent.mm.plugin.textstatus.third;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.service.s.a;
import com.tencent.mm.plugin.textstatus.proto.TextStatusExtInfo;
import com.tencent.mm.plugin.textstatus.proto.TextStatusJumpInfo;
import com.tencent.mm.plugin.textstatus.proto.TextStatusTopicInfo;
import com.tencent.mm.plugin.textstatus.proto.ay;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.u;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/third/ExtJumpInfoHandler;", "", "()V", "TAG", "", "updaterMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/textstatus/third/ExtJumpInfoHandler$JumpInfoUpdater;", "Lkotlin/collections/HashMap;", "getUpdaterMap", "()Ljava/util/HashMap;", "callCgiAndUpdate", "", "reqInfos", "", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "callback", "Lkotlin/Function0;", "preprocessExtInfo2", "extInfoIn", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusExtInfo;", "Lkotlin/Function1;", "FinderJumpInfoUpdater", "JumpInfoUpdater", "WeAppJumpInfoUpdater", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a Tuv;
  private static final HashMap<String, b> Tuw;
  
  static
  {
    AppMethodBeat.i(290132);
    Tuv = new a();
    HashMap localHashMap = new HashMap();
    localHashMap.put("5", a.a.Tux);
    localHashMap.put("7", c.Tuy);
    Tuw = localHashMap;
    AppMethodBeat.o(290132);
  }
  
  public final void a(final TextStatusExtInfo paramTextStatusExtInfo, b<? super TextStatusExtInfo, ah> paramb)
  {
    AppMethodBeat.i(290149);
    kotlin.g.b.s.u(paramTextStatusExtInfo, "extInfoIn");
    kotlin.g.b.s.u(paramb, "callback");
    Object localObject1 = paramTextStatusExtInfo.topicInfo.jumpInfos;
    kotlin.g.b.s.s(localObject1, "extInfoIn.topicInfo.jumpInfos");
    Object localObject2 = (List)localObject1;
    localObject1 = paramTextStatusExtInfo.topicInfo.sourceJumpInfos;
    kotlin.g.b.s.s(localObject1, "extInfoIn.topicInfo.sourceJumpInfos");
    Object localObject3 = (List)localObject1;
    localObject1 = (List)new LinkedList();
    localObject2 = j.lu((List)localObject2);
    localObject3 = j.lu((List)localObject3);
    if ((localObject2 != null) && (j.a((TextStatusJumpInfo)localObject2) == true))
    {
      i = 1;
      if (i != 0) {
        ((List)localObject1).add(localObject2);
      }
      if ((localObject3 == null) || (j.a((TextStatusJumpInfo)localObject3) != true)) {
        break label178;
      }
    }
    label178:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        ((List)localObject1).add(localObject3);
      }
      if (!((List)localObject1).isEmpty()) {
        break label183;
      }
      paramb.invoke(paramTextStatusExtInfo);
      AppMethodBeat.o(290149);
      return;
      i = 0;
      break;
    }
    label183:
    a((List)localObject1, (kotlin.g.a.a)new e(paramb, paramTextStatusExtInfo));
    AppMethodBeat.o(290149);
  }
  
  public final void a(List<TextStatusJumpInfo> paramList, final kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(290167);
    for (;;)
    {
      kotlin.g.b.s.u(paramList, "reqInfos");
      kotlin.g.b.s.u(parama, "callback");
      if (paramList.isEmpty())
      {
        parama.invoke();
        AppMethodBeat.o(290167);
        return;
      }
      try
      {
        TextStatusJumpInfo localTextStatusJumpInfo = (TextStatusJumpInfo)paramList.remove(0);
        b localb = (b)Tuw.get(localTextStatusJumpInfo.jumpType);
        if (localb != null)
        {
          localb.a(localTextStatusJumpInfo, (kotlin.g.a.a)new d(paramList, parama));
          AppMethodBeat.o(290167);
          return;
        }
        a(paramList, parama);
        AppMethodBeat.o(290167);
        return;
      }
      finally {}
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/third/ExtJumpInfoHandler$JumpInfoUpdater;", "", "update", "", "reqInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "callback", "Lkotlin/Function0;", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface b
  {
    public abstract void a(TextStatusJumpInfo paramTextStatusJumpInfo, kotlin.g.a.a<ah> parama);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/third/ExtJumpInfoHandler$WeAppJumpInfoUpdater;", "Lcom/tencent/mm/plugin/textstatus/third/ExtJumpInfoHandler$JumpInfoUpdater;", "()V", "update", "", "reqInfo", "Lcom/tencent/mm/plugin/textstatus/proto/TextStatusJumpInfo;", "callback", "Lkotlin/Function0;", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements a.b
  {
    public static final c Tuy;
    
    static
    {
      AppMethodBeat.i(290148);
      Tuy = new c();
      AppMethodBeat.o(290148);
    }
    
    public final void a(final TextStatusJumpInfo paramTextStatusJumpInfo, final kotlin.g.a.a<ah> parama)
    {
      AppMethodBeat.i(290159);
      kotlin.g.b.s.u(paramTextStatusJumpInfo, "reqInfo");
      kotlin.g.b.s.u(parama, "callback");
      Object localObject = Base64.decode(paramTextStatusJumpInfo.keyBusiBuf, 0);
      final ay localay = new ay();
      localay.parseFrom((byte[])localObject);
      localObject = localay.username;
      ((com.tencent.mm.plugin.appbrand.service.s)h.ax(com.tencent.mm.plugin.appbrand.service.s.class)).c((String)localObject, (s.a)new a((String)localObject, localay, paramTextStatusJumpInfo, parama));
      AppMethodBeat.o(290159);
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/textstatus/third/ExtJumpInfoHandler$WeAppJumpInfoUpdater$update$1", "Lcom/tencent/mm/plugin/appbrand/service/IWeAppInfoService$IGetWeAppInfoCallback;", "onGetWeAppInfo", "", "info", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements s.a
    {
      a(String paramString, ay paramay, TextStatusJumpInfo paramTextStatusJumpInfo, kotlin.g.a.a<ah> parama) {}
      
      public final void onGetWeAppInfo(WxaAttributes paramWxaAttributes)
      {
        AppMethodBeat.i(290082);
        Log.i("MicroMsg.TextStatus.ExtJumpInfoHandler", kotlin.g.b.s.X("onGetWeAppInfo() called with: info = ", paramWxaAttributes));
        JSONObject localJSONObject;
        Object localObject;
        if (paramWxaAttributes != null)
        {
          localJSONObject = new JSONObject();
          localJSONObject.put("username", this.pmW);
          localJSONObject.put("path", localay.path);
          localObject = paramWxaAttributes.clf();
          if (localObject != null) {
            break label142;
          }
        }
        label142:
        for (int i = 0;; i = ((WxaAttributes.WxaVersionInfo)localObject).appVersion)
        {
          localJSONObject.put("version", i);
          localJSONObject.put("versionType", localay.Tqb);
          localObject = paramWxaAttributes.field_smallHeadURL;
          paramWxaAttributes = (WxaAttributes)localObject;
          if (localObject == null) {
            paramWxaAttributes = "";
          }
          localJSONObject.put("headImageURL", paramWxaAttributes);
          paramTextStatusJumpInfo.busiBuf = localJSONObject.toString();
          parama.invoke();
          AppMethodBeat.o(290082);
          return;
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<ah>
  {
    d(List<TextStatusJumpInfo> paramList, kotlin.g.a.a<ah> parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(b<? super TextStatusExtInfo, ah> paramb, TextStatusExtInfo paramTextStatusExtInfo)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.third.a
 * JD-Core Version:    0.7.0.1
 */