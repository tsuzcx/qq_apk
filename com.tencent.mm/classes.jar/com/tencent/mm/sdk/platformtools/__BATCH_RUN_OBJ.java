package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Queue;
import kotlin.Metadata;
import kotlinx.coroutines.cb;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/sdk/platformtools/__BATCH_RUN_OBJ;", "", "()V", "batchData", "Ljava/util/HashMap;", "", "Ljava/util/Queue;", "Lkotlin/collections/HashMap;", "getBatchData", "()Ljava/util/HashMap;", "batchJobs", "Lkotlinx/coroutines/Job;", "getBatchJobs", "libcompatible_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class __BATCH_RUN_OBJ
{
  public static final __BATCH_RUN_OBJ INSTANCE;
  private static final HashMap<String, Queue<?>> batchData;
  private static final HashMap<String, cb> batchJobs;
  
  static
  {
    AppMethodBeat.i(156399);
    INSTANCE = new __BATCH_RUN_OBJ();
    batchJobs = new HashMap();
    batchData = new HashMap();
    AppMethodBeat.o(156399);
  }
  
  public final HashMap<String, Queue<?>> getBatchData()
  {
    return batchData;
  }
  
  public final HashMap<String, cb> getBatchJobs()
  {
    return batchJobs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.__BATCH_RUN_OBJ
 * JD-Core Version:    0.7.0.1
 */