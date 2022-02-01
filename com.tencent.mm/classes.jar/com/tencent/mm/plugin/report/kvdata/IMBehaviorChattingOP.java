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
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.changeUnread);
      paramVarArgs.bS(2, this.changeTop);
      paramVarArgs.bS(3, this.changeNotifyStatus);
      paramVarArgs.bS(4, this.changeSaveAddress);
      paramVarArgs.bS(5, this.expose);
      AppMethodBeat.o(151536);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.changeUnread);
      int i = i.a.a.b.b.a.cJ(2, this.changeTop);
      int j = i.a.a.b.b.a.cJ(3, this.changeNotifyStatus);
      int k = i.a.a.b.b.a.cJ(4, this.changeSaveAddress);
      int m = i.a.a.b.b.a.cJ(5, this.expose);
      AppMethodBeat.o(151536);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(151536);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      IMBehaviorChattingOP localIMBehaviorChattingOP = (IMBehaviorChattingOP)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(151536);
        return -1;
      case 1: 
        localIMBehaviorChattingOP.changeUnread = locala.ajGk.aar();
        AppMethodBeat.o(151536);
        return 0;
      case 2: 
        localIMBehaviorChattingOP.changeTop = locala.ajGk.aar();
        AppMethodBeat.o(151536);
        return 0;
      case 3: 
        localIMBehaviorChattingOP.changeNotifyStatus = locala.ajGk.aar();
        AppMethodBeat.o(151536);
        return 0;
      case 4: 
        localIMBehaviorChattingOP.changeSaveAddress = locala.ajGk.aar();
        AppMethodBeat.o(151536);
        return 0;
      }
      localIMBehaviorChattingOP.expose = locala.ajGk.aar();
      AppMethodBeat.o(151536);
      return 0;
    }
    AppMethodBeat.o(151536);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.report.kvdata.IMBehaviorChattingOP
 * JD-Core Version:    0.7.0.1
 */