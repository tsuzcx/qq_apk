package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class aof
  extends cvw
{
  public alw GDR;
  public b lastBuffer;
  public String sbR;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168979);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.lastBuffer != null) {
        paramVarArgs.c(2, this.lastBuffer);
      }
      if (this.sbR != null) {
        paramVarArgs.d(3, this.sbR);
      }
      if (this.GDR != null)
      {
        paramVarArgs.lJ(4, this.GDR.computeSize());
        this.GDR.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(168979);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label586;
      }
    }
    label586:
    for (int i = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.lastBuffer != null) {
        paramInt = i + f.a.a.b.b.a.b(2, this.lastBuffer);
      }
      i = paramInt;
      if (this.sbR != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.sbR);
      }
      paramInt = i;
      if (this.GDR != null) {
        paramInt = i + f.a.a.a.lI(4, this.GDR.computeSize());
      }
      AppMethodBeat.o(168979);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(168979);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aof localaof = (aof)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168979);
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
            localaof.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(168979);
          return 0;
        case 2: 
          localaof.lastBuffer = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(168979);
          return 0;
        case 3: 
          localaof.sbR = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(168979);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new alw();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((alw)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaof.GDR = ((alw)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(168979);
        return 0;
      }
      AppMethodBeat.o(168979);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aof
 * JD-Core Version:    0.7.0.1
 */