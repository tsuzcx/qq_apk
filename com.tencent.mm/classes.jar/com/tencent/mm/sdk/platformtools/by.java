package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.util.HashMap;
import java.util.Queue;
import kotlinx.coroutines.br;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/sdk/platformtools/__BATCH_RUN_OBJ;", "", "()V", "batchData", "Ljava/util/HashMap;", "", "Ljava/util/Queue;", "Lkotlin/collections/HashMap;", "getBatchData", "()Ljava/util/HashMap;", "batchJobs", "Lkotlinx/coroutines/Job;", "getBatchJobs", "libcompatible_release"})
public final class by
{
  private static final HashMap<String, br> IgR;
  private static final HashMap<String, Queue<?>> IgS;
  public static final by IgT;
  
  static
  {
    AppMethodBeat.i(156399);
    IgT = new by();
    IgR = new HashMap();
    IgS = new HashMap();
    AppMethodBeat.o(156399);
  }
  
  public static HashMap<String, br> fmc()
  {
    return IgR;
  }
  
  public static HashMap<String, Queue<?>> fmd()
  {
    return IgS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.by
 * JD-Core Version:    0.7.0.1
 */