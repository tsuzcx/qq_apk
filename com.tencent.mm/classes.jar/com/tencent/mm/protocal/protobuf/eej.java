package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class eej
  extends com.tencent.mm.bx.a
{
  public float ZaG;
  public float ZaH;
  public String aaGj;
  public String abjt;
  public String abju;
  public long abjv;
  public String pSh;
  public String pSo;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(259929);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "PoiID", this.abjt, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Country", this.pSo, false);
      com.tencent.mm.bk.a.a(localJSONObject, "City", this.pSh, false);
      com.tencent.mm.bk.a.a(localJSONObject, "PoiName", this.aaGj, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Latitude", Float.valueOf(this.ZaH), false);
      com.tencent.mm.bk.a.a(localJSONObject, "Longitude", Float.valueOf(this.ZaG), false);
      com.tencent.mm.bk.a.a(localJSONObject, "PoiQuery", this.abju, false);
      com.tencent.mm.bk.a.a(localJSONObject, "SnsID", Long.valueOf(this.abjv), false);
      label110:
      AppMethodBeat.o(259929);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label110;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117892);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abjt != null) {
        paramVarArgs.g(1, this.abjt);
      }
      if (this.pSo != null) {
        paramVarArgs.g(2, this.pSo);
      }
      if (this.pSh != null) {
        paramVarArgs.g(3, this.pSh);
      }
      if (this.aaGj != null) {
        paramVarArgs.g(4, this.aaGj);
      }
      paramVarArgs.l(5, this.ZaH);
      paramVarArgs.l(6, this.ZaG);
      if (this.abju != null) {
        paramVarArgs.g(7, this.abju);
      }
      paramVarArgs.bv(8, this.abjv);
      AppMethodBeat.o(117892);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abjt == null) {
        break label588;
      }
    }
    label588:
    for (int i = i.a.a.b.b.a.h(1, this.abjt) + 0;; i = 0)
    {
      paramInt = i;
      if (this.pSo != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.pSo);
      }
      i = paramInt;
      if (this.pSh != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.pSh);
      }
      paramInt = i;
      if (this.aaGj != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aaGj);
      }
      i = paramInt + (i.a.a.b.b.a.ko(5) + 4) + (i.a.a.b.b.a.ko(6) + 4);
      paramInt = i;
      if (this.abju != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.abju);
      }
      i = i.a.a.b.b.a.q(8, this.abjv);
      AppMethodBeat.o(117892);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(117892);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        eej localeej = (eej)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117892);
          return -1;
        case 1: 
          localeej.abjt = locala.ajGk.readString();
          AppMethodBeat.o(117892);
          return 0;
        case 2: 
          localeej.pSo = locala.ajGk.readString();
          AppMethodBeat.o(117892);
          return 0;
        case 3: 
          localeej.pSh = locala.ajGk.readString();
          AppMethodBeat.o(117892);
          return 0;
        case 4: 
          localeej.aaGj = locala.ajGk.readString();
          AppMethodBeat.o(117892);
          return 0;
        case 5: 
          localeej.ZaH = Float.intBitsToFloat(locala.ajGk.aax());
          AppMethodBeat.o(117892);
          return 0;
        case 6: 
          localeej.ZaG = Float.intBitsToFloat(locala.ajGk.aax());
          AppMethodBeat.o(117892);
          return 0;
        case 7: 
          localeej.abju = locala.ajGk.readString();
          AppMethodBeat.o(117892);
          return 0;
        }
        localeej.abjv = locala.ajGk.aaw();
        AppMethodBeat.o(117892);
        return 0;
      }
      AppMethodBeat.o(117892);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eej
 * JD-Core Version:    0.7.0.1
 */