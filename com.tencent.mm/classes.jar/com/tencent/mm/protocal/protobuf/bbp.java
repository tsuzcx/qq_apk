package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bbp
  extends cvp
{
  public long Guq;
  public qu GyA;
  public cv GyB;
  public int GyC;
  public String Gyz;
  public int OpCode;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114788);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(114788);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.OpCode);
      paramVarArgs.aY(3, this.Guq);
      if (this.GyB != null)
      {
        paramVarArgs.lC(4, this.GyB.computeSize());
        this.GyB.writeFields(paramVarArgs);
      }
      if (this.Gyz != null) {
        paramVarArgs.d(5, this.Gyz);
      }
      paramVarArgs.aS(6, this.GyC);
      if (this.GyA != null)
      {
        paramVarArgs.lC(7, this.GyA.computeSize());
        this.GyA.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(114788);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label862;
      }
    }
    label862:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.OpCode) + f.a.a.b.b.a.p(3, this.Guq);
      paramInt = i;
      if (this.GyB != null) {
        paramInt = i + f.a.a.a.lB(4, this.GyB.computeSize());
      }
      i = paramInt;
      if (this.Gyz != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.Gyz);
      }
      i += f.a.a.b.b.a.bz(6, this.GyC);
      paramInt = i;
      if (this.GyA != null) {
        paramInt = i + f.a.a.a.lB(7, this.GyA.computeSize());
      }
      AppMethodBeat.o(114788);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(114788);
          throw paramVarArgs;
        }
        AppMethodBeat.o(114788);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bbp localbbp = (bbp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114788);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbbp.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114788);
          return 0;
        case 2: 
          localbbp.OpCode = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(114788);
          return 0;
        case 3: 
          localbbp.Guq = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(114788);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbbp.GyB = ((cv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114788);
          return 0;
        case 5: 
          localbbp.Gyz = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(114788);
          return 0;
        case 6: 
          localbbp.GyC = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(114788);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new qu();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((qu)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbbp.GyA = ((qu)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(114788);
        return 0;
      }
      AppMethodBeat.o(114788);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbp
 * JD-Core Version:    0.7.0.1
 */