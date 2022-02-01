package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eaj
  extends com.tencent.mm.bx.a
{
  public eai abfB;
  public String key;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258480);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.key != null) {
        paramVarArgs.g(1, this.key);
      }
      if (this.abfB != null)
      {
        paramVarArgs.qD(2, this.abfB.computeSize());
        this.abfB.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(258480);
      return 0;
    }
    if (paramInt == 1) {
      if (this.key == null) {
        break label344;
      }
    }
    label344:
    for (paramInt = i.a.a.b.b.a.h(1, this.key) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.abfB != null) {
        i = paramInt + i.a.a.a.qC(2, this.abfB.computeSize());
      }
      AppMethodBeat.o(258480);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258480);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        eaj localeaj = (eaj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258480);
          return -1;
        case 1: 
          localeaj.key = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258480);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          eai localeai = new eai();
          if ((localObject != null) && (localObject.length > 0)) {
            localeai.parseFrom((byte[])localObject);
          }
          localeaj.abfB = localeai;
          paramInt += 1;
        }
        AppMethodBeat.o(258480);
        return 0;
      }
      AppMethodBeat.o(258480);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eaj
 * JD-Core Version:    0.7.0.1
 */