package com.tencent.mm.plugin.report.kvdata;

public class IMBehaviorMsgOP
  extends com.tencent.mm.bv.a
{
  public int appMsgInnerType;
  public int count;
  public int msgOpType;
  public int msgType;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.gB(1, this.msgType);
      paramVarArgs.gB(2, this.msgOpType);
      paramVarArgs.gB(3, this.appMsgInnerType);
      paramVarArgs.gB(4, this.count);
      return 0;
    }
    if (paramInt == 1) {
      return d.a.a.a.gy(1, this.msgType) + 0 + d.a.a.a.gy(2, this.msgOpType) + d.a.a.a.gy(3, this.appMsgInnerType) + d.a.a.a.gy(4, this.count);
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
      IMBehaviorMsgOP localIMBehaviorMsgOP = (IMBehaviorMsgOP)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localIMBehaviorMsgOP.msgType = locala.xpH.oD();
        return 0;
      case 2: 
        localIMBehaviorMsgOP.msgOpType = locala.xpH.oD();
        return 0;
      case 3: 
        localIMBehaviorMsgOP.appMsgInnerType = locala.xpH.oD();
        return 0;
      }
      localIMBehaviorMsgOP.count = locala.xpH.oD();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.report.kvdata.IMBehaviorMsgOP
 * JD-Core Version:    0.7.0.1
 */