package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bbf
  extends com.tencent.mm.bv.a
{
  public String type;
  public int wJh;
  public String xbD;
  public String xqE;
  public String xqF;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(70486);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xqE != null) {
        paramVarArgs.e(1, this.xqE);
      }
      if (this.xbD != null) {
        paramVarArgs.e(2, this.xbD);
      }
      if (this.type != null) {
        paramVarArgs.e(3, this.type);
      }
      paramVarArgs.aO(4, this.wJh);
      if (this.xqF != null) {
        paramVarArgs.e(5, this.xqF);
      }
      AppMethodBeat.o(70486);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xqE == null) {
        break label438;
      }
    }
    label438:
    for (int i = e.a.a.b.b.a.f(1, this.xqE) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xbD != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.xbD);
      }
      i = paramInt;
      if (this.type != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.type);
      }
      i += e.a.a.b.b.a.bl(4, this.wJh);
      paramInt = i;
      if (this.xqF != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.xqF);
      }
      AppMethodBeat.o(70486);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(70486);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        bbf localbbf = (bbf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(70486);
          return -1;
        case 1: 
          localbbf.xqE = locala.CLY.readString();
          AppMethodBeat.o(70486);
          return 0;
        case 2: 
          localbbf.xbD = locala.CLY.readString();
          AppMethodBeat.o(70486);
          return 0;
        case 3: 
          localbbf.type = locala.CLY.readString();
          AppMethodBeat.o(70486);
          return 0;
        case 4: 
          localbbf.wJh = locala.CLY.sl();
          AppMethodBeat.o(70486);
          return 0;
        }
        localbbf.xqF = locala.CLY.readString();
        AppMethodBeat.o(70486);
        return 0;
      }
      AppMethodBeat.o(70486);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbf
 * JD-Core Version:    0.7.0.1
 */