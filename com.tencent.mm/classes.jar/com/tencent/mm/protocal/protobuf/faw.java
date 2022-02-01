package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class faw
  extends com.tencent.mm.bx.a
{
  public String UserName;
  public int YFH;
  public String ZhO;
  public String ZhP;
  public String aaMl;
  public int aaMm;
  public String aaMn;
  public String aaMo;
  public String aaMp;
  public int aaMq;
  public int aaMr;
  public ffs aaMs;
  public ahl aaMt;
  public String aant;
  public String aayW;
  public int abAP;
  public gol abAQ;
  public int abAR;
  public int pSf;
  public String pSg;
  public String pSh;
  public String pSi;
  public String pSo;
  public String pSp;
  public String vhX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32440);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abAQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuffer");
        AppMethodBeat.o(32440);
        throw paramVarArgs;
      }
      if (this.UserName != null) {
        paramVarArgs.g(1, this.UserName);
      }
      if (this.vhX != null) {
        paramVarArgs.g(2, this.vhX);
      }
      if (this.pSg != null) {
        paramVarArgs.g(3, this.pSg);
      }
      if (this.pSh != null) {
        paramVarArgs.g(4, this.pSh);
      }
      if (this.pSi != null) {
        paramVarArgs.g(5, this.pSi);
      }
      if (this.aaMl != null) {
        paramVarArgs.g(6, this.aaMl);
      }
      paramVarArgs.bS(7, this.pSf);
      paramVarArgs.bS(8, this.YFH);
      paramVarArgs.bS(9, this.abAP);
      if (this.abAQ != null)
      {
        paramVarArgs.qD(10, this.abAQ.computeSize());
        this.abAQ.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(11, this.abAR);
      if (this.aaMo != null) {
        paramVarArgs.g(12, this.aaMo);
      }
      if (this.aaMp != null) {
        paramVarArgs.g(13, this.aaMp);
      }
      paramVarArgs.bS(14, this.aaMq);
      paramVarArgs.bS(15, this.aaMm);
      if (this.aaMn != null) {
        paramVarArgs.g(16, this.aaMn);
      }
      if (this.aayW != null) {
        paramVarArgs.g(17, this.aayW);
      }
      paramVarArgs.bS(21, this.aaMr);
      if (this.aaMs != null)
      {
        paramVarArgs.qD(22, this.aaMs.computeSize());
        this.aaMs.writeFields(paramVarArgs);
      }
      if (this.pSo != null) {
        paramVarArgs.g(23, this.pSo);
      }
      if (this.ZhO != null) {
        paramVarArgs.g(24, this.ZhO);
      }
      if (this.ZhP != null) {
        paramVarArgs.g(25, this.ZhP);
      }
      if (this.pSp != null) {
        paramVarArgs.g(26, this.pSp);
      }
      if (this.aaMt != null)
      {
        paramVarArgs.qD(27, this.aaMt.computeSize());
        this.aaMt.writeFields(paramVarArgs);
      }
      if (this.aant != null) {
        paramVarArgs.g(28, this.aant);
      }
      AppMethodBeat.o(32440);
      return 0;
    }
    if (paramInt == 1) {
      if (this.UserName == null) {
        break label1883;
      }
    }
    label1883:
    for (int i = i.a.a.b.b.a.h(1, this.UserName) + 0;; i = 0)
    {
      paramInt = i;
      if (this.vhX != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.vhX);
      }
      i = paramInt;
      if (this.pSg != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.pSg);
      }
      paramInt = i;
      if (this.pSh != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.pSh);
      }
      i = paramInt;
      if (this.pSi != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.pSi);
      }
      paramInt = i;
      if (this.aaMl != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.aaMl);
      }
      i = paramInt + i.a.a.b.b.a.cJ(7, this.pSf) + i.a.a.b.b.a.cJ(8, this.YFH) + i.a.a.b.b.a.cJ(9, this.abAP);
      paramInt = i;
      if (this.abAQ != null) {
        paramInt = i + i.a.a.a.qC(10, this.abAQ.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(11, this.abAR);
      paramInt = i;
      if (this.aaMo != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.aaMo);
      }
      i = paramInt;
      if (this.aaMp != null) {
        i = paramInt + i.a.a.b.b.a.h(13, this.aaMp);
      }
      i = i + i.a.a.b.b.a.cJ(14, this.aaMq) + i.a.a.b.b.a.cJ(15, this.aaMm);
      paramInt = i;
      if (this.aaMn != null) {
        paramInt = i + i.a.a.b.b.a.h(16, this.aaMn);
      }
      i = paramInt;
      if (this.aayW != null) {
        i = paramInt + i.a.a.b.b.a.h(17, this.aayW);
      }
      i += i.a.a.b.b.a.cJ(21, this.aaMr);
      paramInt = i;
      if (this.aaMs != null) {
        paramInt = i + i.a.a.a.qC(22, this.aaMs.computeSize());
      }
      i = paramInt;
      if (this.pSo != null) {
        i = paramInt + i.a.a.b.b.a.h(23, this.pSo);
      }
      paramInt = i;
      if (this.ZhO != null) {
        paramInt = i + i.a.a.b.b.a.h(24, this.ZhO);
      }
      i = paramInt;
      if (this.ZhP != null) {
        i = paramInt + i.a.a.b.b.a.h(25, this.ZhP);
      }
      paramInt = i;
      if (this.pSp != null) {
        paramInt = i + i.a.a.b.b.a.h(26, this.pSp);
      }
      i = paramInt;
      if (this.aaMt != null) {
        i = paramInt + i.a.a.a.qC(27, this.aaMt.computeSize());
      }
      paramInt = i;
      if (this.aant != null) {
        paramInt = i + i.a.a.b.b.a.h(28, this.aant);
      }
      AppMethodBeat.o(32440);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.abAQ == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImgBuffer");
          AppMethodBeat.o(32440);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32440);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        faw localfaw = (faw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 18: 
        case 19: 
        case 20: 
        default: 
          AppMethodBeat.o(32440);
          return -1;
        case 1: 
          localfaw.UserName = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 2: 
          localfaw.vhX = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 3: 
          localfaw.pSg = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 4: 
          localfaw.pSh = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 5: 
          localfaw.pSi = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 6: 
          localfaw.aaMl = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 7: 
          localfaw.pSf = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32440);
          return 0;
        case 8: 
          localfaw.YFH = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32440);
          return 0;
        case 9: 
          localfaw.abAP = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32440);
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
            localfaw.abAQ = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32440);
          return 0;
        case 11: 
          localfaw.abAR = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32440);
          return 0;
        case 12: 
          localfaw.aaMo = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 13: 
          localfaw.aaMp = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 14: 
          localfaw.aaMq = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32440);
          return 0;
        case 15: 
          localfaw.aaMm = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32440);
          return 0;
        case 16: 
          localfaw.aaMn = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 17: 
          localfaw.aayW = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 21: 
          localfaw.aaMr = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32440);
          return 0;
        case 22: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ffs();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ffs)localObject2).parseFrom((byte[])localObject1);
            }
            localfaw.aaMs = ((ffs)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32440);
          return 0;
        case 23: 
          localfaw.pSo = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 24: 
          localfaw.ZhO = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 25: 
          localfaw.ZhP = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 26: 
          localfaw.pSp = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(32440);
          return 0;
        case 27: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ahl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ahl)localObject2).parseFrom((byte[])localObject1);
            }
            localfaw.aaMt = ((ahl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32440);
          return 0;
        }
        localfaw.aant = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(32440);
        return 0;
      }
      AppMethodBeat.o(32440);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.faw
 * JD-Core Version:    0.7.0.1
 */