package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dft
  extends com.tencent.mm.bx.a
{
  public long YVd;
  public LinkedList<String> aaLq;
  
  public dft()
  {
    AppMethodBeat.i(258184);
    this.YVd = 0L;
    this.aaLq = new LinkedList();
    AppMethodBeat.o(258184);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258186);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.YVd);
      paramVarArgs.e(2, 1, this.aaLq);
      AppMethodBeat.o(258186);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.q(1, this.YVd);
      int i = i.a.a.a.c(2, 1, this.aaLq);
      AppMethodBeat.o(258186);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.aaLq.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258186);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      dft localdft = (dft)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(258186);
        return -1;
      case 1: 
        localdft.YVd = locala.ajGk.aaw();
        AppMethodBeat.o(258186);
        return 0;
      }
      localdft.aaLq.add(locala.ajGk.readString());
      AppMethodBeat.o(258186);
      return 0;
    }
    AppMethodBeat.o(258186);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dft
 * JD-Core Version:    0.7.0.1
 */