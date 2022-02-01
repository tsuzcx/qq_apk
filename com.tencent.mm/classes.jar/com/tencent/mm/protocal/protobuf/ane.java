package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONObject;

public final class ane
  extends com.tencent.mm.bx.a
{
  public bfv akjQ;
  public boolean muH;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(369665);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "box_id", this.akjQ, false);
      com.tencent.mm.bk.a.a(localJSONObject, "has_unread_msg", Boolean.valueOf(this.muH), false);
      label38:
      AppMethodBeat.o(369665);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label38;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(369666);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.akjQ != null)
      {
        paramVarArgs.qD(1, this.akjQ.computeSize());
        this.akjQ.writeFields(paramVarArgs);
      }
      paramVarArgs.di(2, this.muH);
      AppMethodBeat.o(369666);
      return 0;
    }
    if (paramInt == 1) {
      if (this.akjQ == null) {
        break label328;
      }
    }
    label328:
    for (paramInt = i.a.a.a.qC(1, this.akjQ.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.ko(2);
      AppMethodBeat.o(369666);
      return paramInt + (i + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(369666);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ane localane = (ane)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(369666);
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
            localane.akjQ = localbfv;
            paramInt += 1;
          }
          AppMethodBeat.o(369666);
          return 0;
        }
        localane.muH = ((i.a.a.a.a)localObject).ajGk.aai();
        AppMethodBeat.o(369666);
        return 0;
      }
      AppMethodBeat.o(369666);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ane
 * JD-Core Version:    0.7.0.1
 */