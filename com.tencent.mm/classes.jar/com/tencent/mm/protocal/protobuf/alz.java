package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class alz
  extends bvk
{
  public String gwR;
  public int wBX;
  public String wBZ;
  public SKBuiltinBuffer_t xcE;
  public int xcJ;
  public LinkedList<bwc> xcK;
  public int xcL;
  public LinkedList<azs> xcM;
  public String xcN;
  public int xcO;
  public int xcP;
  public azt xcQ;
  public String xcR;
  
  public alz()
  {
    AppMethodBeat.i(28447);
    this.xcK = new LinkedList();
    this.xcM = new LinkedList();
    AppMethodBeat.o(28447);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28448);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(28448);
        throw paramVarArgs;
      }
      if (this.xcE == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buff");
        AppMethodBeat.o(28448);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.xcE != null)
      {
        paramVarArgs.iQ(2, this.xcE.computeSize());
        this.xcE.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(3, this.xcJ);
      paramVarArgs.e(4, 8, this.xcK);
      paramVarArgs.aO(5, this.xcL);
      paramVarArgs.e(6, 8, this.xcM);
      paramVarArgs.aO(7, this.wBX);
      if (this.xcN != null) {
        paramVarArgs.e(8, this.xcN);
      }
      if (this.wBZ != null) {
        paramVarArgs.e(9, this.wBZ);
      }
      paramVarArgs.aO(10, this.xcO);
      if (this.gwR != null) {
        paramVarArgs.e(11, this.gwR);
      }
      paramVarArgs.aO(12, this.xcP);
      if (this.xcQ != null)
      {
        paramVarArgs.iQ(13, this.xcQ.computeSize());
        this.xcQ.writeFields(paramVarArgs);
      }
      if (this.xcR != null) {
        paramVarArgs.e(14, this.xcR);
      }
      AppMethodBeat.o(28448);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1490;
      }
    }
    label1490:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xcE != null) {
        i = paramInt + e.a.a.a.iP(2, this.xcE.computeSize());
      }
      i = i + e.a.a.b.b.a.bl(3, this.xcJ) + e.a.a.a.c(4, 8, this.xcK) + e.a.a.b.b.a.bl(5, this.xcL) + e.a.a.a.c(6, 8, this.xcM) + e.a.a.b.b.a.bl(7, this.wBX);
      paramInt = i;
      if (this.xcN != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.xcN);
      }
      i = paramInt;
      if (this.wBZ != null) {
        i = paramInt + e.a.a.b.b.a.f(9, this.wBZ);
      }
      i += e.a.a.b.b.a.bl(10, this.xcO);
      paramInt = i;
      if (this.gwR != null) {
        paramInt = i + e.a.a.b.b.a.f(11, this.gwR);
      }
      i = paramInt + e.a.a.b.b.a.bl(12, this.xcP);
      paramInt = i;
      if (this.xcQ != null) {
        paramInt = i + e.a.a.a.iP(13, this.xcQ.computeSize());
      }
      i = paramInt;
      if (this.xcR != null) {
        i = paramInt + e.a.a.b.b.a.f(14, this.xcR);
      }
      AppMethodBeat.o(28448);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xcK.clear();
        this.xcM.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(28448);
          throw paramVarArgs;
        }
        if (this.xcE == null)
        {
          paramVarArgs = new b("Not all required fields were included: Buff");
          AppMethodBeat.o(28448);
          throw paramVarArgs;
        }
        AppMethodBeat.o(28448);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        alz localalz = (alz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(28448);
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
            localalz.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28448);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localalz.xcE = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28448);
          return 0;
        case 3: 
          localalz.xcJ = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28448);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localalz.xcK.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28448);
          return 0;
        case 5: 
          localalz.xcL = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28448);
          return 0;
        case 6: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new azs();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((azs)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localalz.xcM.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28448);
          return 0;
        case 7: 
          localalz.wBX = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28448);
          return 0;
        case 8: 
          localalz.xcN = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28448);
          return 0;
        case 9: 
          localalz.wBZ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28448);
          return 0;
        case 10: 
          localalz.xcO = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28448);
          return 0;
        case 11: 
          localalz.gwR = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28448);
          return 0;
        case 12: 
          localalz.xcP = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(28448);
          return 0;
        case 13: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new azt();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((azt)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localalz.xcQ = ((azt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28448);
          return 0;
        }
        localalz.xcR = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(28448);
        return 0;
      }
      AppMethodBeat.o(28448);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.alz
 * JD-Core Version:    0.7.0.1
 */