package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONObject;

public final class fcn
  extends com.tencent.mm.bx.a
{
  public String AesKey;
  public int IJG;
  public String Md5;
  public String SessionId;
  public int YYs;
  public int aWI;
  public dhb aaLr;
  public acm aaLs;
  public int aayc;
  public String aaye;
  public String aayf;
  public int aayr;
  public String abCc;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(259007);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "Md5", this.Md5, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Offset", Integer.valueOf(this.YYs), false);
      com.tencent.mm.bk.a.a(localJSONObject, "Scene", Integer.valueOf(this.IJG), false);
      com.tencent.mm.bk.a.a(localJSONObject, "SearchId", this.aayf, false);
      com.tencent.mm.bk.a.a(localJSONObject, "SessionId", this.SessionId, false);
      com.tencent.mm.bk.a.a(localJSONObject, "H5Version", Integer.valueOf(this.aayc), false);
      com.tencent.mm.bk.a.a(localJSONObject, "Location", this.aaLr, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Tab", Integer.valueOf(this.aWI), false);
      com.tencent.mm.bk.a.a(localJSONObject, "RequestId", this.aaye, false);
      com.tencent.mm.bk.a.a(localJSONObject, "RequestType", Integer.valueOf(this.aayr), false);
      com.tencent.mm.bk.a.a(localJSONObject, "EmojiUrl", this.abCc, false);
      com.tencent.mm.bk.a.a(localJSONObject, "AesKey", this.AesKey, false);
      com.tencent.mm.bk.a.a(localJSONObject, "ChildMode", this.aaLs, false);
      label171:
      AppMethodBeat.o(259007);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label171;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117925);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.Md5 != null) {
        paramVarArgs.g(1, this.Md5);
      }
      paramVarArgs.bS(2, this.YYs);
      paramVarArgs.bS(3, this.IJG);
      if (this.aayf != null) {
        paramVarArgs.g(4, this.aayf);
      }
      if (this.SessionId != null) {
        paramVarArgs.g(5, this.SessionId);
      }
      paramVarArgs.bS(6, this.aayc);
      if (this.aaLr != null)
      {
        paramVarArgs.qD(7, this.aaLr.computeSize());
        this.aaLr.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(8, this.aWI);
      if (this.aaye != null) {
        paramVarArgs.g(9, this.aaye);
      }
      paramVarArgs.bS(10, this.aayr);
      if (this.abCc != null) {
        paramVarArgs.g(11, this.abCc);
      }
      if (this.AesKey != null) {
        paramVarArgs.g(12, this.AesKey);
      }
      if (this.aaLs != null)
      {
        paramVarArgs.qD(13, this.aaLs.computeSize());
        this.aaLs.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(117925);
      return 0;
    }
    if (paramInt == 1) {
      if (this.Md5 == null) {
        break label1010;
      }
    }
    label1010:
    for (paramInt = i.a.a.b.b.a.h(1, this.Md5) + 0;; paramInt = 0)
    {
      int i = paramInt + i.a.a.b.b.a.cJ(2, this.YYs) + i.a.a.b.b.a.cJ(3, this.IJG);
      paramInt = i;
      if (this.aayf != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aayf);
      }
      i = paramInt;
      if (this.SessionId != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.SessionId);
      }
      i += i.a.a.b.b.a.cJ(6, this.aayc);
      paramInt = i;
      if (this.aaLr != null) {
        paramInt = i + i.a.a.a.qC(7, this.aaLr.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(8, this.aWI);
      paramInt = i;
      if (this.aaye != null) {
        paramInt = i + i.a.a.b.b.a.h(9, this.aaye);
      }
      i = paramInt + i.a.a.b.b.a.cJ(10, this.aayr);
      paramInt = i;
      if (this.abCc != null) {
        paramInt = i + i.a.a.b.b.a.h(11, this.abCc);
      }
      i = paramInt;
      if (this.AesKey != null) {
        i = paramInt + i.a.a.b.b.a.h(12, this.AesKey);
      }
      paramInt = i;
      if (this.aaLs != null) {
        paramInt = i + i.a.a.a.qC(13, this.aaLs.computeSize());
      }
      AppMethodBeat.o(117925);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(117925);
        return 0;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
        fcn localfcn = (fcn)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        switch (paramInt)
        {
        default: 
          AppMethodBeat.o(117925);
          return -1;
        case 1: 
          localfcn.Md5 = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(117925);
          return 0;
        case 2: 
          localfcn.YYs = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(117925);
          return 0;
        case 3: 
          localfcn.IJG = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(117925);
          return 0;
        case 4: 
          localfcn.aayf = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(117925);
          return 0;
        case 5: 
          localfcn.SessionId = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(117925);
          return 0;
        case 6: 
          localfcn.aayc = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(117925);
          return 0;
        case 7: 
          paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject1 = (byte[])paramVarArgs.get(paramInt);
            localObject2 = new dhb();
            if ((localObject1 != null) && (localObject1.length > 0)) {
              ((dhb)localObject2).parseFrom((byte[])localObject1);
            }
            localfcn.aaLr = ((dhb)localObject2);
            paramInt += 1;
          }
          AppMethodBeat.o(117925);
          return 0;
        case 8: 
          localfcn.aWI = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(117925);
          return 0;
        case 9: 
          localfcn.aaye = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(117925);
          return 0;
        case 10: 
          localfcn.aayr = ((i.a.a.a.a)localObject1).ajGk.aar();
          AppMethodBeat.o(117925);
          return 0;
        case 11: 
          localfcn.abCc = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(117925);
          return 0;
        case 12: 
          localfcn.AesKey = ((i.a.a.a.a)localObject1).ajGk.readString();
          AppMethodBeat.o(117925);
          return 0;
        }
        paramVarArgs = ((i.a.a.a.a)localObject1).aMP(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject1 = (byte[])paramVarArgs.get(paramInt);
          localObject2 = new acm();
          if ((localObject1 != null) && (localObject1.length > 0)) {
            ((acm)localObject2).parseFrom((byte[])localObject1);
          }
          localfcn.aaLs = ((acm)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(117925);
        return 0;
      }
      AppMethodBeat.o(117925);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fcn
 * JD-Core Version:    0.7.0.1
 */