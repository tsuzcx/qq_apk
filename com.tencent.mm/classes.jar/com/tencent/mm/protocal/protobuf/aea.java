package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class aea
  extends erp
{
  public int Tqb;
  public int YKE;
  public b Zmh;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257392);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.Tqb);
      if (this.username != null) {
        paramVarArgs.g(3, this.username);
      }
      paramVarArgs.bS(4, this.YKE);
      if (this.Zmh != null) {
        paramVarArgs.d(5, this.Zmh);
      }
      AppMethodBeat.o(257392);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label492;
      }
    }
    label492:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.Tqb);
      paramInt = i;
      if (this.username != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.username);
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.YKE);
      paramInt = i;
      if (this.Zmh != null) {
        paramInt = i + i.a.a.b.b.a.c(5, this.Zmh);
      }
      AppMethodBeat.o(257392);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257392);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        aea localaea = (aea)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257392);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kc localkc = new kc();
            if ((localObject != null) && (localObject.length > 0)) {
              localkc.parseFrom((byte[])localObject);
            }
            localaea.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(257392);
          return 0;
        case 2: 
          localaea.Tqb = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(257392);
          return 0;
        case 3: 
          localaea.username = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257392);
          return 0;
        case 4: 
          localaea.YKE = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(257392);
          return 0;
        }
        localaea.Zmh = ((i.a.a.a.a)localObject).ajGk.kFX();
        AppMethodBeat.o(257392);
        return 0;
      }
      AppMethodBeat.o(257392);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aea
 * JD-Core Version:    0.7.0.1
 */