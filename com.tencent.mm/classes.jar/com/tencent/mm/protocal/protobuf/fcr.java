package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class fcr
  extends com.tencent.mm.bw.a
{
  public String MXx;
  public String NyA;
  public dxs NyB;
  public eie NyC;
  public boolean Nyi;
  public boolean Nyk;
  public boolean Nyl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153317);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.NyA != null) {
        paramVarArgs.e(1, this.NyA);
      }
      if (this.MXx != null) {
        paramVarArgs.e(2, this.MXx);
      }
      if (this.NyB != null)
      {
        paramVarArgs.ni(3, this.NyB.computeSize());
        this.NyB.writeFields(paramVarArgs);
      }
      paramVarArgs.cc(4, this.Nyi);
      paramVarArgs.cc(5, this.Nyk);
      if (this.NyC != null)
      {
        paramVarArgs.ni(6, this.NyC.computeSize());
        this.NyC.writeFields(paramVarArgs);
      }
      paramVarArgs.cc(7, this.Nyl);
      AppMethodBeat.o(153317);
      return 0;
    }
    if (paramInt == 1) {
      if (this.NyA == null) {
        break label714;
      }
    }
    label714:
    for (int i = g.a.a.b.b.a.f(1, this.NyA) + 0;; i = 0)
    {
      paramInt = i;
      if (this.MXx != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.MXx);
      }
      i = paramInt;
      if (this.NyB != null) {
        i = paramInt + g.a.a.a.nh(3, this.NyB.computeSize());
      }
      i = i + (g.a.a.b.b.a.fS(4) + 1) + (g.a.a.b.b.a.fS(5) + 1);
      paramInt = i;
      if (this.NyC != null) {
        paramInt = i + g.a.a.a.nh(6, this.NyC.computeSize());
      }
      i = g.a.a.b.b.a.fS(7);
      AppMethodBeat.o(153317);
      return paramInt + (i + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(153317);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        fcr localfcr = (fcr)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(153317);
          return -1;
        case 1: 
          localfcr.NyA = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(153317);
          return 0;
        case 2: 
          localfcr.MXx = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(153317);
          return 0;
        case 3: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dxs();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((dxs)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localfcr.NyB = ((dxs)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153317);
          return 0;
        case 4: 
          localfcr.Nyi = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(153317);
          return 0;
        case 5: 
          localfcr.Nyk = ((g.a.a.a.a)localObject1).UbS.yZ();
          AppMethodBeat.o(153317);
          return 0;
        case 6: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new eie();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((eie)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localfcr.NyC = ((eie)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(153317);
          return 0;
        }
        localfcr.Nyl = ((g.a.a.a.a)localObject1).UbS.yZ();
        AppMethodBeat.o(153317);
        return 0;
      }
      AppMethodBeat.o(153317);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fcr
 * JD-Core Version:    0.7.0.1
 */