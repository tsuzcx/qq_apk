package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class ejq
  extends cvw
{
  public b ImB;
  public String ImC;
  public int status;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(200272);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.status);
      if (this.ImB != null) {
        paramVarArgs.c(3, this.ImB);
      }
      if (this.ImC != null) {
        paramVarArgs.d(4, this.ImC);
      }
      AppMethodBeat.o(200272);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label474;
      }
    }
    label474:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.status);
      paramInt = i;
      if (this.ImB != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.ImB);
      }
      i = paramInt;
      if (this.ImC != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.ImC);
      }
      AppMethodBeat.o(200272);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(200272);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ejq localejq = (ejq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(200272);
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
            localejq.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(200272);
          return 0;
        case 2: 
          localejq.status = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(200272);
          return 0;
        case 3: 
          localejq.ImB = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(200272);
          return 0;
        }
        localejq.ImC = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(200272);
        return 0;
      }
      AppMethodBeat.o(200272);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ejq
 * JD-Core Version:    0.7.0.1
 */