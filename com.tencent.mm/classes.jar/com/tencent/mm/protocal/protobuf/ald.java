package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class ald
  extends com.tencent.mm.bw.a
{
  public String GCO;
  public long GCP;
  public long GCQ;
  public String GCR;
  public long GCS;
  public LinkedList<ale> GdG;
  public String GmU;
  public String ynr;
  
  public ald()
  {
    AppMethodBeat.i(91458);
    this.GdG = new LinkedList();
    AppMethodBeat.o(91458);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(91459);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GCO != null) {
        paramVarArgs.d(1, this.GCO);
      }
      paramVarArgs.e(2, 8, this.GdG);
      paramVarArgs.aZ(3, this.GCP);
      paramVarArgs.aZ(4, this.GCQ);
      if (this.GCR != null) {
        paramVarArgs.d(5, this.GCR);
      }
      if (this.ynr != null) {
        paramVarArgs.d(6, this.ynr);
      }
      paramVarArgs.aZ(7, this.GCS);
      if (this.GmU != null) {
        paramVarArgs.d(8, this.GmU);
      }
      AppMethodBeat.o(91459);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GCO == null) {
        break label670;
      }
    }
    label670:
    for (paramInt = f.a.a.b.b.a.e(1, this.GCO) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.a.c(2, 8, this.GdG) + f.a.a.b.b.a.p(3, this.GCP) + f.a.a.b.b.a.p(4, this.GCQ);
      paramInt = i;
      if (this.GCR != null) {
        paramInt = i + f.a.a.b.b.a.e(5, this.GCR);
      }
      i = paramInt;
      if (this.ynr != null) {
        i = paramInt + f.a.a.b.b.a.e(6, this.ynr);
      }
      i += f.a.a.b.b.a.p(7, this.GCS);
      paramInt = i;
      if (this.GmU != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.GmU);
      }
      AppMethodBeat.o(91459);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.GdG.clear();
        paramVarArgs = new f.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(91459);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        ald localald = (ald)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(91459);
          return -1;
        case 1: 
          localald.GCO = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91459);
          return 0;
        case 2: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new ale();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((ale)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localald.GdG.add(localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(91459);
          return 0;
        case 3: 
          localald.GCP = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(91459);
          return 0;
        case 4: 
          localald.GCQ = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(91459);
          return 0;
        case 5: 
          localald.GCR = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91459);
          return 0;
        case 6: 
          localald.ynr = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(91459);
          return 0;
        case 7: 
          localald.GCS = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(91459);
          return 0;
        }
        localald.GmU = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(91459);
        return 0;
      }
      AppMethodBeat.o(91459);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ald
 * JD-Core Version:    0.7.0.1
 */