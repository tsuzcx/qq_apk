package com.tencent.mm.plugin.voip.model;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.ConnectivityManager.NetworkCallback;
import android.net.Network;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ai;
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
    Object localObject = this.ACh.ABJ;
    ((v2protocal)localObject).AGO += 1;
    localObject = Parcel.obtain();
    paramNetwork.writeToParcel((Parcel)localObject, 0);
    com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "found requested network. netid: " + ((Parcel)localObject).readInt() + " toString: " + paramNetwork.toString());
    if (com.tencent.mm.compatible.util.d.kZ(28)) {
      localObject = (ConnectivityManager)ai.getContext().getSystemService("connectivity");
    }
    try
    {
      int j = ((ConnectivityManager)localObject).getMultipathPreference(paramNetwork);
      com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "getMultipathPreference ret ".concat(String.valueOf(j)));
      if (j == 0) {
        this.ACh.ABJ.AGN = 3;
      }
      if (this.ACh.ABY != null)
      {
        this.ACh.ABY = paramNetwork;
        if (this.ACh.ACa != null) {
          while (i < this.ACh.ACa.size())
          {
            this.ACh.aG(((Integer)this.ACh.ACa.get(i)).intValue(), true);
            i += 1;
          }
        }
      }
      else
      {
        this.ACh.ABY = paramNetwork;
      }
    }
    catch (Exception paramNetwork)
    {
      com.tencent.mm.plugin.voip.b.d.Logi("MicroMsg.Voip.VoipContext", "getMultipathPreference  Error");
      this.ACh.ABJ.AGN = 2;
      AppMethodBeat.o(114890);
      return;
    }
    this.ACh.ABZ = this;
    this.ACh.ABJ.AGN = 1;
    AppMethodBeat.o(114890);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.voip.model.l.7
 * JD-Core Version:    0.7.0.1
 */