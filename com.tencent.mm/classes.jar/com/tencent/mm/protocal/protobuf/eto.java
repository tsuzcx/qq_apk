package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONObject;

public final class eto
  extends com.tencent.mm.bx.a
{
  public int vgN;
  public LinkedList<etn> vgO;
  
  public eto()
  {
    AppMethodBeat.i(134255);
    this.vgO = new LinkedList();
    AppMethodBeat.o(134255);
  }
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(257877);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "Count", Integer.valueOf(this.vgN), false);
      com.tencent.mm.bk.a.a(localJSONObject, "List", this.vgO, false);
      label38:
      AppMethodBeat.o(257877);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label38;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(134256);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.vgN);
      paramVarArgs.e(2, 8, this.vgO);
      AppMethodBeat.o(134256);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.vgN);
      i = i.a.a.a.c(2, 8, this.vgO);
      AppMethodBeat.o(134256);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.vgO.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(134256);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      eto localeto = (eto)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(134256);
        return -1;
      case 1: 
        localeto.vgN = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(134256);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        etn localetn = new etn();
        if ((localObject != null) && (localObject.length > 0)) {
          localetn.parseFrom((byte[])localObject);
        }
        localeto.vgO.add(localetn);
        paramInt += 1;
      }
      AppMethodBeat.o(134256);
      return 0;
    }
    AppMethodBeat.o(134256);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eto
 * JD-Core Version:    0.7.0.1
 */