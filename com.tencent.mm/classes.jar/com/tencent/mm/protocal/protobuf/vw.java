package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class vw
  extends dop
{
  public int Lba;
  public b Lhb;
  public b Lhc;
  public String qwM;
  public int yRL;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91408);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.yRL);
      if (this.Lhb != null) {
        paramVarArgs.c(3, this.Lhb);
      }
      if (this.Lhc != null) {
        paramVarArgs.c(4, this.Lhc);
      }
      if (this.qwM != null) {
        paramVarArgs.e(5, this.qwM);
      }
      paramVarArgs.aM(6, this.Lba);
      AppMethodBeat.o(91408);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label582;
      }
    }
    label582:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.yRL);
      paramInt = i;
      if (this.Lhb != null) {
        paramInt = i + g.a.a.b.b.a.b(3, this.Lhb);
      }
      i = paramInt;
      if (this.Lhc != null) {
        i = paramInt + g.a.a.b.b.a.b(4, this.Lhc);
      }
      paramInt = i;
      if (this.qwM != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.qwM);
      }
      i = g.a.a.b.b.a.bu(6, this.Lba);
      AppMethodBeat.o(91408);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91408);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        vw localvw = (vw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91408);
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
            localvw.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91408);
          return 0;
        case 2: 
          localvw.yRL = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91408);
          return 0;
        case 3: 
          localvw.Lhb = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(91408);
          return 0;
        case 4: 
          localvw.Lhc = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(91408);
          return 0;
        case 5: 
          localvw.qwM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91408);
          return 0;
        }
        localvw.Lba = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91408);
        return 0;
      }
      AppMethodBeat.o(91408);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.vw
 * JD-Core Version:    0.7.0.1
 */