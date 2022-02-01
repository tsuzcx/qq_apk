package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class IMBehaviorChattingOP
  extends com.tencent.mm.bx.a
{
  public int changeNotifyStatus;
  public int changeSaveAddress;
  public int changeTop;
  public int changeUnread;
  public int expose;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(151536);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.changeUnread);
      paramVarArgs.aR(2, this.changeTop);
      paramVarArgs.aR(3, this.changeNotifyStatus);
      paramVarArgs.aR(4, this.changeSaveAddress);
      paramVarArgs.aR(5, this.expose);
      AppMethodBeat.o(151536);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bA(1, this.changeUnread);
      int i = f.a.a.b.b.a.bA(2, this.changeTop);
      int j = f.a.a.b.b.a.bA(3, this.changeNotifyStatus);
      int k = f.a.a.b.b.a.bA(4, this.changeSaveAddress);
      int m = f.a.a.b.b.a.bA(5, this.expose);
      AppMethodBeat.o(151536);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(151536);
      return 0;
    }
    if (paramInt == 3)
    {
      f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
      IMBehaviorChattingOP localIMBehaviorChattingOP = (IMBehaviorChattingOP)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(151536);
        return -1;
      case 1: 
        localIMBehaviorChattingOP.changeUnread = locala.KhF.xS();
        AppMethodBeat.o(151536);
        return 0;
      case 2: 
        localIMBehaviorChattingOP.changeTop = locala.KhF.xS();
        AppMethodBeat.o(151536);
        return 0;
      case 3: 
        localIMBehaviorChattingOP.changeNotifyStatus = locala.KhF.xS();
        AppMethodBeat.o(151536);
        return 0;
      case 4: 
        localIMBehaviorChattingOP.changeSaveAddress = locala.KhF.xS();
        AppMethodBeat.o(151536);
        return 0;
      }
      localIMBehaviorChattingOP.expose = locala.KhF.xS();
      AppMethodBeat.o(151536);
      return 0;
    }
    AppMethodBeat.o(151536);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.report.kvdata.IMBehaviorChattingOP
 * JD-Core Version:    0.7.0.1
 */