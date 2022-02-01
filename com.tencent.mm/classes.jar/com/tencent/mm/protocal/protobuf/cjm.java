package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cjm
  extends cqk
{
  public LinkedList<cdp> DLp;
  public dhy EOc;
  public qb EPI;
  public cqw EZC;
  public long Epi;
  public long Epj;
  public bkc Euc;
  public bwt Fxo;
  public int nWx;
  public String nWy;
  
  public cjm()
  {
    AppMethodBeat.i(72560);
    this.DLp = new LinkedList();
    AppMethodBeat.o(72560);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72561);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72561);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.nWx);
      if (this.nWy != null) {
        paramVarArgs.d(3, this.nWy);
      }
      if (this.Euc != null)
      {
        paramVarArgs.ln(4, this.Euc.computeSize());
        this.Euc.writeFields(paramVarArgs);
      }
      paramVarArgs.e(5, 8, this.DLp);
      paramVarArgs.aO(6, this.Epi);
      paramVarArgs.aO(7, this.Epj);
      if (this.EZC != null)
      {
        paramVarArgs.ln(8, this.EZC.computeSize());
        this.EZC.writeFields(paramVarArgs);
      }
      if (this.EPI != null)
      {
        paramVarArgs.ln(9, this.EPI.computeSize());
        this.EPI.writeFields(paramVarArgs);
      }
      if (this.EOc != null)
      {
        paramVarArgs.ln(10, this.EOc.computeSize());
        this.EOc.writeFields(paramVarArgs);
      }
      if (this.Fxo != null)
      {
        paramVarArgs.ln(11, this.Fxo.computeSize());
        this.Fxo.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72561);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1470;
      }
    }
    label1470:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.nWx);
      paramInt = i;
      if (this.nWy != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nWy);
      }
      i = paramInt;
      if (this.Euc != null) {
        i = paramInt + f.a.a.a.lm(4, this.Euc.computeSize());
      }
      i = i + f.a.a.a.c(5, 8, this.DLp) + f.a.a.b.b.a.p(6, this.Epi) + f.a.a.b.b.a.p(7, this.Epj);
      paramInt = i;
      if (this.EZC != null) {
        paramInt = i + f.a.a.a.lm(8, this.EZC.computeSize());
      }
      i = paramInt;
      if (this.EPI != null) {
        i = paramInt + f.a.a.a.lm(9, this.EPI.computeSize());
      }
      paramInt = i;
      if (this.EOc != null) {
        paramInt = i + f.a.a.a.lm(10, this.EOc.computeSize());
      }
      i = paramInt;
      if (this.Fxo != null) {
        i = paramInt + f.a.a.a.lm(11, this.Fxo.computeSize());
      }
      AppMethodBeat.o(72561);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DLp.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72561);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72561);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cjm localcjm = (cjm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72561);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcjm.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72561);
          return 0;
        case 2: 
          localcjm.nWx = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(72561);
          return 0;
        case 3: 
          localcjm.nWy = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(72561);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bkc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bkc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcjm.Euc = ((bkc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72561);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cdp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cdp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcjm.DLp.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72561);
          return 0;
        case 6: 
          localcjm.Epi = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(72561);
          return 0;
        case 7: 
          localcjm.Epj = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(72561);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cqw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cqw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcjm.EZC = ((cqw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72561);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new qb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((qb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcjm.EPI = ((qb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72561);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dhy();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dhy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcjm.EOc = ((dhy)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72561);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bwt();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bwt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcjm.Fxo = ((bwt)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72561);
        return 0;
      }
      AppMethodBeat.o(72561);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjm
 * JD-Core Version:    0.7.0.1
 */