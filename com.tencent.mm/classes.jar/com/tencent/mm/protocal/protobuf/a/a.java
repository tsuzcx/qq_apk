package com.tencent.mm.protocal.protobuf.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class a
  extends com.tencent.mm.bx.a
{
  public int abaj;
  public int abak;
  public aa aciQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259719);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aciQ != null)
      {
        paramVarArgs.qD(1, this.aciQ.computeSize());
        this.aciQ.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.abaj);
      paramVarArgs.bS(3, this.abak);
      AppMethodBeat.o(259719);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aciQ == null) {
        break label376;
      }
    }
    label376:
    for (paramInt = i.a.a.a.qC(1, this.aciQ.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.abaj);
      int j = i.a.a.b.b.a.cJ(3, this.abak);
      AppMethodBeat.o(259719);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259719);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        a locala = (a)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259719);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            aa localaa = new aa();
            if ((localObject != null) && (localObject.length > 0)) {
              localaa.parseFrom((byte[])localObject);
            }
            locala.aciQ = localaa;
            paramInt += 1;
          }
          AppMethodBeat.o(259719);
          return 0;
        case 2: 
          locala.abaj = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259719);
          return 0;
        }
        locala.abak = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259719);
        return 0;
      }
      AppMethodBeat.o(259719);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.a.a
 * JD-Core Version:    0.7.0.1
 */