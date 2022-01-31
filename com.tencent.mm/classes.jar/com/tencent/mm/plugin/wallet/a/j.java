package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import java.util.LinkedList;

public final class j
  extends com.tencent.mm.bv.a
{
  public double tUe;
  public LinkedList<t> tUg;
  public double tUl;
  public double tUm;
  public int tUn;
  public String tUo;
  public String tUp;
  public b tUu;
  public String tUv;
  public double tUw;
  public LinkedList<f> tUx;
  
  public j()
  {
    AppMethodBeat.i(56653);
    this.tUx = new LinkedList();
    this.tUg = new LinkedList();
    AppMethodBeat.o(56653);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(56654);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.tUv != null) {
        paramVarArgs.e(1, this.tUv);
      }
      paramVarArgs.f(2, this.tUw);
      paramVarArgs.f(3, this.tUe);
      paramVarArgs.e(4, 8, this.tUx);
      paramVarArgs.e(5, 8, this.tUg);
      paramVarArgs.f(6, this.tUl);
      paramVarArgs.f(7, this.tUm);
      paramVarArgs.aO(8, this.tUn);
      if (this.tUo != null) {
        paramVarArgs.e(9, this.tUo);
      }
      if (this.tUp != null) {
        paramVarArgs.e(10, this.tUp);
      }
      if (this.tUu != null) {
        paramVarArgs.c(11, this.tUu);
      }
      AppMethodBeat.o(56654);
      return 0;
    }
    if (paramInt == 1) {
      if (this.tUv == null) {
        break label906;
      }
    }
    label906:
    for (paramInt = e.a.a.b.b.a.f(1, this.tUv) + 0;; paramInt = 0)
    {
      int i = paramInt + (e.a.a.b.b.a.eW(2) + 8) + (e.a.a.b.b.a.eW(3) + 8) + e.a.a.a.c(4, 8, this.tUx) + e.a.a.a.c(5, 8, this.tUg) + (e.a.a.b.b.a.eW(6) + 8) + (e.a.a.b.b.a.eW(7) + 8) + e.a.a.b.b.a.bl(8, this.tUn);
      paramInt = i;
      if (this.tUo != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.tUo);
      }
      i = paramInt;
      if (this.tUp != null) {
        i = paramInt + e.a.a.b.b.a.f(10, this.tUp);
      }
      paramInt = i;
      if (this.tUu != null) {
        paramInt = i + e.a.a.b.b.a.b(11, this.tUu);
      }
      AppMethodBeat.o(56654);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.tUx.clear();
        this.tUg.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(56654);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        j localj = (j)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(56654);
          return -1;
        case 1: 
          localj.tUv = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56654);
          return 0;
        case 2: 
          localj.tUw = Double.longBitsToDouble(((e.a.a.a.a)localObject1).CLY.emy());
          AppMethodBeat.o(56654);
          return 0;
        case 3: 
          localj.tUe = Double.longBitsToDouble(((e.a.a.a.a)localObject1).CLY.emy());
          AppMethodBeat.o(56654);
          return 0;
        case 4: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new f();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((f)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localj.tUx.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56654);
          return 0;
        case 5: 
          paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new t();
            localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((t)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
            localj.tUg.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(56654);
          return 0;
        case 6: 
          localj.tUl = Double.longBitsToDouble(((e.a.a.a.a)localObject1).CLY.emy());
          AppMethodBeat.o(56654);
          return 0;
        case 7: 
          localj.tUm = Double.longBitsToDouble(((e.a.a.a.a)localObject1).CLY.emy());
          AppMethodBeat.o(56654);
          return 0;
        case 8: 
          localj.tUn = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(56654);
          return 0;
        case 9: 
          localj.tUo = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56654);
          return 0;
        case 10: 
          localj.tUp = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(56654);
          return 0;
        }
        localj.tUu = ((e.a.a.a.a)localObject1).CLY.eqS();
        AppMethodBeat.o(56654);
        return 0;
      }
      AppMethodBeat.o(56654);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.j
 * JD-Core Version:    0.7.0.1
 */