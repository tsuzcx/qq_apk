package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class ewj
  extends com.tencent.mm.bx.a
{
  public String IGG;
  public String IcT;
  public String ThumbUrl;
  public String UserName;
  public String abyL;
  public int crz;
  public String hAP;
  public String muA;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(259866);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "Title", this.hAP, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Desc", this.IGG, false);
      com.tencent.mm.bk.a.a(localJSONObject, "ThumbUrl", this.ThumbUrl, false);
      com.tencent.mm.bk.a.a(localJSONObject, "AppID", this.muA, false);
      com.tencent.mm.bk.a.a(localJSONObject, "UserName", this.UserName, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Path", this.IcT, false);
      com.tencent.mm.bk.a.a(localJSONObject, "WeappIconUrl", this.abyL, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Version", Integer.valueOf(this.crz), false);
      label104:
      AppMethodBeat.o(259866);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label104;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259873);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.hAP != null) {
        paramVarArgs.g(1, this.hAP);
      }
      if (this.IGG != null) {
        paramVarArgs.g(2, this.IGG);
      }
      if (this.ThumbUrl != null) {
        paramVarArgs.g(3, this.ThumbUrl);
      }
      if (this.muA != null) {
        paramVarArgs.g(4, this.muA);
      }
      if (this.UserName != null) {
        paramVarArgs.g(5, this.UserName);
      }
      if (this.IcT != null) {
        paramVarArgs.g(6, this.IcT);
      }
      if (this.abyL != null) {
        paramVarArgs.g(7, this.abyL);
      }
      paramVarArgs.bS(8, this.crz);
      AppMethodBeat.o(259873);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hAP == null) {
        break label622;
      }
    }
    label622:
    for (int i = i.a.a.b.b.a.h(1, this.hAP) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IGG != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.IGG);
      }
      i = paramInt;
      if (this.ThumbUrl != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ThumbUrl);
      }
      paramInt = i;
      if (this.muA != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.muA);
      }
      i = paramInt;
      if (this.UserName != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.UserName);
      }
      paramInt = i;
      if (this.IcT != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.IcT);
      }
      i = paramInt;
      if (this.abyL != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.abyL);
      }
      paramInt = i.a.a.b.b.a.cJ(8, this.crz);
      AppMethodBeat.o(259873);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259873);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ewj localewj = (ewj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(259873);
          return -1;
        case 1: 
          localewj.hAP = locala.ajGk.readString();
          AppMethodBeat.o(259873);
          return 0;
        case 2: 
          localewj.IGG = locala.ajGk.readString();
          AppMethodBeat.o(259873);
          return 0;
        case 3: 
          localewj.ThumbUrl = locala.ajGk.readString();
          AppMethodBeat.o(259873);
          return 0;
        case 4: 
          localewj.muA = locala.ajGk.readString();
          AppMethodBeat.o(259873);
          return 0;
        case 5: 
          localewj.UserName = locala.ajGk.readString();
          AppMethodBeat.o(259873);
          return 0;
        case 6: 
          localewj.IcT = locala.ajGk.readString();
          AppMethodBeat.o(259873);
          return 0;
        case 7: 
          localewj.abyL = locala.ajGk.readString();
          AppMethodBeat.o(259873);
          return 0;
        }
        localewj.crz = locala.ajGk.aar();
        AppMethodBeat.o(259873);
        return 0;
      }
      AppMethodBeat.o(259873);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ewj
 * JD-Core Version:    0.7.0.1
 */