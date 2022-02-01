package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ava
  extends com.tencent.mm.bx.a
{
  public long FDj;
  public String FDk;
  public LinkedList<dwg> Gtk;
  
  public ava()
  {
    AppMethodBeat.i(110898);
    this.Gtk = new LinkedList();
    AppMethodBeat.o(110898);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(110899);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.FDj);
      paramVarArgs.e(2, 8, this.Gtk);
      if (this.FDk != null) {
        paramVarArgs.d(3, this.FDk);
      }
      AppMethodBeat.o(110899);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.p(1, this.FDj) + 0 + f.a.a.a.c(2, 8, this.Gtk);
      paramInt = i;
      if (this.FDk != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.FDk);
      }
      AppMethodBeat.o(110899);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Gtk.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(110899);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      ava localava = (ava)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(110899);
        return -1;
      case 1: 
        localava.FDj = ((f.a.a.a.a)localObject1).NPN.zd();
        AppMethodBeat.o(110899);
        return 0;
      case 2: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dwg();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dwg)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localava.Gtk.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(110899);
        return 0;
      }
      localava.FDk = ((f.a.a.a.a)localObject1).NPN.readString();
      AppMethodBeat.o(110899);
      return 0;
    }
    AppMethodBeat.o(110899);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ava
 * JD-Core Version:    0.7.0.1
 */