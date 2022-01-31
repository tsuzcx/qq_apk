package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import java.util.LinkedList;

public final class bh
  extends buy
{
  public String bssid;
  public int cpt;
  public String qZx;
  public int scene;
  public String ssid;
  public int wnF;
  public String wnG;
  public long wnH;
  public bt wnI;
  public int wnJ;
  public int wnK;
  public String wnL;
  public int wnM;
  public b wnN;
  public b wnO;
  public long wnP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94491);
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
      paramVarArgs.aO(3, this.wnF);
      if (this.wnG != null) {
        paramVarArgs.e(4, this.wnG);
      }
      paramVarArgs.aO(5, this.scene);
      if (this.ssid != null) {
        paramVarArgs.e(6, this.ssid);
      }
      if (this.bssid != null) {
        paramVarArgs.e(7, this.bssid);
      }
      paramVarArgs.am(8, this.wnH);
      if (this.wnI != null)
      {
        paramVarArgs.iQ(9, this.wnI.computeSize());
        this.wnI.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(10, this.wnJ);
      paramVarArgs.aO(11, this.wnK);
      paramVarArgs.aO(12, this.cpt);
      if (this.wnL != null) {
        paramVarArgs.e(13, this.wnL);
      }
      paramVarArgs.aO(14, this.wnM);
      if (this.wnN != null) {
        paramVarArgs.c(15, this.wnN);
      }
      if (this.wnO != null) {
        paramVarArgs.c(16, this.wnO);
      }
      paramVarArgs.am(17, this.wnP);
      AppMethodBeat.o(94491);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1258;
      }
    }
    label1258:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.qZx != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.qZx);
      }
      i += e.a.a.b.b.a.bl(3, this.wnF);
      paramInt = i;
      if (this.wnG != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wnG);
      }
      i = paramInt + e.a.a.b.b.a.bl(5, this.scene);
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
      if (this.wnI != null) {
        paramInt = i + e.a.a.a.iP(9, this.wnI.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(10, this.wnJ) + e.a.a.b.b.a.bl(11, this.wnK) + e.a.a.b.b.a.bl(12, this.cpt);
      paramInt = i;
      if (this.wnL != null) {
        paramInt = i + e.a.a.b.b.a.f(13, this.wnL);
      }
      i = paramInt + e.a.a.b.b.a.bl(14, this.wnM);
      paramInt = i;
      if (this.wnN != null) {
        paramInt = i + e.a.a.b.b.a.b(15, this.wnN);
      }
      i = paramInt;
      if (this.wnO != null) {
        i = paramInt + e.a.a.b.b.a.b(16, this.wnO);
      }
      paramInt = e.a.a.b.b.a.p(17, this.wnP);
      AppMethodBeat.o(94491);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(94491);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bh localbh = (bh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(94491);
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
            localbh.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94491);
          return 0;
        case 2: 
          localbh.qZx = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94491);
          return 0;
        case 3: 
          localbh.wnF = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94491);
          return 0;
        case 4: 
          localbh.wnG = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94491);
          return 0;
        case 5: 
          localbh.scene = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94491);
          return 0;
        case 6: 
          localbh.ssid = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94491);
          return 0;
        case 7: 
          localbh.bssid = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94491);
          return 0;
        case 8: 
          localbh.wnH = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(94491);
          return 0;
        case 9: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bt();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bt)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbh.wnI = ((bt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94491);
          return 0;
        case 10: 
          localbh.wnJ = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94491);
          return 0;
        case 11: 
          localbh.wnK = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94491);
          return 0;
        case 12: 
          localbh.cpt = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94491);
          return 0;
        case 13: 
          localbh.wnL = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94491);
          return 0;
        case 14: 
          localbh.wnM = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94491);
          return 0;
        case 15: 
          localbh.wnN = ((e.a.a.a.a)localObject1).CLY.eqS();
          AppMethodBeat.o(94491);
          return 0;
        case 16: 
          localbh.wnO = ((e.a.a.a.a)localObject1).CLY.eqS();
          AppMethodBeat.o(94491);
          return 0;
        }
        localbh.wnP = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(94491);
        return 0;
      }
      AppMethodBeat.o(94491);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bh
 * JD-Core Version:    0.7.0.1
 */