package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONObject;

public final class evu
  extends com.tencent.mm.bx.a
{
  public LinkedList<evt> vgO;
  
  public evu()
  {
    AppMethodBeat.i(117912);
    this.vgO = new LinkedList();
    AppMethodBeat.o(117912);
  }
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(260092);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "List", this.vgO, false);
      label24:
      AppMethodBeat.o(260092);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label24;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117913);
    if (paramInt == 0)
    {
      ((i.a.a.c.a)paramVarArgs[0]).e(1, 8, this.vgO);
      AppMethodBeat.o(117913);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.a.c(1, 8, this.vgO);
      AppMethodBeat.o(117913);
      return paramInt + 0;
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
      AppMethodBeat.o(117913);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      evu localevu = (evu)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117913);
        return -1;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      int i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        evt localevt = new evt();
        if ((localObject != null) && (localObject.length > 0)) {
          localevt.parseFrom((byte[])localObject);
        }
        localevu.vgO.add(localevt);
        paramInt += 1;
      }
      AppMethodBeat.o(117913);
      return 0;
    }
    AppMethodBeat.o(117913);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.evu
 * JD-Core Version:    0.7.0.1
 */