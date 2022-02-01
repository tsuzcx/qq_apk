package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class b
  extends com.tencent.mm.bw.a
{
  public m CYn;
  public int CYo;
  public String CYp;
  public String CYq;
  public String CYr;
  public String CYs;
  public String CYt;
  public String CYu;
  public String CYv;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91285);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CYn != null)
      {
        paramVarArgs.lJ(1, this.CYn.computeSize());
        this.CYn.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(2, this.CYo);
      if (this.CYp != null) {
        paramVarArgs.d(3, this.CYp);
      }
      if (this.CYq != null) {
        paramVarArgs.d(4, this.CYq);
      }
      if (this.CYr != null) {
        paramVarArgs.d(5, this.CYr);
      }
      if (this.CYs != null) {
        paramVarArgs.d(6, this.CYs);
      }
      if (this.CYt != null) {
        paramVarArgs.d(7, this.CYt);
      }
      if (this.CYu != null) {
        paramVarArgs.d(8, this.CYu);
      }
      if (this.CYv != null) {
        paramVarArgs.d(9, this.CYv);
      }
      AppMethodBeat.o(91285);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CYn == null) {
        break label782;
      }
    }
    label782:
    for (paramInt = f.a.a.a.lI(1, this.CYn.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.CYo);
      paramInt = i;
      if (this.CYp != null) {
        paramInt = i + f.a.a.b.b.a.e(3, this.CYp);
      }
      i = paramInt;
      if (this.CYq != null) {
        i = paramInt + f.a.a.b.b.a.e(4, this.CYq);
      }
      paramInt = i;
      if (this.CYr != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.CYr);
      }
      i = paramInt;
      if (this.CYs != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.CYs);
      }
      paramInt = i;
      if (this.CYt != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.CYt);
      }
      i = paramInt;
      if (this.CYu != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.CYu);
      }
      paramInt = i;
      if (this.CYv != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.CYv);
      }
      AppMethodBeat.o(91285);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91285);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        b localb = (b)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91285);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new m();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((m)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localb.CYn = ((m)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91285);
          return 0;
        case 2: 
          localb.CYo = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(91285);
          return 0;
        case 3: 
          localb.CYp = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91285);
          return 0;
        case 4: 
          localb.CYq = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91285);
          return 0;
        case 5: 
          localb.CYr = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91285);
          return 0;
        case 6: 
          localb.CYs = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91285);
          return 0;
        case 7: 
          localb.CYt = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91285);
          return 0;
        case 8: 
          localb.CYu = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91285);
          return 0;
        }
        localb.CYv = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91285);
        return 0;
      }
      AppMethodBeat.o(91285);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.b
 * JD-Core Version:    0.7.0.1
 */