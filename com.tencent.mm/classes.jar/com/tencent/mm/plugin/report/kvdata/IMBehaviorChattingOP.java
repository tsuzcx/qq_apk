package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class IMBehaviorChattingOP
  extends com.tencent.mm.bv.a
{
  public int changeNotifyStatus;
  public int changeSaveAddress;
  public int changeTop;
  public int changeUnread;
  public int expose;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(79150);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.changeUnread);
      paramVarArgs.aO(2, this.changeTop);
      paramVarArgs.aO(3, this.changeNotifyStatus);
      paramVarArgs.aO(4, this.changeSaveAddress);
      paramVarArgs.aO(5, this.expose);
      AppMethodBeat.o(79150);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.bl(1, this.changeUnread);
      int i = e.a.a.b.b.a.bl(2, this.changeTop);
      int j = e.a.a.b.b.a.bl(3, this.changeNotifyStatus);
      int k = e.a.a.b.b.a.bl(4, this.changeSaveAddress);
      int m = e.a.a.b.b.a.bl(5, this.expose);
      AppMethodBeat.o(79150);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(79150);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      IMBehaviorChattingOP localIMBehaviorChattingOP = (IMBehaviorChattingOP)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(79150);
        return -1;
      case 1: 
        localIMBehaviorChattingOP.changeUnread = locala.CLY.sl();
        AppMethodBeat.o(79150);
        return 0;
      case 2: 
        localIMBehaviorChattingOP.changeTop = locala.CLY.sl();
        AppMethodBeat.o(79150);
        return 0;
      case 3: 
        localIMBehaviorChattingOP.changeNotifyStatus = locala.CLY.sl();
        AppMethodBeat.o(79150);
        return 0;
      case 4: 
        localIMBehaviorChattingOP.changeSaveAddress = locala.CLY.sl();
        AppMethodBeat.o(79150);
        return 0;
      }
      localIMBehaviorChattingOP.expose = locala.CLY.sl();
      AppMethodBeat.o(79150);
      return 0;
    }
    AppMethodBeat.o(79150);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.report.kvdata.IMBehaviorChattingOP
 * JD-Core Version:    0.7.0.1
 */