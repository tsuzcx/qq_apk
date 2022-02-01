package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;
import org.json.JSONObject;

public final class duk
  extends com.tencent.mm.bx.a
{
  public int Idd;
  public int YYp;
  public gol ZdD;
  public adx ZdG;
  public int abav;
  public int abaw;
  public int vhk;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(259160);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "Ret", Integer.valueOf(this.Idd), false);
      com.tencent.mm.bk.a.a(localJSONObject, "CmdList", this.ZdG, false);
      com.tencent.mm.bk.a.a(localJSONObject, "ContinueFlag", Integer.valueOf(this.YYp), false);
      com.tencent.mm.bk.a.a(localJSONObject, "KeyBuf", this.ZdD, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Status", Integer.valueOf(this.vhk), false);
      com.tencent.mm.bk.a.a(localJSONObject, "OnlineVersion", Integer.valueOf(this.abav), false);
      com.tencent.mm.bk.a.a(localJSONObject, "SvrTime", Integer.valueOf(this.abaw), false);
      label105:
      AppMethodBeat.o(259160);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label105;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133187);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.ZdG == null)
      {
        paramVarArgs = new b("Not all required fields were included: CmdList");
        AppMethodBeat.o(133187);
        throw paramVarArgs;
      }
      if (this.ZdD == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyBuf");
        AppMethodBeat.o(133187);
        throw paramVarArgs;
      }
      paramVarArgs.bS(1, this.Idd);
      if (this.ZdG != null)
      {
        paramVarArgs.qD(2, this.ZdG.computeSize());
        this.ZdG.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(3, this.YYp);
      if (this.ZdD != null)
      {
        paramVarArgs.qD(4, this.ZdD.computeSize());
        this.ZdD.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(5, this.vhk);
      paramVarArgs.bS(6, this.abav);
      paramVarArgs.bS(7, this.abaw);
      AppMethodBeat.o(133187);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.Idd) + 0;
      paramInt = i;
      if (this.ZdG != null) {
        paramInt = i + i.a.a.a.qC(2, this.ZdG.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(3, this.YYp);
      paramInt = i;
      if (this.ZdD != null) {
        paramInt = i + i.a.a.a.qC(4, this.ZdD.computeSize());
      }
      i = i.a.a.b.b.a.cJ(5, this.vhk);
      int j = i.a.a.b.b.a.cJ(6, this.abav);
      int k = i.a.a.b.b.a.cJ(7, this.abaw);
      AppMethodBeat.o(133187);
      return paramInt + i + j + k;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      if (this.ZdG == null)
      {
        paramVarArgs = new b("Not all required fields were included: CmdList");
        AppMethodBeat.o(133187);
        throw paramVarArgs;
      }
      if (this.ZdD == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyBuf");
        AppMethodBeat.o(133187);
        throw paramVarArgs;
      }
      AppMethodBeat.o(133187);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      duk localduk = (duk)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(133187);
        return -1;
      case 1: 
        localduk.Idd = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(133187);
        return 0;
      case 2: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new adx();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((adx)localObject2).parseFrom((byte[])localObject1);
          }
          localduk.ZdG = ((adx)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(133187);
        return 0;
      case 3: 
        localduk.YYp = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(133187);
        return 0;
      case 4: 
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new gol();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((gol)localObject2).dg((byte[])localObject1);
          }
          localduk.ZdD = ((gol)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(133187);
        return 0;
      case 5: 
        localduk.vhk = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(133187);
        return 0;
      case 6: 
        localduk.abav = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(133187);
        return 0;
      }
      localduk.abaw = ((i.a.a.a.a)localObject1).ajGk.aar();
      AppMethodBeat.o(133187);
      return 0;
    }
    AppMethodBeat.o(133187);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.duk
 * JD-Core Version:    0.7.0.1
 */