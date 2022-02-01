package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cqx
  extends dop
{
  public String AOk;
  public String Htm;
  public int Htr;
  public String KHB;
  public String dDj;
  public long eht;
  public int grV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91545);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.Htr);
      if (this.dDj != null) {
        paramVarArgs.e(3, this.dDj);
      }
      if (this.AOk != null) {
        paramVarArgs.e(4, this.AOk);
      }
      if (this.Htm != null) {
        paramVarArgs.e(5, this.Htm);
      }
      paramVarArgs.bb(6, this.eht);
      paramVarArgs.aM(7, this.grV);
      if (this.KHB != null) {
        paramVarArgs.e(8, this.KHB);
      }
      AppMethodBeat.o(91545);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label686;
      }
    }
    label686:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.Htr);
      paramInt = i;
      if (this.dDj != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.dDj);
      }
      i = paramInt;
      if (this.AOk != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.AOk);
      }
      paramInt = i;
      if (this.Htm != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.Htm);
      }
      i = paramInt + g.a.a.b.b.a.r(6, this.eht) + g.a.a.b.b.a.bu(7, this.grV);
      paramInt = i;
      if (this.KHB != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.KHB);
      }
      AppMethodBeat.o(91545);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91545);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cqx localcqx = (cqx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91545);
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
            localcqx.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91545);
          return 0;
        case 2: 
          localcqx.Htr = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91545);
          return 0;
        case 3: 
          localcqx.dDj = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91545);
          return 0;
        case 4: 
          localcqx.AOk = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91545);
          return 0;
        case 5: 
          localcqx.Htm = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91545);
          return 0;
        case 6: 
          localcqx.eht = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(91545);
          return 0;
        case 7: 
          localcqx.grV = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91545);
          return 0;
        }
        localcqx.KHB = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91545);
        return 0;
      }
      AppMethodBeat.o(91545);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqx
 * JD-Core Version:    0.7.0.1
 */