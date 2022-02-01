package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class fln
  extends com.tencent.mm.bx.a
{
  public int IcB;
  public int aamC;
  public String abLY;
  public String abLZ;
  public String abMa;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(259071);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "PublishUsername", this.abLY, false);
      com.tencent.mm.bk.a.a(localJSONObject, "CommentUserName", this.abLZ, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Source", Integer.valueOf(this.IcB), false);
      com.tencent.mm.bk.a.a(localJSONObject, "ContentType", Integer.valueOf(this.aamC), false);
      com.tencent.mm.bk.a.a(localJSONObject, "ContentID", this.abMa, false);
      label74:
      AppMethodBeat.o(259071);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label74;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(259076);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      if (this.abLY != null) {
        paramVarArgs.g(1, this.abLY);
      }
      if (this.abLZ != null) {
        paramVarArgs.g(2, this.abLZ);
      }
      paramVarArgs.bS(3, this.IcB);
      paramVarArgs.bS(4, this.aamC);
      if (this.abMa != null) {
        paramVarArgs.g(5, this.abMa);
      }
      AppMethodBeat.o(259076);
      return 0;
    }
    if (paramInt == 1) {
      if (this.abLY == null) {
        break label418;
      }
    }
    label418:
    for (paramInt = i.a.a.b.b.a.h(1, this.abLY) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (this.abLZ != null) {
        i = paramInt + i.a.a.b.b.a.h(2, this.abLZ);
      }
      i = i + i.a.a.b.b.a.cJ(3, this.IcB) + i.a.a.b.b.a.cJ(4, this.aamC);
      paramInt = i;
      if (this.abMa != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.abMa);
      }
      AppMethodBeat.o(259076);
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.kFT();
          }
        }
        AppMethodBeat.o(259076);
        return 0;
      }
      if (paramInt == 3)
      {
        i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
        fln localfln = (fln)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(259076);
          return -1;
        case 1: 
          localfln.abLY = locala.ajGk.readString();
          AppMethodBeat.o(259076);
          return 0;
        case 2: 
          localfln.abLZ = locala.ajGk.readString();
          AppMethodBeat.o(259076);
          return 0;
        case 3: 
          localfln.IcB = locala.ajGk.aar();
          AppMethodBeat.o(259076);
          return 0;
        case 4: 
          localfln.aamC = locala.ajGk.aar();
          AppMethodBeat.o(259076);
          return 0;
        }
        localfln.abMa = locala.ajGk.readString();
        AppMethodBeat.o(259076);
        return 0;
      }
      AppMethodBeat.o(259076);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.fln
 * JD-Core Version:    0.7.0.1
 */