package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cuc
  extends esc
{
  public String aazB;
  public String aazC;
  public String iaI;
  public int status;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257755);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.status);
      if (this.iaI != null) {
        paramVarArgs.g(3, this.iaI);
      }
      if (this.aazB != null) {
        paramVarArgs.g(4, this.aazB);
      }
      if (this.aazC != null) {
        paramVarArgs.g(5, this.aazC);
      }
      AppMethodBeat.o(257755);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label508;
      }
    }
    label508:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.status);
      paramInt = i;
      if (this.iaI != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.iaI);
      }
      i = paramInt;
      if (this.aazB != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.aazB);
      }
      paramInt = i;
      if (this.aazC != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.aazC);
      }
      AppMethodBeat.o(257755);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257755);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        cuc localcuc = (cuc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257755);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kd localkd = new kd();
            if ((localObject != null) && (localObject.length > 0)) {
              localkd.parseFrom((byte[])localObject);
            }
            localcuc.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(257755);
          return 0;
        case 2: 
          localcuc.status = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(257755);
          return 0;
        case 3: 
          localcuc.iaI = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257755);
          return 0;
        case 4: 
          localcuc.aazB = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257755);
          return 0;
        }
        localcuc.aazC = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(257755);
        return 0;
      }
      AppMethodBeat.o(257755);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cuc
 * JD-Core Version:    0.7.0.1
 */