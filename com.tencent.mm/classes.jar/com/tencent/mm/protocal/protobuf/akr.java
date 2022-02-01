package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class akr
  extends com.tencent.mm.bw.a
{
  public String FZl;
  public LinkedList<akl> GCj;
  public akl GCk;
  public int gvx;
  
  public akr()
  {
    AppMethodBeat.i(127478);
    this.GCj = new LinkedList();
    AppMethodBeat.o(127478);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(127479);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.gvx);
      if (this.FZl != null) {
        paramVarArgs.d(2, this.FZl);
      }
      paramVarArgs.e(3, 8, this.GCj);
      if (this.GCk != null)
      {
        paramVarArgs.lJ(4, this.GCk.computeSize());
        this.GCk.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(127479);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.gvx) + 0;
      paramInt = i;
      if (this.FZl != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.FZl);
      }
      i = paramInt + f.a.a.a.c(3, 8, this.GCj);
      paramInt = i;
      if (this.GCk != null) {
        paramInt = i + f.a.a.a.lI(4, this.GCk.computeSize());
      }
      AppMethodBeat.o(127479);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.GCj.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(127479);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      akr localakr = (akr)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(127479);
        return -1;
      case 1: 
        localakr.gvx = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(127479);
        return 0;
      case 2: 
        localakr.FZl = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(127479);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new akl();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((akl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localakr.GCj.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(127479);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new akl();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((akl)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localakr.GCk = ((akl)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(127479);
      return 0;
    }
    AppMethodBeat.o(127479);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akr
 * JD-Core Version:    0.7.0.1
 */