package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class crp
  extends bvk
{
  public int wQP;
  public long wQQ;
  public int wta;
  public LinkedList<crm> wtb;
  public int yaA;
  public int yaB;
  public int yaC;
  public int yaD;
  public int yaE;
  public int yad;
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
  
  public crp()
  {
    AppMethodBeat.i(5231);
    this.wtb = new LinkedList();
    this.yap = new LinkedList();
    AppMethodBeat.o(5231);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(5232);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(5232);
        throw paramVarArgs;
      }
      if (this.yae == null)
      {
        paramVarArgs = new b("Not all required fields were included: RelayData");
        AppMethodBeat.o(5232);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.wta);
      paramVarArgs.e(3, 8, this.wtb);
      paramVarArgs.aO(4, this.wQP);
      paramVarArgs.am(5, this.wQQ);
      paramVarArgs.aO(6, this.yad);
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
      paramVarArgs.aO(14, this.yau);
      paramVarArgs.aO(15, this.yav);
      paramVarArgs.aO(16, this.yaf);
      paramVarArgs.aO(17, this.yax);
      paramVarArgs.aO(18, this.yay);
      paramVarArgs.aO(19, this.yag);
      paramVarArgs.aO(20, this.yaz);
      paramVarArgs.aO(21, this.yaA);
      paramVarArgs.aO(22, this.yaB);
      paramVarArgs.aO(23, this.yaC);
      paramVarArgs.aO(24, this.yah);
      paramVarArgs.aO(25, this.yai);
      paramVarArgs.aO(26, this.yaD);
      paramVarArgs.aO(27, this.yaE);
      if (this.yaj != null)
      {
        paramVarArgs.iQ(28, this.yaj.computeSize());
        this.yaj.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(5232);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label2044;
      }
    }
    label2044:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.wta) + e.a.a.a.c(3, 8, this.wtb) + e.a.a.b.b.a.bl(4, this.wQP) + e.a.a.b.b.a.p(5, this.wQQ) + e.a.a.b.b.a.bl(6, this.yad);
      paramInt = i;
      if (this.yae != null) {
        paramInt = i + e.a.a.a.iP(7, this.yae.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(8, this.yao) + e.a.a.a.c(9, 8, this.yap) + e.a.a.b.b.a.bl(10, this.yaq) + e.a.a.b.b.a.bl(11, this.yar) + e.a.a.b.b.a.bl(12, this.yas) + e.a.a.b.b.a.bl(13, this.yat) + e.a.a.b.b.a.bl(14, this.yau) + e.a.a.b.b.a.bl(15, this.yav) + e.a.a.b.b.a.bl(16, this.yaf) + e.a.a.b.b.a.bl(17, this.yax) + e.a.a.b.b.a.bl(18, this.yay) + e.a.a.b.b.a.bl(19, this.yag) + e.a.a.b.b.a.bl(20, this.yaz) + e.a.a.b.b.a.bl(21, this.yaA) + e.a.a.b.b.a.bl(22, this.yaB) + e.a.a.b.b.a.bl(23, this.yaC) + e.a.a.b.b.a.bl(24, this.yah) + e.a.a.b.b.a.bl(25, this.yai) + e.a.a.b.b.a.bl(26, this.yaD) + e.a.a.b.b.a.bl(27, this.yaE);
      paramInt = i;
      if (this.yaj != null) {
        paramInt = i + e.a.a.a.iP(28, this.yaj.computeSize());
      }
      AppMethodBeat.o(5232);
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
          AppMethodBeat.o(5232);
          throw paramVarArgs;
        }
        if (this.yae == null)
        {
          paramVarArgs = new b("Not all required fields were included: RelayData");
          AppMethodBeat.o(5232);
          throw paramVarArgs;
        }
        AppMethodBeat.o(5232);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        crp localcrp = (crp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(5232);
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
            localcrp.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5232);
          return 0;
        case 2: 
          localcrp.wta = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5232);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crm();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crm)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcrp.wtb.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5232);
          return 0;
        case 4: 
          localcrp.wQP = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5232);
          return 0;
        case 5: 
          localcrp.wQQ = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(5232);
          return 0;
        case 6: 
          localcrp.yad = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5232);
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
            localcrp.yae = ((csu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5232);
          return 0;
        case 8: 
          localcrp.yao = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5232);
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
            localcrp.yap.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5232);
          return 0;
        case 10: 
          localcrp.yaq = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5232);
          return 0;
        case 11: 
          localcrp.yar = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5232);
          return 0;
        case 12: 
          localcrp.yas = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5232);
          return 0;
        case 13: 
          localcrp.yat = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5232);
          return 0;
        case 14: 
          localcrp.yau = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5232);
          return 0;
        case 15: 
          localcrp.yav = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5232);
          return 0;
        case 16: 
          localcrp.yaf = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5232);
          return 0;
        case 17: 
          localcrp.yax = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5232);
          return 0;
        case 18: 
          localcrp.yay = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5232);
          return 0;
        case 19: 
          localcrp.yag = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5232);
          return 0;
        case 20: 
          localcrp.yaz = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5232);
          return 0;
        case 21: 
          localcrp.yaA = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5232);
          return 0;
        case 22: 
          localcrp.yaB = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5232);
          return 0;
        case 23: 
          localcrp.yaC = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5232);
          return 0;
        case 24: 
          localcrp.yah = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5232);
          return 0;
        case 25: 
          localcrp.yai = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5232);
          return 0;
        case 26: 
          localcrp.yaD = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5232);
          return 0;
        case 27: 
          localcrp.yaE = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5232);
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
          localcrp.yaj = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(5232);
        return 0;
      }
      AppMethodBeat.o(5232);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.crp
 * JD-Core Version:    0.7.0.1
 */