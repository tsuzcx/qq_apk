package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class amo
  extends buy
{
  public int pIE;
  public long pIG;
  public int pIx;
  public int pIy;
  public int pIz;
  public bwc woP;
  public bwc woQ;
  public int xdn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80075);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.woP == null)
      {
        paramVarArgs = new b("Not all required fields were included: FromUserName");
        AppMethodBeat.o(80075);
        throw paramVarArgs;
      }
      if (this.woQ == null)
      {
        paramVarArgs = new b("Not all required fields were included: ToUserName");
        AppMethodBeat.o(80075);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.pIE);
      if (this.woP != null)
      {
        paramVarArgs.iQ(3, this.woP.computeSize());
        this.woP.writeFields(paramVarArgs);
      }
      if (this.woQ != null)
      {
        paramVarArgs.iQ(4, this.woQ.computeSize());
        this.woQ.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(5, this.pIx);
      paramVarArgs.aO(6, this.pIy);
      paramVarArgs.aO(7, this.pIz);
      paramVarArgs.aO(8, this.xdn);
      paramVarArgs.am(9, this.pIG);
      AppMethodBeat.o(80075);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label994;
      }
    }
    label994:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.pIE);
      paramInt = i;
      if (this.woP != null) {
        paramInt = i + e.a.a.a.iP(3, this.woP.computeSize());
      }
      i = paramInt;
      if (this.woQ != null) {
        i = paramInt + e.a.a.a.iP(4, this.woQ.computeSize());
      }
      paramInt = e.a.a.b.b.a.bl(5, this.pIx);
      int j = e.a.a.b.b.a.bl(6, this.pIy);
      int k = e.a.a.b.b.a.bl(7, this.pIz);
      int m = e.a.a.b.b.a.bl(8, this.xdn);
      int n = e.a.a.b.b.a.p(9, this.pIG);
      AppMethodBeat.o(80075);
      return i + paramInt + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.woP == null)
        {
          paramVarArgs = new b("Not all required fields were included: FromUserName");
          AppMethodBeat.o(80075);
          throw paramVarArgs;
        }
        if (this.woQ == null)
        {
          paramVarArgs = new b("Not all required fields were included: ToUserName");
          AppMethodBeat.o(80075);
          throw paramVarArgs;
        }
        AppMethodBeat.o(80075);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        amo localamo = (amo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(80075);
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
            localamo.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80075);
          return 0;
        case 2: 
          localamo.pIE = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80075);
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
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localamo.woP = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80075);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localamo.woQ = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80075);
          return 0;
        case 5: 
          localamo.pIx = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80075);
          return 0;
        case 6: 
          localamo.pIy = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80075);
          return 0;
        case 7: 
          localamo.pIz = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80075);
          return 0;
        case 8: 
          localamo.xdn = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80075);
          return 0;
        }
        localamo.pIG = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(80075);
        return 0;
      }
      AppMethodBeat.o(80075);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amo
 * JD-Core Version:    0.7.0.1
 */