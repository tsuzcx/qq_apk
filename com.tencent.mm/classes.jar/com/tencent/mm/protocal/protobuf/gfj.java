package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONObject;

public final class gfj
  extends com.tencent.mm.bx.a
{
  public String UserName;
  public ese YVQ;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(259438);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "CommContent", this.YVQ, false);
      com.tencent.mm.bk.a.a(localJSONObject, "UserName", this.UserName, false);
      label35:
      AppMethodBeat.o(259438);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label35;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117944);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YVQ != null)
      {
        paramVarArgs.qD(1, this.YVQ.computeSize());
        this.YVQ.writeFields(paramVarArgs);
      }
      if (this.UserName != null) {
        paramVarArgs.g(2, this.UserName);
      }
      AppMethodBeat.o(117944);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YVQ == null) {
        break label344;
      }
    }
    label344:
    for (paramInt = i.a.a.a.qC(1, this.YVQ.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.UserName != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.UserName);
      }
      AppMethodBeat.o(117944);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(117944);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        gfj localgfj = (gfj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117944);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            ese localese = new ese();
            if ((localObject != null) && (localObject.length > 0)) {
              localese.parseFrom((byte[])localObject);
            }
            localgfj.YVQ = localese;
            paramInt += 1;
          }
          AppMethodBeat.o(117944);
          return 0;
        }
        localgfj.UserName = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(117944);
        return 0;
      }
      AppMethodBeat.o(117944);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gfj
 * JD-Core Version:    0.7.0.1
 */