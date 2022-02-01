package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import org.json.JSONObject;

public final class ewe
  extends com.tencent.mm.bx.a
{
  public int IKW;
  public String SessionId;
  public String aaye;
  public String aayf;
  public int abmA;
  public String abyG;
  public b abyH;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(259833);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "SessionId", this.SessionId, false);
      com.tencent.mm.bk.a.a(localJSONObject, "SearchId", this.aayf, false);
      com.tencent.mm.bk.a.a(localJSONObject, "RequestId", this.aaye, false);
      com.tencent.mm.bk.a.a(localJSONObject, "BusinessType", Integer.valueOf(this.IKW), false);
      com.tencent.mm.bk.a.a(localJSONObject, "SubType", Integer.valueOf(this.abmA), false);
      com.tencent.mm.bk.a.a(localJSONObject, "DocID", this.abyG, false);
      com.tencent.mm.bk.a.a(localJSONObject, "ExtendInfo", this.abyH, false);
      label96:
      AppMethodBeat.o(259833);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label96;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259837);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.SessionId != null) {
        paramVarArgs.g(1, this.SessionId);
      }
      if (this.aayf != null) {
        paramVarArgs.g(2, this.aayf);
      }
      if (this.aaye != null) {
        paramVarArgs.g(3, this.aaye);
      }
      paramVarArgs.bS(4, this.IKW);
      paramVarArgs.bS(5, this.abmA);
      if (this.abyG != null) {
        paramVarArgs.g(6, this.abyG);
      }
      if (this.abyH != null) {
        paramVarArgs.d(7, this.abyH);
      }
      AppMethodBeat.o(259837);
      return 0;
    }
    if (paramInt == 1) {
      if (this.SessionId == null) {
        break label542;
      }
    }
    label542:
    for (int i = i.a.a.b.b.a.h(1, this.SessionId) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aayf != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.aayf);
      }
      i = paramInt;
      if (this.aaye != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.aaye);
      }
      i = i + i.a.a.b.b.a.cJ(4, this.IKW) + i.a.a.b.b.a.cJ(5, this.abmA);
      paramInt = i;
      if (this.abyG != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.abyG);
      }
      i = paramInt;
      if (this.abyH != null) {
        i = paramInt + i.a.a.b.b.a.c(7, this.abyH);
      }
      AppMethodBeat.o(259837);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259837);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ewe localewe = (ewe)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(259837);
          return -1;
        case 1: 
          localewe.SessionId = locala.ajGk.readString();
          AppMethodBeat.o(259837);
          return 0;
        case 2: 
          localewe.aayf = locala.ajGk.readString();
          AppMethodBeat.o(259837);
          return 0;
        case 3: 
          localewe.aaye = locala.ajGk.readString();
          AppMethodBeat.o(259837);
          return 0;
        case 4: 
          localewe.IKW = locala.ajGk.aar();
          AppMethodBeat.o(259837);
          return 0;
        case 5: 
          localewe.abmA = locala.ajGk.aar();
          AppMethodBeat.o(259837);
          return 0;
        case 6: 
          localewe.abyG = locala.ajGk.readString();
          AppMethodBeat.o(259837);
          return 0;
        }
        localewe.abyH = locala.ajGk.kFX();
        AppMethodBeat.o(259837);
        return 0;
      }
      AppMethodBeat.o(259837);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ewe
 * JD-Core Version:    0.7.0.1
 */