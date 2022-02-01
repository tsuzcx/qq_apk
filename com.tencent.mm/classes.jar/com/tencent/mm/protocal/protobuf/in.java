package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class in
  extends com.tencent.mm.bw.a
{
  public String FTN;
  public String dlT;
  public String uVs;
  public String wSp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91356);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FTN != null) {
        paramVarArgs.d(1, this.FTN);
      }
      if (this.dlT != null) {
        paramVarArgs.d(2, this.dlT);
      }
      if (this.uVs != null) {
        paramVarArgs.d(3, this.uVs);
      }
      if (this.wSp != null) {
        paramVarArgs.d(4, this.wSp);
      }
      AppMethodBeat.o(91356);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FTN == null) {
        break label394;
      }
    }
    label394:
    for (int i = f.a.a.b.b.a.e(1, this.FTN) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dlT != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.dlT);
      }
      i = paramInt;
      if (this.uVs != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.uVs);
      }
      paramInt = i;
      if (this.wSp != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.wSp);
      }
      AppMethodBeat.o(91356);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91356);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        in localin = (in)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91356);
          return -1;
        case 1: 
          localin.FTN = locala.OmT.readString();
          AppMethodBeat.o(91356);
          return 0;
        case 2: 
          localin.dlT = locala.OmT.readString();
          AppMethodBeat.o(91356);
          return 0;
        case 3: 
          localin.uVs = locala.OmT.readString();
          AppMethodBeat.o(91356);
          return 0;
        }
        localin.wSp = locala.OmT.readString();
        AppMethodBeat.o(91356);
        return 0;
      }
      AppMethodBeat.o(91356);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.in
 * JD-Core Version:    0.7.0.1
 */