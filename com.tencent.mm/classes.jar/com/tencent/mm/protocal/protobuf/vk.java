package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class vk
  extends com.tencent.mm.cd.a
{
  public String path;
  public long rKZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(191428);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.path != null) {
        paramVarArgs.f(1, this.path);
      }
      paramVarArgs.bm(2, this.rKZ);
      AppMethodBeat.o(191428);
      return 0;
    }
    if (paramInt == 1) {
      if (this.path == null) {
        break label258;
      }
    }
    label258:
    for (paramInt = g.a.a.b.b.a.g(1, this.path) + 0;; paramInt = 0)
    {
      int i = g.a.a.b.b.a.p(2, this.rKZ);
      AppMethodBeat.o(191428);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(191428);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        vk localvk = (vk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(191428);
          return -1;
        case 1: 
          localvk.path = locala.abFh.readString();
          AppMethodBeat.o(191428);
          return 0;
        }
        localvk.rKZ = locala.abFh.AN();
        AppMethodBeat.o(191428);
        return 0;
      }
      AppMethodBeat.o(191428);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vk
 * JD-Core Version:    0.7.0.1
 */