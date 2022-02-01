package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public class clj
  extends esc
{
  public dby aatv;
  public b aatw;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257742);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.aatv != null)
      {
        paramVarArgs.qD(2, this.aatv.computeSize());
        this.aatv.writeFields(paramVarArgs);
      }
      if (this.aatw != null) {
        paramVarArgs.d(3, this.aatw);
      }
      AppMethodBeat.o(257742);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label478;
      }
    }
    label478:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aatv != null) {
        paramInt = i + i.a.a.a.qC(2, this.aatv.computeSize());
      }
      i = paramInt;
      if (this.aatw != null) {
        i = paramInt + i.a.a.b.b.a.c(3, this.aatw);
      }
      AppMethodBeat.o(257742);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257742);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        clj localclj = (clj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257742);
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
            localclj.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257742);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dby();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dby)localObject2).parseFrom((byte[])localObject1);
            }
            localclj.aatv = ((dby)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(257742);
          return 0;
        }
        localclj.aatw = ((i.a.a.a.a)localObject1).ajGk.kFX();
        AppMethodBeat.o(257742);
        return 0;
      }
      AppMethodBeat.o(257742);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.clj
 * JD-Core Version:    0.7.0.1
 */