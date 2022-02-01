package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class pg
  extends cvc
{
  public String FKw;
  public int FKx;
  public com.tencent.mm.bx.b FKy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207246);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FKw == null)
      {
        paramVarArgs = new f.a.a.b("Not all required fields were included: main_brand_user_name");
        AppMethodBeat.o(207246);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FKw != null) {
        paramVarArgs.d(2, this.FKw);
      }
      paramVarArgs.aS(3, this.FKx);
      if (this.FKy != null) {
        paramVarArgs.c(4, this.FKy);
      }
      AppMethodBeat.o(207246);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label522;
      }
    }
    label522:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FKw != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.FKw);
      }
      i += f.a.a.b.b.a.bz(3, this.FKx);
      paramInt = i;
      if (this.FKy != null) {
        paramInt = i + f.a.a.b.b.a.b(4, this.FKy);
      }
      AppMethodBeat.o(207246);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.FKw == null)
        {
          paramVarArgs = new f.a.a.b("Not all required fields were included: main_brand_user_name");
          AppMethodBeat.o(207246);
          throw paramVarArgs;
        }
        AppMethodBeat.o(207246);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        pg localpg = (pg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(207246);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, cvc.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localpg.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(207246);
          return 0;
        case 2: 
          localpg.FKw = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(207246);
          return 0;
        case 3: 
          localpg.FKx = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(207246);
          return 0;
        }
        localpg.FKy = ((f.a.a.a.a)localObject1).NPN.gxI();
        AppMethodBeat.o(207246);
        return 0;
      }
      AppMethodBeat.o(207246);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pg
 * JD-Core Version:    0.7.0.1
 */