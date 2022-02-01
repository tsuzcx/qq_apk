package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class evj
  extends com.tencent.mm.bx.a
{
  public String AesKey;
  public String AttachedText;
  public String AttachedTextColor;
  public String EncryptUrl;
  public String LensId;
  public String aaro;
  public String abye;
  public int abyf;
  public String abyg;
  public String abyh;
  public String abyi;
  public int abyj;
  public int abyk;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(260182);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "EmoticonMD5", this.abye, false);
      com.tencent.mm.bk.a.a(localJSONObject, "EmoticonType", Integer.valueOf(this.abyf), false);
      com.tencent.mm.bk.a.a(localJSONObject, "EmoticonProductId", this.abyg, false);
      com.tencent.mm.bk.a.a(localJSONObject, "ThumbImgUrl", this.abyh, false);
      com.tencent.mm.bk.a.a(localJSONObject, "DesignerId", this.abyi, false);
      com.tencent.mm.bk.a.a(localJSONObject, "ActivityId", this.aaro, false);
      com.tencent.mm.bk.a.a(localJSONObject, "AttachedText", this.AttachedText, false);
      com.tencent.mm.bk.a.a(localJSONObject, "AttachedTextColor", this.AttachedTextColor, false);
      com.tencent.mm.bk.a.a(localJSONObject, "LensId", this.LensId, false);
      com.tencent.mm.bk.a.a(localJSONObject, "EmoticonWidth", Integer.valueOf(this.abyj), false);
      com.tencent.mm.bk.a.a(localJSONObject, "EmoticonHeight", Integer.valueOf(this.abyk), false);
      com.tencent.mm.bk.a.a(localJSONObject, "EncryptUrl", this.EncryptUrl, false);
      com.tencent.mm.bk.a.a(localJSONObject, "AesKey", this.AesKey, false);
      label165:
      AppMethodBeat.o(260182);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label165;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260189);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abye != null) {
        paramVarArgs.g(1, this.abye);
      }
      paramVarArgs.bS(2, this.abyf);
      if (this.abyg != null) {
        paramVarArgs.g(3, this.abyg);
      }
      if (this.abyh != null) {
        paramVarArgs.g(4, this.abyh);
      }
      if (this.abyi != null) {
        paramVarArgs.g(5, this.abyi);
      }
      if (this.aaro != null) {
        paramVarArgs.g(6, this.aaro);
      }
      if (this.AttachedText != null) {
        paramVarArgs.g(7, this.AttachedText);
      }
      if (this.AttachedTextColor != null) {
        paramVarArgs.g(8, this.AttachedTextColor);
      }
      if (this.LensId != null) {
        paramVarArgs.g(9, this.LensId);
      }
      paramVarArgs.bS(10, this.abyj);
      paramVarArgs.bS(11, this.abyk);
      if (this.EncryptUrl != null) {
        paramVarArgs.g(12, this.EncryptUrl);
      }
      if (this.AesKey != null) {
        paramVarArgs.g(13, this.AesKey);
      }
      AppMethodBeat.o(260189);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abye == null) {
        break label898;
      }
    }
    label898:
    for (paramInt = i.a.a.b.b.a.h(1, this.abye) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.abyf);
      paramInt = i;
      if (this.abyg != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.abyg);
      }
      i = paramInt;
      if (this.abyh != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.abyh);
      }
      paramInt = i;
      if (this.abyi != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.abyi);
      }
      i = paramInt;
      if (this.aaro != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.aaro);
      }
      paramInt = i;
      if (this.AttachedText != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.AttachedText);
      }
      i = paramInt;
      if (this.AttachedTextColor != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.AttachedTextColor);
      }
      paramInt = i;
      if (this.LensId != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.LensId);
      }
      i = paramInt + i.a.a.b.b.a.cJ(10, this.abyj) + i.a.a.b.b.a.cJ(11, this.abyk);
      paramInt = i;
      if (this.EncryptUrl != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.EncryptUrl);
      }
      i = paramInt;
      if (this.AesKey != null) {
        i = paramInt + i.a.a.b.b.a.h(13, this.AesKey);
      }
      AppMethodBeat.o(260189);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(260189);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        evj localevj = (evj)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(260189);
          return -1;
        case 1: 
          localevj.abye = locala.ajGk.readString();
          AppMethodBeat.o(260189);
          return 0;
        case 2: 
          localevj.abyf = locala.ajGk.aar();
          AppMethodBeat.o(260189);
          return 0;
        case 3: 
          localevj.abyg = locala.ajGk.readString();
          AppMethodBeat.o(260189);
          return 0;
        case 4: 
          localevj.abyh = locala.ajGk.readString();
          AppMethodBeat.o(260189);
          return 0;
        case 5: 
          localevj.abyi = locala.ajGk.readString();
          AppMethodBeat.o(260189);
          return 0;
        case 6: 
          localevj.aaro = locala.ajGk.readString();
          AppMethodBeat.o(260189);
          return 0;
        case 7: 
          localevj.AttachedText = locala.ajGk.readString();
          AppMethodBeat.o(260189);
          return 0;
        case 8: 
          localevj.AttachedTextColor = locala.ajGk.readString();
          AppMethodBeat.o(260189);
          return 0;
        case 9: 
          localevj.LensId = locala.ajGk.readString();
          AppMethodBeat.o(260189);
          return 0;
        case 10: 
          localevj.abyj = locala.ajGk.aar();
          AppMethodBeat.o(260189);
          return 0;
        case 11: 
          localevj.abyk = locala.ajGk.aar();
          AppMethodBeat.o(260189);
          return 0;
        case 12: 
          localevj.EncryptUrl = locala.ajGk.readString();
          AppMethodBeat.o(260189);
          return 0;
        }
        localevj.AesKey = locala.ajGk.readString();
        AppMethodBeat.o(260189);
        return 0;
      }
      AppMethodBeat.o(260189);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.evj
 * JD-Core Version:    0.7.0.1
 */