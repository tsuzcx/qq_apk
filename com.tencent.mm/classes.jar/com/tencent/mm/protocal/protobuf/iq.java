package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class iq
  extends com.tencent.mm.bw.a
{
  public SKBuiltinBuffer_t DTF;
  public SKBuiltinBuffer_t DTG;
  public String DTL;
  public int DWA;
  public SKBuiltinBuffer_t DWx;
  public duy DWy;
  public dzn DWz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133155);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DWx != null)
      {
        paramVarArgs.ln(1, this.DWx.computeSize());
        this.DWx.writeFields(paramVarArgs);
      }
      if (this.DWy != null)
      {
        paramVarArgs.ln(2, this.DWy.computeSize());
        this.DWy.writeFields(paramVarArgs);
      }
      if (this.DWz != null)
      {
        paramVarArgs.ln(3, this.DWz.computeSize());
        this.DWz.writeFields(paramVarArgs);
      }
      if (this.DTF != null)
      {
        paramVarArgs.ln(4, this.DTF.computeSize());
        this.DTF.writeFields(paramVarArgs);
      }
      if (this.DTG != null)
      {
        paramVarArgs.ln(5, this.DTG.computeSize());
        this.DTG.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(6, this.DWA);
      if (this.DTL != null) {
        paramVarArgs.d(7, this.DTL);
      }
      AppMethodBeat.o(133155);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DWx == null) {
        break label1034;
      }
    }
    label1034:
    for (int i = f.a.a.a.lm(1, this.DWx.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.DWy != null) {
        paramInt = i + f.a.a.a.lm(2, this.DWy.computeSize());
      }
      i = paramInt;
      if (this.DWz != null) {
        i = paramInt + f.a.a.a.lm(3, this.DWz.computeSize());
      }
      paramInt = i;
      if (this.DTF != null) {
        paramInt = i + f.a.a.a.lm(4, this.DTF.computeSize());
      }
      i = paramInt;
      if (this.DTG != null) {
        i = paramInt + f.a.a.a.lm(5, this.DTG.computeSize());
      }
      i += f.a.a.b.b.a.bx(6, this.DWA);
      paramInt = i;
      if (this.DTL != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.DTL);
      }
      AppMethodBeat.o(133155);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(133155);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        iq localiq = (iq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133155);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localiq.DWx = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133155);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new duy();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((duy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localiq.DWy = ((duy)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133155);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dzn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dzn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localiq.DWz = ((dzn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133155);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localiq.DTF = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133155);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localiq.DTG = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(133155);
          return 0;
        case 6: 
          localiq.DWA = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(133155);
          return 0;
        }
        localiq.DTL = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(133155);
        return 0;
      }
      AppMethodBeat.o(133155);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.iq
 * JD-Core Version:    0.7.0.1
 */