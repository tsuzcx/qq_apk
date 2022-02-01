package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dav
  extends cvc
{
  public long HqN;
  public long HqO;
  public String toa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82476);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.toa != null) {
        paramVarArgs.d(2, this.toa);
      }
      paramVarArgs.aY(3, this.HqN);
      paramVarArgs.aY(4, this.HqO);
      AppMethodBeat.o(82476);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label462;
      }
    }
    label462:
    for (paramInt = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.toa != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.toa);
      }
      paramInt = f.a.a.b.b.a.p(3, this.HqN);
      int j = f.a.a.b.b.a.p(4, this.HqO);
      AppMethodBeat.o(82476);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(82476);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dav localdav = (dav)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82476);
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
            localdav.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82476);
          return 0;
        case 2: 
          localdav.toa = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(82476);
          return 0;
        case 3: 
          localdav.HqN = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(82476);
          return 0;
        }
        localdav.HqO = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(82476);
        return 0;
      }
      AppMethodBeat.o(82476);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dav
 * JD-Core Version:    0.7.0.1
 */