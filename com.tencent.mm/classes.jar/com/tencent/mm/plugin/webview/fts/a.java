package com.tencent.mm.plugin.webview.fts;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.f.b.a.ah;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.plugin.websearch.api.ar;
import com.tencent.mm.plugin.websearch.api.v;
import com.tencent.mm.plugin.webview.modeltools.f;
import com.tencent.mm.protocal.protobuf.flh;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/webview/fts/ChatSearchLogic;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "THREAD_TAG", "mJSCallback", "Lcom/tencent/mm/plugin/webview/fts/PreGetController$JSCallback;", "getCgiAction", "content", "getChatSearchData", "", "params", "", "", "getSessionId", "url", "onDataBack", "", "tag", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "reportAction", "action", "sessionId", "cgiRet", "cgiAction", "start", "stop", "plugin-webview_release"})
public final class a
  implements com.tencent.mm.an.i
{
  public static final h.a PKf;
  public static final a PKg;
  public static final String TAG = "MicroMsg.WebSearch.ChatSearchLogic";
  private static final String THREAD_TAG = "WebSearch.ChatSearchLogic";
  
  static
  {
    AppMethodBeat.i(253416);
    PKg = new a();
    TAG = "MicroMsg.WebSearch.ChatSearchLogic";
    THREAD_TAG = "WebSearch.ChatSearchLogic";
    PKf = (h.a)b.PKi;
    AppMethodBeat.o(253416);
  }
  
  private static void b(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2)
  {
    AppMethodBeat.i(253406);
    ah localah = new ah();
    localah.le(paramInt1);
    localah.lg(paramInt2);
    localah.iZ("");
    localah.ja("");
    localah.lh(0);
    localah.iX(paramString1);
    localah.cq(System.currentTimeMillis());
    localah.li(paramInt3);
    localah.jc(paramString2);
    localah.bpa();
    ar.a((com.tencent.mm.plugin.report.a)localah);
    AppMethodBeat.o(253406);
  }
  
  public static String bjQ(String paramString)
  {
    AppMethodBeat.i(253401);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(253401);
      return "";
    }
    try
    {
      localObject = Uri.parse(paramString).getQueryParameter("sessionId");
      paramString = (String)localObject;
      if (localObject == null) {
        paramString = "";
      }
      AppMethodBeat.o(253401);
      return paramString;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(253401);
    }
    return "";
  }
  
  private static String bjR(String paramString)
  {
    AppMethodBeat.i(253403);
    Object localObject = (CharSequence)paramString;
    if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(253403);
      return "";
    }
    try
    {
      localObject = new JSONObject(paramString).optString("action");
      paramString = (String)localObject;
      if (localObject == null) {
        paramString = "";
      }
      AppMethodBeat.o(253403);
      return paramString;
    }
    catch (Exception paramString)
    {
      AppMethodBeat.o(253403);
    }
    return "";
  }
  
  private static void ms(String paramString1, String paramString2)
  {
    AppMethodBeat.i(253413);
    j localj = f.gWr();
    p.j(localj, "SubCoreTools.getFTSWebSearchLogic()");
    localj.gTv().a(0, paramString2, paramString1, PKf);
    AppMethodBeat.o(253413);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(253411);
    if ((paramq instanceof aa)) {
      if (!TextUtils.isEmpty((CharSequence)((aa)paramq).gQy().content))
      {
        paramString = ((aa)paramq).gQy().content;
        p.j(paramString, "scene.model.content");
      }
    }
    for (;;)
    {
      flh localflh = ((aa)paramq).gQD();
      Object localObject1 = ((aa)paramq).gQy();
      Object localObject2;
      int i;
      if ((localflh != null) && (localObject1 != null))
      {
        localObject2 = (CharSequence)((v)localObject1).Pyp;
        if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0))
        {
          i = 1;
          label109:
          if (i == 0)
          {
            localObject2 = ((v)localObject1).Pyp;
            p.j(localObject2, "model.imageSearchSessionId");
            b(7, (String)localObject2, ((v)localObject1).scene, paramInt2, bjR(((v)localObject1).content));
          }
          if ((paramInt1 == 0) && (paramInt2 == 0)) {
            break label283;
          }
          Log.i(TAG, "net scene fail requestId:" + ((aa)paramq).gQy().fIY + " reqKey:" + ((aa)paramq).gQy().fwv);
          paramq = new JSONObject();
        }
      }
      try
      {
        paramq.put("ret", -1);
        label228:
        paramq = paramq.toString();
        p.j(paramq, "resultObject.toString()");
        ms(paramq, paramString);
        AppMethodBeat.o(253411);
        return;
        paramString = ((aa)paramq).gQy().fIY;
        p.j(paramString, "scene.model.requestId");
        continue;
        i = 0;
        break label109;
        label283:
        localObject1 = TAG;
        localObject2 = new StringBuilder("net scene success requestId:").append(((aa)paramq).gQy().fIY).append(" reqKey:").append(((aa)paramq).gQy().fwv).append(" jsonStr:");
        paramq = localflh.RSB;
        if (paramq != null) {}
        for (paramq = Integer.valueOf(paramq.length());; paramq = null)
        {
          Log.i((String)localObject1, paramq);
          paramq = localflh.RSB;
          p.j(paramq, "response.json_str");
          ms(paramq, paramString);
          AppMethodBeat.o(253411);
          return;
        }
      }
      catch (Exception localException)
      {
        break label228;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  public static final class a
    implements Runnable
  {
    public a(v paramv) {}
    
    public final void run()
    {
      AppMethodBeat.i(225091);
      Object localObject = new aa(this.PKh);
      com.tencent.mm.kernel.h.aGY().b((q)localObject);
      localObject = a.PKg;
      localObject = this.PKh.Pyp;
      p.j(localObject, "model.imageSearchSessionId");
      int i = this.PKh.scene;
      a locala = a.PKg;
      a.Q((String)localObject, i, a.bjS(this.PKh.content));
      AppMethodBeat.o(225091);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/webview/fts/PreGetController$ReqStatus;", "kotlin.jvm.PlatformType", "handleCallback"})
  static final class b
    implements h.a
  {
    public static final b PKi;
    
    static
    {
      AppMethodBeat.i(242502);
      PKi = new b();
      AppMethodBeat.o(242502);
    }
    
    public final void a(h.b paramb)
    {
      AppMethodBeat.i(242501);
      if (((paramb.PLd instanceof v)) && ((paramb.PLe instanceof String)))
      {
        Object localObject = paramb.PLd;
        if (localObject == null)
        {
          paramb = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.websearch.api.NetSceneRequestModel");
          AppMethodBeat.o(242501);
          throw paramb;
        }
        localObject = (v)localObject;
        com.tencent.mm.plugin.webview.ui.tools.jsapi.h localh = com.tencent.mm.plugin.webview.ui.tools.jsapi.i.aoU(((v)localObject).fPp);
        paramb = paramb.PLe;
        if (paramb == null)
        {
          paramb = new kotlin.t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(242501);
          throw paramb;
        }
        localh.mH((String)paramb, ((v)localObject).fIY);
      }
      AppMethodBeat.o(242501);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.fts.a
 * JD-Core Version:    0.7.0.1
 */