package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dmi
  extends com.tencent.mm.bw.a
{
  public int HTI;
  public int HTJ;
  public String Hhh;
  public String ikm;
  public String uuA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153306);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Hhh != null) {
        paramVarArgs.d(1, this.Hhh);
      }
      paramVarArgs.aS(2, this.HTI);
      paramVarArgs.aS(3, this.HTJ);
      if (this.uuA != null) {
        paramVarArgs.d(4, this.uuA);
      }
      if (this.ikm != null) {
        paramVarArgs.d(5, this.ikm);
      }
      AppMethodBeat.o(153306);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Hhh == null) {
        break label422;
      }
    }
    label422:
    for (paramInt = f.a.a.b.b.a.e(1, this.Hhh) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.HTI) + f.a.a.b.b.a.bz(3, this.HTJ);
      paramInt = i;
      if (this.uuA != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.uuA);
      }
      i = paramInt;
      if (this.ikm != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.ikm);
      }
      AppMethodBeat.o(153306);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(153306);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dmi localdmi = (dmi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153306);
          return -1;
        case 1: 
          localdmi.Hhh = locala.OmT.readString();
          AppMethodBeat.o(153306);
          return 0;
        case 2: 
          localdmi.HTI = locala.OmT.zc();
          AppMethodBeat.o(153306);
          return 0;
        case 3: 
          localdmi.HTJ = locala.OmT.zc();
          AppMethodBeat.o(153306);
          return 0;
        case 4: 
          localdmi.uuA = locala.OmT.readString();
          AppMethodBeat.o(153306);
          return 0;
        }
        localdmi.ikm = locala.OmT.readString();
        AppMethodBeat.o(153306);
        return 0;
      }
      AppMethodBeat.o(153306);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmi
 * JD-Core Version:    0.7.0.1
 */