package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class gja
  extends com.tencent.mm.bx.a
{
  public String IHo;
  public String UserName;
  public int YQB;
  public String abgw;
  public String acfp;
  public String muA;
  public String vhX;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(258419);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "DocId", this.abgw, false);
      com.tencent.mm.bk.a.a(localJSONObject, "UserName", this.UserName, false);
      com.tencent.mm.bk.a.a(localJSONObject, "NickName", this.vhX, false);
      com.tencent.mm.bk.a.a(localJSONObject, "AppID", this.muA, false);
      com.tencent.mm.bk.a.a(localJSONObject, "AppVersion", Integer.valueOf(this.YQB), false);
      com.tencent.mm.bk.a.a(localJSONObject, "BoxInfo", this.acfp, false);
      com.tencent.mm.bk.a.a(localJSONObject, "IconUrl", this.IHo, false);
      label93:
      AppMethodBeat.o(258419);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label93;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117957);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abgw != null) {
        paramVarArgs.g(1, this.abgw);
      }
      if (this.UserName != null) {
        paramVarArgs.g(2, this.UserName);
      }
      if (this.vhX != null) {
        paramVarArgs.g(3, this.vhX);
      }
      if (this.muA != null) {
        paramVarArgs.g(4, this.muA);
      }
      paramVarArgs.bS(5, this.YQB);
      if (this.acfp != null) {
        paramVarArgs.g(6, this.acfp);
      }
      if (this.IHo != null) {
        paramVarArgs.g(7, this.IHo);
      }
      AppMethodBeat.o(117957);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abgw == null) {
        break label558;
      }
    }
    label558:
    for (int i = i.a.a.b.b.a.h(1, this.abgw) + 0;; i = 0)
    {
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.UserName);
      }
      i = paramInt;
      if (this.vhX != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.vhX);
      }
      paramInt = i;
      if (this.muA != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.muA);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.YQB);
      paramInt = i;
      if (this.acfp != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.acfp);
      }
      i = paramInt;
      if (this.IHo != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.IHo);
      }
      AppMethodBeat.o(117957);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(117957);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        gja localgja = (gja)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117957);
          return -1;
        case 1: 
          localgja.abgw = locala.ajGk.readString();
          AppMethodBeat.o(117957);
          return 0;
        case 2: 
          localgja.UserName = locala.ajGk.readString();
          AppMethodBeat.o(117957);
          return 0;
        case 3: 
          localgja.vhX = locala.ajGk.readString();
          AppMethodBeat.o(117957);
          return 0;
        case 4: 
          localgja.muA = locala.ajGk.readString();
          AppMethodBeat.o(117957);
          return 0;
        case 5: 
          localgja.YQB = locala.ajGk.aar();
          AppMethodBeat.o(117957);
          return 0;
        case 6: 
          localgja.acfp = locala.ajGk.readString();
          AppMethodBeat.o(117957);
          return 0;
        }
        localgja.IHo = locala.ajGk.readString();
        AppMethodBeat.o(117957);
        return 0;
      }
      AppMethodBeat.o(117957);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gja
 * JD-Core Version:    0.7.0.1
 */