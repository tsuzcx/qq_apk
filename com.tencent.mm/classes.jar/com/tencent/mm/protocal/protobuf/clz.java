package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class clz
  extends com.tencent.mm.bw.a
{
  public int GSF;
  public String GSG;
  public String GSH;
  public dqz HxX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32369);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.GSF);
      if (this.GSG != null) {
        paramVarArgs.d(2, this.GSG);
      }
      if (this.GSH != null) {
        paramVarArgs.d(3, this.GSH);
      }
      if (this.HxX != null)
      {
        paramVarArgs.lJ(4, this.HxX.computeSize());
        this.HxX.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32369);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.GSF) + 0;
      paramInt = i;
      if (this.GSG != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GSG);
      }
      i = paramInt;
      if (this.GSH != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GSH);
      }
      paramInt = i;
      if (this.HxX != null) {
        paramInt = i + f.a.a.a.lI(4, this.HxX.computeSize());
      }
      AppMethodBeat.o(32369);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(32369);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      clz localclz = (clz)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32369);
        return -1;
      case 1: 
        localclz.GSF = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(32369);
        return 0;
      case 2: 
        localclz.GSG = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(32369);
        return 0;
      case 3: 
        localclz.GSH = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(32369);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new dqz();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((dqz)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localclz.HxX = ((dqz)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(32369);
      return 0;
    }
    AppMethodBeat.o(32369);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.clz
 * JD-Core Version:    0.7.0.1
 */