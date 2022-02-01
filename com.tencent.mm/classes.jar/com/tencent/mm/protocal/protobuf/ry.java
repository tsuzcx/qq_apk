package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class ry
  extends com.tencent.mm.bx.a
{
  public int PHe;
  public int Tqb;
  public int YWM;
  public int YWN;
  public String YWO;
  public int YWP;
  public int YWQ;
  public int YWR;
  public String YWS;
  public String appid;
  public String xmx;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(257502);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "appid", this.appid, false);
      com.tencent.mm.bk.a.a(localJSONObject, "version_type", Integer.valueOf(this.Tqb), false);
      com.tencent.mm.bk.a.a(localJSONObject, "app_version", Integer.valueOf(this.YWM), false);
      com.tencent.mm.bk.a.a(localJSONObject, "extinfo", this.xmx, false);
      com.tencent.mm.bk.a.a(localJSONObject, "appuin", Integer.valueOf(this.YWN), false);
      com.tencent.mm.bk.a.a(localJSONObject, "debugurl", this.YWO, false);
      com.tencent.mm.bk.a.a(localJSONObject, "isrefresh", Integer.valueOf(this.YWP), false);
      com.tencent.mm.bk.a.a(localJSONObject, "isdevtools", Integer.valueOf(this.YWQ), false);
      com.tencent.mm.bk.a.a(localJSONObject, "isusing_cached_location", Integer.valueOf(this.YWR), false);
      com.tencent.mm.bk.a.a(localJSONObject, "from_url", this.YWS, false);
      com.tencent.mm.bk.a.a(localJSONObject, "screen_width", Integer.valueOf(this.PHe), false);
      label155:
      AppMethodBeat.o(257502);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label155;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117838);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.appid != null) {
        paramVarArgs.g(1, this.appid);
      }
      paramVarArgs.bS(2, this.Tqb);
      paramVarArgs.bS(3, this.YWM);
      if (this.xmx != null) {
        paramVarArgs.g(4, this.xmx);
      }
      paramVarArgs.bS(5, this.YWN);
      if (this.YWO != null) {
        paramVarArgs.g(6, this.YWO);
      }
      paramVarArgs.bS(7, this.YWP);
      paramVarArgs.bS(8, this.YWQ);
      paramVarArgs.bS(9, this.YWR);
      if (this.YWS != null) {
        paramVarArgs.g(10, this.YWS);
      }
      paramVarArgs.bS(15, this.PHe);
      AppMethodBeat.o(117838);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appid == null) {
        break label722;
      }
    }
    label722:
    for (paramInt = i.a.a.b.b.a.h(1, this.appid) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.Tqb) + i.a.a.b.b.a.cJ(3, this.YWM);
      paramInt = i;
      if (this.xmx != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.xmx);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.YWN);
      paramInt = i;
      if (this.YWO != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.YWO);
      }
      i = paramInt + i.a.a.b.b.a.cJ(7, this.YWP) + i.a.a.b.b.a.cJ(8, this.YWQ) + i.a.a.b.b.a.cJ(9, this.YWR);
      paramInt = i;
      if (this.YWS != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.YWS);
      }
      i = i.a.a.b.b.a.cJ(15, this.PHe);
      AppMethodBeat.o(117838);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(117838);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        ry localry = (ry)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        case 11: 
        case 12: 
        case 13: 
        case 14: 
        default: 
          AppMethodBeat.o(117838);
          return -1;
        case 1: 
          localry.appid = locala.ajGk.readString();
          AppMethodBeat.o(117838);
          return 0;
        case 2: 
          localry.Tqb = locala.ajGk.aar();
          AppMethodBeat.o(117838);
          return 0;
        case 3: 
          localry.YWM = locala.ajGk.aar();
          AppMethodBeat.o(117838);
          return 0;
        case 4: 
          localry.xmx = locala.ajGk.readString();
          AppMethodBeat.o(117838);
          return 0;
        case 5: 
          localry.YWN = locala.ajGk.aar();
          AppMethodBeat.o(117838);
          return 0;
        case 6: 
          localry.YWO = locala.ajGk.readString();
          AppMethodBeat.o(117838);
          return 0;
        case 7: 
          localry.YWP = locala.ajGk.aar();
          AppMethodBeat.o(117838);
          return 0;
        case 8: 
          localry.YWQ = locala.ajGk.aar();
          AppMethodBeat.o(117838);
          return 0;
        case 9: 
          localry.YWR = locala.ajGk.aar();
          AppMethodBeat.o(117838);
          return 0;
        case 10: 
          localry.YWS = locala.ajGk.readString();
          AppMethodBeat.o(117838);
          return 0;
        }
        localry.PHe = locala.ajGk.aar();
        AppMethodBeat.o(117838);
        return 0;
      }
      AppMethodBeat.o(117838);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ry
 * JD-Core Version:    0.7.0.1
 */