package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONObject;

public final class eax
  extends com.tencent.mm.bx.a
{
  public eaz abgr;
  public eay abgs;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(258285);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "ShowInfo", this.abgr, false);
      com.tencent.mm.bk.a.a(localJSONObject, "ActionInfo", this.abgs, false);
      label35:
      AppMethodBeat.o(258285);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label35;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117886);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abgr != null)
      {
        paramVarArgs.qD(1, this.abgr.computeSize());
        this.abgr.writeFields(paramVarArgs);
      }
      if (this.abgs != null)
      {
        paramVarArgs.qD(2, this.abgs.computeSize());
        this.abgs.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(117886);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abgr == null) {
        break label418;
      }
    }
    label418:
    for (paramInt = i.a.a.a.qC(1, this.abgr.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.abgs != null) {
        i = paramInt + i.a.a.a.qC(2, this.abgs.computeSize());
      }
      AppMethodBeat.o(117886);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(117886);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        eax localeax = (eax)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117886);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eaz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eaz)localObject2).parseFrom((byte[])localObject1);
            }
            localeax.abgr = ((eaz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(117886);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eay();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eay)localObject2).parseFrom((byte[])localObject1);
          }
          localeax.abgs = ((eay)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(117886);
        return 0;
      }
      AppMethodBeat.o(117886);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eax
 * JD-Core Version:    0.7.0.1
 */