package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;
import e.a.a.b;

public final class bcz
  extends com.tencent.mm.bv.a
{
  public String ThumbUrl;
  public String Title;
  public String wXs;
  public int wzE;
  public int xsZ;
  public int xta;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(54952);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.Title == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(54952);
        throw paramVarArgs;
      }
      if (this.ThumbUrl == null)
      {
        paramVarArgs = new b("Not all required fields were included: ThumbUrl");
        AppMethodBeat.o(54952);
        throw paramVarArgs;
      }
      paramVarArgs.aO(1, this.xsZ);
      if (this.Title != null) {
        paramVarArgs.e(2, this.Title);
      }
      if (this.ThumbUrl != null) {
        paramVarArgs.e(3, this.ThumbUrl);
      }
      paramVarArgs.aO(4, this.wzE);
      if (this.wXs != null) {
        paramVarArgs.e(5, this.wXs);
      }
      paramVarArgs.aO(6, this.xta);
      AppMethodBeat.o(54952);
      return 0;
    }
    if (paramInt == 1)
    {
      int i = e.a.a.b.b.a.bl(1, this.xsZ) + 0;
      paramInt = i;
      if (this.Title != null) {
        paramInt = i + e.a.a.b.b.a.f(2, this.Title);
      }
      i = paramInt;
      if (this.ThumbUrl != null) {
        i = paramInt + e.a.a.b.b.a.f(3, this.ThumbUrl);
      }
      i += e.a.a.b.b.a.bl(4, this.wzE);
      paramInt = i;
      if (this.wXs != null) {
        paramInt = i + e.a.a.b.b.a.f(5, this.wXs);
      }
      i = e.a.a.b.b.a.bl(6, this.xta);
      AppMethodBeat.o(54952);
      return paramInt + i;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      if (this.Title == null)
      {
        paramVarArgs = new b("Not all required fields were included: Title");
        AppMethodBeat.o(54952);
        throw paramVarArgs;
      }
      if (this.ThumbUrl == null)
      {
        paramVarArgs = new b("Not all required fields were included: ThumbUrl");
        AppMethodBeat.o(54952);
        throw paramVarArgs;
      }
      AppMethodBeat.o(54952);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      bcz localbcz = (bcz)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(54952);
        return -1;
      case 1: 
        localbcz.xsZ = locala.CLY.sl();
        AppMethodBeat.o(54952);
        return 0;
      case 2: 
        localbcz.Title = locala.CLY.readString();
        AppMethodBeat.o(54952);
        return 0;
      case 3: 
        localbcz.ThumbUrl = locala.CLY.readString();
        AppMethodBeat.o(54952);
        return 0;
      case 4: 
        localbcz.wzE = locala.CLY.sl();
        AppMethodBeat.o(54952);
        return 0;
      case 5: 
        localbcz.wXs = locala.CLY.readString();
        AppMethodBeat.o(54952);
        return 0;
      }
      localbcz.xta = locala.CLY.sl();
      AppMethodBeat.o(54952);
      return 0;
    }
    AppMethodBeat.o(54952);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.bcz
 * JD-Core Version:    0.7.0.1
 */