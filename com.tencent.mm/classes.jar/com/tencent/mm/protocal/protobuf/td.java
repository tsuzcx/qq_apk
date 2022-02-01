package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import org.json.JSONObject;

public final class td
  extends com.tencent.mm.bx.a
{
  public String MFB;
  public String YYC;
  public String YYD;
  public String YYE;
  public int YYF;
  public String YYG;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(259540);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "ProductId", this.YYC, false);
      com.tencent.mm.bk.a.a(localJSONObject, "ProductName", this.MFB, false);
      com.tencent.mm.bk.a.a(localJSONObject, "SellerName", this.YYD, false);
      com.tencent.mm.bk.a.a(localJSONObject, "SellerUserName", this.YYE, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Price", Integer.valueOf(this.YYF), false);
      com.tencent.mm.bk.a.a(localJSONObject, "ProductImgUrl", this.YYG, false);
      label82:
      AppMethodBeat.o(259540);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label82;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117847);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YYC == null)
      {
        paramVarArgs = new b("Not all required fields were included: ProductId");
        AppMethodBeat.o(117847);
        throw paramVarArgs;
      }
      if (this.MFB == null)
      {
        paramVarArgs = new b("Not all required fields were included: ProductName");
        AppMethodBeat.o(117847);
        throw paramVarArgs;
      }
      if (this.YYD == null)
      {
        paramVarArgs = new b("Not all required fields were included: SellerName");
        AppMethodBeat.o(117847);
        throw paramVarArgs;
      }
      if (this.YYE == null)
      {
        paramVarArgs = new b("Not all required fields were included: SellerUserName");
        AppMethodBeat.o(117847);
        throw paramVarArgs;
      }
      if (this.YYC != null) {
        paramVarArgs.g(1, this.YYC);
      }
      if (this.MFB != null) {
        paramVarArgs.g(2, this.MFB);
      }
      if (this.YYD != null) {
        paramVarArgs.g(3, this.YYD);
      }
      if (this.YYE != null) {
        paramVarArgs.g(4, this.YYE);
      }
      paramVarArgs.bS(5, this.YYF);
      if (this.YYG != null) {
        paramVarArgs.g(6, this.YYG);
      }
      AppMethodBeat.o(117847);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YYC == null) {
        break label690;
      }
    }
    label690:
    for (int i = i.a.a.b.b.a.h(1, this.YYC) + 0;; i = 0)
    {
      paramInt = i;
      if (this.MFB != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.MFB);
      }
      i = paramInt;
      if (this.YYD != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.YYD);
      }
      paramInt = i;
      if (this.YYE != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.YYE);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.YYF);
      paramInt = i;
      if (this.YYG != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.YYG);
      }
      AppMethodBeat.o(117847);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.YYC == null)
        {
          paramVarArgs = new b("Not all required fields were included: ProductId");
          AppMethodBeat.o(117847);
          throw paramVarArgs;
        }
        if (this.MFB == null)
        {
          paramVarArgs = new b("Not all required fields were included: ProductName");
          AppMethodBeat.o(117847);
          throw paramVarArgs;
        }
        if (this.YYD == null)
        {
          paramVarArgs = new b("Not all required fields were included: SellerName");
          AppMethodBeat.o(117847);
          throw paramVarArgs;
        }
        if (this.YYE == null)
        {
          paramVarArgs = new b("Not all required fields were included: SellerUserName");
          AppMethodBeat.o(117847);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117847);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        td localtd = (td)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117847);
          return -1;
        case 1: 
          localtd.YYC = locala.ajGk.readString();
          AppMethodBeat.o(117847);
          return 0;
        case 2: 
          localtd.MFB = locala.ajGk.readString();
          AppMethodBeat.o(117847);
          return 0;
        case 3: 
          localtd.YYD = locala.ajGk.readString();
          AppMethodBeat.o(117847);
          return 0;
        case 4: 
          localtd.YYE = locala.ajGk.readString();
          AppMethodBeat.o(117847);
          return 0;
        case 5: 
          localtd.YYF = locala.ajGk.aar();
          AppMethodBeat.o(117847);
          return 0;
        }
        localtd.YYG = locala.ajGk.readString();
        AppMethodBeat.o(117847);
        return 0;
      }
      AppMethodBeat.o(117847);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.td
 * JD-Core Version:    0.7.0.1
 */