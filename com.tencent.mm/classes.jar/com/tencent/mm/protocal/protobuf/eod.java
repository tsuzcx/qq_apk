package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eod
  extends com.tencent.mm.bx.a
{
  public fmp ZoM;
  public String abst;
  public int type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91664);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.type);
      if (this.abst != null) {
        paramVarArgs.g(2, this.abst);
      }
      if (this.ZoM != null)
      {
        paramVarArgs.qD(3, this.ZoM.computeSize());
        this.ZoM.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91664);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.type) + 0;
      paramInt = i;
      if (this.abst != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.abst);
      }
      i = paramInt;
      if (this.ZoM != null) {
        i = paramInt + i.a.a.a.qC(3, this.ZoM.computeSize());
      }
      AppMethodBeat.o(91664);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(91664);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      eod localeod = (eod)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91664);
        return -1;
      case 1: 
        localeod.type = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(91664);
        return 0;
      case 2: 
        localeod.abst = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(91664);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        fmp localfmp = new fmp();
        if ((localObject != null) && (localObject.length > 0)) {
          localfmp.parseFrom((byte[])localObject);
        }
        localeod.ZoM = localfmp;
        paramInt += 1;
      }
      AppMethodBeat.o(91664);
      return 0;
    }
    AppMethodBeat.o(91664);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eod
 * JD-Core Version:    0.7.0.1
 */