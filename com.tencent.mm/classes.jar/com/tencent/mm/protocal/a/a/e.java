package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class e
  extends com.tencent.mm.bx.a
{
  public String CrA;
  public String CrB;
  public String CrC;
  public int CrD;
  public int Cro;
  public LinkedList<d> Crp;
  public String Cry;
  public String Crz;
  public int nettype;
  public int uin;
  
  public e()
  {
    AppMethodBeat.i(143944);
    this.Crp = new LinkedList();
    AppMethodBeat.o(143944);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143945);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.uin);
      paramVarArgs.aR(2, this.Cro);
      paramVarArgs.aR(3, this.nettype);
      paramVarArgs.e(4, 8, this.Crp);
      if (this.Cry != null) {
        paramVarArgs.d(5, this.Cry);
      }
      if (this.Crz != null) {
        paramVarArgs.d(6, this.Crz);
      }
      if (this.CrA != null) {
        paramVarArgs.d(7, this.CrA);
      }
      if (this.CrB != null) {
        paramVarArgs.d(8, this.CrB);
      }
      if (this.CrC != null) {
        paramVarArgs.d(9, this.CrC);
      }
      paramVarArgs.aR(10, this.CrD);
      AppMethodBeat.o(143945);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bA(1, this.uin) + 0 + f.a.a.b.b.a.bA(2, this.Cro) + f.a.a.b.b.a.bA(3, this.nettype) + f.a.a.a.c(4, 8, this.Crp);
      paramInt = i;
      if (this.Cry != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.Cry);
      }
      i = paramInt;
      if (this.Crz != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.Crz);
      }
      paramInt = i;
      if (this.CrA != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.CrA);
      }
      i = paramInt;
      if (this.CrB != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.CrB);
      }
      paramInt = i;
      if (this.CrC != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.CrC);
      }
      i = f.a.a.b.b.a.bA(10, this.CrD);
      AppMethodBeat.o(143945);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.Crp.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.fMq();
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
        locale.uin = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(143945);
        return 0;
      case 2: 
        locale.Cro = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(143945);
        return 0;
      case 3: 
        locale.nettype = ((f.a.a.a.a)localObject1).KhF.xS();
        AppMethodBeat.o(143945);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).agn(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new d();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((d)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locale.Crp.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143945);
        return 0;
      case 5: 
        locale.Cry = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(143945);
        return 0;
      case 6: 
        locale.Crz = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(143945);
        return 0;
      case 7: 
        locale.CrA = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(143945);
        return 0;
      case 8: 
        locale.CrB = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(143945);
        return 0;
      case 9: 
        locale.CrC = ((f.a.a.a.a)localObject1).KhF.readString();
        AppMethodBeat.o(143945);
        return 0;
      }
      locale.CrD = ((f.a.a.a.a)localObject1).KhF.xS();
      AppMethodBeat.o(143945);
      return 0;
    }
    AppMethodBeat.o(143945);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.e
 * JD-Core Version:    0.7.0.1
 */