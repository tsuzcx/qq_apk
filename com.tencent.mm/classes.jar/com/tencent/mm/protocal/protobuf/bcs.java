package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bcs
  extends com.tencent.mm.bv.a
{
  public String Desc;
  public String Id;
  public String Title;
  public String Url;
  public int cIp;
  public String cqq;
  public int jKs;
  public String rGh;
  public boolean raZ;
  public int sdf;
  public int subType;
  public int xrR;
  public String xrS;
  public int xrT;
  public int xrU;
  public bcu xrV;
  public String xrW;
  public int xrX;
  public int xrY;
  public String xrZ;
  public String xsa;
  public String xsb;
  public String xsc;
  public String xsd;
  public int xse;
  public long xsf;
  public String xsg;
  public String xsh;
  public int xsi;
  public String xsj;
  public String xsk;
  public int xsl;
  public String xsm;
  public String xsn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94539);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.Id != null) {
        paramVarArgs.e(1, this.Id);
      }
      paramVarArgs.aO(2, this.jKs);
      if (this.Desc != null) {
        paramVarArgs.e(3, this.Desc);
      }
      if (this.Url != null) {
        paramVarArgs.e(4, this.Url);
      }
      paramVarArgs.aO(5, this.xrR);
      if (this.xrS != null) {
        paramVarArgs.e(6, this.xrS);
      }
      paramVarArgs.aO(7, this.xrT);
      paramVarArgs.aO(8, this.xrU);
      if (this.Title != null) {
        paramVarArgs.e(9, this.Title);
      }
      if (this.xrV != null)
      {
        paramVarArgs.iQ(10, this.xrV.computeSize());
        this.xrV.writeFields(paramVarArgs);
      }
      if (this.xrW != null) {
        paramVarArgs.e(11, this.xrW);
      }
      paramVarArgs.aO(12, this.xrX);
      paramVarArgs.aO(13, this.cIp);
      paramVarArgs.aO(14, this.xrY);
      if (this.rGh != null) {
        paramVarArgs.e(15, this.rGh);
      }
      paramVarArgs.aO(16, this.subType);
      if (this.cqq != null) {
        paramVarArgs.e(17, this.cqq);
      }
      if (this.xrZ != null) {
        paramVarArgs.e(18, this.xrZ);
      }
      if (this.xsa != null) {
        paramVarArgs.e(19, this.xsa);
      }
      if (this.xsb != null) {
        paramVarArgs.e(20, this.xsb);
      }
      paramVarArgs.aO(21, this.sdf);
      if (this.xsc != null) {
        paramVarArgs.e(22, this.xsc);
      }
      if (this.xsd != null) {
        paramVarArgs.e(23, this.xsd);
      }
      paramVarArgs.aO(24, this.xse);
      paramVarArgs.am(25, this.xsf);
      if (this.xsg != null) {
        paramVarArgs.e(26, this.xsg);
      }
      if (this.xsh != null) {
        paramVarArgs.e(27, this.xsh);
      }
      paramVarArgs.aO(28, this.xsi);
      if (this.xsj != null) {
        paramVarArgs.e(29, this.xsj);
      }
      if (this.xsk != null) {
        paramVarArgs.e(30, this.xsk);
      }
      paramVarArgs.aO(31, this.xsl);
      if (this.xsm != null) {
        paramVarArgs.e(32, this.xsm);
      }
      if (this.xsn != null) {
        paramVarArgs.e(33, this.xsn);
      }
      paramVarArgs.aS(34, this.raZ);
      AppMethodBeat.o(94539);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Id == null) {
        break label2114;
      }
    }
    label2114:
    for (paramInt = e.a.a.b.b.a.f(1, this.Id) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.jKs);
      paramInt = i;
      if (this.Desc != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.Desc);
      }
      i = paramInt;
      if (this.Url != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.Url);
      }
      i += e.a.a.b.b.a.bl(5, this.xrR);
      paramInt = i;
      if (this.xrS != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.xrS);
      }
      i = paramInt + e.a.a.b.b.a.bl(7, this.xrT) + e.a.a.b.b.a.bl(8, this.xrU);
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.Title);
      }
      i = paramInt;
      if (this.xrV != null) {
        i = paramInt + e.a.a.a.iP(10, this.xrV.computeSize());
      }
      paramInt = i;
      if (this.xrW != null) {
        paramInt = i + e.a.a.b.b.a.f(11, this.xrW);
      }
      i = paramInt + e.a.a.b.b.a.bl(12, this.xrX) + e.a.a.b.b.a.bl(13, this.cIp) + e.a.a.b.b.a.bl(14, this.xrY);
      paramInt = i;
      if (this.rGh != null) {
        paramInt = i + e.a.a.b.b.a.f(15, this.rGh);
      }
      i = paramInt + e.a.a.b.b.a.bl(16, this.subType);
      paramInt = i;
      if (this.cqq != null) {
        paramInt = i + e.a.a.b.b.a.f(17, this.cqq);
      }
      i = paramInt;
      if (this.xrZ != null) {
        i = paramInt + e.a.a.b.b.a.f(18, this.xrZ);
      }
      paramInt = i;
      if (this.xsa != null) {
        paramInt = i + e.a.a.b.b.a.f(19, this.xsa);
      }
      i = paramInt;
      if (this.xsb != null) {
        i = paramInt + e.a.a.b.b.a.f(20, this.xsb);
      }
      i += e.a.a.b.b.a.bl(21, this.sdf);
      paramInt = i;
      if (this.xsc != null) {
        paramInt = i + e.a.a.b.b.a.f(22, this.xsc);
      }
      i = paramInt;
      if (this.xsd != null) {
        i = paramInt + e.a.a.b.b.a.f(23, this.xsd);
      }
      i = i + e.a.a.b.b.a.bl(24, this.xse) + e.a.a.b.b.a.p(25, this.xsf);
      paramInt = i;
      if (this.xsg != null) {
        paramInt = i + e.a.a.b.b.a.f(26, this.xsg);
      }
      i = paramInt;
      if (this.xsh != null) {
        i = paramInt + e.a.a.b.b.a.f(27, this.xsh);
      }
      i += e.a.a.b.b.a.bl(28, this.xsi);
      paramInt = i;
      if (this.xsj != null) {
        paramInt = i + e.a.a.b.b.a.f(29, this.xsj);
      }
      i = paramInt;
      if (this.xsk != null) {
        i = paramInt + e.a.a.b.b.a.f(30, this.xsk);
      }
      i += e.a.a.b.b.a.bl(31, this.xsl);
      paramInt = i;
      if (this.xsm != null) {
        paramInt = i + e.a.a.b.b.a.f(32, this.xsm);
      }
      i = paramInt;
      if (this.xsn != null) {
        i = paramInt + e.a.a.b.b.a.f(33, this.xsn);
      }
      paramInt = e.a.a.b.b.a.eW(34);
      AppMethodBeat.o(94539);
      return i + (paramInt + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(94539);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bcs localbcs = (bcs)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(94539);
          return -1;
        case 1: 
          localbcs.Id = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94539);
          return 0;
        case 2: 
          localbcs.jKs = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94539);
          return 0;
        case 3: 
          localbcs.Desc = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94539);
          return 0;
        case 4: 
          localbcs.Url = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94539);
          return 0;
        case 5: 
          localbcs.xrR = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94539);
          return 0;
        case 6: 
          localbcs.xrS = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94539);
          return 0;
        case 7: 
          localbcs.xrT = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94539);
          return 0;
        case 8: 
          localbcs.xrU = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94539);
          return 0;
        case 9: 
          localbcs.Title = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94539);
          return 0;
        case 10: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bcu();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((bcu)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbcs.xrV = ((bcu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94539);
          return 0;
        case 11: 
          localbcs.xrW = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94539);
          return 0;
        case 12: 
          localbcs.xrX = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94539);
          return 0;
        case 13: 
          localbcs.cIp = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94539);
          return 0;
        case 14: 
          localbcs.xrY = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94539);
          return 0;
        case 15: 
          localbcs.rGh = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94539);
          return 0;
        case 16: 
          localbcs.subType = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94539);
          return 0;
        case 17: 
          localbcs.cqq = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94539);
          return 0;
        case 18: 
          localbcs.xrZ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94539);
          return 0;
        case 19: 
          localbcs.xsa = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94539);
          return 0;
        case 20: 
          localbcs.xsb = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94539);
          return 0;
        case 21: 
          localbcs.sdf = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94539);
          return 0;
        case 22: 
          localbcs.xsc = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94539);
          return 0;
        case 23: 
          localbcs.xsd = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94539);
          return 0;
        case 24: 
          localbcs.xse = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94539);
          return 0;
        case 25: 
          localbcs.xsf = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(94539);
          return 0;
        case 26: 
          localbcs.xsg = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94539);
          return 0;
        case 27: 
          localbcs.xsh = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94539);
          return 0;
        case 28: 
          localbcs.xsi = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94539);
          return 0;
        case 29: 
          localbcs.xsj = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94539);
          return 0;
        case 30: 
          localbcs.xsk = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94539);
          return 0;
        case 31: 
          localbcs.xsl = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94539);
          return 0;
        case 32: 
          localbcs.xsm = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94539);
          return 0;
        case 33: 
          localbcs.xsn = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94539);
          return 0;
        }
        localbcs.raZ = ((e.a.a.a.a)localObject1).CLY.emu();
        AppMethodBeat.o(94539);
        return 0;
      }
      AppMethodBeat.o(94539);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcs
 * JD-Core Version:    0.7.0.1
 */