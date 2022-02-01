package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class eay
  extends com.tencent.mm.bx.a
{
  public String IGI;
  public String UserName;
  public int YVh;
  public String ZrY;
  public int ZrZ;
  public String Zsa;
  public String abgt;
  public String abgu;
  public String abgv;
  public String query;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(258273);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "ActionType", Integer.valueOf(this.YVh), false);
      com.tencent.mm.bk.a.a(localJSONObject, "JumpUrl", this.IGI, false);
      com.tencent.mm.bk.a.a(localJSONObject, "UserName", this.UserName, false);
      com.tencent.mm.bk.a.a(localJSONObject, "WeappPath", this.ZrY, false);
      com.tencent.mm.bk.a.a(localJSONObject, "WeappVersion", Integer.valueOf(this.ZrZ), false);
      com.tencent.mm.bk.a.a(localJSONObject, "SceneNote", this.Zsa, false);
      com.tencent.mm.bk.a.a(localJSONObject, "CtrlInfo", this.abgt, false);
      com.tencent.mm.bk.a.a(localJSONObject, "MusicObjectXmlDesc", this.abgu, false);
      com.tencent.mm.bk.a.a(localJSONObject, "query", this.query, false);
      com.tencent.mm.bk.a.a(localJSONObject, "extParamStr", this.abgv, false);
      label129:
      AppMethodBeat.o(258273);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label129;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117887);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.YVh);
      if (this.IGI != null) {
        paramVarArgs.g(2, this.IGI);
      }
      if (this.UserName != null) {
        paramVarArgs.g(3, this.UserName);
      }
      if (this.ZrY != null) {
        paramVarArgs.g(4, this.ZrY);
      }
      paramVarArgs.bS(5, this.ZrZ);
      if (this.Zsa != null) {
        paramVarArgs.g(6, this.Zsa);
      }
      if (this.abgt != null) {
        paramVarArgs.g(7, this.abgt);
      }
      if (this.abgu != null) {
        paramVarArgs.g(8, this.abgu);
      }
      if (this.query != null) {
        paramVarArgs.g(100, this.query);
      }
      if (this.abgv != null) {
        paramVarArgs.g(101, this.abgv);
      }
      AppMethodBeat.o(117887);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.YVh) + 0;
      paramInt = i;
      if (this.IGI != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.IGI);
      }
      i = paramInt;
      if (this.UserName != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.UserName);
      }
      paramInt = i;
      if (this.ZrY != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ZrY);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.ZrZ);
      paramInt = i;
      if (this.Zsa != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.Zsa);
      }
      i = paramInt;
      if (this.abgt != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.abgt);
      }
      paramInt = i;
      if (this.abgu != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.abgu);
      }
      i = paramInt;
      if (this.query != null) {
        i = paramInt + i.a.a.b.b.a.h(100, this.query);
      }
      paramInt = i;
      if (this.abgv != null) {
        paramInt = i + i.a.a.b.b.a.h(101, this.abgv);
      }
      AppMethodBeat.o(117887);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(117887);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      eay localeay = (eay)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117887);
        return -1;
      case 1: 
        localeay.YVh = locala.ajGk.aar();
        AppMethodBeat.o(117887);
        return 0;
      case 2: 
        localeay.IGI = locala.ajGk.readString();
        AppMethodBeat.o(117887);
        return 0;
      case 3: 
        localeay.UserName = locala.ajGk.readString();
        AppMethodBeat.o(117887);
        return 0;
      case 4: 
        localeay.ZrY = locala.ajGk.readString();
        AppMethodBeat.o(117887);
        return 0;
      case 5: 
        localeay.ZrZ = locala.ajGk.aar();
        AppMethodBeat.o(117887);
        return 0;
      case 6: 
        localeay.Zsa = locala.ajGk.readString();
        AppMethodBeat.o(117887);
        return 0;
      case 7: 
        localeay.abgt = locala.ajGk.readString();
        AppMethodBeat.o(117887);
        return 0;
      case 8: 
        localeay.abgu = locala.ajGk.readString();
        AppMethodBeat.o(117887);
        return 0;
      case 100: 
        localeay.query = locala.ajGk.readString();
        AppMethodBeat.o(117887);
        return 0;
      }
      localeay.abgv = locala.ajGk.readString();
      AppMethodBeat.o(117887);
      return 0;
    }
    AppMethodBeat.o(117887);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eay
 * JD-Core Version:    0.7.0.1
 */