package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dxc
  extends com.tencent.mm.bw.a
{
  public boolean ERy;
  public LinkedList<dxa> EUr;
  public boolean GdL;
  
  public dxc()
  {
    AppMethodBeat.i(32541);
    this.EUr = new LinkedList();
    AppMethodBeat.o(32541);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32542);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bl(1, this.ERy);
      paramVarArgs.e(2, 8, this.EUr);
      paramVarArgs.bl(3, this.GdL);
      AppMethodBeat.o(32542);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.fK(1);
      i = f.a.a.a.c(2, 8, this.EUr);
      int j = f.a.a.b.b.a.fK(3);
      AppMethodBeat.o(32542);
      return paramInt + 1 + 0 + i + (j + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.EUr.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(32542);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dxc localdxc = (dxc)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32542);
        return -1;
      case 1: 
        localdxc.ERy = ((f.a.a.a.a)localObject1).LVo.fZX();
        AppMethodBeat.o(32542);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dxa();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dxa)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdxc.EUr.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32542);
        return 0;
      }
      localdxc.GdL = ((f.a.a.a.a)localObject1).LVo.fZX();
      AppMethodBeat.o(32542);
      return 0;
    }
    AppMethodBeat.o(32542);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxc
 * JD-Core Version:    0.7.0.1
 */