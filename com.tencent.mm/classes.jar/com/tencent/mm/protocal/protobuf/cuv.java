package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class cuv
  extends com.tencent.mm.bx.a
{
  public String AesKey;
  public String Gjr;
  public String HbF;
  public String HbG;
  public String HlW;
  public String HmR;
  public float HmS;
  public String HmT;
  public String HmU;
  public String HmV;
  public String HmW;
  public String HmX;
  public float HmY;
  public String MD5;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115967);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Gjr == null)
      {
        paramVarArgs = new b("Not all required fields were included: FileID");
        AppMethodBeat.o(115967);
        throw paramVarArgs;
      }
      if (this.AesKey == null)
      {
        paramVarArgs = new b("Not all required fields were included: AesKey");
        AppMethodBeat.o(115967);
        throw paramVarArgs;
      }
      if (this.HbF == null)
      {
        paramVarArgs = new b("Not all required fields were included: ThumbFileID");
        AppMethodBeat.o(115967);
        throw paramVarArgs;
      }
      if (this.HbG == null)
      {
        paramVarArgs = new b("Not all required fields were included: ThumbAesKey");
        AppMethodBeat.o(115967);
        throw paramVarArgs;
      }
      if (this.HmT == null)
      {
        paramVarArgs = new b("Not all required fields were included: ThumbMD5");
        AppMethodBeat.o(115967);
        throw paramVarArgs;
      }
      if (this.HmV == null)
      {
        paramVarArgs = new b("Not all required fields were included: OriginThumbFileID");
        AppMethodBeat.o(115967);
        throw paramVarArgs;
      }
      if (this.HmW == null)
      {
        paramVarArgs = new b("Not all required fields were included: OriginThumbAesKey");
        AppMethodBeat.o(115967);
        throw paramVarArgs;
      }
      if (this.HmX == null)
      {
        paramVarArgs = new b("Not all required fields were included: OriginThumbMD5");
        AppMethodBeat.o(115967);
        throw paramVarArgs;
      }
      if (this.Gjr != null) {
        paramVarArgs.d(1, this.Gjr);
      }
      if (this.AesKey != null) {
        paramVarArgs.d(2, this.AesKey);
      }
      if (this.MD5 != null) {
        paramVarArgs.d(3, this.MD5);
      }
      if (this.HmR != null) {
        paramVarArgs.d(4, this.HmR);
      }
      paramVarArgs.z(5, this.HmS);
      if (this.HbF != null) {
        paramVarArgs.d(6, this.HbF);
      }
      if (this.HbG != null) {
        paramVarArgs.d(7, this.HbG);
      }
      if (this.HmT != null) {
        paramVarArgs.d(8, this.HmT);
      }
      if (this.HlW != null) {
        paramVarArgs.d(9, this.HlW);
      }
      if (this.HmU != null) {
        paramVarArgs.d(10, this.HmU);
      }
      if (this.HmV != null) {
        paramVarArgs.d(11, this.HmV);
      }
      if (this.HmW != null) {
        paramVarArgs.d(12, this.HmW);
      }
      if (this.HmX != null) {
        paramVarArgs.d(13, this.HmX);
      }
      paramVarArgs.z(14, this.HmY);
      AppMethodBeat.o(115967);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Gjr == null) {
        break label1364;
      }
    }
    label1364:
    for (int i = f.a.a.b.b.a.e(1, this.Gjr) + 0;; i = 0)
    {
      paramInt = i;
      if (this.AesKey != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.AesKey);
      }
      i = paramInt;
      if (this.MD5 != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.MD5);
      }
      paramInt = i;
      if (this.HmR != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HmR);
      }
      i = paramInt + f.a.a.b.b.a.alU(5);
      paramInt = i;
      if (this.HbF != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.HbF);
      }
      i = paramInt;
      if (this.HbG != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.HbG);
      }
      paramInt = i;
      if (this.HmT != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.HmT);
      }
      i = paramInt;
      if (this.HlW != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.HlW);
      }
      paramInt = i;
      if (this.HmU != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.HmU);
      }
      i = paramInt;
      if (this.HmV != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.HmV);
      }
      paramInt = i;
      if (this.HmW != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.HmW);
      }
      i = paramInt;
      if (this.HmX != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.HmX);
      }
      paramInt = f.a.a.b.b.a.alU(14);
      AppMethodBeat.o(115967);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gxE();
          }
        }
        if (this.Gjr == null)
        {
          paramVarArgs = new b("Not all required fields were included: FileID");
          AppMethodBeat.o(115967);
          throw paramVarArgs;
        }
        if (this.AesKey == null)
        {
          paramVarArgs = new b("Not all required fields were included: AesKey");
          AppMethodBeat.o(115967);
          throw paramVarArgs;
        }
        if (this.HbF == null)
        {
          paramVarArgs = new b("Not all required fields were included: ThumbFileID");
          AppMethodBeat.o(115967);
          throw paramVarArgs;
        }
        if (this.HbG == null)
        {
          paramVarArgs = new b("Not all required fields were included: ThumbAesKey");
          AppMethodBeat.o(115967);
          throw paramVarArgs;
        }
        if (this.HmT == null)
        {
          paramVarArgs = new b("Not all required fields were included: ThumbMD5");
          AppMethodBeat.o(115967);
          throw paramVarArgs;
        }
        if (this.HmV == null)
        {
          paramVarArgs = new b("Not all required fields were included: OriginThumbFileID");
          AppMethodBeat.o(115967);
          throw paramVarArgs;
        }
        if (this.HmW == null)
        {
          paramVarArgs = new b("Not all required fields were included: OriginThumbAesKey");
          AppMethodBeat.o(115967);
          throw paramVarArgs;
        }
        if (this.HmX == null)
        {
          paramVarArgs = new b("Not all required fields were included: OriginThumbMD5");
          AppMethodBeat.o(115967);
          throw paramVarArgs;
        }
        AppMethodBeat.o(115967);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        cuv localcuv = (cuv)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(115967);
          return -1;
        case 1: 
          localcuv.Gjr = locala.NPN.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 2: 
          localcuv.AesKey = locala.NPN.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 3: 
          localcuv.MD5 = locala.NPN.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 4: 
          localcuv.HmR = locala.NPN.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 5: 
          localcuv.HmS = Float.intBitsToFloat(locala.NPN.grz());
          AppMethodBeat.o(115967);
          return 0;
        case 6: 
          localcuv.HbF = locala.NPN.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 7: 
          localcuv.HbG = locala.NPN.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 8: 
          localcuv.HmT = locala.NPN.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 9: 
          localcuv.HlW = locala.NPN.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 10: 
          localcuv.HmU = locala.NPN.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 11: 
          localcuv.HmV = locala.NPN.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 12: 
          localcuv.HmW = locala.NPN.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 13: 
          localcuv.HmX = locala.NPN.readString();
          AppMethodBeat.o(115967);
          return 0;
        }
        localcuv.HmY = Float.intBitsToFloat(locala.NPN.grz());
        AppMethodBeat.o(115967);
        return 0;
      }
      AppMethodBeat.o(115967);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cuv
 * JD-Core Version:    0.7.0.1
 */