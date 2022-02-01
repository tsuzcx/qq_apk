package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONObject;

public final class gnf
  extends com.tencent.mm.bx.a
{
  public int HTK;
  public gnh aciq;
  public gng acir;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(259894);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "plugin_info", this.aciq, false);
      com.tencent.mm.bk.a.a(localJSONObject, "scope_item", this.acir, false);
      com.tencent.mm.bk.a.a(localJSONObject, "create_time", Integer.valueOf(this.HTK), false);
      label49:
      AppMethodBeat.o(259894);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label49;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259896);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aciq != null)
      {
        paramVarArgs.qD(1, this.aciq.computeSize());
        this.aciq.writeFields(paramVarArgs);
      }
      if (this.acir != null)
      {
        paramVarArgs.qD(2, this.acir.computeSize());
        this.acir.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(3, this.HTK);
      AppMethodBeat.o(259896);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aciq == null) {
        break label462;
      }
    }
    label462:
    for (paramInt = i.a.a.a.qC(1, this.aciq.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.acir != null) {
        i = paramInt + i.a.a.a.qC(2, this.acir.computeSize());
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.HTK);
      AppMethodBeat.o(259896);
      return i + paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259896);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        gnf localgnf = (gnf)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259896);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gnh();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gnh)localObject2).parseFrom((byte[])localObject1);
            }
            localgnf.aciq = ((gnh)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259896);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new gng();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((gng)localObject2).parseFrom((byte[])localObject1);
            }
            localgnf.acir = ((gng)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(259896);
          return 0;
        }
        localgnf.HTK = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(259896);
        return 0;
      }
      AppMethodBeat.o(259896);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gnf
 * JD-Core Version:    0.7.0.1
 */