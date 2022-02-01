package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import org.json.JSONObject;

public final class aem
  extends com.tencent.mm.bx.a
{
  public long Zmx;
  public String Zmy;
  public String key;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(257354);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "key", this.key, false);
      com.tencent.mm.bk.a.a(localJSONObject, "uint_value", Long.valueOf(this.Zmx), false);
      com.tencent.mm.bk.a.a(localJSONObject, "text_value", this.Zmy, false);
      label49:
      AppMethodBeat.o(257354);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label49;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152990);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.key == null)
      {
        paramVarArgs = new b("Not all required fields were included: key");
        AppMethodBeat.o(152990);
        throw paramVarArgs;
      }
      if (this.key != null) {
        paramVarArgs.g(1, this.key);
      }
      paramVarArgs.bv(2, this.Zmx);
      if (this.Zmy != null) {
        paramVarArgs.g(3, this.Zmy);
      }
      AppMethodBeat.o(152990);
      return 0;
    }
    if (paramInt == 1) {
      if (this.key == null) {
        break label362;
      }
    }
    label362:
    for (paramInt = i.a.a.b.b.a.h(1, this.key) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.Zmx);
      paramInt = i;
      if (this.Zmy != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.Zmy);
      }
      AppMethodBeat.o(152990);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.key == null)
        {
          paramVarArgs = new b("Not all required fields were included: key");
          AppMethodBeat.o(152990);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152990);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        aem localaem = (aem)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152990);
          return -1;
        case 1: 
          localaem.key = locala.ajGk.readString();
          AppMethodBeat.o(152990);
          return 0;
        case 2: 
          localaem.Zmx = locala.ajGk.aaw();
          AppMethodBeat.o(152990);
          return 0;
        }
        localaem.Zmy = locala.ajGk.readString();
        AppMethodBeat.o(152990);
        return 0;
      }
      AppMethodBeat.o(152990);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aem
 * JD-Core Version:    0.7.0.1
 */