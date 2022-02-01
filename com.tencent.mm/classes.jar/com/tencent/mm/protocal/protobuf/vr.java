package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class vr
  extends com.tencent.mm.bx.a
{
  public long ZbA;
  public int ZbB;
  public String ZbC;
  public aek ZbD;
  public LinkedList<bj> ZbE;
  public aek ZbF;
  public aek ZbG;
  public aek ZbH;
  public akc ZbI;
  public String ZbJ;
  public aek ZbK;
  public String ZbL;
  public aek ZbM;
  public boolean ZbN;
  public boolean ZbO;
  public aek ZbP;
  public aek ZbQ;
  public int Zbr;
  public int Zbs;
  public LinkedList<xd> Zbt;
  public LinkedList<xd> Zbu;
  public LinkedList<xd> Zbv;
  public LinkedList<String> Zbw;
  public int Zbx;
  public int Zby;
  public LinkedList<aek> Zbz;
  public String code;
  public int status;
  
  public vr()
  {
    AppMethodBeat.i(113948);
    this.Zbt = new LinkedList();
    this.Zbu = new LinkedList();
    this.Zbv = new LinkedList();
    this.Zbw = new LinkedList();
    this.Zbz = new LinkedList();
    this.ZbE = new LinkedList();
    AppMethodBeat.o(113948);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113949);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.status);
      paramVarArgs.bS(2, this.Zbr);
      paramVarArgs.bS(3, this.Zbs);
      paramVarArgs.e(4, 8, this.Zbt);
      paramVarArgs.e(5, 8, this.Zbu);
      paramVarArgs.e(6, 8, this.Zbv);
      paramVarArgs.e(7, 1, this.Zbw);
      paramVarArgs.bS(8, this.Zbx);
      if (this.code != null) {
        paramVarArgs.g(9, this.code);
      }
      paramVarArgs.bS(10, this.Zby);
      paramVarArgs.e(11, 8, this.Zbz);
      paramVarArgs.bv(12, this.ZbA);
      paramVarArgs.bS(13, this.ZbB);
      if (this.ZbC != null) {
        paramVarArgs.g(14, this.ZbC);
      }
      if (this.ZbD != null)
      {
        paramVarArgs.qD(15, this.ZbD.computeSize());
        this.ZbD.writeFields(paramVarArgs);
      }
      paramVarArgs.e(16, 8, this.ZbE);
      if (this.ZbF != null)
      {
        paramVarArgs.qD(17, this.ZbF.computeSize());
        this.ZbF.writeFields(paramVarArgs);
      }
      if (this.ZbG != null)
      {
        paramVarArgs.qD(18, this.ZbG.computeSize());
        this.ZbG.writeFields(paramVarArgs);
      }
      if (this.ZbH != null)
      {
        paramVarArgs.qD(19, this.ZbH.computeSize());
        this.ZbH.writeFields(paramVarArgs);
      }
      if (this.ZbI != null)
      {
        paramVarArgs.qD(20, this.ZbI.computeSize());
        this.ZbI.writeFields(paramVarArgs);
      }
      if (this.ZbJ != null) {
        paramVarArgs.g(21, this.ZbJ);
      }
      if (this.ZbK != null)
      {
        paramVarArgs.qD(22, this.ZbK.computeSize());
        this.ZbK.writeFields(paramVarArgs);
      }
      if (this.ZbL != null) {
        paramVarArgs.g(23, this.ZbL);
      }
      if (this.ZbM != null)
      {
        paramVarArgs.qD(24, this.ZbM.computeSize());
        this.ZbM.writeFields(paramVarArgs);
      }
      paramVarArgs.di(25, this.ZbN);
      paramVarArgs.di(26, this.ZbO);
      if (this.ZbP != null)
      {
        paramVarArgs.qD(29, this.ZbP.computeSize());
        this.ZbP.writeFields(paramVarArgs);
      }
      if (this.ZbQ != null)
      {
        paramVarArgs.qD(30, this.ZbQ.computeSize());
        this.ZbQ.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(113949);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.status) + 0 + i.a.a.b.b.a.cJ(2, this.Zbr) + i.a.a.b.b.a.cJ(3, this.Zbs) + i.a.a.a.c(4, 8, this.Zbt) + i.a.a.a.c(5, 8, this.Zbu) + i.a.a.a.c(6, 8, this.Zbv) + i.a.a.a.c(7, 1, this.Zbw) + i.a.a.b.b.a.cJ(8, this.Zbx);
      paramInt = i;
      if (this.code != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.code);
      }
      i = paramInt + i.a.a.b.b.a.cJ(10, this.Zby) + i.a.a.a.c(11, 8, this.Zbz) + i.a.a.b.b.a.q(12, this.ZbA) + i.a.a.b.b.a.cJ(13, this.ZbB);
      paramInt = i;
      if (this.ZbC != null) {
        paramInt = i + i.a.a.b.b.a.h(14, this.ZbC);
      }
      i = paramInt;
      if (this.ZbD != null) {
        i = paramInt + i.a.a.a.qC(15, this.ZbD.computeSize());
      }
      i += i.a.a.a.c(16, 8, this.ZbE);
      paramInt = i;
      if (this.ZbF != null) {
        paramInt = i + i.a.a.a.qC(17, this.ZbF.computeSize());
      }
      i = paramInt;
      if (this.ZbG != null) {
        i = paramInt + i.a.a.a.qC(18, this.ZbG.computeSize());
      }
      paramInt = i;
      if (this.ZbH != null) {
        paramInt = i + i.a.a.a.qC(19, this.ZbH.computeSize());
      }
      i = paramInt;
      if (this.ZbI != null) {
        i = paramInt + i.a.a.a.qC(20, this.ZbI.computeSize());
      }
      paramInt = i;
      if (this.ZbJ != null) {
        paramInt = i + i.a.a.b.b.a.h(21, this.ZbJ);
      }
      i = paramInt;
      if (this.ZbK != null) {
        i = paramInt + i.a.a.a.qC(22, this.ZbK.computeSize());
      }
      paramInt = i;
      if (this.ZbL != null) {
        paramInt = i + i.a.a.b.b.a.h(23, this.ZbL);
      }
      i = paramInt;
      if (this.ZbM != null) {
        i = paramInt + i.a.a.a.qC(24, this.ZbM.computeSize());
      }
      i = i + (i.a.a.b.b.a.ko(25) + 1) + (i.a.a.b.b.a.ko(26) + 1);
      paramInt = i;
      if (this.ZbP != null) {
        paramInt = i + i.a.a.a.qC(29, this.ZbP.computeSize());
      }
      i = paramInt;
      if (this.ZbQ != null) {
        i = paramInt + i.a.a.a.qC(30, this.ZbQ.computeSize());
      }
      AppMethodBeat.o(113949);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Zbt.clear();
      this.Zbu.clear();
      this.Zbv.clear();
      this.Zbw.clear();
      this.Zbz.clear();
      this.ZbE.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(113949);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      vr localvr = (vr)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      case 27: 
      case 28: 
      default: 
        AppMethodBeat.o(113949);
        return -1;
      case 1: 
        localvr.status = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(113949);
        return 0;
      case 2: 
        localvr.Zbr = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(113949);
        return 0;
      case 3: 
        localvr.Zbs = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(113949);
        return 0;
      case 4: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new xd();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((xd)localObject2).parseFrom((byte[])localObject1);
          }
          localvr.Zbt.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 5: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new xd();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((xd)localObject2).parseFrom((byte[])localObject1);
          }
          localvr.Zbu.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 6: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new xd();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((xd)localObject2).parseFrom((byte[])localObject1);
          }
          localvr.Zbv.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 7: 
        localvr.Zbw.add(((i.a.a.a.a)localObject1).ajGk.readString());
        AppMethodBeat.o(113949);
        return 0;
      case 8: 
        localvr.Zbx = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(113949);
        return 0;
      case 9: 
        localvr.code = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(113949);
        return 0;
      case 10: 
        localvr.Zby = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(113949);
        return 0;
      case 11: 
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
          localvr.Zbz.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 12: 
        localvr.ZbA = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(113949);
        return 0;
      case 13: 
        localvr.ZbB = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(113949);
        return 0;
      case 14: 
        localvr.ZbC = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(113949);
        return 0;
      case 15: 
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
          localvr.ZbD = ((aek)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 16: 
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
          localvr.ZbE.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 17: 
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
          localvr.ZbF = ((aek)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 18: 
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
          localvr.ZbG = ((aek)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 19: 
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
          localvr.ZbH = ((aek)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 20: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new akc();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((akc)localObject2).parseFrom((byte[])localObject1);
          }
          localvr.ZbI = ((akc)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 21: 
        localvr.ZbJ = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(113949);
        return 0;
      case 22: 
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
          localvr.ZbK = ((aek)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 23: 
        localvr.ZbL = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(113949);
        return 0;
      case 24: 
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
          localvr.ZbM = ((aek)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      case 25: 
        localvr.ZbN = ((i.a.a.a.a)localObject1).ajGk.aai();
        AppMethodBeat.o(113949);
        return 0;
      case 26: 
        localvr.ZbO = ((i.a.a.a.a)localObject1).ajGk.aai();
        AppMethodBeat.o(113949);
        return 0;
      case 29: 
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
          localvr.ZbP = ((aek)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(113949);
        return 0;
      }
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
        localvr.ZbQ = ((aek)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(113949);
      return 0;
    }
    AppMethodBeat.o(113949);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vr
 * JD-Core Version:    0.7.0.1
 */