package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class crq
  extends com.tencent.mm.bw.a
{
  public LinkedList<brk> FEq;
  public boolean FEr;
  public boolean FEs;
  public boolean FEt;
  public boolean FEu;
  public boolean FEv;
  
  public crq()
  {
    AppMethodBeat.i(155454);
    this.FEq = new LinkedList();
    AppMethodBeat.o(155454);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155455);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.FEq);
      paramVarArgs.bl(2, this.FEr);
      paramVarArgs.bl(3, this.FEs);
      paramVarArgs.bl(4, this.FEt);
      paramVarArgs.bl(5, this.FEu);
      paramVarArgs.bl(6, this.FEv);
      AppMethodBeat.o(155455);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.a.c(1, 8, this.FEq);
      i = f.a.a.b.b.a.fK(2);
      int j = f.a.a.b.b.a.fK(3);
      int k = f.a.a.b.b.a.fK(4);
      int m = f.a.a.b.b.a.fK(5);
      int n = f.a.a.b.b.a.fK(6);
      AppMethodBeat.o(155455);
      return paramInt + 0 + (i + 1) + (j + 1) + (k + 1) + (m + 1) + (n + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FEq.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(155455);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      crq localcrq = (crq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(155455);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new brk();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((brk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcrq.FEq.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(155455);
        return 0;
      case 2: 
        localcrq.FEr = ((f.a.a.a.a)localObject1).LVo.fZX();
        AppMethodBeat.o(155455);
        return 0;
      case 3: 
        localcrq.FEs = ((f.a.a.a.a)localObject1).LVo.fZX();
        AppMethodBeat.o(155455);
        return 0;
      case 4: 
        localcrq.FEt = ((f.a.a.a.a)localObject1).LVo.fZX();
        AppMethodBeat.o(155455);
        return 0;
      case 5: 
        localcrq.FEu = ((f.a.a.a.a)localObject1).LVo.fZX();
        AppMethodBeat.o(155455);
        return 0;
      }
      localcrq.FEv = ((f.a.a.a.a)localObject1).LVo.fZX();
      AppMethodBeat.o(155455);
      return 0;
    }
    AppMethodBeat.o(155455);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.crq
 * JD-Core Version:    0.7.0.1
 */