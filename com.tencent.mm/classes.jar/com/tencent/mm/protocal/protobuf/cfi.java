package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cfi
  extends esc
{
  public com.tencent.mm.bx.b aaoX;
  public long aaoY;
  public com.tencent.mm.bx.b aaoZ;
  public dtt aapa;
  public nh aapb;
  public float aapc = 0.5F;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104368);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse == null)
      {
        paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
        AppMethodBeat.o(104368);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(2, this.aaoY);
      if (this.aaoZ != null) {
        paramVarArgs.d(3, this.aaoZ);
      }
      if (this.aapa != null)
      {
        paramVarArgs.qD(4, this.aapa.computeSize());
        this.aapa.writeFields(paramVarArgs);
      }
      if (this.aapb != null)
      {
        paramVarArgs.qD(5, this.aapb.computeSize());
        this.aapb.writeFields(paramVarArgs);
      }
      if (this.aaoX != null) {
        paramVarArgs.d(6, this.aaoX);
      }
      paramVarArgs.l(7, this.aapc);
      AppMethodBeat.o(104368);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label811;
      }
    }
    label811:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.q(2, this.aaoY);
      paramInt = i;
      if (this.aaoZ != null) {
        paramInt = i + i.a.a.b.b.a.c(3, this.aaoZ);
      }
      i = paramInt;
      if (this.aapa != null) {
        i = paramInt + i.a.a.a.qC(4, this.aapa.computeSize());
      }
      paramInt = i;
      if (this.aapb != null) {
        paramInt = i + i.a.a.a.qC(5, this.aapb.computeSize());
      }
      i = paramInt;
      if (this.aaoX != null) {
        i = paramInt + i.a.a.b.b.a.c(6, this.aaoX);
      }
      paramInt = i.a.a.b.b.a.ko(7);
      AppMethodBeat.o(104368);
      return i + (paramInt + 4);
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
          paramVarArgs = new i.a.a.b("Not all required fields were included: BaseResponse");
          AppMethodBeat.o(104368);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104368);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cfi localcfi = (cfi)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(104368);
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
            localcfi.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104368);
          return 0;
        case 2: 
          localcfi.aaoY = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(104368);
          return 0;
        case 3: 
          localcfi.aaoZ = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(104368);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dtt();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dtt)localObject2).parseFrom((byte[])localObject1);
            }
            localcfi.aapa = ((dtt)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104368);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new nh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((nh)localObject2).parseFrom((byte[])localObject1);
            }
            localcfi.aapb = ((nh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(104368);
          return 0;
        case 6: 
          localcfi.aaoX = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(104368);
          return 0;
        }
        localcfi.aapc = Float.intBitsToFloat(((i.a.a.a.a)localObject1).ajGk.aax());
        AppMethodBeat.o(104368);
        return 0;
      }
      AppMethodBeat.o(104368);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cfi
 * JD-Core Version:    0.7.0.1
 */