package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class asv
  extends bvk
{
  public String cyA;
  public int jAI;
  public String wBL;
  public czj wJX;
  public String xhO;
  public String xhQ;
  public int xhR;
  public LinkedList<bfs> xhS;
  public int xhT;
  public String xhU;
  public String xhV;
  public int xhW;
  public String xhX;
  public String xhY;
  public int xhZ;
  public int xia;
  public bfs xib;
  
  public asv()
  {
    AppMethodBeat.i(96238);
    this.xhS = new LinkedList();
    AppMethodBeat.o(96238);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96239);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(96239);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.wJX != null)
      {
        paramVarArgs.iQ(2, this.wJX.computeSize());
        this.wJX.writeFields(paramVarArgs);
      }
      if (this.xhQ != null) {
        paramVarArgs.e(3, this.xhQ);
      }
      paramVarArgs.aO(4, this.xhR);
      paramVarArgs.aO(5, this.jAI);
      if (this.xhO != null) {
        paramVarArgs.e(6, this.xhO);
      }
      paramVarArgs.e(7, 8, this.xhS);
      paramVarArgs.aO(8, this.xhT);
      if (this.xhU != null) {
        paramVarArgs.e(9, this.xhU);
      }
      if (this.xhV != null) {
        paramVarArgs.e(10, this.xhV);
      }
      paramVarArgs.aO(11, this.xhW);
      if (this.cyA != null) {
        paramVarArgs.e(12, this.cyA);
      }
      if (this.xhX != null) {
        paramVarArgs.e(13, this.xhX);
      }
      if (this.wBL != null) {
        paramVarArgs.e(14, this.wBL);
      }
      if (this.xhY != null) {
        paramVarArgs.e(15, this.xhY);
      }
      paramVarArgs.aO(16, this.xhZ);
      paramVarArgs.aO(17, this.xia);
      if (this.xib != null)
      {
        paramVarArgs.iQ(18, this.xib.computeSize());
        this.xib.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(96239);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1570;
      }
    }
    label1570:
    for (int i = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wJX != null) {
        paramInt = i + e.a.a.a.iP(2, this.wJX.computeSize());
      }
      i = paramInt;
      if (this.xhQ != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.xhQ);
      }
      i = i + e.a.a.b.b.a.bl(4, this.xhR) + e.a.a.b.b.a.bl(5, this.jAI);
      paramInt = i;
      if (this.xhO != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.xhO);
      }
      i = paramInt + e.a.a.a.c(7, 8, this.xhS) + e.a.a.b.b.a.bl(8, this.xhT);
      paramInt = i;
      if (this.xhU != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.xhU);
      }
      i = paramInt;
      if (this.xhV != null) {
        i = paramInt + e.a.a.b.b.a.f(10, this.xhV);
      }
      i += e.a.a.b.b.a.bl(11, this.xhW);
      paramInt = i;
      if (this.cyA != null) {
        paramInt = i + e.a.a.b.b.a.f(12, this.cyA);
      }
      i = paramInt;
      if (this.xhX != null) {
        i = paramInt + e.a.a.b.b.a.f(13, this.xhX);
      }
      paramInt = i;
      if (this.wBL != null) {
        paramInt = i + e.a.a.b.b.a.f(14, this.wBL);
      }
      i = paramInt;
      if (this.xhY != null) {
        i = paramInt + e.a.a.b.b.a.f(15, this.xhY);
      }
      i = i + e.a.a.b.b.a.bl(16, this.xhZ) + e.a.a.b.b.a.bl(17, this.xia);
      paramInt = i;
      if (this.xib != null) {
        paramInt = i + e.a.a.a.iP(18, this.xib.computeSize());
      }
      AppMethodBeat.o(96239);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xhS.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(96239);
          throw paramVarArgs;
        }
        AppMethodBeat.o(96239);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        asv localasv = (asv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(96239);
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
            localasv.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(96239);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new czj();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((czj)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localasv.wJX = ((czj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(96239);
          return 0;
        case 3: 
          localasv.xhQ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(96239);
          return 0;
        case 4: 
          localasv.xhR = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(96239);
          return 0;
        case 5: 
          localasv.jAI = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(96239);
          return 0;
        case 6: 
          localasv.xhO = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(96239);
          return 0;
        case 7: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bfs();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bfs)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localasv.xhS.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(96239);
          return 0;
        case 8: 
          localasv.xhT = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(96239);
          return 0;
        case 9: 
          localasv.xhU = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(96239);
          return 0;
        case 10: 
          localasv.xhV = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(96239);
          return 0;
        case 11: 
          localasv.xhW = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(96239);
          return 0;
        case 12: 
          localasv.cyA = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(96239);
          return 0;
        case 13: 
          localasv.xhX = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(96239);
          return 0;
        case 14: 
          localasv.wBL = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(96239);
          return 0;
        case 15: 
          localasv.xhY = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(96239);
          return 0;
        case 16: 
          localasv.xhZ = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(96239);
          return 0;
        case 17: 
          localasv.xia = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(96239);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bfs();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((bfs)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localasv.xib = ((bfs)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(96239);
        return 0;
      }
      AppMethodBeat.o(96239);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.asv
 * JD-Core Version:    0.7.0.1
 */