package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class dru
  extends com.tencent.mm.bx.a
{
  public long aaXu;
  public long duration;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(259951);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "startBrowseTimestamp", Long.valueOf(this.aaXu), false);
      com.tencent.mm.bk.a.a(localJSONObject, "duration", Long.valueOf(this.duration), false);
      label41:
      AppMethodBeat.o(259951);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label41;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259955);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.aaXu);
      paramVarArgs.bv(2, this.duration);
      AppMethodBeat.o(259955);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.q(1, this.aaXu);
      int i = i.a.a.b.b.a.q(2, this.duration);
      AppMethodBeat.o(259955);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259955);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      dru localdru = (dru)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259955);
        return -1;
      case 1: 
        localdru.aaXu = locala.ajGk.aaw();
        AppMethodBeat.o(259955);
        return 0;
      }
      localdru.duration = locala.ajGk.aaw();
      AppMethodBeat.o(259955);
      return 0;
    }
    AppMethodBeat.o(259955);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dru
 * JD-Core Version:    0.7.0.1
 */