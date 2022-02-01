package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONObject;

public final class cry
  extends esc
{
  public ewe aayg;
  public evb aayh;
  public eva aayi;
  public ewj aayj;
  public ewk aayk;
  public evm aayl;
  public evn aaym;
  public evj aayn;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258686);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.BaseResponse != null)
      {
        paramVarArgs.qD(1, this.BaseResponse.computeSize());
        this.BaseResponse.writeFields(paramVarArgs);
      }
      if (this.aayg != null)
      {
        paramVarArgs.qD(2, this.aayg.computeSize());
        this.aayg.writeFields(paramVarArgs);
      }
      if (this.aayh != null)
      {
        paramVarArgs.qD(3, this.aayh.computeSize());
        this.aayh.writeFields(paramVarArgs);
      }
      if (this.aayi != null)
      {
        paramVarArgs.qD(4, this.aayi.computeSize());
        this.aayi.writeFields(paramVarArgs);
      }
      if (this.aayj != null)
      {
        paramVarArgs.qD(5, this.aayj.computeSize());
        this.aayj.writeFields(paramVarArgs);
      }
      if (this.aayk != null)
      {
        paramVarArgs.qD(6, this.aayk.computeSize());
        this.aayk.writeFields(paramVarArgs);
      }
      if (this.aayl != null)
      {
        paramVarArgs.qD(7, this.aayl.computeSize());
        this.aayl.writeFields(paramVarArgs);
      }
      if (this.aaym != null)
      {
        paramVarArgs.qD(8, this.aaym.computeSize());
        this.aaym.writeFields(paramVarArgs);
      }
      if (this.aayn != null)
      {
        paramVarArgs.qD(9, this.aayn.computeSize());
        this.aayn.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(258686);
      return 0;
    }
    if (paramInt == 1) {
      if (this.BaseResponse == null) {
        break label1348;
      }
    }
    label1348:
    for (int i = i.a.a.a.qC(1, this.BaseResponse.computeSize()) + 0;; i = 0)
    {
      paramInt = i;
      if (this.aayg != null) {
        paramInt = i + i.a.a.a.qC(2, this.aayg.computeSize());
      }
      i = paramInt;
      if (this.aayh != null) {
        i = paramInt + i.a.a.a.qC(3, this.aayh.computeSize());
      }
      paramInt = i;
      if (this.aayi != null) {
        paramInt = i + i.a.a.a.qC(4, this.aayi.computeSize());
      }
      i = paramInt;
      if (this.aayj != null) {
        i = paramInt + i.a.a.a.qC(5, this.aayj.computeSize());
      }
      paramInt = i;
      if (this.aayk != null) {
        paramInt = i + i.a.a.a.qC(6, this.aayk.computeSize());
      }
      i = paramInt;
      if (this.aayl != null) {
        i = paramInt + i.a.a.a.qC(7, this.aayl.computeSize());
      }
      paramInt = i;
      if (this.aaym != null) {
        paramInt = i + i.a.a.a.qC(8, this.aaym.computeSize());
      }
      i = paramInt;
      if (this.aayn != null) {
        i = paramInt + i.a.a.a.qC(9, this.aayn.computeSize());
      }
      AppMethodBeat.o(258686);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = esc.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = esc.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(258686);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        cry localcry = (cry)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(258686);
          return -1;
        case 1: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new kd();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((kd)localObject2).parseFrom((byte[])localObject1);
            }
            localcry.BaseResponse = ((kd)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258686);
          return 0;
        case 2: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ewe();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ewe)localObject2).parseFrom((byte[])localObject1);
            }
            localcry.aayg = ((ewe)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258686);
          return 0;
        case 3: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new evb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((evb)localObject2).parseFrom((byte[])localObject1);
            }
            localcry.aayh = ((evb)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258686);
          return 0;
        case 4: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new eva();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((eva)localObject2).parseFrom((byte[])localObject1);
            }
            localcry.aayi = ((eva)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258686);
          return 0;
        case 5: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ewj();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ewj)localObject2).parseFrom((byte[])localObject1);
            }
            localcry.aayj = ((ewj)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258686);
          return 0;
        case 6: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new ewk();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((ewk)localObject2).parseFrom((byte[])localObject1);
            }
            localcry.aayk = ((ewk)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258686);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new evm();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((evm)localObject2).parseFrom((byte[])localObject1);
            }
            localcry.aayl = ((evm)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258686);
          return 0;
        case 8: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new evn();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((evn)localObject2).parseFrom((byte[])localObject1);
            }
            localcry.aaym = ((evn)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(258686);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new evj();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((evj)localObject2).parseFrom((byte[])localObject1);
          }
          localcry.aayn = ((evj)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(258686);
        return 0;
      }
      AppMethodBeat.o(258686);
      return -1;
    }
  }
  
  public final JSONObject toJSON()
  {
    AppMethodBeat.i(258690);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "BaseResponse", this.BaseResponse, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Context", this.aayg, false);
      com.tencent.mm.bk.a.a(localJSONObject, "BrandFeed", this.aayh, false);
      com.tencent.mm.bk.a.a(localJSONObject, "BrandProfile", this.aayi, false);
      com.tencent.mm.bk.a.a(localJSONObject, "WeappFeed", this.aayj, false);
      com.tencent.mm.bk.a.a(localJSONObject, "WeappProfile", this.aayk, false);
      com.tencent.mm.bk.a.a(localJSONObject, "FinderProfile", this.aayl, false);
      com.tencent.mm.bk.a.a(localJSONObject, "FinderFeed", this.aaym, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Emoticon", this.aayn, false);
      label112:
      AppMethodBeat.o(258690);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label112;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.cry
 * JD-Core Version:    0.7.0.1
 */