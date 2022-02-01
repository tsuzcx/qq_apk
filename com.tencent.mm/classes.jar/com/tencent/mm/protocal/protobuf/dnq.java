package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class dnq
  extends com.tencent.mm.bx.a
{
  public LinkedList<bpb> aaUM;
  public int aaUN;
  public int aaUO;
  public int aaUP;
  public LinkedList<FinderObject> aaUQ;
  public long aaUR;
  public long aaUS;
  public String key;
  public b lastBuffer;
  
  public dnq()
  {
    AppMethodBeat.i(258449);
    this.aaUM = new LinkedList();
    this.aaUQ = new LinkedList();
    AppMethodBeat.o(258449);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258455);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.key != null) {
        paramVarArgs.g(1, this.key);
      }
      paramVarArgs.e(2, 8, this.aaUM);
      paramVarArgs.bS(3, this.aaUN);
      paramVarArgs.bS(4, this.aaUO);
      if (this.lastBuffer != null) {
        paramVarArgs.d(5, this.lastBuffer);
      }
      paramVarArgs.bS(6, this.aaUP);
      paramVarArgs.e(7, 8, this.aaUQ);
      paramVarArgs.bv(8, this.aaUR);
      paramVarArgs.bv(9, this.aaUS);
      AppMethodBeat.o(258455);
      return 0;
    }
    if (paramInt == 1) {
      if (this.key == null) {
        break label738;
      }
    }
    label738:
    for (paramInt = i.a.a.b.b.a.h(1, this.key) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.a.c(2, 8, this.aaUM) + i.a.a.b.b.a.cJ(3, this.aaUN) + i.a.a.b.b.a.cJ(4, this.aaUO);
      paramInt = i;
      if (this.lastBuffer != null) {
        paramInt = i + i.a.a.b.b.a.c(5, this.lastBuffer);
      }
      i = i.a.a.b.b.a.cJ(6, this.aaUP);
      int j = i.a.a.a.c(7, 8, this.aaUQ);
      int k = i.a.a.b.b.a.q(8, this.aaUR);
      int m = i.a.a.b.b.a.q(9, this.aaUS);
      AppMethodBeat.o(258455);
      return paramInt + i + j + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.aaUM.clear();
        this.aaUQ.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258455);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        dnq localdnq = (dnq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258455);
          return -1;
        case 1: 
          localdnq.key = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258455);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new bpb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((bpb)localObject2).parseFrom((byte[])localObject1);
            }
            localdnq.aaUM.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258455);
          return 0;
        case 3: 
          localdnq.aaUN = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258455);
          return 0;
        case 4: 
          localdnq.aaUO = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258455);
          return 0;
        case 5: 
          localdnq.lastBuffer = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(258455);
          return 0;
        case 6: 
          localdnq.aaUP = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258455);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new FinderObject();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((FinderObject)localObject2).parseFrom((byte[])localObject1);
            }
            localdnq.aaUQ.add(localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258455);
          return 0;
        case 8: 
          localdnq.aaUR = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(258455);
          return 0;
        }
        localdnq.aaUS = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(258455);
        return 0;
      }
      AppMethodBeat.o(258455);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dnq
 * JD-Core Version:    0.7.0.1
 */