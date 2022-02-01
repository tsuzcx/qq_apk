package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class dzt
  extends com.tencent.mm.bx.a
{
  public LinkedList<dzs> abeS;
  public int abeT;
  public int abeU;
  public ery abeV;
  public int abeW;
  public LinkedList<dzr> abeX;
  public boolean abeY;
  public LinkedList<ery> abeZ;
  public int state;
  public String ycW;
  
  public dzt()
  {
    AppMethodBeat.i(117544);
    this.abeS = new LinkedList();
    this.abeX = new LinkedList();
    this.abeZ = new LinkedList();
    AppMethodBeat.o(117544);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117545);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ycW == null)
      {
        paramVarArgs = new b("Not all required fields were included: pid");
        AppMethodBeat.o(117545);
        throw paramVarArgs;
      }
      if (this.ycW != null) {
        paramVarArgs.g(1, this.ycW);
      }
      paramVarArgs.bS(2, this.state);
      paramVarArgs.e(3, 8, this.abeS);
      paramVarArgs.bS(4, this.abeT);
      paramVarArgs.bS(5, this.abeU);
      if (this.abeV != null)
      {
        paramVarArgs.qD(6, this.abeV.computeSize());
        this.abeV.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(7, this.abeW);
      paramVarArgs.e(8, 8, this.abeX);
      paramVarArgs.di(9, this.abeY);
      paramVarArgs.e(10, 8, this.abeZ);
      AppMethodBeat.o(117545);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ycW == null) {
        break label974;
      }
    }
    label974:
    for (paramInt = i.a.a.b.b.a.h(1, this.ycW) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.state) + i.a.a.a.c(3, 8, this.abeS) + i.a.a.b.b.a.cJ(4, this.abeT) + i.a.a.b.b.a.cJ(5, this.abeU);
      paramInt = i;
      if (this.abeV != null) {
        paramInt = i + i.a.a.a.qC(6, this.abeV.computeSize());
      }
      i = i.a.a.b.b.a.cJ(7, this.abeW);
      int j = i.a.a.a.c(8, 8, this.abeX);
      int k = i.a.a.b.b.a.ko(9);
      int m = i.a.a.a.c(10, 8, this.abeZ);
      AppMethodBeat.o(117545);
      return paramInt + i + j + (k + 1) + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.abeS.clear();
        this.abeX.clear();
        this.abeZ.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.ycW == null)
        {
          paramVarArgs = new b("Not all required fields were included: pid");
          AppMethodBeat.o(117545);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117545);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dzt localdzt = (dzt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117545);
          return -1;
        case 1: 
          localdzt.ycW = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(117545);
          return 0;
        case 2: 
          localdzt.state = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(117545);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dzs();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dzs)localObject2).parseFrom((byte[])localObject1);
            }
            localdzt.abeS.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(117545);
          return 0;
        case 4: 
          localdzt.abeT = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(117545);
          return 0;
        case 5: 
          localdzt.abeU = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(117545);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ery();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ery)localObject2).parseFrom((byte[])localObject1);
            }
            localdzt.abeV = ((ery)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(117545);
          return 0;
        case 7: 
          localdzt.abeW = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(117545);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dzr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dzr)localObject2).parseFrom((byte[])localObject1);
            }
            localdzt.abeX.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(117545);
          return 0;
        case 9: 
          localdzt.abeY = ((i.a.a.a.a)localObject1).ajGk.aai();
          AppMethodBeat.o(117545);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new ery();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((ery)localObject2).parseFrom((byte[])localObject1);
          }
          localdzt.abeZ.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(117545);
        return 0;
      }
      AppMethodBeat.o(117545);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dzt
 * JD-Core Version:    0.7.0.1
 */