package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c;
import i.a.a.b;
import java.util.LinkedList;

public final class so
  extends esc
{
  public long VIB;
  public c VIz;
  public long YXY;
  public LinkedList<String> YXZ;
  public int YYa;
  public int YYb;
  public String YYc;
  public String YYd;
  public String YYe;
  public boolean YYf;
  public String wuA;
  public int wuz;
  
  public so()
  {
    AppMethodBeat.i(91377);
    this.YXZ = new LinkedList();
    AppMethodBeat.o(91377);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91378);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(91378);
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
      paramVarArgs.bv(4, this.VIB);
      if (this.VIz != null)
      {
        paramVarArgs.qD(5, this.VIz.computeSize());
        this.VIz.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(6, this.YXY);
      paramVarArgs.e(7, 1, this.YXZ);
      paramVarArgs.bS(8, this.YYa);
      paramVarArgs.bS(9, this.YYb);
      if (this.YYc != null) {
        paramVarArgs.g(10, this.YYc);
      }
      if (this.YYd != null) {
        paramVarArgs.g(11, this.YYd);
      }
      if (this.YYe != null) {
        paramVarArgs.g(12, this.YYe);
      }
      paramVarArgs.di(13, this.YYf);
      AppMethodBeat.o(91378);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1038;
      }
    }
    label1038:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.wuz);
      paramInt = i;
      if (this.wuA != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wuA);
      }
      i = paramInt + i.a.a.b.b.a.q(4, this.VIB);
      paramInt = i;
      if (this.VIz != null) {
        paramInt = i + i.a.a.a.qC(5, this.VIz.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.q(6, this.YXY) + i.a.a.a.c(7, 1, this.YXZ) + i.a.a.b.b.a.cJ(8, this.YYa) + i.a.a.b.b.a.cJ(9, this.YYb);
      paramInt = i;
      if (this.YYc != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.YYc);
      }
      i = paramInt;
      if (this.YYd != null) {
        i = paramInt + i.a.a.b.b.a.h(11, this.YYd);
      }
      paramInt = i;
      if (this.YYe != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.YYe);
      }
      i = i.a.a.b.b.a.ko(13);
      AppMethodBeat.o(91378);
      return paramInt + (i + 1);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.YXZ.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(91378);
          throw paramVarArgs;
        }
        AppMethodBeat.o(91378);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        so localso = (so)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91378);
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
            localso.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91378);
          return 0;
        case 2: 
          localso.wuz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91378);
          return 0;
        case 3: 
          localso.wuA = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91378);
          return 0;
        case 4: 
          localso.VIB = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(91378);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new c();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((c)localObject2).parseFrom((byte[])localObject1);
            }
            localso.VIz = ((c)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(91378);
          return 0;
        case 6: 
          localso.YXY = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(91378);
          return 0;
        case 7: 
          localso.YXZ.add(((i.a.a.a.a)localObject1).ajGk.readString());
          AppMethodBeat.o(91378);
          return 0;
        case 8: 
          localso.YYa = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91378);
          return 0;
        case 9: 
          localso.YYb = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(91378);
          return 0;
        case 10: 
          localso.YYc = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91378);
          return 0;
        case 11: 
          localso.YYd = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91378);
          return 0;
        case 12: 
          localso.YYe = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(91378);
          return 0;
        }
        localso.YYf = ((i.a.a.a.a)localObject1).ajGk.aai();
        AppMethodBeat.o(91378);
        return 0;
      }
      AppMethodBeat.o(91378);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.so
 * JD-Core Version:    0.7.0.1
 */