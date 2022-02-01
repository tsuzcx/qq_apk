package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class acv
  extends com.tencent.mm.bx.a
{
  public dtr Ddv;
  public String Ddw;
  public long begin_time;
  public long duration;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110893);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Ddv != null)
      {
        paramVarArgs.kX(1, this.Ddv.computeSize());
        this.Ddv.writeFields(paramVarArgs);
      }
      paramVarArgs.aG(2, this.begin_time);
      paramVarArgs.aG(3, this.duration);
      if (this.Ddw != null) {
        paramVarArgs.d(4, this.Ddw);
      }
      AppMethodBeat.o(110893);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Ddv == null) {
        break label458;
      }
    }
    label458:
    for (paramInt = f.a.a.a.kW(1, this.Ddv.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.q(2, this.begin_time) + f.a.a.b.b.a.q(3, this.duration);
      paramInt = i;
      if (this.Ddw != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.Ddw);
      }
      AppMethodBeat.o(110893);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        AppMethodBeat.o(110893);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        acv localacv = (acv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(110893);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dtr();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dtr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localacv.Ddv = ((dtr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(110893);
          return 0;
        case 2: 
          localacv.begin_time = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(110893);
          return 0;
        case 3: 
          localacv.duration = ((f.a.a.a.a)localObject1).KhF.xT();
          AppMethodBeat.o(110893);
          return 0;
        }
        localacv.Ddw = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(110893);
        return 0;
      }
      AppMethodBeat.o(110893);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.acv
 * JD-Core Version:    0.7.0.1
 */