package com.tencent.mm.plugin.sns.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.ejj;
import g.a.a.b;
import java.util.LinkedList;

public final class e
  extends com.tencent.mm.cd.a
{
  public ejj JVa;
  public String KeY;
  public int KeZ;
  public String Kfa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(96156);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KeY == null)
      {
        paramVarArgs = new b("Not all required fields were included: clientID");
        AppMethodBeat.o(96156);
        throw paramVarArgs;
      }
      if (this.JVa == null)
      {
        paramVarArgs = new b("Not all required fields were included: actionGroup");
        AppMethodBeat.o(96156);
        throw paramVarArgs;
      }
      if (this.KeY != null) {
        paramVarArgs.f(1, this.KeY);
      }
      if (this.JVa != null)
      {
        paramVarArgs.oE(2, this.JVa.computeSize());
        this.JVa.writeFields(paramVarArgs);
      }
      paramVarArgs.aY(3, this.KeZ);
      if (this.Kfa != null) {
        paramVarArgs.f(4, this.Kfa);
      }
      AppMethodBeat.o(96156);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KeY == null) {
        break label548;
      }
    }
    label548:
    for (paramInt = g.a.a.b.b.a.g(1, this.KeY) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.JVa != null) {
        i = paramInt + g.a.a.a.oD(2, this.JVa.computeSize());
      }
      i += g.a.a.b.b.a.bM(3, this.KeZ);
      paramInt = i;
      if (this.Kfa != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.Kfa);
      }
      AppMethodBeat.o(96156);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.KeY == null)
        {
          paramVarArgs = new b("Not all required fields were included: clientID");
          AppMethodBeat.o(96156);
          throw paramVarArgs;
        }
        if (this.JVa == null)
        {
          paramVarArgs = new b("Not all required fields were included: actionGroup");
          AppMethodBeat.o(96156);
          throw paramVarArgs;
        }
        AppMethodBeat.o(96156);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        e locale = (e)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(96156);
          return -1;
        case 1: 
          locale.KeY = ((g.a.a.a.a)localObject).abFh.readString();
          AppMethodBeat.o(96156);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            ejj localejj = new ejj();
            if ((localObject != null) && (localObject.length > 0)) {
              localejj.parseFrom((byte[])localObject);
            }
            locale.JVa = localejj;
            paramInt += 1;
          }
          AppMethodBeat.o(96156);
          return 0;
        case 3: 
          locale.KeZ = ((g.a.a.a.a)localObject).abFh.AK();
          AppMethodBeat.o(96156);
          return 0;
        }
        locale.Kfa = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(96156);
        return 0;
      }
      AppMethodBeat.o(96156);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.j.e
 * JD-Core Version:    0.7.0.1
 */