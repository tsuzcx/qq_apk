package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class abb
  extends com.tencent.mm.bw.a
{
  public LinkedList<aba> FNS;
  public int GsT;
  public int GsU;
  public long Gsf;
  public long Gsg;
  
  public abb()
  {
    AppMethodBeat.i(90962);
    this.FNS = new LinkedList();
    AppMethodBeat.o(90962);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(90963);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aZ(1, this.Gsf);
      paramVarArgs.aZ(2, this.Gsg);
      paramVarArgs.e(3, 8, this.FNS);
      paramVarArgs.aS(4, this.GsT);
      paramVarArgs.aS(5, this.GsU);
      AppMethodBeat.o(90963);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.p(1, this.Gsf);
      i = f.a.a.b.b.a.p(2, this.Gsg);
      int j = f.a.a.a.c(3, 8, this.FNS);
      int k = f.a.a.b.b.a.bz(4, this.GsT);
      int m = f.a.a.b.b.a.bz(5, this.GsU);
      AppMethodBeat.o(90963);
      return paramInt + 0 + i + j + k + m;
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
      AppMethodBeat.o(90963);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      abb localabb = (abb)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(90963);
        return -1;
      case 1: 
        localabb.Gsf = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(90963);
        return 0;
      case 2: 
        localabb.Gsg = ((f.a.a.a.a)localObject1).OmT.zd();
        AppMethodBeat.o(90963);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aba();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((aba)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localabb.FNS.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(90963);
        return 0;
      case 4: 
        localabb.GsT = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(90963);
        return 0;
      }
      localabb.GsU = ((f.a.a.a.a)localObject1).OmT.zc();
      AppMethodBeat.o(90963);
      return 0;
    }
    AppMethodBeat.o(90963);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abb
 * JD-Core Version:    0.7.0.1
 */