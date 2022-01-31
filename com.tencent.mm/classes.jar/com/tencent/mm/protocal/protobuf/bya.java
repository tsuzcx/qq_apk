package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bya
  extends com.tencent.mm.bv.a
{
  public int gwP;
  public String gwQ;
  public String gwR;
  public String gwS;
  public int gwT;
  public String gwU;
  public String gwY;
  public String wJq;
  public String wJr;
  public bwc wOT;
  public wd xKz;
  public bwc xmi;
  public int xpe;
  public String xpf;
  public String xpg;
  public String xph;
  public int xpi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124359);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wOT == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(124359);
        throw paramVarArgs;
      }
      if (this.xmi == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(124359);
        throw paramVarArgs;
      }
      if (this.wOT != null)
      {
        paramVarArgs.iQ(1, this.wOT.computeSize());
        this.wOT.writeFields(paramVarArgs);
      }
      if (this.xmi != null)
      {
        paramVarArgs.iQ(2, this.xmi.computeSize());
        this.xmi.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(3, this.gwP);
      if (this.gwQ != null) {
        paramVarArgs.e(4, this.gwQ);
      }
      if (this.gwR != null) {
        paramVarArgs.e(5, this.gwR);
      }
      if (this.gwS != null) {
        paramVarArgs.e(6, this.gwS);
      }
      paramVarArgs.aO(7, this.gwT);
      paramVarArgs.aO(8, this.xpe);
      if (this.xpf != null) {
        paramVarArgs.e(9, this.xpf);
      }
      if (this.xpg != null) {
        paramVarArgs.e(10, this.xpg);
      }
      if (this.gwU != null) {
        paramVarArgs.e(11, this.gwU);
      }
      if (this.xph != null) {
        paramVarArgs.e(12, this.xph);
      }
      paramVarArgs.aO(13, this.xpi);
      if (this.gwY != null) {
        paramVarArgs.e(14, this.gwY);
      }
      if (this.xKz != null)
      {
        paramVarArgs.iQ(15, this.xKz.computeSize());
        this.xKz.writeFields(paramVarArgs);
      }
      if (this.wJq != null) {
        paramVarArgs.e(16, this.wJq);
      }
      if (this.wJr != null) {
        paramVarArgs.e(17, this.wJr);
      }
      AppMethodBeat.o(124359);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wOT == null) {
        break label1514;
      }
    }
    label1514:
    for (paramInt = e.a.a.a.iP(1, this.wOT.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xmi != null) {
        i = paramInt + e.a.a.a.iP(2, this.xmi.computeSize());
      }
      i += e.a.a.b.b.a.bl(3, this.gwP);
      paramInt = i;
      if (this.gwQ != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.gwQ);
      }
      i = paramInt;
      if (this.gwR != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.gwR);
      }
      paramInt = i;
      if (this.gwS != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.gwS);
      }
      i = paramInt + e.a.a.b.b.a.bl(7, this.gwT) + e.a.a.b.b.a.bl(8, this.xpe);
      paramInt = i;
      if (this.xpf != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.xpf);
      }
      i = paramInt;
      if (this.xpg != null) {
        i = paramInt + e.a.a.b.b.a.f(10, this.xpg);
      }
      paramInt = i;
      if (this.gwU != null) {
        paramInt = i + e.a.a.b.b.a.f(11, this.gwU);
      }
      i = paramInt;
      if (this.xph != null) {
        i = paramInt + e.a.a.b.b.a.f(12, this.xph);
      }
      i += e.a.a.b.b.a.bl(13, this.xpi);
      paramInt = i;
      if (this.gwY != null) {
        paramInt = i + e.a.a.b.b.a.f(14, this.gwY);
      }
      i = paramInt;
      if (this.xKz != null) {
        i = paramInt + e.a.a.a.iP(15, this.xKz.computeSize());
      }
      paramInt = i;
      if (this.wJq != null) {
        paramInt = i + e.a.a.b.b.a.f(16, this.wJq);
      }
      i = paramInt;
      if (this.wJr != null) {
        i = paramInt + e.a.a.b.b.a.f(17, this.wJr);
      }
      AppMethodBeat.o(124359);
      return i;
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
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(124359);
          throw paramVarArgs;
        }
        if (this.xmi == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(124359);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124359);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bya localbya = (bya)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124359);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbya.wOT = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124359);
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
            localbya.xmi = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124359);
          return 0;
        case 3: 
          localbya.gwP = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(124359);
          return 0;
        case 4: 
          localbya.gwQ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(124359);
          return 0;
        case 5: 
          localbya.gwR = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(124359);
          return 0;
        case 6: 
          localbya.gwS = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(124359);
          return 0;
        case 7: 
          localbya.gwT = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(124359);
          return 0;
        case 8: 
          localbya.xpe = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(124359);
          return 0;
        case 9: 
          localbya.xpf = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(124359);
          return 0;
        case 10: 
          localbya.xpg = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(124359);
          return 0;
        case 11: 
          localbya.gwU = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(124359);
          return 0;
        case 12: 
          localbya.xph = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(124359);
          return 0;
        case 13: 
          localbya.xpi = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(124359);
          return 0;
        case 14: 
          localbya.gwY = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(124359);
          return 0;
        case 15: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new wd();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((wd)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbya.xKz = ((wd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124359);
          return 0;
        case 16: 
          localbya.wJq = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(124359);
          return 0;
        }
        localbya.wJr = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(124359);
        return 0;
      }
      AppMethodBeat.o(124359);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bya
 * JD-Core Version:    0.7.0.1
 */