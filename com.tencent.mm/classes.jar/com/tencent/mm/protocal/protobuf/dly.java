package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import org.json.JSONObject;

public final class dly
  extends com.tencent.mm.bx.a
{
  public int IJG;
  public int IKW;
  public String SessionId;
  public dhb aaLr;
  public acm aaLs;
  public long aaSb;
  public String aaSc;
  public int aayc;
  public String yts;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(259046);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "Scene", Integer.valueOf(this.IJG), false);
      com.tencent.mm.bk.a.a(localJSONObject, "H5Version", Integer.valueOf(this.aayc), false);
      com.tencent.mm.bk.a.a(localJSONObject, "Location", this.aaLr, false);
      com.tencent.mm.bk.a.a(localJSONObject, "BusinessType", Integer.valueOf(this.IKW), false);
      com.tencent.mm.bk.a.a(localJSONObject, "Language", this.yts, false);
      com.tencent.mm.bk.a.a(localJSONObject, "ConfigParam", Long.valueOf(this.aaSb), false);
      com.tencent.mm.bk.a.a(localJSONObject, "SessionId", this.SessionId, false);
      com.tencent.mm.bk.a.a(localJSONObject, "GuideInfo", this.aaSc, false);
      com.tencent.mm.bk.a.a(localJSONObject, "ChildMode", this.aaLs, false);
      label124:
      AppMethodBeat.o(259046);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label124;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117878);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.IJG);
      paramVarArgs.bS(2, this.aayc);
      if (this.aaLr != null)
      {
        paramVarArgs.qD(3, this.aaLr.computeSize());
        this.aaLr.writeFields(paramVarArgs);
      }
      paramVarArgs.bS(4, this.IKW);
      if (this.yts != null) {
        paramVarArgs.g(5, this.yts);
      }
      paramVarArgs.bv(6, this.aaSb);
      if (this.SessionId != null) {
        paramVarArgs.g(7, this.SessionId);
      }
      if (this.aaSc != null) {
        paramVarArgs.g(8, this.aaSc);
      }
      if (this.aaLs != null)
      {
        paramVarArgs.qD(9, this.aaLs.computeSize());
        this.aaLs.writeFields(paramVarArgs);
      }
      AppMethodBeat.o(117878);
      return 0;
    }
    int i;
    if (paramInt == 1)
    {
      i = i.a.a.b.b.a.cJ(1, this.IJG) + 0 + i.a.a.b.b.a.cJ(2, this.aayc);
      paramInt = i;
      if (this.aaLr != null) {
        paramInt = i + i.a.a.a.qC(3, this.aaLr.computeSize());
      }
      i = paramInt + i.a.a.b.b.a.cJ(4, this.IKW);
      paramInt = i;
      if (this.yts != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.yts);
      }
      i = paramInt + i.a.a.b.b.a.q(6, this.aaSb);
      paramInt = i;
      if (this.SessionId != null) {
        paramInt = i + i.a.a.b.b.a.h(7, this.SessionId);
      }
      i = paramInt;
      if (this.aaSc != null) {
        i = paramInt + i.a.a.b.b.a.h(8, this.aaSc);
      }
      paramInt = i;
      if (this.aaLs != null) {
        paramInt = i + i.a.a.a.qC(9, this.aaLs.computeSize());
      }
      AppMethodBeat.o(117878);
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
      AppMethodBeat.o(117878);
      return 0;
    }
    if (paramInt == 3)
    {
      Object localObject1 = (i.a.a.a.a)paramVarArgs[0];
      dly localdly = (dly)paramVarArgs[1];
      paramInt = ((Integer)paramVarArgs[2]).intValue();
      Object localObject2;
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(117878);
        return -1;
      case 1: 
        localdly.IJG = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(117878);
        return 0;
      case 2: 
        localdly.aayc = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(117878);
        return 0;
      case 3: 
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
          localdly.aaLr = ((dhb)localObject2);
          paramInt += 1;
        }
        AppMethodBeat.o(117878);
        return 0;
      case 4: 
        localdly.IKW = ((i.a.a.a.a)localObject1).ajGk.aar();
        AppMethodBeat.o(117878);
        return 0;
      case 5: 
        localdly.yts = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(117878);
        return 0;
      case 6: 
        localdly.aaSb = ((i.a.a.a.a)localObject1).ajGk.aaw();
        AppMethodBeat.o(117878);
        return 0;
      case 7: 
        localdly.SessionId = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(117878);
        return 0;
      case 8: 
        localdly.aaSc = ((i.a.a.a.a)localObject1).ajGk.readString();
        AppMethodBeat.o(117878);
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
        localdly.aaLs = ((acm)localObject2);
        paramInt += 1;
      }
      AppMethodBeat.o(117878);
      return 0;
    }
    AppMethodBeat.o(117878);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.dly
 * JD-Core Version:    0.7.0.1
 */