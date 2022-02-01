package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ai
  extends com.tencent.mm.bx.a
{
  public int Frj;
  public int Frk;
  public int Frl;
  public LinkedList<ag> Frm;
  public int Frn;
  public LinkedList<ag> Fro;
  
  public ai()
  {
    AppMethodBeat.i(143963);
    this.Frm = new LinkedList();
    this.Fro = new LinkedList();
    AppMethodBeat.o(143963);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143964);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.Frj);
      paramVarArgs.aS(2, this.Frl);
      paramVarArgs.e(3, 8, this.Frm);
      paramVarArgs.aS(4, this.Frk);
      paramVarArgs.aS(5, this.Frn);
      paramVarArgs.e(6, 8, this.Fro);
      AppMethodBeat.o(143964);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = f.a.a.b.b.a.bz(1, this.Frj);
      i = f.a.a.b.b.a.bz(2, this.Frl);
      int j = f.a.a.a.c(3, 8, this.Frm);
      int k = f.a.a.b.b.a.bz(4, this.Frk);
      int m = f.a.a.b.b.a.bz(5, this.Frn);
      int n = f.a.a.a.c(6, 8, this.Fro);
      AppMethodBeat.o(143964);
      return paramInt + 0 + i + j + k + m + n;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Frm.clear();
      this.Fro.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(143964);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      ai localai = (ai)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143964);
        return -1;
      case 1: 
        localai.Frj = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(143964);
        return 0;
      case 2: 
        localai.Frl = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(143964);
        return 0;
      case 3: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ag();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ag)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localai.Frm.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143964);
        return 0;
      case 4: 
        localai.Frk = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(143964);
        return 0;
      case 5: 
        localai.Frn = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(143964);
        return 0;
      }
      paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new ag();
        localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((ag)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
        localai.Fro.add(localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(143964);
      return 0;
    }
    AppMethodBeat.o(143964);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ai
 * JD-Core Version:    0.7.0.1
 */