package com.tencent.mm.plugin.wallet.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class j
  extends com.tencent.mm.bx.a
{
  public double CGY;
  public LinkedList<t> CHa;
  public double CHf;
  public double CHg;
  public int CHh;
  public String CHi;
  public String CHj;
  public b CHo;
  public String CHp;
  public double CHq;
  public LinkedList<f> CHr;
  
  public j()
  {
    AppMethodBeat.i(91296);
    this.CHr = new LinkedList();
    this.CHa = new LinkedList();
    AppMethodBeat.o(91296);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91297);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CHp != null) {
        paramVarArgs.d(1, this.CHp);
      }
      paramVarArgs.e(2, this.CHq);
      paramVarArgs.e(3, this.CGY);
      paramVarArgs.e(4, 8, this.CHr);
      paramVarArgs.e(5, 8, this.CHa);
      paramVarArgs.e(6, this.CHf);
      paramVarArgs.e(7, this.CHg);
      paramVarArgs.aS(8, this.CHh);
      if (this.CHi != null) {
        paramVarArgs.d(9, this.CHi);
      }
      if (this.CHj != null) {
        paramVarArgs.d(10, this.CHj);
      }
      if (this.CHo != null) {
        paramVarArgs.c(11, this.CHo);
      }
      AppMethodBeat.o(91297);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CHp == null) {
        break label894;
      }
    }
    label894:
    for (paramInt = f.a.a.b.b.a.e(1, this.CHp) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.alT(2) + f.a.a.b.b.a.alT(3) + f.a.a.a.c(4, 8, this.CHr) + f.a.a.a.c(5, 8, this.CHa) + f.a.a.b.b.a.alT(6) + f.a.a.b.b.a.alT(7) + f.a.a.b.b.a.bz(8, this.CHh);
      paramInt = i;
      if (this.CHi != null) {
        paramInt = i + f.a.a.b.b.a.e(9, this.CHi);
      }
      i = paramInt;
      if (this.CHj != null) {
        i = paramInt + f.a.a.b.b.a.e(10, this.CHj);
      }
      paramInt = i;
      if (this.CHo != null) {
        paramInt = i + f.a.a.b.b.a.b(11, this.CHo);
      }
      AppMethodBeat.o(91297);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.CHr.clear();
        this.CHa.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(91297);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        j localj = (j)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91297);
          return -1;
        case 1: 
          localj.CHp = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91297);
          return 0;
        case 2: 
          localj.CHq = Double.longBitsToDouble(((f.a.a.a.a)localObject1).NPN.grA());
          AppMethodBeat.o(91297);
          return 0;
        case 3: 
          localj.CGY = Double.longBitsToDouble(((f.a.a.a.a)localObject1).NPN.grA());
          AppMethodBeat.o(91297);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new f();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((f)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localj.CHr.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91297);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localj.CHa.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91297);
          return 0;
        case 6: 
          localj.CHf = Double.longBitsToDouble(((f.a.a.a.a)localObject1).NPN.grA());
          AppMethodBeat.o(91297);
          return 0;
        case 7: 
          localj.CHg = Double.longBitsToDouble(((f.a.a.a.a)localObject1).NPN.grA());
          AppMethodBeat.o(91297);
          return 0;
        case 8: 
          localj.CHh = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(91297);
          return 0;
        case 9: 
          localj.CHi = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91297);
          return 0;
        case 10: 
          localj.CHj = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(91297);
          return 0;
        }
        localj.CHo = ((f.a.a.a.a)localObject1).NPN.gxI();
        AppMethodBeat.o(91297);
        return 0;
      }
      AppMethodBeat.o(91297);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.wallet.a.j
 * JD-Core Version:    0.7.0.1
 */