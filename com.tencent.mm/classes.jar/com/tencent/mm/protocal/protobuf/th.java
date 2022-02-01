package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import org.json.JSONObject;

public final class th
  extends com.tencent.mm.bx.a
{
  public long Id;
  public String YYX;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(259481);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "Id", Long.valueOf(this.Id), false);
      com.tencent.mm.bk.a.a(localJSONObject, "ObjectDesc", this.YYX, false);
      label38:
      AppMethodBeat.o(259481);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label38;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117853);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YYX == null)
      {
        paramVarArgs = new b("Not all required fields were included: ObjectDesc");
        AppMethodBeat.o(117853);
        throw paramVarArgs;
      }
      paramVarArgs.bv(1, this.Id);
      if (this.YYX != null) {
        paramVarArgs.g(2, this.YYX);
      }
      AppMethodBeat.o(117853);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.q(1, this.Id) + 0;
      paramInt = i;
      if (this.YYX != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.YYX);
      }
      AppMethodBeat.o(117853);
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
      if (this.YYX == null)
      {
        paramVarArgs = new b("Not all required fields were included: ObjectDesc");
        AppMethodBeat.o(117853);
        throw paramVarArgs;
      }
      AppMethodBeat.o(117853);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      th localth = (th)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117853);
        return -1;
      case 1: 
        localth.Id = locala.ajGk.aaw();
        AppMethodBeat.o(117853);
        return 0;
      }
      localth.YYX = locala.ajGk.readString();
      AppMethodBeat.o(117853);
      return 0;
    }
    AppMethodBeat.o(117853);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.th
 * JD-Core Version:    0.7.0.1
 */