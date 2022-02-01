package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class fnx
  extends com.tencent.mm.bx.a
{
  public int IJG;
  public int IcB;
  public int YIc;
  public String aaye;
  public String aayf;
  public String abNQ;
  public String abgw;
  public String abuT;
  public int muC;
  public String nUB;
  public String vYo;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(258290);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "DocId", this.abgw, false);
      com.tencent.mm.bk.a.a(localJSONObject, "CommentId", this.abNQ, false);
      com.tencent.mm.bk.a.a(localJSONObject, "OpType", Integer.valueOf(this.muC), false);
      com.tencent.mm.bk.a.a(localJSONObject, "RequestId", this.aaye, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Content", this.nUB, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Scene", Integer.valueOf(this.IJG), false);
      com.tencent.mm.bk.a.a(localJSONObject, "SearchId", this.aayf, false);
      com.tencent.mm.bk.a.a(localJSONObject, "SubScene", Integer.valueOf(this.YIc), false);
      com.tencent.mm.bk.a.a(localJSONObject, "Vid", this.vYo, false);
      com.tencent.mm.bk.a.a(localJSONObject, "ByPass", this.abuT, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Source", Integer.valueOf(this.IcB), false);
      label146:
      AppMethodBeat.o(258290);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label146;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117936);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abgw != null) {
        paramVarArgs.g(1, this.abgw);
      }
      if (this.abNQ != null) {
        paramVarArgs.g(2, this.abNQ);
      }
      paramVarArgs.bS(3, this.muC);
      if (this.aaye != null) {
        paramVarArgs.g(4, this.aaye);
      }
      if (this.nUB != null) {
        paramVarArgs.g(5, this.nUB);
      }
      paramVarArgs.bS(6, this.IJG);
      if (this.aayf != null) {
        paramVarArgs.g(7, this.aayf);
      }
      paramVarArgs.bS(8, this.YIc);
      if (this.vYo != null) {
        paramVarArgs.g(9, this.vYo);
      }
      if (this.abuT != null) {
        paramVarArgs.g(10, this.abuT);
      }
      paramVarArgs.bS(11, this.IcB);
      AppMethodBeat.o(117936);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abgw == null) {
        break label758;
      }
    }
    label758:
    for (paramInt = i.a.a.b.b.a.h(1, this.abgw) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.abNQ != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.abNQ);
      }
      i += i.a.a.b.b.a.cJ(3, this.muC);
      paramInt = i;
      if (this.aaye != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aaye);
      }
      i = paramInt;
      if (this.nUB != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.nUB);
      }
      i += i.a.a.b.b.a.cJ(6, this.IJG);
      paramInt = i;
      if (this.aayf != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.aayf);
      }
      i = paramInt + i.a.a.b.b.a.cJ(8, this.YIc);
      paramInt = i;
      if (this.vYo != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.vYo);
      }
      i = paramInt;
      if (this.abuT != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.abuT);
      }
      paramInt = i.a.a.b.b.a.cJ(11, this.IcB);
      AppMethodBeat.o(117936);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(117936);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        fnx localfnx = (fnx)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117936);
          return -1;
        case 1: 
          localfnx.abgw = locala.ajGk.readString();
          AppMethodBeat.o(117936);
          return 0;
        case 2: 
          localfnx.abNQ = locala.ajGk.readString();
          AppMethodBeat.o(117936);
          return 0;
        case 3: 
          localfnx.muC = locala.ajGk.aar();
          AppMethodBeat.o(117936);
          return 0;
        case 4: 
          localfnx.aaye = locala.ajGk.readString();
          AppMethodBeat.o(117936);
          return 0;
        case 5: 
          localfnx.nUB = locala.ajGk.readString();
          AppMethodBeat.o(117936);
          return 0;
        case 6: 
          localfnx.IJG = locala.ajGk.aar();
          AppMethodBeat.o(117936);
          return 0;
        case 7: 
          localfnx.aayf = locala.ajGk.readString();
          AppMethodBeat.o(117936);
          return 0;
        case 8: 
          localfnx.YIc = locala.ajGk.aar();
          AppMethodBeat.o(117936);
          return 0;
        case 9: 
          localfnx.vYo = locala.ajGk.readString();
          AppMethodBeat.o(117936);
          return 0;
        case 10: 
          localfnx.abuT = locala.ajGk.readString();
          AppMethodBeat.o(117936);
          return 0;
        }
        localfnx.IcB = locala.ajGk.aar();
        AppMethodBeat.o(117936);
        return 0;
      }
      AppMethodBeat.o(117936);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fnx
 * JD-Core Version:    0.7.0.1
 */