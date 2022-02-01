package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;

public final class cfy
  extends com.tencent.mm.bw.a
{
  public int MlF;
  public b MlG;
  public int MlM;
  public int MlN;
  public int oTz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116337);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.MlF);
      if (this.MlG != null) {
        paramVarArgs.c(2, this.MlG);
      }
      paramVarArgs.aM(3, this.MlM);
      paramVarArgs.aM(4, this.oTz);
      paramVarArgs.aM(5, this.MlN);
      AppMethodBeat.o(116337);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = g.a.a.b.b.a.bu(1, this.MlF) + 0;
      paramInt = i;
      if (this.MlG != null) {
        paramInt = i + g.a.a.b.b.a.b(2, this.MlG);
      }
      i = g.a.a.b.b.a.bu(3, this.MlM);
      int j = g.a.a.b.b.a.bu(4, this.oTz);
      int k = g.a.a.b.b.a.bu(5, this.MlN);
      AppMethodBeat.o(116337);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(116337);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      cfy localcfy = (cfy)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(116337);
        return -1;
      case 1: 
        localcfy.MlF = locala.UbS.zi();
        AppMethodBeat.o(116337);
        return 0;
      case 2: 
        localcfy.MlG = locala.UbS.hPo();
        AppMethodBeat.o(116337);
        return 0;
      case 3: 
        localcfy.MlM = locala.UbS.zi();
        AppMethodBeat.o(116337);
        return 0;
      case 4: 
        localcfy.oTz = locala.UbS.zi();
        AppMethodBeat.o(116337);
        return 0;
      }
      localcfy.MlN = locala.UbS.zi();
      AppMethodBeat.o(116337);
      return 0;
    }
    AppMethodBeat.o(116337);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cfy
 * JD-Core Version:    0.7.0.1
 */