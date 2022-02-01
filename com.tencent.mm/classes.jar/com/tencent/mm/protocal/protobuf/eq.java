package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;

public final class eq
  extends com.tencent.mm.bw.a
{
  public int CreateTime;
  public String FNL;
  public int FOQ;
  public String FOR;
  public SKBuiltinBuffer_t FOS;
  public int FOT;
  public String FOU;
  public String FOV;
  public String FOW;
  public int FOX;
  public String hFS;
  public String ikm;
  public int nJA;
  public int ucK;
  public String uqs;
  public String uvF;
  public String uvG;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(32116);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.uvG != null) {
        paramVarArgs.d(1, this.uvG);
      }
      if (this.ikm != null) {
        paramVarArgs.d(2, this.ikm);
      }
      paramVarArgs.aS(3, this.FOQ);
      if (this.uvF != null) {
        paramVarArgs.d(4, this.uvF);
      }
      paramVarArgs.aS(5, this.nJA);
      if (this.hFS != null) {
        paramVarArgs.d(6, this.hFS);
      }
      paramVarArgs.aS(7, this.CreateTime);
      if (this.FOR != null) {
        paramVarArgs.d(8, this.FOR);
      }
      if (this.FOS != null)
      {
        paramVarArgs.lJ(9, this.FOS.computeSize());
        this.FOS.writeFields(paramVarArgs);
      }
      paramVarArgs.aS(10, this.ucK);
      paramVarArgs.aS(11, this.FOT);
      if (this.FNL != null) {
        paramVarArgs.d(12, this.FNL);
      }
      if (this.FOU != null) {
        paramVarArgs.d(13, this.FOU);
      }
      if (this.FOV != null) {
        paramVarArgs.d(14, this.FOV);
      }
      if (this.FOW != null) {
        paramVarArgs.d(15, this.FOW);
      }
      paramVarArgs.aS(16, this.FOX);
      if (this.uqs != null) {
        paramVarArgs.d(17, this.uqs);
      }
      AppMethodBeat.o(32116);
      return 0;
    }
    if (paramInt == 1) {
      if (this.uvG == null) {
        break label1221;
      }
    }
    label1221:
    for (paramInt = f.a.a.b.b.a.e(1, this.uvG) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.ikm != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.ikm);
      }
      i += f.a.a.b.b.a.bz(3, this.FOQ);
      paramInt = i;
      if (this.uvF != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.uvF);
      }
      i = paramInt + f.a.a.b.b.a.bz(5, this.nJA);
      paramInt = i;
      if (this.hFS != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.hFS);
      }
      i = paramInt + f.a.a.b.b.a.bz(7, this.CreateTime);
      paramInt = i;
      if (this.FOR != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.FOR);
      }
      i = paramInt;
      if (this.FOS != null) {
        i = paramInt + f.a.a.a.lI(9, this.FOS.computeSize());
      }
      i = i + f.a.a.b.b.a.bz(10, this.ucK) + f.a.a.b.b.a.bz(11, this.FOT);
      paramInt = i;
      if (this.FNL != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.FNL);
      }
      i = paramInt;
      if (this.FOU != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.FOU);
      }
      paramInt = i;
      if (this.FOV != null) {
        paramInt = i + f.a.a.b.b.a.e(14, this.FOV);
      }
      i = paramInt;
      if (this.FOW != null) {
        i = paramInt + f.a.a.b.b.a.e(15, this.FOW);
      }
      i += f.a.a.b.b.a.bz(16, this.FOX);
      paramInt = i;
      if (this.uqs != null) {
        paramInt = i + f.a.a.b.b.a.e(17, this.uqs);
      }
      AppMethodBeat.o(32116);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        AppMethodBeat.o(32116);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (f.a.a.a.a)paramVarArgs[0];
        eq localeq = (eq)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(32116);
          return -1;
        case 1: 
          localeq.uvG = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32116);
          return 0;
        case 2: 
          localeq.ikm = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32116);
          return 0;
        case 3: 
          localeq.FOQ = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32116);
          return 0;
        case 4: 
          localeq.uvF = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32116);
          return 0;
        case 5: 
          localeq.nJA = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32116);
          return 0;
        case 6: 
          localeq.hFS = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32116);
          return 0;
        case 7: 
          localeq.CreateTime = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32116);
          return 0;
        case 8: 
          localeq.FOR = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32116);
          return 0;
        case 9: 
          paramVarArgs = ((f.a.a.a.a)localObject1).amA(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new SKBuiltinBuffer_t();
            localObject2 = new f.a.a.a.a((byte[])localObject2, unknownTagHandler);
            for (boolean bool = true; bool; bool = ((SKBuiltinBuffer_t)localObject1).populateBuilderWithField((f.a.a.a.a)localObject2, (com.tencent.mm.bw.a)localObject1, com.tencent.mm.bw.a.getNextFieldNumber((f.a.a.a.a)localObject2))) {}
            localeq.FOS = ((SKBuiltinBuffer_t)localObject1);
            paramInt += 1;
          }
          AppMethodBeat.o(32116);
          return 0;
        case 10: 
          localeq.ucK = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32116);
          return 0;
        case 11: 
          localeq.FOT = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32116);
          return 0;
        case 12: 
          localeq.FNL = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32116);
          return 0;
        case 13: 
          localeq.FOU = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32116);
          return 0;
        case 14: 
          localeq.FOV = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32116);
          return 0;
        case 15: 
          localeq.FOW = ((f.a.a.a.a)localObject1).OmT.readString();
          AppMethodBeat.o(32116);
          return 0;
        case 16: 
          localeq.FOX = ((f.a.a.a.a)localObject1).OmT.zc();
          AppMethodBeat.o(32116);
          return 0;
        }
        localeq.uqs = ((f.a.a.a.a)localObject1).OmT.readString();
        AppMethodBeat.o(32116);
        return 0;
      }
      AppMethodBeat.o(32116);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eq
 * JD-Core Version:    0.7.0.1
 */