package com.tencent.mm.timelineedit.a;

import com.google.d.ce;
import com.google.d.ce.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/timelineedit/model/ProtoModel;", "Message", "Lcom/google/protobuf/MessageLite;", "Builder", "Lcom/google/protobuf/MessageLite$Builder;", "Lcom/tencent/mm/timelineedit/model/Protoable;", "()V", "innerBuilder", "getInnerBuilder", "()Lcom/google/protobuf/MessageLite$Builder;", "setInnerBuilder", "(Lcom/google/protobuf/MessageLite$Builder;)V", "Lcom/google/protobuf/MessageLite$Builder;", "toProto", "", "timelinelib_release"}, k=1, mv={1, 1, 15})
public abstract class d<Message extends ce, Builder extends ce.a>
{
  protected Builder adpD;
  
  protected final void a(Builder paramBuilder)
  {
    s.t(paramBuilder, "<set-?>");
    this.adpD = paramBuilder;
  }
  
  protected final Builder jeC()
  {
    ce.a locala = this.adpD;
    if (locala == null) {
      s.bIx("innerBuilder");
    }
    return locala;
  }
  
  public final byte[] jeD()
  {
    Object localObject = this.adpD;
    if (localObject == null) {
      s.bIx("innerBuilder");
    }
    localObject = ((ce.a)localObject).build().toByteArray();
    s.r(localObject, "innerBuilder.build().toByteArray()");
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.timelineedit.a.d
 * JD-Core Version:    0.7.0.1
 */