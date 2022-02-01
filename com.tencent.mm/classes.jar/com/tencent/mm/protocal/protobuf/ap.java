package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ap
  extends cvw
{
  public int FJT;
  public String FJU;
  public String FJV;
  public boolean FJW;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(113927);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.FJT);
      if (this.FJU != null) {
        paramVarArgs.d(3, this.FJU);
      }
      if (this.FJV != null) {
        paramVarArgs.d(4, this.FJV);
      }
      paramVarArgs.bC(5, this.FJW);
      AppMethodBeat.o(113927);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label514;
      }
    }
    label514:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.FJT);
      paramInt = i;
      if (this.FJU != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.FJU);
      }
      i = paramInt;
      if (this.FJV != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.FJV);
      }
      paramInt = f.a.a.b.b.a.amF(5);
      AppMethodBeat.o(113927);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(113927);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ap localap = (ap)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(113927);
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
            localap.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(113927);
          return 0;
        case 2: 
          localap.FJT = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(113927);
          return 0;
        case 3: 
          localap.FJU = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(113927);
          return 0;
        case 4: 
          localap.FJV = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(113927);
          return 0;
        }
        localap.FJW = ((f.a.a.a.a)localObject1).OmT.gvY();
        AppMethodBeat.o(113927);
        return 0;
      }
      AppMethodBeat.o(113927);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ap
 * JD-Core Version:    0.7.0.1
 */