package com.tencent.ttpic.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

public class ResourcePathMapper$ResourcePath
{
  private String id;
  private List<String> items;
  private String name;
  private String path;
  private String type;
  
  public ResourcePathMapper$ResourcePath() {}
  
  public ResourcePathMapper$ResourcePath(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(83949);
    this.id = paramString1;
    this.type = paramString2;
    this.name = paramString3;
    this.path = paramString4;
    this.items = new ArrayList();
    AppMethodBeat.o(83949);
  }
  
  public void addItem(String paramString)
  {
    AppMethodBeat.i(83950);
    if (paramString != null) {
      this.items.add(paramString);
    }
    AppMethodBeat.o(83950);
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public List<String> getItems()
  {
    return this.items;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getPath()
  {
    return this.path;
  }
  
  public String getType()
  {
    return this.type;
  }
  
  public void setId(String paramString)
  {
    this.id = paramString;
  }
  
  public void setItems(List<String> paramList)
  {
    this.items = paramList;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setPath(String paramString)
  {
    this.path = paramString;
  }
  
  public void setType(String paramString)
  {
    this.type = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.util.ResourcePathMapper.ResourcePath
 * JD-Core Version:    0.7.0.1
 */