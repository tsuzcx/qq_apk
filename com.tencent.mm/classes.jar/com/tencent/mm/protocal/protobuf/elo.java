package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class elo
  extends com.tencent.mm.bx.a
{
  public int IGY;
  public String IIe;
  public String IKJ;
  public String YDJ;
  public String YDK;
  public String YDL;
  public String YDM;
  public String YDN;
  public String YDO;
  public gns YDP;
  public String YQz;
  public int aaZx;
  public String aamA;
  public String abpW;
  public int abpX;
  public LinkedList<etl> abpY;
  public String abpZ;
  public String abqa;
  public String abqb;
  public String abqc;
  public String abqd;
  public String abqe;
  public String abqf;
  public int abqg;
  public String muA;
  
  public elo()
  {
    AppMethodBeat.i(152664);
    this.abpY = new LinkedList();
    AppMethodBeat.o(152664);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152665);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.muA != null) {
        paramVarArgs.g(1, this.muA);
      }
      if (this.IKJ != null) {
        paramVarArgs.g(2, this.IKJ);
      }
      if (this.YDL != null) {
        paramVarArgs.g(3, this.YDL);
      }
      if (this.aamA != null) {
        paramVarArgs.g(4, this.aamA);
      }
      if (this.YDK != null) {
        paramVarArgs.g(5, this.YDK);
      }
      if (this.YDJ != null) {
        paramVarArgs.g(6, this.YDJ);
      }
      if (this.abpW != null) {
        paramVarArgs.g(7, this.abpW);
      }
      paramVarArgs.bS(8, this.abpX);
      paramVarArgs.e(9, 8, this.abpY);
      if (this.YDM != null) {
        paramVarArgs.g(10, this.YDM);
      }
      if (this.abpZ != null) {
        paramVarArgs.g(11, this.abpZ);
      }
      if (this.abqa != null) {
        paramVarArgs.g(12, this.abqa);
      }
      paramVarArgs.bS(13, this.aaZx);
      if (this.YQz != null) {
        paramVarArgs.g(14, this.YQz);
      }
      if (this.IIe != null) {
        paramVarArgs.g(15, this.IIe);
      }
      if (this.YDN != null) {
        paramVarArgs.g(16, this.YDN);
      }
      if (this.abqb != null) {
        paramVarArgs.g(17, this.abqb);
      }
      if (this.abqc != null) {
        paramVarArgs.g(18, this.abqc);
      }
      if (this.YDO != null) {
        paramVarArgs.g(19, this.YDO);
      }
      if (this.abqd != null) {
        paramVarArgs.g(20, this.abqd);
      }
      if (this.abqe != null) {
        paramVarArgs.g(21, this.abqe);
      }
      if (this.YDP != null)
      {
        paramVarArgs.qD(22, this.YDP.computeSize());
        this.YDP.writeFields(paramVarArgs);
      }
      if (this.abqf != null) {
        paramVarArgs.g(23, this.abqf);
      }
      paramVarArgs.bS(24, this.abqg);
      paramVarArgs.bS(25, this.IGY);
      AppMethodBeat.o(152665);
      return 0;
    }
    if (paramInt == 1) {
      if (this.muA == null) {
        break label1762;
      }
    }
    label1762:
    for (int i = i.a.a.b.b.a.h(1, this.muA) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IKJ != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.IKJ);
      }
      i = paramInt;
      if (this.YDL != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YDL);
      }
      paramInt = i;
      if (this.aamA != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aamA);
      }
      i = paramInt;
      if (this.YDK != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.YDK);
      }
      paramInt = i;
      if (this.YDJ != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.YDJ);
      }
      i = paramInt;
      if (this.abpW != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.abpW);
      }
      i = i + i.a.a.b.b.a.cJ(8, this.abpX) + i.a.a.a.c(9, 8, this.abpY);
      paramInt = i;
      if (this.YDM != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.YDM);
      }
      i = paramInt;
      if (this.abpZ != null) {
        i = paramInt + i.a.a.b.b.a.h(11, this.abpZ);
      }
      paramInt = i;
      if (this.abqa != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.abqa);
      }
      i = paramInt + i.a.a.b.b.a.cJ(13, this.aaZx);
      paramInt = i;
      if (this.YQz != null) {
        paramInt = i + i.a.a.b.b.a.h(14, this.YQz);
      }
      i = paramInt;
      if (this.IIe != null) {
        i = paramInt + i.a.a.b.b.a.h(15, this.IIe);
      }
      paramInt = i;
      if (this.YDN != null) {
        paramInt = i + i.a.a.b.b.a.h(16, this.YDN);
      }
      i = paramInt;
      if (this.abqb != null) {
        i = paramInt + i.a.a.b.b.a.h(17, this.abqb);
      }
      paramInt = i;
      if (this.abqc != null) {
        paramInt = i + i.a.a.b.b.a.h(18, this.abqc);
      }
      i = paramInt;
      if (this.YDO != null) {
        i = paramInt + i.a.a.b.b.a.h(19, this.YDO);
      }
      paramInt = i;
      if (this.abqd != null) {
        paramInt = i + i.a.a.b.b.a.h(20, this.abqd);
      }
      i = paramInt;
      if (this.abqe != null) {
        i = paramInt + i.a.a.b.b.a.h(21, this.abqe);
      }
      paramInt = i;
      if (this.YDP != null) {
        paramInt = i + i.a.a.a.qC(22, this.YDP.computeSize());
      }
      i = paramInt;
      if (this.abqf != null) {
        i = paramInt + i.a.a.b.b.a.h(23, this.abqf);
      }
      paramInt = i.a.a.b.b.a.cJ(24, this.abqg);
      int j = i.a.a.b.b.a.cJ(25, this.IGY);
      AppMethodBeat.o(152665);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abpY.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(152665);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        elo localelo = (elo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152665);
          return -1;
        case 1: 
          localelo.muA = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 2: 
          localelo.IKJ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 3: 
          localelo.YDL = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 4: 
          localelo.aamA = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 5: 
          localelo.YDK = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 6: 
          localelo.YDJ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 7: 
          localelo.abpW = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 8: 
          localelo.abpX = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152665);
          return 0;
        case 9: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new etl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((etl)localObject2).dh((byte[])localObject1);
            }
            localelo.abpY.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152665);
          return 0;
        case 10: 
          localelo.YDM = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 11: 
          localelo.abpZ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 12: 
          localelo.abqa = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 13: 
          localelo.aaZx = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152665);
          return 0;
        case 14: 
          localelo.YQz = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 15: 
          localelo.IIe = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 16: 
          localelo.YDN = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 17: 
          localelo.abqb = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 18: 
          localelo.abqc = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 19: 
          localelo.YDO = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 20: 
          localelo.abqd = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 21: 
          localelo.abqe = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 22: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gns();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gns)localObject2).parseFrom((byte[])localObject1);
            }
            localelo.YDP = ((gns)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(152665);
          return 0;
        case 23: 
          localelo.abqf = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(152665);
          return 0;
        case 24: 
          localelo.abqg = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(152665);
          return 0;
        }
        localelo.IGY = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(152665);
        return 0;
      }
      AppMethodBeat.o(152665);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.elo
 * JD-Core Version:    0.7.0.1
 */