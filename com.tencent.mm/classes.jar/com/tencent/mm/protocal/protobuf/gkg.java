package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONObject;

public final class gkg
  extends erp
{
  public int acge;
  public int acgi;
  public String username;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(257827);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "BaseRequest", this.BaseRequest, false);
      com.tencent.mm.bk.a.a(localJSONObject, "username", this.username, false);
      com.tencent.mm.bk.a.a(localJSONObject, "last_update_time", Integer.valueOf(this.acge), false);
      com.tencent.mm.bk.a.a(localJSONObject, "record_count", Integer.valueOf(this.acgi), false);
      label63:
      AppMethodBeat.o(257827);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label63;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(257833);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseRequest != null)
      {
        paramVarArgs.qD(1, this.BaseRequest.computeSize());
        this.BaseRequest.writeFields(paramVarArgs);
      }
      if (this.username != null) {
        paramVarArgs.g(2, this.username);
      }
      paramVarArgs.bS(3, this.acge);
      paramVarArgs.bS(4, this.acgi);
      AppMethodBeat.o(257833);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseRequest == null) {
        break label436;
      }
    }
    label436:
    for (paramInt = i.a.a.a.qC(1, this.BaseRequest.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.username != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.username);
      }
      paramInt = i.a.a.b.b.a.cJ(3, this.acge);
      int j = i.a.a.b.b.a.cJ(4, this.acgi);
      AppMethodBeat.o(257833);
      return i + paramInt + j;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = erp.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = erp.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(257833);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        gkg localgkg = (gkg)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(257833);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            kc localkc = new kc();
            if ((localObject != null) && (localObject.length > 0)) {
              localkc.parseFrom((byte[])localObject);
            }
            localgkg.BaseRequest = localkc;
            paramInt += 1;
          }
          AppMethodBeat.o(257833);
          return 0;
        case 2: 
          localgkg.username = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(257833);
          return 0;
        case 3: 
          localgkg.acge = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(257833);
          return 0;
        }
        localgkg.acgi = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(257833);
        return 0;
      }
      AppMethodBeat.o(257833);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gkg
 * JD-Core Version:    0.7.0.1
 */