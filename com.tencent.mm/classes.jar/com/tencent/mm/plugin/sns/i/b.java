package com.tencent.mm.plugin.sns.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bzh;
import java.util.LinkedList;

public final class b
  extends com.tencent.mm.bw.a
{
  public bzh dKe;
  public int icw;
  public String parentId;
  public int zHI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96151);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dKe != null)
      {
        paramVarArgs.lJ(1, this.dKe.computeSize());
        this.dKe.writeFields(paramVarArgs);
      }
      if (this.parentId != null) {
        paramVarArgs.d(2, this.parentId);
      }
      paramVarArgs.aS(3, this.icw);
      paramVarArgs.aS(4, this.zHI);
      AppMethodBeat.o(96151);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dKe == null) {
        break label462;
      }
    }
    label462:
    for (paramInt = f.a.a.a.lI(1, this.dKe.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.parentId != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.parentId);
      }
      paramInt = f.a.a.b.b.a.bz(3, this.icw);
      int j = f.a.a.b.b.a.bz(4, this.zHI);
      AppMethodBeat.o(96151);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(96151);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        b localb = (b)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(96151);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bzh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((bzh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localb.dKe = ((bzh)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(96151);
          return 0;
        case 2: 
          localb.parentId = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(96151);
          return 0;
        case 3: 
          localb.icw = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(96151);
          return 0;
        }
        localb.zHI = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(96151);
        return 0;
      }
      AppMethodBeat.o(96151);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.i.b
 * JD-Core Version:    0.7.0.1
 */