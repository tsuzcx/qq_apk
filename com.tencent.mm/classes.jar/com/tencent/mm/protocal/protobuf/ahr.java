package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ahr
  extends com.tencent.mm.bw.a
{
  public LinkedList<ahl> EBO;
  public ahl EBP;
  public String Ebg;
  public int fZz;
  
  public ahr()
  {
    AppMethodBeat.i(127478);
    this.EBO = new LinkedList();
    AppMethodBeat.o(127478);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127479);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.fZz);
      if (this.Ebg != null) {
        paramVarArgs.d(2, this.Ebg);
      }
      paramVarArgs.e(3, 8, this.EBO);
      if (this.EBP != null)
      {
        paramVarArgs.ln(4, this.EBP.computeSize());
        this.EBP.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(127479);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.fZz) + 0;
      paramInt = i;
      if (this.Ebg != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Ebg);
      }
      i = paramInt + f.a.a.a.c(3, 8, this.EBO);
      paramInt = i;
      if (this.EBP != null) {
        paramInt = i + f.a.a.a.lm(4, this.EBP.computeSize());
      }
      AppMethodBeat.o(127479);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.EBO.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(127479);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      ahr localahr = (ahr)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(127479);
        return -1;
      case 1: 
        localahr.fZz = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(127479);
        return 0;
      case 2: 
        localahr.Ebg = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(127479);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ahl();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ahl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localahr.EBO.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(127479);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new ahl();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((ahl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localahr.EBP = ((ahl)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(127479);
      return 0;
    }
    AppMethodBeat.o(127479);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahr
 * JD-Core Version:    0.7.0.1
 */