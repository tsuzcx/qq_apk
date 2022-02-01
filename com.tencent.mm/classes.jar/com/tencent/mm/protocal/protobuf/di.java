package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class di
  extends com.tencent.mm.bw.a
{
  public LinkedList<cvt> KHx;
  public String desc;
  public String jHa;
  
  public di()
  {
    AppMethodBeat.i(152483);
    this.KHx = new LinkedList();
    AppMethodBeat.o(152483);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152484);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.jHa != null) {
        paramVarArgs.e(1, this.jHa);
      }
      paramVarArgs.e(2, 8, this.KHx);
      if (this.desc != null) {
        paramVarArgs.e(3, this.desc);
      }
      AppMethodBeat.o(152484);
      return 0;
    }
    if (paramInt == 1) {
      if (this.jHa == null) {
        break label418;
      }
    }
    label418:
    for (paramInt = g.a.a.b.b.a.f(1, this.jHa) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.a.c(2, 8, this.KHx);
      paramInt = i;
      if (this.desc != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.desc);
      }
      AppMethodBeat.o(152484);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.KHx.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(152484);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        di localdi = (di)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152484);
          return -1;
        case 1: 
          localdi.jHa = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152484);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new cvt();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((cvt)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localdi.KHx.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152484);
          return 0;
        }
        localdi.desc = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(152484);
        return 0;
      }
      AppMethodBeat.o(152484);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.di
 * JD-Core Version:    0.7.0.1
 */