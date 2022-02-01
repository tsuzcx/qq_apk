package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cjc
  extends com.tencent.mm.bw.a
{
  public cjd Mot;
  public ciz Mou;
  public cja Mov;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(196383);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Mot != null)
      {
        paramVarArgs.ni(1, this.Mot.computeSize());
        this.Mot.writeFields(paramVarArgs);
      }
      if (this.Mou != null)
      {
        paramVarArgs.ni(2, this.Mou.computeSize());
        this.Mou.writeFields(paramVarArgs);
      }
      if (this.Mov != null)
      {
        paramVarArgs.ni(3, this.Mov.computeSize());
        this.Mov.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(196383);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Mot == null) {
        break label618;
      }
    }
    label618:
    for (int i = g.a.a.a.nh(1, this.Mot.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Mou != null) {
        paramInt = i + g.a.a.a.nh(2, this.Mou.computeSize());
      }
      i = paramInt;
      if (this.Mov != null) {
        i = paramInt + g.a.a.a.nh(3, this.Mov.computeSize());
      }
      AppMethodBeat.o(196383);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(196383);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cjc localcjc = (cjc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(196383);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cjd();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cjd)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcjc.Mot = ((cjd)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(196383);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ciz();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((ciz)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcjc.Mou = ((ciz)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(196383);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cja();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cja)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcjc.Mov = ((cja)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(196383);
        return 0;
      }
      AppMethodBeat.o(196383);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cjc
 * JD-Core Version:    0.7.0.1
 */