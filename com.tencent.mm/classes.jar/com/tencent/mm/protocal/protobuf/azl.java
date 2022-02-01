package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class azl
  extends com.tencent.mm.bw.a
{
  public azk LJj;
  public String LJk;
  public String LJl;
  public String LJm;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(209613);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LJj != null)
      {
        paramVarArgs.ni(1, this.LJj.computeSize());
        this.LJj.writeFields(paramVarArgs);
      }
      if (this.LJk != null) {
        paramVarArgs.e(2, this.LJk);
      }
      if (this.LJl != null) {
        paramVarArgs.e(3, this.LJl);
      }
      if (this.LJm != null) {
        paramVarArgs.e(4, this.LJm);
      }
      AppMethodBeat.o(209613);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LJj == null) {
        break label490;
      }
    }
    label490:
    for (int i = g.a.a.a.nh(1, this.LJj.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.LJk != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.LJk);
      }
      i = paramInt;
      if (this.LJl != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.LJl);
      }
      paramInt = i;
      if (this.LJm != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.LJm);
      }
      AppMethodBeat.o(209613);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(209613);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        azl localazl = (azl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(209613);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new azk();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((azk)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localazl.LJj = ((azk)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(209613);
          return 0;
        case 2: 
          localazl.LJk = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209613);
          return 0;
        case 3: 
          localazl.LJl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(209613);
          return 0;
        }
        localazl.LJm = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(209613);
        return 0;
      }
      AppMethodBeat.o(209613);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.azl
 * JD-Core Version:    0.7.0.1
 */