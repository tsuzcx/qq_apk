package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONObject;

public final class gni
  extends com.tencent.mm.bx.a
{
  public LinkedList<gng> acip;
  public int update_time;
  public String username;
  
  public gni()
  {
    AppMethodBeat.i(259756);
    this.acip = new LinkedList();
    AppMethodBeat.o(259756);
  }
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(259759);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "username", this.username, false);
      com.tencent.mm.bk.a.a(localJSONObject, "scope_item_list", this.acip, false);
      com.tencent.mm.bk.a.a(localJSONObject, "update_time", Integer.valueOf(this.update_time), false);
      label49:
      AppMethodBeat.o(259759);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label49;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259766);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.username != null) {
        paramVarArgs.g(1, this.username);
      }
      paramVarArgs.e(2, 8, this.acip);
      paramVarArgs.bS(3, this.update_time);
      AppMethodBeat.o(259766);
      return 0;
    }
    if (paramInt == 1) {
      if (this.username == null) {
        break label380;
      }
    }
    label380:
    for (paramInt = i.a.a.b.b.a.h(1, this.username) + 0;; paramInt = 0)
    {
      int i = i.a.a.a.c(2, 8, this.acip);
      int j = i.a.a.b.b.a.cJ(3, this.update_time);
      AppMethodBeat.o(259766);
      return paramInt + i + j;
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        this.acip.clear();
        paramVarArgs = new i.a.a.a.a(paramVarArgs, unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259766);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        gni localgni = (gni)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259766);
          return -1;
        case 1: 
          localgni.username = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259766);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject = (byte[])paramVarArgs.get(paramInt);
            gng localgng = new gng();
            if ((localObject != null) && (localObject.length > 0)) {
              localgng.parseFrom((byte[])localObject);
            }
            localgni.acip.add(localgng);
            paramInt += 1;
          }
          AppMethodBeat.o(259766);
          return 0;
        }
        localgni.update_time = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(259766);
        return 0;
      }
      AppMethodBeat.o(259766);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gni
 * JD-Core Version:    0.7.0.1
 */