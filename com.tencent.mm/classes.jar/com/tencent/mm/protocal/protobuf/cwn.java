package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cwn
  extends erp
{
  public String aaBF;
  public int aarV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259996);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.aarV);
      if (this.aaBF != null) {
        paramVarArgs.g(3, this.aaBF);
      }
      AppMethodBeat.o(259996);
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
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.aarV);
      paramInt = i;
      if (this.aaBF != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.aaBF);
      }
      AppMethodBeat.o(259996);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259996);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        cwn localcwn = (cwn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259996);
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
            localcwn.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(259996);
          return 0;
        case 2: 
          localcwn.aarV = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(259996);
          return 0;
        }
        localcwn.aaBF = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(259996);
        return 0;
      }
      AppMethodBeat.o(259996);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwn
 * JD-Core Version:    0.7.0.1
 */