package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import org.json.JSONObject;

public final class fkk
  extends com.tencent.mm.bx.a
{
  public int IHl;
  public String ILD;
  public b YYM;
  public String abLm;
  public b abLn;
  public String abgw;
  public String abiz;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(259392);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "Word", this.abiz, false);
      com.tencent.mm.bk.a.a(localJSONObject, "DocId", this.abgw, false);
      com.tencent.mm.bk.a.a(localJSONObject, "DebugInfo", this.YYM, false);
      com.tencent.mm.bk.a.a(localJSONObject, "CacheJsonResult", this.abLm, false);
      com.tencent.mm.bk.a.a(localJSONObject, "JumpType", Integer.valueOf(this.IHl), false);
      com.tencent.mm.bk.a.a(localJSONObject, "JumpUrl", this.abLn, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Label", this.ILD, false);
      label93:
      AppMethodBeat.o(259392);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label93;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(117930);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abiz != null) {
        paramVarArgs.g(1, this.abiz);
      }
      if (this.abgw != null) {
        paramVarArgs.g(2, this.abgw);
      }
      if (this.YYM != null) {
        paramVarArgs.d(3, this.YYM);
      }
      if (this.abLm != null) {
        paramVarArgs.g(4, this.abLm);
      }
      paramVarArgs.bS(5, this.IHl);
      if (this.abLn != null) {
        paramVarArgs.d(6, this.abLn);
      }
      if (this.ILD != null) {
        paramVarArgs.g(7, this.ILD);
      }
      AppMethodBeat.o(117930);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abiz == null) {
        break label558;
      }
    }
    label558:
    for (int i = i.a.a.b.b.a.h(1, this.abiz) + 0;; i = 0)
    {
      paramInt = i;
      if (this.abgw != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.abgw);
      }
      i = paramInt;
      if (this.YYM != null) {
        i = paramInt + i.a.a.b.b.a.c(3, this.YYM);
      }
      paramInt = i;
      if (this.abLm != null) {
        paramInt = i + i.a.a.b.b.a.h(4, this.abLm);
      }
      i = paramInt + i.a.a.b.b.a.cJ(5, this.IHl);
      paramInt = i;
      if (this.abLn != null) {
        paramInt = i + i.a.a.b.b.a.c(6, this.abLn);
      }
      i = paramInt;
      if (this.ILD != null) {
        i = paramInt + i.a.a.b.b.a.h(7, this.ILD);
      }
      AppMethodBeat.o(117930);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(117930);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        fkk localfkk = (fkk)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(117930);
          return -1;
        case 1: 
          localfkk.abiz = locala.ajGk.readString();
          AppMethodBeat.o(117930);
          return 0;
        case 2: 
          localfkk.abgw = locala.ajGk.readString();
          AppMethodBeat.o(117930);
          return 0;
        case 3: 
          localfkk.YYM = locala.ajGk.kFX();
          AppMethodBeat.o(117930);
          return 0;
        case 4: 
          localfkk.abLm = locala.ajGk.readString();
          AppMethodBeat.o(117930);
          return 0;
        case 5: 
          localfkk.IHl = locala.ajGk.aar();
          AppMethodBeat.o(117930);
          return 0;
        case 6: 
          localfkk.abLn = locala.ajGk.kFX();
          AppMethodBeat.o(117930);
          return 0;
        }
        localfkk.ILD = locala.ajGk.readString();
        AppMethodBeat.o(117930);
        return 0;
      }
      AppMethodBeat.o(117930);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fkk
 * JD-Core Version:    0.7.0.1
 */