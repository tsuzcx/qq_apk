package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cgh
  extends cld
{
  public LinkedList<cgf> Cxd;
  public String Ddo;
  public int OpCode;
  public int fpb;
  
  public cgh()
  {
    AppMethodBeat.i(127297);
    this.Cxd = new LinkedList();
    AppMethodBeat.o(127297);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127298);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(127298);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Ddo != null) {
        paramVarArgs.d(2, this.Ddo);
      }
      paramVarArgs.aR(3, this.OpCode);
      paramVarArgs.aR(4, this.fpb);
      paramVarArgs.e(5, 8, this.Cxd);
      AppMethodBeat.o(127298);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label650;
      }
    }
    label650:
    for (paramInt = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Ddo != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.Ddo);
      }
      paramInt = f.a.a.b.b.a.bA(3, this.OpCode);
      int j = f.a.a.b.b.a.bA(4, this.fpb);
      int k = f.a.a.a.c(5, 8, this.Cxd);
      AppMethodBeat.o(127298);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Cxd.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(127298);
          throw paramVarArgs;
        }
        AppMethodBeat.o(127298);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cgh localcgh = (cgh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(127298);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcgh.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(127298);
          return 0;
        case 2: 
          localcgh.Ddo = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(127298);
          return 0;
        case 3: 
          localcgh.OpCode = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(127298);
          return 0;
        case 4: 
          localcgh.fpb = ((f.a.a.a.a)localObject1).KhF.xS();
          AppMethodBeat.o(127298);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cgf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cgf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcgh.Cxd.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(127298);
        return 0;
      }
      AppMethodBeat.o(127298);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cgh
 * JD-Core Version:    0.7.0.1
 */