package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class aaq
  extends esc
{
  public cyp Zjb;
  public LinkedList<cyo> Zjc;
  public String Zjd;
  public String wuA;
  public int wuz;
  
  public aaq()
  {
    AppMethodBeat.i(72455);
    this.Zjc = new LinkedList();
    AppMethodBeat.o(72455);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72456);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72456);
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
      paramVarArgs.e(5, 8, this.Zjc);
      if (this.Zjd != null) {
        paramVarArgs.g(6, this.Zjd);
      }
      AppMethodBeat.o(72456);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label752;
      }
    }
    label752:
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
      i += i.a.a.a.c(5, 8, this.Zjc);
      paramInt = i;
      if (this.Zjd != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.Zjd);
      }
      AppMethodBeat.o(72456);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.Zjc.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(72456);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72456);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        aaq localaaq = (aaq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72456);
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
            localaaq.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72456);
          return 0;
        case 2: 
          localaaq.wuz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(72456);
          return 0;
        case 3: 
          localaaq.wuA = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72456);
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
            localaaq.Zjb = ((cyp)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72456);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cyo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cyo)localObject2).parseFrom((byte[])localObject1);
            }
            localaaq.Zjc.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72456);
          return 0;
        }
        localaaq.Zjd = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(72456);
        return 0;
      }
      AppMethodBeat.o(72456);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aaq
 * JD-Core Version:    0.7.0.1
 */