package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cbj
  extends com.tencent.mm.bv.a
{
  public int gwP;
  public String gwQ;
  public String gwR;
  public String gwS;
  public String gwY;
  public String gwZ;
  public String jJA;
  public String jKG;
  public String wJq;
  public String wJr;
  public String wYu;
  public int woS;
  public int xMa;
  public SKBuiltinBuffer_t xMb;
  public int xMc;
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
    AppMethodBeat.i(28642);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.xMb == null)
      {
        paramVarArgs = new b("Not all required fields were included: ImgBuffer");
        AppMethodBeat.o(28642);
        throw paramVarArgs;
      }
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
      paramVarArgs.aO(9, this.xMa);
      if (this.xMb != null)
      {
        paramVarArgs.iQ(10, this.xMb.computeSize());
        this.xMb.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(11, this.xMc);
      if (this.xpg != null) {
        paramVarArgs.e(12, this.xpg);
      }
      if (this.xph != null) {
        paramVarArgs.e(13, this.xph);
      }
      paramVarArgs.aO(14, this.xpi);
      paramVarArgs.aO(15, this.xpe);
      if (this.xpf != null) {
        paramVarArgs.e(16, this.xpf);
      }
      if (this.xfJ != null) {
        paramVarArgs.e(17, this.xfJ);
      }
      paramVarArgs.aO(21, this.xpj);
      if (this.xpk != null)
      {
        paramVarArgs.iQ(22, this.xpk.computeSize());
        this.xpk.writeFields(paramVarArgs);
      }
      if (this.gwY != null) {
        paramVarArgs.e(23, this.gwY);
      }
      if (this.wJq != null) {
        paramVarArgs.e(24, this.wJq);
      }
      if (this.wJr != null) {
        paramVarArgs.e(25, this.wJr);
      }
      if (this.gwZ != null) {
        paramVarArgs.e(26, this.gwZ);
      }
      if (this.xpl != null)
      {
        paramVarArgs.iQ(27, this.xpl.computeSize());
        this.xpl.writeFields(paramVarArgs);
      }
      if (this.wYu != null) {
        paramVarArgs.e(28, this.wYu);
      }
      AppMethodBeat.o(28642);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jJA == null) {
        break label1953;
      }
    }
    label1953:
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
      i = paramInt + e.a.a.b.b.a.bl(7, this.gwP) + e.a.a.b.b.a.bl(8, this.woS) + e.a.a.b.b.a.bl(9, this.xMa);
      paramInt = i;
      if (this.xMb != null) {
        paramInt = i + e.a.a.a.iP(10, this.xMb.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(11, this.xMc);
      paramInt = i;
      if (this.xpg != null) {
        paramInt = i + e.a.a.b.b.a.f(12, this.xpg);
      }
      i = paramInt;
      if (this.xph != null) {
        i = paramInt + e.a.a.b.b.a.f(13, this.xph);
      }
      i = i + e.a.a.b.b.a.bl(14, this.xpi) + e.a.a.b.b.a.bl(15, this.xpe);
      paramInt = i;
      if (this.xpf != null) {
        paramInt = i + e.a.a.b.b.a.f(16, this.xpf);
      }
      i = paramInt;
      if (this.xfJ != null) {
        i = paramInt + e.a.a.b.b.a.f(17, this.xfJ);
      }
      i += e.a.a.b.b.a.bl(21, this.xpj);
      paramInt = i;
      if (this.xpk != null) {
        paramInt = i + e.a.a.a.iP(22, this.xpk.computeSize());
      }
      i = paramInt;
      if (this.gwY != null) {
        i = paramInt + e.a.a.b.b.a.f(23, this.gwY);
      }
      paramInt = i;
      if (this.wJq != null) {
        paramInt = i + e.a.a.b.b.a.f(24, this.wJq);
      }
      i = paramInt;
      if (this.wJr != null) {
        i = paramInt + e.a.a.b.b.a.f(25, this.wJr);
      }
      paramInt = i;
      if (this.gwZ != null) {
        paramInt = i + e.a.a.b.b.a.f(26, this.gwZ);
      }
      i = paramInt;
      if (this.xpl != null) {
        i = paramInt + e.a.a.a.iP(27, this.xpl.computeSize());
      }
      paramInt = i;
      if (this.wYu != null) {
        paramInt = i + e.a.a.b.b.a.f(28, this.wYu);
      }
      AppMethodBeat.o(28642);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.xMb == null)
        {
          paramVarArgs = new b("Not all required fields were included: ImgBuffer");
          AppMethodBeat.o(28642);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28642);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cbj localcbj = (cbj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 18: 
        case 19: 
        case 20: 
        default: 
          AppMethodBeat.o(28642);
          return -1;
        case 1: 
          localcbj.jJA = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28642);
          return 0;
        case 2: 
          localcbj.jKG = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28642);
          return 0;
        case 3: 
          localcbj.gwQ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28642);
          return 0;
        case 4: 
          localcbj.gwR = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28642);
          return 0;
        case 5: 
          localcbj.gwS = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28642);
          return 0;
        case 6: 
          localcbj.xpd = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28642);
          return 0;
        case 7: 
          localcbj.gwP = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28642);
          return 0;
        case 8: 
          localcbj.woS = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28642);
          return 0;
        case 9: 
          localcbj.xMa = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28642);
          return 0;
        case 10: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcbj.xMb = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28642);
          return 0;
        case 11: 
          localcbj.xMc = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28642);
          return 0;
        case 12: 
          localcbj.xpg = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28642);
          return 0;
        case 13: 
          localcbj.xph = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28642);
          return 0;
        case 14: 
          localcbj.xpi = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28642);
          return 0;
        case 15: 
          localcbj.xpe = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28642);
          return 0;
        case 16: 
          localcbj.xpf = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28642);
          return 0;
        case 17: 
          localcbj.xfJ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28642);
          return 0;
        case 21: 
          localcbj.xpj = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28642);
          return 0;
        case 22: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cfj();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cfj)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcbj.xpk = ((cfj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28642);
          return 0;
        case 23: 
          localcbj.gwY = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28642);
          return 0;
        case 24: 
          localcbj.wJq = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28642);
          return 0;
        case 25: 
          localcbj.wJr = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28642);
          return 0;
        case 26: 
          localcbj.gwZ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28642);
          return 0;
        case 27: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new wc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((wc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcbj.xpl = ((wc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28642);
          return 0;
        }
        localcbj.wYu = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(28642);
        return 0;
      }
      AppMethodBeat.o(28642);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cbj
 * JD-Core Version:    0.7.0.1
 */