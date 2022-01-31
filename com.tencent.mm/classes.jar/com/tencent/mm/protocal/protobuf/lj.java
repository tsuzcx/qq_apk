package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class lj
  extends bvk
{
  public int wxV;
  public ka wzH;
  public kl wzI;
  public lg wzJ;
  public kn wzK;
  public lg wzL;
  public lt wzM;
  public LinkedList<aej> wzN;
  
  public lj()
  {
    AppMethodBeat.i(151377);
    this.wzN = new LinkedList();
    AppMethodBeat.o(151377);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(151378);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(151378);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.wzH != null)
      {
        paramVarArgs.iQ(2, this.wzH.computeSize());
        this.wzH.writeFields(paramVarArgs);
      }
      if (this.wzI != null)
      {
        paramVarArgs.iQ(3, this.wzI.computeSize());
        this.wzI.writeFields(paramVarArgs);
      }
      if (this.wzJ != null)
      {
        paramVarArgs.iQ(4, this.wzJ.computeSize());
        this.wzJ.writeFields(paramVarArgs);
      }
      if (this.wzK != null)
      {
        paramVarArgs.iQ(5, this.wzK.computeSize());
        this.wzK.writeFields(paramVarArgs);
      }
      if (this.wzL != null)
      {
        paramVarArgs.iQ(6, this.wzL.computeSize());
        this.wzL.writeFields(paramVarArgs);
      }
      if (this.wzM != null)
      {
        paramVarArgs.iQ(7, this.wzM.computeSize());
        this.wzM.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(8, this.wxV);
      paramVarArgs.e(9, 8, this.wzN);
      AppMethodBeat.o(151378);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1478;
      }
    }
    label1478:
    for (int i = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wzH != null) {
        paramInt = i + e.a.a.a.iP(2, this.wzH.computeSize());
      }
      i = paramInt;
      if (this.wzI != null) {
        i = paramInt + e.a.a.a.iP(3, this.wzI.computeSize());
      }
      paramInt = i;
      if (this.wzJ != null) {
        paramInt = i + e.a.a.a.iP(4, this.wzJ.computeSize());
      }
      i = paramInt;
      if (this.wzK != null) {
        i = paramInt + e.a.a.a.iP(5, this.wzK.computeSize());
      }
      paramInt = i;
      if (this.wzL != null) {
        paramInt = i + e.a.a.a.iP(6, this.wzL.computeSize());
      }
      i = paramInt;
      if (this.wzM != null) {
        i = paramInt + e.a.a.a.iP(7, this.wzM.computeSize());
      }
      paramInt = e.a.a.b.b.a.bl(8, this.wxV);
      int j = e.a.a.a.c(9, 8, this.wzN);
      AppMethodBeat.o(151378);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wzN.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(151378);
          throw paramVarArgs;
        }
        AppMethodBeat.o(151378);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        lj locallj = (lj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(151378);
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
            locallj.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(151378);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ka();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ka)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            locallj.wzH = ((ka)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(151378);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new kl();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((kl)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            locallj.wzI = ((kl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(151378);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new lg();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((lg)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            locallj.wzJ = ((lg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(151378);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new kn();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((kn)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            locallj.wzK = ((kn)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(151378);
          return 0;
        case 6: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new lg();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((lg)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            locallj.wzL = ((lg)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(151378);
          return 0;
        case 7: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new lt();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((lt)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            locallj.wzM = ((lt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(151378);
          return 0;
        case 8: 
          locallj.wxV = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(151378);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aej();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aej)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          locallj.wzN.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(151378);
        return 0;
      }
      AppMethodBeat.o(151378);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.lj
 * JD-Core Version:    0.7.0.1
 */