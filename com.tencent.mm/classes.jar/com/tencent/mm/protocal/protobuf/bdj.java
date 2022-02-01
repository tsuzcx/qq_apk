package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class bdj
  extends com.tencent.mm.bx.a
{
  public String ZNU;
  public long id;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259025);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.id);
      if (this.ZNU != null) {
        paramVarArgs.g(2, this.ZNU);
      }
      AppMethodBeat.o(259025);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.q(1, this.id) + 0;
      paramInt = i;
      if (this.ZNU != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.ZNU);
      }
      AppMethodBeat.o(259025);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259025);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      bdj localbdj = (bdj)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259025);
        return -1;
      case 1: 
        localbdj.id = locala.ajGk.aaw();
        AppMethodBeat.o(259025);
        return 0;
      }
      localbdj.ZNU = locala.ajGk.readString();
      AppMethodBeat.o(259025);
      return 0;
    }
    AppMethodBeat.o(259025);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bdj
 * JD-Core Version:    0.7.0.1
 */