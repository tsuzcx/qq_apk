package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aqx
  extends com.tencent.mm.bw.a
{
  public float GHH;
  public float GHI;
  public int GHJ;
  public float dBu;
  public float dzE;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169035);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.y(8, this.dBu);
      paramVarArgs.y(9, this.dzE);
      paramVarArgs.y(10, this.GHH);
      paramVarArgs.y(11, this.GHI);
      paramVarArgs.aS(12, this.GHJ);
      AppMethodBeat.o(169035);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.amE(8);
      int i = f.a.a.b.b.a.amE(9);
      int j = f.a.a.b.b.a.amE(10);
      int k = f.a.a.b.b.a.amE(11);
      int m = f.a.a.b.b.a.bz(12, this.GHJ);
      AppMethodBeat.o(169035);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(169035);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      aqx localaqx = (aqx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(169035);
        return -1;
      case 8: 
        localaqx.dBu = Float.intBitsToFloat(locala.OmT.gwb());
        AppMethodBeat.o(169035);
        return 0;
      case 9: 
        localaqx.dzE = Float.intBitsToFloat(locala.OmT.gwb());
        AppMethodBeat.o(169035);
        return 0;
      case 10: 
        localaqx.GHH = Float.intBitsToFloat(locala.OmT.gwb());
        AppMethodBeat.o(169035);
        return 0;
      case 11: 
        localaqx.GHI = Float.intBitsToFloat(locala.OmT.gwb());
        AppMethodBeat.o(169035);
        return 0;
      }
      localaqx.GHJ = locala.OmT.zc();
      AppMethodBeat.o(169035);
      return 0;
    }
    AppMethodBeat.o(169035);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqx
 * JD-Core Version:    0.7.0.1
 */