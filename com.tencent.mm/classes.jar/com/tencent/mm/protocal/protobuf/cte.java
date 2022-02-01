package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cte
  extends com.tencent.mm.bx.a
{
  public int Hlu;
  public SKBuiltinBuffer_t Hlv;
  public SKBuiltinBuffer_t Hlw;
  public SKBuiltinBuffer_t Hlx;
  public SKBuiltinBuffer_t Hly;
  public long Hlz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125760);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Hlu);
      if (this.Hlv != null)
      {
        paramVarArgs.lC(2, this.Hlv.computeSize());
        this.Hlv.writeFields(paramVarArgs);
      }
      if (this.Hlw != null)
      {
        paramVarArgs.lC(3, this.Hlw.computeSize());
        this.Hlw.writeFields(paramVarArgs);
      }
      if (this.Hlx != null)
      {
        paramVarArgs.lC(4, this.Hlx.computeSize());
        this.Hlx.writeFields(paramVarArgs);
      }
      if (this.Hly != null)
      {
        paramVarArgs.lC(5, this.Hly.computeSize());
        this.Hly.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(6, this.Hlz);
      AppMethodBeat.o(125760);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.Hlu) + 0;
      paramInt = i;
      if (this.Hlv != null) {
        paramInt = i + f.a.a.a.lB(2, this.Hlv.computeSize());
      }
      i = paramInt;
      if (this.Hlw != null) {
        i = paramInt + f.a.a.a.lB(3, this.Hlw.computeSize());
      }
      paramInt = i;
      if (this.Hlx != null) {
        paramInt = i + f.a.a.a.lB(4, this.Hlx.computeSize());
      }
      i = paramInt;
      if (this.Hly != null) {
        i = paramInt + f.a.a.a.lB(5, this.Hly.computeSize());
      }
      paramInt = f.a.a.b.b.a.p(6, this.Hlz);
      AppMethodBeat.o(125760);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(125760);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cte localcte = (cte)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(125760);
        return -1;
      case 1: 
        localcte.Hlu = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(125760);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcte.Hlv = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125760);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcte.Hlw = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125760);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcte.Hlx = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125760);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcte.Hly = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(125760);
        return 0;
      }
      localcte.Hlz = ((f.a.a.a.a)localObject1).NPN.zd();
      AppMethodBeat.o(125760);
      return 0;
    }
    AppMethodBeat.o(125760);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cte
 * JD-Core Version:    0.7.0.1
 */