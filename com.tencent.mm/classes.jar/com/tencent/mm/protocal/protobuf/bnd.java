package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class bnd
  extends bvk
{
  public int koj;
  public String kok;
  public LinkedList<po> wZn;
  public int wpg;
  public awi xBo;
  public bnx xBp;
  public String xBq;
  public int xBr;
  public long xBs;
  public String xpZ;
  public boolean xqa;
  
  public bnd()
  {
    AppMethodBeat.i(56923);
    this.wZn = new LinkedList();
    this.xqa = true;
    AppMethodBeat.o(56923);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56924);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(56924);
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
      if (this.xBo != null)
      {
        paramVarArgs.iQ(4, this.xBo.computeSize());
        this.xBo.writeFields(paramVarArgs);
      }
      if (this.xBp != null)
      {
        paramVarArgs.iQ(5, this.xBp.computeSize());
        this.xBp.writeFields(paramVarArgs);
      }
      if (this.xpZ != null) {
        paramVarArgs.e(6, this.xpZ);
      }
      paramVarArgs.e(7, 8, this.wZn);
      paramVarArgs.aS(8, this.xqa);
      paramVarArgs.aO(9, this.wpg);
      if (this.xBq != null) {
        paramVarArgs.e(10, this.xBq);
      }
      paramVarArgs.aO(11, this.xBr);
      paramVarArgs.am(12, this.xBs);
      AppMethodBeat.o(56924);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1218;
      }
    }
    label1218:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.koj);
      paramInt = i;
      if (this.kok != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.kok);
      }
      i = paramInt;
      if (this.xBo != null) {
        i = paramInt + e.a.a.a.iP(4, this.xBo.computeSize());
      }
      paramInt = i;
      if (this.xBp != null) {
        paramInt = i + e.a.a.a.iP(5, this.xBp.computeSize());
      }
      i = paramInt;
      if (this.xpZ != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.xpZ);
      }
      i = i + e.a.a.a.c(7, 8, this.wZn) + (e.a.a.b.b.a.eW(8) + 1) + e.a.a.b.b.a.bl(9, this.wpg);
      paramInt = i;
      if (this.xBq != null) {
        paramInt = i + e.a.a.b.b.a.f(10, this.xBq);
      }
      i = e.a.a.b.b.a.bl(11, this.xBr);
      int j = e.a.a.b.b.a.p(12, this.xBs);
      AppMethodBeat.o(56924);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wZn.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(56924);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56924);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        bnd localbnd = (bnd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56924);
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
            localbnd.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56924);
          return 0;
        case 2: 
          localbnd.koj = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56924);
          return 0;
        case 3: 
          localbnd.kok = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56924);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new awi();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((awi)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbnd.xBo = ((awi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56924);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bnx();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bnx)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbnd.xBp = ((bnx)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56924);
          return 0;
        case 6: 
          localbnd.xpZ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56924);
          return 0;
        case 7: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new po();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((po)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localbnd.wZn.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56924);
          return 0;
        case 8: 
          localbnd.xqa = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(56924);
          return 0;
        case 9: 
          localbnd.wpg = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56924);
          return 0;
        case 10: 
          localbnd.xBq = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56924);
          return 0;
        case 11: 
          localbnd.xBr = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56924);
          return 0;
        }
        localbnd.xBs = ((e.a.a.a.a)localObject1).CLY.sm();
        AppMethodBeat.o(56924);
        return 0;
      }
      AppMethodBeat.o(56924);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bnd
 * JD-Core Version:    0.7.0.1
 */