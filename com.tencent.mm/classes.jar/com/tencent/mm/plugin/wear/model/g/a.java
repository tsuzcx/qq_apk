package com.tencent.mm.plugin.wear.model.g;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.adv;
import com.tencent.mm.autogen.a.adv.b;
import com.tencent.mm.plugin.wear.ui.WearYoLockUI;
import com.tencent.mm.plugin.wear.ui.WearYoNoLockUI;
import com.tencent.mm.protocal.protobuf.ghc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class a
{
  private KeyguardManager WiC;
  LinkedHashMap<String, a> Wjz;
  private PowerManager powerManager;
  
  public a()
  {
    AppMethodBeat.i(30135);
    this.Wjz = new LinkedHashMap();
    this.powerManager = ((PowerManager)MMApplicationContext.getContext().getSystemService("power"));
    this.WiC = ((KeyguardManager)MMApplicationContext.getContext().getSystemService("keyguard"));
    AppMethodBeat.o(30135);
  }
  
  public static adv bhG(String paramString)
  {
    AppMethodBeat.i(30136);
    adv localadv = new adv();
    localadv.iig.hAf = 1;
    localadv.iig.username = paramString;
    localadv.publish();
    AppMethodBeat.o(30136);
    return localadv;
  }
  
  public final void ioe()
  {
    AppMethodBeat.i(30137);
    if (bhG(null).iih.iii != 0)
    {
      Log.i("MicroMsg.wear.WearYoLogic", "current show yo");
      AppMethodBeat.o(30137);
      return;
    }
    for (;;)
    {
      Object localObject1;
      Object localObject5;
      synchronized (this.Wjz)
      {
        localObject1 = this.Wjz.entrySet().iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label363;
        }
        localObject1 = (a)((Map.Entry)((Iterator)localObject1).next()).getValue();
        if (localObject1 != null) {
          this.Wjz.remove(((a)localObject1).hgk);
        }
        if (localObject1 != null)
        {
          localObject5 = ((a)localObject1).content;
          ??? = new ghc();
          localObject5 = XmlParser.parseXml((String)localObject5, "msg", null);
          if (localObject5 != null) {
            break label297;
          }
          ((ghc)???).vhJ = 0;
          localObject5 = new Intent();
          ((Intent)localObject5).putExtra("key_talker", ((a)localObject1).hgk);
        }
      }
      try
      {
        ((Intent)localObject5).putExtra("key_data", ((ghc)???).toByteArray());
        label169:
        ((Intent)localObject5).addFlags(268435456);
        int i;
        if ((this.WiC.inKeyguardRestrictedInputMode()) || (!this.powerManager.isScreenOn()))
        {
          i = 1;
          label199:
          if (i == 0) {
            break label345;
          }
          ((Intent)localObject5).setClass(MMApplicationContext.getContext(), WearYoLockUI.class);
        }
        for (;;)
        {
          localObject1 = MMApplicationContext.getContext();
          ??? = new com.tencent.mm.hellhoundlib.b.a().cG(localObject5);
          com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)???).aYi(), "com/tencent/mm/plugin/wear/model/yo/WearYoLogic", "publishNextYoMessage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)???).sb(0));
          com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/wear/model/yo/WearYoLogic", "publishNextYoMessage", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
          AppMethodBeat.o(30137);
          return;
          localObject2 = finally;
          AppMethodBeat.o(30137);
          throw localObject2;
          label297:
          ((ghc)???).vhJ = Util.getInt((String)((Map)localObject5).get(".msg.yo.$type"), 0);
          ((ghc)???).vgN = Util.getInt((String)((Map)localObject5).get(".msg.yo.$count"), 0);
          break;
          i = 0;
          break label199;
          label345:
          ((Intent)localObject5).setClass(MMApplicationContext.getContext(), WearYoNoLockUI.class);
        }
      }
      catch (IOException localIOException)
      {
        break label169;
      }
      label363:
      Object localObject3 = null;
    }
  }
  
  final class a
  {
    String content;
    String hgk;
    
    public a(String paramString1, String paramString2)
    {
      this.hgk = paramString1;
      this.content = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.wear.model.g.a
 * JD-Core Version:    0.7.0.1
 */