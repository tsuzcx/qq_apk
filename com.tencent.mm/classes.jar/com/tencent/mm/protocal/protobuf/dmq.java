package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dmq
  extends cpx
{
  public String FEI;
  public int FUl;
  public int FUm;
  public String FUn;
  public int FUo;
  public String FUp;
  public LinkedList<dcm> FUq;
  public int FUr;
  public int FUs;
  public int bRK;
  public String cIZ;
  public String dda;
  public String hiX;
  
  public dmq()
  {
    AppMethodBeat.i(116818);
    this.FUq = new LinkedList();
    AppMethodBeat.o(116818);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116819);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ln(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.cIZ != null) {
        paramVarArgs.d(2, this.cIZ);
      }
      if (this.dda != null) {
        paramVarArgs.d(3, this.dda);
      }
      paramVarArgs.aR(4, this.FUl);
      paramVarArgs.aR(5, this.FUm);
      paramVarArgs.aR(6, this.bRK);
      if (this.FUn != null) {
        paramVarArgs.d(7, this.FUn);
      }
      if (this.FEI != null) {
        paramVarArgs.d(8, this.FEI);
      }
      if (this.hiX != null) {
        paramVarArgs.d(9, this.hiX);
      }
      paramVarArgs.aR(10, this.FUo);
      if (this.FUp != null) {
        paramVarArgs.d(11, this.FUp);
      }
      paramVarArgs.e(12, 8, this.FUq);
      paramVarArgs.aR(13, this.FUr);
      paramVarArgs.aR(14, this.FUs);
      AppMethodBeat.o(116819);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1094;
      }
    }
    label1094:
    for (int i = f.a.a.a.lm(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.cIZ != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.cIZ);
      }
      i = paramInt;
      if (this.dda != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.dda);
      }
      i = i + f.a.a.b.b.a.bx(4, this.FUl) + f.a.a.b.b.a.bx(5, this.FUm) + f.a.a.b.b.a.bx(6, this.bRK);
      paramInt = i;
      if (this.FUn != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FUn);
      }
      i = paramInt;
      if (this.FEI != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.FEI);
      }
      paramInt = i;
      if (this.hiX != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.hiX);
      }
      i = paramInt + f.a.a.b.b.a.bx(10, this.FUo);
      paramInt = i;
      if (this.FUp != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.FUp);
      }
      i = f.a.a.a.c(12, 8, this.FUq);
      int j = f.a.a.b.b.a.bx(13, this.FUr);
      int k = f.a.a.b.b.a.bx(14, this.FUs);
      AppMethodBeat.o(116819);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FUq.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cpx.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cpx.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(116819);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dmq localdmq = (dmq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(116819);
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
            localdmq.BaseRequest = ((iv)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116819);
          return 0;
        case 2: 
          localdmq.cIZ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(116819);
          return 0;
        case 3: 
          localdmq.dda = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(116819);
          return 0;
        case 4: 
          localdmq.FUl = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(116819);
          return 0;
        case 5: 
          localdmq.FUm = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(116819);
          return 0;
        case 6: 
          localdmq.bRK = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(116819);
          return 0;
        case 7: 
          localdmq.FUn = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(116819);
          return 0;
        case 8: 
          localdmq.FEI = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(116819);
          return 0;
        case 9: 
          localdmq.hiX = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(116819);
          return 0;
        case 10: 
          localdmq.FUo = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(116819);
          return 0;
        case 11: 
          localdmq.FUp = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(116819);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dcm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dcm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cpx.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdmq.FUq.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(116819);
          return 0;
        case 13: 
          localdmq.FUr = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(116819);
          return 0;
        }
        localdmq.FUs = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(116819);
        return 0;
      }
      AppMethodBeat.o(116819);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmq
 * JD-Core Version:    0.7.0.1
 */