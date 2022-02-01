package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class fqo
  extends com.tencent.mm.bx.a
{
  public String abQw;
  public String abQx;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125849);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abQw != null) {
        paramVarArgs.g(1, this.abQw);
      }
      if (this.abQx != null) {
        paramVarArgs.g(2, this.abQx);
      }
      AppMethodBeat.o(125849);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abQw == null) {
        break label270;
      }
    }
    label270:
    for (paramInt = i.a.a.b.b.a.h(1, this.abQw) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.abQx != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.abQx);
      }
      AppMethodBeat.o(125849);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(125849);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        fqo localfqo = (fqo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(125849);
          return -1;
        case 1: 
          localfqo.abQw = locala.ajGk.readString();
          AppMethodBeat.o(125849);
          return 0;
        }
        localfqo.abQx = locala.ajGk.readString();
        AppMethodBeat.o(125849);
        return 0;
      }
      AppMethodBeat.o(125849);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fqo
 * JD-Core Version:    0.7.0.1
 */