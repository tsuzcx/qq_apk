package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class IMBehaviorChattingOP
  extends com.tencent.mm.bw.a
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
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.changeUnread);
      paramVarArgs.aM(2, this.changeTop);
      paramVarArgs.aM(3, this.changeNotifyStatus);
      paramVarArgs.aM(4, this.changeSaveAddress);
      paramVarArgs.aM(5, this.expose);
      AppMethodBeat.o(151536);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bu(1, this.changeUnread);
      int i = g.a.a.b.b.a.bu(2, this.changeTop);
      int j = g.a.a.b.b.a.bu(3, this.changeNotifyStatus);
      int k = g.a.a.b.b.a.bu(4, this.changeSaveAddress);
      int m = g.a.a.b.b.a.bu(5, this.expose);
      AppMethodBeat.o(151536);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(151536);
      return 0;
    }
    if (paramInt == 3)
    {
      g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
      IMBehaviorChattingOP localIMBehaviorChattingOP = (IMBehaviorChattingOP)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(151536);
        return -1;
      case 1: 
        localIMBehaviorChattingOP.changeUnread = locala.UbS.zi();
        AppMethodBeat.o(151536);
        return 0;
      case 2: 
        localIMBehaviorChattingOP.changeTop = locala.UbS.zi();
        AppMethodBeat.o(151536);
        return 0;
      case 3: 
        localIMBehaviorChattingOP.changeNotifyStatus = locala.UbS.zi();
        AppMethodBeat.o(151536);
        return 0;
      case 4: 
        localIMBehaviorChattingOP.changeSaveAddress = locala.UbS.zi();
        AppMethodBeat.o(151536);
        return 0;
      }
      localIMBehaviorChattingOP.expose = locala.UbS.zi();
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