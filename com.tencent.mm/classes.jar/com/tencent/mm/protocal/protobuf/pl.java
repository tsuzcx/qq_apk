package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class pl
  extends com.tencent.mm.bw.a
{
  public LinkedList<oq> KUf;
  public int KUh;
  public String KUi;
  public String KWA;
  public long KWz;
  
  public pl()
  {
    AppMethodBeat.i(212256);
    this.KUf = new LinkedList();
    AppMethodBeat.o(212256);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(212257);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bb(1, this.KWz);
      paramVarArgs.e(2, 8, this.KUf);
      paramVarArgs.aM(3, this.KUh);
      if (this.KUi != null) {
        paramVarArgs.e(4, this.KUi);
      }
      if (this.KWA != null) {
        paramVarArgs.e(5, this.KWA);
      }
      AppMethodBeat.o(212257);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.r(1, this.KWz) + 0 + g.a.a.a.c(2, 8, this.KUf) + g.a.a.b.b.a.bu(3, this.KUh);
      paramInt = i;
      if (this.KUi != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.KUi);
      }
      i = paramInt;
      if (this.KWA != null) {
        i = paramInt + g.a.a.b.b.a.f(5, this.KWA);
      }
      AppMethodBeat.o(212257);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.KUf.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(212257);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      pl localpl = (pl)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(212257);
        return -1;
      case 1: 
        localpl.KWz = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(212257);
        return 0;
      case 2: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new oq();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((oq)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localpl.KUf.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(212257);
        return 0;
      case 3: 
        localpl.KUh = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(212257);
        return 0;
      case 4: 
        localpl.KUi = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(212257);
        return 0;
      }
      localpl.KWA = ((g.a.a.a.a)localObject1).UbS.readString();
      AppMethodBeat.o(212257);
      return 0;
    }
    AppMethodBeat.o(212257);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.pl
 * JD-Core Version:    0.7.0.1
 */