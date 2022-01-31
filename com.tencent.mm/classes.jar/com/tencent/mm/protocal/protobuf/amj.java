package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class amj
  extends bvk
{
  public int kWh;
  public int koj;
  public String kok;
  public int xcZ;
  public op xda;
  public os xdb;
  public oo xdc;
  public String xdd;
  public int xde;
  public int xdf;
  public pd xdg;
  public or xdh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(89096);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(89096);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.koj);
      if (this.kok != null) {
        paramVarArgs.e(3, this.kok);
      }
      paramVarArgs.aO(4, this.kWh);
      paramVarArgs.aO(5, this.xcZ);
      if (this.xda != null)
      {
        paramVarArgs.iQ(6, this.xda.computeSize());
        this.xda.writeFields(paramVarArgs);
      }
      if (this.xdb != null)
      {
        paramVarArgs.iQ(7, this.xdb.computeSize());
        this.xdb.writeFields(paramVarArgs);
      }
      if (this.xdc != null)
      {
        paramVarArgs.iQ(8, this.xdc.computeSize());
        this.xdc.writeFields(paramVarArgs);
      }
      if (this.xdd != null) {
        paramVarArgs.e(10, this.xdd);
      }
      paramVarArgs.aO(11, this.xde);
      paramVarArgs.aO(12, this.xdf);
      if (this.xdg != null)
      {
        paramVarArgs.iQ(13, this.xdg.computeSize());
        this.xdg.writeFields(paramVarArgs);
      }
      if (this.xdh != null)
      {
        paramVarArgs.iQ(14, this.xdh.computeSize());
        this.xdh.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(89096);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1486;
      }
    }
    label1486:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.koj);
      paramInt = i;
      if (this.kok != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.kok);
      }
      i = paramInt + e.a.a.b.b.a.bl(4, this.kWh) + e.a.a.b.b.a.bl(5, this.xcZ);
      paramInt = i;
      if (this.xda != null) {
        paramInt = i + e.a.a.a.iP(6, this.xda.computeSize());
      }
      i = paramInt;
      if (this.xdb != null) {
        i = paramInt + e.a.a.a.iP(7, this.xdb.computeSize());
      }
      paramInt = i;
      if (this.xdc != null) {
        paramInt = i + e.a.a.a.iP(8, this.xdc.computeSize());
      }
      i = paramInt;
      if (this.xdd != null) {
        i = paramInt + e.a.a.b.b.a.f(10, this.xdd);
      }
      i = i + e.a.a.b.b.a.bl(11, this.xde) + e.a.a.b.b.a.bl(12, this.xdf);
      paramInt = i;
      if (this.xdg != null) {
        paramInt = i + e.a.a.a.iP(13, this.xdg.computeSize());
      }
      i = paramInt;
      if (this.xdh != null) {
        i = paramInt + e.a.a.a.iP(14, this.xdh.computeSize());
      }
      AppMethodBeat.o(89096);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(89096);
          throw paramVarArgs;
        }
        AppMethodBeat.o(89096);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        amj localamj = (amj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        case 9: 
        default: 
          AppMethodBeat.o(89096);
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
            localamj.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(89096);
          return 0;
        case 2: 
          localamj.koj = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(89096);
          return 0;
        case 3: 
          localamj.kok = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89096);
          return 0;
        case 4: 
          localamj.kWh = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(89096);
          return 0;
        case 5: 
          localamj.xcZ = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(89096);
          return 0;
        case 6: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new op();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((op)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localamj.xda = ((op)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(89096);
          return 0;
        case 7: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new os();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((os)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localamj.xdb = ((os)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(89096);
          return 0;
        case 8: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new oo();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((oo)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localamj.xdc = ((oo)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(89096);
          return 0;
        case 10: 
          localamj.xdd = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(89096);
          return 0;
        case 11: 
          localamj.xde = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(89096);
          return 0;
        case 12: 
          localamj.xdf = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(89096);
          return 0;
        case 13: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new pd();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((pd)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localamj.xdg = ((pd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(89096);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new or();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((or)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localamj.xdh = ((or)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(89096);
        return 0;
      }
      AppMethodBeat.o(89096);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amj
 * JD-Core Version:    0.7.0.1
 */