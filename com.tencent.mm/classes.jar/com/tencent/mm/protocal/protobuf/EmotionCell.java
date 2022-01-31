package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class EmotionCell
  extends com.tencent.mm.bv.a
{
  public String CellTitle;
  public String IconUrl;
  public int Position;
  public int ReqType;
  public String TagUrl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(62536);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      if (this.CellTitle != null) {
        paramVarArgs.e(1, this.CellTitle);
      }
      paramVarArgs.aO(2, this.ReqType);
      paramVarArgs.aO(3, this.Position);
      if (this.IconUrl != null) {
        paramVarArgs.e(4, this.IconUrl);
      }
      if (this.TagUrl != null) {
        paramVarArgs.e(5, this.TagUrl);
      }
      AppMethodBeat.o(62536);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CellTitle == null) {
        break label422;
      }
    }
    label422:
    for (paramInt = e.a.a.b.b.a.f(1, this.CellTitle) + 0;; paramInt = 0)
    {
      int i = paramInt + e.a.a.b.b.a.bl(2, this.ReqType) + e.a.a.b.b.a.bl(3, this.Position);
      paramInt = i;
      if (this.IconUrl != null) {
        paramInt = i + e.a.a.b.b.a.f(4, this.IconUrl);
      }
      i = paramInt;
      if (this.TagUrl != null) {
        i = paramInt + e.a.a.b.b.a.f(5, this.TagUrl);
      }
      AppMethodBeat.o(62536);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.eqQ();
          }
        }
        AppMethodBeat.o(62536);
        return 0;
      }
      if (paramInt == 3)
      {
        e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
        EmotionCell localEmotionCell = (EmotionCell)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(62536);
          return -1;
        case 1: 
          localEmotionCell.CellTitle = locala.CLY.readString();
          AppMethodBeat.o(62536);
          return 0;
        case 2: 
          localEmotionCell.ReqType = locala.CLY.sl();
          AppMethodBeat.o(62536);
          return 0;
        case 3: 
          localEmotionCell.Position = locala.CLY.sl();
          AppMethodBeat.o(62536);
          return 0;
        case 4: 
          localEmotionCell.IconUrl = locala.CLY.readString();
          AppMethodBeat.o(62536);
          return 0;
        }
        localEmotionCell.TagUrl = locala.CLY.readString();
        AppMethodBeat.o(62536);
        return 0;
      }
      AppMethodBeat.o(62536);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.EmotionCell
 * JD-Core Version:    0.7.0.1
 */