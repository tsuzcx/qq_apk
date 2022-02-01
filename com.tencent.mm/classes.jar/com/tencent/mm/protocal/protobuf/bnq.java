package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bnq
  extends erp
{
  public b Ayh;
  public atz ZEc;
  public long ZPX;
  public String finderUsername;
  public long hKN;
  public int hYl;
  public String kLn;
  public long liveId;
  public String mdD;
  public long seq;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258652);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.ZEc != null)
      {
        paramVarArgs.qD(2, this.ZEc.computeSize());
        this.ZEc.writeFields(paramVarArgs);
      }
      paramVarArgs.bv(3, this.hKN);
      paramVarArgs.bv(4, this.liveId);
      paramVarArgs.bv(5, this.seq);
      paramVarArgs.bS(6, this.hYl);
      if (this.Ayh != null) {
        paramVarArgs.d(7, this.Ayh);
      }
      if (this.kLn != null) {
        paramVarArgs.g(8, this.kLn);
      }
      paramVarArgs.bv(9, this.ZPX);
      if (this.finderUsername != null) {
        paramVarArgs.g(10, this.finderUsername);
      }
      if (this.mdD != null) {
        paramVarArgs.g(11, this.mdD);
      }
      AppMethodBeat.o(258652);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label882;
      }
    }
    label882:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ZEc != null) {
        i = paramInt + i.a.a.a.qC(2, this.ZEc.computeSize());
      }
      i = i + i.a.a.b.b.a.q(3, this.hKN) + i.a.a.b.b.a.q(4, this.liveId) + i.a.a.b.b.a.q(5, this.seq) + i.a.a.b.b.a.cJ(6, this.hYl);
      paramInt = i;
      if (this.Ayh != null) {
        paramInt = i + i.a.a.b.b.a.c(7, this.Ayh);
      }
      i = paramInt;
      if (this.kLn != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.kLn);
      }
      i += i.a.a.b.b.a.q(9, this.ZPX);
      paramInt = i;
      if (this.finderUsername != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.finderUsername);
      }
      i = paramInt;
      if (this.mdD != null) {
        i = paramInt + i.a.a.b.b.a.h(11, this.mdD);
      }
      AppMethodBeat.o(258652);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258652);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        bnq localbnq = (bnq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258652);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kc();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kc)localObject2).parseFrom((byte[])localObject1);
            }
            localbnq.BaseRequest = ((kc)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258652);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new atz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((atz)localObject2).parseFrom((byte[])localObject1);
            }
            localbnq.ZEc = ((atz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258652);
          return 0;
        case 3: 
          localbnq.hKN = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(258652);
          return 0;
        case 4: 
          localbnq.liveId = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(258652);
          return 0;
        case 5: 
          localbnq.seq = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(258652);
          return 0;
        case 6: 
          localbnq.hYl = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(258652);
          return 0;
        case 7: 
          localbnq.Ayh = ((i.a.a.a.a)localObject1).ajGk.kFX();
          AppMethodBeat.o(258652);
          return 0;
        case 8: 
          localbnq.kLn = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258652);
          return 0;
        case 9: 
          localbnq.ZPX = ((i.a.a.a.a)localObject1).ajGk.aaw();
          AppMethodBeat.o(258652);
          return 0;
        case 10: 
          localbnq.finderUsername = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(258652);
          return 0;
        }
        localbnq.mdD = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(258652);
        return 0;
      }
      AppMethodBeat.o(258652);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bnq
 * JD-Core Version:    0.7.0.1
 */