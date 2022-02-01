package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cgi
  extends com.tencent.mm.bx.a
{
  public String CHA;
  public String CvO;
  public String CvP;
  public String CvQ;
  public String CvR;
  public String CvS;
  public String CvT;
  public dwx CvU;
  public int DQa;
  public String Dpu;
  public String EbS;
  public int EbT;
  public LinkedList<cmf> EbU;
  public String EbV;
  public String EbW;
  public String EbX;
  public String EbY;
  public String EbZ;
  public String Eca;
  public String Ecb;
  public int Ecc;
  public String fVC;
  public int rZB;
  public String sao;
  public String scR;
  
  public cgi()
  {
    AppMethodBeat.i(152664);
    this.EbU = new LinkedList();
    AppMethodBeat.o(152664);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152665);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.fVC != null) {
        paramVarArgs.d(1, this.fVC);
      }
      if (this.scR != null) {
        paramVarArgs.d(2, this.scR);
      }
      if (this.CvQ != null) {
        paramVarArgs.d(3, this.CvQ);
      }
      if (this.Dpu != null) {
        paramVarArgs.d(4, this.Dpu);
      }
      if (this.CvP != null) {
        paramVarArgs.d(5, this.CvP);
      }
      if (this.CvO != null) {
        paramVarArgs.d(6, this.CvO);
      }
      if (this.EbS != null) {
        paramVarArgs.d(7, this.EbS);
      }
      paramVarArgs.aR(8, this.EbT);
      paramVarArgs.e(9, 8, this.EbU);
      if (this.CvR != null) {
        paramVarArgs.d(10, this.CvR);
      }
      if (this.EbV != null) {
        paramVarArgs.d(11, this.EbV);
      }
      if (this.EbW != null) {
        paramVarArgs.d(12, this.EbW);
      }
      paramVarArgs.aR(13, this.DQa);
      if (this.CHA != null) {
        paramVarArgs.d(14, this.CHA);
      }
      if (this.sao != null) {
        paramVarArgs.d(15, this.sao);
      }
      if (this.CvS != null) {
        paramVarArgs.d(16, this.CvS);
      }
      if (this.EbX != null) {
        paramVarArgs.d(17, this.EbX);
      }
      if (this.EbY != null) {
        paramVarArgs.d(18, this.EbY);
      }
      if (this.CvT != null) {
        paramVarArgs.d(19, this.CvT);
      }
      if (this.EbZ != null) {
        paramVarArgs.d(20, this.EbZ);
      }
      if (this.Eca != null) {
        paramVarArgs.d(21, this.Eca);
      }
      if (this.CvU != null)
      {
        paramVarArgs.kX(22, this.CvU.computeSize());
        this.CvU.writeFields(paramVarArgs);
      }
      if (this.Ecb != null) {
        paramVarArgs.d(23, this.Ecb);
      }
      paramVarArgs.aR(24, this.Ecc);
      paramVarArgs.aR(25, this.rZB);
      AppMethodBeat.o(152665);
      return 0;
    }
    if (paramInt == 1) {
      if (this.fVC == null) {
        break label1806;
      }
    }
    label1806:
    for (int i = f.a.a.b.b.a.e(1, this.fVC) + 0;; i = 0)
    {
      paramInt = i;
      if (this.scR != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.scR);
      }
      i = paramInt;
      if (this.CvQ != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.CvQ);
      }
      paramInt = i;
      if (this.Dpu != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Dpu);
      }
      i = paramInt;
      if (this.CvP != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.CvP);
      }
      paramInt = i;
      if (this.CvO != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.CvO);
      }
      i = paramInt;
      if (this.EbS != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.EbS);
      }
      i = i + f.a.a.b.b.a.bA(8, this.EbT) + f.a.a.a.c(9, 8, this.EbU);
      paramInt = i;
      if (this.CvR != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.CvR);
      }
      i = paramInt;
      if (this.EbV != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.EbV);
      }
      paramInt = i;
      if (this.EbW != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.EbW);
      }
      i = paramInt + f.a.a.b.b.a.bA(13, this.DQa);
      paramInt = i;
      if (this.CHA != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.CHA);
      }
      i = paramInt;
      if (this.sao != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.sao);
      }
      paramInt = i;
      if (this.CvS != null) {
        paramInt = i + f.a.a.b.b.a.e(16, this.CvS);
      }
      i = paramInt;
      if (this.EbX != null) {
        i = paramInt + f.a.a.b.b.a.e(17, this.EbX);
      }
      paramInt = i;
      if (this.EbY != null) {
        paramInt = i + f.a.a.b.b.a.e(18, this.EbY);
      }
      i = paramInt;
      if (this.CvT != null) {
        i = paramInt + f.a.a.b.b.a.e(19, this.CvT);
      }
      paramInt = i;
      if (this.EbZ != null) {
        paramInt = i + f.a.a.b.b.a.e(20, this.EbZ);
      }
      i = paramInt;
      if (this.Eca != null) {
        i = paramInt + f.a.a.b.b.a.e(21, this.Eca);
      }
      paramInt = i;
      if (this.CvU != null) {
        paramInt = i + f.a.a.a.kW(22, this.CvU.computeSize());
      }
      i = paramInt;
      if (this.Ecb != null) {
        i = paramInt + f.a.a.b.b.a.e(23, this.Ecb);
      }
      paramInt = f.a.a.b.b.a.bA(24, this.Ecc);
      int j = f.a.a.b.b.a.bA(25, this.rZB);
      AppMethodBeat.o(152665);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.EbU.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(152665);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cgi localcgi = (cgi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152665);
          return -1;
        case 1: 
          localcgi.fVC = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 2: 
          localcgi.scR = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 3: 
          localcgi.CvQ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 4: 
          localcgi.Dpu = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 5: 
          localcgi.CvP = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 6: 
          localcgi.CvO = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 7: 
          localcgi.EbS = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 8: 
          localcgi.EbT = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152665);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cmf();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcgi.EbU.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152665);
          return 0;
        case 10: 
          localcgi.CvR = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 11: 
          localcgi.EbV = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 12: 
          localcgi.EbW = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 13: 
          localcgi.DQa = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152665);
          return 0;
        case 14: 
          localcgi.CHA = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 15: 
          localcgi.sao = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 16: 
          localcgi.CvS = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 17: 
          localcgi.EbX = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 18: 
          localcgi.EbY = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 19: 
          localcgi.CvT = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 20: 
          localcgi.EbZ = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 21: 
          localcgi.Eca = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 22: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dwx();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dwx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcgi.CvU = ((dwx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152665);
          return 0;
        case 23: 
          localcgi.Ecb = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 24: 
          localcgi.Ecc = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(152665);
          return 0;
        }
        localcgi.rZB = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(152665);
        return 0;
      }
      AppMethodBeat.o(152665);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgi
 * JD-Core Version:    0.7.0.1
 */