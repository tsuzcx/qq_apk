package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bah
  extends com.tencent.mm.bw.a
{
  public String ERk;
  public dqy ERl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115839);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ERk != null) {
        paramVarArgs.d(1, this.ERk);
      }
      if (this.ERl != null)
      {
        paramVarArgs.ln(2, this.ERl.computeSize());
        this.ERl.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(115839);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ERk == null) {
        break label370;
      }
    }
    label370:
    for (paramInt = f.a.a.b.b.a.e(1, this.ERk) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ERl != null) {
        i = paramInt + f.a.a.a.lm(2, this.ERl.computeSize());
      }
      AppMethodBeat.o(115839);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(115839);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        bah localbah = (bah)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(115839);
          return -1;
        case 1: 
          localbah.ERk = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(115839);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dqy();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dqy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbah.ERl = ((dqy)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(115839);
        return 0;
      }
      AppMethodBeat.o(115839);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bah
 * JD-Core Version:    0.7.0.1
 */