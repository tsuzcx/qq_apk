package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public class drz
  extends com.tencent.mm.bx.a
{
  public int HKy;
  public int Rfk;
  public String aaXO;
  public String aaXP;
  public int aaXQ;
  public boolean aaXR;
  public String lPJ;
  public String nickname;
  public String tag;
  public String title;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(259993);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "nickname", this.nickname, false);
      com.tencent.mm.bk.a.a(localJSONObject, "title", this.title, false);
      com.tencent.mm.bk.a.a(localJSONObject, "tipIconUrl", this.aaXO, false);
      com.tencent.mm.bk.a.a(localJSONObject, "videoDurationSec", Integer.valueOf(this.Rfk), false);
      com.tencent.mm.bk.a.a(localJSONObject, "fileExt", this.lPJ, false);
      com.tencent.mm.bk.a.a(localJSONObject, "bizIcon", this.aaXP, false);
      com.tencent.mm.bk.a.a(localJSONObject, "tipIconType", Integer.valueOf(this.aaXQ), false);
      com.tencent.mm.bk.a.a(localJSONObject, "defaultBg", Boolean.valueOf(this.aaXR), false);
      com.tencent.mm.bk.a.a(localJSONObject, "tag", this.tag, false);
      com.tencent.mm.bk.a.a(localJSONObject, "degree", Integer.valueOf(this.HKy), false);
      label135:
      AppMethodBeat.o(259993);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label135;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259999);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.nickname != null) {
        paramVarArgs.g(1, this.nickname);
      }
      if (this.title != null) {
        paramVarArgs.g(2, this.title);
      }
      if (this.aaXO != null) {
        paramVarArgs.g(3, this.aaXO);
      }
      paramVarArgs.bS(4, this.Rfk);
      if (this.lPJ != null) {
        paramVarArgs.g(5, this.lPJ);
      }
      if (this.aaXP != null) {
        paramVarArgs.g(6, this.aaXP);
      }
      paramVarArgs.bS(7, this.aaXQ);
      paramVarArgs.di(8, this.aaXR);
      if (this.tag != null) {
        paramVarArgs.g(9, this.tag);
      }
      paramVarArgs.bS(10, this.HKy);
      AppMethodBeat.o(259999);
      return 0;
    }
    if (paramInt == 1) {
      if (this.nickname == null) {
        break label694;
      }
    }
    label694:
    for (int i = i.a.a.b.b.a.h(1, this.nickname) + 0;; i = 0)
    {
      paramInt = i;
      if (this.title != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.title);
      }
      i = paramInt;
      if (this.aaXO != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.aaXO);
      }
      i += i.a.a.b.b.a.cJ(4, this.Rfk);
      paramInt = i;
      if (this.lPJ != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.lPJ);
      }
      i = paramInt;
      if (this.aaXP != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.aaXP);
      }
      i = i + i.a.a.b.b.a.cJ(7, this.aaXQ) + (i.a.a.b.b.a.ko(8) + 1);
      paramInt = i;
      if (this.tag != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.tag);
      }
      i = i.a.a.b.b.a.cJ(10, this.HKy);
      AppMethodBeat.o(259999);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259999);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        drz localdrz = (drz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(259999);
          return -1;
        case 1: 
          localdrz.nickname = locala.ajGk.readString();
          AppMethodBeat.o(259999);
          return 0;
        case 2: 
          localdrz.title = locala.ajGk.readString();
          AppMethodBeat.o(259999);
          return 0;
        case 3: 
          localdrz.aaXO = locala.ajGk.readString();
          AppMethodBeat.o(259999);
          return 0;
        case 4: 
          localdrz.Rfk = locala.ajGk.aar();
          AppMethodBeat.o(259999);
          return 0;
        case 5: 
          localdrz.lPJ = locala.ajGk.readString();
          AppMethodBeat.o(259999);
          return 0;
        case 6: 
          localdrz.aaXP = locala.ajGk.readString();
          AppMethodBeat.o(259999);
          return 0;
        case 7: 
          localdrz.aaXQ = locala.ajGk.aar();
          AppMethodBeat.o(259999);
          return 0;
        case 8: 
          localdrz.aaXR = locala.ajGk.aai();
          AppMethodBeat.o(259999);
          return 0;
        case 9: 
          localdrz.tag = locala.ajGk.readString();
          AppMethodBeat.o(259999);
          return 0;
        }
        localdrz.HKy = locala.ajGk.aar();
        AppMethodBeat.o(259999);
        return 0;
      }
      AppMethodBeat.o(259999);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.drz
 * JD-Core Version:    0.7.0.1
 */