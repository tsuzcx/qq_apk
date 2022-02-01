package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class m
  extends com.tencent.mm.bx.a
{
  public int Yzw;
  public int Yzx;
  public LinkedList<n> Yzy;
  
  public m()
  {
    AppMethodBeat.i(143956);
    this.Yzy = new LinkedList();
    AppMethodBeat.o(143956);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143957);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.Yzw);
      paramVarArgs.bS(2, this.Yzx);
      paramVarArgs.e(3, 8, this.Yzy);
      AppMethodBeat.o(143957);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.cJ(1, this.Yzw);
      i = i.a.a.b.b.a.cJ(2, this.Yzx);
      int j = i.a.a.a.c(3, 8, this.Yzy);
      AppMethodBeat.o(143957);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Yzy.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(143957);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      m localm = (m)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143957);
        return -1;
      case 1: 
        localm.Yzw = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(143957);
        return 0;
      case 2: 
        localm.Yzx = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(143957);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        n localn = new n();
        if ((localObject != null) && (localObject.length > 0)) {
          localn.parseFrom((byte[])localObject);
        }
        localm.Yzy.add(localn);
        paramInt += 1;
      }
      AppMethodBeat.o(143957);
      return 0;
    }
    AppMethodBeat.o(143957);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.m
 * JD-Core Version:    0.7.0.1
 */