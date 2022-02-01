package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aad
  extends erp
{
  public String URL;
  public int ZiC;
  public int ZiD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32159);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.URL != null) {
        paramVarArgs.g(2, this.URL);
      }
      paramVarArgs.bS(3, this.ZiC);
      paramVarArgs.bS(4, this.ZiD);
      AppMethodBeat.o(32159);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label446;
      }
    }
    label446:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.URL != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.URL);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.ZiC);
      int j = i.a.a.b.b.a.cJ(4, this.ZiD);
      AppMethodBeat.o(32159);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(32159);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        aad localaad = (aad)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32159);
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
            localaad.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(32159);
          return 0;
        case 2: 
          localaad.URL = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32159);
          return 0;
        case 3: 
          localaad.ZiC = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(32159);
          return 0;
        }
        localaad.ZiD = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(32159);
        return 0;
      }
      AppMethodBeat.o(32159);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aad
 * JD-Core Version:    0.7.0.1
 */