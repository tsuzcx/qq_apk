package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cyx
  extends com.tencent.mm.bv.a
{
  public String Md5;
  public String wxa;
  public String yew;
  public int yfN;
  public int yfO;
  public String yfT;
  public cyp yfU;
  public cyw yfV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(63702);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.yfT == null)
      {
        paramVarArgs = new b("Not all required fields were included: EntranceDomain");
        AppMethodBeat.o(63702);
        throw paramVarArgs;
      }
      if (this.yew == null)
      {
        paramVarArgs = new b("Not all required fields were included: Charset");
        AppMethodBeat.o(63702);
        throw paramVarArgs;
      }
      if (this.yfT != null) {
        paramVarArgs.e(4, this.yfT);
      }
      if (this.yew != null) {
        paramVarArgs.e(12, this.yew);
      }
      if (this.yfU != null)
      {
        paramVarArgs.iQ(9, this.yfU.computeSize());
        this.yfU.writeFields(paramVarArgs);
      }
      if (this.yfV != null)
      {
        paramVarArgs.iQ(10, this.yfV.computeSize());
        this.yfV.writeFields(paramVarArgs);
      }
      if (this.Md5 != null) {
        paramVarArgs.e(5, this.Md5);
      }
      if (this.wxa != null) {
        paramVarArgs.e(6, this.wxa);
      }
      paramVarArgs.aO(7, this.yfN);
      paramVarArgs.aO(8, this.yfO);
      AppMethodBeat.o(63702);
      return 0;
    }
    if (paramInt == 1) {
      if (this.yfT == null) {
        break label906;
      }
    }
    label906:
    for (int i = e.a.a.b.b.a.f(4, this.yfT) + 0;; i = 0)
    {
      paramInt = i;
      if (this.yew != null) {
        paramInt = i + e.a.a.b.b.a.f(12, this.yew);
      }
      i = paramInt;
      if (this.yfU != null) {
        i = paramInt + e.a.a.a.iP(9, this.yfU.computeSize());
      }
      paramInt = i;
      if (this.yfV != null) {
        paramInt = i + e.a.a.a.iP(10, this.yfV.computeSize());
      }
      i = paramInt;
      if (this.Md5 != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.Md5);
      }
      paramInt = i;
      if (this.wxa != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.wxa);
      }
      i = e.a.a.b.b.a.bl(7, this.yfN);
      int j = e.a.a.b.b.a.bl(8, this.yfO);
      AppMethodBeat.o(63702);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.yfT == null)
        {
          paramVarArgs = new b("Not all required fields were included: EntranceDomain");
          AppMethodBeat.o(63702);
          throw paramVarArgs;
        }
        if (this.yew == null)
        {
          paramVarArgs = new b("Not all required fields were included: Charset");
          AppMethodBeat.o(63702);
          throw paramVarArgs;
        }
        AppMethodBeat.o(63702);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cyx localcyx = (cyx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 11: 
        default: 
          AppMethodBeat.o(63702);
          return -1;
        case 4: 
          localcyx.yfT = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(63702);
          return 0;
        case 12: 
          localcyx.yew = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(63702);
          return 0;
        case 9: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cyp();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cyp)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcyx.yfU = ((cyp)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(63702);
          return 0;
        case 10: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cyw();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cyw)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcyx.yfV = ((cyw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(63702);
          return 0;
        case 5: 
          localcyx.Md5 = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(63702);
          return 0;
        case 6: 
          localcyx.wxa = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(63702);
          return 0;
        case 7: 
          localcyx.yfN = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(63702);
          return 0;
        }
        localcyx.yfO = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(63702);
        return 0;
      }
      AppMethodBeat.o(63702);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyx
 * JD-Core Version:    0.7.0.1
 */