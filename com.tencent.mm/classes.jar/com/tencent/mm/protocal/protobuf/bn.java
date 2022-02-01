package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bn
  extends cvw
{
  public bm FMh;
  public String cPd;
  public String content;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125691);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.cPd != null) {
        paramVarArgs.d(2, this.cPd);
      }
      if (this.FMh != null)
      {
        paramVarArgs.lJ(3, this.FMh.computeSize());
        this.FMh.writeFields(paramVarArgs);
      }
      if (this.content != null) {
        paramVarArgs.d(4, this.content);
      }
      AppMethodBeat.o(125691);
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
      if (this.cPd != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.cPd);
      }
      i = paramInt;
      if (this.FMh != null) {
        i = paramInt + f.a.a.a.lI(3, this.FMh.computeSize());
      }
      paramInt = i;
      if (this.content != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.content);
      }
      AppMethodBeat.o(125691);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(125691);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bn localbn = (bn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125691);
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
            localbn.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125691);
          return 0;
        case 2: 
          localbn.cPd = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(125691);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localbn.FMh = ((bm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125691);
          return 0;
        }
        localbn.content = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(125691);
        return 0;
      }
      AppMethodBeat.o(125691);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bn
 * JD-Core Version:    0.7.0.1
 */