package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dcb
  extends com.tencent.mm.bw.a
{
  public LinkedList<String> FRc;
  public LinkedList<String> HKB;
  
  public dcb()
  {
    AppMethodBeat.i(91685);
    this.FRc = new LinkedList();
    this.HKB = new LinkedList();
    AppMethodBeat.o(91685);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91686);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 1, this.FRc);
      paramVarArgs.e(2, 1, this.HKB);
      AppMethodBeat.o(91686);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.a.c(1, 1, this.FRc);
      int i = f.a.a.a.c(2, 1, this.HKB);
      AppMethodBeat.o(91686);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FRc.clear();
      this.HKB.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(91686);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      dcb localdcb = (dcb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91686);
        return -1;
      case 1: 
        localdcb.FRc.add(locala.OmT.readString());
        AppMethodBeat.o(91686);
        return 0;
      }
      localdcb.HKB.add(locala.OmT.readString());
      AppMethodBeat.o(91686);
      return 0;
    }
    AppMethodBeat.o(91686);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dcb
 * JD-Core Version:    0.7.0.1
 */