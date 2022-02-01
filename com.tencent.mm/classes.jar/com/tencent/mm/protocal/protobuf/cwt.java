package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cwt
  extends erp
{
  public aeo YMR;
  public int YWM;
  public String aaBO;
  public int aaBP;
  public boolean aaBQ;
  public dzz aaBR;
  public String aaBS;
  public LinkedList<dra> aaBT;
  public int aaBU;
  public boolean aaBV;
  public boolean aaBW;
  public String aazm;
  public int aazp;
  public String appid;
  public String path;
  public int scene;
  public int type;
  public String username;
  
  public cwt()
  {
    AppMethodBeat.i(123586);
    this.aaBQ = false;
    this.aaBT = new LinkedList();
    AppMethodBeat.o(123586);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123587);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.type);
      if (this.appid != null) {
        paramVarArgs.g(3, this.appid);
      }
      paramVarArgs.bS(4, this.YWM);
      if (this.aaBO != null) {
        paramVarArgs.g(5, this.aaBO);
      }
      paramVarArgs.bS(6, this.aazp);
      paramVarArgs.bS(7, this.aaBP);
      if (this.aazm != null) {
        paramVarArgs.g(8, this.aazm);
      }
      paramVarArgs.di(9, this.aaBQ);
      if (this.aaBR != null)
      {
        paramVarArgs.qD(10, this.aaBR.computeSize());
        this.aaBR.writeFields(paramVarArgs);
      }
      if (this.aaBS != null) {
        paramVarArgs.g(11, this.aaBS);
      }
      paramVarArgs.e(12, 8, this.aaBT);
      paramVarArgs.bS(13, this.aaBU);
      if (this.username != null) {
        paramVarArgs.g(14, this.username);
      }
      if (this.path != null) {
        paramVarArgs.g(15, this.path);
      }
      paramVarArgs.di(16, this.aaBV);
      paramVarArgs.di(17, this.aaBW);
      paramVarArgs.bS(18, this.scene);
      if (this.YMR != null)
      {
        paramVarArgs.qD(19, this.YMR.computeSize());
        this.YMR.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(123587);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1438;
      }
    }
    label1438:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.type);
      paramInt = i;
      if (this.appid != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.appid);
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.YWM);
      paramInt = i;
      if (this.aaBO != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.aaBO);
      }
      i = paramInt + i.a.a.b.b.a.cJ(6, this.aazp) + i.a.a.b.b.a.cJ(7, this.aaBP);
      paramInt = i;
      if (this.aazm != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.aazm);
      }
      i = paramInt + (i.a.a.b.b.a.ko(9) + 1);
      paramInt = i;
      if (this.aaBR != null) {
        paramInt = i + i.a.a.a.qC(10, this.aaBR.computeSize());
      }
      i = paramInt;
      if (this.aaBS != null) {
        i = paramInt + i.a.a.b.b.a.h(11, this.aaBS);
      }
      i = i + i.a.a.a.c(12, 8, this.aaBT) + i.a.a.b.b.a.cJ(13, this.aaBU);
      paramInt = i;
      if (this.username != null) {
        paramInt = i + i.a.a.b.b.a.h(14, this.username);
      }
      i = paramInt;
      if (this.path != null) {
        i = paramInt + i.a.a.b.b.a.h(15, this.path);
      }
      i = i + (i.a.a.b.b.a.ko(16) + 1) + (i.a.a.b.b.a.ko(17) + 1) + i.a.a.b.b.a.cJ(18, this.scene);
      paramInt = i;
      if (this.YMR != null) {
        paramInt = i + i.a.a.a.qC(19, this.YMR.computeSize());
      }
      AppMethodBeat.o(123587);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aaBT.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(123587);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cwt localcwt = (cwt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123587);
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
            localcwt.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123587);
          return 0;
        case 2: 
          localcwt.type = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(123587);
          return 0;
        case 3: 
          localcwt.appid = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123587);
          return 0;
        case 4: 
          localcwt.YWM = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(123587);
          return 0;
        case 5: 
          localcwt.aaBO = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123587);
          return 0;
        case 6: 
          localcwt.aazp = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(123587);
          return 0;
        case 7: 
          localcwt.aaBP = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(123587);
          return 0;
        case 8: 
          localcwt.aazm = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123587);
          return 0;
        case 9: 
          localcwt.aaBQ = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(123587);
          return 0;
        case 10: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dzz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dzz)localObject2).parseFrom((byte[])localObject1);
            }
            localcwt.aaBR = ((dzz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123587);
          return 0;
        case 11: 
          localcwt.aaBS = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123587);
          return 0;
        case 12: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dra();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dra)localObject2).parseFrom((byte[])localObject1);
            }
            localcwt.aaBT.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(123587);
          return 0;
        case 13: 
          localcwt.aaBU = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(123587);
          return 0;
        case 14: 
          localcwt.username = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123587);
          return 0;
        case 15: 
          localcwt.path = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(123587);
          return 0;
        case 16: 
          localcwt.aaBV = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(123587);
          return 0;
        case 17: 
          localcwt.aaBW = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(123587);
          return 0;
        case 18: 
          localcwt.scene = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(123587);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new aeo();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((aeo)localObject2).parseFrom((byte[])localObject1);
          }
          localcwt.YMR = ((aeo)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(123587);
        return 0;
      }
      AppMethodBeat.o(123587);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cwt
 * JD-Core Version:    0.7.0.1
 */