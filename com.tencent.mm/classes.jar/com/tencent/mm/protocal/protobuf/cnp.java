package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class cnp
  extends cld
{
  public SKBuiltinBuffer_t Dta;
  public long Dtd;
  public String Eia;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104835);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(104835);
        throw paramVarArgs;
      }
      if (this.Eia == null)
      {
        paramVarArgs = new b("Not all required fields were included: SearchResult");
        AppMethodBeat.o(104835);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.kX(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Eia != null) {
        paramVarArgs.d(2, this.Eia);
      }
      if (this.Dta != null)
      {
        paramVarArgs.kX(3, this.Dta.computeSize());
        this.Dta.writeFields(paramVarArgs);
      }
      paramVarArgs.aG(4, this.Dtd);
      AppMethodBeat.o(104835);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label666;
      }
    }
    label666:
    for (int i = f.a.a.a.kW(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Eia != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Eia);
      }
      i = paramInt;
      if (this.Dta != null) {
        i = paramInt + f.a.a.a.kW(3, this.Dta.computeSize());
      }
      paramInt = f.a.a.b.b.a.q(4, this.Dtd);
      AppMethodBeat.o(104835);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cld.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cld.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(104835);
          throw paramVarArgs;
        }
        if (this.Eia == null)
        {
          paramVarArgs = new b("Not all required fields were included: SearchResult");
          AppMethodBeat.o(104835);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104835);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cnp localcnp = (cnp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104835);
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
            localcnp.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104835);
          return 0;
        case 2: 
          localcnp.Eia = ((f.a.a.a.a)localObject1).KhF.readString();
          AppMethodBeat.o(104835);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cld.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcnp.Dta = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104835);
          return 0;
        }
        localcnp.Dtd = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(104835);
        return 0;
      }
      AppMethodBeat.o(104835);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cnp
 * JD-Core Version:    0.7.0.1
 */