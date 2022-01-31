package com.tencent.mm.plugin.nearby.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.nearby.a.a;
import com.tencent.mm.protocal.protobuf.azr;

final class NearbyFriendsUI$d
{
  public static int pdz = 10000;
  
  public static boolean AC(int paramInt)
  {
    return paramInt == pdz;
  }
  
  public static azr d(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(145834);
    a locala = new a();
    locala.gwP = pdz;
    locala.jJA = paramString1;
    locala.wJr = paramString2;
    locala.xpd = paramString4;
    locala.jKG = paramString3;
    locala.gwQ = paramString5;
    AppMethodBeat.o(145834);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI.d
 * JD-Core Version:    0.7.0.1
 */