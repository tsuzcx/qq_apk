package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class fcl
  extends com.tencent.mm.bx.a
{
  public long abCa;
  public int actionType;
  public String icon;
  public String id;
  public String title;
  public String uCW;
  public String url;
  public String wording;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(259149);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "id", this.id, false);
      com.tencent.mm.bk.a.a(localJSONObject, "wording", this.wording, false);
      com.tencent.mm.bk.a.a(localJSONObject, "category", Long.valueOf(this.abCa), false);
      com.tencent.mm.bk.a.a(localJSONObject, "actionType", Integer.valueOf(this.actionType), false);
      com.tencent.mm.bk.a.a(localJSONObject, "url", this.url, false);
      com.tencent.mm.bk.a.a(localJSONObject, "title", this.title, false);
      com.tencent.mm.bk.a.a(localJSONObject, "subTitle", this.uCW, false);
      com.tencent.mm.bk.a.a(localJSONObject, "icon", this.icon, false);
      label107:
      AppMethodBeat.o(259149);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label107;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(152995);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.id != null) {
        paramVarArgs.g(1, this.id);
      }
      if (this.wording != null) {
        paramVarArgs.g(2, this.wording);
      }
      paramVarArgs.bv(3, this.abCa);
      paramVarArgs.bS(4, this.actionType);
      if (this.url != null) {
        paramVarArgs.g(5, this.url);
      }
      if (this.title != null) {
        paramVarArgs.g(6, this.title);
      }
      if (this.uCW != null) {
        paramVarArgs.g(7, this.uCW);
      }
      if (this.icon != null) {
        paramVarArgs.g(8, this.icon);
      }
      AppMethodBeat.o(152995);
      return 0;
    }
    if (paramInt == 1) {
      if (this.id == null) {
        break label602;
      }
    }
    label602:
    for (paramInt = i.a.a.b.b.a.h(1, this.id) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.wording != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.wording);
      }
      i = i + i.a.a.b.b.a.q(3, this.abCa) + i.a.a.b.b.a.cJ(4, this.actionType);
      paramInt = i;
      if (this.url != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.url);
      }
      i = paramInt;
      if (this.title != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.title);
      }
      paramInt = i;
      if (this.uCW != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.uCW);
      }
      i = paramInt;
      if (this.icon != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.icon);
      }
      AppMethodBeat.o(152995);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(152995);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        fcl localfcl = (fcl)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(152995);
          return -1;
        case 1: 
          localfcl.id = locala.ajGk.readString();
          AppMethodBeat.o(152995);
          return 0;
        case 2: 
          localfcl.wording = locala.ajGk.readString();
          AppMethodBeat.o(152995);
          return 0;
        case 3: 
          localfcl.abCa = locala.ajGk.aaw();
          AppMethodBeat.o(152995);
          return 0;
        case 4: 
          localfcl.actionType = locala.ajGk.aar();
          AppMethodBeat.o(152995);
          return 0;
        case 5: 
          localfcl.url = locala.ajGk.readString();
          AppMethodBeat.o(152995);
          return 0;
        case 6: 
          localfcl.title = locala.ajGk.readString();
          AppMethodBeat.o(152995);
          return 0;
        case 7: 
          localfcl.uCW = locala.ajGk.readString();
          AppMethodBeat.o(152995);
          return 0;
        }
        localfcl.icon = locala.ajGk.readString();
        AppMethodBeat.o(152995);
        return 0;
      }
      AppMethodBeat.o(152995);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fcl
 * JD-Core Version:    0.7.0.1
 */