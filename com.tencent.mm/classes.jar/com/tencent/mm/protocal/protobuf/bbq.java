package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bbq
  extends cvw
{
  public int GRw;
  public LinkedList<ahz> GRy;
  public int Scene;
  
  public bbq()
  {
    AppMethodBeat.i(122503);
    this.GRy = new LinkedList();
    AppMethodBeat.o(122503);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122504);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.GRw);
      paramVarArgs.aS(3, this.Scene);
      paramVarArgs.e(4, 8, this.GRy);
      AppMethodBeat.o(122504);
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
      int i = f.a.a.b.b.a.bz(2, this.GRw);
      int j = f.a.a.b.b.a.bz(3, this.Scene);
      int k = f.a.a.a.c(4, 8, this.GRy);
      AppMethodBeat.o(122504);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GRy.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(122504);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bbq localbbq = (bbq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122504);
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
            localbbq.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122504);
          return 0;
        case 2: 
          localbbq.GRw = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(122504);
          return 0;
        case 3: 
          localbbq.Scene = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(122504);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ahz();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ahz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbbq.GRy.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122504);
        return 0;
      }
      AppMethodBeat.o(122504);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bbq
 * JD-Core Version:    0.7.0.1
 */