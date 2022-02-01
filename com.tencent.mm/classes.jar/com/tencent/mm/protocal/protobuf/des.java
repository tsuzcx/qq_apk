package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class des
  extends com.tencent.mm.bx.a
{
  public cca ZGd;
  public String lym;
  public int value;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258570);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.lym != null) {
        paramVarArgs.g(1, this.lym);
      }
      paramVarArgs.bS(2, this.value);
      if (this.ZGd != null)
      {
        paramVarArgs.qD(3, this.ZGd.computeSize());
        this.ZGd.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(258570);
      return 0;
    }
    if (paramInt == 1) {
      if (this.lym == null) {
        break label388;
      }
    }
    label388:
    for (paramInt = i.a.a.b.b.a.h(1, this.lym) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.value);
      paramInt = i;
      if (this.ZGd != null) {
        paramInt = i + i.a.a.a.qC(3, this.ZGd.computeSize());
      }
      AppMethodBeat.o(258570);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258570);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        des localdes = (des)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258570);
          return -1;
        case 1: 
          localdes.lym = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(258570);
          return 0;
        case 2: 
          localdes.value = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(258570);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          cca localcca = new cca();
          if ((localObject != null) && (localObject.length > 0)) {
            localcca.parseFrom((byte[])localObject);
          }
          localdes.ZGd = localcca;
          paramInt += 1;
        }
        AppMethodBeat.o(258570);
        return 0;
      }
      AppMethodBeat.o(258570);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.des
 * JD-Core Version:    0.7.0.1
 */