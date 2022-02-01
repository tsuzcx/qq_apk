package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fwh
  extends erp
{
  public int YIq;
  public gol YMf;
  public String YOL;
  public etl YOP;
  public gol YOQ;
  public etl aaAR;
  public int abAU;
  public String abUf;
  public etl abUg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(43133);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.YIq);
      if (this.abUf != null) {
        paramVarArgs.g(3, this.abUf);
      }
      if (this.YOL != null) {
        paramVarArgs.g(4, this.YOL);
      }
      if (this.aaAR != null)
      {
        paramVarArgs.qD(5, this.aaAR.computeSize());
        this.aaAR.writeFields(paramVarArgs);
      }
      if (this.abUg != null)
      {
        paramVarArgs.qD(6, this.abUg.computeSize());
        this.abUg.writeFields(paramVarArgs);
      }
      if (this.YOP != null)
      {
        paramVarArgs.qD(7, this.YOP.computeSize());
        this.YOP.writeFields(paramVarArgs);
      }
      if (this.YOQ != null)
      {
        paramVarArgs.qD(8, this.YOQ.computeSize());
        this.YOQ.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(9, this.abAU);
      if (this.YMf != null)
      {
        paramVarArgs.qD(10, this.YMf.computeSize());
        this.YMf.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(43133);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1162;
      }
    }
    label1162:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.YIq);
      paramInt = i;
      if (this.abUf != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.abUf);
      }
      i = paramInt;
      if (this.YOL != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.YOL);
      }
      paramInt = i;
      if (this.aaAR != null) {
        paramInt = i + i.a.a.a.qC(5, this.aaAR.computeSize());
      }
      i = paramInt;
      if (this.abUg != null) {
        i = paramInt + i.a.a.a.qC(6, this.abUg.computeSize());
      }
      paramInt = i;
      if (this.YOP != null) {
        paramInt = i + i.a.a.a.qC(7, this.YOP.computeSize());
      }
      i = paramInt;
      if (this.YOQ != null) {
        i = paramInt + i.a.a.a.qC(8, this.YOQ.computeSize());
      }
      i += i.a.a.b.b.a.cJ(9, this.abAU);
      paramInt = i;
      if (this.YMf != null) {
        paramInt = i + i.a.a.a.qC(10, this.YMf.computeSize());
      }
      AppMethodBeat.o(43133);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(43133);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fwh localfwh = (fwh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(43133);
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
            localfwh.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(43133);
          return 0;
        case 2: 
          localfwh.YIq = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(43133);
          return 0;
        case 3: 
          localfwh.abUf = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(43133);
          return 0;
        case 4: 
          localfwh.YOL = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(43133);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new etl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((etl)localObject2).dh((byte[])localObject1);
            }
            localfwh.aaAR = ((etl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(43133);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new etl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((etl)localObject2).dh((byte[])localObject1);
            }
            localfwh.abUg = ((etl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(43133);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new etl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((etl)localObject2).dh((byte[])localObject1);
            }
            localfwh.YOP = ((etl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(43133);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gol();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gol)localObject2).dg((byte[])localObject1);
            }
            localfwh.YOQ = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(43133);
          return 0;
        case 9: 
          localfwh.abAU = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(43133);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new gol();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((gol)localObject2).dg((byte[])localObject1);
          }
          localfwh.YMf = ((gol)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(43133);
        return 0;
      }
      AppMethodBeat.o(43133);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fwh
 * JD-Core Version:    0.7.0.1
 */