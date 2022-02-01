package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class to
  extends com.tencent.mm.bx.a
{
  public long YZe;
  public long YZf;
  public int hJr;
  public String wording;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259778);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.YZe);
      if (this.wording != null) {
        paramVarArgs.g(2, this.wording);
      }
      paramVarArgs.bv(3, this.YZf);
      paramVarArgs.bS(4, this.hJr);
      AppMethodBeat.o(259778);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.q(1, this.YZe) + 0;
      paramInt = i;
      if (this.wording != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.wording);
      }
      i = i.a.a.b.b.a.q(3, this.YZf);
      int j = i.a.a.b.b.a.cJ(4, this.hJr);
      AppMethodBeat.o(259778);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259778);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      to localto = (to)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259778);
        return -1;
      case 1: 
        localto.YZe = locala.ajGk.aaw();
        AppMethodBeat.o(259778);
        return 0;
      case 2: 
        localto.wording = locala.ajGk.readString();
        AppMethodBeat.o(259778);
        return 0;
      case 3: 
        localto.YZf = locala.ajGk.aaw();
        AppMethodBeat.o(259778);
        return 0;
      }
      localto.hJr = locala.ajGk.aar();
      AppMethodBeat.o(259778);
      return 0;
    }
    AppMethodBeat.o(259778);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.to
 * JD-Core Version:    0.7.0.1
 */