package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class drv
  extends com.tencent.mm.bx.a
{
  public boolean AMQ;
  public long aaXv;
  public long aaXw;
  public long aaXx;
  public long aaXy;
  public long duration;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(259940);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "enterEduTimestamp", Long.valueOf(this.aaXv), false);
      com.tencent.mm.bk.a.a(localJSONObject, "eduType", Long.valueOf(this.aaXw), false);
      com.tencent.mm.bk.a.a(localJSONObject, "exitType", Long.valueOf(this.aaXx), false);
      com.tencent.mm.bk.a.a(localJSONObject, "duration", Long.valueOf(this.duration), false);
      com.tencent.mm.bk.a.a(localJSONObject, "listEduType", Long.valueOf(this.aaXy), false);
      com.tencent.mm.bk.a.a(localJSONObject, "isExposed", Boolean.valueOf(this.AMQ), false);
      label97:
      AppMethodBeat.o(259940);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label97;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259944);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(12, this.aaXv);
      paramVarArgs.bv(1, this.aaXw);
      paramVarArgs.bv(2, this.aaXx);
      paramVarArgs.bv(3, this.duration);
      paramVarArgs.bv(4, this.aaXy);
      paramVarArgs.di(5, this.AMQ);
      AppMethodBeat.o(259944);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.q(12, this.aaXv);
      int i = i.a.a.b.b.a.q(1, this.aaXw);
      int j = i.a.a.b.b.a.q(2, this.aaXx);
      int k = i.a.a.b.b.a.q(3, this.duration);
      int m = i.a.a.b.b.a.q(4, this.aaXy);
      int n = i.a.a.b.b.a.ko(5);
      AppMethodBeat.o(259944);
      return paramInt + 0 + i + j + k + m + (n + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259944);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      drv localdrv = (drv)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      case 6: 
      case 7: 
      case 8: 
      case 9: 
      case 10: 
      case 11: 
      default: 
        AppMethodBeat.o(259944);
        return -1;
      case 12: 
        localdrv.aaXv = locala.ajGk.aaw();
        AppMethodBeat.o(259944);
        return 0;
      case 1: 
        localdrv.aaXw = locala.ajGk.aaw();
        AppMethodBeat.o(259944);
        return 0;
      case 2: 
        localdrv.aaXx = locala.ajGk.aaw();
        AppMethodBeat.o(259944);
        return 0;
      case 3: 
        localdrv.duration = locala.ajGk.aaw();
        AppMethodBeat.o(259944);
        return 0;
      case 4: 
        localdrv.aaXy = locala.ajGk.aaw();
        AppMethodBeat.o(259944);
        return 0;
      }
      localdrv.AMQ = locala.ajGk.aai();
      AppMethodBeat.o(259944);
      return 0;
    }
    AppMethodBeat.o(259944);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.drv
 * JD-Core Version:    0.7.0.1
 */