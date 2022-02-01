package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import java.util.LinkedList;

public final class bje
  extends com.tencent.mm.bx.a
{
  public int BeA;
  public b ZEQ;
  public int ZSQ;
  public LinkedList<bjc> ZSR;
  public long hKN;
  public long liveId;
  public String objectNonceId;
  
  public bje()
  {
    AppMethodBeat.i(260122);
    this.ZSR = new LinkedList();
    AppMethodBeat.o(260122);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260125);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.ZSQ);
      paramVarArgs.e(2, 8, this.ZSR);
      paramVarArgs.bv(3, this.liveId);
      paramVarArgs.bv(4, this.hKN);
      if (this.objectNonceId != null) {
        paramVarArgs.g(5, this.objectNonceId);
      }
      paramVarArgs.bS(7, this.BeA);
      if (this.ZEQ != null) {
        paramVarArgs.d(8, this.ZEQ);
      }
      AppMethodBeat.o(260125);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.ZSQ) + 0 + i.a.a.a.c(2, 8, this.ZSR) + i.a.a.b.b.a.q(3, this.liveId) + i.a.a.b.b.a.q(4, this.hKN);
      paramInt = i;
      if (this.objectNonceId != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.objectNonceId);
      }
      i = paramInt + i.a.a.b.b.a.cJ(7, this.BeA);
      paramInt = i;
      if (this.ZEQ != null) {
        paramInt = i + i.a.a.b.b.a.c(8, this.ZEQ);
      }
      AppMethodBeat.o(260125);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = (byte[])paramVarArgs[0];
      this.ZSR.clear();
      paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(260125);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      bje localbje = (bje)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      case 6: 
      default: 
        AppMethodBeat.o(260125);
        return -1;
      case 1: 
        localbje.ZSQ = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(260125);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          bjc localbjc = new bjc();
          if ((localObject != null) && (localObject.length > 0)) {
            localbjc.parseFrom((byte[])localObject);
          }
          localbje.ZSR.add(localbjc);
          paramInt += 1;
        }
        AppMethodBeat.o(260125);
        return 0;
      case 3: 
        localbje.liveId = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(260125);
        return 0;
      case 4: 
        localbje.hKN = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(260125);
        return 0;
      case 5: 
        localbje.objectNonceId = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(260125);
        return 0;
      case 7: 
        localbje.BeA = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(260125);
        return 0;
      }
      localbje.ZEQ = ((i.a.a.a.a)localObject).ajGk.kFX();
      AppMethodBeat.o(260125);
      return 0;
    }
    AppMethodBeat.o(260125);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bje
 * JD-Core Version:    0.7.0.1
 */