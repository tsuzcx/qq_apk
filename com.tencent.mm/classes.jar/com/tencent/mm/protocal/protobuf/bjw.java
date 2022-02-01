package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bjw
  extends com.tencent.mm.bw.a
{
  public long EZm;
  public long EZn;
  public LinkedList<ccs> EZo;
  public int EZp;
  public LinkedList<cco> EZq;
  public int EZr;
  public int EZs;
  public long EZt;
  public boolean EZu;
  
  public bjw()
  {
    AppMethodBeat.i(122515);
    this.EZm = 0L;
    this.EZn = 0L;
    this.EZo = new LinkedList();
    this.EZp = -1;
    this.EZq = new LinkedList();
    this.EZr = -1;
    this.EZs = -1;
    this.EZt = 0L;
    this.EZu = false;
    AppMethodBeat.o(122515);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122516);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.EZm);
      paramVarArgs.aO(2, this.EZn);
      paramVarArgs.e(3, 8, this.EZo);
      paramVarArgs.aR(4, this.EZp);
      paramVarArgs.e(5, 8, this.EZq);
      paramVarArgs.aR(6, this.EZr);
      paramVarArgs.aR(7, this.EZs);
      paramVarArgs.aO(8, this.EZt);
      paramVarArgs.bl(9, this.EZu);
      AppMethodBeat.o(122516);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.p(1, this.EZm);
      i = f.a.a.b.b.a.p(2, this.EZn);
      int j = f.a.a.a.c(3, 8, this.EZo);
      int k = f.a.a.b.b.a.bx(4, this.EZp);
      int m = f.a.a.a.c(5, 8, this.EZq);
      int n = f.a.a.b.b.a.bx(6, this.EZr);
      int i1 = f.a.a.b.b.a.bx(7, this.EZs);
      int i2 = f.a.a.b.b.a.p(8, this.EZt);
      int i3 = f.a.a.b.b.a.fK(9);
      AppMethodBeat.o(122516);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + (i3 + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.EZo.clear();
      this.EZq.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(122516);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      bjw localbjw = (bjw)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(122516);
        return -1;
      case 1: 
        localbjw.EZm = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(122516);
        return 0;
      case 2: 
        localbjw.EZn = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(122516);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ccs();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ccs)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbjw.EZo.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122516);
        return 0;
      case 4: 
        localbjw.EZp = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(122516);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cco();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cco)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbjw.EZq.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122516);
        return 0;
      case 6: 
        localbjw.EZr = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(122516);
        return 0;
      case 7: 
        localbjw.EZs = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(122516);
        return 0;
      case 8: 
        localbjw.EZt = ((f.a.a.a.a)localObject1).LVo.xG();
        AppMethodBeat.o(122516);
        return 0;
      }
      localbjw.EZu = ((f.a.a.a.a)localObject1).LVo.fZX();
      AppMethodBeat.o(122516);
      return 0;
    }
    AppMethodBeat.o(122516);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjw
 * JD-Core Version:    0.7.0.1
 */