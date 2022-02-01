package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bgy
  extends com.tencent.mm.bx.a
{
  public biv ZQt;
  public biv ZQu;
  public String appid;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257852);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZQt != null)
      {
        paramVarArgs.qD(1, this.ZQt.computeSize());
        this.ZQt.writeFields(paramVarArgs);
      }
      if (this.ZQu != null)
      {
        paramVarArgs.qD(2, this.ZQu.computeSize());
        this.ZQu.writeFields(paramVarArgs);
      }
      if (this.appid != null) {
        paramVarArgs.g(3, this.appid);
      }
      AppMethodBeat.o(257852);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZQt == null) {
        break label478;
      }
    }
    label478:
    for (int i = i.a.a.a.qC(1, this.ZQt.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.ZQu != null) {
        paramInt = i + i.a.a.a.qC(2, this.ZQu.computeSize());
      }
      i = paramInt;
      if (this.appid != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.appid);
      }
      AppMethodBeat.o(257852);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257852);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        bgy localbgy = (bgy)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        biv localbiv;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257852);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localbiv = new biv();
            if ((localObject != null) && (localObject.length > 0)) {
              localbiv.parseFrom((byte[])localObject);
            }
            localbgy.ZQt = localbiv;
            paramInt += 1;
          }
          AppMethodBeat.o(257852);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localbiv = new biv();
            if ((localObject != null) && (localObject.length > 0)) {
              localbiv.parseFrom((byte[])localObject);
            }
            localbgy.ZQu = localbiv;
            paramInt += 1;
          }
          AppMethodBeat.o(257852);
          return 0;
        }
        localbgy.appid = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(257852);
        return 0;
      }
      AppMethodBeat.o(257852);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bgy
 * JD-Core Version:    0.7.0.1
 */