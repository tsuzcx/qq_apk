package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class th
  extends buy
{
  public int Scene;
  public String nul;
  public String num;
  public int pIE;
  public long pIG;
  public int pIx;
  public String wAs;
  public crd wLH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28362);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.wAs != null) {
        paramVarArgs.e(2, this.wAs);
      }
      paramVarArgs.aO(3, this.pIx);
      paramVarArgs.aO(4, this.pIE);
      if (this.wLH != null)
      {
        paramVarArgs.iQ(5, this.wLH.computeSize());
        this.wLH.writeFields(paramVarArgs);
      }
      paramVarArgs.am(6, this.pIG);
      paramVarArgs.aO(7, this.Scene);
      if (this.num != null) {
        paramVarArgs.e(8, this.num);
      }
      if (this.nul != null) {
        paramVarArgs.e(9, this.nul);
      }
      AppMethodBeat.o(28362);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label841;
      }
    }
    label841:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wAs != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.wAs);
      }
      i = i + e.a.a.b.b.a.bl(3, this.pIx) + e.a.a.b.b.a.bl(4, this.pIE);
      paramInt = i;
      if (this.wLH != null) {
        paramInt = i + e.a.a.a.iP(5, this.wLH.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.p(6, this.pIG) + e.a.a.b.b.a.bl(7, this.Scene);
      paramInt = i;
      if (this.num != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.num);
      }
      i = paramInt;
      if (this.nul != null) {
        i = paramInt + e.a.a.b.b.a.f(9, this.nul);
      }
      AppMethodBeat.o(28362);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(28362);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        th localth = (th)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(28362);
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
            localth.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28362);
          return 0;
        case 2: 
          localth.wAs = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28362);
          return 0;
        case 3: 
          localth.pIx = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28362);
          return 0;
        case 4: 
          localth.pIE = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28362);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new crd();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((crd)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localth.wLH = ((crd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28362);
          return 0;
        case 6: 
          localth.pIG = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(28362);
          return 0;
        case 7: 
          localth.Scene = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28362);
          return 0;
        case 8: 
          localth.num = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28362);
          return 0;
        }
        localth.nul = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(28362);
        return 0;
      }
      AppMethodBeat.o(28362);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.th
 * JD-Core Version:    0.7.0.1
 */