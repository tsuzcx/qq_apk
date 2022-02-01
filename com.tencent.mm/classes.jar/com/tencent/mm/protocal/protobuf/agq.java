package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;
import java.util.LinkedList;

public final class agq
  extends com.tencent.mm.bw.a
{
  public String FNL;
  public String Ghk;
  public SKBuiltinBuffer_t GwS;
  public String GwT;
  public String GwU;
  public String GwV;
  public int GwW;
  public String MD5;
  public int nJA;
  public String uvF;
  public int xsB;
  public int xsC;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(109446);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GwS == null)
      {
        paramVarArgs = new b("Not all required fields were included: EmojiBuffer");
        AppMethodBeat.o(109446);
        throw paramVarArgs;
      }
      if (this.MD5 != null) {
        paramVarArgs.d(1, this.MD5);
      }
      paramVarArgs.aS(2, this.xsC);
      paramVarArgs.aS(3, this.xsB);
      if (this.GwS != null)
      {
        paramVarArgs.lJ(4, this.GwS.computeSize());
        this.GwS.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(5, this.nJA);
      if (this.uvF != null) {
        paramVarArgs.d(6, this.uvF);
      }
      if (this.GwT != null) {
        paramVarArgs.d(7, this.GwT);
      }
      if (this.GwU != null) {
        paramVarArgs.d(8, this.GwU);
      }
      if (this.GwV != null) {
        paramVarArgs.d(9, this.GwV);
      }
      if (this.FNL != null) {
        paramVarArgs.d(10, this.FNL);
      }
      paramVarArgs.aS(11, this.GwW);
      if (this.Ghk != null) {
        paramVarArgs.d(12, this.Ghk);
      }
      AppMethodBeat.o(109446);
      return 0;
    }
    if (paramInt == 1) {
      if (this.MD5 == null) {
        break label966;
      }
    }
    label966:
    for (paramInt = f.a.a.b.b.a.e(1, this.MD5) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bz(2, this.xsC) + f.a.a.b.b.a.bz(3, this.xsB);
      paramInt = i;
      if (this.GwS != null) {
        paramInt = i + f.a.a.a.lI(4, this.GwS.computeSize());
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.nJA);
      paramInt = i;
      if (this.uvF != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.uvF);
      }
      i = paramInt;
      if (this.GwT != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.GwT);
      }
      paramInt = i;
      if (this.GwU != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.GwU);
      }
      i = paramInt;
      if (this.GwV != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.GwV);
      }
      paramInt = i;
      if (this.FNL != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.FNL);
      }
      i = paramInt + f.a.a.b.b.a.bz(11, this.GwW);
      paramInt = i;
      if (this.Ghk != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.Ghk);
      }
      AppMethodBeat.o(109446);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.GwS == null)
        {
          paramVarArgs = new b("Not all required fields were included: EmojiBuffer");
          AppMethodBeat.o(109446);
          throw paramVarArgs;
        }
        AppMethodBeat.o(109446);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        agq localagq = (agq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(109446);
          return -1;
        case 1: 
          localagq.MD5 = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(109446);
          return 0;
        case 2: 
          localagq.xsC = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(109446);
          return 0;
        case 3: 
          localagq.xsB = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(109446);
          return 0;
        case 4: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localagq.GwS = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(109446);
          return 0;
        case 5: 
          localagq.nJA = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(109446);
          return 0;
        case 6: 
          localagq.uvF = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(109446);
          return 0;
        case 7: 
          localagq.GwT = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(109446);
          return 0;
        case 8: 
          localagq.GwU = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(109446);
          return 0;
        case 9: 
          localagq.GwV = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(109446);
          return 0;
        case 10: 
          localagq.FNL = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(109446);
          return 0;
        case 11: 
          localagq.GwW = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(109446);
          return 0;
        }
        localagq.Ghk = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(109446);
        return 0;
      }
      AppMethodBeat.o(109446);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agq
 * JD-Core Version:    0.7.0.1
 */