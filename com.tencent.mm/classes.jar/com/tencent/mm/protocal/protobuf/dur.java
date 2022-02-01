package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class dur
  extends com.tencent.mm.bx.a
{
  public String abaD;
  public int hQm;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(259059);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "eventType", Integer.valueOf(this.hQm), false);
      com.tencent.mm.bk.a.a(localJSONObject, "eventData", this.abaD, false);
      label38:
      AppMethodBeat.o(259059);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label38;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259061);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.hQm);
      if (this.abaD != null) {
        paramVarArgs.g(2, this.abaD);
      }
      AppMethodBeat.o(259061);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.hQm) + 0;
      paramInt = i;
      if (this.abaD != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.abaD);
      }
      AppMethodBeat.o(259061);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259061);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      dur localdur = (dur)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259061);
        return -1;
      case 1: 
        localdur.hQm = locala.ajGk.aar();
        AppMethodBeat.o(259061);
        return 0;
      }
      localdur.abaD = locala.ajGk.readString();
      AppMethodBeat.o(259061);
      return 0;
    }
    AppMethodBeat.o(259061);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dur
 * JD-Core Version:    0.7.0.1
 */