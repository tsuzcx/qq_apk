package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.n;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.cr;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.drr;
import com.tencent.mm.protocal.protobuf.drt;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;

public class SnsAdProxyUI
  extends HellActivity
{
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(98450);
    super.onCreate(paramBundle);
    paramBundle = getIntent();
    if (paramBundle == null)
    {
      Log.e("MicroMsg.SnsAdBlankUI", "intent null!");
      finish();
      AppMethodBeat.o(98450);
      return;
    }
    int i = paramBundle.getIntExtra("action_type", -1);
    Log.i("MicroMsg.SnsAdBlankUI", "action=".concat(String.valueOf(i)));
    if (i < 0)
    {
      finish();
      AppMethodBeat.o(98450);
      return;
    }
    Object localObject;
    if (i == 1)
    {
      localObject = new cr();
      ((cr)localObject).dFK.activity = this;
      ((cr)localObject).dFK.dDX = paramBundle.getStringExtra("qrcodeStr");
      ((cr)localObject).dFK.dFL = paramBundle.getIntExtra("qrcodeType", 0);
      ((cr)localObject).dFK.dFM = paramBundle.getIntExtra("qrcodeVer", 0);
      EventCenter.instance.publish((IEvent)localObject);
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(98450);
      return;
      String str;
      if (i == 2)
      {
        localObject = paramBundle.getStringExtra("username");
        str = paramBundle.getStringExtra("url");
        paramBundle = paramBundle.getStringExtra("sceneNote");
        wq localwq = new wq();
        localwq.ecI.userName = ((String)localObject);
        localwq.ecI.ecK = str;
        localwq.ecI.scene = 1084;
        localwq.ecI.dCw = paramBundle;
        localwq.ecI.context = this;
        EventCenter.instance.publish(localwq);
      }
      else if (i == 3)
      {
        localObject = paramBundle.getByteArrayExtra("searchContactResponseByte");
        str = Util.nullAsNil(paramBundle.getStringExtra("searchWord"));
        try
        {
          paramBundle = new drt();
          paramBundle.parseFrom((byte[])localObject);
          Log.i("MicroMsg.SnsAdBlankUI", "doOpenProfile, query=" + str + ", count=" + paramBundle.LUB);
          if (paramBundle.LUB <= 0) {
            break label424;
          }
          if (!paramBundle.LUC.isEmpty()) {
            break label377;
          }
          h.a(this, 2131765057, 0, true, null);
        }
        catch (Throwable paramBundle)
        {
          Log.e("MicroMsg.SnsAdBlankUI", "parse GetWXUserNameResp exp=" + paramBundle.toString());
        }
        continue;
        label377:
        localObject = new Intent();
        ((n)g.af(n.class)).a((Intent)localObject, (drr)paramBundle.LUC.getFirst(), 182);
        c.b(this, "profile", ".ui.ContactInfoUI", (Intent)localObject);
        continue;
        label424:
        if (Util.nullAsNil(z.a(paramBundle.Lqk)).length() > 0)
        {
          localObject = new Intent();
          ((n)g.af(n.class)).a((Intent)localObject, paramBundle, 182);
          ((Intent)localObject).putExtra("Contact_Scene", 182);
          ((Intent)localObject).putExtra("add_more_friend_search_scene", 2);
          c.b(this, "profile", ".ui.ContactInfoUI", (Intent)localObject);
        }
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdProxyUI
 * JD-Core Version:    0.7.0.1
 */