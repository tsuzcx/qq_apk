package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;
import java.util.LinkedList;

public final class ru
  extends com.tencent.mm.bw.a
{
  public long KZg;
  public int KZh;
  public LinkedList<String> KZi;
  public String KZj;
  public int KZk;
  public String Title;
  public int oTY;
  public LinkedList<sb> xKD;
  
  public ru()
  {
    AppMethodBeat.i(117842);
    this.KZi = new LinkedList();
    this.xKD = new LinkedList();
    AppMethodBeat.o(117842);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117843);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.KZj == null)
      {
        paramVarArgs = new b("Not all required fields were included: SearchID");
        AppMethodBeat.o(117843);
        throw paramVarArgs;
      }
      paramVarArgs.bb(1, this.KZg);
      paramVarArgs.aM(2, this.KZh);
      if (this.Title != null) {
        paramVarArgs.e(3, this.Title);
      }
      paramVarArgs.e(4, 1, this.KZi);
      paramVarArgs.e(5, 8, this.xKD);
      paramVarArgs.aM(6, this.oTY);
      if (this.KZj != null) {
        paramVarArgs.e(7, this.KZj);
      }
      paramVarArgs.aM(8, this.KZk);
      AppMethodBeat.o(117843);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.r(1, this.KZg) + 0 + g.a.a.b.b.a.bu(2, this.KZh);
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + g.a.a.b.b.a.f(3, this.Title);
      }
      i = paramInt + g.a.a.a.c(4, 1, this.KZi) + g.a.a.a.c(5, 8, this.xKD) + g.a.a.b.b.a.bu(6, this.oTY);
      paramInt = i;
      if (this.KZj != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.KZj);
      }
      i = g.a.a.b.b.a.bu(8, this.KZk);
      AppMethodBeat.o(117843);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.KZi.clear();
      this.xKD.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      if (this.KZj == null)
      {
        paramVarArgs = new b("Not all required fields were included: SearchID");
        AppMethodBeat.o(117843);
        throw paramVarArgs;
      }
      AppMethodBeat.o(117843);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      ru localru = (ru)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117843);
        return -1;
      case 1: 
        localru.KZg = ((g.a.a.a.a)localObject1).UbS.zl();
        AppMethodBeat.o(117843);
        return 0;
      case 2: 
        localru.KZh = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(117843);
        return 0;
      case 3: 
        localru.Title = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(117843);
        return 0;
      case 4: 
        localru.KZi.add(((g.a.a.a.a)localObject1).UbS.readString());
        AppMethodBeat.o(117843);
        return 0;
      case 5: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new sb();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((sb)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localru.xKD.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(117843);
        return 0;
      case 6: 
        localru.oTY = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(117843);
        return 0;
      case 7: 
        localru.KZj = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(117843);
        return 0;
      }
      localru.KZk = ((g.a.a.a.a)localObject1).UbS.zi();
      AppMethodBeat.o(117843);
      return 0;
    }
    AppMethodBeat.o(117843);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ru
 * JD-Core Version:    0.7.0.1
 */