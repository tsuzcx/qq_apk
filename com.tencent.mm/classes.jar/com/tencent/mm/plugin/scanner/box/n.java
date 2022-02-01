package com.tencent.mm.plugin.scanner.box;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.d;
import com.tencent.mm.av.q;
import com.tencent.mm.br.c;
import com.tencent.mm.model.ab;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.u;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/scanner/box/ScanBoxShareHelper;", "Lcom/tencent/mm/ui/MMActivity$IMMOnActivityResult;", "()V", "TAG", "", "mBottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "reportData", "Landroid/os/Bundle;", "shareData", "Lcom/tencent/mm/plugin/scanner/box/ScanBoxShareData;", "shareInfo", "Lcom/tencent/mm/plugin/scanner/box/ScanBoxShareData$ScanBoxShareInfo;", "clearShareData", "", "mmOnActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onShareToFriendResult", "pushThumbToCache", "imageUrl", "setReportData", "shareToFriend", "context", "Landroid/content/Context;", "params", "showShareMenu", "updateShareData", "updateShareToFriendData", "Lorg/json/JSONObject;", "MenuId", "RequestCode", "ShareAction", "plugin-scan_release"})
public final class n
  implements MMActivity.a
{
  private static Bundle CDg;
  private static m.a CDh;
  private static final m CDi;
  public static final n CDj;
  
  static
  {
    AppMethodBeat.i(240299);
    CDj = new n();
    CDi = new m();
    AppMethodBeat.o(240299);
  }
  
  public static final void av(Bundle paramBundle)
  {
    AppMethodBeat.i(240294);
    p.h(paramBundle, "data");
    CDg = paramBundle;
    AppMethodBeat.o(240294);
  }
  
  public static final void bu(Context paramContext, String paramString)
  {
    AppMethodBeat.i(240297);
    p.h(paramContext, "context");
    n localn = CDj;
    for (;;)
    {
      try
      {
        Object localObject2 = new JSONObject(paramString).optString("url");
        paramString = CDi;
        p.g(localObject2, "url");
        p.h(localObject2, "key");
        CDh = (m.a)paramString.CDe.get(localObject2);
        Object localObject1 = new StringBuilder("shareToFriend, imageUrl: ");
        paramString = CDh;
        if (paramString != null)
        {
          paramString = paramString.imageUrl;
          localObject1 = ((StringBuilder)localObject1).append(paramString).append(", desc: ");
          paramString = CDh;
          if (paramString != null)
          {
            paramString = paramString.CDf;
            if (paramString != null)
            {
              paramString = paramString.description;
              localObject1 = ((StringBuilder)localObject1).append(paramString).append(", title: ");
              paramString = CDh;
              if (paramString == null) {
                continue;
              }
              paramString = paramString.CDf;
              if (paramString == null) {
                continue;
              }
              paramString = paramString.title;
              Log.i("MicroMsg.ScanBoxShareHelper", paramString + ", url: " + (String)localObject2);
              HashMap localHashMap = new HashMap();
              paramString = CDh;
              if (paramString == null) {
                break label501;
              }
              localObject1 = paramString.imageUrl;
              paramString = (String)localObject1;
              if (localObject1 == null) {
                break label501;
              }
              localHashMap.put("img_url", paramString);
              paramString = CDh;
              if (paramString == null) {
                break label507;
              }
              paramString = paramString.CDf;
              if (paramString == null) {
                break label507;
              }
              localObject1 = paramString.description;
              paramString = (String)localObject1;
              if (localObject1 == null) {
                break label507;
              }
              localHashMap.put("desc", paramString);
              paramString = CDh;
              if (paramString == null) {
                break label513;
              }
              paramString = paramString.CDf;
              if (paramString == null) {
                break label513;
              }
              localObject1 = paramString.title;
              paramString = (String)localObject1;
              if (localObject1 == null) {
                break label513;
              }
              localHashMap.put("title", paramString);
              localHashMap.put("url", localObject2);
              localObject2 = new Intent();
              ((Intent)localObject2).putExtra("webview_params", (Serializable)localHashMap);
              ((Intent)localObject2).putExtra("Select_Conv_Type", 3);
              ((Intent)localObject2).putExtra("scene_from", 2);
              ((Intent)localObject2).putExtra("mutil_select_is_ret", true);
              ((Intent)localObject2).putExtra("Retr_Msg_Type", 2);
              if (!(paramContext instanceof MMActivity)) {
                continue;
              }
              paramString = CDh;
              if (paramString == null) {
                break label519;
              }
              localObject1 = paramString.imageUrl;
              paramString = (String)localObject1;
              if (localObject1 == null) {
                break label519;
              }
              localObject1 = (CharSequence)paramString;
              if (localObject1 == null) {
                break label525;
              }
              if (((CharSequence)localObject1).length() != 0) {
                continue;
              }
              break label525;
              if ((i == 0) && (kotlin.n.n.J(paramString, "http", false))) {
                q.bcQ().a(paramString, null);
              }
              c.a((MMActivity)paramContext, ".ui.transmit.SelectConversationUI", (Intent)localObject2, 1, (MMActivity.a)localn);
              AppMethodBeat.o(240297);
            }
          }
        }
        else
        {
          paramString = null;
          continue;
        }
        paramString = null;
        continue;
        paramString = null;
        continue;
        i = 0;
        continue;
        paramString = "";
      }
      catch (Exception paramContext)
      {
        Log.printErrStackTrace("MicroMsg.ScanBoxShareHelper", (Throwable)paramContext, "shareToFriend exception", new Object[0]);
        AppMethodBeat.o(240297);
        return;
      }
      label501:
      continue;
      label507:
      paramString = "";
      continue;
      label513:
      paramString = "";
      continue;
      label519:
      paramString = "";
      continue;
      label525:
      int i = 1;
    }
  }
  
  public static final void ePw()
  {
    AppMethodBeat.i(240296);
    CDi.CDe.clear();
    AppMethodBeat.o(240296);
  }
  
  public static final void updateShareData(String paramString)
  {
    AppMethodBeat.i(240295);
    Object localObject1 = (CharSequence)paramString;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.e("MicroMsg.ScanBoxShareHelper", "updateShareData params is invalid");
      AppMethodBeat.o(240295);
      return;
    }
    localObject1 = new JSONObject(paramString);
    i = ((JSONObject)localObject1).optInt("action");
    Log.i("MicroMsg.ScanBoxShareHelper", "alvinluo updateShareData action: %d", new Object[] { Integer.valueOf(i) });
    switch (i)
    {
    default: 
      AppMethodBeat.o(240295);
      return;
    }
    paramString = ((JSONObject)localObject1).optString("url");
    if (paramString == null) {
      paramString = "";
    }
    for (;;)
    {
      Object localObject2 = ((JSONObject)localObject1).optString("title");
      String str1 = ((JSONObject)localObject1).optString("desc");
      String str2 = ((JSONObject)localObject1).optString("image_url");
      Log.i("MicroMsg.ScanBoxShareHelper", "shareToFriend, imageUrl: " + str2 + ", desc: " + str1 + ", title: " + (String)localObject2 + ", url: " + paramString);
      localObject1 = new m.a(r.bm((JSONObject)localObject1), str2);
      localObject2 = CDi;
      p.h(paramString, "key");
      ((Map)((m)localObject2).CDe).put(paramString, localObject1);
      break;
    }
  }
  
  public final void d(int paramInt1, int paramInt2, Intent paramIntent)
  {
    String str = null;
    AppMethodBeat.i(240298);
    Object localObject1 = new StringBuilder("onActivityResult requestCode: ").append(paramInt1).append(", resultCode: ").append(paramInt2).append(", data == null: ");
    boolean bool;
    if (paramIntent == null)
    {
      bool = true;
      Log.i("MicroMsg.ScanBoxShareHelper", bool);
      switch (paramInt1)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(240298);
      return;
      bool = false;
      break;
      switch (paramInt2)
      {
      default: 
        break;
      case -1: 
        if (CDh != null)
        {
          localObject1 = CDh;
          if (localObject1 == null) {
            break label187;
          }
        }
      case 0: 
        label187:
        for (localObject1 = ((m.a)localObject1).CDf; localObject1 == null; localObject1 = null)
        {
          Log.e("MicroMsg.ScanBoxShareHelper", "onShareToFriendResult shareInfo invalid");
          AppMethodBeat.o(240298);
          return;
          Log.w("MicroMsg.ScanBoxShareHelper", "onShareToFriendResult cancel");
          s.aw(CDg);
          AppMethodBeat.o(240298);
          return;
        }
        if (paramIntent != null)
        {
          localObject1 = paramIntent.getStringExtra("Select_Conv_User");
          localObject2 = (CharSequence)localObject1;
          if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
            break label255;
          }
        }
        label255:
        for (paramInt1 = 1;; paramInt1 = 0)
        {
          if (paramInt1 == 0) {
            break label260;
          }
          Log.e("MicroMsg.ScanBoxShareHelper", "onShareToFriendResult fail, toUser is null");
          AppMethodBeat.o(240298);
          return;
          localObject1 = null;
          break;
        }
        label260:
        Object localObject2 = paramIntent.getStringExtra("custom_send_text");
        paramIntent = (Intent)localObject2;
        if (localObject2 == null) {
          paramIntent = "";
        }
        localObject2 = r.CDy;
        localObject2 = CDh;
        if (localObject2 == null) {
          p.hyc();
        }
        localObject2 = ((m.a)localObject2).CDf;
        m.a locala = CDh;
        if (locala != null) {
          str = locala.imageUrl;
        }
        bool = r.b((WXMediaMessage)localObject2, (String)localObject1, str, paramIntent);
        Log.i("MicroMsg.ScanBoxShareHelper", "onShareToFriendResult sendOk: %b", new Object[] { Boolean.valueOf(bool) });
        if (bool) {
          h.RTc.n((Runnable)a.CDk, 200L);
        }
        s.b(bool, ab.Eq((String)localObject1), CDg);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    public static final a CDk;
    
    static
    {
      AppMethodBeat.i(240293);
      CDk = new a();
      AppMethodBeat.o(240293);
    }
    
    public final void run()
    {
      AppMethodBeat.i(240292);
      u.cG(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(2131755979));
      AppMethodBeat.o(240292);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.n
 * JD-Core Version:    0.7.0.1
 */