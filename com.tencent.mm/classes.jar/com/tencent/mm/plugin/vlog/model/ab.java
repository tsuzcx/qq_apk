package com.tencent.mm.plugin.vlog.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tav.extractor.ExtractorDelegateFactory;
import com.tencent.tav.extractor.ExtractorDelegateFactory.IExtractorDelegateCreator;
import com.tencent.tav.extractor.IExtractorDelegate;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/model/VLogAssetExtractorFactory;", "", "()V", "setup", "", "VLogAssetExtractorDelegateCreator", "plugin-vlog_release"})
public final class ab
{
  public static final ab NmS;
  
  static
  {
    AppMethodBeat.i(226306);
    NmS = new ab();
    AppMethodBeat.o(226306);
  }
  
  public static void setup()
  {
    AppMethodBeat.i(226301);
    ExtractorDelegateFactory.setExtractorDelegateCreator((ExtractorDelegateFactory.IExtractorDelegateCreator)new a());
    AppMethodBeat.o(226301);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/vlog/model/VLogAssetExtractorFactory$VLogAssetExtractorDelegateCreator;", "Lcom/tencent/tav/extractor/ExtractorDelegateFactory$IExtractorDelegateCreator;", "()V", "createExtractorDelegate", "Lcom/tencent/tav/extractor/IExtractorDelegate;", "plugin-vlog_release"})
  static final class a
    implements ExtractorDelegateFactory.IExtractorDelegateCreator
  {
    public final IExtractorDelegate createExtractorDelegate()
    {
      AppMethodBeat.i(232526);
      IExtractorDelegate localIExtractorDelegate = (IExtractorDelegate)new VLogAssetExtractor();
      AppMethodBeat.o(232526);
      return localIExtractorDelegate;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.vlog.model.ab
 * JD-Core Version:    0.7.0.1
 */