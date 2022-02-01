package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONObject;

public final class akt
  extends com.tencent.mm.bx.a
{
  public String IGI;
  public int IHl;
  public String UserName;
  public ese YVQ;
  public String ZrX;
  public String ZrY;
  public int ZrZ;
  public String Zsa;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(258185);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "CommContent", this.YVQ, false);
      com.tencent.mm.bk.a.a(localJSONObject, "JumpUrl", this.IGI, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Date", this.ZrX, false);
      com.tencent.mm.bk.a.a(localJSONObject, "JumpType", Integer.valueOf(this.IHl), false);
      com.tencent.mm.bk.a.a(localJSONObject, "UserName", this.UserName, false);
      com.tencent.mm.bk.a.a(localJSONObject, "WeappPath", this.ZrY, false);
      com.tencent.mm.bk.a.a(localJSONObject, "WeappVersion", Integer.valueOf(this.ZrZ), false);
      com.tencent.mm.bk.a.a(localJSONObject, "SceneNote", this.Zsa, false);
      label107:
      AppMethodBeat.o(258185);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label107;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117866);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.YVQ != null)
      {
        paramVarArgs.qD(1, this.YVQ.computeSize());
        this.YVQ.writeFields(paramVarArgs);
      }
      if (this.IGI != null) {
        paramVarArgs.g(2, this.IGI);
      }
      if (this.ZrX != null) {
        paramVarArgs.g(3, this.ZrX);
      }
      paramVarArgs.bS(4, this.IHl);
      if (this.UserName != null) {
        paramVarArgs.g(5, this.UserName);
      }
      if (this.ZrY != null) {
        paramVarArgs.g(6, this.ZrY);
      }
      paramVarArgs.bS(7, this.ZrZ);
      if (this.Zsa != null) {
        paramVarArgs.g(8, this.Zsa);
      }
      AppMethodBeat.o(117866);
      return 0;
    }
    if (paramInt == 1) {
      if (this.YVQ == null) {
        break label680;
      }
    }
    label680:
    for (int i = i.a.a.a.qC(1, this.YVQ.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IGI != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.IGI);
      }
      i = paramInt;
      if (this.ZrX != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ZrX);
      }
      i += i.a.a.b.b.a.cJ(4, this.IHl);
      paramInt = i;
      if (this.UserName != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.UserName);
      }
      i = paramInt;
      if (this.ZrY != null) {
        i = paramInt + i.a.a.b.b.a.h(6, this.ZrY);
      }
      i += i.a.a.b.b.a.cJ(7, this.ZrZ);
      paramInt = i;
      if (this.Zsa != null) {
        paramInt = i + i.a.a.b.b.a.h(8, this.Zsa);
      }
      AppMethodBeat.o(117866);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(117866);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject = (i.a.a.a.a)paramVarArgs[0];
        akt localakt = (akt)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117866);
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
            localakt.YVQ = localese;
            paramInt += 1;
          }
          AppMethodBeat.o(117866);
          return 0;
        case 2: 
          localakt.IGI = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(117866);
          return 0;
        case 3: 
          localakt.ZrX = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(117866);
          return 0;
        case 4: 
          localakt.IHl = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(117866);
          return 0;
        case 5: 
          localakt.UserName = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(117866);
          return 0;
        case 6: 
          localakt.ZrY = ((i.a.a.a.a)localObject).ajGk.readString();
          AppMethodBeat.o(117866);
          return 0;
        case 7: 
          localakt.ZrZ = ((i.a.a.a.a)localObject).ajGk.aar();
          AppMethodBeat.o(117866);
          return 0;
        }
        localakt.Zsa = ((i.a.a.a.a)localObject).ajGk.readString();
        AppMethodBeat.o(117866);
        return 0;
      }
      AppMethodBeat.o(117866);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.akt
 * JD-Core Version:    0.7.0.1
 */