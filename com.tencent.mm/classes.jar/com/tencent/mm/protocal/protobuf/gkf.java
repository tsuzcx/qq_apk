package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;
import org.json.JSONObject;

public final class gkf
  extends esc
{
  public LinkedList<gni> acgg;
  public LinkedList<String> acgh;
  public int status;
  
  public gkf()
  {
    AppMethodBeat.i(257849);
    this.acgg = new LinkedList();
    this.acgh = new LinkedList();
    AppMethodBeat.o(257849);
  }
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(257851);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "BaseResponse", this.BaseResponse, false);
      com.tencent.mm.bk.a.a(localJSONObject, "wxa_item_list", this.acgg, false);
      com.tencent.mm.bk.a.a(localJSONObject, "status", Integer.valueOf(this.status), false);
      com.tencent.mm.bk.a.a(localJSONObject, "all_shown_scope_list", this.acgh, false);
      label60:
      AppMethodBeat.o(257851);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label60;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257858);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(257858);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.acgg);
      paramVarArgs.bS(3, this.status);
      paramVarArgs.e(4, 1, this.acgh);
      AppMethodBeat.o(257858);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label558;
      }
    }
    label558:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.a.c(2, 8, this.acgg);
      int j = i.a.a.b.b.a.cJ(3, this.status);
      int k = i.a.a.a.c(4, 1, this.acgh);
      AppMethodBeat.o(257858);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.acgg.clear();
        this.acgh.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(257858);
          throw paramVarArgs;
        }
        AppMethodBeat.o(257858);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        gkf localgkf = (gkf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257858);
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
            localgkf.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257858);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gni();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gni)localObject2).parseFrom((byte[])localObject1);
            }
            localgkf.acgg.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257858);
          return 0;
        case 3: 
          localgkf.status = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(257858);
          return 0;
        }
        localgkf.acgh.add(((i.a.a.a.a)localObject1).ajGk.readString());
        AppMethodBeat.o(257858);
        return 0;
      }
      AppMethodBeat.o(257858);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gkf
 * JD-Core Version:    0.7.0.1
 */