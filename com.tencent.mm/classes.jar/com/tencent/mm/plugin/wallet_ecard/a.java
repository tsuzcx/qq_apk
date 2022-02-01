package com.tencent.mm.plugin.wallet_ecard;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.dv;
import com.tencent.mm.autogen.a.dv.a;
import com.tencent.mm.autogen.a.re;
import com.tencent.mm.model.be;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.wallet.e;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storagebase.h.b;
import com.tencent.mm.wallet_core.e.a;
import java.util.HashMap;

public class a
  implements be
{
  private IListener<dv> VYA;
  private IListener<re> VYB;
  private e.a VYz;
  
  public a()
  {
    AppMethodBeat.i(71678);
    this.VYA = new SubCoreECard.1(this, f.hfK);
    this.VYB = new SubCoreECard.2(this, f.hfK);
    AppMethodBeat.o(71678);
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.b> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(71679);
    this.VYA.alive();
    this.VYB.alive();
    AppMethodBeat.o(71679);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(71680);
    this.VYA.dead();
    this.VYB.dead();
    AppMethodBeat.o(71680);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
  
  final class a
    implements e.a
  {
    private dv VYH;
    
    public a(dv paramdv)
    {
      this.VYH = paramdv;
    }
    
    public final Intent v(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(71677);
      Log.i("MicroMsg.SubCoreECard", "open process end: %s", new Object[] { Integer.valueOf(paramInt) });
      if (paramInt == -1)
      {
        this.VYH.hDH.retCode = 0;
        h.OAn.b(14954, new Object[] { e.iOW(), "openEcard:ok" });
      }
      for (;;)
      {
        this.VYH.hDG.callback.run();
        if (!e.iOV()) {
          e.iOX();
        }
        a.a(a.this, null);
        Intent localIntent = new Intent();
        localIntent.putExtras(paramBundle);
        AppMethodBeat.o(71677);
        return localIntent;
        this.VYH.hDH.retCode = -1;
        if (!e.iOV()) {
          h.OAn.b(14954, new Object[] { e.iOW(), "openEcard:fail" });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.a
 * JD-Core Version:    0.7.0.1
 */