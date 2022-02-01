package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cy
  extends com.tencent.mm.bw.a
{
  public LinkedList<cab> DQg;
  public String desc;
  public String ioe;
  
  public cy()
  {
    AppMethodBeat.i(152483);
    this.DQg = new LinkedList();
    AppMethodBeat.o(152483);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152484);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.ioe != null) {
        paramVarArgs.d(1, this.ioe);
      }
      paramVarArgs.e(2, 8, this.DQg);
      if (this.desc != null) {
        paramVarArgs.d(3, this.desc);
      }
      AppMethodBeat.o(152484);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ioe == null) {
        break label418;
      }
    }
    label418:
    for (paramInt = f.a.a.b.b.a.e(1, this.ioe) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.DQg);
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.desc);
      }
      AppMethodBeat.o(152484);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DQg.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(152484);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        cy localcy = (cy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152484);
          return -1;
        case 1: 
          localcy.ioe = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(152484);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cab();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cab)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localcy.DQg.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152484);
          return 0;
        }
        localcy.desc = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(152484);
        return 0;
      }
      AppMethodBeat.o(152484);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cy
 * JD-Core Version:    0.7.0.1
 */