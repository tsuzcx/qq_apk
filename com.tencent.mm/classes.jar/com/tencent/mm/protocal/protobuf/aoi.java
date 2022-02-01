package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aoi
  extends com.tencent.mm.bx.a
{
  public String IHo;
  public String ProductID;
  public String ZtY;
  public String Zul;
  public String Zuw;
  public String akka;
  public String akkb;
  public String akkc;
  public int akkd;
  public int akke;
  public int akkf;
  public LinkedList<etl> akkg;
  public int akkh;
  public String akki;
  public String akkj;
  public String akkk;
  public String akkl;
  public int akkm;
  public LinkedList<goj> akkn;
  public String akko;
  public String akkp;
  public String akkq;
  public aoh akkr;
  public gok akks;
  public String akkt;
  public dzv akku;
  public int akkv;
  public int akkw;
  public int crz;
  
  public aoi()
  {
    AppMethodBeat.i(104776);
    this.akkg = new LinkedList();
    this.akkn = new LinkedList();
    AppMethodBeat.o(104776);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104777);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ProductID != null) {
        paramVarArgs.g(1, this.ProductID);
      }
      if (this.IHo != null) {
        paramVarArgs.g(2, this.IHo);
      }
      if (this.Zul != null) {
        paramVarArgs.g(3, this.Zul);
      }
      if (this.akka != null) {
        paramVarArgs.g(4, this.akka);
      }
      if (this.akkb != null) {
        paramVarArgs.g(5, this.akkb);
      }
      if (this.akkc != null) {
        paramVarArgs.g(6, this.akkc);
      }
      paramVarArgs.bS(7, this.akkd);
      paramVarArgs.bS(8, this.akke);
      paramVarArgs.bS(9, this.akkf);
      paramVarArgs.e(10, 8, this.akkg);
      if (this.ZtY != null) {
        paramVarArgs.g(11, this.ZtY);
      }
      paramVarArgs.bS(12, this.akkh);
      if (this.akki != null) {
        paramVarArgs.g(13, this.akki);
      }
      if (this.akkj != null) {
        paramVarArgs.g(14, this.akkj);
      }
      if (this.Zuw != null) {
        paramVarArgs.g(15, this.Zuw);
      }
      if (this.akkk != null) {
        paramVarArgs.g(16, this.akkk);
      }
      if (this.akkl != null) {
        paramVarArgs.g(17, this.akkl);
      }
      paramVarArgs.bS(18, this.akkm);
      paramVarArgs.e(19, 8, this.akkn);
      paramVarArgs.bS(20, this.crz);
      if (this.akko != null) {
        paramVarArgs.g(21, this.akko);
      }
      if (this.akkp != null) {
        paramVarArgs.g(22, this.akkp);
      }
      if (this.akkq != null) {
        paramVarArgs.g(23, this.akkq);
      }
      if (this.akkr != null)
      {
        paramVarArgs.qD(24, this.akkr.computeSize());
        this.akkr.writeFields(paramVarArgs);
      }
      if (this.akks != null)
      {
        paramVarArgs.qD(25, this.akks.computeSize());
        this.akks.writeFields(paramVarArgs);
      }
      if (this.akkt != null) {
        paramVarArgs.g(26, this.akkt);
      }
      if (this.akku != null)
      {
        paramVarArgs.qD(27, this.akku.computeSize());
        this.akku.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(28, this.akkv);
      paramVarArgs.bS(29, this.akkw);
      AppMethodBeat.o(104777);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ProductID == null) {
        break label2136;
      }
    }
    label2136:
    for (int i = i.a.a.b.b.a.h(1, this.ProductID) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IHo != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.IHo);
      }
      i = paramInt;
      if (this.Zul != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.Zul);
      }
      paramInt = i;
      if (this.akka != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.akka);
      }
      i = paramInt;
      if (this.akkb != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.akkb);
      }
      paramInt = i;
      if (this.akkc != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.akkc);
      }
      i = paramInt + i.a.a.b.b.a.cJ(7, this.akkd) + i.a.a.b.b.a.cJ(8, this.akke) + i.a.a.b.b.a.cJ(9, this.akkf) + i.a.a.a.c(10, 8, this.akkg);
      paramInt = i;
      if (this.ZtY != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.ZtY);
      }
      i = paramInt + i.a.a.b.b.a.cJ(12, this.akkh);
      paramInt = i;
      if (this.akki != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.akki);
      }
      i = paramInt;
      if (this.akkj != null) {
        i = paramInt + i.a.a.b.b.a.h(14, this.akkj);
      }
      paramInt = i;
      if (this.Zuw != null) {
        paramInt = i + i.a.a.b.b.a.h(15, this.Zuw);
      }
      i = paramInt;
      if (this.akkk != null) {
        i = paramInt + i.a.a.b.b.a.h(16, this.akkk);
      }
      paramInt = i;
      if (this.akkl != null) {
        paramInt = i + i.a.a.b.b.a.h(17, this.akkl);
      }
      i = paramInt + i.a.a.b.b.a.cJ(18, this.akkm) + i.a.a.a.c(19, 8, this.akkn) + i.a.a.b.b.a.cJ(20, this.crz);
      paramInt = i;
      if (this.akko != null) {
        paramInt = i + i.a.a.b.b.a.h(21, this.akko);
      }
      i = paramInt;
      if (this.akkp != null) {
        i = paramInt + i.a.a.b.b.a.h(22, this.akkp);
      }
      paramInt = i;
      if (this.akkq != null) {
        paramInt = i + i.a.a.b.b.a.h(23, this.akkq);
      }
      i = paramInt;
      if (this.akkr != null) {
        i = paramInt + i.a.a.a.qC(24, this.akkr.computeSize());
      }
      paramInt = i;
      if (this.akks != null) {
        paramInt = i + i.a.a.a.qC(25, this.akks.computeSize());
      }
      i = paramInt;
      if (this.akkt != null) {
        i = paramInt + i.a.a.b.b.a.h(26, this.akkt);
      }
      paramInt = i;
      if (this.akku != null) {
        paramInt = i + i.a.a.a.qC(27, this.akku.computeSize());
      }
      i = i.a.a.b.b.a.cJ(28, this.akkv);
      int j = i.a.a.b.b.a.cJ(29, this.akkw);
      AppMethodBeat.o(104777);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.akkg.clear();
        this.akkn.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(104777);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        aoi localaoi = (aoi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104777);
          return -1;
        case 1: 
          localaoi.ProductID = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(104777);
          return 0;
        case 2: 
          localaoi.IHo = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(104777);
          return 0;
        case 3: 
          localaoi.Zul = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(104777);
          return 0;
        case 4: 
          localaoi.akka = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(104777);
          return 0;
        case 5: 
          localaoi.akkb = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(104777);
          return 0;
        case 6: 
          localaoi.akkc = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(104777);
          return 0;
        case 7: 
          localaoi.akkd = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(104777);
          return 0;
        case 8: 
          localaoi.akke = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(104777);
          return 0;
        case 9: 
          localaoi.akkf = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(104777);
          return 0;
        case 10: 
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
            localaoi.akkg.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104777);
          return 0;
        case 11: 
          localaoi.ZtY = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(104777);
          return 0;
        case 12: 
          localaoi.akkh = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(104777);
          return 0;
        case 13: 
          localaoi.akki = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(104777);
          return 0;
        case 14: 
          localaoi.akkj = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(104777);
          return 0;
        case 15: 
          localaoi.Zuw = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(104777);
          return 0;
        case 16: 
          localaoi.akkk = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(104777);
          return 0;
        case 17: 
          localaoi.akkl = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(104777);
          return 0;
        case 18: 
          localaoi.akkm = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(104777);
          return 0;
        case 19: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new goj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((goj)localObject2).parseFrom((byte[])localObject1);
            }
            localaoi.akkn.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104777);
          return 0;
        case 20: 
          localaoi.crz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(104777);
          return 0;
        case 21: 
          localaoi.akko = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(104777);
          return 0;
        case 22: 
          localaoi.akkp = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(104777);
          return 0;
        case 23: 
          localaoi.akkq = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(104777);
          return 0;
        case 24: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aoh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aoh)localObject2).parseFrom((byte[])localObject1);
            }
            localaoi.akkr = ((aoh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104777);
          return 0;
        case 25: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gok();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gok)localObject2).parseFrom((byte[])localObject1);
            }
            localaoi.akks = ((gok)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104777);
          return 0;
        case 26: 
          localaoi.akkt = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(104777);
          return 0;
        case 27: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dzv();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dzv)localObject2).parseFrom((byte[])localObject1);
            }
            localaoi.akku = ((dzv)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104777);
          return 0;
        case 28: 
          localaoi.akkv = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(104777);
          return 0;
        }
        localaoi.akkw = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(104777);
        return 0;
      }
      AppMethodBeat.o(104777);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aoi
 * JD-Core Version:    0.7.0.1
 */