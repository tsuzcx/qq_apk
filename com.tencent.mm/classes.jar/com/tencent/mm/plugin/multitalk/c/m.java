package com.tencent.mm.plugin.multitalk.c;

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
    AppMethodBeat.i(285136);
    Ljg = new m("INSTANCE");
    Ljh = new m[] { Ljg };
    AppMethodBeat.o(285136);
  }
  
  private m() {}
  
  private void Ji(int paramInt)
  {
    AppMethodBeat.i(285123);
    final String str = MMApplicationContext.getProcessName();
    Log.i("MicroMsg.Multitalk.ILinkNetworkMgr", "hy: %s operate network change: %d", new Object[] { str, Integer.valueOf(paramInt) });
    Bundle localBundle = new Bundle();
    localBundle.putString("from_process", str);
    localBundle.putInt("opcode", paramInt);
    j.a(MainProcessIPCService.PROCESS_NAME, localBundle, a.class, new f() {});
    AppMethodBeat.o(285123);
  }
  
  public static int gen()
  {
    int j = 5;
    AppMethodBeat.i(285117);
    int i;
    if (NetStatusUtil.is2G(MMApplicationContext.getContext())) {
      i = 1;
    }
    for (;;)
    {
      Log.i("MicroMsg.Multitalk.ILinkNetworkMgr", "hy: current network type is: %d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(285117);
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
  
  final void cuD()
  {
    AppMethodBeat.i(285147);
    Log.i("MicroMsg.Multitalk.ILinkNetworkMgr", "hy: stop listen to network change");
    Ji(1);
    AppMethodBeat.o(285147);
  }
  
  final void duo()
  {
    AppMethodBeat.i(285141);
    Log.i("MicroMsg.Multitalk.ILinkNetworkMgr", "hy: start listen to network change");
    Ji(0);
    AppMethodBeat.o(285141);
  }
  
  static final class a
    implements d<Bundle, Bundle>
  {
    private static String wUI;
    private static final p wUJ;
    
    static
    {
      AppMethodBeat.i(285061);
      wUJ = new p.a()
      {
        public final void onNetworkChange(int paramAnonymousInt)
        {
          AppMethodBeat.i(285062);
          Object localObject = NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext());
          final String str = MMApplicationContext.getProcessName();
          Log.i("MicroMsg.Multitalk.ILinkNetworkMgr", "hy: %s on network changed: %d, changed to %s, %s", new Object[] { str, Integer.valueOf(paramAnonymousInt), localObject, m.a.wUI });
          localObject = new Bundle();
          ((Bundle)localObject).putString("from_process", str);
          ((Bundle)localObject).putInt("newState", paramAnonymousInt);
          j.a(m.a.wUI, (Parcelable)localObject, m.a.a.class, new f() {});
          AppMethodBeat.o(285062);
        }
      };
      AppMethodBeat.o(285061);
    }
    
    static class a
      implements d<Bundle, Bundle>
    {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.multitalk.c.m
 * JD-Core Version:    0.7.0.1
 */