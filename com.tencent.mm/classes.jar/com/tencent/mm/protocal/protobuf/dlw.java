package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class dlw
  extends com.tencent.mm.bx.a
{
  public String YYr;
  public long aaRX;
  public long aaRY;
  public String aayd;
  public int scene;
  public int vhJ;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(259021);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "scene", Integer.valueOf(this.scene), false);
      com.tencent.mm.bk.a.a(localJSONObject, "Json", this.aayd, false);
      com.tencent.mm.bk.a.a(localJSONObject, "CacheSecond", Long.valueOf(this.aaRX), false);
      com.tencent.mm.bk.a.a(localJSONObject, "LastCacheSecond", Long.valueOf(this.aaRY), false);
      com.tencent.mm.bk.a.a(localJSONObject, "SearchID", this.YYr, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Type", Integer.valueOf(this.vhJ), false);
      label91:
      AppMethodBeat.o(259021);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label91;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117876);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.scene);
      if (this.aayd != null) {
        paramVarArgs.g(2, this.aayd);
      }
      paramVarArgs.bv(3, this.aaRX);
      paramVarArgs.bv(4, this.aaRY);
      if (this.YYr != null) {
        paramVarArgs.g(5, this.YYr);
      }
      paramVarArgs.bS(6, this.vhJ);
      AppMethodBeat.o(117876);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.scene) + 0;
      paramInt = i;
      if (this.aayd != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.aayd);
      }
      i = paramInt + i.a.a.b.b.a.q(3, this.aaRX) + i.a.a.b.b.a.q(4, this.aaRY);
      paramInt = i;
      if (this.YYr != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.YYr);
      }
      i = i.a.a.b.b.a.cJ(6, this.vhJ);
      AppMethodBeat.o(117876);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(117876);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      dlw localdlw = (dlw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117876);
        return -1;
      case 1: 
        localdlw.scene = locala.ajGk.aar();
        AppMethodBeat.o(117876);
        return 0;
      case 2: 
        localdlw.aayd = locala.ajGk.readString();
        AppMethodBeat.o(117876);
        return 0;
      case 3: 
        localdlw.aaRX = locala.ajGk.aaw();
        AppMethodBeat.o(117876);
        return 0;
      case 4: 
        localdlw.aaRY = locala.ajGk.aaw();
        AppMethodBeat.o(117876);
        return 0;
      case 5: 
        localdlw.YYr = locala.ajGk.readString();
        AppMethodBeat.o(117876);
        return 0;
      }
      localdlw.vhJ = locala.ajGk.aar();
      AppMethodBeat.o(117876);
      return 0;
    }
    AppMethodBeat.o(117876);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dlw
 * JD-Core Version:    0.7.0.1
 */