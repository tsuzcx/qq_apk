package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cxd
  extends cvw
{
  public String FNj;
  public cxa GPK;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(181508);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FNj != null) {
        paramVarArgs.d(2, this.FNj);
      }
      if (this.GPK != null)
      {
        paramVarArgs.lJ(3, this.GPK.computeSize());
        this.GPK.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(181508);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label526;
      }
    }
    label526:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.FNj != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FNj);
      }
      i = paramInt;
      if (this.GPK != null) {
        i = paramInt + f.a.a.a.lI(3, this.GPK.computeSize());
      }
      AppMethodBeat.o(181508);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(181508);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cxd localcxd = (cxd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(181508);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcxd.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(181508);
          return 0;
        case 2: 
          localcxd.FNj = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(181508);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cxa();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cxa)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localcxd.GPK = ((cxa)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(181508);
        return 0;
      }
      AppMethodBeat.o(181508);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cxd
 * JD-Core Version:    0.7.0.1
 */