package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bkt
  extends com.tencent.mm.bx.a
{
  public bks ZTQ;
  public String ZTR;
  public boi location;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259424);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZTQ != null)
      {
        paramVarArgs.qD(1, this.ZTQ.computeSize());
        this.ZTQ.writeFields(paramVarArgs);
      }
      if (this.ZTR != null) {
        paramVarArgs.g(2, this.ZTR);
      }
      if (this.location != null)
      {
        paramVarArgs.qD(3, this.location.computeSize());
        this.location.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(259424);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZTQ == null) {
        break label478;
      }
    }
    label478:
    for (int i = i.a.a.a.qC(1, this.ZTQ.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ZTR != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.ZTR);
      }
      i = paramInt;
      if (this.location != null) {
        i = paramInt + i.a.a.a.qC(3, this.location.computeSize());
      }
      AppMethodBeat.o(259424);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259424);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bkt localbkt = (bkt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259424);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bks();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bks)localObject2).parseFrom((byte[])localObject1);
            }
            localbkt.ZTQ = ((bks)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259424);
          return 0;
        case 2: 
          localbkt.ZTR = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(259424);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new boi();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((boi)localObject2).parseFrom((byte[])localObject1);
          }
          localbkt.location = ((boi)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(259424);
        return 0;
      }
      AppMethodBeat.o(259424);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkt
 * JD-Core Version:    0.7.0.1
 */