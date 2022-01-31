package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class e
  extends com.tencent.mm.bv.a
{
  public int nettype;
  public int uin;
  public int wjc;
  public LinkedList<d> wjd;
  public String wjm;
  public String wjn;
  public String wjo;
  public String wjp;
  public String wjq;
  public int wjr;
  
  public e()
  {
    AppMethodBeat.i(72820);
    this.wjd = new LinkedList();
    AppMethodBeat.o(72820);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(72821);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aO(1, this.uin);
      paramVarArgs.aO(2, this.wjc);
      paramVarArgs.aO(3, this.nettype);
      paramVarArgs.e(4, 8, this.wjd);
      if (this.wjm != null) {
        paramVarArgs.e(5, this.wjm);
      }
      if (this.wjn != null) {
        paramVarArgs.e(6, this.wjn);
      }
      if (this.wjo != null) {
        paramVarArgs.e(7, this.wjo);
      }
      if (this.wjp != null) {
        paramVarArgs.e(8, this.wjp);
      }
      if (this.wjq != null) {
        paramVarArgs.e(9, this.wjq);
      }
      paramVarArgs.aO(10, this.wjr);
      AppMethodBeat.o(72821);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = e.a.a.b.b.a.bl(1, this.uin) + 0 + e.a.a.b.b.a.bl(2, this.wjc) + e.a.a.b.b.a.bl(3, this.nettype) + e.a.a.a.c(4, 8, this.wjd);
      paramInt = i;
      if (this.wjm != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.wjm);
      }
      i = paramInt;
      if (this.wjn != null) {
        i = paramInt + e.a.a.b.b.a.f(6, this.wjn);
      }
      paramInt = i;
      if (this.wjo != null) {
        paramInt = i + e.a.a.b.b.a.f(7, this.wjo);
      }
      i = paramInt;
      if (this.wjp != null) {
        i = paramInt + e.a.a.b.b.a.f(8, this.wjp);
      }
      paramInt = i;
      if (this.wjq != null) {
        paramInt = i + e.a.a.b.b.a.f(9, this.wjq);
      }
      i = e.a.a.b.b.a.bl(10, this.wjr);
      AppMethodBeat.o(72821);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.wjd.clear();
      paramVarArgs = new e.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(72821);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (e.a.a.a.a)paramVarArgs[0];
      e locale = (e)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(72821);
        return -1;
      case 1: 
        locale.uin = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(72821);
        return 0;
      case 2: 
        locale.wjc = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(72821);
        return 0;
      case 3: 
        locale.nettype = ((e.a.a.a.a)localObject1).CLY.sl();
        AppMethodBeat.o(72821);
        return 0;
      case 4: 
        paramVarArgs = ((e.a.a.a.a)localObject1).Wp(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new d();
          localObject2 = new e.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((d)localObject1).populateBuilderWithField((e.a.a.a.a)localObject2, (com.tencent.mm.bv.a)localObject1, com.tencent.mm.bv.a.getNextFieldNumber((e.a.a.a.a)localObject2))) {}
          locale.wjd.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(72821);
        return 0;
      case 5: 
        locale.wjm = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(72821);
        return 0;
      case 6: 
        locale.wjn = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(72821);
        return 0;
      case 7: 
        locale.wjo = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(72821);
        return 0;
      case 8: 
        locale.wjp = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(72821);
        return 0;
      case 9: 
        locale.wjq = ((e.a.a.a.a)localObject1).CLY.readString();
        AppMethodBeat.o(72821);
        return 0;
      }
      locale.wjr = ((e.a.a.a.a)localObject1).CLY.sl();
      AppMethodBeat.o(72821);
      return 0;
    }
    AppMethodBeat.o(72821);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.e
 * JD-Core Version:    0.7.0.1
 */