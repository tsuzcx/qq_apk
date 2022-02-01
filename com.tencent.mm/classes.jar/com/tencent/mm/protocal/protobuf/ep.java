package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class ep
  extends com.tencent.mm.bw.a
{
  public String FOO;
  public String FOP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125711);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FOO != null) {
        paramVarArgs.d(1, this.FOO);
      }
      if (this.FOP != null) {
        paramVarArgs.d(2, this.FOP);
      }
      AppMethodBeat.o(125711);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FOO == null) {
        break label274;
      }
    }
    label274:
    for (paramInt = f.a.a.b.b.a.e(1, this.FOO) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FOP != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.FOP);
      }
      AppMethodBeat.o(125711);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(125711);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        ep localep = (ep)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(125711);
          return -1;
        case 1: 
          localep.FOO = locala.OmT.readString();
          AppMethodBeat.o(125711);
          return 0;
        }
        localep.FOP = locala.OmT.readString();
        AppMethodBeat.o(125711);
        return 0;
      }
      AppMethodBeat.o(125711);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ep
 * JD-Core Version:    0.7.0.1
 */