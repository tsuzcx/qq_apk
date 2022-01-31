package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import java.util.LinkedList;

public final class ctg
  extends buy
{
  public int wLO;
  public int wQP;
  public int xQo;
  public int xQp;
  public int xQq;
  public int xQr;
  public int xQs;
  public LinkedList<Integer> xQt;
  public int xQu;
  public int xQv;
  public LinkedList<Integer> xQw;
  public int xQx;
  public int xQy;
  
  public ctg()
  {
    AppMethodBeat.i(5270);
    this.xQt = new LinkedList();
    this.xQw = new LinkedList();
    AppMethodBeat.o(5270);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(5271);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.wQP);
      paramVarArgs.aO(3, this.xQo);
      paramVarArgs.aO(4, this.wLO);
      paramVarArgs.aO(5, this.xQp);
      paramVarArgs.aO(6, this.xQq);
      paramVarArgs.aO(7, this.xQr);
      paramVarArgs.aO(8, this.xQs);
      paramVarArgs.f(9, 2, this.xQt);
      paramVarArgs.aO(10, this.xQu);
      paramVarArgs.aO(11, this.xQv);
      paramVarArgs.f(12, 2, this.xQw);
      paramVarArgs.aO(13, this.xQx);
      paramVarArgs.aO(14, this.xQy);
      AppMethodBeat.o(5271);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1004;
      }
    }
    label1004:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.bl(2, this.wQP);
      int j = e.a.a.b.b.a.bl(3, this.xQo);
      int k = e.a.a.b.b.a.bl(4, this.wLO);
      int m = e.a.a.b.b.a.bl(5, this.xQp);
      int n = e.a.a.b.b.a.bl(6, this.xQq);
      int i1 = e.a.a.b.b.a.bl(7, this.xQr);
      int i2 = e.a.a.b.b.a.bl(8, this.xQs);
      int i3 = e.a.a.a.d(9, 2, this.xQt);
      int i4 = e.a.a.b.b.a.bl(10, this.xQu);
      int i5 = e.a.a.b.b.a.bl(11, this.xQv);
      int i6 = e.a.a.a.d(12, 2, this.xQw);
      int i7 = e.a.a.b.b.a.bl(13, this.xQx);
      int i8 = e.a.a.b.b.a.bl(14, this.xQy);
      AppMethodBeat.o(5271);
      return paramInt + i + j + k + m + n + i1 + i2 + i3 + i4 + i5 + i6 + i7 + i8;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xQt.clear();
        this.xQw.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(5271);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        ctg localctg = (ctg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(5271);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((hq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localctg.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5271);
          return 0;
        case 2: 
          localctg.wQP = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5271);
          return 0;
        case 3: 
          localctg.xQo = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5271);
          return 0;
        case 4: 
          localctg.wLO = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5271);
          return 0;
        case 5: 
          localctg.xQp = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5271);
          return 0;
        case 6: 
          localctg.xQq = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5271);
          return 0;
        case 7: 
          localctg.xQr = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5271);
          return 0;
        case 8: 
          localctg.xQs = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5271);
          return 0;
        case 9: 
          localctg.xQt = new e.a.a.a.a(((e.a.a.a.a)localObject1).CLY.eqS().pW, unknownTagHandler).CLY.eqR();
          AppMethodBeat.o(5271);
          return 0;
        case 10: 
          localctg.xQu = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5271);
          return 0;
        case 11: 
          localctg.xQv = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5271);
          return 0;
        case 12: 
          localctg.xQw = new e.a.a.a.a(((e.a.a.a.a)localObject1).CLY.eqS().pW, unknownTagHandler).CLY.eqR();
          AppMethodBeat.o(5271);
          return 0;
        case 13: 
          localctg.xQx = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5271);
          return 0;
        }
        localctg.xQy = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(5271);
        return 0;
      }
      AppMethodBeat.o(5271);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ctg
 * JD-Core Version:    0.7.0.1
 */