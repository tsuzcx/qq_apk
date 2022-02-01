package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class yh
  extends cvc
{
  public String Daf;
  public String duW;
  public String dzn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123565);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lC(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.duW != null) {
        paramVarArgs.d(2, this.duW);
      }
      if (this.dzn != null) {
        paramVarArgs.d(3, this.dzn);
      }
      if (this.Daf != null) {
        paramVarArgs.d(4, this.Daf);
      }
      AppMethodBeat.o(123565);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label490;
      }
    }
    label490:
    for (int i = f.a.a.a.lB(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.duW != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.duW);
      }
      i = paramInt;
      if (this.dzn != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.dzn);
      }
      paramInt = i;
      if (this.Daf != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Daf);
      }
      AppMethodBeat.o(123565);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(123565);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        yh localyh = (yh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123565);
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
            localyh.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123565);
          return 0;
        case 2: 
          localyh.duW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123565);
          return 0;
        case 3: 
          localyh.dzn = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(123565);
          return 0;
        }
        localyh.Daf = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(123565);
        return 0;
      }
      AppMethodBeat.o(123565);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.yh
 * JD-Core Version:    0.7.0.1
 */