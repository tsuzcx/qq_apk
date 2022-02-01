package com.tencent.mm.plugin.scanner.box;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.d;
import com.tencent.mm.ay.q;
import com.tencent.mm.by.c;
import com.tencent.mm.model.ab;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.scanner.l.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.w;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/scanner/box/ScanBoxShareHelper;", "Lcom/tencent/mm/ui/MMActivity$IMMOnActivityResult;", "()V", "TAG", "", "mBottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "reportData", "Landroid/os/Bundle;", "shareData", "Lcom/tencent/mm/plugin/scanner/box/ScanBoxShareData;", "shareInfo", "Lcom/tencent/mm/plugin/scanner/box/ScanBoxShareData$ScanBoxShareInfo;", "clearShareData", "", "mmOnActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onShareToFriendResult", "pushThumbToCache", "imageUrl", "setReportData", "shareToFriend", "context", "Landroid/content/Context;", "params", "showShareMenu", "updateShareData", "updateShareToFriendData", "Lorg/json/JSONObject;", "MenuId", "RequestCode", "ShareAction", "plugin-scan_release"})
public final class n
  implements MMActivity.a
{
  private static Bundle IHG;
  private static m.a IHH;
  private static final m IHI;
  public static final n IHJ;
  
  static
  {
    AppMethodBeat.i(222737);
    IHJ = new n();
    IHI = new m();
    AppMethodBeat.o(222737);
  }
  
  public static final void ar(Bundle paramBundle)
  {
    AppMethodBeat.i(222717);
    p.k(paramBundle, "data");
    IHG = paramBundle;
    AppMethodBeat.o(222717);
  }
  
  public static final void bH(Context paramContext, String paramString)
  {
    AppMethodBeat.i(222734);
    p.k(paramContext, "context");
    n localn = IHJ;
    for (;;)
    {
      try
      {
        Object localObject2 = new JSONObject(paramString).optString("url");
        paramString = IHI;
        p.j(localObject2, "url");
        p.k(localObject2, "key");
        IHH = (m.a)paramString.IHE.get(localObject2);
        Object localObject1 = new StringBuilder("shareToFriend, imageUrl: ");
        paramString = IHH;
        if (paramString != null)
        {
          paramString = paramString.imageUrl;
          localObject1 = ((StringBuilder)localObject1).append(paramString).append(", desc: ");
          paramString = IHH;
          if (paramString != null)
          {
            paramString = paramString.IHF;
            if (paramString != null)
            {
              paramString = paramString.description;
              localObject1 = ((StringBuilder)localObject1).append(paramString).append(", title: ");
              paramString = IHH;
              if (paramString == null) {
                continue;
              }
              paramString = paramString.IHF;
              if (paramString == null) {
                continue;
              }
              paramString = paramString.title;
              Log.i("MicroMsg.ScanBoxShareHelper", paramString + ", url: " + (String)localObject2);
              HashMap localHashMap = new HashMap();
              paramString = IHH;
              if (paramString == null) {
                break label501;
              }
              localObject1 = paramString.imageUrl;
              paramString = (String)localObject1;
              if (localObject1 == null) {
                break label501;
              }
              localHashMap.put("img_url", paramString);
              paramString = IHH;
              if (paramString == null) {
                break label507;
              }
              paramString = paramString.IHF;
              if (paramString == null) {
                break label507;
              }
              localObject1 = paramString.description;
              paramString = (String)localObject1;
              if (localObject1 == null) {
                break label507;
              }
              localHashMap.put("desc", paramString);
              paramString = IHH;
              if (paramString == null) {
                break label513;
              }
              paramString = paramString.IHF;
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
              paramString = IHH;
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
              if ((i == 0) && (kotlin.n.n.M(paramString, "http", false))) {
                q.bmg().a(paramString, null);
              }
              c.a((MMActivity)paramContext, ".ui.transmit.SelectConversationUI", (Intent)localObject2, 1, (MMActivity.a)localn);
              AppMethodBeat.o(222734);
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
        AppMethodBeat.o(222734);
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
  
  public static final void fCj()
  {
    AppMethodBeat.i(222725);
    IHI.IHE.clear();
    AppMethodBeat.o(222725);
  }
  
  public static final void updateShareData(String paramString)
  {
    AppMethodBeat.i(222724);
    Object localObject1 = (CharSequence)paramString;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.e("MicroMsg.ScanBoxShareHelper", "updateShareData params is invalid");
      AppMethodBeat.o(222724);
      return;
    }
    localObject1 = new JSONObject(paramString);
    i = ((JSONObject)localObject1).optInt("action");
    Log.i("MicroMsg.ScanBoxShareHelper", "alvinluo updateShareData action: %d", new Object[] { Integer.valueOf(i) });
    switch (i)
    {
    default: 
      AppMethodBeat.o(222724);
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
      localObject1 = new m.a(r.bv((JSONObject)localObject1), str2);
      localObject2 = IHI;
      p.k(paramString, "key");
      ((Map)((m)localObject2).IHE).put(paramString, localObject1);
      break;
    }
  }
  
  public final void d(int paramInt1, int paramInt2, Intent paramIntent)
  {
    String str = null;
    AppMethodBeat.i(222736);
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
      AppMethodBeat.o(222736);
      return;
      bool = false;
      break;
      switch (paramInt2)
      {
      default: 
        break;
      case -1: 
        if (IHH != null)
        {
          localObject1 = IHH;
          if (localObject1 == null) {
            break label187;
          }
        }
      case 0: 
        label187:
        for (localObject1 = ((m.a)localObject1).IHF; localObject1 == null; localObject1 = null)
        {
          Log.e("MicroMsg.ScanBoxShareHelper", "onShareToFriendResult shareInfo invalid");
          AppMethodBeat.o(222736);
          return;
          Log.w("MicroMsg.ScanBoxShareHelper", "onShareToFriendResult cancel");
          s.as(IHG);
          AppMethodBeat.o(222736);
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
          AppMethodBeat.o(222736);
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
        localObject2 = r.IHY;
        localObject2 = IHH;
        if (localObject2 == null) {
          p.iCn();
        }
        localObject2 = ((m.a)localObject2).IHF;
        m.a locala = IHH;
        if (locala != null) {
          str = locala.imageUrl;
        }
        bool = r.b((WXMediaMessage)localObject2, (String)localObject1, str, paramIntent);
        Log.i("MicroMsg.ScanBoxShareHelper", "onShareToFriendResult sendOk: %b", new Object[] { Boolean.valueOf(bool) });
        if (bool) {
          h.ZvG.n((Runnable)a.IHK, 200L);
        }
        s.b(bool, ab.Lj((String)localObject1), IHG);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    public static final a IHK;
    
    static
    {
      AppMethodBeat.i(222386);
      IHK = new a();
      AppMethodBeat.o(222386);
    }
    
    public final void run()
    {
      AppMethodBeat.i(222385);
      w.cR(MMApplicationContext.getContext(), MMApplicationContext.getContext().getString(l.i.app_sent));
      AppMethodBeat.o(222385);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.scanner.box.n
 * JD-Core Version:    0.7.0.1
 */