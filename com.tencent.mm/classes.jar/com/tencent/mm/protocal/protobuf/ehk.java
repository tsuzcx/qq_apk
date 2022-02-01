package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ehk
  extends dop
{
  public String KUk;
  public int KWE;
  public String KWF;
  public long KWz;
  public String NgX;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(224541);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.bb(2, this.KWz);
      paramVarArgs.aM(3, this.KWE);
      if (this.KUk != null) {
        paramVarArgs.e(4, this.KUk);
      }
      if (this.KWF != null) {
        paramVarArgs.e(5, this.KWF);
      }
      if (this.NgX != null) {
        paramVarArgs.e(6, this.NgX);
      }
      AppMethodBeat.o(224541);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label578;
      }
    }
    label578:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.r(2, this.KWz) + g.a.a.b.b.a.bu(3, this.KWE);
      paramInt = i;
      if (this.KUk != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.KUk);
      }
      i = paramInt;
      if (this.KWF != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.KWF);
      }
      paramInt = i;
      if (this.NgX != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.NgX);
      }
      AppMethodBeat.o(224541);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(224541);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ehk localehk = (ehk)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(224541);
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
            localehk.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(224541);
          return 0;
        case 2: 
          localehk.KWz = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(224541);
          return 0;
        case 3: 
          localehk.KWE = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(224541);
          return 0;
        case 4: 
          localehk.KUk = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(224541);
          return 0;
        case 5: 
          localehk.KWF = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(224541);
          return 0;
        }
        localehk.NgX = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(224541);
        return 0;
      }
      AppMethodBeat.o(224541);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ehk
 * JD-Core Version:    0.7.0.1
 */