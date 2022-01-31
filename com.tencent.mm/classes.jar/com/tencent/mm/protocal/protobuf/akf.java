package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class akf
  extends bvk
{
  public LinkedList<ds> wrp;
  public int xbs;
  public int xbt;
  public LinkedList<Integer> xbu;
  public LinkedList<aao> xbv;
  public int xbw;
  
  public akf()
  {
    AppMethodBeat.i(73653);
    this.xbu = new LinkedList();
    this.xbv = new LinkedList();
    this.wrp = new LinkedList();
    AppMethodBeat.o(73653);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(73654);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(73654);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.xbs);
      paramVarArgs.aO(3, this.xbt);
      paramVarArgs.e(4, 2, this.xbu);
      paramVarArgs.e(5, 8, this.xbv);
      paramVarArgs.aO(6, this.xbw);
      paramVarArgs.e(7, 8, this.wrp);
      AppMethodBeat.o(73654);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label845;
      }
    }
    label845:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = e.a.a.b.b.a.bl(2, this.xbs);
      int j = e.a.a.b.b.a.bl(3, this.xbt);
      int k = e.a.a.a.c(4, 2, this.xbu);
      int m = e.a.a.a.c(5, 8, this.xbv);
      int n = e.a.a.b.b.a.bl(6, this.xbw);
      int i1 = e.a.a.a.c(7, 8, this.wrp);
      AppMethodBeat.o(73654);
      return paramInt + i + j + k + m + n + i1;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.xbu.clear();
        this.xbv.clear();
        this.wrp.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(73654);
          throw paramVarArgs;
        }
        AppMethodBeat.o(73654);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        akf localakf = (akf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(73654);
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
            localakf.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(73654);
          return 0;
        case 2: 
          localakf.xbs = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(73654);
          return 0;
        case 3: 
          localakf.xbt = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(73654);
          return 0;
        case 4: 
          localakf.xbu.add(Integer.valueOf(((e.a.a.a.a)localObject1).CLY.sl()));
          AppMethodBeat.o(73654);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aao();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aao)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localakf.xbv.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(73654);
          return 0;
        case 6: 
          localakf.xbw = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(73654);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ds();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ds)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localakf.wrp.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(73654);
        return 0;
      }
      AppMethodBeat.o(73654);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akf
 * JD-Core Version:    0.7.0.1
 */