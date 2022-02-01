package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class fqm
  extends com.tencent.mm.cd.a
{
  public int Sry;
  public int UOk;
  public int UOl;
  public emg UOm;
  public int score;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32570);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.username == null)
      {
        paramVarArgs = new b("Not all required fields were included: username");
        AppMethodBeat.o(32570);
        throw paramVarArgs;
      }
      if (this.username != null) {
        paramVarArgs.f(1, this.username);
      }
      paramVarArgs.aY(2, this.score);
      paramVarArgs.aY(3, this.UOk);
      paramVarArgs.aY(4, this.Sry);
      paramVarArgs.aY(5, this.UOl);
      if (this.UOm != null)
      {
        paramVarArgs.oE(6, this.UOm.computeSize());
        this.UOm.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32570);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label584;
      }
    }
    label584:
    for (paramInt = g.a.a.b.b.a.g(1, this.username) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bM(2, this.score) + g.a.a.b.b.a.bM(3, this.UOk) + g.a.a.b.b.a.bM(4, this.Sry) + g.a.a.b.b.a.bM(5, this.UOl);
      paramInt = i;
      if (this.UOm != null) {
        paramInt = i + g.a.a.a.oD(6, this.UOm.computeSize());
      }
      AppMethodBeat.o(32570);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
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
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        fqm localfqm = (fqm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32570);
          return -1;
        case 1: 
          localfqm.username = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(32570);
          return 0;
        case 2: 
          localfqm.score = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(32570);
          return 0;
        case 3: 
          localfqm.UOk = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(32570);
          return 0;
        case 4: 
          localfqm.Sry = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(32570);
          return 0;
        case 5: 
          localfqm.UOl = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(32570);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          emg localemg = new emg();
          if ((localObject != null) && (localObject.length > 0)) {
            localemg.parseFrom((byte[])localObject);
          }
          localfqm.UOm = localemg;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fqm
 * JD-Core Version:    0.7.0.1
 */