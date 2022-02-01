package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cge
  extends com.tencent.mm.bw.a
{
  public String KXA;
  public int MaY;
  public String Mba;
  public chl MlQ;
  public aah MlR;
  public int Scene;
  public String SessionId;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(187875);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KXA != null) {
        paramVarArgs.e(1, this.KXA);
      }
      if (this.MlQ != null)
      {
        paramVarArgs.ni(2, this.MlQ.computeSize());
        this.MlQ.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(3, this.Scene);
      if (this.MlR != null)
      {
        paramVarArgs.ni(4, this.MlR.computeSize());
        this.MlR.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(5, this.MaY);
      if (this.Mba != null) {
        paramVarArgs.e(6, this.Mba);
      }
      if (this.SessionId != null) {
        paramVarArgs.e(7, this.SessionId);
      }
      AppMethodBeat.o(187875);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KXA == null) {
        break label738;
      }
    }
    label738:
    for (paramInt = g.a.a.b.b.a.f(1, this.KXA) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.MlQ != null) {
        i = paramInt + g.a.a.a.nh(2, this.MlQ.computeSize());
      }
      i += g.a.a.b.b.a.bu(3, this.Scene);
      paramInt = i;
      if (this.MlR != null) {
        paramInt = i + g.a.a.a.nh(4, this.MlR.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(5, this.MaY);
      paramInt = i;
      if (this.Mba != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.Mba);
      }
      i = paramInt;
      if (this.SessionId != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.SessionId);
      }
      AppMethodBeat.o(187875);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(187875);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cge localcge = (cge)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(187875);
          return -1;
        case 1: 
          localcge.KXA = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(187875);
          return 0;
        case 2: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new chl();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((chl)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcge.MlQ = ((chl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(187875);
          return 0;
        case 3: 
          localcge.Scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(187875);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aah();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aah)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localcge.MlR = ((aah)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(187875);
          return 0;
        case 5: 
          localcge.MaY = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(187875);
          return 0;
        case 6: 
          localcge.Mba = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(187875);
          return 0;
        }
        localcge.SessionId = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(187875);
        return 0;
      }
      AppMethodBeat.o(187875);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cge
 * JD-Core Version:    0.7.0.1
 */