package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class vt
  extends buy
{
  public int Scene;
  public int eeF;
  public bwc wOt;
  public SKBuiltinBuffer_t wOu;
  public LinkedList<bcw> wov;
  
  public vt()
  {
    AppMethodBeat.i(5568);
    this.wov = new LinkedList();
    AppMethodBeat.o(5568);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(5569);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.wOt == null)
      {
        paramVarArgs = new b("Not all required fields were included: Topic");
        AppMethodBeat.o(5569);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.iQ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.wOt != null)
      {
        paramVarArgs.iQ(2, this.wOt.computeSize());
        this.wOt.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(3, this.eeF);
      paramVarArgs.e(4, 8, this.wov);
      paramVarArgs.aO(5, this.Scene);
      if (this.wOu != null)
      {
        paramVarArgs.iQ(6, this.wOu.computeSize());
        this.wOu.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(5569);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label906;
      }
    }
    label906:
    for (paramInt = e.a.a.a.iP(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wOt != null) {
        i = paramInt + e.a.a.a.iP(2, this.wOt.computeSize());
      }
      i = i + e.a.a.b.b.a.bl(3, this.eeF) + e.a.a.a.c(4, 8, this.wov) + e.a.a.b.b.a.bl(5, this.Scene);
      paramInt = i;
      if (this.wOu != null) {
        paramInt = i + e.a.a.a.iP(6, this.wOu.computeSize());
      }
      AppMethodBeat.o(5569);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wov.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = buy.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = buy.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.wOt == null)
        {
          paramVarArgs = new b("Not all required fields were included: Topic");
          AppMethodBeat.o(5569);
          throw paramVarArgs;
        }
        AppMethodBeat.o(5569);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        vt localvt = (vt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(5569);
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
            localvt.BaseRequest = ((hq)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5569);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bwc();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bwc)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localvt.wOt = ((bwc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5569);
          return 0;
        case 3: 
          localvt.eeF = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5569);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bcw();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bcw)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localvt.wov.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(5569);
          return 0;
        case 5: 
          localvt.Scene = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(5569);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new SKBuiltinBuffer_t();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, buy.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localvt.wOu = ((SKBuiltinBuffer_t)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(5569);
        return 0;
      }
      AppMethodBeat.o(5569);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vt
 * JD-Core Version:    0.7.0.1
 */