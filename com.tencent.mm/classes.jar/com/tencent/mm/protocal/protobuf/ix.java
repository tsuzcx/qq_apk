package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ix
  extends com.tencent.mm.bw.a
{
  public String FRD;
  public SKBuiltinBuffer_t FRx;
  public SKBuiltinBuffer_t FRy;
  public SKBuiltinBuffer_t FUo;
  public ecj FUp;
  public ehi FUq;
  public int FUr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133155);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FUo != null)
      {
        paramVarArgs.lJ(1, this.FUo.computeSize());
        this.FUo.writeFields(paramVarArgs);
      }
      if (this.FUp != null)
      {
        paramVarArgs.lJ(2, this.FUp.computeSize());
        this.FUp.writeFields(paramVarArgs);
      }
      if (this.FUq != null)
      {
        paramVarArgs.lJ(3, this.FUq.computeSize());
        this.FUq.writeFields(paramVarArgs);
      }
      if (this.FRx != null)
      {
        paramVarArgs.lJ(4, this.FRx.computeSize());
        this.FRx.writeFields(paramVarArgs);
      }
      if (this.FRy != null)
      {
        paramVarArgs.lJ(5, this.FRy.computeSize());
        this.FRy.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(6, this.FUr);
      if (this.FRD != null) {
        paramVarArgs.d(7, this.FRD);
      }
      AppMethodBeat.o(133155);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FUo == null) {
        break label1034;
      }
    }
    label1034:
    for (int i = f.a.a.a.lI(1, this.FUo.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FUp != null) {
        paramInt = i + f.a.a.a.lI(2, this.FUp.computeSize());
      }
      i = paramInt;
      if (this.FUq != null) {
        i = paramInt + f.a.a.a.lI(3, this.FUq.computeSize());
      }
      paramInt = i;
      if (this.FRx != null) {
        paramInt = i + f.a.a.a.lI(4, this.FRx.computeSize());
      }
      i = paramInt;
      if (this.FRy != null) {
        i = paramInt + f.a.a.a.lI(5, this.FRy.computeSize());
      }
      i += f.a.a.b.b.a.bz(6, this.FUr);
      paramInt = i;
      if (this.FRD != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FRD);
      }
      AppMethodBeat.o(133155);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(133155);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ix localix = (ix)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133155);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localix.FUo = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133155);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ecj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ecj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localix.FUp = ((ecj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133155);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ehi();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ehi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localix.FUq = ((ehi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133155);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localix.FRx = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133155);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localix.FRy = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133155);
          return 0;
        case 6: 
          localix.FUr = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(133155);
          return 0;
        }
        localix.FRD = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(133155);
        return 0;
      }
      AppMethodBeat.o(133155);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ix
 * JD-Core Version:    0.7.0.1
 */