package com.tencent.mm.plugin.report.kvdata;

public class IMBehaviorChattingOP
  extends com.tencent.mm.bv.a
{
  public int changeNotifyStatus;
  public int changeSaveAddress;
  public int changeTop;
  public int changeUnread;
  public int expose;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.changeUnread);
      paramVarArgs.gB(2, this.changeTop);
      paramVarArgs.gB(3, this.changeNotifyStatus);
      paramVarArgs.gB(4, this.changeSaveAddress);
      paramVarArgs.gB(5, this.expose);
      return 0;
    }
    if (paramInt == 1) {
      return d.a.a.a.gy(1, this.changeUnread) + 0 + d.a.a.a.gy(2, this.changeTop) + d.a.a.a.gy(3, this.changeNotifyStatus) + d.a.a.a.gy(4, this.changeSaveAddress) + d.a.a.a.gy(5, this.expose);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      return 0;
    }
    if (paramInt == 3)
    {
      d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
      IMBehaviorChattingOP localIMBehaviorChattingOP = (IMBehaviorChattingOP)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localIMBehaviorChattingOP.changeUnread = locala.xpH.oD();
        return 0;
      case 2: 
        localIMBehaviorChattingOP.changeTop = locala.xpH.oD();
        return 0;
      case 3: 
        localIMBehaviorChattingOP.changeNotifyStatus = locala.xpH.oD();
        return 0;
      case 4: 
        localIMBehaviorChattingOP.changeSaveAddress = locala.xpH.oD();
        return 0;
      }
      localIMBehaviorChattingOP.expose = locala.xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.report.kvdata.IMBehaviorChattingOP
 * JD-Core Version:    0.7.0.1
 */