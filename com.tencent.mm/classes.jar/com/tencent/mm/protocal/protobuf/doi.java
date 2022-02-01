package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import g.a.a.b;

public final class doi
  extends com.tencent.mm.bw.a
{
  public String AesKey;
  public String LxW;
  public String MD5;
  public String MEd;
  public String MEe;
  public String MQG;
  public String MRB;
  public float MRC;
  public String MRD;
  public String MRE;
  public String MRF;
  public String MRG;
  public String MRH;
  public float MRI;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115967);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.LxW == null)
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
      if (this.MEd == null)
      {
        paramVarArgs = new b("Not all required fields were included: ThumbFileID");
        AppMethodBeat.o(115967);
        throw paramVarArgs;
      }
      if (this.MEe == null)
      {
        paramVarArgs = new b("Not all required fields were included: ThumbAesKey");
        AppMethodBeat.o(115967);
        throw paramVarArgs;
      }
      if (this.MRD == null)
      {
        paramVarArgs = new b("Not all required fields were included: ThumbMD5");
        AppMethodBeat.o(115967);
        throw paramVarArgs;
      }
      if (this.MRF == null)
      {
        paramVarArgs = new b("Not all required fields were included: OriginThumbFileID");
        AppMethodBeat.o(115967);
        throw paramVarArgs;
      }
      if (this.MRG == null)
      {
        paramVarArgs = new b("Not all required fields were included: OriginThumbAesKey");
        AppMethodBeat.o(115967);
        throw paramVarArgs;
      }
      if (this.MRH == null)
      {
        paramVarArgs = new b("Not all required fields were included: OriginThumbMD5");
        AppMethodBeat.o(115967);
        throw paramVarArgs;
      }
      if (this.LxW != null) {
        paramVarArgs.e(1, this.LxW);
      }
      if (this.AesKey != null) {
        paramVarArgs.e(2, this.AesKey);
      }
      if (this.MD5 != null) {
        paramVarArgs.e(3, this.MD5);
      }
      if (this.MRB != null) {
        paramVarArgs.e(4, this.MRB);
      }
      paramVarArgs.E(5, this.MRC);
      if (this.MEd != null) {
        paramVarArgs.e(6, this.MEd);
      }
      if (this.MEe != null) {
        paramVarArgs.e(7, this.MEe);
      }
      if (this.MRD != null) {
        paramVarArgs.e(8, this.MRD);
      }
      if (this.MQG != null) {
        paramVarArgs.e(9, this.MQG);
      }
      if (this.MRE != null) {
        paramVarArgs.e(10, this.MRE);
      }
      if (this.MRF != null) {
        paramVarArgs.e(11, this.MRF);
      }
      if (this.MRG != null) {
        paramVarArgs.e(12, this.MRG);
      }
      if (this.MRH != null) {
        paramVarArgs.e(13, this.MRH);
      }
      paramVarArgs.E(14, this.MRI);
      AppMethodBeat.o(115967);
      return 0;
    }
    if (paramInt == 1) {
      if (this.LxW == null) {
        break label1368;
      }
    }
    label1368:
    for (int i = g.a.a.b.b.a.f(1, this.LxW) + 0;; i = 0)
    {
      paramInt = i;
      if (this.AesKey != null) {
        paramInt = i + g.a.a.b.b.a.f(2, this.AesKey);
      }
      i = paramInt;
      if (this.MD5 != null) {
        i = paramInt + g.a.a.b.b.a.f(3, this.MD5);
      }
      paramInt = i;
      if (this.MRB != null) {
        paramInt = i + g.a.a.b.b.a.f(4, this.MRB);
      }
      i = paramInt + (g.a.a.b.b.a.fS(5) + 4);
      paramInt = i;
      if (this.MEd != null) {
        paramInt = i + g.a.a.b.b.a.f(6, this.MEd);
      }
      i = paramInt;
      if (this.MEe != null) {
        i = paramInt + g.a.a.b.b.a.f(7, this.MEe);
      }
      paramInt = i;
      if (this.MRD != null) {
        paramInt = i + g.a.a.b.b.a.f(8, this.MRD);
      }
      i = paramInt;
      if (this.MQG != null) {
        i = paramInt + g.a.a.b.b.a.f(9, this.MQG);
      }
      paramInt = i;
      if (this.MRE != null) {
        paramInt = i + g.a.a.b.b.a.f(10, this.MRE);
      }
      i = paramInt;
      if (this.MRF != null) {
        i = paramInt + g.a.a.b.b.a.f(11, this.MRF);
      }
      paramInt = i;
      if (this.MRG != null) {
        paramInt = i + g.a.a.b.b.a.f(12, this.MRG);
      }
      i = paramInt;
      if (this.MRH != null) {
        i = paramInt + g.a.a.b.b.a.f(13, this.MRH);
      }
      paramInt = g.a.a.b.b.a.fS(14);
      AppMethodBeat.o(115967);
      return i + (paramInt + 4);
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.hPl();
          }
        }
        if (this.LxW == null)
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
        if (this.MEd == null)
        {
          paramVarArgs = new b("Not all required fields were included: ThumbFileID");
          AppMethodBeat.o(115967);
          throw paramVarArgs;
        }
        if (this.MEe == null)
        {
          paramVarArgs = new b("Not all required fields were included: ThumbAesKey");
          AppMethodBeat.o(115967);
          throw paramVarArgs;
        }
        if (this.MRD == null)
        {
          paramVarArgs = new b("Not all required fields were included: ThumbMD5");
          AppMethodBeat.o(115967);
          throw paramVarArgs;
        }
        if (this.MRF == null)
        {
          paramVarArgs = new b("Not all required fields were included: OriginThumbFileID");
          AppMethodBeat.o(115967);
          throw paramVarArgs;
        }
        if (this.MRG == null)
        {
          paramVarArgs = new b("Not all required fields were included: OriginThumbAesKey");
          AppMethodBeat.o(115967);
          throw paramVarArgs;
        }
        if (this.MRH == null)
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
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        doi localdoi = (doi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(115967);
          return -1;
        case 1: 
          localdoi.LxW = locala.UbS.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 2: 
          localdoi.AesKey = locala.UbS.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 3: 
          localdoi.MD5 = locala.UbS.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 4: 
          localdoi.MRB = locala.UbS.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 5: 
          localdoi.MRC = Float.intBitsToFloat(locala.UbS.zm());
          AppMethodBeat.o(115967);
          return 0;
        case 6: 
          localdoi.MEd = locala.UbS.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 7: 
          localdoi.MEe = locala.UbS.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 8: 
          localdoi.MRD = locala.UbS.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 9: 
          localdoi.MQG = locala.UbS.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 10: 
          localdoi.MRE = locala.UbS.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 11: 
          localdoi.MRF = locala.UbS.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 12: 
          localdoi.MRG = locala.UbS.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 13: 
          localdoi.MRH = locala.UbS.readString();
          AppMethodBeat.o(115967);
          return 0;
        }
        localdoi.MRI = Float.intBitsToFloat(locala.UbS.zm());
        AppMethodBeat.o(115967);
        return 0;
      }
      AppMethodBeat.o(115967);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.doi
 * JD-Core Version:    0.7.0.1
 */