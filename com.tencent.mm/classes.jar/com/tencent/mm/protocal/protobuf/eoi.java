package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eoi
  extends erp
{
  public int JaC;
  public String Vbl;
  public String ZlW;
  public int ablD;
  public String ablH;
  public String ablI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91665);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.ablD);
      if (this.ablI != null) {
        paramVarArgs.g(3, this.ablI);
      }
      if (this.ZlW != null) {
        paramVarArgs.g(4, this.ZlW);
      }
      paramVarArgs.bS(5, this.JaC);
      if (this.ablH != null) {
        paramVarArgs.g(6, this.ablH);
      }
      if (this.Vbl != null) {
        paramVarArgs.g(100, this.Vbl);
      }
      AppMethodBeat.o(91665);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label640;
      }
    }
    label640:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.ablD);
      paramInt = i;
      if (this.ablI != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.ablI);
      }
      i = paramInt;
      if (this.ZlW != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.ZlW);
      }
      i += i.a.a.b.b.a.cJ(5, this.JaC);
      paramInt = i;
      if (this.ablH != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.ablH);
      }
      i = paramInt;
      if (this.Vbl != null) {
        i = paramInt + i.a.a.b.b.a.h(100, this.Vbl);
      }
      AppMethodBeat.o(91665);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91665);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        eoi localeoi = (eoi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91665);
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
            localeoi.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(91665);
          return 0;
        case 2: 
          localeoi.ablD = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91665);
          return 0;
        case 3: 
          localeoi.ablI = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91665);
          return 0;
        case 4: 
          localeoi.ZlW = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91665);
          return 0;
        case 5: 
          localeoi.JaC = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91665);
          return 0;
        case 6: 
          localeoi.ablH = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91665);
          return 0;
        }
        localeoi.Vbl = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(91665);
        return 0;
      }
      AppMethodBeat.o(91665);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eoi
 * JD-Core Version:    0.7.0.1
 */