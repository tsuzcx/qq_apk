package com.tencent.mm.plugin.music.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.av.a;
import com.tencent.mm.av.e;
import com.tencent.mm.plugin.music.model.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.h.c;

final class MusicMainUI$7
  implements h.c
{
  MusicMainUI$7(MusicMainUI paramMusicMainUI, e parame) {}
  
  public final void gl(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      com.tencent.mm.plugin.music.model.d.D(this.mCa);
      com.tencent.mm.plugin.music.model.d.d.uR(MusicMainUI.h(this.mCa));
      com.tencent.mm.plugin.music.model.d.d.uT(2);
      return;
    case 1: 
      com.tencent.mm.plugin.music.model.d.b(this.euo, this.mCa);
      com.tencent.mm.plugin.music.model.d.d.uS(MusicMainUI.h(this.mCa));
      com.tencent.mm.plugin.music.model.d.d.uT(1);
      return;
    case 2: 
      com.tencent.mm.plugin.music.model.d.a(this.euo, this.mCa);
      com.tencent.mm.plugin.music.model.d.d.uT(3);
      return;
    }
    Object localObject = this.euo;
    MusicMainUI localMusicMainUI = this.mCa;
    h.nFQ.aC(10910, "4");
    String str;
    label141:
    label164:
    Uri localUri;
    if (localObject != null)
    {
      str = ((e)localObject).euF;
      if (str != null) {
        break label195;
      }
      paramInt = -1;
      if (paramInt >= 0) {
        break label206;
      }
      localObject = null;
      if (localObject != null) {
        break label218;
      }
      y.e("MicroMsg.Music.MusicUtil", "wtf, get qq music data fail, url %s", new Object[] { str });
      localObject = "androidqqmusic://";
      localUri = Uri.parse((String)localObject);
      if (localUri != null) {
        break label250;
      }
      y.w("MicroMsg.Music.MusicUtil", "parse qq music action url fail, url %s", new Object[] { localObject });
    }
    for (;;)
    {
      com.tencent.mm.plugin.music.model.d.d.uT(4);
      return;
      label195:
      paramInt = str.indexOf("#p=");
      break;
      label206:
      localObject = str.substring(paramInt + 3);
      break label141;
      label218:
      y.i("MicroMsg.Music.MusicUtil", "get qq music data %s", new Object[] { localObject });
      localObject = String.format("androidqqmusic://from=webPlayer&data=%s", new Object[] { localObject });
      break label164;
      label250:
      a.Ps();
      localObject = new Intent("android.intent.action.VIEW", localUri);
      ((Intent)localObject).addFlags(268435456);
      if (bk.i(localMusicMainUI, (Intent)localObject))
      {
        localMusicMainUI.startActivity((Intent)localObject);
      }
      else
      {
        localObject = new Intent();
        ((Intent)localObject).putExtra("rawUrl", str);
        b.eUR.j((Intent)localObject, localMusicMainUI);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.music.ui.MusicMainUI.7
 * JD-Core Version:    0.7.0.1
 */