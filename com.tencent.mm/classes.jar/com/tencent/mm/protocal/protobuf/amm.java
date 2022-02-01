package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;

public final class amm
  extends esc
{
  public String Njp;
  public fck YJt;
  public sc YOA;
  public dts YOB;
  public dal YOz;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(155403);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(155403);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.Njp != null) {
        paramVarArgs.g(2, this.Njp);
      }
      if (this.YOA != null)
      {
        paramVarArgs.qD(3, this.YOA.computeSize());
        this.YOA.writeFields(paramVarArgs);
      }
      if (this.YOz != null)
      {
        paramVarArgs.qD(4, this.YOz.computeSize());
        this.YOz.writeFields(paramVarArgs);
      }
      if (this.YJt != null)
      {
        paramVarArgs.qD(5, this.YJt.computeSize());
        this.YJt.writeFields(paramVarArgs);
      }
      if (this.YOB != null)
      {
        paramVarArgs.qD(6, this.YOB.computeSize());
        this.YOB.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(155403);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label924;
      }
    }
    label924:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Njp != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.Njp);
      }
      i = paramInt;
      if (this.YOA != null) {
        i = paramInt + i.a.a.a.qC(3, this.YOA.computeSize());
      }
      paramInt = i;
      if (this.YOz != null) {
        paramInt = i + i.a.a.a.qC(4, this.YOz.computeSize());
      }
      i = paramInt;
      if (this.YJt != null) {
        i = paramInt + i.a.a.a.qC(5, this.YJt.computeSize());
      }
      paramInt = i;
      if (this.YOB != null) {
        paramInt = i + i.a.a.a.qC(6, this.YOB.computeSize());
      }
      AppMethodBeat.o(155403);
      return paramInt;
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
          AppMethodBeat.o(155403);
          throw paramVarArgs;
        }
        AppMethodBeat.o(155403);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        amm localamm = (amm)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(155403);
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
            localamm.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(155403);
          return 0;
        case 2: 
          localamm.Njp = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(155403);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new sc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((sc)localObject2).parseFrom((byte[])localObject1);
            }
            localamm.YOA = ((sc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(155403);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dal();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dal)localObject2).parseFrom((byte[])localObject1);
            }
            localamm.YOz = ((dal)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(155403);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fck();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fck)localObject2).parseFrom((byte[])localObject1);
            }
            localamm.YJt = ((fck)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(155403);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new dts();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((dts)localObject2).parseFrom((byte[])localObject1);
          }
          localamm.YOB = ((dts)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(155403);
        return 0;
      }
      AppMethodBeat.o(155403);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amm
 * JD-Core Version:    0.7.0.1
 */