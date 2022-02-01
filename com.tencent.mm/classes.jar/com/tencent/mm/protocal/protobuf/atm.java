package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class atm
  extends com.tencent.mm.bw.a
{
  public int GEL;
  public int GEM;
  public arj GJF;
  public int GKn;
  public int GKo;
  public int GKp;
  public int GKq;
  public int count;
  public String hGI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169077);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.count);
      paramVarArgs.aS(2, this.GEL);
      paramVarArgs.aS(3, this.GEM);
      paramVarArgs.aS(4, this.GKn);
      if (this.hGI != null) {
        paramVarArgs.d(5, this.hGI);
      }
      if (this.GJF != null)
      {
        paramVarArgs.lJ(6, this.GJF.computeSize());
        this.GJF.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(7, this.GKo);
      paramVarArgs.aS(8, this.GKp);
      paramVarArgs.aS(9, this.GKq);
      AppMethodBeat.o(169077);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.count) + 0 + f.a.a.b.b.a.bz(2, this.GEL) + f.a.a.b.b.a.bz(3, this.GEM) + f.a.a.b.b.a.bz(4, this.GKn);
      paramInt = i;
      if (this.hGI != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.hGI);
      }
      i = paramInt;
      if (this.GJF != null) {
        i = paramInt + f.a.a.a.lI(6, this.GJF.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(7, this.GKo);
      int j = f.a.a.b.b.a.bz(8, this.GKp);
      int k = f.a.a.b.b.a.bz(9, this.GKq);
      AppMethodBeat.o(169077);
      return i + paramInt + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(169077);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      atm localatm = (atm)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(169077);
        return -1;
      case 1: 
        localatm.count = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(169077);
        return 0;
      case 2: 
        localatm.GEL = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(169077);
        return 0;
      case 3: 
        localatm.GEM = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(169077);
        return 0;
      case 4: 
        localatm.GKn = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(169077);
        return 0;
      case 5: 
        localatm.hGI = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(169077);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new arj();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((arj)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localatm.GJF = ((arj)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(169077);
        return 0;
      case 7: 
        localatm.GKo = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(169077);
        return 0;
      case 8: 
        localatm.GKp = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(169077);
        return 0;
      }
      localatm.GKq = ((f.a.a.a.a)localObject1).OmT.zc();
      AppMethodBeat.o(169077);
      return 0;
    }
    AppMethodBeat.o(169077);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.atm
 * JD-Core Version:    0.7.0.1
 */