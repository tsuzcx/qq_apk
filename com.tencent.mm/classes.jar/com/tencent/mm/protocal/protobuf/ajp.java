package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class ajp
  extends dop
{
  public String KSV;
  public b Lqr;
  public b Lte;
  public int xub;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124485);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.KSV != null) {
        paramVarArgs.e(2, this.KSV);
      }
      paramVarArgs.aM(3, this.xub);
      if (this.Lte != null) {
        paramVarArgs.c(4, this.Lte);
      }
      if (this.Lqr != null) {
        paramVarArgs.c(5, this.Lqr);
      }
      AppMethodBeat.o(124485);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label534;
      }
    }
    label534:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.KSV != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.KSV);
      }
      i += g.a.a.b.b.a.bu(3, this.xub);
      paramInt = i;
      if (this.Lte != null) {
        paramInt = i + g.a.a.b.b.a.b(4, this.Lte);
      }
      i = paramInt;
      if (this.Lqr != null) {
        i = paramInt + g.a.a.b.b.a.b(5, this.Lqr);
      }
      AppMethodBeat.o(124485);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(124485);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ajp localajp = (ajp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124485);
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
            localajp.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124485);
          return 0;
        case 2: 
          localajp.KSV = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(124485);
          return 0;
        case 3: 
          localajp.xub = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(124485);
          return 0;
        case 4: 
          localajp.Lte = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(124485);
          return 0;
        }
        localajp.Lqr = ((g.a.a.a.a)localObject1).UbS.hPo();
        AppMethodBeat.o(124485);
        return 0;
      }
      AppMethodBeat.o(124485);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ajp
 * JD-Core Version:    0.7.0.1
 */