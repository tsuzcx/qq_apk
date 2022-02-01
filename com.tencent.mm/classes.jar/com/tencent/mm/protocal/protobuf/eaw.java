package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONObject;

public final class eaw
  extends esc
{
  public int abgq;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(258246);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "BaseResponse", this.BaseResponse, false);
      com.tencent.mm.bk.a.a(localJSONObject, "CacheExpireTime", Integer.valueOf(this.abgq), false);
      label38:
      AppMethodBeat.o(258246);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label38;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117885);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.abgq);
      AppMethodBeat.o(117885);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label328;
      }
    }
    label328:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.abgq);
      AppMethodBeat.o(117885);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(117885);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        eaw localeaw = (eaw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117885);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kd localkd = new kd();
            if ((localObject != null) && (localObject.length > 0)) {
              localkd.parseFrom((byte[])localObject);
            }
            localeaw.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(117885);
          return 0;
        }
        localeaw.abgq = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(117885);
        return 0;
      }
      AppMethodBeat.o(117885);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eaw
 * JD-Core Version:    0.7.0.1
 */