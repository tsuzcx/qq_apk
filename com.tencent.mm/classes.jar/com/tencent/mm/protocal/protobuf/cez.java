package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;
import java.util.LinkedList;

public final class cez
  extends bvk
{
  public int OpCode;
  public int jJu;
  public LinkedList<cex> jJv;
  public int rfp;
  public String xPr;
  
  public cez()
  {
    AppMethodBeat.i(94609);
    this.jJv = new LinkedList();
    AppMethodBeat.o(94609);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(94610);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(94610);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.iQ(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.OpCode);
      if (this.xPr != null) {
        paramVarArgs.e(3, this.xPr);
      }
      paramVarArgs.aO(4, this.jJu);
      paramVarArgs.e(5, 8, this.jJv);
      paramVarArgs.aO(6, this.rfp);
      AppMethodBeat.o(94610);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label698;
      }
    }
    label698:
    for (paramInt = e.a.a.a.iP(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.OpCode);
      paramInt = i;
      if (this.xPr != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.xPr);
      }
      i = e.a.a.b.b.a.bl(4, this.jJu);
      int j = e.a.a.a.c(5, 8, this.jJv);
      int k = e.a.a.b.b.a.bl(6, this.rfp);
      AppMethodBeat.o(94610);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.jJv.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = bvk.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = bvk.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(94610);
          throw paramVarArgs;
        }
        AppMethodBeat.o(94610);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        cez localcez = (cez)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(94610);
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
            localcez.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94610);
          return 0;
        case 2: 
          localcez.OpCode = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94610);
          return 0;
        case 3: 
          localcez.xPr = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(94610);
          return 0;
        case 4: 
          localcez.jJu = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(94610);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cex();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cex)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, bvk.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localcez.jJv.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(94610);
          return 0;
        }
        localcez.rfp = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(94610);
        return 0;
      }
      AppMethodBeat.o(94610);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cez
 * JD-Core Version:    0.7.0.1
 */