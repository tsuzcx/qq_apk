package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ahj
  extends com.tencent.mm.bx.a
{
  public dmt Zqp;
  public enx Zqq;
  public enx Zqr;
  public enx Zqs;
  public enx Zqt;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259167);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Zqp != null)
      {
        paramVarArgs.qD(1, this.Zqp.computeSize());
        this.Zqp.writeFields(paramVarArgs);
      }
      if (this.Zqq != null)
      {
        paramVarArgs.qD(2, this.Zqq.computeSize());
        this.Zqq.writeFields(paramVarArgs);
      }
      if (this.Zqr != null)
      {
        paramVarArgs.qD(3, this.Zqr.computeSize());
        this.Zqr.writeFields(paramVarArgs);
      }
      if (this.Zqs != null)
      {
        paramVarArgs.qD(4, this.Zqs.computeSize());
        this.Zqs.writeFields(paramVarArgs);
      }
      if (this.Zqt != null)
      {
        paramVarArgs.qD(5, this.Zqt.computeSize());
        this.Zqt.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(259167);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Zqp == null) {
        break label812;
      }
    }
    label812:
    for (int i = i.a.a.a.qC(1, this.Zqp.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Zqq != null) {
        paramInt = i + i.a.a.a.qC(2, this.Zqq.computeSize());
      }
      i = paramInt;
      if (this.Zqr != null) {
        i = paramInt + i.a.a.a.qC(3, this.Zqr.computeSize());
      }
      paramInt = i;
      if (this.Zqs != null) {
        paramInt = i + i.a.a.a.qC(4, this.Zqs.computeSize());
      }
      i = paramInt;
      if (this.Zqt != null) {
        i = paramInt + i.a.a.a.qC(5, this.Zqt.computeSize());
      }
      AppMethodBeat.o(259167);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259167);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ahj localahj = (ahj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259167);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dmt();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dmt)localObject2).parseFrom((byte[])localObject1);
            }
            localahj.Zqp = ((dmt)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259167);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new enx();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((enx)localObject2).parseFrom((byte[])localObject1);
            }
            localahj.Zqq = ((enx)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259167);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new enx();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((enx)localObject2).parseFrom((byte[])localObject1);
            }
            localahj.Zqr = ((enx)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259167);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new enx();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((enx)localObject2).parseFrom((byte[])localObject1);
            }
            localahj.Zqs = ((enx)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259167);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new enx();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((enx)localObject2).parseFrom((byte[])localObject1);
          }
          localahj.Zqt = ((enx)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(259167);
        return 0;
      }
      AppMethodBeat.o(259167);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahj
 * JD-Core Version:    0.7.0.1
 */