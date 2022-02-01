package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cku
  extends cqk
{
  public int DKD;
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
  
  public cku()
  {
    AppMethodBeat.i(91656);
    this.FpB = new LinkedList();
    AppMethodBeat.o(91656);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91657);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91657);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.ln(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.dBN);
      paramVarArgs.aR(3, this.Fpy);
      paramVarArgs.aO(4, this.Fpz);
      paramVarArgs.aR(5, this.DKD);
      paramVarArgs.aO(6, this.FpA);
      paramVarArgs.aR(9, this.ugG);
      paramVarArgs.e(10, 8, this.FpB);
      if (this.ugH != null) {
        paramVarArgs.d(11, this.ugH);
      }
      if (this.FpC != null) {
        paramVarArgs.d(12, this.FpC);
      }
      if (this.FpD != null) {
        paramVarArgs.d(13, this.FpD);
      }
      if (this.FpE != null) {
        paramVarArgs.d(14, this.FpE);
      }
      paramVarArgs.aR(15, this.FpF);
      if (this.ugJ != null) {
        paramVarArgs.d(16, this.ugJ);
      }
      paramVarArgs.aR(17, this.FpG);
      if (this.ugI != null) {
        paramVarArgs.d(18, this.ugI);
      }
      paramVarArgs.aR(19, this.Fpx);
      paramVarArgs.aR(20, this.ugF);
      paramVarArgs.aR(21, this.Fpw);
      if (this.FpH != null) {
        paramVarArgs.d(22, this.FpH);
      }
      AppMethodBeat.o(91657);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1426;
      }
    }
    label1426:
    for (paramInt = f.a.a.a.lm(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.dBN) + f.a.a.b.b.a.bx(3, this.Fpy) + f.a.a.b.b.a.p(4, this.Fpz) + f.a.a.b.b.a.bx(5, this.DKD) + f.a.a.b.b.a.p(6, this.FpA) + f.a.a.b.b.a.bx(9, this.ugG) + f.a.a.a.c(10, 8, this.FpB);
      paramInt = i;
      if (this.ugH != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.ugH);
      }
      i = paramInt;
      if (this.FpC != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.FpC);
      }
      paramInt = i;
      if (this.FpD != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.FpD);
      }
      i = paramInt;
      if (this.FpE != null) {
        i = paramInt + f.a.a.b.b.a.e(14, this.FpE);
      }
      i += f.a.a.b.b.a.bx(15, this.FpF);
      paramInt = i;
      if (this.ugJ != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.ugJ);
      }
      i = paramInt + f.a.a.b.b.a.bx(17, this.FpG);
      paramInt = i;
      if (this.ugI != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.ugI);
      }
      i = paramInt + f.a.a.b.b.a.bx(19, this.Fpx) + f.a.a.b.b.a.bx(20, this.ugF) + f.a.a.b.b.a.bx(21, this.Fpw);
      paramInt = i;
      if (this.FpH != null) {
        paramInt = i + f.a.a.b.b.a.e(22, this.FpH);
      }
      AppMethodBeat.o(91657);
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
          AppMethodBeat.o(91657);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91657);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cku localcku = (cku)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 7: 
        case 8: 
        default: 
          AppMethodBeat.o(91657);
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
            localcku.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91657);
          return 0;
        case 2: 
          localcku.dBN = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(91657);
          return 0;
        case 3: 
          localcku.Fpy = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91657);
          return 0;
        case 4: 
          localcku.Fpz = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(91657);
          return 0;
        case 5: 
          localcku.DKD = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91657);
          return 0;
        case 6: 
          localcku.FpA = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(91657);
          return 0;
        case 9: 
          localcku.ugG = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91657);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bir();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bir)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cqk.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcku.FpB.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91657);
          return 0;
        case 11: 
          localcku.ugH = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91657);
          return 0;
        case 12: 
          localcku.FpC = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91657);
          return 0;
        case 13: 
          localcku.FpD = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91657);
          return 0;
        case 14: 
          localcku.FpE = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91657);
          return 0;
        case 15: 
          localcku.FpF = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91657);
          return 0;
        case 16: 
          localcku.ugJ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91657);
          return 0;
        case 17: 
          localcku.FpG = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91657);
          return 0;
        case 18: 
          localcku.ugI = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91657);
          return 0;
        case 19: 
          localcku.Fpx = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91657);
          return 0;
        case 20: 
          localcku.ugF = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91657);
          return 0;
        case 21: 
          localcku.Fpw = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91657);
          return 0;
        }
        localcku.FpH = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91657);
        return 0;
      }
      AppMethodBeat.o(91657);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cku
 * JD-Core Version:    0.7.0.1
 */