package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ffj
  extends dop
{
  public String KLL;
  public String NAF;
  public String rBI;
  public int xIL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152731);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.rBI != null) {
        paramVarArgs.e(2, this.rBI);
      }
      if (this.KLL != null) {
        paramVarArgs.e(3, this.KLL);
      }
      if (this.NAF != null) {
        paramVarArgs.e(4, this.NAF);
      }
      paramVarArgs.aM(5, this.xIL);
      AppMethodBeat.o(152731);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label534;
      }
    }
    label534:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.rBI != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.rBI);
      }
      i = paramInt;
      if (this.KLL != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.KLL);
      }
      paramInt = i;
      if (this.NAF != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.NAF);
      }
      i = g.a.a.b.b.a.bu(5, this.xIL);
      AppMethodBeat.o(152731);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(152731);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ffj localffj = (ffj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(152731);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localffj.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(152731);
          return 0;
        case 2: 
          localffj.rBI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152731);
          return 0;
        case 3: 
          localffj.KLL = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152731);
          return 0;
        case 4: 
          localffj.NAF = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(152731);
          return 0;
        }
        localffj.xIL = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(152731);
        return 0;
      }
      AppMethodBeat.o(152731);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ffj
 * JD-Core Version:    0.7.0.1
 */