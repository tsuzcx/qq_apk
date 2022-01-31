package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aao
  extends com.tencent.mm.bv.a
{
  public int wRd;
  public int wRe;
  public int wRf;
  public String wRg;
  public int wRh;
  public String wRi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(73648);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.wRd);
      paramVarArgs.aO(2, this.wRe);
      paramVarArgs.aO(3, this.wRf);
      if (this.wRg != null) {
        paramVarArgs.e(4, this.wRg);
      }
      paramVarArgs.aO(5, this.wRh);
      if (this.wRi != null) {
        paramVarArgs.e(6, this.wRi);
      }
      AppMethodBeat.o(73648);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.wRd) + 0 + e.a.a.b.b.a.bl(2, this.wRe) + e.a.a.b.b.a.bl(3, this.wRf);
      paramInt = i;
      if (this.wRg != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wRg);
      }
      i = paramInt + e.a.a.b.b.a.bl(5, this.wRh);
      paramInt = i;
      if (this.wRi != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.wRi);
      }
      AppMethodBeat.o(73648);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(73648);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      aao localaao = (aao)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(73648);
        return -1;
      case 1: 
        localaao.wRd = locala.CLY.sl();
        AppMethodBeat.o(73648);
        return 0;
      case 2: 
        localaao.wRe = locala.CLY.sl();
        AppMethodBeat.o(73648);
        return 0;
      case 3: 
        localaao.wRf = locala.CLY.sl();
        AppMethodBeat.o(73648);
        return 0;
      case 4: 
        localaao.wRg = locala.CLY.readString();
        AppMethodBeat.o(73648);
        return 0;
      case 5: 
        localaao.wRh = locala.CLY.sl();
        AppMethodBeat.o(73648);
        return 0;
      }
      localaao.wRi = locala.CLY.readString();
      AppMethodBeat.o(73648);
      return 0;
    }
    AppMethodBeat.o(73648);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aao
 * JD-Core Version:    0.7.0.1
 */