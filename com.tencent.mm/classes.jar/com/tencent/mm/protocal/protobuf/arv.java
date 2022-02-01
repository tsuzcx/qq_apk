package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class arv
  extends com.tencent.mm.bw.a
{
  public String Frk;
  public String GIp;
  public String GIq;
  public int GIr;
  public int GIs;
  public String GIt;
  public String GIu;
  public apb GIv;
  public aox GIw;
  public int ioG;
  public String oRC;
  public asi rQy;
  public int recommendType;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(189401);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.oRC != null) {
        paramVarArgs.d(1, this.oRC);
      }
      if (this.GIp != null) {
        paramVarArgs.d(2, this.GIp);
      }
      if (this.GIq != null) {
        paramVarArgs.d(3, this.GIq);
      }
      paramVarArgs.aS(4, this.GIr);
      paramVarArgs.aS(5, this.GIs);
      if (this.GIt != null) {
        paramVarArgs.d(6, this.GIt);
      }
      if (this.GIu != null) {
        paramVarArgs.d(7, this.GIu);
      }
      if (this.Frk != null) {
        paramVarArgs.d(8, this.Frk);
      }
      paramVarArgs.aS(9, this.ioG);
      if (this.GIv != null)
      {
        paramVarArgs.lJ(10, this.GIv.computeSize());
        this.GIv.writeFields(paramVarArgs);
      }
      if (this.rQy != null)
      {
        paramVarArgs.lJ(11, this.rQy.computeSize());
        this.rQy.writeFields(paramVarArgs);
      }
      if (this.GIw != null)
      {
        paramVarArgs.lJ(12, this.GIw.computeSize());
        this.GIw.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(13, this.recommendType);
      AppMethodBeat.o(189401);
      return 0;
    }
    if (paramInt == 1) {
      if (this.oRC == null) {
        break label1170;
      }
    }
    label1170:
    for (int i = f.a.a.b.b.a.e(1, this.oRC) + 0;; i = 0)
    {
      paramInt = i;
      if (this.GIp != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.GIp);
      }
      i = paramInt;
      if (this.GIq != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.GIq);
      }
      i = i + f.a.a.b.b.a.bz(4, this.GIr) + f.a.a.b.b.a.bz(5, this.GIs);
      paramInt = i;
      if (this.GIt != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GIt);
      }
      i = paramInt;
      if (this.GIu != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.GIu);
      }
      paramInt = i;
      if (this.Frk != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.Frk);
      }
      i = paramInt + f.a.a.b.b.a.bz(9, this.ioG);
      paramInt = i;
      if (this.GIv != null) {
        paramInt = i + f.a.a.a.lI(10, this.GIv.computeSize());
      }
      i = paramInt;
      if (this.rQy != null) {
        i = paramInt + f.a.a.a.lI(11, this.rQy.computeSize());
      }
      paramInt = i;
      if (this.GIw != null) {
        paramInt = i + f.a.a.a.lI(12, this.GIw.computeSize());
      }
      i = f.a.a.b.b.a.bz(13, this.recommendType);
      AppMethodBeat.o(189401);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(189401);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        arv localarv = (arv)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(189401);
          return -1;
        case 1: 
          localarv.oRC = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(189401);
          return 0;
        case 2: 
          localarv.GIp = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(189401);
          return 0;
        case 3: 
          localarv.GIq = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(189401);
          return 0;
        case 4: 
          localarv.GIr = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(189401);
          return 0;
        case 5: 
          localarv.GIs = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(189401);
          return 0;
        case 6: 
          localarv.GIt = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(189401);
          return 0;
        case 7: 
          localarv.GIu = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(189401);
          return 0;
        case 8: 
          localarv.Frk = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(189401);
          return 0;
        case 9: 
          localarv.ioG = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(189401);
          return 0;
        case 10: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new apb();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((apb)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localarv.GIv = ((apb)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(189401);
          return 0;
        case 11: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new asi();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((asi)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localarv.rQy = ((asi)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(189401);
          return 0;
        case 12: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new aox();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (bool = true; bool; bool = ((aox)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localarv.GIw = ((aox)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(189401);
          return 0;
        }
        localarv.recommendType = ((f.a.a.a.a)localObject1).OmT.zc();
        AppMethodBeat.o(189401);
        return 0;
      }
      AppMethodBeat.o(189401);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.arv
 * JD-Core Version:    0.7.0.1
 */