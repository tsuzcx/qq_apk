package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dcw
  extends com.tencent.mm.bx.a
{
  public int Cfu;
  public int Euo;
  public String Eup;
  public int Euq;
  public int Eur;
  public LinkedList<ddb> Eus;
  public boolean Eut;
  public boolean ddw;
  
  public dcw()
  {
    AppMethodBeat.i(153003);
    this.Eus = new LinkedList();
    AppMethodBeat.o(153003);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153004);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.Euo);
      if (this.Eup != null) {
        paramVarArgs.d(2, this.Eup);
      }
      paramVarArgs.aR(3, this.Cfu);
      paramVarArgs.aR(4, this.Euq);
      paramVarArgs.aR(5, this.Eur);
      paramVarArgs.e(6, 8, this.Eus);
      paramVarArgs.bg(7, this.Eut);
      paramVarArgs.bg(8, this.ddw);
      AppMethodBeat.o(153004);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.Euo) + 0;
      paramInt = i;
      if (this.Eup != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Eup);
      }
      i = f.a.a.b.b.a.bA(3, this.Cfu);
      int j = f.a.a.b.b.a.bA(4, this.Euq);
      int k = f.a.a.b.b.a.bA(5, this.Eur);
      int m = f.a.a.a.c(6, 8, this.Eus);
      int n = f.a.a.b.b.a.fY(7);
      int i1 = f.a.a.b.b.a.fY(8);
      AppMethodBeat.o(153004);
      return paramInt + i + j + k + m + (n + 1) + (i1 + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Eus.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
        }
      }
      AppMethodBeat.o(153004);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      dcw localdcw = (dcw)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(153004);
        return -1;
      case 1: 
        localdcw.Euo = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(153004);
        return 0;
      case 2: 
        localdcw.Eup = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(153004);
        return 0;
      case 3: 
        localdcw.Cfu = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(153004);
        return 0;
      case 4: 
        localdcw.Euq = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(153004);
        return 0;
      case 5: 
        localdcw.Eur = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(153004);
        return 0;
      case 6: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ddb();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ddb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdcw.Eus.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(153004);
        return 0;
      case 7: 
        localdcw.Eut = ((f.a.a.a.a)localObject1).KhF.fHu();
        AppMethodBeat.o(153004);
        return 0;
      }
      localdcw.ddw = ((f.a.a.a.a)localObject1).KhF.fHu();
      AppMethodBeat.o(153004);
      return 0;
    }
    AppMethodBeat.o(153004);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dcw
 * JD-Core Version:    0.7.0.1
 */