package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class jk
  extends com.tencent.mm.bw.a
{
  public SKBuiltinBuffer_t KLe;
  public SKBuiltinBuffer_t KLf;
  public String KLk;
  public SKBuiltinBuffer_t KNX;
  public ewr KNY;
  public fca KNZ;
  public int KOa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133155);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KNX != null)
      {
        paramVarArgs.ni(1, this.KNX.computeSize());
        this.KNX.writeFields(paramVarArgs);
      }
      if (this.KNY != null)
      {
        paramVarArgs.ni(2, this.KNY.computeSize());
        this.KNY.writeFields(paramVarArgs);
      }
      if (this.KNZ != null)
      {
        paramVarArgs.ni(3, this.KNZ.computeSize());
        this.KNZ.writeFields(paramVarArgs);
      }
      if (this.KLe != null)
      {
        paramVarArgs.ni(4, this.KLe.computeSize());
        this.KLe.writeFields(paramVarArgs);
      }
      if (this.KLf != null)
      {
        paramVarArgs.ni(5, this.KLf.computeSize());
        this.KLf.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(6, this.KOa);
      if (this.KLk != null) {
        paramVarArgs.e(7, this.KLk);
      }
      AppMethodBeat.o(133155);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KNX == null) {
        break label1034;
      }
    }
    label1034:
    for (int i = g.a.a.a.nh(1, this.KNX.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.KNY != null) {
        paramInt = i + g.a.a.a.nh(2, this.KNY.computeSize());
      }
      i = paramInt;
      if (this.KNZ != null) {
        i = paramInt + g.a.a.a.nh(3, this.KNZ.computeSize());
      }
      paramInt = i;
      if (this.KLe != null) {
        paramInt = i + g.a.a.a.nh(4, this.KLe.computeSize());
      }
      i = paramInt;
      if (this.KLf != null) {
        i = paramInt + g.a.a.a.nh(5, this.KLf.computeSize());
      }
      i += g.a.a.b.b.a.bu(6, this.KOa);
      paramInt = i;
      if (this.KLk != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.KLk);
      }
      AppMethodBeat.o(133155);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(133155);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        jk localjk = (jk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133155);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localjk.KNX = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133155);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ewr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ewr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localjk.KNY = ((ewr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133155);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new fca();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((fca)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localjk.KNZ = ((fca)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133155);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localjk.KLe = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133155);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localjk.KLf = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133155);
          return 0;
        case 6: 
          localjk.KOa = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(133155);
          return 0;
        }
        localjk.KLk = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(133155);
        return 0;
      }
      AppMethodBeat.o(133155);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.jk
 * JD-Core Version:    0.7.0.1
 */