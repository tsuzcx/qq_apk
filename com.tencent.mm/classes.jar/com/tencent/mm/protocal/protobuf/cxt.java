package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cxt
  extends cvp
{
  public String Fxq;
  public String Hpf;
  public String Hpg;
  public String Hph;
  public com.tencent.mm.bx.b Hpi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82472);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(82472);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Fxq != null) {
        paramVarArgs.d(3, this.Fxq);
      }
      if (this.Hpf != null) {
        paramVarArgs.d(4, this.Hpf);
      }
      if (this.Hpg != null) {
        paramVarArgs.d(5, this.Hpg);
      }
      if (this.Hph != null) {
        paramVarArgs.d(6, this.Hph);
      }
      if (this.Hpi != null) {
        paramVarArgs.c(7, this.Hpi);
      }
      AppMethodBeat.o(82472);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label666;
      }
    }
    label666:
    for (int i = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Fxq != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.Fxq);
      }
      i = paramInt;
      if (this.Hpf != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.Hpf);
      }
      paramInt = i;
      if (this.Hpg != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Hpg);
      }
      i = paramInt;
      if (this.Hph != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.Hph);
      }
      paramInt = i;
      if (this.Hpi != null) {
        paramInt = i + f.a.a.b.b.a.b(7, this.Hpi);
      }
      AppMethodBeat.o(82472);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(82472);
          throw paramVarArgs;
        }
        AppMethodBeat.o(82472);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cxt localcxt = (cxt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        case 2: 
        default: 
          AppMethodBeat.o(82472);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new BaseResponse();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((BaseResponse)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvp.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcxt.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82472);
          return 0;
        case 3: 
          localcxt.Fxq = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(82472);
          return 0;
        case 4: 
          localcxt.Hpf = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(82472);
          return 0;
        case 5: 
          localcxt.Hpg = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(82472);
          return 0;
        case 6: 
          localcxt.Hph = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(82472);
          return 0;
        }
        localcxt.Hpi = ((f.a.a.a.a)localObject1).NPN.gxI();
        AppMethodBeat.o(82472);
        return 0;
      }
      AppMethodBeat.o(82472);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxt
 * JD-Core Version:    0.7.0.1
 */