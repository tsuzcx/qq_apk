package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class gjb
  extends com.tencent.mm.bx.a
{
  public int YQB;
  public String acfq;
  public String acfr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123682);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.YQB);
      if (this.acfq != null) {
        paramVarArgs.g(2, this.acfq);
      }
      if (this.acfr != null) {
        paramVarArgs.g(3, this.acfr);
      }
      AppMethodBeat.o(123682);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.YQB) + 0;
      paramInt = i;
      if (this.acfq != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.acfq);
      }
      i = paramInt;
      if (this.acfr != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.acfr);
      }
      AppMethodBeat.o(123682);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(123682);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      gjb localgjb = (gjb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(123682);
        return -1;
      case 1: 
        localgjb.YQB = locala.ajGk.aar();
        AppMethodBeat.o(123682);
        return 0;
      case 2: 
        localgjb.acfq = locala.ajGk.readString();
        AppMethodBeat.o(123682);
        return 0;
      }
      localgjb.acfr = locala.ajGk.readString();
      AppMethodBeat.o(123682);
      return 0;
    }
    AppMethodBeat.o(123682);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gjb
 * JD-Core Version:    0.7.0.1
 */