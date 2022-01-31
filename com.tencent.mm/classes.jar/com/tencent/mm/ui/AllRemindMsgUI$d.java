package com.tencent.mm.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.btj;
import com.tencent.mm.sdk.platformtools.bo;

final class AllRemindMsgUI$d
{
  int cpG;
  long cpO;
  String nickname;
  int subType;
  long timestamp;
  String title;
  String username;
  String wUy;
  btj yTK;
  String yTL;
  
  AllRemindMsgUI$d(AllRemindMsgUI paramAllRemindMsgUI) {}
  
  public final String toString()
  {
    AppMethodBeat.i(29128);
    String str = "RemindItem{username='" + this.username + '\'' + ", nickname='" + this.nickname + '\'' + ", title='" + bo.aqg(this.title) + '\'' + ", timestamp=" + this.timestamp + ", subType=" + this.subType + ", msgId=" + this.cpO + ", sourceType=" + this.cpG + ", sourceId='" + this.wUy + '\'' + '}';
    AppMethodBeat.o(29128);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.AllRemindMsgUI.d
 * JD-Core Version:    0.7.0.1
 */