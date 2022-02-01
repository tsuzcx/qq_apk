package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bnm
  extends cvp
{
  public SKBuiltinBuffer_t FyT;
  public SKBuiltinBuffer_t GHI;
  public SKBuiltinBuffer_t GHJ;
  public int GHK;
  public int GHL;
  public int GHM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32319);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32319);
        throw paramVarArgs;
      }
      if (this.FyT == null)
      {
        paramVarArgs = new b("Not all required fields were included: SessionKey");
        AppMethodBeat.o(32319);
        throw paramVarArgs;
      }
      if (this.GHI == null)
      {
        paramVarArgs = new b("Not all required fields were included: SessionBuffer");
        AppMethodBeat.o(32319);
        throw paramVarArgs;
      }
      if (this.GHJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyBuffer");
        AppMethodBeat.o(32319);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.FyT != null)
      {
        paramVarArgs.lC(2, this.FyT.computeSize());
        this.FyT.writeFields(paramVarArgs);
      }
      if (this.GHI != null)
      {
        paramVarArgs.lC(3, this.GHI.computeSize());
        this.GHI.writeFields(paramVarArgs);
      }
      if (this.GHJ != null)
      {
        paramVarArgs.lC(4, this.GHJ.computeSize());
        this.GHJ.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(5, this.GHK);
      paramVarArgs.aS(6, this.GHL);
      paramVarArgs.aS(7, this.GHM);
      AppMethodBeat.o(32319);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1127;
      }
    }
    label1127:
    for (int i = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FyT != null) {
        paramInt = i + f.a.a.a.lB(2, this.FyT.computeSize());
      }
      i = paramInt;
      if (this.GHI != null) {
        i = paramInt + f.a.a.a.lB(3, this.GHI.computeSize());
      }
      paramInt = i;
      if (this.GHJ != null) {
        paramInt = i + f.a.a.a.lB(4, this.GHJ.computeSize());
      }
      i = f.a.a.b.b.a.bz(5, this.GHK);
      int j = f.a.a.b.b.a.bz(6, this.GHL);
      int k = f.a.a.b.b.a.bz(7, this.GHM);
      AppMethodBeat.o(32319);
      return paramInt + i + j + k;
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
          AppMethodBeat.o(32319);
          throw paramVarArgs;
        }
        if (this.FyT == null)
        {
          paramVarArgs = new b("Not all required fields were included: SessionKey");
          AppMethodBeat.o(32319);
          throw paramVarArgs;
        }
        if (this.GHI == null)
        {
          paramVarArgs = new b("Not all required fields were included: SessionBuffer");
          AppMethodBeat.o(32319);
          throw paramVarArgs;
        }
        if (this.GHJ == null)
        {
          paramVarArgs = new b("Not all required fields were included: KeyBuffer");
          AppMethodBeat.o(32319);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32319);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bnm localbnm = (bnm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32319);
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
            localbnm.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32319);
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
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbnm.FyT = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32319);
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
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbnm.GHI = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32319);
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
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbnm.GHJ = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32319);
          return 0;
        case 5: 
          localbnm.GHK = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32319);
          return 0;
        case 6: 
          localbnm.GHL = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(32319);
          return 0;
        }
        localbnm.GHM = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(32319);
        return 0;
      }
      AppMethodBeat.o(32319);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bnm
 * JD-Core Version:    0.7.0.1
 */