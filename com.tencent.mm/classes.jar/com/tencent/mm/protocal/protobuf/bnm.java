package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bnm
  extends bvk
{
  public String wDF;
  public int wuD;
  public String wuE;
  public LinkedList<aan> xBH;
  public LinkedList<au> xBI;
  public int xBJ;
  public int xct;
  
  public bnm()
  {
    AppMethodBeat.i(56929);
    this.xBH = new LinkedList();
    this.xBI = new LinkedList();
    AppMethodBeat.o(56929);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56930);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.xct);
      paramVarArgs.e(3, 8, this.xBH);
      if (this.wDF != null) {
        paramVarArgs.e(4, this.wDF);
      }
      paramVarArgs.aO(5, this.wuD);
      if (this.wuE != null) {
        paramVarArgs.e(6, this.wuE);
      }
      paramVarArgs.e(7, 8, this.xBI);
      paramVarArgs.aO(8, this.xBJ);
      AppMethodBeat.o(56930);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label850;
      }
    }
    label850:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.xct) + e.a.a.a.c(3, 8, this.xBH);
      paramInt = i;
      if (this.wDF != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wDF);
      }
      i = paramInt + e.a.a.b.b.a.bl(5, this.wuD);
      paramInt = i;
      if (this.wuE != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.wuE);
      }
      i = e.a.a.a.c(7, 8, this.xBI);
      int j = e.a.a.b.b.a.bl(8, this.xBJ);
      AppMethodBeat.o(56930);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xBH.clear();
        this.xBI.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56930);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bnm localbnm = (bnm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56930);
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
            localbnm.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56930);
          return 0;
        case 2: 
          localbnm.xct = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56930);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aan();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aan)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbnm.xBH.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56930);
          return 0;
        case 4: 
          localbnm.wDF = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56930);
          return 0;
        case 5: 
          localbnm.wuD = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56930);
          return 0;
        case 6: 
          localbnm.wuE = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56930);
          return 0;
        case 7: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new au();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((au)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbnm.xBI.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56930);
          return 0;
        }
        localbnm.xBJ = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(56930);
        return 0;
      }
      AppMethodBeat.o(56930);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bnm
 * JD-Core Version:    0.7.0.1
 */