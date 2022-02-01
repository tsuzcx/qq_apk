package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class aau
  extends erp
{
  public String UUID;
  public int YOO;
  public gol YOj;
  public int muB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258533);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YOj == null)
      {
        paramVarArgs = new b("Not all required fields were included: RandomEncryKey");
        AppMethodBeat.o(258533);
        throw paramVarArgs;
      }
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.YOj != null)
      {
        paramVarArgs.qD(2, this.YOj.computeSize());
        this.YOj.writeFields(paramVarArgs);
      }
      if (this.UUID != null) {
        paramVarArgs.g(3, this.UUID);
      }
      paramVarArgs.bS(4, this.muB);
      paramVarArgs.bS(5, this.YOO);
      AppMethodBeat.o(258533);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label614;
      }
    }
    label614:
    for (int i = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YOj != null) {
        paramInt = i + i.a.a.a.qC(2, this.YOj.computeSize());
      }
      i = paramInt;
      if (this.UUID != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.UUID);
      }
      paramInt = i.a.a.b.b.a.cJ(4, this.muB);
      int j = i.a.a.b.b.a.cJ(5, this.YOO);
      AppMethodBeat.o(258533);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.YOj == null)
        {
          paramVarArgs = new b("Not all required fields were included: RandomEncryKey");
          AppMethodBeat.o(258533);
          throw paramVarArgs;
        }
        AppMethodBeat.o(258533);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        aau localaau = (aau)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258533);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localaau.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258533);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localaau.YOj = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258533);
          return 0;
        case 3: 
          localaau.UUID = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258533);
          return 0;
        case 4: 
          localaau.muB = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258533);
          return 0;
        }
        localaau.YOO = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(258533);
        return 0;
      }
      AppMethodBeat.o(258533);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aau
 * JD-Core Version:    0.7.0.1
 */