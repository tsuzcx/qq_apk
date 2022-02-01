package com.tencent.tav.decoder.decodecache;

class DecoderSegmentMsg
{
  final RequestStatus callbackObject;
  final CacheSegment segment;
  
  DecoderSegmentMsg(CacheSegment paramCacheSegment, RequestStatus paramRequestStatus)
  {
    this.segment = paramCacheSegment;
    this.callbackObject = paramRequestStatus;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.tav.decoder.decodecache.DecoderSegmentMsg
 * JD-Core Version:    0.7.0.1
 */