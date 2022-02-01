package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONObject;

public final class ghx
  extends com.tencent.mm.bx.a
{
  public long aceo;
  public ry acep;
  public int aceq;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(258685);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "ctrl_type", Long.valueOf(this.aceo), false);
      com.tencent.mm.bk.a.a(localJSONObject, "widget_url_info", this.acep, false);
      com.tencent.mm.bk.a.a(localJSONObject, "publiclibversion", Integer.valueOf(this.aceq), false);
      label52:
      AppMethodBeat.o(258685);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label52;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117950);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.aceo);
      if (this.acep != null)
      {
        paramVarArgs.qD(2, this.acep.computeSize());
        this.acep.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(3, this.aceq);
      AppMethodBeat.o(117950);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(1, this.aceo) + 0;
      paramInt = i;
      if (this.acep != null) {
        paramInt = i + i.a.a.a.qC(2, this.acep.computeSize());
      }
      i = i.a.a.b.b.a.cJ(3, this.aceq);
      AppMethodBeat.o(117950);
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
      AppMethodBeat.o(117950);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      ghx localghx = (ghx)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117950);
        return -1;
      case 1: 
        localghx.aceo = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(117950);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          ry localry = new ry();
          if ((localObject != null) && (localObject.length > 0)) {
            localry.parseFrom((byte[])localObject);
          }
          localghx.acep = localry;
          paramInt += 1;
        }
        AppMethodBeat.o(117950);
        return 0;
      }
      localghx.aceq = ((i.a.a.a.a)localObject).ajGk.aar();
      AppMethodBeat.o(117950);
      return 0;
    }
    AppMethodBeat.o(117950);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ghx
 * JD-Core Version:    0.7.0.1
 */