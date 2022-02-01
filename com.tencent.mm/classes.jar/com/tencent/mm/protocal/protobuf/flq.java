package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class flq
  extends com.tencent.mm.bx.a
{
  public int abMc;
  public String abMd;
  public String abMe;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(258916);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "TagType", Integer.valueOf(this.abMc), false);
      com.tencent.mm.bk.a.a(localJSONObject, "TagText", this.abMd, false);
      com.tencent.mm.bk.a.a(localJSONObject, "TagExtValue", this.abMe, false);
      label49:
      AppMethodBeat.o(258916);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label49;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117933);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.abMc);
      if (this.abMd != null) {
        paramVarArgs.g(2, this.abMd);
      }
      if (this.abMe != null) {
        paramVarArgs.g(3, this.abMe);
      }
      AppMethodBeat.o(117933);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.abMc) + 0;
      paramInt = i;
      if (this.abMd != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.abMd);
      }
      i = paramInt;
      if (this.abMe != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.abMe);
      }
      AppMethodBeat.o(117933);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(117933);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      flq localflq = (flq)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117933);
        return -1;
      case 1: 
        localflq.abMc = locala.ajGk.aar();
        AppMethodBeat.o(117933);
        return 0;
      case 2: 
        localflq.abMd = locala.ajGk.readString();
        AppMethodBeat.o(117933);
        return 0;
      }
      localflq.abMe = locala.ajGk.readString();
      AppMethodBeat.o(117933);
      return 0;
    }
    AppMethodBeat.o(117933);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.flq
 * JD-Core Version:    0.7.0.1
 */