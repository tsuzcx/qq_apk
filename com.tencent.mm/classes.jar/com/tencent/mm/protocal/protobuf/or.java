package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class or
  extends com.tencent.mm.cd.a
{
  public LinkedList<os> RWN;
  public String RWO;
  public int RWP;
  
  public or()
  {
    AppMethodBeat.i(207230);
    this.RWN = new LinkedList();
    AppMethodBeat.o(207230);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207232);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.RWN);
      if (this.RWO != null) {
        paramVarArgs.f(2, this.RWO);
      }
      paramVarArgs.aY(3, this.RWP);
      AppMethodBeat.o(207232);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 8, this.RWN) + 0;
      paramInt = i;
      if (this.RWO != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.RWO);
      }
      i = g.a.a.b.b.a.bM(3, this.RWP);
      AppMethodBeat.o(207232);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.RWN.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(207232);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      or localor = (or)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(207232);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          os localos = new os();
          if ((localObject != null) && (localObject.length > 0)) {
            localos.parseFrom((byte[])localObject);
          }
          localor.RWN.add(localos);
          paramInt += 1;
        }
        AppMethodBeat.o(207232);
        return 0;
      case 2: 
        localor.RWO = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(207232);
        return 0;
      }
      localor.RWP = ((g.a.a.a.a)localObject).abFh.AK();
      AppMethodBeat.o(207232);
      return 0;
    }
    AppMethodBeat.o(207232);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.or
 * JD-Core Version:    0.7.0.1
 */