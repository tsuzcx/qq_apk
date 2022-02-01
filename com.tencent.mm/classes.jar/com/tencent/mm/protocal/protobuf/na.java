package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class na
  extends erp
{
  public gol YMf;
  public int YOK;
  public String YOL;
  public String YOM;
  public String YON;
  public int YOO;
  public etl YOP;
  public gol YOQ;
  public int YOR;
  public String YOh;
  public String YOi;
  public String YOy;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155396);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.YOK);
      if (this.YOy != null) {
        paramVarArgs.g(3, this.YOy);
      }
      if (this.YOL != null) {
        paramVarArgs.g(4, this.YOL);
      }
      if (this.YOM != null) {
        paramVarArgs.g(5, this.YOM);
      }
      if (this.YON != null) {
        paramVarArgs.g(6, this.YON);
      }
      paramVarArgs.bS(7, this.YOO);
      if (this.YOP != null)
      {
        paramVarArgs.qD(8, this.YOP.computeSize());
        this.YOP.writeFields(paramVarArgs);
      }
      if (this.YOQ != null)
      {
        paramVarArgs.qD(9, this.YOQ.computeSize());
        this.YOQ.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(10, this.YOR);
      if (this.YOh != null) {
        paramVarArgs.g(11, this.YOh);
      }
      if (this.YOi != null) {
        paramVarArgs.g(12, this.YOi);
      }
      if (this.YMf != null)
      {
        paramVarArgs.qD(13, this.YMf.computeSize());
        this.YMf.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(155396);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label1190;
      }
    }
    label1190:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.YOK);
      paramInt = i;
      if (this.YOy != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.YOy);
      }
      i = paramInt;
      if (this.YOL != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.YOL);
      }
      paramInt = i;
      if (this.YOM != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.YOM);
      }
      i = paramInt;
      if (this.YON != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.YON);
      }
      i += i.a.a.b.b.a.cJ(7, this.YOO);
      paramInt = i;
      if (this.YOP != null) {
        paramInt = i + i.a.a.a.qC(8, this.YOP.computeSize());
      }
      i = paramInt;
      if (this.YOQ != null) {
        i = paramInt + i.a.a.a.qC(9, this.YOQ.computeSize());
      }
      i += i.a.a.b.b.a.cJ(10, this.YOR);
      paramInt = i;
      if (this.YOh != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.YOh);
      }
      i = paramInt;
      if (this.YOi != null) {
        i = paramInt + i.a.a.b.b.a.h(12, this.YOi);
      }
      paramInt = i;
      if (this.YMf != null) {
        paramInt = i + i.a.a.a.qC(13, this.YMf.computeSize());
      }
      AppMethodBeat.o(155396);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(155396);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        na localna = (na)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155396);
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
            localna.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(155396);
          return 0;
        case 2: 
          localna.YOK = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(155396);
          return 0;
        case 3: 
          localna.YOy = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(155396);
          return 0;
        case 4: 
          localna.YOL = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(155396);
          return 0;
        case 5: 
          localna.YOM = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(155396);
          return 0;
        case 6: 
          localna.YON = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(155396);
          return 0;
        case 7: 
          localna.YOO = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(155396);
          return 0;
        case 8: 
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
            localna.YOP = ((etl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(155396);
          return 0;
        case 9: 
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
            localna.YOQ = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(155396);
          return 0;
        case 10: 
          localna.YOR = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(155396);
          return 0;
        case 11: 
          localna.YOh = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(155396);
          return 0;
        case 12: 
          localna.YOi = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(155396);
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
          localna.YMf = ((gol)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(155396);
        return 0;
      }
      AppMethodBeat.o(155396);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.na
 * JD-Core Version:    0.7.0.1
 */