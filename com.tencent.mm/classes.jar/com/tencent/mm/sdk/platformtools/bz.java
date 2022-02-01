package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.util.HashMap;
import java.util.Queue;
import kotlinx.coroutines.br;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/sdk/platformtools/__BATCH_RUN_OBJ;", "", "()V", "batchData", "Ljava/util/HashMap;", "", "Ljava/util/Queue;", "Lkotlin/collections/HashMap;", "getBatchData", "()Ljava/util/HashMap;", "batchJobs", "Lkotlinx/coroutines/Job;", "getBatchJobs", "libcompatible_release"})
public final class bz
{
  private static final HashMap<String, br> IBc;
  private static final HashMap<String, Queue<?>> IBd;
  public static final bz IBe;
  
  static
  {
    AppMethodBeat.i(156399);
    IBe = new bz();
    IBc = new HashMap();
    IBd = new HashMap();
    AppMethodBeat.o(156399);
  }
  
  public static HashMap<String, br> fpX()
  {
    return IBc;
  }
  
  public static HashMap<String, Queue<?>> fpY()
  {
    return IBd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.bz
 * JD-Core Version:    0.7.0.1
 */