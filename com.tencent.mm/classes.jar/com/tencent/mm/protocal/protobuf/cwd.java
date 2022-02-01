package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cwd
  extends com.tencent.mm.bw.a
{
  public boolean fxO;
  public LinkedList<cwe> hkS;
  
  public cwd()
  {
    AppMethodBeat.i(122542);
    this.fxO = true;
    this.hkS = new LinkedList();
    AppMethodBeat.o(122542);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122543);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bl(1, this.fxO);
      paramVarArgs.e(2, 8, this.hkS);
      AppMethodBeat.o(122543);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.fK(1);
      i = f.a.a.a.c(2, 8, this.hkS);
      AppMethodBeat.o(122543);
      return paramInt + 1 + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.hkS.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(122543);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cwd localcwd = (cwd)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(122543);
        return -1;
      case 1: 
        localcwd.fxO = ((f.a.a.a.a)localObject1).LVo.fZX();
        AppMethodBeat.o(122543);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new cwe();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((cwe)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localcwd.hkS.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(122543);
      return 0;
    }
    AppMethodBeat.o(122543);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwd
 * JD-Core Version:    0.7.0.1
 */