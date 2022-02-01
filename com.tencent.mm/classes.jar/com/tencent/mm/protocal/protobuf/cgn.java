package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cgn
  extends cqk
{
  public String AWH;
  public int AWN;
  public LinkedList<sh> EMe;
  public String Fgx;
  public boolean Fgy;
  public int FuA;
  public long FuB;
  public String FuC;
  public String FuD;
  public String FuE;
  public String FuF;
  public LinkedList<cmz> FuG;
  public blf Fux;
  public chp Fuy;
  public String Fuz;
  public int nWx;
  public String nWy;
  
  public cgn()
  {
    AppMethodBeat.i(91622);
    this.EMe = new LinkedList();
    this.Fgy = true;
    this.FuG = new LinkedList();
    AppMethodBeat.o(91622);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91623);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91623);
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
      if (this.Fux != null)
      {
        paramVarArgs.ln(4, this.Fux.computeSize());
        this.Fux.writeFields(paramVarArgs);
      }
      if (this.Fuy != null)
      {
        paramVarArgs.ln(5, this.Fuy.computeSize());
        this.Fuy.writeFields(paramVarArgs);
      }
      if (this.Fgx != null) {
        paramVarArgs.d(6, this.Fgx);
      }
      paramVarArgs.e(7, 8, this.EMe);
      paramVarArgs.bl(8, this.Fgy);
      paramVarArgs.aR(9, this.AWN);
      if (this.Fuz != null) {
        paramVarArgs.d(10, this.Fuz);
      }
      paramVarArgs.aR(11, this.FuA);
      paramVarArgs.aO(12, this.FuB);
      if (this.AWH != null) {
        paramVarArgs.d(13, this.AWH);
      }
      if (this.FuC != null) {
        paramVarArgs.d(14, this.FuC);
      }
      if (this.FuD != null) {
        paramVarArgs.d(15, this.FuD);
      }
      if (this.FuE != null) {
        paramVarArgs.d(16, this.FuE);
      }
      if (this.FuF != null) {
        paramVarArgs.d(17, this.FuF);
      }
      paramVarArgs.e(18, 8, this.FuG);
      AppMethodBeat.o(91623);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1666;
      }
    }
    label1666:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.nWx);
      paramInt = i;
      if (this.nWy != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.nWy);
      }
      i = paramInt;
      if (this.Fux != null) {
        i = paramInt + f.a.a.a.lm(4, this.Fux.computeSize());
      }
      paramInt = i;
      if (this.Fuy != null) {
        paramInt = i + f.a.a.a.lm(5, this.Fuy.computeSize());
      }
      i = paramInt;
      if (this.Fgx != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.Fgx);
      }
      i = i + f.a.a.a.c(7, 8, this.EMe) + (f.a.a.b.b.a.fK(8) + 1) + f.a.a.b.b.a.bx(9, this.AWN);
      paramInt = i;
      if (this.Fuz != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.Fuz);
      }
      i = paramInt + f.a.a.b.b.a.bx(11, this.FuA) + f.a.a.b.b.a.p(12, this.FuB);
      paramInt = i;
      if (this.AWH != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.AWH);
      }
      i = paramInt;
      if (this.FuC != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.FuC);
      }
      paramInt = i;
      if (this.FuD != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.FuD);
      }
      i = paramInt;
      if (this.FuE != null) {
        i = paramInt + f.a.a.b.b.a.e(16, this.FuE);
      }
      paramInt = i;
      if (this.FuF != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.FuF);
      }
      i = f.a.a.a.c(18, 8, this.FuG);
      AppMethodBeat.o(91623);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EMe.clear();
        this.FuG.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91623);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91623);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cgn localcgn = (cgn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91623);
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
            localcgn.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91623);
          return 0;
        case 2: 
          localcgn.nWx = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91623);
          return 0;
        case 3: 
          localcgn.nWy = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91623);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new blf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((blf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcgn.Fux = ((blf)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91623);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new chp();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((chp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcgn.Fuy = ((chp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91623);
          return 0;
        case 6: 
          localcgn.Fgx = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91623);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new sh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((sh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcgn.EMe.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91623);
          return 0;
        case 8: 
          localcgn.Fgy = ((f.a.a.a.a)localObject1).LVo.fZX();
          AppMethodBeat.o(91623);
          return 0;
        case 9: 
          localcgn.AWN = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91623);
          return 0;
        case 10: 
          localcgn.Fuz = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91623);
          return 0;
        case 11: 
          localcgn.FuA = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91623);
          return 0;
        case 12: 
          localcgn.FuB = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(91623);
          return 0;
        case 13: 
          localcgn.AWH = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91623);
          return 0;
        case 14: 
          localcgn.FuC = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91623);
          return 0;
        case 15: 
          localcgn.FuD = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91623);
          return 0;
        case 16: 
          localcgn.FuE = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91623);
          return 0;
        case 17: 
          localcgn.FuF = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91623);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cmz();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cmz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcgn.FuG.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91623);
        return 0;
      }
      AppMethodBeat.o(91623);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgn
 * JD-Core Version:    0.7.0.1
 */