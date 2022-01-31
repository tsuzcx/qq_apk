package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class nl
  extends com.tencent.mm.bv.a
{
  public String cDz;
  public String title;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28348);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.url != null) {
        paramVarArgs.e(1, this.url);
      }
      if (this.title != null) {
        paramVarArgs.e(2, this.title);
      }
      if (this.cDz != null) {
        paramVarArgs.e(3, this.cDz);
      }
      AppMethodBeat.o(28348);
      return 0;
    }
    if (paramInt == 1) {
      if (this.url == null) {
        break label343;
      }
    }
    label343:
    for (int i = e.a.a.b.b.a.f(1, this.url) + 0;; i = 0)
    {
      paramInt = i;
      if (this.title != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.title);
      }
      i = paramInt;
      if (this.cDz != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.cDz);
      }
      AppMethodBeat.o(28348);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(28348);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        nl localnl = (nl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(28348);
          return -1;
        case 1: 
          localnl.url = locala.CLY.readString();
          AppMethodBeat.o(28348);
          return 0;
        case 2: 
          localnl.title = locala.CLY.readString();
          AppMethodBeat.o(28348);
          return 0;
        }
        localnl.cDz = locala.CLY.readString();
        AppMethodBeat.o(28348);
        return 0;
      }
      AppMethodBeat.o(28348);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nl
 * JD-Core Version:    0.7.0.1
 */