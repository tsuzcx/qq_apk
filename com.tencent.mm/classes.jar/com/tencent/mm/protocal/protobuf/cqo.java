package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cqo
  extends com.tencent.mm.bx.a
{
  public LinkedList<String> CAN;
  public LinkedList<String> Ejz;
  
  public cqo()
  {
    AppMethodBeat.i(91685);
    this.CAN = new LinkedList();
    this.Ejz = new LinkedList();
    AppMethodBeat.o(91685);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91686);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 1, this.CAN);
      paramVarArgs.e(2, 1, this.Ejz);
      AppMethodBeat.o(91686);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.a.c(1, 1, this.CAN);
      int i = f.a.a.a.c(2, 1, this.Ejz);
      AppMethodBeat.o(91686);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.CAN.clear();
      this.Ejz.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(91686);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      cqo localcqo = (cqo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(91686);
        return -1;
      case 1: 
        localcqo.CAN.add(locala.KhF.readString());
        AppMethodBeat.o(91686);
        return 0;
      }
      localcqo.Ejz.add(locala.KhF.readString());
      AppMethodBeat.o(91686);
      return 0;
    }
    AppMethodBeat.o(91686);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqo
 * JD-Core Version:    0.7.0.1
 */