package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aof
  extends com.tencent.mm.bw.a
{
  public String LAi;
  public LinkedList<aog> LAj;
  public String desc;
  public String title;
  
  public aof()
  {
    AppMethodBeat.i(91463);
    this.LAj = new LinkedList();
    AppMethodBeat.o(91463);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91464);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.e(1, this.title);
      }
      if (this.LAi != null) {
        paramVarArgs.e(2, this.LAi);
      }
      paramVarArgs.e(3, 8, this.LAj);
      if (this.desc != null) {
        paramVarArgs.e(4, this.desc);
      }
      AppMethodBeat.o(91464);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label478;
      }
    }
    label478:
    for (paramInt = g.a.a.b.b.a.f(1, this.title) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.LAi != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.LAi);
      }
      i += g.a.a.a.c(3, 8, this.LAj);
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.desc);
      }
      AppMethodBeat.o(91464);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.LAj.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91464);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        aof localaof = (aof)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91464);
          return -1;
        case 1: 
          localaof.title = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91464);
          return 0;
        case 2: 
          localaof.LAi = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91464);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aog();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((aog)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localaof.LAj.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91464);
          return 0;
        }
        localaof.desc = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91464);
        return 0;
      }
      AppMethodBeat.o(91464);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aof
 * JD-Core Version:    0.7.0.1
 */