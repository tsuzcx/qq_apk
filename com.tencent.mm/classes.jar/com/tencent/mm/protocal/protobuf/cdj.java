package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cdj
  extends com.tencent.mm.bw.a
{
  public SKBuiltinBuffer_t Fsb;
  public int Fsc;
  public SKBuiltinBuffer_t Fsd;
  public int uin;
  public int version;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(129972);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.uin);
      paramVarArgs.aR(2, this.version);
      if (this.Fsb != null)
      {
        paramVarArgs.ln(3, this.Fsb.computeSize());
        this.Fsb.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(4, this.Fsc);
      if (this.Fsd != null)
      {
        paramVarArgs.ln(5, this.Fsd.computeSize());
        this.Fsd.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(129972);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.uin) + 0 + f.a.a.b.b.a.bx(2, this.version);
      paramInt = i;
      if (this.Fsb != null) {
        paramInt = i + f.a.a.a.lm(3, this.Fsb.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bx(4, this.Fsc);
      paramInt = i;
      if (this.Fsd != null) {
        paramInt = i + f.a.a.a.lm(5, this.Fsd.computeSize());
      }
      AppMethodBeat.o(129972);
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
      AppMethodBeat.o(129972);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cdj localcdj = (cdj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(129972);
        return -1;
      case 1: 
        localcdj.uin = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(129972);
        return 0;
      case 2: 
        localcdj.version = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(129972);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcdj.Fsb = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(129972);
        return 0;
      case 4: 
        localcdj.Fsc = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(129972);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new SKBuiltinBuffer_t();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localcdj.Fsd = ((SKBuiltinBuffer_t)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(129972);
      return 0;
    }
    AppMethodBeat.o(129972);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cdj
 * JD-Core Version:    0.7.0.1
 */