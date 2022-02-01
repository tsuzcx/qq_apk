package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class eou
  extends com.tencent.mm.bx.a
{
  public String aaVQ;
  public String absW;
  public String absX;
  public String absY;
  public String vhX;
  public String ytr;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(259474);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "NickName", this.vhX, false);
      com.tencent.mm.bk.a.a(localJSONObject, "PwdHash", this.absW, false);
      com.tencent.mm.bk.a.a(localJSONObject, "HeadImgMd5", this.aaVQ, false);
      com.tencent.mm.bk.a.a(localJSONObject, "PhoneNumber", this.absX, false);
      com.tencent.mm.bk.a.a(localJSONObject, "TimeZone", this.ytr, false);
      com.tencent.mm.bk.a.a(localJSONObject, "TimeZoneName", this.absY, false);
      label79:
      AppMethodBeat.o(259474);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label79;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(134253);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.vhX != null) {
        paramVarArgs.g(1, this.vhX);
      }
      if (this.absW != null) {
        paramVarArgs.g(2, this.absW);
      }
      if (this.aaVQ != null) {
        paramVarArgs.g(3, this.aaVQ);
      }
      if (this.absX != null) {
        paramVarArgs.g(4, this.absX);
      }
      if (this.ytr != null) {
        paramVarArgs.g(5, this.ytr);
      }
      if (this.absY != null) {
        paramVarArgs.g(6, this.absY);
      }
      AppMethodBeat.o(134253);
      return 0;
    }
    if (paramInt == 1) {
      if (this.vhX == null) {
        break label514;
      }
    }
    label514:
    for (int i = i.a.a.b.b.a.h(1, this.vhX) + 0;; i = 0)
    {
      paramInt = i;
      if (this.absW != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.absW);
      }
      i = paramInt;
      if (this.aaVQ != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.aaVQ);
      }
      paramInt = i;
      if (this.absX != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.absX);
      }
      i = paramInt;
      if (this.ytr != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.ytr);
      }
      paramInt = i;
      if (this.absY != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.absY);
      }
      AppMethodBeat.o(134253);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(134253);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        eou localeou = (eou)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(134253);
          return -1;
        case 1: 
          localeou.vhX = locala.ajGk.readString();
          AppMethodBeat.o(134253);
          return 0;
        case 2: 
          localeou.absW = locala.ajGk.readString();
          AppMethodBeat.o(134253);
          return 0;
        case 3: 
          localeou.aaVQ = locala.ajGk.readString();
          AppMethodBeat.o(134253);
          return 0;
        case 4: 
          localeou.absX = locala.ajGk.readString();
          AppMethodBeat.o(134253);
          return 0;
        case 5: 
          localeou.ytr = locala.ajGk.readString();
          AppMethodBeat.o(134253);
          return 0;
        }
        localeou.absY = locala.ajGk.readString();
        AppMethodBeat.o(134253);
        return 0;
      }
      AppMethodBeat.o(134253);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eou
 * JD-Core Version:    0.7.0.1
 */