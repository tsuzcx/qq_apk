package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class bze
  extends com.tencent.mm.bx.a
{
  public int ZFQ;
  public int ZFR;
  public btw aagf;
  public int aaim;
  public int aain;
  public int aaio;
  public int aaip;
  public int aaiq;
  public int aair;
  public int count;
  public int hdp;
  public String nVs;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(169077);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.count);
      paramVarArgs.bS(2, this.ZFQ);
      paramVarArgs.bS(3, this.ZFR);
      paramVarArgs.bS(4, this.aaim);
      if (this.nVs != null) {
        paramVarArgs.g(5, this.nVs);
      }
      if (this.aagf != null)
      {
        paramVarArgs.qD(6, this.aagf.computeSize());
        this.aagf.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(7, this.aain);
      paramVarArgs.bS(8, this.aaio);
      paramVarArgs.bS(9, this.aaip);
      paramVarArgs.bS(10, this.hdp);
      paramVarArgs.bS(11, this.aaiq);
      paramVarArgs.bS(12, this.aair);
      AppMethodBeat.o(169077);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.count) + 0 + i.a.a.b.b.a.cJ(2, this.ZFQ) + i.a.a.b.b.a.cJ(3, this.ZFR) + i.a.a.b.b.a.cJ(4, this.aaim);
      paramInt = i;
      if (this.nVs != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.nVs);
      }
      i = paramInt;
      if (this.aagf != null) {
        i = paramInt + i.a.a.a.qC(6, this.aagf.computeSize());
      }
      paramInt = i.a.a.b.b.a.cJ(7, this.aain);
      int j = i.a.a.b.b.a.cJ(8, this.aaio);
      int k = i.a.a.b.b.a.cJ(9, this.aaip);
      int m = i.a.a.b.b.a.cJ(10, this.hdp);
      int n = i.a.a.b.b.a.cJ(11, this.aaiq);
      int i1 = i.a.a.b.b.a.cJ(12, this.aair);
      AppMethodBeat.o(169077);
      return i + paramInt + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(169077);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      bze localbze = (bze)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(169077);
        return -1;
      case 1: 
        localbze.count = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(169077);
        return 0;
      case 2: 
        localbze.ZFQ = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(169077);
        return 0;
      case 3: 
        localbze.ZFR = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(169077);
        return 0;
      case 4: 
        localbze.aaim = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(169077);
        return 0;
      case 5: 
        localbze.nVs = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(169077);
        return 0;
      case 6: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          btw localbtw = new btw();
          if ((localObject != null) && (localObject.length > 0)) {
            localbtw.parseFrom((byte[])localObject);
          }
          localbze.aagf = localbtw;
          paramInt += 1;
        }
        AppMethodBeat.o(169077);
        return 0;
      case 7: 
        localbze.aain = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(169077);
        return 0;
      case 8: 
        localbze.aaio = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(169077);
        return 0;
      case 9: 
        localbze.aaip = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(169077);
        return 0;
      case 10: 
        localbze.hdp = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(169077);
        return 0;
      case 11: 
        localbze.aaiq = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(169077);
        return 0;
      }
      localbze.aair = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(169077);
      return 0;
    }
    AppMethodBeat.o(169077);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bze
 * JD-Core Version:    0.7.0.1
 */