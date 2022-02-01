package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class cpq
  extends com.tencent.mm.bw.a
{
  public String AesKey;
  public String EBF;
  public String FBH;
  public String FCC;
  public float FCD;
  public String FCE;
  public String FCF;
  public String FCG;
  public String FCH;
  public String FCI;
  public String FCJ;
  public String FCK;
  public float FCL;
  public String MD5;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115967);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.EBF == null)
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
      if (this.FCE == null)
      {
        paramVarArgs = new b("Not all required fields were included: ThumbFileID");
        AppMethodBeat.o(115967);
        throw paramVarArgs;
      }
      if (this.FCF == null)
      {
        paramVarArgs = new b("Not all required fields were included: ThumbAesKey");
        AppMethodBeat.o(115967);
        throw paramVarArgs;
      }
      if (this.FCG == null)
      {
        paramVarArgs = new b("Not all required fields were included: ThumbMD5");
        AppMethodBeat.o(115967);
        throw paramVarArgs;
      }
      if (this.FCI == null)
      {
        paramVarArgs = new b("Not all required fields were included: OriginThumbFileID");
        AppMethodBeat.o(115967);
        throw paramVarArgs;
      }
      if (this.FCJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: OriginThumbAesKey");
        AppMethodBeat.o(115967);
        throw paramVarArgs;
      }
      if (this.FCK == null)
      {
        paramVarArgs = new b("Not all required fields were included: OriginThumbMD5");
        AppMethodBeat.o(115967);
        throw paramVarArgs;
      }
      if (this.EBF != null) {
        paramVarArgs.d(1, this.EBF);
      }
      if (this.AesKey != null) {
        paramVarArgs.d(2, this.AesKey);
      }
      if (this.MD5 != null) {
        paramVarArgs.d(3, this.MD5);
      }
      if (this.FCC != null) {
        paramVarArgs.d(4, this.FCC);
      }
      paramVarArgs.x(5, this.FCD);
      if (this.FCE != null) {
        paramVarArgs.d(6, this.FCE);
      }
      if (this.FCF != null) {
        paramVarArgs.d(7, this.FCF);
      }
      if (this.FCG != null) {
        paramVarArgs.d(8, this.FCG);
      }
      if (this.FBH != null) {
        paramVarArgs.d(9, this.FBH);
      }
      if (this.FCH != null) {
        paramVarArgs.d(10, this.FCH);
      }
      if (this.FCI != null) {
        paramVarArgs.d(11, this.FCI);
      }
      if (this.FCJ != null) {
        paramVarArgs.d(12, this.FCJ);
      }
      if (this.FCK != null) {
        paramVarArgs.d(13, this.FCK);
      }
      paramVarArgs.x(14, this.FCL);
      AppMethodBeat.o(115967);
      return 0;
    }
    if (paramInt == 1) {
      if (this.EBF == null) {
        break label1368;
      }
    }
    label1368:
    for (int i = f.a.a.b.b.a.e(1, this.EBF) + 0;; i = 0)
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
      if (this.FCC != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.FCC);
      }
      i = paramInt + (f.a.a.b.b.a.fK(5) + 4);
      paramInt = i;
      if (this.FCE != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.FCE);
      }
      i = paramInt;
      if (this.FCF != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.FCF);
      }
      paramInt = i;
      if (this.FCG != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.FCG);
      }
      i = paramInt;
      if (this.FBH != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.FBH);
      }
      paramInt = i;
      if (this.FCH != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.FCH);
      }
      i = paramInt;
      if (this.FCI != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.FCI);
      }
      paramInt = i;
      if (this.FCJ != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.FCJ);
      }
      i = paramInt;
      if (this.FCK != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.FCK);
      }
      paramInt = f.a.a.b.b.a.fK(14);
      AppMethodBeat.o(115967);
      return i + (paramInt + 4);
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        if (this.EBF == null)
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
        if (this.FCE == null)
        {
          paramVarArgs = new b("Not all required fields were included: ThumbFileID");
          AppMethodBeat.o(115967);
          throw paramVarArgs;
        }
        if (this.FCF == null)
        {
          paramVarArgs = new b("Not all required fields were included: ThumbAesKey");
          AppMethodBeat.o(115967);
          throw paramVarArgs;
        }
        if (this.FCG == null)
        {
          paramVarArgs = new b("Not all required fields were included: ThumbMD5");
          AppMethodBeat.o(115967);
          throw paramVarArgs;
        }
        if (this.FCI == null)
        {
          paramVarArgs = new b("Not all required fields were included: OriginThumbFileID");
          AppMethodBeat.o(115967);
          throw paramVarArgs;
        }
        if (this.FCJ == null)
        {
          paramVarArgs = new b("Not all required fields were included: OriginThumbAesKey");
          AppMethodBeat.o(115967);
          throw paramVarArgs;
        }
        if (this.FCK == null)
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
        cpq localcpq = (cpq)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(115967);
          return -1;
        case 1: 
          localcpq.EBF = locala.LVo.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 2: 
          localcpq.AesKey = locala.LVo.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 3: 
          localcpq.MD5 = locala.LVo.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 4: 
          localcpq.FCC = locala.LVo.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 5: 
          localcpq.FCD = Float.intBitsToFloat(locala.LVo.gaa());
          AppMethodBeat.o(115967);
          return 0;
        case 6: 
          localcpq.FCE = locala.LVo.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 7: 
          localcpq.FCF = locala.LVo.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 8: 
          localcpq.FCG = locala.LVo.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 9: 
          localcpq.FBH = locala.LVo.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 10: 
          localcpq.FCH = locala.LVo.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 11: 
          localcpq.FCI = locala.LVo.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 12: 
          localcpq.FCJ = locala.LVo.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 13: 
          localcpq.FCK = locala.LVo.readString();
          AppMethodBeat.o(115967);
          return 0;
        }
        localcpq.FCL = Float.intBitsToFloat(locala.LVo.gaa());
        AppMethodBeat.o(115967);
        return 0;
      }
      AppMethodBeat.o(115967);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cpq
 * JD-Core Version:    0.7.0.1
 */