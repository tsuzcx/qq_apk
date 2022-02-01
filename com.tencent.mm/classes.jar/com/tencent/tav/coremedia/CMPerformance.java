package com.tencent.tav.coremedia;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class CMPerformance
{
  private long endMs;
  private CMPerformance nextNode;
  public ArrayList<CMPerformance> preNodes;
  public CMPerformanceStage stage;
  private long startMs;
  
  public CMPerformance()
  {
    AppMethodBeat.i(215678);
    this.stage = CMPerformanceStage.DEFAULT;
    this.startMs = -1L;
    this.endMs = -1L;
    this.preNodes = new ArrayList();
    AppMethodBeat.o(215678);
  }
  
  public CMPerformance(CMPerformanceStage paramCMPerformanceStage)
  {
    AppMethodBeat.i(215684);
    this.stage = CMPerformanceStage.DEFAULT;
    this.startMs = -1L;
    this.endMs = -1L;
    this.preNodes = new ArrayList();
    this.stage = paramCMPerformanceStage;
    AppMethodBeat.o(215684);
  }
  
  public void addPreNode(CMPerformance paramCMPerformance)
  {
    AppMethodBeat.i(215699);
    this.preNodes.add(paramCMPerformance);
    AppMethodBeat.o(215699);
  }
  
  public long costMs()
  {
    return this.endMs - this.startMs;
  }
  
  public CMPerformance getNextNode()
  {
    return this.nextNode;
  }
  
  public void markEnd()
  {
    AppMethodBeat.i(215724);
    this.endMs = System.currentTimeMillis();
    AppMethodBeat.o(215724);
  }
  
  public void markStart()
  {
    AppMethodBeat.i(215716);
    this.startMs = System.currentTimeMillis();
    AppMethodBeat.o(215716);
  }
  
  public void setNextNode(CMPerformance paramCMPerformance)
  {
    this.nextNode = paramCMPerformance;
  }
  
  public boolean stageValid()
  {
    return this.stage != CMPerformanceStage.DEFAULT;
  }
  
  public String toString()
  {
    AppMethodBeat.i(215739);
    String str = "CMPerformance{stage=" + this.stage + ", startMs=" + this.startMs + ", endMs=" + this.endMs + '}';
    AppMethodBeat.o(215739);
    return str;
  }
  
  public static enum CMPerformanceStage
  {
    static
    {
      AppMethodBeat.i(215759);
      DEFAULT = new CMPerformanceStage("DEFAULT", 0);
      EXTRACTOR = new CMPerformanceStage("EXTRACTOR", 1);
      DECODE_WAIT = new CMPerformanceStage("DECODE_WAIT", 2);
      DECODE_JUMP = new CMPerformanceStage("DECODE_JUMP", 3);
      DECODE_CACHE = new CMPerformanceStage("DECODE_CACHE", 4);
      DECODE = new CMPerformanceStage("DECODE", 5);
      RENDER = new CMPerformanceStage("RENDER", 6);
      ENCODE_RENDER_CLEAR = new CMPerformanceStage("ENCODE_RENDER_CLEAR", 7);
      ENCODE_RENDER = new CMPerformanceStage("ENCODE_RENDER", 8);
      ENCODE_SWAP_BUFFER = new CMPerformanceStage("ENCODE_SWAP_BUFFER", 9);
      ENCODE = new CMPerformanceStage("ENCODE", 10);
      ENCODE_WAIT = new CMPerformanceStage("ENCODE_WAIT", 11);
      $VALUES = new CMPerformanceStage[] { DEFAULT, EXTRACTOR, DECODE_WAIT, DECODE_JUMP, DECODE_CACHE, DECODE, RENDER, ENCODE_RENDER_CLEAR, ENCODE_RENDER, ENCODE_SWAP_BUFFER, ENCODE, ENCODE_WAIT };
      AppMethodBeat.o(215759);
    }
    
    private CMPerformanceStage() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.tav.coremedia.CMPerformance
 * JD-Core Version:    0.7.0.1
 */