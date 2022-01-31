package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class asf
  extends bvk
{
  public int CellCount;
  public LinkedList<cuw> CellList;
  public String xhg;
  public String xhi;
  public int xhj;
  public String xhk;
  public String xhl;
  public String xhm;
  
  public asf()
  {
    AppMethodBeat.i(28505);
    this.CellList = new LinkedList();
    AppMethodBeat.o(28505);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28506);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(28506);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.CellCount);
      paramVarArgs.e(3, 8, this.CellList);
      if (this.xhi != null) {
        paramVarArgs.e(4, this.xhi);
      }
      if (this.xhg != null) {
        paramVarArgs.e(5, this.xhg);
      }
      paramVarArgs.aO(6, this.xhj);
      if (this.xhk != null) {
        paramVarArgs.e(7, this.xhk);
      }
      if (this.xhl != null) {
        paramVarArgs.e(8, this.xhl);
      }
      if (this.xhm != null) {
        paramVarArgs.e(9, this.xhm);
      }
      AppMethodBeat.o(28506);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label909;
      }
    }
    label909:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.CellCount) + e.a.a.a.c(3, 8, this.CellList);
      paramInt = i;
      if (this.xhi != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.xhi);
      }
      i = paramInt;
      if (this.xhg != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.xhg);
      }
      i += e.a.a.b.b.a.bl(6, this.xhj);
      paramInt = i;
      if (this.xhk != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.xhk);
      }
      i = paramInt;
      if (this.xhl != null) {
        i = paramInt + e.a.a.b.b.a.f(8, this.xhl);
      }
      paramInt = i;
      if (this.xhm != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.xhm);
      }
      AppMethodBeat.o(28506);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CellList.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(28506);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28506);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        asf localasf = (asf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(28506);
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
            localasf.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28506);
          return 0;
        case 2: 
          localasf.CellCount = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28506);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cuw();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cuw)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localasf.CellList.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28506);
          return 0;
        case 4: 
          localasf.xhi = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28506);
          return 0;
        case 5: 
          localasf.xhg = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28506);
          return 0;
        case 6: 
          localasf.xhj = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28506);
          return 0;
        case 7: 
          localasf.xhk = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28506);
          return 0;
        case 8: 
          localasf.xhl = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28506);
          return 0;
        }
        localasf.xhm = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(28506);
        return 0;
      }
      AppMethodBeat.o(28506);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.asf
 * JD-Core Version:    0.7.0.1
 */