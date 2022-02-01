package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ain
  extends com.tencent.mm.bx.a
{
  public int Dlf;
  public LinkedList<FinderObject> Dlg;
  public int fwP;
  public String username;
  
  public ain()
  {
    AppMethodBeat.i(190567);
    this.Dlg = new LinkedList();
    AppMethodBeat.o(190567);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(190568);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Dlf);
      paramVarArgs.e(2, 8, this.Dlg);
      if (this.username != null) {
        paramVarArgs.d(3, this.username);
      }
      paramVarArgs.aR(4, this.fwP);
      AppMethodBeat.o(190568);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.Dlf) + 0 + f.a.a.a.c(2, 8, this.Dlg);
      paramInt = i;
      if (this.username != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.username);
      }
      i = f.a.a.b.b.a.bA(4, this.fwP);
      AppMethodBeat.o(190568);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Dlg.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(190568);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      ain localain = (ain)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(190568);
        return -1;
      case 1: 
        localain.Dlf = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(190568);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new FinderObject();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((FinderObject)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localain.Dlg.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(190568);
        return 0;
      case 3: 
        localain.username = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(190568);
        return 0;
      }
      localain.fwP = ((f.a.a.a.a)localObject1).KhF.xS();
      AppMethodBeat.o(190568);
      return 0;
    }
    AppMethodBeat.o(190568);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ain
 * JD-Core Version:    0.7.0.1
 */