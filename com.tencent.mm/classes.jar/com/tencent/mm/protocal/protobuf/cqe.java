package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;
import org.json.JSONObject;

public class cqe
  extends esc
{
  public dqk aawJ;
  public fvb aawK;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(259157);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "BaseResponse", this.BaseResponse, false);
      com.tencent.mm.bk.a.a(localJSONObject, "UserInfo", this.aawJ, false);
      com.tencent.mm.bk.a.a(localJSONObject, "UserInfoExt", this.aawK, false);
      label46:
      AppMethodBeat.o(259157);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label46;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(134246);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(134246);
        throw paramVarArgs;
      }
      if (this.aawJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserInfo");
        AppMethodBeat.o(134246);
        throw paramVarArgs;
      }
      if (this.aawK == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserInfoExt");
        AppMethodBeat.o(134246);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.aawJ != null)
      {
        paramVarArgs.qD(2, this.aawJ.computeSize());
        this.aawJ.writeFields(paramVarArgs);
      }
      if (this.aawK != null)
      {
        paramVarArgs.qD(3, this.aawK.computeSize());
        this.aawK.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(134246);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label692;
      }
    }
    label692:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aawJ != null) {
        paramInt = i + i.a.a.a.qC(2, this.aawJ.computeSize());
      }
      i = paramInt;
      if (this.aawK != null) {
        i = paramInt + i.a.a.a.qC(3, this.aawK.computeSize());
      }
      AppMethodBeat.o(134246);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(134246);
          throw paramVarArgs;
        }
        if (this.aawJ == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserInfo");
          AppMethodBeat.o(134246);
          throw paramVarArgs;
        }
        if (this.aawK == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserInfoExt");
          AppMethodBeat.o(134246);
          throw paramVarArgs;
        }
        AppMethodBeat.o(134246);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cqe localcqe = (cqe)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(134246);
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
            localcqe.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(134246);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dqk();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dqk)localObject2).parseFrom((byte[])localObject1);
            }
            localcqe.aawJ = ((dqk)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(134246);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fvb();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fvb)localObject2).parseFrom((byte[])localObject1);
          }
          localcqe.aawK = ((fvb)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(134246);
        return 0;
      }
      AppMethodBeat.o(134246);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqe
 * JD-Core Version:    0.7.0.1
 */