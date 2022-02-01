package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ws
  extends com.tencent.mm.bx.a
{
  public String YTl;
  public String YYZ;
  public int ZdI;
  public String ZdJ;
  public LinkedList<aek> ZdK;
  public LinkedList<aek> ZdL;
  public String ZdM;
  public String ZdN;
  public int ZdO;
  public String ZdP;
  public int ZdQ;
  public String ZdR;
  public String ZdS;
  public long ZdT;
  public String ZdU;
  public String ZdV;
  public String ZdW;
  public wh ZdX;
  public String ZdY;
  public String ZdZ;
  public int Zea;
  public akb Zeb;
  public fum Zec;
  public bzp Zed;
  public bj Zee;
  public int Zef;
  public int Zeg;
  public String Zeh;
  public int Zei;
  public String Zej;
  public int Zek;
  public aek Zel;
  public String Zem;
  public aek Zen;
  public alk Zeo;
  public boolean Zep;
  public int Zeq;
  public boolean Zer;
  public boolean Zes;
  public ru Zet;
  public String Zeu;
  public String Zev;
  public String Zew;
  public String Zex;
  public String appid;
  public String mee;
  public String nQG;
  public String nRQ;
  public String pHt;
  public String rHe;
  public String source;
  public int tNW;
  public String title;
  public String wsy;
  public String wsz;
  public String wtN;
  
  public ws()
  {
    AppMethodBeat.i(113975);
    this.ZdK = new LinkedList();
    this.ZdL = new LinkedList();
    AppMethodBeat.o(113975);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113976);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.wsy != null) {
        paramVarArgs.g(1, this.wsy);
      }
      if (this.nQG != null) {
        paramVarArgs.g(2, this.nQG);
      }
      if (this.appid != null) {
        paramVarArgs.g(3, this.appid);
      }
      if (this.YYZ != null) {
        paramVarArgs.g(4, this.YYZ);
      }
      paramVarArgs.bS(5, this.ZdI);
      paramVarArgs.bS(6, this.tNW);
      if (this.mee != null) {
        paramVarArgs.g(7, this.mee);
      }
      if (this.title != null) {
        paramVarArgs.g(8, this.title);
      }
      if (this.wsz != null) {
        paramVarArgs.g(9, this.wsz);
      }
      if (this.nRQ != null) {
        paramVarArgs.g(10, this.nRQ);
      }
      if (this.pHt != null) {
        paramVarArgs.g(11, this.pHt);
      }
      if (this.ZdJ != null) {
        paramVarArgs.g(12, this.ZdJ);
      }
      paramVarArgs.e(13, 8, this.ZdK);
      paramVarArgs.e(14, 8, this.ZdL);
      if (this.ZdM != null) {
        paramVarArgs.g(15, this.ZdM);
      }
      if (this.ZdN != null) {
        paramVarArgs.g(16, this.ZdN);
      }
      if (this.source != null) {
        paramVarArgs.g(17, this.source);
      }
      paramVarArgs.bS(18, this.ZdO);
      if (this.wtN != null) {
        paramVarArgs.g(19, this.wtN);
      }
      if (this.rHe != null) {
        paramVarArgs.g(20, this.rHe);
      }
      if (this.ZdP != null) {
        paramVarArgs.g(21, this.ZdP);
      }
      paramVarArgs.bS(22, this.ZdQ);
      if (this.ZdR != null) {
        paramVarArgs.g(23, this.ZdR);
      }
      if (this.ZdS != null) {
        paramVarArgs.g(24, this.ZdS);
      }
      paramVarArgs.bv(25, this.ZdT);
      if (this.ZdU != null) {
        paramVarArgs.g(26, this.ZdU);
      }
      if (this.ZdV != null) {
        paramVarArgs.g(27, this.ZdV);
      }
      if (this.ZdW != null) {
        paramVarArgs.g(28, this.ZdW);
      }
      if (this.ZdX != null)
      {
        paramVarArgs.qD(29, this.ZdX.computeSize());
        this.ZdX.writeFields(paramVarArgs);
      }
      if (this.ZdY != null) {
        paramVarArgs.g(30, this.ZdY);
      }
      if (this.ZdZ != null) {
        paramVarArgs.g(31, this.ZdZ);
      }
      paramVarArgs.bS(32, this.Zea);
      if (this.Zeb != null)
      {
        paramVarArgs.qD(33, this.Zeb.computeSize());
        this.Zeb.writeFields(paramVarArgs);
      }
      if (this.Zec != null)
      {
        paramVarArgs.qD(34, this.Zec.computeSize());
        this.Zec.writeFields(paramVarArgs);
      }
      if (this.Zed != null)
      {
        paramVarArgs.qD(35, this.Zed.computeSize());
        this.Zed.writeFields(paramVarArgs);
      }
      if (this.Zee != null)
      {
        paramVarArgs.qD(36, this.Zee.computeSize());
        this.Zee.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(37, this.Zef);
      paramVarArgs.bS(38, this.Zeg);
      if (this.Zeh != null) {
        paramVarArgs.g(39, this.Zeh);
      }
      paramVarArgs.bS(40, this.Zei);
      if (this.Zej != null) {
        paramVarArgs.g(41, this.Zej);
      }
      paramVarArgs.bS(42, this.Zek);
      if (this.Zel != null)
      {
        paramVarArgs.qD(43, this.Zel.computeSize());
        this.Zel.writeFields(paramVarArgs);
      }
      if (this.Zem != null) {
        paramVarArgs.g(44, this.Zem);
      }
      if (this.Zen != null)
      {
        paramVarArgs.qD(45, this.Zen.computeSize());
        this.Zen.writeFields(paramVarArgs);
      }
      if (this.Zeo != null)
      {
        paramVarArgs.qD(46, this.Zeo.computeSize());
        this.Zeo.writeFields(paramVarArgs);
      }
      paramVarArgs.di(47, this.Zep);
      paramVarArgs.bS(48, this.Zeq);
      paramVarArgs.di(49, this.Zer);
      paramVarArgs.di(50, this.Zes);
      if (this.Zet != null)
      {
        paramVarArgs.qD(51, this.Zet.computeSize());
        this.Zet.writeFields(paramVarArgs);
      }
      if (this.YTl != null) {
        paramVarArgs.g(52, this.YTl);
      }
      if (this.Zeu != null) {
        paramVarArgs.g(53, this.Zeu);
      }
      if (this.Zev != null) {
        paramVarArgs.g(54, this.Zev);
      }
      if (this.Zew != null) {
        paramVarArgs.g(55, this.Zew);
      }
      if (this.Zex != null) {
        paramVarArgs.g(56, this.Zex);
      }
      AppMethodBeat.o(113976);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wsy == null) {
        break label4136;
      }
    }
    label4136:
    for (int i = i.a.a.b.b.a.h(1, this.wsy) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nQG != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.nQG);
      }
      i = paramInt;
      if (this.appid != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.appid);
      }
      paramInt = i;
      if (this.YYZ != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.YYZ);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.ZdI) + i.a.a.b.b.a.cJ(6, this.tNW);
      paramInt = i;
      if (this.mee != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.mee);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.title);
      }
      paramInt = i;
      if (this.wsz != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.wsz);
      }
      i = paramInt;
      if (this.nRQ != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.nRQ);
      }
      paramInt = i;
      if (this.pHt != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.pHt);
      }
      i = paramInt;
      if (this.ZdJ != null) {
        i = paramInt + i.a.a.b.b.a.h(12, this.ZdJ);
      }
      i = i + i.a.a.a.c(13, 8, this.ZdK) + i.a.a.a.c(14, 8, this.ZdL);
      paramInt = i;
      if (this.ZdM != null) {
        paramInt = i + i.a.a.b.b.a.h(15, this.ZdM);
      }
      i = paramInt;
      if (this.ZdN != null) {
        i = paramInt + i.a.a.b.b.a.h(16, this.ZdN);
      }
      paramInt = i;
      if (this.source != null) {
        paramInt = i + i.a.a.b.b.a.h(17, this.source);
      }
      i = paramInt + i.a.a.b.b.a.cJ(18, this.ZdO);
      paramInt = i;
      if (this.wtN != null) {
        paramInt = i + i.a.a.b.b.a.h(19, this.wtN);
      }
      i = paramInt;
      if (this.rHe != null) {
        i = paramInt + i.a.a.b.b.a.h(20, this.rHe);
      }
      paramInt = i;
      if (this.ZdP != null) {
        paramInt = i + i.a.a.b.b.a.h(21, this.ZdP);
      }
      i = paramInt + i.a.a.b.b.a.cJ(22, this.ZdQ);
      paramInt = i;
      if (this.ZdR != null) {
        paramInt = i + i.a.a.b.b.a.h(23, this.ZdR);
      }
      i = paramInt;
      if (this.ZdS != null) {
        i = paramInt + i.a.a.b.b.a.h(24, this.ZdS);
      }
      i += i.a.a.b.b.a.q(25, this.ZdT);
      paramInt = i;
      if (this.ZdU != null) {
        paramInt = i + i.a.a.b.b.a.h(26, this.ZdU);
      }
      i = paramInt;
      if (this.ZdV != null) {
        i = paramInt + i.a.a.b.b.a.h(27, this.ZdV);
      }
      paramInt = i;
      if (this.ZdW != null) {
        paramInt = i + i.a.a.b.b.a.h(28, this.ZdW);
      }
      i = paramInt;
      if (this.ZdX != null) {
        i = paramInt + i.a.a.a.qC(29, this.ZdX.computeSize());
      }
      paramInt = i;
      if (this.ZdY != null) {
        paramInt = i + i.a.a.b.b.a.h(30, this.ZdY);
      }
      i = paramInt;
      if (this.ZdZ != null) {
        i = paramInt + i.a.a.b.b.a.h(31, this.ZdZ);
      }
      i += i.a.a.b.b.a.cJ(32, this.Zea);
      paramInt = i;
      if (this.Zeb != null) {
        paramInt = i + i.a.a.a.qC(33, this.Zeb.computeSize());
      }
      i = paramInt;
      if (this.Zec != null) {
        i = paramInt + i.a.a.a.qC(34, this.Zec.computeSize());
      }
      paramInt = i;
      if (this.Zed != null) {
        paramInt = i + i.a.a.a.qC(35, this.Zed.computeSize());
      }
      i = paramInt;
      if (this.Zee != null) {
        i = paramInt + i.a.a.a.qC(36, this.Zee.computeSize());
      }
      i = i + i.a.a.b.b.a.cJ(37, this.Zef) + i.a.a.b.b.a.cJ(38, this.Zeg);
      paramInt = i;
      if (this.Zeh != null) {
        paramInt = i + i.a.a.b.b.a.h(39, this.Zeh);
      }
      i = paramInt + i.a.a.b.b.a.cJ(40, this.Zei);
      paramInt = i;
      if (this.Zej != null) {
        paramInt = i + i.a.a.b.b.a.h(41, this.Zej);
      }
      i = paramInt + i.a.a.b.b.a.cJ(42, this.Zek);
      paramInt = i;
      if (this.Zel != null) {
        paramInt = i + i.a.a.a.qC(43, this.Zel.computeSize());
      }
      i = paramInt;
      if (this.Zem != null) {
        i = paramInt + i.a.a.b.b.a.h(44, this.Zem);
      }
      paramInt = i;
      if (this.Zen != null) {
        paramInt = i + i.a.a.a.qC(45, this.Zen.computeSize());
      }
      i = paramInt;
      if (this.Zeo != null) {
        i = paramInt + i.a.a.a.qC(46, this.Zeo.computeSize());
      }
      i = i + (i.a.a.b.b.a.ko(47) + 1) + i.a.a.b.b.a.cJ(48, this.Zeq) + (i.a.a.b.b.a.ko(49) + 1) + (i.a.a.b.b.a.ko(50) + 1);
      paramInt = i;
      if (this.Zet != null) {
        paramInt = i + i.a.a.a.qC(51, this.Zet.computeSize());
      }
      i = paramInt;
      if (this.YTl != null) {
        i = paramInt + i.a.a.b.b.a.h(52, this.YTl);
      }
      paramInt = i;
      if (this.Zeu != null) {
        paramInt = i + i.a.a.b.b.a.h(53, this.Zeu);
      }
      i = paramInt;
      if (this.Zev != null) {
        i = paramInt + i.a.a.b.b.a.h(54, this.Zev);
      }
      paramInt = i;
      if (this.Zew != null) {
        paramInt = i + i.a.a.b.b.a.h(55, this.Zew);
      }
      i = paramInt;
      if (this.Zex != null) {
        i = paramInt + i.a.a.b.b.a.h(56, this.Zex);
      }
      AppMethodBeat.o(113976);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.ZdK.clear();
        this.ZdL.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(113976);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ws localws = (ws)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113976);
          return -1;
        case 1: 
          localws.wsy = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(113976);
          return 0;
        case 2: 
          localws.nQG = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(113976);
          return 0;
        case 3: 
          localws.appid = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(113976);
          return 0;
        case 4: 
          localws.YYZ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(113976);
          return 0;
        case 5: 
          localws.ZdI = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(113976);
          return 0;
        case 6: 
          localws.tNW = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(113976);
          return 0;
        case 7: 
          localws.mee = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(113976);
          return 0;
        case 8: 
          localws.title = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(113976);
          return 0;
        case 9: 
          localws.wsz = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(113976);
          return 0;
        case 10: 
          localws.nRQ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(113976);
          return 0;
        case 11: 
          localws.pHt = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(113976);
          return 0;
        case 12: 
          localws.ZdJ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(113976);
          return 0;
        case 13: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aek();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aek)localObject2).parseFrom((byte[])localObject1);
            }
            localws.ZdK.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(113976);
          return 0;
        case 14: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aek();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aek)localObject2).parseFrom((byte[])localObject1);
            }
            localws.ZdL.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(113976);
          return 0;
        case 15: 
          localws.ZdM = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(113976);
          return 0;
        case 16: 
          localws.ZdN = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(113976);
          return 0;
        case 17: 
          localws.source = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(113976);
          return 0;
        case 18: 
          localws.ZdO = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(113976);
          return 0;
        case 19: 
          localws.wtN = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(113976);
          return 0;
        case 20: 
          localws.rHe = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(113976);
          return 0;
        case 21: 
          localws.ZdP = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(113976);
          return 0;
        case 22: 
          localws.ZdQ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(113976);
          return 0;
        case 23: 
          localws.ZdR = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(113976);
          return 0;
        case 24: 
          localws.ZdS = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(113976);
          return 0;
        case 25: 
          localws.ZdT = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(113976);
          return 0;
        case 26: 
          localws.ZdU = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(113976);
          return 0;
        case 27: 
          localws.ZdV = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(113976);
          return 0;
        case 28: 
          localws.ZdW = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(113976);
          return 0;
        case 29: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new wh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((wh)localObject2).parseFrom((byte[])localObject1);
            }
            localws.ZdX = ((wh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(113976);
          return 0;
        case 30: 
          localws.ZdY = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(113976);
          return 0;
        case 31: 
          localws.ZdZ = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(113976);
          return 0;
        case 32: 
          localws.Zea = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(113976);
          return 0;
        case 33: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new akb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((akb)localObject2).parseFrom((byte[])localObject1);
            }
            localws.Zeb = ((akb)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(113976);
          return 0;
        case 34: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fum();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fum)localObject2).parseFrom((byte[])localObject1);
            }
            localws.Zec = ((fum)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(113976);
          return 0;
        case 35: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bzp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bzp)localObject2).parseFrom((byte[])localObject1);
            }
            localws.Zed = ((bzp)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(113976);
          return 0;
        case 36: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bj)localObject2).parseFrom((byte[])localObject1);
            }
            localws.Zee = ((bj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(113976);
          return 0;
        case 37: 
          localws.Zef = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(113976);
          return 0;
        case 38: 
          localws.Zeg = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(113976);
          return 0;
        case 39: 
          localws.Zeh = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(113976);
          return 0;
        case 40: 
          localws.Zei = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(113976);
          return 0;
        case 41: 
          localws.Zej = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(113976);
          return 0;
        case 42: 
          localws.Zek = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(113976);
          return 0;
        case 43: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aek();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aek)localObject2).parseFrom((byte[])localObject1);
            }
            localws.Zel = ((aek)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(113976);
          return 0;
        case 44: 
          localws.Zem = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(113976);
          return 0;
        case 45: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aek();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aek)localObject2).parseFrom((byte[])localObject1);
            }
            localws.Zen = ((aek)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(113976);
          return 0;
        case 46: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new alk();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((alk)localObject2).parseFrom((byte[])localObject1);
            }
            localws.Zeo = ((alk)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(113976);
          return 0;
        case 47: 
          localws.Zep = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(113976);
          return 0;
        case 48: 
          localws.Zeq = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(113976);
          return 0;
        case 49: 
          localws.Zer = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(113976);
          return 0;
        case 50: 
          localws.Zes = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(113976);
          return 0;
        case 51: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ru();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ru)localObject2).parseFrom((byte[])localObject1);
            }
            localws.Zet = ((ru)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(113976);
          return 0;
        case 52: 
          localws.YTl = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(113976);
          return 0;
        case 53: 
          localws.Zeu = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(113976);
          return 0;
        case 54: 
          localws.Zev = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(113976);
          return 0;
        case 55: 
          localws.Zew = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(113976);
          return 0;
        }
        localws.Zex = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(113976);
        return 0;
      }
      AppMethodBeat.o(113976);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ws
 * JD-Core Version:    0.7.0.1
 */