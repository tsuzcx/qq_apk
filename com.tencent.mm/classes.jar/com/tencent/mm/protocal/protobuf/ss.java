package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ss
  extends buy
{
  public int jKs;
  public String wLg;
  public LinkedList<cca> wLh;
  public LinkedList<ccc> wLi;
  public LinkedList<cbz> wLj;
  public LinkedList<cby> wLk;
  public LinkedList<ccb> wLl;
  
  public ss()
  {
    AppMethodBeat.i(28359);
    this.wLh = new LinkedList();
    this.wLi = new LinkedList();
    this.wLj = new LinkedList();
    this.wLk = new LinkedList();
    this.wLl = new LinkedList();
    AppMethodBeat.o(28359);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28360);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.jKs);
      if (this.wLg != null) {
        paramVarArgs.e(3, this.wLg);
      }
      paramVarArgs.e(4, 8, this.wLh);
      paramVarArgs.e(5, 8, this.wLi);
      paramVarArgs.e(6, 8, this.wLj);
      paramVarArgs.e(7, 8, this.wLk);
      paramVarArgs.e(8, 8, this.wLl);
      AppMethodBeat.o(28360);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1140;
      }
    }
    label1140:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.jKs);
      paramInt = i;
      if (this.wLg != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.wLg);
      }
      i = e.a.a.a.c(4, 8, this.wLh);
      int j = e.a.a.a.c(5, 8, this.wLi);
      int k = e.a.a.a.c(6, 8, this.wLj);
      int m = e.a.a.a.c(7, 8, this.wLk);
      int n = e.a.a.a.c(8, 8, this.wLl);
      AppMethodBeat.o(28360);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wLh.clear();
        this.wLi.clear();
        this.wLj.clear();
        this.wLk.clear();
        this.wLl.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(28360);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        ss localss = (ss)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(28360);
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
            localss.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28360);
          return 0;
        case 2: 
          localss.jKs = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28360);
          return 0;
        case 3: 
          localss.wLg = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28360);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cca();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cca)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localss.wLh.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28360);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ccc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ccc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localss.wLi.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28360);
          return 0;
        case 6: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cbz();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cbz)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localss.wLj.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28360);
          return 0;
        case 7: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cby();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cby)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localss.wLk.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28360);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ccb();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ccb)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localss.wLl.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(28360);
        return 0;
      }
      AppMethodBeat.o(28360);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ss
 * JD-Core Version:    0.7.0.1
 */