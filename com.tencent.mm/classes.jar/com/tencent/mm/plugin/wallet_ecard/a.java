package com.tencent.mm.plugin.wallet_ecard;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h.d;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.cs.a;
import com.tencent.mm.g.a.ly;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.wallet.g;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.c.a;
import java.util.HashMap;

public class a
  implements at
{
  private c.a uyw;
  private c<cs> uyx;
  private c<ly> uyy;
  
  public a()
  {
    AppMethodBeat.i(48045);
    this.uyx = new a.1(this);
    this.uyy = new a.2(this);
    AppMethodBeat.o(48045);
  }
  
  public void clearPluginData(int paramInt) {}
  
  public HashMap<Integer, h.d> getBaseDBFactories()
  {
    return null;
  }
  
  public void onAccountPostReset(boolean paramBoolean)
  {
    AppMethodBeat.i(48046);
    this.uyx.alive();
    this.uyy.alive();
    AppMethodBeat.o(48046);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(48047);
    this.uyx.dead();
    this.uyy.dead();
    AppMethodBeat.o(48047);
  }
  
  public void onSdcardMount(boolean paramBoolean) {}
  
  final class a
    implements c.a
  {
    private cs uyE;
    
    public a(cs paramcs)
    {
      this.uyE = paramcs;
    }
    
    public final Intent p(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(48044);
      ab.i("MicroMsg.SubCoreECard", "open process end: %s", new Object[] { Integer.valueOf(paramInt) });
      if (paramInt == -1)
      {
        this.uyE.cqe.retCode = 0;
        h.qsU.e(14954, new Object[] { g.dpO(), "openEcard:ok" });
      }
      for (;;)
      {
        this.uyE.cqd.callback.run();
        if (!g.dpN()) {
          g.dpP();
        }
        a.a(a.this, null);
        Intent localIntent = new Intent();
        localIntent.putExtras(paramBundle);
        AppMethodBeat.o(48044);
        return localIntent;
        this.uyE.cqe.retCode = -1;
        if (!g.dpN()) {
          h.qsU.e(14954, new Object[] { g.dpO(), "openEcard:fail" });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet_ecard.a
 * JD-Core Version:    0.7.0.1
 */