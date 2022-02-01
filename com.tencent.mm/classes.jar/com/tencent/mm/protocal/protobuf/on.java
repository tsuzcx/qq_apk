package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class on
  extends com.tencent.mm.bw.a
{
  public int FNv;
  public LinkedList<om> Gal;
  public long Gcv;
  public String Title;
  
  public on()
  {
    AppMethodBeat.i(188940);
    this.Gal = new LinkedList();
    AppMethodBeat.o(188940);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(188941);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.FNv);
      if (this.Title != null) {
        paramVarArgs.d(2, this.Title);
      }
      paramVarArgs.e(3, 8, this.Gal);
      paramVarArgs.aZ(4, this.Gcv);
      AppMethodBeat.o(188941);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.FNv) + 0;
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Title);
      }
      i = f.a.a.a.c(3, 8, this.Gal);
      int j = f.a.a.b.b.a.p(4, this.Gcv);
      AppMethodBeat.o(188941);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Gal.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(188941);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      on localon = (on)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(188941);
        return -1;
      case 1: 
        localon.FNv = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(188941);
        return 0;
      case 2: 
        localon.Title = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(188941);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new om();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((om)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localon.Gal.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(188941);
        return 0;
      }
      localon.Gcv = ((f.a.a.a.a)localObject1).OmT.zd();
      AppMethodBeat.o(188941);
      return 0;
    }
    AppMethodBeat.o(188941);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.on
 * JD-Core Version:    0.7.0.1
 */