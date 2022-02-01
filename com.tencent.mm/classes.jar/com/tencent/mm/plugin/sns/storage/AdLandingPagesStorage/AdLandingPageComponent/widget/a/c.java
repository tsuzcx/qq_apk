package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/wheelpickerview/PickDataNode;", "", "key", "", "label", "childs", "", "parentNode", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/wheelpickerview/PickDataNode;)V", "childNodes", "getChildNodes", "()Ljava/util/List;", "getKey", "()Ljava/lang/String;", "getLabel", "getParentNode", "()Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/wheelpickerview/PickDataNode;", "toString", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public final c QWE;
  public final List<c> QWF;
  public final String key;
  public final String label;
  
  public c(String paramString1, String paramString2, List<c> paramList, c paramc)
  {
    AppMethodBeat.i(306845);
    this.key = paramString1;
    this.label = paramString2;
    this.QWE = paramc;
    this.QWF = paramList;
    AppMethodBeat.o(306845);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(306851);
    StringBuilder localStringBuilder = new StringBuilder("PickDataNode(key='").append(this.key).append("', label='").append(this.label).append("', childNodes=");
    Object localObject = this.QWF;
    if (localObject == null) {}
    for (localObject = null;; localObject = Integer.valueOf(((List)localObject).size()))
    {
      localObject = localObject + ", parentNode=" + this.QWE + ')';
      AppMethodBeat.o(306851);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.a.c
 * JD-Core Version:    0.7.0.1
 */