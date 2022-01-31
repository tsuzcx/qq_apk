package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class beq
  extends com.tencent.mm.bv.a
{
  public int gwP;
  public String gwQ;
  public String gwR;
  public String gwS;
  public int gwT;
  public String gwU;
  public int gwV;
  public int gwW;
  public String gwX;
  public String gwY;
  public int jJS;
  public bwc wOT;
  public long wRQ;
  public String wRR;
  public int wmq;
  public int wmt;
  public bwc xmi;
  public int xpe;
  public String xpf;
  public String xpg;
  public String xph;
  public int xpi;
  public yn xtJ;
  public int xtY;
  public int xtq;
  public int xud;
  public com.tencent.mm.bv.b xue;
  public int xug;
  public bwc xuh;
  public bwc xui;
  public int xuj;
  public int xuk;
  public int xul;
  public int xum;
  public int xun;
  public ati xuo;
  public int xup;
  public String xuq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(60051);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wOT == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: UserName");
        AppMethodBeat.o(60051);
        throw paramVarArgs;
      }
      if (this.xmi == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: NickName");
        AppMethodBeat.o(60051);
        throw paramVarArgs;
      }
      if (this.xuh == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: BindEmail");
        AppMethodBeat.o(60051);
        throw paramVarArgs;
      }
      if (this.xui == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: BindMobile");
        AppMethodBeat.o(60051);
        throw paramVarArgs;
      }
      paramVarArgs.aO(1, this.xug);
      if (this.wOT != null)
      {
        paramVarArgs.iQ(2, this.wOT.computeSize());
        this.wOT.writeFields(paramVarArgs);
      }
      if (this.xmi != null)
      {
        paramVarArgs.iQ(3, this.xmi.computeSize());
        this.xmi.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(4, this.wmq);
      if (this.xuh != null)
      {
        paramVarArgs.iQ(5, this.xuh.computeSize());
        this.xuh.writeFields(paramVarArgs);
      }
      if (this.xui != null)
      {
        paramVarArgs.iQ(6, this.xui.computeSize());
        this.xui.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(7, this.jJS);
      paramVarArgs.aO(8, this.xud);
      if (this.xue != null) {
        paramVarArgs.c(9, this.xue);
      }
      paramVarArgs.aO(10, this.gwP);
      if (this.gwQ != null) {
        paramVarArgs.e(11, this.gwQ);
      }
      if (this.gwR != null) {
        paramVarArgs.e(12, this.gwR);
      }
      if (this.gwS != null) {
        paramVarArgs.e(13, this.gwS);
      }
      paramVarArgs.aO(14, this.gwT);
      if (this.xtJ != null)
      {
        paramVarArgs.iQ(15, this.xtJ.computeSize());
        this.xtJ.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(16, this.wmt);
      paramVarArgs.aO(17, this.xpe);
      if (this.xpf != null) {
        paramVarArgs.e(18, this.xpf);
      }
      paramVarArgs.aO(19, this.xuj);
      paramVarArgs.aO(20, this.xuk);
      paramVarArgs.aO(21, this.xtq);
      paramVarArgs.aO(22, this.xul);
      paramVarArgs.aO(23, this.xum);
      if (this.xpg != null) {
        paramVarArgs.e(24, this.xpg);
      }
      paramVarArgs.aO(25, this.xun);
      if (this.xuo != null)
      {
        paramVarArgs.iQ(26, this.xuo.computeSize());
        this.xuo.writeFields(paramVarArgs);
      }
      if (this.gwU != null) {
        paramVarArgs.e(27, this.gwU);
      }
      if (this.xph != null) {
        paramVarArgs.e(28, this.xph);
      }
      paramVarArgs.aO(29, this.xpi);
      paramVarArgs.aO(30, this.xup);
      paramVarArgs.am(31, this.wRQ);
      if (this.wRR != null) {
        paramVarArgs.e(32, this.wRR);
      }
      paramVarArgs.aO(33, this.gwW);
      paramVarArgs.aO(34, this.gwV);
      if (this.gwX != null) {
        paramVarArgs.e(35, this.gwX);
      }
      paramVarArgs.aO(36, this.xtY);
      if (this.xuq != null) {
        paramVarArgs.e(37, this.xuq);
      }
      if (this.gwY != null) {
        paramVarArgs.e(38, this.gwY);
      }
      AppMethodBeat.o(60051);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.xug) + 0;
      paramInt = i;
      if (this.wOT != null) {
        paramInt = i + e.a.a.a.iP(2, this.wOT.computeSize());
      }
      i = paramInt;
      if (this.xmi != null) {
        i = paramInt + e.a.a.a.iP(3, this.xmi.computeSize());
      }
      i += e.a.a.b.b.a.bl(4, this.wmq);
      paramInt = i;
      if (this.xuh != null) {
        paramInt = i + e.a.a.a.iP(5, this.xuh.computeSize());
      }
      i = paramInt;
      if (this.xui != null) {
        i = paramInt + e.a.a.a.iP(6, this.xui.computeSize());
      }
      i = i + e.a.a.b.b.a.bl(7, this.jJS) + e.a.a.b.b.a.bl(8, this.xud);
      paramInt = i;
      if (this.xue != null) {
        paramInt = i + e.a.a.b.b.a.b(9, this.xue);
      }
      i = paramInt + e.a.a.b.b.a.bl(10, this.gwP);
      paramInt = i;
      if (this.gwQ != null) {
        paramInt = i + e.a.a.b.b.a.f(11, this.gwQ);
      }
      i = paramInt;
      if (this.gwR != null) {
        i = paramInt + e.a.a.b.b.a.f(12, this.gwR);
      }
      paramInt = i;
      if (this.gwS != null) {
        paramInt = i + e.a.a.b.b.a.f(13, this.gwS);
      }
      i = paramInt + e.a.a.b.b.a.bl(14, this.gwT);
      paramInt = i;
      if (this.xtJ != null) {
        paramInt = i + e.a.a.a.iP(15, this.xtJ.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(16, this.wmt) + e.a.a.b.b.a.bl(17, this.xpe);
      paramInt = i;
      if (this.xpf != null) {
        paramInt = i + e.a.a.b.b.a.f(18, this.xpf);
      }
      i = paramInt + e.a.a.b.b.a.bl(19, this.xuj) + e.a.a.b.b.a.bl(20, this.xuk) + e.a.a.b.b.a.bl(21, this.xtq) + e.a.a.b.b.a.bl(22, this.xul) + e.a.a.b.b.a.bl(23, this.xum);
      paramInt = i;
      if (this.xpg != null) {
        paramInt = i + e.a.a.b.b.a.f(24, this.xpg);
      }
      i = paramInt + e.a.a.b.b.a.bl(25, this.xun);
      paramInt = i;
      if (this.xuo != null) {
        paramInt = i + e.a.a.a.iP(26, this.xuo.computeSize());
      }
      i = paramInt;
      if (this.gwU != null) {
        i = paramInt + e.a.a.b.b.a.f(27, this.gwU);
      }
      paramInt = i;
      if (this.xph != null) {
        paramInt = i + e.a.a.b.b.a.f(28, this.xph);
      }
      i = paramInt + e.a.a.b.b.a.bl(29, this.xpi) + e.a.a.b.b.a.bl(30, this.xup) + e.a.a.b.b.a.p(31, this.wRQ);
      paramInt = i;
      if (this.wRR != null) {
        paramInt = i + e.a.a.b.b.a.f(32, this.wRR);
      }
      i = paramInt + e.a.a.b.b.a.bl(33, this.gwW) + e.a.a.b.b.a.bl(34, this.gwV);
      paramInt = i;
      if (this.gwX != null) {
        paramInt = i + e.a.a.b.b.a.f(35, this.gwX);
      }
      i = paramInt + e.a.a.b.b.a.bl(36, this.xtY);
      paramInt = i;
      if (this.xuq != null) {
        paramInt = i + e.a.a.b.b.a.f(37, this.xuq);
      }
      i = paramInt;
      if (this.gwY != null) {
        i = paramInt + e.a.a.b.b.a.f(38, this.gwY);
      }
      AppMethodBeat.o(60051);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      if (this.wOT == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: UserName");
        AppMethodBeat.o(60051);
        throw paramVarArgs;
      }
      if (this.xmi == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: NickName");
        AppMethodBeat.o(60051);
        throw paramVarArgs;
      }
      if (this.xuh == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: BindEmail");
        AppMethodBeat.o(60051);
        throw paramVarArgs;
      }
      if (this.xui == null)
      {
        paramVarArgs = new e.a.a.b("Not all required fields were included: BindMobile");
        AppMethodBeat.o(60051);
        throw paramVarArgs;
      }
      AppMethodBeat.o(60051);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      beq localbeq = (beq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(60051);
        return -1;
      case 1: 
        localbeq.xug = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(60051);
        return 0;
      case 2: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bwc();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbeq.wOT = ((bwc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(60051);
        return 0;
      case 3: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bwc();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbeq.xmi = ((bwc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(60051);
        return 0;
      case 4: 
        localbeq.wmq = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(60051);
        return 0;
      case 5: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bwc();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbeq.xuh = ((bwc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(60051);
        return 0;
      case 6: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bwc();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbeq.xui = ((bwc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(60051);
        return 0;
      case 7: 
        localbeq.jJS = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(60051);
        return 0;
      case 8: 
        localbeq.xud = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(60051);
        return 0;
      case 9: 
        localbeq.xue = ((e.a.a.a.a)localObject1).CLY.eqS();
        AppMethodBeat.o(60051);
        return 0;
      case 10: 
        localbeq.gwP = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(60051);
        return 0;
      case 11: 
        localbeq.gwQ = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(60051);
        return 0;
      case 12: 
        localbeq.gwR = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(60051);
        return 0;
      case 13: 
        localbeq.gwS = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(60051);
        return 0;
      case 14: 
        localbeq.gwT = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(60051);
        return 0;
      case 15: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new yn();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((yn)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbeq.xtJ = ((yn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(60051);
        return 0;
      case 16: 
        localbeq.wmt = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(60051);
        return 0;
      case 17: 
        localbeq.xpe = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(60051);
        return 0;
      case 18: 
        localbeq.xpf = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(60051);
        return 0;
      case 19: 
        localbeq.xuj = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(60051);
        return 0;
      case 20: 
        localbeq.xuk = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(60051);
        return 0;
      case 21: 
        localbeq.xtq = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(60051);
        return 0;
      case 22: 
        localbeq.xul = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(60051);
        return 0;
      case 23: 
        localbeq.xum = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(60051);
        return 0;
      case 24: 
        localbeq.xpg = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(60051);
        return 0;
      case 25: 
        localbeq.xun = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(60051);
        return 0;
      case 26: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ati();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ati)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localbeq.xuo = ((ati)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(60051);
        return 0;
      case 27: 
        localbeq.gwU = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(60051);
        return 0;
      case 28: 
        localbeq.xph = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(60051);
        return 0;
      case 29: 
        localbeq.xpi = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(60051);
        return 0;
      case 30: 
        localbeq.xup = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(60051);
        return 0;
      case 31: 
        localbeq.wRQ = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(60051);
        return 0;
      case 32: 
        localbeq.wRR = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(60051);
        return 0;
      case 33: 
        localbeq.gwW = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(60051);
        return 0;
      case 34: 
        localbeq.gwV = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(60051);
        return 0;
      case 35: 
        localbeq.gwX = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(60051);
        return 0;
      case 36: 
        localbeq.xtY = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(60051);
        return 0;
      case 37: 
        localbeq.xuq = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(60051);
        return 0;
      }
      localbeq.gwY = ((e.a.a.a.a)localObject1).CLY.readString();
      AppMethodBeat.o(60051);
      return 0;
    }
    AppMethodBeat.o(60051);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.beq
 * JD-Core Version:    0.7.0.1
 */