package com.tencent.qqmusic.mediaplayer.perf;

import com.tencent.qqmusic.mediaplayer.upstream.IDataSource;

class PerformanceTracer$OverallInfo
{
  final IDataSource dataSource;
  final long timeCostInMs;
  final long totalPcmToBePlayed;
  
  PerformanceTracer$OverallInfo(IDataSource paramIDataSource, long paramLong1, long paramLong2)
  {
    this.dataSource = paramIDataSource;
    this.timeCostInMs = paramLong1;
    this.totalPcmToBePlayed = paramLong2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.qqmusic.mediaplayer.perf.PerformanceTracer.OverallInfo
 * JD-Core Version:    0.7.0.1
 */