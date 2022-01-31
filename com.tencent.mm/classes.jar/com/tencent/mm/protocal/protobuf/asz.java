package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class asz
  extends bvk
{
  public czj wJX;
  public int xhZ;
  public LinkedList<dap> xig;
  public dap xih;
  public String xii;
  public int xij;
  public String xik;
  public String xil;
  public String xim;
  public String xin;
  
  public asz()
  {
    AppMethodBeat.i(96244);
    this.xig = new LinkedList();
    AppMethodBeat.o(96244);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96245);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(96245);
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
      paramVarArgs.e(3, 8, this.xig);
      if (this.xih != null)
      {
        paramVarArgs.iQ(4, this.xih.computeSize());
        this.xih.writeFields(paramVarArgs);
      }
      if (this.xii != null) {
        paramVarArgs.e(5, this.xii);
      }
      paramVarArgs.aO(6, this.xij);
      if (this.xik != null) {
        paramVarArgs.e(7, this.xik);
      }
      if (this.xil != null) {
        paramVarArgs.e(8, this.xil);
      }
      if (this.xim != null) {
        paramVarArgs.e(9, this.xim);
      }
      if (this.xin != null) {
        paramVarArgs.e(10, this.xin);
      }
      paramVarArgs.aO(11, this.xhZ);
      AppMethodBeat.o(96245);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1206;
      }
    }
    label1206:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wJX != null) {
        i = paramInt + e.a.a.a.iP(2, this.wJX.computeSize());
      }
      i += e.a.a.a.c(3, 8, this.xig);
      paramInt = i;
      if (this.xih != null) {
        paramInt = i + e.a.a.a.iP(4, this.xih.computeSize());
      }
      i = paramInt;
      if (this.xii != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.xii);
      }
      i += e.a.a.b.b.a.bl(6, this.xij);
      paramInt = i;
      if (this.xik != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.xik);
      }
      i = paramInt;
      if (this.xil != null) {
        i = paramInt + e.a.a.b.b.a.f(8, this.xil);
      }
      paramInt = i;
      if (this.xim != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.xim);
      }
      i = paramInt;
      if (this.xin != null) {
        i = paramInt + e.a.a.b.b.a.f(10, this.xin);
      }
      paramInt = e.a.a.b.b.a.bl(11, this.xhZ);
      AppMethodBeat.o(96245);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xig.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(96245);
          throw paramVarArgs;
        }
        AppMethodBeat.o(96245);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        asz localasz = (asz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(96245);
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
            localasz.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(96245);
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
            localasz.wJX = ((czj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(96245);
          return 0;
        case 3: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dap();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dap)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localasz.xig.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(96245);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dap();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dap)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localasz.xih = ((dap)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(96245);
          return 0;
        case 5: 
          localasz.xii = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(96245);
          return 0;
        case 6: 
          localasz.xij = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(96245);
          return 0;
        case 7: 
          localasz.xik = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(96245);
          return 0;
        case 8: 
          localasz.xil = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(96245);
          return 0;
        case 9: 
          localasz.xim = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(96245);
          return 0;
        case 10: 
          localasz.xin = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(96245);
          return 0;
        }
        localasz.xhZ = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(96245);
        return 0;
      }
      AppMethodBeat.o(96245);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.asz
 * JD-Core Version:    0.7.0.1
 */