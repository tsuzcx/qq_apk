package com.tencent.mm.plugin.textstatus.conversation.g;

import android.content.Context;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.api.f;
import com.tencent.mm.plugin.appbrand.api.g;
import com.tencent.mm.plugin.appbrand.config.z;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.textstatus.conversation.d.d;
import com.tencent.mm.plugin.textstatus.util.e;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.p.a;
import com.tencent.mm.util.b.a;
import com.tencent.mm.util.i;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/textstatus/conversation/service/TextStatusMiniAppService;", "", "()V", "MINIAPP_USERNAME", "", "TAG", "getComOpenBundle", "Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;", "snapShot", "getSnapShotPath", "activity", "Lcom/tencent/mm/ui/MMActivity;", "goMiniApp", "", "context", "Landroid/content/Context;", "encUserName", "scene", "greetItem", "Lcom/tencent/mm/plugin/textstatus/conversation/data/TextStatusGreetingItem;", "preRenderMiniApp", "preRenderUserlist", "", "plugin-textstatus_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c Tjw;
  
  static
  {
    AppMethodBeat.i(291183);
    Tjw = new c();
    AppMethodBeat.o(291183);
  }
  
  private static final String G(List paramList, String paramString)
  {
    AppMethodBeat.i(291161);
    JSONObject localJSONObject = new JSONObject();
    if (paramList != null)
    {
      if (!((Collection)paramList).isEmpty()) {
        i = 1;
      }
      while (i != 0)
      {
        JSONArray localJSONArray = new JSONArray();
        paramList = ((Iterable)paramList).iterator();
        for (;;)
        {
          if (paramList.hasNext())
          {
            localJSONArray.put((String)paramList.next());
            continue;
            i = 0;
            break;
          }
        }
        localJSONObject.put("enc_usernames", localJSONArray);
      }
    }
    localJSONObject.put("isprerender", true);
    paramList = (CharSequence)paramString;
    if ((paramList == null) || (n.bp(paramList))) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        localJSONObject.put("scene", paramString);
      }
      paramList = localJSONObject.toString();
      s.s(paramList, "jsonObj.toString()");
      AppMethodBeat.o(291161);
      return paramList;
    }
  }
  
  private static final String a(String paramString1, d paramd, String paramString2)
  {
    AppMethodBeat.i(291172);
    JSONObject localJSONObject = new JSONObject();
    String str = paramString1;
    if (paramString1 == null) {
      str = "";
    }
    localJSONObject.put("enc_username", str);
    if (paramd != null)
    {
      localJSONObject.put("session_id", paramd.field_session_id);
      localJSONObject.put("hash_username", paramd.field_hash_username);
      localJSONObject.put("tag", paramd.field_tag);
      localJSONObject.put("source_id", paramd.field_source_id);
      localJSONObject.put("plain", paramd.field_plain);
      localJSONObject.put("status_id", paramd.field_status_id);
      localJSONObject.put("modify_count", paramd.field_modify_count);
      localJSONObject.put("card_key", paramd.field_card_key);
    }
    paramString1 = (CharSequence)paramString2;
    if ((paramString1 == null) || (n.bp(paramString1))) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        localJSONObject.put("scene", paramString2);
      }
      paramString1 = localJSONObject.toString();
      s.s(paramString1, "jsonObj.toString()");
      AppMethodBeat.o(291172);
      return paramString1;
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, d paramd)
  {
    AppMethodBeat.i(291111);
    s.u(paramContext, "context");
    Log.d("MicroMsg.TextStatus.TextStatusMiniAppService", "goMiniApp() called with: context = " + paramContext + " un =" + paramString1);
    if (((t)h.ax(t.class)).cAy()) {
      if ((paramContext instanceof MMActivity)) {
        localObject = (MMActivity)paramContext;
      }
    }
    for (Object localObject = t((MMActivity)localObject);; localObject = "")
    {
      localObject = bdM((String)localObject);
      ((g)localObject).qAG = new c..ExternalSyntheticLambda0(paramString1, paramd, paramString2);
      ((t)h.ax(t.class)).a(paramContext, (g)localObject);
      AppMethodBeat.o(291111);
      return;
      localObject = null;
      break;
    }
  }
  
  public static void a(Context paramContext, List<String> paramList, String paramString)
  {
    AppMethodBeat.i(291098);
    s.u(paramContext, "context");
    Log.d("MicroMsg.TextStatus.TextStatusMiniAppService", "preRenderMiniApp() called with: context = " + paramContext + " preRenderUserlist=" + paramList);
    paramContext = bdM("");
    paramContext.qAG = new c..ExternalSyntheticLambda1(paramList, paramString);
    ((t)h.ax(t.class)).b(paramContext, (f)new c.a());
    AppMethodBeat.o(291098);
  }
  
  private static g bdM(String paramString)
  {
    int i = 0;
    AppMethodBeat.i(291153);
    g localg = new g();
    localg.username = "gh_390359b3fd13@app";
    localg.scene = 1209;
    i locali = i.agtt;
    if (s.p(i.a(b.a.agri, Integer.valueOf(0)), Integer.valueOf(1))) {
      i = 2;
    }
    localg.euz = i;
    localg.qAF = "pages/detail/detail.html";
    localg.epq = z.raW;
    localg.ept = com.tencent.mm.plugin.appbrand.config.y.raT;
    localg.epu = com.tencent.mm.plugin.appbrand.config.y.raT;
    localg.qAY = true;
    localg.epr = paramString;
    AppMethodBeat.o(291153);
    return localg;
  }
  
  private static String t(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(291136);
    if (paramMMActivity == null)
    {
      AppMethodBeat.o(291136);
      return "";
    }
    try
    {
      paramMMActivity = paramMMActivity.getWindow().getDecorView();
      s.s(paramMMActivity, "activity.window.decorView");
      paramMMActivity = a.a(paramMMActivity, paramMMActivity.getWidth(), paramMMActivity.getHeight(), false, Bitmap.Config.RGB_565);
      if (paramMMActivity != null)
      {
        Object localObject = e.TAU;
        localObject = s.X(e.hKp(), "/snapshot");
        if (com.tencent.mm.vfs.y.ZC((String)localObject)) {
          com.tencent.mm.vfs.y.deleteFile((String)localObject);
        }
        BitmapUtil.saveBitmapToImage(paramMMActivity, 100, Bitmap.CompressFormat.JPEG, (String)localObject, true);
        AppMethodBeat.o(291136);
        return localObject;
      }
    }
    finally
    {
      Log.printErrStackTrace("MicroMsg.TextStatus.TextStatusMiniAppService", paramMMActivity, "getSnapShot err", new Object[0]);
      AppMethodBeat.o(291136);
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.conversation.g.c
 * JD-Core Version:    0.7.0.1
 */