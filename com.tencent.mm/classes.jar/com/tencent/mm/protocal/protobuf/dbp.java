package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dbp
  extends com.tencent.mm.bw.a
{
  public long FKR;
  public long FKS;
  public long FKT;
  public LinkedList<dah> FKU;
  public String FKV;
  public String dln;
  public String dnh;
  public String hqo;
  
  public dbp()
  {
    AppMethodBeat.i(122548);
    this.FKR = 0L;
    this.FKS = 0L;
    this.FKT = 0L;
    this.FKU = new LinkedList();
    AppMethodBeat.o(122548);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(122549);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.dnh != null) {
        paramVarArgs.d(1, this.dnh);
      }
      paramVarArgs.aO(2, this.FKR);
      paramVarArgs.aO(3, this.FKS);
      paramVarArgs.aO(4, this.FKT);
      paramVarArgs.e(5, 8, this.FKU);
      if (this.dln != null) {
        paramVarArgs.d(6, this.dln);
      }
      if (this.hqo != null) {
        paramVarArgs.d(7, this.hqo);
      }
      if (this.FKV != null) {
        paramVarArgs.d(8, this.FKV);
      }
      AppMethodBeat.o(122549);
      return 0;
    }
    if (paramInt == 1) {
      if (this.dnh == null) {
        break label670;
      }
    }
    label670:
    for (paramInt = f.a.a.b.b.a.e(1, this.dnh) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.FKR) + f.a.a.b.b.a.p(3, this.FKS) + f.a.a.b.b.a.p(4, this.FKT) + f.a.a.a.c(5, 8, this.FKU);
      paramInt = i;
      if (this.dln != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.dln);
      }
      i = paramInt;
      if (this.hqo != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.hqo);
      }
      paramInt = i;
      if (this.FKV != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.FKV);
      }
      AppMethodBeat.o(122549);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.FKU.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(122549);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dbp localdbp = (dbp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(122549);
          return -1;
        case 1: 
          localdbp.dnh = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(122549);
          return 0;
        case 2: 
          localdbp.FKR = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(122549);
          return 0;
        case 3: 
          localdbp.FKS = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(122549);
          return 0;
        case 4: 
          localdbp.FKT = ((f.a.a.a.a)localObject1).LVo.xG();
          AppMethodBeat.o(122549);
          return 0;
        case 5: 
          paramVarArgs = ((f.a.a.a.a)localObject1).ajj(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dah();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dah)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdbp.FKU.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(122549);
          return 0;
        case 6: 
          localdbp.dln = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(122549);
          return 0;
        case 7: 
          localdbp.hqo = ((f.a.a.a.a)localObject1).LVo.readString();
          AppMethodBeat.o(122549);
          return 0;
        }
        localdbp.FKV = ((f.a.a.a.a)localObject1).LVo.readString();
        AppMethodBeat.o(122549);
        return 0;
      }
      AppMethodBeat.o(122549);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dbp
 * JD-Core Version:    0.7.0.1
 */