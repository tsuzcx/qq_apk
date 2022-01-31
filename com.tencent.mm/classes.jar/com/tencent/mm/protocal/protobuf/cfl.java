package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cfl
  extends bvk
{
  public LinkedList<SnsObject> wuP;
  public String xOk;
  public int xOo;
  public ceu xOq;
  public int xPP;
  public long xPQ;
  public long xPR;
  public String xPS;
  public int xPz;
  public cfj xpk;
  public int xtO;
  
  public cfl()
  {
    AppMethodBeat.i(94624);
    this.wuP = new LinkedList();
    AppMethodBeat.o(94624);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94625);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(94625);
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
      paramVarArgs.aO(5, this.xPP);
      if (this.xpk != null)
      {
        paramVarArgs.iQ(6, this.xpk.computeSize());
        this.xpk.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(7, this.xPz);
      paramVarArgs.aO(8, this.xOo);
      if (this.xOq != null)
      {
        paramVarArgs.iQ(9, this.xOq.computeSize());
        this.xOq.writeFields(paramVarArgs);
      }
      paramVarArgs.am(10, this.xPQ);
      paramVarArgs.am(11, this.xPR);
      if (this.xPS != null) {
        paramVarArgs.e(12, this.xPS);
      }
      AppMethodBeat.o(94625);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1198;
      }
    }
    label1198:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.xOk != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.xOk);
      }
      i = i + e.a.a.b.b.a.bl(3, this.xtO) + e.a.a.a.c(4, 8, this.wuP) + e.a.a.b.b.a.bl(5, this.xPP);
      paramInt = i;
      if (this.xpk != null) {
        paramInt = i + e.a.a.a.iP(6, this.xpk.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.bl(7, this.xPz) + e.a.a.b.b.a.bl(8, this.xOo);
      paramInt = i;
      if (this.xOq != null) {
        paramInt = i + e.a.a.a.iP(9, this.xOq.computeSize());
      }
      i = paramInt + e.a.a.b.b.a.p(10, this.xPQ) + e.a.a.b.b.a.p(11, this.xPR);
      paramInt = i;
      if (this.xPS != null) {
        paramInt = i + e.a.a.b.b.a.f(12, this.xPS);
      }
      AppMethodBeat.o(94625);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wuP.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(94625);
          throw paramVarArgs;
        }
        AppMethodBeat.o(94625);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cfl localcfl = (cfl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(94625);
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
            localcfl.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94625);
          return 0;
        case 2: 
          localcfl.xOk = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94625);
          return 0;
        case 3: 
          localcfl.xtO = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94625);
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
            localcfl.wuP.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94625);
          return 0;
        case 5: 
          localcfl.xPP = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94625);
          return 0;
        case 6: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cfj();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cfj)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcfl.xpk = ((cfj)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94625);
          return 0;
        case 7: 
          localcfl.xPz = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94625);
          return 0;
        case 8: 
          localcfl.xOo = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94625);
          return 0;
        case 9: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ceu();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ceu)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcfl.xOq = ((ceu)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94625);
          return 0;
        case 10: 
          localcfl.xPQ = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(94625);
          return 0;
        case 11: 
          localcfl.xPR = ((e.a.a.a.a)localObject1).CLY.sm();
          AppMethodBeat.o(94625);
          return 0;
        }
        localcfl.xPS = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(94625);
        return 0;
      }
      AppMethodBeat.o(94625);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cfl
 * JD-Core Version:    0.7.0.1
 */