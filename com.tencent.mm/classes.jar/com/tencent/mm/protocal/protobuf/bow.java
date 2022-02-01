package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bow
  extends dop
{
  public int DYl;
  public long DYn;
  public int LWW;
  public String gTk;
  public String gTl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(125732);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(2, this.DYn);
      paramVarArgs.aM(3, this.LWW);
      if (this.gTl != null) {
        paramVarArgs.e(4, this.gTl);
      }
      if (this.gTk != null) {
        paramVarArgs.e(5, this.gTk);
      }
      paramVarArgs.aM(6, this.DYl);
      AppMethodBeat.o(125732);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label562;
      }
    }
    label562:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.r(2, this.DYn) + g.a.a.b.b.a.bu(3, this.LWW);
      paramInt = i;
      if (this.gTl != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.gTl);
      }
      i = paramInt;
      if (this.gTk != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.gTk);
      }
      paramInt = g.a.a.b.b.a.bu(6, this.DYl);
      AppMethodBeat.o(125732);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(125732);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bow localbow = (bow)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(125732);
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
            localbow.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(125732);
          return 0;
        case 2: 
          localbow.DYn = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(125732);
          return 0;
        case 3: 
          localbow.LWW = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(125732);
          return 0;
        case 4: 
          localbow.gTl = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125732);
          return 0;
        case 5: 
          localbow.gTk = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(125732);
          return 0;
        }
        localbow.DYl = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(125732);
        return 0;
      }
      AppMethodBeat.o(125732);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bow
 * JD-Core Version:    0.7.0.1
 */