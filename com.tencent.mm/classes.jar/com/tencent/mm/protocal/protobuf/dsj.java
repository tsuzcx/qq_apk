package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class dsj
  extends com.tencent.mm.cd.a
{
  public eaf RIl;
  public eaf SrH;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101829);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RIl == null)
      {
        paramVarArgs = new b("Not all required fields were included: ChatRoomName");
        AppMethodBeat.o(101829);
        throw paramVarArgs;
      }
      if (this.SrH == null)
      {
        paramVarArgs = new b("Not all required fields were included: UserName");
        AppMethodBeat.o(101829);
        throw paramVarArgs;
      }
      if (this.RIl != null)
      {
        paramVarArgs.oE(1, this.RIl.computeSize());
        this.RIl.writeFields(paramVarArgs);
      }
      if (this.SrH != null)
      {
        paramVarArgs.oE(2, this.SrH.computeSize());
        this.SrH.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(101829);
      return 0;
    }
    if (paramInt == 1) {
      if (this.RIl == null) {
        break label518;
      }
    }
    label518:
    for (paramInt = g.a.a.a.oD(1, this.RIl.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.SrH != null) {
        i = paramInt + g.a.a.a.oD(2, this.SrH.computeSize());
      }
      AppMethodBeat.o(101829);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        if (this.RIl == null)
        {
          paramVarArgs = new b("Not all required fields were included: ChatRoomName");
          AppMethodBeat.o(101829);
          throw paramVarArgs;
        }
        if (this.SrH == null)
        {
          paramVarArgs = new b("Not all required fields were included: UserName");
          AppMethodBeat.o(101829);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101829);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        dsj localdsj = (dsj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        eaf localeaf;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101829);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localeaf = new eaf();
            if ((localObject != null) && (localObject.length > 0)) {
              localeaf.de((byte[])localObject);
            }
            localdsj.RIl = localeaf;
            paramInt += 1;
          }
          AppMethodBeat.o(101829);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localeaf = new eaf();
          if ((localObject != null) && (localObject.length > 0)) {
            localeaf.de((byte[])localObject);
          }
          localdsj.SrH = localeaf;
          paramInt += 1;
        }
        AppMethodBeat.o(101829);
        return 0;
      }
      AppMethodBeat.o(101829);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dsj
 * JD-Core Version:    0.7.0.1
 */