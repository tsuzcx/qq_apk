package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;
import org.json.JSONObject;

public final class adw
  extends com.tencent.mm.bx.a
{
  public int Zmc;
  public gol Zmd;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(257483);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "CmdId", Integer.valueOf(this.Zmc), false);
      com.tencent.mm.bk.a.a(localJSONObject, "CmdBuf", this.Zmd, false);
      label38:
      AppMethodBeat.o(257483);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label38;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133166);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Zmd == null)
      {
        paramVarArgs = new b("Not all required fields were included: CmdBuf");
        AppMethodBeat.o(133166);
        throw paramVarArgs;
      }
      paramVarArgs.bS(1, this.Zmc);
      if (this.Zmd != null)
      {
        paramVarArgs.qD(2, this.Zmd.computeSize());
        this.Zmd.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(133166);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.Zmc) + 0;
      paramInt = i;
      if (this.Zmd != null) {
        paramInt = i + i.a.a.a.qC(2, this.Zmd.computeSize());
      }
      AppMethodBeat.o(133166);
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
      if (this.Zmd == null)
      {
        paramVarArgs = new b("Not all required fields were included: CmdBuf");
        AppMethodBeat.o(133166);
        throw paramVarArgs;
      }
      AppMethodBeat.o(133166);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      adw localadw = (adw)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(133166);
        return -1;
      case 1: 
        localadw.Zmc = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(133166);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        gol localgol = new gol();
        if ((localObject != null) && (localObject.length > 0)) {
          localgol.dg((byte[])localObject);
        }
        localadw.Zmd = localgol;
        paramInt += 1;
      }
      AppMethodBeat.o(133166);
      return 0;
    }
    AppMethodBeat.o(133166);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.adw
 * JD-Core Version:    0.7.0.1
 */