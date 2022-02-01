package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bvc
  extends com.tencent.mm.bw.a
{
  public bvb Fla;
  public int Flb;
  public int Ret;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(194049);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Ret);
      if (this.Fla != null)
      {
        paramVarArgs.ln(2, this.Fla.computeSize());
        this.Fla.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(3, this.Flb);
      AppMethodBeat.o(194049);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.Ret) + 0;
      paramInt = i;
      if (this.Fla != null) {
        paramInt = i + f.a.a.a.lm(2, this.Fla.computeSize());
      }
      i = f.a.a.b.b.a.bx(3, this.Flb);
      AppMethodBeat.o(194049);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(194049);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      bvc localbvc = (bvc)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(194049);
        return -1;
      case 1: 
        localbvc.Ret = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(194049);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bvb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bvb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbvc.Fla = ((bvb)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(194049);
        return 0;
      }
      localbvc.Flb = ((f.a.a.a.a)localObject1).LVo.xF();
      AppMethodBeat.o(194049);
      return 0;
    }
    AppMethodBeat.o(194049);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bvc
 * JD-Core Version:    0.7.0.1
 */