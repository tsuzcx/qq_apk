package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class glx
  extends com.tencent.mm.bx.a
{
  public LinkedList<glw> ZMd;
  public int acho;
  
  public glx()
  {
    AppMethodBeat.i(153329);
    this.ZMd = new LinkedList();
    AppMethodBeat.o(153329);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153330);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.ZMd);
      paramVarArgs.bS(2, this.acho);
      AppMethodBeat.o(153330);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      paramInt = i.a.a.a.c(1, 8, this.ZMd);
      i = i.a.a.b.b.a.cJ(2, this.acho);
      AppMethodBeat.o(153330);
      return paramInt + 0 + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ZMd.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(153330);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      glx localglx = (glx)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(153330);
        return -1;
      case 1: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          glw localglw = new glw();
          if ((localObject != null) && (localObject.length > 0)) {
            localglw.parseFrom((byte[])localObject);
          }
          localglx.ZMd.add(localglw);
          paramInt += 1;
        }
        AppMethodBeat.o(153330);
        return 0;
      }
      localglx.acho = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(153330);
      return 0;
    }
    AppMethodBeat.o(153330);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.glx
 * JD-Core Version:    0.7.0.1
 */