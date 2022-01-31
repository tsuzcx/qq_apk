package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import java.util.LinkedList;

public final class ccz
  extends bvk
{
  public int xNA;
  public int xNB;
  public b xNC;
  public String xNn;
  public String xNo;
  public String xNp;
  public int xNz;
  public String xqX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124364);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.xNn != null) {
        paramVarArgs.e(2, this.xNn);
      }
      paramVarArgs.aO(3, this.xNz);
      paramVarArgs.aO(4, this.xNA);
      if (this.xNo != null) {
        paramVarArgs.e(5, this.xNo);
      }
      if (this.xNp != null) {
        paramVarArgs.e(6, this.xNp);
      }
      paramVarArgs.aO(7, this.xNB);
      if (this.xqX != null) {
        paramVarArgs.e(8, this.xqX);
      }
      if (this.xNC != null) {
        paramVarArgs.c(9, this.xNC);
      }
      AppMethodBeat.o(124364);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label750;
      }
    }
    label750:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xNn != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.xNn);
      }
      i = i + e.a.a.b.b.a.bl(3, this.xNz) + e.a.a.b.b.a.bl(4, this.xNA);
      paramInt = i;
      if (this.xNo != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.xNo);
      }
      i = paramInt;
      if (this.xNp != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.xNp);
      }
      i += e.a.a.b.b.a.bl(7, this.xNB);
      paramInt = i;
      if (this.xqX != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.xqX);
      }
      i = paramInt;
      if (this.xNC != null) {
        i = paramInt + e.a.a.b.b.a.b(9, this.xNC);
      }
      AppMethodBeat.o(124364);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(124364);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        ccz localccz = (ccz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124364);
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
            localccz.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124364);
          return 0;
        case 2: 
          localccz.xNn = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(124364);
          return 0;
        case 3: 
          localccz.xNz = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(124364);
          return 0;
        case 4: 
          localccz.xNA = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(124364);
          return 0;
        case 5: 
          localccz.xNo = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(124364);
          return 0;
        case 6: 
          localccz.xNp = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(124364);
          return 0;
        case 7: 
          localccz.xNB = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(124364);
          return 0;
        case 8: 
          localccz.xqX = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(124364);
          return 0;
        }
        localccz.xNC = ((e.a.a.a.a)localObject1).CLY.eqS();
        AppMethodBeat.o(124364);
        return 0;
      }
      AppMethodBeat.o(124364);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccz
 * JD-Core Version:    0.7.0.1
 */