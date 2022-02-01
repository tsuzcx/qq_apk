package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class erg
  extends com.tencent.mm.bx.a
{
  public String AesKey;
  public String MD5;
  public String ZBp;
  public String abgi;
  public String abgj;
  public String abuW;
  public float abuX;
  public String abuY;
  public String abuZ;
  public String abuh;
  public String abva;
  public String abvb;
  public String abvc;
  public float abvd;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(115967);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZBp == null)
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
      if (this.abgi == null)
      {
        paramVarArgs = new b("Not all required fields were included: ThumbFileID");
        AppMethodBeat.o(115967);
        throw paramVarArgs;
      }
      if (this.abgj == null)
      {
        paramVarArgs = new b("Not all required fields were included: ThumbAesKey");
        AppMethodBeat.o(115967);
        throw paramVarArgs;
      }
      if (this.abuY == null)
      {
        paramVarArgs = new b("Not all required fields were included: ThumbMD5");
        AppMethodBeat.o(115967);
        throw paramVarArgs;
      }
      if (this.abva == null)
      {
        paramVarArgs = new b("Not all required fields were included: OriginThumbFileID");
        AppMethodBeat.o(115967);
        throw paramVarArgs;
      }
      if (this.abvb == null)
      {
        paramVarArgs = new b("Not all required fields were included: OriginThumbAesKey");
        AppMethodBeat.o(115967);
        throw paramVarArgs;
      }
      if (this.abvc == null)
      {
        paramVarArgs = new b("Not all required fields were included: OriginThumbMD5");
        AppMethodBeat.o(115967);
        throw paramVarArgs;
      }
      if (this.ZBp != null) {
        paramVarArgs.g(1, this.ZBp);
      }
      if (this.AesKey != null) {
        paramVarArgs.g(2, this.AesKey);
      }
      if (this.MD5 != null) {
        paramVarArgs.g(3, this.MD5);
      }
      if (this.abuW != null) {
        paramVarArgs.g(4, this.abuW);
      }
      paramVarArgs.l(5, this.abuX);
      if (this.abgi != null) {
        paramVarArgs.g(6, this.abgi);
      }
      if (this.abgj != null) {
        paramVarArgs.g(7, this.abgj);
      }
      if (this.abuY != null) {
        paramVarArgs.g(8, this.abuY);
      }
      if (this.abuh != null) {
        paramVarArgs.g(9, this.abuh);
      }
      if (this.abuZ != null) {
        paramVarArgs.g(10, this.abuZ);
      }
      if (this.abva != null) {
        paramVarArgs.g(11, this.abva);
      }
      if (this.abvb != null) {
        paramVarArgs.g(12, this.abvb);
      }
      if (this.abvc != null) {
        paramVarArgs.g(13, this.abvc);
      }
      paramVarArgs.l(14, this.abvd);
      AppMethodBeat.o(115967);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZBp == null) {
        break label1364;
      }
    }
    label1364:
    for (int i = i.a.a.b.b.a.h(1, this.ZBp) + 0;; i = 0)
    {
      paramInt = i;
      if (this.AesKey != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.AesKey);
      }
      i = paramInt;
      if (this.MD5 != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.MD5);
      }
      paramInt = i;
      if (this.abuW != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.abuW);
      }
      i = paramInt + (i.a.a.b.b.a.ko(5) + 4);
      paramInt = i;
      if (this.abgi != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.abgi);
      }
      i = paramInt;
      if (this.abgj != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.abgj);
      }
      paramInt = i;
      if (this.abuY != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.abuY);
      }
      i = paramInt;
      if (this.abuh != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.abuh);
      }
      paramInt = i;
      if (this.abuZ != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.abuZ);
      }
      i = paramInt;
      if (this.abva != null) {
        i = paramInt + i.a.a.b.b.a.h(11, this.abva);
      }
      paramInt = i;
      if (this.abvb != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.abvb);
      }
      i = paramInt;
      if (this.abvc != null) {
        i = paramInt + i.a.a.b.b.a.h(13, this.abvc);
      }
      paramInt = i.a.a.b.b.a.ko(14);
      AppMethodBeat.o(115967);
      return i + (paramInt + 4);
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.ZBp == null)
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
        if (this.abgi == null)
        {
          paramVarArgs = new b("Not all required fields were included: ThumbFileID");
          AppMethodBeat.o(115967);
          throw paramVarArgs;
        }
        if (this.abgj == null)
        {
          paramVarArgs = new b("Not all required fields were included: ThumbAesKey");
          AppMethodBeat.o(115967);
          throw paramVarArgs;
        }
        if (this.abuY == null)
        {
          paramVarArgs = new b("Not all required fields were included: ThumbMD5");
          AppMethodBeat.o(115967);
          throw paramVarArgs;
        }
        if (this.abva == null)
        {
          paramVarArgs = new b("Not all required fields were included: OriginThumbFileID");
          AppMethodBeat.o(115967);
          throw paramVarArgs;
        }
        if (this.abvb == null)
        {
          paramVarArgs = new b("Not all required fields were included: OriginThumbAesKey");
          AppMethodBeat.o(115967);
          throw paramVarArgs;
        }
        if (this.abvc == null)
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
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        erg localerg = (erg)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(115967);
          return -1;
        case 1: 
          localerg.ZBp = locala.ajGk.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 2: 
          localerg.AesKey = locala.ajGk.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 3: 
          localerg.MD5 = locala.ajGk.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 4: 
          localerg.abuW = locala.ajGk.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 5: 
          localerg.abuX = Float.intBitsToFloat(locala.ajGk.aax());
          AppMethodBeat.o(115967);
          return 0;
        case 6: 
          localerg.abgi = locala.ajGk.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 7: 
          localerg.abgj = locala.ajGk.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 8: 
          localerg.abuY = locala.ajGk.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 9: 
          localerg.abuh = locala.ajGk.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 10: 
          localerg.abuZ = locala.ajGk.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 11: 
          localerg.abva = locala.ajGk.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 12: 
          localerg.abvb = locala.ajGk.readString();
          AppMethodBeat.o(115967);
          return 0;
        case 13: 
          localerg.abvc = locala.ajGk.readString();
          AppMethodBeat.o(115967);
          return 0;
        }
        localerg.abvd = Float.intBitsToFloat(locala.ajGk.aax());
        AppMethodBeat.o(115967);
        return 0;
      }
      AppMethodBeat.o(115967);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.erg
 * JD-Core Version:    0.7.0.1
 */