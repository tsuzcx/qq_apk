package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class djd
  extends cvc
{
  public String Gdd;
  public long HtV;
  public String nDo;
  public int qey;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118444);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.nDo != null) {
        paramVarArgs.d(2, this.nDo);
      }
      paramVarArgs.aS(3, this.qey);
      if (this.Gdd != null) {
        paramVarArgs.d(4, this.Gdd);
      }
      paramVarArgs.aY(5, this.HtV);
      AppMethodBeat.o(118444);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label518;
      }
    }
    label518:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.nDo != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.nDo);
      }
      i += f.a.a.b.b.a.bz(3, this.qey);
      paramInt = i;
      if (this.Gdd != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Gdd);
      }
      i = f.a.a.b.b.a.p(5, this.HtV);
      AppMethodBeat.o(118444);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(118444);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        djd localdjd = (djd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118444);
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
            localdjd.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118444);
          return 0;
        case 2: 
          localdjd.nDo = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(118444);
          return 0;
        case 3: 
          localdjd.qey = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(118444);
          return 0;
        case 4: 
          localdjd.Gdd = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(118444);
          return 0;
        }
        localdjd.HtV = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(118444);
        return 0;
      }
      AppMethodBeat.o(118444);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.djd
 * JD-Core Version:    0.7.0.1
 */