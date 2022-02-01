package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fes
  extends com.tencent.mm.bx.a
{
  public eel abEh;
  public int abEi;
  public int abEj;
  public int abEk;
  public int hQp;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258365);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abEh != null)
      {
        paramVarArgs.qD(1, this.abEh.computeSize());
        this.abEh.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.abEi);
      paramVarArgs.bS(3, this.abEj);
      paramVarArgs.bS(4, this.abEk);
      paramVarArgs.bS(5, this.hQp);
      AppMethodBeat.o(258365);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abEh == null) {
        break label468;
      }
    }
    label468:
    for (paramInt = i.a.a.a.qC(1, this.abEh.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.abEi);
      int j = i.a.a.b.b.a.cJ(3, this.abEj);
      int k = i.a.a.b.b.a.cJ(4, this.abEk);
      int m = i.a.a.b.b.a.cJ(5, this.hQp);
      AppMethodBeat.o(258365);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258365);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fes localfes = (fes)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258365);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            eel localeel = new eel();
            if ((localObject != null) && (localObject.length > 0)) {
              localeel.parseFrom((byte[])localObject);
            }
            localfes.abEh = localeel;
            paramInt += 1;
          }
          AppMethodBeat.o(258365);
          return 0;
        case 2: 
          localfes.abEi = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258365);
          return 0;
        case 3: 
          localfes.abEj = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258365);
          return 0;
        case 4: 
          localfes.abEk = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258365);
          return 0;
        }
        localfes.hQp = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(258365);
        return 0;
      }
      AppMethodBeat.o(258365);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fes
 * JD-Core Version:    0.7.0.1
 */