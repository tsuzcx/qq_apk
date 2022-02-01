package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bms
  extends com.tencent.mm.bx.a
{
  public bzd ZVw;
  public String ttL;
  public String username;
  public int xlL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258841);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.xlL);
      if (this.username != null) {
        paramVarArgs.g(2, this.username);
      }
      if (this.ZVw != null)
      {
        paramVarArgs.qD(3, this.ZVw.computeSize());
        this.ZVw.writeFields(paramVarArgs);
      }
      if (this.ttL != null) {
        paramVarArgs.g(4, this.ttL);
      }
      AppMethodBeat.o(258841);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.xlL) + 0;
      paramInt = i;
      if (this.username != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.username);
      }
      i = paramInt;
      if (this.ZVw != null) {
        i = paramInt + i.a.a.a.qC(3, this.ZVw.computeSize());
      }
      paramInt = i;
      if (this.ttL != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ttL);
      }
      AppMethodBeat.o(258841);
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
      AppMethodBeat.o(258841);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      bms localbms = (bms)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(258841);
        return -1;
      case 1: 
        localbms.xlL = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258841);
        return 0;
      case 2: 
        localbms.username = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(258841);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          bzd localbzd = new bzd();
          if ((localObject != null) && (localObject.length > 0)) {
            localbzd.parseFrom((byte[])localObject);
          }
          localbms.ZVw = localbzd;
          paramInt += 1;
        }
        AppMethodBeat.o(258841);
        return 0;
      }
      localbms.ttL = ((i.a.a.a.a)localObject).ajGk.readString();
      AppMethodBeat.o(258841);
      return 0;
    }
    AppMethodBeat.o(258841);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bms
 * JD-Core Version:    0.7.0.1
 */