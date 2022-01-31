package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class awa
  extends com.tencent.mm.bv.a
{
  public String desc;
  public String title;
  public String xln;
  public String xlo;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(10196);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.e(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.e(2, this.desc);
      }
      if (this.xln != null) {
        paramVarArgs.e(3, this.xln);
      }
      if (this.xlo != null) {
        paramVarArgs.e(4, this.xlo);
      }
      AppMethodBeat.o(10196);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label404;
      }
    }
    label404:
    for (int i = e.a.a.b.b.a.f(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.desc);
      }
      i = paramInt;
      if (this.xln != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.xln);
      }
      paramInt = i;
      if (this.xlo != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.xlo);
      }
      AppMethodBeat.o(10196);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(10196);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        awa localawa = (awa)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(10196);
          return -1;
        case 1: 
          localawa.title = locala.CLY.readString();
          AppMethodBeat.o(10196);
          return 0;
        case 2: 
          localawa.desc = locala.CLY.readString();
          AppMethodBeat.o(10196);
          return 0;
        case 3: 
          localawa.xln = locala.CLY.readString();
          AppMethodBeat.o(10196);
          return 0;
        }
        localawa.xlo = locala.CLY.readString();
        AppMethodBeat.o(10196);
        return 0;
      }
      AppMethodBeat.o(10196);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.awa
 * JD-Core Version:    0.7.0.1
 */