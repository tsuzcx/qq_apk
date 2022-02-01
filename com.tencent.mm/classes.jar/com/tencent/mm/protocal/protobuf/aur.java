package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aur
  extends com.tencent.mm.bw.a
{
  public long GLB;
  public LinkedList<bov> GLC;
  public LinkedList<dwx> GLD;
  public String name;
  public long startTime;
  
  public aur()
  {
    AppMethodBeat.i(122499);
    this.startTime = -1L;
    this.GLB = 0L;
    this.GLC = new LinkedList();
    this.GLD = new LinkedList();
    AppMethodBeat.o(122499);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122500);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.name != null) {
        paramVarArgs.d(1, this.name);
      }
      paramVarArgs.aZ(2, this.startTime);
      paramVarArgs.aZ(3, this.GLB);
      paramVarArgs.e(4, 8, this.GLC);
      paramVarArgs.e(5, 8, this.GLD);
      AppMethodBeat.o(122500);
      return 0;
    }
    if (paramInt == 1) {
      if (this.name == null) {
        break label590;
      }
    }
    label590:
    for (paramInt = f.a.a.b.b.a.e(1, this.name) + 0;; paramInt = 0)
    {
      int i = f.a.a.b.b.a.p(2, this.startTime);
      int j = f.a.a.b.b.a.p(3, this.GLB);
      int k = f.a.a.a.c(4, 8, this.GLC);
      int m = f.a.a.a.c(5, 8, this.GLD);
      AppMethodBeat.o(122500);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GLC.clear();
        this.GLD.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(122500);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aur localaur = (aur)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122500);
          return -1;
        case 1: 
          localaur.name = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(122500);
          return 0;
        case 2: 
          localaur.startTime = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(122500);
          return 0;
        case 3: 
          localaur.GLB = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(122500);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new bov();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((bov)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaur.GLC.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122500);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dwx();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dwx)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localaur.GLD.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(122500);
        return 0;
      }
      AppMethodBeat.o(122500);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aur
 * JD-Core Version:    0.7.0.1
 */