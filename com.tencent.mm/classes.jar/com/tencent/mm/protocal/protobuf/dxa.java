package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dxa
  extends com.tencent.mm.bw.a
{
  public chy HHT;
  public byt Icu;
  public int Icv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91725);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HHT != null)
      {
        paramVarArgs.lJ(1, this.HHT.computeSize());
        this.HHT.writeFields(paramVarArgs);
      }
      if (this.Icu != null)
      {
        paramVarArgs.lJ(2, this.Icu.computeSize());
        this.Icu.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(3, this.Icv);
      AppMethodBeat.o(91725);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HHT == null) {
        break label510;
      }
    }
    label510:
    for (paramInt = f.a.a.a.lI(1, this.HHT.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Icu != null) {
        i = paramInt + f.a.a.a.lI(2, this.Icu.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(3, this.Icv);
      AppMethodBeat.o(91725);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91725);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dxa localdxa = (dxa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91725);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new chy();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((chy)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdxa.HHT = ((chy)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91725);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new byt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((byt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdxa.Icu = ((byt)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91725);
          return 0;
        }
        localdxa.Icv = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(91725);
        return 0;
      }
      AppMethodBeat.o(91725);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxa
 * JD-Core Version:    0.7.0.1
 */