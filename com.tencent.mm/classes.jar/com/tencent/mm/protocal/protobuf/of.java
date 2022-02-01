package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class of
  extends cvw
{
  public int FTU;
  public b FXp;
  public String FXs;
  public int GbS;
  public int doj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118407);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.FXp != null) {
        paramVarArgs.c(2, this.FXp);
      }
      paramVarArgs.aS(3, this.doj);
      paramVarArgs.aS(4, this.GbS);
      if (this.FXs != null) {
        paramVarArgs.d(5, this.FXs);
      }
      paramVarArgs.aS(6, this.FTU);
      AppMethodBeat.o(118407);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label562;
      }
    }
    label562:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.FXp != null) {
        i = paramInt + f.a.a.b.b.a.b(2, this.FXp);
      }
      i = i + f.a.a.b.b.a.bz(3, this.doj) + f.a.a.b.b.a.bz(4, this.GbS);
      paramInt = i;
      if (this.FXs != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FXs);
      }
      i = f.a.a.b.b.a.bz(6, this.FTU);
      AppMethodBeat.o(118407);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(118407);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        of localof = (of)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(118407);
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
            localof.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(118407);
          return 0;
        case 2: 
          localof.FXp = ((f.a.a.a.a)localObject1).OmT.gCk();
          AppMethodBeat.o(118407);
          return 0;
        case 3: 
          localof.doj = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(118407);
          return 0;
        case 4: 
          localof.GbS = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(118407);
          return 0;
        case 5: 
          localof.FXs = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(118407);
          return 0;
        }
        localof.FTU = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(118407);
        return 0;
      }
      AppMethodBeat.o(118407);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.of
 * JD-Core Version:    0.7.0.1
 */