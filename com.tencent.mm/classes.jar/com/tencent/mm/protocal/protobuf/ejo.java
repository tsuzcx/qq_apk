package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ejo
  extends com.tencent.mm.bw.a
{
  public String Imu;
  public LinkedList<ejn> Imv;
  
  public ejo()
  {
    AppMethodBeat.i(153335);
    this.Imv = new LinkedList();
    AppMethodBeat.o(153335);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153336);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Imu != null) {
        paramVarArgs.d(1, this.Imu);
      }
      paramVarArgs.e(2, 8, this.Imv);
      AppMethodBeat.o(153336);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Imu == null) {
        break label358;
      }
    }
    label358:
    for (paramInt = f.a.a.b.b.a.e(1, this.Imu) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 8, this.Imv);
      AppMethodBeat.o(153336);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Imv.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(153336);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ejo localejo = (ejo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153336);
          return -1;
        case 1: 
          localejo.Imu = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(153336);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ejn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ejn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localejo.Imv.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(153336);
        return 0;
      }
      AppMethodBeat.o(153336);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ejo
 * JD-Core Version:    0.7.0.1
 */