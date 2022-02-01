package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/sns/storage/AdLandingPagesStorage/AdLandingPageComponent/widget/wheelpickerview/PickItem;", "", "key", "", "label", "(Ljava/lang/String;Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "getLabel", "toString", "plugin-sns_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public final String key;
  public final String label;
  
  public d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(306844);
    this.key = paramString1;
    this.label = paramString2;
    AppMethodBeat.o(306844);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(306849);
    String str = "PickItem(key='" + this.key + "', label=" + this.label + ')';
    AppMethodBeat.o(306849);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.widget.a.d
 * JD-Core Version:    0.7.0.1
 */