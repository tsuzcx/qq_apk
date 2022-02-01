package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class crx
  extends com.tencent.mm.bx.a
{
  public int IJG;
  public String SessionId;
  public String YWK;
  public int aayc;
  public String aaye;
  public String aayf;
  public String nUB;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(258643);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "Scene", Integer.valueOf(this.IJG), false);
      com.tencent.mm.bk.a.a(localJSONObject, "SessionId", this.SessionId, false);
      com.tencent.mm.bk.a.a(localJSONObject, "RequestId", this.aaye, false);
      com.tencent.mm.bk.a.a(localJSONObject, "SearchId", this.aayf, false);
      com.tencent.mm.bk.a.a(localJSONObject, "H5Version", Integer.valueOf(this.aayc), false);
      com.tencent.mm.bk.a.a(localJSONObject, "Query", this.YWK, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Content", this.nUB, false);
      label96:
      AppMethodBeat.o(258643);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label96;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(258648);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.IJG);
      if (this.SessionId != null) {
        paramVarArgs.g(2, this.SessionId);
      }
      if (this.aaye != null) {
        paramVarArgs.g(3, this.aaye);
      }
      if (this.aayf != null) {
        paramVarArgs.g(4, this.aayf);
      }
      paramVarArgs.bS(5, this.aayc);
      if (this.YWK != null) {
        paramVarArgs.g(6, this.YWK);
      }
      if (this.nUB != null) {
        paramVarArgs.g(7, this.nUB);
      }
      AppMethodBeat.o(258648);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.IJG) + 0;
      paramInt = i;
      if (this.SessionId != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.SessionId);
      }
      i = paramInt;
      if (this.aaye != null) {
        i = paramInt + i.a.a.b.b.a.h(3, this.aaye);
      }
      paramInt = i;
      if (this.aayf != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.aayf);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.aayc);
      paramInt = i;
      if (this.YWK != null) {
        paramInt = i + i.a.a.b.b.a.h(6, this.YWK);
      }
      i = paramInt;
      if (this.nUB != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.nUB);
      }
      AppMethodBeat.o(258648);
      return i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(258648);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      crx localcrx = (crx)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(258648);
        return -1;
      case 1: 
        localcrx.IJG = locala.ajGk.aar();
        AppMethodBeat.o(258648);
        return 0;
      case 2: 
        localcrx.SessionId = locala.ajGk.readString();
        AppMethodBeat.o(258648);
        return 0;
      case 3: 
        localcrx.aaye = locala.ajGk.readString();
        AppMethodBeat.o(258648);
        return 0;
      case 4: 
        localcrx.aayf = locala.ajGk.readString();
        AppMethodBeat.o(258648);
        return 0;
      case 5: 
        localcrx.aayc = locala.ajGk.aar();
        AppMethodBeat.o(258648);
        return 0;
      case 6: 
        localcrx.YWK = locala.ajGk.readString();
        AppMethodBeat.o(258648);
        return 0;
      }
      localcrx.nUB = locala.ajGk.readString();
      AppMethodBeat.o(258648);
      return 0;
    }
    AppMethodBeat.o(258648);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.crx
 * JD-Core Version:    0.7.0.1
 */