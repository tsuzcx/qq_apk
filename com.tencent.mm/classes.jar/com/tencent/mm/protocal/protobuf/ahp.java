package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ahp
  extends com.tencent.mm.bw.a
{
  public dpe KWG;
  public String Lrr;
  public String Lrs;
  public int Lrt;
  public String Lru;
  public String UserName;
  public String xIy;
  public int xJa;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117866);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KWG != null)
      {
        paramVarArgs.ni(1, this.KWG.computeSize());
        this.KWG.writeFields(paramVarArgs);
      }
      if (this.xIy != null) {
        paramVarArgs.e(2, this.xIy);
      }
      if (this.Lrr != null) {
        paramVarArgs.e(3, this.Lrr);
      }
      paramVarArgs.aM(4, this.xJa);
      if (this.UserName != null) {
        paramVarArgs.e(5, this.UserName);
      }
      if (this.Lrs != null) {
        paramVarArgs.e(6, this.Lrs);
      }
      paramVarArgs.aM(7, this.Lrt);
      if (this.Lru != null) {
        paramVarArgs.e(8, this.Lru);
      }
      AppMethodBeat.o(117866);
      return 0;
    }
    if (paramInt == 1) {
      if (this.KWG == null) {
        break label706;
      }
    }
    label706:
    for (int i = g.a.a.a.nh(1, this.KWG.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xIy != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.xIy);
      }
      i = paramInt;
      if (this.Lrr != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.Lrr);
      }
      i += g.a.a.b.b.a.bu(4, this.xJa);
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.UserName);
      }
      i = paramInt;
      if (this.Lrs != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.Lrs);
      }
      i += g.a.a.b.b.a.bu(7, this.Lrt);
      paramInt = i;
      if (this.Lru != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.Lru);
      }
      AppMethodBeat.o(117866);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(117866);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ahp localahp = (ahp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117866);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dpe();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dpe)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localahp.KWG = ((dpe)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(117866);
          return 0;
        case 2: 
          localahp.xIy = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(117866);
          return 0;
        case 3: 
          localahp.Lrr = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(117866);
          return 0;
        case 4: 
          localahp.xJa = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(117866);
          return 0;
        case 5: 
          localahp.UserName = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(117866);
          return 0;
        case 6: 
          localahp.Lrs = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(117866);
          return 0;
        case 7: 
          localahp.Lrt = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(117866);
          return 0;
        }
        localahp.Lru = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(117866);
        return 0;
      }
      AppMethodBeat.o(117866);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ahp
 * JD-Core Version:    0.7.0.1
 */