package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONObject;

public final class bzk
  extends com.tencent.mm.bx.a
{
  public LinkedList<bzl> aaiF;
  
  public bzk()
  {
    AppMethodBeat.i(152992);
    this.aaiF = new LinkedList();
    AppMethodBeat.o(152992);
  }
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(257633);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "DocInfo", this.aaiF, false);
      label24:
      AppMethodBeat.o(257633);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label24;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152993);
    if (paramInt == 0)
    {
      ((i.a.a.c.a)paramVarArgs[0]).e(1, 8, this.aaiF);
      AppMethodBeat.o(152993);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.a.c(1, 8, this.aaiF);
      AppMethodBeat.o(152993);
      return paramInt + 0;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.aaiF.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(152993);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      bzk localbzk = (bzk)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(152993);
        return -1;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      int i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        bzl localbzl = new bzl();
        if ((localObject != null) && (localObject.length > 0)) {
          localbzl.parseFrom((byte[])localObject);
        }
        localbzk.aaiF.add(localbzl);
        paramInt += 1;
      }
      AppMethodBeat.o(152993);
      return 0;
    }
    AppMethodBeat.o(152993);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bzk
 * JD-Core Version:    0.7.0.1
 */