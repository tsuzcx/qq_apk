package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class dkc
  extends com.tencent.mm.bw.a
{
  public String GvK;
  public dkn HRH;
  public LinkedList<Integer> HRU;
  public int HRq;
  public long Id;
  
  public dkc()
  {
    AppMethodBeat.i(118447);
    this.HRU = new LinkedList();
    AppMethodBeat.o(118447);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(118448);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.Id);
      if (this.GvK != null) {
        paramVarArgs.d(2, this.GvK);
      }
      if (this.HRH != null)
      {
        paramVarArgs.lJ(3, this.HRH.computeSize());
        this.HRH.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(4, this.HRq);
      paramVarArgs.f(5, 2, this.HRU);
      AppMethodBeat.o(118448);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.Id) + 0;
      paramInt = i;
      if (this.GvK != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GvK);
      }
      i = paramInt;
      if (this.HRH != null) {
        i = paramInt + f.a.a.a.lI(3, this.HRH.computeSize());
      }
      paramInt = f.a.a.b.b.a.bz(4, this.HRq);
      int j = f.a.a.a.d(5, 2, this.HRU);
      AppMethodBeat.o(118448);
      return i + paramInt + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.HRU.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(118448);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dkc localdkc = (dkc)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(118448);
        return -1;
      case 1: 
        localdkc.Id = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(118448);
        return 0;
      case 2: 
        localdkc.GvK = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(118448);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dkn();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dkn)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdkc.HRH = ((dkn)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(118448);
        return 0;
      case 4: 
        localdkc.HRq = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(118448);
        return 0;
      }
      localdkc.HRU = new f.a.a.a.a(((f.a.a.a.a)localObject1).OmT.gCk().zr, unknownTagHandler).OmT.gCi();
      AppMethodBeat.o(118448);
      return 0;
    }
    AppMethodBeat.o(118448);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dkc
 * JD-Core Version:    0.7.0.1
 */