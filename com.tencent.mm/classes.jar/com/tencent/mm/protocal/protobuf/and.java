package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;
import org.json.JSONObject;

public final class and
  extends com.tencent.mm.bx.a
{
  public b ZEQ;
  public bfv akjQ;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(369670);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "box_id", this.akjQ, false);
      com.tencent.mm.bk.a.a(localJSONObject, "last_buffer", this.ZEQ, false);
      label35:
      AppMethodBeat.o(369670);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label35;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(369671);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.akjQ != null)
      {
        paramVarArgs.qD(1, this.akjQ.computeSize());
        this.akjQ.writeFields(paramVarArgs);
      }
      if (this.ZEQ != null) {
        paramVarArgs.d(2, this.ZEQ);
      }
      AppMethodBeat.o(369671);
      return 0;
    }
    if (paramInt == 1) {
      if (this.akjQ == null) {
        break label344;
      }
    }
    label344:
    for (paramInt = i.a.a.a.qC(1, this.akjQ.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ZEQ != null) {
        i = paramInt + i.a.a.b.b.a.c(2, this.ZEQ);
      }
      AppMethodBeat.o(369671);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(369671);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        and localand = (and)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(369671);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            bfv localbfv = new bfv();
            if ((localObject != null) && (localObject.length > 0)) {
              localbfv.parseFrom((byte[])localObject);
            }
            localand.akjQ = localbfv;
            paramInt += 1;
          }
          AppMethodBeat.o(369671);
          return 0;
        }
        localand.ZEQ = ((i.a.a.a.a)localObject).ajGk.kFX();
        AppMethodBeat.o(369671);
        return 0;
      }
      AppMethodBeat.o(369671);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.and
 * JD-Core Version:    0.7.0.1
 */