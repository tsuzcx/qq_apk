package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cyo
  extends com.tencent.mm.bx.a
{
  public boolean aaDs;
  public cyn aate;
  public String icon;
  public String lym;
  public int tNW;
  public String wtN;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72496);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.wtN != null) {
        paramVarArgs.g(1, this.wtN);
      }
      if (this.lym != null) {
        paramVarArgs.g(2, this.lym);
      }
      if (this.icon != null) {
        paramVarArgs.g(3, this.icon);
      }
      paramVarArgs.di(4, this.aaDs);
      paramVarArgs.bS(5, this.tNW);
      if (this.aate != null)
      {
        paramVarArgs.qD(6, this.aate.computeSize());
        this.aate.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(72496);
      return 0;
    }
    if (paramInt == 1) {
      if (this.wtN == null) {
        break label552;
      }
    }
    label552:
    for (int i = i.a.a.b.b.a.h(1, this.wtN) + 0;; i = 0)
    {
      paramInt = i;
      if (this.lym != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.lym);
      }
      i = paramInt;
      if (this.icon != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.icon);
      }
      i = i + (i.a.a.b.b.a.ko(4) + 1) + i.a.a.b.b.a.cJ(5, this.tNW);
      paramInt = i;
      if (this.aate != null) {
        paramInt = i + i.a.a.a.qC(6, this.aate.computeSize());
      }
      AppMethodBeat.o(72496);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(72496);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        cyo localcyo = (cyo)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(72496);
          return -1;
        case 1: 
          localcyo.wtN = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72496);
          return 0;
        case 2: 
          localcyo.lym = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72496);
          return 0;
        case 3: 
          localcyo.icon = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(72496);
          return 0;
        case 4: 
          localcyo.aaDs = ((i.a.a.a.a)localObject).ajGk.aai();
          AppMethodBeat.o(72496);
          return 0;
        case 5: 
          localcyo.tNW = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(72496);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          cyn localcyn = new cyn();
          if ((localObject != null) && (localObject.length > 0)) {
            localcyn.parseFrom((byte[])localObject);
          }
          localcyo.aate = localcyn;
          paramInt += 1;
        }
        AppMethodBeat.o(72496);
        return 0;
      }
      AppMethodBeat.o(72496);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cyo
 * JD-Core Version:    0.7.0.1
 */