package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ddm
  extends com.tencent.mm.bw.a
{
  public int LWR;
  public String LWS;
  public String LWT;
  public ekv MID;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32369);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.LWR);
      if (this.LWS != null) {
        paramVarArgs.e(2, this.LWS);
      }
      if (this.LWT != null) {
        paramVarArgs.e(3, this.LWT);
      }
      if (this.MID != null)
      {
        paramVarArgs.ni(4, this.MID.computeSize());
        this.MID.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(32369);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.LWR) + 0;
      paramInt = i;
      if (this.LWS != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.LWS);
      }
      i = paramInt;
      if (this.LWT != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.LWT);
      }
      paramInt = i;
      if (this.MID != null) {
        paramInt = i + g.a.a.a.nh(4, this.MID.computeSize());
      }
      AppMethodBeat.o(32369);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(32369);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      ddm localddm = (ddm)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(32369);
        return -1;
      case 1: 
        localddm.LWR = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(32369);
        return 0;
      case 2: 
        localddm.LWS = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(32369);
        return 0;
      case 3: 
        localddm.LWT = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(32369);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new ekv();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (boolean bool = true; bool; bool = ((ekv)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localddm.MID = ((ekv)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(32369);
      return 0;
    }
    AppMethodBeat.o(32369);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ddm
 * JD-Core Version:    0.7.0.1
 */