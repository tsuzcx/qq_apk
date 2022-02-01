package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class abc
  extends erp
{
  public int IJG;
  public String ZjA;
  public String ZjB;
  public String ZjC;
  public String ZjD;
  public String ZjE;
  public int ZjF;
  public String ZjG;
  public String Zjz;
  public String hAP;
  public String oOI;
  public String oOv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(63271);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.oOv != null) {
        paramVarArgs.g(2, this.oOv);
      }
      if (this.hAP != null) {
        paramVarArgs.g(3, this.hAP);
      }
      if (this.Zjz != null) {
        paramVarArgs.g(4, this.Zjz);
      }
      if (this.ZjA != null) {
        paramVarArgs.g(5, this.ZjA);
      }
      if (this.ZjB != null) {
        paramVarArgs.g(6, this.ZjB);
      }
      if (this.ZjC != null) {
        paramVarArgs.g(7, this.ZjC);
      }
      if (this.ZjD != null) {
        paramVarArgs.g(8, this.ZjD);
      }
      if (this.oOI != null) {
        paramVarArgs.g(9, this.oOI);
      }
      paramVarArgs.bS(10, this.IJG);
      if (this.ZjE != null) {
        paramVarArgs.g(11, this.ZjE);
      }
      paramVarArgs.bS(12, this.ZjF);
      if (this.ZjG != null) {
        paramVarArgs.g(13, this.ZjG);
      }
      AppMethodBeat.o(63271);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label988;
      }
    }
    label988:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.oOv != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.oOv);
      }
      i = paramInt;
      if (this.hAP != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.hAP);
      }
      paramInt = i;
      if (this.Zjz != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.Zjz);
      }
      i = paramInt;
      if (this.ZjA != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.ZjA);
      }
      paramInt = i;
      if (this.ZjB != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.ZjB);
      }
      i = paramInt;
      if (this.ZjC != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.ZjC);
      }
      paramInt = i;
      if (this.ZjD != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.ZjD);
      }
      i = paramInt;
      if (this.oOI != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.oOI);
      }
      i += i.a.a.b.b.a.cJ(10, this.IJG);
      paramInt = i;
      if (this.ZjE != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.ZjE);
      }
      i = paramInt + i.a.a.b.b.a.cJ(12, this.ZjF);
      paramInt = i;
      if (this.ZjG != null) {
        paramInt = i + i.a.a.b.b.a.h(13, this.ZjG);
      }
      AppMethodBeat.o(63271);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(63271);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        abc localabc = (abc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(63271);
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
            localabc.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(63271);
          return 0;
        case 2: 
          localabc.oOv = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(63271);
          return 0;
        case 3: 
          localabc.hAP = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(63271);
          return 0;
        case 4: 
          localabc.Zjz = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(63271);
          return 0;
        case 5: 
          localabc.ZjA = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(63271);
          return 0;
        case 6: 
          localabc.ZjB = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(63271);
          return 0;
        case 7: 
          localabc.ZjC = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(63271);
          return 0;
        case 8: 
          localabc.ZjD = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(63271);
          return 0;
        case 9: 
          localabc.oOI = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(63271);
          return 0;
        case 10: 
          localabc.IJG = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(63271);
          return 0;
        case 11: 
          localabc.ZjE = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(63271);
          return 0;
        case 12: 
          localabc.ZjF = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(63271);
          return 0;
        }
        localabc.ZjG = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(63271);
        return 0;
      }
      AppMethodBeat.o(63271);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.abc
 * JD-Core Version:    0.7.0.1
 */