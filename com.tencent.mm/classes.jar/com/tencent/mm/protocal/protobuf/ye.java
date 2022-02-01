package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ye
  extends cvw
{
  public LinkedList<Integer> Gqg;
  public LinkedList<yd> Gqh;
  public int Scene;
  public String oxI;
  
  public ye()
  {
    AppMethodBeat.i(6403);
    this.Gqg = new LinkedList();
    this.Gqh = new LinkedList();
    AppMethodBeat.o(6403);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6404);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 2, this.Gqg);
      paramVarArgs.aS(3, this.Scene);
      if (this.oxI != null) {
        paramVarArgs.d(4, this.oxI);
      }
      paramVarArgs.e(5, 8, this.Gqh);
      AppMethodBeat.o(6404);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label624;
      }
    }
    label624:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 2, this.Gqg) + f.a.a.b.b.a.bz(3, this.Scene);
      paramInt = i;
      if (this.oxI != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.oxI);
      }
      i = f.a.a.a.c(5, 8, this.Gqh);
      AppMethodBeat.o(6404);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Gqg.clear();
        this.Gqh.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(6404);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ye localye = (ye)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(6404);
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
            localye.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(6404);
          return 0;
        case 2: 
          localye.Gqg.add(Integer.valueOf(((f.a.a.a.a)localObject1).OmT.zc()));
          AppMethodBeat.o(6404);
          return 0;
        case 3: 
          localye.Scene = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(6404);
          return 0;
        case 4: 
          localye.oxI = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(6404);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new yd();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((yd)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localye.Gqh.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(6404);
        return 0;
      }
      AppMethodBeat.o(6404);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ye
 * JD-Core Version:    0.7.0.1
 */