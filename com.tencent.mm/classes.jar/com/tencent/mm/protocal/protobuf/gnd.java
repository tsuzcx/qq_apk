package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONObject;

public final class gnd
  extends com.tencent.mm.bx.a
{
  public gne acin;
  public LinkedList<gne> acio;
  
  public gnd()
  {
    AppMethodBeat.i(259865);
    this.acio = new LinkedList();
    AppMethodBeat.o(259865);
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259872);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.acin != null)
      {
        paramVarArgs.qD(1, this.acin.computeSize());
        this.acin.writeFields(paramVarArgs);
      }
      paramVarArgs.e(2, 8, this.acio);
      AppMethodBeat.o(259872);
      return 0;
    }
    if (paramInt == 1) {
      if (this.acin == null) {
        break label406;
      }
    }
    label406:
    for (paramInt = i.a.a.a.qC(1, this.acin.computeSize()) + 0;; paramInt = 0)
    {
      int i = i.a.a.a.c(2, 8, this.acio);
      AppMethodBeat.o(259872);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.acio.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259872);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        gnd localgnd = (gnd)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        gne localgne;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259872);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            localgne = new gne();
            if ((localObject != null) && (localObject.length > 0)) {
              localgne.parseFrom((byte[])localObject);
            }
            localgnd.acin = localgne;
            paramInt += 1;
          }
          AppMethodBeat.o(259872);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          localgne = new gne();
          if ((localObject != null) && (localObject.length > 0)) {
            localgne.parseFrom((byte[])localObject);
          }
          localgnd.acio.add(localgne);
          paramInt += 1;
        }
        AppMethodBeat.o(259872);
        return 0;
      }
      AppMethodBeat.o(259872);
      return -1;
    }
  }
  
  public final JSONObject toJSON()
  {
    AppMethodBeat.i(259875);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "wxa_item", this.acin, false);
      com.tencent.mm.bk.a.a(localJSONObject, "plugin_item_list", this.acio, false);
      label35:
      AppMethodBeat.o(259875);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label35;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gnd
 * JD-Core Version:    0.7.0.1
 */