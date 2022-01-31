package com.tencent.ttpic.util;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class RetrieveDataManager$1
  extends ThreadLocal<RetrieveDataManager>
{
  protected final RetrieveDataManager initialValue()
  {
    AppMethodBeat.i(83964);
    RetrieveDataManager localRetrieveDataManager = new RetrieveDataManager();
    AppMethodBeat.o(83964);
    return localRetrieveDataManager;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.ttpic.util.RetrieveDataManager.1
 * JD-Core Version:    0.7.0.1
 */