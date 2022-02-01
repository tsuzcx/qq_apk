package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONObject;

public class kd
  extends com.tencent.mm.bx.a
{
  public int Idd;
  public etl akjO;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(259561);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "Ret", Integer.valueOf(this.Idd), false);
      com.tencent.mm.bk.a.a(localJSONObject, "ErrMsg", this.akjO, false);
      label38:
      AppMethodBeat.o(259561);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label38;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133157);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.Idd);
      if (this.akjO != null)
      {
        paramVarArgs.qD(2, this.akjO.computeSize());
        this.akjO.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133157);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.Idd) + 0;
      paramInt = i;
      if (this.akjO != null) {
        paramInt = i + i.a.a.a.qC(2, this.akjO.computeSize());
      }
      AppMethodBeat.o(133157);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(133157);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      kd localkd = (kd)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(133157);
        return -1;
      case 1: 
        localkd.Idd = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(133157);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        etl localetl = new etl();
        if ((localObject != null) && (localObject.length > 0)) {
          localetl.dh((byte[])localObject);
        }
        localkd.akjO = localetl;
        paramInt += 1;
      }
      AppMethodBeat.o(133157);
      return 0;
    }
    AppMethodBeat.o(133157);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.kd
 * JD-Core Version:    0.7.0.1
 */