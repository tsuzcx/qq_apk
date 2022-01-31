package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cff
  extends bvk
{
  public LinkedList<SnsObject> wuP;
  public SKBuiltinBuffer_t xNO;
  public String xOk;
  public int xOo;
  public int xOp;
  public ceu xOq;
  public int xPA;
  public LinkedList<cy> xPB;
  public int xPC;
  public LinkedList<bsc> xPD;
  public int xPE;
  public LinkedList<wj> xPF;
  public int xPz;
  public int xtO;
  
  public cff()
  {
    AppMethodBeat.i(94618);
    this.wuP = new LinkedList();
    this.xPB = new LinkedList();
    this.xPD = new LinkedList();
    this.xPF = new LinkedList();
    AppMethodBeat.o(94618);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94619);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(94619);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.xOk != null) {
        paramVarArgs.e(2, this.xOk);
      }
      paramVarArgs.aO(3, this.xtO);
      paramVarArgs.e(4, 8, this.wuP);
      paramVarArgs.aO(5, this.xPz);
      paramVarArgs.aO(6, this.xOo);
      paramVarArgs.aO(7, this.xOp);
      if (this.xOq != null)
      {
        paramVarArgs.iQ(8, this.xOq.computeSize());
        this.xOq.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(9, this.xPA);
      paramVarArgs.e(10, 8, this.xPB);
      if (this.xNO != null)
      {
        paramVarArgs.iQ(11, this.xNO.computeSize());
        this.xNO.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(12, this.xPC);
      paramVarArgs.e(13, 8, this.xPD);
      paramVarArgs.aO(14, this.xPE);
      paramVarArgs.e(15, 8, this.xPF);
      AppMethodBeat.o(94619);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1610;
      }
    }
    label1610:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xOk != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.xOk);
      }
      i = i + e.a.a.b.b.a.bl(3, this.xtO) + e.a.a.a.c(4, 8, this.wuP) + e.a.a.b.b.a.bl(5, this.xPz) + e.a.a.b.b.a.bl(6, this.xOo) + e.a.a.b.b.a.bl(7, this.xOp);
      paramInt = i;
      if (this.xOq != null) {
        paramInt = i + e.a.a.a.iP(8, this.xOq.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(9, this.xPA) + e.a.a.a.c(10, 8, this.xPB);
      paramInt = i;
      if (this.xNO != null) {
        paramInt = i + e.a.a.a.iP(11, this.xNO.computeSize());
      }
      i = e.a.a.b.b.a.bl(12, this.xPC);
      int j = e.a.a.a.c(13, 8, this.xPD);
      int k = e.a.a.b.b.a.bl(14, this.xPE);
      int m = e.a.a.a.c(15, 8, this.xPF);
      AppMethodBeat.o(94619);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wuP.clear();
        this.xPB.clear();
        this.xPD.clear();
        this.xPF.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(94619);
          throw paramVarArgs;
        }
        AppMethodBeat.o(94619);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cff localcff = (cff)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(94619);
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
            localcff.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94619);
          return 0;
        case 2: 
          localcff.xOk = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94619);
          return 0;
        case 3: 
          localcff.xtO = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94619);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SnsObject();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SnsObject)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcff.wuP.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94619);
          return 0;
        case 5: 
          localcff.xPz = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94619);
          return 0;
        case 6: 
          localcff.xOo = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94619);
          return 0;
        case 7: 
          localcff.xOp = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94619);
          return 0;
        case 8: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ceu();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ceu)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcff.xOq = ((ceu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94619);
          return 0;
        case 9: 
          localcff.xPA = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94619);
          return 0;
        case 10: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cy();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cy)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcff.xPB.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94619);
          return 0;
        case 11: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcff.xNO = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94619);
          return 0;
        case 12: 
          localcff.xPC = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94619);
          return 0;
        case 13: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bsc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bsc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcff.xPD.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94619);
          return 0;
        case 14: 
          localcff.xPE = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94619);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new wj();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((wj)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localcff.xPF.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(94619);
        return 0;
      }
      AppMethodBeat.o(94619);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cff
 * JD-Core Version:    0.7.0.1
 */