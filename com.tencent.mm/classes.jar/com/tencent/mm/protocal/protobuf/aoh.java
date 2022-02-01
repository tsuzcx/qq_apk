package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class aoh
  extends cvw
{
  public String GDP;
  public alw GDR;
  public b GFN;
  public int dvm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168982);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.GDP != null) {
        paramVarArgs.d(2, this.GDP);
      }
      if (this.GFN != null) {
        paramVarArgs.c(3, this.GFN);
      }
      if (this.GDR != null)
      {
        paramVarArgs.lJ(4, this.GDR.computeSize());
        this.GDR.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(5, this.dvm);
      AppMethodBeat.o(168982);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label630;
      }
    }
    label630:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GDP != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GDP);
      }
      i = paramInt;
      if (this.GFN != null) {
        i = paramInt + f.a.a.b.b.a.b(3, this.GFN);
      }
      paramInt = i;
      if (this.GDR != null) {
        paramInt = i + f.a.a.a.lI(4, this.GDR.computeSize());
      }
      i = f.a.a.b.b.a.bz(5, this.dvm);
      AppMethodBeat.o(168982);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(168982);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aoh localaoh = (aoh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168982);
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
            localaoh.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168982);
          return 0;
        case 2: 
          localaoh.GDP = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(168982);
          return 0;
        case 3: 
          localaoh.GFN = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(168982);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new alw();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((alw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaoh.GDR = ((alw)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168982);
          return 0;
        }
        localaoh.dvm = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(168982);
        return 0;
      }
      AppMethodBeat.o(168982);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aoh
 * JD-Core Version:    0.7.0.1
 */