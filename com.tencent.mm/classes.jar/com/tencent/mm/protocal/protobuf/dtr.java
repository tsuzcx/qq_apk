package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class dtr
  extends com.tencent.mm.bx.a
{
  public String seq;
  public String token;
  public String url;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(259386);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "seq", this.seq, false);
      com.tencent.mm.bk.a.a(localJSONObject, "url", this.url, false);
      com.tencent.mm.bk.a.a(localJSONObject, "token", this.token, false);
      label46:
      AppMethodBeat.o(259386);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label46;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259387);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.seq != null) {
        paramVarArgs.g(1, this.seq);
      }
      if (this.url != null) {
        paramVarArgs.g(2, this.url);
      }
      if (this.token != null) {
        paramVarArgs.g(3, this.token);
      }
      AppMethodBeat.o(259387);
      return 0;
    }
    if (paramInt == 1) {
      if (this.seq == null) {
        break label330;
      }
    }
    label330:
    for (int i = i.a.a.b.b.a.h(1, this.seq) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.url);
      }
      i = paramInt;
      if (this.token != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.token);
      }
      AppMethodBeat.o(259387);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259387);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dtr localdtr = (dtr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(259387);
          return -1;
        case 1: 
          localdtr.seq = locala.ajGk.readString();
          AppMethodBeat.o(259387);
          return 0;
        case 2: 
          localdtr.url = locala.ajGk.readString();
          AppMethodBeat.o(259387);
          return 0;
        }
        localdtr.token = locala.ajGk.readString();
        AppMethodBeat.o(259387);
        return 0;
      }
      AppMethodBeat.o(259387);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dtr
 * JD-Core Version:    0.7.0.1
 */