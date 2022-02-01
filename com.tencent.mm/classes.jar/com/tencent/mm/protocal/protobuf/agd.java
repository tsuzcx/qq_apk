package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class agd
  extends com.tencent.mm.bx.a
{
  public efk Gee;
  public String Gef;
  public long begin_time;
  public long duration;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110893);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Gee != null)
      {
        paramVarArgs.lC(1, this.Gee.computeSize());
        this.Gee.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(2, this.begin_time);
      paramVarArgs.aY(3, this.duration);
      if (this.Gef != null) {
        paramVarArgs.d(4, this.Gef);
      }
      AppMethodBeat.o(110893);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Gee == null) {
        break label458;
      }
    }
    label458:
    for (paramInt = f.a.a.a.lB(1, this.Gee.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.begin_time) + f.a.a.b.b.a.p(3, this.duration);
      paramInt = i;
      if (this.Gef != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Gef);
      }
      AppMethodBeat.o(110893);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(110893);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        agd localagd = (agd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(110893);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new efk();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((efk)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localagd.Gee = ((efk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(110893);
          return 0;
        case 2: 
          localagd.begin_time = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(110893);
          return 0;
        case 3: 
          localagd.duration = ((f.a.a.a.a)localObject1).NPN.zd();
          AppMethodBeat.o(110893);
          return 0;
        }
        localagd.Gef = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(110893);
        return 0;
      }
      AppMethodBeat.o(110893);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agd
 * JD-Core Version:    0.7.0.1
 */