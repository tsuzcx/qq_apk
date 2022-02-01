package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class clp
  extends esc
{
  public long aarR;
  public String aarS;
  public emd aarT;
  public gim aarU;
  public String aatC;
  public adz aatD;
  public String aatE;
  public boolean aatF = true;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257809);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(257809);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(2, this.aarR);
      if (this.aarS != null) {
        paramVarArgs.g(3, this.aarS);
      }
      if (this.aatC != null) {
        paramVarArgs.g(4, this.aatC);
      }
      if (this.aatD != null)
      {
        paramVarArgs.qD(5, this.aatD.computeSize());
        this.aatD.writeFields(paramVarArgs);
      }
      if (this.aarT != null)
      {
        paramVarArgs.qD(6, this.aarT.computeSize());
        this.aarT.writeFields(paramVarArgs);
      }
      if (this.aatE != null) {
        paramVarArgs.g(7, this.aatE);
      }
      paramVarArgs.di(8, this.aatF);
      if (this.aarU != null)
      {
        paramVarArgs.qD(9, this.aarU.computeSize());
        this.aarU.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(257809);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1002;
      }
    }
    label1002:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.aarR);
      paramInt = i;
      if (this.aarS != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.aarS);
      }
      i = paramInt;
      if (this.aatC != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.aatC);
      }
      paramInt = i;
      if (this.aatD != null) {
        paramInt = i + i.a.a.a.qC(5, this.aatD.computeSize());
      }
      i = paramInt;
      if (this.aarT != null) {
        i = paramInt + i.a.a.a.qC(6, this.aarT.computeSize());
      }
      paramInt = i;
      if (this.aatE != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.aatE);
      }
      i = paramInt + (i.a.a.b.b.a.ko(8) + 1);
      paramInt = i;
      if (this.aarU != null) {
        paramInt = i + i.a.a.a.qC(9, this.aarU.computeSize());
      }
      AppMethodBeat.o(257809);
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
          AppMethodBeat.o(257809);
          throw paramVarArgs;
        }
        AppMethodBeat.o(257809);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        clp localclp = (clp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257809);
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
            localclp.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257809);
          return 0;
        case 2: 
          localclp.aarR = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(257809);
          return 0;
        case 3: 
          localclp.aarS = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257809);
          return 0;
        case 4: 
          localclp.aatC = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257809);
          return 0;
        case 5: 
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
            localclp.aatD = ((adz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257809);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new emd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((emd)localObject2).parseFrom((byte[])localObject1);
            }
            localclp.aarT = ((emd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257809);
          return 0;
        case 7: 
          localclp.aatE = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(257809);
          return 0;
        case 8: 
          localclp.aatF = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(257809);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new gim();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((gim)localObject2).parseFrom((byte[])localObject1);
          }
          localclp.aarU = ((gim)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(257809);
        return 0;
      }
      AppMethodBeat.o(257809);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.clp
 * JD-Core Version:    0.7.0.1
 */