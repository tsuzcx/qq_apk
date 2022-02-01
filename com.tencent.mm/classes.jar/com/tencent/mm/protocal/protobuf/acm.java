package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class acm
  extends com.tencent.mm.bx.a
{
  public int ZkO;
  public int ZkP;
  public int ZkQ;
  public boolean ZkR;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(257999);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "BizSwitch", Integer.valueOf(this.ZkO), false);
      com.tencent.mm.bk.a.a(localJSONObject, "WeappSwitch", Integer.valueOf(this.ZkP), false);
      com.tencent.mm.bk.a.a(localJSONObject, "FinderSwitch", Integer.valueOf(this.ZkQ), false);
      com.tencent.mm.bk.a.a(localJSONObject, "ChildModeSwitch", Boolean.valueOf(this.ZkR), false);
      label69:
      AppMethodBeat.o(257999);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label69;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258001);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.ZkO);
      paramVarArgs.bS(2, this.ZkP);
      paramVarArgs.bS(3, this.ZkQ);
      paramVarArgs.di(4, this.ZkR);
      AppMethodBeat.o(258001);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.ZkO);
      int i = i.a.a.b.b.a.cJ(2, this.ZkP);
      int j = i.a.a.b.b.a.cJ(3, this.ZkQ);
      int k = i.a.a.b.b.a.ko(4);
      AppMethodBeat.o(258001);
      return paramInt + 0 + i + j + (k + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258001);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      acm localacm = (acm)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(258001);
        return -1;
      case 1: 
        localacm.ZkO = locala.ajGk.aar();
        AppMethodBeat.o(258001);
        return 0;
      case 2: 
        localacm.ZkP = locala.ajGk.aar();
        AppMethodBeat.o(258001);
        return 0;
      case 3: 
        localacm.ZkQ = locala.ajGk.aar();
        AppMethodBeat.o(258001);
        return 0;
      }
      localacm.ZkR = locala.ajGk.aai();
      AppMethodBeat.o(258001);
      return 0;
    }
    AppMethodBeat.o(258001);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acm
 * JD-Core Version:    0.7.0.1
 */