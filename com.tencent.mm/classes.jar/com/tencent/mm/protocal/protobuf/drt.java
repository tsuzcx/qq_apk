package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class drt
  extends com.tencent.mm.bx.a
{
  public String LCT;
  public long XgN;
  public String aaXo;
  public boolean aaXp;
  public String aaXq;
  public boolean aaXr;
  public boolean aaXs;
  public int aaXt;
  public String qWi;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(260135);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "snapshotUrl", this.aaXo, false);
      com.tencent.mm.bk.a.a(localJSONObject, "position", this.qWi, false);
      com.tencent.mm.bk.a.a(localJSONObject, "needEnterAnim", Boolean.valueOf(this.aaXp), false);
      com.tencent.mm.bk.a.a(localJSONObject, "homeSnapUrl", this.aaXq, false);
      com.tencent.mm.bk.a.a(localJSONObject, "ori_position", this.LCT, false);
      com.tencent.mm.bk.a.a(localJSONObject, "isVisiableTop", Boolean.valueOf(this.aaXr), false);
      com.tencent.mm.bk.a.a(localJSONObject, "isVisiableButtom", Boolean.valueOf(this.aaXs), false);
      com.tencent.mm.bk.a.a(localJSONObject, "curItem_pos", Integer.valueOf(this.aaXt), false);
      com.tencent.mm.bk.a.a(localJSONObject, "clickTimeStamp", Long.valueOf(this.XgN), false);
      label127:
      AppMethodBeat.o(260135);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label127;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260143);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.aaXo != null) {
        paramVarArgs.g(1, this.aaXo);
      }
      if (this.qWi != null) {
        paramVarArgs.g(2, this.qWi);
      }
      paramVarArgs.di(3, this.aaXp);
      if (this.aaXq != null) {
        paramVarArgs.g(4, this.aaXq);
      }
      if (this.LCT != null) {
        paramVarArgs.g(5, this.LCT);
      }
      paramVarArgs.di(6, this.aaXr);
      paramVarArgs.di(7, this.aaXs);
      paramVarArgs.bS(8, this.aaXt);
      paramVarArgs.bv(9, this.XgN);
      AppMethodBeat.o(260143);
      return 0;
    }
    if (paramInt == 1) {
      if (this.aaXo == null) {
        break label618;
      }
    }
    label618:
    for (paramInt = i.a.a.b.b.a.h(1, this.aaXo) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.qWi != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.qWi);
      }
      i += i.a.a.b.b.a.ko(3) + 1;
      paramInt = i;
      if (this.aaXq != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aaXq);
      }
      i = paramInt;
      if (this.LCT != null) {
        i = paramInt + i.a.a.b.b.a.h(5, this.LCT);
      }
      paramInt = i.a.a.b.b.a.ko(6);
      int j = i.a.a.b.b.a.ko(7);
      int k = i.a.a.b.b.a.cJ(8, this.aaXt);
      int m = i.a.a.b.b.a.q(9, this.XgN);
      AppMethodBeat.o(260143);
      return i + (paramInt + 1) + (j + 1) + k + m;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(260143);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        drt localdrt = (drt)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(260143);
          return -1;
        case 1: 
          localdrt.aaXo = locala.ajGk.readString();
          AppMethodBeat.o(260143);
          return 0;
        case 2: 
          localdrt.qWi = locala.ajGk.readString();
          AppMethodBeat.o(260143);
          return 0;
        case 3: 
          localdrt.aaXp = locala.ajGk.aai();
          AppMethodBeat.o(260143);
          return 0;
        case 4: 
          localdrt.aaXq = locala.ajGk.readString();
          AppMethodBeat.o(260143);
          return 0;
        case 5: 
          localdrt.LCT = locala.ajGk.readString();
          AppMethodBeat.o(260143);
          return 0;
        case 6: 
          localdrt.aaXr = locala.ajGk.aai();
          AppMethodBeat.o(260143);
          return 0;
        case 7: 
          localdrt.aaXs = locala.ajGk.aai();
          AppMethodBeat.o(260143);
          return 0;
        case 8: 
          localdrt.aaXt = locala.ajGk.aar();
          AppMethodBeat.o(260143);
          return 0;
        }
        localdrt.XgN = locala.ajGk.aaw();
        AppMethodBeat.o(260143);
        return 0;
      }
      AppMethodBeat.o(260143);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.drt
 * JD-Core Version:    0.7.0.1
 */