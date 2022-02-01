package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bkn
  extends dop
{
  public long LdA;
  public String Ldn;
  public int Leq;
  public double latitude;
  public double longitude;
  public int scene;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(114015);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Ldn != null) {
        paramVarArgs.e(2, this.Ldn);
      }
      paramVarArgs.e(3, this.latitude);
      paramVarArgs.e(4, this.longitude);
      paramVarArgs.bb(5, this.LdA);
      paramVarArgs.aM(6, this.Leq);
      paramVarArgs.aM(7, this.scene);
      AppMethodBeat.o(114015);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label608;
      }
    }
    label608:
    for (paramInt = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Ldn != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.Ldn);
      }
      paramInt = g.a.a.b.b.a.fS(3);
      int j = g.a.a.b.b.a.fS(4);
      int k = g.a.a.b.b.a.r(5, this.LdA);
      int m = g.a.a.b.b.a.bu(6, this.Leq);
      int n = g.a.a.b.b.a.bu(7, this.scene);
      AppMethodBeat.o(114015);
      return i + (paramInt + 8) + (j + 8) + k + m + n;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(114015);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        bkn localbkn = (bkn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(114015);
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
            localbkn.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(114015);
          return 0;
        case 2: 
          localbkn.Ldn = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(114015);
          return 0;
        case 3: 
          localbkn.latitude = Double.longBitsToDouble(((g.a.a.a.a)localObject1).UbS.zn());
          AppMethodBeat.o(114015);
          return 0;
        case 4: 
          localbkn.longitude = Double.longBitsToDouble(((g.a.a.a.a)localObject1).UbS.zn());
          AppMethodBeat.o(114015);
          return 0;
        case 5: 
          localbkn.LdA = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(114015);
          return 0;
        case 6: 
          localbkn.Leq = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(114015);
          return 0;
        }
        localbkn.scene = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(114015);
        return 0;
      }
      AppMethodBeat.o(114015);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bkn
 * JD-Core Version:    0.7.0.1
 */