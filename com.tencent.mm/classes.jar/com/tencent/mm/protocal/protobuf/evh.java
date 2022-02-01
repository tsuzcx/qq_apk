package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;
import org.json.JSONObject;

public final class evh
  extends com.tencent.mm.bx.a
{
  public int IJG;
  public long YYo;
  public String YYr;
  public int YYs;
  public dhb aaLr;
  public String aaqW;
  public int abyb;
  public LinkedList<fvd> abyc;
  
  public evh()
  {
    AppMethodBeat.i(117908);
    this.abyc = new LinkedList();
    AppMethodBeat.o(117908);
  }
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(257379);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "BusinessType", Long.valueOf(this.YYo), false);
      com.tencent.mm.bk.a.a(localJSONObject, "KeyWord", this.aaqW, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Offset", Integer.valueOf(this.YYs), false);
      com.tencent.mm.bk.a.a(localJSONObject, "Location", this.aaLr, false);
      com.tencent.mm.bk.a.a(localJSONObject, "RequestSrc", Integer.valueOf(this.abyb), false);
      com.tencent.mm.bk.a.a(localJSONObject, "MatchUserList", this.abyc, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Scene", Integer.valueOf(this.IJG), false);
      com.tencent.mm.bk.a.a(localJSONObject, "SearchID", this.YYr, false);
      label113:
      AppMethodBeat.o(257379);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label113;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117909);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaqW == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyWord");
        AppMethodBeat.o(117909);
        throw paramVarArgs;
      }
      paramVarArgs.bv(1, this.YYo);
      if (this.aaqW != null) {
        paramVarArgs.g(2, this.aaqW);
      }
      paramVarArgs.bS(3, this.YYs);
      if (this.aaLr != null)
      {
        paramVarArgs.qD(4, this.aaLr.computeSize());
        this.aaLr.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(5, this.abyb);
      paramVarArgs.e(6, 8, this.abyc);
      paramVarArgs.bS(7, this.IJG);
      if (this.YYr != null) {
        paramVarArgs.g(8, this.YYr);
      }
      AppMethodBeat.o(117909);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(1, this.YYo) + 0;
      paramInt = i;
      if (this.aaqW != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.aaqW);
      }
      i = paramInt + i.a.a.b.b.a.cJ(3, this.YYs);
      paramInt = i;
      if (this.aaLr != null) {
        paramInt = i + i.a.a.a.qC(4, this.aaLr.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.abyb) + i.a.a.a.c(6, 8, this.abyc) + i.a.a.b.b.a.cJ(7, this.IJG);
      paramInt = i;
      if (this.YYr != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.YYr);
      }
      AppMethodBeat.o(117909);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.abyc.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      if (this.aaqW == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyWord");
        AppMethodBeat.o(117909);
        throw paramVarArgs;
      }
      AppMethodBeat.o(117909);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      evh localevh = (evh)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117909);
        return -1;
      case 1: 
        localevh.YYo = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(117909);
        return 0;
      case 2: 
        localevh.aaqW = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(117909);
        return 0;
      case 3: 
        localevh.YYs = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(117909);
        return 0;
      case 4: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dhb();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dhb)localObject2).parseFrom((byte[])localObject1);
          }
          localevh.aaLr = ((dhb)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(117909);
        return 0;
      case 5: 
        localevh.abyb = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(117909);
        return 0;
      case 6: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fvd();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fvd)localObject2).parseFrom((byte[])localObject1);
          }
          localevh.abyc.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(117909);
        return 0;
      case 7: 
        localevh.IJG = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(117909);
        return 0;
      }
      localevh.YYr = ((i.a.a.a.a)localObject1).ajGk.readString();
      AppMethodBeat.o(117909);
      return 0;
    }
    AppMethodBeat.o(117909);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.evh
 * JD-Core Version:    0.7.0.1
 */