package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public class apo
  extends bvk
{
  public String nQe;
  public LinkedList<ccn> xfp;
  public int xfq;
  public int xfr;
  
  public apo()
  {
    AppMethodBeat.i(114965);
    this.xfp = new LinkedList();
    AppMethodBeat.o(114965);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114966);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(114966);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.xfp);
      if (this.nQe != null) {
        paramVarArgs.e(3, this.nQe);
      }
      paramVarArgs.aO(4, this.xfq);
      paramVarArgs.aO(5, this.xfr);
      AppMethodBeat.o(114966);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label650;
      }
    }
    label650:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.a.c(2, 8, this.xfp);
      paramInt = i;
      if (this.nQe != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.nQe);
      }
      i = e.a.a.b.b.a.bl(4, this.xfq);
      int j = e.a.a.b.b.a.bl(5, this.xfr);
      AppMethodBeat.o(114966);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xfp.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(114966);
          throw paramVarArgs;
        }
        AppMethodBeat.o(114966);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        apo localapo = (apo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114966);
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
            localapo.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114966);
          return 0;
        case 2: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ccn();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ccn)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localapo.xfp.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114966);
          return 0;
        case 3: 
          localapo.nQe = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(114966);
          return 0;
        case 4: 
          localapo.xfq = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(114966);
          return 0;
        }
        localapo.xfr = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(114966);
        return 0;
      }
      AppMethodBeat.o(114966);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.apo
 * JD-Core Version:    0.7.0.1
 */