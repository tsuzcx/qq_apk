package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;
import org.json.JSONObject;

public class gjz
  extends esc
{
  public fvg acfT;
  public LinkedList<hu> acfU;
  public gnd acfV;
  
  public gjz()
  {
    AppMethodBeat.i(147821);
    this.acfU = new LinkedList();
    AppMethodBeat.o(147821);
  }
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(258136);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "BaseResponse", this.BaseResponse, false);
      com.tencent.mm.bk.a.a(localJSONObject, "userMgrBaseResp", this.acfT, false);
      com.tencent.mm.bk.a.a(localJSONObject, "authItem", this.acfU, false);
      com.tencent.mm.bk.a.a(localJSONObject, "use_user_info", this.acfV, false);
      label57:
      AppMethodBeat.o(258136);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label57;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147822);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(147822);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.acfT != null)
      {
        paramVarArgs.qD(2, this.acfT.computeSize());
        this.acfT.writeFields(paramVarArgs);
      }
      paramVarArgs.e(3, 8, this.acfU);
      if (this.acfV != null)
      {
        paramVarArgs.qD(4, this.acfV.computeSize());
        this.acfV.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(147822);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label718;
      }
    }
    label718:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.acfT != null) {
        i = paramInt + i.a.a.a.qC(2, this.acfT.computeSize());
      }
      i += i.a.a.a.c(3, 8, this.acfU);
      paramInt = i;
      if (this.acfV != null) {
        paramInt = i + i.a.a.a.qC(4, this.acfV.computeSize());
      }
      AppMethodBeat.o(147822);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.acfU.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(147822);
          throw paramVarArgs;
        }
        AppMethodBeat.o(147822);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        gjz localgjz = (gjz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(147822);
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
            localgjz.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(147822);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fvg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fvg)localObject2).parseFrom((byte[])localObject1);
            }
            localgjz.acfT = ((fvg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(147822);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new hu();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((hu)localObject2).parseFrom((byte[])localObject1);
            }
            localgjz.acfU.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(147822);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new gnd();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((gnd)localObject2).parseFrom((byte[])localObject1);
          }
          localgjz.acfV = ((gnd)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(147822);
        return 0;
      }
      AppMethodBeat.o(147822);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gjz
 * JD-Core Version:    0.7.0.1
 */