package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class azg
  extends com.tencent.mm.cd.a
{
  public String Dmx;
  public int fod;
  public long liveId;
  public String yxR;
  public String zev;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(229624);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.fod);
      paramVarArgs.bm(2, this.liveId);
      if (this.Dmx != null) {
        paramVarArgs.f(3, this.Dmx);
      }
      if (this.yxR != null) {
        paramVarArgs.f(4, this.yxR);
      }
      if (this.zev != null) {
        paramVarArgs.f(5, this.zev);
      }
      AppMethodBeat.o(229624);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bM(1, this.fod) + 0 + g.a.a.b.b.a.p(2, this.liveId);
      paramInt = i;
      if (this.Dmx != null) {
        paramInt = i + g.a.a.b.b.a.g(3, this.Dmx);
      }
      i = paramInt;
      if (this.yxR != null) {
        i = paramInt + g.a.a.b.b.a.g(4, this.yxR);
      }
      paramInt = i;
      if (this.zev != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.zev);
      }
      AppMethodBeat.o(229624);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(229624);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      azg localazg = (azg)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(229624);
        return -1;
      case 1: 
        localazg.fod = locala.abFh.AK();
        AppMethodBeat.o(229624);
        return 0;
      case 2: 
        localazg.liveId = locala.abFh.AN();
        AppMethodBeat.o(229624);
        return 0;
      case 3: 
        localazg.Dmx = locala.abFh.readString();
        AppMethodBeat.o(229624);
        return 0;
      case 4: 
        localazg.yxR = locala.abFh.readString();
        AppMethodBeat.o(229624);
        return 0;
      }
      localazg.zev = locala.abFh.readString();
      AppMethodBeat.o(229624);
      return 0;
    }
    AppMethodBeat.o(229624);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azg
 * JD-Core Version:    0.7.0.1
 */