package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class alp
  extends erp
{
  public int YSW;
  public String ZsI;
  public String ZsJ;
  public int tab_type;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257856);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.tab_type);
      if (this.ZsI != null) {
        paramVarArgs.g(3, this.ZsI);
      }
      paramVarArgs.bS(4, this.YSW);
      if (this.ZsJ != null) {
        paramVarArgs.g(5, this.ZsJ);
      }
      AppMethodBeat.o(257856);
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
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.tab_type);
      paramInt = i;
      if (this.ZsI != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.ZsI);
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.YSW);
      paramInt = i;
      if (this.ZsJ != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.ZsJ);
      }
      AppMethodBeat.o(257856);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257856);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        alp localalp = (alp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257856);
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
            localalp.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(257856);
          return 0;
        case 2: 
          localalp.tab_type = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(257856);
          return 0;
        case 3: 
          localalp.ZsI = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257856);
          return 0;
        case 4: 
          localalp.YSW = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(257856);
          return 0;
        }
        localalp.ZsJ = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(257856);
        return 0;
      }
      AppMethodBeat.o(257856);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.alp
 * JD-Core Version:    0.7.0.1
 */