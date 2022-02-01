package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class evm
  extends com.tencent.mm.bx.a
{
  public String UserName;
  public String ZuK;
  public String abym;
  public String abyn;
  public String hAP;
  public String vhX;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(260193);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "Title", this.hAP, false);
      com.tencent.mm.bk.a.a(localJSONObject, "UserName", this.UserName, false);
      com.tencent.mm.bk.a.a(localJSONObject, "HeadUrl", this.ZuK, false);
      com.tencent.mm.bk.a.a(localJSONObject, "NickName", this.vhX, false);
      com.tencent.mm.bk.a.a(localJSONObject, "AuthJob", this.abym, false);
      com.tencent.mm.bk.a.a(localJSONObject, "AuthIcon", this.abyn, false);
      label79:
      AppMethodBeat.o(260193);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label79;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260196);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.hAP != null) {
        paramVarArgs.g(1, this.hAP);
      }
      if (this.UserName != null) {
        paramVarArgs.g(2, this.UserName);
      }
      if (this.ZuK != null) {
        paramVarArgs.g(3, this.ZuK);
      }
      if (this.vhX != null) {
        paramVarArgs.g(4, this.vhX);
      }
      if (this.abym != null) {
        paramVarArgs.g(5, this.abym);
      }
      if (this.abyn != null) {
        paramVarArgs.g(6, this.abyn);
      }
      AppMethodBeat.o(260196);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hAP == null) {
        break label514;
      }
    }
    label514:
    for (int i = i.a.a.b.b.a.h(1, this.hAP) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.UserName);
      }
      i = paramInt;
      if (this.ZuK != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ZuK);
      }
      paramInt = i;
      if (this.vhX != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.vhX);
      }
      i = paramInt;
      if (this.abym != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.abym);
      }
      paramInt = i;
      if (this.abyn != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.abyn);
      }
      AppMethodBeat.o(260196);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(260196);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        evm localevm = (evm)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(260196);
          return -1;
        case 1: 
          localevm.hAP = locala.ajGk.readString();
          AppMethodBeat.o(260196);
          return 0;
        case 2: 
          localevm.UserName = locala.ajGk.readString();
          AppMethodBeat.o(260196);
          return 0;
        case 3: 
          localevm.ZuK = locala.ajGk.readString();
          AppMethodBeat.o(260196);
          return 0;
        case 4: 
          localevm.vhX = locala.ajGk.readString();
          AppMethodBeat.o(260196);
          return 0;
        case 5: 
          localevm.abym = locala.ajGk.readString();
          AppMethodBeat.o(260196);
          return 0;
        }
        localevm.abyn = locala.ajGk.readString();
        AppMethodBeat.o(260196);
        return 0;
      }
      AppMethodBeat.o(260196);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.evm
 * JD-Core Version:    0.7.0.1
 */