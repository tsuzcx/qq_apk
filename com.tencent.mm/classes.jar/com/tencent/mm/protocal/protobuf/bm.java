package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import java.util.LinkedList;

public final class bm
  extends buy
{
  public String bssid;
  public int cpt;
  public String qZx;
  public int scene;
  public String ssid;
  public int type;
  public String wnG;
  public long wnH;
  public int wnJ;
  public String wnL;
  public int wnM;
  public b wnN;
  public b wnO;
  public int wnY;
  public bl wnZ;
  public bo woa;
  public int wob;
  public int woc;
  public int wod;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94497);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.qZx != null) {
        paramVarArgs.e(2, this.qZx);
      }
      paramVarArgs.aO(3, this.scene);
      paramVarArgs.aO(4, this.type);
      paramVarArgs.aO(5, this.wnY);
      if (this.ssid != null) {
        paramVarArgs.e(6, this.ssid);
      }
      if (this.bssid != null) {
        paramVarArgs.e(7, this.bssid);
      }
      paramVarArgs.am(8, this.wnH);
      if (this.wnZ != null)
      {
        paramVarArgs.iQ(9, this.wnZ.computeSize());
        this.wnZ.writeFields(paramVarArgs);
      }
      if (this.woa != null)
      {
        paramVarArgs.iQ(10, this.woa.computeSize());
        this.woa.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(11, this.wnJ);
      if (this.wnG != null) {
        paramVarArgs.e(12, this.wnG);
      }
      paramVarArgs.aO(13, this.cpt);
      if (this.wnL != null) {
        paramVarArgs.e(14, this.wnL);
      }
      paramVarArgs.aO(15, this.wob);
      paramVarArgs.aO(16, this.woc);
      paramVarArgs.aO(17, this.wod);
      paramVarArgs.aO(18, this.wnM);
      if (this.wnN != null) {
        paramVarArgs.c(19, this.wnN);
      }
      if (this.wnO != null) {
        paramVarArgs.c(20, this.wnO);
      }
      AppMethodBeat.o(94497);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1498;
      }
    }
    label1498:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.qZx != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.qZx);
      }
      i = i + e.a.a.b.b.a.bl(3, this.scene) + e.a.a.b.b.a.bl(4, this.type) + e.a.a.b.b.a.bl(5, this.wnY);
      paramInt = i;
      if (this.ssid != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.ssid);
      }
      i = paramInt;
      if (this.bssid != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.bssid);
      }
      i += e.a.a.b.b.a.p(8, this.wnH);
      paramInt = i;
      if (this.wnZ != null) {
        paramInt = i + e.a.a.a.iP(9, this.wnZ.computeSize());
      }
      i = paramInt;
      if (this.woa != null) {
        i = paramInt + e.a.a.a.iP(10, this.woa.computeSize());
      }
      i += e.a.a.b.b.a.bl(11, this.wnJ);
      paramInt = i;
      if (this.wnG != null) {
        paramInt = i + e.a.a.b.b.a.f(12, this.wnG);
      }
      i = paramInt + e.a.a.b.b.a.bl(13, this.cpt);
      paramInt = i;
      if (this.wnL != null) {
        paramInt = i + e.a.a.b.b.a.f(14, this.wnL);
      }
      i = paramInt + e.a.a.b.b.a.bl(15, this.wob) + e.a.a.b.b.a.bl(16, this.woc) + e.a.a.b.b.a.bl(17, this.wod) + e.a.a.b.b.a.bl(18, this.wnM);
      paramInt = i;
      if (this.wnN != null) {
        paramInt = i + e.a.a.b.b.a.b(19, this.wnN);
      }
      i = paramInt;
      if (this.wnO != null) {
        i = paramInt + e.a.a.b.b.a.b(20, this.wnO);
      }
      AppMethodBeat.o(94497);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(94497);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bm localbm = (bm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(94497);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((hq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbm.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94497);
          return 0;
        case 2: 
          localbm.qZx = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94497);
          return 0;
        case 3: 
          localbm.scene = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94497);
          return 0;
        case 4: 
          localbm.type = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94497);
          return 0;
        case 5: 
          localbm.wnY = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94497);
          return 0;
        case 6: 
          localbm.ssid = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94497);
          return 0;
        case 7: 
          localbm.bssid = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94497);
          return 0;
        case 8: 
          localbm.wnH = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(94497);
          return 0;
        case 9: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bl();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bl)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbm.wnZ = ((bl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94497);
          return 0;
        case 10: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bo();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bo)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbm.woa = ((bo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94497);
          return 0;
        case 11: 
          localbm.wnJ = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94497);
          return 0;
        case 12: 
          localbm.wnG = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94497);
          return 0;
        case 13: 
          localbm.cpt = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94497);
          return 0;
        case 14: 
          localbm.wnL = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94497);
          return 0;
        case 15: 
          localbm.wob = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94497);
          return 0;
        case 16: 
          localbm.woc = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94497);
          return 0;
        case 17: 
          localbm.wod = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94497);
          return 0;
        case 18: 
          localbm.wnM = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94497);
          return 0;
        case 19: 
          localbm.wnN = ((e.a.a.a.a)localObject1).CLY.eqS();
          AppMethodBeat.o(94497);
          return 0;
        }
        localbm.wnO = ((e.a.a.a.a)localObject1).CLY.eqS();
        AppMethodBeat.o(94497);
        return 0;
      }
      AppMethodBeat.o(94497);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bm
 * JD-Core Version:    0.7.0.1
 */