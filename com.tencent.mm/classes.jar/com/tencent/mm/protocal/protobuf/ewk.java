package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class ewk
  extends com.tencent.mm.bx.a
{
  public String ThumbUrl;
  public String UserName;
  public String abxR;
  public int abyM;
  public int abyN;
  public String muA;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(259925);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "UserName", this.UserName, false);
      com.tencent.mm.bk.a.a(localJSONObject, "SourceDisplayName", this.abxR, false);
      com.tencent.mm.bk.a.a(localJSONObject, "ThumbUrl", this.ThumbUrl, false);
      com.tencent.mm.bk.a.a(localJSONObject, "AppID", this.muA, false);
      com.tencent.mm.bk.a.a(localJSONObject, "TradingGuaranteeFlag", Integer.valueOf(this.abyM), false);
      com.tencent.mm.bk.a.a(localJSONObject, "BrandOfficialFlag", Integer.valueOf(this.abyN), false);
      label85:
      AppMethodBeat.o(259925);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label85;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259928);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.UserName != null) {
        paramVarArgs.g(1, this.UserName);
      }
      if (this.abxR != null) {
        paramVarArgs.g(2, this.abxR);
      }
      if (this.ThumbUrl != null) {
        paramVarArgs.g(3, this.ThumbUrl);
      }
      if (this.muA != null) {
        paramVarArgs.g(4, this.muA);
      }
      paramVarArgs.bS(5, this.abyM);
      paramVarArgs.bS(6, this.abyN);
      AppMethodBeat.o(259928);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UserName == null) {
        break label482;
      }
    }
    label482:
    for (int i = i.a.a.b.b.a.h(1, this.UserName) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abxR != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.abxR);
      }
      i = paramInt;
      if (this.ThumbUrl != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ThumbUrl);
      }
      paramInt = i;
      if (this.muA != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.muA);
      }
      i = i.a.a.b.b.a.cJ(5, this.abyM);
      int j = i.a.a.b.b.a.cJ(6, this.abyN);
      AppMethodBeat.o(259928);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259928);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ewk localewk = (ewk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(259928);
          return -1;
        case 1: 
          localewk.UserName = locala.ajGk.readString();
          AppMethodBeat.o(259928);
          return 0;
        case 2: 
          localewk.abxR = locala.ajGk.readString();
          AppMethodBeat.o(259928);
          return 0;
        case 3: 
          localewk.ThumbUrl = locala.ajGk.readString();
          AppMethodBeat.o(259928);
          return 0;
        case 4: 
          localewk.muA = locala.ajGk.readString();
          AppMethodBeat.o(259928);
          return 0;
        case 5: 
          localewk.abyM = locala.ajGk.aar();
          AppMethodBeat.o(259928);
          return 0;
        }
        localewk.abyN = locala.ajGk.aar();
        AppMethodBeat.o(259928);
        return 0;
      }
      AppMethodBeat.o(259928);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ewk
 * JD-Core Version:    0.7.0.1
 */