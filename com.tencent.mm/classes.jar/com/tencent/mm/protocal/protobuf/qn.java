package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class qn
  extends com.tencent.mm.bx.a
{
  public LinkedList<yt> CPk;
  public int CPl;
  public String CPm;
  public String Csy;
  public String name;
  
  public qn()
  {
    AppMethodBeat.i(32155);
    this.CPk = new LinkedList();
    AppMethodBeat.o(32155);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32156);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.CPk);
      if (this.Csy != null) {
        paramVarArgs.d(2, this.Csy);
      }
      paramVarArgs.aR(3, this.CPl);
      if (this.CPm != null) {
        paramVarArgs.d(4, this.CPm);
      }
      if (this.name != null) {
        paramVarArgs.d(5, this.name);
      }
      AppMethodBeat.o(32156);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.a.c(1, 8, this.CPk) + 0;
      paramInt = i;
      if (this.Csy != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Csy);
      }
      i = paramInt + f.a.a.b.b.a.bA(3, this.CPl);
      paramInt = i;
      if (this.CPm != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.CPm);
      }
      i = paramInt;
      if (this.name != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.name);
      }
      AppMethodBeat.o(32156);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.CPk.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(32156);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      qn localqn = (qn)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32156);
        return -1;
      case 1: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new yt();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((yt)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localqn.CPk.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(32156);
        return 0;
      case 2: 
        localqn.Csy = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(32156);
        return 0;
      case 3: 
        localqn.CPl = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(32156);
        return 0;
      case 4: 
        localqn.CPm = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(32156);
        return 0;
      }
      localqn.name = ((f.a.a.a.a)localObject1).KhF.readString();
      AppMethodBeat.o(32156);
      return 0;
    }
    AppMethodBeat.o(32156);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.qn
 * JD-Core Version:    0.7.0.1
 */