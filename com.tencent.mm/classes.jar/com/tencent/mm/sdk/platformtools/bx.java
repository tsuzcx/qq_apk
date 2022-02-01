package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.l;
import java.util.HashMap;
import java.util.Queue;
import kotlinx.coroutines.bo;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/sdk/platformtools/__BATCH_RUN_OBJ;", "", "()V", "batchData", "Ljava/util/HashMap;", "", "Ljava/util/Queue;", "Lkotlin/collections/HashMap;", "getBatchData", "()Ljava/util/HashMap;", "batchJobs", "Lkotlinx/coroutines/Job;", "getBatchJobs", "libcompatible_release"})
public final class bx
{
  private static final HashMap<String, bo> GuW;
  private static final HashMap<String, Queue<?>> GuX;
  public static final bx GuY;
  
  static
  {
    AppMethodBeat.i(156399);
    GuY = new bx();
    GuW = new HashMap();
    GuX = new HashMap();
    AppMethodBeat.o(156399);
  }
  
  public static HashMap<String, bo> eWs()
  {
    return GuW;
  }
  
  public static HashMap<String, Queue<?>> eWt()
  {
    return GuX;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.sdk.platformtools.bx
 * JD-Core Version:    0.7.0.1
 */