package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONObject;

public final class dfv
  extends esc
{
  public fkl aaLt;
  public String aayf;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(258209);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "BaseResponse", this.BaseResponse, false);
      com.tencent.mm.bk.a.a(localJSONObject, "SearchId", this.aayf, false);
      com.tencent.mm.bk.a.a(localJSONObject, "SugResult", this.aaLt, false);
      label46:
      AppMethodBeat.o(258209);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label46;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258215);
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
      AppMethodBeat.o(258215);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label478;
      }
    }
    label478:
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
      AppMethodBeat.o(258215);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258215);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dfv localdfv = (dfv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258215);
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
            localdfv.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258215);
          return 0;
        case 2: 
          localdfv.aayf = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258215);
          return 0;
        }
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
          localdfv.aaLt = ((fkl)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258215);
        return 0;
      }
      AppMethodBeat.o(258215);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dfv
 * JD-Core Version:    0.7.0.1
 */