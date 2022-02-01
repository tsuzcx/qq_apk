package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class gmm
  extends com.tencent.mm.bx.a
{
  public int YQo;
  public int YZM;
  public String abro;
  public String achB;
  public int achC;
  public boolean achD = false;
  public boolean achE = false;
  public String session_id;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(260050);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "h5_version", Integer.valueOf(this.YQo), false);
      com.tencent.mm.bk.a.a(localJSONObject, "sub_type", Integer.valueOf(this.YZM), false);
      com.tencent.mm.bk.a.a(localJSONObject, "session_id", this.session_id, false);
      com.tencent.mm.bk.a.a(localJSONObject, "keyword_id", this.achB, false);
      com.tencent.mm.bk.a.a(localJSONObject, "wording_id", this.abro, false);
      com.tencent.mm.bk.a.a(localJSONObject, "sug_pos", Integer.valueOf(this.achC), false);
      com.tencent.mm.bk.a.a(localJSONObject, "is_local_search", Boolean.valueOf(this.achD), false);
      com.tencent.mm.bk.a.a(localJSONObject, "no_history_save", Boolean.valueOf(this.achE), false);
      label116:
      AppMethodBeat.o(260050);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label116;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117961);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.YQo);
      paramVarArgs.bS(2, this.YZM);
      if (this.session_id != null) {
        paramVarArgs.g(3, this.session_id);
      }
      if (this.achB != null) {
        paramVarArgs.g(4, this.achB);
      }
      if (this.abro != null) {
        paramVarArgs.g(5, this.abro);
      }
      paramVarArgs.bS(6, this.achC);
      paramVarArgs.di(7, this.achD);
      paramVarArgs.di(8, this.achE);
      AppMethodBeat.o(117961);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.YQo) + 0 + i.a.a.b.b.a.cJ(2, this.YZM);
      paramInt = i;
      if (this.session_id != null) {
        paramInt = i + i.a.a.b.b.a.h(3, this.session_id);
      }
      i = paramInt;
      if (this.achB != null) {
        i = paramInt + i.a.a.b.b.a.h(4, this.achB);
      }
      paramInt = i;
      if (this.abro != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.abro);
      }
      i = i.a.a.b.b.a.cJ(6, this.achC);
      int j = i.a.a.b.b.a.ko(7);
      int k = i.a.a.b.b.a.ko(8);
      AppMethodBeat.o(117961);
      return paramInt + i + (j + 1) + (k + 1);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(117961);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      gmm localgmm = (gmm)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(117961);
        return -1;
      case 1: 
        localgmm.YQo = locala.ajGk.aar();
        AppMethodBeat.o(117961);
        return 0;
      case 2: 
        localgmm.YZM = locala.ajGk.aar();
        AppMethodBeat.o(117961);
        return 0;
      case 3: 
        localgmm.session_id = locala.ajGk.readString();
        AppMethodBeat.o(117961);
        return 0;
      case 4: 
        localgmm.achB = locala.ajGk.readString();
        AppMethodBeat.o(117961);
        return 0;
      case 5: 
        localgmm.abro = locala.ajGk.readString();
        AppMethodBeat.o(117961);
        return 0;
      case 6: 
        localgmm.achC = locala.ajGk.aar();
        AppMethodBeat.o(117961);
        return 0;
      case 7: 
        localgmm.achD = locala.ajGk.aai();
        AppMethodBeat.o(117961);
        return 0;
      }
      localgmm.achE = locala.ajGk.aai();
      AppMethodBeat.o(117961);
      return 0;
    }
    AppMethodBeat.o(117961);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.gmm
 * JD-Core Version:    0.7.0.1
 */