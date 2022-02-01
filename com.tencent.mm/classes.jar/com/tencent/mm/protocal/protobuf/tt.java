package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;

public final class tt
  extends com.tencent.mm.bx.a
{
  public String activityid;
  public String aeskey;
  public String attachedtext;
  public String attachedtextcolor;
  public String authkey;
  public String cdnurl;
  public String designerid;
  public String emojiattr;
  public String encrypturl;
  public String externmd5;
  public String externurl;
  public String extxml;
  public int height;
  public boolean is_charge;
  public int len;
  public String lensid;
  public String md5;
  public int newxmlflag;
  public String productid;
  public String thumburl;
  public String tpurl;
  public int type;
  public int width;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259727);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.md5 == null)
      {
        paramVarArgs = new b("Not all required fields were included: md5");
        AppMethodBeat.o(259727);
        throw paramVarArgs;
      }
      if (this.md5 != null) {
        paramVarArgs.g(1, this.md5);
      }
      paramVarArgs.bS(2, this.len);
      if (this.productid != null) {
        paramVarArgs.g(3, this.productid);
      }
      paramVarArgs.bS(4, this.type);
      if (this.extxml != null) {
        paramVarArgs.g(5, this.extxml);
      }
      if (this.cdnurl != null) {
        paramVarArgs.g(6, this.cdnurl);
      }
      paramVarArgs.bS(7, this.newxmlflag);
      if (this.designerid != null) {
        paramVarArgs.g(8, this.designerid);
      }
      if (this.thumburl != null) {
        paramVarArgs.g(9, this.thumburl);
      }
      if (this.encrypturl != null) {
        paramVarArgs.g(10, this.encrypturl);
      }
      if (this.aeskey != null) {
        paramVarArgs.g(11, this.aeskey);
      }
      paramVarArgs.bS(12, this.width);
      paramVarArgs.bS(13, this.height);
      if (this.externurl != null) {
        paramVarArgs.g(14, this.externurl);
      }
      if (this.externmd5 != null) {
        paramVarArgs.g(15, this.externmd5);
      }
      if (this.activityid != null) {
        paramVarArgs.g(16, this.activityid);
      }
      if (this.tpurl != null) {
        paramVarArgs.g(17, this.tpurl);
      }
      if (this.authkey != null) {
        paramVarArgs.g(18, this.authkey);
      }
      if (this.attachedtext != null) {
        paramVarArgs.g(19, this.attachedtext);
      }
      if (this.attachedtextcolor != null) {
        paramVarArgs.g(20, this.attachedtextcolor);
      }
      if (this.lensid != null) {
        paramVarArgs.g(21, this.lensid);
      }
      paramVarArgs.di(22, this.is_charge);
      if (this.emojiattr != null) {
        paramVarArgs.g(23, this.emojiattr);
      }
      AppMethodBeat.o(259727);
      return 0;
    }
    if (paramInt == 1) {
      if (this.md5 == null) {
        break label1514;
      }
    }
    label1514:
    for (paramInt = i.a.a.b.b.a.h(1, this.md5) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.len);
      paramInt = i;
      if (this.productid != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.productid);
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.type);
      paramInt = i;
      if (this.extxml != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.extxml);
      }
      i = paramInt;
      if (this.cdnurl != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.cdnurl);
      }
      i += i.a.a.b.b.a.cJ(7, this.newxmlflag);
      paramInt = i;
      if (this.designerid != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.designerid);
      }
      i = paramInt;
      if (this.thumburl != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.thumburl);
      }
      paramInt = i;
      if (this.encrypturl != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.encrypturl);
      }
      i = paramInt;
      if (this.aeskey != null) {
        i = paramInt + i.a.a.b.b.a.h(11, this.aeskey);
      }
      i = i + i.a.a.b.b.a.cJ(12, this.width) + i.a.a.b.b.a.cJ(13, this.height);
      paramInt = i;
      if (this.externurl != null) {
        paramInt = i + i.a.a.b.b.a.h(14, this.externurl);
      }
      i = paramInt;
      if (this.externmd5 != null) {
        i = paramInt + i.a.a.b.b.a.h(15, this.externmd5);
      }
      paramInt = i;
      if (this.activityid != null) {
        paramInt = i + i.a.a.b.b.a.h(16, this.activityid);
      }
      i = paramInt;
      if (this.tpurl != null) {
        i = paramInt + i.a.a.b.b.a.h(17, this.tpurl);
      }
      paramInt = i;
      if (this.authkey != null) {
        paramInt = i + i.a.a.b.b.a.h(18, this.authkey);
      }
      i = paramInt;
      if (this.attachedtext != null) {
        i = paramInt + i.a.a.b.b.a.h(19, this.attachedtext);
      }
      paramInt = i;
      if (this.attachedtextcolor != null) {
        paramInt = i + i.a.a.b.b.a.h(20, this.attachedtextcolor);
      }
      i = paramInt;
      if (this.lensid != null) {
        i = paramInt + i.a.a.b.b.a.h(21, this.lensid);
      }
      i += i.a.a.b.b.a.ko(22) + 1;
      paramInt = i;
      if (this.emojiattr != null) {
        paramInt = i + i.a.a.b.b.a.h(23, this.emojiattr);
      }
      AppMethodBeat.o(259727);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.md5 == null)
        {
          paramVarArgs = new b("Not all required fields were included: md5");
          AppMethodBeat.o(259727);
          throw paramVarArgs;
        }
        AppMethodBeat.o(259727);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        tt localtt = (tt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(259727);
          return -1;
        case 1: 
          localtt.md5 = locala.ajGk.readString();
          AppMethodBeat.o(259727);
          return 0;
        case 2: 
          localtt.len = locala.ajGk.aar();
          AppMethodBeat.o(259727);
          return 0;
        case 3: 
          localtt.productid = locala.ajGk.readString();
          AppMethodBeat.o(259727);
          return 0;
        case 4: 
          localtt.type = locala.ajGk.aar();
          AppMethodBeat.o(259727);
          return 0;
        case 5: 
          localtt.extxml = locala.ajGk.readString();
          AppMethodBeat.o(259727);
          return 0;
        case 6: 
          localtt.cdnurl = locala.ajGk.readString();
          AppMethodBeat.o(259727);
          return 0;
        case 7: 
          localtt.newxmlflag = locala.ajGk.aar();
          AppMethodBeat.o(259727);
          return 0;
        case 8: 
          localtt.designerid = locala.ajGk.readString();
          AppMethodBeat.o(259727);
          return 0;
        case 9: 
          localtt.thumburl = locala.ajGk.readString();
          AppMethodBeat.o(259727);
          return 0;
        case 10: 
          localtt.encrypturl = locala.ajGk.readString();
          AppMethodBeat.o(259727);
          return 0;
        case 11: 
          localtt.aeskey = locala.ajGk.readString();
          AppMethodBeat.o(259727);
          return 0;
        case 12: 
          localtt.width = locala.ajGk.aar();
          AppMethodBeat.o(259727);
          return 0;
        case 13: 
          localtt.height = locala.ajGk.aar();
          AppMethodBeat.o(259727);
          return 0;
        case 14: 
          localtt.externurl = locala.ajGk.readString();
          AppMethodBeat.o(259727);
          return 0;
        case 15: 
          localtt.externmd5 = locala.ajGk.readString();
          AppMethodBeat.o(259727);
          return 0;
        case 16: 
          localtt.activityid = locala.ajGk.readString();
          AppMethodBeat.o(259727);
          return 0;
        case 17: 
          localtt.tpurl = locala.ajGk.readString();
          AppMethodBeat.o(259727);
          return 0;
        case 18: 
          localtt.authkey = locala.ajGk.readString();
          AppMethodBeat.o(259727);
          return 0;
        case 19: 
          localtt.attachedtext = locala.ajGk.readString();
          AppMethodBeat.o(259727);
          return 0;
        case 20: 
          localtt.attachedtextcolor = locala.ajGk.readString();
          AppMethodBeat.o(259727);
          return 0;
        case 21: 
          localtt.lensid = locala.ajGk.readString();
          AppMethodBeat.o(259727);
          return 0;
        case 22: 
          localtt.is_charge = locala.ajGk.aai();
          AppMethodBeat.o(259727);
          return 0;
        }
        localtt.emojiattr = locala.ajGk.readString();
        AppMethodBeat.o(259727);
        return 0;
      }
      AppMethodBeat.o(259727);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.tt
 * JD-Core Version:    0.7.0.1
 */