package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class cpf
  extends com.tencent.mm.bv.a
{
  public String qFg;
  public int qFh;
  public String scope;
  public int state;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127737);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.scope != null) {
        paramVarArgs.e(1, this.scope);
      }
      if (this.qFg != null) {
        paramVarArgs.e(2, this.qFg);
      }
      paramVarArgs.aO(3, this.state);
      paramVarArgs.aO(4, this.qFh);
      AppMethodBeat.o(127737);
      return 0;
    }
    if (paramInt == 1) {
      if (this.scope == null) {
        break label366;
      }
    }
    label366:
    for (paramInt = e.a.a.b.b.a.f(1, this.scope) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.qFg != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.qFg);
      }
      paramInt = e.a.a.b.b.a.bl(3, this.state);
      int j = e.a.a.b.b.a.bl(4, this.qFh);
      AppMethodBeat.o(127737);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(127737);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        cpf localcpf = (cpf)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(127737);
          return -1;
        case 1: 
          localcpf.scope = locala.CLY.readString();
          AppMethodBeat.o(127737);
          return 0;
        case 2: 
          localcpf.qFg = locala.CLY.readString();
          AppMethodBeat.o(127737);
          return 0;
        case 3: 
          localcpf.state = locala.CLY.sl();
          AppMethodBeat.o(127737);
          return 0;
        }
        localcpf.qFh = locala.CLY.sl();
        AppMethodBeat.o(127737);
        return 0;
      }
      AppMethodBeat.o(127737);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpf
 * JD-Core Version:    0.7.0.1
 */