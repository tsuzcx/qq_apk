package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;
import org.json.JSONObject;

public final class xa
  extends com.tencent.mm.bx.a
{
  public LinkedList<fuk> ZeN;
  public b ZeO;
  public b ZeP;
  
  public xa()
  {
    AppMethodBeat.i(117854);
    this.ZeN = new LinkedList();
    AppMethodBeat.o(117854);
  }
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(258713);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "CdnUrlInfo", this.ZeN, false);
      com.tencent.mm.bk.a.a(localJSONObject, "CoverUrl", this.ZeO, false);
      com.tencent.mm.bk.a.a(localJSONObject, "ArticleUrl", this.ZeP, false);
      label46:
      AppMethodBeat.o(258713);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label46;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117855);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.ZeN);
      if (this.ZeO != null) {
        paramVarArgs.d(2, this.ZeO);
      }
      if (this.ZeP != null) {
        paramVarArgs.d(3, this.ZeP);
      }
      AppMethodBeat.o(117855);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.a.c(1, 8, this.ZeN) + 0;
      paramInt = i;
      if (this.ZeO != null) {
        paramInt = i + i.a.a.b.b.a.c(2, this.ZeO);
      }
      i = paramInt;
      if (this.ZeP != null) {
        i = paramInt + i.a.a.b.b.a.c(3, this.ZeP);
      }
      AppMethodBeat.o(117855);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ZeN.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(117855);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      xa localxa = (xa)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117855);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          fuk localfuk = new fuk();
          if ((localObject != null) && (localObject.length > 0)) {
            localfuk.parseFrom((byte[])localObject);
          }
          localxa.ZeN.add(localfuk);
          paramInt += 1;
        }
        AppMethodBeat.o(117855);
        return 0;
      case 2: 
        localxa.ZeO = ((i.a.a.a.a)localObject).ajGk.kFX();
        AppMethodBeat.o(117855);
        return 0;
      }
      localxa.ZeP = ((i.a.a.a.a)localObject).ajGk.kFX();
      AppMethodBeat.o(117855);
      return 0;
    }
    AppMethodBeat.o(117855);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.xa
 * JD-Core Version:    0.7.0.1
 */