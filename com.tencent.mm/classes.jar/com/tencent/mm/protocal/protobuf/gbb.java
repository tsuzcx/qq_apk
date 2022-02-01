package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class gbb
  extends com.tencent.mm.bx.a
{
  public int JHp;
  public gbh abWP;
  public gbh abWQ;
  public epf abYF;
  public akm abYG;
  public int abYM;
  public fzo abYN;
  public fzo abYO;
  public int abYP;
  public int abYQ;
  public int abYR;
  public int abYS;
  public gol abYT;
  public int abYU;
  public fzo abYV;
  public int abYW;
  public int abYX;
  public int abYY;
  public int abYZ;
  public int abZa;
  public int abZb;
  public gol abZc;
  public gol abZd;
  public int abZe;
  public gol abZf;
  public int abZg;
  public int abZh;
  public int abZi;
  public del abZj;
  public gol abZk;
  public int abZl;
  public String abZm;
  public int abZn;
  public LinkedList<gbc> abZo;
  public cnv abZp;
  
  public gbb()
  {
    AppMethodBeat.i(115899);
    this.abZo = new LinkedList();
    AppMethodBeat.o(115899);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115900);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abWP == null)
      {
        paramVarArgs = new b("Not all required fields were included: PeerId");
        AppMethodBeat.o(115900);
        throw paramVarArgs;
      }
      if (this.abWQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: CapInfo");
        AppMethodBeat.o(115900);
        throw paramVarArgs;
      }
      if (this.abWP != null)
      {
        paramVarArgs.qD(1, this.abWP.computeSize());
        this.abWP.writeFields(paramVarArgs);
      }
      if (this.abWQ != null)
      {
        paramVarArgs.qD(2, this.abWQ.computeSize());
        this.abWQ.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(3, this.abYM);
      if (this.abYN != null)
      {
        paramVarArgs.qD(4, this.abYN.computeSize());
        this.abYN.writeFields(paramVarArgs);
      }
      if (this.abYO != null)
      {
        paramVarArgs.qD(5, this.abYO.computeSize());
        this.abYO.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(6, this.abYP);
      paramVarArgs.bS(7, this.abYQ);
      paramVarArgs.bS(8, this.abYR);
      paramVarArgs.bS(9, this.abYS);
      if (this.abYT != null)
      {
        paramVarArgs.qD(10, this.abYT.computeSize());
        this.abYT.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(11, this.abYU);
      if (this.abYV != null)
      {
        paramVarArgs.qD(12, this.abYV.computeSize());
        this.abYV.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(13, this.abYW);
      paramVarArgs.bS(14, this.abYX);
      paramVarArgs.bS(15, this.abYY);
      paramVarArgs.bS(16, this.abYZ);
      paramVarArgs.bS(17, this.abZa);
      paramVarArgs.bS(18, this.JHp);
      paramVarArgs.bS(19, this.abZb);
      if (this.abZc != null)
      {
        paramVarArgs.qD(20, this.abZc.computeSize());
        this.abZc.writeFields(paramVarArgs);
      }
      if (this.abZd != null)
      {
        paramVarArgs.qD(21, this.abZd.computeSize());
        this.abZd.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(22, this.abZe);
      if (this.abZf != null)
      {
        paramVarArgs.qD(23, this.abZf.computeSize());
        this.abZf.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(24, this.abZg);
      paramVarArgs.bS(25, this.abZh);
      paramVarArgs.bS(26, this.abZi);
      if (this.abZj != null)
      {
        paramVarArgs.qD(27, this.abZj.computeSize());
        this.abZj.writeFields(paramVarArgs);
      }
      if (this.abZk != null)
      {
        paramVarArgs.qD(28, this.abZk.computeSize());
        this.abZk.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(29, this.abZl);
      if (this.abZm != null) {
        paramVarArgs.g(30, this.abZm);
      }
      paramVarArgs.bS(31, this.abZn);
      paramVarArgs.e(32, 8, this.abZo);
      if (this.abYF != null)
      {
        paramVarArgs.qD(33, this.abYF.computeSize());
        this.abYF.writeFields(paramVarArgs);
      }
      if (this.abYG != null)
      {
        paramVarArgs.qD(34, this.abYG.computeSize());
        this.abYG.writeFields(paramVarArgs);
      }
      if (this.abZp != null)
      {
        paramVarArgs.qD(35, this.abZp.computeSize());
        this.abZp.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(115900);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abWP == null) {
        break label3148;
      }
    }
    label3148:
    for (paramInt = i.a.a.a.qC(1, this.abWP.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.abWQ != null) {
        i = paramInt + i.a.a.a.qC(2, this.abWQ.computeSize());
      }
      i += i.a.a.b.b.a.cJ(3, this.abYM);
      paramInt = i;
      if (this.abYN != null) {
        paramInt = i + i.a.a.a.qC(4, this.abYN.computeSize());
      }
      i = paramInt;
      if (this.abYO != null) {
        i = paramInt + i.a.a.a.qC(5, this.abYO.computeSize());
      }
      i = i + i.a.a.b.b.a.cJ(6, this.abYP) + i.a.a.b.b.a.cJ(7, this.abYQ) + i.a.a.b.b.a.cJ(8, this.abYR) + i.a.a.b.b.a.cJ(9, this.abYS);
      paramInt = i;
      if (this.abYT != null) {
        paramInt = i + i.a.a.a.qC(10, this.abYT.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(11, this.abYU);
      paramInt = i;
      if (this.abYV != null) {
        paramInt = i + i.a.a.a.qC(12, this.abYV.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(13, this.abYW) + i.a.a.b.b.a.cJ(14, this.abYX) + i.a.a.b.b.a.cJ(15, this.abYY) + i.a.a.b.b.a.cJ(16, this.abYZ) + i.a.a.b.b.a.cJ(17, this.abZa) + i.a.a.b.b.a.cJ(18, this.JHp) + i.a.a.b.b.a.cJ(19, this.abZb);
      paramInt = i;
      if (this.abZc != null) {
        paramInt = i + i.a.a.a.qC(20, this.abZc.computeSize());
      }
      i = paramInt;
      if (this.abZd != null) {
        i = paramInt + i.a.a.a.qC(21, this.abZd.computeSize());
      }
      i += i.a.a.b.b.a.cJ(22, this.abZe);
      paramInt = i;
      if (this.abZf != null) {
        paramInt = i + i.a.a.a.qC(23, this.abZf.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(24, this.abZg) + i.a.a.b.b.a.cJ(25, this.abZh) + i.a.a.b.b.a.cJ(26, this.abZi);
      paramInt = i;
      if (this.abZj != null) {
        paramInt = i + i.a.a.a.qC(27, this.abZj.computeSize());
      }
      i = paramInt;
      if (this.abZk != null) {
        i = paramInt + i.a.a.a.qC(28, this.abZk.computeSize());
      }
      i += i.a.a.b.b.a.cJ(29, this.abZl);
      paramInt = i;
      if (this.abZm != null) {
        paramInt = i + i.a.a.b.b.a.h(30, this.abZm);
      }
      i = paramInt + i.a.a.b.b.a.cJ(31, this.abZn) + i.a.a.a.c(32, 8, this.abZo);
      paramInt = i;
      if (this.abYF != null) {
        paramInt = i + i.a.a.a.qC(33, this.abYF.computeSize());
      }
      i = paramInt;
      if (this.abYG != null) {
        i = paramInt + i.a.a.a.qC(34, this.abYG.computeSize());
      }
      paramInt = i;
      if (this.abZp != null) {
        paramInt = i + i.a.a.a.qC(35, this.abZp.computeSize());
      }
      AppMethodBeat.o(115900);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abZo.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.abWP == null)
        {
          paramVarArgs = new b("Not all required fields were included: PeerId");
          AppMethodBeat.o(115900);
          throw paramVarArgs;
        }
        if (this.abWQ == null)
        {
          paramVarArgs = new b("Not all required fields were included: CapInfo");
          AppMethodBeat.o(115900);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115900);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        gbb localgbb = (gbb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115900);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gbh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gbh)localObject2).parseFrom((byte[])localObject1);
            }
            localgbb.abWP = ((gbh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gbh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gbh)localObject2).parseFrom((byte[])localObject1);
            }
            localgbb.abWQ = ((gbh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 3: 
          localgbb.abYM = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115900);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fzo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fzo)localObject2).parseFrom((byte[])localObject1);
            }
            localgbb.abYN = ((fzo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fzo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fzo)localObject2).parseFrom((byte[])localObject1);
            }
            localgbb.abYO = ((fzo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 6: 
          localgbb.abYP = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115900);
          return 0;
        case 7: 
          localgbb.abYQ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115900);
          return 0;
        case 8: 
          localgbb.abYR = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115900);
          return 0;
        case 9: 
          localgbb.abYS = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115900);
          return 0;
        case 10: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localgbb.abYT = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 11: 
          localgbb.abYU = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115900);
          return 0;
        case 12: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fzo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fzo)localObject2).parseFrom((byte[])localObject1);
            }
            localgbb.abYV = ((fzo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 13: 
          localgbb.abYW = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115900);
          return 0;
        case 14: 
          localgbb.abYX = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115900);
          return 0;
        case 15: 
          localgbb.abYY = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115900);
          return 0;
        case 16: 
          localgbb.abYZ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115900);
          return 0;
        case 17: 
          localgbb.abZa = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115900);
          return 0;
        case 18: 
          localgbb.JHp = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115900);
          return 0;
        case 19: 
          localgbb.abZb = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115900);
          return 0;
        case 20: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localgbb.abZc = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 21: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localgbb.abZd = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 22: 
          localgbb.abZe = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115900);
          return 0;
        case 23: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localgbb.abZf = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 24: 
          localgbb.abZg = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115900);
          return 0;
        case 25: 
          localgbb.abZh = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115900);
          return 0;
        case 26: 
          localgbb.abZi = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115900);
          return 0;
        case 27: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new del();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((del)localObject2).parseFrom((byte[])localObject1);
            }
            localgbb.abZj = ((del)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 28: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localgbb.abZk = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 29: 
          localgbb.abZl = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115900);
          return 0;
        case 30: 
          localgbb.abZm = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(115900);
          return 0;
        case 31: 
          localgbb.abZn = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(115900);
          return 0;
        case 32: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gbc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gbc)localObject2).parseFrom((byte[])localObject1);
            }
            localgbb.abZo.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 33: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new epf();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((epf)localObject2).parseFrom((byte[])localObject1);
            }
            localgbb.abYF = ((epf)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        case 34: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new akm();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((akm)localObject2).parseFrom((byte[])localObject1);
            }
            localgbb.abYG = ((akm)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(115900);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new cnv();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((cnv)localObject2).parseFrom((byte[])localObject1);
          }
          localgbb.abZp = ((cnv)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(115900);
        return 0;
      }
      AppMethodBeat.o(115900);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gbb
 * JD-Core Version:    0.7.0.1
 */