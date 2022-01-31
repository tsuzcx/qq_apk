package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class ast
  extends bvk
{
  public String cyc;
  public int ret;
  public String url;
  public int xaJ;
  public bkc xhJ;
  public LinkedList<bfd> xhK;
  public String xhL;
  
  public ast()
  {
    AppMethodBeat.i(96235);
    this.xhK = new LinkedList();
    AppMethodBeat.o(96235);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96236);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(96236);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.ret);
      if (this.url != null) {
        paramVarArgs.e(3, this.url);
      }
      paramVarArgs.aO(4, this.xaJ);
      if (this.cyc != null) {
        paramVarArgs.e(5, this.cyc);
      }
      if (this.xhJ != null)
      {
        paramVarArgs.iQ(6, this.xhJ.computeSize());
        this.xhJ.writeFields(paramVarArgs);
      }
      paramVarArgs.e(7, 8, this.xhK);
      if (this.xhL != null) {
        paramVarArgs.e(8, this.xhL);
      }
      AppMethodBeat.o(96236);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label926;
      }
    }
    label926:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.ret);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.url);
      }
      i = paramInt + e.a.a.b.b.a.bl(4, this.xaJ);
      paramInt = i;
      if (this.cyc != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.cyc);
      }
      i = paramInt;
      if (this.xhJ != null) {
        i = paramInt + e.a.a.a.iP(6, this.xhJ.computeSize());
      }
      i += e.a.a.a.c(7, 8, this.xhK);
      paramInt = i;
      if (this.xhL != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.xhL);
      }
      AppMethodBeat.o(96236);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xhK.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(96236);
          throw paramVarArgs;
        }
        AppMethodBeat.o(96236);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        ast localast = (ast)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(96236);
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
            localast.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(96236);
          return 0;
        case 2: 
          localast.ret = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(96236);
          return 0;
        case 3: 
          localast.url = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(96236);
          return 0;
        case 4: 
          localast.xaJ = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(96236);
          return 0;
        case 5: 
          localast.cyc = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(96236);
          return 0;
        case 6: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bkc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bkc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localast.xhJ = ((bkc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(96236);
          return 0;
        case 7: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bfd();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bfd)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localast.xhK.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(96236);
          return 0;
        }
        localast.xhL = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(96236);
        return 0;
      }
      AppMethodBeat.o(96236);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ast
 * JD-Core Version:    0.7.0.1
 */