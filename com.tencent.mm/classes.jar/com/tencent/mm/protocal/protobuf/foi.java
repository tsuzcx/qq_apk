package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class foi
  extends com.tencent.mm.bx.a
{
  public long abOC;
  public long abOQ;
  public long abOR;
  public String mediaId;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(258052);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "mediaId", this.mediaId, false);
      com.tencent.mm.bk.a.a(localJSONObject, "preloadOffset", Long.valueOf(this.abOQ), false);
      com.tencent.mm.bk.a.a(localJSONObject, "preloadPercent", Long.valueOf(this.abOR), false);
      com.tencent.mm.bk.a.a(localJSONObject, "videoSize", Long.valueOf(this.abOC), false);
      label66:
      AppMethodBeat.o(258052);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label66;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153014);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.mediaId != null) {
        paramVarArgs.g(1, this.mediaId);
      }
      paramVarArgs.bv(2, this.abOQ);
      paramVarArgs.bv(3, this.abOR);
      paramVarArgs.bv(4, this.abOC);
      AppMethodBeat.o(153014);
      return 0;
    }
    if (paramInt == 1) {
      if (this.mediaId == null) {
        break label346;
      }
    }
    label346:
    for (paramInt = i.a.a.b.b.a.h(1, this.mediaId) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.q(2, this.abOQ);
      int j = i.a.a.b.b.a.q(3, this.abOR);
      int k = i.a.a.b.b.a.q(4, this.abOC);
      AppMethodBeat.o(153014);
      return paramInt + i + j + k;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(153014);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        foi localfoi = (foi)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153014);
          return -1;
        case 1: 
          localfoi.mediaId = locala.ajGk.readString();
          AppMethodBeat.o(153014);
          return 0;
        case 2: 
          localfoi.abOQ = locala.ajGk.aaw();
          AppMethodBeat.o(153014);
          return 0;
        case 3: 
          localfoi.abOR = locala.ajGk.aaw();
          AppMethodBeat.o(153014);
          return 0;
        }
        localfoi.abOC = locala.ajGk.aaw();
        AppMethodBeat.o(153014);
        return 0;
      }
      AppMethodBeat.o(153014);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.foi
 * JD-Core Version:    0.7.0.1
 */