package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class elj
  extends com.tencent.mm.bw.a
{
  public cig Nkp;
  public cig Nkq;
  public String content;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72616);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.e(1, this.title);
      }
      if (this.content != null) {
        paramVarArgs.e(2, this.content);
      }
      if (this.Nkp != null)
      {
        paramVarArgs.ni(3, this.Nkp.computeSize());
        this.Nkp.writeFields(paramVarArgs);
      }
      if (this.Nkq != null)
      {
        paramVarArgs.ni(4, this.Nkq.computeSize());
        this.Nkq.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72616);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label586;
      }
    }
    label586:
    for (int i = g.a.a.b.b.a.f(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.content != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.content);
      }
      i = paramInt;
      if (this.Nkp != null) {
        i = paramInt + g.a.a.a.nh(3, this.Nkp.computeSize());
      }
      paramInt = i;
      if (this.Nkq != null) {
        paramInt = i + g.a.a.a.nh(4, this.Nkq.computeSize());
      }
      AppMethodBeat.o(72616);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(72616);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        elj localelj = (elj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72616);
          return -1;
        case 1: 
          localelj.title = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72616);
          return 0;
        case 2: 
          localelj.content = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(72616);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cig();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((cig)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localelj.Nkp = ((cig)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(72616);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cig();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((cig)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localelj.Nkq = ((cig)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72616);
        return 0;
      }
      AppMethodBeat.o(72616);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.elj
 * JD-Core Version:    0.7.0.1
 */