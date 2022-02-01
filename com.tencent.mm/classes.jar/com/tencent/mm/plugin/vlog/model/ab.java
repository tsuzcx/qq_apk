package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.extractor.ExtractorDelegateFactory;
import com.tencent.tav.extractor.ExtractorDelegateFactory.IExtractorDelegateCreator;
import com.tencent.tav.extractor.IExtractorDelegate;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/model/VLogAssetExtractorFactory;", "", "()V", "setup", "", "VLogAssetExtractorDelegateCreator", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ab
{
  public static final ab Uau;
  
  static
  {
    AppMethodBeat.i(283585);
    Uau = new ab();
    AppMethodBeat.o(283585);
  }
  
  public static void setup()
  {
    AppMethodBeat.i(283579);
    ExtractorDelegateFactory.setExtractorDelegateCreator((ExtractorDelegateFactory.IExtractorDelegateCreator)new a());
    AppMethodBeat.o(283579);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/vlog/model/VLogAssetExtractorFactory$VLogAssetExtractorDelegateCreator;", "Lcom/tencent/tav/extractor/ExtractorDelegateFactory$IExtractorDelegateCreator;", "()V", "createExtractorDelegate", "Lcom/tencent/tav/extractor/IExtractorDelegate;", "plugin-vlog_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a
    implements ExtractorDelegateFactory.IExtractorDelegateCreator
  {
    public final IExtractorDelegate createExtractorDelegate()
    {
      AppMethodBeat.i(283701);
      IExtractorDelegate localIExtractorDelegate = (IExtractorDelegate)new VLogAssetExtractor();
      AppMethodBeat.o(283701);
      return localIExtractorDelegate;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.ab
 * JD-Core Version:    0.7.0.1
 */