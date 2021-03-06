package com.tencent.mm.plugin.report.kvdata;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class HeavyDetailInfo
  extends com.tencent.mm.bx.a
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
    AppMethodBeat.i(151534);
    if (paramInt == 0)
    {
      paramVarArgs = (i.a.a.c.a)paramVarArgs[0];
      paramVarArgs.bv(1, this.flag_);
      paramVarArgs.bv(2, this.sdFileSize_);
      paramVarArgs.bv(3, this.sdFileRatio_);
      paramVarArgs.bv(4, this.dbSize_);
      paramVarArgs.bv(5, this.message_);
      paramVarArgs.bv(6, this.conversation_);
      paramVarArgs.bv(7, this.contact_);
      paramVarArgs.bv(8, this.chatroom_);
      paramVarArgs.bv(9, this.favDbSize_);
      AppMethodBeat.o(151534);
      return 0;
    }
    if (paramInt == 1)
    {
      paramInt = i.a.a.b.b.a.q(1, this.flag_);
      int i = i.a.a.b.b.a.q(2, this.sdFileSize_);
      int j = i.a.a.b.b.a.q(3, this.sdFileRatio_);
      int k = i.a.a.b.b.a.q(4, this.dbSize_);
      int m = i.a.a.b.b.a.q(5, this.message_);
      int n = i.a.a.b.b.a.q(6, this.conversation_);
      int i1 = i.a.a.b.b.a.q(7, this.contact_);
      int i2 = i.a.a.b.b.a.q(8, this.chatroom_);
      int i3 = i.a.a.b.b.a.q(9, this.favDbSize_);
      AppMethodBeat.o(151534);
      return paramInt + 0 + i + j + k + m + n + i1 + i2 + i3;
    }
    if (paramInt == 2)
    {
      paramVarArgs = new i.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bx.a.getNextFieldNumber(paramVarArgs)) {
        if (!super.populateBuilderWithField(paramVarArgs, this, paramInt)) {
          paramVarArgs.kFT();
        }
      }
      AppMethodBeat.o(151534);
      return 0;
    }
    if (paramInt == 3)
    {
      i.a.a.a.a locala = (i.a.a.a.a)paramVarArgs[0];
      HeavyDetailInfo localHeavyDetailInfo = (HeavyDetailInfo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        AppMethodBeat.o(151534);
        return -1;
      case 1: 
        localHeavyDetailInfo.flag_ = locala.ajGk.aaw();
        AppMethodBeat.o(151534);
        return 0;
      case 2: 
        localHeavyDetailInfo.sdFileSize_ = locala.ajGk.aaw();
        AppMethodBeat.o(151534);
        return 0;
      case 3: 
        localHeavyDetailInfo.sdFileRatio_ = locala.ajGk.aaw();
        AppMethodBeat.o(151534);
        return 0;
      case 4: 
        localHeavyDetailInfo.dbSize_ = locala.ajGk.aaw();
        AppMethodBeat.o(151534);
        return 0;
      case 5: 
        localHeavyDetailInfo.message_ = locala.ajGk.aaw();
        AppMethodBeat.o(151534);
        return 0;
      case 6: 
        localHeavyDetailInfo.conversation_ = locala.ajGk.aaw();
        AppMethodBeat.o(151534);
        return 0;
      case 7: 
        localHeavyDetailInfo.contact_ = locala.ajGk.aaw();
        AppMethodBeat.o(151534);
        return 0;
      case 8: 
        localHeavyDetailInfo.chatroom_ = locala.ajGk.aaw();
        AppMethodBeat.o(151534);
        return 0;
      }
      localHeavyDetailInfo.favDbSize_ = locala.ajGk.aaw();
      AppMethodBeat.o(151534);
      return 0;
    }
    AppMethodBeat.o(151534);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.report.kvdata.HeavyDetailInfo
 * JD-Core Version:    0.7.0.1
 */