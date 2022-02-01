package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class apf
  extends com.tencent.mm.bw.a
{
  public String EIi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152994);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EIi != null) {
        paramVarArgs.d(1, this.EIi);
      }
      AppMethodBeat.o(152994);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EIi == null) {
        break label213;
      }
    }
    label213:
    for (paramInt = f.a.a.b.b.a.e(1, this.EIi) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(152994);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(152994);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        apf localapf = (apf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152994);
          return -1;
        }
        localapf.EIi = locala.LVo.readString();
        AppMethodBeat.o(152994);
        return 0;
      }
      AppMethodBeat.o(152994);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.apf
 * JD-Core Version:    0.7.0.1
 */