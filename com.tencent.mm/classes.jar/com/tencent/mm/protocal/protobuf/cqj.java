package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cqj
  extends dop
{
  public String MvX;
  public int MvY;
  public int MvZ;
  public int Mwa;
  public String dNI;
  public int eaQ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(74664);
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
      if (this.MvX != null) {
        paramVarArgs.e(3, this.MvX);
      }
      paramVarArgs.aM(4, this.MvY);
      paramVarArgs.aM(5, this.MvZ);
      paramVarArgs.aM(6, this.Mwa);
      paramVarArgs.aM(7, this.eaQ);
      AppMethodBeat.o(74664);
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
      if (this.MvX != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.MvX);
      }
      paramInt = g.a.a.b.b.a.bu(4, this.MvY);
      int j = g.a.a.b.b.a.bu(5, this.MvZ);
      int k = g.a.a.b.b.a.bu(6, this.Mwa);
      int m = g.a.a.b.b.a.bu(7, this.eaQ);
      AppMethodBeat.o(74664);
      return i + paramInt + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(74664);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cqj localcqj = (cqj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(74664);
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
            localcqj.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(74664);
          return 0;
        case 2: 
          localcqj.dNI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(74664);
          return 0;
        case 3: 
          localcqj.MvX = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(74664);
          return 0;
        case 4: 
          localcqj.MvY = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(74664);
          return 0;
        case 5: 
          localcqj.MvZ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(74664);
          return 0;
        case 6: 
          localcqj.Mwa = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(74664);
          return 0;
        }
        localcqj.eaQ = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(74664);
        return 0;
      }
      AppMethodBeat.o(74664);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cqj
 * JD-Core Version:    0.7.0.1
 */