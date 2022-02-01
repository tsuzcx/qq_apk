package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONObject;

public final class evi
  extends esc
{
  public int YYs;
  public sy abyd;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(257376);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "BaseResponse", this.BaseResponse, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Content", this.abyd, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Offset", Integer.valueOf(this.YYs), false);
      label49:
      AppMethodBeat.o(257376);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label49;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117910);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.abyd != null)
      {
        paramVarArgs.qD(2, this.abyd.computeSize());
        this.abyd.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(3, this.YYs);
      AppMethodBeat.o(117910);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label462;
      }
    }
    label462:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.abyd != null) {
        i = paramInt + i.a.a.a.qC(2, this.abyd.computeSize());
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.YYs);
      AppMethodBeat.o(117910);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(117910);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        evi localevi = (evi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117910);
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
            localevi.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(117910);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new sy();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((sy)localObject2).parseFrom((byte[])localObject1);
            }
            localevi.abyd = ((sy)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(117910);
          return 0;
        }
        localevi.YYs = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(117910);
        return 0;
      }
      AppMethodBeat.o(117910);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.evi
 * JD-Core Version:    0.7.0.1
 */