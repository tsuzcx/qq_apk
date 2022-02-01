package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class emr
  extends com.tencent.mm.bx.a
{
  public String abqX;
  public String abqY;
  public int abqZ;
  public int abra = 0;
  public String abrb;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(260203);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "Summary", this.abqX, false);
      com.tencent.mm.bk.a.a(localJSONObject, "RedPointMsgId", this.abqY, false);
      com.tencent.mm.bk.a.a(localJSONObject, "RedPointInvalidTime", Integer.valueOf(this.abqZ), false);
      com.tencent.mm.bk.a.a(localJSONObject, "NoCache", Integer.valueOf(this.abra), false);
      com.tencent.mm.bk.a.a(localJSONObject, "CallBackStr", this.abrb, false);
      label74:
      AppMethodBeat.o(260203);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label74;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117895);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abqX != null) {
        paramVarArgs.g(1, this.abqX);
      }
      if (this.abqY != null) {
        paramVarArgs.g(2, this.abqY);
      }
      paramVarArgs.bS(3, this.abqZ);
      paramVarArgs.bS(4, this.abra);
      if (this.abrb != null) {
        paramVarArgs.g(5, this.abrb);
      }
      AppMethodBeat.o(117895);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abqX == null) {
        break label418;
      }
    }
    label418:
    for (paramInt = i.a.a.b.b.a.h(1, this.abqX) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.abqY != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.abqY);
      }
      i = i + i.a.a.b.b.a.cJ(3, this.abqZ) + i.a.a.b.b.a.cJ(4, this.abra);
      paramInt = i;
      if (this.abrb != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.abrb);
      }
      AppMethodBeat.o(117895);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(117895);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        emr localemr = (emr)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117895);
          return -1;
        case 1: 
          localemr.abqX = locala.ajGk.readString();
          AppMethodBeat.o(117895);
          return 0;
        case 2: 
          localemr.abqY = locala.ajGk.readString();
          AppMethodBeat.o(117895);
          return 0;
        case 3: 
          localemr.abqZ = locala.ajGk.aar();
          AppMethodBeat.o(117895);
          return 0;
        case 4: 
          localemr.abra = locala.ajGk.aar();
          AppMethodBeat.o(117895);
          return 0;
        }
        localemr.abrb = locala.ajGk.readString();
        AppMethodBeat.o(117895);
        return 0;
      }
      AppMethodBeat.o(117895);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.emr
 * JD-Core Version:    0.7.0.1
 */