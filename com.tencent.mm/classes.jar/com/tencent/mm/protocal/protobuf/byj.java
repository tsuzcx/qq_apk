package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class byj
  extends com.tencent.mm.bx.a
{
  public String aahc;
  public int aahd;
  public String aahe;
  public FinderAuthInfo aahf;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258050);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aahc != null) {
        paramVarArgs.g(1, this.aahc);
      }
      paramVarArgs.bS(2, this.aahd);
      if (this.aahe != null) {
        paramVarArgs.g(3, this.aahe);
      }
      if (this.aahf != null)
      {
        paramVarArgs.qD(4, this.aahf.computeSize());
        this.aahf.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(258050);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aahc == null) {
        break label448;
      }
    }
    label448:
    for (paramInt = i.a.a.b.b.a.h(1, this.aahc) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.aahd);
      paramInt = i;
      if (this.aahe != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.aahe);
      }
      i = paramInt;
      if (this.aahf != null) {
        i = paramInt + i.a.a.a.qC(4, this.aahf.computeSize());
      }
      AppMethodBeat.o(258050);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258050);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        byj localbyj = (byj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258050);
          return -1;
        case 1: 
          localbyj.aahc = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258050);
          return 0;
        case 2: 
          localbyj.aahd = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258050);
          return 0;
        case 3: 
          localbyj.aahe = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258050);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          FinderAuthInfo localFinderAuthInfo = new FinderAuthInfo();
          if ((localObject != null) && (localObject.length > 0)) {
            localFinderAuthInfo.parseFrom((byte[])localObject);
          }
          localbyj.aahf = localFinderAuthInfo;
          paramInt += 1;
        }
        AppMethodBeat.o(258050);
        return 0;
      }
      AppMethodBeat.o(258050);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.byj
 * JD-Core Version:    0.7.0.1
 */