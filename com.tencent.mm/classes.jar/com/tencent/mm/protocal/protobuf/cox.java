package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cox
  extends cvw
{
  public long HAG;
  public long HAH;
  public long offset;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91638);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aZ(2, this.HAG);
      paramVarArgs.aZ(3, this.offset);
      paramVarArgs.aZ(4, this.HAH);
      AppMethodBeat.o(91638);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label446;
      }
    }
    label446:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.p(2, this.HAG);
      int j = f.a.a.b.b.a.p(3, this.offset);
      int k = f.a.a.b.b.a.p(4, this.HAH);
      AppMethodBeat.o(91638);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91638);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cox localcox = (cox)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91638);
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
            localcox.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91638);
          return 0;
        case 2: 
          localcox.HAG = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(91638);
          return 0;
        case 3: 
          localcox.offset = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(91638);
          return 0;
        }
        localcox.HAH = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(91638);
        return 0;
      }
      AppMethodBeat.o(91638);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cox
 * JD-Core Version:    0.7.0.1
 */