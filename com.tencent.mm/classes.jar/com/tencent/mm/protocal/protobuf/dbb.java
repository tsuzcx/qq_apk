package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dbb
  extends com.tencent.mm.bw.a
{
  public int FDp;
  public int FKi;
  public LinkedList<daj> FKj;
  public int FKk;
  public int FKl;
  
  public dbb()
  {
    AppMethodBeat.i(125810);
    this.FKj = new LinkedList();
    AppMethodBeat.o(125810);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125811);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.FKi);
      paramVarArgs.e(2, 8, this.FKj);
      paramVarArgs.aR(3, this.FKk);
      paramVarArgs.aR(4, this.FDp);
      paramVarArgs.aR(5, this.FKl);
      AppMethodBeat.o(125811);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.FKi);
      i = f.a.a.a.c(2, 8, this.FKj);
      int j = f.a.a.b.b.a.bx(3, this.FKk);
      int k = f.a.a.b.b.a.bx(4, this.FDp);
      int m = f.a.a.b.b.a.bx(5, this.FKl);
      AppMethodBeat.o(125811);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FKj.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(125811);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dbb localdbb = (dbb)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(125811);
        return -1;
      case 1: 
        localdbb.FKi = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(125811);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new daj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((daj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdbb.FKj.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125811);
        return 0;
      case 3: 
        localdbb.FKk = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(125811);
        return 0;
      case 4: 
        localdbb.FDp = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(125811);
        return 0;
      }
      localdbb.FKl = ((f.a.a.a.a)localObject1).LVo.xF();
      AppMethodBeat.o(125811);
      return 0;
    }
    AppMethodBeat.o(125811);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbb
 * JD-Core Version:    0.7.0.1
 */