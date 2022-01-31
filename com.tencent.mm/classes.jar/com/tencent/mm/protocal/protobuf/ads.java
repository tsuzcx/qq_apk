package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ads
  extends buy
{
  public String pqE;
  public String wQf;
  public String wWF;
  public String wWG;
  public String wWH;
  public String wvG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56796);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.wWF != null) {
        paramVarArgs.e(2, this.wWF);
      }
      if (this.wvG != null) {
        paramVarArgs.e(3, this.wvG);
      }
      if (this.pqE != null) {
        paramVarArgs.e(4, this.pqE);
      }
      if (this.wWG != null) {
        paramVarArgs.e(5, this.wWG);
      }
      if (this.wWH != null) {
        paramVarArgs.e(6, this.wWH);
      }
      if (this.wQf != null) {
        paramVarArgs.e(7, this.wQf);
      }
      AppMethodBeat.o(56796);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label674;
      }
    }
    label674:
    for (int i = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.wWF != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.wWF);
      }
      i = paramInt;
      if (this.wvG != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.wvG);
      }
      paramInt = i;
      if (this.pqE != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.pqE);
      }
      i = paramInt;
      if (this.wWG != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.wWG);
      }
      paramInt = i;
      if (this.wWH != null) {
        paramInt = i + e.a.a.b.b.a.f(6, this.wWH);
      }
      i = paramInt;
      if (this.wQf != null) {
        i = paramInt + e.a.a.b.b.a.f(7, this.wQf);
      }
      AppMethodBeat.o(56796);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56796);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        ads localads = (ads)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56796);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new hq();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((hq)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localads.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56796);
          return 0;
        case 2: 
          localads.wWF = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56796);
          return 0;
        case 3: 
          localads.wvG = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56796);
          return 0;
        case 4: 
          localads.pqE = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56796);
          return 0;
        case 5: 
          localads.wWG = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56796);
          return 0;
        case 6: 
          localads.wWH = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56796);
          return 0;
        }
        localads.wQf = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56796);
        return 0;
      }
      AppMethodBeat.o(56796);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ads
 * JD-Core Version:    0.7.0.1
 */