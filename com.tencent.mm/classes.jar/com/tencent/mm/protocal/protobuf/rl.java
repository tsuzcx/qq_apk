package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class rl
  extends com.tencent.mm.bw.a
{
  public int AJS;
  public int AJT;
  public int GfK;
  public int GfX;
  public String GfY;
  public String GfZ;
  public String Gga;
  public String Ggb;
  public String aeskey;
  public int length;
  public String md5;
  public int type;
  public String url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(220224);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.aeskey == null)
      {
        paramVarArgs = new b("Not all required fields were included: aeskey");
        AppMethodBeat.o(220224);
        throw paramVarArgs;
      }
      if (this.url == null)
      {
        paramVarArgs = new b("Not all required fields were included: url");
        AppMethodBeat.o(220224);
        throw paramVarArgs;
      }
      if (this.aeskey != null) {
        paramVarArgs.d(1, this.aeskey);
      }
      if (this.url != null) {
        paramVarArgs.d(2, this.url);
      }
      paramVarArgs.aS(3, this.type);
      paramVarArgs.aS(4, this.length);
      paramVarArgs.aS(5, this.GfX);
      if (this.GfY != null) {
        paramVarArgs.d(6, this.GfY);
      }
      if (this.GfZ != null) {
        paramVarArgs.d(7, this.GfZ);
      }
      paramVarArgs.aS(8, this.GfK);
      paramVarArgs.aS(9, this.AJS);
      paramVarArgs.aS(10, this.AJT);
      if (this.md5 != null) {
        paramVarArgs.d(11, this.md5);
      }
      if (this.Gga != null) {
        paramVarArgs.d(12, this.Gga);
      }
      if (this.Ggb != null) {
        paramVarArgs.d(13, this.Ggb);
      }
      AppMethodBeat.o(220224);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aeskey == null) {
        break label942;
      }
    }
    label942:
    for (paramInt = f.a.a.b.b.a.e(1, this.aeskey) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.url != null) {
        i = paramInt + f.a.a.b.b.a.e(2, this.url);
      }
      i = i + f.a.a.b.b.a.bz(3, this.type) + f.a.a.b.b.a.bz(4, this.length) + f.a.a.b.b.a.bz(5, this.GfX);
      paramInt = i;
      if (this.GfY != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.GfY);
      }
      i = paramInt;
      if (this.GfZ != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.GfZ);
      }
      i = i + f.a.a.b.b.a.bz(8, this.GfK) + f.a.a.b.b.a.bz(9, this.AJS) + f.a.a.b.b.a.bz(10, this.AJT);
      paramInt = i;
      if (this.md5 != null) {
        paramInt = i + f.a.a.b.b.a.e(11, this.md5);
      }
      i = paramInt;
      if (this.Gga != null) {
        i = paramInt + f.a.a.b.b.a.e(12, this.Gga);
      }
      paramInt = i;
      if (this.Ggb != null) {
        paramInt = i + f.a.a.b.b.a.e(13, this.Ggb);
      }
      AppMethodBeat.o(220224);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.aeskey == null)
        {
          paramVarArgs = new b("Not all required fields were included: aeskey");
          AppMethodBeat.o(220224);
          throw paramVarArgs;
        }
        if (this.url == null)
        {
          paramVarArgs = new b("Not all required fields were included: url");
          AppMethodBeat.o(220224);
          throw paramVarArgs;
        }
        AppMethodBeat.o(220224);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        rl localrl = (rl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(220224);
          return -1;
        case 1: 
          localrl.aeskey = locala.OmT.readString();
          AppMethodBeat.o(220224);
          return 0;
        case 2: 
          localrl.url = locala.OmT.readString();
          AppMethodBeat.o(220224);
          return 0;
        case 3: 
          localrl.type = locala.OmT.zc();
          AppMethodBeat.o(220224);
          return 0;
        case 4: 
          localrl.length = locala.OmT.zc();
          AppMethodBeat.o(220224);
          return 0;
        case 5: 
          localrl.GfX = locala.OmT.zc();
          AppMethodBeat.o(220224);
          return 0;
        case 6: 
          localrl.GfY = locala.OmT.readString();
          AppMethodBeat.o(220224);
          return 0;
        case 7: 
          localrl.GfZ = locala.OmT.readString();
          AppMethodBeat.o(220224);
          return 0;
        case 8: 
          localrl.GfK = locala.OmT.zc();
          AppMethodBeat.o(220224);
          return 0;
        case 9: 
          localrl.AJS = locala.OmT.zc();
          AppMethodBeat.o(220224);
          return 0;
        case 10: 
          localrl.AJT = locala.OmT.zc();
          AppMethodBeat.o(220224);
          return 0;
        case 11: 
          localrl.md5 = locala.OmT.readString();
          AppMethodBeat.o(220224);
          return 0;
        case 12: 
          localrl.Gga = locala.OmT.readString();
          AppMethodBeat.o(220224);
          return 0;
        }
        localrl.Ggb = locala.OmT.readString();
        AppMethodBeat.o(220224);
        return 0;
      }
      AppMethodBeat.o(220224);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.rl
 * JD-Core Version:    0.7.0.1
 */