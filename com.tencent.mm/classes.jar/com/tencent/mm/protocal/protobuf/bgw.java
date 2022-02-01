package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class bgw
  extends com.tencent.mm.cd.a
{
  public float SRx;
  public float SRy;
  public int SRz;
  public float latitude;
  public float longitude;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169035);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.i(8, this.longitude);
      paramVarArgs.i(9, this.latitude);
      paramVarArgs.i(10, this.SRx);
      paramVarArgs.i(11, this.SRy);
      paramVarArgs.aY(12, this.SRz);
      AppMethodBeat.o(169035);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.gL(8);
      int i = g.a.a.b.b.a.gL(9);
      int j = g.a.a.b.b.a.gL(10);
      int k = g.a.a.b.b.a.gL(11);
      int m = g.a.a.b.b.a.bM(12, this.SRz);
      AppMethodBeat.o(169035);
      return paramInt + 4 + 0 + (i + 4) + (j + 4) + (k + 4) + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(169035);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      bgw localbgw = (bgw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(169035);
        return -1;
      case 8: 
        localbgw.longitude = Float.intBitsToFloat(locala.abFh.AO());
        AppMethodBeat.o(169035);
        return 0;
      case 9: 
        localbgw.latitude = Float.intBitsToFloat(locala.abFh.AO());
        AppMethodBeat.o(169035);
        return 0;
      case 10: 
        localbgw.SRx = Float.intBitsToFloat(locala.abFh.AO());
        AppMethodBeat.o(169035);
        return 0;
      case 11: 
        localbgw.SRy = Float.intBitsToFloat(locala.abFh.AO());
        AppMethodBeat.o(169035);
        return 0;
      }
      localbgw.SRz = locala.abFh.AK();
      AppMethodBeat.o(169035);
      return 0;
    }
    AppMethodBeat.o(169035);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgw
 * JD-Core Version:    0.7.0.1
 */