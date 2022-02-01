package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class chw
  extends esc
{
  public LinkedList<Integer> aamU;
  public LinkedList<fwx> aaqA;
  public LinkedList<exo> aaqB;
  public int aaqy;
  public LinkedList<dph> aaqz;
  
  public chw()
  {
    AppMethodBeat.i(32234);
    this.aaqz = new LinkedList();
    this.aamU = new LinkedList();
    this.aaqA = new LinkedList();
    this.aaqB = new LinkedList();
    AppMethodBeat.o(32234);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32235);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(32235);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.aaqy);
      paramVarArgs.e(3, 8, this.aaqz);
      paramVarArgs.f(4, 2, this.aamU);
      paramVarArgs.e(5, 8, this.aaqA);
      paramVarArgs.e(6, 8, this.aaqB);
      AppMethodBeat.o(32235);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label825;
      }
    }
    label825:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.aaqy);
      int j = i.a.a.a.c(3, 8, this.aaqz);
      int k = i.a.a.a.d(4, 2, this.aamU);
      int m = i.a.a.a.c(5, 8, this.aaqA);
      int n = i.a.a.a.c(6, 8, this.aaqB);
      AppMethodBeat.o(32235);
      return paramInt + i + j + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aaqz.clear();
        this.aamU.clear();
        this.aaqA.clear();
        this.aaqB.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.BaseResponse == null)
        {
          paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(32235);
          throw paramVarArgs;
        }
        AppMethodBeat.o(32235);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        chw localchw = (chw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32235);
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
            localchw.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32235);
          return 0;
        case 2: 
          localchw.aaqy = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(32235);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dph();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dph)localObject2).parseFrom((byte[])localObject1);
            }
            localchw.aaqz.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32235);
          return 0;
        case 4: 
          localchw.aamU = new i.a.a.a.a(((i.a.a.a.a)localObject1).ajGk.kFX().Op, unknownTagHandler).ajGk.kFV();
          AppMethodBeat.o(32235);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fwx();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fwx)localObject2).parseFrom((byte[])localObject1);
            }
            localchw.aaqA.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(32235);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new exo();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((exo)localObject2).parseFrom((byte[])localObject1);
          }
          localchw.aaqB.add(localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(32235);
        return 0;
      }
      AppMethodBeat.o(32235);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.chw
 * JD-Core Version:    0.7.0.1
 */