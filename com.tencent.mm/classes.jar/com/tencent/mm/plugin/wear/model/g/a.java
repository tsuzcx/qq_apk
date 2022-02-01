package com.tencent.mm.plugin.wear.model.g;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.xz;
import com.tencent.mm.g.a.xz.b;
import com.tencent.mm.plugin.wear.ui.WearYoLockUI;
import com.tencent.mm.plugin.wear.ui.WearYoNoLockUI;
import com.tencent.mm.protocal.protobuf.dsh;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a
{
  private KeyguardManager AEc;
  LinkedHashMap<String, a> AFb;
  private PowerManager powerManager;
  
  public a()
  {
    AppMethodBeat.i(30135);
    this.AFb = new LinkedHashMap();
    this.powerManager = ((PowerManager)aj.getContext().getSystemService("power"));
    this.AEc = ((KeyguardManager)aj.getContext().getSystemService("keyguard"));
    AppMethodBeat.o(30135);
  }
  
  public static xz auT(String paramString)
  {
    AppMethodBeat.i(30136);
    xz localxz = new xz();
    localxz.dEm.dbV = 1;
    localxz.dEm.username = paramString;
    com.tencent.mm.sdk.b.a.ESL.l(localxz);
    AppMethodBeat.o(30136);
    return localxz;
  }
  
  public final void ehq()
  {
    AppMethodBeat.i(30137);
    if (auT(null).dEn.dEo != 0)
    {
      ad.i("MicroMsg.wear.WearYoLogic", "current show yo");
      AppMethodBeat.o(30137);
      return;
    }
    for (;;)
    {
      Object localObject1;
      Object localObject5;
      synchronized (this.AFb)
      {
        localObject1 = this.AFb.entrySet().iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label362;
        }
        localObject1 = (a)((Map.Entry)((Iterator)localObject1).next()).getValue();
        if (localObject1 != null) {
          this.AFb.remove(((a)localObject1).yGA);
        }
        if (localObject1 != null)
        {
          localObject5 = ((a)localObject1).content;
          ??? = new dsh();
          localObject5 = bw.K((String)localObject5, "msg");
          if (localObject5 != null) {
            break label296;
          }
          ((dsh)???).mBH = 0;
          localObject5 = new Intent();
          ((Intent)localObject5).putExtra("key_talker", ((a)localObject1).yGA);
        }
      }
      try
      {
        ((Intent)localObject5).putExtra("key_data", ((dsh)???).toByteArray());
        label168:
        ((Intent)localObject5).addFlags(268435456);
        int i;
        if ((this.AEc.inKeyguardRestrictedInputMode()) || (!this.powerManager.isScreenOn()))
        {
          i = 1;
          label198:
          if (i == 0) {
            break label344;
          }
          ((Intent)localObject5).setClass(aj.getContext(), WearYoLockUI.class);
        }
        for (;;)
        {
          localObject1 = aj.getContext();
          ??? = new com.tencent.mm.hellhoundlib.b.a().bd(localObject5);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)???).adn(), "com/tencent/mm/plugin/wear/model/yo/WearYoLogic", "publishNextYoMessage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)???).lS(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/wear/model/yo/WearYoLogic", "publishNextYoMessage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(30137);
          return;
          localObject2 = finally;
          AppMethodBeat.o(30137);
          throw localObject2;
          label296:
          ((dsh)???).mBH = bt.getInt((String)((Map)localObject5).get(".msg.yo.$type"), 0);
          ((dsh)???).mAK = bt.getInt((String)((Map)localObject5).get(".msg.yo.$count"), 0);
          break;
          i = 0;
          break label198;
          label344:
          ((Intent)localObject5).setClass(aj.getContext(), WearYoNoLockUI.class);
        }
      }
      catch (IOException localIOException)
      {
        break label168;
      }
      label362:
      Object localObject3 = null;
    }
  }
  
  final class a
  {
    String content;
    String yGA;
    
    public a(String paramString1, String paramString2)
    {
      this.yGA = paramString1;
      this.content = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.g.a
 * JD-Core Version:    0.7.0.1
 */