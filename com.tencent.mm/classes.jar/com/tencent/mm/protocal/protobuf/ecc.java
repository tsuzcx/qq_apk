package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ecc
  extends erp
{
  public String abhA;
  public int abhw;
  public String abhy;
  public String abhz;
  public String language;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91587);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.abhw);
      if (this.language != null) {
        paramVarArgs.g(3, this.language);
      }
      if (this.abhy != null) {
        paramVarArgs.g(4, this.abhy);
      }
      if (this.abhz != null) {
        paramVarArgs.g(5, this.abhz);
      }
      if (this.abhA != null) {
        paramVarArgs.g(6, this.abhA);
      }
      AppMethodBeat.o(91587);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label572;
      }
    }
    label572:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.abhw);
      paramInt = i;
      if (this.language != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.language);
      }
      i = paramInt;
      if (this.abhy != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.abhy);
      }
      paramInt = i;
      if (this.abhz != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.abhz);
      }
      i = paramInt;
      if (this.abhA != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.abhA);
      }
      AppMethodBeat.o(91587);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91587);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ecc localecc = (ecc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91587);
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
            localecc.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(91587);
          return 0;
        case 2: 
          localecc.abhw = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91587);
          return 0;
        case 3: 
          localecc.language = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91587);
          return 0;
        case 4: 
          localecc.abhy = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91587);
          return 0;
        case 5: 
          localecc.abhz = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91587);
          return 0;
        }
        localecc.abhA = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(91587);
        return 0;
      }
      AppMethodBeat.o(91587);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ecc
 * JD-Core Version:    0.7.0.1
 */