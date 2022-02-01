package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class bdj
  extends ckq
{
  public SKBuiltinBuffer_t CBk;
  public String DAI;
  public SKBuiltinBuffer_t DpR;
  public int Scene;
  public String mAQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32315);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CBk == null)
      {
        paramVarArgs = new b("Not all required fields were included: A2Key");
        AppMethodBeat.o(32315);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.kX(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.CBk != null)
      {
        paramVarArgs.kX(2, this.CBk.computeSize());
        this.CBk.writeFields(paramVarArgs);
      }
      if (this.mAQ != null) {
        paramVarArgs.d(3, this.mAQ);
      }
      paramVarArgs.aR(4, this.Scene);
      if (this.DAI != null) {
        paramVarArgs.d(5, this.DAI);
      }
      if (this.DpR != null)
      {
        paramVarArgs.kX(6, this.DpR.computeSize());
        this.DpR.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32315);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label846;
      }
    }
    label846:
    for (int i = f.a.a.a.kW(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CBk != null) {
        paramInt = i + f.a.a.a.kW(2, this.CBk.computeSize());
      }
      i = paramInt;
      if (this.mAQ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.mAQ);
      }
      i += f.a.a.b.b.a.bA(4, this.Scene);
      paramInt = i;
      if (this.DAI != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.DAI);
      }
      i = paramInt;
      if (this.DpR != null) {
        i = paramInt + f.a.a.a.kW(6, this.DpR.computeSize());
      }
      AppMethodBeat.o(32315);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = ckq.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = ckq.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.CBk == null)
        {
          paramVarArgs = new b("Not all required fields were included: A2Key");
          AppMethodBeat.o(32315);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32315);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bdj localbdj = (bdj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32315);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ip();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ip)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbdj.BaseRequest = ((ip)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32315);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbdj.CBk = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32315);
          return 0;
        case 3: 
          localbdj.mAQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32315);
          return 0;
        case 4: 
          localbdj.Scene = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(32315);
          return 0;
        case 5: 
          localbdj.DAI = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(32315);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, ckq.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbdj.DpR = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32315);
        return 0;
      }
      AppMethodBeat.o(32315);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bdj
 * JD-Core Version:    0.7.0.1
 */