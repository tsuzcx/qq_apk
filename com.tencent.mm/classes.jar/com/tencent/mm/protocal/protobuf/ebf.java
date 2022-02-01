package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ebf
  extends com.tencent.mm.bw.a
{
  public long NaS;
  public long NaT;
  public long NaU;
  public LinkedList<dzv> NaV;
  public String NaW;
  public String dPM;
  public String dRM;
  public String iGB;
  
  public ebf()
  {
    AppMethodBeat.i(122548);
    this.NaS = 0L;
    this.NaT = 0L;
    this.NaU = 0L;
    this.NaV = new LinkedList();
    AppMethodBeat.o(122548);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122549);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.dRM != null) {
        paramVarArgs.e(1, this.dRM);
      }
      paramVarArgs.bb(2, this.NaS);
      paramVarArgs.bb(3, this.NaT);
      paramVarArgs.bb(4, this.NaU);
      paramVarArgs.e(5, 8, this.NaV);
      if (this.dPM != null) {
        paramVarArgs.e(6, this.dPM);
      }
      if (this.iGB != null) {
        paramVarArgs.e(7, this.iGB);
      }
      if (this.NaW != null) {
        paramVarArgs.e(8, this.NaW);
      }
      AppMethodBeat.o(122549);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dRM == null) {
        break label670;
      }
    }
    label670:
    for (paramInt = g.a.a.b.b.a.f(1, this.dRM) + 0;; paramInt = 0)
    {
      int i = paramInt + g.a.a.b.b.a.r(2, this.NaS) + g.a.a.b.b.a.r(3, this.NaT) + g.a.a.b.b.a.r(4, this.NaU) + g.a.a.a.c(5, 8, this.NaV);
      paramInt = i;
      if (this.dPM != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.dPM);
      }
      i = paramInt;
      if (this.iGB != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.iGB);
      }
      paramInt = i;
      if (this.NaW != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.NaW);
      }
      AppMethodBeat.o(122549);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.NaV.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(122549);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ebf localebf = (ebf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122549);
          return -1;
        case 1: 
          localebf.dRM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(122549);
          return 0;
        case 2: 
          localebf.NaS = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(122549);
          return 0;
        case 3: 
          localebf.NaT = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(122549);
          return 0;
        case 4: 
          localebf.NaU = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(122549);
          return 0;
        case 5: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dzv();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dzv)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localebf.NaV.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122549);
          return 0;
        case 6: 
          localebf.dPM = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(122549);
          return 0;
        case 7: 
          localebf.iGB = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(122549);
          return 0;
        }
        localebf.NaW = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(122549);
        return 0;
      }
      AppMethodBeat.o(122549);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ebf
 * JD-Core Version:    0.7.0.1
 */