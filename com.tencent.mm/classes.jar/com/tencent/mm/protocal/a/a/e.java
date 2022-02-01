package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class e
  extends com.tencent.mm.bw.a
{
  public int FHA;
  public int FHl;
  public LinkedList<d> FHm;
  public String FHv;
  public String FHw;
  public String FHx;
  public String FHy;
  public String FHz;
  public int nettype;
  public int uin;
  
  public e()
  {
    AppMethodBeat.i(143944);
    this.FHm = new LinkedList();
    AppMethodBeat.o(143944);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143945);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aS(1, this.uin);
      paramVarArgs.aS(2, this.FHl);
      paramVarArgs.aS(3, this.nettype);
      paramVarArgs.e(4, 8, this.FHm);
      if (this.FHv != null) {
        paramVarArgs.d(5, this.FHv);
      }
      if (this.FHw != null) {
        paramVarArgs.d(6, this.FHw);
      }
      if (this.FHx != null) {
        paramVarArgs.d(7, this.FHx);
      }
      if (this.FHy != null) {
        paramVarArgs.d(8, this.FHy);
      }
      if (this.FHz != null) {
        paramVarArgs.d(9, this.FHz);
      }
      paramVarArgs.aS(10, this.FHA);
      AppMethodBeat.o(143945);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bz(1, this.uin) + 0 + f.a.a.b.b.a.bz(2, this.FHl) + f.a.a.b.b.a.bz(3, this.nettype) + f.a.a.a.c(4, 8, this.FHm);
      paramInt = i;
      if (this.FHv != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.FHv);
      }
      i = paramInt;
      if (this.FHw != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.FHw);
      }
      paramInt = i;
      if (this.FHx != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FHx);
      }
      i = paramInt;
      if (this.FHy != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.FHy);
      }
      paramInt = i;
      if (this.FHz != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.FHz);
      }
      i = f.a.a.b.b.a.bz(10, this.FHA);
      AppMethodBeat.o(143945);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.FHm.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gCg();
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
        locale.uin = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(143945);
        return 0;
      case 2: 
        locale.FHl = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(143945);
        return 0;
      case 3: 
        locale.nettype = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(143945);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new d();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((d)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locale.FHm.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143945);
        return 0;
      case 5: 
        locale.FHv = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(143945);
        return 0;
      case 6: 
        locale.FHw = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(143945);
        return 0;
      case 7: 
        locale.FHx = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(143945);
        return 0;
      case 8: 
        locale.FHy = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(143945);
        return 0;
      case 9: 
        locale.FHz = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(143945);
        return 0;
      }
      locale.FHA = ((f.a.a.a.a)localObject1).OmT.zc();
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