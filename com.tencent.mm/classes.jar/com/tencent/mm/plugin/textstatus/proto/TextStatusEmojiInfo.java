package com.tencent.mm.plugin.textstatus.proto;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class TextStatusEmojiInfo
  extends com.tencent.mm.cd.a
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
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(243681);
    if (paramInt == 0)
    {
      paramVarArgs = (g.a.a.c.a)paramVarArgs[0];
      if (this.Md5 != null) {
        paramVarArgs.f(1, this.Md5);
      }
      if (this.Url != null) {
        paramVarArgs.f(2, this.Url);
      }
      if (this.ThumbUrl != null) {
        paramVarArgs.f(3, this.ThumbUrl);
      }
      if (this.DesignerID != null) {
        paramVarArgs.f(4, this.DesignerID);
      }
      if (this.EncryptUrl != null) {
        paramVarArgs.f(5, this.EncryptUrl);
      }
      if (this.AesKey != null) {
        paramVarArgs.f(6, this.AesKey);
      }
      if (this.ProductID != null) {
        paramVarArgs.f(7, this.ProductID);
      }
      if (this.ExternUrl != null) {
        paramVarArgs.f(8, this.ExternUrl);
      }
      if (this.ExternMd5 != null) {
        paramVarArgs.f(9, this.ExternMd5);
      }
      if (this.ActivityID != null) {
        paramVarArgs.f(10, this.ActivityID);
      }
      if (this.AttachedText != null) {
        paramVarArgs.f(11, this.AttachedText);
      }
      if (this.AttachedTextColor != null) {
        paramVarArgs.f(12, this.AttachedTextColor);
      }
      if (this.LensId != null) {
        paramVarArgs.f(13, this.LensId);
      }
      if (this.EmojiAttr != null) {
        paramVarArgs.f(14, this.EmojiAttr);
      }
      AppMethodBeat.o(243681);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Md5 == null) {
        break label1014;
      }
    }
    label1014:
    for (int i = g.a.a.b.b.a.g(1, this.Md5) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + g.a.a.b.b.a.g(2, this.Url);
      }
      i = paramInt;
      if (this.ThumbUrl != null) {
        i = paramInt + g.a.a.b.b.a.g(3, this.ThumbUrl);
      }
      paramInt = i;
      if (this.DesignerID != null) {
        paramInt = i + g.a.a.b.b.a.g(4, this.DesignerID);
      }
      i = paramInt;
      if (this.EncryptUrl != null) {
        i = paramInt + g.a.a.b.b.a.g(5, this.EncryptUrl);
      }
      paramInt = i;
      if (this.AesKey != null) {
        paramInt = i + g.a.a.b.b.a.g(6, this.AesKey);
      }
      i = paramInt;
      if (this.ProductID != null) {
        i = paramInt + g.a.a.b.b.a.g(7, this.ProductID);
      }
      paramInt = i;
      if (this.ExternUrl != null) {
        paramInt = i + g.a.a.b.b.a.g(8, this.ExternUrl);
      }
      i = paramInt;
      if (this.ExternMd5 != null) {
        i = paramInt + g.a.a.b.b.a.g(9, this.ExternMd5);
      }
      paramInt = i;
      if (this.ActivityID != null) {
        paramInt = i + g.a.a.b.b.a.g(10, this.ActivityID);
      }
      i = paramInt;
      if (this.AttachedText != null) {
        i = paramInt + g.a.a.b.b.a.g(11, this.AttachedText);
      }
      paramInt = i;
      if (this.AttachedTextColor != null) {
        paramInt = i + g.a.a.b.b.a.g(12, this.AttachedTextColor);
      }
      i = paramInt;
      if (this.LensId != null) {
        i = paramInt + g.a.a.b.b.a.g(13, this.LensId);
      }
      paramInt = i;
      if (this.EmojiAttr != null) {
        paramInt = i + g.a.a.b.b.a.g(14, this.EmojiAttr);
      }
      AppMethodBeat.o(243681);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new g.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.cd.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.iUs();
          }
        }
        AppMethodBeat.o(243681);
        return 0;
      }
      if (paramInt == 3)
      {
        g.a.a.a.a locala = (g.a.a.a.a)paramVarArgs[0];
        TextStatusEmojiInfo localTextStatusEmojiInfo = (TextStatusEmojiInfo)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(243681);
          return -1;
        case 1: 
          localTextStatusEmojiInfo.Md5 = locala.abFh.readString();
          AppMethodBeat.o(243681);
          return 0;
        case 2: 
          localTextStatusEmojiInfo.Url = locala.abFh.readString();
          AppMethodBeat.o(243681);
          return 0;
        case 3: 
          localTextStatusEmojiInfo.ThumbUrl = locala.abFh.readString();
          AppMethodBeat.o(243681);
          return 0;
        case 4: 
          localTextStatusEmojiInfo.DesignerID = locala.abFh.readString();
          AppMethodBeat.o(243681);
          return 0;
        case 5: 
          localTextStatusEmojiInfo.EncryptUrl = locala.abFh.readString();
          AppMethodBeat.o(243681);
          return 0;
        case 6: 
          localTextStatusEmojiInfo.AesKey = locala.abFh.readString();
          AppMethodBeat.o(243681);
          return 0;
        case 7: 
          localTextStatusEmojiInfo.ProductID = locala.abFh.readString();
          AppMethodBeat.o(243681);
          return 0;
        case 8: 
          localTextStatusEmojiInfo.ExternUrl = locala.abFh.readString();
          AppMethodBeat.o(243681);
          return 0;
        case 9: 
          localTextStatusEmojiInfo.ExternMd5 = locala.abFh.readString();
          AppMethodBeat.o(243681);
          return 0;
        case 10: 
          localTextStatusEmojiInfo.ActivityID = locala.abFh.readString();
          AppMethodBeat.o(243681);
          return 0;
        case 11: 
          localTextStatusEmojiInfo.AttachedText = locala.abFh.readString();
          AppMethodBeat.o(243681);
          return 0;
        case 12: 
          localTextStatusEmojiInfo.AttachedTextColor = locala.abFh.readString();
          AppMethodBeat.o(243681);
          return 0;
        case 13: 
          localTextStatusEmojiInfo.LensId = locala.abFh.readString();
          AppMethodBeat.o(243681);
          return 0;
        }
        localTextStatusEmojiInfo.EmojiAttr = locala.abFh.readString();
        AppMethodBeat.o(243681);
        return 0;
      }
      AppMethodBeat.o(243681);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.textstatus.proto.TextStatusEmojiInfo
 * JD-Core Version:    0.7.0.1
 */