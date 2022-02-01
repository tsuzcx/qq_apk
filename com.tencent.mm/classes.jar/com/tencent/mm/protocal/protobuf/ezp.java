package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ezp
  extends erp
{
  public String abAA;
  public int abAz;
  public String muA;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32434);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.muA != null) {
        paramVarArgs.g(2, this.muA);
      }
      paramVarArgs.bS(3, this.abAz);
      if (this.abAA != null) {
        paramVarArgs.g(4, this.abAA);
      }
      AppMethodBeat.o(32434);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label458;
      }
    }
    label458:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.muA != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.muA);
      }
      i += i.a.a.b.b.a.cJ(3, this.abAz);
      paramInt = i;
      if (this.abAA != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.abAA);
      }
      AppMethodBeat.o(32434);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(32434);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ezp localezp = (ezp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32434);
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
            localezp.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(32434);
          return 0;
        case 2: 
          localezp.muA = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(32434);
          return 0;
        case 3: 
          localezp.abAz = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(32434);
          return 0;
        }
        localezp.abAA = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(32434);
        return 0;
      }
      AppMethodBeat.o(32434);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ezp
 * JD-Core Version:    0.7.0.1
 */