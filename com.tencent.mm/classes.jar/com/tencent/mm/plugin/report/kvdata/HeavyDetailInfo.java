package com.tencent.mm.plugin.report.kvdata;

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
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (d.a.a.c.a)paramVarArgs[0];
      paramVarArgs.Y(1, this.flag_);
      paramVarArgs.Y(2, this.sdFileSize_);
      paramVarArgs.Y(3, this.sdFileRatio_);
      paramVarArgs.Y(4, this.dbSize_);
      paramVarArgs.Y(5, this.message_);
      paramVarArgs.Y(6, this.conversation_);
      paramVarArgs.Y(7, this.contact_);
      paramVarArgs.Y(8, this.chatroom_);
      paramVarArgs.Y(9, this.favDbSize_);
      return 0;
    }
    if (paramInt == 1) {
      return d.a.a.a.X(1, this.flag_) + 0 + d.a.a.a.X(2, this.sdFileSize_) + d.a.a.a.X(3, this.sdFileRatio_) + d.a.a.a.X(4, this.dbSize_) + d.a.a.a.X(5, this.message_) + d.a.a.a.X(6, this.conversation_) + d.a.a.a.X(7, this.contact_) + d.a.a.a.X(8, this.chatroom_) + d.a.a.a.X(9, this.favDbSize_);
    }
    if (paramInt == 2)
    {
      paramVarArgs = new d.a.a.a.a((byte[])paramVarArgs[0], unknownTagHandler);
      for (paramInt = com.tencent.mm.bv.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.bv.a.a(paramVarArgs)) {
        if (!super.a(paramVarArgs, this, paramInt)) {
          paramVarArgs.cUt();
        }
      }
      return 0;
    }
    if (paramInt == 3)
    {
      d.a.a.a.a locala = (d.a.a.a.a)paramVarArgs[0];
      HeavyDetailInfo localHeavyDetailInfo = (HeavyDetailInfo)paramVarArgs[1];
      switch (((Integer)paramVarArgs[2]).intValue())
      {
      default: 
        return -1;
      case 1: 
        localHeavyDetailInfo.flag_ = locala.xpH.oE();
        return 0;
      case 2: 
        localHeavyDetailInfo.sdFileSize_ = locala.xpH.oE();
        return 0;
      case 3: 
        localHeavyDetailInfo.sdFileRatio_ = locala.xpH.oE();
        return 0;
      case 4: 
        localHeavyDetailInfo.dbSize_ = locala.xpH.oE();
        return 0;
      case 5: 
        localHeavyDetailInfo.message_ = locala.xpH.oE();
        return 0;
      case 6: 
        localHeavyDetailInfo.conversation_ = locala.xpH.oE();
        return 0;
      case 7: 
        localHeavyDetailInfo.contact_ = locala.xpH.oE();
        return 0;
      case 8: 
        localHeavyDetailInfo.chatroom_ = locala.xpH.oE();
        return 0;
      }
      localHeavyDetailInfo.favDbSize_ = locala.xpH.oE();
      return 0;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.report.kvdata.HeavyDetailInfo
 * JD-Core Version:    0.7.0.1
 */