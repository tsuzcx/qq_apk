package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class rm
  extends com.tencent.mm.cd.a
{
  public String CMD;
  public ro Sak;
  public eck San;
  public rv Sao;
  public String rWI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117841);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.rWI == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(117841);
        throw paramVarArgs;
      }
      if (this.San == null)
      {
        paramVarArgs = new b("Not all required fields were included: ContactItem");
        AppMethodBeat.o(117841);
        throw paramVarArgs;
      }
      if (this.rWI != null) {
        paramVarArgs.f(1, this.rWI);
      }
      if (this.Sak != null)
      {
        paramVarArgs.oE(2, this.Sak.computeSize());
        this.Sak.writeFields(paramVarArgs);
      }
      if (this.San != null)
      {
        paramVarArgs.oE(3, this.San.computeSize());
        this.San.writeFields(paramVarArgs);
      }
      if (this.Sao != null)
      {
        paramVarArgs.oE(4, this.Sao.computeSize());
        this.Sao.writeFields(paramVarArgs);
      }
      if (this.CMD != null) {
        paramVarArgs.f(5, this.CMD);
      }
      AppMethodBeat.o(117841);
      return 0;
    }
    if (paramInt == 1) {
      if (this.rWI == null) {
        break label768;
      }
    }
    label768:
    for (int i = g.a.a.b.b.a.g(1, this.rWI) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Sak != null) {
        paramInt = i + g.a.a.a.oD(2, this.Sak.computeSize());
      }
      i = paramInt;
      if (this.San != null) {
        i = paramInt + g.a.a.a.oD(3, this.San.computeSize());
      }
      paramInt = i;
      if (this.Sao != null) {
        paramInt = i + g.a.a.a.oD(4, this.Sao.computeSize());
      }
      i = paramInt;
      if (this.CMD != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.CMD);
      }
      AppMethodBeat.o(117841);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.rWI == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(117841);
          throw paramVarArgs;
        }
        if (this.San == null)
        {
          paramVarArgs = new b("Not all required fields were included: ContactItem");
          AppMethodBeat.o(117841);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117841);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        rm localrm = (rm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117841);
          return -1;
        case 1: 
          localrm.rWI = ((g.a.a.a.a)localObject1).abFh.readString();
          AppMethodBeat.o(117841);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ro();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ro)localObject2).parseFrom((byte[])localObject1);
            }
            localrm.Sak = ((ro)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(117841);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eck();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eck)localObject2).parseFrom((byte[])localObject1);
            }
            localrm.San = ((eck)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(117841);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new rv();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((rv)localObject2).parseFrom((byte[])localObject1);
            }
            localrm.Sao = ((rv)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(117841);
          return 0;
        }
        localrm.CMD = ((g.a.a.a.a)localObject1).abFh.readString();
        AppMethodBeat.o(117841);
        return 0;
      }
      AppMethodBeat.o(117841);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rm
 * JD-Core Version:    0.7.0.1
 */