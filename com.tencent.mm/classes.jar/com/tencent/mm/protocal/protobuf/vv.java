package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class vv
  extends com.tencent.mm.bx.a
{
  public LinkedList<dtq> YHU;
  public int hAO;
  
  public vv()
  {
    AppMethodBeat.i(259045);
    this.YHU = new LinkedList();
    AppMethodBeat.o(259045);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259047);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.YHU);
      paramVarArgs.bS(2, this.hAO);
      AppMethodBeat.o(259047);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.a.c(1, 8, this.YHU);
      i = i.a.a.b.b.a.cJ(2, this.hAO);
      AppMethodBeat.o(259047);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.YHU.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259047);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      vv localvv = (vv)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(259047);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          dtq localdtq = new dtq();
          if ((localObject != null) && (localObject.length > 0)) {
            localdtq.parseFrom((byte[])localObject);
          }
          localvv.YHU.add(localdtq);
          paramInt += 1;
        }
        AppMethodBeat.o(259047);
        return 0;
      }
      localvv.hAO = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(259047);
      return 0;
    }
    AppMethodBeat.o(259047);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vv
 * JD-Core Version:    0.7.0.1
 */