package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import org.json.JSONObject;

public final class tc
  extends com.tencent.mm.bx.a
{
  public String Url;
  public String YYA;
  public int YYB;
  public String YYx;
  public String YYy;
  public int YYz;
  public String hAP;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(259497);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "Title", this.hAP, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Url", this.Url, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Position", this.YYx, false);
      com.tencent.mm.bk.a.a(localJSONObject, "DetailInfo", this.YYy, false);
      com.tencent.mm.bk.a.a(localJSONObject, "StarLevel", Integer.valueOf(this.YYz), false);
      com.tencent.mm.bk.a.a(localJSONObject, "Average", this.YYA, false);
      com.tencent.mm.bk.a.a(localJSONObject, "PoiFlag", Integer.valueOf(this.YYB), false);
      label96:
      AppMethodBeat.o(259497);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label96;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117846);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.hAP == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(117846);
        throw paramVarArgs;
      }
      if (this.Url == null)
      {
        paramVarArgs = new b("Not all required fields were included: Url");
        AppMethodBeat.o(117846);
        throw paramVarArgs;
      }
      if (this.YYx == null)
      {
        paramVarArgs = new b("Not all required fields were included: Position");
        AppMethodBeat.o(117846);
        throw paramVarArgs;
      }
      if (this.YYy == null)
      {
        paramVarArgs = new b("Not all required fields were included: DetailInfo");
        AppMethodBeat.o(117846);
        throw paramVarArgs;
      }
      if (this.hAP != null) {
        paramVarArgs.g(1, this.hAP);
      }
      if (this.Url != null) {
        paramVarArgs.g(2, this.Url);
      }
      if (this.YYx != null) {
        paramVarArgs.g(3, this.YYx);
      }
      if (this.YYy != null) {
        paramVarArgs.g(4, this.YYy);
      }
      paramVarArgs.bS(5, this.YYz);
      if (this.YYA != null) {
        paramVarArgs.g(6, this.YYA);
      }
      paramVarArgs.bS(7, this.YYB);
      AppMethodBeat.o(117846);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hAP == null) {
        break label734;
      }
    }
    label734:
    for (int i = i.a.a.b.b.a.h(1, this.hAP) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.Url);
      }
      i = paramInt;
      if (this.YYx != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YYx);
      }
      paramInt = i;
      if (this.YYy != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.YYy);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.YYz);
      paramInt = i;
      if (this.YYA != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.YYA);
      }
      i = i.a.a.b.b.a.cJ(7, this.YYB);
      AppMethodBeat.o(117846);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.hAP == null)
        {
          paramVarArgs = new b("Not all required fields were included: Title");
          AppMethodBeat.o(117846);
          throw paramVarArgs;
        }
        if (this.Url == null)
        {
          paramVarArgs = new b("Not all required fields were included: Url");
          AppMethodBeat.o(117846);
          throw paramVarArgs;
        }
        if (this.YYx == null)
        {
          paramVarArgs = new b("Not all required fields were included: Position");
          AppMethodBeat.o(117846);
          throw paramVarArgs;
        }
        if (this.YYy == null)
        {
          paramVarArgs = new b("Not all required fields were included: DetailInfo");
          AppMethodBeat.o(117846);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117846);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        tc localtc = (tc)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117846);
          return -1;
        case 1: 
          localtc.hAP = locala.ajGk.readString();
          AppMethodBeat.o(117846);
          return 0;
        case 2: 
          localtc.Url = locala.ajGk.readString();
          AppMethodBeat.o(117846);
          return 0;
        case 3: 
          localtc.YYx = locala.ajGk.readString();
          AppMethodBeat.o(117846);
          return 0;
        case 4: 
          localtc.YYy = locala.ajGk.readString();
          AppMethodBeat.o(117846);
          return 0;
        case 5: 
          localtc.YYz = locala.ajGk.aar();
          AppMethodBeat.o(117846);
          return 0;
        case 6: 
          localtc.YYA = locala.ajGk.readString();
          AppMethodBeat.o(117846);
          return 0;
        }
        localtc.YYB = locala.ajGk.aar();
        AppMethodBeat.o(117846);
        return 0;
      }
      AppMethodBeat.o(117846);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tc
 * JD-Core Version:    0.7.0.1
 */