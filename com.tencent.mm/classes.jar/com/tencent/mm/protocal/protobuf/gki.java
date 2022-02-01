package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class gki
  extends com.tencent.mm.bx.a
{
  public LinkedList<edw> acgk;
  public LinkedList<dfe> acgl;
  
  public gki()
  {
    AppMethodBeat.i(123687);
    this.acgk = new LinkedList();
    this.acgl = new LinkedList();
    AppMethodBeat.o(123687);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123688);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.acgk);
      paramVarArgs.e(2, 8, this.acgl);
      AppMethodBeat.o(123688);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.a.c(1, 8, this.acgk);
      i = i.a.a.a.c(2, 8, this.acgl);
      AppMethodBeat.o(123688);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.acgk.clear();
      this.acgl.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(123688);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      gki localgki = (gki)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(123688);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new edw();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((edw)localObject2).parseFrom((byte[])localObject1);
          }
          localgki.acgk.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(123688);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new dfe();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((dfe)localObject2).parseFrom((byte[])localObject1);
        }
        localgki.acgl.add(localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(123688);
      return 0;
    }
    AppMethodBeat.o(123688);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gki
 * JD-Core Version:    0.7.0.1
 */