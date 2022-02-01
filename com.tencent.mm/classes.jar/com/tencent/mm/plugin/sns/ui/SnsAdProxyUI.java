package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.o;
import com.tencent.mm.autogen.a.df;
import com.tencent.mm.autogen.a.zp;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.fts.ui.p.g;
import com.tencent.mm.protocal.protobuf.eve;
import com.tencent.mm.protocal.protobuf.evg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k;
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
      localObject = new df();
      ((df)localObject).hDa.activity = this;
      ((df)localObject).hDa.hBi = paramBundle.getStringExtra("qrcodeStr");
      ((df)localObject).hDa.hDb = paramBundle.getIntExtra("qrcodeType", 0);
      ((df)localObject).hDa.hDc = paramBundle.getIntExtra("qrcodeVer", 0);
      ((df)localObject).publish();
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
        zp localzp = new zp();
        localzp.icM.userName = ((String)localObject);
        localzp.icM.icO = str;
        localzp.icM.scene = 1084;
        localzp.icM.hzx = paramBundle;
        localzp.icM.context = this;
        localzp.publish();
      }
      else if (i == 3)
      {
        localObject = paramBundle.getByteArrayExtra("searchContactResponseByte");
        str = Util.nullAsNil(paramBundle.getStringExtra("searchWord"));
        try
        {
          paramBundle = new evg();
          paramBundle.parseFrom((byte[])localObject);
          Log.i("MicroMsg.SnsAdBlankUI", "doOpenProfile, query=" + str + ", count=" + paramBundle.aaqy);
          if (paramBundle.aaqy <= 0) {
            break label419;
          }
          if (!paramBundle.aaqz.isEmpty()) {
            break label372;
          }
          k.a(this, p.g.search_contact_not_found, 0, true, null);
          continue;
        }
        finally
        {
          Log.e("MicroMsg.SnsAdBlankUI", "parse GetWXUserNameResp exp=" + paramBundle.toString());
        }
        continue;
        label372:
        localObject = new Intent();
        ((o)h.ax(o.class)).a((Intent)localObject, (eve)paramBundle.aaqz.getFirst(), 182);
        c.b(this, "profile", ".ui.ContactInfoUI", (Intent)localObject);
        continue;
        label419:
        if (Util.nullAsNil(w.a(paramBundle.ZqL)).length() > 0)
        {
          localObject = new Intent();
          ((o)h.ax(o.class)).a((Intent)localObject, paramBundle, 182);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.ui.SnsAdProxyUI
 * JD-Core Version:    0.7.0.1
 */