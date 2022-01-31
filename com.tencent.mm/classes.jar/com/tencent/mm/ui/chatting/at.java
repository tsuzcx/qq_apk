package com.tencent.mm.ui.chatting;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.model.au;
import com.tencent.mm.opensdk.channel.MMessageActV2;
import com.tencent.mm.opensdk.channel.MMessageActV2.Args;
import com.tencent.mm.opensdk.modelmsg.GetMessageFromWX.Req;
import com.tencent.mm.opensdk.modelmsg.GetMessageFromWX.Resp;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.i;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.pluginsdk.ui.applet.q.a;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.s;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class at
  implements ad
{
  public static k<ad, Bundle> vnx = new at.1();
  private a byx;
  public com.tencent.mm.ui.x vnv;
  public final Set<String> vnw = new HashSet();
  
  public at(a parama)
  {
    this.vnv = parama.vtz;
  }
  
  private q.a a(WXMediaMessage paramWXMediaMessage, f paramf)
  {
    return new at.2(this, paramWXMediaMessage, paramf);
  }
  
  public static void ap(Bundle paramBundle)
  {
    vnx.bV(paramBundle);
    vnx.doNotify();
  }
  
  @TargetApi(9)
  public static void b(Context paramContext, Set<String> paramSet)
  {
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
    paramContext = paramContext.getSharedPreferences(ae.cqU(), 0).edit();
    paramContext.putString("transactions_array_key", (String)localObject1);
    if (Build.VERSION.SDK_INT > 8)
    {
      paramContext.apply();
      return;
    }
    paramContext.commit();
  }
  
  private String m(f paramf)
  {
    return this.vnv.getString(R.l.confirm_dialog_source, new Object[] { com.tencent.mm.pluginsdk.model.app.g.b(this.vnv.getContext(), paramf, null) });
  }
  
  public final void ao(Bundle paramBundle)
  {
    int j = 1;
    int k = 0;
    if (!this.byx.euf)
    {
      y.v("MicroMsg.WXAppMessageReceiver", "handleResp Chatting is a fragment but not foregound");
      return;
    }
    Object localObject2 = Uri.parse(paramBundle.getString("_mmessage_content")).getQueryParameter("appid");
    Object localObject1 = new GetMessageFromWX.Resp(paramBundle);
    paramBundle = ((GetMessageFromWX.Resp)localObject1).message;
    Object localObject4;
    Object localObject3;
    if (this.vnw.size() == 0)
    {
      localObject4 = this.vnv.getContext();
      localObject3 = new HashSet();
      localObject4 = ((Context)localObject4).getSharedPreferences(ae.cqU(), 0).getString("transactions_array_key", null);
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
      this.vnw.addAll((Collection)localObject3);
    }
    if (!this.vnw.contains(((GetMessageFromWX.Resp)localObject1).transaction))
    {
      y.e("MicroMsg.WXAppMessageReceiver", "invalid resp, check transaction failed, transaction=" + ((GetMessageFromWX.Resp)localObject1).transaction);
      return;
    }
    this.vnw.remove(((GetMessageFromWX.Resp)localObject1).transaction);
    b(this.vnv.getContext(), this.vnw);
    localObject1 = new f();
    ((f)localObject1).field_appId = ((String)localObject2);
    y.d("MicroMsg.WXAppMessageReceiver", "handleResp, appId = " + (String)localObject2);
    if (!ap.brn().b((com.tencent.mm.sdk.e.c)localObject1, new String[0]))
    {
      y.e("MicroMsg.WXAppMessageReceiver", "unregistered app, ignore request, appId = " + (String)localObject2);
      return;
    }
    int i = paramBundle.getType();
    switch (i)
    {
    case 6: 
    default: 
      y.e("MicroMsg.WXAppMessageReceiver", "unknown type = " + i);
      i = 0;
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
      while (i == 0)
      {
        y.e("MicroMsg.WXAppMessageReceiver", "deal fail, result is false");
        return;
        localObject2 = this.vnv.getController();
        localObject3 = paramBundle.description;
        m((f)localObject1);
        if (com.tencent.mm.pluginsdk.ui.applet.g.a((s)localObject2, (String)localObject3, false, a(paramBundle, (f)localObject1)) != null) {}
        for (i = 1;; i = 0) {
          break;
        }
        if ((paramBundle.thumbData != null) && (paramBundle.thumbData.length > 0))
        {
          localObject2 = this.vnv.getController();
          localObject3 = paramBundle.thumbData;
          m((f)localObject1);
          paramBundle = com.tencent.mm.pluginsdk.ui.applet.g.a((s)localObject2, (byte[])localObject3, false, a(paramBundle, (f)localObject1));
          if (paramBundle != null) {
            break label640;
          }
          y.e("MicroMsg.WXAppMessageReceiver", "showDialogItem3 fail, invalid argument");
        }
        for (i = k;; i = 1)
        {
          break;
          localObject2 = (WXImageObject)paramBundle.mediaObject;
          if ((((WXImageObject)localObject2).imageData != null) && (((WXImageObject)localObject2).imageData.length > 0))
          {
            localObject3 = this.vnv.getController();
            localObject2 = ((WXImageObject)localObject2).imageData;
            m((f)localObject1);
            paramBundle = com.tencent.mm.pluginsdk.ui.applet.g.a((s)localObject3, (byte[])localObject2, false, a(paramBundle, (f)localObject1));
            break label512;
          }
          localObject3 = this.vnv.getController();
          localObject2 = ((WXImageObject)localObject2).imagePath;
          m((f)localObject1);
          paramBundle = com.tencent.mm.pluginsdk.ui.applet.g.b((s)localObject3, (String)localObject2, false, a(paramBundle, (f)localObject1));
          break label512;
        }
        if ((paramBundle.thumbData != null) && (paramBundle.thumbData.length > 0))
        {
          localObject2 = this.vnv.getController();
          localObject3 = paramBundle.title;
          m((f)localObject1);
        }
        for (paramBundle = com.tencent.mm.pluginsdk.ui.applet.g.a((s)localObject2, (String)localObject3, false, 2, a(paramBundle, (f)localObject1));; paramBundle = com.tencent.mm.pluginsdk.ui.applet.g.a((s)localObject2, i, (String)localObject3, false, a(paramBundle, (f)localObject1)))
        {
          i = j;
          if (paramBundle != null) {
            break;
          }
          i = 0;
          break;
          localObject2 = this.vnv.getController();
          i = R.k.app_attach_file_icon_music;
          localObject3 = paramBundle.title;
          m((f)localObject1);
        }
        if ((paramBundle.thumbData != null) && (paramBundle.thumbData.length > 0))
        {
          localObject2 = this.vnv.getController();
          localObject3 = paramBundle.title;
          m((f)localObject1);
        }
        for (paramBundle = com.tencent.mm.pluginsdk.ui.applet.g.a((s)localObject2, (String)localObject3, false, 1, a(paramBundle, (f)localObject1));; paramBundle = com.tencent.mm.pluginsdk.ui.applet.g.a((s)localObject2, i, (String)localObject3, false, a(paramBundle, (f)localObject1)))
        {
          i = j;
          if (paramBundle != null) {
            break;
          }
          i = 0;
          break;
          localObject2 = this.vnv.getController();
          i = R.k.app_attach_file_icon_video;
          localObject3 = paramBundle.title;
          m((f)localObject1);
        }
        localObject2 = this.vnv.getController();
        localObject3 = paramBundle.title;
        localObject4 = paramBundle.description;
        m((f)localObject1);
        i = j;
        if (com.tencent.mm.pluginsdk.ui.applet.g.a((s)localObject2, (String)localObject3, (String)localObject4, a(paramBundle, (f)localObject1)) == null) {
          i = 0;
        }
      }
    case 7: 
      label512:
      if ((paramBundle.thumbData != null) && (paramBundle.thumbData.length > 0))
      {
        localObject2 = this.vnv.getController();
        localObject3 = paramBundle.title;
        m((f)localObject1);
      }
      label640:
      for (paramBundle = com.tencent.mm.pluginsdk.ui.applet.g.a((s)localObject2, (String)localObject3, false, 0, a(paramBundle, (f)localObject1));; paramBundle = com.tencent.mm.pluginsdk.ui.applet.g.a((s)localObject2, i, (String)localObject3, false, a(paramBundle, (f)localObject1)))
      {
        i = j;
        if (paramBundle != null) {
          break;
        }
        i = 0;
        break;
        localObject2 = this.vnv.getController();
        i = R.k.app_attach_file_icon_webpage;
        localObject3 = paramBundle.title;
        m((f)localObject1);
      }
    }
    if ((paramBundle.thumbData != null) && (paramBundle.thumbData.length > 0))
    {
      localObject2 = this.vnv.getController();
      localObject3 = paramBundle.thumbData;
      m((f)localObject1);
    }
    for (paramBundle = com.tencent.mm.pluginsdk.ui.applet.g.a((s)localObject2, (byte[])localObject3, false, a(paramBundle, (f)localObject1));; paramBundle = com.tencent.mm.pluginsdk.ui.applet.g.a((s)localObject2, i, (String)localObject3, false, a(paramBundle, (f)localObject1)))
    {
      i = j;
      if (paramBundle != null) {
        break;
      }
      i = 0;
      break;
      localObject2 = this.vnv.getController();
      i = R.k.app_attach_file_icon_webpage;
      localObject3 = paramBundle.title;
      m((f)localObject1);
    }
  }
  
  public final boolean gw(String paramString1, String paramString2)
  {
    y.d("MicroMsg.WXAppMessageReceiver", "request, pkg = " + paramString1 + ", openId = " + paramString2);
    GetMessageFromWX.Req localReq = new GetMessageFromWX.Req();
    localReq.username = this.byx.getTalkerUserName();
    localReq.transaction = com.tencent.mm.a.g.o(ah.UY().getBytes());
    localReq.openId = paramString2;
    paramString2 = this.vnv.getSharedPreferences(ae.cqR(), 0);
    this.vnv.getContext();
    localReq.lang = com.tencent.mm.sdk.platformtools.x.d(paramString2);
    au.Hx();
    localReq.country = ((String)com.tencent.mm.model.c.Dz().get(274436, null));
    paramString2 = new Bundle();
    localReq.toBundle(paramString2);
    p.ak(paramString2);
    p.al(paramString2);
    MMessageActV2.Args localArgs = new MMessageActV2.Args();
    localArgs.targetPkgName = paramString1;
    localArgs.bundle = paramString2;
    boolean bool = MMessageActV2.send(this.vnv.getContext(), localArgs);
    this.vnw.add(localReq.transaction);
    b(this.vnv.getContext(), this.vnw);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ui.chatting.at
 * JD-Core Version:    0.7.0.1
 */