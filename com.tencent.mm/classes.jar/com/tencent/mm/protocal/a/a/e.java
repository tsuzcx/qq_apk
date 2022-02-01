package com.tencent.mm.protocal.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class e
  extends com.tencent.mm.bx.a
{
  public int YyR;
  public LinkedList<d> YyS;
  public String Yzb;
  public String Yzc;
  public String Yzd;
  public String Yze;
  public String Yzf;
  public int Yzg;
  public int nettype;
  public int uin;
  
  public e()
  {
    AppMethodBeat.i(143944);
    this.YyS = new LinkedList();
    AppMethodBeat.o(143944);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(143945);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.uin);
      paramVarArgs.bS(2, this.YyR);
      paramVarArgs.bS(3, this.nettype);
      paramVarArgs.e(4, 8, this.YyS);
      if (this.Yzb != null) {
        paramVarArgs.g(5, this.Yzb);
      }
      if (this.Yzc != null) {
        paramVarArgs.g(6, this.Yzc);
      }
      if (this.Yzd != null) {
        paramVarArgs.g(7, this.Yzd);
      }
      if (this.Yze != null) {
        paramVarArgs.g(8, this.Yze);
      }
      if (this.Yzf != null) {
        paramVarArgs.g(9, this.Yzf);
      }
      paramVarArgs.bS(10, this.Yzg);
      AppMethodBeat.o(143945);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.uin) + 0 + i.a.a.b.b.a.cJ(2, this.YyR) + i.a.a.b.b.a.cJ(3, this.nettype) + i.a.a.a.c(4, 8, this.YyS);
      paramInt = i;
      if (this.Yzb != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.Yzb);
      }
      i = paramInt;
      if (this.Yzc != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.Yzc);
      }
      paramInt = i;
      if (this.Yzd != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.Yzd);
      }
      i = paramInt;
      if (this.Yze != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.Yze);
      }
      paramInt = i;
      if (this.Yzf != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.Yzf);
      }
      i = i.a.a.b.b.a.cJ(10, this.Yzg);
      AppMethodBeat.o(143945);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.YyS.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(143945);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      e locale = (e)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(143945);
        return -1;
      case 1: 
        locale.uin = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(143945);
        return 0;
      case 2: 
        locale.YyR = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(143945);
        return 0;
      case 3: 
        locale.nettype = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(143945);
        return 0;
      case 4: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          d locald = new d();
          if ((localObject != null) && (localObject.length > 0)) {
            locald.parseFrom((byte[])localObject);
          }
          locale.YyS.add(locald);
          paramInt += 1;
        }
        AppMethodBeat.o(143945);
        return 0;
      case 5: 
        locale.Yzb = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(143945);
        return 0;
      case 6: 
        locale.Yzc = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(143945);
        return 0;
      case 7: 
        locale.Yzd = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(143945);
        return 0;
      case 8: 
        locale.Yze = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(143945);
        return 0;
      case 9: 
        locale.Yzf = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(143945);
        return 0;
      }
      locale.Yzg = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(143945);
      return 0;
    }
    AppMethodBeat.o(143945);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.a.a.e
 * JD-Core Version:    0.7.0.1
 */