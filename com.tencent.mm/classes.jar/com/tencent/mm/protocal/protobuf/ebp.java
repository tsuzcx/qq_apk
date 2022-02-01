package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ebp
  extends com.tencent.mm.bw.a
{
  public int Lqt;
  public int Mmd;
  public int Nbp;
  public int Nbq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125840);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.Lqt);
      paramVarArgs.aM(2, this.Mmd);
      paramVarArgs.aM(3, this.Nbp);
      paramVarArgs.aM(4, this.Nbq);
      AppMethodBeat.o(125840);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.Lqt);
      int i = g.a.a.b.b.a.bu(2, this.Mmd);
      int j = g.a.a.b.b.a.bu(3, this.Nbp);
      int k = g.a.a.b.b.a.bu(4, this.Nbq);
      AppMethodBeat.o(125840);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(125840);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      ebp localebp = (ebp)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(125840);
        return -1;
      case 1: 
        localebp.Lqt = locala.UbS.zi();
        AppMethodBeat.o(125840);
        return 0;
      case 2: 
        localebp.Mmd = locala.UbS.zi();
        AppMethodBeat.o(125840);
        return 0;
      case 3: 
        localebp.Nbp = locala.UbS.zi();
        AppMethodBeat.o(125840);
        return 0;
      }
      localebp.Nbq = locala.UbS.zi();
      AppMethodBeat.o(125840);
      return 0;
    }
    AppMethodBeat.o(125840);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebp
 * JD-Core Version:    0.7.0.1
 */