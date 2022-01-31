package com.tencent.mm.plugin.sns.model;

final class ap$a
{
  String cad;
  String id;
  String otF;
  String otG;
  int type;
  
  public final boolean equals(Object paramObject)
  {
    if ((paramObject instanceof a))
    {
      paramObject = (a)paramObject;
      return (this.id.equals(paramObject.id)) && (this.type == paramObject.type);
    }
    return super.equals(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.model.ap.a
 * JD-Core Version:    0.7.0.1
 */