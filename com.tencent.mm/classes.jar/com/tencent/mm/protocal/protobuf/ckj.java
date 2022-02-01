package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class ckj
  extends com.tencent.mm.bx.a
{
  public String AesKey;
  public String Diz;
  public String EeH;
  public String EfC;
  public float EfD;
  public String EfE;
  public String EfF;
  public String EfG;
  public String EfH;
  public String EfI;
  public String EfJ;
  public String EfK;
  public float EfL;
  public String MD5;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115967);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Diz == null)
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
      if (this.EfE == null)
      {
        paramVarArgs = new b("Not all required fields were included: ThumbFileID");
        AppMethodBeat.o(115967);
        throw paramVarArgs;
      }
      if (this.EfF == null)
      {
        paramVarArgs = new b("Not all required fields were included: ThumbAesKey");
        AppMethodBeat.o(115967);
        throw paramVarArgs;
      }
      if (this.EfG == null)
      {
        paramVarArgs = new b("Not all required fields were included: ThumbMD5");
        AppMethodBeat.o(115967);
        throw paramVarArgs;
      }
      if (this.EfI == null)
      {
        paramVarArgs = new b("Not all required fields were included: OriginThumbFileID");
        AppMethodBeat.o(115967);
        throw paramVarArgs;
      }
      if (this.EfJ == null)
      {
        paramVarArgs = new b("Not all required fields were included: OriginThumbAesKey");
        AppMethodBeat.o(115967);
        throw paramVarArgs;
      }
      if (this.EfK == null)
      {
        paramVarArgs = new b("Not all required fields were included: OriginThumbMD5");
        AppMethodBeat.o(115967);
        throw paramVarArgs;
      }
      if (this.Diz != null) {
        paramVarArgs.d(1, this.Diz);
      }
      if (this.AesKey != null) {
        paramVarArgs.d(2, this.AesKey);
      }
      if (this.MD5 != null) {
        paramVarArgs.d(3, this.MD5);
      }
      if (this.EfC != null) {
        paramVarArgs.d(4, this.EfC);
      }
      paramVarArgs.x(5, this.EfD);
      if (this.EfE != null) {
        paramVarArgs.d(6, this.EfE);
      }
      if (this.EfF != null) {
        paramVarArgs.d(7, this.EfF);
      }
      if (this.EfG != null) {
        paramVarArgs.d(8, this.EfG);
      }
      if (this.EeH != null) {
        paramVarArgs.d(9, this.EeH);
      }
      if (this.EfH != null) {
        paramVarArgs.d(10, this.EfH);
      }
      if (this.EfI != null) {
        paramVarArgs.d(11, this.EfI);
      }
      if (this.EfJ != null) {
        paramVarArgs.d(12, this.EfJ);
      }
      if (this.EfK != null) {
        paramVarArgs.d(13, this.EfK);
      }
      paramVarArgs.x(14, this.EfL);
      AppMethodBeat.o(115967);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Diz == null) {
        break label1368;
      }
    }
    label1368:
    for (int i = f.a.a.b.b.a.e(1, this.Diz) + 0;; i = 0)
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
      if (this.EfC != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.EfC);
      }
      i = paramInt + (f.a.a.b.b.a.fY(5) + 4);
      paramInt = i;
      if (this.EfE != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.EfE);
      }
      i = paramInt;
      if (this.EfF != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.EfF);
      }
      paramInt = i;
      if (this.EfG != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.EfG);
      }
      i = paramInt;
      if (this.EeH != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.EeH);
      }
      paramInt = i;
      if (this.EfH != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.EfH);
      }
      i = paramInt;
      if (this.EfI != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.EfI);
      }
      paramInt = i;
      if (this.EfJ != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.EfJ);
      }
      i = paramInt;
      if (this.EfK != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.EfK);
      }
      paramInt = f.a.a.b.b.a.fY(14);
      AppMethodBeat.o(115967);
      return i + (paramInt + 4);
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.fMq();
          }
        }
        if (this.Diz == null)
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
        if (this.EfE == null)
        {
          paramVarArgs = new b("Not all required fields were included: ThumbFileID");
          AppMethodBeat.o(115967);
          throw paramVarArgs;
        }
        if (this.EfF == null)
        {
          paramVarArgs = new b("Not all required fields were included: ThumbAesKey");
          AppMethodBeat.o(115967);
          throw paramVarArgs;
        }
        if (this.EfG == null)
        {
          paramVarArgs = new b("Not all required fields were included: ThumbMD5");
          AppMethodBeat.o(115967);
          throw paramVarArgs;
        }
        if (this.EfI == null)
        {
          paramVarArgs = new b("Not all required fields were included: OriginThumbFileID");
          AppMethodBeat.o(115967);
          throw paramVarArgs;
        }
        if (this.EfJ == null)
        {
          paramVarArgs = new b("Not all required fields were included: OriginThumbAesKey");
          AppMethodBeat.o(115967);
          throw paramVarArgs;
        }
        if (this.EfK == null)
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
        ckj localckj = (ckj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(115967);
          return -1;
        case 1: 
          localckj.Diz = locala.KhF.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 2: 
          localckj.AesKey = locala.KhF.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 3: 
          localckj.MD5 = locala.KhF.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 4: 
          localckj.EfC = locala.KhF.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 5: 
          localckj.EfD = Float.intBitsToFloat(locala.KhF.fHx());
          AppMethodBeat.o(115967);
          return 0;
        case 6: 
          localckj.EfE = locala.KhF.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 7: 
          localckj.EfF = locala.KhF.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 8: 
          localckj.EfG = locala.KhF.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 9: 
          localckj.EeH = locala.KhF.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 10: 
          localckj.EfH = locala.KhF.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 11: 
          localckj.EfI = locala.KhF.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 12: 
          localckj.EfJ = locala.KhF.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 13: 
          localckj.EfK = locala.KhF.readString();
          AppMethodBeat.o(115967);
          return 0;
        }
        localckj.EfL = Float.intBitsToFloat(locala.KhF.fHx());
        AppMethodBeat.o(115967);
        return 0;
      }
      AppMethodBeat.o(115967);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ckj
 * JD-Core Version:    0.7.0.1
 */