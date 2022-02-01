package com.tencent.mm.plugin.multitalk.b;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.network.p;
import com.tencent.mm.network.p.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;

 enum n
{
  static
  {
    AppMethodBeat.i(239099);
    zHO = new n("INSTANCE");
    zHP = new n[] { zHO };
    AppMethodBeat.o(239099);
  }
  
  private n() {}
  
  private void EX(int paramInt)
  {
    AppMethodBeat.i(239097);
    final String str = MMApplicationContext.getProcessName();
    Log.i("MicroMsg.Multitalk.ILinkNetworkMgr", "hy: %s operate network change: %d", new Object[] { str, Integer.valueOf(paramInt) });
    Bundle localBundle = new Bundle();
    localBundle.putString("from_process", str);
    localBundle.putInt("opcode", paramInt);
    h.a(MainProcessIPCService.dkO, localBundle, a.class, new d() {});
    AppMethodBeat.o(239097);
  }
  
  public static int elK()
  {
    int j = 5;
    AppMethodBeat.i(239094);
    int i;
    if (NetStatusUtil.is2G(MMApplicationContext.getContext())) {
      i = 1;
    }
    for (;;)
    {
      Log.i("MicroMsg.Multitalk.ILinkNetworkMgr", "hy: current network type is: %d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(239094);
      return i;
      if (NetStatusUtil.is3G(MMApplicationContext.getContext()))
      {
        i = 3;
      }
      else if (NetStatusUtil.isWifi(MMApplicationContext.getContext()))
      {
        i = 4;
      }
      else
      {
        i = j;
        if (!NetStatusUtil.is4G(MMApplicationContext.getContext()))
        {
          i = j;
          if (!NetStatusUtil.is5G(MMApplicationContext.getContext())) {
            i = 0;
          }
        }
      }
    }
  }
  
  final void cBn()
  {
    AppMethodBeat.i(239095);
    Log.i("MicroMsg.Multitalk.ILinkNetworkMgr", "hy: start listen to network change");
    EX(0);
    AppMethodBeat.o(239095);
  }
  
  final void cBo()
  {
    AppMethodBeat.i(239096);
    Log.i("MicroMsg.Multitalk.ILinkNetworkMgr", "hy: stop listen to network change");
    EX(1);
    AppMethodBeat.o(239096);
  }
  
  static final class a
    implements b<Bundle, Bundle>
  {
    private static String qsG;
    private static final p qsH;
    
    static
    {
      AppMethodBeat.i(239091);
      qsH = new p.a()
      {
        public final void onNetworkChange(int paramAnonymousInt)
        {
          AppMethodBeat.i(239088);
          Object localObject = NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext());
          final String str = MMApplicationContext.getProcessName();
          Log.i("MicroMsg.Multitalk.ILinkNetworkMgr", "hy: %s on network changed: %d, changed to %s, %s", new Object[] { str, Integer.valueOf(paramAnonymousInt), localObject, n.a.qsG });
          localObject = new Bundle();
          ((Bundle)localObject).putString("from_process", str);
          ((Bundle)localObject).putInt("newState", paramAnonymousInt);
          h.a(n.a.qsG, (Parcelable)localObject, n.a.a.class, new d() {});
          AppMethodBeat.o(239088);
        }
      };
      AppMethodBeat.o(239091);
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