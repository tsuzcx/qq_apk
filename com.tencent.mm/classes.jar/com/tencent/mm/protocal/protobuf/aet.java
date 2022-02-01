package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONObject;

public final class aet
  extends com.tencent.mm.bx.a
{
  public drt ZmM;
  public boolean ZmN;
  public String zIO;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(260183);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "animdata", this.ZmM, false);
      com.tencent.mm.bk.a.a(localJSONObject, "contextId", this.zIO, false);
      com.tencent.mm.bk.a.a(localJSONObject, "isFromTaskBar", Boolean.valueOf(this.ZmN), false);
      label49:
      AppMethodBeat.o(260183);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label49;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260188);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZmM != null)
      {
        paramVarArgs.qD(1, this.ZmM.computeSize());
        this.ZmM.writeFields(paramVarArgs);
      }
      if (this.zIO != null) {
        paramVarArgs.g(2, this.zIO);
      }
      paramVarArgs.di(3, this.ZmN);
      AppMethodBeat.o(260188);
      return 0;
    }
    if (paramInt == 1) {
      if (this.ZmM == null) {
        break label388;
      }
    }
    label388:
    for (paramInt = i.a.a.a.qC(1, this.ZmM.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.zIO != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.zIO);
      }
      paramInt = i.a.a.b.b.a.ko(3);
      AppMethodBeat.o(260188);
      return i + (paramInt + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(260188);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        aet localaet = (aet)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(260188);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            drt localdrt = new drt();
            if ((localObject != null) && (localObject.length > 0)) {
              localdrt.parseFrom((byte[])localObject);
            }
            localaet.ZmM = localdrt;
            paramInt += 1;
          }
          AppMethodBeat.o(260188);
          return 0;
        case 2: 
          localaet.zIO = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(260188);
          return 0;
        }
        localaet.ZmN = ((i.a.a.a.a)localObject).ajGk.aai();
        AppMethodBeat.o(260188);
        return 0;
      }
      AppMethodBeat.o(260188);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.aet
 * JD-Core Version:    0.7.0.1
 */