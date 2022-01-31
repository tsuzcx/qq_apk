package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class acr
  extends com.tencent.mm.bv.a
{
  public String Desc;
  public String Title;
  public int woH;
  public String woI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118271);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.e(1, this.Title);
      }
      if (this.Desc != null) {
        paramVarArgs.e(2, this.Desc);
      }
      paramVarArgs.aO(3, this.woH);
      if (this.woI != null) {
        paramVarArgs.e(4, this.woI);
      }
      AppMethodBeat.o(118271);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label378;
      }
    }
    label378:
    for (paramInt = e.a.a.b.b.a.f(1, this.Title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Desc != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.Desc);
      }
      i += e.a.a.b.b.a.bl(3, this.woH);
      paramInt = i;
      if (this.woI != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.woI);
      }
      AppMethodBeat.o(118271);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(118271);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        acr localacr = (acr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(118271);
          return -1;
        case 1: 
          localacr.Title = locala.CLY.readString();
          AppMethodBeat.o(118271);
          return 0;
        case 2: 
          localacr.Desc = locala.CLY.readString();
          AppMethodBeat.o(118271);
          return 0;
        case 3: 
          localacr.woH = locala.CLY.sl();
          AppMethodBeat.o(118271);
          return 0;
        }
        localacr.woI = locala.CLY.readString();
        AppMethodBeat.o(118271);
        return 0;
      }
      AppMethodBeat.o(118271);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acr
 * JD-Core Version:    0.7.0.1
 */