package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public class gib
  extends com.tencent.mm.bx.a
{
  public String ICb;
  public String WoZ;
  public String Wpa;
  public String Wpb;
  public String Wpc;
  public long Wpd;
  public String Wpe;
  public String Wpf;
  public String Wpg;
  public String Wph;
  public String Wpi;
  public String Wpj;
  public String Wpk;
  public long Wpl;
  public String Wpm;
  public String ibx;
  public String source;
  public String svG;
  public String thumbUrl;
  public String ytZ;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(258637);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "relevant_vid", this.WoZ, false);
      com.tencent.mm.bk.a.a(localJSONObject, "relevant_expand", this.Wpa, false);
      com.tencent.mm.bk.a.a(localJSONObject, "relevant_pre_searchid", this.Wpb, false);
      com.tencent.mm.bk.a.a(localJSONObject, "relevant_shared_openid", this.Wpc, false);
      com.tencent.mm.bk.a.a(localJSONObject, "rec_category", Long.valueOf(this.Wpd), false);
      com.tencent.mm.bk.a.a(localJSONObject, "strPlayCount", this.Wph, false);
      com.tencent.mm.bk.a.a(localJSONObject, "shareUrl", this.ytZ, false);
      com.tencent.mm.bk.a.a(localJSONObject, "shareTitle", this.svG, false);
      com.tencent.mm.bk.a.a(localJSONObject, "shareDesc", this.ICb, false);
      com.tencent.mm.bk.a.a(localJSONObject, "shareImgUrl", this.Wpe, false);
      com.tencent.mm.bk.a.a(localJSONObject, "shareString", this.Wpf, false);
      com.tencent.mm.bk.a.a(localJSONObject, "shareStringUrl", this.Wpg, false);
      com.tencent.mm.bk.a.a(localJSONObject, "source", this.source, false);
      com.tencent.mm.bk.a.a(localJSONObject, "sourceUrl", this.ibx, false);
      com.tencent.mm.bk.a.a(localJSONObject, "titleUrl", this.Wpi, false);
      com.tencent.mm.bk.a.a(localJSONObject, "extReqParams", this.Wpj, false);
      com.tencent.mm.bk.a.a(localJSONObject, "tagList", this.Wpk, false);
      com.tencent.mm.bk.a.a(localJSONObject, "channelId", Long.valueOf(this.Wpl), false);
      com.tencent.mm.bk.a.a(localJSONObject, "thumbUrl", this.thumbUrl, false);
      com.tencent.mm.bk.a.a(localJSONObject, "shareTag", this.Wpm, false);
      label239:
      AppMethodBeat.o(258637);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label239;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153016);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.WoZ != null) {
        paramVarArgs.g(1, this.WoZ);
      }
      if (this.Wpa != null) {
        paramVarArgs.g(2, this.Wpa);
      }
      if (this.Wpb != null) {
        paramVarArgs.g(3, this.Wpb);
      }
      if (this.Wpc != null) {
        paramVarArgs.g(4, this.Wpc);
      }
      paramVarArgs.bv(5, this.Wpd);
      if (this.Wph != null) {
        paramVarArgs.g(6, this.Wph);
      }
      if (this.ytZ != null) {
        paramVarArgs.g(7, this.ytZ);
      }
      if (this.svG != null) {
        paramVarArgs.g(8, this.svG);
      }
      if (this.ICb != null) {
        paramVarArgs.g(9, this.ICb);
      }
      if (this.Wpe != null) {
        paramVarArgs.g(10, this.Wpe);
      }
      if (this.Wpf != null) {
        paramVarArgs.g(11, this.Wpf);
      }
      if (this.Wpg != null) {
        paramVarArgs.g(12, this.Wpg);
      }
      if (this.source != null) {
        paramVarArgs.g(13, this.source);
      }
      if (this.ibx != null) {
        paramVarArgs.g(14, this.ibx);
      }
      if (this.Wpi != null) {
        paramVarArgs.g(15, this.Wpi);
      }
      if (this.Wpj != null) {
        paramVarArgs.g(16, this.Wpj);
      }
      if (this.Wpk != null) {
        paramVarArgs.g(17, this.Wpk);
      }
      paramVarArgs.bv(18, this.Wpl);
      if (this.thumbUrl != null) {
        paramVarArgs.g(19, this.thumbUrl);
      }
      if (this.Wpm != null) {
        paramVarArgs.g(20, this.Wpm);
      }
      AppMethodBeat.o(153016);
      return 0;
    }
    if (paramInt == 1) {
      if (this.WoZ == null) {
        break label1350;
      }
    }
    label1350:
    for (int i = i.a.a.b.b.a.h(1, this.WoZ) + 0;; i = 0)
    {
      paramInt = i;
      if (this.Wpa != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.Wpa);
      }
      i = paramInt;
      if (this.Wpb != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.Wpb);
      }
      paramInt = i;
      if (this.Wpc != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.Wpc);
      }
      i = paramInt + i.a.a.b.b.a.q(5, this.Wpd);
      paramInt = i;
      if (this.Wph != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.Wph);
      }
      i = paramInt;
      if (this.ytZ != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.ytZ);
      }
      paramInt = i;
      if (this.svG != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.svG);
      }
      i = paramInt;
      if (this.ICb != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.ICb);
      }
      paramInt = i;
      if (this.Wpe != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.Wpe);
      }
      i = paramInt;
      if (this.Wpf != null) {
        i = paramInt + i.a.a.b.b.a.h(11, this.Wpf);
      }
      paramInt = i;
      if (this.Wpg != null) {
        paramInt = i + i.a.a.b.b.a.h(12, this.Wpg);
      }
      i = paramInt;
      if (this.source != null) {
        i = paramInt + i.a.a.b.b.a.h(13, this.source);
      }
      paramInt = i;
      if (this.ibx != null) {
        paramInt = i + i.a.a.b.b.a.h(14, this.ibx);
      }
      i = paramInt;
      if (this.Wpi != null) {
        i = paramInt + i.a.a.b.b.a.h(15, this.Wpi);
      }
      paramInt = i;
      if (this.Wpj != null) {
        paramInt = i + i.a.a.b.b.a.h(16, this.Wpj);
      }
      i = paramInt;
      if (this.Wpk != null) {
        i = paramInt + i.a.a.b.b.a.h(17, this.Wpk);
      }
      i += i.a.a.b.b.a.q(18, this.Wpl);
      paramInt = i;
      if (this.thumbUrl != null) {
        paramInt = i + i.a.a.b.b.a.h(19, this.thumbUrl);
      }
      i = paramInt;
      if (this.Wpm != null) {
        i = paramInt + i.a.a.b.b.a.h(20, this.Wpm);
      }
      AppMethodBeat.o(153016);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(153016);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        gib localgib = (gib)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153016);
          return -1;
        case 1: 
          localgib.WoZ = locala.ajGk.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 2: 
          localgib.Wpa = locala.ajGk.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 3: 
          localgib.Wpb = locala.ajGk.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 4: 
          localgib.Wpc = locala.ajGk.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 5: 
          localgib.Wpd = locala.ajGk.aaw();
          AppMethodBeat.o(153016);
          return 0;
        case 6: 
          localgib.Wph = locala.ajGk.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 7: 
          localgib.ytZ = locala.ajGk.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 8: 
          localgib.svG = locala.ajGk.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 9: 
          localgib.ICb = locala.ajGk.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 10: 
          localgib.Wpe = locala.ajGk.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 11: 
          localgib.Wpf = locala.ajGk.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 12: 
          localgib.Wpg = locala.ajGk.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 13: 
          localgib.source = locala.ajGk.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 14: 
          localgib.ibx = locala.ajGk.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 15: 
          localgib.Wpi = locala.ajGk.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 16: 
          localgib.Wpj = locala.ajGk.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 17: 
          localgib.Wpk = locala.ajGk.readString();
          AppMethodBeat.o(153016);
          return 0;
        case 18: 
          localgib.Wpl = locala.ajGk.aaw();
          AppMethodBeat.o(153016);
          return 0;
        case 19: 
          localgib.thumbUrl = locala.ajGk.readString();
          AppMethodBeat.o(153016);
          return 0;
        }
        localgib.Wpm = locala.ajGk.readString();
        AppMethodBeat.o(153016);
        return 0;
      }
      AppMethodBeat.o(153016);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gib
 * JD-Core Version:    0.7.0.1
 */