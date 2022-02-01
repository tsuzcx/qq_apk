package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class anl
  extends com.tencent.mm.bx.a
{
  public String IGG;
  public int ZuN;
  public String ZuO;
  public ank ZuP;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260206);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.ZuN);
      if (this.ZuO != null) {
        paramVarArgs.g(2, this.ZuO);
      }
      if (this.ZuP != null)
      {
        paramVarArgs.qD(3, this.ZuP.computeSize());
        this.ZuP.writeFields(paramVarArgs);
      }
      if (this.IGG != null) {
        paramVarArgs.g(4, this.IGG);
      }
      AppMethodBeat.o(260206);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.ZuN) + 0;
      paramInt = i;
      if (this.ZuO != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.ZuO);
      }
      i = paramInt;
      if (this.ZuP != null) {
        i = paramInt + i.a.a.a.qC(3, this.ZuP.computeSize());
      }
      paramInt = i;
      if (this.IGG != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.IGG);
      }
      AppMethodBeat.o(260206);
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
      AppMethodBeat.o(260206);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      anl localanl = (anl)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(260206);
        return -1;
      case 1: 
        localanl.ZuN = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(260206);
        return 0;
      case 2: 
        localanl.ZuO = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(260206);
        return 0;
      case 3: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          ank localank = new ank();
          if ((localObject != null) && (localObject.length > 0)) {
            localank.parseFrom((byte[])localObject);
          }
          localanl.ZuP = localank;
          paramInt += 1;
        }
        AppMethodBeat.o(260206);
        return 0;
      }
      localanl.IGG = ((i.a.a.a.a)localObject).ajGk.readString();
      AppMethodBeat.o(260206);
      return 0;
    }
    AppMethodBeat.o(260206);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.anl
 * JD-Core Version:    0.7.0.1
 */