package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dxm
  extends com.tencent.mm.bw.a
{
  public LinkedList<dwi> ENR;
  public boolean ERy;
  public int EfV;
  
  public dxm()
  {
    AppMethodBeat.i(32554);
    this.ENR = new LinkedList();
    AppMethodBeat.o(32554);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32555);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.ENR);
      paramVarArgs.aR(2, this.EfV);
      paramVarArgs.bl(3, this.ERy);
      AppMethodBeat.o(32555);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.a.c(1, 8, this.ENR);
      i = f.a.a.b.b.a.bx(2, this.EfV);
      int j = f.a.a.b.b.a.fK(3);
      AppMethodBeat.o(32555);
      return paramInt + 0 + i + (j + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ENR.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
        }
      }
      AppMethodBeat.o(32555);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dxm localdxm = (dxm)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32555);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dwi();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dwi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdxm.ENR.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32555);
        return 0;
      case 2: 
        localdxm.EfV = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(32555);
        return 0;
      }
      localdxm.ERy = ((f.a.a.a.a)localObject1).LVo.fZX();
      AppMethodBeat.o(32555);
      return 0;
    }
    AppMethodBeat.o(32555);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dxm
 * JD-Core Version:    0.7.0.1
 */