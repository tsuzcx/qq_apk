package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public class dgu
  extends esc
{
  public dgp aaLZ;
  public aat aaMa;
  public gki aaMb;
  public eim aaMc;
  public bk aaMd;
  public dyz aaMe;
  public gmj aaMf;
  public int aaMg;
  public String appid;
  public String eqk;
  public String username;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123625);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(123625);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.aaLZ != null)
      {
        paramVarArgs.qD(2, this.aaLZ.computeSize());
        this.aaLZ.writeFields(paramVarArgs);
      }
      if (this.aaMa != null)
      {
        paramVarArgs.qD(3, this.aaMa.computeSize());
        this.aaMa.writeFields(paramVarArgs);
      }
      if (this.aaMb != null)
      {
        paramVarArgs.qD(4, this.aaMb.computeSize());
        this.aaMb.writeFields(paramVarArgs);
      }
      if (this.aaMc != null)
      {
        paramVarArgs.qD(5, this.aaMc.computeSize());
        this.aaMc.writeFields(paramVarArgs);
      }
      if (this.aaMd != null)
      {
        paramVarArgs.qD(6, this.aaMd.computeSize());
        this.aaMd.writeFields(paramVarArgs);
      }
      if (this.aaMe != null)
      {
        paramVarArgs.qD(7, this.aaMe.computeSize());
        this.aaMe.writeFields(paramVarArgs);
      }
      if (this.appid != null) {
        paramVarArgs.g(8, this.appid);
      }
      if (this.username != null) {
        paramVarArgs.g(9, this.username);
      }
      if (this.eqk != null) {
        paramVarArgs.g(10, this.eqk);
      }
      if (this.aaMf != null)
      {
        paramVarArgs.qD(11, this.aaMf.computeSize());
        this.aaMf.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(12, this.aaMg);
      AppMethodBeat.o(123625);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1494;
      }
    }
    label1494:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aaLZ != null) {
        paramInt = i + i.a.a.a.qC(2, this.aaLZ.computeSize());
      }
      i = paramInt;
      if (this.aaMa != null) {
        i = paramInt + i.a.a.a.qC(3, this.aaMa.computeSize());
      }
      paramInt = i;
      if (this.aaMb != null) {
        paramInt = i + i.a.a.a.qC(4, this.aaMb.computeSize());
      }
      i = paramInt;
      if (this.aaMc != null) {
        i = paramInt + i.a.a.a.qC(5, this.aaMc.computeSize());
      }
      paramInt = i;
      if (this.aaMd != null) {
        paramInt = i + i.a.a.a.qC(6, this.aaMd.computeSize());
      }
      i = paramInt;
      if (this.aaMe != null) {
        i = paramInt + i.a.a.a.qC(7, this.aaMe.computeSize());
      }
      paramInt = i;
      if (this.appid != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.appid);
      }
      i = paramInt;
      if (this.username != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.username);
      }
      paramInt = i;
      if (this.eqk != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.eqk);
      }
      i = paramInt;
      if (this.aaMf != null) {
        i = paramInt + i.a.a.a.qC(11, this.aaMf.computeSize());
      }
      paramInt = i.a.a.b.b.a.cJ(12, this.aaMg);
      AppMethodBeat.o(123625);
      return i + paramInt;
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
          AppMethodBeat.o(123625);
          throw paramVarArgs;
        }
        AppMethodBeat.o(123625);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dgu localdgu = (dgu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123625);
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
            localdgu.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123625);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dgp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dgp)localObject2).parseFrom((byte[])localObject1);
            }
            localdgu.aaLZ = ((dgp)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123625);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new aat();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((aat)localObject2).parseFrom((byte[])localObject1);
            }
            localdgu.aaMa = ((aat)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123625);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gki();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gki)localObject2).parseFrom((byte[])localObject1);
            }
            localdgu.aaMb = ((gki)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123625);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eim();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eim)localObject2).parseFrom((byte[])localObject1);
            }
            localdgu.aaMc = ((eim)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123625);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bk();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bk)localObject2).parseFrom((byte[])localObject1);
            }
            localdgu.aaMd = ((bk)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123625);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dyz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dyz)localObject2).parseFrom((byte[])localObject1);
            }
            localdgu.aaMe = ((dyz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123625);
          return 0;
        case 8: 
          localdgu.appid = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123625);
          return 0;
        case 9: 
          localdgu.username = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123625);
          return 0;
        case 10: 
          localdgu.eqk = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123625);
          return 0;
        case 11: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gmj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gmj)localObject2).parseFrom((byte[])localObject1);
            }
            localdgu.aaMf = ((gmj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123625);
          return 0;
        }
        localdgu.aaMg = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(123625);
        return 0;
      }
      AppMethodBeat.o(123625);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dgu
 * JD-Core Version:    0.7.0.1
 */