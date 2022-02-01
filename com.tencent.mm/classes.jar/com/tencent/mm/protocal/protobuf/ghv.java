package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONObject;

public final class ghv
  extends erp
{
  public String YQb;
  public int type;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(258699);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "BaseRequest", this.BaseRequest, false);
      com.tencent.mm.bk.a.a(localJSONObject, "json_str", this.YQb, false);
      com.tencent.mm.bk.a.a(localJSONObject, "type", Integer.valueOf(this.type), false);
      label49:
      AppMethodBeat.o(258699);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label49;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258702);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.YQb != null) {
        paramVarArgs.g(2, this.YQb);
      }
      paramVarArgs.bS(3, this.type);
      AppMethodBeat.o(258702);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label388;
      }
    }
    label388:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.YQb != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.YQb);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.type);
      AppMethodBeat.o(258702);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258702);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ghv localghv = (ghv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258702);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kc localkc = new kc();
            if ((localObject != null) && (localObject.length > 0)) {
              localkc.parseFrom((byte[])localObject);
            }
            localghv.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(258702);
          return 0;
        case 2: 
          localghv.YQb = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258702);
          return 0;
        }
        localghv.type = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258702);
        return 0;
      }
      AppMethodBeat.o(258702);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ghv
 * JD-Core Version:    0.7.0.1
 */