package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class vg
  extends com.tencent.mm.bw.a
{
  public b LfA;
  public LinkedList<eoj> Lfy;
  public b Lfz;
  
  public vg()
  {
    AppMethodBeat.i(117854);
    this.Lfy = new LinkedList();
    AppMethodBeat.o(117854);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117855);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.Lfy);
      if (this.Lfz != null) {
        paramVarArgs.c(2, this.Lfz);
      }
      if (this.LfA != null) {
        paramVarArgs.c(3, this.LfA);
      }
      AppMethodBeat.o(117855);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 8, this.Lfy) + 0;
      paramInt = i;
      if (this.Lfz != null) {
        paramInt = i + g.a.a.b.b.a.b(2, this.Lfz);
      }
      i = paramInt;
      if (this.LfA != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.LfA);
      }
      AppMethodBeat.o(117855);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Lfy.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(117855);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      vg localvg = (vg)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117855);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new eoj();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((eoj)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localvg.Lfy.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117855);
        return 0;
      case 2: 
        localvg.Lfz = ((g.a.a.a.a)localObject1).UbS.hPo();
        AppMethodBeat.o(117855);
        return 0;
      }
      localvg.LfA = ((g.a.a.a.a)localObject1).UbS.hPo();
      AppMethodBeat.o(117855);
      return 0;
    }
    AppMethodBeat.o(117855);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vg
 * JD-Core Version:    0.7.0.1
 */