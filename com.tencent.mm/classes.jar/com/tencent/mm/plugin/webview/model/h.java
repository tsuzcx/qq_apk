package com.tencent.mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.modeltools.f;
import com.tencent.mm.protocal.protobuf.cmc;
import com.tencent.mm.protocal.protobuf.cou;
import com.tencent.mm.sdk.platformtools.RWCache;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class h
{
  public int PTU;
  public int PTV;
  public int PTW;
  public final List<cou> PTX;
  public int PTY;
  public long PTZ;
  
  private h()
  {
    AppMethodBeat.i(78862);
    this.PTU = 20480;
    this.PTV = 30720;
    this.PTW = 51200;
    this.PTX = new LinkedList();
    this.PTY = 0;
    this.PTZ = 0L;
    AppMethodBeat.o(78862);
  }
  
  public static void iY(List<cmc> paramList)
  {
    AppMethodBeat.i(78863);
    if (Util.isNullOrNil(paramList))
    {
      AppMethodBeat.o(78863);
      return;
    }
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      cmc localcmc = (cmc)paramList.next();
      g localg = f.gWv();
      int i = localcmc.Stn;
      long l1 = Util.nowSecond();
      long l2 = localcmc.TtU;
      localg.PTS.set(Integer.valueOf(i), Long.valueOf(l1 + l2));
    }
    f.gWv().gVo();
    AppMethodBeat.o(78863);
  }
  
  public static final class a
  {
    private static final h PUa;
    
    static
    {
      AppMethodBeat.i(78861);
      PUa = new h((byte)0);
      AppMethodBeat.o(78861);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.webview.model.h
 * JD-Core Version:    0.7.0.1
 */