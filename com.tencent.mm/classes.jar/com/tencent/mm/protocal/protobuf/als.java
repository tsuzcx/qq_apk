package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class als
  extends erp
{
  public int YSW;
  public String ZsI;
  public String hAB;
  public int offset;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257946);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.hAB != null) {
        paramVarArgs.g(2, this.hAB);
      }
      if (this.ZsI != null) {
        paramVarArgs.g(3, this.ZsI);
      }
      paramVarArgs.bS(4, this.YSW);
      paramVarArgs.bS(5, this.offset);
      AppMethodBeat.o(257946);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label496;
      }
    }
    label496:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hAB != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.hAB);
      }
      i = paramInt;
      if (this.ZsI != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ZsI);
      }
      paramInt = i.a.a.b.b.a.cJ(4, this.YSW);
      int j = i.a.a.b.b.a.cJ(5, this.offset);
      AppMethodBeat.o(257946);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257946);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        als localals = (als)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257946);
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
            localals.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(257946);
          return 0;
        case 2: 
          localals.hAB = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257946);
          return 0;
        case 3: 
          localals.ZsI = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257946);
          return 0;
        case 4: 
          localals.YSW = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(257946);
          return 0;
        }
        localals.offset = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(257946);
        return 0;
      }
      AppMethodBeat.o(257946);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.als
 * JD-Core Version:    0.7.0.1
 */