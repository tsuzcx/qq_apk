package com.tencent.mm.plugin.wear.model.g;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ze;
import com.tencent.mm.g.a.ze.b;
import com.tencent.mm.plugin.wear.ui.WearYoLockUI;
import com.tencent.mm.plugin.wear.ui.WearYoNoLockUI;
import com.tencent.mm.protocal.protobuf.edy;
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
  private KeyguardManager DwQ;
  LinkedHashMap<String, a> DxO;
  private PowerManager powerManager;
  
  public a()
  {
    AppMethodBeat.i(30135);
    this.DxO = new LinkedHashMap();
    this.powerManager = ((PowerManager)aj.getContext().getSystemService("power"));
    this.DwQ = ((KeyguardManager)aj.getContext().getSystemService("keyguard"));
    AppMethodBeat.o(30135);
  }
  
  public static ze aFu(String paramString)
  {
    AppMethodBeat.i(30136);
    ze localze = new ze();
    localze.dOl.dkM = 1;
    localze.dOl.username = paramString;
    com.tencent.mm.sdk.b.a.IbL.l(localze);
    AppMethodBeat.o(30136);
    return localze;
  }
  
  public final void eKQ()
  {
    AppMethodBeat.i(30137);
    if (aFu(null).dOm.dOn != 0)
    {
      ad.i("MicroMsg.wear.WearYoLogic", "current show yo");
      AppMethodBeat.o(30137);
      return;
    }
    for (;;)
    {
      Object localObject1;
      Object localObject5;
      synchronized (this.DxO)
      {
        localObject1 = this.DxO.entrySet().iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label362;
        }
        localObject1 = (a)((Map.Entry)((Iterator)localObject1).next()).getValue();
        if (localObject1 != null) {
          this.DxO.remove(((a)localObject1).dHm);
        }
        if (localObject1 != null)
        {
          localObject5 = ((a)localObject1).content;
          ??? = new edy();
          localObject5 = bw.M((String)localObject5, "msg");
          if (localObject5 != null) {
            break label296;
          }
          ((edy)???).nEf = 0;
          localObject5 = new Intent();
          ((Intent)localObject5).putExtra("key_talker", ((a)localObject1).dHm);
        }
      }
      try
      {
        ((Intent)localObject5).putExtra("key_data", ((edy)???).toByteArray());
        label168:
        ((Intent)localObject5).addFlags(268435456);
        int i;
        if ((this.DwQ.inKeyguardRestrictedInputMode()) || (!this.powerManager.isScreenOn()))
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
          ??? = new com.tencent.mm.hellhoundlib.b.a().bc(localObject5);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)???).ahp(), "com/tencent/mm/plugin/wear/model/yo/WearYoLogic", "publishNextYoMessage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)???).mq(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/wear/model/yo/WearYoLogic", "publishNextYoMessage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(30137);
          return;
          localObject2 = finally;
          AppMethodBeat.o(30137);
          throw localObject2;
          label296:
          ((edy)???).nEf = bt.getInt((String)((Map)localObject5).get(".msg.yo.$type"), 0);
          ((edy)???).nDi = bt.getInt((String)((Map)localObject5).get(".msg.yo.$count"), 0);
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
    String dHm;
    
    public a(String paramString1, String paramString2)
    {
      this.dHm = paramString1;
      this.content = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.g.a
 * JD-Core Version:    0.7.0.1
 */