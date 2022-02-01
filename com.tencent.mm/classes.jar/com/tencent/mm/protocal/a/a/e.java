package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class e
  extends com.tencent.mm.bw.a
{
  public LinkedList<d> KAA;
  public String KAJ;
  public String KAK;
  public String KAL;
  public String KAM;
  public String KAN;
  public int KAO;
  public int KAz;
  public int nettype;
  public int uin;
  
  public e()
  {
    AppMethodBeat.i(143944);
    this.KAA = new LinkedList();
    AppMethodBeat.o(143944);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143945);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aM(1, this.uin);
      paramVarArgs.aM(2, this.KAz);
      paramVarArgs.aM(3, this.nettype);
      paramVarArgs.e(4, 8, this.KAA);
      if (this.KAJ != null) {
        paramVarArgs.e(5, this.KAJ);
      }
      if (this.KAK != null) {
        paramVarArgs.e(6, this.KAK);
      }
      if (this.KAL != null) {
        paramVarArgs.e(7, this.KAL);
      }
      if (this.KAM != null) {
        paramVarArgs.e(8, this.KAM);
      }
      if (this.KAN != null) {
        paramVarArgs.e(9, this.KAN);
      }
      paramVarArgs.aM(10, this.KAO);
      AppMethodBeat.o(143945);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bu(1, this.uin) + 0 + g.a.a.b.b.a.bu(2, this.KAz) + g.a.a.b.b.a.bu(3, this.nettype) + g.a.a.a.c(4, 8, this.KAA);
      paramInt = i;
      if (this.KAJ != null) {
        paramInt = i + g.a.a.b.b.a.f(5, this.KAJ);
      }
      i = paramInt;
      if (this.KAK != null) {
        i = paramInt + g.a.a.b.b.a.f(6, this.KAK);
      }
      paramInt = i;
      if (this.KAL != null) {
        paramInt = i + g.a.a.b.b.a.f(7, this.KAL);
      }
      i = paramInt;
      if (this.KAM != null) {
        i = paramInt + g.a.a.b.b.a.f(8, this.KAM);
      }
      paramInt = i;
      if (this.KAN != null) {
        paramInt = i + g.a.a.b.b.a.f(9, this.KAN);
      }
      i = g.a.a.b.b.a.bu(10, this.KAO);
      AppMethodBeat.o(143945);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.KAA.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.hPl();
        }
      }
      AppMethodBeat.o(143945);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (g.a.a.a.a)paramVarArgs[0];
      e locale = (e)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143945);
        return -1;
      case 1: 
        locale.uin = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(143945);
        return 0;
      case 2: 
        locale.KAz = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(143945);
        return 0;
      case 3: 
        locale.nettype = ((g.a.a.a.a)localObject1).UbS.zi();
        AppMethodBeat.o(143945);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject1).awh(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new d();
          localObject2 = new g.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((d)localObject1).populateBuilderWithField((g.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((g.a.a.a.a)localObject2))) {}
          locale.KAA.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143945);
        return 0;
      case 5: 
        locale.KAJ = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(143945);
        return 0;
      case 6: 
        locale.KAK = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(143945);
        return 0;
      case 7: 
        locale.KAL = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(143945);
        return 0;
      case 8: 
        locale.KAM = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(143945);
        return 0;
      case 9: 
        locale.KAN = ((g.a.a.a.a)localObject1).UbS.readString();
        AppMethodBeat.o(143945);
        return 0;
      }
      locale.KAO = ((g.a.a.a.a)localObject1).UbS.zi();
      AppMethodBeat.o(143945);
      return 0;
    }
    AppMethodBeat.o(143945);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.e
 * JD-Core Version:    0.7.0.1
 */