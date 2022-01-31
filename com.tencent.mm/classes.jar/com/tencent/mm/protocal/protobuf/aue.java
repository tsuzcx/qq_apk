package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aue
  extends com.tencent.mm.bv.a
{
  public com.tencent.mm.bv.b xiU;
  public int xiV;
  public LinkedList<aug> xiW;
  public LinkedList<Integer> xiX;
  
  public aue()
  {
    AppMethodBeat.i(5214);
    this.xiW = new LinkedList();
    this.xiX = new LinkedList();
    AppMethodBeat.o(5214);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(5215);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xiU == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: RawBuf");
        AppMethodBeat.o(5215);
        throw paramVarArgs;
      }
      if (this.xiU != null) {
        paramVarArgs.c(1, this.xiU);
      }
      paramVarArgs.aO(2, this.xiV);
      paramVarArgs.e(3, 8, this.xiW);
      paramVarArgs.e(4, 2, this.xiX);
      AppMethodBeat.o(5215);
      return 0;
    }
    if (paramInt == 1) {
      if (this.xiU == null) {
        break label527;
      }
    }
    label527:
    for (paramInt = e.a.a.b.b.a.b(1, this.xiU) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.bl(2, this.xiV);
      int j = e.a.a.a.c(3, 8, this.xiW);
      int k = e.a.a.a.c(4, 2, this.xiX);
      AppMethodBeat.o(5215);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xiW.clear();
        this.xiX.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.xiU == null)
        {
          paramVarArgs = new e.a.a.b("Not all required fields were included: RawBuf");
          AppMethodBeat.o(5215);
          throw paramVarArgs;
        }
        AppMethodBeat.o(5215);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        aue localaue = (aue)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(5215);
          return -1;
        case 1: 
          localaue.xiU = ((e.a.a.a.a)localObject1).CLY.eqS();
          AppMethodBeat.o(5215);
          return 0;
        case 2: 
          localaue.xiV = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5215);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aug();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((aug)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localaue.xiW.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5215);
          return 0;
        }
        localaue.xiX.add(Integer.valueOf(((e.a.a.a.a)localObject1).CLY.sl()));
        AppMethodBeat.o(5215);
        return 0;
      }
      AppMethodBeat.o(5215);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aue
 * JD-Core Version:    0.7.0.1
 */