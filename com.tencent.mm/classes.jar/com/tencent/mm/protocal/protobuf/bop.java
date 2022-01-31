package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bop
  extends bvk
{
  public int lGK;
  public String lGL;
  public int nNf;
  public String nNg;
  public int nNu;
  public int wQP;
  public long wQQ;
  public int xCH;
  public int xCJ;
  public int xCK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28594);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(28594);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(3, this.wQP);
      paramVarArgs.am(4, this.wQQ);
      paramVarArgs.aO(5, this.xCJ);
      paramVarArgs.aO(6, this.xCH);
      paramVarArgs.aO(7, this.nNu);
      paramVarArgs.aO(8, this.xCK);
      paramVarArgs.aO(9, this.lGK);
      if (this.lGL != null) {
        paramVarArgs.e(10, this.lGL);
      }
      paramVarArgs.aO(11, this.nNf);
      if (this.nNg != null) {
        paramVarArgs.e(12, this.nNg);
      }
      AppMethodBeat.o(28594);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label855;
      }
    }
    label855:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(3, this.wQP) + e.a.a.b.b.a.p(4, this.wQQ) + e.a.a.b.b.a.bl(5, this.xCJ) + e.a.a.b.b.a.bl(6, this.xCH) + e.a.a.b.b.a.bl(7, this.nNu) + e.a.a.b.b.a.bl(8, this.xCK) + e.a.a.b.b.a.bl(9, this.lGK);
      paramInt = i;
      if (this.lGL != null) {
        paramInt = i + e.a.a.b.b.a.f(10, this.lGL);
      }
      i = paramInt + e.a.a.b.b.a.bl(11, this.nNf);
      paramInt = i;
      if (this.nNg != null) {
        paramInt = i + e.a.a.b.b.a.f(12, this.nNg);
      }
      AppMethodBeat.o(28594);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(28594);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28594);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bop localbop = (bop)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 2: 
        default: 
          AppMethodBeat.o(28594);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbop.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28594);
          return 0;
        case 3: 
          localbop.wQP = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28594);
          return 0;
        case 4: 
          localbop.wQQ = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(28594);
          return 0;
        case 5: 
          localbop.xCJ = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28594);
          return 0;
        case 6: 
          localbop.xCH = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28594);
          return 0;
        case 7: 
          localbop.nNu = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28594);
          return 0;
        case 8: 
          localbop.xCK = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28594);
          return 0;
        case 9: 
          localbop.lGK = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28594);
          return 0;
        case 10: 
          localbop.lGL = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28594);
          return 0;
        case 11: 
          localbop.nNf = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28594);
          return 0;
        }
        localbop.nNg = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(28594);
        return 0;
      }
      AppMethodBeat.o(28594);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bop
 * JD-Core Version:    0.7.0.1
 */