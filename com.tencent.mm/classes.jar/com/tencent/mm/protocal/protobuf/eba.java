package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONObject;

public final class eba
  extends com.tencent.mm.bx.a
{
  public int IJG;
  public int IKW;
  public String SessionId;
  public String YWK;
  public dhb aaLr;
  public acm aaLs;
  public int aayc;
  public String aaye;
  public int abgA;
  public String abgx;
  public int abgy;
  public int abgz;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(258181);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "Query", this.YWK, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Location", this.aaLr, false);
      com.tencent.mm.bk.a.a(localJSONObject, "SessionId", this.SessionId, false);
      com.tencent.mm.bk.a.a(localJSONObject, "RequestId", this.aaye, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Source", this.abgx, false);
      com.tencent.mm.bk.a.a(localJSONObject, "PardusSwitch", Integer.valueOf(this.abgy), false);
      com.tencent.mm.bk.a.a(localJSONObject, "H5Version", Integer.valueOf(this.aayc), false);
      com.tencent.mm.bk.a.a(localJSONObject, "DarkMode", Integer.valueOf(this.abgz), false);
      com.tencent.mm.bk.a.a(localJSONObject, "Scene", Integer.valueOf(this.IJG), false);
      com.tencent.mm.bk.a.a(localJSONObject, "BusinessType", Integer.valueOf(this.IKW), false);
      com.tencent.mm.bk.a.a(localJSONObject, "ChildMode", this.aaLs, false);
      com.tencent.mm.bk.a.a(localJSONObject, "WebSearchH5Version", Integer.valueOf(this.abgA), false);
      label163:
      AppMethodBeat.o(258181);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label163;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117889);
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
      if (this.SessionId != null) {
        paramVarArgs.g(3, this.SessionId);
      }
      if (this.aaye != null) {
        paramVarArgs.g(4, this.aaye);
      }
      if (this.abgx != null) {
        paramVarArgs.g(5, this.abgx);
      }
      paramVarArgs.bS(6, this.abgy);
      paramVarArgs.bS(7, this.aayc);
      paramVarArgs.bS(8, this.abgz);
      paramVarArgs.bS(9, this.IJG);
      paramVarArgs.bS(10, this.IKW);
      if (this.aaLs != null)
      {
        paramVarArgs.qD(11, this.aaLs.computeSize());
        this.aaLs.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(12, this.abgA);
      AppMethodBeat.o(117889);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YWK == null) {
        break label926;
      }
    }
    label926:
    for (int i = i.a.a.b.b.a.h(1, this.YWK) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aaLr != null) {
        paramInt = i + i.a.a.a.qC(2, this.aaLr.computeSize());
      }
      i = paramInt;
      if (this.SessionId != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.SessionId);
      }
      paramInt = i;
      if (this.aaye != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aaye);
      }
      i = paramInt;
      if (this.abgx != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.abgx);
      }
      i = i + i.a.a.b.b.a.cJ(6, this.abgy) + i.a.a.b.b.a.cJ(7, this.aayc) + i.a.a.b.b.a.cJ(8, this.abgz) + i.a.a.b.b.a.cJ(9, this.IJG) + i.a.a.b.b.a.cJ(10, this.IKW);
      paramInt = i;
      if (this.aaLs != null) {
        paramInt = i + i.a.a.a.qC(11, this.aaLs.computeSize());
      }
      i = i.a.a.b.b.a.cJ(12, this.abgA);
      AppMethodBeat.o(117889);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(117889);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        eba localeba = (eba)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117889);
          return -1;
        case 1: 
          localeba.YWK = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(117889);
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
            localeba.aaLr = ((dhb)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(117889);
          return 0;
        case 3: 
          localeba.SessionId = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(117889);
          return 0;
        case 4: 
          localeba.aaye = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(117889);
          return 0;
        case 5: 
          localeba.abgx = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(117889);
          return 0;
        case 6: 
          localeba.abgy = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(117889);
          return 0;
        case 7: 
          localeba.aayc = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(117889);
          return 0;
        case 8: 
          localeba.abgz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(117889);
          return 0;
        case 9: 
          localeba.IJG = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(117889);
          return 0;
        case 10: 
          localeba.IKW = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(117889);
          return 0;
        case 11: 
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
            localeba.aaLs = ((acm)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(117889);
          return 0;
        }
        localeba.abgA = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(117889);
        return 0;
      }
      AppMethodBeat.o(117889);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eba
 * JD-Core Version:    0.7.0.1
 */