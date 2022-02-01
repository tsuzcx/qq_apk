package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dpc
  extends cpx
{
  public SKBuiltinBuffer_t DWx;
  public String DYS;
  public crm DYW;
  public SKBuiltinBuffer_t DYX;
  public crm EVt;
  public int FHb;
  public String FWu;
  public crm FWv;
  public int OpCode;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43133);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.OpCode);
      if (this.FWu != null) {
        paramVarArgs.d(3, this.FWu);
      }
      if (this.DYS != null) {
        paramVarArgs.d(4, this.DYS);
      }
      if (this.EVt != null)
      {
        paramVarArgs.ln(5, this.EVt.computeSize());
        this.EVt.writeFields(paramVarArgs);
      }
      if (this.FWv != null)
      {
        paramVarArgs.ln(6, this.FWv.computeSize());
        this.FWv.writeFields(paramVarArgs);
      }
      if (this.DYW != null)
      {
        paramVarArgs.ln(7, this.DYW.computeSize());
        this.DYW.writeFields(paramVarArgs);
      }
      if (this.DYX != null)
      {
        paramVarArgs.ln(8, this.DYX.computeSize());
        this.DYX.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(9, this.FHb);
      if (this.DWx != null)
      {
        paramVarArgs.ln(10, this.DWx.computeSize());
        this.DWx.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(43133);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1298;
      }
    }
    label1298:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.OpCode);
      paramInt = i;
      if (this.FWu != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.FWu);
      }
      i = paramInt;
      if (this.DYS != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.DYS);
      }
      paramInt = i;
      if (this.EVt != null) {
        paramInt = i + f.a.a.a.lm(5, this.EVt.computeSize());
      }
      i = paramInt;
      if (this.FWv != null) {
        i = paramInt + f.a.a.a.lm(6, this.FWv.computeSize());
      }
      paramInt = i;
      if (this.DYW != null) {
        paramInt = i + f.a.a.a.lm(7, this.DYW.computeSize());
      }
      i = paramInt;
      if (this.DYX != null) {
        i = paramInt + f.a.a.a.lm(8, this.DYX.computeSize());
      }
      i += f.a.a.b.b.a.bx(9, this.FHb);
      paramInt = i;
      if (this.DWx != null) {
        paramInt = i + f.a.a.a.lm(10, this.DWx.computeSize());
      }
      AppMethodBeat.o(43133);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(43133);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dpc localdpc = (dpc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(43133);
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
            localdpc.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43133);
          return 0;
        case 2: 
          localdpc.OpCode = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(43133);
          return 0;
        case 3: 
          localdpc.FWu = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(43133);
          return 0;
        case 4: 
          localdpc.DYS = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(43133);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdpc.EVt = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43133);
          return 0;
        case 6: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdpc.FWv = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43133);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdpc.DYW = ((crm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43133);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdpc.DYX = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(43133);
          return 0;
        case 9: 
          localdpc.FHb = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(43133);
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
          localdpc.DWx = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(43133);
        return 0;
      }
      AppMethodBeat.o(43133);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpc
 * JD-Core Version:    0.7.0.1
 */