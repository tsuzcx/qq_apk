package com.tencent.mm.plugin.wear.model.g;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import com.tencent.mm.h.a.ud;
import com.tencent.mm.h.a.ud.b;
import com.tencent.mm.plugin.wear.ui.WearYoLockUI;
import com.tencent.mm.plugin.wear.ui.WearYoNoLockUI;
import com.tencent.mm.protocal.c.ckq;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a
{
  private PowerManager qRO = (PowerManager)ae.getContext().getSystemService("power");
  private KeyguardManager qRP = (KeyguardManager)ae.getContext().getSystemService("keyguard");
  LinkedHashMap<String, a.a> qSP = new LinkedHashMap();
  
  public static ud Rl(String paramString)
  {
    ud localud = new ud();
    localud.ceB.bHz = 1;
    localud.ceB.username = paramString;
    com.tencent.mm.sdk.b.a.udP.m(localud);
    return localud;
  }
  
  public final void bZb()
  {
    if (Rl(null).ceC.ceD != 0)
    {
      y.i("MicroMsg.wear.WearYoLogic", "current show yo");
      return;
    }
    for (;;)
    {
      Object localObject5;
      synchronized (this.qSP)
      {
        Object localObject1 = this.qSP.entrySet().iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label281;
        }
        localObject1 = (a.a)((Map.Entry)((Iterator)localObject1).next()).getValue();
        if (localObject1 != null) {
          this.qSP.remove(((a.a)localObject1).pyp);
        }
        if (localObject1 == null) {
          break;
        }
        localObject5 = ((a.a)localObject1).content;
        ??? = new ckq();
        localObject5 = bn.s((String)localObject5, "msg");
        if (localObject5 == null)
        {
          ((ckq)???).hQR = 0;
          localObject5 = new Intent();
          ((Intent)localObject5).putExtra("key_talker", ((a.a)localObject1).pyp);
        }
      }
      try
      {
        ((Intent)localObject5).putExtra("key_data", ((ckq)???).toByteArray());
        label156:
        ((Intent)localObject5).addFlags(268435456);
        int i;
        if ((this.qRP.inKeyguardRestrictedInputMode()) || (!this.qRO.isScreenOn()))
        {
          i = 1;
          label186:
          if (i == 0) {
            break label263;
          }
          ((Intent)localObject5).setClass(ae.getContext(), WearYoLockUI.class);
        }
        for (;;)
        {
          ae.getContext().startActivity((Intent)localObject5);
          return;
          localObject2 = finally;
          throw localObject2;
          ((ckq)???).hQR = bk.getInt((String)((Map)localObject5).get(".msg.yo.$type"), 0);
          ((ckq)???).hPS = bk.getInt((String)((Map)localObject5).get(".msg.yo.$count"), 0);
          break;
          i = 0;
          break label186;
          label263:
          ((Intent)localObject5).setClass(ae.getContext(), WearYoNoLockUI.class);
        }
      }
      catch (IOException localIOException)
      {
        break label156;
      }
      label281:
      Object localObject3 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.g.a
 * JD-Core Version:    0.7.0.1
 */