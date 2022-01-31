package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class yp
  extends com.tencent.mm.bv.a
{
  public String desc;
  public String title;
  public String wPJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56770);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.e(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.e(2, this.desc);
      }
      if (this.wPJ != null) {
        paramVarArgs.e(3, this.wPJ);
      }
      AppMethodBeat.o(56770);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label334;
      }
    }
    label334:
    for (int i = e.a.a.b.b.a.f(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.desc);
      }
      i = paramInt;
      if (this.wPJ != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wPJ);
      }
      AppMethodBeat.o(56770);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56770);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        yp localyp = (yp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(56770);
          return -1;
        case 1: 
          localyp.title = locala.CLY.readString();
          AppMethodBeat.o(56770);
          return 0;
        case 2: 
          localyp.desc = locala.CLY.readString();
          AppMethodBeat.o(56770);
          return 0;
        }
        localyp.wPJ = locala.CLY.readString();
        AppMethodBeat.o(56770);
        return 0;
      }
      AppMethodBeat.o(56770);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yp
 * JD-Core Version:    0.7.0.1
 */