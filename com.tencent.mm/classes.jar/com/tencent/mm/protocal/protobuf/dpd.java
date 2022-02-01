package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dpd
  extends com.tencent.mm.bw.a
{
  public LinkedList<Long> HWE;
  
  public dpd()
  {
    AppMethodBeat.i(189432);
    this.HWE = new LinkedList();
    AppMethodBeat.o(189432);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(189433);
    if (paramInt == 0)
    {
      ((f.a.a.c.a)paramVarArgs[0]).e(1, 3, this.HWE);
      AppMethodBeat.o(189433);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.a.c(1, 3, this.HWE);
      AppMethodBeat.o(189433);
      return paramInt + 0;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.HWE.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(189433);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dpd localdpd = (dpd)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(189433);
        return -1;
      }
      localdpd.HWE.add(Long.valueOf(locala.OmT.zd()));
      AppMethodBeat.o(189433);
      return 0;
    }
    AppMethodBeat.o(189433);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpd
 * JD-Core Version:    0.7.0.1
 */