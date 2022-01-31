package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class agg
  extends buy
{
  public String appId;
  public String cqf;
  public String mLu;
  public String mLv;
  public String mLw;
  public String sign;
  public dh wZk;
  public String wkY;
  public int wkZ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(28415);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.appId != null) {
        paramVarArgs.e(2, this.appId);
      }
      if (this.mLu != null) {
        paramVarArgs.e(3, this.mLu);
      }
      if (this.mLv != null) {
        paramVarArgs.e(4, this.mLv);
      }
      if (this.mLw != null) {
        paramVarArgs.e(5, this.mLw);
      }
      if (this.cqf != null) {
        paramVarArgs.e(6, this.cqf);
      }
      if (this.sign != null) {
        paramVarArgs.e(7, this.sign);
      }
      if (this.wZk != null)
      {
        paramVarArgs.iQ(8, this.wZk.computeSize());
        this.wZk.writeFields(paramVarArgs);
      }
      if (this.wkY != null) {
        paramVarArgs.e(9, this.wkY);
      }
      paramVarArgs.aO(10, this.wkZ);
      AppMethodBeat.o(28415);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label954;
      }
    }
    label954:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.appId != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.appId);
      }
      i = paramInt;
      if (this.mLu != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.mLu);
      }
      paramInt = i;
      if (this.mLv != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.mLv);
      }
      i = paramInt;
      if (this.mLw != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.mLw);
      }
      paramInt = i;
      if (this.cqf != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.cqf);
      }
      i = paramInt;
      if (this.sign != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.sign);
      }
      paramInt = i;
      if (this.wZk != null) {
        paramInt = i + e.a.a.a.iP(8, this.wZk.computeSize());
      }
      i = paramInt;
      if (this.wkY != null) {
        i = paramInt + e.a.a.b.b.a.f(9, this.wkY);
      }
      paramInt = e.a.a.b.b.a.bl(10, this.wkZ);
      AppMethodBeat.o(28415);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(28415);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        agg localagg = (agg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(28415);
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
            localagg.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28415);
          return 0;
        case 2: 
          localagg.appId = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28415);
          return 0;
        case 3: 
          localagg.mLu = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28415);
          return 0;
        case 4: 
          localagg.mLv = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28415);
          return 0;
        case 5: 
          localagg.mLw = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28415);
          return 0;
        case 6: 
          localagg.cqf = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28415);
          return 0;
        case 7: 
          localagg.sign = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28415);
          return 0;
        case 8: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dh();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dh)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localagg.wZk = ((dh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(28415);
          return 0;
        case 9: 
          localagg.wkY = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(28415);
          return 0;
        }
        localagg.wkZ = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(28415);
        return 0;
      }
      AppMethodBeat.o(28415);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agg
 * JD-Core Version:    0.7.0.1
 */