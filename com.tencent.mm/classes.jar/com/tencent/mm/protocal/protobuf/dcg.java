package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class dcg
  extends com.tencent.mm.bw.a
{
  public String GLI;
  public long GLJ;
  public LinkedList<dcc> HKI;
  public int index;
  public String rfp;
  public boolean sDg;
  public int type;
  
  public dcg()
  {
    AppMethodBeat.i(169384);
    this.HKI = new LinkedList();
    this.sDg = false;
    this.type = 0;
    this.index = -1;
    AppMethodBeat.o(169384);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169385);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.rfp != null) {
        paramVarArgs.d(1, this.rfp);
      }
      paramVarArgs.aZ(2, this.GLJ);
      paramVarArgs.e(3, 8, this.HKI);
      if (this.GLI != null) {
        paramVarArgs.d(4, this.GLI);
      }
      paramVarArgs.bC(5, this.sDg);
      paramVarArgs.aS(6, this.type);
      paramVarArgs.aS(7, this.index);
      AppMethodBeat.o(169385);
      return 0;
    }
    if (paramInt == 1) {
      if (this.rfp == null) {
        break label594;
      }
    }
    label594:
    for (paramInt = f.a.a.b.b.a.e(1, this.rfp) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.p(2, this.GLJ) + f.a.a.a.c(3, 8, this.HKI);
      paramInt = i;
      if (this.GLI != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GLI);
      }
      i = f.a.a.b.b.a.amF(5);
      int j = f.a.a.b.b.a.bz(6, this.type);
      int k = f.a.a.b.b.a.bz(7, this.index);
      AppMethodBeat.o(169385);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.HKI.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(169385);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dcg localdcg = (dcg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(169385);
          return -1;
        case 1: 
          localdcg.rfp = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(169385);
          return 0;
        case 2: 
          localdcg.GLJ = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(169385);
          return 0;
        case 3: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dcc();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((dcc)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdcg.HKI.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(169385);
          return 0;
        case 4: 
          localdcg.GLI = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(169385);
          return 0;
        case 5: 
          localdcg.sDg = ((f.a.a.a.a)localObject1).OmT.gvY();
          AppMethodBeat.o(169385);
          return 0;
        case 6: 
          localdcg.type = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(169385);
          return 0;
        }
        localdcg.index = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(169385);
        return 0;
      }
      AppMethodBeat.o(169385);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dcg
 * JD-Core Version:    0.7.0.1
 */