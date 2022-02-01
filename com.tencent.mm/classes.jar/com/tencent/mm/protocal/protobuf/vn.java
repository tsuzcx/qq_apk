package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class vn
  extends cvp
{
  public String FUR;
  public boolean FUS;
  public int dlw;
  public String paA;
  public int xZf;
  public String ygt;
  public String ygu;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72449);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72449);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.lC(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.dlw);
      if (this.paA != null) {
        paramVarArgs.d(3, this.paA);
      }
      if (this.FUR != null) {
        paramVarArgs.d(4, this.FUR);
      }
      if (this.ygt != null) {
        paramVarArgs.d(5, this.ygt);
      }
      paramVarArgs.bt(6, this.FUS);
      if (this.ygu != null) {
        paramVarArgs.d(7, this.ygu);
      }
      paramVarArgs.aS(8, this.xZf);
      AppMethodBeat.o(72449);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label734;
      }
    }
    label734:
    for (paramInt = f.a.a.a.lB(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.dlw);
      paramInt = i;
      if (this.paA != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.paA);
      }
      i = paramInt;
      if (this.FUR != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.FUR);
      }
      paramInt = i;
      if (this.ygt != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.ygt);
      }
      i = paramInt + f.a.a.b.b.a.alV(6);
      paramInt = i;
      if (this.ygu != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.ygu);
      }
      i = f.a.a.b.b.a.bz(8, this.xZf);
      AppMethodBeat.o(72449);
      return paramInt + i;
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
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72449);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72449);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        vn localvn = (vn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72449);
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
            localvn.BaseResponse = ((BaseResponse)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72449);
          return 0;
        case 2: 
          localvn.dlw = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(72449);
          return 0;
        case 3: 
          localvn.paA = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72449);
          return 0;
        case 4: 
          localvn.FUR = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72449);
          return 0;
        case 5: 
          localvn.ygt = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72449);
          return 0;
        case 6: 
          localvn.FUS = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(72449);
          return 0;
        case 7: 
          localvn.ygu = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(72449);
          return 0;
        }
        localvn.xZf = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(72449);
        return 0;
      }
      AppMethodBeat.o(72449);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vn
 * JD-Core Version:    0.7.0.1
 */