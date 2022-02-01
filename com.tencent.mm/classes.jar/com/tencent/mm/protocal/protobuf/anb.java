package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONObject;

public final class anb
  extends com.tencent.mm.bx.a
{
  public int HTK;
  public bgh ZNW;
  public int ZmD;
  public int ZmE;
  public long id;
  public String msg;
  public String nickname;
  public int type;
  public String username;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(369660);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "id", Long.valueOf(this.id), false);
      com.tencent.mm.bk.a.a(localJSONObject, "type", Integer.valueOf(this.type), false);
      com.tencent.mm.bk.a.a(localJSONObject, "username", this.username, false);
      com.tencent.mm.bk.a.a(localJSONObject, "nickname", this.nickname, false);
      com.tencent.mm.bk.a.a(localJSONObject, "msg", this.msg, false);
      com.tencent.mm.bk.a.a(localJSONObject, "create_time", Integer.valueOf(this.HTK), false);
      com.tencent.mm.bk.a.a(localJSONObject, "relation", Integer.valueOf(this.ZmD), false);
      com.tencent.mm.bk.a.a(localJSONObject, "del_flag", Integer.valueOf(this.ZmE), false);
      com.tencent.mm.bk.a.a(localJSONObject, "to_user_contact", this.ZNW, false);
      label127:
      AppMethodBeat.o(369660);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label127;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(369661);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.id);
      paramVarArgs.bS(2, this.type);
      if (this.username != null) {
        paramVarArgs.g(3, this.username);
      }
      if (this.nickname != null) {
        paramVarArgs.g(4, this.nickname);
      }
      if (this.msg != null) {
        paramVarArgs.g(5, this.msg);
      }
      paramVarArgs.bS(6, this.HTK);
      paramVarArgs.bS(7, this.ZmD);
      paramVarArgs.bS(8, this.ZmE);
      if (this.ZNW != null)
      {
        paramVarArgs.qD(9, this.ZNW.computeSize());
        this.ZNW.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(369661);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.q(1, this.id) + 0 + i.a.a.b.b.a.cJ(2, this.type);
      paramInt = i;
      if (this.username != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.username);
      }
      i = paramInt;
      if (this.nickname != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.nickname);
      }
      paramInt = i;
      if (this.msg != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.msg);
      }
      i = paramInt + i.a.a.b.b.a.cJ(6, this.HTK) + i.a.a.b.b.a.cJ(7, this.ZmD) + i.a.a.b.b.a.cJ(8, this.ZmE);
      paramInt = i;
      if (this.ZNW != null) {
        paramInt = i + i.a.a.a.qC(9, this.ZNW.computeSize());
      }
      AppMethodBeat.o(369661);
      return paramInt;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(369661);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject = (i.a.a.a.a)paramVarArgs[0];
      anb localanb = (anb)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(369661);
        return -1;
      case 1: 
        localanb.id = ((i.a.a.a.a)localObject).ajGk.aaw();
        AppMethodBeat.o(369661);
        return 0;
      case 2: 
        localanb.type = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(369661);
        return 0;
      case 3: 
        localanb.username = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(369661);
        return 0;
      case 4: 
        localanb.nickname = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(369661);
        return 0;
      case 5: 
        localanb.msg = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(369661);
        return 0;
      case 6: 
        localanb.HTK = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(369661);
        return 0;
      case 7: 
        localanb.ZmD = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(369661);
        return 0;
      case 8: 
        localanb.ZmE = ((i.a.a.a.a)localObject).ajGk.aar();
        AppMethodBeat.o(369661);
        return 0;
      }
      paramVarArgs = ((i.a.a.a.a)localObject).aMP(paramInt);
      i = paramVarArgs.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject = (byte[])paramVarArgs.get(paramInt);
        bgh localbgh = new bgh();
        if ((localObject != null) && (localObject.length > 0)) {
          localbgh.parseFrom((byte[])localObject);
        }
        localanb.ZNW = localbgh;
        paramInt += 1;
      }
      AppMethodBeat.o(369661);
      return 0;
    }
    AppMethodBeat.o(369661);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.anb
 * JD-Core Version:    0.7.0.1
 */