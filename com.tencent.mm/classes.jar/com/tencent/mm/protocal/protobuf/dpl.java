package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class dpl
  extends cpx
{
  public int DUY;
  public SKBuiltinBuffer_t DUq;
  public SKBuiltinBuffer_t DUr;
  public String EUa;
  public int FWM;
  public LinkedList<dpi> FWN;
  public int FWO;
  public LinkedList<Integer> FWP;
  public int FWQ;
  public LinkedList<dpk> FWR;
  public int FWS;
  
  public dpl()
  {
    AppMethodBeat.i(152726);
    this.FWN = new LinkedList();
    this.FWP = new LinkedList();
    this.FWR = new LinkedList();
    AppMethodBeat.o(152726);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152727);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.DUY);
      paramVarArgs.aR(3, this.FWM);
      paramVarArgs.e(4, 8, this.FWN);
      if (this.EUa != null) {
        paramVarArgs.d(5, this.EUa);
      }
      paramVarArgs.aR(6, this.FWO);
      paramVarArgs.f(7, 2, this.FWP);
      paramVarArgs.aR(8, this.FWQ);
      paramVarArgs.e(9, 8, this.FWR);
      if (this.DUq != null)
      {
        paramVarArgs.ln(10, this.DUq.computeSize());
        this.DUq.writeFields(paramVarArgs);
      }
      if (this.DUr != null)
      {
        paramVarArgs.ln(11, this.DUr.computeSize());
        this.DUr.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(12, this.FWS);
      AppMethodBeat.o(152727);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1253;
      }
    }
    label1253:
    for (paramInt = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.DUY) + f.a.a.b.b.a.bx(3, this.FWM) + f.a.a.a.c(4, 8, this.FWN);
      paramInt = i;
      if (this.EUa != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.EUa);
      }
      i = paramInt + f.a.a.b.b.a.bx(6, this.FWO) + f.a.a.a.d(7, 2, this.FWP) + f.a.a.b.b.a.bx(8, this.FWQ) + f.a.a.a.c(9, 8, this.FWR);
      paramInt = i;
      if (this.DUq != null) {
        paramInt = i + f.a.a.a.lm(10, this.DUq.computeSize());
      }
      i = paramInt;
      if (this.DUr != null) {
        i = paramInt + f.a.a.a.lm(11, this.DUr.computeSize());
      }
      paramInt = f.a.a.b.b.a.bx(12, this.FWS);
      AppMethodBeat.o(152727);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FWN.clear();
        this.FWP.clear();
        this.FWR.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(152727);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dpl localdpl = (dpl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152727);
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
            localdpl.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152727);
          return 0;
        case 2: 
          localdpl.DUY = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152727);
          return 0;
        case 3: 
          localdpl.FWM = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152727);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dpi();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dpi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdpl.FWN.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152727);
          return 0;
        case 5: 
          localdpl.EUa = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152727);
          return 0;
        case 6: 
          localdpl.FWO = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152727);
          return 0;
        case 7: 
          localdpl.FWP = new f.a.a.a.a(((f.a.a.a.a)localObject1).LVo.gfk().xy, unknownTagHandler).LVo.gfi();
          AppMethodBeat.o(152727);
          return 0;
        case 8: 
          localdpl.FWQ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152727);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dpk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dpk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdpl.FWR.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152727);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdpl.DUq = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152727);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdpl.DUr = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152727);
          return 0;
        }
        localdpl.FWS = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(152727);
        return 0;
      }
      AppMethodBeat.o(152727);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpl
 * JD-Core Version:    0.7.0.1
 */