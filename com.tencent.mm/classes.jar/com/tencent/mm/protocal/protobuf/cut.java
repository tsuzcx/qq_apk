package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class cut
  extends com.tencent.mm.bx.a
{
  public LinkedList<fuw> aaAk;
  public b aaAl;
  public fuy aaAm;
  
  public cut()
  {
    AppMethodBeat.i(257576);
    this.aaAk = new LinkedList();
    AppMethodBeat.o(257576);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257584);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.aaAk);
      if (this.aaAl != null) {
        paramVarArgs.d(2, this.aaAl);
      }
      if (this.aaAm != null)
      {
        paramVarArgs.qD(5, this.aaAm.computeSize());
        this.aaAm.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(257584);
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
      i = paramInt;
      if (this.aaAm != null) {
        i = paramInt + i.a.a.a.qC(5, this.aaAm.computeSize());
      }
      AppMethodBeat.o(257584);
      return i;
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
      AppMethodBeat.o(257584);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      cut localcut = (cut)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      case 3: 
      case 4: 
      default: 
        AppMethodBeat.o(257584);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fuw();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fuw)localObject2).parseFrom((byte[])localObject1);
          }
          localcut.aaAk.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257584);
        return 0;
      case 2: 
        localcut.aaAl = ((i.a.a.a.a)localObject1).ajGk.kFX();
        AppMethodBeat.o(257584);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject1 = (byte[])paramVarArgs.get(paramInt);
        localObject2 = new fuy();
        if ((localObject1 != null) && (localObject1.length > 0)) {
          ((fuy)localObject2).parseFrom((byte[])localObject1);
        }
        localcut.aaAm = ((fuy)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(257584);
      return 0;
    }
    AppMethodBeat.o(257584);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cut
 * JD-Core Version:    0.7.0.1
 */