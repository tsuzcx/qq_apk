package com.tencent.mm.plugin.scanner.box;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.modelimage.e;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.scanner.l.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.aa;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/scanner/box/ScanBoxShareHelper;", "Lcom/tencent/mm/ui/MMActivity$IMMOnActivityResult;", "()V", "TAG", "", "mBottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "reportData", "Landroid/os/Bundle;", "shareData", "Lcom/tencent/mm/plugin/scanner/box/ScanBoxShareData;", "shareInfo", "Lcom/tencent/mm/plugin/scanner/box/ScanBoxShareData$ScanBoxShareInfo;", "clearShareData", "", "mmOnActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onShareToFriendResult", "pushThumbToCache", "imageUrl", "setReportData", "shareToFriend", "context", "Landroid/content/Context;", "params", "showShareMenu", "updateShareData", "updateShareToFriendData", "Lorg/json/JSONObject;", "MenuId", "RequestCode", "ShareAction", "plugin-scan_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
  implements MMActivity.a
{
  public static final n ONK;
  private static Bundle ONL;
  private static m.a ONM;
  private static final m ONN;
  
  static
  {
    AppMethodBeat.i(313782);
    ONK = new n();
    ONN = new m();
    AppMethodBeat.o(313782);
  }
  
  public static final void aQ(Bundle paramBundle)
  {
    AppMethodBeat.i(313748);
    kotlin.g.b.s.u(paramBundle, "data");
    ONL = paramBundle;
    AppMethodBeat.o(313748);
  }
  
  public static final void bJ(Context paramContext, String paramString)
  {
    AppMethodBeat.i(313773);
    kotlin.g.b.s.u(paramContext, "context");
    n localn = ONK;
    label548:
    for (;;)
    {
      try
      {
        Object localObject2 = new JSONObject(paramString).optString("url");
        paramString = ONN;
        kotlin.g.b.s.s(localObject2, "url");
        kotlin.g.b.s.u(localObject2, "key");
        ONM = (m.a)paramString.ONI.get(localObject2);
        Object localObject1 = new StringBuilder("shareToFriend, imageUrl: ");
        paramString = ONM;
        int i;
        if (paramString == null)
        {
          paramString = null;
          localObject1 = ((StringBuilder)localObject1).append(paramString).append(", desc: ");
          paramString = ONM;
          if (paramString == null)
          {
            paramString = null;
            localObject1 = ((StringBuilder)localObject1).append(paramString).append(", title: ");
            paramString = ONM;
            if (paramString != null) {
              continue;
            }
            paramString = null;
            Log.i("MicroMsg.ScanBoxShareHelper", paramString + ", url: " + localObject2);
            HashMap localHashMap = new HashMap();
            paramString = ONM;
            if (paramString != null) {
              continue;
            }
            paramString = "";
            localHashMap.put("img_url", paramString);
            paramString = ONM;
            if (paramString != null) {
              continue;
            }
            paramString = "";
            localHashMap.put("desc", paramString);
            paramString = ONM;
            if (paramString != null) {
              continue;
            }
            paramString = "";
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
            paramString = ONM;
            if (paramString != null) {
              continue;
            }
            paramString = "";
            localObject1 = (CharSequence)paramString;
            if (localObject1 == null) {
              break label548;
            }
            if (((CharSequence)localObject1).length() != 0) {
              continue;
            }
            break label548;
            if ((i == 0) && (kotlin.n.n.U(paramString, "http", false))) {
              com.tencent.mm.modelimage.r.bJZ().a(paramString, true, null);
            }
            c.a((MMActivity)paramContext, ".ui.transmit.SelectConversationUI", (Intent)localObject2, 1, (MMActivity.a)localn);
            AppMethodBeat.o(313773);
          }
        }
        else
        {
          paramString = paramString.imageUrl;
          continue;
        }
        paramString = paramString.ONJ;
        if (paramString == null)
        {
          paramString = null;
        }
        else
        {
          paramString = paramString.description;
          continue;
          paramString = paramString.ONJ;
          if (paramString == null)
          {
            paramString = null;
          }
          else
          {
            paramString = paramString.title;
            continue;
            localObject1 = paramString.imageUrl;
            paramString = (String)localObject1;
            if (localObject1 == null)
            {
              paramString = "";
              continue;
              paramString = paramString.ONJ;
              if (paramString == null)
              {
                paramString = "";
              }
              else
              {
                localObject1 = paramString.description;
                paramString = (String)localObject1;
                if (localObject1 == null)
                {
                  paramString = "";
                  continue;
                  paramString = paramString.ONJ;
                  if (paramString == null)
                  {
                    paramString = "";
                  }
                  else
                  {
                    localObject1 = paramString.title;
                    paramString = (String)localObject1;
                    if (localObject1 == null)
                    {
                      paramString = "";
                      continue;
                      localObject1 = paramString.imageUrl;
                      paramString = (String)localObject1;
                      if (localObject1 == null)
                      {
                        paramString = "";
                        continue;
                        i = 0;
                        continue;
                        i = 1;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
      catch (Exception paramContext)
      {
        Log.printErrStackTrace("MicroMsg.ScanBoxShareHelper", (Throwable)paramContext, "shareToFriend exception", new Object[0]);
        AppMethodBeat.o(313773);
        return;
      }
    }
  }
  
  public static final void gPT()
  {
    AppMethodBeat.i(313762);
    ONN.ONI.clear();
    AppMethodBeat.o(313762);
  }
  
  private static final void gPU()
  {
    AppMethodBeat.i(313779);
    aa.db(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(l.i.app_sent));
    AppMethodBeat.o(313779);
  }
  
  public static final void updateShareData(String paramString)
  {
    AppMethodBeat.i(313755);
    Object localObject1 = (CharSequence)paramString;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.e("MicroMsg.ScanBoxShareHelper", "updateShareData params is invalid");
      AppMethodBeat.o(313755);
      return;
    }
    localObject1 = new JSONObject(paramString);
    i = ((JSONObject)localObject1).optInt("action");
    Log.i("MicroMsg.ScanBoxShareHelper", "alvinluo updateShareData action: %d", new Object[] { Integer.valueOf(i) });
    if (i == 1)
    {
      paramString = ((JSONObject)localObject1).optString("url");
      if (paramString != null) {
        break label225;
      }
      paramString = "";
    }
    label225:
    for (;;)
    {
      Object localObject2 = ((JSONObject)localObject1).optString("title");
      String str1 = ((JSONObject)localObject1).optString("desc");
      String str2 = ((JSONObject)localObject1).optString("image_url");
      Log.i("MicroMsg.ScanBoxShareHelper", "shareToFriend, imageUrl: " + str2 + ", desc: " + str1 + ", title: " + localObject2 + ", url: " + paramString);
      localObject1 = new m.a(r.bM((JSONObject)localObject1), str2);
      localObject2 = ONN;
      kotlin.g.b.s.u(paramString, "key");
      ((Map)((m)localObject2).ONI).put(paramString, localObject1);
      AppMethodBeat.o(313755);
      return;
    }
  }
  
  public final void mmOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    String str = null;
    AppMethodBeat.i(313809);
    Object localObject1 = new StringBuilder("onActivityResult requestCode: ").append(paramInt1).append(", resultCode: ").append(paramInt2).append(", data == null: ");
    if (paramIntent == null) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.ScanBoxShareHelper", bool);
      if (paramInt1 == 1) {}
      switch (paramInt2)
      {
      default: 
        AppMethodBeat.o(313809);
        return;
      }
    }
    Log.w("MicroMsg.ScanBoxShareHelper", "onShareToFriendResult cancel");
    s.aR(ONL);
    AppMethodBeat.o(313809);
    return;
    if (ONM != null)
    {
      localObject1 = ONM;
      if (localObject1 != null) {
        break label165;
      }
    }
    label165:
    for (localObject1 = null; localObject1 == null; localObject1 = ((m.a)localObject1).ONJ)
    {
      Log.e("MicroMsg.ScanBoxShareHelper", "onShareToFriendResult shareInfo invalid");
      AppMethodBeat.o(313809);
      return;
    }
    if (paramIntent == null)
    {
      localObject1 = null;
      localObject2 = (CharSequence)localObject1;
      if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
        break label237;
      }
    }
    label237:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 == 0) {
        break label242;
      }
      Log.e("MicroMsg.ScanBoxShareHelper", "onShareToFriendResult fail, toUser is null");
      AppMethodBeat.o(313809);
      return;
      localObject1 = paramIntent.getStringExtra("Select_Conv_User");
      break;
    }
    label242:
    Object localObject2 = paramIntent.getStringExtra("custom_send_text");
    paramIntent = (Intent)localObject2;
    if (localObject2 == null) {
      paramIntent = "";
    }
    localObject2 = r.ONX;
    localObject2 = ONM;
    kotlin.g.b.s.checkNotNull(localObject2);
    localObject2 = ((m.a)localObject2).ONJ;
    m.a locala = ONM;
    if (locala == null) {}
    for (;;)
    {
      bool = r.b((WXMediaMessage)localObject2, (String)localObject1, str, paramIntent);
      Log.i("MicroMsg.ScanBoxShareHelper", "onShareToFriendResult sendOk: %b", new Object[] { Boolean.valueOf(bool) });
      if (bool) {
        h.ahAA.o(n..ExternalSyntheticLambda0.INSTANCE, 200L);
      }
      s.b(bool, au.bwE((String)localObject1), ONL);
      break;
      str = locala.imageUrl;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.n
 * JD-Core Version:    0.7.0.1
 */