package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ik
  extends com.tencent.mm.bx.a
{
  public SKBuiltinBuffer_t CBh;
  public SKBuiltinBuffer_t CBi;
  public String CBn;
  public SKBuiltinBuffer_t CDX;
  public dph CDY;
  public dtw CDZ;
  public int CEa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133155);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CDX != null)
      {
        paramVarArgs.kX(1, this.CDX.computeSize());
        this.CDX.writeFields(paramVarArgs);
      }
      if (this.CDY != null)
      {
        paramVarArgs.kX(2, this.CDY.computeSize());
        this.CDY.writeFields(paramVarArgs);
      }
      if (this.CDZ != null)
      {
        paramVarArgs.kX(3, this.CDZ.computeSize());
        this.CDZ.writeFields(paramVarArgs);
      }
      if (this.CBh != null)
      {
        paramVarArgs.kX(4, this.CBh.computeSize());
        this.CBh.writeFields(paramVarArgs);
      }
      if (this.CBi != null)
      {
        paramVarArgs.kX(5, this.CBi.computeSize());
        this.CBi.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(6, this.CEa);
      if (this.CBn != null) {
        paramVarArgs.d(7, this.CBn);
      }
      AppMethodBeat.o(133155);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CDX == null) {
        break label1034;
      }
    }
    label1034:
    for (int i = f.a.a.a.kW(1, this.CDX.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CDY != null) {
        paramInt = i + f.a.a.a.kW(2, this.CDY.computeSize());
      }
      i = paramInt;
      if (this.CDZ != null) {
        i = paramInt + f.a.a.a.kW(3, this.CDZ.computeSize());
      }
      paramInt = i;
      if (this.CBh != null) {
        paramInt = i + f.a.a.a.kW(4, this.CBh.computeSize());
      }
      i = paramInt;
      if (this.CBi != null) {
        i = paramInt + f.a.a.a.kW(5, this.CBi.computeSize());
      }
      i += f.a.a.b.b.a.bA(6, this.CEa);
      paramInt = i;
      if (this.CBn != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.CBn);
      }
      AppMethodBeat.o(133155);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(133155);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ik localik = (ik)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133155);
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
            localik.CDX = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133155);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dph();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dph)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localik.CDY = ((dph)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133155);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dtw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dtw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localik.CDZ = ((dtw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133155);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localik.CBh = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133155);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localik.CBi = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133155);
          return 0;
        case 6: 
          localik.CEa = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(133155);
          return 0;
        }
        localik.CBn = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(133155);
        return 0;
      }
      AppMethodBeat.o(133155);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ik
 * JD-Core Version:    0.7.0.1
 */