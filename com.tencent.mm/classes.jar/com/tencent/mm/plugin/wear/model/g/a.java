package com.tencent.mm.plugin.wear.model.g;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.yk;
import com.tencent.mm.g.a.yk.b;
import com.tencent.mm.plugin.wear.ui.WearYoLockUI;
import com.tencent.mm.plugin.wear.ui.WearYoNoLockUI;
import com.tencent.mm.protocal.protobuf.dxy;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a
{
  private KeyguardManager BWw;
  LinkedHashMap<String, a> BXv;
  private PowerManager powerManager;
  
  public a()
  {
    AppMethodBeat.i(30135);
    this.BXv = new LinkedHashMap();
    this.powerManager = ((PowerManager)ai.getContext().getSystemService("power"));
    this.BWw = ((KeyguardManager)ai.getContext().getSystemService("keyguard"));
    AppMethodBeat.o(30135);
  }
  
  public static yk aAk(String paramString)
  {
    AppMethodBeat.i(30136);
    yk localyk = new yk();
    localyk.dBY.cZu = 1;
    localyk.dBY.username = paramString;
    com.tencent.mm.sdk.b.a.GpY.l(localyk);
    AppMethodBeat.o(30136);
    return localyk;
  }
  
  public final void ewK()
  {
    AppMethodBeat.i(30137);
    if (aAk(null).dBZ.dCa != 0)
    {
      ac.i("MicroMsg.wear.WearYoLogic", "current show yo");
      AppMethodBeat.o(30137);
      return;
    }
    for (;;)
    {
      Object localObject1;
      Object localObject5;
      synchronized (this.BXv)
      {
        localObject1 = this.BXv.entrySet().iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label362;
        }
        localObject1 = (a)((Map.Entry)((Iterator)localObject1).next()).getValue();
        if (localObject1 != null) {
          this.BXv.remove(((a)localObject1).zTO);
        }
        if (localObject1 != null)
        {
          localObject5 = ((a)localObject1).content;
          ??? = new dxy();
          localObject5 = bv.L((String)localObject5, "msg");
          if (localObject5 != null) {
            break label296;
          }
          ((dxy)???).ndI = 0;
          localObject5 = new Intent();
          ((Intent)localObject5).putExtra("key_talker", ((a)localObject1).zTO);
        }
      }
      try
      {
        ((Intent)localObject5).putExtra("key_data", ((dxy)???).toByteArray());
        label168:
        ((Intent)localObject5).addFlags(268435456);
        int i;
        if ((this.BWw.inKeyguardRestrictedInputMode()) || (!this.powerManager.isScreenOn()))
        {
          i = 1;
          label198:
          if (i == 0) {
            break label344;
          }
          ((Intent)localObject5).setClass(ai.getContext(), WearYoLockUI.class);
        }
        for (;;)
        {
          localObject1 = ai.getContext();
          ??? = new com.tencent.mm.hellhoundlib.b.a().ba(localObject5);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)???).aeD(), "com/tencent/mm/plugin/wear/model/yo/WearYoLogic", "publishNextYoMessage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)???).lR(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/wear/model/yo/WearYoLogic", "publishNextYoMessage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(30137);
          return;
          localObject2 = finally;
          AppMethodBeat.o(30137);
          throw localObject2;
          label296:
          ((dxy)???).ndI = bs.getInt((String)((Map)localObject5).get(".msg.yo.$type"), 0);
          ((dxy)???).ncL = bs.getInt((String)((Map)localObject5).get(".msg.yo.$count"), 0);
          break;
          i = 0;
          break label198;
          label344:
          ((Intent)localObject5).setClass(ai.getContext(), WearYoNoLockUI.class);
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
    String zTO;
    
    public a(String paramString1, String paramString2)
    {
      this.zTO = paramString1;
      this.content = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.g.a
 * JD-Core Version:    0.7.0.1
 */