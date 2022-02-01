package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONObject;

public final class eav
  extends com.tencent.mm.bx.a
{
  public dhb aaLr;
  public acm aaLs;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(258261);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "Location", this.aaLr, false);
      com.tencent.mm.bk.a.a(localJSONObject, "ChildMode", this.aaLs, false);
      label35:
      AppMethodBeat.o(258261);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label35;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117884);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaLr != null)
      {
        paramVarArgs.qD(1, this.aaLr.computeSize());
        this.aaLr.writeFields(paramVarArgs);
      }
      if (this.aaLs != null)
      {
        paramVarArgs.qD(2, this.aaLs.computeSize());
        this.aaLs.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(117884);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aaLr == null) {
        break label418;
      }
    }
    label418:
    for (paramInt = i.a.a.a.qC(1, this.aaLr.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.aaLs != null) {
        i = paramInt + i.a.a.a.qC(2, this.aaLs.computeSize());
      }
      AppMethodBeat.o(117884);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(117884);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        eav localeav = (eav)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117884);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dhb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dhb)localObject2).parseFrom((byte[])localObject1);
            }
            localeav.aaLr = ((dhb)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(117884);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new acm();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((acm)localObject2).parseFrom((byte[])localObject1);
          }
          localeav.aaLs = ((acm)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(117884);
        return 0;
      }
      AppMethodBeat.o(117884);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eav
 * JD-Core Version:    0.7.0.1
 */