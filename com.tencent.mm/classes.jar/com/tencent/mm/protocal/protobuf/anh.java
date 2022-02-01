package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class anh
  extends com.tencent.mm.bw.a
{
  public int EGp;
  public ani EGq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169043);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.EGp);
      if (this.EGq != null)
      {
        paramVarArgs.ln(2, this.EGq.computeSize());
        this.EGq.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(169043);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.EGp) + 0;
      paramInt = i;
      if (this.EGq != null) {
        paramInt = i + f.a.a.a.lm(2, this.EGq.computeSize());
      }
      AppMethodBeat.o(169043);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(169043);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      anh localanh = (anh)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(169043);
        return -1;
      case 1: 
        localanh.EGp = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(169043);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new ani();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((ani)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localanh.EGq = ((ani)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(169043);
      return 0;
    }
    AppMethodBeat.o(169043);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.anh
 * JD-Core Version:    0.7.0.1
 */