package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class fnz
  extends com.tencent.mm.bx.a
{
  public String abNS;
  public String abNT;
  public String appId;
  public String avatar;
  public String desc;
  public String icO;
  public String title;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(258306);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "title", this.title, false);
      com.tencent.mm.bk.a.a(localJSONObject, "desc", this.desc, false);
      com.tencent.mm.bk.a.a(localJSONObject, "relativeURL", this.icO, false);
      com.tencent.mm.bk.a.a(localJSONObject, "originalId", this.abNS, false);
      com.tencent.mm.bk.a.a(localJSONObject, "weAppName", this.abNT, false);
      com.tencent.mm.bk.a.a(localJSONObject, "appId", this.appId, false);
      com.tencent.mm.bk.a.a(localJSONObject, "avatar", this.avatar, false);
      label90:
      AppMethodBeat.o(258306);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label90;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153000);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.g(1, this.title);
      }
      if (this.desc != null) {
        paramVarArgs.g(2, this.desc);
      }
      if (this.icO != null) {
        paramVarArgs.g(3, this.icO);
      }
      if (this.abNS != null) {
        paramVarArgs.g(4, this.abNS);
      }
      if (this.abNT != null) {
        paramVarArgs.g(5, this.abNT);
      }
      if (this.appId != null) {
        paramVarArgs.g(6, this.appId);
      }
      if (this.avatar != null) {
        paramVarArgs.g(7, this.avatar);
      }
      AppMethodBeat.o(153000);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label574;
      }
    }
    label574:
    for (int i = i.a.a.b.b.a.h(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.desc);
      }
      i = paramInt;
      if (this.icO != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.icO);
      }
      paramInt = i;
      if (this.abNS != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.abNS);
      }
      i = paramInt;
      if (this.abNT != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.abNT);
      }
      paramInt = i;
      if (this.appId != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.appId);
      }
      i = paramInt;
      if (this.avatar != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.avatar);
      }
      AppMethodBeat.o(153000);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(153000);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        fnz localfnz = (fnz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153000);
          return -1;
        case 1: 
          localfnz.title = locala.ajGk.readString();
          AppMethodBeat.o(153000);
          return 0;
        case 2: 
          localfnz.desc = locala.ajGk.readString();
          AppMethodBeat.o(153000);
          return 0;
        case 3: 
          localfnz.icO = locala.ajGk.readString();
          AppMethodBeat.o(153000);
          return 0;
        case 4: 
          localfnz.abNS = locala.ajGk.readString();
          AppMethodBeat.o(153000);
          return 0;
        case 5: 
          localfnz.abNT = locala.ajGk.readString();
          AppMethodBeat.o(153000);
          return 0;
        case 6: 
          localfnz.appId = locala.ajGk.readString();
          AppMethodBeat.o(153000);
          return 0;
        }
        localfnz.avatar = locala.ajGk.readString();
        AppMethodBeat.o(153000);
        return 0;
      }
      AppMethodBeat.o(153000);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fnz
 * JD-Core Version:    0.7.0.1
 */