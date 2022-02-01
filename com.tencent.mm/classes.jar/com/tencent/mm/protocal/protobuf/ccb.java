package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ccb
  extends com.tencent.mm.bx.a
{
  public fvo aalk;
  public cbb aals;
  public cbq aalt;
  public caz aalu;
  public String error_msg;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258025);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aalk != null)
      {
        paramVarArgs.qD(1, this.aalk.computeSize());
        this.aalk.writeFields(paramVarArgs);
      }
      if (this.aals != null)
      {
        paramVarArgs.qD(2, this.aals.computeSize());
        this.aals.writeFields(paramVarArgs);
      }
      if (this.error_msg != null) {
        paramVarArgs.g(3, this.error_msg);
      }
      if (this.aalt != null)
      {
        paramVarArgs.qD(4, this.aalt.computeSize());
        this.aalt.writeFields(paramVarArgs);
      }
      if (this.aalu != null)
      {
        paramVarArgs.qD(5, this.aalu.computeSize());
        this.aalu.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(258025);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aalk == null) {
        break label742;
      }
    }
    label742:
    for (int i = i.a.a.a.qC(1, this.aalk.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aals != null) {
        paramInt = i + i.a.a.a.qC(2, this.aals.computeSize());
      }
      i = paramInt;
      if (this.error_msg != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.error_msg);
      }
      paramInt = i;
      if (this.aalt != null) {
        paramInt = i + i.a.a.a.qC(4, this.aalt.computeSize());
      }
      i = paramInt;
      if (this.aalu != null) {
        i = paramInt + i.a.a.a.qC(5, this.aalu.computeSize());
      }
      AppMethodBeat.o(258025);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258025);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        ccb localccb = (ccb)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258025);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fvo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fvo)localObject2).parseFrom((byte[])localObject1);
            }
            localccb.aalk = ((fvo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258025);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cbb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cbb)localObject2).parseFrom((byte[])localObject1);
            }
            localccb.aals = ((cbb)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258025);
          return 0;
        case 3: 
          localccb.error_msg = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258025);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new cbq();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((cbq)localObject2).parseFrom((byte[])localObject1);
            }
            localccb.aalt = ((cbq)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258025);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new caz();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((caz)localObject2).parseFrom((byte[])localObject1);
          }
          localccb.aalu = ((caz)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258025);
        return 0;
      }
      AppMethodBeat.o(258025);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ccb
 * JD-Core Version:    0.7.0.1
 */