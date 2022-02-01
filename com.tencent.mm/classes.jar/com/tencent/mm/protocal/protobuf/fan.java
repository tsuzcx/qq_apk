package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class fan
  extends com.tencent.mm.bx.a
{
  public LinkedList<fuw> aaAk;
  public b aaAl;
  public int abAM;
  
  public fan()
  {
    AppMethodBeat.i(259787);
    this.aaAk = new LinkedList();
    AppMethodBeat.o(259787);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259790);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.aaAk);
      if (this.aaAl != null) {
        paramVarArgs.d(2, this.aaAl);
      }
      paramVarArgs.bS(3, this.abAM);
      AppMethodBeat.o(259790);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.a.c(1, 8, this.aaAk) + 0;
      paramInt = i;
      if (this.aaAl != null) {
        paramInt = i + i.a.a.b.b.a.c(2, this.aaAl);
      }
      i = i.a.a.b.b.a.cJ(3, this.abAM);
      AppMethodBeat.o(259790);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.aaAk.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259790);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      fan localfan = (fan)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(259790);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          fuw localfuw = new fuw();
          if ((localObject != null) && (localObject.length > 0)) {
            localfuw.parseFrom((byte[])localObject);
          }
          localfan.aaAk.add(localfuw);
          paramInt += 1;
        }
        AppMethodBeat.o(259790);
        return 0;
      case 2: 
        localfan.aaAl = ((i.a.a.a.a)localObject).ajGk.kFX();
        AppMethodBeat.o(259790);
        return 0;
      }
      localfan.abAM = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(259790);
      return 0;
    }
    AppMethodBeat.o(259790);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fan
 * JD-Core Version:    0.7.0.1
 */