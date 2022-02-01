package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bki
  extends cvc
{
  public SKBuiltinBuffer_t FDQ;
  public cwt GEP;
  public cwt GEQ;
  public SKBuiltinBuffer_t GER;
  public cwt GbY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155420);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GbY == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(155420);
        throw paramVarArgs;
      }
      if (this.GEP == null)
      {
        paramVarArgs = new b("Not all required fields were included: Pwd");
        AppMethodBeat.o(155420);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.GbY != null)
      {
        paramVarArgs.lC(2, this.GbY.computeSize());
        this.GbY.writeFields(paramVarArgs);
      }
      if (this.GEP != null)
      {
        paramVarArgs.lC(3, this.GEP.computeSize());
        this.GEP.writeFields(paramVarArgs);
      }
      if (this.GEQ != null)
      {
        paramVarArgs.lC(4, this.GEQ.computeSize());
        this.GEQ.writeFields(paramVarArgs);
      }
      if (this.FDQ != null)
      {
        paramVarArgs.lC(5, this.FDQ.computeSize());
        this.FDQ.writeFields(paramVarArgs);
      }
      if (this.GER != null)
      {
        paramVarArgs.lC(6, this.GER.computeSize());
        this.GER.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(155420);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1178;
      }
    }
    label1178:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GbY != null) {
        paramInt = i + f.a.a.a.lB(2, this.GbY.computeSize());
      }
      i = paramInt;
      if (this.GEP != null) {
        i = paramInt + f.a.a.a.lB(3, this.GEP.computeSize());
      }
      paramInt = i;
      if (this.GEQ != null) {
        paramInt = i + f.a.a.a.lB(4, this.GEQ.computeSize());
      }
      i = paramInt;
      if (this.FDQ != null) {
        i = paramInt + f.a.a.a.lB(5, this.FDQ.computeSize());
      }
      paramInt = i;
      if (this.GER != null) {
        paramInt = i + f.a.a.a.lB(6, this.GER.computeSize());
      }
      AppMethodBeat.o(155420);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.GbY == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(155420);
          throw paramVarArgs;
        }
        if (this.GEP == null)
        {
          paramVarArgs = new b("Not all required fields were included: Pwd");
          AppMethodBeat.o(155420);
          throw paramVarArgs;
        }
        AppMethodBeat.o(155420);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bki localbki = (bki)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155420);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbki.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155420);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbki.GbY = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155420);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbki.GEP = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155420);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cwt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbki.GEQ = ((cwt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155420);
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
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbki.FDQ = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155420);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbki.GER = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(155420);
        return 0;
      }
      AppMethodBeat.o(155420);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bki
 * JD-Core Version:    0.7.0.1
 */