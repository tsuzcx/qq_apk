package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cst
  extends bvk
{
  public int wQP;
  public long wQQ;
  public int wta;
  public LinkedList<crm> wtb;
  public int xCv;
  public int yaA;
  public int yaB;
  public int yaC;
  public int yaD;
  public int yaE;
  public csu yae;
  public int yaf;
  public int yag;
  public int yah;
  public int yai;
  public SKBuiltinBuffer_t yaj;
  public int yao;
  public LinkedList<csw> yap;
  public int yaq;
  public int yar;
  public int yas;
  public int yat;
  public int yau;
  public int yav;
  public int yax;
  public int yay;
  public int yaz;
  public int ybl;
  public int ybm;
  public int ybn;
  
  public cst()
  {
    AppMethodBeat.i(5251);
    this.wtb = new LinkedList();
    this.yap = new LinkedList();
    AppMethodBeat.o(5251);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(5252);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(5252);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.wQP);
      paramVarArgs.aO(3, this.wta);
      paramVarArgs.e(4, 8, this.wtb);
      paramVarArgs.am(5, this.wQQ);
      paramVarArgs.aO(6, this.xCv);
      if (this.yae != null)
      {
        paramVarArgs.iQ(7, this.yae.computeSize());
        this.yae.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(8, this.yao);
      paramVarArgs.e(9, 8, this.yap);
      paramVarArgs.aO(10, this.yaq);
      paramVarArgs.aO(11, this.yar);
      paramVarArgs.aO(12, this.yas);
      paramVarArgs.aO(13, this.yat);
      paramVarArgs.aO(14, this.ybl);
      paramVarArgs.aO(15, this.yau);
      paramVarArgs.aO(16, this.yav);
      paramVarArgs.aO(17, this.yaf);
      paramVarArgs.aO(18, this.yax);
      paramVarArgs.aO(19, this.yay);
      paramVarArgs.aO(20, this.yag);
      paramVarArgs.aO(21, this.yaz);
      paramVarArgs.aO(22, this.yaA);
      paramVarArgs.aO(23, this.yaB);
      paramVarArgs.aO(24, this.ybm);
      paramVarArgs.aO(25, this.yaC);
      paramVarArgs.aO(26, this.ybn);
      paramVarArgs.aO(27, this.yah);
      paramVarArgs.aO(28, this.yai);
      paramVarArgs.aO(29, this.yaD);
      paramVarArgs.aO(30, this.yaE);
      if (this.yaj != null)
      {
        paramVarArgs.iQ(31, this.yaj.computeSize());
        this.yaj.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(5252);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2131;
      }
    }
    label2131:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.wQP) + e.a.a.b.b.a.bl(3, this.wta) + e.a.a.a.c(4, 8, this.wtb) + e.a.a.b.b.a.p(5, this.wQQ) + e.a.a.b.b.a.bl(6, this.xCv);
      paramInt = i;
      if (this.yae != null) {
        paramInt = i + e.a.a.a.iP(7, this.yae.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(8, this.yao) + e.a.a.a.c(9, 8, this.yap) + e.a.a.b.b.a.bl(10, this.yaq) + e.a.a.b.b.a.bl(11, this.yar) + e.a.a.b.b.a.bl(12, this.yas) + e.a.a.b.b.a.bl(13, this.yat) + e.a.a.b.b.a.bl(14, this.ybl) + e.a.a.b.b.a.bl(15, this.yau) + e.a.a.b.b.a.bl(16, this.yav) + e.a.a.b.b.a.bl(17, this.yaf) + e.a.a.b.b.a.bl(18, this.yax) + e.a.a.b.b.a.bl(19, this.yay) + e.a.a.b.b.a.bl(20, this.yag) + e.a.a.b.b.a.bl(21, this.yaz) + e.a.a.b.b.a.bl(22, this.yaA) + e.a.a.b.b.a.bl(23, this.yaB) + e.a.a.b.b.a.bl(24, this.ybm) + e.a.a.b.b.a.bl(25, this.yaC) + e.a.a.b.b.a.bl(26, this.ybn) + e.a.a.b.b.a.bl(27, this.yah) + e.a.a.b.b.a.bl(28, this.yai) + e.a.a.b.b.a.bl(29, this.yaD) + e.a.a.b.b.a.bl(30, this.yaE);
      paramInt = i;
      if (this.yaj != null) {
        paramInt = i + e.a.a.a.iP(31, this.yaj.computeSize());
      }
      AppMethodBeat.o(5252);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wtb.clear();
        this.yap.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(5252);
          throw paramVarArgs;
        }
        AppMethodBeat.o(5252);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cst localcst = (cst)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(5252);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcst.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5252);
          return 0;
        case 2: 
          localcst.wQP = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5252);
          return 0;
        case 3: 
          localcst.wta = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5252);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcst.wtb.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5252);
          return 0;
        case 5: 
          localcst.wQQ = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(5252);
          return 0;
        case 6: 
          localcst.xCv = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5252);
          return 0;
        case 7: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new csu();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((csu)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcst.yae = ((csu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5252);
          return 0;
        case 8: 
          localcst.yao = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5252);
          return 0;
        case 9: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new csw();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((csw)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcst.yap.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5252);
          return 0;
        case 10: 
          localcst.yaq = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5252);
          return 0;
        case 11: 
          localcst.yar = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5252);
          return 0;
        case 12: 
          localcst.yas = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5252);
          return 0;
        case 13: 
          localcst.yat = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5252);
          return 0;
        case 14: 
          localcst.ybl = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5252);
          return 0;
        case 15: 
          localcst.yau = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5252);
          return 0;
        case 16: 
          localcst.yav = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5252);
          return 0;
        case 17: 
          localcst.yaf = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5252);
          return 0;
        case 18: 
          localcst.yax = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5252);
          return 0;
        case 19: 
          localcst.yay = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5252);
          return 0;
        case 20: 
          localcst.yag = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5252);
          return 0;
        case 21: 
          localcst.yaz = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5252);
          return 0;
        case 22: 
          localcst.yaA = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5252);
          return 0;
        case 23: 
          localcst.yaB = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5252);
          return 0;
        case 24: 
          localcst.ybm = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5252);
          return 0;
        case 25: 
          localcst.yaC = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5252);
          return 0;
        case 26: 
          localcst.ybn = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5252);
          return 0;
        case 27: 
          localcst.yah = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5252);
          return 0;
        case 28: 
          localcst.yai = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5252);
          return 0;
        case 29: 
          localcst.yaD = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5252);
          return 0;
        case 30: 
          localcst.yaE = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5252);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcst.yaj = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(5252);
        return 0;
      }
      AppMethodBeat.o(5252);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cst
 * JD-Core Version:    0.7.0.1
 */