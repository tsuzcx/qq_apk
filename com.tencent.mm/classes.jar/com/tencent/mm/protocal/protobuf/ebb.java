package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ebb
  extends com.tencent.mm.bx.a
{
  public String HEy;
  public String HNJ;
  public String HNK;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91726);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      if (this.HNJ != null) {
        paramVarArgs.d(2, this.HNJ);
      }
      if (this.HEy != null) {
        paramVarArgs.d(3, this.HEy);
      }
      if (this.HNK != null) {
        paramVarArgs.d(4, this.HNK);
      }
      AppMethodBeat.o(91726);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label394;
      }
    }
    label394:
    for (int i = f.a.a.b.b.a.e(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.HNJ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.HNJ);
      }
      i = paramInt;
      if (this.HEy != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.HEy);
      }
      paramInt = i;
      if (this.HNK != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HNK);
      }
      AppMethodBeat.o(91726);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91726);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ebb localebb = (ebb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91726);
          return -1;
        case 1: 
          localebb.title = locala.NPN.readString();
          AppMethodBeat.o(91726);
          return 0;
        case 2: 
          localebb.HNJ = locala.NPN.readString();
          AppMethodBeat.o(91726);
          return 0;
        case 3: 
          localebb.HEy = locala.NPN.readString();
          AppMethodBeat.o(91726);
          return 0;
        }
        localebb.HNK = locala.NPN.readString();
        AppMethodBeat.o(91726);
        return 0;
      }
      AppMethodBeat.o(91726);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebb
 * JD-Core Version:    0.7.0.1
 */