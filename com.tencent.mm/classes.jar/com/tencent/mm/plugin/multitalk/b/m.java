package com.tencent.mm.plugin.multitalk.b;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.network.p;
import com.tencent.mm.network.p.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;

 enum m
{
  static
  {
    AppMethodBeat.i(204041);
    Fna = new m("INSTANCE");
    Fnb = new m[] { Fna };
    AppMethodBeat.o(204041);
  }
  
  private m() {}
  
  private void IF(int paramInt)
  {
    AppMethodBeat.i(204037);
    final String str = MMApplicationContext.getProcessName();
    Log.i("MicroMsg.Multitalk.ILinkNetworkMgr", "hy: %s operate network change: %d", new Object[] { str, Integer.valueOf(paramInt) });
    Bundle localBundle = new Bundle();
    localBundle.putString("from_process", str);
    localBundle.putInt("opcode", paramInt);
    j.a(MainProcessIPCService.PROCESS_NAME, localBundle, a.class, new f() {});
    AppMethodBeat.o(204037);
  }
  
  public static int eVw()
  {
    int j = 5;
    AppMethodBeat.i(204033);
    int i;
    if (NetStatusUtil.is2G(MMApplicationContext.getContext())) {
      i = 1;
    }
    for (;;)
    {
      Log.i("MicroMsg.Multitalk.ILinkNetworkMgr", "hy: current network type is: %d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(204033);
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
  
  final void cPR()
  {
    AppMethodBeat.i(204035);
    Log.i("MicroMsg.Multitalk.ILinkNetworkMgr", "hy: start listen to network change");
    IF(0);
    AppMethodBeat.o(204035);
  }
  
  final void cPS()
  {
    AppMethodBeat.i(204036);
    Log.i("MicroMsg.Multitalk.ILinkNetworkMgr", "hy: stop listen to network change");
    IF(1);
    AppMethodBeat.o(204036);
  }
  
  static final class a
    implements d<Bundle, Bundle>
  {
    private static String tRs;
    private static final p tRt;
    
    static
    {
      AppMethodBeat.i(205163);
      tRt = new p.a()
      {
        public final void onNetworkChange(int paramAnonymousInt)
        {
          AppMethodBeat.i(195938);
          Object localObject = NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext());
          final String str = MMApplicationContext.getProcessName();
          Log.i("MicroMsg.Multitalk.ILinkNetworkMgr", "hy: %s on network changed: %d, changed to %s, %s", new Object[] { str, Integer.valueOf(paramAnonymousInt), localObject, m.a.tRs });
          localObject = new Bundle();
          ((Bundle)localObject).putString("from_process", str);
          ((Bundle)localObject).putInt("newState", paramAnonymousInt);
          j.a(m.a.tRs, (Parcelable)localObject, m.a.a.class, new f() {});
          AppMethodBeat.o(195938);
        }
      };
      AppMethodBeat.o(205163);
    }
    
    static class a
      implements d<Bundle, Bundle>
    {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.b.m
 * JD-Core Version:    0.7.0.1
 */