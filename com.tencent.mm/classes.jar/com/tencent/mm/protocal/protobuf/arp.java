package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class arp
  extends com.tencent.mm.bw.a
{
  public int ELo;
  public LinkedList<aex> ELp;
  public int ELq;
  public int drx;
  
  public arp()
  {
    AppMethodBeat.i(153145);
    this.ELp = new LinkedList();
    AppMethodBeat.o(153145);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153146);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.ELo);
      paramVarArgs.e(2, 8, this.ELp);
      paramVarArgs.aR(3, this.ELq);
      paramVarArgs.aR(4, this.drx);
      AppMethodBeat.o(153146);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bx(1, this.ELo);
      i = f.a.a.a.c(2, 8, this.ELp);
      int j = f.a.a.b.b.a.bx(3, this.ELq);
      int k = f.a.a.b.b.a.bx(4, this.drx);
      AppMethodBeat.o(153146);
      return paramInt + 0 + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ELp.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(153146);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      arp localarp = (arp)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(153146);
        return -1;
      case 1: 
        localarp.ELo = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(153146);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aex();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((aex)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localarp.ELp.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(153146);
        return 0;
      case 3: 
        localarp.ELq = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(153146);
        return 0;
      }
      localarp.drx = ((f.a.a.a.a)localObject1).LVo.xF();
      AppMethodBeat.o(153146);
      return 0;
    }
    AppMethodBeat.o(153146);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.arp
 * JD-Core Version:    0.7.0.1
 */