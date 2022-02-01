package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class clb
  extends esc
{
  public cyp Zjb;
  public dmd aaqU;
  public uj aatd;
  public cyn aate;
  public dah aatf;
  public String wuA;
  public int wuz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72489);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72489);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.wuz);
      if (this.wuA != null) {
        paramVarArgs.g(3, this.wuA);
      }
      if (this.Zjb != null)
      {
        paramVarArgs.qD(4, this.Zjb.computeSize());
        this.Zjb.writeFields(paramVarArgs);
      }
      if (this.aatd != null)
      {
        paramVarArgs.qD(8, this.aatd.computeSize());
        this.aatd.writeFields(paramVarArgs);
      }
      if (this.aaqU != null)
      {
        paramVarArgs.qD(9, this.aaqU.computeSize());
        this.aaqU.writeFields(paramVarArgs);
      }
      if (this.aate != null)
      {
        paramVarArgs.qD(10, this.aate.computeSize());
        this.aate.writeFields(paramVarArgs);
      }
      if (this.aatf != null)
      {
        paramVarArgs.qD(11, this.aatf.computeSize());
        this.aatf.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72489);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1118;
      }
    }
    label1118:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.wuz);
      paramInt = i;
      if (this.wuA != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wuA);
      }
      i = paramInt;
      if (this.Zjb != null) {
        i = paramInt + i.a.a.a.qC(4, this.Zjb.computeSize());
      }
      paramInt = i;
      if (this.aatd != null) {
        paramInt = i + i.a.a.a.qC(8, this.aatd.computeSize());
      }
      i = paramInt;
      if (this.aaqU != null) {
        i = paramInt + i.a.a.a.qC(9, this.aaqU.computeSize());
      }
      paramInt = i;
      if (this.aate != null) {
        paramInt = i + i.a.a.a.qC(10, this.aate.computeSize());
      }
      i = paramInt;
      if (this.aatf != null) {
        i = paramInt + i.a.a.a.qC(11, this.aatf.computeSize());
      }
      AppMethodBeat.o(72489);
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
          AppMethodBeat.o(72489);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72489);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        clb localclb = (clb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        case 5: 
        case 6: 
        case 7: 
        default: 
          AppMethodBeat.o(72489);
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
            localclb.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72489);
          return 0;
        case 2: 
          localclb.wuz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(72489);
          return 0;
        case 3: 
          localclb.wuA = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72489);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cyp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cyp)localObject2).parseFrom((byte[])localObject1);
            }
            localclb.Zjb = ((cyp)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72489);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new uj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((uj)localObject2).parseFrom((byte[])localObject1);
            }
            localclb.aatd = ((uj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72489);
          return 0;
        case 9: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dmd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dmd)localObject2).parseFrom((byte[])localObject1);
            }
            localclb.aaqU = ((dmd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72489);
          return 0;
        case 10: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cyn();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cyn)localObject2).parseFrom((byte[])localObject1);
            }
            localclb.aate = ((cyn)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72489);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dah();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dah)localObject2).parseFrom((byte[])localObject1);
          }
          localclb.aatf = ((dah)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(72489);
        return 0;
      }
      AppMethodBeat.o(72489);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.clb
 * JD-Core Version:    0.7.0.1
 */