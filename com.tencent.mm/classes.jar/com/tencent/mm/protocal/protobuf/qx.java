package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONObject;

public final class qx
  extends com.tencent.mm.bx.a
{
  public ese YVQ;
  public String YVR;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(257439);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "CommContent", this.YVQ, false);
      com.tencent.mm.bk.a.a(localJSONObject, "BizUserAttrInfo", this.YVR, false);
      label35:
      AppMethodBeat.o(257439);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label35;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117836);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YVQ != null)
      {
        paramVarArgs.qD(1, this.YVQ.computeSize());
        this.YVQ.writeFields(paramVarArgs);
      }
      if (this.YVR != null) {
        paramVarArgs.g(2, this.YVR);
      }
      AppMethodBeat.o(117836);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YVQ == null) {
        break label344;
      }
    }
    label344:
    for (paramInt = i.a.a.a.qC(1, this.YVQ.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.YVR != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.YVR);
      }
      AppMethodBeat.o(117836);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(117836);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        qx localqx = (qx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117836);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            ese localese = new ese();
            if ((localObject != null) && (localObject.length > 0)) {
              localese.parseFrom((byte[])localObject);
            }
            localqx.YVQ = localese;
            paramInt += 1;
          }
          AppMethodBeat.o(117836);
          return 0;
        }
        localqx.YVR = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(117836);
        return 0;
      }
      AppMethodBeat.o(117836);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qx
 * JD-Core Version:    0.7.0.1
 */