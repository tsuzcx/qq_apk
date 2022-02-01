package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import org.json.JSONObject;

public final class eva
  extends com.tencent.mm.bx.a
{
  public String IHW;
  public String Username;
  public String YPo;
  public int aaMm;
  public String abxL;
  public String abxM;
  public b abxN;
  public b abxO;
  public b abxP;
  public int pSf;
  public String pSg;
  public String pSh;
  public String pSi;
  public String pSo;
  public int pSt;
  public String vhX;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(257460);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "Username", this.Username, false);
      com.tencent.mm.bk.a.a(localJSONObject, "NickName", this.vhX, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Fullpy", this.abxL, false);
      com.tencent.mm.bk.a.a(localJSONObject, "AliasName", this.abxM, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Country", this.pSo, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Province", this.pSg, false);
      com.tencent.mm.bk.a.a(localJSONObject, "City", this.pSh, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Signature", this.pSi, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Sex", Integer.valueOf(this.pSf), false);
      com.tencent.mm.bk.a.a(localJSONObject, "VerifyFlag", Integer.valueOf(this.aaMm), false);
      com.tencent.mm.bk.a.a(localJSONObject, "CertInfo", this.abxN, false);
      com.tencent.mm.bk.a.a(localJSONObject, "BrandIconUrl", this.YPo, false);
      com.tencent.mm.bk.a.a(localJSONObject, "ExternalInfo", this.abxO, false);
      com.tencent.mm.bk.a.a(localJSONObject, "BrandInfo", this.abxP, false);
      com.tencent.mm.bk.a.a(localJSONObject, "BrandFlag", Integer.valueOf(this.pSt), false);
      com.tencent.mm.bk.a.a(localJSONObject, "HeadImgUrl", this.IHW, false);
      label198:
      AppMethodBeat.o(257460);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label198;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257466);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Username != null) {
        paramVarArgs.g(1, this.Username);
      }
      if (this.vhX != null) {
        paramVarArgs.g(2, this.vhX);
      }
      if (this.abxL != null) {
        paramVarArgs.g(3, this.abxL);
      }
      if (this.abxM != null) {
        paramVarArgs.g(4, this.abxM);
      }
      if (this.pSo != null) {
        paramVarArgs.g(5, this.pSo);
      }
      if (this.pSg != null) {
        paramVarArgs.g(6, this.pSg);
      }
      if (this.pSh != null) {
        paramVarArgs.g(7, this.pSh);
      }
      if (this.pSi != null) {
        paramVarArgs.g(8, this.pSi);
      }
      paramVarArgs.bS(9, this.pSf);
      paramVarArgs.bS(10, this.aaMm);
      if (this.abxN != null) {
        paramVarArgs.d(11, this.abxN);
      }
      if (this.YPo != null) {
        paramVarArgs.g(12, this.YPo);
      }
      if (this.abxO != null) {
        paramVarArgs.d(13, this.abxO);
      }
      if (this.abxP != null) {
        paramVarArgs.d(14, this.abxP);
      }
      paramVarArgs.bS(15, this.pSt);
      if (this.IHW != null) {
        paramVarArgs.g(16, this.IHW);
      }
      AppMethodBeat.o(257466);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Username == null) {
        break label1082;
      }
    }
    label1082:
    for (int i = i.a.a.b.b.a.h(1, this.Username) + 0;; i = 0)
    {
      paramInt = i;
      if (this.vhX != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.vhX);
      }
      i = paramInt;
      if (this.abxL != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.abxL);
      }
      paramInt = i;
      if (this.abxM != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.abxM);
      }
      i = paramInt;
      if (this.pSo != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.pSo);
      }
      paramInt = i;
      if (this.pSg != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.pSg);
      }
      i = paramInt;
      if (this.pSh != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.pSh);
      }
      paramInt = i;
      if (this.pSi != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.pSi);
      }
      i = paramInt + i.a.a.b.b.a.cJ(9, this.pSf) + i.a.a.b.b.a.cJ(10, this.aaMm);
      paramInt = i;
      if (this.abxN != null) {
        paramInt = i + i.a.a.b.b.a.c(11, this.abxN);
      }
      i = paramInt;
      if (this.YPo != null) {
        i = paramInt + i.a.a.b.b.a.h(12, this.YPo);
      }
      paramInt = i;
      if (this.abxO != null) {
        paramInt = i + i.a.a.b.b.a.c(13, this.abxO);
      }
      i = paramInt;
      if (this.abxP != null) {
        i = paramInt + i.a.a.b.b.a.c(14, this.abxP);
      }
      i += i.a.a.b.b.a.cJ(15, this.pSt);
      paramInt = i;
      if (this.IHW != null) {
        paramInt = i + i.a.a.b.b.a.h(16, this.IHW);
      }
      AppMethodBeat.o(257466);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257466);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        eva localeva = (eva)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(257466);
          return -1;
        case 1: 
          localeva.Username = locala.ajGk.readString();
          AppMethodBeat.o(257466);
          return 0;
        case 2: 
          localeva.vhX = locala.ajGk.readString();
          AppMethodBeat.o(257466);
          return 0;
        case 3: 
          localeva.abxL = locala.ajGk.readString();
          AppMethodBeat.o(257466);
          return 0;
        case 4: 
          localeva.abxM = locala.ajGk.readString();
          AppMethodBeat.o(257466);
          return 0;
        case 5: 
          localeva.pSo = locala.ajGk.readString();
          AppMethodBeat.o(257466);
          return 0;
        case 6: 
          localeva.pSg = locala.ajGk.readString();
          AppMethodBeat.o(257466);
          return 0;
        case 7: 
          localeva.pSh = locala.ajGk.readString();
          AppMethodBeat.o(257466);
          return 0;
        case 8: 
          localeva.pSi = locala.ajGk.readString();
          AppMethodBeat.o(257466);
          return 0;
        case 9: 
          localeva.pSf = locala.ajGk.aar();
          AppMethodBeat.o(257466);
          return 0;
        case 10: 
          localeva.aaMm = locala.ajGk.aar();
          AppMethodBeat.o(257466);
          return 0;
        case 11: 
          localeva.abxN = locala.ajGk.kFX();
          AppMethodBeat.o(257466);
          return 0;
        case 12: 
          localeva.YPo = locala.ajGk.readString();
          AppMethodBeat.o(257466);
          return 0;
        case 13: 
          localeva.abxO = locala.ajGk.kFX();
          AppMethodBeat.o(257466);
          return 0;
        case 14: 
          localeva.abxP = locala.ajGk.kFX();
          AppMethodBeat.o(257466);
          return 0;
        case 15: 
          localeva.pSt = locala.ajGk.aar();
          AppMethodBeat.o(257466);
          return 0;
        }
        localeva.IHW = locala.ajGk.readString();
        AppMethodBeat.o(257466);
        return 0;
      }
      AppMethodBeat.o(257466);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eva
 * JD-Core Version:    0.7.0.1
 */