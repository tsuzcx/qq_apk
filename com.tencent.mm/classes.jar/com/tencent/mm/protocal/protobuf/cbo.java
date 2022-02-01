package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cbo
  extends cqk
{
  public int DKD;
  public cma EmH;
  public long FpA;
  public LinkedList<bir> FpB;
  public String FpC;
  public String FpD;
  public String FpE;
  public int FpF;
  public int FpG;
  public String FpH;
  public int Fpw;
  public int Fpx;
  public int Fpy;
  public long Fpz;
  public long dBN;
  public int ugF;
  public int ugG;
  public String ugH;
  public String ugI;
  public String ugJ;
  
  public cbo()
  {
    AppMethodBeat.i(91566);
    this.FpB = new LinkedList();
    AppMethodBeat.o(91566);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91567);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91567);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(2, this.Fpw);
      paramVarArgs.aR(3, this.Fpx);
      paramVarArgs.aR(4, this.ugF);
      paramVarArgs.aO(5, this.dBN);
      paramVarArgs.aR(6, this.Fpy);
      paramVarArgs.aO(7, this.Fpz);
      paramVarArgs.aR(8, this.DKD);
      paramVarArgs.aO(9, this.FpA);
      paramVarArgs.aR(10, this.ugG);
      paramVarArgs.e(11, 8, this.FpB);
      if (this.ugH != null) {
        paramVarArgs.d(12, this.ugH);
      }
      if (this.FpC != null) {
        paramVarArgs.d(13, this.FpC);
      }
      if (this.FpD != null) {
        paramVarArgs.d(14, this.FpD);
      }
      if (this.FpE != null) {
        paramVarArgs.d(15, this.FpE);
      }
      paramVarArgs.aR(16, this.FpF);
      if (this.ugJ != null) {
        paramVarArgs.d(17, this.ugJ);
      }
      paramVarArgs.aR(18, this.FpG);
      if (this.ugI != null) {
        paramVarArgs.d(19, this.ugI);
      }
      if (this.EmH != null)
      {
        paramVarArgs.ln(20, this.EmH.computeSize());
        this.EmH.writeFields(paramVarArgs);
      }
      if (this.FpH != null) {
        paramVarArgs.d(21, this.FpH);
      }
      AppMethodBeat.o(91567);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1570;
      }
    }
    label1570:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.Fpw) + f.a.a.b.b.a.bx(3, this.Fpx) + f.a.a.b.b.a.bx(4, this.ugF) + f.a.a.b.b.a.p(5, this.dBN) + f.a.a.b.b.a.bx(6, this.Fpy) + f.a.a.b.b.a.p(7, this.Fpz) + f.a.a.b.b.a.bx(8, this.DKD) + f.a.a.b.b.a.p(9, this.FpA) + f.a.a.b.b.a.bx(10, this.ugG) + f.a.a.a.c(11, 8, this.FpB);
      paramInt = i;
      if (this.ugH != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.ugH);
      }
      i = paramInt;
      if (this.FpC != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.FpC);
      }
      paramInt = i;
      if (this.FpD != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.FpD);
      }
      i = paramInt;
      if (this.FpE != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.FpE);
      }
      i += f.a.a.b.b.a.bx(16, this.FpF);
      paramInt = i;
      if (this.ugJ != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.ugJ);
      }
      i = paramInt + f.a.a.b.b.a.bx(18, this.FpG);
      paramInt = i;
      if (this.ugI != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.ugI);
      }
      i = paramInt;
      if (this.EmH != null) {
        i = paramInt + f.a.a.a.lm(20, this.EmH.computeSize());
      }
      paramInt = i;
      if (this.FpH != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.FpH);
      }
      AppMethodBeat.o(91567);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FpB.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cqk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cqk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91567);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91567);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cbo localcbo = (cbo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91567);
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
            localcbo.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91567);
          return 0;
        case 2: 
          localcbo.Fpw = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91567);
          return 0;
        case 3: 
          localcbo.Fpx = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91567);
          return 0;
        case 4: 
          localcbo.ugF = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91567);
          return 0;
        case 5: 
          localcbo.dBN = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(91567);
          return 0;
        case 6: 
          localcbo.Fpy = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91567);
          return 0;
        case 7: 
          localcbo.Fpz = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(91567);
          return 0;
        case 8: 
          localcbo.DKD = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91567);
          return 0;
        case 9: 
          localcbo.FpA = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(91567);
          return 0;
        case 10: 
          localcbo.ugG = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91567);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bir();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bir)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcbo.FpB.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91567);
          return 0;
        case 12: 
          localcbo.ugH = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91567);
          return 0;
        case 13: 
          localcbo.FpC = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91567);
          return 0;
        case 14: 
          localcbo.FpD = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91567);
          return 0;
        case 15: 
          localcbo.FpE = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91567);
          return 0;
        case 16: 
          localcbo.FpF = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91567);
          return 0;
        case 17: 
          localcbo.ugJ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91567);
          return 0;
        case 18: 
          localcbo.FpG = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91567);
          return 0;
        case 19: 
          localcbo.ugI = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91567);
          return 0;
        case 20: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cma();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cma)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcbo.EmH = ((cma)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91567);
          return 0;
        }
        localcbo.FpH = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91567);
        return 0;
      }
      AppMethodBeat.o(91567);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbo
 * JD-Core Version:    0.7.0.1
 */