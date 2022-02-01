package com.tencent.mm.plugin.sns.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dmz;

public final class bh
{
  String QzI;
  public int QzJ;
  public int QzK;
  int createTime;
  public int dUJ;
  public String hES;
  dmz ibT;
  int lxi;
  public int lxk;
  String oYq;
  public int progress;
  
  public final String toString()
  {
    AppMethodBeat.i(96062);
    String str = "cdnMediaId " + this.oYq + " isPlayMode " + this.lxi + " createTime " + this.createTime + " snsLocalId " + this.hES + " postName " + this.QzI + " url " + this.ibT.Url + " progress " + this.progress + " totalLength " + this.dUJ + " moovOffset " + this.QzJ + " moovLength " + this.QzK;
    AppMethodBeat.o(96062);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.bh
 * JD-Core Version:    0.7.0.1
 */