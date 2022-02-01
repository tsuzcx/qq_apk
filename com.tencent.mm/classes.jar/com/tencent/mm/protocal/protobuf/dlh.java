package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dlh
  extends com.tencent.mm.bx.a
{
  public int DYT;
  public int EsP;
  public String EsQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115860);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.EsP);
      paramVarArgs.aR(2, this.DYT);
      if (this.EsQ != null) {
        paramVarArgs.d(3, this.EsQ);
      }
      AppMethodBeat.o(115860);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.EsP) + 0 + f.a.a.b.b.a.bA(2, this.DYT);
      paramInt = i;
      if (this.EsQ != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.EsQ);
      }
      AppMethodBeat.o(115860);
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
      AppMethodBeat.o(115860);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dlh localdlh = (dlh)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(115860);
        return -1;
      case 1: 
        localdlh.EsP = locala.KhF.xS();
        AppMethodBeat.o(115860);
        return 0;
      case 2: 
        localdlh.DYT = locala.KhF.xS();
        AppMethodBeat.o(115860);
        return 0;
      }
      localdlh.EsQ = locala.KhF.readString();
      AppMethodBeat.o(115860);
      return 0;
    }
    AppMethodBeat.o(115860);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dlh
 * JD-Core Version:    0.7.0.1
 */