package com.tencent.mm.protocal.protobuf;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class EmotionCell
  extends com.tencent.mm.bw.a
{
  public String CellTitle;
  public String IconUrl;
  public int Position;
  public int ReqType;
  public String TagUrl;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(104772);
    if (paramInt == 0)
    {
      paramVarArgs = (f.a.a.c.a)paramVarArgs[0];
      if (this.CellTitle != null) {
        paramVarArgs.d(1, this.CellTitle);
      }
      paramVarArgs.aR(2, this.ReqType);
      paramVarArgs.aR(3, this.Position);
      if (this.IconUrl != null) {
        paramVarArgs.d(4, this.IconUrl);
      }
      if (this.TagUrl != null) {
        paramVarArgs.d(5, this.TagUrl);
      }
      AppMethodBeat.o(104772);
      return 0;
    }
    if (paramInt == 1) {
      if (this.CellTitle == null) {
        break label422;
      }
    }
    label422:
    for (paramInt = f.a.a.b.b.a.e(1, this.CellTitle) + 0;; paramInt = 0)
    {
      int i = paramInt + f.a.a.b.b.a.bx(2, this.ReqType) + f.a.a.b.b.a.bx(3, this.Position);
      paramInt = i;
      if (this.IconUrl != null) {
        paramInt = i + f.a.a.b.b.a.e(4, this.IconUrl);
      }
      i = paramInt;
      if (this.TagUrl != null) {
        i = paramInt + f.a.a.b.b.a.e(5, this.TagUrl);
      }
      AppMethodBeat.o(104772);
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new f.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
        for (paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bw.a.getNextFieldNumber(paramVarArgs)) {
          if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
            paramVarArgs.gfg();
          }
        }
        AppMethodBeat.o(104772);
        return 0;
      }
      if (paramInt == 3)
      {
        f.a.a.a.a locala = (f.a.a.a.a)paramVarArgs[0];
        EmotionCell localEmotionCell = (EmotionCell)paramVarArgs[1];
        switch (((Integer)paramVarArgs[2]).intValue())
        {
        default: 
          AppMethodBeat.o(104772);
          return -1;
        case 1: 
          localEmotionCell.CellTitle = locala.LVo.readString();
          AppMethodBeat.o(104772);
          return 0;
        case 2: 
          localEmotionCell.ReqType = locala.LVo.xF();
          AppMethodBeat.o(104772);
          return 0;
        case 3: 
          localEmotionCell.Position = locala.LVo.xF();
          AppMethodBeat.o(104772);
          return 0;
        case 4: 
          localEmotionCell.IconUrl = locala.LVo.readString();
          AppMethodBeat.o(104772);
          return 0;
        }
        localEmotionCell.TagUrl = locala.LVo.readString();
        AppMethodBeat.o(104772);
        return 0;
      }
      AppMethodBeat.o(104772);
      return -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.protocal.protobuf.EmotionCell
 * JD-Core Version:    0.7.0.1
 */