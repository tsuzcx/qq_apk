package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aat
  extends com.tencent.mm.bw.a
{
  public LinkedList<aas> FNS;
  public long Gsf;
  public long Gsg;
  
  public aat()
  {
    AppMethodBeat.i(184493);
    this.FNS = new LinkedList();
    AppMethodBeat.o(184493);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(184494);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.Gsf);
      paramVarArgs.aZ(2, this.Gsg);
      paramVarArgs.e(3, 8, this.FNS);
      AppMethodBeat.o(184494);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.p(1, this.Gsf);
      i = f.a.a.b.b.a.p(2, this.Gsg);
      int j = f.a.a.a.c(3, 8, this.FNS);
      AppMethodBeat.o(184494);
      return paramInt + 0 + i + j;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FNS.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
        }
      }
      AppMethodBeat.o(184494);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      aat localaat = (aat)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(184494);
        return -1;
      case 1: 
        localaat.Gsf = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(184494);
        return 0;
      case 2: 
        localaat.Gsg = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(184494);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new aas();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((aas)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localaat.FNS.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(184494);
      return 0;
    }
    AppMethodBeat.o(184494);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aat
 * JD-Core Version:    0.7.0.1
 */