package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dtm
  extends com.tencent.mm.bx.a
{
  public int CLL;
  public String EIi;
  public String EIj;
  public String dlB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82491);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dlB != null) {
        paramVarArgs.d(1, this.dlB);
      }
      paramVarArgs.aR(2, this.CLL);
      if (this.EIi != null) {
        paramVarArgs.d(3, this.EIi);
      }
      if (this.EIj != null) {
        paramVarArgs.d(4, this.EIj);
      }
      AppMethodBeat.o(82491);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dlB == null) {
        break label378;
      }
    }
    label378:
    for (paramInt = f.a.a.b.b.a.e(1, this.dlB) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bA(2, this.CLL);
      paramInt = i;
      if (this.EIi != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.EIi);
      }
      i = paramInt;
      if (this.EIj != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.EIj);
      }
      AppMethodBeat.o(82491);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(82491);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dtm localdtm = (dtm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(82491);
          return -1;
        case 1: 
          localdtm.dlB = locala.KhF.readString();
          AppMethodBeat.o(82491);
          return 0;
        case 2: 
          localdtm.CLL = locala.KhF.xS();
          AppMethodBeat.o(82491);
          return 0;
        case 3: 
          localdtm.EIi = locala.KhF.readString();
          AppMethodBeat.o(82491);
          return 0;
        }
        localdtm.EIj = locala.KhF.readString();
        AppMethodBeat.o(82491);
        return 0;
      }
      AppMethodBeat.o(82491);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dtm
 * JD-Core Version:    0.7.0.1
 */