package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class mh
  extends com.tencent.mm.bw.a
{
  public LinkedList<mj> DSZ;
  public boolean Ebd;
  public String Title;
  
  public mh()
  {
    AppMethodBeat.i(124411);
    this.DSZ = new LinkedList();
    AppMethodBeat.o(124411);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124412);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Title != null) {
        paramVarArgs.d(1, this.Title);
      }
      paramVarArgs.e(2, 8, this.DSZ);
      paramVarArgs.bl(3, this.Ebd);
      AppMethodBeat.o(124412);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Title == null) {
        break label402;
      }
    }
    label402:
    for (paramInt = f.a.a.b.b.a.e(1, this.Title) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 8, this.DSZ);
      int j = f.a.a.b.b.a.fK(3);
      AppMethodBeat.o(124412);
      return paramInt + i + (j + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.DSZ.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(124412);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        mh localmh = (mh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124412);
          return -1;
        case 1: 
          localmh.Title = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(124412);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new mj();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((mj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localmh.DSZ.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124412);
          return 0;
        }
        localmh.Ebd = ((f.a.a.a.a)localObject1).LVo.fZX();
        AppMethodBeat.o(124412);
        return 0;
      }
      AppMethodBeat.o(124412);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mh
 * JD-Core Version:    0.7.0.1
 */