package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class buk
  extends buy
{
  public long bqN;
  public LinkedList<aam> xHC;
  public int xHD;
  public int xHE;
  public LinkedList<tr> xHF;
  public int xHG;
  public ts xfd;
  
  public buk()
  {
    AppMethodBeat.i(134443);
    this.xHC = new LinkedList();
    this.xHF = new LinkedList();
    AppMethodBeat.o(134443);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(134444);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.am(2, this.bqN);
      paramVarArgs.e(3, 8, this.xHC);
      paramVarArgs.aO(5, this.xHD);
      paramVarArgs.aO(6, this.xHE);
      if (this.xfd != null)
      {
        paramVarArgs.iQ(7, this.xfd.computeSize());
        this.xfd.writeFields(paramVarArgs);
      }
      paramVarArgs.e(8, 8, this.xHF);
      paramVarArgs.aO(9, this.xHG);
      AppMethodBeat.o(134444);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label930;
      }
    }
    label930:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.p(2, this.bqN) + e.a.a.a.c(3, 8, this.xHC) + e.a.a.b.b.a.bl(5, this.xHD) + e.a.a.b.b.a.bl(6, this.xHE);
      paramInt = i;
      if (this.xfd != null) {
        paramInt = i + e.a.a.a.iP(7, this.xfd.computeSize());
      }
      i = e.a.a.a.c(8, 8, this.xHF);
      int j = e.a.a.b.b.a.bl(9, this.xHG);
      AppMethodBeat.o(134444);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xHC.clear();
        this.xHF.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(134444);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        buk localbuk = (buk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 4: 
        default: 
          AppMethodBeat.o(134444);
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
            localbuk.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134444);
          return 0;
        case 2: 
          localbuk.bqN = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(134444);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aam();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aam)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbuk.xHC.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134444);
          return 0;
        case 5: 
          localbuk.xHD = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(134444);
          return 0;
        case 6: 
          localbuk.xHE = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(134444);
          return 0;
        case 7: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ts();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ts)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbuk.xfd = ((ts)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134444);
          return 0;
        case 8: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new tr();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((tr)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbuk.xHF.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(134444);
          return 0;
        }
        localbuk.xHG = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(134444);
        return 0;
      }
      AppMethodBeat.o(134444);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.buk
 * JD-Core Version:    0.7.0.1
 */