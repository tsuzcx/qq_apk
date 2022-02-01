package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class fnv
  extends com.tencent.mm.bx.a
{
  public int IJG;
  public int IcB;
  public int YIc;
  public String aaiG;
  public String aaye;
  public String aayf;
  public String abNO;
  public String abNP;
  public String abgw;
  public String abuT;
  public String hAP;
  public String nUB;
  public String vYo;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(258266);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "RequestId", this.aaye, false);
      com.tencent.mm.bk.a.a(localJSONObject, "DocId", this.abgw, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Content", this.nUB, false);
      com.tencent.mm.bk.a.a(localJSONObject, "ReplyId", this.abNO, false);
      com.tencent.mm.bk.a.a(localJSONObject, "SubReplyId", this.abNP, false);
      com.tencent.mm.bk.a.a(localJSONObject, "DocUrl", this.aaiG, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Title", this.hAP, false);
      com.tencent.mm.bk.a.a(localJSONObject, "SearchId", this.aayf, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Scene", Integer.valueOf(this.IJG), false);
      com.tencent.mm.bk.a.a(localJSONObject, "SubScene", Integer.valueOf(this.YIc), false);
      com.tencent.mm.bk.a.a(localJSONObject, "ByPass", this.abuT, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Vid", this.vYo, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Source", Integer.valueOf(this.IcB), false);
      label165:
      AppMethodBeat.o(258266);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label165;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117934);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaye != null) {
        paramVarArgs.g(1, this.aaye);
      }
      if (this.abgw != null) {
        paramVarArgs.g(2, this.abgw);
      }
      if (this.nUB != null) {
        paramVarArgs.g(3, this.nUB);
      }
      if (this.abNO != null) {
        paramVarArgs.g(4, this.abNO);
      }
      if (this.abNP != null) {
        paramVarArgs.g(5, this.abNP);
      }
      if (this.aaiG != null) {
        paramVarArgs.g(6, this.aaiG);
      }
      if (this.hAP != null) {
        paramVarArgs.g(7, this.hAP);
      }
      if (this.aayf != null) {
        paramVarArgs.g(8, this.aayf);
      }
      paramVarArgs.bS(9, this.IJG);
      paramVarArgs.bS(10, this.YIc);
      if (this.abuT != null) {
        paramVarArgs.g(11, this.abuT);
      }
      if (this.vYo != null) {
        paramVarArgs.g(12, this.vYo);
      }
      paramVarArgs.bS(13, this.IcB);
      AppMethodBeat.o(117934);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aaye == null) {
        break label898;
      }
    }
    label898:
    for (int i = i.a.a.b.b.a.h(1, this.aaye) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abgw != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.abgw);
      }
      i = paramInt;
      if (this.nUB != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.nUB);
      }
      paramInt = i;
      if (this.abNO != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.abNO);
      }
      i = paramInt;
      if (this.abNP != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.abNP);
      }
      paramInt = i;
      if (this.aaiG != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.aaiG);
      }
      i = paramInt;
      if (this.hAP != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.hAP);
      }
      paramInt = i;
      if (this.aayf != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.aayf);
      }
      i = paramInt + i.a.a.b.b.a.cJ(9, this.IJG) + i.a.a.b.b.a.cJ(10, this.YIc);
      paramInt = i;
      if (this.abuT != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.abuT);
      }
      i = paramInt;
      if (this.vYo != null) {
        i = paramInt + i.a.a.b.b.a.h(12, this.vYo);
      }
      paramInt = i.a.a.b.b.a.cJ(13, this.IcB);
      AppMethodBeat.o(117934);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(117934);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        fnv localfnv = (fnv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117934);
          return -1;
        case 1: 
          localfnv.aaye = locala.ajGk.readString();
          AppMethodBeat.o(117934);
          return 0;
        case 2: 
          localfnv.abgw = locala.ajGk.readString();
          AppMethodBeat.o(117934);
          return 0;
        case 3: 
          localfnv.nUB = locala.ajGk.readString();
          AppMethodBeat.o(117934);
          return 0;
        case 4: 
          localfnv.abNO = locala.ajGk.readString();
          AppMethodBeat.o(117934);
          return 0;
        case 5: 
          localfnv.abNP = locala.ajGk.readString();
          AppMethodBeat.o(117934);
          return 0;
        case 6: 
          localfnv.aaiG = locala.ajGk.readString();
          AppMethodBeat.o(117934);
          return 0;
        case 7: 
          localfnv.hAP = locala.ajGk.readString();
          AppMethodBeat.o(117934);
          return 0;
        case 8: 
          localfnv.aayf = locala.ajGk.readString();
          AppMethodBeat.o(117934);
          return 0;
        case 9: 
          localfnv.IJG = locala.ajGk.aar();
          AppMethodBeat.o(117934);
          return 0;
        case 10: 
          localfnv.YIc = locala.ajGk.aar();
          AppMethodBeat.o(117934);
          return 0;
        case 11: 
          localfnv.abuT = locala.ajGk.readString();
          AppMethodBeat.o(117934);
          return 0;
        case 12: 
          localfnv.vYo = locala.ajGk.readString();
          AppMethodBeat.o(117934);
          return 0;
        }
        localfnv.IcB = locala.ajGk.aar();
        AppMethodBeat.o(117934);
        return 0;
      }
      AppMethodBeat.o(117934);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fnv
 * JD-Core Version:    0.7.0.1
 */