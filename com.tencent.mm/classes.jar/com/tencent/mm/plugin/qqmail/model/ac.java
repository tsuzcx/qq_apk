package com.tencent.mm.plugin.qqmail.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.erp;
import com.tencent.mm.protocal.protobuf.kc;
import java.util.LinkedList;

public final class ac
  extends erp
{
  public int NkL;
  public String NkM;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122794);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.NkL);
      if (this.NkM != null) {
        paramVarArgs.g(3, this.NkM);
      }
      AppMethodBeat.o(122794);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label388;
      }
    }
    label388:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.NkL);
      paramInt = i;
      if (this.NkM != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.NkM);
      }
      AppMethodBeat.o(122794);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(122794);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ac localac = (ac)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122794);
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
            localac.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(122794);
          return 0;
        case 2: 
          localac.NkL = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(122794);
          return 0;
        }
        localac.NkM = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(122794);
        return 0;
      }
      AppMethodBeat.o(122794);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.qqmail.model.ac
 * JD-Core Version:    0.7.0.1
 */