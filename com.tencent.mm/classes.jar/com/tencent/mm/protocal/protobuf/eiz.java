package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eiz
  extends com.tencent.mm.bw.a
{
  public eiy Imi;
  public xi Imj;
  public int drN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(200344);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Imi != null)
      {
        paramVarArgs.lJ(1, this.Imi.computeSize());
        this.Imi.writeFields(paramVarArgs);
      }
      if (this.Imj != null)
      {
        paramVarArgs.lJ(2, this.Imj.computeSize());
        this.Imj.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.drN);
      AppMethodBeat.o(200344);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Imi == null) {
        break label510;
      }
    }
    label510:
    for (paramInt = f.a.a.a.lI(1, this.Imi.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Imj != null) {
        i = paramInt + f.a.a.a.lI(2, this.Imj.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(3, this.drN);
      AppMethodBeat.o(200344);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(200344);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        eiz localeiz = (eiz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(200344);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eiy();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eiy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localeiz.Imi = ((eiy)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(200344);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new xi();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((xi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localeiz.Imj = ((xi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(200344);
          return 0;
        }
        localeiz.drN = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(200344);
        return 0;
      }
      AppMethodBeat.o(200344);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eiz
 * JD-Core Version:    0.7.0.1
 */