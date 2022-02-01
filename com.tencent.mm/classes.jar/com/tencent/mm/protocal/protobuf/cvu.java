package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cvu
  extends com.tencent.mm.bx.a
{
  public long Enw;
  public int mAK;
  public LinkedList<cmf> mAL;
  public String scP;
  
  public cvu()
  {
    AppMethodBeat.i(125816);
    this.mAL = new LinkedList();
    AppMethodBeat.o(125816);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125817);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aG(1, this.Enw);
      if (this.scP != null) {
        paramVarArgs.d(2, this.scP);
      }
      paramVarArgs.aR(3, this.mAK);
      paramVarArgs.e(4, 8, this.mAL);
      AppMethodBeat.o(125817);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.q(1, this.Enw) + 0;
      paramInt = i;
      if (this.scP != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.scP);
      }
      i = f.a.a.b.b.a.bA(3, this.mAK);
      int j = f.a.a.a.c(4, 8, this.mAL);
      AppMethodBeat.o(125817);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.mAL.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(125817);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      cvu localcvu = (cvu)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(125817);
        return -1;
      case 1: 
        localcvu.Enw = ((f.a.a.a.a)localObject1).KhF.xT();
        AppMethodBeat.o(125817);
        return 0;
      case 2: 
        localcvu.scP = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(125817);
        return 0;
      case 3: 
        localcvu.mAK = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(125817);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new cmf();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((cmf)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localcvu.mAL.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(125817);
      return 0;
    }
    AppMethodBeat.o(125817);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvu
 * JD-Core Version:    0.7.0.1
 */