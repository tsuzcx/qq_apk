package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dum
  extends com.tencent.mm.bw.a
{
  public LinkedList<dmt> Iad;
  public LinkedList<dmt> Iae;
  public LinkedList<aai> Iaf;
  public String title;
  
  public dum()
  {
    AppMethodBeat.i(114083);
    this.Iad = new LinkedList();
    this.Iae = new LinkedList();
    this.Iaf = new LinkedList();
    AppMethodBeat.o(114083);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114084);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.d(1, this.title);
      }
      paramVarArgs.e(2, 8, this.Iad);
      paramVarArgs.e(3, 8, this.Iae);
      paramVarArgs.e(4, 8, this.Iaf);
      AppMethodBeat.o(114084);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label638;
      }
    }
    label638:
    for (paramInt = f.a.a.b.b.a.e(1, this.title) + 0;; paramInt = 0)
    {
      int i = f.a.a.a.c(2, 8, this.Iad);
      int j = f.a.a.a.c(3, 8, this.Iae);
      int k = f.a.a.a.c(4, 8, this.Iaf);
      AppMethodBeat.o(114084);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Iad.clear();
        this.Iae.clear();
        this.Iaf.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(114084);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dum localdum = (dum)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114084);
          return -1;
        case 1: 
          localdum.title = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(114084);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dmt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dmt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdum.Iad.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114084);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dmt();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dmt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdum.Iae.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114084);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aai();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aai)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdum.Iaf.add(localObject1);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dum
 * JD-Core Version:    0.7.0.1
 */