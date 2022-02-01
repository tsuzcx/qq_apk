package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class cya
  extends com.tencent.mm.cd.a
{
  public eaf RIl;
  public eaf TGe;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(101828);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.RIl == null)
      {
        paramVarArgs = new b("Not all required fields were included: ChatRoomName");
        AppMethodBeat.o(101828);
        throw paramVarArgs;
      }
      if (this.TGe == null)
      {
        paramVarArgs = new b("Not all required fields were included: ChatRoomTopic");
        AppMethodBeat.o(101828);
        throw paramVarArgs;
      }
      if (this.RIl != null)
      {
        paramVarArgs.oE(1, this.RIl.computeSize());
        this.RIl.writeFields(paramVarArgs);
      }
      if (this.TGe != null)
      {
        paramVarArgs.oE(2, this.TGe.computeSize());
        this.TGe.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(101828);
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
      if (this.TGe != null) {
        i = paramInt + g.a.a.a.oD(2, this.TGe.computeSize());
      }
      AppMethodBeat.o(101828);
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
          AppMethodBeat.o(101828);
          throw paramVarArgs;
        }
        if (this.TGe == null)
        {
          paramVarArgs = new b("Not all required fields were included: ChatRoomTopic");
          AppMethodBeat.o(101828);
          throw paramVarArgs;
        }
        AppMethodBeat.o(101828);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (g.a.a.a.a)paramVarArgs[0];
        cya localcya = (cya)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        eaf localeaf;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(101828);
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
            localcya.RIl = localeaf;
            paramInt += 1;
          }
          AppMethodBeat.o(101828);
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
          localcya.TGe = localeaf;
          paramInt += 1;
        }
        AppMethodBeat.o(101828);
        return 0;
      }
      AppMethodBeat.o(101828);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cya
 * JD-Core Version:    0.7.0.1
 */