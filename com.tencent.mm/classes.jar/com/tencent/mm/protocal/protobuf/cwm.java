package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class cwm
  extends esc
{
  public long ZoU;
  public String aaBC;
  public boolean aaBD = false;
  public gii aaBE;
  public long aarR;
  public String aarS;
  public String aatC;
  public adz aatD;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260004);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(260004);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(2, this.ZoU);
      paramVarArgs.bv(3, this.aarR);
      if (this.aaBC != null) {
        paramVarArgs.g(4, this.aaBC);
      }
      if (this.aarS != null) {
        paramVarArgs.g(5, this.aarS);
      }
      paramVarArgs.di(6, this.aaBD);
      if (this.aatC != null) {
        paramVarArgs.g(7, this.aatC);
      }
      if (this.aatD != null)
      {
        paramVarArgs.qD(8, this.aatD.computeSize());
        this.aatD.writeFields(paramVarArgs);
      }
      if (this.aaBE != null)
      {
        paramVarArgs.qD(9, this.aaBE.computeSize());
        this.aaBE.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(260004);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label912;
      }
    }
    label912:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.ZoU) + i.a.a.b.b.a.q(3, this.aarR);
      paramInt = i;
      if (this.aaBC != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aaBC);
      }
      i = paramInt;
      if (this.aarS != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.aarS);
      }
      i += i.a.a.b.b.a.ko(6) + 1;
      paramInt = i;
      if (this.aatC != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.aatC);
      }
      i = paramInt;
      if (this.aatD != null) {
        i = paramInt + i.a.a.a.qC(8, this.aatD.computeSize());
      }
      paramInt = i;
      if (this.aaBE != null) {
        paramInt = i + i.a.a.a.qC(9, this.aaBE.computeSize());
      }
      AppMethodBeat.o(260004);
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
          AppMethodBeat.o(260004);
          throw paramVarArgs;
        }
        AppMethodBeat.o(260004);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cwm localcwm = (cwm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(260004);
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
            localcwm.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260004);
          return 0;
        case 2: 
          localcwm.ZoU = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(260004);
          return 0;
        case 3: 
          localcwm.aarR = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(260004);
          return 0;
        case 4: 
          localcwm.aaBC = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(260004);
          return 0;
        case 5: 
          localcwm.aarS = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(260004);
          return 0;
        case 6: 
          localcwm.aaBD = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(260004);
          return 0;
        case 7: 
          localcwm.aatC = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(260004);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new adz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((adz)localObject2).parseFrom((byte[])localObject1);
            }
            localcwm.aatD = ((adz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(260004);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new gii();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((gii)localObject2).parseFrom((byte[])localObject1);
          }
          localcwm.aaBE = ((gii)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(260004);
        return 0;
      }
      AppMethodBeat.o(260004);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwm
 * JD-Core Version:    0.7.0.1
 */