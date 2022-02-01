package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONObject;

public final class evw
  extends esc
{
  public long YYo;
  public LinkedList<sy> abyx;
  
  public evw()
  {
    AppMethodBeat.i(117916);
    this.abyx = new LinkedList();
    AppMethodBeat.o(117916);
  }
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(260118);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "BaseResponse", this.BaseResponse, false);
      com.tencent.mm.bk.a.a(localJSONObject, "BusinessType", Long.valueOf(this.YYo), false);
      com.tencent.mm.bk.a.a(localJSONObject, "ContentList", this.abyx, false);
      label49:
      AppMethodBeat.o(260118);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label49;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117917);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(2, this.YYo);
      paramVarArgs.e(3, 8, this.abyx);
      AppMethodBeat.o(117917);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label450;
      }
    }
    label450:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.q(2, this.YYo);
      int j = i.a.a.a.c(3, 8, this.abyx);
      AppMethodBeat.o(117917);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abyx.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(117917);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        evw localevw = (evw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117917);
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
            localevw.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(117917);
          return 0;
        case 2: 
          localevw.YYo = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(117917);
          return 0;
        }
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
          localevw.abyx.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(117917);
        return 0;
      }
      AppMethodBeat.o(117917);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.evw
 * JD-Core Version:    0.7.0.1
 */