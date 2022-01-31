package com.tencent.mm.ui.chatting;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bv;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelmsg.GetMessageFromWX.Req;
import com.tencent.mm.opensdk.modelmsg.GetMessageFromWX.Resp;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMFragment;
import com.tencent.mm.ui.chatting.d.a;
import com.tencent.mm.ui.q;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class aq
  implements aa
{
  private static com.tencent.mm.sdk.e.l<aa, Bundle> zCT;
  private a caz;
  private MMFragment zCR;
  private final Set<String> zCS;
  
  static
  {
    AppMethodBeat.i(31085);
    zCT = new com.tencent.mm.sdk.e.l() {};
    AppMethodBeat.o(31085);
  }
  
  public aq(a parama)
  {
    AppMethodBeat.i(31076);
    this.zCS = new HashSet();
    this.zCR = parama.zJz;
    AppMethodBeat.o(31076);
  }
  
  private q.a a(final WXMediaMessage paramWXMediaMessage, final f paramf)
  {
    AppMethodBeat.i(31083);
    paramWXMediaMessage = new q.a()
    {
      public final void a(boolean paramAnonymousBoolean, String paramAnonymousString, int paramAnonymousInt)
      {
        AppMethodBeat.i(31075);
        if (paramAnonymousBoolean)
        {
          paramAnonymousString = null;
          if (paramWXMediaMessage.getType() == 8)
          {
            if (paramWXMediaMessage.thumbData == null)
            {
              ab.e("MicroMsg.WXAppMessageReceiver", "code should not reach here due to WXMediaMessage::checkArgs, sendEmoji Fail cause thumbData is null");
              AppMethodBeat.o(31075);
              return;
            }
            String str = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().a(aq.c(aq.this).getContext(), paramWXMediaMessage, paramf.field_appId);
            paramAnonymousString = str;
            if (str == null)
            {
              ab.v("MicroMsg.WXAppMessageReceiver", "sendEmoji Fail cause emojiconmd5 is null");
              AppMethodBeat.o(31075);
              return;
            }
          }
          bv.abc().c(27, new Object[] { Integer.valueOf(1) });
          ab.v("MicroMsg.WXAppMessageReceiver", "onDialogClick, messageAction = %s, messageExt = %s", new Object[] { paramWXMediaMessage.messageAction, paramWXMediaMessage.messageExt });
          com.tencent.mm.pluginsdk.model.app.l.a(paramWXMediaMessage, paramf.field_appId, paramf.field_appName, aq.d(aq.this).getTalkerUserName(), 1, paramAnonymousString);
        }
        AppMethodBeat.o(31075);
      }
    };
    AppMethodBeat.o(31083);
    return paramWXMediaMessage;
  }
  
  public static void a(aq paramaq)
  {
    AppMethodBeat.i(31080);
    zCT.a(paramaq, null);
    AppMethodBeat.o(31080);
  }
  
  public static void aI(Bundle paramBundle)
  {
    AppMethodBeat.i(31077);
    zCT.cy(paramBundle);
    zCT.doNotify();
    AppMethodBeat.o(31077);
  }
  
  @TargetApi(9)
  private static void b(Context paramContext, Set<String> paramSet)
  {
    AppMethodBeat.i(31084);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramSet != null)
    {
      localObject1 = localObject2;
      if (paramSet.size() > 0)
      {
        localObject1 = new StringBuilder();
        paramSet = paramSet.iterator();
        while (paramSet.hasNext())
        {
          ((StringBuilder)localObject1).append((String)paramSet.next());
          ((StringBuilder)localObject1).append(";");
        }
        localObject1 = ((StringBuilder)localObject1).toString();
      }
    }
    paramContext = paramContext.getSharedPreferences(com.tencent.mm.sdk.platformtools.ah.dsS(), 0).edit();
    paramContext.putString("transactions_array_key", (String)localObject1);
    if (Build.VERSION.SDK_INT > 8)
    {
      paramContext.apply();
      AppMethodBeat.o(31084);
      return;
    }
    paramContext.commit();
    AppMethodBeat.o(31084);
  }
  
  public static void b(aq paramaq)
  {
    AppMethodBeat.i(31081);
    zCT.remove(paramaq);
    paramaq.zCS.clear();
    b(paramaq.zCR.getContext(), null);
    AppMethodBeat.o(31081);
  }
  
  private String r(f paramf)
  {
    AppMethodBeat.i(31082);
    paramf = this.zCR.getString(2131298504, new Object[] { com.tencent.mm.pluginsdk.model.app.g.b(this.zCR.getContext(), paramf, null) });
    AppMethodBeat.o(31082);
    return paramf;
  }
  
  public final void aH(Bundle paramBundle)
  {
    int j = 1;
    int k = 0;
    AppMethodBeat.i(31078);
    if (!this.caz.bSe)
    {
      ab.v("MicroMsg.WXAppMessageReceiver", "handleResp Chatting is a fragment but not foregound");
      AppMethodBeat.o(31078);
      return;
    }
    Object localObject2 = Uri.parse(paramBundle.getString("_mmessage_content")).getQueryParameter("appid");
    Object localObject1 = new GetMessageFromWX.Resp(paramBundle);
    paramBundle = ((GetMessageFromWX.Resp)localObject1).message;
    Object localObject4;
    Object localObject3;
    if (this.zCS.size() == 0)
    {
      localObject4 = this.zCR.getContext();
      localObject3 = new HashSet();
      localObject4 = ((Context)localObject4).getSharedPreferences(com.tencent.mm.sdk.platformtools.ah.dsS(), 0).getString("transactions_array_key", null);
      if ((localObject4 != null) && (((String)localObject4).length() > 0))
      {
        localObject4 = ((String)localObject4).split(";");
        int m = localObject4.length;
        i = 0;
        while (i < m)
        {
          ((Set)localObject3).add(localObject4[i]);
          i += 1;
        }
      }
      this.zCS.addAll((Collection)localObject3);
    }
    if (!this.zCS.contains(((GetMessageFromWX.Resp)localObject1).transaction))
    {
      ab.e("MicroMsg.WXAppMessageReceiver", "invalid resp, check transaction failed, transaction=" + ((GetMessageFromWX.Resp)localObject1).transaction);
      AppMethodBeat.o(31078);
      return;
    }
    this.zCS.remove(((GetMessageFromWX.Resp)localObject1).transaction);
    b(this.zCR.getContext(), this.zCS);
    localObject1 = new f();
    ((f)localObject1).field_appId = ((String)localObject2);
    ab.d("MicroMsg.WXAppMessageReceiver", "handleResp, appId = ".concat(String.valueOf(localObject2)));
    if (!al.cac().get((com.tencent.mm.sdk.e.c)localObject1, new String[0]))
    {
      ab.e("MicroMsg.WXAppMessageReceiver", "unregistered app, ignore request, appId = ".concat(String.valueOf(localObject2)));
      AppMethodBeat.o(31078);
      return;
    }
    int i = paramBundle.getType();
    switch (i)
    {
    case 6: 
    default: 
      ab.e("MicroMsg.WXAppMessageReceiver", "unknown type = ".concat(String.valueOf(i)));
      i = 0;
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
      for (;;)
      {
        if (i == 0) {
          ab.e("MicroMsg.WXAppMessageReceiver", "deal fail, result is false");
        }
        AppMethodBeat.o(31078);
        return;
        localObject2 = this.zCR.getController();
        localObject3 = paramBundle.description;
        r((f)localObject1);
        if (com.tencent.mm.pluginsdk.ui.applet.g.a((q)localObject2, (String)localObject3, false, a(paramBundle, (f)localObject1)) != null) {}
        for (i = 1;; i = 0) {
          break;
        }
        if ((paramBundle.thumbData != null) && (paramBundle.thumbData.length > 0))
        {
          localObject2 = this.zCR.getController();
          localObject3 = paramBundle.thumbData;
          r((f)localObject1);
          paramBundle = com.tencent.mm.pluginsdk.ui.applet.g.a((q)localObject2, (byte[])localObject3, false, a(paramBundle, (f)localObject1));
          if (paramBundle != null) {
            break label651;
          }
          ab.e("MicroMsg.WXAppMessageReceiver", "showDialogItem3 fail, invalid argument");
        }
        for (i = k;; i = 1)
        {
          break;
          localObject2 = (WXImageObject)paramBundle.mediaObject;
          if ((((WXImageObject)localObject2).imageData != null) && (((WXImageObject)localObject2).imageData.length > 0))
          {
            localObject3 = this.zCR.getController();
            localObject2 = ((WXImageObject)localObject2).imageData;
            r((f)localObject1);
            paramBundle = com.tencent.mm.pluginsdk.ui.applet.g.a((q)localObject3, (byte[])localObject2, false, a(paramBundle, (f)localObject1));
            break label523;
          }
          localObject3 = this.zCR.getController();
          localObject2 = ((WXImageObject)localObject2).imagePath;
          r((f)localObject1);
          paramBundle = com.tencent.mm.pluginsdk.ui.applet.g.b((q)localObject3, (String)localObject2, false, a(paramBundle, (f)localObject1));
          break label523;
        }
        if ((paramBundle.thumbData != null) && (paramBundle.thumbData.length > 0))
        {
          localObject2 = this.zCR.getController();
          localObject3 = paramBundle.title;
          r((f)localObject1);
        }
        for (paramBundle = com.tencent.mm.pluginsdk.ui.applet.g.a((q)localObject2, (String)localObject3, false, 2, a(paramBundle, (f)localObject1));; paramBundle = com.tencent.mm.pluginsdk.ui.applet.g.a((q)localObject2, 2131230809, (String)localObject3, false, a(paramBundle, (f)localObject1)))
        {
          i = j;
          if (paramBundle != null) {
            break;
          }
          i = 0;
          break;
          localObject2 = this.zCR.getController();
          localObject3 = paramBundle.title;
          r((f)localObject1);
        }
        if ((paramBundle.thumbData != null) && (paramBundle.thumbData.length > 0))
        {
          localObject2 = this.zCR.getController();
          localObject3 = paramBundle.title;
          r((f)localObject1);
        }
        for (paramBundle = com.tencent.mm.pluginsdk.ui.applet.g.a((q)localObject2, (String)localObject3, false, 1, a(paramBundle, (f)localObject1));; paramBundle = com.tencent.mm.pluginsdk.ui.applet.g.a((q)localObject2, 2131230826, (String)localObject3, false, a(paramBundle, (f)localObject1)))
        {
          i = j;
          if (paramBundle != null) {
            break;
          }
          i = 0;
          break;
          localObject2 = this.zCR.getController();
          localObject3 = paramBundle.title;
          r((f)localObject1);
        }
        localObject2 = this.zCR.getController();
        localObject3 = paramBundle.title;
        localObject4 = paramBundle.description;
        r((f)localObject1);
        i = j;
        if (com.tencent.mm.pluginsdk.ui.applet.g.a((q)localObject2, (String)localObject3, (String)localObject4, a(paramBundle, (f)localObject1)) == null) {
          i = 0;
        }
      }
    case 7: 
      label523:
      if ((paramBundle.thumbData != null) && (paramBundle.thumbData.length > 0))
      {
        localObject2 = this.zCR.getController();
        localObject3 = paramBundle.title;
        r((f)localObject1);
      }
      label651:
      for (paramBundle = com.tencent.mm.pluginsdk.ui.applet.g.a((q)localObject2, (String)localObject3, false, 0, a(paramBundle, (f)localObject1));; paramBundle = com.tencent.mm.pluginsdk.ui.applet.g.a((q)localObject2, 2131230829, (String)localObject3, false, a(paramBundle, (f)localObject1)))
      {
        i = j;
        if (paramBundle != null) {
          break;
        }
        i = 0;
        break;
        localObject2 = this.zCR.getController();
        localObject3 = paramBundle.title;
        r((f)localObject1);
      }
    }
    if ((paramBundle.thumbData != null) && (paramBundle.thumbData.length > 0))
    {
      localObject2 = this.zCR.getController();
      localObject3 = paramBundle.thumbData;
      r((f)localObject1);
    }
    for (paramBundle = com.tencent.mm.pluginsdk.ui.applet.g.a((q)localObject2, (byte[])localObject3, false, a(paramBundle, (f)localObject1));; paramBundle = com.tencent.mm.pluginsdk.ui.applet.g.a((q)localObject2, 2131230829, (String)localObject3, false, a(paramBundle, (f)localObject1)))
    {
      i = j;
      if (paramBundle != null) {
        break;
      }
      i = 0;
      break;
      localObject2 = this.zCR.getController();
      localObject3 = paramBundle.title;
      r((f)localObject1);
    }
  }
  
  public final boolean iz(String paramString1, String paramString2)
  {
    AppMethodBeat.i(31079);
    ab.d("MicroMsg.WXAppMessageReceiver", "request, pkg = " + paramString1 + ", openId = " + paramString2);
    GetMessageFromWX.Req localReq = new GetMessageFromWX.Req();
    localReq.username = this.caz.getTalkerUserName();
    localReq.transaction = com.tencent.mm.a.g.w(com.tencent.mm.platformtools.ah.aoy().getBytes());
    localReq.openId = paramString2;
    paramString2 = this.zCR.getSharedPreferences(com.tencent.mm.sdk.platformtools.ah.dsP(), 0);
    this.zCR.getContext();
    localReq.lang = com.tencent.mm.sdk.platformtools.aa.f(paramString2);
    aw.aaz();
    localReq.country = ((String)com.tencent.mm.model.c.Ru().get(274436, null));
    paramString2 = new Bundle();
    localReq.toBundle(paramString2);
    p.aC(paramString2);
    p.aD(paramString2);
    MMessageActV2.Args localArgs = new MMessageActV2.Args();
    localArgs.targetPkgName = paramString1;
    localArgs.bundle = paramString2;
    boolean bool = MMessageActV2.send(this.zCR.getContext(), localArgs);
    this.zCS.add(localReq.transaction);
    b(this.zCR.getContext(), this.zCS);
    AppMethodBeat.o(31079);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.aq
 * JD-Core Version:    0.7.0.1
 */