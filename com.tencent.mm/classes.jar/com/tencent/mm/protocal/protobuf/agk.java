package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import f.a.a.b;

public final class agk
  extends com.tencent.mm.bw.a
{
  public String ActivityID;
  public String AesKey;
  public String EncryptUrl;
  public String ExternMd5;
  public String ExternUrl;
  public String GwF;
  public String GwG;
  public String GwH;
  public String GwI;
  public String Md5;
  public String ProductID;
  public String ThumbUrl;
  public String Url;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104759);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.Md5 == null)
      {
        paramVarArgs = new b("Not all required fields were included: Md5");
        AppMethodBeat.o(104759);
        throw paramVarArgs;
      }
      if (this.Md5 != null) {
        paramVarArgs.d(1, this.Md5);
      }
      if (this.Url != null) {
        paramVarArgs.d(2, this.Url);
      }
      if (this.ThumbUrl != null) {
        paramVarArgs.d(3, this.ThumbUrl);
      }
      if (this.GwF != null) {
        paramVarArgs.d(4, this.GwF);
      }
      if (this.EncryptUrl != null) {
        paramVarArgs.d(5, this.EncryptUrl);
      }
      if (this.AesKey != null) {
        paramVarArgs.d(6, this.AesKey);
      }
      if (this.ProductID != null) {
        paramVarArgs.d(7, this.ProductID);
      }
      if (this.ExternUrl != null) {
        paramVarArgs.d(8, this.ExternUrl);
      }
      if (this.ExternMd5 != null) {
        paramVarArgs.d(9, this.ExternMd5);
      }
      if (this.ActivityID != null) {
        paramVarArgs.d(10, this.ActivityID);
      }
      if (this.GwG != null) {
        paramVarArgs.d(11, this.GwG);
      }
      if (this.GwH != null) {
        paramVarArgs.d(12, this.GwH);
      }
      if (this.GwI != null) {
        paramVarArgs.d(13, this.GwI);
      }
      AppMethodBeat.o(104759);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Md5 == null) {
        break label998;
      }
    }
    label998:
    for (int i = f.a.a.b.b.a.e(1, this.Md5) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + f.a.a.b.b.a.e(2, this.Url);
      }
      i = paramInt;
      if (this.ThumbUrl != null) {
        i = paramInt + f.a.a.b.b.a.e(3, this.ThumbUrl);
      }
      paramInt = i;
      if (this.GwF != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.GwF);
      }
      i = paramInt;
      if (this.EncryptUrl != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.EncryptUrl);
      }
      paramInt = i;
      if (this.AesKey != null) {
        paramInt = i + f.a.a.b.b.a.e(6, this.AesKey);
      }
      i = paramInt;
      if (this.ProductID != null) {
        i = paramInt + f.a.a.b.b.a.e(7, this.ProductID);
      }
      paramInt = i;
      if (this.ExternUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(8, this.ExternUrl);
      }
      i = paramInt;
      if (this.ExternMd5 != null) {
        i = paramInt + f.a.a.b.b.a.e(9, this.ExternMd5);
      }
      paramInt = i;
      if (this.ActivityID != null) {
        paramInt = i + f.a.a.b.b.a.e(10, this.ActivityID);
      }
      i = paramInt;
      if (this.GwG != null) {
        i = paramInt + f.a.a.b.b.a.e(11, this.GwG);
      }
      paramInt = i;
      if (this.GwH != null) {
        paramInt = i + f.a.a.b.b.a.e(12, this.GwH);
      }
      i = paramInt;
      if (this.GwI != null) {
        i = paramInt + f.a.a.b.b.a.e(13, this.GwI);
      }
      AppMethodBeat.o(104759);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gCg();
          }
        }
        if (this.Md5 == null)
        {
          paramVarArgs = new b("Not all required fields were included: Md5");
          AppMethodBeat.o(104759);
          throw paramVarArgs;
        }
        AppMethodBeat.o(104759);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        agk localagk = (agk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104759);
          return -1;
        case 1: 
          localagk.Md5 = locala.OmT.readString();
          AppMethodBeat.o(104759);
          return 0;
        case 2: 
          localagk.Url = locala.OmT.readString();
          AppMethodBeat.o(104759);
          return 0;
        case 3: 
          localagk.ThumbUrl = locala.OmT.readString();
          AppMethodBeat.o(104759);
          return 0;
        case 4: 
          localagk.GwF = locala.OmT.readString();
          AppMethodBeat.o(104759);
          return 0;
        case 5: 
          localagk.EncryptUrl = locala.OmT.readString();
          AppMethodBeat.o(104759);
          return 0;
        case 6: 
          localagk.AesKey = locala.OmT.readString();
          AppMethodBeat.o(104759);
          return 0;
        case 7: 
          localagk.ProductID = locala.OmT.readString();
          AppMethodBeat.o(104759);
          return 0;
        case 8: 
          localagk.ExternUrl = locala.OmT.readString();
          AppMethodBeat.o(104759);
          return 0;
        case 9: 
          localagk.ExternMd5 = locala.OmT.readString();
          AppMethodBeat.o(104759);
          return 0;
        case 10: 
          localagk.ActivityID = locala.OmT.readString();
          AppMethodBeat.o(104759);
          return 0;
        case 11: 
          localagk.GwG = locala.OmT.readString();
          AppMethodBeat.o(104759);
          return 0;
        case 12: 
          localagk.GwH = locala.OmT.readString();
          AppMethodBeat.o(104759);
          return 0;
        }
        localagk.GwI = locala.OmT.readString();
        AppMethodBeat.o(104759);
        return 0;
      }
      AppMethodBeat.o(104759);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.agk
 * JD-Core Version:    0.7.0.1
 */