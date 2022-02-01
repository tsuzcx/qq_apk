package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class gnv
  extends com.tencent.mm.bx.a
{
  public int ZqA;
  public int aciM;
  public int aciN;
  public fhc aciO;
  public int score;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32570);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.username == null)
      {
        paramVarArgs = new b("Not all required fields were included: username");
        AppMethodBeat.o(32570);
        throw paramVarArgs;
      }
      if (this.username != null) {
        paramVarArgs.g(1, this.username);
      }
      paramVarArgs.bS(2, this.score);
      paramVarArgs.bS(3, this.aciM);
      paramVarArgs.bS(4, this.ZqA);
      paramVarArgs.bS(5, this.aciN);
      if (this.aciO != null)
      {
        paramVarArgs.qD(6, this.aciO.computeSize());
        this.aciO.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32570);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label580;
      }
    }
    label580:
    for (paramInt = i.a.a.b.b.a.h(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.score) + i.a.a.b.b.a.cJ(3, this.aciM) + i.a.a.b.b.a.cJ(4, this.ZqA) + i.a.a.b.b.a.cJ(5, this.aciN);
      paramInt = i;
      if (this.aciO != null) {
        paramInt = i + i.a.a.a.qC(6, this.aciO.computeSize());
      }
      AppMethodBeat.o(32570);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.username == null)
        {
          paramVarArgs = new b("Not all required fields were included: username");
          AppMethodBeat.o(32570);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32570);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        gnv localgnv = (gnv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32570);
          return -1;
        case 1: 
          localgnv.username = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32570);
          return 0;
        case 2: 
          localgnv.score = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(32570);
          return 0;
        case 3: 
          localgnv.aciM = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(32570);
          return 0;
        case 4: 
          localgnv.ZqA = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(32570);
          return 0;
        case 5: 
          localgnv.aciN = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(32570);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          fhc localfhc = new fhc();
          if ((localObject != null) && (localObject.length > 0)) {
            localfhc.parseFrom((byte[])localObject);
          }
          localgnv.aciO = localfhc;
          paramInt += 1;
        }
        AppMethodBeat.o(32570);
        return 0;
      }
      AppMethodBeat.o(32570);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gnv
 * JD-Core Version:    0.7.0.1
 */