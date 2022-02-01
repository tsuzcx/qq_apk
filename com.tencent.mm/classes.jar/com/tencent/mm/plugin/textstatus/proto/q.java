package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class q
  extends com.tencent.mm.bx.a
{
  public m Tpn;
  public int action;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(290024);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.action);
      if (this.Tpn != null)
      {
        paramVarArgs.qD(2, this.Tpn.computeSize());
        this.Tpn.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(290024);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.action) + 0;
      paramInt = i;
      if (this.Tpn != null) {
        paramInt = i + i.a.a.a.qC(2, this.Tpn.computeSize());
      }
      AppMethodBeat.o(290024);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(290024);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      q localq = (q)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(290024);
        return -1;
      case 1: 
        localq.action = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(290024);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        m localm = new m();
        if ((localObject != null) && (localObject.length > 0)) {
          localm.parseFrom((byte[])localObject);
        }
        localq.Tpn = localm;
        paramInt += 1;
      }
      AppMethodBeat.o(290024);
      return 0;
    }
    AppMethodBeat.o(290024);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.q
 * JD-Core Version:    0.7.0.1
 */