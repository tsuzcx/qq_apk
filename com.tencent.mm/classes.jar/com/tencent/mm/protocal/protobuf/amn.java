package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class amn
  extends com.tencent.mm.bx.a
{
  public String ActivityID;
  public String AesKey;
  public String AttachedText;
  public String AttachedTextColor;
  public String DesignerID;
  public String EmojiAttr;
  public String EncryptUrl;
  public String ExternMd5;
  public String ExternUrl;
  public String LensId;
  public String Md5;
  public String ProductID;
  public String ThumbUrl;
  public String Url;
  public String Ztx;
  public String Zty;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104759);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Md5 == null)
      {
        paramVarArgs = new b("Not all required fields were included: Md5");
        AppMethodBeat.o(104759);
        throw paramVarArgs;
      }
      if (this.Md5 != null) {
        paramVarArgs.g(1, this.Md5);
      }
      if (this.Url != null) {
        paramVarArgs.g(2, this.Url);
      }
      if (this.ThumbUrl != null) {
        paramVarArgs.g(3, this.ThumbUrl);
      }
      if (this.DesignerID != null) {
        paramVarArgs.g(4, this.DesignerID);
      }
      if (this.EncryptUrl != null) {
        paramVarArgs.g(5, this.EncryptUrl);
      }
      if (this.AesKey != null) {
        paramVarArgs.g(6, this.AesKey);
      }
      if (this.ProductID != null) {
        paramVarArgs.g(7, this.ProductID);
      }
      if (this.ExternUrl != null) {
        paramVarArgs.g(8, this.ExternUrl);
      }
      if (this.ExternMd5 != null) {
        paramVarArgs.g(9, this.ExternMd5);
      }
      if (this.ActivityID != null) {
        paramVarArgs.g(10, this.ActivityID);
      }
      if (this.AttachedText != null) {
        paramVarArgs.g(11, this.AttachedText);
      }
      if (this.AttachedTextColor != null) {
        paramVarArgs.g(12, this.AttachedTextColor);
      }
      if (this.LensId != null) {
        paramVarArgs.g(13, this.LensId);
      }
      if (this.EmojiAttr != null) {
        paramVarArgs.g(14, this.EmojiAttr);
      }
      if (this.Ztx != null) {
        paramVarArgs.g(15, this.Ztx);
      }
      if (this.Zty != null) {
        paramVarArgs.g(16, this.Zty);
      }
      AppMethodBeat.o(104759);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Md5 == null) {
        break label1182;
      }
    }
    label1182:
    for (int i = i.a.a.b.b.a.h(1, this.Md5) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.Url);
      }
      i = paramInt;
      if (this.ThumbUrl != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ThumbUrl);
      }
      paramInt = i;
      if (this.DesignerID != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.DesignerID);
      }
      i = paramInt;
      if (this.EncryptUrl != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.EncryptUrl);
      }
      paramInt = i;
      if (this.AesKey != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.AesKey);
      }
      i = paramInt;
      if (this.ProductID != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.ProductID);
      }
      paramInt = i;
      if (this.ExternUrl != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.ExternUrl);
      }
      i = paramInt;
      if (this.ExternMd5 != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.ExternMd5);
      }
      paramInt = i;
      if (this.ActivityID != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.ActivityID);
      }
      i = paramInt;
      if (this.AttachedText != null) {
        i = paramInt + i.a.a.b.b.a.h(11, this.AttachedText);
      }
      paramInt = i;
      if (this.AttachedTextColor != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.AttachedTextColor);
      }
      i = paramInt;
      if (this.LensId != null) {
        i = paramInt + i.a.a.b.b.a.h(13, this.LensId);
      }
      paramInt = i;
      if (this.EmojiAttr != null) {
        paramInt = i + i.a.a.b.b.a.h(14, this.EmojiAttr);
      }
      i = paramInt;
      if (this.Ztx != null) {
        i = paramInt + i.a.a.b.b.a.h(15, this.Ztx);
      }
      paramInt = i;
      if (this.Zty != null) {
        paramInt = i + i.a.a.b.b.a.h(16, this.Zty);
      }
      AppMethodBeat.o(104759);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
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
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        amn localamn = (amn)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104759);
          return -1;
        case 1: 
          localamn.Md5 = locala.ajGk.readString();
          AppMethodBeat.o(104759);
          return 0;
        case 2: 
          localamn.Url = locala.ajGk.readString();
          AppMethodBeat.o(104759);
          return 0;
        case 3: 
          localamn.ThumbUrl = locala.ajGk.readString();
          AppMethodBeat.o(104759);
          return 0;
        case 4: 
          localamn.DesignerID = locala.ajGk.readString();
          AppMethodBeat.o(104759);
          return 0;
        case 5: 
          localamn.EncryptUrl = locala.ajGk.readString();
          AppMethodBeat.o(104759);
          return 0;
        case 6: 
          localamn.AesKey = locala.ajGk.readString();
          AppMethodBeat.o(104759);
          return 0;
        case 7: 
          localamn.ProductID = locala.ajGk.readString();
          AppMethodBeat.o(104759);
          return 0;
        case 8: 
          localamn.ExternUrl = locala.ajGk.readString();
          AppMethodBeat.o(104759);
          return 0;
        case 9: 
          localamn.ExternMd5 = locala.ajGk.readString();
          AppMethodBeat.o(104759);
          return 0;
        case 10: 
          localamn.ActivityID = locala.ajGk.readString();
          AppMethodBeat.o(104759);
          return 0;
        case 11: 
          localamn.AttachedText = locala.ajGk.readString();
          AppMethodBeat.o(104759);
          return 0;
        case 12: 
          localamn.AttachedTextColor = locala.ajGk.readString();
          AppMethodBeat.o(104759);
          return 0;
        case 13: 
          localamn.LensId = locala.ajGk.readString();
          AppMethodBeat.o(104759);
          return 0;
        case 14: 
          localamn.EmojiAttr = locala.ajGk.readString();
          AppMethodBeat.o(104759);
          return 0;
        case 15: 
          localamn.Ztx = locala.ajGk.readString();
          AppMethodBeat.o(104759);
          return 0;
        }
        localamn.Zty = locala.ajGk.readString();
        AppMethodBeat.o(104759);
        return 0;
      }
      AppMethodBeat.o(104759);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.amn
 * JD-Core Version:    0.7.0.1
 */