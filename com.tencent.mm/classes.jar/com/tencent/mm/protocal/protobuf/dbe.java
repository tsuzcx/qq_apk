package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dbe
  extends com.tencent.mm.bx.a
{
  public int DYT;
  public int EsP;
  public String EsQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32466);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.EsP);
      paramVarArgs.aR(2, this.DYT);
      if (this.EsQ != null) {
        paramVarArgs.d(3, this.EsQ);
      }
      AppMethodBeat.o(32466);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.EsP) + 0 + f.a.a.b.b.a.bA(2, this.DYT);
      paramInt = i;
      if (this.EsQ != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.EsQ);
      }
      AppMethodBeat.o(32466);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(32466);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dbe localdbe = (dbe)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(32466);
        return -1;
      case 1: 
        localdbe.EsP = locala.KhF.xS();
        AppMethodBeat.o(32466);
        return 0;
      case 2: 
        localdbe.DYT = locala.KhF.xS();
        AppMethodBeat.o(32466);
        return 0;
      }
      localdbe.EsQ = locala.KhF.readString();
      AppMethodBeat.o(32466);
      return 0;
    }
    AppMethodBeat.o(32466);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbe
 * JD-Core Version:    0.7.0.1
 */