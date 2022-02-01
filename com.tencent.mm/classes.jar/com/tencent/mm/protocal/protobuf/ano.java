package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ano
  extends com.tencent.mm.bw.a
{
  public String EGv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(195111);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EGv != null) {
        paramVarArgs.d(1, this.EGv);
      }
      AppMethodBeat.o(195111);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EGv == null) {
        break label213;
      }
    }
    label213:
    for (paramInt = f.a.a.b.b.a.e(1, this.EGv) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(195111);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(195111);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ano localano = (ano)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(195111);
          return -1;
        }
        localano.EGv = locala.LVo.readString();
        AppMethodBeat.o(195111);
        return 0;
      }
      AppMethodBeat.o(195111);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ano
 * JD-Core Version:    0.7.0.1
 */