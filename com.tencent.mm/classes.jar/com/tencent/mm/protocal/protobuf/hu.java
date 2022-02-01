package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONObject;

public final class hu
  extends com.tencent.mm.bx.a
{
  public String YJc;
  public fur YJd;
  public String YJe;
  public euo YJf;
  public String YJg;
  public String rHf;
  public String rHg;
  public String rHh;
  public String scope;
  public int state;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(257885);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "scope", this.scope, false);
      com.tencent.mm.bk.a.a(localJSONObject, "scopeDesc", this.YJc, false);
      com.tencent.mm.bk.a.a(localJSONObject, "state", Integer.valueOf(this.state), false);
      com.tencent.mm.bk.a.a(localJSONObject, "userAvatarInfo", this.YJd, false);
      com.tencent.mm.bk.a.a(localJSONObject, "scope_sub_desc", this.YJe, false);
      com.tencent.mm.bk.a.a(localJSONObject, "risk_popup_info", this.YJf, false);
      com.tencent.mm.bk.a.a(localJSONObject, "auth_wording", this.YJg, false);
      com.tencent.mm.bk.a.a(localJSONObject, "bottom_desc", this.rHf, false);
      com.tencent.mm.bk.a.a(localJSONObject, "scope_sec_desc", this.rHg, false);
      com.tencent.mm.bk.a.a(localJSONObject, "item_title", this.rHh, false);
      label126:
      AppMethodBeat.o(257885);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label126;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(147757);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.scope != null) {
        paramVarArgs.g(1, this.scope);
      }
      if (this.YJc != null) {
        paramVarArgs.g(2, this.YJc);
      }
      paramVarArgs.bS(3, this.state);
      if (this.YJd != null)
      {
        paramVarArgs.qD(4, this.YJd.computeSize());
        this.YJd.writeFields(paramVarArgs);
      }
      if (this.YJe != null) {
        paramVarArgs.g(5, this.YJe);
      }
      if (this.YJf != null)
      {
        paramVarArgs.qD(6, this.YJf.computeSize());
        this.YJf.writeFields(paramVarArgs);
      }
      if (this.YJg != null) {
        paramVarArgs.g(7, this.YJg);
      }
      if (this.rHf != null) {
        paramVarArgs.g(8, this.rHf);
      }
      if (this.rHg != null) {
        paramVarArgs.g(9, this.rHg);
      }
      if (this.rHh != null) {
        paramVarArgs.g(10, this.rHh);
      }
      AppMethodBeat.o(147757);
      return 0;
    }
    if (paramInt == 1) {
      if (this.scope == null) {
        break label890;
      }
    }
    label890:
    for (paramInt = i.a.a.b.b.a.h(1, this.scope) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.YJc != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.YJc);
      }
      i += i.a.a.b.b.a.cJ(3, this.state);
      paramInt = i;
      if (this.YJd != null) {
        paramInt = i + i.a.a.a.qC(4, this.YJd.computeSize());
      }
      i = paramInt;
      if (this.YJe != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.YJe);
      }
      paramInt = i;
      if (this.YJf != null) {
        paramInt = i + i.a.a.a.qC(6, this.YJf.computeSize());
      }
      i = paramInt;
      if (this.YJg != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.YJg);
      }
      paramInt = i;
      if (this.rHf != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.rHf);
      }
      i = paramInt;
      if (this.rHg != null) {
        i = paramInt + i.a.a.b.b.a.h(9, this.rHg);
      }
      paramInt = i;
      if (this.rHh != null) {
        paramInt = i + i.a.a.b.b.a.h(10, this.rHh);
      }
      AppMethodBeat.o(147757);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(147757);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        hu localhu = (hu)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(147757);
          return -1;
        case 1: 
          localhu.scope = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(147757);
          return 0;
        case 2: 
          localhu.YJc = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(147757);
          return 0;
        case 3: 
          localhu.state = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(147757);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new fur();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((fur)localObject2).parseFrom((byte[])localObject1);
            }
            localhu.YJd = ((fur)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(147757);
          return 0;
        case 5: 
          localhu.YJe = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(147757);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new euo();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((euo)localObject2).parseFrom((byte[])localObject1);
            }
            localhu.YJf = ((euo)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(147757);
          return 0;
        case 7: 
          localhu.YJg = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(147757);
          return 0;
        case 8: 
          localhu.rHf = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(147757);
          return 0;
        case 9: 
          localhu.rHg = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(147757);
          return 0;
        }
        localhu.rHh = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(147757);
        return 0;
      }
      AppMethodBeat.o(147757);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.hu
 * JD-Core Version:    0.7.0.1
 */