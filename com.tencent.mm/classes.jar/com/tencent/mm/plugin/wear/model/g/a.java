package com.tencent.mm.plugin.wear.model.g;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.vz;
import com.tencent.mm.g.a.vz.b;
import com.tencent.mm.plugin.wear.ui.WearYoLockUI;
import com.tencent.mm.plugin.wear.ui.WearYoNoLockUI;
import com.tencent.mm.protocal.protobuf.cyd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a
{
  private PowerManager uGW;
  private KeyguardManager uGX;
  LinkedHashMap<String, a.a> uHW;
  
  public a()
  {
    AppMethodBeat.i(26453);
    this.uHW = new LinkedHashMap();
    this.uGW = ((PowerManager)ah.getContext().getSystemService("power"));
    this.uGX = ((KeyguardManager)ah.getContext().getSystemService("keyguard"));
    AppMethodBeat.o(26453);
  }
  
  public static vz agi(String paramString)
  {
    AppMethodBeat.i(26454);
    vz localvz = new vz();
    localvz.cNo.coO = 1;
    localvz.cNo.username = paramString;
    com.tencent.mm.sdk.b.a.ymk.l(localvz);
    AppMethodBeat.o(26454);
    return localvz;
  }
  
  public final void cYO()
  {
    AppMethodBeat.i(26455);
    if (agi(null).cNp.cNq != 0)
    {
      ab.i("MicroMsg.wear.WearYoLogic", "current show yo");
      AppMethodBeat.o(26455);
      return;
    }
    for (;;)
    {
      Object localObject5;
      synchronized (this.uHW)
      {
        Object localObject1 = this.uHW.entrySet().iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label305;
        }
        localObject1 = (a.a)((Map.Entry)((Iterator)localObject1).next()).getValue();
        if (localObject1 != null) {
          this.uHW.remove(((a.a)localObject1).tac);
        }
        if (localObject1 != null)
        {
          localObject5 = ((a.a)localObject1).content;
          ??? = new cyd();
          localObject5 = br.F((String)localObject5, "msg");
          if (localObject5 != null) {
            break label239;
          }
          ((cyd)???).jKs = 0;
          localObject5 = new Intent();
          ((Intent)localObject5).putExtra("key_talker", ((a.a)localObject1).tac);
        }
      }
      try
      {
        ((Intent)localObject5).putExtra("key_data", ((cyd)???).toByteArray());
        label168:
        ((Intent)localObject5).addFlags(268435456);
        int i;
        if ((this.uGX.inKeyguardRestrictedInputMode()) || (!this.uGW.isScreenOn()))
        {
          i = 1;
          label198:
          if (i == 0) {
            break label287;
          }
          ((Intent)localObject5).setClass(ah.getContext(), WearYoLockUI.class);
        }
        for (;;)
        {
          ah.getContext().startActivity((Intent)localObject5);
          AppMethodBeat.o(26455);
          return;
          localObject2 = finally;
          AppMethodBeat.o(26455);
          throw localObject2;
          label239:
          ((cyd)???).jKs = bo.getInt((String)((Map)localObject5).get(".msg.yo.$type"), 0);
          ((cyd)???).jJu = bo.getInt((String)((Map)localObject5).get(".msg.yo.$count"), 0);
          break;
          i = 0;
          break label198;
          label287:
          ((Intent)localObject5).setClass(ah.getContext(), WearYoNoLockUI.class);
        }
      }
      catch (IOException localIOException)
      {
        break label168;
      }
      label305:
      Object localObject3 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.g.a
 * JD-Core Version:    0.7.0.1
 */