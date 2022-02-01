package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class agv
  extends dop
{
  public int KFC;
  public int LqA;
  public String Lqy;
  public int Lqz;
  public String dNI;
  public int source;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147761);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.dNI != null) {
        paramVarArgs.e(2, this.dNI);
      }
      if (this.Lqy != null) {
        paramVarArgs.e(3, this.Lqy);
      }
      paramVarArgs.aM(4, this.Lqz);
      paramVarArgs.aM(5, this.source);
      paramVarArgs.aM(6, this.LqA);
      paramVarArgs.aM(7, this.KFC);
      AppMethodBeat.o(147761);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label618;
      }
    }
    label618:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.dNI != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.dNI);
      }
      i = paramInt;
      if (this.Lqy != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Lqy);
      }
      paramInt = g.a.a.b.b.a.bu(4, this.Lqz);
      int j = g.a.a.b.b.a.bu(5, this.source);
      int k = g.a.a.b.b.a.bu(6, this.LqA);
      int m = g.a.a.b.b.a.bu(7, this.KFC);
      AppMethodBeat.o(147761);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(147761);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        agv localagv = (agv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(147761);
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
            localagv.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(147761);
          return 0;
        case 2: 
          localagv.dNI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(147761);
          return 0;
        case 3: 
          localagv.Lqy = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(147761);
          return 0;
        case 4: 
          localagv.Lqz = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(147761);
          return 0;
        case 5: 
          localagv.source = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(147761);
          return 0;
        case 6: 
          localagv.LqA = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(147761);
          return 0;
        }
        localagv.KFC = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(147761);
        return 0;
      }
      AppMethodBeat.o(147761);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agv
 * JD-Core Version:    0.7.0.1
 */