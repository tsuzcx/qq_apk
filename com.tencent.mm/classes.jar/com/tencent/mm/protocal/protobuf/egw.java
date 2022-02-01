package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class egw
  extends esc
{
  public String YzL;
  public dop aauM;
  public dcl ablX;
  public String abmj;
  public String abmk;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259102);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(259102);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.aauM != null)
      {
        paramVarArgs.qD(2, this.aauM.computeSize());
        this.aauM.writeFields(paramVarArgs);
      }
      if (this.YzL != null) {
        paramVarArgs.g(3, this.YzL);
      }
      if (this.abmj != null) {
        paramVarArgs.g(4, this.abmj);
      }
      if (this.abmk != null) {
        paramVarArgs.g(5, this.abmk);
      }
      if (this.ablX != null)
      {
        paramVarArgs.qD(100, this.ablX.computeSize());
        this.ablX.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(259102);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label800;
      }
    }
    label800:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aauM != null) {
        paramInt = i + i.a.a.a.qC(2, this.aauM.computeSize());
      }
      i = paramInt;
      if (this.YzL != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YzL);
      }
      paramInt = i;
      if (this.abmj != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.abmj);
      }
      i = paramInt;
      if (this.abmk != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.abmk);
      }
      paramInt = i;
      if (this.ablX != null) {
        paramInt = i + i.a.a.a.qC(100, this.ablX.computeSize());
      }
      AppMethodBeat.o(259102);
      return paramInt;
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
          AppMethodBeat.o(259102);
          throw paramVarArgs;
        }
        AppMethodBeat.o(259102);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        egw localegw = (egw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259102);
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
            localegw.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259102);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dop();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dop)localObject2).parseFrom((byte[])localObject1);
            }
            localegw.aauM = ((dop)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259102);
          return 0;
        case 3: 
          localegw.YzL = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259102);
          return 0;
        case 4: 
          localegw.abmj = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259102);
          return 0;
        case 5: 
          localegw.abmk = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259102);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dcl();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dcl)localObject2).parseFrom((byte[])localObject1);
          }
          localegw.ablX = ((dcl)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(259102);
        return 0;
      }
      AppMethodBeat.o(259102);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.egw
 * JD-Core Version:    0.7.0.1
 */