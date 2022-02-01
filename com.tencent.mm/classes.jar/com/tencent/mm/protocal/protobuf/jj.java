package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class jj
  extends com.tencent.mm.bw.a
{
  public dqe KEP;
  public String KNW;
  public String title;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91360);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.title != null) {
        paramVarArgs.e(1, this.title);
      }
      if (this.KEP != null)
      {
        paramVarArgs.ni(2, this.KEP.computeSize());
        this.KEP.writeFields(paramVarArgs);
      }
      if (this.KNW != null) {
        paramVarArgs.e(3, this.KNW);
      }
      AppMethodBeat.o(91360);
      return 0;
    }
    if (paramInt == 1) {
      if (this.title == null) {
        break label430;
      }
    }
    label430:
    for (int i = g.a.a.b.b.a.f(1, this.title) + 0;; i = 0)
    {
      paramInt = i;
      if (this.KEP != null) {
        paramInt = i + g.a.a.a.nh(2, this.KEP.computeSize());
      }
      i = paramInt;
      if (this.KNW != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.KNW);
      }
      AppMethodBeat.o(91360);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91360);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        jj localjj = (jj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91360);
          return -1;
        case 1: 
          localjj.title = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91360);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dqe();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dqe)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localjj.KEP = ((dqe)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91360);
          return 0;
        }
        localjj.KNW = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91360);
        return 0;
      }
      AppMethodBeat.o(91360);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.jj
 * JD-Core Version:    0.7.0.1
 */