package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class dks
  extends esc
{
  public String WLa;
  public int WLb;
  public String sign;
  public String xkX;
  public String xkY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82454);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(82454);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.WLa != null) {
        paramVarArgs.g(2, this.WLa);
      }
      if (this.xkX != null) {
        paramVarArgs.g(3, this.xkX);
      }
      if (this.xkY != null) {
        paramVarArgs.g(4, this.xkY);
      }
      if (this.sign != null) {
        paramVarArgs.g(5, this.sign);
      }
      paramVarArgs.bS(6, this.WLb);
      AppMethodBeat.o(82454);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label620;
      }
    }
    label620:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.WLa != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.WLa);
      }
      i = paramInt;
      if (this.xkX != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.xkX);
      }
      paramInt = i;
      if (this.xkY != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.xkY);
      }
      i = paramInt;
      if (this.sign != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.sign);
      }
      paramInt = i.a.a.b.b.a.cJ(6, this.WLb);
      AppMethodBeat.o(82454);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(82454);
          throw paramVarArgs;
        }
        AppMethodBeat.o(82454);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        dks localdks = (dks)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82454);
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
            localdks.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(82454);
          return 0;
        case 2: 
          localdks.WLa = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(82454);
          return 0;
        case 3: 
          localdks.xkX = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(82454);
          return 0;
        case 4: 
          localdks.xkY = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(82454);
          return 0;
        case 5: 
          localdks.sign = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(82454);
          return 0;
        }
        localdks.WLb = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(82454);
        return 0;
      }
      AppMethodBeat.o(82454);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dks
 * JD-Core Version:    0.7.0.1
 */