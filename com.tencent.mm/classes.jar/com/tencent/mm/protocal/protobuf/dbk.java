package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dbk
  extends cvw
{
  public int HKj;
  public LinkedList<eca> HKk;
  public int HKl;
  public int HnP;
  
  public dbk()
  {
    AppMethodBeat.i(32431);
    this.HKk = new LinkedList();
    AppMethodBeat.o(32431);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32432);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.lJ(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.HnP);
      paramVarArgs.aS(3, this.HKj);
      paramVarArgs.e(4, 8, this.HKk);
      paramVarArgs.aS(5, this.HKl);
      AppMethodBeat.o(32432);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label601;
      }
    }
    label601:
    for (paramInt = f.a.a.a.lI(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.bz(2, this.HnP);
      int j = f.a.a.b.b.a.bz(3, this.HKj);
      int k = f.a.a.a.c(4, 8, this.HKk);
      int m = f.a.a.b.b.a.bz(5, this.HKl);
      AppMethodBeat.o(32432);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HKk.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = cvw.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = cvw.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(32432);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dbk localdbk = (dbk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32432);
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
            localdbk.BaseRequest = ((jc)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32432);
          return 0;
        case 2: 
          localdbk.HnP = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32432);
          return 0;
        case 3: 
          localdbk.HKj = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32432);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eca();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eca)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, cvw.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdbk.HKk.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32432);
          return 0;
        }
        localdbk.HKl = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(32432);
        return 0;
      }
      AppMethodBeat.o(32432);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbk
 * JD-Core Version:    0.7.0.1
 */