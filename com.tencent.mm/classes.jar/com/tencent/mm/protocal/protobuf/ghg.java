package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONObject;

public final class ghg
  extends esc
{
  public String acds;
  public String hOG;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(258871);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "BaseResponse", this.BaseResponse, false);
      com.tencent.mm.bk.a.a(localJSONObject, "commResp", this.acds, false);
      com.tencent.mm.bk.a.a(localJSONObject, "requestId", this.hOG, false);
      label46:
      AppMethodBeat.o(258871);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label46;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117946);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.acds != null) {
        paramVarArgs.g(2, this.acds);
      }
      if (this.hOG != null) {
        paramVarArgs.g(3, this.hOG);
      }
      AppMethodBeat.o(117946);
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
      if (this.acds != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.acds);
      }
      i = paramInt;
      if (this.hOG != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.hOG);
      }
      AppMethodBeat.o(117946);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(117946);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        ghg localghg = (ghg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117946);
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
            localghg.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(117946);
          return 0;
        case 2: 
          localghg.acds = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(117946);
          return 0;
        }
        localghg.hOG = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(117946);
        return 0;
      }
      AppMethodBeat.o(117946);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.ghg
 * JD-Core Version:    0.7.0.1
 */