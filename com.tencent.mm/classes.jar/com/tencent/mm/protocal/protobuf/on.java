package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class on
  extends com.tencent.mm.bx.a
{
  public LinkedList<ahf> CMg;
  public LinkedList<ahe> CMh;
  public String CMi;
  public String CMj;
  public String CMk;
  
  public on()
  {
    AppMethodBeat.i(91368);
    this.CMg = new LinkedList();
    this.CMh = new LinkedList();
    AppMethodBeat.o(91368);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91369);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.CMg);
      paramVarArgs.e(2, 8, this.CMh);
      if (this.CMi != null) {
        paramVarArgs.d(3, this.CMi);
      }
      if (this.CMj != null) {
        paramVarArgs.d(4, this.CMj);
      }
      if (this.CMk != null) {
        paramVarArgs.d(5, this.CMk);
      }
      AppMethodBeat.o(91369);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 8, this.CMg) + 0 + f.a.a.a.c(2, 8, this.CMh);
      paramInt = i;
      if (this.CMi != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.CMi);
      }
      i = paramInt;
      if (this.CMj != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.CMj);
      }
      paramInt = i;
      if (this.CMk != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.CMk);
      }
      AppMethodBeat.o(91369);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.CMg.clear();
      this.CMh.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(91369);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      on localon = (on)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91369);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ahf();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ahf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localon.CMg.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91369);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ahe();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ahe)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localon.CMh.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91369);
        return 0;
      case 3: 
        localon.CMi = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91369);
        return 0;
      case 4: 
        localon.CMj = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(91369);
        return 0;
      }
      localon.CMk = ((f.a.a.a.a)localObject1).KhF.readString();
      AppMethodBeat.o(91369);
      return 0;
    }
    AppMethodBeat.o(91369);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.on
 * JD-Core Version:    0.7.0.1
 */