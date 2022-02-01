package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class edl
  extends com.tencent.mm.bx.a
{
  public dha Zqj;
  public int Zvi;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32368);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Zqj != null)
      {
        paramVarArgs.qD(1, this.Zqj.computeSize());
        this.Zqj.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.Zvi);
      AppMethodBeat.o(32368);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Zqj == null) {
        break label336;
      }
    }
    label336:
    for (paramInt = i.a.a.a.qC(1, this.Zqj.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.Zvi);
      AppMethodBeat.o(32368);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(32368);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        edl localedl = (edl)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32368);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            dha localdha = new dha();
            if ((localObject != null) && (localObject.length > 0)) {
              localdha.parseFrom((byte[])localObject);
            }
            localedl.Zqj = localdha;
            paramInt += 1;
          }
          AppMethodBeat.o(32368);
          return 0;
        }
        localedl.Zvi = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(32368);
        return 0;
      }
      AppMethodBeat.o(32368);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.edl
 * JD-Core Version:    0.7.0.1
 */