package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class aas
  extends esc
{
  public String Kmq;
  public long Zjf;
  public long Zjg;
  public String Zjh;
  public String Zji;
  public String icon_url;
  public dus ign;
  public String wuA;
  public int wuz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72458);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(72458);
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
      paramVarArgs.bv(4, this.Zjf);
      paramVarArgs.bv(5, this.Zjg);
      if (this.Zjh != null) {
        paramVarArgs.g(6, this.Zjh);
      }
      if (this.Zji != null) {
        paramVarArgs.g(7, this.Zji);
      }
      if (this.Kmq != null) {
        paramVarArgs.g(8, this.Kmq);
      }
      if (this.icon_url != null) {
        paramVarArgs.g(9, this.icon_url);
      }
      if (this.ign != null)
      {
        paramVarArgs.qD(10, this.ign.computeSize());
        this.ign.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72458);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label906;
      }
    }
    label906:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.wuz);
      paramInt = i;
      if (this.wuA != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wuA);
      }
      i = paramInt + i.a.a.b.b.a.q(4, this.Zjf) + i.a.a.b.b.a.q(5, this.Zjg);
      paramInt = i;
      if (this.Zjh != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.Zjh);
      }
      i = paramInt;
      if (this.Zji != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.Zji);
      }
      paramInt = i;
      if (this.Kmq != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.Kmq);
      }
      i = paramInt;
      if (this.icon_url != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.icon_url);
      }
      paramInt = i;
      if (this.ign != null) {
        paramInt = i + i.a.a.a.qC(10, this.ign.computeSize());
      }
      AppMethodBeat.o(72458);
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
          AppMethodBeat.o(72458);
          throw paramVarArgs;
        }
        AppMethodBeat.o(72458);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        aas localaas = (aas)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72458);
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
            localaas.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(72458);
          return 0;
        case 2: 
          localaas.wuz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(72458);
          return 0;
        case 3: 
          localaas.wuA = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72458);
          return 0;
        case 4: 
          localaas.Zjf = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(72458);
          return 0;
        case 5: 
          localaas.Zjg = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(72458);
          return 0;
        case 6: 
          localaas.Zjh = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72458);
          return 0;
        case 7: 
          localaas.Zji = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72458);
          return 0;
        case 8: 
          localaas.Kmq = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72458);
          return 0;
        case 9: 
          localaas.icon_url = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(72458);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dus();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dus)localObject2).parseFrom((byte[])localObject1);
          }
          localaas.ign = ((dus)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(72458);
        return 0;
      }
      AppMethodBeat.o(72458);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aas
 * JD-Core Version:    0.7.0.1
 */