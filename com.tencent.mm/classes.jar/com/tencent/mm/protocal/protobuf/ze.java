package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class ze
  extends buy
{
  public String lGH;
  public String wQc;
  public String wQd;
  public int wQe;
  public int wsW;
  public String wsp;
  public SKBuiltinBuffer_t wvN;
  public String wvW;
  public String wvs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(73701);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wvN == null)
      {
        paramVarArgs = new b("Not all required fields were included: RandomEncryKey");
        AppMethodBeat.o(73701);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.wvN != null)
      {
        paramVarArgs.iQ(2, this.wvN.computeSize());
        this.wvN.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(3, this.wsW);
      if (this.wvs != null) {
        paramVarArgs.e(4, this.wvs);
      }
      if (this.lGH != null) {
        paramVarArgs.e(5, this.lGH);
      }
      if (this.wvW != null) {
        paramVarArgs.e(6, this.wvW);
      }
      if (this.wQc != null) {
        paramVarArgs.e(7, this.wQc);
      }
      if (this.wsp != null) {
        paramVarArgs.e(8, this.wsp);
      }
      if (this.wQd != null) {
        paramVarArgs.e(9, this.wQd);
      }
      paramVarArgs.aO(10, this.wQe);
      AppMethodBeat.o(73701);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label970;
      }
    }
    label970:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wvN != null) {
        i = paramInt + e.a.a.a.iP(2, this.wvN.computeSize());
      }
      i += e.a.a.b.b.a.bl(3, this.wsW);
      paramInt = i;
      if (this.wvs != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wvs);
      }
      i = paramInt;
      if (this.lGH != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.lGH);
      }
      paramInt = i;
      if (this.wvW != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.wvW);
      }
      i = paramInt;
      if (this.wQc != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.wQc);
      }
      paramInt = i;
      if (this.wsp != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.wsp);
      }
      i = paramInt;
      if (this.wQd != null) {
        i = paramInt + e.a.a.b.b.a.f(9, this.wQd);
      }
      paramInt = e.a.a.b.b.a.bl(10, this.wQe);
      AppMethodBeat.o(73701);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.wvN == null)
        {
          paramVarArgs = new b("Not all required fields were included: RandomEncryKey");
          AppMethodBeat.o(73701);
          throw paramVarArgs;
        }
        AppMethodBeat.o(73701);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        ze localze = (ze)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(73701);
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
            localze.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(73701);
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
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localze.wvN = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(73701);
          return 0;
        case 3: 
          localze.wsW = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(73701);
          return 0;
        case 4: 
          localze.wvs = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(73701);
          return 0;
        case 5: 
          localze.lGH = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(73701);
          return 0;
        case 6: 
          localze.wvW = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(73701);
          return 0;
        case 7: 
          localze.wQc = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(73701);
          return 0;
        case 8: 
          localze.wsp = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(73701);
          return 0;
        case 9: 
          localze.wQd = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(73701);
          return 0;
        }
        localze.wQe = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(73701);
        return 0;
      }
      AppMethodBeat.o(73701);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ze
 * JD-Core Version:    0.7.0.1
 */