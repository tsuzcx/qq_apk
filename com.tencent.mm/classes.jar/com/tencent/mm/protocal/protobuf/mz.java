package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class mz
  extends com.tencent.mm.bw.a
{
  public String FXj;
  public LinkedList<my> FZj;
  public int FZk;
  
  public mz()
  {
    AppMethodBeat.i(124413);
    this.FZj = new LinkedList();
    AppMethodBeat.o(124413);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124414);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.FZj);
      paramVarArgs.aS(2, this.FZk);
      if (this.FXj != null) {
        paramVarArgs.d(3, this.FXj);
      }
      AppMethodBeat.o(124414);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 8, this.FZj) + 0 + f.a.a.b.b.a.bz(2, this.FZk);
      paramInt = i;
      if (this.FXj != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.FXj);
      }
      AppMethodBeat.o(124414);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FZj.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(124414);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      mz localmz = (mz)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(124414);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new my();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((my)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localmz.FZj.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(124414);
        return 0;
      case 2: 
        localmz.FZk = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(124414);
        return 0;
      }
      localmz.FXj = ((f.a.a.a.a)localObject1).OmT.readString();
      AppMethodBeat.o(124414);
      return 0;
    }
    AppMethodBeat.o(124414);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.mz
 * JD-Core Version:    0.7.0.1
 */