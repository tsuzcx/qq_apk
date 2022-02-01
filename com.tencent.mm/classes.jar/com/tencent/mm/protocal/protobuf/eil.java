package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class eil
  extends com.tencent.mm.bw.a
{
  public double IlL;
  public long IlM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153324);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, this.IlL);
      paramVarArgs.aZ(2, this.IlM);
      AppMethodBeat.o(153324);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.amD(1);
      int i = f.a.a.b.b.a.p(2, this.IlM);
      AppMethodBeat.o(153324);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(153324);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      eil localeil = (eil)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(153324);
        return -1;
      case 1: 
        localeil.IlL = Double.longBitsToDouble(locala.OmT.gwc());
        AppMethodBeat.o(153324);
        return 0;
      }
      localeil.IlM = locala.OmT.zd();
      AppMethodBeat.o(153324);
      return 0;
    }
    AppMethodBeat.o(153324);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eil
 * JD-Core Version:    0.7.0.1
 */