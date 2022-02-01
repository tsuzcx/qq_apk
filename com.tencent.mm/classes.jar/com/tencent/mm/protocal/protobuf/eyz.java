package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eyz
  extends com.tencent.mm.bx.a
{
  public LinkedList<caw> aajM;
  public String hQR;
  
  public eyz()
  {
    AppMethodBeat.i(122534);
    this.aajM = new LinkedList();
    AppMethodBeat.o(122534);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122535);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.hQR != null) {
        paramVarArgs.g(1, this.hQR);
      }
      paramVarArgs.e(2, 8, this.aajM);
      AppMethodBeat.o(122535);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hQR == null) {
        break label332;
      }
    }
    label332:
    for (paramInt = i.a.a.b.b.a.h(1, this.hQR) + 0;; paramInt = 0)
    {
      int i = i.a.a.a.c(2, 8, this.aajM);
      AppMethodBeat.o(122535);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aajM.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(122535);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        eyz localeyz = (eyz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122535);
          return -1;
        case 1: 
          localeyz.hQR = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(122535);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          caw localcaw = new caw();
          if ((localObject != null) && (localObject.length > 0)) {
            localcaw.parseFrom((byte[])localObject);
          }
          localeyz.aajM.add(localcaw);
          paramInt += 1;
        }
        AppMethodBeat.o(122535);
        return 0;
      }
      AppMethodBeat.o(122535);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eyz
 * JD-Core Version:    0.7.0.1
 */