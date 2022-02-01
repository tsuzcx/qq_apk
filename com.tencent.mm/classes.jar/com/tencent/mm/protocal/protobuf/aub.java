package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class aub
  extends com.tencent.mm.bw.a
{
  public dol GKT;
  public String GKU = "";
  public int GKV = 0;
  public String GKW = "";
  public boolean GKX = false;
  public boolean GKY = false;
  public long timestamp = 0L;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122493);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GKT != null)
      {
        paramVarArgs.lJ(1, this.GKT.computeSize());
        this.GKT.writeFields(paramVarArgs);
      }
      if (this.GKW != null) {
        paramVarArgs.d(2, this.GKW);
      }
      paramVarArgs.bC(3, this.GKX);
      if (this.GKU != null) {
        paramVarArgs.d(4, this.GKU);
      }
      paramVarArgs.bC(5, this.GKY);
      paramVarArgs.aZ(6, this.timestamp);
      paramVarArgs.aS(7, this.GKV);
      AppMethodBeat.o(122493);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GKT == null) {
        break label606;
      }
    }
    label606:
    for (paramInt = f.a.a.a.lI(1, this.GKT.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.GKW != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.GKW);
      }
      i += f.a.a.b.b.a.amF(3);
      paramInt = i;
      if (this.GKU != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GKU);
      }
      i = f.a.a.b.b.a.amF(5);
      int j = f.a.a.b.b.a.p(6, this.timestamp);
      int k = f.a.a.b.b.a.bz(7, this.GKV);
      AppMethodBeat.o(122493);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(122493);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        aub localaub = (aub)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122493);
          return -1;
        case 1: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dol();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dol)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localaub.GKT = ((dol)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122493);
          return 0;
        case 2: 
          localaub.GKW = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(122493);
          return 0;
        case 3: 
          localaub.GKX = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(122493);
          return 0;
        case 4: 
          localaub.GKU = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(122493);
          return 0;
        case 5: 
          localaub.GKY = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(122493);
          return 0;
        case 6: 
          localaub.timestamp = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(122493);
          return 0;
        }
        localaub.GKV = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(122493);
        return 0;
      }
      AppMethodBeat.o(122493);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aub
 * JD-Core Version:    0.7.0.1
 */