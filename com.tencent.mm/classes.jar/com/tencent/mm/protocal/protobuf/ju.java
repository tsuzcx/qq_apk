package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ju
  extends com.tencent.mm.bx.a
{
  public etg YCV;
  public String YMe;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91360);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.g(1, this.title);
      }
      if (this.YCV != null)
      {
        paramVarArgs.qD(2, this.YCV.computeSize());
        this.YCV.writeFields(paramVarArgs);
      }
      if (this.YMe != null) {
        paramVarArgs.g(3, this.YMe);
      }
      AppMethodBeat.o(91360);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label404;
      }
    }
    label404:
    for (int i = i.a.a.b.b.a.h(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YCV != null) {
        paramInt = i + i.a.a.a.qC(2, this.YCV.computeSize());
      }
      i = paramInt;
      if (this.YMe != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YMe);
      }
      AppMethodBeat.o(91360);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(91360);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ju localju = (ju)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91360);
          return -1;
        case 1: 
          localju.title = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(91360);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            etg localetg = new etg();
            if ((localObject != null) && (localObject.length > 0)) {
              localetg.parseFrom((byte[])localObject);
            }
            localju.YCV = localetg;
            paramInt += 1;
          }
          AppMethodBeat.o(91360);
          return 0;
        }
        localju.YMe = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(91360);
        return 0;
      }
      AppMethodBeat.o(91360);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ju
 * JD-Core Version:    0.7.0.1
 */