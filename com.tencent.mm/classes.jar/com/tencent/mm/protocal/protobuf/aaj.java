package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aaj
  extends com.tencent.mm.bw.a
{
  public int KOj;
  public int Llx;
  public String hid;
  public String hie;
  public String hif;
  public String hig;
  public String hih;
  public int oUA;
  public int rBx;
  public LinkedList<cfu> xKD;
  
  public aaj()
  {
    AppMethodBeat.i(143965);
    this.xKD = new LinkedList();
    AppMethodBeat.o(143965);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143966);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.rBx);
      if (this.hif != null) {
        paramVarArgs.e(7, this.hif);
      }
      paramVarArgs.aM(2, this.KOj);
      paramVarArgs.aM(3, this.Llx);
      paramVarArgs.e(4, 8, this.xKD);
      if (this.hid != null) {
        paramVarArgs.e(5, this.hid);
      }
      if (this.hie != null) {
        paramVarArgs.e(6, this.hie);
      }
      if (this.hig != null) {
        paramVarArgs.e(8, this.hig);
      }
      if (this.hih != null) {
        paramVarArgs.e(9, this.hih);
      }
      paramVarArgs.aM(10, this.oUA);
      AppMethodBeat.o(143966);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.rBx) + 0;
      paramInt = i;
      if (this.hif != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.hif);
      }
      i = paramInt + g.a.a.b.b.a.bu(2, this.KOj) + g.a.a.b.b.a.bu(3, this.Llx) + g.a.a.a.c(4, 8, this.xKD);
      paramInt = i;
      if (this.hid != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.hid);
      }
      i = paramInt;
      if (this.hie != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.hie);
      }
      paramInt = i;
      if (this.hig != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.hig);
      }
      i = paramInt;
      if (this.hih != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.hih);
      }
      paramInt = g.a.a.b.b.a.bu(10, this.oUA);
      AppMethodBeat.o(143966);
      return i + paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.xKD.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(143966);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      aaj localaaj = (aaj)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143966);
        return -1;
      case 1: 
        localaaj.rBx = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(143966);
        return 0;
      case 7: 
        localaaj.hif = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(143966);
        return 0;
      case 2: 
        localaaj.KOj = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(143966);
        return 0;
      case 3: 
        localaaj.Llx = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(143966);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new cfu();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((cfu)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          localaaj.xKD.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143966);
        return 0;
      case 5: 
        localaaj.hid = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(143966);
        return 0;
      case 6: 
        localaaj.hie = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(143966);
        return 0;
      case 8: 
        localaaj.hig = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(143966);
        return 0;
      case 9: 
        localaaj.hih = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(143966);
        return 0;
      }
      localaaj.oUA = ((g.a.a.a.a)localObject1).UbS.zi();
      AppMethodBeat.o(143966);
      return 0;
    }
    AppMethodBeat.o(143966);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aaj
 * JD-Core Version:    0.7.0.1
 */