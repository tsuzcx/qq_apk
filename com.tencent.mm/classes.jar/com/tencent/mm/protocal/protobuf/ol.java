package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ol
  extends com.tencent.mm.bx.a
{
  public LinkedList<ok> FHP;
  public long FJW;
  public int FuX;
  public String Title;
  
  public ol()
  {
    AppMethodBeat.i(207240);
    this.FHP = new LinkedList();
    AppMethodBeat.o(207240);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(207241);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.FuX);
      if (this.Title != null) {
        paramVarArgs.d(2, this.Title);
      }
      paramVarArgs.e(3, 8, this.FHP);
      paramVarArgs.aY(4, this.FJW);
      AppMethodBeat.o(207241);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.FuX) + 0;
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Title);
      }
      i = f.a.a.a.c(3, 8, this.FHP);
      int j = f.a.a.b.b.a.p(4, this.FJW);
      AppMethodBeat.o(207241);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FHP.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(207241);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      ol localol = (ol)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(207241);
        return -1;
      case 1: 
        localol.FuX = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(207241);
        return 0;
      case 2: 
        localol.Title = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(207241);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ok();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ok)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localol.FHP.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(207241);
        return 0;
      }
      localol.FJW = ((f.a.a.a.a)localObject1).NPN.zd();
      AppMethodBeat.o(207241);
      return 0;
    }
    AppMethodBeat.o(207241);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ol
 * JD-Core Version:    0.7.0.1
 */