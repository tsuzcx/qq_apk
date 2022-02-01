package com.tencent.mm.timelineedit.a;

import com.google.b.bw;
import com.google.b.bw.a;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 15}, iBL={""}, iBM={"Lcom/tencent/mm/timelineedit/model/ProtoModel;", "Message", "Lcom/google/protobuf/MessageLite;", "Builder", "Lcom/google/protobuf/MessageLite$Builder;", "Lcom/tencent/mm/timelineedit/model/Protoable;", "()V", "innerBuilder", "getInnerBuilder", "()Lcom/google/protobuf/MessageLite$Builder;", "setInnerBuilder", "(Lcom/google/protobuf/MessageLite$Builder;)V", "Lcom/google/protobuf/MessageLite$Builder;", "toProto", "", "timelinelib_release"})
public abstract class d<Message extends bw, Builder extends bw.a>
{
  protected Builder VLy;
  
  protected final void a(Builder paramBuilder)
  {
    p.k(paramBuilder, "<set-?>");
    this.VLy = paramBuilder;
  }
  
  protected final Builder hCw()
  {
    bw.a locala = this.VLy;
    if (locala == null) {
      p.bGy("innerBuilder");
    }
    return locala;
  }
  
  public final byte[] hCx()
  {
    Object localObject = this.VLy;
    if (localObject == null) {
      p.bGy("innerBuilder");
    }
    localObject = ((bw.a)localObject).CS().toByteArray();
    p.j(localObject, "innerBuilder.build().toByteArray()");
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.timelineedit.a.d
 * JD-Core Version:    0.7.0.1
 */