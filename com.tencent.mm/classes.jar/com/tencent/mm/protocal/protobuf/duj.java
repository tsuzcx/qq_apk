package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;
import org.json.JSONObject;

public final class duj
  extends com.tencent.mm.bx.a
{
  public int IJG;
  public String YJY;
  public int ZdC;
  public gol ZdD;
  public adx abat;
  public int abau;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(259133);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "Oplog", this.abat, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Selector", Integer.valueOf(this.ZdC), false);
      com.tencent.mm.bk.a.a(localJSONObject, "KeyBuf", this.ZdD, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Scene", Integer.valueOf(this.IJG), false);
      com.tencent.mm.bk.a.a(localJSONObject, "DeviceType", this.YJY, false);
      com.tencent.mm.bk.a.a(localJSONObject, "SyncMsgDigest", Integer.valueOf(this.abau), false);
      label88:
      AppMethodBeat.o(259133);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label88;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(133186);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abat == null)
      {
        paramVarArgs = new b("Not all required fields were included: Oplog");
        AppMethodBeat.o(133186);
        throw paramVarArgs;
      }
      if (this.ZdD == null)
      {
        paramVarArgs = new b("Not all required fields were included: KeyBuf");
        AppMethodBeat.o(133186);
        throw paramVarArgs;
      }
      if (this.abat != null)
      {
        paramVarArgs.qD(1, this.abat.computeSize());
        this.abat.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(2, this.ZdC);
      if (this.ZdD != null)
      {
        paramVarArgs.qD(3, this.ZdD.computeSize());
        this.ZdD.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(4, this.IJG);
      if (this.YJY != null) {
        paramVarArgs.g(5, this.YJY);
      }
      paramVarArgs.bS(6, this.abau);
      AppMethodBeat.o(133186);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abat == null) {
        break label706;
      }
    }
    label706:
    for (paramInt = i.a.a.a.qC(1, this.abat.computeSize()) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.ZdC);
      paramInt = i;
      if (this.ZdD != null) {
        paramInt = i + i.a.a.a.qC(3, this.ZdD.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.IJG);
      paramInt = i;
      if (this.YJY != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.YJY);
      }
      i = i.a.a.b.b.a.cJ(6, this.abau);
      AppMethodBeat.o(133186);
      return paramInt + i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.abat == null)
        {
          paramVarArgs = new b("Not all required fields were included: Oplog");
          AppMethodBeat.o(133186);
          throw paramVarArgs;
        }
        if (this.ZdD == null)
        {
          paramVarArgs = new b("Not all required fields were included: KeyBuf");
          AppMethodBeat.o(133186);
          throw paramVarArgs;
        }
        AppMethodBeat.o(133186);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        duj localduj = (duj)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(133186);
          return -1;
        case 1: 
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
            localduj.abat = ((adx)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133186);
          return 0;
        case 2: 
          localduj.ZdC = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(133186);
          return 0;
        case 3: 
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
            localduj.ZdD = ((gol)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(133186);
          return 0;
        case 4: 
          localduj.IJG = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(133186);
          return 0;
        case 5: 
          localduj.YJY = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(133186);
          return 0;
        }
        localduj.abau = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(133186);
        return 0;
      }
      AppMethodBeat.o(133186);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.duj
 * JD-Core Version:    0.7.0.1
 */