package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cfh
  extends buy
{
  public int ExtFlag;
  public String fKw;
  public int jKs;
  public String pIw;
  public int pIx;
  public int pIy;
  public int wLO;
  public String wQr;
  public String woO;
  public SKBuiltinBuffer_t wtq;
  public clw xBi;
  public int xPK;
  public int xPL;
  public int xso;
  public int xsp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94620);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wtq == null)
      {
        paramVarArgs = new b("Not all required fields were included: Buffer");
        AppMethodBeat.o(94620);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.jKs);
      paramVarArgs.aO(3, this.pIy);
      paramVarArgs.aO(4, this.pIx);
      if (this.wtq != null)
      {
        paramVarArgs.iQ(5, this.wtq.computeSize());
        this.wtq.writeFields(paramVarArgs);
      }
      if (this.pIw != null) {
        paramVarArgs.e(6, this.pIw);
      }
      paramVarArgs.aO(7, this.xso);
      paramVarArgs.aO(8, this.xsp);
      if (this.woO != null) {
        paramVarArgs.e(9, this.woO);
      }
      paramVarArgs.aO(10, this.xPK);
      paramVarArgs.aO(11, this.wLO);
      if (this.xBi != null)
      {
        paramVarArgs.iQ(12, this.xBi.computeSize());
        this.xBi.writeFields(paramVarArgs);
      }
      if (this.fKw != null) {
        paramVarArgs.e(13, this.fKw);
      }
      paramVarArgs.aO(14, this.ExtFlag);
      if (this.wQr != null) {
        paramVarArgs.e(15, this.wQr);
      }
      paramVarArgs.aO(16, this.xPL);
      AppMethodBeat.o(94620);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1318;
      }
    }
    label1318:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.jKs) + e.a.a.b.b.a.bl(3, this.pIy) + e.a.a.b.b.a.bl(4, this.pIx);
      paramInt = i;
      if (this.wtq != null) {
        paramInt = i + e.a.a.a.iP(5, this.wtq.computeSize());
      }
      i = paramInt;
      if (this.pIw != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.pIw);
      }
      i = i + e.a.a.b.b.a.bl(7, this.xso) + e.a.a.b.b.a.bl(8, this.xsp);
      paramInt = i;
      if (this.woO != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.woO);
      }
      i = paramInt + e.a.a.b.b.a.bl(10, this.xPK) + e.a.a.b.b.a.bl(11, this.wLO);
      paramInt = i;
      if (this.xBi != null) {
        paramInt = i + e.a.a.a.iP(12, this.xBi.computeSize());
      }
      i = paramInt;
      if (this.fKw != null) {
        i = paramInt + e.a.a.b.b.a.f(13, this.fKw);
      }
      i += e.a.a.b.b.a.bl(14, this.ExtFlag);
      paramInt = i;
      if (this.wQr != null) {
        paramInt = i + e.a.a.b.b.a.f(15, this.wQr);
      }
      i = e.a.a.b.b.a.bl(16, this.xPL);
      AppMethodBeat.o(94620);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.wtq == null)
        {
          paramVarArgs = new b("Not all required fields were included: Buffer");
          AppMethodBeat.o(94620);
          throw paramVarArgs;
        }
        AppMethodBeat.o(94620);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cfh localcfh = (cfh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(94620);
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
            localcfh.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94620);
          return 0;
        case 2: 
          localcfh.jKs = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94620);
          return 0;
        case 3: 
          localcfh.pIy = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94620);
          return 0;
        case 4: 
          localcfh.pIx = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94620);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcfh.wtq = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94620);
          return 0;
        case 6: 
          localcfh.pIw = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94620);
          return 0;
        case 7: 
          localcfh.xso = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94620);
          return 0;
        case 8: 
          localcfh.xsp = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94620);
          return 0;
        case 9: 
          localcfh.woO = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94620);
          return 0;
        case 10: 
          localcfh.xPK = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94620);
          return 0;
        case 11: 
          localcfh.wLO = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94620);
          return 0;
        case 12: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new clw();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((clw)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcfh.xBi = ((clw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94620);
          return 0;
        case 13: 
          localcfh.fKw = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94620);
          return 0;
        case 14: 
          localcfh.ExtFlag = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94620);
          return 0;
        case 15: 
          localcfh.wQr = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94620);
          return 0;
        }
        localcfh.xPL = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(94620);
        return 0;
      }
      AppMethodBeat.o(94620);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cfh
 * JD-Core Version:    0.7.0.1
 */