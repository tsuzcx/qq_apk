package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.c;
import i.a.a.b;
import java.util.LinkedList;

public final class up
  extends esc
{
  public c VIz;
  public long YXY;
  public LinkedList<String> YXZ;
  public int YYa;
  public int YYb;
  public String YYc;
  public String YYd;
  public String YYe;
  public String pHu;
  public String wuA;
  public int wuz;
  
  public up()
  {
    AppMethodBeat.i(259124);
    this.YXZ = new LinkedList();
    AppMethodBeat.o(259124);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259128);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(259128);
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
      if (this.VIz != null)
      {
        paramVarArgs.qD(4, this.VIz.computeSize());
        this.VIz.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(5, this.YXY);
      paramVarArgs.bS(6, this.YYb);
      paramVarArgs.e(7, 1, this.YXZ);
      paramVarArgs.bS(8, this.YYa);
      if (this.YYc != null) {
        paramVarArgs.g(9, this.YYc);
      }
      if (this.YYd != null) {
        paramVarArgs.g(10, this.YYd);
      }
      if (this.YYe != null) {
        paramVarArgs.g(11, this.YYe);
      }
      if (this.pHu != null) {
        paramVarArgs.g(12, this.pHu);
      }
      AppMethodBeat.o(259128);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1010;
      }
    }
    label1010:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.wuz);
      paramInt = i;
      if (this.wuA != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.wuA);
      }
      i = paramInt;
      if (this.VIz != null) {
        i = paramInt + i.a.a.a.qC(4, this.VIz.computeSize());
      }
      i = i + i.a.a.b.b.a.q(5, this.YXY) + i.a.a.b.b.a.cJ(6, this.YYb) + i.a.a.a.c(7, 1, this.YXZ) + i.a.a.b.b.a.cJ(8, this.YYa);
      paramInt = i;
      if (this.YYc != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.YYc);
      }
      i = paramInt;
      if (this.YYd != null) {
        i = paramInt + i.a.a.b.b.a.h(10, this.YYd);
      }
      paramInt = i;
      if (this.YYe != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.YYe);
      }
      i = paramInt;
      if (this.pHu != null) {
        i = paramInt + i.a.a.b.b.a.h(12, this.pHu);
      }
      AppMethodBeat.o(259128);
      return i;
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
          AppMethodBeat.o(259128);
          throw paramVarArgs;
        }
        AppMethodBeat.o(259128);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        up localup = (up)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259128);
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
            localup.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259128);
          return 0;
        case 2: 
          localup.wuz = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259128);
          return 0;
        case 3: 
          localup.wuA = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259128);
          return 0;
        case 4: 
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
            localup.VIz = ((c)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259128);
          return 0;
        case 5: 
          localup.YXY = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(259128);
          return 0;
        case 6: 
          localup.YYb = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259128);
          return 0;
        case 7: 
          localup.YXZ.add(((i.a.a.a.a)localObject1).ajGk.readString());
          AppMethodBeat.o(259128);
          return 0;
        case 8: 
          localup.YYa = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(259128);
          return 0;
        case 9: 
          localup.YYc = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259128);
          return 0;
        case 10: 
          localup.YYd = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259128);
          return 0;
        case 11: 
          localup.YYe = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259128);
          return 0;
        }
        localup.pHu = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(259128);
        return 0;
      }
      AppMethodBeat.o(259128);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.up
 * JD-Core Version:    0.7.0.1
 */