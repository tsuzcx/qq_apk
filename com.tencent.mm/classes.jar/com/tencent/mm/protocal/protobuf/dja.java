package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dja
  extends com.tencent.mm.bw.a
{
  public String umv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125842);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.umv != null) {
        paramVarArgs.d(1, this.umv);
      }
      AppMethodBeat.o(125842);
      return 0;
    }
    if (paramInt == 1) {
      if (this.umv == null) {
        break label213;
      }
    }
    label213:
    for (paramInt = f.a.a.b.b.a.e(1, this.umv) + 0;; paramInt = 0)
    {
      AppMethodBeat.o(125842);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(125842);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        dja localdja = (dja)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(125842);
          return -1;
        }
        localdja.umv = locala.OmT.readString();
        AppMethodBeat.o(125842);
        return 0;
      }
      AppMethodBeat.o(125842);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dja
 * JD-Core Version:    0.7.0.1
 */