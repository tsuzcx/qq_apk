package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ehc
  extends com.tencent.mm.bw.a
{
  public String CeI;
  public dqe KEP;
  public String KNW;
  public long NgL;
  public int NgM;
  public aib NgN;
  public float size;
  public String text;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91713);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.NgL);
      if (this.CeI != null) {
        paramVarArgs.e(2, this.CeI);
      }
      if (this.text != null) {
        paramVarArgs.e(3, this.text);
      }
      paramVarArgs.E(4, this.size);
      if (this.KEP != null)
      {
        paramVarArgs.ni(5, this.KEP.computeSize());
        this.KEP.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(6, this.NgM);
      if (this.KNW != null) {
        paramVarArgs.e(7, this.KNW);
      }
      if (this.NgN != null)
      {
        paramVarArgs.ni(8, this.NgN.computeSize());
        this.NgN.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(91713);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.r(1, this.NgL) + 0;
      paramInt = i;
      if (this.CeI != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.CeI);
      }
      i = paramInt;
      if (this.text != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.text);
      }
      i += g.a.a.b.b.a.fS(4) + 4;
      paramInt = i;
      if (this.KEP != null) {
        paramInt = i + g.a.a.a.nh(5, this.KEP.computeSize());
      }
      i = paramInt + g.a.a.b.b.a.bu(6, this.NgM);
      paramInt = i;
      if (this.KNW != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.KNW);
      }
      i = paramInt;
      if (this.NgN != null) {
        i = paramInt + g.a.a.a.nh(8, this.NgN.computeSize());
      }
      AppMethodBeat.o(91713);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(91713);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      ehc localehc = (ehc)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      boolean bool;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(91713);
        return -1;
      case 1: 
        localehc.NgL = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(91713);
        return 0;
      case 2: 
        localehc.CeI = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91713);
        return 0;
      case 3: 
        localehc.text = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91713);
        return 0;
      case 4: 
        localehc.size = Float.intBitsToFloat(((g.a.a.a.a)localObject1).UbS.zm());
        AppMethodBeat.o(91713);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dqe();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dqe)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localehc.KEP = ((dqe)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(91713);
        return 0;
      case 6: 
        localehc.NgM = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(91713);
        return 0;
      case 7: 
        localehc.KNW = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91713);
        return 0;
      }
      paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramVarArgs.get(paramInt);
        localObject1 = new aib();
        localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((aib)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
        localehc.NgN = ((aib)localObject1);
        paramInt += 1;
      }
      AppMethodBeat.o(91713);
      return 0;
    }
    AppMethodBeat.o(91713);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ehc
 * JD-Core Version:    0.7.0.1
 */