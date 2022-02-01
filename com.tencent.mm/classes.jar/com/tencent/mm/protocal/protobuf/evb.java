package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class evb
  extends com.tencent.mm.bx.a
{
  public int Height;
  public String IGG;
  public String MpP;
  public String ThumbUrl;
  public int Width;
  public String abxQ;
  public String abxR;
  public int abxS;
  public String hAP;
  public int nUA;
  public String vYo;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(257326);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "Title", this.hAP, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Desc", this.IGG, false);
      com.tencent.mm.bk.a.a(localJSONObject, "ThumbUrl", this.ThumbUrl, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Link", this.MpP, false);
      com.tencent.mm.bk.a.a(localJSONObject, "ItemShowType", Integer.valueOf(this.nUA), false);
      com.tencent.mm.bk.a.a(localJSONObject, "SourceUsername", this.abxQ, false);
      com.tencent.mm.bk.a.a(localJSONObject, "SourceDisplayName", this.abxR, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Vid", this.vYo, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Duraion", Integer.valueOf(this.abxS), false);
      com.tencent.mm.bk.a.a(localJSONObject, "Width", Integer.valueOf(this.Width), false);
      com.tencent.mm.bk.a.a(localJSONObject, "Height", Integer.valueOf(this.Height), false);
      label146:
      AppMethodBeat.o(257326);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label146;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257327);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.hAP != null) {
        paramVarArgs.g(1, this.hAP);
      }
      if (this.IGG != null) {
        paramVarArgs.g(2, this.IGG);
      }
      if (this.ThumbUrl != null) {
        paramVarArgs.g(3, this.ThumbUrl);
      }
      if (this.MpP != null) {
        paramVarArgs.g(4, this.MpP);
      }
      paramVarArgs.bS(5, this.nUA);
      if (this.abxQ != null) {
        paramVarArgs.g(6, this.abxQ);
      }
      if (this.abxR != null) {
        paramVarArgs.g(7, this.abxR);
      }
      if (this.vYo != null) {
        paramVarArgs.g(8, this.vYo);
      }
      paramVarArgs.bS(9, this.abxS);
      paramVarArgs.bS(10, this.Width);
      paramVarArgs.bS(11, this.Height);
      AppMethodBeat.o(257327);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hAP == null) {
        break label762;
      }
    }
    label762:
    for (int i = i.a.a.b.b.a.h(1, this.hAP) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IGG != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.IGG);
      }
      i = paramInt;
      if (this.ThumbUrl != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ThumbUrl);
      }
      paramInt = i;
      if (this.MpP != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.MpP);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.nUA);
      paramInt = i;
      if (this.abxQ != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.abxQ);
      }
      i = paramInt;
      if (this.abxR != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.abxR);
      }
      paramInt = i;
      if (this.vYo != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.vYo);
      }
      i = i.a.a.b.b.a.cJ(9, this.abxS);
      int j = i.a.a.b.b.a.cJ(10, this.Width);
      int k = i.a.a.b.b.a.cJ(11, this.Height);
      AppMethodBeat.o(257327);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257327);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        evb localevb = (evb)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(257327);
          return -1;
        case 1: 
          localevb.hAP = locala.ajGk.readString();
          AppMethodBeat.o(257327);
          return 0;
        case 2: 
          localevb.IGG = locala.ajGk.readString();
          AppMethodBeat.o(257327);
          return 0;
        case 3: 
          localevb.ThumbUrl = locala.ajGk.readString();
          AppMethodBeat.o(257327);
          return 0;
        case 4: 
          localevb.MpP = locala.ajGk.readString();
          AppMethodBeat.o(257327);
          return 0;
        case 5: 
          localevb.nUA = locala.ajGk.aar();
          AppMethodBeat.o(257327);
          return 0;
        case 6: 
          localevb.abxQ = locala.ajGk.readString();
          AppMethodBeat.o(257327);
          return 0;
        case 7: 
          localevb.abxR = locala.ajGk.readString();
          AppMethodBeat.o(257327);
          return 0;
        case 8: 
          localevb.vYo = locala.ajGk.readString();
          AppMethodBeat.o(257327);
          return 0;
        case 9: 
          localevb.abxS = locala.ajGk.aar();
          AppMethodBeat.o(257327);
          return 0;
        case 10: 
          localevb.Width = locala.ajGk.aar();
          AppMethodBeat.o(257327);
          return 0;
        }
        localevb.Height = locala.ajGk.aar();
        AppMethodBeat.o(257327);
        return 0;
      }
      AppMethodBeat.o(257327);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.evb
 * JD-Core Version:    0.7.0.1
 */