package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eip
  extends erp
{
  public int JaC;
  public String VEr;
  public int VaY;
  public String Vbl;
  public String aaMM;
  public String aaMN;
  public String ablH;
  public int abnw;
  public int abnx;
  public int abny;
  public String hAk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91636);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.aaMN != null) {
        paramVarArgs.g(2, this.aaMN);
      }
      paramVarArgs.bS(3, this.abnw);
      paramVarArgs.bS(4, this.JaC);
      if (this.aaMM != null) {
        paramVarArgs.g(5, this.aaMM);
      }
      if (this.ablH != null) {
        paramVarArgs.g(7, this.ablH);
      }
      paramVarArgs.bS(8, this.VaY);
      if (this.hAk != null) {
        paramVarArgs.g(9, this.hAk);
      }
      if (this.VEr != null) {
        paramVarArgs.g(10, this.VEr);
      }
      paramVarArgs.bS(11, this.abnx);
      paramVarArgs.bS(12, this.abny);
      if (this.Vbl != null) {
        paramVarArgs.g(100, this.Vbl);
      }
      AppMethodBeat.o(91636);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label920;
      }
    }
    label920:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.aaMN != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.aaMN);
      }
      i = i + i.a.a.b.b.a.cJ(3, this.abnw) + i.a.a.b.b.a.cJ(4, this.JaC);
      paramInt = i;
      if (this.aaMM != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.aaMM);
      }
      i = paramInt;
      if (this.ablH != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.ablH);
      }
      i += i.a.a.b.b.a.cJ(8, this.VaY);
      paramInt = i;
      if (this.hAk != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.hAk);
      }
      i = paramInt;
      if (this.VEr != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.VEr);
      }
      i = i + i.a.a.b.b.a.cJ(11, this.abnx) + i.a.a.b.b.a.cJ(12, this.abny);
      paramInt = i;
      if (this.Vbl != null) {
        paramInt = i + i.a.a.b.b.a.h(100, this.Vbl);
      }
      AppMethodBeat.o(91636);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91636);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        eip localeip = (eip)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91636);
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
            localeip.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(91636);
          return 0;
        case 2: 
          localeip.aaMN = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91636);
          return 0;
        case 3: 
          localeip.abnw = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91636);
          return 0;
        case 4: 
          localeip.JaC = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91636);
          return 0;
        case 5: 
          localeip.aaMM = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91636);
          return 0;
        case 7: 
          localeip.ablH = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91636);
          return 0;
        case 8: 
          localeip.VaY = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91636);
          return 0;
        case 9: 
          localeip.hAk = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91636);
          return 0;
        case 10: 
          localeip.VEr = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91636);
          return 0;
        case 11: 
          localeip.abnx = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91636);
          return 0;
        case 12: 
          localeip.abny = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(91636);
          return 0;
        }
        localeip.Vbl = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(91636);
        return 0;
      }
      AppMethodBeat.o(91636);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eip
 * JD-Core Version:    0.7.0.1
 */