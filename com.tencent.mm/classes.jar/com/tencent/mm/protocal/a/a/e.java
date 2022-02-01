package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class e
  extends com.tencent.mm.cd.a
{
  public String RCA;
  public String RCB;
  public String RCC;
  public String RCD;
  public int RCE;
  public int RCp;
  public LinkedList<d> RCq;
  public String RCz;
  public int nettype;
  public int uin;
  
  public e()
  {
    AppMethodBeat.i(143944);
    this.RCq = new LinkedList();
    AppMethodBeat.o(143944);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143945);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      paramVarArgs.aY(1, this.uin);
      paramVarArgs.aY(2, this.RCp);
      paramVarArgs.aY(3, this.nettype);
      paramVarArgs.e(4, 8, this.RCq);
      if (this.RCz != null) {
        paramVarArgs.f(5, this.RCz);
      }
      if (this.RCA != null) {
        paramVarArgs.f(6, this.RCA);
      }
      if (this.RCB != null) {
        paramVarArgs.f(7, this.RCB);
      }
      if (this.RCC != null) {
        paramVarArgs.f(8, this.RCC);
      }
      if (this.RCD != null) {
        paramVarArgs.f(9, this.RCD);
      }
      paramVarArgs.aY(10, this.RCE);
      AppMethodBeat.o(143945);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = g.a.a.b.b.a.bM(1, this.uin) + 0 + g.a.a.b.b.a.bM(2, this.RCp) + g.a.a.b.b.a.bM(3, this.nettype) + g.a.a.a.c(4, 8, this.RCq);
      paramInt = i;
      if (this.RCz != null) {
        paramInt = i + g.a.a.b.b.a.g(5, this.RCz);
      }
      i = paramInt;
      if (this.RCA != null) {
        i = paramInt + g.a.a.b.b.a.g(6, this.RCA);
      }
      paramInt = i;
      if (this.RCB != null) {
        paramInt = i + g.a.a.b.b.a.g(7, this.RCB);
      }
      i = paramInt;
      if (this.RCC != null) {
        i = paramInt + g.a.a.b.b.a.g(8, this.RCC);
      }
      paramInt = i;
      if (this.RCD != null) {
        paramInt = i + g.a.a.b.b.a.g(9, this.RCD);
      }
      i = g.a.a.b.b.a.bM(10, this.RCE);
      AppMethodBeat.o(143945);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.RCq.clear();
      paramVarArgs = new g.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.iUs();
        }
      }
      AppMethodBeat.o(143945);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (g.a.a.a.a)paramVarArgs[0];
      e locale = (e)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143945);
        return -1;
      case 1: 
        locale.uin = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(143945);
        return 0;
      case 2: 
        locale.RCp = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(143945);
        return 0;
      case 3: 
        locale.nettype = ((g.a.a.a.a)localObject).abFh.AK();
        AppMethodBeat.o(143945);
        return 0;
      case 4: 
        paramVarArgs = ((g.a.a.a.a)localObject).aGc(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          d locald = new d();
          if ((localObject != null) && (localObject.length > 0)) {
            locald.parseFrom((byte[])localObject);
          }
          locale.RCq.add(locald);
          paramInt += 1;
        }
        AppMethodBeat.o(143945);
        return 0;
      case 5: 
        locale.RCz = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(143945);
        return 0;
      case 6: 
        locale.RCA = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(143945);
        return 0;
      case 7: 
        locale.RCB = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(143945);
        return 0;
      case 8: 
        locale.RCC = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(143945);
        return 0;
      case 9: 
        locale.RCD = ((g.a.a.a.a)localObject).abFh.readString();
        AppMethodBeat.o(143945);
        return 0;
      }
      locale.RCE = ((g.a.a.a.a)localObject).abFh.AK();
      AppMethodBeat.o(143945);
      return 0;
    }
    AppMethodBeat.o(143945);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.e
 * JD-Core Version:    0.7.0.1
 */