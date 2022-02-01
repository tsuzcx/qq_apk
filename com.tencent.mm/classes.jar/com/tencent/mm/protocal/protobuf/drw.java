package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class drw
  extends com.tencent.mm.bx.a
{
  public long aaXA;
  public long aaXB;
  public long aaXC;
  public long aaXz;
  public long duration;
  public long mwI;
  public long nAz;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(259977);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "action", Long.valueOf(this.mwI), false);
      com.tencent.mm.bk.a.a(localJSONObject, "scene", Long.valueOf(this.nAz), false);
      com.tencent.mm.bk.a.a(localJSONObject, "useraction", Long.valueOf(this.aaXz), false);
      com.tencent.mm.bk.a.a(localJSONObject, "fullscreen", Long.valueOf(this.aaXA), false);
      com.tencent.mm.bk.a.a(localJSONObject, "taskcount", Long.valueOf(this.aaXB), false);
      com.tencent.mm.bk.a.a(localJSONObject, "duration", Long.valueOf(this.duration), false);
      com.tencent.mm.bk.a.a(localJSONObject, "enterChatting", Long.valueOf(this.aaXC), false);
      label111:
      AppMethodBeat.o(259977);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label111;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259983);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.mwI);
      paramVarArgs.bv(2, this.nAz);
      paramVarArgs.bv(3, this.aaXz);
      paramVarArgs.bv(4, this.aaXA);
      paramVarArgs.bv(5, this.aaXB);
      paramVarArgs.bv(6, this.duration);
      paramVarArgs.bv(7, this.aaXC);
      AppMethodBeat.o(259983);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.q(1, this.mwI);
      int i = i.a.a.b.b.a.q(2, this.nAz);
      int j = i.a.a.b.b.a.q(3, this.aaXz);
      int k = i.a.a.b.b.a.q(4, this.aaXA);
      int m = i.a.a.b.b.a.q(5, this.aaXB);
      int n = i.a.a.b.b.a.q(6, this.duration);
      int i1 = i.a.a.b.b.a.q(7, this.aaXC);
      AppMethodBeat.o(259983);
      return paramInt + 0 + i + j + k + m + n + i1;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(259983);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      drw localdrw = (drw)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(259983);
        return -1;
      case 1: 
        localdrw.mwI = locala.ajGk.aaw();
        AppMethodBeat.o(259983);
        return 0;
      case 2: 
        localdrw.nAz = locala.ajGk.aaw();
        AppMethodBeat.o(259983);
        return 0;
      case 3: 
        localdrw.aaXz = locala.ajGk.aaw();
        AppMethodBeat.o(259983);
        return 0;
      case 4: 
        localdrw.aaXA = locala.ajGk.aaw();
        AppMethodBeat.o(259983);
        return 0;
      case 5: 
        localdrw.aaXB = locala.ajGk.aaw();
        AppMethodBeat.o(259983);
        return 0;
      case 6: 
        localdrw.duration = locala.ajGk.aaw();
        AppMethodBeat.o(259983);
        return 0;
      }
      localdrw.aaXC = locala.ajGk.aaw();
      AppMethodBeat.o(259983);
      return 0;
    }
    AppMethodBeat.o(259983);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.drw
 * JD-Core Version:    0.7.0.1
 */