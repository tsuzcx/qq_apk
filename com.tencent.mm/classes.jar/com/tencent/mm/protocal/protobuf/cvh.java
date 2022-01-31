package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cvh
  extends com.tencent.mm.bv.a
{
  public SKBuiltinBuffer_t woT;
  public String wwk;
  public SKBuiltinBuffer_t wwo;
  public String ydL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(58940);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wwo == null)
      {
        paramVarArgs = new b("Not all required fields were included: KSid");
        AppMethodBeat.o(58940);
        throw paramVarArgs;
      }
      if (this.woT == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuf");
        AppMethodBeat.o(58940);
        throw paramVarArgs;
      }
      if (this.ydL != null) {
        paramVarArgs.e(1, this.ydL);
      }
      if (this.wwo != null)
      {
        paramVarArgs.iQ(2, this.wwo.computeSize());
        this.wwo.writeFields(paramVarArgs);
      }
      if (this.wwk != null) {
        paramVarArgs.e(3, this.wwk);
      }
      if (this.woT != null)
      {
        paramVarArgs.iQ(4, this.woT.computeSize());
        this.woT.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(58940);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ydL == null) {
        break label682;
      }
    }
    label682:
    for (int i = e.a.a.b.b.a.f(1, this.ydL) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wwo != null) {
        paramInt = i + e.a.a.a.iP(2, this.wwo.computeSize());
      }
      i = paramInt;
      if (this.wwk != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wwk);
      }
      paramInt = i;
      if (this.woT != null) {
        paramInt = i + e.a.a.a.iP(4, this.woT.computeSize());
      }
      AppMethodBeat.o(58940);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.wwo == null)
        {
          paramVarArgs = new b("Not all required fields were included: KSid");
          AppMethodBeat.o(58940);
          throw paramVarArgs;
        }
        if (this.woT == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImgBuf");
          AppMethodBeat.o(58940);
          throw paramVarArgs;
        }
        AppMethodBeat.o(58940);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cvh localcvh = (cvh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(58940);
          return -1;
        case 1: 
          localcvh.ydL = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(58940);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcvh.wwo = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(58940);
          return 0;
        case 3: 
          localcvh.wwk = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(58940);
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
          localcvh.woT = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(58940);
        return 0;
      }
      AppMethodBeat.o(58940);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvh
 * JD-Core Version:    0.7.0.1
 */