package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bhm
  extends com.tencent.mm.bx.a
{
  public SKBuiltinBuffer_t CxB;
  public cmf DFs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152612);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CxB == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(152612);
        throw paramVarArgs;
      }
      if (this.DFs == null)
      {
        paramVarArgs = new b("Not all required fields were included: Username");
        AppMethodBeat.o(152612);
        throw paramVarArgs;
      }
      if (this.CxB != null)
      {
        paramVarArgs.kX(1, this.CxB.computeSize());
        this.CxB.writeFields(paramVarArgs);
      }
      if (this.DFs != null)
      {
        paramVarArgs.kX(2, this.DFs.computeSize());
        this.DFs.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(152612);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CxB == null) {
        break label562;
      }
    }
    label562:
    for (paramInt = f.a.a.a.kW(1, this.CxB.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.DFs != null) {
        i = paramInt + f.a.a.a.kW(2, this.DFs.computeSize());
      }
      AppMethodBeat.o(152612);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.CxB == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImgBuf");
          AppMethodBeat.o(152612);
          throw paramVarArgs;
        }
        if (this.DFs == null)
        {
          paramVarArgs = new b("Not all required fields were included: Username");
          AppMethodBeat.o(152612);
          throw paramVarArgs;
        }
        AppMethodBeat.o(152612);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bhm localbhm = (bhm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152612);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbhm.CxB = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152612);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cmf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbhm.DFs = ((cmf)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(152612);
        return 0;
      }
      AppMethodBeat.o(152612);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bhm
 * JD-Core Version:    0.7.0.1
 */