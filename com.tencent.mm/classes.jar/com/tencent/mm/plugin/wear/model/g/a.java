package com.tencent.mm.plugin.wear.model.g;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.zk;
import com.tencent.mm.g.a.zk.b;
import com.tencent.mm.plugin.wear.ui.WearYoLockUI;
import com.tencent.mm.plugin.wear.ui.WearYoNoLockUI;
import com.tencent.mm.protocal.protobuf.efp;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a
{
  private KeyguardManager DOv;
  LinkedHashMap<String, a> DPt;
  private PowerManager powerManager;
  
  public a()
  {
    AppMethodBeat.i(30135);
    this.DPt = new LinkedHashMap();
    this.powerManager = ((PowerManager)ak.getContext().getSystemService("power"));
    this.DOv = ((KeyguardManager)ak.getContext().getSystemService("keyguard"));
    AppMethodBeat.o(30135);
  }
  
  public static zk aGO(String paramString)
  {
    AppMethodBeat.i(30136);
    zk localzk = new zk();
    localzk.dPB.dlO = 1;
    localzk.dPB.username = paramString;
    com.tencent.mm.sdk.b.a.IvT.l(localzk);
    AppMethodBeat.o(30136);
    return localzk;
  }
  
  public final void eOy()
  {
    AppMethodBeat.i(30137);
    if (aGO(null).dPC.dPD != 0)
    {
      ae.i("MicroMsg.wear.WearYoLogic", "current show yo");
      AppMethodBeat.o(30137);
      return;
    }
    for (;;)
    {
      Object localObject1;
      Object localObject5;
      synchronized (this.DPt)
      {
        localObject1 = this.DPt.entrySet().iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label362;
        }
        localObject1 = (a)((Map.Entry)((Iterator)localObject1).next()).getValue();
        if (localObject1 != null) {
          this.DPt.remove(((a)localObject1).cUA);
        }
        if (localObject1 != null)
        {
          localObject5 = ((a)localObject1).content;
          ??? = new efp();
          localObject5 = bx.M((String)localObject5, "msg");
          if (localObject5 != null) {
            break label296;
          }
          ((efp)???).nJA = 0;
          localObject5 = new Intent();
          ((Intent)localObject5).putExtra("key_talker", ((a)localObject1).cUA);
        }
      }
      try
      {
        ((Intent)localObject5).putExtra("key_data", ((efp)???).toByteArray());
        label168:
        ((Intent)localObject5).addFlags(268435456);
        int i;
        if ((this.DOv.inKeyguardRestrictedInputMode()) || (!this.powerManager.isScreenOn()))
        {
          i = 1;
          label198:
          if (i == 0) {
            break label344;
          }
          ((Intent)localObject5).setClass(ak.getContext(), WearYoLockUI.class);
        }
        for (;;)
        {
          localObject1 = ak.getContext();
          ??? = new com.tencent.mm.hellhoundlib.b.a().bc(localObject5);
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)???).ahE(), "com/tencent/mm/plugin/wear/model/yo/WearYoLogic", "publishNextYoMessage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)???).mt(0));
          com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/wear/model/yo/WearYoLogic", "publishNextYoMessage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(30137);
          return;
          localObject2 = finally;
          AppMethodBeat.o(30137);
          throw localObject2;
          label296:
          ((efp)???).nJA = bu.getInt((String)((Map)localObject5).get(".msg.yo.$type"), 0);
          ((efp)???).nID = bu.getInt((String)((Map)localObject5).get(".msg.yo.$count"), 0);
          break;
          i = 0;
          break label198;
          label344:
          ((Intent)localObject5).setClass(ak.getContext(), WearYoNoLockUI.class);
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
    String cUA;
    String content;
    
    public a(String paramString1, String paramString2)
    {
      this.cUA = paramString1;
      this.content = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.g.a
 * JD-Core Version:    0.7.0.1
 */