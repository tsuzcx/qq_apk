package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dub
  extends com.tencent.mm.bx.a
{
  public cle HGW;
  public String Username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56263);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.HGW == null)
      {
        paramVarArgs = new b("Not all required fields were included: Position");
        AppMethodBeat.o(56263);
        throw paramVarArgs;
      }
      if (this.Username != null) {
        paramVarArgs.d(1, this.Username);
      }
      if (this.HGW != null)
      {
        paramVarArgs.lC(2, this.HGW.computeSize());
        this.HGW.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(56263);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Username == null) {
        break label418;
      }
    }
    label418:
    for (paramInt = f.a.a.b.b.a.e(1, this.Username) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.HGW != null) {
        i = paramInt + f.a.a.a.lB(2, this.HGW.computeSize());
      }
      AppMethodBeat.o(56263);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.HGW == null)
        {
          paramVarArgs = new b("Not all required fields were included: Position");
          AppMethodBeat.o(56263);
          throw paramVarArgs;
        }
        AppMethodBeat.o(56263);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dub localdub = (dub)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56263);
          return -1;
        case 1: 
          localdub.Username = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(56263);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cle();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cle)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdub.HGW = ((cle)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(56263);
        return 0;
      }
      AppMethodBeat.o(56263);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dub
 * JD-Core Version:    0.7.0.1
 */