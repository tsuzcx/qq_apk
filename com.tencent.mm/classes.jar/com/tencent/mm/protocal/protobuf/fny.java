package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONObject;

public final class fny
  extends esc
{
  public String aaye;
  public boolean abNR;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(258272);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "BaseResponse", this.BaseResponse, false);
      com.tencent.mm.bk.a.a(localJSONObject, "RequestId", this.aaye, false);
      com.tencent.mm.bk.a.a(localJSONObject, "HasDeleteComment", Boolean.valueOf(this.abNR), false);
      label49:
      AppMethodBeat.o(258272);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label49;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117937);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.aaye != null) {
        paramVarArgs.g(2, this.aaye);
      }
      paramVarArgs.di(3, this.abNR);
      AppMethodBeat.o(117937);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label388;
      }
    }
    label388:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.aaye != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.aaye);
      }
      paramInt = i.a.a.b.b.a.ko(3);
      AppMethodBeat.o(117937);
      return i + (paramInt + 1);
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(117937);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fny localfny = (fny)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117937);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kd localkd = new kd();
            if ((localObject != null) && (localObject.length > 0)) {
              localkd.parseFrom((byte[])localObject);
            }
            localfny.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(117937);
          return 0;
        case 2: 
          localfny.aaye = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(117937);
          return 0;
        }
        localfny.abNR = ((i.a.a.a.a)localObject).ajGk.aai();
        AppMethodBeat.o(117937);
        return 0;
      }
      AppMethodBeat.o(117937);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fny
 * JD-Core Version:    0.7.0.1
 */