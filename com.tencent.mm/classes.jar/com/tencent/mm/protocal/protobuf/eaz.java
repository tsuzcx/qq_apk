package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class eaz
  extends com.tencent.mm.bx.a
{
  public String IGG;
  public String IHo;
  public String abgw;
  public String abgx;
  public int crr;
  public String hAP;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(258318);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "DocId", this.abgw, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Title", this.hAP, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Desc", this.IGG, false);
      com.tencent.mm.bk.a.a(localJSONObject, "IconUrl", this.IHo, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Source", this.abgx, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Duration", Integer.valueOf(this.crr), false);
      label82:
      AppMethodBeat.o(258318);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label82;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117888);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abgw != null) {
        paramVarArgs.g(1, this.abgw);
      }
      if (this.hAP != null) {
        paramVarArgs.g(2, this.hAP);
      }
      if (this.IGG != null) {
        paramVarArgs.g(3, this.IGG);
      }
      if (this.IHo != null) {
        paramVarArgs.g(4, this.IHo);
      }
      if (this.abgx != null) {
        paramVarArgs.g(5, this.abgx);
      }
      paramVarArgs.bS(6, this.crr);
      AppMethodBeat.o(117888);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abgw == null) {
        break label498;
      }
    }
    label498:
    for (int i = i.a.a.b.b.a.h(1, this.abgw) + 0;; i = 0)
    {
      paramInt = i;
      if (this.hAP != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.hAP);
      }
      i = paramInt;
      if (this.IGG != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.IGG);
      }
      paramInt = i;
      if (this.IHo != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.IHo);
      }
      i = paramInt;
      if (this.abgx != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.abgx);
      }
      paramInt = i.a.a.b.b.a.cJ(6, this.crr);
      AppMethodBeat.o(117888);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(117888);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        eaz localeaz = (eaz)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117888);
          return -1;
        case 1: 
          localeaz.abgw = locala.ajGk.readString();
          AppMethodBeat.o(117888);
          return 0;
        case 2: 
          localeaz.hAP = locala.ajGk.readString();
          AppMethodBeat.o(117888);
          return 0;
        case 3: 
          localeaz.IGG = locala.ajGk.readString();
          AppMethodBeat.o(117888);
          return 0;
        case 4: 
          localeaz.IHo = locala.ajGk.readString();
          AppMethodBeat.o(117888);
          return 0;
        case 5: 
          localeaz.abgx = locala.ajGk.readString();
          AppMethodBeat.o(117888);
          return 0;
        }
        localeaz.crr = locala.ajGk.aar();
        AppMethodBeat.o(117888);
        return 0;
      }
      AppMethodBeat.o(117888);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.eaz
 * JD-Core Version:    0.7.0.1
 */