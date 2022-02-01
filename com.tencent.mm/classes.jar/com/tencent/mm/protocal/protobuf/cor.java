package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cor
  extends cvw
{
  public int GuE;
  public String HqI;
  public int HqJ;
  public LinkedList<String> HqK;
  
  public cor()
  {
    AppMethodBeat.i(82464);
    this.HqK = new LinkedList();
    AppMethodBeat.o(82464);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82465);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.HqI != null) {
        paramVarArgs.d(2, this.HqI);
      }
      paramVarArgs.aS(3, this.HqJ);
      paramVarArgs.e(4, 1, this.HqK);
      paramVarArgs.aS(5, this.GuE);
      AppMethodBeat.o(82465);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label522;
      }
    }
    label522:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HqI != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.HqI);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.HqJ);
      int j = f.a.a.a.c(4, 1, this.HqK);
      int k = f.a.a.b.b.a.bz(5, this.GuE);
      AppMethodBeat.o(82465);
      return i + paramInt + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HqK.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(82465);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cor localcor = (cor)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82465);
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
            localcor.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(82465);
          return 0;
        case 2: 
          localcor.HqI = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(82465);
          return 0;
        case 3: 
          localcor.HqJ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(82465);
          return 0;
        case 4: 
          localcor.HqK.add(((f.a.a.a.a)localObject1).OmT.readString());
          AppMethodBeat.o(82465);
          return 0;
        }
        localcor.GuE = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(82465);
        return 0;
      }
      AppMethodBeat.o(82465);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cor
 * JD-Core Version:    0.7.0.1
 */