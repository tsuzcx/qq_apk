package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ale
  extends com.tencent.mm.bw.a
{
  public int KHa;
  public LinkedList<pj> KUf;
  public String KUk;
  public String KUo;
  public LinkedList<String> KWr;
  public int KWs;
  public long KWz;
  public String Lug;
  public String Luh;
  public String Lui;
  public String Luj;
  public String Luk;
  
  public ale()
  {
    AppMethodBeat.i(212273);
    this.KUf = new LinkedList();
    this.KWr = new LinkedList();
    AppMethodBeat.o(212273);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(212274);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Lug != null) {
        paramVarArgs.e(1, this.Lug);
      }
      if (this.Luh != null) {
        paramVarArgs.e(2, this.Luh);
      }
      paramVarArgs.bb(3, this.KWz);
      paramVarArgs.e(4, 8, this.KUf);
      paramVarArgs.aM(5, this.KHa);
      if (this.Lui != null) {
        paramVarArgs.e(6, this.Lui);
      }
      if (this.KUk != null) {
        paramVarArgs.e(7, this.KUk);
      }
      if (this.KUo != null) {
        paramVarArgs.e(8, this.KUo);
      }
      paramVarArgs.e(9, 1, this.KWr);
      paramVarArgs.aM(10, this.KWs);
      if (this.Luj != null) {
        paramVarArgs.e(11, this.Luj);
      }
      if (this.Luk != null) {
        paramVarArgs.e(12, this.Luk);
      }
      AppMethodBeat.o(212274);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Lug == null) {
        break label914;
      }
    }
    label914:
    for (paramInt = g.a.a.b.b.a.f(1, this.Lug) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.Luh != null) {
        i = paramInt + g.a.a.b.b.a.f(2, this.Luh);
      }
      i = i + g.a.a.b.b.a.r(3, this.KWz) + g.a.a.a.c(4, 8, this.KUf) + g.a.a.b.b.a.bu(5, this.KHa);
      paramInt = i;
      if (this.Lui != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.Lui);
      }
      i = paramInt;
      if (this.KUk != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.KUk);
      }
      paramInt = i;
      if (this.KUo != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.KUo);
      }
      i = paramInt + g.a.a.a.c(9, 1, this.KWr) + g.a.a.b.b.a.bu(10, this.KWs);
      paramInt = i;
      if (this.Luj != null) {
        paramInt = i + g.a.a.b.b.a.f(11, this.Luj);
      }
      i = paramInt;
      if (this.Luk != null) {
        i = paramInt + g.a.a.b.b.a.f(12, this.Luk);
      }
      AppMethodBeat.o(212274);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.KUf.clear();
        this.KWr.clear();
        paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        AppMethodBeat.o(212274);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
        ale localale = (ale)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(212274);
          return -1;
        case 1: 
          localale.Lug = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(212274);
          return 0;
        case 2: 
          localale.Luh = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(212274);
          return 0;
        case 3: 
          localale.KWz = ((g.a.a.a.a)localObject1).UbS.zl();
          AppMethodBeat.o(212274);
          return 0;
        case 4: 
          paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new pj();
            localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((pj)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
            localale.KUf.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(212274);
          return 0;
        case 5: 
          localale.KHa = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(212274);
          return 0;
        case 6: 
          localale.Lui = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(212274);
          return 0;
        case 7: 
          localale.KUk = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(212274);
          return 0;
        case 8: 
          localale.KUo = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(212274);
          return 0;
        case 9: 
          localale.KWr.add(((g.a.a.a.a)localObject1).UbS.readString());
          AppMethodBeat.o(212274);
          return 0;
        case 10: 
          localale.KWs = ((g.a.a.a.a)localObject1).UbS.zi();
          AppMethodBeat.o(212274);
          return 0;
        case 11: 
          localale.Luj = ((g.a.a.a.a)localObject1).UbS.readString();
          AppMethodBeat.o(212274);
          return 0;
        }
        localale.Luk = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(212274);
        return 0;
      }
      AppMethodBeat.o(212274);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ale
 * JD-Core Version:    0.7.0.1
 */