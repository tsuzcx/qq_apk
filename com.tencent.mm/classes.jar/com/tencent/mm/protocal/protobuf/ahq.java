package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class ahq
  extends com.tencent.mm.bx.a
{
  public boolean ZqF;
  public boolean ZqG = false;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(259097);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "ISDisplay", Boolean.valueOf(this.ZqF), false);
      com.tencent.mm.bk.a.a(localJSONObject, "IsRdm", Boolean.valueOf(this.ZqG), false);
      label41:
      AppMethodBeat.o(259097);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label41;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117865);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.di(1, this.ZqF);
      paramVarArgs.di(2, this.ZqG);
      AppMethodBeat.o(117865);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.ko(1);
      int i = i.a.a.b.b.a.ko(2);
      AppMethodBeat.o(117865);
      return paramInt + 1 + 0 + (i + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(117865);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      ahq localahq = (ahq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117865);
        return -1;
      case 1: 
        localahq.ZqF = locala.ajGk.aai();
        AppMethodBeat.o(117865);
        return 0;
      }
      localahq.ZqG = locala.ajGk.aai();
      AppMethodBeat.o(117865);
      return 0;
    }
    AppMethodBeat.o(117865);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahq
 * JD-Core Version:    0.7.0.1
 */