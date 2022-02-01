package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class dxb
  extends com.tencent.mm.bx.a
{
  public String aavy;
  public String abcR;
  public String abcS;
  public String abcT;
  public String abcU;
  public String abcV;
  public boolean abcW;
  public String title;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(258303);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "title", this.title, false);
      com.tencent.mm.bk.a.a(localJSONObject, "heading", this.abcR, false);
      com.tencent.mm.bk.a.a(localJSONObject, "desp", this.abcS, false);
      com.tencent.mm.bk.a.a(localJSONObject, "approve_button_wording", this.abcT, false);
      com.tencent.mm.bk.a.a(localJSONObject, "reject_button_wording", this.abcU, false);
      com.tencent.mm.bk.a.a(localJSONObject, "privacy_agreement_wording", this.abcV, false);
      com.tencent.mm.bk.a.a(localJSONObject, "privacy_agreement_url", this.aavy, false);
      com.tencent.mm.bk.a.a(localJSONObject, "is_force_archived", Boolean.valueOf(this.abcW), false);
      label104:
      AppMethodBeat.o(258303);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label104;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258309);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.g(1, this.title);
      }
      if (this.abcR != null) {
        paramVarArgs.g(2, this.abcR);
      }
      if (this.abcS != null) {
        paramVarArgs.g(3, this.abcS);
      }
      if (this.abcT != null) {
        paramVarArgs.g(4, this.abcT);
      }
      if (this.abcU != null) {
        paramVarArgs.g(5, this.abcU);
      }
      if (this.abcV != null) {
        paramVarArgs.g(6, this.abcV);
      }
      if (this.aavy != null) {
        paramVarArgs.g(7, this.aavy);
      }
      paramVarArgs.di(8, this.abcW);
      AppMethodBeat.o(258309);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label618;
      }
    }
    label618:
    for (int i = i.a.a.b.b.a.h(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abcR != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.abcR);
      }
      i = paramInt;
      if (this.abcS != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.abcS);
      }
      paramInt = i;
      if (this.abcT != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.abcT);
      }
      i = paramInt;
      if (this.abcU != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.abcU);
      }
      paramInt = i;
      if (this.abcV != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.abcV);
      }
      i = paramInt;
      if (this.aavy != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.aavy);
      }
      paramInt = i.a.a.b.b.a.ko(8);
      AppMethodBeat.o(258309);
      return i + (paramInt + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258309);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        dxb localdxb = (dxb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(258309);
          return -1;
        case 1: 
          localdxb.title = locala.ajGk.readString();
          AppMethodBeat.o(258309);
          return 0;
        case 2: 
          localdxb.abcR = locala.ajGk.readString();
          AppMethodBeat.o(258309);
          return 0;
        case 3: 
          localdxb.abcS = locala.ajGk.readString();
          AppMethodBeat.o(258309);
          return 0;
        case 4: 
          localdxb.abcT = locala.ajGk.readString();
          AppMethodBeat.o(258309);
          return 0;
        case 5: 
          localdxb.abcU = locala.ajGk.readString();
          AppMethodBeat.o(258309);
          return 0;
        case 6: 
          localdxb.abcV = locala.ajGk.readString();
          AppMethodBeat.o(258309);
          return 0;
        case 7: 
          localdxb.aavy = locala.ajGk.readString();
          AppMethodBeat.o(258309);
          return 0;
        }
        localdxb.abcW = locala.ajGk.aai();
        AppMethodBeat.o(258309);
        return 0;
      }
      AppMethodBeat.o(258309);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxb
 * JD-Core Version:    0.7.0.1
 */