package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eog
  extends com.tencent.mm.bx.a
{
  public eoh aaxS;
  public String absu;
  public String content;
  public String nQD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(168758);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.content != null) {
        paramVarArgs.g(1, this.content);
      }
      if (this.nQD != null) {
        paramVarArgs.g(2, this.nQD);
      }
      if (this.absu != null) {
        paramVarArgs.g(3, this.absu);
      }
      if (this.aaxS != null)
      {
        paramVarArgs.qD(4, this.aaxS.computeSize());
        this.aaxS.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(168758);
      return 0;
    }
    if (paramInt == 1) {
      if (this.content == null) {
        break label464;
      }
    }
    label464:
    for (int i = i.a.a.b.b.a.h(1, this.content) + 0;; i = 0)
    {
      paramInt = i;
      if (this.nQD != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.nQD);
      }
      i = paramInt;
      if (this.absu != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.absu);
      }
      paramInt = i;
      if (this.aaxS != null) {
        paramInt = i + i.a.a.a.qC(4, this.aaxS.computeSize());
      }
      AppMethodBeat.o(168758);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(168758);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        eog localeog = (eog)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(168758);
          return -1;
        case 1: 
          localeog.content = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(168758);
          return 0;
        case 2: 
          localeog.nQD = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(168758);
          return 0;
        case 3: 
          localeog.absu = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(168758);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          eoh localeoh = new eoh();
          if ((localObject != null) && (localObject.length > 0)) {
            localeoh.parseFrom((byte[])localObject);
          }
          localeog.aaxS = localeoh;
          paramInt += 1;
        }
        AppMethodBeat.o(168758);
        return 0;
      }
      AppMethodBeat.o(168758);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eog
 * JD-Core Version:    0.7.0.1
 */