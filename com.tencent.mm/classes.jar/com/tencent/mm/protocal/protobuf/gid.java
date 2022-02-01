package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;
import org.json.JSONObject;

public final class gid
  extends esc
{
  public int YYs;
  public String aayd;
  public int abuG;
  public int acek;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(258653);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "BaseResponse", this.BaseResponse, false);
      com.tencent.mm.bk.a.a(localJSONObject, "UpdateCode", Integer.valueOf(this.acek), false);
      com.tencent.mm.bk.a.a(localJSONObject, "Offset", Integer.valueOf(this.YYs), false);
      com.tencent.mm.bk.a.a(localJSONObject, "Json", this.aayd, false);
      com.tencent.mm.bk.a.a(localJSONObject, "ResultType", Integer.valueOf(this.abuG), false);
      label77:
      AppMethodBeat.o(258653);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label77;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117956);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aayd == null)
      {
        paramVarArgs = new b("Not all required fields were included: Json");
        AppMethodBeat.o(117956);
        throw paramVarArgs;
      }
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.acek);
      paramVarArgs.bS(3, this.YYs);
      if (this.aayd != null) {
        paramVarArgs.g(4, this.aayd);
      }
      paramVarArgs.bS(5, this.abuG);
      AppMethodBeat.o(117956);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label524;
      }
    }
    label524:
    for (paramInt = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.acek) + i.a.a.b.b.a.cJ(3, this.YYs);
      paramInt = i;
      if (this.aayd != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aayd);
      }
      i = i.a.a.b.b.a.cJ(5, this.abuG);
      AppMethodBeat.o(117956);
      return paramInt + i;
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
          AppMethodBeat.o(117956);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117956);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        gid localgid = (gid)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117956);
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
            localgid.BaseResponse = localkd;
            paramInt += 1;
          }
          AppMethodBeat.o(117956);
          return 0;
        case 2: 
          localgid.acek = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(117956);
          return 0;
        case 3: 
          localgid.YYs = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(117956);
          return 0;
        case 4: 
          localgid.aayd = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(117956);
          return 0;
        }
        localgid.abuG = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(117956);
        return 0;
      }
      AppMethodBeat.o(117956);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gid
 * JD-Core Version:    0.7.0.1
 */