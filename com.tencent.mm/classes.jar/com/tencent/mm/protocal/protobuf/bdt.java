package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class bdt
  extends cvw
{
  public b GTp;
  public b GTq;
  public int ReqType;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104807);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.ReqType);
      if (this.GTp != null) {
        paramVarArgs.c(3, this.GTp);
      }
      if (this.GTq != null) {
        paramVarArgs.c(4, this.GTq);
      }
      AppMethodBeat.o(104807);
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
      int i = paramInt + f.a.a.b.b.a.bz(2, this.ReqType);
      paramInt = i;
      if (this.GTp != null) {
        paramInt = i + f.a.a.b.b.a.b(3, this.GTp);
      }
      i = paramInt;
      if (this.GTq != null) {
        i = paramInt + f.a.a.b.b.a.b(4, this.GTq);
      }
      AppMethodBeat.o(104807);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(104807);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bdt localbdt = (bdt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104807);
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
            localbdt.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(104807);
          return 0;
        case 2: 
          localbdt.ReqType = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(104807);
          return 0;
        case 3: 
          localbdt.GTp = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(104807);
          return 0;
        }
        localbdt.GTq = ((f.a.a.a.a)localObject1).OmT.gCk();
        AppMethodBeat.o(104807);
        return 0;
      }
      AppMethodBeat.o(104807);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bdt
 * JD-Core Version:    0.7.0.1
 */