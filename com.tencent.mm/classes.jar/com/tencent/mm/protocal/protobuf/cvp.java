package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class cvp
  extends com.tencent.mm.bw.a
{
  public String AesKey;
  public String GCa;
  public String HFw;
  public String HGr;
  public float HGs;
  public String HGt;
  public String HGu;
  public String HGv;
  public String HGw;
  public String HGx;
  public float HGy;
  public String Hvf;
  public String Hvg;
  public String MD5;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115967);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.GCa == null)
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
      if (this.Hvf == null)
      {
        paramVarArgs = new b("Not all required fields were included: ThumbFileID");
        AppMethodBeat.o(115967);
        throw paramVarArgs;
      }
      if (this.Hvg == null)
      {
        paramVarArgs = new b("Not all required fields were included: ThumbAesKey");
        AppMethodBeat.o(115967);
        throw paramVarArgs;
      }
      if (this.HGt == null)
      {
        paramVarArgs = new b("Not all required fields were included: ThumbMD5");
        AppMethodBeat.o(115967);
        throw paramVarArgs;
      }
      if (this.HGv == null)
      {
        paramVarArgs = new b("Not all required fields were included: OriginThumbFileID");
        AppMethodBeat.o(115967);
        throw paramVarArgs;
      }
      if (this.HGw == null)
      {
        paramVarArgs = new b("Not all required fields were included: OriginThumbAesKey");
        AppMethodBeat.o(115967);
        throw paramVarArgs;
      }
      if (this.HGx == null)
      {
        paramVarArgs = new b("Not all required fields were included: OriginThumbMD5");
        AppMethodBeat.o(115967);
        throw paramVarArgs;
      }
      if (this.GCa != null) {
        paramVarArgs.d(1, this.GCa);
      }
      if (this.AesKey != null) {
        paramVarArgs.d(2, this.AesKey);
      }
      if (this.MD5 != null) {
        paramVarArgs.d(3, this.MD5);
      }
      if (this.HGr != null) {
        paramVarArgs.d(4, this.HGr);
      }
      paramVarArgs.y(5, this.HGs);
      if (this.Hvf != null) {
        paramVarArgs.d(6, this.Hvf);
      }
      if (this.Hvg != null) {
        paramVarArgs.d(7, this.Hvg);
      }
      if (this.HGt != null) {
        paramVarArgs.d(8, this.HGt);
      }
      if (this.HFw != null) {
        paramVarArgs.d(9, this.HFw);
      }
      if (this.HGu != null) {
        paramVarArgs.d(10, this.HGu);
      }
      if (this.HGv != null) {
        paramVarArgs.d(11, this.HGv);
      }
      if (this.HGw != null) {
        paramVarArgs.d(12, this.HGw);
      }
      if (this.HGx != null) {
        paramVarArgs.d(13, this.HGx);
      }
      paramVarArgs.y(14, this.HGy);
      AppMethodBeat.o(115967);
      return 0;
    }
    if (paramInt == 1) {
      if (this.GCa == null) {
        break label1364;
      }
    }
    label1364:
    for (int i = f.a.a.b.b.a.e(1, this.GCa) + 0;; i = 0)
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
      if (this.HGr != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.HGr);
      }
      i = paramInt + f.a.a.b.b.a.amE(5);
      paramInt = i;
      if (this.Hvf != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.Hvf);
      }
      i = paramInt;
      if (this.Hvg != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.Hvg);
      }
      paramInt = i;
      if (this.HGt != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.HGt);
      }
      i = paramInt;
      if (this.HFw != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.HFw);
      }
      paramInt = i;
      if (this.HGu != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.HGu);
      }
      i = paramInt;
      if (this.HGv != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.HGv);
      }
      paramInt = i;
      if (this.HGw != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.HGw);
      }
      i = paramInt;
      if (this.HGx != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.HGx);
      }
      paramInt = f.a.a.b.b.a.amE(14);
      AppMethodBeat.o(115967);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.GCa == null)
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
        if (this.Hvf == null)
        {
          paramVarArgs = new b("Not all required fields were included: ThumbFileID");
          AppMethodBeat.o(115967);
          throw paramVarArgs;
        }
        if (this.Hvg == null)
        {
          paramVarArgs = new b("Not all required fields were included: ThumbAesKey");
          AppMethodBeat.o(115967);
          throw paramVarArgs;
        }
        if (this.HGt == null)
        {
          paramVarArgs = new b("Not all required fields were included: ThumbMD5");
          AppMethodBeat.o(115967);
          throw paramVarArgs;
        }
        if (this.HGv == null)
        {
          paramVarArgs = new b("Not all required fields were included: OriginThumbFileID");
          AppMethodBeat.o(115967);
          throw paramVarArgs;
        }
        if (this.HGw == null)
        {
          paramVarArgs = new b("Not all required fields were included: OriginThumbAesKey");
          AppMethodBeat.o(115967);
          throw paramVarArgs;
        }
        if (this.HGx == null)
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
        cvp localcvp = (cvp)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(115967);
          return -1;
        case 1: 
          localcvp.GCa = locala.OmT.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 2: 
          localcvp.AesKey = locala.OmT.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 3: 
          localcvp.MD5 = locala.OmT.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 4: 
          localcvp.HGr = locala.OmT.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 5: 
          localcvp.HGs = Float.intBitsToFloat(locala.OmT.gwb());
          AppMethodBeat.o(115967);
          return 0;
        case 6: 
          localcvp.Hvf = locala.OmT.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 7: 
          localcvp.Hvg = locala.OmT.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 8: 
          localcvp.HGt = locala.OmT.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 9: 
          localcvp.HFw = locala.OmT.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 10: 
          localcvp.HGu = locala.OmT.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 11: 
          localcvp.HGv = locala.OmT.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 12: 
          localcvp.HGw = locala.OmT.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 13: 
          localcvp.HGx = locala.OmT.readString();
          AppMethodBeat.o(115967);
          return 0;
        }
        localcvp.HGy = Float.intBitsToFloat(locala.OmT.gwb());
        AppMethodBeat.o(115967);
        return 0;
      }
      AppMethodBeat.o(115967);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cvp
 * JD-Core Version:    0.7.0.1
 */