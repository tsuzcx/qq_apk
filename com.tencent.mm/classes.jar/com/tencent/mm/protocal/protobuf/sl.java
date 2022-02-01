package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class sl
  extends erp
{
  public int OhP;
  public asl OiK;
  public String OiL;
  public String OiN;
  public String OiR;
  public String Oiv;
  public String Oiw;
  public LinkedList<apu> Oiy;
  public String Oki;
  public String Okj;
  public int Okm;
  public String Okn;
  public String RZY;
  public int YGv;
  public String YXA;
  public int YXk;
  public String YXn;
  public String YXo;
  public String YXp;
  public int YXq;
  public boolean YXr;
  public boolean YXs;
  public String YXt;
  public int YXu;
  public String YXv;
  public int YXw;
  public int YXx;
  public String YXy;
  public String YXz;
  public int channel;
  public String mXG;
  public String nQU;
  public String nickname;
  public int scene;
  
  public sl()
  {
    AppMethodBeat.i(260237);
    this.Oiy = new LinkedList();
    AppMethodBeat.o(260237);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91374);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YXn == null)
      {
        paramVarArgs = new b("Not all required fields were included: qrcode_id");
        AppMethodBeat.o(91374);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Oiw != null) {
        paramVarArgs.g(2, this.Oiw);
      }
      if (this.YXn != null) {
        paramVarArgs.g(3, this.YXn);
      }
      paramVarArgs.bS(4, this.scene);
      if (this.YXo != null) {
        paramVarArgs.g(5, this.YXo);
      }
      if (this.Oki != null) {
        paramVarArgs.g(6, this.Oki);
      }
      paramVarArgs.bS(7, this.YGv);
      paramVarArgs.bS(8, this.channel);
      if (this.Okn != null) {
        paramVarArgs.g(9, this.Okn);
      }
      if (this.Okj != null) {
        paramVarArgs.g(10, this.Okj);
      }
      if (this.YXp != null) {
        paramVarArgs.g(11, this.YXp);
      }
      paramVarArgs.bS(12, this.YXq);
      paramVarArgs.bS(13, this.Okm);
      if (this.nQU != null) {
        paramVarArgs.g(14, this.nQU);
      }
      if (this.OiK != null)
      {
        paramVarArgs.qD(15, this.OiK.computeSize());
        this.OiK.writeFields(paramVarArgs);
      }
      if (this.OiL != null) {
        paramVarArgs.g(16, this.OiL);
      }
      paramVarArgs.bS(17, this.OhP);
      paramVarArgs.di(18, this.YXr);
      paramVarArgs.di(19, this.YXs);
      if (this.RZY != null) {
        paramVarArgs.g(20, this.RZY);
      }
      if (this.mXG != null) {
        paramVarArgs.g(21, this.mXG);
      }
      if (this.YXt != null) {
        paramVarArgs.g(22, this.YXt);
      }
      if (this.Oiv != null) {
        paramVarArgs.g(23, this.Oiv);
      }
      if (this.nickname != null) {
        paramVarArgs.g(24, this.nickname);
      }
      if (this.OiN != null) {
        paramVarArgs.g(25, this.OiN);
      }
      paramVarArgs.bS(26, this.YXu);
      if (this.YXv != null) {
        paramVarArgs.g(27, this.YXv);
      }
      paramVarArgs.bS(28, this.YXw);
      paramVarArgs.bS(29, this.YXx);
      if (this.OiR != null) {
        paramVarArgs.g(30, this.OiR);
      }
      if (this.YXy != null) {
        paramVarArgs.g(31, this.YXy);
      }
      if (this.YXz != null) {
        paramVarArgs.g(32, this.YXz);
      }
      paramVarArgs.e(33, 8, this.Oiy);
      paramVarArgs.bS(34, this.YXk);
      if (this.YXA != null) {
        paramVarArgs.g(35, this.YXA);
      }
      AppMethodBeat.o(91374);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label2356;
      }
    }
    label2356:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Oiw != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.Oiw);
      }
      i = paramInt;
      if (this.YXn != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YXn);
      }
      i += i.a.a.b.b.a.cJ(4, this.scene);
      paramInt = i;
      if (this.YXo != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.YXo);
      }
      i = paramInt;
      if (this.Oki != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.Oki);
      }
      i = i + i.a.a.b.b.a.cJ(7, this.YGv) + i.a.a.b.b.a.cJ(8, this.channel);
      paramInt = i;
      if (this.Okn != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.Okn);
      }
      i = paramInt;
      if (this.Okj != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.Okj);
      }
      paramInt = i;
      if (this.YXp != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.YXp);
      }
      i = paramInt + i.a.a.b.b.a.cJ(12, this.YXq) + i.a.a.b.b.a.cJ(13, this.Okm);
      paramInt = i;
      if (this.nQU != null) {
        paramInt = i + i.a.a.b.b.a.h(14, this.nQU);
      }
      i = paramInt;
      if (this.OiK != null) {
        i = paramInt + i.a.a.a.qC(15, this.OiK.computeSize());
      }
      paramInt = i;
      if (this.OiL != null) {
        paramInt = i + i.a.a.b.b.a.h(16, this.OiL);
      }
      i = paramInt + i.a.a.b.b.a.cJ(17, this.OhP) + (i.a.a.b.b.a.ko(18) + 1) + (i.a.a.b.b.a.ko(19) + 1);
      paramInt = i;
      if (this.RZY != null) {
        paramInt = i + i.a.a.b.b.a.h(20, this.RZY);
      }
      i = paramInt;
      if (this.mXG != null) {
        i = paramInt + i.a.a.b.b.a.h(21, this.mXG);
      }
      paramInt = i;
      if (this.YXt != null) {
        paramInt = i + i.a.a.b.b.a.h(22, this.YXt);
      }
      i = paramInt;
      if (this.Oiv != null) {
        i = paramInt + i.a.a.b.b.a.h(23, this.Oiv);
      }
      paramInt = i;
      if (this.nickname != null) {
        paramInt = i + i.a.a.b.b.a.h(24, this.nickname);
      }
      i = paramInt;
      if (this.OiN != null) {
        i = paramInt + i.a.a.b.b.a.h(25, this.OiN);
      }
      i += i.a.a.b.b.a.cJ(26, this.YXu);
      paramInt = i;
      if (this.YXv != null) {
        paramInt = i + i.a.a.b.b.a.h(27, this.YXv);
      }
      i = paramInt + i.a.a.b.b.a.cJ(28, this.YXw) + i.a.a.b.b.a.cJ(29, this.YXx);
      paramInt = i;
      if (this.OiR != null) {
        paramInt = i + i.a.a.b.b.a.h(30, this.OiR);
      }
      i = paramInt;
      if (this.YXy != null) {
        i = paramInt + i.a.a.b.b.a.h(31, this.YXy);
      }
      paramInt = i;
      if (this.YXz != null) {
        paramInt = i + i.a.a.b.b.a.h(32, this.YXz);
      }
      i = paramInt + i.a.a.a.c(33, 8, this.Oiy) + i.a.a.b.b.a.cJ(34, this.YXk);
      paramInt = i;
      if (this.YXA != null) {
        paramInt = i + i.a.a.b.b.a.h(35, this.YXA);
      }
      AppMethodBeat.o(91374);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Oiy.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.YXn == null)
        {
          paramVarArgs = new b("Not all required fields were included: qrcode_id");
          AppMethodBeat.o(91374);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91374);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        sl localsl = (sl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91374);
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
            localsl.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91374);
          return 0;
        case 2: 
          localsl.Oiw = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 3: 
          localsl.YXn = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 4: 
          localsl.scene = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91374);
          return 0;
        case 5: 
          localsl.YXo = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 6: 
          localsl.Oki = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 7: 
          localsl.YGv = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91374);
          return 0;
        case 8: 
          localsl.channel = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91374);
          return 0;
        case 9: 
          localsl.Okn = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 10: 
          localsl.Okj = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 11: 
          localsl.YXp = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 12: 
          localsl.YXq = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91374);
          return 0;
        case 13: 
          localsl.Okm = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91374);
          return 0;
        case 14: 
          localsl.nQU = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 15: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new asl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((asl)localObject2).parseFrom((byte[])localObject1);
            }
            localsl.OiK = ((asl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91374);
          return 0;
        case 16: 
          localsl.OiL = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 17: 
          localsl.OhP = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91374);
          return 0;
        case 18: 
          localsl.YXr = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(91374);
          return 0;
        case 19: 
          localsl.YXs = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(91374);
          return 0;
        case 20: 
          localsl.RZY = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 21: 
          localsl.mXG = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 22: 
          localsl.YXt = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 23: 
          localsl.Oiv = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 24: 
          localsl.nickname = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 25: 
          localsl.OiN = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 26: 
          localsl.YXu = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91374);
          return 0;
        case 27: 
          localsl.YXv = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 28: 
          localsl.YXw = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91374);
          return 0;
        case 29: 
          localsl.YXx = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91374);
          return 0;
        case 30: 
          localsl.OiR = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 31: 
          localsl.YXy = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 32: 
          localsl.YXz = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91374);
          return 0;
        case 33: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new apu();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((apu)localObject2).parseFrom((byte[])localObject1);
            }
            localsl.Oiy.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91374);
          return 0;
        case 34: 
          localsl.YXk = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91374);
          return 0;
        }
        localsl.YXA = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(91374);
        return 0;
      }
      AppMethodBeat.o(91374);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sl
 * JD-Core Version:    0.7.0.1
 */