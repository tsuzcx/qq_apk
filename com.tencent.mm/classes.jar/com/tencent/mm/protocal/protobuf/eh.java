package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eh
  extends com.tencent.mm.bv.a
{
  public String Url;
  public String ntu;
  public int pIE;
  public int wqh;
  public String wqi;
  public int wqj;
  public boolean wqk;
  public int wql;
  public int wqm;
  public int wqn;
  public int wqo;
  public int wqp;
  public boolean wqq;
  public LinkedList<ckj> wqr;
  
  public eh()
  {
    AppMethodBeat.i(152667);
    this.wqh = 600;
    this.wqp = -1;
    this.wqq = false;
    this.wqr = new LinkedList();
    AppMethodBeat.o(152667);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(14689);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.Url != null) {
        paramVarArgs.e(1, this.Url);
      }
      if (this.ntu != null) {
        paramVarArgs.e(2, this.ntu);
      }
      paramVarArgs.aO(3, this.wqh);
      if (this.wqi != null) {
        paramVarArgs.e(4, this.wqi);
      }
      paramVarArgs.aO(5, this.wqj);
      paramVarArgs.aS(6, this.wqk);
      paramVarArgs.aO(7, this.wql);
      paramVarArgs.aO(8, this.wqm);
      paramVarArgs.aO(9, this.pIE);
      paramVarArgs.aO(10, this.wqn);
      paramVarArgs.aO(11, this.wqo);
      paramVarArgs.aO(12, this.wqp);
      paramVarArgs.aS(13, this.wqq);
      paramVarArgs.e(14, 8, this.wqr);
      AppMethodBeat.o(14689);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Url == null) {
        break label970;
      }
    }
    label970:
    for (paramInt = e.a.a.b.b.a.f(1, this.Url) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ntu != null) {
        i = paramInt + e.a.a.b.b.a.f(2, this.ntu);
      }
      i += e.a.a.b.b.a.bl(3, this.wqh);
      paramInt = i;
      if (this.wqi != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.wqi);
      }
      i = e.a.a.b.b.a.bl(5, this.wqj);
      int j = e.a.a.b.b.a.eW(6);
      int k = e.a.a.b.b.a.bl(7, this.wql);
      int m = e.a.a.b.b.a.bl(8, this.wqm);
      int n = e.a.a.b.b.a.bl(9, this.pIE);
      int i1 = e.a.a.b.b.a.bl(10, this.wqn);
      int i2 = e.a.a.b.b.a.bl(11, this.wqo);
      int i3 = e.a.a.b.b.a.bl(12, this.wqp);
      int i4 = e.a.a.b.b.a.eW(13);
      int i5 = e.a.a.a.c(14, 8, this.wqr);
      AppMethodBeat.o(14689);
      return paramInt + i + (j + 1) + k + m + n + i1 + i2 + i3 + (i4 + 1) + i5;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.wqr.clear();
        paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(14689);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
        eh localeh = (eh)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(14689);
          return -1;
        case 1: 
          localeh.Url = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(14689);
          return 0;
        case 2: 
          localeh.ntu = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(14689);
          return 0;
        case 3: 
          localeh.wqh = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(14689);
          return 0;
        case 4: 
          localeh.wqi = ((e.a.a.a.a)localObject1).CLY.readString();
          AppMethodBeat.o(14689);
          return 0;
        case 5: 
          localeh.wqj = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(14689);
          return 0;
        case 6: 
          localeh.wqk = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(14689);
          return 0;
        case 7: 
          localeh.wql = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(14689);
          return 0;
        case 8: 
          localeh.wqm = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(14689);
          return 0;
        case 9: 
          localeh.pIE = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(14689);
          return 0;
        case 10: 
          localeh.wqn = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(14689);
          return 0;
        case 11: 
          localeh.wqo = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(14689);
          return 0;
        case 12: 
          localeh.wqp = ((e.a.a.a.a)localObject1).CLY.sl();
          AppMethodBeat.o(14689);
          return 0;
        case 13: 
          localeh.wqq = ((e.a.a.a.a)localObject1).CLY.emu();
          AppMethodBeat.o(14689);
          return 0;
        }
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ckj();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((ckj)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          localeh.wqr.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(14689);
        return 0;
      }
      AppMethodBeat.o(14689);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eh
 * JD-Core Version:    0.7.0.1
 */