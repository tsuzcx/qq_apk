package com.tencent.mm.plugin.voip.model;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.ConnectivityManager.NetworkCallback;
import android.net.Network;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.voip.f.g;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.LinkedList;

final class l$7
  extends ConnectivityManager.NetworkCallback
{
  l$7(l paraml) {}
  
  public final void onAvailable(Network paramNetwork)
  {
    int i = 0;
    AppMethodBeat.i(114890);
    super.onAvailable(paramNetwork);
    Object localObject = this.Uzp.UyU;
    ((v2protocal)localObject).UEk += 1;
    localObject = Parcel.obtain();
    paramNetwork.writeToParcel((Parcel)localObject, 0);
    g.Logi("MicroMsg.Voip.VoipContext", "found requested network. netid: " + ((Parcel)localObject).readInt() + " toString: " + paramNetwork.toString());
    if (d.rb(28)) {
      localObject = (ConnectivityManager)MMApplicationContext.getContext().getSystemService("connectivity");
    }
    try
    {
      int j = ((ConnectivityManager)localObject).getMultipathPreference(paramNetwork);
      g.Logi("MicroMsg.Voip.VoipContext", "getMultipathPreference ret ".concat(String.valueOf(j)));
      if (j == 0) {
        this.Uzp.UyU.UEj = 3;
      }
      if (this.Uzp.Lkt != null)
      {
        this.Uzp.Lkt = paramNetwork;
        if (this.Uzp.Lkv == null) {
          break label266;
        }
        while (i < this.Uzp.Lkv.size())
        {
          this.Uzp.bk(((Integer)this.Uzp.Lkv.get(i)).intValue(), true);
          i += 1;
        }
      }
      label266:
      return;
    }
    catch (Exception paramNetwork)
    {
      g.Logi("MicroMsg.Voip.VoipContext", "getMultipathPreference  Error");
      this.Uzp.UyU.UEj = 2;
      try
      {
        ((ConnectivityManager)localObject).unregisterNetworkCallback(this);
        AppMethodBeat.o(114890);
        return;
      }
      catch (Exception paramNetwork)
      {
        g.Logi("MicroMsg.Voip.VoipContext", "unregisterNetworkCallback Error");
        AppMethodBeat.o(114890);
        return;
      }
      this.Uzp.Lkt = paramNetwork;
      this.Uzp.Lku = this;
      g.Logi("MicroMsg.Voip.VoipContext", "networkcallback hashCode: " + this.Uzp.Lku.hashCode());
      this.Uzp.UyU.UEj = 1;
      AppMethodBeat.o(114890);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.l.7
 * JD-Core Version:    0.7.0.1
 */