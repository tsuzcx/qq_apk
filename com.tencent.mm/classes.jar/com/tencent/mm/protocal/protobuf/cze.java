package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class cze
  extends com.tencent.mm.bw.a
{
  public String KXA;
  public String MEr;
  public int MEs;
  public int MEt;
  public int MaY;
  public String Mba;
  public chl MlQ;
  public aah MlR;
  public int Scene;
  public String SessionId;
  public int xMB;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117889);
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
      if (this.SessionId != null) {
        paramVarArgs.e(3, this.SessionId);
      }
      if (this.Mba != null) {
        paramVarArgs.e(4, this.Mba);
      }
      if (this.MEr != null) {
        paramVarArgs.e(5, this.MEr);
      }
      paramVarArgs.aM(6, this.MEs);
      paramVarArgs.aM(7, this.MaY);
      paramVarArgs.aM(8, this.MEt);
      paramVarArgs.aM(9, this.Scene);
      paramVarArgs.aM(10, this.xMB);
      if (this.MlR != null)
      {
        paramVarArgs.ni(11, this.MlR.computeSize());
        this.MlR.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(117889);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KXA == null) {
        break label930;
      }
    }
    label930:
    for (int i = g.a.a.b.b.a.f(1, this.KXA) + 0;; i = 0)
    {
      paramInt = i;
      if (this.MlQ != null) {
        paramInt = i + g.a.a.a.nh(2, this.MlQ.computeSize());
      }
      i = paramInt;
      if (this.SessionId != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.SessionId);
      }
      paramInt = i;
      if (this.Mba != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.Mba);
      }
      i = paramInt;
      if (this.MEr != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.MEr);
      }
      i = i + g.a.a.b.b.a.bu(6, this.MEs) + g.a.a.b.b.a.bu(7, this.MaY) + g.a.a.b.b.a.bu(8, this.MEt) + g.a.a.b.b.a.bu(9, this.Scene) + g.a.a.b.b.a.bu(10, this.xMB);
      paramInt = i;
      if (this.MlR != null) {
        paramInt = i + g.a.a.a.nh(11, this.MlR.computeSize());
      }
      AppMethodBeat.o(117889);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(117889);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        cze localcze = (cze)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117889);
          return -1;
        case 1: 
          localcze.KXA = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(117889);
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
            localcze.MlQ = ((chl)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117889);
          return 0;
        case 3: 
          localcze.SessionId = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(117889);
          return 0;
        case 4: 
          localcze.Mba = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(117889);
          return 0;
        case 5: 
          localcze.MEr = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(117889);
          return 0;
        case 6: 
          localcze.MEs = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(117889);
          return 0;
        case 7: 
          localcze.MaY = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(117889);
          return 0;
        case 8: 
          localcze.MEt = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(117889);
          return 0;
        case 9: 
          localcze.Scene = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(117889);
          return 0;
        case 10: 
          localcze.xMB = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(117889);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new aah();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((aah)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localcze.MlR = ((aah)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117889);
        return 0;
      }
      AppMethodBeat.o(117889);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cze
 * JD-Core Version:    0.7.0.1
 */