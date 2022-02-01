package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eqg
  extends erp
{
  public String CAf;
  public String Ksi;
  public String abdU;
  public String abue;
  public int hYb;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(116341);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.CAf != null) {
        paramVarArgs.g(2, this.CAf);
      }
      if (this.abdU != null) {
        paramVarArgs.g(3, this.abdU);
      }
      paramVarArgs.bS(4, this.hYb);
      if (this.Ksi != null) {
        paramVarArgs.g(5, this.Ksi);
      }
      if (this.abue != null) {
        paramVarArgs.g(6, this.abue);
      }
      AppMethodBeat.o(116341);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label572;
      }
    }
    label572:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.CAf != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.CAf);
      }
      i = paramInt;
      if (this.abdU != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.abdU);
      }
      i += i.a.a.b.b.a.cJ(4, this.hYb);
      paramInt = i;
      if (this.Ksi != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.Ksi);
      }
      i = paramInt;
      if (this.abue != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.abue);
      }
      AppMethodBeat.o(116341);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(116341);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        eqg localeqg = (eqg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(116341);
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
            localeqg.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(116341);
          return 0;
        case 2: 
          localeqg.CAf = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(116341);
          return 0;
        case 3: 
          localeqg.abdU = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(116341);
          return 0;
        case 4: 
          localeqg.hYb = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(116341);
          return 0;
        case 5: 
          localeqg.Ksi = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(116341);
          return 0;
        }
        localeqg.abue = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(116341);
        return 0;
      }
      AppMethodBeat.o(116341);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eqg
 * JD-Core Version:    0.7.0.1
 */