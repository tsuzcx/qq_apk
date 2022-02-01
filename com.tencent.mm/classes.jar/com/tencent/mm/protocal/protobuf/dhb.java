package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class dhb
  extends com.tencent.mm.bx.a
{
  public float ZaG;
  public float ZaH;
  public int Zyl;
  public String Zym;
  public String Zyn;
  public int Zyo;
  public String aaMz;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(257682);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "Longitude", Float.valueOf(this.ZaG), false);
      com.tencent.mm.bk.a.a(localJSONObject, "Latitude", Float.valueOf(this.ZaH), false);
      com.tencent.mm.bk.a.a(localJSONObject, "Precision", Integer.valueOf(this.Zyl), false);
      com.tencent.mm.bk.a.a(localJSONObject, "MacAddr", this.Zym, false);
      com.tencent.mm.bk.a.a(localJSONObject, "CellId", this.Zyn, false);
      com.tencent.mm.bk.a.a(localJSONObject, "GPSSource", Integer.valueOf(this.Zyo), false);
      com.tencent.mm.bk.a.a(localJSONObject, "Address", this.aaMz, false);
      label102:
      AppMethodBeat.o(257682);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label102;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117875);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.l(1, this.ZaG);
      paramVarArgs.l(2, this.ZaH);
      paramVarArgs.bS(3, this.Zyl);
      if (this.Zym != null) {
        paramVarArgs.g(4, this.Zym);
      }
      if (this.Zyn != null) {
        paramVarArgs.g(5, this.Zyn);
      }
      paramVarArgs.bS(6, this.Zyo);
      if (this.aaMz != null) {
        paramVarArgs.g(7, this.aaMz);
      }
      AppMethodBeat.o(117875);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.ko(1) + 4 + 0 + (i.a.a.b.b.a.ko(2) + 4) + i.a.a.b.b.a.cJ(3, this.Zyl);
      paramInt = i;
      if (this.Zym != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.Zym);
      }
      i = paramInt;
      if (this.Zyn != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.Zyn);
      }
      i += i.a.a.b.b.a.cJ(6, this.Zyo);
      paramInt = i;
      if (this.aaMz != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.aaMz);
      }
      AppMethodBeat.o(117875);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(117875);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      dhb localdhb = (dhb)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117875);
        return -1;
      case 1: 
        localdhb.ZaG = Float.intBitsToFloat(locala.ajGk.aax());
        AppMethodBeat.o(117875);
        return 0;
      case 2: 
        localdhb.ZaH = Float.intBitsToFloat(locala.ajGk.aax());
        AppMethodBeat.o(117875);
        return 0;
      case 3: 
        localdhb.Zyl = locala.ajGk.aar();
        AppMethodBeat.o(117875);
        return 0;
      case 4: 
        localdhb.Zym = locala.ajGk.readString();
        AppMethodBeat.o(117875);
        return 0;
      case 5: 
        localdhb.Zyn = locala.ajGk.readString();
        AppMethodBeat.o(117875);
        return 0;
      case 6: 
        localdhb.Zyo = locala.ajGk.aar();
        AppMethodBeat.o(117875);
        return 0;
      }
      localdhb.aaMz = locala.ajGk.readString();
      AppMethodBeat.o(117875);
      return 0;
    }
    AppMethodBeat.o(117875);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dhb
 * JD-Core Version:    0.7.0.1
 */