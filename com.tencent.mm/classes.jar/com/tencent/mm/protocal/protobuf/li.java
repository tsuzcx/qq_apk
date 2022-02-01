package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class li
  extends cpx
{
  public SKBuiltinBuffer_t DWx;
  public String DYF;
  public int DYR;
  public String DYS;
  public String DYT;
  public String DYU;
  public int DYV;
  public crm DYW;
  public SKBuiltinBuffer_t DYX;
  public int DYY;
  public String DYs;
  public String DYt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155396);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.DYR);
      if (this.DYF != null) {
        paramVarArgs.d(3, this.DYF);
      }
      if (this.DYS != null) {
        paramVarArgs.d(4, this.DYS);
      }
      if (this.DYT != null) {
        paramVarArgs.d(5, this.DYT);
      }
      if (this.DYU != null) {
        paramVarArgs.d(6, this.DYU);
      }
      paramVarArgs.aR(7, this.DYV);
      if (this.DYW != null)
      {
        paramVarArgs.ln(8, this.DYW.computeSize());
        this.DYW.writeFields(paramVarArgs);
      }
      if (this.DYX != null)
      {
        paramVarArgs.ln(9, this.DYX.computeSize());
        this.DYX.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(10, this.DYY);
      if (this.DYs != null) {
        paramVarArgs.d(11, this.DYs);
      }
      if (this.DYt != null) {
        paramVarArgs.d(12, this.DYt);
      }
      if (this.DWx != null)
      {
        paramVarArgs.ln(13, this.DWx.computeSize());
        this.DWx.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(155396);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1282;
      }
    }
    label1282:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.DYR);
      paramInt = i;
      if (this.DYF != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.DYF);
      }
      i = paramInt;
      if (this.DYS != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.DYS);
      }
      paramInt = i;
      if (this.DYT != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.DYT);
      }
      i = paramInt;
      if (this.DYU != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.DYU);
      }
      i += f.a.a.b.b.a.bx(7, this.DYV);
      paramInt = i;
      if (this.DYW != null) {
        paramInt = i + f.a.a.a.lm(8, this.DYW.computeSize());
      }
      i = paramInt;
      if (this.DYX != null) {
        i = paramInt + f.a.a.a.lm(9, this.DYX.computeSize());
      }
      i += f.a.a.b.b.a.bx(10, this.DYY);
      paramInt = i;
      if (this.DYs != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.DYs);
      }
      i = paramInt;
      if (this.DYt != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.DYt);
      }
      paramInt = i;
      if (this.DWx != null) {
        paramInt = i + f.a.a.a.lm(13, this.DWx.computeSize());
      }
      AppMethodBeat.o(155396);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(155396);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        li localli = (li)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155396);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new iv();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((iv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localli.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155396);
          return 0;
        case 2: 
          localli.DYR = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(155396);
          return 0;
        case 3: 
          localli.DYF = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(155396);
          return 0;
        case 4: 
          localli.DYS = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(155396);
          return 0;
        case 5: 
          localli.DYT = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(155396);
          return 0;
        case 6: 
          localli.DYU = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(155396);
          return 0;
        case 7: 
          localli.DYV = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(155396);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localli.DYW = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155396);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localli.DYX = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(155396);
          return 0;
        case 10: 
          localli.DYY = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(155396);
          return 0;
        case 11: 
          localli.DYs = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(155396);
          return 0;
        case 12: 
          localli.DYt = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(155396);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localli.DWx = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(155396);
        return 0;
      }
      AppMethodBeat.o(155396);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.li
 * JD-Core Version:    0.7.0.1
 */