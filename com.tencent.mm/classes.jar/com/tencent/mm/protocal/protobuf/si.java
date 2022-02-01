package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class si
  extends com.tencent.mm.bw.a
{
  public dqe KEP;
  public String KNW;
  public ccy KZS;
  public abm KZT;
  public int gTu;
  public int pTI;
  public int state;
  public String text;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91384);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.state);
      if (this.KEP != null)
      {
        paramVarArgs.ni(2, this.KEP.computeSize());
        this.KEP.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(3, this.gTu);
      if (this.KZS != null)
      {
        paramVarArgs.ni(4, this.KZS.computeSize());
        this.KZS.writeFields(paramVarArgs);
      }
      if (this.text != null) {
        paramVarArgs.e(5, this.text);
      }
      if (this.KNW != null) {
        paramVarArgs.e(6, this.KNW);
      }
      paramVarArgs.aM(7, this.pTI);
      if (this.KZT != null)
      {
        paramVarArgs.ni(8, this.KZT.computeSize());
        this.KZT.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91384);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.state) + 0;
      paramInt = i;
      if (this.KEP != null) {
        paramInt = i + g.a.a.a.nh(2, this.KEP.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(3, this.gTu);
      paramInt = i;
      if (this.KZS != null) {
        paramInt = i + g.a.a.a.nh(4, this.KZS.computeSize());
      }
      i = paramInt;
      if (this.text != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.text);
      }
      paramInt = i;
      if (this.KNW != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.KNW);
      }
      i = paramInt + g.a.a.b.b.a.bu(7, this.pTI);
      paramInt = i;
      if (this.KZT != null) {
        paramInt = i + g.a.a.a.nh(8, this.KZT.computeSize());
      }
      AppMethodBeat.o(91384);
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
      AppMethodBeat.o(91384);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      si localsi = (si)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91384);
        return -1;
      case 1: 
        localsi.state = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91384);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dqe();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dqe)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localsi.KEP = ((dqe)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91384);
        return 0;
      case 3: 
        localsi.gTu = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91384);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ccy();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((ccy)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localsi.KZS = ((ccy)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91384);
        return 0;
      case 5: 
        localsi.text = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91384);
        return 0;
      case 6: 
        localsi.KNW = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91384);
        return 0;
      case 7: 
        localsi.pTI = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91384);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new abm();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((abm)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localsi.KZT = ((abm)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(91384);
      return 0;
    }
    AppMethodBeat.o(91384);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.si
 * JD-Core Version:    0.7.0.1
 */