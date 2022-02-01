package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class dom
  extends com.tencent.mm.bx.a
{
  public long CJK;
  public long aaVw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258137);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.CJK);
      paramVarArgs.bv(2, this.aaVw);
      AppMethodBeat.o(258137);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.q(1, this.CJK);
      int i = i.a.a.b.b.a.q(2, this.aaVw);
      AppMethodBeat.o(258137);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258137);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      dom localdom = (dom)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(258137);
        return -1;
      case 1: 
        localdom.CJK = locala.ajGk.aaw();
        AppMethodBeat.o(258137);
        return 0;
      }
      localdom.aaVw = locala.ajGk.aaw();
      AppMethodBeat.o(258137);
      return 0;
    }
    AppMethodBeat.o(258137);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dom
 * JD-Core Version:    0.7.0.1
 */