package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bkg
  extends cvw
{
  public int FJf;
  public int GXv;
  public int xsB;
  public int xsC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(74659);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.GXv);
      paramVarArgs.aS(3, this.xsB);
      paramVarArgs.aS(4, this.xsC);
      paramVarArgs.aS(5, this.FJf);
      AppMethodBeat.o(74659);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label494;
      }
    }
    label494:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.GXv);
      int j = f.a.a.b.b.a.bz(3, this.xsB);
      int k = f.a.a.b.b.a.bz(4, this.xsC);
      int m = f.a.a.b.b.a.bz(5, this.FJf);
      AppMethodBeat.o(74659);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(74659);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bkg localbkg = (bkg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(74659);
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
            localbkg.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(74659);
          return 0;
        case 2: 
          localbkg.GXv = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(74659);
          return 0;
        case 3: 
          localbkg.xsB = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(74659);
          return 0;
        case 4: 
          localbkg.xsC = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(74659);
          return 0;
        }
        localbkg.FJf = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(74659);
        return 0;
      }
      AppMethodBeat.o(74659);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkg
 * JD-Core Version:    0.7.0.1
 */