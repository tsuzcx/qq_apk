package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class gmp
  extends com.tencent.mm.bx.a
{
  public gmr achO;
  public gmq achP;
  public gmu achQ;
  public gmw achR;
  public gmv achS;
  public gmz achT;
  public gmo achU;
  public gmx achV;
  public gms achW;
  public gmt achX;
  public gmy achY;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153340);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.achO != null)
      {
        paramVarArgs.qD(1, this.achO.computeSize());
        this.achO.writeFields(paramVarArgs);
      }
      if (this.achP != null)
      {
        paramVarArgs.qD(2, this.achP.computeSize());
        this.achP.writeFields(paramVarArgs);
      }
      if (this.achQ != null)
      {
        paramVarArgs.qD(3, this.achQ.computeSize());
        this.achQ.writeFields(paramVarArgs);
      }
      if (this.achR != null)
      {
        paramVarArgs.qD(4, this.achR.computeSize());
        this.achR.writeFields(paramVarArgs);
      }
      if (this.achS != null)
      {
        paramVarArgs.qD(5, this.achS.computeSize());
        this.achS.writeFields(paramVarArgs);
      }
      if (this.achT != null)
      {
        paramVarArgs.qD(6, this.achT.computeSize());
        this.achT.writeFields(paramVarArgs);
      }
      if (this.achU != null)
      {
        paramVarArgs.qD(7, this.achU.computeSize());
        this.achU.writeFields(paramVarArgs);
      }
      if (this.achV != null)
      {
        paramVarArgs.qD(8, this.achV.computeSize());
        this.achV.writeFields(paramVarArgs);
      }
      if (this.achW != null)
      {
        paramVarArgs.qD(9, this.achW.computeSize());
        this.achW.writeFields(paramVarArgs);
      }
      if (this.achX != null)
      {
        paramVarArgs.qD(10, this.achX.computeSize());
        this.achX.writeFields(paramVarArgs);
      }
      if (this.achY != null)
      {
        paramVarArgs.qD(11, this.achY.computeSize());
        this.achY.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(153340);
      return 0;
    }
    if (paramInt == 1) {
      if (this.achO == null) {
        break label1616;
      }
    }
    label1616:
    for (int i = i.a.a.a.qC(1, this.achO.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.achP != null) {
        paramInt = i + i.a.a.a.qC(2, this.achP.computeSize());
      }
      i = paramInt;
      if (this.achQ != null) {
        i = paramInt + i.a.a.a.qC(3, this.achQ.computeSize());
      }
      paramInt = i;
      if (this.achR != null) {
        paramInt = i + i.a.a.a.qC(4, this.achR.computeSize());
      }
      i = paramInt;
      if (this.achS != null) {
        i = paramInt + i.a.a.a.qC(5, this.achS.computeSize());
      }
      paramInt = i;
      if (this.achT != null) {
        paramInt = i + i.a.a.a.qC(6, this.achT.computeSize());
      }
      i = paramInt;
      if (this.achU != null) {
        i = paramInt + i.a.a.a.qC(7, this.achU.computeSize());
      }
      paramInt = i;
      if (this.achV != null) {
        paramInt = i + i.a.a.a.qC(8, this.achV.computeSize());
      }
      i = paramInt;
      if (this.achW != null) {
        i = paramInt + i.a.a.a.qC(9, this.achW.computeSize());
      }
      paramInt = i;
      if (this.achX != null) {
        paramInt = i + i.a.a.a.qC(10, this.achX.computeSize());
      }
      i = paramInt;
      if (this.achY != null) {
        i = paramInt + i.a.a.a.qC(11, this.achY.computeSize());
      }
      AppMethodBeat.o(153340);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(153340);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        gmp localgmp = (gmp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153340);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gmr();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gmr)localObject2).parseFrom((byte[])localObject1);
            }
            localgmp.achO = ((gmr)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153340);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gmq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gmq)localObject2).parseFrom((byte[])localObject1);
            }
            localgmp.achP = ((gmq)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153340);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gmu();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gmu)localObject2).parseFrom((byte[])localObject1);
            }
            localgmp.achQ = ((gmu)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153340);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gmw();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gmw)localObject2).parseFrom((byte[])localObject1);
            }
            localgmp.achR = ((gmw)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153340);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gmv();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gmv)localObject2).parseFrom((byte[])localObject1);
            }
            localgmp.achS = ((gmv)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153340);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gmz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gmz)localObject2).parseFrom((byte[])localObject1);
            }
            localgmp.achT = ((gmz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153340);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gmo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gmo)localObject2).parseFrom((byte[])localObject1);
            }
            localgmp.achU = ((gmo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153340);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gmx();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gmx)localObject2).parseFrom((byte[])localObject1);
            }
            localgmp.achV = ((gmx)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153340);
          return 0;
        case 9: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gms();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gms)localObject2).parseFrom((byte[])localObject1);
            }
            localgmp.achW = ((gms)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153340);
          return 0;
        case 10: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gmt();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gmt)localObject2).parseFrom((byte[])localObject1);
            }
            localgmp.achX = ((gmt)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(153340);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new gmy();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((gmy)localObject2).parseFrom((byte[])localObject1);
          }
          localgmp.achY = ((gmy)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(153340);
        return 0;
      }
      AppMethodBeat.o(153340);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gmp
 * JD-Core Version:    0.7.0.1
 */