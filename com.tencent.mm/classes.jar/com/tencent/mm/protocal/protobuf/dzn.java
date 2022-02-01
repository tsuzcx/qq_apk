package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dzn
  extends cvw
{
  public int Gxq;
  public long Gxr;
  public long Idp;
  public int Iew;
  public int Timestamp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115881);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.Gxq);
      paramVarArgs.aZ(3, this.Gxr);
      paramVarArgs.aS(4, this.Timestamp);
      paramVarArgs.aZ(5, this.Idp);
      paramVarArgs.aS(6, this.Iew);
      AppMethodBeat.o(115881);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label542;
      }
    }
    label542:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.Gxq);
      int j = f.a.a.b.b.a.p(3, this.Gxr);
      int k = f.a.a.b.b.a.bz(4, this.Timestamp);
      int m = f.a.a.b.b.a.p(5, this.Idp);
      int n = f.a.a.b.b.a.bz(6, this.Iew);
      AppMethodBeat.o(115881);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(115881);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dzn localdzn = (dzn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115881);
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
            localdzn.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(115881);
          return 0;
        case 2: 
          localdzn.Gxq = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115881);
          return 0;
        case 3: 
          localdzn.Gxr = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(115881);
          return 0;
        case 4: 
          localdzn.Timestamp = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(115881);
          return 0;
        case 5: 
          localdzn.Idp = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(115881);
          return 0;
        }
        localdzn.Iew = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(115881);
        return 0;
      }
      AppMethodBeat.o(115881);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzn
 * JD-Core Version:    0.7.0.1
 */