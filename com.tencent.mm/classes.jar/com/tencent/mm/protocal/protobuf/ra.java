package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ra
  extends com.tencent.mm.bw.a
{
  public String DMR;
  public String EiC;
  public String EiD;
  public String EiE;
  public String EiF;
  public String EiG;
  public LinkedList<qz> EiH;
  public int EiI;
  public String EiJ;
  public String EiK;
  public String EiL;
  public int EiM;
  public String EiN;
  public int EiO;
  public String EiP;
  public int EiQ;
  public String EiR;
  public rm EiS;
  public String EiT;
  
  public ra()
  {
    AppMethodBeat.i(113951);
    this.EiH = new LinkedList();
    AppMethodBeat.o(113951);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113952);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.DMR != null) {
        paramVarArgs.d(1, this.DMR);
      }
      if (this.EiC != null) {
        paramVarArgs.d(2, this.EiC);
      }
      if (this.EiD != null) {
        paramVarArgs.d(3, this.EiD);
      }
      if (this.EiE != null) {
        paramVarArgs.d(4, this.EiE);
      }
      if (this.EiF != null) {
        paramVarArgs.d(5, this.EiF);
      }
      if (this.EiG != null) {
        paramVarArgs.d(6, this.EiG);
      }
      paramVarArgs.e(7, 8, this.EiH);
      paramVarArgs.aR(8, this.EiI);
      if (this.EiJ != null) {
        paramVarArgs.d(9, this.EiJ);
      }
      if (this.EiK != null) {
        paramVarArgs.d(10, this.EiK);
      }
      if (this.EiL != null) {
        paramVarArgs.d(11, this.EiL);
      }
      paramVarArgs.aR(12, this.EiM);
      if (this.EiN != null) {
        paramVarArgs.d(13, this.EiN);
      }
      paramVarArgs.aR(14, this.EiO);
      if (this.EiP != null) {
        paramVarArgs.d(15, this.EiP);
      }
      paramVarArgs.aR(16, this.EiQ);
      if (this.EiR != null) {
        paramVarArgs.d(17, this.EiR);
      }
      if (this.EiS != null)
      {
        paramVarArgs.ln(18, this.EiS.computeSize());
        this.EiS.writeFields(paramVarArgs);
      }
      if (this.EiT != null) {
        paramVarArgs.d(19, this.EiT);
      }
      AppMethodBeat.o(113952);
      return 0;
    }
    if (paramInt == 1) {
      if (this.DMR == null) {
        break label1434;
      }
    }
    label1434:
    for (int i = f.a.a.b.b.a.e(1, this.DMR) + 0;; i = 0)
    {
      paramInt = i;
      if (this.EiC != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.EiC);
      }
      i = paramInt;
      if (this.EiD != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.EiD);
      }
      paramInt = i;
      if (this.EiE != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EiE);
      }
      i = paramInt;
      if (this.EiF != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.EiF);
      }
      paramInt = i;
      if (this.EiG != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.EiG);
      }
      i = paramInt + f.a.a.a.c(7, 8, this.EiH) + f.a.a.b.b.a.bx(8, this.EiI);
      paramInt = i;
      if (this.EiJ != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.EiJ);
      }
      i = paramInt;
      if (this.EiK != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.EiK);
      }
      paramInt = i;
      if (this.EiL != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.EiL);
      }
      i = paramInt + f.a.a.b.b.a.bx(12, this.EiM);
      paramInt = i;
      if (this.EiN != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.EiN);
      }
      i = paramInt + f.a.a.b.b.a.bx(14, this.EiO);
      paramInt = i;
      if (this.EiP != null) {
        paramInt = i + f.a.a.b.b.a.e(15, this.EiP);
      }
      i = paramInt + f.a.a.b.b.a.bx(16, this.EiQ);
      paramInt = i;
      if (this.EiR != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.EiR);
      }
      i = paramInt;
      if (this.EiS != null) {
        i = paramInt + f.a.a.a.lm(18, this.EiS.computeSize());
      }
      paramInt = i;
      if (this.EiT != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.EiT);
      }
      AppMethodBeat.o(113952);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EiH.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(113952);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ra localra = (ra)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113952);
          return -1;
        case 1: 
          localra.DMR = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 2: 
          localra.EiC = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 3: 
          localra.EiD = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 4: 
          localra.EiE = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 5: 
          localra.EiF = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 6: 
          localra.EiG = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new qz();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((qz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localra.EiH.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113952);
          return 0;
        case 8: 
          localra.EiI = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(113952);
          return 0;
        case 9: 
          localra.EiJ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 10: 
          localra.EiK = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 11: 
          localra.EiL = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 12: 
          localra.EiM = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(113952);
          return 0;
        case 13: 
          localra.EiN = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 14: 
          localra.EiO = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(113952);
          return 0;
        case 15: 
          localra.EiP = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 16: 
          localra.EiQ = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(113952);
          return 0;
        case 17: 
          localra.EiR = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(113952);
          return 0;
        case 18: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new rm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((rm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localra.EiS = ((rm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113952);
          return 0;
        }
        localra.EiT = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(113952);
        return 0;
      }
      AppMethodBeat.o(113952);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ra
 * JD-Core Version:    0.7.0.1
 */