package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class azr
  extends com.tencent.mm.bv.a
{
  public int gwP;
  public String gwQ;
  public String gwR;
  public String gwS;
  public String gwU;
  public String gwY;
  public String gwZ;
  public String jJA;
  public String jKG;
  public String wJq;
  public String wJr;
  public String wYu;
  public int woS;
  public String xfJ;
  public String xpd;
  public int xpe;
  public String xpf;
  public String xpg;
  public String xph;
  public int xpi;
  public int xpj;
  public cfj xpk;
  public wc xpl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(55526);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.jJA != null) {
        paramVarArgs.e(1, this.jJA);
      }
      if (this.jKG != null) {
        paramVarArgs.e(2, this.jKG);
      }
      if (this.gwQ != null) {
        paramVarArgs.e(3, this.gwQ);
      }
      if (this.gwR != null) {
        paramVarArgs.e(4, this.gwR);
      }
      if (this.gwS != null) {
        paramVarArgs.e(5, this.gwS);
      }
      if (this.xpd != null) {
        paramVarArgs.e(6, this.xpd);
      }
      paramVarArgs.aO(7, this.gwP);
      paramVarArgs.aO(8, this.woS);
      paramVarArgs.aO(9, this.xpe);
      if (this.xpf != null) {
        paramVarArgs.e(10, this.xpf);
      }
      if (this.xfJ != null) {
        paramVarArgs.e(11, this.xfJ);
      }
      if (this.gwU != null) {
        paramVarArgs.e(12, this.gwU);
      }
      if (this.xpg != null) {
        paramVarArgs.e(13, this.xpg);
      }
      if (this.xph != null) {
        paramVarArgs.e(14, this.xph);
      }
      paramVarArgs.aO(15, this.xpi);
      paramVarArgs.aO(19, this.xpj);
      if (this.xpk != null)
      {
        paramVarArgs.iQ(20, this.xpk.computeSize());
        this.xpk.writeFields(paramVarArgs);
      }
      if (this.gwY != null) {
        paramVarArgs.e(21, this.gwY);
      }
      if (this.wJq != null) {
        paramVarArgs.e(22, this.wJq);
      }
      if (this.wJr != null) {
        paramVarArgs.e(23, this.wJr);
      }
      if (this.gwZ != null) {
        paramVarArgs.e(24, this.gwZ);
      }
      if (this.xpl != null)
      {
        paramVarArgs.iQ(25, this.xpl.computeSize());
        this.xpl.writeFields(paramVarArgs);
      }
      if (this.wYu != null) {
        paramVarArgs.e(26, this.wYu);
      }
      AppMethodBeat.o(55526);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jJA == null) {
        break label1686;
      }
    }
    label1686:
    for (int i = e.a.a.b.b.a.f(1, this.jJA) + 0;; i = 0)
    {
      paramInt = i;
      if (this.jKG != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.jKG);
      }
      i = paramInt;
      if (this.gwQ != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.gwQ);
      }
      paramInt = i;
      if (this.gwR != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.gwR);
      }
      i = paramInt;
      if (this.gwS != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.gwS);
      }
      paramInt = i;
      if (this.xpd != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.xpd);
      }
      i = paramInt + e.a.a.b.b.a.bl(7, this.gwP) + e.a.a.b.b.a.bl(8, this.woS) + e.a.a.b.b.a.bl(9, this.xpe);
      paramInt = i;
      if (this.xpf != null) {
        paramInt = i + e.a.a.b.b.a.f(10, this.xpf);
      }
      i = paramInt;
      if (this.xfJ != null) {
        i = paramInt + e.a.a.b.b.a.f(11, this.xfJ);
      }
      paramInt = i;
      if (this.gwU != null) {
        paramInt = i + e.a.a.b.b.a.f(12, this.gwU);
      }
      i = paramInt;
      if (this.xpg != null) {
        i = paramInt + e.a.a.b.b.a.f(13, this.xpg);
      }
      paramInt = i;
      if (this.xph != null) {
        paramInt = i + e.a.a.b.b.a.f(14, this.xph);
      }
      i = paramInt + e.a.a.b.b.a.bl(15, this.xpi) + e.a.a.b.b.a.bl(19, this.xpj);
      paramInt = i;
      if (this.xpk != null) {
        paramInt = i + e.a.a.a.iP(20, this.xpk.computeSize());
      }
      i = paramInt;
      if (this.gwY != null) {
        i = paramInt + e.a.a.b.b.a.f(21, this.gwY);
      }
      paramInt = i;
      if (this.wJq != null) {
        paramInt = i + e.a.a.b.b.a.f(22, this.wJq);
      }
      i = paramInt;
      if (this.wJr != null) {
        i = paramInt + e.a.a.b.b.a.f(23, this.wJr);
      }
      paramInt = i;
      if (this.gwZ != null) {
        paramInt = i + e.a.a.b.b.a.f(24, this.gwZ);
      }
      i = paramInt;
      if (this.xpl != null) {
        i = paramInt + e.a.a.a.iP(25, this.xpl.computeSize());
      }
      paramInt = i;
      if (this.wYu != null) {
        paramInt = i + e.a.a.b.b.a.f(26, this.wYu);
      }
      AppMethodBeat.o(55526);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(55526);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        azr localazr = (azr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 16: 
        case 17: 
        case 18: 
        default: 
          AppMethodBeat.o(55526);
          return -1;
        case 1: 
          localazr.jJA = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(55526);
          return 0;
        case 2: 
          localazr.jKG = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(55526);
          return 0;
        case 3: 
          localazr.gwQ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(55526);
          return 0;
        case 4: 
          localazr.gwR = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(55526);
          return 0;
        case 5: 
          localazr.gwS = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(55526);
          return 0;
        case 6: 
          localazr.xpd = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(55526);
          return 0;
        case 7: 
          localazr.gwP = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(55526);
          return 0;
        case 8: 
          localazr.woS = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(55526);
          return 0;
        case 9: 
          localazr.xpe = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(55526);
          return 0;
        case 10: 
          localazr.xpf = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(55526);
          return 0;
        case 11: 
          localazr.xfJ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(55526);
          return 0;
        case 12: 
          localazr.gwU = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(55526);
          return 0;
        case 13: 
          localazr.xpg = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(55526);
          return 0;
        case 14: 
          localazr.xph = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(55526);
          return 0;
        case 15: 
          localazr.xpi = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(55526);
          return 0;
        case 19: 
          localazr.xpj = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(55526);
          return 0;
        case 20: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cfj();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cfj)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localazr.xpk = ((cfj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(55526);
          return 0;
        case 21: 
          localazr.gwY = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(55526);
          return 0;
        case 22: 
          localazr.wJq = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(55526);
          return 0;
        case 23: 
          localazr.wJr = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(55526);
          return 0;
        case 24: 
          localazr.gwZ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(55526);
          return 0;
        case 25: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new wc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((wc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localazr.xpl = ((wc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(55526);
          return 0;
        }
        localazr.wYu = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(55526);
        return 0;
      }
      AppMethodBeat.o(55526);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azr
 * JD-Core Version:    0.7.0.1
 */