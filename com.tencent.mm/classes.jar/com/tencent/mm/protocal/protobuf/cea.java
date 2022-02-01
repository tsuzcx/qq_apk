package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cea
  extends com.tencent.mm.bw.a
{
  public int HqT;
  public String desc;
  public String mqC;
  public String scope;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82463);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.scope != null) {
        paramVarArgs.d(1, this.scope);
      }
      if (this.desc != null) {
        paramVarArgs.d(2, this.desc);
      }
      paramVarArgs.aS(3, this.HqT);
      if (this.mqC != null) {
        paramVarArgs.d(4, this.mqC);
      }
      AppMethodBeat.o(82463);
      return 0;
    }
    if (paramInt == 1) {
      if (this.scope == null) {
        break label378;
      }
    }
    label378:
    for (paramInt = f.a.a.b.b.a.e(1, this.scope) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.desc != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.desc);
      }
      i += f.a.a.b.b.a.bz(3, this.HqT);
      paramInt = i;
      if (this.mqC != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.mqC);
      }
      AppMethodBeat.o(82463);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(82463);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cea localcea = (cea)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(82463);
          return -1;
        case 1: 
          localcea.scope = locala.OmT.readString();
          AppMethodBeat.o(82463);
          return 0;
        case 2: 
          localcea.desc = locala.OmT.readString();
          AppMethodBeat.o(82463);
          return 0;
        case 3: 
          localcea.HqT = locala.OmT.zc();
          AppMethodBeat.o(82463);
          return 0;
        }
        localcea.mqC = locala.OmT.readString();
        AppMethodBeat.o(82463);
        return 0;
      }
      AppMethodBeat.o(82463);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cea
 * JD-Core Version:    0.7.0.1
 */