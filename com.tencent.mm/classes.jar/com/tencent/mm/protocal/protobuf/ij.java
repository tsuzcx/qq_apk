package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ij
  extends com.tencent.mm.bw.a
{
  public String CRv;
  public String CRw;
  public String DfC;
  public String title;
  public int uIW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91354);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      paramVarArgs.aS(2, this.uIW);
      if (this.DfC != null) {
        paramVarArgs.d(3, this.DfC);
      }
      if (this.CRv != null) {
        paramVarArgs.d(4, this.CRv);
      }
      if (this.CRw != null) {
        paramVarArgs.d(5, this.CRw);
      }
      AppMethodBeat.o(91354);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label438;
      }
    }
    label438:
    for (paramInt = f.a.a.b.b.a.e(1, this.title) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.uIW);
      paramInt = i;
      if (this.DfC != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.DfC);
      }
      i = paramInt;
      if (this.CRv != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.CRv);
      }
      paramInt = i;
      if (this.CRw != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.CRw);
      }
      AppMethodBeat.o(91354);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91354);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ij localij = (ij)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(91354);
          return -1;
        case 1: 
          localij.title = locala.OmT.readString();
          AppMethodBeat.o(91354);
          return 0;
        case 2: 
          localij.uIW = locala.OmT.zc();
          AppMethodBeat.o(91354);
          return 0;
        case 3: 
          localij.DfC = locala.OmT.readString();
          AppMethodBeat.o(91354);
          return 0;
        case 4: 
          localij.CRv = locala.OmT.readString();
          AppMethodBeat.o(91354);
          return 0;
        }
        localij.CRw = locala.OmT.readString();
        AppMethodBeat.o(91354);
        return 0;
      }
      AppMethodBeat.o(91354);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ij
 * JD-Core Version:    0.7.0.1
 */