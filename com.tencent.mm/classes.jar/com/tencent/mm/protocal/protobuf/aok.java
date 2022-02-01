package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class aok
  extends com.tencent.mm.bx.a
{
  public String Dqk;
  public long Dql;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152555);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Dqk != null) {
        paramVarArgs.d(1, this.Dqk);
      }
      paramVarArgs.aG(2, this.Dql);
      AppMethodBeat.o(152555);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Dqk == null) {
        break label258;
      }
    }
    label258:
    for (paramInt = f.a.a.b.b.a.e(1, this.Dqk) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.q(2, this.Dql);
      AppMethodBeat.o(152555);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(152555);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        aok localaok = (aok)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152555);
          return -1;
        case 1: 
          localaok.Dqk = locala.KhF.readString();
          AppMethodBeat.o(152555);
          return 0;
        }
        localaok.Dql = locala.KhF.xT();
        AppMethodBeat.o(152555);
        return 0;
      }
      AppMethodBeat.o(152555);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aok
 * JD-Core Version:    0.7.0.1
 */