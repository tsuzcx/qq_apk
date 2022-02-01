package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aax
  extends com.tencent.mm.bw.a
{
  public LinkedList<String> GsN;
  public int GsO;
  public int GsP;
  
  public aax()
  {
    AppMethodBeat.i(211618);
    this.GsN = new LinkedList();
    AppMethodBeat.o(211618);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(211619);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 1, this.GsN);
      paramVarArgs.aS(2, this.GsO);
      paramVarArgs.aS(3, this.GsP);
      AppMethodBeat.o(211619);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.a.c(1, 1, this.GsN);
      int i = f.a.a.b.b.a.bz(2, this.GsO);
      int j = f.a.a.b.b.a.bz(3, this.GsP);
      AppMethodBeat.o(211619);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.GsN.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(211619);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      aax localaax = (aax)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(211619);
        return -1;
      case 1: 
        localaax.GsN.add(locala.OmT.readString());
        AppMethodBeat.o(211619);
        return 0;
      case 2: 
        localaax.GsO = locala.OmT.zc();
        AppMethodBeat.o(211619);
        return 0;
      }
      localaax.GsP = locala.OmT.zc();
      AppMethodBeat.o(211619);
      return 0;
    }
    AppMethodBeat.o(211619);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aax
 * JD-Core Version:    0.7.0.1
 */