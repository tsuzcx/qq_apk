package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;
import org.json.JSONObject;

public final class sx
  extends com.tencent.mm.bx.a
{
  public String IGI;
  public sz YYj;
  public ewb YYm;
  public tg YYn;
  public String vhX;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(260062);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "NickName", this.vhX, false);
      com.tencent.mm.bk.a.a(localJSONObject, "DetailInfo", this.YYj, false);
      com.tencent.mm.bk.a.a(localJSONObject, "ContactItem", this.YYm, false);
      com.tencent.mm.bk.a.a(localJSONObject, "ServiceInfo", this.YYn, false);
      com.tencent.mm.bk.a.a(localJSONObject, "JumpUrl", this.IGI, false);
      label68:
      AppMethodBeat.o(260062);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label68;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117841);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.vhX == null)
      {
        paramVarArgs = new b("Not all required fields were included: NickName");
        AppMethodBeat.o(117841);
        throw paramVarArgs;
      }
      if (this.YYm == null)
      {
        paramVarArgs = new b("Not all required fields were included: ContactItem");
        AppMethodBeat.o(117841);
        throw paramVarArgs;
      }
      if (this.vhX != null) {
        paramVarArgs.g(1, this.vhX);
      }
      if (this.YYj != null)
      {
        paramVarArgs.qD(2, this.YYj.computeSize());
        this.YYj.writeFields(paramVarArgs);
      }
      if (this.YYm != null)
      {
        paramVarArgs.qD(3, this.YYm.computeSize());
        this.YYm.writeFields(paramVarArgs);
      }
      if (this.YYn != null)
      {
        paramVarArgs.qD(4, this.YYn.computeSize());
        this.YYn.writeFields(paramVarArgs);
      }
      if (this.IGI != null) {
        paramVarArgs.g(5, this.IGI);
      }
      AppMethodBeat.o(117841);
      return 0;
    }
    if (paramInt == 1) {
      if (this.vhX == null) {
        break label764;
      }
    }
    label764:
    for (int i = i.a.a.b.b.a.h(1, this.vhX) + 0;; i = 0)
    {
      paramInt = i;
      if (this.YYj != null) {
        paramInt = i + i.a.a.a.qC(2, this.YYj.computeSize());
      }
      i = paramInt;
      if (this.YYm != null) {
        i = paramInt + i.a.a.a.qC(3, this.YYm.computeSize());
      }
      paramInt = i;
      if (this.YYn != null) {
        paramInt = i + i.a.a.a.qC(4, this.YYn.computeSize());
      }
      i = paramInt;
      if (this.IGI != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.IGI);
      }
      AppMethodBeat.o(117841);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.vhX == null)
        {
          paramVarArgs = new b("Not all required fields were included: NickName");
          AppMethodBeat.o(117841);
          throw paramVarArgs;
        }
        if (this.YYm == null)
        {
          paramVarArgs = new b("Not all required fields were included: ContactItem");
          AppMethodBeat.o(117841);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117841);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        sx localsx = (sx)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117841);
          return -1;
        case 1: 
          localsx.vhX = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(117841);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new sz();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((sz)localObject2).parseFrom((byte[])localObject1);
            }
            localsx.YYj = ((sz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(117841);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ewb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ewb)localObject2).parseFrom((byte[])localObject1);
            }
            localsx.YYm = ((ewb)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(117841);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new tg();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((tg)localObject2).parseFrom((byte[])localObject1);
            }
            localsx.YYn = ((tg)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(117841);
          return 0;
        }
        localsx.IGI = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(117841);
        return 0;
      }
      AppMethodBeat.o(117841);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sx
 * JD-Core Version:    0.7.0.1
 */