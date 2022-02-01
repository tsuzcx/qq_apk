package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class e
  extends com.tencent.mm.bx.a
{
  public int FoN;
  public LinkedList<d> FoO;
  public String FoX;
  public String FoY;
  public String FoZ;
  public String Fpa;
  public String Fpb;
  public int Fpc;
  public int nettype;
  public int uin;
  
  public e()
  {
    AppMethodBeat.i(143944);
    this.FoO = new LinkedList();
    AppMethodBeat.o(143944);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143945);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.uin);
      paramVarArgs.aS(2, this.FoN);
      paramVarArgs.aS(3, this.nettype);
      paramVarArgs.e(4, 8, this.FoO);
      if (this.FoX != null) {
        paramVarArgs.d(5, this.FoX);
      }
      if (this.FoY != null) {
        paramVarArgs.d(6, this.FoY);
      }
      if (this.FoZ != null) {
        paramVarArgs.d(7, this.FoZ);
      }
      if (this.Fpa != null) {
        paramVarArgs.d(8, this.Fpa);
      }
      if (this.Fpb != null) {
        paramVarArgs.d(9, this.Fpb);
      }
      paramVarArgs.aS(10, this.Fpc);
      AppMethodBeat.o(143945);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.uin) + 0 + f.a.a.b.b.a.bz(2, this.FoN) + f.a.a.b.b.a.bz(3, this.nettype) + f.a.a.a.c(4, 8, this.FoO);
      paramInt = i;
      if (this.FoX != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FoX);
      }
      i = paramInt;
      if (this.FoY != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.FoY);
      }
      paramInt = i;
      if (this.FoZ != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FoZ);
      }
      i = paramInt;
      if (this.Fpa != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.Fpa);
      }
      paramInt = i;
      if (this.Fpb != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.Fpb);
      }
      i = f.a.a.b.b.a.bz(10, this.Fpc);
      AppMethodBeat.o(143945);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FoO.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gxE();
        }
      }
      AppMethodBeat.o(143945);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
      e locale = (e)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143945);
        return -1;
      case 1: 
        locale.uin = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(143945);
        return 0;
      case 2: 
        locale.FoN = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(143945);
        return 0;
      case 3: 
        locale.nettype = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(143945);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new d();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((d)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locale.FoO.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143945);
        return 0;
      case 5: 
        locale.FoX = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(143945);
        return 0;
      case 6: 
        locale.FoY = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(143945);
        return 0;
      case 7: 
        locale.FoZ = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(143945);
        return 0;
      case 8: 
        locale.Fpa = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(143945);
        return 0;
      case 9: 
        locale.Fpb = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(143945);
        return 0;
      }
      locale.Fpc = ((f.a.a.a.a)localObject1).NPN.zc();
      AppMethodBeat.o(143945);
      return 0;
    }
    AppMethodBeat.o(143945);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.e
 * JD-Core Version:    0.7.0.1
 */