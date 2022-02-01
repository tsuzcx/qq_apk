package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class aal
  extends esc
{
  public gjx ZiP;
  public boolean ZiQ;
  public String ZiR;
  public String ZiS;
  public boolean ZiT;
  public String ZiU;
  public String ZiV;
  public String ZiW;
  public String ZiX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123562);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123562);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.ZiP != null)
      {
        paramVarArgs.qD(2, this.ZiP.computeSize());
        this.ZiP.writeFields(paramVarArgs);
      }
      paramVarArgs.di(3, this.ZiQ);
      if (this.ZiR != null) {
        paramVarArgs.g(4, this.ZiR);
      }
      if (this.ZiS != null) {
        paramVarArgs.g(5, this.ZiS);
      }
      paramVarArgs.di(6, this.ZiT);
      if (this.ZiU != null) {
        paramVarArgs.g(7, this.ZiU);
      }
      if (this.ZiV != null) {
        paramVarArgs.g(8, this.ZiV);
      }
      if (this.ZiW != null) {
        paramVarArgs.g(9, this.ZiW);
      }
      if (this.ZiX != null) {
        paramVarArgs.g(10, this.ZiX);
      }
      AppMethodBeat.o(123562);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label918;
      }
    }
    label918:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ZiP != null) {
        i = paramInt + i.a.a.a.qC(2, this.ZiP.computeSize());
      }
      i += i.a.a.b.b.a.ko(3) + 1;
      paramInt = i;
      if (this.ZiR != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.ZiR);
      }
      i = paramInt;
      if (this.ZiS != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.ZiS);
      }
      i += i.a.a.b.b.a.ko(6) + 1;
      paramInt = i;
      if (this.ZiU != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.ZiU);
      }
      i = paramInt;
      if (this.ZiV != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.ZiV);
      }
      paramInt = i;
      if (this.ZiW != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.ZiW);
      }
      i = paramInt;
      if (this.ZiX != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.ZiX);
      }
      AppMethodBeat.o(123562);
      return i;
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
          AppMethodBeat.o(123562);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123562);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        aal localaal = (aal)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123562);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localaal.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123562);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gjx();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gjx)localObject2).parseFrom((byte[])localObject1);
            }
            localaal.ZiP = ((gjx)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123562);
          return 0;
        case 3: 
          localaal.ZiQ = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(123562);
          return 0;
        case 4: 
          localaal.ZiR = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123562);
          return 0;
        case 5: 
          localaal.ZiS = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123562);
          return 0;
        case 6: 
          localaal.ZiT = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(123562);
          return 0;
        case 7: 
          localaal.ZiU = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123562);
          return 0;
        case 8: 
          localaal.ZiV = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123562);
          return 0;
        case 9: 
          localaal.ZiW = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123562);
          return 0;
        }
        localaal.ZiX = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(123562);
        return 0;
      }
      AppMethodBeat.o(123562);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aal
 * JD-Core Version:    0.7.0.1
 */