package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bam
  extends cvw
{
  public cjm GQF;
  public String GoW;
  public long Gub;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72483);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.GoW != null) {
        paramVarArgs.d(2, this.GoW);
      }
      paramVarArgs.aZ(3, this.Gub);
      if (this.GQF != null)
      {
        paramVarArgs.lJ(4, this.GQF.computeSize());
        this.GQF.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72483);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label570;
      }
    }
    label570:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GoW != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.GoW);
      }
      i += f.a.a.b.b.a.p(3, this.Gub);
      paramInt = i;
      if (this.GQF != null) {
        paramInt = i + f.a.a.a.lI(4, this.GQF.computeSize());
      }
      AppMethodBeat.o(72483);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(72483);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bam localbam = (bam)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72483);
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
            localbam.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72483);
          return 0;
        case 2: 
          localbam.GoW = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(72483);
          return 0;
        case 3: 
          localbam.Gub = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(72483);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cjm();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cjm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbam.GQF = ((cjm)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72483);
        return 0;
      }
      AppMethodBeat.o(72483);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bam
 * JD-Core Version:    0.7.0.1
 */