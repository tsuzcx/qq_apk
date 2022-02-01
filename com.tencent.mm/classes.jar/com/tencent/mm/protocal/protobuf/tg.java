package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONObject;

public final class tg
  extends com.tencent.mm.bx.a
{
  public com.tencent.mm.bx.b YYU;
  public com.tencent.mm.bx.b YYV;
  public LinkedList<eyq> YYW;
  
  public tg()
  {
    AppMethodBeat.i(117851);
    this.YYW = new LinkedList();
    AppMethodBeat.o(117851);
  }
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(259448);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "Title", this.YYU, false);
      com.tencent.mm.bk.a.a(localJSONObject, "ServiceUrl", this.YYV, false);
      com.tencent.mm.bk.a.a(localJSONObject, "ItemFieldList", this.YYW, false);
      label46:
      AppMethodBeat.o(259448);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label46;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117852);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YYU == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: Title");
        AppMethodBeat.o(117852);
        throw paramVarArgs;
      }
      if (this.YYV == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: ServiceUrl");
        AppMethodBeat.o(117852);
        throw paramVarArgs;
      }
      if (this.YYU != null) {
        paramVarArgs.d(1, this.YYU);
      }
      if (this.YYV != null) {
        paramVarArgs.d(2, this.YYV);
      }
      paramVarArgs.e(3, 8, this.YYW);
      AppMethodBeat.o(117852);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YYU == null) {
        break label488;
      }
    }
    label488:
    for (paramInt = i.a.a.b.b.a.c(1, this.YYU) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.YYV != null) {
        i = paramInt + i.a.a.b.b.a.c(2, this.YYV);
      }
      paramInt = i.a.a.a.c(3, 8, this.YYW);
      AppMethodBeat.o(117852);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YYW.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.YYU == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: Title");
          AppMethodBeat.o(117852);
          throw paramVarArgs;
        }
        if (this.YYV == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: ServiceUrl");
          AppMethodBeat.o(117852);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117852);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        tg localtg = (tg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117852);
          return -1;
        case 1: 
          localtg.YYU = ((i.a.a.a.a)localObject).ajGk.kFX();
          AppMethodBeat.o(117852);
          return 0;
        case 2: 
          localtg.YYV = ((i.a.a.a.a)localObject).ajGk.kFX();
          AppMethodBeat.o(117852);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          eyq localeyq = new eyq();
          if ((localObject != null) && (localObject.length > 0)) {
            localeyq.parseFrom((byte[])localObject);
          }
          localtg.YYW.add(localeyq);
          paramInt += 1;
        }
        AppMethodBeat.o(117852);
        return 0;
      }
      AppMethodBeat.o(117852);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tg
 * JD-Core Version:    0.7.0.1
 */