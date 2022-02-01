package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ng
  extends com.tencent.mm.bx.a
{
  public String FGV;
  public int FGW;
  public String FGZ;
  public String FHc;
  public String FHk;
  public LinkedList<nh> FHl;
  public int FHm;
  public String oBW;
  public int ver;
  
  public ng()
  {
    AppMethodBeat.i(207221);
    this.FHl = new LinkedList();
    AppMethodBeat.o(207221);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(124425);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.FHc != null) {
        paramVarArgs.d(1, this.FHc);
      }
      if (this.oBW != null) {
        paramVarArgs.d(2, this.oBW);
      }
      paramVarArgs.aS(3, this.ver);
      if (this.FGV != null) {
        paramVarArgs.d(4, this.FGV);
      }
      if (this.FHk != null) {
        paramVarArgs.d(5, this.FHk);
      }
      paramVarArgs.aS(6, this.FGW);
      if (this.FGZ != null) {
        paramVarArgs.d(7, this.FGZ);
      }
      paramVarArgs.e(8, 8, this.FHl);
      paramVarArgs.aS(9, this.FHm);
      AppMethodBeat.o(124425);
      return 0;
    }
    if (paramInt == 1) {
      if (this.FHc == null) {
        break label738;
      }
    }
    label738:
    for (paramInt = f.a.a.b.b.a.e(1, this.FHc) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.oBW != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.oBW);
      }
      i += f.a.a.b.b.a.bz(3, this.ver);
      paramInt = i;
      if (this.FGV != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FGV);
      }
      i = paramInt;
      if (this.FHk != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.FHk);
      }
      i += f.a.a.b.b.a.bz(6, this.FGW);
      paramInt = i;
      if (this.FGZ != null) {
        paramInt = i + f.a.a.b.b.a.e(7, this.FGZ);
      }
      i = f.a.a.a.c(8, 8, this.FHl);
      int j = f.a.a.b.b.a.bz(9, this.FHm);
      AppMethodBeat.o(124425);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FHl.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        AppMethodBeat.o(124425);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ng localng = (ng)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(124425);
          return -1;
        case 1: 
          localng.FHc = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(124425);
          return 0;
        case 2: 
          localng.oBW = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(124425);
          return 0;
        case 3: 
          localng.ver = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(124425);
          return 0;
        case 4: 
          localng.FGV = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(124425);
          return 0;
        case 5: 
          localng.FHk = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(124425);
          return 0;
        case 6: 
          localng.FGW = ((f.a.a.a.a)localObject1).NPN.zc();
          AppMethodBeat.o(124425);
          return 0;
        case 7: 
          localng.FGZ = ((f.a.a.a.a)localObject1).NPN.readString();
          AppMethodBeat.o(124425);
          return 0;
        case 8: 
          paramVarArgs = ((f.a.a.a.a)localObject1).alQ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new nh();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((nh)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bx.a)localObject1, com.tencent.mm.bx.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localng.FHl.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(124425);
          return 0;
        }
        localng.FHm = ((f.a.a.a.a)localObject1).NPN.zc();
        AppMethodBeat.o(124425);
        return 0;
      }
      AppMethodBeat.o(124425);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ng
 * JD-Core Version:    0.7.0.1
 */