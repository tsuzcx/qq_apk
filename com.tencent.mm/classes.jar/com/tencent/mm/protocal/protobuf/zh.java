package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class zh
  extends com.tencent.mm.bw.a
{
  public int Grh;
  public SKBuiltinBuffer_t Gri;
  public int Grj;
  public SKBuiltinBuffer_t Grk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(145668);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Gri == null)
      {
        paramVarArgs = new b("Not all required fields were included: OperationInfo");
        AppMethodBeat.o(145668);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.Grh);
      if (this.Gri != null)
      {
        paramVarArgs.lJ(2, this.Gri.computeSize());
        this.Gri.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.Grj);
      if (this.Grk != null)
      {
        paramVarArgs.lJ(4, this.Grk.computeSize());
        this.Grk.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(145668);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.Grh) + 0;
      paramInt = i;
      if (this.Gri != null) {
        paramInt = i + f.a.a.a.lI(2, this.Gri.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(3, this.Grj);
      paramInt = i;
      if (this.Grk != null) {
        paramInt = i + f.a.a.a.lI(4, this.Grk.computeSize());
      }
      AppMethodBeat.o(145668);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      if (this.Gri == null)
      {
        paramVarArgs = new b("Not all required fields were included: OperationInfo");
        AppMethodBeat.o(145668);
        throw paramVarArgs;
      }
      AppMethodBeat.o(145668);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      zh localzh = (zh)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(145668);
        return -1;
      case 1: 
        localzh.Grh = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(145668);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localzh.Gri = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(145668);
        return 0;
      case 3: 
        localzh.Grj = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(145668);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new SKBuiltinBuffer_t();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localzh.Grk = ((SKBuiltinBuffer_t)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(145668);
      return 0;
    }
    AppMethodBeat.o(145668);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.zh
 * JD-Core Version:    0.7.0.1
 */