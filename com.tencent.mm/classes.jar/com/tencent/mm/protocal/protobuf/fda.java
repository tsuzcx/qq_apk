package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import org.json.JSONObject;

public final class fda
  extends com.tencent.mm.bx.a
{
  public int IJG;
  public String Url;
  public int abCA;
  public int abCB;
  public String abCq;
  public String abCr;
  public String abCs;
  public int abCt;
  public String abCu;
  public String abCv;
  public String abCw;
  public int abCx;
  public int abCy;
  public int abCz;
  public String hAP;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(258869);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "PickedWord", this.abCq, false);
      com.tencent.mm.bk.a.a(localJSONObject, "PrefixText", this.abCr, false);
      com.tencent.mm.bk.a.a(localJSONObject, "SuffixText", this.abCs, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Scene", Integer.valueOf(this.IJG), false);
      com.tencent.mm.bk.a.a(localJSONObject, "MainIndex", Integer.valueOf(this.abCt), false);
      com.tencent.mm.bk.a.a(localJSONObject, "Url", this.Url, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Title", this.hAP, false);
      com.tencent.mm.bk.a.a(localJSONObject, "SubPickedWord", this.abCu, false);
      com.tencent.mm.bk.a.a(localJSONObject, "SubPrefixText", this.abCv, false);
      com.tencent.mm.bk.a.a(localJSONObject, "SubSuffixText", this.abCw, false);
      com.tencent.mm.bk.a.a(localJSONObject, "SubIndex", Integer.valueOf(this.abCx), false);
      com.tencent.mm.bk.a.a(localJSONObject, "TagNewLineBefore", Integer.valueOf(this.abCy), false);
      com.tencent.mm.bk.a.a(localJSONObject, "TagNewLineAfter", Integer.valueOf(this.abCz), false);
      com.tencent.mm.bk.a.a(localJSONObject, "TagNewLineBeforeSub", Integer.valueOf(this.abCA), false);
      com.tencent.mm.bk.a.a(localJSONObject, "TagNewLineAfterSub", Integer.valueOf(this.abCB), false);
      label199:
      AppMethodBeat.o(258869);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label199;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117927);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abCq == null)
      {
        paramVarArgs = new b("Not all required fields were included: PickedWord");
        AppMethodBeat.o(117927);
        throw paramVarArgs;
      }
      if (this.abCq != null) {
        paramVarArgs.g(1, this.abCq);
      }
      if (this.abCr != null) {
        paramVarArgs.g(2, this.abCr);
      }
      if (this.abCs != null) {
        paramVarArgs.g(3, this.abCs);
      }
      paramVarArgs.bS(4, this.IJG);
      paramVarArgs.bS(5, this.abCt);
      if (this.Url != null) {
        paramVarArgs.g(6, this.Url);
      }
      if (this.hAP != null) {
        paramVarArgs.g(7, this.hAP);
      }
      if (this.abCu != null) {
        paramVarArgs.g(8, this.abCu);
      }
      if (this.abCv != null) {
        paramVarArgs.g(9, this.abCv);
      }
      if (this.abCw != null) {
        paramVarArgs.g(10, this.abCw);
      }
      paramVarArgs.bS(11, this.abCx);
      paramVarArgs.bS(12, this.abCy);
      paramVarArgs.bS(13, this.abCz);
      paramVarArgs.bS(14, this.abCA);
      paramVarArgs.bS(15, this.abCB);
      AppMethodBeat.o(117927);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abCq == null) {
        break label1014;
      }
    }
    label1014:
    for (int i = i.a.a.b.b.a.h(1, this.abCq) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abCr != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.abCr);
      }
      i = paramInt;
      if (this.abCs != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.abCs);
      }
      i = i + i.a.a.b.b.a.cJ(4, this.IJG) + i.a.a.b.b.a.cJ(5, this.abCt);
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.Url);
      }
      i = paramInt;
      if (this.hAP != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.hAP);
      }
      paramInt = i;
      if (this.abCu != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.abCu);
      }
      i = paramInt;
      if (this.abCv != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.abCv);
      }
      paramInt = i;
      if (this.abCw != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.abCw);
      }
      i = i.a.a.b.b.a.cJ(11, this.abCx);
      int j = i.a.a.b.b.a.cJ(12, this.abCy);
      int k = i.a.a.b.b.a.cJ(13, this.abCz);
      int m = i.a.a.b.b.a.cJ(14, this.abCA);
      int n = i.a.a.b.b.a.cJ(15, this.abCB);
      AppMethodBeat.o(117927);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.abCq == null)
        {
          paramVarArgs = new b("Not all required fields were included: PickedWord");
          AppMethodBeat.o(117927);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117927);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        fda localfda = (fda)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117927);
          return -1;
        case 1: 
          localfda.abCq = locala.ajGk.readString();
          AppMethodBeat.o(117927);
          return 0;
        case 2: 
          localfda.abCr = locala.ajGk.readString();
          AppMethodBeat.o(117927);
          return 0;
        case 3: 
          localfda.abCs = locala.ajGk.readString();
          AppMethodBeat.o(117927);
          return 0;
        case 4: 
          localfda.IJG = locala.ajGk.aar();
          AppMethodBeat.o(117927);
          return 0;
        case 5: 
          localfda.abCt = locala.ajGk.aar();
          AppMethodBeat.o(117927);
          return 0;
        case 6: 
          localfda.Url = locala.ajGk.readString();
          AppMethodBeat.o(117927);
          return 0;
        case 7: 
          localfda.hAP = locala.ajGk.readString();
          AppMethodBeat.o(117927);
          return 0;
        case 8: 
          localfda.abCu = locala.ajGk.readString();
          AppMethodBeat.o(117927);
          return 0;
        case 9: 
          localfda.abCv = locala.ajGk.readString();
          AppMethodBeat.o(117927);
          return 0;
        case 10: 
          localfda.abCw = locala.ajGk.readString();
          AppMethodBeat.o(117927);
          return 0;
        case 11: 
          localfda.abCx = locala.ajGk.aar();
          AppMethodBeat.o(117927);
          return 0;
        case 12: 
          localfda.abCy = locala.ajGk.aar();
          AppMethodBeat.o(117927);
          return 0;
        case 13: 
          localfda.abCz = locala.ajGk.aar();
          AppMethodBeat.o(117927);
          return 0;
        case 14: 
          localfda.abCA = locala.ajGk.aar();
          AppMethodBeat.o(117927);
          return 0;
        }
        localfda.abCB = locala.ajGk.aar();
        AppMethodBeat.o(117927);
        return 0;
      }
      AppMethodBeat.o(117927);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fda
 * JD-Core Version:    0.7.0.1
 */