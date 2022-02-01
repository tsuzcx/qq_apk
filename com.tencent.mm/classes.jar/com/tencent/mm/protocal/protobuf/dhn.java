package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dhn
  extends com.tencent.mm.bw.a
{
  public long HOG;
  public int nID;
  public LinkedList<cxn> nIE;
  public String uum;
  
  public dhn()
  {
    AppMethodBeat.i(125816);
    this.nIE = new LinkedList();
    AppMethodBeat.o(125816);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125817);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.HOG);
      if (this.uum != null) {
        paramVarArgs.d(2, this.uum);
      }
      paramVarArgs.aS(3, this.nID);
      paramVarArgs.e(4, 8, this.nIE);
      AppMethodBeat.o(125817);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.HOG) + 0;
      paramInt = i;
      if (this.uum != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.uum);
      }
      i = f.a.a.b.b.a.bz(3, this.nID);
      int j = f.a.a.a.c(4, 8, this.nIE);
      AppMethodBeat.o(125817);
      return paramInt + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.nIE.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(125817);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dhn localdhn = (dhn)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(125817);
        return -1;
      case 1: 
        localdhn.HOG = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(125817);
        return 0;
      case 2: 
        localdhn.uum = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(125817);
        return 0;
      case 3: 
        localdhn.nID = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(125817);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new cxn();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((cxn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localdhn.nIE.add(localObject1);
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
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhn
 * JD-Core Version:    0.7.0.1
 */