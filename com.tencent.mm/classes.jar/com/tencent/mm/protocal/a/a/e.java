package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class e
  extends com.tencent.mm.bw.a
{
  public int DJG;
  public LinkedList<d> DJH;
  public String DJQ;
  public String DJR;
  public String DJS;
  public String DJT;
  public String DJU;
  public int DJV;
  public int nettype;
  public int uin;
  
  public e()
  {
    AppMethodBeat.i(143944);
    this.DJH = new LinkedList();
    AppMethodBeat.o(143944);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143945);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aR(1, this.uin);
      paramVarArgs.aR(2, this.DJG);
      paramVarArgs.aR(3, this.nettype);
      paramVarArgs.e(4, 8, this.DJH);
      if (this.DJQ != null) {
        paramVarArgs.d(5, this.DJQ);
      }
      if (this.DJR != null) {
        paramVarArgs.d(6, this.DJR);
      }
      if (this.DJS != null) {
        paramVarArgs.d(7, this.DJS);
      }
      if (this.DJT != null) {
        paramVarArgs.d(8, this.DJT);
      }
      if (this.DJU != null) {
        paramVarArgs.d(9, this.DJU);
      }
      paramVarArgs.aR(10, this.DJV);
      AppMethodBeat.o(143945);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = f.a.a.b.b.a.bx(1, this.uin) + 0 + f.a.a.b.b.a.bx(2, this.DJG) + f.a.a.b.b.a.bx(3, this.nettype) + f.a.a.a.c(4, 8, this.DJH);
      paramInt = i;
      if (this.DJQ != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.DJQ);
      }
      i = paramInt;
      if (this.DJR != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.DJR);
      }
      paramInt = i;
      if (this.DJS != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.DJS);
      }
      i = paramInt;
      if (this.DJT != null) {
        i = paramInt + f.a.a.b.b.a.e(8, this.DJT);
      }
      paramInt = i;
      if (this.DJU != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.DJU);
      }
      i = f.a.a.b.b.a.bx(10, this.DJV);
      AppMethodBeat.o(143945);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.DJH.clear();
      paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.gfg();
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
        locale.uin = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(143945);
        return 0;
      case 2: 
        locale.DJG = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(143945);
        return 0;
      case 3: 
        locale.nettype = ((f.a.a.a.a)localObject1).LVo.xF();
        AppMethodBeat.o(143945);
        return 0;
      case 4: 
        paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new d();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((d)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          locale.DJH.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(143945);
        return 0;
      case 5: 
        locale.DJQ = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(143945);
        return 0;
      case 6: 
        locale.DJR = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(143945);
        return 0;
      case 7: 
        locale.DJS = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(143945);
        return 0;
      case 8: 
        locale.DJT = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(143945);
        return 0;
      case 9: 
        locale.DJU = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(143945);
        return 0;
      }
      locale.DJV = ((f.a.a.a.a)localObject1).LVo.xF();
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