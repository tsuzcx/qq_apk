package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class epn
  extends erp
{
  public String YBH;
  public String iaI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259204);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.iaI != null) {
        paramVarArgs.g(2, this.iaI);
      }
      if (this.YBH != null) {
        paramVarArgs.g(3, this.YBH);
      }
      AppMethodBeat.o(259204);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label404;
      }
    }
    label404:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.iaI != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.iaI);
      }
      i = paramInt;
      if (this.YBH != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YBH);
      }
      AppMethodBeat.o(259204);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259204);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        epn localepn = (epn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259204);
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
            localepn.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(259204);
          return 0;
        case 2: 
          localepn.iaI = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259204);
          return 0;
        }
        localepn.YBH = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(259204);
        return 0;
      }
      AppMethodBeat.o(259204);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.epn
 * JD-Core Version:    0.7.0.1
 */