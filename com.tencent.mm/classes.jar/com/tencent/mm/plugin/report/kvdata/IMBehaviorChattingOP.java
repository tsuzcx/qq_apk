package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class IMBehaviorChattingOP
  extends com.tencent.mm.cd.a
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
      paramVarArgs.aY(1, this.changeUnread);
      paramVarArgs.aY(2, this.changeTop);
      paramVarArgs.aY(3, this.changeNotifyStatus);
      paramVarArgs.aY(4, this.changeSaveAddress);
      paramVarArgs.aY(5, this.expose);
      AppMethodBeat.o(151536);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = g.a.a.b.b.a.bM(1, this.changeUnread);
      int i = g.a.a.b.b.a.bM(2, this.changeTop);
      int j = g.a.a.b.b.a.bM(3, this.changeNotifyStatus);
      int k = g.a.a.b.b.a.bM(4, this.changeSaveAddress);
      int m = g.a.a.b.b.a.bM(5, this.expose);
      AppMethodBeat.o(151536);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
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
        localIMBehaviorChattingOP.changeUnread = locala.abFh.AK();
        AppMethodBeat.o(151536);
        return 0;
      case 2: 
        localIMBehaviorChattingOP.changeTop = locala.abFh.AK();
        AppMethodBeat.o(151536);
        return 0;
      case 3: 
        localIMBehaviorChattingOP.changeNotifyStatus = locala.abFh.AK();
        AppMethodBeat.o(151536);
        return 0;
      case 4: 
        localIMBehaviorChattingOP.changeSaveAddress = locala.abFh.AK();
        AppMethodBeat.o(151536);
        return 0;
      }
      localIMBehaviorChattingOP.expose = locala.abFh.AK();
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