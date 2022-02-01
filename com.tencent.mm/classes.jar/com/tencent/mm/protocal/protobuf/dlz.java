package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dlz
  extends cvw
{
  public String FZx;
  public boolean lXh;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6435);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FZx == null)
      {
        paramVarArgs = new b("Not all required fields were included: brand_user_name");
        AppMethodBeat.o(6435);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FZx != null) {
        paramVarArgs.d(2, this.FZx);
      }
      paramVarArgs.bC(3, this.lXh);
      AppMethodBeat.o(6435);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label471;
      }
    }
    label471:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FZx != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.FZx);
      }
      paramInt = f.a.a.b.b.a.amF(3);
      AppMethodBeat.o(6435);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.FZx == null)
        {
          paramVarArgs = new b("Not all required fields were included: brand_user_name");
          AppMethodBeat.o(6435);
          throw paramVarArgs;
        }
        AppMethodBeat.o(6435);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dlz localdlz = (dlz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(6435);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdlz.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(6435);
          return 0;
        case 2: 
          localdlz.FZx = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(6435);
          return 0;
        }
        localdlz.lXh = ((f.a.a.a.a)localObject1).OmT.gvY();
        AppMethodBeat.o(6435);
        return 0;
      }
      AppMethodBeat.o(6435);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dlz
 * JD-Core Version:    0.7.0.1
 */