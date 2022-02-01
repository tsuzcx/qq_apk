package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fhf
  extends com.tencent.mm.bx.a
{
  public fhe abHR;
  public fhe abHS;
  public fhe abHT;
  public int abHU;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123655);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abHR != null)
      {
        paramVarArgs.qD(1, this.abHR.computeSize());
        this.abHR.writeFields(paramVarArgs);
      }
      if (this.abHS != null)
      {
        paramVarArgs.qD(2, this.abHS.computeSize());
        this.abHS.writeFields(paramVarArgs);
      }
      if (this.abHT != null)
      {
        paramVarArgs.qD(3, this.abHT.computeSize());
        this.abHT.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(4, this.scene);
      paramVarArgs.bS(5, this.abHU);
      AppMethodBeat.o(123655);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abHR == null) {
        break label640;
      }
    }
    label640:
    for (int i = i.a.a.a.qC(1, this.abHR.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abHS != null) {
        paramInt = i + i.a.a.a.qC(2, this.abHS.computeSize());
      }
      i = paramInt;
      if (this.abHT != null) {
        i = paramInt + i.a.a.a.qC(3, this.abHT.computeSize());
      }
      paramInt = i.a.a.b.b.a.cJ(4, this.scene);
      int j = i.a.a.b.b.a.cJ(5, this.abHU);
      AppMethodBeat.o(123655);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(123655);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fhf localfhf = (fhf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        fhe localfhe;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123655);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localfhe = new fhe();
            if ((localObject != null) && (localObject.length > 0)) {
              localfhe.parseFrom((byte[])localObject);
            }
            localfhf.abHR = localfhe;
            paramInt += 1;
          }
          AppMethodBeat.o(123655);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localfhe = new fhe();
            if ((localObject != null) && (localObject.length > 0)) {
              localfhe.parseFrom((byte[])localObject);
            }
            localfhf.abHS = localfhe;
            paramInt += 1;
          }
          AppMethodBeat.o(123655);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localfhe = new fhe();
            if ((localObject != null) && (localObject.length > 0)) {
              localfhe.parseFrom((byte[])localObject);
            }
            localfhf.abHT = localfhe;
            paramInt += 1;
          }
          AppMethodBeat.o(123655);
          return 0;
        case 4: 
          localfhf.scene = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(123655);
          return 0;
        }
        localfhf.abHU = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(123655);
        return 0;
      }
      AppMethodBeat.o(123655);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fhf
 * JD-Core Version:    0.7.0.1
 */