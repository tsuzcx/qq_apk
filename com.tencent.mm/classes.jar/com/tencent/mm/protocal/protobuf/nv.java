package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class nv
  extends com.tencent.mm.bv.a
{
  public String wDt;
  public int wDu;
  public String wDv;
  public String wDw;
  public String wum;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(2537);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wDt != null) {
        paramVarArgs.e(1, this.wDt);
      }
      paramVarArgs.aO(2, this.wDu);
      if (this.wDv != null) {
        paramVarArgs.e(3, this.wDv);
      }
      if (this.wum != null) {
        paramVarArgs.e(4, this.wum);
      }
      if (this.wDw != null) {
        paramVarArgs.e(5, this.wDw);
      }
      AppMethodBeat.o(2537);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wDt == null) {
        break label449;
      }
    }
    label449:
    for (paramInt = e.a.a.b.b.a.f(1, this.wDt) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.wDu);
      paramInt = i;
      if (this.wDv != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.wDv);
      }
      i = paramInt;
      if (this.wum != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.wum);
      }
      paramInt = i;
      if (this.wDw != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.wDw);
      }
      AppMethodBeat.o(2537);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(2537);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        nv localnv = (nv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(2537);
          return -1;
        case 1: 
          localnv.wDt = locala.CLY.readString();
          AppMethodBeat.o(2537);
          return 0;
        case 2: 
          localnv.wDu = locala.CLY.sl();
          AppMethodBeat.o(2537);
          return 0;
        case 3: 
          localnv.wDv = locala.CLY.readString();
          AppMethodBeat.o(2537);
          return 0;
        case 4: 
          localnv.wum = locala.CLY.readString();
          AppMethodBeat.o(2537);
          return 0;
        }
        localnv.wDw = locala.CLY.readString();
        AppMethodBeat.o(2537);
        return 0;
      }
      AppMethodBeat.o(2537);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.nv
 * JD-Core Version:    0.7.0.1
 */