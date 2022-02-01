package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONObject;

public final class fnw
  extends esc
{
  public String aaye;
  public String abNQ;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(258247);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "BaseResponse", this.BaseResponse, false);
      com.tencent.mm.bk.a.a(localJSONObject, "CommentId", this.abNQ, false);
      com.tencent.mm.bk.a.a(localJSONObject, "RequestId", this.aaye, false);
      label46:
      AppMethodBeat.o(258247);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label46;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117935);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.abNQ != null) {
        paramVarArgs.g(2, this.abNQ);
      }
      if (this.aaye != null) {
        paramVarArgs.g(3, this.aaye);
      }
      AppMethodBeat.o(117935);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label404;
      }
    }
    label404:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abNQ != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.abNQ);
      }
      i = paramInt;
      if (this.aaye != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.aaye);
      }
      AppMethodBeat.o(117935);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(117935);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        fnw localfnw = (fnw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117935);
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
            localfnw.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(117935);
          return 0;
        case 2: 
          localfnw.abNQ = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(117935);
          return 0;
        }
        localfnw.aaye = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(117935);
        return 0;
      }
      AppMethodBeat.o(117935);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fnw
 * JD-Core Version:    0.7.0.1
 */