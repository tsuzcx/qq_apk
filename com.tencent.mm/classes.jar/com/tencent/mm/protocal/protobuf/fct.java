package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import java.util.LinkedList;

public final class fct
  extends dop
{
  public acc KOF;
  public b KSW;
  public String Mmu;
  public String Mmv;
  public String NyI;
  public int NyJ;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(123696);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.ni(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.Mmv != null) {
        paramVarArgs.e(2, this.Mmv);
      }
      if (this.KSW != null) {
        paramVarArgs.c(3, this.KSW);
      }
      if (this.NyI != null) {
        paramVarArgs.e(4, this.NyI);
      }
      if (this.Mmu != null) {
        paramVarArgs.e(5, this.Mmu);
      }
      paramVarArgs.aM(6, this.NyJ);
      if (this.KOF != null)
      {
        paramVarArgs.ni(7, this.KOF.computeSize());
        this.KOF.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(123696);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label754;
      }
    }
    label754:
    for (int i = g.a.a.a.nh(1, this.BaseRequest.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Mmv != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.Mmv);
      }
      i = paramInt;
      if (this.KSW != null) {
        i = paramInt + g.a.a.b.b.a.b(3, this.KSW);
      }
      paramInt = i;
      if (this.NyI != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.NyI);
      }
      i = paramInt;
      if (this.Mmu != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.Mmu);
      }
      i += g.a.a.b.b.a.bu(6, this.NyJ);
      paramInt = i;
      if (this.KOF != null) {
        paramInt = i + g.a.a.a.nh(7, this.KOF.computeSize());
      }
      AppMethodBeat.o(123696);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = dop.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = dop.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(123696);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        fct localfct = (fct)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(123696);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new jr();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((jr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localfct.BaseRequest = ((jr)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(123696);
          return 0;
        case 2: 
          localfct.Mmv = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123696);
          return 0;
        case 3: 
          localfct.KSW = ((g.a.a.a.a)localObject1).UbS.hPo();
          AppMethodBeat.o(123696);
          return 0;
        case 4: 
          localfct.NyI = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123696);
          return 0;
        case 5: 
          localfct.Mmu = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(123696);
          return 0;
        case 6: 
          localfct.NyJ = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(123696);
          return 0;
        }
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new acc();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((acc)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, dop.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localfct.KOF = ((acc)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(123696);
        return 0;
      }
      AppMethodBeat.o(123696);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fct
 * JD-Core Version:    0.7.0.1
 */