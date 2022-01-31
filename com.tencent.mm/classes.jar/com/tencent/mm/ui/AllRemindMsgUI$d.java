package com.tencent.mm.ui;

import com.tencent.mm.protocal.c.bkj;
import com.tencent.mm.sdk.platformtools.bk;

final class AllRemindMsgUI$d
{
  int bIl;
  long bIt;
  int brC;
  String nickname;
  String sWz;
  long timestamp;
  String title;
  bkj uGI;
  String uGJ;
  String username;
  
  AllRemindMsgUI$d(AllRemindMsgUI paramAllRemindMsgUI) {}
  
  public final String toString()
  {
    return "RemindItem{username='" + this.username + '\'' + ", nickname='" + this.nickname + '\'' + ", title='" + bk.aac(this.title) + '\'' + ", timestamp=" + this.timestamp + ", subType=" + this.brC + ", msgId=" + this.bIt + ", sourceType=" + this.bIl + ", sourceId='" + this.sWz + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ui.AllRemindMsgUI.d
 * JD-Core Version:    0.7.0.1
 */