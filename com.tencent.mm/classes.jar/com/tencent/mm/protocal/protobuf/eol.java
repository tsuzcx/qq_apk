package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eol
  extends com.tencent.mm.bw.a
{
  public LinkedList<egi> Nmk;
  public LinkedList<egi> Nml;
  public LinkedList<abz> Nmm;
  public String title;
  
  public eol()
  {
    AppMethodBeat.i(114083);
    this.Nmk = new LinkedList();
    this.Nml = new LinkedList();
    this.Nmm = new LinkedList();
    AppMethodBeat.o(114083);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114084);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.e(1, this.title);
      }
      paramVarArgs.e(2, 8, this.Nmk);
      paramVarArgs.e(3, 8, this.Nml);
      paramVarArgs.e(4, 8, this.Nmm);
      AppMethodBeat.o(114084);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label638;
      }
    }
    label638:
    for (paramInt = g.a.a.b.b.a.f(1, this.title) + 0;; paramInt = 0)
    {
      int i = g.a.a.a.c(2, 8, this.Nmk);
      int j = g.a.a.a.c(3, 8, this.Nml);
      int k = g.a.a.a.c(4, 8, this.Nmm);
      AppMethodBeat.o(114084);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Nmk.clear();
        this.Nml.clear();
        this.Nmm.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(114084);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        eol localeol = (eol)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114084);
          return -1;
        case 1: 
          localeol.title = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114084);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new egi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((egi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeol.Nmk.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114084);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new egi();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((egi)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localeol.Nml.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114084);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new abz();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((abz)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localeol.Nmm.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(114084);
        return 0;
      }
      AppMethodBeat.o(114084);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eol
 * JD-Core Version:    0.7.0.1
 */