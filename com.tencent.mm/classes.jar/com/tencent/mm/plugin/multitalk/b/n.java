package com.tencent.mm.plugin.multitalk.b;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;

 enum n
{
  static
  {
    AppMethodBeat.i(190519);
    wmK = new n("INSTANCE");
    wmL = new n[] { wmK };
    AppMethodBeat.o(190519);
  }
  
  private n() {}
  
  private void Bp(int paramInt)
  {
    AppMethodBeat.i(190517);
    final String str = ak.getProcessName();
    ae.i("MicroMsg.Multitalk.ILinkNetworkMgr", "hy: %s operate network change: %d", new Object[] { str, Integer.valueOf(paramInt) });
    Bundle localBundle = new Bundle();
    localBundle.putString("from_process", str);
    localBundle.putInt("opcode", paramInt);
    h.a("com.tencent.mm", localBundle, a.class, new d() {});
    AppMethodBeat.o(190517);
  }
  
  final void cds()
  {
    AppMethodBeat.i(190515);
    ae.i("MicroMsg.Multitalk.ILinkNetworkMgr", "hy: start listen to network change");
    Bp(0);
    AppMethodBeat.o(190515);
  }
  
  final void cdt()
  {
    AppMethodBeat.i(190516);
    ae.i("MicroMsg.Multitalk.ILinkNetworkMgr", "hy: stop listen to network change");
    Bp(1);
    AppMethodBeat.o(190516);
  }
  
  static final class a
    implements b<Bundle, Bundle>
  {
    private static String pdG;
    private static final com.tencent.mm.network.n pdH;
    
    static
    {
      AppMethodBeat.i(190512);
      pdH = new com.tencent.mm.network.n.a()
      {
        public final void onNetworkChange(int paramAnonymousInt)
        {
          AppMethodBeat.i(190509);
          Object localObject = az.iW(ak.getContext());
          final String str = ak.getProcessName();
          ae.i("MicroMsg.Multitalk.ILinkNetworkMgr", "hy: %s on network changed: %d, changed to %s, %s", new Object[] { str, Integer.valueOf(paramAnonymousInt), localObject, n.a.pdG });
          localObject = new Bundle();
          ((Bundle)localObject).putString("from_process", str);
          ((Bundle)localObject).putInt("newState", paramAnonymousInt);
          h.a(n.a.pdG, (Parcelable)localObject, n.a.a.class, new d() {});
          AppMethodBeat.o(190509);
        }
      };
      AppMethodBeat.o(190512);
    }
    
    static class a
      implements b<Bundle, Bundle>
    {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.b.n
 * JD-Core Version:    0.7.0.1
 */