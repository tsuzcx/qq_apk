package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.n;
import com.tencent.mm.by.c;
import com.tencent.mm.f.a.cv;
import com.tencent.mm.f.a.xw;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.fts.ui.o.g;
import com.tencent.mm.protocal.protobuf.ebn;
import com.tencent.mm.protocal.protobuf.ebp;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
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
      localObject = new cv();
      ((cv)localObject).fyr.activity = this;
      ((cv)localObject).fyr.fwI = paramBundle.getStringExtra("qrcodeStr");
      ((cv)localObject).fyr.fys = paramBundle.getIntExtra("qrcodeType", 0);
      ((cv)localObject).fyr.fyt = paramBundle.getIntExtra("qrcodeVer", 0);
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
        xw localxw = new xw();
        localxw.fWN.userName = ((String)localObject);
        localxw.fWN.fWP = str;
        localxw.fWN.scene = 1084;
        localxw.fWN.fvd = paramBundle;
        localxw.fWN.context = this;
        EventCenter.instance.publish(localxw);
      }
      else if (i == 3)
      {
        localObject = paramBundle.getByteArrayExtra("searchContactResponseByte");
        str = Util.nullAsNil(paramBundle.getStringExtra("searchWord"));
        try
        {
          paramBundle = new ebp();
          paramBundle.parseFrom((byte[])localObject);
          Log.i("MicroMsg.SnsAdBlankUI", "doOpenProfile, query=" + str + ", count=" + paramBundle.Tdj);
          if (paramBundle.Tdj <= 0) {
            break label425;
          }
          if (!paramBundle.Tdk.isEmpty()) {
            break label378;
          }
          com.tencent.mm.ui.base.h.a(this, o.g.search_contact_not_found, 0, true, null);
        }
        catch (Throwable paramBundle)
        {
          Log.e("MicroMsg.SnsAdBlankUI", "parse GetWXUserNameResp exp=" + paramBundle.toString());
        }
        continue;
        label378:
        localObject = new Intent();
        ((n)com.tencent.mm.kernel.h.ae(n.class)).a((Intent)localObject, (ebn)paramBundle.Tdk.getFirst(), 182);
        c.b(this, "profile", ".ui.ContactInfoUI", (Intent)localObject);
        continue;
        label425:
        if (Util.nullAsNil(z.a(paramBundle.SrH)).length() > 0)
        {
          localObject = new Intent();
          ((n)com.tencent.mm.kernel.h.ae(n.class)).a((Intent)localObject, paramBundle, 182);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdProxyUI
 * JD-Core Version:    0.7.0.1
 */