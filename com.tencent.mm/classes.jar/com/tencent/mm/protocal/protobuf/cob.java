package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cob
  extends com.tencent.mm.bw.a
{
  public int FBh;
  public SKBuiltinBuffer_t FBi;
  public SKBuiltinBuffer_t FBj;
  public SKBuiltinBuffer_t FBk;
  public SKBuiltinBuffer_t FBl;
  public long FBm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125760);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.FBh);
      if (this.FBi != null)
      {
        paramVarArgs.ln(2, this.FBi.computeSize());
        this.FBi.writeFields(paramVarArgs);
      }
      if (this.FBj != null)
      {
        paramVarArgs.ln(3, this.FBj.computeSize());
        this.FBj.writeFields(paramVarArgs);
      }
      if (this.FBk != null)
      {
        paramVarArgs.ln(4, this.FBk.computeSize());
        this.FBk.writeFields(paramVarArgs);
      }
      if (this.FBl != null)
      {
        paramVarArgs.ln(5, this.FBl.computeSize());
        this.FBl.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(6, this.FBm);
      AppMethodBeat.o(125760);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.FBh) + 0;
      paramInt = i;
      if (this.FBi != null) {
        paramInt = i + f.a.a.a.lm(2, this.FBi.computeSize());
      }
      i = paramInt;
      if (this.FBj != null) {
        i = paramInt + f.a.a.a.lm(3, this.FBj.computeSize());
      }
      paramInt = i;
      if (this.FBk != null) {
        paramInt = i + f.a.a.a.lm(4, this.FBk.computeSize());
      }
      i = paramInt;
      if (this.FBl != null) {
        i = paramInt + f.a.a.a.lm(5, this.FBl.computeSize());
      }
      paramInt = f.a.a.b.b.a.p(6, this.FBm);
      AppMethodBeat.o(125760);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(125760);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cob localcob = (cob)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(125760);
        return -1;
      case 1: 
        localcob.FBh = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(125760);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcob.FBi = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125760);
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
          localcob.FBj = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125760);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcob.FBk = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125760);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcob.FBl = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125760);
        return 0;
      }
      localcob.FBm = ((f.a.a.a.a)localObject1).LVo.xG();
      AppMethodBeat.o(125760);
      return 0;
    }
    AppMethodBeat.o(125760);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cob
 * JD-Core Version:    0.7.0.1
 */