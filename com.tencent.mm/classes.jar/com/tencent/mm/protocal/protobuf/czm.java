package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class czm
  extends cvp
{
  public long Hql;
  public b Hqm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(108149);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.Hql);
      if (this.Hqm != null) {
        paramVarArgs.c(3, this.Hqm);
      }
      AppMethodBeat.o(108149);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label414;
      }
    }
    label414:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.Hql);
      paramInt = i;
      if (this.Hqm != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.Hqm);
      }
      AppMethodBeat.o(108149);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(108149);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        czm localczm = (czm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(108149);
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
            localczm.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(108149);
          return 0;
        case 2: 
          localczm.Hql = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(108149);
          return 0;
        }
        localczm.Hqm = ((f.a.a.a.a)localObject1).NPN.gxI();
        AppMethodBeat.o(108149);
        return 0;
      }
      AppMethodBeat.o(108149);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.czm
 * JD-Core Version:    0.7.0.1
 */