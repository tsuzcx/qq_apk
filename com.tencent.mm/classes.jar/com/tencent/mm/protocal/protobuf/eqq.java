package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eqq
  extends com.tencent.mm.bw.a
{
  public LinkedList<eqr> Lhs;
  public String MJZ;
  public int Nhi;
  public String dNI;
  public String dQx;
  public int version;
  
  public eqq()
  {
    AppMethodBeat.i(176154);
    this.Lhs = new LinkedList();
    AppMethodBeat.o(176154);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(176155);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.e(1, 8, this.Lhs);
      if (this.dQx != null) {
        paramVarArgs.e(2, this.dQx);
      }
      paramVarArgs.aM(3, this.Nhi);
      if (this.MJZ != null) {
        paramVarArgs.e(4, this.MJZ);
      }
      if (this.dNI != null) {
        paramVarArgs.e(5, this.dNI);
      }
      paramVarArgs.aM(6, this.version);
      AppMethodBeat.o(176155);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.a.c(1, 8, this.Lhs) + 0;
      paramInt = i;
      if (this.dQx != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.dQx);
      }
      i = paramInt + g.a.a.b.b.a.bu(3, this.Nhi);
      paramInt = i;
      if (this.MJZ != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.MJZ);
      }
      i = paramInt;
      if (this.dNI != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.dNI);
      }
      paramInt = g.a.a.b.b.a.bu(6, this.version);
      AppMethodBeat.o(176155);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Lhs.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(176155);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      eqq localeqq = (eqq)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(176155);
        return -1;
      case 1: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new eqr();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((eqr)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localeqq.Lhs.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(176155);
        return 0;
      case 2: 
        localeqq.dQx = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(176155);
        return 0;
      case 3: 
        localeqq.Nhi = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(176155);
        return 0;
      case 4: 
        localeqq.MJZ = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(176155);
        return 0;
      case 5: 
        localeqq.dNI = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(176155);
        return 0;
      }
      localeqq.version = ((g.a.a.a.a)localObject1).UbS.zi();
      AppMethodBeat.o(176155);
      return 0;
    }
    AppMethodBeat.o(176155);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eqq
 * JD-Core Version:    0.7.0.1
 */