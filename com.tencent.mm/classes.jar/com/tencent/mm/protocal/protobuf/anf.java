package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class anf
  extends com.tencent.mm.bw.a
{
  public int EDy;
  public LinkedList<FinderContact> EGm;
  public int EGn;
  
  public anf()
  {
    AppMethodBeat.i(169041);
    this.EGm = new LinkedList();
    AppMethodBeat.o(169041);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169042);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.EGm);
      paramVarArgs.aR(2, this.EDy);
      paramVarArgs.aR(3, this.EGn);
      AppMethodBeat.o(169042);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.a.c(1, 8, this.EGm);
      i = f.a.a.b.b.a.bx(2, this.EDy);
      int j = f.a.a.b.b.a.bx(3, this.EGn);
      AppMethodBeat.o(169042);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.EGm.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(169042);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      anf localanf = (anf)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(169042);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new FinderContact();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((FinderContact)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localanf.EGm.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169042);
        return 0;
      case 2: 
        localanf.EDy = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(169042);
        return 0;
      }
      localanf.EGn = ((f.a.a.a.a)localObject1).LVo.xF();
      AppMethodBeat.o(169042);
      return 0;
    }
    AppMethodBeat.o(169042);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.anf
 * JD-Core Version:    0.7.0.1
 */