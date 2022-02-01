package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eer
  extends com.tencent.mm.bx.a
{
  public dlx DBi;
  public long FMq;
  public String FMt;
  public int FMu;
  public btn GRt;
  public String Gsr;
  public LinkedList<aag> HOp;
  public int HPA;
  public String HPB;
  public int HPP;
  public String HPQ;
  public String HPR;
  public int HPS;
  public LinkedList<String> HPT;
  public LinkedList<ccy> HPU;
  public com.tencent.mm.bx.b HPV;
  public com.tencent.mm.bx.b HPW;
  public dfq HPX;
  public acj HPY;
  public ckv HPZ;
  public int HbV;
  public int Hmr;
  public int Hmv;
  public LinkedList<dty> Hpv;
  public int Scene;
  public String qei;
  
  public eer()
  {
    AppMethodBeat.i(117954);
    this.Hpv = new LinkedList();
    this.HPT = new LinkedList();
    this.HPA = 2;
    this.HOp = new LinkedList();
    this.HPU = new LinkedList();
    AppMethodBeat.o(117954);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117955);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Gsr == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Keyword");
        AppMethodBeat.o(117955);
        throw paramVarArgs;
      }
      paramVarArgs.aS(1, this.Hmr);
      if (this.Gsr != null) {
        paramVarArgs.d(2, this.Gsr);
      }
      paramVarArgs.aS(3, this.FMu);
      paramVarArgs.aY(4, this.FMq);
      paramVarArgs.aS(5, this.HPP);
      if (this.GRt != null)
      {
        paramVarArgs.lC(6, this.GRt.computeSize());
        this.GRt.writeFields(paramVarArgs);
      }
      paramVarArgs.e(7, 8, this.Hpv);
      paramVarArgs.aS(8, this.Scene);
      if (this.FMt != null) {
        paramVarArgs.d(9, this.FMt);
      }
      paramVarArgs.aS(10, this.Hmv);
      if (this.HPQ != null) {
        paramVarArgs.d(11, this.HPQ);
      }
      if (this.HPR != null) {
        paramVarArgs.d(12, this.HPR);
      }
      paramVarArgs.aS(13, this.HPS);
      paramVarArgs.e(14, 1, this.HPT);
      paramVarArgs.aS(15, this.HPA);
      if (this.DBi != null)
      {
        paramVarArgs.lC(16, this.DBi.computeSize());
        this.DBi.writeFields(paramVarArgs);
      }
      paramVarArgs.e(17, 8, this.HOp);
      paramVarArgs.e(18, 8, this.HPU);
      if (this.qei != null) {
        paramVarArgs.d(19, this.qei);
      }
      if (this.HPV != null) {
        paramVarArgs.c(20, this.HPV);
      }
      if (this.HPB != null) {
        paramVarArgs.d(21, this.HPB);
      }
      if (this.HPW != null) {
        paramVarArgs.c(22, this.HPW);
      }
      if (this.HPX != null)
      {
        paramVarArgs.lC(23, this.HPX.computeSize());
        this.HPX.writeFields(paramVarArgs);
      }
      if (this.HPY != null)
      {
        paramVarArgs.lC(24, this.HPY.computeSize());
        this.HPY.writeFields(paramVarArgs);
      }
      if (this.HPZ != null)
      {
        paramVarArgs.lC(25, this.HPZ.computeSize());
        this.HPZ.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(26, this.HbV);
      AppMethodBeat.o(117955);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.Hmr) + 0;
      paramInt = i;
      if (this.Gsr != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Gsr);
      }
      i = paramInt + f.a.a.b.b.a.bz(3, this.FMu) + f.a.a.b.b.a.p(4, this.FMq) + f.a.a.b.b.a.bz(5, this.HPP);
      paramInt = i;
      if (this.GRt != null) {
        paramInt = i + f.a.a.a.lB(6, this.GRt.computeSize());
      }
      i = paramInt + f.a.a.a.c(7, 8, this.Hpv) + f.a.a.b.b.a.bz(8, this.Scene);
      paramInt = i;
      if (this.FMt != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.FMt);
      }
      i = paramInt + f.a.a.b.b.a.bz(10, this.Hmv);
      paramInt = i;
      if (this.HPQ != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.HPQ);
      }
      i = paramInt;
      if (this.HPR != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.HPR);
      }
      i = i + f.a.a.b.b.a.bz(13, this.HPS) + f.a.a.a.c(14, 1, this.HPT) + f.a.a.b.b.a.bz(15, this.HPA);
      paramInt = i;
      if (this.DBi != null) {
        paramInt = i + f.a.a.a.lB(16, this.DBi.computeSize());
      }
      i = paramInt + f.a.a.a.c(17, 8, this.HOp) + f.a.a.a.c(18, 8, this.HPU);
      paramInt = i;
      if (this.qei != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.qei);
      }
      i = paramInt;
      if (this.HPV != null) {
        i = paramInt + f.a.a.b.b.a.b(20, this.HPV);
      }
      paramInt = i;
      if (this.HPB != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.HPB);
      }
      i = paramInt;
      if (this.HPW != null) {
        i = paramInt + f.a.a.b.b.a.b(22, this.HPW);
      }
      paramInt = i;
      if (this.HPX != null) {
        paramInt = i + f.a.a.a.lB(23, this.HPX.computeSize());
      }
      i = paramInt;
      if (this.HPY != null) {
        i = paramInt + f.a.a.a.lB(24, this.HPY.computeSize());
      }
      paramInt = i;
      if (this.HPZ != null) {
        paramInt = i + f.a.a.a.lB(25, this.HPZ.computeSize());
      }
      i = f.a.a.b.b.a.bz(26, this.HbV);
      AppMethodBeat.o(117955);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Hpv.clear();
      this.HPT.clear();
      this.HOp.clear();
      this.HPU.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      if (this.Gsr == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Keyword");
        AppMethodBeat.o(117955);
        throw paramVarArgs;
      }
      AppMethodBeat.o(117955);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      eer localeer = (eer)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117955);
        return -1;
      case 1: 
        localeer.Hmr = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(117955);
        return 0;
      case 2: 
        localeer.Gsr = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(117955);
        return 0;
      case 3: 
        localeer.FMu = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(117955);
        return 0;
      case 4: 
        localeer.FMq = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(117955);
        return 0;
      case 5: 
        localeer.HPP = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(117955);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new btn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((btn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localeer.GRt = ((btn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117955);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dty();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dty)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localeer.Hpv.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117955);
        return 0;
      case 8: 
        localeer.Scene = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(117955);
        return 0;
      case 9: 
        localeer.FMt = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(117955);
        return 0;
      case 10: 
        localeer.Hmv = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(117955);
        return 0;
      case 11: 
        localeer.HPQ = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(117955);
        return 0;
      case 12: 
        localeer.HPR = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(117955);
        return 0;
      case 13: 
        localeer.HPS = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(117955);
        return 0;
      case 14: 
        localeer.HPT.add(((f.a.a.a.a)localObject1).NPN.readString());
        AppMethodBeat.o(117955);
        return 0;
      case 15: 
        localeer.HPA = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(117955);
        return 0;
      case 16: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dlx();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dlx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localeer.DBi = ((dlx)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117955);
        return 0;
      case 17: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aag();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aag)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localeer.HOp.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117955);
        return 0;
      case 18: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ccy();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ccy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localeer.HPU.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117955);
        return 0;
      case 19: 
        localeer.qei = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(117955);
        return 0;
      case 20: 
        localeer.HPV = ((f.a.a.a.a)localObject1).NPN.gxI();
        AppMethodBeat.o(117955);
        return 0;
      case 21: 
        localeer.HPB = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(117955);
        return 0;
      case 22: 
        localeer.HPW = ((f.a.a.a.a)localObject1).NPN.gxI();
        AppMethodBeat.o(117955);
        return 0;
      case 23: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dfq();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dfq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localeer.HPX = ((dfq)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117955);
        return 0;
      case 24: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new acj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((acj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localeer.HPY = ((acj)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117955);
        return 0;
      case 25: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ckv();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ckv)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localeer.HPZ = ((ckv)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117955);
        return 0;
      }
      localeer.HbV = ((f.a.a.a.a)localObject1).NPN.zc();
      AppMethodBeat.o(117955);
      return 0;
    }
    AppMethodBeat.o(117955);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eer
 * JD-Core Version:    0.7.0.1
 */