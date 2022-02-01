package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.util.HashMap;
import java.util.Queue;
import kotlinx.coroutines.bj;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/sdk/platformtools/__BATCH_RUN_OBJ;", "", "()V", "batchData", "Ljava/util/HashMap;", "", "Ljava/util/Queue;", "Lkotlin/collections/HashMap;", "getBatchData", "()Ljava/util/HashMap;", "batchJobs", "Lkotlinx/coroutines/Job;", "getBatchJobs", "libcompatible_release"})
public final class by
{
  private static final HashMap<String, bj> EXK;
  private static final HashMap<String, Queue<?>> EXL;
  public static final by EXM;
  
  static
  {
    AppMethodBeat.i(156399);
    EXM = new by();
    EXK = new HashMap();
    EXL = new HashMap();
    AppMethodBeat.o(156399);
  }
  
  public static HashMap<String, bj> eGX()
  {
    return EXK;
  }
  
  public static HashMap<String, Queue<?>> eGY()
  {
    return EXL;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.by
 * JD-Core Version:    0.7.0.1
 */