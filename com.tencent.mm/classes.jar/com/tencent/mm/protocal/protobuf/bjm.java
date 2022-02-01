package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bjm
  extends com.tencent.mm.bw.a
{
  public long ETS;
  public String EYC;
  public bjn EYD;
  public String EYE;
  public int EYF;
  public int EYG;
  public long EYH;
  public String EYI;
  public String EYJ;
  public int EYK;
  public String EYL;
  public String EYM;
  public String EYN;
  public String EYO;
  public String EYP;
  public int EYQ;
  public String EYR;
  public int EbO;
  public String Etc;
  public int cDF;
  public int hhv;
  public int subType;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91520);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EYC != null) {
        paramVarArgs.d(1, this.EYC);
      }
      paramVarArgs.aR(2, this.subType);
      if (this.Etc != null) {
        paramVarArgs.d(3, this.Etc);
      }
      if (this.EYD != null)
      {
        paramVarArgs.ln(4, this.EYD.computeSize());
        this.EYD.writeFields(paramVarArgs);
      }
      if (this.EYE != null) {
        paramVarArgs.d(5, this.EYE);
      }
      paramVarArgs.aR(6, this.EYF);
      paramVarArgs.aR(7, this.EYG);
      paramVarArgs.aO(8, this.EYH);
      paramVarArgs.aR(9, this.hhv);
      paramVarArgs.aR(10, this.EbO);
      if (this.EYI != null) {
        paramVarArgs.d(11, this.EYI);
      }
      if (this.EYJ != null) {
        paramVarArgs.d(12, this.EYJ);
      }
      paramVarArgs.aR(13, this.EYK);
      if (this.EYL != null) {
        paramVarArgs.d(14, this.EYL);
      }
      if (this.EYM != null) {
        paramVarArgs.d(15, this.EYM);
      }
      if (this.EYN != null) {
        paramVarArgs.d(16, this.EYN);
      }
      if (this.EYO != null) {
        paramVarArgs.d(17, this.EYO);
      }
      if (this.EYP != null) {
        paramVarArgs.d(18, this.EYP);
      }
      paramVarArgs.aR(19, this.EYQ);
      paramVarArgs.aO(20, this.ETS);
      paramVarArgs.aR(21, this.cDF);
      if (this.EYR != null) {
        paramVarArgs.d(22, this.EYR);
      }
      AppMethodBeat.o(91520);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EYC == null) {
        break label1434;
      }
    }
    label1434:
    for (paramInt = f.a.a.b.b.a.e(1, this.EYC) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.subType);
      paramInt = i;
      if (this.Etc != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Etc);
      }
      i = paramInt;
      if (this.EYD != null) {
        i = paramInt + f.a.a.a.lm(4, this.EYD.computeSize());
      }
      paramInt = i;
      if (this.EYE != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.EYE);
      }
      i = paramInt + f.a.a.b.b.a.bx(6, this.EYF) + f.a.a.b.b.a.bx(7, this.EYG) + f.a.a.b.b.a.p(8, this.EYH) + f.a.a.b.b.a.bx(9, this.hhv) + f.a.a.b.b.a.bx(10, this.EbO);
      paramInt = i;
      if (this.EYI != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.EYI);
      }
      i = paramInt;
      if (this.EYJ != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.EYJ);
      }
      i += f.a.a.b.b.a.bx(13, this.EYK);
      paramInt = i;
      if (this.EYL != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.EYL);
      }
      i = paramInt;
      if (this.EYM != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.EYM);
      }
      paramInt = i;
      if (this.EYN != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.EYN);
      }
      i = paramInt;
      if (this.EYO != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.EYO);
      }
      paramInt = i;
      if (this.EYP != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.EYP);
      }
      i = paramInt + f.a.a.b.b.a.bx(19, this.EYQ) + f.a.a.b.b.a.p(20, this.ETS) + f.a.a.b.b.a.bx(21, this.cDF);
      paramInt = i;
      if (this.EYR != null) {
        paramInt = i + f.a.a.b.b.a.e(22, this.EYR);
      }
      AppMethodBeat.o(91520);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(91520);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bjm localbjm = (bjm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91520);
          return -1;
        case 1: 
          localbjm.EYC = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91520);
          return 0;
        case 2: 
          localbjm.subType = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91520);
          return 0;
        case 3: 
          localbjm.Etc = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91520);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bjn();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((bjn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbjm.EYD = ((bjn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91520);
          return 0;
        case 5: 
          localbjm.EYE = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91520);
          return 0;
        case 6: 
          localbjm.EYF = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91520);
          return 0;
        case 7: 
          localbjm.EYG = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91520);
          return 0;
        case 8: 
          localbjm.EYH = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(91520);
          return 0;
        case 9: 
          localbjm.hhv = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91520);
          return 0;
        case 10: 
          localbjm.EbO = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91520);
          return 0;
        case 11: 
          localbjm.EYI = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91520);
          return 0;
        case 12: 
          localbjm.EYJ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91520);
          return 0;
        case 13: 
          localbjm.EYK = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91520);
          return 0;
        case 14: 
          localbjm.EYL = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91520);
          return 0;
        case 15: 
          localbjm.EYM = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91520);
          return 0;
        case 16: 
          localbjm.EYN = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91520);
          return 0;
        case 17: 
          localbjm.EYO = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91520);
          return 0;
        case 18: 
          localbjm.EYP = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(91520);
          return 0;
        case 19: 
          localbjm.EYQ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91520);
          return 0;
        case 20: 
          localbjm.ETS = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(91520);
          return 0;
        case 21: 
          localbjm.cDF = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(91520);
          return 0;
        }
        localbjm.EYR = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(91520);
        return 0;
      }
      AppMethodBeat.o(91520);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bjm
 * JD-Core Version:    0.7.0.1
 */