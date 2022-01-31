package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cyh
  extends bvk
{
  public String wAa;
  public int wzS;
  public int xpM;
  public bsd yfp;
  public bsb yfq;
  public int yfr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124381);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.xpM);
      paramVarArgs.aO(3, this.wzS);
      if (this.wAa != null) {
        paramVarArgs.e(4, this.wAa);
      }
      if (this.yfp != null)
      {
        paramVarArgs.iQ(5, this.yfp.computeSize());
        this.yfp.writeFields(paramVarArgs);
      }
      if (this.yfq != null)
      {
        paramVarArgs.iQ(6, this.yfq.computeSize());
        this.yfq.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(7, this.yfr);
      AppMethodBeat.o(124381);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label814;
      }
    }
    label814:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.xpM) + e.a.a.b.b.a.bl(3, this.wzS);
      paramInt = i;
      if (this.wAa != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wAa);
      }
      i = paramInt;
      if (this.yfp != null) {
        i = paramInt + e.a.a.a.iP(5, this.yfp.computeSize());
      }
      paramInt = i;
      if (this.yfq != null) {
        paramInt = i + e.a.a.a.iP(6, this.yfq.computeSize());
      }
      i = e.a.a.b.b.a.bl(7, this.yfr);
      AppMethodBeat.o(124381);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(124381);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cyh localcyh = (cyh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124381);
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
            localcyh.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124381);
          return 0;
        case 2: 
          localcyh.xpM = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(124381);
          return 0;
        case 3: 
          localcyh.wzS = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(124381);
          return 0;
        case 4: 
          localcyh.wAa = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(124381);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bsd();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bsd)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcyh.yfp = ((bsd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124381);
          return 0;
        case 6: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bsb();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bsb)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcyh.yfq = ((bsb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124381);
          return 0;
        }
        localcyh.yfr = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(124381);
        return 0;
      }
      AppMethodBeat.o(124381);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyh
 * JD-Core Version:    0.7.0.1
 */