package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class HeavyDetailInfo
  extends com.tencent.mm.bv.a
{
  public long chatroom_;
  public long contact_;
  public long conversation_;
  public long dbSize_;
  public long favDbSize_;
  public long flag_;
  public long message_;
  public long sdFileRatio_;
  public long sdFileSize_;
  
  public final int op(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(79148);
    if (paramInt == 0)
    {
      paramVarArgs = (e.a.a.c.a)paramVarArgs[0];
      paramVarArgs.am(1, this.flag_);
      paramVarArgs.am(2, this.sdFileSize_);
      paramVarArgs.am(3, this.sdFileRatio_);
      paramVarArgs.am(4, this.dbSize_);
      paramVarArgs.am(5, this.message_);
      paramVarArgs.am(6, this.conversation_);
      paramVarArgs.am(7, this.contact_);
      paramVarArgs.am(8, this.chatroom_);
      paramVarArgs.am(9, this.favDbSize_);
      AppMethodBeat.o(79148);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = e.a.a.b.b.a.p(1, this.flag_);
      int i = e.a.a.b.b.a.p(2, this.sdFileSize_);
      int j = e.a.a.b.b.a.p(3, this.sdFileRatio_);
      int k = e.a.a.b.b.a.p(4, this.dbSize_);
      int m = e.a.a.b.b.a.p(5, this.message_);
      int n = e.a.a.b.b.a.p(6, this.conversation_);
      int i1 = e.a.a.b.b.a.p(7, this.contact_);
      int i2 = e.a.a.b.b.a.p(8, this.chatroom_);
      int i3 = e.a.a.b.b.a.p(9, this.favDbSize_);
      AppMethodBeat.o(79148);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new e.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.eqQ();
        }
      }
      AppMethodBeat.o(79148);
      return 0;
    }
    if (paramInt == 3)
    {
      e.a.a.a.a locala = (e.a.a.a.a)paramVarArgs[0];
      HeavyDetailInfo localHeavyDetailInfo = (HeavyDetailInfo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(79148);
        return -1;
      case 1: 
        localHeavyDetailInfo.flag_ = locala.CLY.sm();
        AppMethodBeat.o(79148);
        return 0;
      case 2: 
        localHeavyDetailInfo.sdFileSize_ = locala.CLY.sm();
        AppMethodBeat.o(79148);
        return 0;
      case 3: 
        localHeavyDetailInfo.sdFileRatio_ = locala.CLY.sm();
        AppMethodBeat.o(79148);
        return 0;
      case 4: 
        localHeavyDetailInfo.dbSize_ = locala.CLY.sm();
        AppMethodBeat.o(79148);
        return 0;
      case 5: 
        localHeavyDetailInfo.message_ = locala.CLY.sm();
        AppMethodBeat.o(79148);
        return 0;
      case 6: 
        localHeavyDetailInfo.conversation_ = locala.CLY.sm();
        AppMethodBeat.o(79148);
        return 0;
      case 7: 
        localHeavyDetailInfo.contact_ = locala.CLY.sm();
        AppMethodBeat.o(79148);
        return 0;
      case 8: 
        localHeavyDetailInfo.chatroom_ = locala.CLY.sm();
        AppMethodBeat.o(79148);
        return 0;
      }
      localHeavyDetailInfo.favDbSize_ = locala.CLY.sm();
      AppMethodBeat.o(79148);
      return 0;
    }
    AppMethodBeat.o(79148);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.report.kvdata.HeavyDetailInfo
 * JD-Core Version:    0.7.0.1
 */