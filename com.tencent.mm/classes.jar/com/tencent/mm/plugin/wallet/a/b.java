package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class b
  extends com.tencent.mm.bv.a
{
  public m tTN;
  public int tTO;
  public String tTP;
  public String tTQ;
  public String tTR;
  public String tTS;
  public String tTT;
  public String tTU;
  public String tTV;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56642);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.tTN != null)
      {
        paramVarArgs.iQ(1, this.tTN.computeSize());
        this.tTN.writeFields(paramVarArgs);
      }
      paramVarArgs.aO(2, this.tTO);
      if (this.tTP != null) {
        paramVarArgs.e(3, this.tTP);
      }
      if (this.tTQ != null) {
        paramVarArgs.e(4, this.tTQ);
      }
      if (this.tTR != null) {
        paramVarArgs.e(5, this.tTR);
      }
      if (this.tTS != null) {
        paramVarArgs.e(6, this.tTS);
      }
      if (this.tTT != null) {
        paramVarArgs.e(7, this.tTT);
      }
      if (this.tTU != null) {
        paramVarArgs.e(8, this.tTU);
      }
      if (this.tTV != null) {
        paramVarArgs.e(9, this.tTV);
      }
      AppMethodBeat.o(56642);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tTN == null) {
        break label782;
      }
    }
    label782:
    for (paramInt = e.a.a.a.iP(1, this.tTN.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.tTO);
      paramInt = i;
      if (this.tTP != null) {
        paramInt = i + e.a.a.b.b.a.f(3, this.tTP);
      }
      i = paramInt;
      if (this.tTQ != null) {
        i = paramInt + e.a.a.b.b.a.f(4, this.tTQ);
      }
      paramInt = i;
      if (this.tTR != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.tTR);
      }
      i = paramInt;
      if (this.tTS != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.tTS);
      }
      paramInt = i;
      if (this.tTT != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.tTT);
      }
      i = paramInt;
      if (this.tTU != null) {
        i = paramInt + e.a.a.b.b.a.f(8, this.tTU);
      }
      paramInt = i;
      if (this.tTV != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.tTV);
      }
      AppMethodBeat.o(56642);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56642);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        b localb = (b)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56642);
          return -1;
        case 1: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new m();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((m)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localb.tTN = ((m)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56642);
          return 0;
        case 2: 
          localb.tTO = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56642);
          return 0;
        case 3: 
          localb.tTP = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56642);
          return 0;
        case 4: 
          localb.tTQ = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56642);
          return 0;
        case 5: 
          localb.tTR = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56642);
          return 0;
        case 6: 
          localb.tTS = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56642);
          return 0;
        case 7: 
          localb.tTT = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56642);
          return 0;
        case 8: 
          localb.tTU = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56642);
          return 0;
        }
        localb.tTV = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(56642);
        return 0;
      }
      AppMethodBeat.o(56642);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.b
 * JD-Core Version:    0.7.0.1
 */