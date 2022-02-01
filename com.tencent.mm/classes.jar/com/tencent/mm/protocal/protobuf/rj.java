package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class rj
  extends esc
{
  public ecp YWi;
  public gc YWj;
  public rh YWk;
  public ehl YWl;
  public fxh YWm;
  public eg YWn;
  public enk YWo;
  public doj YWp;
  public ph YWq;
  public fnd YWr;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124461);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(124461);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.YWi != null)
      {
        paramVarArgs.qD(2, this.YWi.computeSize());
        this.YWi.writeFields(paramVarArgs);
      }
      if (this.YWj != null)
      {
        paramVarArgs.qD(3, this.YWj.computeSize());
        this.YWj.writeFields(paramVarArgs);
      }
      if (this.YWk != null)
      {
        paramVarArgs.qD(4, this.YWk.computeSize());
        this.YWk.writeFields(paramVarArgs);
      }
      if (this.YWl != null)
      {
        paramVarArgs.qD(5, this.YWl.computeSize());
        this.YWl.writeFields(paramVarArgs);
      }
      if (this.YWm != null)
      {
        paramVarArgs.qD(6, this.YWm.computeSize());
        this.YWm.writeFields(paramVarArgs);
      }
      if (this.YWn != null)
      {
        paramVarArgs.qD(7, this.YWn.computeSize());
        this.YWn.writeFields(paramVarArgs);
      }
      if (this.YWo != null)
      {
        paramVarArgs.qD(8, this.YWo.computeSize());
        this.YWo.writeFields(paramVarArgs);
      }
      if (this.YWp != null)
      {
        paramVarArgs.qD(9, this.YWp.computeSize());
        this.YWp.writeFields(paramVarArgs);
      }
      if (this.YWq != null)
      {
        paramVarArgs.qD(10, this.YWq.computeSize());
        this.YWq.writeFields(paramVarArgs);
      }
      if (this.YWr != null)
      {
        paramVarArgs.qD(11, this.YWr.computeSize());
        this.YWr.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(124461);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1664;
      }
    }
    label1664:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YWi != null) {
        paramInt = i + i.a.a.a.qC(2, this.YWi.computeSize());
      }
      i = paramInt;
      if (this.YWj != null) {
        i = paramInt + i.a.a.a.qC(3, this.YWj.computeSize());
      }
      paramInt = i;
      if (this.YWk != null) {
        paramInt = i + i.a.a.a.qC(4, this.YWk.computeSize());
      }
      i = paramInt;
      if (this.YWl != null) {
        i = paramInt + i.a.a.a.qC(5, this.YWl.computeSize());
      }
      paramInt = i;
      if (this.YWm != null) {
        paramInt = i + i.a.a.a.qC(6, this.YWm.computeSize());
      }
      i = paramInt;
      if (this.YWn != null) {
        i = paramInt + i.a.a.a.qC(7, this.YWn.computeSize());
      }
      paramInt = i;
      if (this.YWo != null) {
        paramInt = i + i.a.a.a.qC(8, this.YWo.computeSize());
      }
      i = paramInt;
      if (this.YWp != null) {
        i = paramInt + i.a.a.a.qC(9, this.YWp.computeSize());
      }
      paramInt = i;
      if (this.YWq != null) {
        paramInt = i + i.a.a.a.qC(10, this.YWq.computeSize());
      }
      i = paramInt;
      if (this.YWr != null) {
        i = paramInt + i.a.a.a.qC(11, this.YWr.computeSize());
      }
      AppMethodBeat.o(124461);
      return i;
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
          AppMethodBeat.o(124461);
          throw paramVarArgs;
        }
        AppMethodBeat.o(124461);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        rj localrj = (rj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124461);
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
            localrj.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124461);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ecp();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ecp)localObject2).parseFrom((byte[])localObject1);
            }
            localrj.YWi = ((ecp)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124461);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gc)localObject2).parseFrom((byte[])localObject1);
            }
            localrj.YWj = ((gc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124461);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new rh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((rh)localObject2).parseFrom((byte[])localObject1);
            }
            localrj.YWk = ((rh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124461);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ehl();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ehl)localObject2).parseFrom((byte[])localObject1);
            }
            localrj.YWl = ((ehl)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124461);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fxh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fxh)localObject2).parseFrom((byte[])localObject1);
            }
            localrj.YWm = ((fxh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124461);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eg)localObject2).parseFrom((byte[])localObject1);
            }
            localrj.YWn = ((eg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124461);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new enk();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((enk)localObject2).parseFrom((byte[])localObject1);
            }
            localrj.YWo = ((enk)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124461);
          return 0;
        case 9: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new doj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((doj)localObject2).parseFrom((byte[])localObject1);
            }
            localrj.YWp = ((doj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124461);
          return 0;
        case 10: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ph();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ph)localObject2).parseFrom((byte[])localObject1);
            }
            localrj.YWq = ((ph)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(124461);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new fnd();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((fnd)localObject2).parseFrom((byte[])localObject1);
          }
          localrj.YWr = ((fnd)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(124461);
        return 0;
      }
      AppMethodBeat.o(124461);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rj
 * JD-Core Version:    0.7.0.1
 */