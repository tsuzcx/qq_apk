package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aft
  extends com.tencent.mm.bx.a
{
  public LinkedList<afs> GdD;
  public int qQb;
  public int qQc;
  public String qQf;
  public String qQg;
  public String qQh;
  public int qQi;
  public int qQk;
  public int qQl;
  public String qQm;
  public String script;
  
  public aft()
  {
    AppMethodBeat.i(210583);
    this.GdD = new LinkedList();
    AppMethodBeat.o(210583);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(210584);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.qQf != null) {
        paramVarArgs.d(1, this.qQf);
      }
      paramVarArgs.aS(2, this.qQb);
      paramVarArgs.aS(3, this.qQc);
      if (this.qQg != null) {
        paramVarArgs.d(4, this.qQg);
      }
      if (this.qQh != null) {
        paramVarArgs.d(5, this.qQh);
      }
      paramVarArgs.aS(6, this.qQi);
      paramVarArgs.e(7, 8, this.GdD);
      paramVarArgs.aS(8, this.qQk);
      paramVarArgs.aS(9, this.qQl);
      if (this.script != null) {
        paramVarArgs.d(10, this.script);
      }
      if (this.qQm != null) {
        paramVarArgs.d(11, this.qQm);
      }
      AppMethodBeat.o(210584);
      return 0;
    }
    if (paramInt == 1) {
      if (this.qQf == null) {
        break label822;
      }
    }
    label822:
    for (paramInt = f.a.a.b.b.a.e(1, this.qQf) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.qQb) + f.a.a.b.b.a.bz(3, this.qQc);
      paramInt = i;
      if (this.qQg != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.qQg);
      }
      i = paramInt;
      if (this.qQh != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.qQh);
      }
      i = i + f.a.a.b.b.a.bz(6, this.qQi) + f.a.a.a.c(7, 8, this.GdD) + f.a.a.b.b.a.bz(8, this.qQk) + f.a.a.b.b.a.bz(9, this.qQl);
      paramInt = i;
      if (this.script != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.script);
      }
      i = paramInt;
      if (this.qQm != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.qQm);
      }
      AppMethodBeat.o(210584);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GdD.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(210584);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aft localaft = (aft)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(210584);
          return -1;
        case 1: 
          localaft.qQf = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(210584);
          return 0;
        case 2: 
          localaft.qQb = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(210584);
          return 0;
        case 3: 
          localaft.qQc = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(210584);
          return 0;
        case 4: 
          localaft.qQg = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(210584);
          return 0;
        case 5: 
          localaft.qQh = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(210584);
          return 0;
        case 6: 
          localaft.qQi = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(210584);
          return 0;
        case 7: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new afs();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((afs)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaft.GdD.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(210584);
          return 0;
        case 8: 
          localaft.qQk = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(210584);
          return 0;
        case 9: 
          localaft.qQl = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(210584);
          return 0;
        case 10: 
          localaft.script = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(210584);
          return 0;
        }
        localaft.qQm = ((f.a.a.a.a)localObject1).NPN.readString();
        AppMethodBeat.o(210584);
        return 0;
      }
      AppMethodBeat.o(210584);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aft
 * JD-Core Version:    0.7.0.1
 */