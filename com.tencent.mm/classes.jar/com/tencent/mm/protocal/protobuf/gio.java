package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gio
  extends com.tencent.mm.bx.a
{
  public LinkedList<gdo> aceW;
  public LinkedList<fna> aceX;
  
  public gio()
  {
    AppMethodBeat.i(258587);
    this.aceW = new LinkedList();
    this.aceX = new LinkedList();
    AppMethodBeat.o(258587);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258590);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.aceW);
      paramVarArgs.e(2, 8, this.aceX);
      AppMethodBeat.o(258590);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.a.c(1, 8, this.aceW);
      i = i.a.a.a.c(2, 8, this.aceX);
      AppMethodBeat.o(258590);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.aceW.clear();
      this.aceX.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258590);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      gio localgio = (gio)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(258590);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new gdo();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((gdo)localObject2).parseFrom((byte[])localObject1);
          }
          localgio.aceW.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258590);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new fna();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((fna)localObject2).parseFrom((byte[])localObject1);
        }
        localgio.aceX.add(localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(258590);
      return 0;
    }
    AppMethodBeat.o(258590);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gio
 * JD-Core Version:    0.7.0.1
 */