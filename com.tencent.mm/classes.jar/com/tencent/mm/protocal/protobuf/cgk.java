package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cgk
  extends buy
{
  public String nul;
  public String num;
  public String wpS;
  public int xRf;
  public int xRg;
  public LinkedList<cgm> xRh;
  public cgj xRi;
  public int xRj;
  public LinkedList<cgj> xRk;
  
  public cgk()
  {
    AppMethodBeat.i(80191);
    this.xRh = new LinkedList();
    this.xRk = new LinkedList();
    AppMethodBeat.o(80191);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(80192);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.xRf);
      if (this.num != null) {
        paramVarArgs.e(3, this.num);
      }
      if (this.nul != null) {
        paramVarArgs.e(4, this.nul);
      }
      if (this.wpS != null) {
        paramVarArgs.e(5, this.wpS);
      }
      paramVarArgs.aO(6, this.xRg);
      paramVarArgs.e(7, 8, this.xRh);
      if (this.xRi != null)
      {
        paramVarArgs.iQ(8, this.xRi.computeSize());
        this.xRi.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(9, this.xRj);
      paramVarArgs.e(10, 8, this.xRk);
      AppMethodBeat.o(80192);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1066;
      }
    }
    label1066:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.xRf);
      paramInt = i;
      if (this.num != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.num);
      }
      i = paramInt;
      if (this.nul != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.nul);
      }
      paramInt = i;
      if (this.wpS != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.wpS);
      }
      i = paramInt + e.a.a.b.b.a.bl(6, this.xRg) + e.a.a.a.c(7, 8, this.xRh);
      paramInt = i;
      if (this.xRi != null) {
        paramInt = i + e.a.a.a.iP(8, this.xRi.computeSize());
      }
      i = e.a.a.b.b.a.bl(9, this.xRj);
      int j = e.a.a.a.c(10, 8, this.xRk);
      AppMethodBeat.o(80192);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xRh.clear();
        this.xRk.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(80192);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cgk localcgk = (cgk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(80192);
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
            localcgk.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80192);
          return 0;
        case 2: 
          localcgk.xRf = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80192);
          return 0;
        case 3: 
          localcgk.num = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80192);
          return 0;
        case 4: 
          localcgk.nul = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80192);
          return 0;
        case 5: 
          localcgk.wpS = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(80192);
          return 0;
        case 6: 
          localcgk.xRg = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80192);
          return 0;
        case 7: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cgm();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cgm)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcgk.xRh.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80192);
          return 0;
        case 8: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cgj();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cgj)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcgk.xRi = ((cgj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(80192);
          return 0;
        case 9: 
          localcgk.xRj = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(80192);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cgj();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cgj)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcgk.xRk.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(80192);
        return 0;
      }
      AppMethodBeat.o(80192);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgk
 * JD-Core Version:    0.7.0.1
 */