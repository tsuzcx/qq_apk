package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cll
  extends com.tencent.mm.bw.a
{
  public String DOj;
  public String DOk;
  public String DOl;
  public String DOm;
  public String DOn;
  public String DOo;
  public eco DOp;
  public String EKv;
  public String Eac;
  public int Fmr;
  public String FyN;
  public int FyO;
  public LinkedList<crm> FyP;
  public String FyQ;
  public String FyR;
  public String FyS;
  public String FyT;
  public String FyU;
  public String FyV;
  public String FyW;
  public int FyX;
  public String fZx;
  public int thu;
  public String tii;
  public String tkL;
  
  public cll()
  {
    AppMethodBeat.i(152664);
    this.FyP = new LinkedList();
    AppMethodBeat.o(152664);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152665);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.fZx != null) {
        paramVarArgs.d(1, this.fZx);
      }
      if (this.tkL != null) {
        paramVarArgs.d(2, this.tkL);
      }
      if (this.DOl != null) {
        paramVarArgs.d(3, this.DOl);
      }
      if (this.EKv != null) {
        paramVarArgs.d(4, this.EKv);
      }
      if (this.DOk != null) {
        paramVarArgs.d(5, this.DOk);
      }
      if (this.DOj != null) {
        paramVarArgs.d(6, this.DOj);
      }
      if (this.FyN != null) {
        paramVarArgs.d(7, this.FyN);
      }
      paramVarArgs.aR(8, this.FyO);
      paramVarArgs.e(9, 8, this.FyP);
      if (this.DOm != null) {
        paramVarArgs.d(10, this.DOm);
      }
      if (this.FyQ != null) {
        paramVarArgs.d(11, this.FyQ);
      }
      if (this.FyR != null) {
        paramVarArgs.d(12, this.FyR);
      }
      paramVarArgs.aR(13, this.Fmr);
      if (this.Eac != null) {
        paramVarArgs.d(14, this.Eac);
      }
      if (this.tii != null) {
        paramVarArgs.d(15, this.tii);
      }
      if (this.DOn != null) {
        paramVarArgs.d(16, this.DOn);
      }
      if (this.FyS != null) {
        paramVarArgs.d(17, this.FyS);
      }
      if (this.FyT != null) {
        paramVarArgs.d(18, this.FyT);
      }
      if (this.DOo != null) {
        paramVarArgs.d(19, this.DOo);
      }
      if (this.FyU != null) {
        paramVarArgs.d(20, this.FyU);
      }
      if (this.FyV != null) {
        paramVarArgs.d(21, this.FyV);
      }
      if (this.DOp != null)
      {
        paramVarArgs.ln(22, this.DOp.computeSize());
        this.DOp.writeFields(paramVarArgs);
      }
      if (this.FyW != null) {
        paramVarArgs.d(23, this.FyW);
      }
      paramVarArgs.aR(24, this.FyX);
      paramVarArgs.aR(25, this.thu);
      AppMethodBeat.o(152665);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fZx == null) {
        break label1806;
      }
    }
    label1806:
    for (int i = f.a.a.b.b.a.e(1, this.fZx) + 0;; i = 0)
    {
      paramInt = i;
      if (this.tkL != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.tkL);
      }
      i = paramInt;
      if (this.DOl != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.DOl);
      }
      paramInt = i;
      if (this.EKv != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EKv);
      }
      i = paramInt;
      if (this.DOk != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.DOk);
      }
      paramInt = i;
      if (this.DOj != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.DOj);
      }
      i = paramInt;
      if (this.FyN != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.FyN);
      }
      i = i + f.a.a.b.b.a.bx(8, this.FyO) + f.a.a.a.c(9, 8, this.FyP);
      paramInt = i;
      if (this.DOm != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.DOm);
      }
      i = paramInt;
      if (this.FyQ != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.FyQ);
      }
      paramInt = i;
      if (this.FyR != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.FyR);
      }
      i = paramInt + f.a.a.b.b.a.bx(13, this.Fmr);
      paramInt = i;
      if (this.Eac != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.Eac);
      }
      i = paramInt;
      if (this.tii != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.tii);
      }
      paramInt = i;
      if (this.DOn != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.DOn);
      }
      i = paramInt;
      if (this.FyS != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.FyS);
      }
      paramInt = i;
      if (this.FyT != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.FyT);
      }
      i = paramInt;
      if (this.DOo != null) {
        i = paramInt + f.a.a.b.b.a.e(19, this.DOo);
      }
      paramInt = i;
      if (this.FyU != null) {
        paramInt = i + f.a.a.b.b.a.e(20, this.FyU);
      }
      i = paramInt;
      if (this.FyV != null) {
        i = paramInt + f.a.a.b.b.a.e(21, this.FyV);
      }
      paramInt = i;
      if (this.DOp != null) {
        paramInt = i + f.a.a.a.lm(22, this.DOp.computeSize());
      }
      i = paramInt;
      if (this.FyW != null) {
        i = paramInt + f.a.a.b.b.a.e(23, this.FyW);
      }
      paramInt = f.a.a.b.b.a.bx(24, this.FyX);
      int j = f.a.a.b.b.a.bx(25, this.thu);
      AppMethodBeat.o(152665);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FyP.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(152665);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cll localcll = (cll)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152665);
          return -1;
        case 1: 
          localcll.fZx = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 2: 
          localcll.tkL = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 3: 
          localcll.DOl = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 4: 
          localcll.EKv = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 5: 
          localcll.DOk = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 6: 
          localcll.DOj = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 7: 
          localcll.FyN = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 8: 
          localcll.FyO = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152665);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcll.FyP.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152665);
          return 0;
        case 10: 
          localcll.DOm = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 11: 
          localcll.FyQ = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 12: 
          localcll.FyR = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 13: 
          localcll.Fmr = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152665);
          return 0;
        case 14: 
          localcll.Eac = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 15: 
          localcll.tii = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 16: 
          localcll.DOn = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 17: 
          localcll.FyS = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 18: 
          localcll.FyT = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 19: 
          localcll.DOo = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 20: 
          localcll.FyU = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 21: 
          localcll.FyV = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 22: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eco();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eco)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcll.DOp = ((eco)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152665);
          return 0;
        case 23: 
          localcll.FyW = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 24: 
          localcll.FyX = ((f.a.a.a.a)localObject1).LVo.xF();
          AppMethodBeat.o(152665);
          return 0;
        }
        localcll.thu = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(152665);
        return 0;
      }
      AppMethodBeat.o(152665);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cll
 * JD-Core Version:    0.7.0.1
 */