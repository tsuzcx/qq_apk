package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dmg
  extends erp
{
  public String Jmq;
  public String YDN;
  public jv YJU;
  public String YJV;
  public int YJW;
  public String YJX;
  public String YJY;
  public int YJZ;
  public gol YKa;
  public gol YKb;
  public String YKc;
  public eil YKd;
  public String Ztv;
  public String aaSn;
  public String aaSo;
  public String aaSp;
  public int aaSq;
  public int muB;
  public String mut;
  public String muu;
  public String pSi;
  public String vgW;
  public String ytr;
  public String yts;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133176);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.YJU != null)
      {
        paramVarArgs.qD(2, this.YJU.computeSize());
        this.YJU.writeFields(paramVarArgs);
      }
      if (this.Jmq != null) {
        paramVarArgs.g(3, this.Jmq);
      }
      if (this.YJV != null) {
        paramVarArgs.g(4, this.YJV);
      }
      paramVarArgs.bS(5, this.YJW);
      if (this.YJX != null) {
        paramVarArgs.g(6, this.YJX);
      }
      if (this.pSi != null) {
        paramVarArgs.g(7, this.pSi);
      }
      if (this.vgW != null) {
        paramVarArgs.g(8, this.vgW);
      }
      if (this.YJY != null) {
        paramVarArgs.g(9, this.YJY);
      }
      if (this.yts != null) {
        paramVarArgs.g(10, this.yts);
      }
      if (this.ytr != null) {
        paramVarArgs.g(11, this.ytr);
      }
      paramVarArgs.bS(13, this.YJZ);
      paramVarArgs.bS(14, this.muB);
      if (this.muu != null) {
        paramVarArgs.g(15, this.muu);
      }
      if (this.mut != null) {
        paramVarArgs.g(16, this.mut);
      }
      if (this.aaSn != null) {
        paramVarArgs.g(17, this.aaSn);
      }
      if (this.Ztv != null) {
        paramVarArgs.g(18, this.Ztv);
      }
      if (this.YKc != null) {
        paramVarArgs.g(19, this.YKc);
      }
      if (this.aaSo != null) {
        paramVarArgs.g(20, this.aaSo);
      }
      if (this.aaSp != null) {
        paramVarArgs.g(21, this.aaSp);
      }
      paramVarArgs.bS(22, this.aaSq);
      if (this.YKa != null)
      {
        paramVarArgs.qD(23, this.YKa.computeSize());
        this.YKa.writeFields(paramVarArgs);
      }
      if (this.YKb != null)
      {
        paramVarArgs.qD(24, this.YKb.computeSize());
        this.YKb.writeFields(paramVarArgs);
      }
      if (this.YDN != null) {
        paramVarArgs.g(25, this.YDN);
      }
      if (this.YKd != null)
      {
        paramVarArgs.qD(26, this.YKd.computeSize());
        this.YKd.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133176);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1992;
      }
    }
    label1992:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YJU != null) {
        paramInt = i + i.a.a.a.qC(2, this.YJU.computeSize());
      }
      i = paramInt;
      if (this.Jmq != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.Jmq);
      }
      paramInt = i;
      if (this.YJV != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.YJV);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.YJW);
      paramInt = i;
      if (this.YJX != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.YJX);
      }
      i = paramInt;
      if (this.pSi != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.pSi);
      }
      paramInt = i;
      if (this.vgW != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.vgW);
      }
      i = paramInt;
      if (this.YJY != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.YJY);
      }
      paramInt = i;
      if (this.yts != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.yts);
      }
      i = paramInt;
      if (this.ytr != null) {
        i = paramInt + i.a.a.b.b.a.h(11, this.ytr);
      }
      i = i + i.a.a.b.b.a.cJ(13, this.YJZ) + i.a.a.b.b.a.cJ(14, this.muB);
      paramInt = i;
      if (this.muu != null) {
        paramInt = i + i.a.a.b.b.a.h(15, this.muu);
      }
      i = paramInt;
      if (this.mut != null) {
        i = paramInt + i.a.a.b.b.a.h(16, this.mut);
      }
      paramInt = i;
      if (this.aaSn != null) {
        paramInt = i + i.a.a.b.b.a.h(17, this.aaSn);
      }
      i = paramInt;
      if (this.Ztv != null) {
        i = paramInt + i.a.a.b.b.a.h(18, this.Ztv);
      }
      paramInt = i;
      if (this.YKc != null) {
        paramInt = i + i.a.a.b.b.a.h(19, this.YKc);
      }
      i = paramInt;
      if (this.aaSo != null) {
        i = paramInt + i.a.a.b.b.a.h(20, this.aaSo);
      }
      paramInt = i;
      if (this.aaSp != null) {
        paramInt = i + i.a.a.b.b.a.h(21, this.aaSp);
      }
      i = paramInt + i.a.a.b.b.a.cJ(22, this.aaSq);
      paramInt = i;
      if (this.YKa != null) {
        paramInt = i + i.a.a.a.qC(23, this.YKa.computeSize());
      }
      i = paramInt;
      if (this.YKb != null) {
        i = paramInt + i.a.a.a.qC(24, this.YKb.computeSize());
      }
      paramInt = i;
      if (this.YDN != null) {
        paramInt = i + i.a.a.b.b.a.h(25, this.YDN);
      }
      i = paramInt;
      if (this.YKd != null) {
        i = paramInt + i.a.a.a.qC(26, this.YKd.computeSize());
      }
      AppMethodBeat.o(133176);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(133176);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dmg localdmg = (dmg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 12: 
        default: 
          AppMethodBeat.o(133176);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localdmg.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133176);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new jv();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((jv)localObject2).parseFrom((byte[])localObject1);
            }
            localdmg.YJU = ((jv)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133176);
          return 0;
        case 3: 
          localdmg.Jmq = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 4: 
          localdmg.YJV = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 5: 
          localdmg.YJW = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(133176);
          return 0;
        case 6: 
          localdmg.YJX = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 7: 
          localdmg.pSi = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 8: 
          localdmg.vgW = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 9: 
          localdmg.YJY = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 10: 
          localdmg.yts = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 11: 
          localdmg.ytr = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 13: 
          localdmg.YJZ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(133176);
          return 0;
        case 14: 
          localdmg.muB = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(133176);
          return 0;
        case 15: 
          localdmg.muu = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 16: 
          localdmg.mut = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 17: 
          localdmg.aaSn = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 18: 
          localdmg.Ztv = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 19: 
          localdmg.YKc = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 20: 
          localdmg.aaSo = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 21: 
          localdmg.aaSp = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(133176);
          return 0;
        case 22: 
          localdmg.aaSq = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(133176);
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
            localdmg.YKa = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133176);
          return 0;
        case 24: 
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
            localdmg.YKb = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133176);
          return 0;
        case 25: 
          localdmg.YDN = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(133176);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new eil();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((eil)localObject2).parseFrom((byte[])localObject1);
          }
          localdmg.YKd = ((eil)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(133176);
        return 0;
      }
      AppMethodBeat.o(133176);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dmg
 * JD-Core Version:    0.7.0.1
 */