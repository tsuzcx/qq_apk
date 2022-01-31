package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class aqh
  extends buy
{
  public String jKG;
  public String lGH;
  public String wsp;
  public SKBuiltinBuffer_t wvN;
  public String xfF;
  public String xfG;
  public String xfH;
  public String xfI;
  public String xfJ;
  public int xfK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(73716);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wvN == null)
      {
        paramVarArgs = new b("Not all required fields were included: RandomEncryKey");
        AppMethodBeat.o(73716);
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
      if (this.xfF != null) {
        paramVarArgs.e(3, this.xfF);
      }
      if (this.xfG != null) {
        paramVarArgs.e(4, this.xfG);
      }
      if (this.jKG != null) {
        paramVarArgs.e(5, this.jKG);
      }
      if (this.xfH != null) {
        paramVarArgs.e(6, this.xfH);
      }
      if (this.xfI != null) {
        paramVarArgs.e(7, this.xfI);
      }
      if (this.xfJ != null) {
        paramVarArgs.e(8, this.xfJ);
      }
      paramVarArgs.aO(9, this.xfK);
      if (this.lGH != null) {
        paramVarArgs.e(10, this.lGH);
      }
      if (this.wsp != null) {
        paramVarArgs.e(11, this.wsp);
      }
      AppMethodBeat.o(73716);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1050;
      }
    }
    label1050:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wvN != null) {
        paramInt = i + e.a.a.a.iP(2, this.wvN.computeSize());
      }
      i = paramInt;
      if (this.xfF != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.xfF);
      }
      paramInt = i;
      if (this.xfG != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.xfG);
      }
      i = paramInt;
      if (this.jKG != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.jKG);
      }
      paramInt = i;
      if (this.xfH != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.xfH);
      }
      i = paramInt;
      if (this.xfI != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.xfI);
      }
      paramInt = i;
      if (this.xfJ != null) {
        paramInt = i + e.a.a.b.b.a.f(8, this.xfJ);
      }
      i = paramInt + e.a.a.b.b.a.bl(9, this.xfK);
      paramInt = i;
      if (this.lGH != null) {
        paramInt = i + e.a.a.b.b.a.f(10, this.lGH);
      }
      i = paramInt;
      if (this.wsp != null) {
        i = paramInt + e.a.a.b.b.a.f(11, this.wsp);
      }
      AppMethodBeat.o(73716);
      return i;
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
          AppMethodBeat.o(73716);
          throw paramVarArgs;
        }
        AppMethodBeat.o(73716);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        aqh localaqh = (aqh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(73716);
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
            localaqh.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(73716);
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
            localaqh.wvN = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(73716);
          return 0;
        case 3: 
          localaqh.xfF = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(73716);
          return 0;
        case 4: 
          localaqh.xfG = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(73716);
          return 0;
        case 5: 
          localaqh.jKG = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(73716);
          return 0;
        case 6: 
          localaqh.xfH = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(73716);
          return 0;
        case 7: 
          localaqh.xfI = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(73716);
          return 0;
        case 8: 
          localaqh.xfJ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(73716);
          return 0;
        case 9: 
          localaqh.xfK = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(73716);
          return 0;
        case 10: 
          localaqh.lGH = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(73716);
          return 0;
        }
        localaqh.wsp = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(73716);
        return 0;
      }
      AppMethodBeat.o(73716);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqh
 * JD-Core Version:    0.7.0.1
 */