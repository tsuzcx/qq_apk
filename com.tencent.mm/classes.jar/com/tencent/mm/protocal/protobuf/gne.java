package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONObject;

public final class gne
  extends com.tencent.mm.bx.a
{
  public LinkedList<eum> acip;
  public String appid;
  public String icon_url;
  public String xkX;
  
  public gne()
  {
    AppMethodBeat.i(259907);
    this.acip = new LinkedList();
    AppMethodBeat.o(259907);
  }
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(259911);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "appid", this.appid, false);
      com.tencent.mm.bk.a.a(localJSONObject, "nick_name", this.xkX, false);
      com.tencent.mm.bk.a.a(localJSONObject, "icon_url", this.icon_url, false);
      com.tencent.mm.bk.a.a(localJSONObject, "scope_item_list", this.acip, false);
      label57:
      AppMethodBeat.o(259911);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label57;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259917);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.appid != null) {
        paramVarArgs.g(1, this.appid);
      }
      if (this.xkX != null) {
        paramVarArgs.g(2, this.xkX);
      }
      if (this.icon_url != null) {
        paramVarArgs.g(3, this.icon_url);
      }
      paramVarArgs.e(4, 8, this.acip);
      AppMethodBeat.o(259917);
      return 0;
    }
    if (paramInt == 1) {
      if (this.appid == null) {
        break label452;
      }
    }
    label452:
    for (int i = i.a.a.b.b.a.h(1, this.appid) + 0;; i = 0)
    {
      paramInt = i;
      if (this.xkX != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.xkX);
      }
      i = paramInt;
      if (this.icon_url != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.icon_url);
      }
      paramInt = i.a.a.a.c(4, 8, this.acip);
      AppMethodBeat.o(259917);
      return i + paramInt;
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
        AppMethodBeat.o(259917);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        gne localgne = (gne)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(259917);
          return -1;
        case 1: 
          localgne.appid = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259917);
          return 0;
        case 2: 
          localgne.xkX = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259917);
          return 0;
        case 3: 
          localgne.icon_url = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(259917);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject = (byte[])paramVarArgs.get(paramInt);
          eum localeum = new eum();
          if ((localObject != null) && (localObject.length > 0)) {
            localeum.parseFrom((byte[])localObject);
          }
          localgne.acip.add(localeum);
          paramInt += 1;
        }
        AppMethodBeat.o(259917);
        return 0;
      }
      AppMethodBeat.o(259917);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gne
 * JD-Core Version:    0.7.0.1
 */