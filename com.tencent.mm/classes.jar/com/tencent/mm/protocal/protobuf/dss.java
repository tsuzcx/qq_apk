package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dss
  extends com.tencent.mm.bx.a
{
  public String CNs;
  public int CNt;
  public int DLD;
  public ble DLE;
  public String DVa;
  public String Dop;
  public LinkedList<xp> EFX;
  public int EHi;
  public String EHj;
  public String EHk;
  public LinkedList<String> EHl;
  public int EHm;
  public amb EHn;
  public String EcN;
  public int Efc;
  public int Efg;
  public int Efz;
  public int EsO;
  public int Scene;
  public int mBH;
  
  public dss()
  {
    AppMethodBeat.i(117947);
    this.EHi = 2;
    this.EFX = new LinkedList();
    this.EHl = new LinkedList();
    AppMethodBeat.o(117947);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117948);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.CNt);
      paramVarArgs.aR(2, this.DLD);
      paramVarArgs.aR(3, this.Efc);
      if (this.Dop != null) {
        paramVarArgs.d(4, this.Dop);
      }
      if (this.DLE != null)
      {
        paramVarArgs.kX(5, this.DLE.computeSize());
        this.DLE.writeFields(paramVarArgs);
      }
      paramVarArgs.aR(6, this.Scene);
      if (this.CNs != null) {
        paramVarArgs.d(7, this.CNs);
      }
      paramVarArgs.aR(8, this.Efg);
      paramVarArgs.aR(9, this.EHi);
      paramVarArgs.e(10, 8, this.EFX);
      if (this.EHj != null) {
        paramVarArgs.d(11, this.EHj);
      }
      if (this.DVa != null) {
        paramVarArgs.d(12, this.DVa);
      }
      paramVarArgs.aR(13, this.EsO);
      if (this.EHk != null) {
        paramVarArgs.d(14, this.EHk);
      }
      if (this.EcN != null) {
        paramVarArgs.d(15, this.EcN);
      }
      paramVarArgs.e(16, 1, this.EHl);
      paramVarArgs.aR(17, this.Efz);
      paramVarArgs.aR(18, this.mBH);
      paramVarArgs.aR(19, this.EHm);
      if (this.EHn != null)
      {
        paramVarArgs.kX(20, this.EHn.computeSize());
        this.EHn.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(117948);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.CNt) + 0 + f.a.a.b.b.a.bA(2, this.DLD) + f.a.a.b.b.a.bA(3, this.Efc);
      paramInt = i;
      if (this.Dop != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Dop);
      }
      i = paramInt;
      if (this.DLE != null) {
        i = paramInt + f.a.a.a.kW(5, this.DLE.computeSize());
      }
      i += f.a.a.b.b.a.bA(6, this.Scene);
      paramInt = i;
      if (this.CNs != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.CNs);
      }
      i = paramInt + f.a.a.b.b.a.bA(8, this.Efg) + f.a.a.b.b.a.bA(9, this.EHi) + f.a.a.a.c(10, 8, this.EFX);
      paramInt = i;
      if (this.EHj != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.EHj);
      }
      i = paramInt;
      if (this.DVa != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.DVa);
      }
      i += f.a.a.b.b.a.bA(13, this.EsO);
      paramInt = i;
      if (this.EHk != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.EHk);
      }
      i = paramInt;
      if (this.EcN != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.EcN);
      }
      i = i + f.a.a.a.c(16, 1, this.EHl) + f.a.a.b.b.a.bA(17, this.Efz) + f.a.a.b.b.a.bA(18, this.mBH) + f.a.a.b.b.a.bA(19, this.EHm);
      paramInt = i;
      if (this.EHn != null) {
        paramInt = i + f.a.a.a.kW(20, this.EHn.computeSize());
      }
      AppMethodBeat.o(117948);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.EFX.clear();
      this.EHl.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(117948);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dss localdss = (dss)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117948);
        return -1;
      case 1: 
        localdss.CNt = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(117948);
        return 0;
      case 2: 
        localdss.DLD = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(117948);
        return 0;
      case 3: 
        localdss.Efc = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(117948);
        return 0;
      case 4: 
        localdss.Dop = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(117948);
        return 0;
      case 5: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ble();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ble)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdss.DLE = ((ble)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117948);
        return 0;
      case 6: 
        localdss.Scene = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(117948);
        return 0;
      case 7: 
        localdss.CNs = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(117948);
        return 0;
      case 8: 
        localdss.Efg = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(117948);
        return 0;
      case 9: 
        localdss.EHi = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(117948);
        return 0;
      case 10: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new xp();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((xp)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdss.EFX.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117948);
        return 0;
      case 11: 
        localdss.EHj = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(117948);
        return 0;
      case 12: 
        localdss.DVa = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(117948);
        return 0;
      case 13: 
        localdss.EsO = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(117948);
        return 0;
      case 14: 
        localdss.EHk = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(117948);
        return 0;
      case 15: 
        localdss.EcN = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(117948);
        return 0;
      case 16: 
        localdss.EHl.add(((f.a.a.a.a)localObject1).KhF.readString());
        AppMethodBeat.o(117948);
        return 0;
      case 17: 
        localdss.Efz = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(117948);
        return 0;
      case 18: 
        localdss.mBH = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(117948);
        return 0;
      case 19: 
        localdss.EHm = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(117948);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new amb();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((amb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localdss.EHn = ((amb)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(117948);
      return 0;
    }
    AppMethodBeat.o(117948);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dss
 * JD-Core Version:    0.7.0.1
 */