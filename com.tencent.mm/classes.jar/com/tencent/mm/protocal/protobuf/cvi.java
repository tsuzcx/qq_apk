package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cvi
  extends com.tencent.mm.bv.a
{
  public String title;
  public String xWf;
  public String ydM;
  public String ydN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56994);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.e(1, this.title);
      }
      if (this.ydM != null) {
        paramVarArgs.e(2, this.ydM);
      }
      if (this.xWf != null) {
        paramVarArgs.e(3, this.xWf);
      }
      if (this.ydN != null) {
        paramVarArgs.e(4, this.ydN);
      }
      AppMethodBeat.o(56994);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label394;
      }
    }
    label394:
    for (int i = e.a.a.b.b.a.f(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ydM != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.ydM);
      }
      i = paramInt;
      if (this.xWf != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.xWf);
      }
      paramInt = i;
      if (this.ydN != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.ydN);
      }
      AppMethodBeat.o(56994);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56994);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cvi localcvi = (cvi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(56994);
          return -1;
        case 1: 
          localcvi.title = locala.CLY.readString();
          AppMethodBeat.o(56994);
          return 0;
        case 2: 
          localcvi.ydM = locala.CLY.readString();
          AppMethodBeat.o(56994);
          return 0;
        case 3: 
          localcvi.xWf = locala.CLY.readString();
          AppMethodBeat.o(56994);
          return 0;
        }
        localcvi.ydN = locala.CLY.readString();
        AppMethodBeat.o(56994);
        return 0;
      }
      AppMethodBeat.o(56994);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvi
 * JD-Core Version:    0.7.0.1
 */