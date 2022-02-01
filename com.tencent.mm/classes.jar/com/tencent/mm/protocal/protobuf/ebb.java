package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONObject;

public final class ebb
  extends esc
{
  public fkl aaLt;
  public String aayf;
  public LinkedList<te> abgB;
  public String abgC;
  public String abgD;
  public String abgE;
  public fkl abgF;
  public String abgG;
  
  public ebb()
  {
    AppMethodBeat.i(117890);
    this.abgB = new LinkedList();
    AppMethodBeat.o(117890);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117891);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.aayf != null) {
        paramVarArgs.g(2, this.aayf);
      }
      if (this.aaLt != null)
      {
        paramVarArgs.qD(3, this.aaLt.computeSize());
        this.aaLt.writeFields(paramVarArgs);
      }
      paramVarArgs.e(4, 8, this.abgB);
      if (this.abgC != null) {
        paramVarArgs.g(5, this.abgC);
      }
      if (this.abgD != null) {
        paramVarArgs.g(6, this.abgD);
      }
      if (this.abgE != null) {
        paramVarArgs.g(7, this.abgE);
      }
      if (this.abgF != null)
      {
        paramVarArgs.qD(8, this.abgF.computeSize());
        this.abgF.writeFields(paramVarArgs);
      }
      if (this.abgG != null) {
        paramVarArgs.g(9, this.abgG);
      }
      AppMethodBeat.o(117891);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label978;
      }
    }
    label978:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aayf != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.aayf);
      }
      i = paramInt;
      if (this.aaLt != null) {
        i = paramInt + i.a.a.a.qC(3, this.aaLt.computeSize());
      }
      i += i.a.a.a.c(4, 8, this.abgB);
      paramInt = i;
      if (this.abgC != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.abgC);
      }
      i = paramInt;
      if (this.abgD != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.abgD);
      }
      paramInt = i;
      if (this.abgE != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.abgE);
      }
      i = paramInt;
      if (this.abgF != null) {
        i = paramInt + i.a.a.a.qC(8, this.abgF.computeSize());
      }
      paramInt = i;
      if (this.abgG != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.abgG);
      }
      AppMethodBeat.o(117891);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abgB.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(117891);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ebb localebb = (ebb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117891);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localebb.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(117891);
          return 0;
        case 2: 
          localebb.aayf = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(117891);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fkl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fkl)localObject2).parseFrom((byte[])localObject1);
            }
            localebb.aaLt = ((fkl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(117891);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new te();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((te)localObject2).parseFrom((byte[])localObject1);
            }
            localebb.abgB.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(117891);
          return 0;
        case 5: 
          localebb.abgC = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(117891);
          return 0;
        case 6: 
          localebb.abgD = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(117891);
          return 0;
        case 7: 
          localebb.abgE = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(117891);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fkl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fkl)localObject2).parseFrom((byte[])localObject1);
            }
            localebb.abgF = ((fkl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(117891);
          return 0;
        }
        localebb.abgG = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(117891);
        return 0;
      }
      AppMethodBeat.o(117891);
      return -1;
    }
  }
  
  public final JSONObject toJSON()
  {
    AppMethodBeat.i(258169);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "BaseResponse", this.BaseResponse, false);
      com.tencent.mm.bk.a.a(localJSONObject, "SearchId", this.aayf, false);
      com.tencent.mm.bk.a.a(localJSONObject, "SugResult", this.aaLt, false);
      com.tencent.mm.bk.a.a(localJSONObject, "BusinessResults", this.abgB, false);
      com.tencent.mm.bk.a.a(localJSONObject, "MoreText", this.abgC, false);
      com.tencent.mm.bk.a.a(localJSONObject, "GuideText", this.abgD, false);
      com.tencent.mm.bk.a.a(localJSONObject, "PardusInfo", this.abgE, false);
      com.tencent.mm.bk.a.a(localJSONObject, "ReletedResult", this.abgF, false);
      com.tencent.mm.bk.a.a(localJSONObject, "JsonResult", this.abgG, false);
      label112:
      AppMethodBeat.o(258169);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label112;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebb
 * JD-Core Version:    0.7.0.1
 */