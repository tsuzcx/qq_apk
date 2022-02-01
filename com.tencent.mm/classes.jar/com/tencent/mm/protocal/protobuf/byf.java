package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class byf
  extends com.tencent.mm.bx.a
{
  public long GQY;
  public LinkedList<b> GSq;
  public bpm GSr;
  public long GSs;
  public long dle;
  public long id;
  
  public byf()
  {
    AppMethodBeat.i(110903);
    this.GSq = new LinkedList();
    AppMethodBeat.o(110903);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110904);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.id);
      paramVarArgs.e(2, 6, this.GSq);
      if (this.GSr != null)
      {
        paramVarArgs.lC(3, this.GSr.computeSize());
        this.GSr.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(4, this.dle);
      paramVarArgs.aY(5, this.GQY);
      paramVarArgs.aY(6, this.GSs);
      AppMethodBeat.o(110904);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.id) + 0 + f.a.a.a.c(2, 6, this.GSq);
      paramInt = i;
      if (this.GSr != null) {
        paramInt = i + f.a.a.a.lB(3, this.GSr.computeSize());
      }
      i = f.a.a.b.b.a.p(4, this.dle);
      int j = f.a.a.b.b.a.p(5, this.GQY);
      int k = f.a.a.b.b.a.p(6, this.GSs);
      AppMethodBeat.o(110904);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.GSq.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(110904);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      byf localbyf = (byf)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(110904);
        return -1;
      case 1: 
        localbyf.id = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(110904);
        return 0;
      case 2: 
        localbyf.GSq.add(((f.a.a.a.a)localObject1).NPN.gxI());
        AppMethodBeat.o(110904);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new bpm();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((bpm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localbyf.GSr = ((bpm)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110904);
        return 0;
      case 4: 
        localbyf.dle = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(110904);
        return 0;
      case 5: 
        localbyf.GQY = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(110904);
        return 0;
      }
      localbyf.GSs = ((f.a.a.a.a)localObject1).NPN.zd();
      AppMethodBeat.o(110904);
      return 0;
    }
    AppMethodBeat.o(110904);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byf
 * JD-Core Version:    0.7.0.1
 */