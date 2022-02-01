package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import org.json.JSONObject;

public final class fvd
  extends com.tencent.mm.bx.a
{
  public String UserName;
  public String Zpa;
  public String abTC;
  public String crB;
  public String pSk;
  public String vhX;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(258696);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "UserName", this.UserName, false);
      com.tencent.mm.bk.a.a(localJSONObject, "MatchWord", this.abTC, false);
      com.tencent.mm.bk.a.a(localJSONObject, "NickName", this.vhX, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Remark", this.Zpa, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Alias", this.pSk, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Description", this.crB, false);
      label79:
      AppMethodBeat.o(258696);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label79;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117939);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.UserName == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(117939);
        throw paramVarArgs;
      }
      if (this.abTC == null)
      {
        paramVarArgs = new b("Not all required fields were included: MatchWord");
        AppMethodBeat.o(117939);
        throw paramVarArgs;
      }
      if (this.UserName != null) {
        paramVarArgs.g(1, this.UserName);
      }
      if (this.abTC != null) {
        paramVarArgs.g(2, this.abTC);
      }
      if (this.vhX != null) {
        paramVarArgs.g(3, this.vhX);
      }
      if (this.Zpa != null) {
        paramVarArgs.g(4, this.Zpa);
      }
      if (this.pSk != null) {
        paramVarArgs.g(5, this.pSk);
      }
      if (this.crB != null) {
        paramVarArgs.g(6, this.crB);
      }
      AppMethodBeat.o(117939);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UserName == null) {
        break label610;
      }
    }
    label610:
    for (int i = i.a.a.b.b.a.h(1, this.UserName) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abTC != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.abTC);
      }
      i = paramInt;
      if (this.vhX != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.vhX);
      }
      paramInt = i;
      if (this.Zpa != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.Zpa);
      }
      i = paramInt;
      if (this.pSk != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.pSk);
      }
      paramInt = i;
      if (this.crB != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.crB);
      }
      AppMethodBeat.o(117939);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.UserName == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(117939);
          throw paramVarArgs;
        }
        if (this.abTC == null)
        {
          paramVarArgs = new b("Not all required fields were included: MatchWord");
          AppMethodBeat.o(117939);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117939);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        fvd localfvd = (fvd)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117939);
          return -1;
        case 1: 
          localfvd.UserName = locala.ajGk.readString();
          AppMethodBeat.o(117939);
          return 0;
        case 2: 
          localfvd.abTC = locala.ajGk.readString();
          AppMethodBeat.o(117939);
          return 0;
        case 3: 
          localfvd.vhX = locala.ajGk.readString();
          AppMethodBeat.o(117939);
          return 0;
        case 4: 
          localfvd.Zpa = locala.ajGk.readString();
          AppMethodBeat.o(117939);
          return 0;
        case 5: 
          localfvd.pSk = locala.ajGk.readString();
          AppMethodBeat.o(117939);
          return 0;
        }
        localfvd.crB = locala.ajGk.readString();
        AppMethodBeat.o(117939);
        return 0;
      }
      AppMethodBeat.o(117939);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fvd
 * JD-Core Version:    0.7.0.1
 */