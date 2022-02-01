package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class day
  extends com.tencent.mm.bx.a
{
  public int EsK;
  public String EsL;
  public String EsM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117933);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.EsK);
      if (this.EsL != null) {
        paramVarArgs.d(2, this.EsL);
      }
      if (this.EsM != null) {
        paramVarArgs.d(3, this.EsM);
      }
      AppMethodBeat.o(117933);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = f.a.a.b.b.a.bA(1, this.EsK) + 0;
      paramInt = i;
      if (this.EsL != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.EsL);
      }
      i = paramInt;
      if (this.EsM != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.EsM);
      }
      AppMethodBeat.o(117933);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(117933);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      day localday = (day)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117933);
        return -1;
      case 1: 
        localday.EsK = locala.KhF.xS();
        AppMethodBeat.o(117933);
        return 0;
      case 2: 
        localday.EsL = locala.KhF.readString();
        AppMethodBeat.o(117933);
        return 0;
      }
      localday.EsM = locala.KhF.readString();
      AppMethodBeat.o(117933);
      return 0;
    }
    AppMethodBeat.o(117933);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.day
 * JD-Core Version:    0.7.0.1
 */