package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;
import org.json.JSONObject;

public final class dlz
  extends esc
{
  public int aaSd;
  public String aayd;
  public String aayf;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(259077);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "BaseResponse", this.BaseResponse, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Json", this.aayd, false);
      com.tencent.mm.bk.a.a(localJSONObject, "TimevalSec", Integer.valueOf(this.aaSd), false);
      com.tencent.mm.bk.a.a(localJSONObject, "SearchId", this.aayf, false);
      label60:
      AppMethodBeat.o(259077);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label60;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117879);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aayd == null)
      {
        paramVarArgs = new b("Not all required fields were included: Json");
        AppMethodBeat.o(117879);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.aayd != null) {
        paramVarArgs.g(2, this.aayd);
      }
      paramVarArgs.bS(3, this.aaSd);
      if (this.aayf != null) {
        paramVarArgs.g(4, this.aayf);
      }
      AppMethodBeat.o(117879);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label496;
      }
    }
    label496:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.aayd != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.aayd);
      }
      i += i.a.a.b.b.a.cJ(3, this.aaSd);
      paramInt = i;
      if (this.aayf != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aayf);
      }
      AppMethodBeat.o(117879);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.aayd == null)
        {
          paramVarArgs = new b("Not all required fields were included: Json");
          AppMethodBeat.o(117879);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117879);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        dlz localdlz = (dlz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117879);
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
            localdlz.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(117879);
          return 0;
        case 2: 
          localdlz.aayd = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(117879);
          return 0;
        case 3: 
          localdlz.aaSd = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(117879);
          return 0;
        }
        localdlz.aayf = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(117879);
        return 0;
      }
      AppMethodBeat.o(117879);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dlz
 * JD-Core Version:    0.7.0.1
 */