package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dsy
  extends com.tencent.mm.bx.a
{
  public day AFW;
  public long CNp;
  public String CNs;
  public int CNt;
  public ble DLE;
  public int DVd;
  public String Dop;
  public LinkedList<xp> EFX;
  public int EHA;
  public LinkedList<String> EHB;
  public LinkedList<btq> EHC;
  public com.tencent.mm.bx.b EHD;
  public com.tencent.mm.bx.b EHE;
  public cur EHF;
  public zk EHG;
  public cax EHH;
  public int EHi;
  public String EHj;
  public int EHx;
  public String EHy;
  public String EHz;
  public int Efc;
  public int Efg;
  public LinkedList<dis> EhY;
  public int Scene;
  public String oXs;
  
  public dsy()
  {
    AppMethodBeat.i(117954);
    this.EhY = new LinkedList();
    this.EHB = new LinkedList();
    this.EHi = 2;
    this.EFX = new LinkedList();
    this.EHC = new LinkedList();
    AppMethodBeat.o(117954);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117955);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Dop == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: Keyword");
        AppMethodBeat.o(117955);
        throw paramVarArgs;
      }
      paramVarArgs.aR(1, this.Efc);
      if (this.Dop != null) {
        paramVarArgs.d(2, this.Dop);
      }
      paramVarArgs.aR(3, this.CNt);
      paramVarArgs.aG(4, this.CNp);
      paramVarArgs.aR(5, this.EHx);
      if (this.DLE != null)
      {
        paramVarArgs.kX(6, this.DLE.computeSize());
        this.DLE.writeFields(paramVarArgs);
      }
      paramVarArgs.e(7, 8, this.EhY);
      paramVarArgs.aR(8, this.Scene);
      if (this.CNs != null) {
        paramVarArgs.d(9, this.CNs);
      }
      paramVarArgs.aR(10, this.Efg);
      if (this.EHy != null) {
        paramVarArgs.d(11, this.EHy);
      }
      if (this.EHz != null) {
        paramVarArgs.d(12, this.EHz);
      }
      paramVarArgs.aR(13, this.EHA);
      paramVarArgs.e(14, 1, this.EHB);
      paramVarArgs.aR(15, this.EHi);
      if (this.AFW != null)
      {
        paramVarArgs.kX(16, this.AFW.computeSize());
        this.AFW.writeFields(paramVarArgs);
      }
      paramVarArgs.e(17, 8, this.EFX);
      paramVarArgs.e(18, 8, this.EHC);
      if (this.oXs != null) {
        paramVarArgs.d(19, this.oXs);
      }
      if (this.EHD != null) {
        paramVarArgs.c(20, this.EHD);
      }
      if (this.EHj != null) {
        paramVarArgs.d(21, this.EHj);
      }
      if (this.EHE != null) {
        paramVarArgs.c(22, this.EHE);
      }
      if (this.EHF != null)
      {
        paramVarArgs.kX(23, this.EHF.computeSize());
        this.EHF.writeFields(paramVarArgs);
      }
      if (this.EHG != null)
      {
        paramVarArgs.kX(24, this.EHG.computeSize());
        this.EHG.writeFields(paramVarArgs);
      }
      if (this.EHH != null)
      {
        paramVarArgs.kX(25, this.EHH.computeSize());
        this.EHH.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(26, this.DVd);
      AppMethodBeat.o(117955);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.Efc) + 0;
      paramInt = i;
      if (this.Dop != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Dop);
      }
      i = paramInt + f.a.a.b.b.a.bA(3, this.CNt) + f.a.a.b.b.a.q(4, this.CNp) + f.a.a.b.b.a.bA(5, this.EHx);
      paramInt = i;
      if (this.DLE != null) {
        paramInt = i + f.a.a.a.kW(6, this.DLE.computeSize());
      }
      i = paramInt + f.a.a.a.c(7, 8, this.EhY) + f.a.a.b.b.a.bA(8, this.Scene);
      paramInt = i;
      if (this.CNs != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.CNs);
      }
      i = paramInt + f.a.a.b.b.a.bA(10, this.Efg);
      paramInt = i;
      if (this.EHy != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.EHy);
      }
      i = paramInt;
      if (this.EHz != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.EHz);
      }
      i = i + f.a.a.b.b.a.bA(13, this.EHA) + f.a.a.a.c(14, 1, this.EHB) + f.a.a.b.b.a.bA(15, this.EHi);
      paramInt = i;
      if (this.AFW != null) {
        paramInt = i + f.a.a.a.kW(16, this.AFW.computeSize());
      }
      i = paramInt + f.a.a.a.c(17, 8, this.EFX) + f.a.a.a.c(18, 8, this.EHC);
      paramInt = i;
      if (this.oXs != null) {
        paramInt = i + f.a.a.b.b.a.e(19, this.oXs);
      }
      i = paramInt;
      if (this.EHD != null) {
        i = paramInt + f.a.a.b.b.a.b(20, this.EHD);
      }
      paramInt = i;
      if (this.EHj != null) {
        paramInt = i + f.a.a.b.b.a.e(21, this.EHj);
      }
      i = paramInt;
      if (this.EHE != null) {
        i = paramInt + f.a.a.b.b.a.b(22, this.EHE);
      }
      paramInt = i;
      if (this.EHF != null) {
        paramInt = i + f.a.a.a.kW(23, this.EHF.computeSize());
      }
      i = paramInt;
      if (this.EHG != null) {
        i = paramInt + f.a.a.a.kW(24, this.EHG.computeSize());
      }
      paramInt = i;
      if (this.EHH != null) {
        paramInt = i + f.a.a.a.kW(25, this.EHH.computeSize());
      }
      i = f.a.a.b.b.a.bA(26, this.DVd);
      AppMethodBeat.o(117955);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.EhY.clear();
      this.EHB.clear();
      this.EFX.clear();
      this.EHC.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      if (this.Dop == null)
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
      dsy localdsy = (dsy)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117955);
        return -1;
      case 1: 
        localdsy.Efc = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(117955);
        return 0;
      case 2: 
        localdsy.Dop = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(117955);
        return 0;
      case 3: 
        localdsy.CNt = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(117955);
        return 0;
      case 4: 
        localdsy.CNp = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(117955);
        return 0;
      case 5: 
        localdsy.EHx = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(117955);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ble();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ble)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdsy.DLE = ((ble)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117955);
        return 0;
      case 7: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dis();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dis)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdsy.EhY.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117955);
        return 0;
      case 8: 
        localdsy.Scene = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(117955);
        return 0;
      case 9: 
        localdsy.CNs = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(117955);
        return 0;
      case 10: 
        localdsy.Efg = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(117955);
        return 0;
      case 11: 
        localdsy.EHy = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(117955);
        return 0;
      case 12: 
        localdsy.EHz = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(117955);
        return 0;
      case 13: 
        localdsy.EHA = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(117955);
        return 0;
      case 14: 
        localdsy.EHB.add(((f.a.a.a.a)localObject1).KhF.readString());
        AppMethodBeat.o(117955);
        return 0;
      case 15: 
        localdsy.EHi = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(117955);
        return 0;
      case 16: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new day();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((day)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdsy.AFW = ((day)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117955);
        return 0;
      case 17: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new xp();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((xp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdsy.EFX.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117955);
        return 0;
      case 18: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new btq();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((btq)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdsy.EHC.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117955);
        return 0;
      case 19: 
        localdsy.oXs = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(117955);
        return 0;
      case 20: 
        localdsy.EHD = ((f.a.a.a.a)localObject1).KhF.fMu();
        AppMethodBeat.o(117955);
        return 0;
      case 21: 
        localdsy.EHj = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(117955);
        return 0;
      case 22: 
        localdsy.EHE = ((f.a.a.a.a)localObject1).KhF.fMu();
        AppMethodBeat.o(117955);
        return 0;
      case 23: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cur();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cur)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdsy.EHF = ((cur)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117955);
        return 0;
      case 24: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new zk();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((zk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdsy.EHG = ((zk)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117955);
        return 0;
      case 25: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cax();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cax)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdsy.EHH = ((cax)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117955);
        return 0;
      }
      localdsy.DVd = ((f.a.a.a.a)localObject1).KhF.xS();
      AppMethodBeat.o(117955);
      return 0;
    }
    AppMethodBeat.o(117955);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsy
 * JD-Core Version:    0.7.0.1
 */