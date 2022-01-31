package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bkn
  extends com.tencent.mm.bv.a
{
  public int uin;
  public int version;
  public SKBuiltinBuffer_t xzg;
  public int xzh;
  public SKBuiltinBuffer_t xzi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(51770);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.uin);
      paramVarArgs.aO(2, this.version);
      if (this.xzg != null)
      {
        paramVarArgs.iQ(3, this.xzg.computeSize());
        this.xzg.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(4, this.xzh);
      if (this.xzi != null)
      {
        paramVarArgs.iQ(5, this.xzi.computeSize());
        this.xzi.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(51770);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.uin) + 0 + e.a.a.b.b.a.bl(2, this.version);
      paramInt = i;
      if (this.xzg != null) {
        paramInt = i + e.a.a.a.iP(3, this.xzg.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(4, this.xzh);
      paramInt = i;
      if (this.xzi != null) {
        paramInt = i + e.a.a.a.iP(5, this.xzi.computeSize());
      }
      AppMethodBeat.o(51770);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(51770);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      bkn localbkn = (bkn)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(51770);
        return -1;
      case 1: 
        localbkn.uin = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(51770);
        return 0;
      case 2: 
        localbkn.version = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(51770);
        return 0;
      case 3: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbkn.xzg = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(51770);
        return 0;
      case 4: 
        localbkn.xzh = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(51770);
        return 0;
      }
      paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new SKBuiltinBuffer_t();
        localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
        localbkn.xzi = ((SKBuiltinBuffer_t)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(51770);
      return 0;
    }
    AppMethodBeat.o(51770);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkn
 * JD-Core Version:    0.7.0.1
 */