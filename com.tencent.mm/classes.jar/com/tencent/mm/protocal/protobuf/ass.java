package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class ass
  extends com.tencent.mm.bx.a
{
  public boolean ZCV;
  public String id;
  public String wording;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(258469);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "id", this.id, false);
      com.tencent.mm.bk.a.a(localJSONObject, "wording", this.wording, false);
      com.tencent.mm.bk.a.a(localJSONObject, "isUseToConfirm", Boolean.valueOf(this.ZCV), false);
      label49:
      AppMethodBeat.o(258469);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label49;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152991);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.id != null) {
        paramVarArgs.g(1, this.id);
      }
      if (this.wording != null) {
        paramVarArgs.g(2, this.wording);
      }
      paramVarArgs.di(3, this.ZCV);
      AppMethodBeat.o(152991);
      return 0;
    }
    if (paramInt == 1) {
      if (this.id == null) {
        break label314;
      }
    }
    label314:
    for (paramInt = i.a.a.b.b.a.h(1, this.id) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wording != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.wording);
      }
      paramInt = i.a.a.b.b.a.ko(3);
      AppMethodBeat.o(152991);
      return i + (paramInt + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(152991);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ass localass = (ass)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152991);
          return -1;
        case 1: 
          localass.id = locala.ajGk.readString();
          AppMethodBeat.o(152991);
          return 0;
        case 2: 
          localass.wording = locala.ajGk.readString();
          AppMethodBeat.o(152991);
          return 0;
        }
        localass.ZCV = locala.ajGk.aai();
        AppMethodBeat.o(152991);
        return 0;
      }
      AppMethodBeat.o(152991);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ass
 * JD-Core Version:    0.7.0.1
 */