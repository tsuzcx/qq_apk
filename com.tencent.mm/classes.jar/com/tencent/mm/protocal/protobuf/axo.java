package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import java.util.LinkedList;

public final class axo
  extends buy
{
  public String cqf;
  public String cwc;
  public String signature;
  public String url;
  public String xmo;
  public String xmq;
  public String xmr;
  public b xms;
  public int xmt;
  public LinkedList<ayc> xmx;
  
  public axo()
  {
    AppMethodBeat.i(10209);
    this.xmx = new LinkedList();
    AppMethodBeat.o(10209);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(10210);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.url != null) {
        paramVarArgs.e(2, this.url);
      }
      if (this.cwc != null) {
        paramVarArgs.e(3, this.cwc);
      }
      if (this.xmo != null) {
        paramVarArgs.e(4, this.xmo);
      }
      if (this.cqf != null) {
        paramVarArgs.e(5, this.cqf);
      }
      if (this.xmq != null) {
        paramVarArgs.e(6, this.xmq);
      }
      if (this.signature != null) {
        paramVarArgs.e(7, this.signature);
      }
      if (this.xmr != null) {
        paramVarArgs.e(8, this.xmr);
      }
      if (this.xms != null) {
        paramVarArgs.c(9, this.xms);
      }
      paramVarArgs.aO(10, this.xmt);
      paramVarArgs.e(11, 8, this.xmx);
      AppMethodBeat.o(10210);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1007;
      }
    }
    label1007:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.url != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.url);
      }
      i = paramInt;
      if (this.cwc != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.cwc);
      }
      paramInt = i;
      if (this.xmo != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.xmo);
      }
      i = paramInt;
      if (this.cqf != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.cqf);
      }
      paramInt = i;
      if (this.xmq != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.xmq);
      }
      i = paramInt;
      if (this.signature != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.signature);
      }
      paramInt = i;
      if (this.xmr != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.xmr);
      }
      i = paramInt;
      if (this.xms != null) {
        i = paramInt + e.a.a.b.b.a.b(9, this.xms);
      }
      paramInt = e.a.a.b.b.a.bl(10, this.xmt);
      int j = e.a.a.a.c(11, 8, this.xmx);
      AppMethodBeat.o(10210);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xmx.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(10210);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        axo localaxo = (axo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(10210);
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
            localaxo.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(10210);
          return 0;
        case 2: 
          localaxo.url = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(10210);
          return 0;
        case 3: 
          localaxo.cwc = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(10210);
          return 0;
        case 4: 
          localaxo.xmo = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(10210);
          return 0;
        case 5: 
          localaxo.cqf = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(10210);
          return 0;
        case 6: 
          localaxo.xmq = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(10210);
          return 0;
        case 7: 
          localaxo.signature = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(10210);
          return 0;
        case 8: 
          localaxo.xmr = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(10210);
          return 0;
        case 9: 
          localaxo.xms = ((e.a.a.a.a)localObject1).CLY.eqS();
          AppMethodBeat.o(10210);
          return 0;
        case 10: 
          localaxo.xmt = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(10210);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ayc();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ayc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localaxo.xmx.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(10210);
        return 0;
      }
      AppMethodBeat.o(10210);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.axo
 * JD-Core Version:    0.7.0.1
 */