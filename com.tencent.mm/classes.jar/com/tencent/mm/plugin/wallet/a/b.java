package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class b
  extends com.tencent.mm.bw.a
{
  public m HEb;
  public int HEc;
  public String HEd;
  public String HEe;
  public String HEf;
  public String HEg;
  public String HEh;
  public String HEi;
  public String HEj;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91285);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.HEb != null)
      {
        paramVarArgs.ni(1, this.HEb.computeSize());
        this.HEb.writeFields(paramVarArgs);
      }
      paramVarArgs.aM(2, this.HEc);
      if (this.HEd != null) {
        paramVarArgs.e(3, this.HEd);
      }
      if (this.HEe != null) {
        paramVarArgs.e(4, this.HEe);
      }
      if (this.HEf != null) {
        paramVarArgs.e(5, this.HEf);
      }
      if (this.HEg != null) {
        paramVarArgs.e(6, this.HEg);
      }
      if (this.HEh != null) {
        paramVarArgs.e(7, this.HEh);
      }
      if (this.HEi != null) {
        paramVarArgs.e(8, this.HEi);
      }
      if (this.HEj != null) {
        paramVarArgs.e(9, this.HEj);
      }
      AppMethodBeat.o(91285);
      return 0;
    }
    if (paramInt == 1) {
      if (this.HEb == null) {
        break label782;
      }
    }
    label782:
    for (paramInt = g.a.a.a.nh(1, this.HEb.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.bu(2, this.HEc);
      paramInt = i;
      if (this.HEd != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.HEd);
      }
      i = paramInt;
      if (this.HEe != null) {
        i = paramInt + g.a.a.b.b.a.f(4, this.HEe);
      }
      paramInt = i;
      if (this.HEf != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.HEf);
      }
      i = paramInt;
      if (this.HEg != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.HEg);
      }
      paramInt = i;
      if (this.HEh != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.HEh);
      }
      i = paramInt;
      if (this.HEi != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.HEi);
      }
      paramInt = i;
      if (this.HEj != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.HEj);
      }
      AppMethodBeat.o(91285);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(91285);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        b localb = (b)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91285);
          return -1;
        case 1: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new m();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((m)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localb.HEb = ((m)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91285);
          return 0;
        case 2: 
          localb.HEc = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(91285);
          return 0;
        case 3: 
          localb.HEd = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91285);
          return 0;
        case 4: 
          localb.HEe = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91285);
          return 0;
        case 5: 
          localb.HEf = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91285);
          return 0;
        case 6: 
          localb.HEg = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91285);
          return 0;
        case 7: 
          localb.HEh = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91285);
          return 0;
        case 8: 
          localb.HEi = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(91285);
          return 0;
        }
        localb.HEj = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(91285);
        return 0;
      }
      AppMethodBeat.o(91285);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.b
 * JD-Core Version:    0.7.0.1
 */