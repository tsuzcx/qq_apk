package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class ejj
  extends esc
{
  public LinkedList<dve> abaS;
  public String abaT;
  public LinkedList<dvb> abaX;
  public dvf abba;
  public boolean abnX;
  public String appid;
  public String nSt;
  public boolean rGY;
  public int rGZ;
  public int rHa;
  public String rHb;
  public String rHc;
  
  public ejj()
  {
    AppMethodBeat.i(82468);
    this.abaS = new LinkedList();
    this.abaX = new LinkedList();
    AppMethodBeat.o(82468);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(82469);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(82469);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.di(2, this.abnX);
      paramVarArgs.e(3, 8, this.abaS);
      if (this.appid != null) {
        paramVarArgs.g(4, this.appid);
      }
      if (this.nSt != null) {
        paramVarArgs.g(5, this.nSt);
      }
      if (this.abaT != null) {
        paramVarArgs.g(6, this.abaT);
      }
      paramVarArgs.e(7, 8, this.abaX);
      paramVarArgs.di(8, this.rGY);
      paramVarArgs.bS(9, this.rGZ);
      paramVarArgs.bS(10, this.rHa);
      if (this.rHb != null) {
        paramVarArgs.g(11, this.rHb);
      }
      if (this.rHc != null) {
        paramVarArgs.g(12, this.rHc);
      }
      if (this.abba != null)
      {
        paramVarArgs.qD(13, this.abba.computeSize());
        this.abba.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(82469);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1182;
      }
    }
    label1182:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + (i.a.a.b.b.a.ko(2) + 1) + i.a.a.a.c(3, 8, this.abaS);
      paramInt = i;
      if (this.appid != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.appid);
      }
      i = paramInt;
      if (this.nSt != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.nSt);
      }
      paramInt = i;
      if (this.abaT != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.abaT);
      }
      i = paramInt + i.a.a.a.c(7, 8, this.abaX) + (i.a.a.b.b.a.ko(8) + 1) + i.a.a.b.b.a.cJ(9, this.rGZ) + i.a.a.b.b.a.cJ(10, this.rHa);
      paramInt = i;
      if (this.rHb != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.rHb);
      }
      i = paramInt;
      if (this.rHc != null) {
        i = paramInt + i.a.a.b.b.a.h(12, this.rHc);
      }
      paramInt = i;
      if (this.abba != null) {
        paramInt = i + i.a.a.a.qC(13, this.abba.computeSize());
      }
      AppMethodBeat.o(82469);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abaS.clear();
        this.abaX.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(82469);
          throw paramVarArgs;
        }
        AppMethodBeat.o(82469);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ejj localejj = (ejj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(82469);
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
            localejj.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(82469);
          return 0;
        case 2: 
          localejj.abnX = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(82469);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dve();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dve)localObject2).parseFrom((byte[])localObject1);
            }
            localejj.abaS.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(82469);
          return 0;
        case 4: 
          localejj.appid = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(82469);
          return 0;
        case 5: 
          localejj.nSt = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(82469);
          return 0;
        case 6: 
          localejj.abaT = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(82469);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dvb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dvb)localObject2).parseFrom((byte[])localObject1);
            }
            localejj.abaX.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(82469);
          return 0;
        case 8: 
          localejj.rGY = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(82469);
          return 0;
        case 9: 
          localejj.rGZ = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(82469);
          return 0;
        case 10: 
          localejj.rHa = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(82469);
          return 0;
        case 11: 
          localejj.rHb = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(82469);
          return 0;
        case 12: 
          localejj.rHc = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(82469);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dvf();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dvf)localObject2).parseFrom((byte[])localObject1);
          }
          localejj.abba = ((dvf)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(82469);
        return 0;
      }
      AppMethodBeat.o(82469);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ejj
 * JD-Core Version:    0.7.0.1
 */