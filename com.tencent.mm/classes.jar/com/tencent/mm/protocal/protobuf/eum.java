package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class eum
  extends com.tencent.mm.bx.a
{
  public String abmt;
  public String desc;
  public String icon_url;
  public String scope;
  public int state;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257652);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.scope != null) {
        paramVarArgs.g(1, this.scope);
      }
      if (this.desc != null) {
        paramVarArgs.g(2, this.desc);
      }
      paramVarArgs.bS(3, this.state);
      if (this.icon_url != null) {
        paramVarArgs.g(4, this.icon_url);
      }
      if (this.abmt != null) {
        paramVarArgs.g(5, this.abmt);
      }
      AppMethodBeat.o(257652);
      return 0;
    }
    if (paramInt == 1) {
      if (this.scope == null) {
        break label434;
      }
    }
    label434:
    for (paramInt = i.a.a.b.b.a.h(1, this.scope) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.desc != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.desc);
      }
      i += i.a.a.b.b.a.cJ(3, this.state);
      paramInt = i;
      if (this.icon_url != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.icon_url);
      }
      i = paramInt;
      if (this.abmt != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.abmt);
      }
      AppMethodBeat.o(257652);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257652);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        eum localeum = (eum)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(257652);
          return -1;
        case 1: 
          localeum.scope = locala.ajGk.readString();
          AppMethodBeat.o(257652);
          return 0;
        case 2: 
          localeum.desc = locala.ajGk.readString();
          AppMethodBeat.o(257652);
          return 0;
        case 3: 
          localeum.state = locala.ajGk.aar();
          AppMethodBeat.o(257652);
          return 0;
        case 4: 
          localeum.icon_url = locala.ajGk.readString();
          AppMethodBeat.o(257652);
          return 0;
        }
        localeum.abmt = locala.ajGk.readString();
        AppMethodBeat.o(257652);
        return 0;
      }
      AppMethodBeat.o(257652);
      return -1;
    }
  }
  
  public final JSONObject toJSON()
  {
    AppMethodBeat.i(257654);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "scope", this.scope, false);
      com.tencent.mm.bk.a.a(localJSONObject, "desc", this.desc, false);
      com.tencent.mm.bk.a.a(localJSONObject, "state", Integer.valueOf(this.state), false);
      com.tencent.mm.bk.a.a(localJSONObject, "icon_url", this.icon_url, false);
      com.tencent.mm.bk.a.a(localJSONObject, "dark_mode_icon_url", this.abmt, false);
      label71:
      AppMethodBeat.o(257654);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label71;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eum
 * JD-Core Version:    0.7.0.1
 */