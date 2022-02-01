package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class akn
  extends com.tencent.mm.bw.a
{
  public LinkedList<ako> iAd;
  public String key;
  public String title;
  
  public akn()
  {
    AppMethodBeat.i(215273);
    this.iAd = new LinkedList();
    AppMethodBeat.o(215273);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(215274);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.iAd);
      if (this.key != null) {
        paramVarArgs.e(2, this.key);
      }
      if (this.title != null) {
        paramVarArgs.e(3, this.title);
      }
      AppMethodBeat.o(215274);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 8, this.iAd) + 0;
      paramInt = i;
      if (this.key != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.key);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.title);
      }
      AppMethodBeat.o(215274);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.iAd.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(215274);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      akn localakn = (akn)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(215274);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ako();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ako)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localakn.iAd.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(215274);
        return 0;
      case 2: 
        localakn.key = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(215274);
        return 0;
      }
      localakn.title = ((g.a.a.a.a)localObject1).UbS.readString();
      AppMethodBeat.o(215274);
      return 0;
    }
    AppMethodBeat.o(215274);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akn
 * JD-Core Version:    0.7.0.1
 */