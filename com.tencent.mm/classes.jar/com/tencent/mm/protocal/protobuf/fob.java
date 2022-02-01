package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class fob
  extends com.tencent.mm.bx.a
{
  public long UGO;
  public int WoG;
  public int WpN;
  public int WpO;
  public int WpP;
  public int abNX;
  public long abNY;
  public String extInfo;
  public String icon;
  public String msgId;
  public int oUj;
  public long ofU;
  public int priority;
  public int showFlag;
  public String text;
  public int type;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(258163);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "msgId", this.msgId, false);
      com.tencent.mm.bk.a.a(localJSONObject, "entry", Integer.valueOf(this.WpN), false);
      com.tencent.mm.bk.a.a(localJSONObject, "clientVer", Integer.valueOf(this.WpO), false);
      com.tencent.mm.bk.a.a(localJSONObject, "expireTime", Long.valueOf(this.ofU), false);
      com.tencent.mm.bk.a.a(localJSONObject, "h5Version", Integer.valueOf(this.WoG), false);
      com.tencent.mm.bk.a.a(localJSONObject, "type", Integer.valueOf(this.type), false);
      com.tencent.mm.bk.a.a(localJSONObject, "text", this.text, false);
      com.tencent.mm.bk.a.a(localJSONObject, "icon", this.icon, false);
      com.tencent.mm.bk.a.a(localJSONObject, "showTime", Long.valueOf(this.UGO), false);
      com.tencent.mm.bk.a.a(localJSONObject, "discovery", Integer.valueOf(this.WpP), false);
      com.tencent.mm.bk.a.a(localJSONObject, "clearFlag", Integer.valueOf(this.abNX), false);
      com.tencent.mm.bk.a.a(localJSONObject, "receiveTime", Long.valueOf(this.abNY), false);
      com.tencent.mm.bk.a.a(localJSONObject, "showFlag", Integer.valueOf(this.showFlag), false);
      com.tencent.mm.bk.a.a(localJSONObject, "seq", Integer.valueOf(this.oUj), false);
      com.tencent.mm.bk.a.a(localJSONObject, "extInfo", this.extInfo, false);
      com.tencent.mm.bk.a.a(localJSONObject, "priority", Integer.valueOf(this.priority), false);
      label225:
      AppMethodBeat.o(258163);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label225;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(153002);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.msgId != null) {
        paramVarArgs.g(1, this.msgId);
      }
      paramVarArgs.bS(2, this.WpN);
      paramVarArgs.bS(3, this.WpO);
      paramVarArgs.bv(4, this.ofU);
      paramVarArgs.bS(5, this.WoG);
      paramVarArgs.bS(6, this.type);
      if (this.text != null) {
        paramVarArgs.g(7, this.text);
      }
      if (this.icon != null) {
        paramVarArgs.g(8, this.icon);
      }
      paramVarArgs.bv(9, this.UGO);
      paramVarArgs.bS(10, this.WpP);
      paramVarArgs.bS(11, this.abNX);
      paramVarArgs.bv(12, this.abNY);
      paramVarArgs.bS(13, this.showFlag);
      paramVarArgs.bS(14, this.oUj);
      if (this.extInfo != null) {
        paramVarArgs.g(15, this.extInfo);
      }
      paramVarArgs.bS(16, this.priority);
      AppMethodBeat.o(153002);
      return 0;
    }
    if (paramInt == 1) {
      if (this.msgId == null) {
        break label922;
      }
    }
    label922:
    for (paramInt = i.a.a.b.b.a.h(1, this.msgId) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.WpN) + i.a.a.b.b.a.cJ(3, this.WpO) + i.a.a.b.b.a.q(4, this.ofU) + i.a.a.b.b.a.cJ(5, this.WoG) + i.a.a.b.b.a.cJ(6, this.type);
      paramInt = i;
      if (this.text != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.text);
      }
      i = paramInt;
      if (this.icon != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.icon);
      }
      i = i + i.a.a.b.b.a.q(9, this.UGO) + i.a.a.b.b.a.cJ(10, this.WpP) + i.a.a.b.b.a.cJ(11, this.abNX) + i.a.a.b.b.a.q(12, this.abNY) + i.a.a.b.b.a.cJ(13, this.showFlag) + i.a.a.b.b.a.cJ(14, this.oUj);
      paramInt = i;
      if (this.extInfo != null) {
        paramInt = i + i.a.a.b.b.a.h(15, this.extInfo);
      }
      i = i.a.a.b.b.a.cJ(16, this.priority);
      AppMethodBeat.o(153002);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(153002);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        fob localfob = (fob)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(153002);
          return -1;
        case 1: 
          localfob.msgId = locala.ajGk.readString();
          AppMethodBeat.o(153002);
          return 0;
        case 2: 
          localfob.WpN = locala.ajGk.aar();
          AppMethodBeat.o(153002);
          return 0;
        case 3: 
          localfob.WpO = locala.ajGk.aar();
          AppMethodBeat.o(153002);
          return 0;
        case 4: 
          localfob.ofU = locala.ajGk.aaw();
          AppMethodBeat.o(153002);
          return 0;
        case 5: 
          localfob.WoG = locala.ajGk.aar();
          AppMethodBeat.o(153002);
          return 0;
        case 6: 
          localfob.type = locala.ajGk.aar();
          AppMethodBeat.o(153002);
          return 0;
        case 7: 
          localfob.text = locala.ajGk.readString();
          AppMethodBeat.o(153002);
          return 0;
        case 8: 
          localfob.icon = locala.ajGk.readString();
          AppMethodBeat.o(153002);
          return 0;
        case 9: 
          localfob.UGO = locala.ajGk.aaw();
          AppMethodBeat.o(153002);
          return 0;
        case 10: 
          localfob.WpP = locala.ajGk.aar();
          AppMethodBeat.o(153002);
          return 0;
        case 11: 
          localfob.abNX = locala.ajGk.aar();
          AppMethodBeat.o(153002);
          return 0;
        case 12: 
          localfob.abNY = locala.ajGk.aaw();
          AppMethodBeat.o(153002);
          return 0;
        case 13: 
          localfob.showFlag = locala.ajGk.aar();
          AppMethodBeat.o(153002);
          return 0;
        case 14: 
          localfob.oUj = locala.ajGk.aar();
          AppMethodBeat.o(153002);
          return 0;
        case 15: 
          localfob.extInfo = locala.ajGk.readString();
          AppMethodBeat.o(153002);
          return 0;
        }
        localfob.priority = locala.ajGk.aar();
        AppMethodBeat.o(153002);
        return 0;
      }
      AppMethodBeat.o(153002);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fob
 * JD-Core Version:    0.7.0.1
 */