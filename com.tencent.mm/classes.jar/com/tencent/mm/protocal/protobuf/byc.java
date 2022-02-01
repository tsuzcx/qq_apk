package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class byc
  extends com.tencent.mm.bw.a
{
  public LinkedList<qx> EtR;
  public int EtS;
  public int EtT;
  public long lastUpdateTime;
  public int version;
  
  public byc()
  {
    AppMethodBeat.i(32357);
    this.EtR = new LinkedList();
    AppMethodBeat.o(32357);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32358);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.EtR);
      paramVarArgs.aR(2, this.version);
      paramVarArgs.aR(3, this.EtS);
      paramVarArgs.aR(4, this.EtT);
      paramVarArgs.aO(5, this.lastUpdateTime);
      AppMethodBeat.o(32358);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.a.c(1, 8, this.EtR);
      i = f.a.a.b.b.a.bx(2, this.version);
      int j = f.a.a.b.b.a.bx(3, this.EtS);
      int k = f.a.a.b.b.a.bx(4, this.EtT);
      int m = f.a.a.b.b.a.p(5, this.lastUpdateTime);
      AppMethodBeat.o(32358);
      return paramInt + 0 + i + j + k + m;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.EtR.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(32358);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      byc localbyc = (byc)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32358);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new qx();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((qx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbyc.EtR.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32358);
        return 0;
      case 2: 
        localbyc.version = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(32358);
        return 0;
      case 3: 
        localbyc.EtS = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(32358);
        return 0;
      case 4: 
        localbyc.EtT = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(32358);
        return 0;
      }
      localbyc.lastUpdateTime = ((f.a.a.a.a)localObject1).LVo.xG();
      AppMethodBeat.o(32358);
      return 0;
    }
    AppMethodBeat.o(32358);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byc
 * JD-Core Version:    0.7.0.1
 */