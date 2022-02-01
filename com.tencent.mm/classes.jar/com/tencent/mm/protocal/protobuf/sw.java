package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import i.a.a.b;
import java.util.LinkedList;
import org.json.JSONObject;

public final class sw
  extends com.tencent.mm.bx.a
{
  public String IGG;
  public String ThumbUrl;
  public sz YYj;
  public ta YYk;
  public st YYl;
  public String hAP;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(260133);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "Title", this.hAP, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Desc", this.IGG, false);
      com.tencent.mm.bk.a.a(localJSONObject, "ThumbUrl", this.ThumbUrl, false);
      com.tencent.mm.bk.a.a(localJSONObject, "DetailInfo", this.YYj, false);
      com.tencent.mm.bk.a.a(localJSONObject, "ExtendInfo", this.YYk, false);
      com.tencent.mm.bk.a.a(localJSONObject, "ActionInfo", this.YYl, false);
      label79:
      AppMethodBeat.o(260133);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label79;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117840);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.hAP == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(117840);
        throw paramVarArgs;
      }
      if (this.IGG == null)
      {
        paramVarArgs = new b("Not all required fields were included: Desc");
        AppMethodBeat.o(117840);
        throw paramVarArgs;
      }
      if (this.ThumbUrl == null)
      {
        paramVarArgs = new b("Not all required fields were included: ThumbUrl");
        AppMethodBeat.o(117840);
        throw paramVarArgs;
      }
      if (this.YYj == null)
      {
        paramVarArgs = new b("Not all required fields were included: DetailInfo");
        AppMethodBeat.o(117840);
        throw paramVarArgs;
      }
      if (this.YYl == null)
      {
        paramVarArgs = new b("Not all required fields were included: ActionInfo");
        AppMethodBeat.o(117840);
        throw paramVarArgs;
      }
      if (this.hAP != null) {
        paramVarArgs.g(1, this.hAP);
      }
      if (this.IGG != null) {
        paramVarArgs.g(2, this.IGG);
      }
      if (this.ThumbUrl != null) {
        paramVarArgs.g(3, this.ThumbUrl);
      }
      if (this.YYj != null)
      {
        paramVarArgs.qD(4, this.YYj.computeSize());
        this.YYj.writeFields(paramVarArgs);
      }
      if (this.YYk != null)
      {
        paramVarArgs.qD(5, this.YYk.computeSize());
        this.YYk.writeFields(paramVarArgs);
      }
      if (this.YYl != null)
      {
        paramVarArgs.qD(6, this.YYl.computeSize());
        this.YYl.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(117840);
      return 0;
    }
    if (paramInt == 1) {
      if (this.hAP == null) {
        break label972;
      }
    }
    label972:
    for (int i = i.a.a.b.b.a.h(1, this.hAP) + 0;; i = 0)
    {
      paramInt = i;
      if (this.IGG != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.IGG);
      }
      i = paramInt;
      if (this.ThumbUrl != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.ThumbUrl);
      }
      paramInt = i;
      if (this.YYj != null) {
        paramInt = i + i.a.a.a.qC(4, this.YYj.computeSize());
      }
      i = paramInt;
      if (this.YYk != null) {
        i = paramInt + i.a.a.a.qC(5, this.YYk.computeSize());
      }
      paramInt = i;
      if (this.YYl != null) {
        paramInt = i + i.a.a.a.qC(6, this.YYl.computeSize());
      }
      AppMethodBeat.o(117840);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        if (this.hAP == null)
        {
          paramVarArgs = new b("Not all required fields were included: Title");
          AppMethodBeat.o(117840);
          throw paramVarArgs;
        }
        if (this.IGG == null)
        {
          paramVarArgs = new b("Not all required fields were included: Desc");
          AppMethodBeat.o(117840);
          throw paramVarArgs;
        }
        if (this.ThumbUrl == null)
        {
          paramVarArgs = new b("Not all required fields were included: ThumbUrl");
          AppMethodBeat.o(117840);
          throw paramVarArgs;
        }
        if (this.YYj == null)
        {
          paramVarArgs = new b("Not all required fields were included: DetailInfo");
          AppMethodBeat.o(117840);
          throw paramVarArgs;
        }
        if (this.YYl == null)
        {
          paramVarArgs = new b("Not all required fields were included: ActionInfo");
          AppMethodBeat.o(117840);
          throw paramVarArgs;
        }
        AppMethodBeat.o(117840);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        sw localsw = (sw)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117840);
          return -1;
        case 1: 
          localsw.hAP = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(117840);
          return 0;
        case 2: 
          localsw.IGG = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(117840);
          return 0;
        case 3: 
          localsw.ThumbUrl = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(117840);
          return 0;
        case 4: 
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
            localsw.YYj = ((sz)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(117840);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ta();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ta)localObject2).parseFrom((byte[])localObject1);
            }
            localsw.YYk = ((ta)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(117840);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new st();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((st)localObject2).parseFrom((byte[])localObject1);
          }
          localsw.YYl = ((st)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(117840);
        return 0;
      }
      AppMethodBeat.o(117840);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.sw
 * JD-Core Version:    0.7.0.1
 */