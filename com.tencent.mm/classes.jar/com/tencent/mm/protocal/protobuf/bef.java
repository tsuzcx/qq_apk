package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bef
  extends cvw
{
  public long FKy;
  public String FKz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(215568);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aZ(2, this.FKy);
      if (this.FKz != null) {
        paramVarArgs.d(3, this.FKz);
      }
      AppMethodBeat.o(215568);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label414;
      }
    }
    label414:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.FKy);
      paramInt = i;
      if (this.FKz != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.FKz);
      }
      AppMethodBeat.o(215568);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(215568);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bef localbef = (bef)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(215568);
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
            localbef.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(215568);
          return 0;
        case 2: 
          localbef.FKy = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(215568);
          return 0;
        }
        localbef.FKz = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(215568);
        return 0;
      }
      AppMethodBeat.o(215568);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bef
 * JD-Core Version:    0.7.0.1
 */