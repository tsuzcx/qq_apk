package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class dpj
  extends com.tencent.mm.bw.a
{
  public int BXQ;
  public int BXR;
  public float BXS;
  public int BXz;
  public long Cec;
  public long HWH;
  public long HWI;
  public acm HWJ;
  public dqr HWK;
  public long hlm;
  public String path;
  public long startTimeMs;
  public int type;
  public float volume;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(212480);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.path == null)
      {
        paramVarArgs = new b("Not all required fields were included: path");
        AppMethodBeat.o(212480);
        throw paramVarArgs;
      }
      if (this.path != null) {
        paramVarArgs.d(1, this.path);
      }
      paramVarArgs.aS(2, this.type);
      paramVarArgs.aZ(3, this.startTimeMs);
      paramVarArgs.aZ(4, this.hlm);
      paramVarArgs.aZ(5, this.HWH);
      paramVarArgs.aZ(6, this.HWI);
      paramVarArgs.aZ(7, this.Cec);
      paramVarArgs.aS(8, this.BXQ);
      paramVarArgs.aS(9, this.BXR);
      paramVarArgs.y(10, this.BXS);
      paramVarArgs.y(11, this.volume);
      if (this.HWJ != null)
      {
        paramVarArgs.lJ(12, this.HWJ.computeSize());
        this.HWJ.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(13, this.BXz);
      if (this.HWK != null)
      {
        paramVarArgs.lJ(14, this.HWK.computeSize());
        this.HWK.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(212480);
      return 0;
    }
    if (paramInt == 1) {
      if (this.path == null) {
        break label1056;
      }
    }
    label1056:
    for (paramInt = f.a.a.b.b.a.e(1, this.path) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.type) + f.a.a.b.b.a.p(3, this.startTimeMs) + f.a.a.b.b.a.p(4, this.hlm) + f.a.a.b.b.a.p(5, this.HWH) + f.a.a.b.b.a.p(6, this.HWI) + f.a.a.b.b.a.p(7, this.Cec) + f.a.a.b.b.a.bz(8, this.BXQ) + f.a.a.b.b.a.bz(9, this.BXR) + f.a.a.b.b.a.amE(10) + f.a.a.b.b.a.amE(11);
      paramInt = i;
      if (this.HWJ != null) {
        paramInt = i + f.a.a.a.lI(12, this.HWJ.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(13, this.BXz);
      paramInt = i;
      if (this.HWK != null) {
        paramInt = i + f.a.a.a.lI(14, this.HWK.computeSize());
      }
      AppMethodBeat.o(212480);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.path == null)
        {
          paramVarArgs = new b("Not all required fields were included: path");
          AppMethodBeat.o(212480);
          throw paramVarArgs;
        }
        AppMethodBeat.o(212480);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        dpj localdpj = (dpj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(212480);
          return -1;
        case 1: 
          localdpj.path = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(212480);
          return 0;
        case 2: 
          localdpj.type = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(212480);
          return 0;
        case 3: 
          localdpj.startTimeMs = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(212480);
          return 0;
        case 4: 
          localdpj.hlm = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(212480);
          return 0;
        case 5: 
          localdpj.HWH = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(212480);
          return 0;
        case 6: 
          localdpj.HWI = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(212480);
          return 0;
        case 7: 
          localdpj.Cec = ((f.a.a.a.a)localObject1).OmT.zd();
          AppMethodBeat.o(212480);
          return 0;
        case 8: 
          localdpj.BXQ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(212480);
          return 0;
        case 9: 
          localdpj.BXR = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(212480);
          return 0;
        case 10: 
          localdpj.BXS = Float.intBitsToFloat(((f.a.a.a.a)localObject1).OmT.gwb());
          AppMethodBeat.o(212480);
          return 0;
        case 11: 
          localdpj.volume = Float.intBitsToFloat(((f.a.a.a.a)localObject1).OmT.gwb());
          AppMethodBeat.o(212480);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new acm();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((acm)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localdpj.HWJ = ((acm)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(212480);
          return 0;
        case 13: 
          localdpj.BXz = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(212480);
          return 0;
        }
        paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new dqr();
          localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
          for (bool = true; bool; bool = ((dqr)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
          localdpj.HWK = ((dqr)localObject1);
          paramInt += 1;
        }
        AppMethodBeat.o(212480);
        return 0;
      }
      AppMethodBeat.o(212480);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dpj
 * JD-Core Version:    0.7.0.1
 */