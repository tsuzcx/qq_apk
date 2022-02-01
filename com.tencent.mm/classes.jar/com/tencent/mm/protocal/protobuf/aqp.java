package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONObject;

public final class aqp
  extends com.tencent.mm.bx.a
{
  public fkk ZxJ;
  public int crs;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(259130);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "Item", this.ZxJ, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Index", Integer.valueOf(this.crs), false);
      label38:
      AppMethodBeat.o(259130);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label38;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117867);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZxJ != null)
      {
        paramVarArgs.qD(1, this.ZxJ.computeSize());
        this.ZxJ.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.crs);
      AppMethodBeat.o(117867);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZxJ == null) {
        break label328;
      }
    }
    label328:
    for (paramInt = i.a.a.a.qC(1, this.ZxJ.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.b.b.a.cJ(2, this.crs);
      AppMethodBeat.o(117867);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(117867);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        aqp localaqp = (aqp)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117867);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            fkk localfkk = new fkk();
            if ((localObject != null) && (localObject.length > 0)) {
              localfkk.parseFrom((byte[])localObject);
            }
            localaqp.ZxJ = localfkk;
            paramInt += 1;
          }
          AppMethodBeat.o(117867);
          return 0;
        }
        localaqp.crs = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(117867);
        return 0;
      }
      AppMethodBeat.o(117867);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aqp
 * JD-Core Version:    0.7.0.1
 */