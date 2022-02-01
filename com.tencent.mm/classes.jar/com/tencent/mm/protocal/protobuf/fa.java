package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public class fa
  extends com.tencent.mm.bx.a
{
  public int FwK;
  public String FwL;
  public int FwM;
  public boolean FwN;
  public int FwO;
  public int FwP;
  public int FwQ;
  public int FwR;
  public boolean FwS;
  public LinkedList<dni> FwT;
  public String Url;
  public int hCZ;
  public String hDa;
  public int xbr;
  
  public fa()
  {
    AppMethodBeat.i(6388);
    this.FwK = 600;
    this.hCZ = -1;
    this.FwS = false;
    this.FwT = new LinkedList();
    AppMethodBeat.o(6388);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(6389);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Url != null) {
        paramVarArgs.d(1, this.Url);
      }
      if (this.hDa != null) {
        paramVarArgs.d(2, this.hDa);
      }
      paramVarArgs.aS(3, this.FwK);
      if (this.FwL != null) {
        paramVarArgs.d(4, this.FwL);
      }
      paramVarArgs.aS(5, this.FwM);
      paramVarArgs.bt(6, this.FwN);
      paramVarArgs.aS(7, this.FwO);
      paramVarArgs.aS(8, this.FwP);
      paramVarArgs.aS(9, this.xbr);
      paramVarArgs.aS(10, this.FwQ);
      paramVarArgs.aS(11, this.FwR);
      paramVarArgs.aS(12, this.hCZ);
      paramVarArgs.bt(13, this.FwS);
      paramVarArgs.e(14, 8, this.FwT);
      AppMethodBeat.o(6389);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Url == null) {
        break label966;
      }
    }
    label966:
    for (paramInt = f.a.a.b.b.a.e(1, this.Url) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.hDa != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.hDa);
      }
      i += f.a.a.b.b.a.bz(3, this.FwK);
      paramInt = i;
      if (this.FwL != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FwL);
      }
      i = f.a.a.b.b.a.bz(5, this.FwM);
      int j = f.a.a.b.b.a.alV(6);
      int k = f.a.a.b.b.a.bz(7, this.FwO);
      int m = f.a.a.b.b.a.bz(8, this.FwP);
      int n = f.a.a.b.b.a.bz(9, this.xbr);
      int i1 = f.a.a.b.b.a.bz(10, this.FwQ);
      int i2 = f.a.a.b.b.a.bz(11, this.FwR);
      int i3 = f.a.a.b.b.a.bz(12, this.hCZ);
      int i4 = f.a.a.b.b.a.alV(13);
      int i5 = f.a.a.a.c(14, 8, this.FwT);
      AppMethodBeat.o(6389);
      return paramInt + i + j + k + m + n + i1 + i2 + i3 + i4 + i5;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FwT.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(6389);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        fa localfa = (fa)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(6389);
          return -1;
        case 1: 
          localfa.Url = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(6389);
          return 0;
        case 2: 
          localfa.hDa = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(6389);
          return 0;
        case 3: 
          localfa.FwK = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(6389);
          return 0;
        case 4: 
          localfa.FwL = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(6389);
          return 0;
        case 5: 
          localfa.FwM = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(6389);
          return 0;
        case 6: 
          localfa.FwN = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(6389);
          return 0;
        case 7: 
          localfa.FwO = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(6389);
          return 0;
        case 8: 
          localfa.FwP = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(6389);
          return 0;
        case 9: 
          localfa.xbr = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(6389);
          return 0;
        case 10: 
          localfa.FwQ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(6389);
          return 0;
        case 11: 
          localfa.FwR = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(6389);
          return 0;
        case 12: 
          localfa.hCZ = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(6389);
          return 0;
        case 13: 
          localfa.FwS = ((f.a.a.a.a)localObject1).NPN.grw();
          AppMethodBeat.o(6389);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          Object localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dni();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (boolean bool = true; bool; bool = ((dni)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localfa.FwT.add(localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(6389);
        return 0;
      }
      AppMethodBeat.o(6389);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fa
 * JD-Core Version:    0.7.0.1
 */