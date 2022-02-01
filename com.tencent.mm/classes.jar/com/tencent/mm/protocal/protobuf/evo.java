package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class evo
  extends com.tencent.mm.bx.a
{
  public int Height;
  public int Idt;
  public String ThumbUrl;
  public String Url;
  public int Width;
  public int abyt;
  
  private JSONObject toJSON()
  {
    AppMethodBeat.i(260218);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      com.tencent.mm.bk.a.a(localJSONObject, "MediaType", Integer.valueOf(this.Idt), false);
      com.tencent.mm.bk.a.a(localJSONObject, "Url", this.Url, false);
      com.tencent.mm.bk.a.a(localJSONObject, "Width", Integer.valueOf(this.Width), false);
      com.tencent.mm.bk.a.a(localJSONObject, "Height", Integer.valueOf(this.Height), false);
      com.tencent.mm.bk.a.a(localJSONObject, "ThumbUrl", this.ThumbUrl, false);
      com.tencent.mm.bk.a.a(localJSONObject, "VideoPlayDuration", Integer.valueOf(this.abyt), false);
      label91:
      AppMethodBeat.o(260218);
      return localJSONObject;
    }
    catch (Exception localException)
    {
      break label91;
    }
  }
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(260222);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bS(1, this.Idt);
      if (this.Url != null) {
        paramVarArgs.g(2, this.Url);
      }
      paramVarArgs.bS(3, this.Width);
      paramVarArgs.bS(4, this.Height);
      if (this.ThumbUrl != null) {
        paramVarArgs.g(5, this.ThumbUrl);
      }
      paramVarArgs.bS(6, this.abyt);
      AppMethodBeat.o(260222);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = i.a.a.b.b.a.cJ(1, this.Idt) + 0;
      paramInt = i;
      if (this.Url != null) {
        paramInt = i + i.a.a.b.b.a.h(2, this.Url);
      }
      i = paramInt + i.a.a.b.b.a.cJ(3, this.Width) + i.a.a.b.b.a.cJ(4, this.Height);
      paramInt = i;
      if (this.ThumbUrl != null) {
        paramInt = i + i.a.a.b.b.a.h(5, this.ThumbUrl);
      }
      i = i.a.a.b.b.a.cJ(6, this.abyt);
      AppMethodBeat.o(260222);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(260222);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      evo localevo = (evo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(260222);
        return -1;
      case 1: 
        localevo.Idt = locala.ajGk.aar();
        AppMethodBeat.o(260222);
        return 0;
      case 2: 
        localevo.Url = locala.ajGk.readString();
        AppMethodBeat.o(260222);
        return 0;
      case 3: 
        localevo.Width = locala.ajGk.aar();
        AppMethodBeat.o(260222);
        return 0;
      case 4: 
        localevo.Height = locala.ajGk.aar();
        AppMethodBeat.o(260222);
        return 0;
      case 5: 
        localevo.ThumbUrl = locala.ajGk.readString();
        AppMethodBeat.o(260222);
        return 0;
      }
      localevo.abyt = locala.ajGk.aar();
      AppMethodBeat.o(260222);
      return 0;
    }
    AppMethodBeat.o(260222);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.evo
 * JD-Core Version:    0.7.0.1
 */