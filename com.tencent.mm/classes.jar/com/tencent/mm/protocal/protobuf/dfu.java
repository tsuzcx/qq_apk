package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONObject;

public final class dfu
  extends com.tencent.mm.bx.a
{
  public int IJG;
  public String SessionId;
  public String YWK;
  public dhb aaLr;
  public acm aaLs;
  public int aayc;
  public String aaye;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(258164);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "Query", this.YWK, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Location", this.aaLr, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Scene", Integer.valueOf(this.IJG), false);
      com.tencent.mm.bk.a.a(localJSONObject, "ChildMode", this.aaLs, false);
      com.tencent.mm.bk.a.a(localJSONObject, "H5Version", Integer.valueOf(this.aayc), false);
      com.tencent.mm.bk.a.a(localJSONObject, "RequestId", this.aaye, false);
      com.tencent.mm.bk.a.a(localJSONObject, "SessionId", this.SessionId, false);
      label96:
      AppMethodBeat.o(258164);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label96;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258174);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YWK != null) {
        paramVarArgs.g(1, this.YWK);
      }
      if (this.aaLr != null)
      {
        paramVarArgs.qD(2, this.aaLr.computeSize());
        this.aaLr.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(3, this.IJG);
      if (this.aaLs != null)
      {
        paramVarArgs.qD(4, this.aaLs.computeSize());
        this.aaLs.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(5, this.aayc);
      if (this.aaye != null) {
        paramVarArgs.g(6, this.aaye);
      }
      if (this.SessionId != null) {
        paramVarArgs.g(7, this.SessionId);
      }
      AppMethodBeat.o(258174);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YWK == null) {
        break label690;
      }
    }
    label690:
    for (paramInt = i.a.a.b.b.a.h(1, this.YWK) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.aaLr != null) {
        i = paramInt + i.a.a.a.qC(2, this.aaLr.computeSize());
      }
      i += i.a.a.b.b.a.cJ(3, this.IJG);
      paramInt = i;
      if (this.aaLs != null) {
        paramInt = i + i.a.a.a.qC(4, this.aaLs.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.aayc);
      paramInt = i;
      if (this.aaye != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.aaye);
      }
      i = paramInt;
      if (this.SessionId != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.SessionId);
      }
      AppMethodBeat.o(258174);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258174);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dfu localdfu = (dfu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258174);
          return -1;
        case 1: 
          localdfu.YWK = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258174);
          return 0;
        case 2: 
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
            localdfu.aaLr = ((dhb)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258174);
          return 0;
        case 3: 
          localdfu.IJG = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258174);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new acm();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((acm)localObject2).parseFrom((byte[])localObject1);
            }
            localdfu.aaLs = ((acm)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258174);
          return 0;
        case 5: 
          localdfu.aayc = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258174);
          return 0;
        case 6: 
          localdfu.aaye = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258174);
          return 0;
        }
        localdfu.SessionId = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(258174);
        return 0;
      }
      AppMethodBeat.o(258174);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dfu
 * JD-Core Version:    0.7.0.1
 */