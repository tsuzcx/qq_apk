package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cuu
  extends dop
{
  public String ANo;
  public int HuF;
  public String HuS;
  public String MAa;
  public int yba;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91558);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.yba);
      paramVarArgs.aM(3, this.HuF);
      if (this.ANo != null) {
        paramVarArgs.e(4, this.ANo);
      }
      if (this.MAa != null) {
        paramVarArgs.e(5, this.MAa);
      }
      if (this.HuS != null) {
        paramVarArgs.e(100, this.HuS);
      }
      AppMethodBeat.o(91558);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label598;
      }
    }
    label598:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.yba) + g.a.a.b.b.a.bu(3, this.HuF);
      paramInt = i;
      if (this.ANo != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.ANo);
      }
      i = paramInt;
      if (this.MAa != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.MAa);
      }
      paramInt = i;
      if (this.HuS != null) {
        paramInt = i + g.a.a.b.b.a.f(100, this.HuS);
      }
      AppMethodBeat.o(91558);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91558);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cuu localcuu = (cuu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91558);
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
            localcuu.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91558);
          return 0;
        case 2: 
          localcuu.yba = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91558);
          return 0;
        case 3: 
          localcuu.HuF = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91558);
          return 0;
        case 4: 
          localcuu.ANo = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91558);
          return 0;
        case 5: 
          localcuu.MAa = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91558);
          return 0;
        }
        localcuu.HuS = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91558);
        return 0;
      }
      AppMethodBeat.o(91558);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cuu
 * JD-Core Version:    0.7.0.1
 */